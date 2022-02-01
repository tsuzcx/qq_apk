package com.tencent.av.screenshare;

import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.ui.AVActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import lez;

class ScreenShareCtrl$4
  implements Runnable
{
  ScreenShareCtrl$4(ScreenShareCtrl paramScreenShareCtrl, AVActivity paramAVActivity, lez paramlez) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentAvUiAVActivity.isFinishing()) || (this.jdField_a_of_type_ComTencentAvUiAVActivity.isDestroyed())) {
      if (QLog.isColorLevel()) {
        QLog.i("AVShare", 2, "stopShareScreen, activity finish");
      }
    }
    lez locallez;
    do
    {
      return;
      locallez = ScreenShareCtrl.a(this.this$0).a();
      if ((locallez.r()) && (!locallez.f()) && (TextUtils.equals(this.jdField_a_of_type_Lez.c, locallez.c))) {
        QQToast.a(BaseApplicationImpl.getApplication(), 0, 2131695378, 1).a();
      }
    } while (!QLog.isColorLevel());
    QLog.i("AVShare", 2, "stopShareScreen, session[" + locallez + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.screenshare.ScreenShareCtrl.4
 * JD-Core Version:    0.7.0.1
 */