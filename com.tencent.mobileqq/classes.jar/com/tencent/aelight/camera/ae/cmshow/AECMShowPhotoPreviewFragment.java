package com.tencent.aelight.camera.ae.cmshow;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.play.FaceChangeUtils;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.view.AECMShowFaceScanView;
import com.tencent.aelight.camera.ae.view.AECMShowFaceScanView.FaceRectData;
import com.tencent.aelight.camera.ae.view.AECMShowFaceScanView.ScanViewListener;
import com.tencent.aelight.camera.aebase.QIMCameraCaptureActivity;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem.Pair;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.DisplayUtil;
import com.tencent.aelight.camera.cmsshow.api.CmShowDataWrapper;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.subscribe.utils.NavigationBarUtil;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicFragmentActivityCallBackInterface;
import com.tencent.mobileqq.activity.PublicFragmentActivityForPeak;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.tavsticker.utils.TAVStickerUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import mqq.os.MqqHandler;

public class AECMShowPhotoPreviewFragment
  extends PublicBaseFragment
  implements View.OnClickListener, AECMShowFaceScanView.ScanViewListener, PublicFragmentActivityCallBackInterface
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AECMShowLoadingView jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowLoadingView;
  private AECMShowRequestController jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowRequestController;
  private AECMShowFaceScanView jdField_a_of_type_ComTencentAelightCameraAeViewAECMShowFaceScanView;
  private CmShowDataWrapper jdField_a_of_type_ComTencentAelightCameraCmsshowApiCmShowDataWrapper;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean = false;
  private int c = 0;
  private int d = 0;
  
  private AECMShowFaceScanView.FaceRectData a(@NonNull List<PointF> paramList)
  {
    PointF localPointF1 = (PointF)paramList.get(0);
    PointF localPointF2 = (PointF)paramList.get(1);
    localPointF2 = (PointF)paramList.get(2);
    Object localObject = (PointF)paramList.get(3);
    paramList = new PointF((localPointF1.x + localPointF2.x) / 2.0F, (localPointF1.y + localPointF2.y) / 2.0F);
    float f1 = TAVStickerUtil.getDistance(paramList, (PointF)localObject);
    float f2 = TAVStickerUtil.getDistance(localPointF1, localPointF2) / 2.0F;
    localObject = new AECMShowFaceScanView.FaceRectData();
    RectF localRectF = new RectF();
    localRectF.left = (paramList.x - f2);
    localRectF.right = (paramList.x + f2);
    localRectF.top = (paramList.y - f1);
    localRectF.bottom = (paramList.y + f1);
    ((AECMShowFaceScanView.FaceRectData)localObject).a(localRectF);
    f1 = localPointF2.y;
    f2 = localPointF1.y;
    float f3 = localPointF2.x;
    float f4 = localPointF1.x;
    ((AECMShowFaceScanView.FaceRectData)localObject).a((float)Math.toDegrees(Math.atan2(f1 - f2, f3 - f4)));
    return localObject;
  }
  
  @NonNull
  private DynamicTextItem.Pair<Boolean, List<PointF>> a(@Nullable Bitmap paramBitmap, @Nullable String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    paramString = Boolean.valueOf(false);
    if ((!bool) && (paramBitmap != null))
    {
      paramBitmap = FaceChangeUtils.detectBiggestFaceInGLThread(paramBitmap);
      if ((paramBitmap != null) && (paramBitmap.a != null) && (((Integer)paramBitmap.a).intValue() == 1) && (!CollectionUtils.isEmpty((Collection)paramBitmap.b)))
      {
        AEQLog.b("AECMShowPhotoPreviewFragment", "[detectFaceLocally] face detected");
        return new DynamicTextItem.Pair(Boolean.valueOf(true), FaceChangeUtils.transFromImageSpace2ContainerSpace(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight(), this.jdField_a_of_type_AndroidWidgetRelativeLayout.getWidth(), this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight(), (List)paramBitmap.b));
      }
      AEQLog.b("AECMShowPhotoPreviewFragment", "[detectFaceLocally] no face detected");
      return new DynamicTextItem.Pair(paramString, null);
    }
    AEQLog.a("AECMShowPhotoPreviewFragment", "[detectFaceLocally] invalid data");
    return new DynamicTextItem.Pair(paramString, null);
  }
  
  private void a()
  {
    this.jdField_a_of_type_Int = DisplayUtil.a(getBaseActivity());
    this.jdField_b_of_type_Int = DisplayUtil.b(getBaseActivity());
    Object localObject = getArguments().getStringArrayList("PhotoConst.SELECTED_PATHS");
    if (!CollectionUtils.isEmpty((Collection)localObject)) {
      this.jdField_a_of_type_JavaLangString = ((String)((ArrayList)localObject).get(0));
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapUtils.decodeSampledBitmapFromFileCheckExif(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
      if (localObject != null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
        localObject = this.jdField_a_of_type_AndroidWidgetImageView.getViewTreeObserver();
        if (((ViewTreeObserver)localObject).isAlive()) {
          ((ViewTreeObserver)localObject).addOnGlobalLayoutListener(new AECMShowPhotoPreviewFragment.2(this));
        }
      }
    }
  }
  
  public static void a(Activity paramActivity, Intent paramIntent)
  {
    PublicFragmentActivity.Launcher.a(paramActivity, paramIntent, PublicFragmentActivityForPeak.class, AECMShowPhotoPreviewFragment.class);
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2064122573));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2064122321));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2064122299));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2064122788));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2064122780));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2064122207));
    this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowLoadingView = ((AECMShowLoadingView)paramView.findViewById(2064122050));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2064122805);
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAECMShowFaceScanView = ((AECMShowFaceScanView)paramView.findViewById(2064122179));
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAECMShowFaceScanView.setListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setEnabled(false);
  }
  
  private void a(List<PointF> paramList)
  {
    paramList = a(paramList);
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAECMShowFaceScanView.a(1001, paramList);
  }
  
  private void b()
  {
    AEQLog.b("AECMShowPhotoPreviewFragment", "startCmShowRequest");
    ThreadManager.getSubThreadHandler().post(new AECMShowPhotoPreviewFragment.3(this));
    this.d = 1;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowLoadingView.a(1, null);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private static void b(@NonNull Activity paramActivity, @NonNull CmShowDataWrapper paramCmShowDataWrapper)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("edit_video_type", 10027);
    localBundle.putInt("ability_flag", 2);
    localBundle.putInt("PeakConstants.ARG_FORCE_CAMERA", 1);
    localBundle.putSerializable("KEY_CMSHOW_DATA", paramCmShowDataWrapper);
    paramCmShowDataWrapper = QIMCameraCaptureActivity.a(paramActivity, localBundle);
    paramCmShowDataWrapper.addFlags(603979776);
    paramActivity.startActivity(paramCmShowDataWrapper);
    paramActivity.finish();
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
    if (this.d == 2) {
      AEBaseDataReporter.a().a(1, System.currentTimeMillis() - this.jdField_a_of_type_Long);
    }
    getBaseActivity().finish();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2064122780)
    {
      onBackPressed();
      return;
    }
    if (i == 2064122299) {
      onBackPressed();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowRequestController = new AECMShowRequestController(2, new AECMShowPhotoPreviewFragment.1(this));
    this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowRequestController.a();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2064318492, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localBitmap != null) {
      BitmapUtils.recycle(localBitmap);
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowRequestController.b();
    this.jdField_a_of_type_ComTencentAelightCameraCmsshowApiCmShowDataWrapper = null;
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentAelightCameraCmsshowApiCmShowDataWrapper != null)
    {
      b(getBaseActivity(), this.jdField_a_of_type_ComTencentAelightCameraCmsshowApiCmShowDataWrapper);
      this.jdField_a_of_type_ComTencentAelightCameraCmsshowApiCmShowDataWrapper = null;
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    a(paramView);
    a();
  }
  
  public void y()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAECMShowFaceScanView.a(1003, null);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2064056369);
    b();
  }
  
  public void z() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.cmshow.AECMShowPhotoPreviewFragment
 * JD-Core Version:    0.7.0.1
 */