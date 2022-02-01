package com.tencent.aelight.camera.ae.play;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.config.CameraPeakServiceHandler;
import com.tencent.aelight.camera.ae.config.CameraPeakServiceObserver;
import com.tencent.aelight.camera.ae.entry.AECameraEntryManager;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.DisplayUtil;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.subscribe.utils.NavigationBarUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.component.network.utils.FileUtils;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicFragmentActivityCallBackInterface;
import com.tencent.mobileqq.activity.PublicFragmentActivityForPeak;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import javax.annotation.Nullable;

public class AETakeFacePhotoPreviewFragment
  extends PublicBaseFragment
  implements View.OnClickListener, PublicFragmentActivityCallBackInterface
{
  public static final String INTENT_KEY_PHOTO_PATH = "photo_path";
  private static String detectFacePath = "";
  private long faceDetectStartTime;
  private AppInterface mAppInterface = QQStoryContext.k();
  private CameraPeakServiceHandler mHandler = (CameraPeakServiceHandler)this.mAppInterface.getBusinessHandler(PeakAppInterface.e);
  private ImageView mImgFacePreview;
  private Dialog mLoadingDialog;
  private CameraPeakServiceObserver mObserver;
  private Bitmap mPhotoBitmap;
  private String mPhotoPath;
  private TextView mTvAgain;
  private TextView mTvConfirm;
  private int screenHeight;
  private int screenWidth;
  
  private void choosePhotoAndBack()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("take_photo_path", this.mPhotoPath);
    getBaseActivity().setResult(-1, localIntent);
    onBackPressed();
  }
  
  public static String getDetectFacePath()
  {
    return detectFacePath;
  }
  
  private void handleSensitiveFaceDetectResult(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      if (paramInt == 0) {
        choosePhotoAndBack();
      } else if (paramInt == -1) {
        QQToast.makeText(getBaseActivity(), 2064187588, 0).show();
      } else if (paramInt == -2) {
        QQToast.makeText(getBaseActivity(), 2131895533, 0).show();
      }
    }
    else {
      QQToast.makeText(getBaseActivity(), 2131895533, 0).show();
    }
    hideLoading();
  }
  
  private void hideLoading()
  {
    Object localObject = getBaseActivity();
    if ((localObject != null) && (!((BaseActivity)localObject).isFinishing()))
    {
      localObject = this.mLoadingDialog;
      if ((localObject != null) && (((Dialog)localObject).isShowing())) {
        this.mLoadingDialog.dismiss();
      }
    }
  }
  
  private void initData()
  {
    this.screenWidth = DisplayUtil.a(getBaseActivity());
    this.screenHeight = DisplayUtil.b(getBaseActivity());
    this.mPhotoPath = getArguments().getString("photo_path");
    if (!TextUtils.isEmpty(this.mPhotoPath))
    {
      this.mPhotoBitmap = BitmapUtils.decodeSampleBitmap(getBaseActivity(), this.mPhotoPath, this.screenWidth, this.screenHeight);
      Bitmap localBitmap = this.mPhotoBitmap;
      if (localBitmap != null)
      {
        this.mImgFacePreview.setImageBitmap(localBitmap);
        initDetectData();
        this.mTvAgain.setOnClickListener(this);
        this.mTvConfirm.setOnClickListener(this);
      }
    }
  }
  
  private void initDetectData()
  {
    detectFacePath = "";
    if (!FaceChangeUtils.hasFaceInPic(this.mPhotoBitmap)) {
      return;
    }
    FaceChangeUtils.cropFace(this.mPhotoBitmap, new AETakeFacePhotoPreviewFragment.1(this));
  }
  
  private void initView(View paramView)
  {
    this.mImgFacePreview = ((ImageView)paramView.findViewById(2063990840));
    this.mTvAgain = ((TextView)paramView.findViewById(2063990859));
    this.mTvConfirm = ((TextView)paramView.findViewById(2063990860));
  }
  
  public static void jumpToMeForResult(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    PublicFragmentActivity.Launcher.a(paramActivity, paramIntent, PublicFragmentActivityForPeak.class, AETakeFacePhotoPreviewFragment.class, paramInt);
  }
  
  private void onPressConfirmBtn(@Nullable Bitmap paramBitmap, @Nullable String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramBitmap == null) {
        return;
      }
      AEVideoShelfEditFragment.keepScreenOn(getBaseActivity(), true);
      showLoading();
      Intent localIntent = getBaseActivity().getIntent();
      if (((!localIntent.getBooleanExtra("key_disable_face_detect", false)) || (AECameraEntryManager.m(localIntent))) && (!FaceChangeUtils.hasFaceInPic(paramBitmap)))
      {
        QQToast.makeText(getBaseActivity(), 2064187590, 0).show();
        hideLoading();
        onBackPressed();
        return;
      }
      if ((!localIntent.getBooleanExtra("key_need_check_sensitive", false)) && (!AECameraEntryManager.m(localIntent)))
      {
        handleSensitiveFaceDetectResult(true, 0);
        return;
      }
      removeOldObserver();
      this.mObserver = new AETakeFacePhotoPreviewFragment.2(this);
      this.faceDetectStartTime = System.currentTimeMillis();
      this.mAppInterface.addObserver(this.mObserver);
      this.mHandler.b(paramString);
    }
  }
  
  private void removeOldObserver()
  {
    CameraPeakServiceObserver localCameraPeakServiceObserver = this.mObserver;
    if (localCameraPeakServiceObserver != null)
    {
      this.mAppInterface.removeObserver(localCameraPeakServiceObserver);
      this.mObserver = null;
    }
  }
  
  private void showLoading()
  {
    BaseActivity localBaseActivity = getBaseActivity();
    if ((localBaseActivity != null) && (!localBaseActivity.isFinishing()))
    {
      if (this.mLoadingDialog == null)
      {
        this.mLoadingDialog = new Dialog(localBaseActivity, 2131953338);
        this.mLoadingDialog.setContentView(2131625585);
        ((TextView)this.mLoadingDialog.findViewById(2131440191)).setText(2064187587);
        this.mLoadingDialog.setCancelable(true);
        this.mLoadingDialog.setCanceledOnTouchOutside(false);
        this.mLoadingDialog.setOnDismissListener(new AETakeFacePhotoPreviewFragment.3(this));
      }
      this.mLoadingDialog.show();
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.requestWindowFeature(1);
    paramActivity.getWindow().setFlags(1024, 1024);
    if (Build.VERSION.SDK_INT >= 29) {
      NavigationBarUtil.a(paramActivity.getWindow());
    }
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onBackPressed()
  {
    getBaseActivity().finish();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2063990860)
    {
      if ((!TextUtils.isEmpty(this.mPhotoPath)) || (this.mPhotoBitmap != null))
      {
        AEBaseDataReporter.a().ac();
        onPressConfirmBtn(this.mPhotoBitmap, this.mPhotoPath);
      }
    }
    else if (i == 2063990859)
    {
      AEBaseDataReporter.a().ad();
      onBackPressed();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2064056363, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.mPhotoBitmap;
    if (localObject != null) {
      BitmapUtils.recycle((Bitmap)localObject);
    }
    localObject = detectFacePath;
    if ((localObject != null) && (((String)localObject).length() > 0)) {
      FileUtils.delete(detectFacePath);
    }
  }
  
  public void onStop()
  {
    super.onStop();
    hideLoading();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    initView(paramView);
    initData();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.AETakeFacePhotoPreviewFragment
 * JD-Core Version:    0.7.0.1
 */