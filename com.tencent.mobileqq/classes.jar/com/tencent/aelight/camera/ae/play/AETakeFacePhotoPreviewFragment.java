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
  private AppInterface mAppInterface = QQStoryContext.a();
  private CameraPeakServiceHandler mHandler = (CameraPeakServiceHandler)this.mAppInterface.getBusinessHandler(PeakAppInterface.d);
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
        QQToast.a(getBaseActivity(), 2064515241, 0).a();
      } else if (paramInt == -2) {
        QQToast.a(getBaseActivity(), 2131697760, 0).a();
      }
    }
    else {
      QQToast.a(getBaseActivity(), 2131697760, 0).a();
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
    this.mImgFacePreview = ((ImageView)paramView.findViewById(2064121906));
    this.mTvAgain = ((TextView)paramView.findViewById(2064121925));
    this.mTvConfirm = ((TextView)paramView.findViewById(2064121926));
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
      if (((!localIntent.getBooleanExtra("key_disable_face_detect", false)) || (AECameraEntryManager.i(localIntent))) && (!FaceChangeUtils.hasFaceInPic(paramBitmap)))
      {
        QQToast.a(getBaseActivity(), 2064515243, 0).a();
        hideLoading();
        onBackPressed();
        return;
      }
      if ((!localIntent.getBooleanExtra("key_need_check_sensitive", false)) && (!AECameraEntryManager.i(localIntent)))
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
        this.mLoadingDialog = new Dialog(localBaseActivity, 2131756189);
        this.mLoadingDialog.setContentView(2131559561);
        ((TextView)this.mLoadingDialog.findViewById(2131372646)).setText(2064515240);
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
    if (i == 2064121926)
    {
      if ((!TextUtils.isEmpty(this.mPhotoPath)) || (this.mPhotoBitmap != null))
      {
        AEBaseDataReporter.a().ab();
        onPressConfirmBtn(this.mPhotoBitmap, this.mPhotoPath);
      }
    }
    else if (i == 2064121925)
    {
      AEBaseDataReporter.a().ac();
      onBackPressed();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2064318496, paramViewGroup, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.AETakeFacePhotoPreviewFragment
 * JD-Core Version:    0.7.0.1
 */