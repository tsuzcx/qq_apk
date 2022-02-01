package com.tencent.av.screenshare;

import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.ui.AVActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import lfe;

class ScreenShareCtrl$4
  implements Runnable
{
  ScreenShareCtrl$4(ScreenShareCtrl paramScreenShareCtrl, AVActivity paramAVActivity, lfe paramlfe) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentAvUiAVActivity.isFinishing()) || (this.jdField_a_of_type_ComTencentAvUiAVActivity.isDestroyed())) {
      if (QLog.isColorLevel()) {
        QLog.i("AVShare", 2, "stopShareScreen, activity finish");
      }
    }
    lfe locallfe;
    do
    {
      return;
      locallfe = ScreenShareCtrl.a(this.this$0).a();
      if ((locallfe.r()) && (!locallfe.f()) && (TextUtils.equals(this.jdField_a_of_type_Lfe.c, locallfe.c))) {
        QQToast.a(BaseApplicationImpl.getApplication(), 0, 2131695595, 1).a();
      }
    } while (!QLog.isColorLevel());
    QLog.i("AVShare", 2, "stopShareScreen, session[" + locallfe + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.screenshare.ScreenShareCtrl.4
 * JD-Core Version:    0.7.0.1
 */