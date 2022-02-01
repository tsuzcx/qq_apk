package com.tencent.av.ui;

import android.os.Handler;
import android.widget.TextView;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;

class VoiceChangeChooseDialog$3
  implements VoiceChangeAdapter.ICallback
{
  public void a(int paramInt)
  {
    AVLog.printAllUserLog("VoiceChangeChooseDialog", "onItemSelected| voiceType=" + paramInt);
    if (this.a.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      AVLog.printErrorLog("VoiceChangeChooseDialog", "onItemSelected mVideoController is null!!");
      return;
    }
    if (paramInt == 0)
    {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(2131695963);
      this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
      VoiceChangeChooseDialog.a(this.a, 0);
    }
    while (this.a.jdField_a_of_type_ComTencentAvVideoController.a() != null)
    {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().U = paramInt;
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().V = 0;
      this.a.jdField_a_of_type_ComTencentAvVideoController.y();
      VoiceChangeDataReport.a(this.a.jdField_a_of_type_ComTencentAvVideoController.a(), paramInt);
      return;
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(2131695962);
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a() != null)
      {
        if ((!this.a.jdField_a_of_type_ComTencentAvVideoController.a().aB) && (VoiceChangeChooseDialog.a(this.a) == 0) && (!this.a.jdField_a_of_type_Boolean))
        {
          this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 5000L);
          VoiceChangeChooseDialog.a(this.a, 1);
        }
      }
      else {
        AVLog.printErrorLog("VoiceChangeChooseDialog", "mVideoController.getSessionInfo() == null");
      }
    }
    AVLog.printErrorLog("VoiceChangeChooseDialog", "mVideoController.getSessionInfo() == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.VoiceChangeChooseDialog.3
 * JD-Core Version:    0.7.0.1
 */