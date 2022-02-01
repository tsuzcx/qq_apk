package com.tencent.aelight.camera.ae;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.aelight.camera.ae.camera.ui.AECaptureController;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.aelight.camera.ae.view.AECompoundButton;
import com.tencent.aelight.camera.ae.view.AEPituCameraCaptureButtonLayout;
import com.tencent.aelight.camera.aebase.view.AbsAECaptureButton;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.camera.utils.CameraUtils;
import com.tencent.mobileqq.widget.QQToast;
import java.util.Arrays;

class AEPituCameraUnit$18
  implements Runnable
{
  AEPituCameraUnit$18(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void run()
  {
    AEQLog.b(this.this$0.jdField_a_of_type_JavaLangString, "actionAfterFirstFrame--ui run--BEGIN");
    Object localObject = (ViewStub)this.this$0.jdField_a_of_type_AndroidViewView.findViewById(2064122646);
    if (localObject != null)
    {
      ((ViewStub)localObject).inflate();
      AEQLog.b(this.this$0.jdField_a_of_type_JavaLangString, "AEPartAction--inflate bottom");
    }
    localObject = (ViewStub)this.this$0.jdField_a_of_type_AndroidViewView.findViewById(2064122648);
    if ((localObject != null) && (!this.this$0.m()))
    {
      ((ViewStub)localObject).inflate();
      AEQLog.b(this.this$0.jdField_a_of_type_JavaLangString, "AEPartAction--inflate captureModeCode");
    }
    localObject = this.this$0;
    ((AEPituCameraUnit)localObject).jdField_a_of_type_ComTencentAelightCameraAebaseViewAbsAECaptureButton = ((AEPituCameraCaptureButtonLayout)((AEPituCameraUnit)localObject).jdField_a_of_type_AndroidViewView.findViewById(2064122025));
    localObject = this.this$0.jdField_a_of_type_ComTencentAelightCameraAebaseViewAbsAECaptureButton;
    AEPituCameraUnit localAEPituCameraUnit = this.this$0;
    ((AbsAECaptureButton)localObject).a(localAEPituCameraUnit, localAEPituCameraUnit.jdField_a_of_type_ComTencentAelightCameraAeAECameraConfig.i(), this.this$0.jdField_a_of_type_ComTencentAelightCameraAeCameraCoreAECameraGLSurfaceView);
    if (!this.this$0.l())
    {
      localObject = (RelativeLayout.LayoutParams)this.this$0.jdField_a_of_type_ComTencentAelightCameraAebaseViewAbsAECaptureButton.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.b(-30.0F, this.this$0.jdField_a_of_type_ComTencentAelightCameraAebaseViewAbsAECaptureButton.getResources());
      this.this$0.jdField_a_of_type_ComTencentAelightCameraAebaseViewAbsAECaptureButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.this$0.jdField_a_of_type_ComTencentAelightCameraAebaseViewAbsAECaptureButton.d();
    }
    if (this.this$0.jdField_a_of_type_Boolean)
    {
      this.this$0.jdField_a_of_type_ComTencentAelightCameraAebaseViewAbsAECaptureButton.k();
      this.this$0.R();
    }
    this.this$0.jdField_a_of_type_ComTencentAelightCameraAeCameraUiAECaptureController.b();
    if (this.this$0.jdField_a_of_type_ComTencentAelightCameraAeModeAECaptureMode.shouldStartCamera())
    {
      this.this$0.Y();
      this.this$0.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager.a();
      if ((AEPituCameraUnit.a(this.this$0) > 0) && (AEPituCameraUnit.b(this.this$0) > 0)) {
        this.this$0.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager.a(851973, new Object[] { Arrays.asList(new Integer[] { Integer.valueOf(AEPituCameraUnit.a(this.this$0)), Integer.valueOf(AEPituCameraUnit.b(this.this$0)) }) });
      }
    }
    localObject = this.this$0;
    AEPituCameraUnit.a((AEPituCameraUnit)localObject, (AECompoundButton)((AEPituCameraUnit)localObject).jdField_a_of_type_AndroidViewView.findViewById(2064122095));
    if (AEPituCameraUnit.a(this.this$0) != null)
    {
      AEPituCameraUnit.a(this.this$0).setOnClickListener(this.this$0);
      AEPituCameraUnit.a(this.this$0).setSelected(false);
      AEPituCameraUnit.a(this.this$0).setVisibility(8);
      if (AEPituCameraUnit.a(this.this$0))
      {
        localObject = this.this$0;
        AEPituCameraUnit.a((AEPituCameraUnit)localObject, AEPituCameraUnit.a((AEPituCameraUnit)localObject));
      }
    }
    localObject = this.this$0;
    AEPituCameraUnit.b((AEPituCameraUnit)localObject, (AECompoundButton)((AEPituCameraUnit)localObject).jdField_a_of_type_AndroidViewView.findViewById(2064122036));
    if (AEPituCameraUnit.b(this.this$0) != null)
    {
      AEPituCameraUnit.b(this.this$0).setOnClickListener(this.this$0);
      AEPituCameraUnit.b(this.this$0).setContentDescription(AEPituCameraUnit.b(this.this$0).getResources().getString(2064515413));
      if (!CameraUtils.d())
      {
        AEPituCameraUnit.b(this.this$0).setVisibility(4);
        AEPituCameraUnit.b(this.this$0).setEnabled(false);
      }
    }
    if (this.this$0.jdField_a_of_type_Boolean)
    {
      this.this$0.jdField_a_of_type_ComTencentAelightCameraAePartVideoStoryCapturePartManager.b();
      this.this$0.jdField_a_of_type_ComTencentAelightCameraAeCameraUiAECaptureController.h();
    }
    this.this$0.jdField_a_of_type_AndroidViewView.setOnTouchListener(this.this$0);
    if (this.this$0.l()) {
      this.this$0.jdField_a_of_type_AndroidViewView.setOnClickListener(new AEPituCameraUnit.18.1(this));
    }
    this.this$0.N();
    AEPituCameraUnit.c(this.this$0);
    AEPituCameraUnit.a(this.this$0, true);
    if (this.this$0.m()) {
      QQToast.a(BaseApplicationImpl.getContext(), HardCodeUtil.a(2064515294), 0).a();
    }
    AEQLog.b(this.this$0.jdField_a_of_type_JavaLangString, "actionAfterFirstFrame--ui run--END");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.18
 * JD-Core Version:    0.7.0.1
 */