package com.tencent.av.screenshare;

import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.AVActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class ScreenShareCtrl$3
  implements Runnable
{
  ScreenShareCtrl$3(ScreenShareCtrl paramScreenShareCtrl, AVActivity paramAVActivity, SessionInfo paramSessionInfo) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentAvUiAVActivity.isFinishing()) || (this.jdField_a_of_type_ComTencentAvUiAVActivity.isDestroyed())) {
      if (QLog.isColorLevel()) {
        QLog.i("AVShare", 2, "stopShareScreen, activity finish");
      }
    }
    SessionInfo localSessionInfo;
    do
    {
      return;
      localSessionInfo = ScreenShareCtrl.a(this.this$0).a();
      if ((localSessionInfo.r()) && (!localSessionInfo.f()) && (TextUtils.equals(this.jdField_a_of_type_ComTencentAvAppSessionInfo.c, localSessionInfo.c))) {
        QQToast.a(BaseApplicationImpl.getApplication(), 0, 2131695836, 1).a();
      }
    } while (!QLog.isColorLevel());
    QLog.i("AVShare", 2, "stopShareScreen, session[" + localSessionInfo + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.screenshare.ScreenShareCtrl.3
 * JD-Core Version:    0.7.0.1
 */