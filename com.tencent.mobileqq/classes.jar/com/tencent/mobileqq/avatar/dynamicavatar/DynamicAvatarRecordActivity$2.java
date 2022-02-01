package com.tencent.mobileqq.avatar.dynamicavatar;

import android.os.Build.VERSION;
import android.os.MessageQueue.IdleHandler;
import android.view.WindowManager.BadTokenException;
import com.tencent.aelight.camera.api.ICameraCompatible;
import com.tencent.aelight.camera.constants.CameraCompatibleConstants;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.view.CameraGLSurfaceView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

class DynamicAvatarRecordActivity$2
  implements MessageQueue.IdleHandler
{
  DynamicAvatarRecordActivity$2(DynamicAvatarRecordActivity paramDynamicAvatarRecordActivity) {}
  
  public boolean queueIdle()
  {
    if (((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isFoundProduct(CameraCompatibleConstants.b)) {
      this.a.b(true);
    } else {
      this.a.b(false);
    }
    if (this.a.m != null) {
      this.a.m.onResume();
    }
    this.a.e.e();
    DynamicAvatarRecordActivity.a(this.a);
    if (Build.VERSION.SDK_INT < 14)
    {
      DynamicAvatarRecordActivity localDynamicAvatarRecordActivity = this.a;
      localDynamicAvatarRecordActivity.S = DialogUtil.a(localDynamicAvatarRecordActivity, 230).setMessage(HardCodeUtil.a(2131901675)).setPositiveButton(this.a.getString(2131891511), new DynamicAvatarRecordActivity.2.1(this));
      try
      {
        this.a.S.setCancelable(false);
        this.a.S.show();
      }
      catch (WindowManager.BadTokenException localBadTokenException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("DynamicAvatarRecordActivity", 2, "", localBadTokenException);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("PEAK_CAMERA", 2, "Added camera view.");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity.2
 * JD-Core Version:    0.7.0.1
 */