package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.panorama.PanoramaSensorManager;
import com.tencent.av.camera.CameraObserver;
import com.tencent.av.camera.api.ICameraManagerApi;
import com.tencent.av.opengl.effects.EffectController;
import com.tencent.av.ui.effect.menuview.QavEffectBaseMenuView;
import com.tencent.av.utils.AVTraceUtil;
import com.tencent.av.utils.AudioHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class AVActivity$3
  extends CameraObserver
{
  AVActivity$3(AVActivity paramAVActivity) {}
  
  protected void a(long paramLong)
  {
    if (QLog.isDevelopLevel())
    {
      String str = this.b.i;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onBeforeCloseCamera, mControlUI[");
      boolean bool;
      if (this.b.K != null) {
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
    if (this.b.isDestroyed()) {
      return;
    }
    if (this.b.K != null)
    {
      if (this.b.K.V()) {
        return;
      }
      this.b.K.m(paramLong);
      if (this.b.K.am() != null) {
        this.b.K.am().b(3);
      }
    }
  }
  
  protected void a(long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = this.b.i;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onBeforeOpenCamera, bLastOpen[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if (this.b.isDestroyed()) {
      return;
    }
    if (this.b.K != null)
    {
      if (this.b.K.V()) {
        return;
      }
      this.b.K.f(paramLong, 16777215);
    }
  }
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    Object localObject = this.b.i;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAfterOpenCamera, success[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("], preSessionType[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], mRotationAngle[");
    localStringBuilder.append(this.b.V);
    localStringBuilder.append("], mShutCamera[");
    localStringBuilder.append(this.b.z);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    if (this.b.isDestroyed()) {
      return;
    }
    if (this.b.K != null)
    {
      if (this.b.K.V()) {
        return;
      }
      this.b.K.f(paramLong, 16777215);
      this.b.K.b(paramLong, this.b.V);
      this.b.K.a(paramLong, paramBoolean, paramInt);
      PanoramaSensorManager.a().a(this.b.M.isFrontCamera());
      if (this.b.L != null)
      {
        if ((this.b.I != null) && (this.b.I.k().o != 2)) {
          this.b.L.a(this.b.V, false);
        } else {
          this.b.L.b(this.b.V);
        }
        this.b.L.c(paramLong, this.b.M.isFrontCamera());
      }
      if ((this.b.I != null) && (this.b.I.k().o != 2)) {
        this.b.M.setRotation(this.b.V);
      }
      if (!paramBoolean)
      {
        localObject = this.b;
        ((AVActivity)localObject).z = true;
        if ((((AVActivity)localObject).I != null) && (this.b.I.k() != null))
        {
          if (this.b.I.k().p()) {
            localObject = "0X8004894";
          }
          for (;;)
          {
            break;
            if (this.b.I.k().h == 1) {
              localObject = "0X8004888";
            } else if (this.b.I.k().h == 2) {
              localObject = "0X800488E";
            } else {
              localObject = "";
            }
          }
          ReportController.b(null, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
        }
        if (this.b.H != null) {
          this.b.H.a(new Object[] { Integer.valueOf(38), Integer.valueOf(2), Long.valueOf(paramLong) });
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    long l = AudioHelper.c();
    AVTraceUtil.a("switch_camera", "onAfterSwitchCamera", 3, new Object[] { Long.valueOf(l) });
    String str = this.b.i;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAfterSwitchCamera, success[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (paramBoolean)
    {
      if (this.b.K != null) {
        this.b.K.b(2131441310, true);
      }
      if (this.b.L != null) {
        this.b.L.e(this.b.M.isFrontCamera());
      }
      if (this.b.M != null) {
        PanoramaSensorManager.a().a(this.b.M.isFrontCamera());
      }
    }
    else
    {
      this.b.a(l);
    }
  }
  
  protected void b()
  {
    AVTraceUtil.a("switch_camera", "onBeforeSwitchCamera", 3, new Object[0]);
    if (this.b.K != null) {
      this.b.K.b(2131441310, false);
    }
  }
  
  protected void b(long paramLong, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isDevelopLevel())
    {
      localObject = this.b.i;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAfterCloseCamera, success[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], mControlUI[");
      boolean bool;
      if (this.b.K != null) {
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
    if (this.b.isDestroyed()) {
      return;
    }
    if (this.b.K != null)
    {
      if (this.b.K.V()) {
        return;
      }
      this.b.K.c(paramLong, paramBoolean);
      localObject = VideoController.f().m(false);
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
 * Qualified Name:     com.tencent.av.ui.AVActivity.3
 * JD-Core Version:    0.7.0.1
 */