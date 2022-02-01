package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.panorama.PanoramaSensorManager;
import com.tencent.av.camera.CameraObserver;
import com.tencent.av.camera.api.ICameraManagerApi;
import com.tencent.av.opengl.effects.EffectController;
import com.tencent.av.utils.AVTraceUtil;
import com.tencent.av.utils.AudioHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class AVActivity$2
  extends CameraObserver
{
  AVActivity$2(AVActivity paramAVActivity) {}
  
  protected void a(long paramLong)
  {
    if (QLog.isDevelopLevel())
    {
      String str = this.a.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onBeforeCloseCamera, mControlUI[");
      boolean bool;
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if (this.a.isDestroyed()) {
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.h()) {
        return;
      }
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.k(paramLong);
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a() != null) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a().a(3);
      }
    }
  }
  
  protected void a(long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = this.a.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onBeforeOpenCamera, bLastOpen[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if (this.a.isDestroyed()) {
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.h()) {
        return;
      }
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.i(paramLong, 16777215);
    }
  }
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    Object localObject = this.a.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAfterOpenCamera, success[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("], preSessionType[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], mRotationAngle[");
    localStringBuilder.append(this.a.h);
    localStringBuilder.append("], mShutCamera[");
    localStringBuilder.append(this.a.f);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    if (this.a.isDestroyed()) {
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.h()) {
        return;
      }
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.i(paramLong, 16777215);
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.b(paramLong, this.a.h);
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.a(paramLong, paramBoolean, paramInt);
      PanoramaSensorManager.a().a(this.a.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi.isFrontCamera());
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null)
      {
        if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().j != 2)) {
          this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(this.a.h, false);
        } else {
          this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.b(this.a.h);
        }
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.c(paramLong, this.a.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi.isFrontCamera());
      }
      if ((this.a.jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a().j != 2)) {
        this.a.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi.setRotation(this.a.h);
      }
      if (!paramBoolean)
      {
        localObject = this.a;
        ((AVActivity)localObject).f = true;
        if ((((AVActivity)localObject).jdField_a_of_type_ComTencentAvVideoController != null) && (this.a.jdField_a_of_type_ComTencentAvVideoController.a() != null))
        {
          if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().p()) {
            localObject = "0X8004894";
          }
          for (;;)
          {
            break;
            if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().e == 1) {
              localObject = "0X8004888";
            } else if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().e == 2) {
              localObject = "0X800488E";
            } else {
              localObject = "";
            }
          }
          ReportController.b(null, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
        }
        if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
          this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(38), Integer.valueOf(2), Long.valueOf(paramLong) });
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    long l = AudioHelper.b();
    AVTraceUtil.a("switch_camera", "onAfterSwitchCamera", 3, new Object[] { Long.valueOf(l) });
    String str = this.a.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAfterSwitchCamera, success[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (paramBoolean)
    {
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.b(2131373640, true);
      }
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
        this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.e(this.a.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi.isFrontCamera());
      }
      if (this.a.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi != null) {
        PanoramaSensorManager.a().a(this.a.jdField_a_of_type_ComTencentAvCameraApiICameraManagerApi.isFrontCamera());
      }
    }
    else
    {
      this.a.a(l);
    }
  }
  
  protected void b()
  {
    AVTraceUtil.a("switch_camera", "onBeforeSwitchCamera", 3, new Object[0]);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.b(2131373640, false);
    }
  }
  
  protected void b(long paramLong, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isDevelopLevel())
    {
      localObject = this.a.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAfterCloseCamera, success[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], mControlUI[");
      boolean bool;
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    if (this.a.isDestroyed()) {
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI != null)
    {
      if (this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.h()) {
        return;
      }
      this.a.jdField_a_of_type_ComTencentAvUiVideoControlUI.c(paramLong, paramBoolean);
      localObject = VideoController.a().a(false);
      if (localObject != null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("EffectSettingUi", 1, "onHide clear state");
        }
        ((EffectController)localObject).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.2
 * JD-Core Version:    0.7.0.1
 */