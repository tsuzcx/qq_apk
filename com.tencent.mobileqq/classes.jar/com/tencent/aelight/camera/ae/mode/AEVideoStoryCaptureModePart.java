package com.tencent.aelight.camera.ae.mode;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.AEViewModelProviders;
import com.tencent.aelight.camera.ae.control.AEQIMManager;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.part.AEVideoStoryStateViewModel;
import com.tencent.aelight.camera.ae.part.VideoStoryBasePart;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.aelight.camera.aioeditor.shortvideo.util.ScreenUtil;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;

public class AEVideoStoryCaptureModePart
  extends VideoStoryBasePart
{
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private PagerAdapter jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter;
  private AEPituCameraUnit jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit;
  private AECaptureMode jdField_a_of_type_ComTencentAelightCameraAeModeAECaptureMode;
  private AECaptureModeSelectPager jdField_a_of_type_ComTencentAelightCameraAeModeAECaptureModeSelectPager;
  private AEVideoStoryCaptureModeViewModel jdField_a_of_type_ComTencentAelightCameraAeModeAEVideoStoryCaptureModeViewModel;
  private AEVideoStoryStateViewModel jdField_a_of_type_ComTencentAelightCameraAePartAEVideoStoryStateViewModel;
  private boolean jdField_a_of_type_Boolean;
  private AECaptureMode[] jdField_a_of_type_ArrayOfComTencentAelightCameraAeModeAECaptureMode;
  private boolean b;
  
  public AEVideoStoryCaptureModePart(Activity paramActivity, View paramView, VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    super(paramActivity, paramView, paramVideoStoryCapturePartManager);
    this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit = ((AEPituCameraUnit)paramVideoStoryCapturePartManager.a(65537, new Object[0]));
  }
  
  private AEMaterialManager a()
  {
    return (AEMaterialManager)AEQIMManager.a().b(1);
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeModeAEVideoStoryCaptureModeViewModel = ((AEVideoStoryCaptureModeViewModel)AEViewModelProviders.a(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit).get(AEVideoStoryCaptureModeViewModel.class));
    this.jdField_a_of_type_ComTencentAelightCameraAeModeAEVideoStoryCaptureModeViewModel.a.observe(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit, new AEVideoStoryCaptureModePart.2(this));
    this.jdField_a_of_type_ComTencentAelightCameraAePartAEVideoStoryStateViewModel = ((AEVideoStoryStateViewModel)AEViewModelProviders.a(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit).get(AEVideoStoryStateViewModel.class));
    this.jdField_a_of_type_ComTencentAelightCameraAePartAEVideoStoryStateViewModel.a().observe(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit, new AEVideoStoryCaptureModePart.3(this));
  }
  
  private void a(AECaptureMode paramAECaptureMode)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeModeAECaptureMode == paramAECaptureMode) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAeModeAEVideoStoryCaptureModeViewModel.e()) {
      return;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeModeAEVideoStoryCaptureModeViewModel.a.postValue(new AECaptureModeChangingEvent(this.jdField_a_of_type_ComTencentAelightCameraAeModeAECaptureMode, paramAECaptureMode, 0));
  }
  
  private void a(boolean paramBoolean)
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView == null) {
      return;
    }
    this.b = paramBoolean;
    if (paramBoolean)
    {
      if (localView.getVisibility() != 0) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
    else if (localView.getVisibility() == 0) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  protected void initView()
  {
    Object localObject = (ViewStub)this.mRootView.findViewById(2064122648);
    if (localObject != null)
    {
      ((ViewStub)localObject).inflate();
      AEQLog.b("AEVideoStoryCaptureModePart", "AEPartAction--inflate captureMode");
    }
    this.jdField_a_of_type_AndroidViewView = this.mRootView.findViewById(2064122567);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2064122297));
    this.jdField_a_of_type_ComTencentAelightCameraAeModeAECaptureModeSelectPager = ((AECaptureModeSelectPager)this.jdField_a_of_type_AndroidViewView.findViewById(2064122841));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.mRootView.findViewById(2064122226));
    int j = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
    int k = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
    int i = j;
    if (ScreenUtil.a(j, k)) {
      i = k * 9 / 16;
    }
    i = (i - ViewUtils.a(53.0F)) / 2;
    this.jdField_a_of_type_ComTencentAelightCameraAeModeAECaptureModeSelectPager.setPadding(i, 0, i, 0);
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeModeAECaptureModeSelectPager;
    boolean bool = true;
    ((AECaptureModeSelectPager)localObject).setDisableScroll(true);
    this.jdField_a_of_type_ComTencentAelightCameraAeModeAECaptureModeSelectPager.setOnPageChangeListener(new AEVideoStoryCaptureModePart.1(this));
    this.jdField_a_of_type_ArrayOfComTencentAelightCameraAeModeAECaptureMode = ((AECaptureMode[])((AEVideoStoryCaptureModeViewModel)AEViewModelProviders.a(this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit).get(AEVideoStoryCaptureModeViewModel.class)).b.getValue());
    localObject = this.jdField_a_of_type_ArrayOfComTencentAelightCameraAeModeAECaptureMode;
    if (localObject != null)
    {
      if (localObject.length <= 1) {
        bool = false;
      }
      a(bool);
    }
    this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter = new AEVideoStoryCaptureModePart.AECaptureModeAdapter(this, this.mRootView.getContext());
    this.jdField_a_of_type_ComTencentAelightCameraAeModeAECaptureModeSelectPager.setAdapter(this.jdField_a_of_type_AndroidxViewpagerWidgetPagerAdapter);
    a();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((this.mActivity != null) && (paramInt1 == 101) && (paramInt2 == 201)) {
      this.mActivity.finish();
    }
  }
  
  public void onActivityResume()
  {
    super.onActivityResume();
    if (AECaptureMode.NORMAL == this.jdField_a_of_type_ComTencentAelightCameraAeModeAECaptureMode)
    {
      AEPituCameraUnit localAEPituCameraUnit = this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit;
      if (localAEPituCameraUnit != null) {
        localAEPituCameraUnit.f(true);
      }
    }
  }
  
  public void send(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 393218) {
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length == 1) && ((paramVarArgs[0] instanceof AEMaterialMetaData)))
    {
      if (this.jdField_a_of_type_ComTencentAelightCameraAeModeAECaptureMode != AECaptureMode.PLAY) {
        return;
      }
      a().a((AEMaterialMetaData)paramVarArgs[0], true);
      Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeAEPituCameraUnit;
      if (localObject != null)
      {
        localObject = ((AEPituCameraUnit)localObject).a().getIntent();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("camera^");
        localStringBuilder.append(((AEMaterialMetaData)paramVarArgs[0]).k);
        ((Intent)localObject).putExtra("widgetinfo", localStringBuilder.toString());
      }
    }
    a(AECaptureMode.NORMAL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.mode.AEVideoStoryCaptureModePart
 * JD-Core Version:    0.7.0.1
 */