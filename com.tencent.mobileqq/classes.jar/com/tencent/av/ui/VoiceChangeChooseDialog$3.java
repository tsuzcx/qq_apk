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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onItemSelected| voiceType=");
    localStringBuilder.append(paramInt);
    AVLog.printAllUserLog("VoiceChangeChooseDialog", localStringBuilder.toString());
    if (this.a.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      AVLog.printErrorLog("VoiceChangeChooseDialog", "onItemSelected mVideoController is null!!");
      return;
    }
    if (paramInt == 0)
    {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(2131695978);
      this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
      VoiceChangeChooseDialog.a(this.a, 0);
    }
    else
    {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(2131695977);
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a() != null)
      {
        if ((!this.a.jdField_a_of_type_ComTencentAvVideoController.a().aq) && (VoiceChangeChooseDialog.a(this.a) == 0) && (!this.a.jdField_a_of_type_Boolean))
        {
          this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 5000L);
          VoiceChangeChooseDialog.a(this.a, 1);
        }
      }
      else {
        AVLog.printErrorLog("VoiceChangeChooseDialog", "mVideoController.getSessionInfo() == null");
      }
    }
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.a() != null)
    {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().ad = paramInt;
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().ae = 0;
      this.a.jdField_a_of_type_ComTencentAvVideoController.z();
      VoiceChangeDataReport.a(this.a.jdField_a_of_type_ComTencentAvVideoController.a(), paramInt);
      return;
    }
    AVLog.printErrorLog("VoiceChangeChooseDialog", "mVideoController.getSessionInfo() == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VoiceChangeChooseDialog.3
 * JD-Core Version:    0.7.0.1
 */