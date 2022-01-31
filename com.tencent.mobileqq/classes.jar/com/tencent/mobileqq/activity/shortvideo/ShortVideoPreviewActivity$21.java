package com.tencent.mobileqq.activity.shortvideo;

import android.os.Message;
import android.widget.SeekBar;
import bbva;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ShortVideoPreviewActivity$21
  implements Runnable
{
  ShortVideoPreviewActivity$21(ShortVideoPreviewActivity paramShortVideoPreviewActivity) {}
  
  public void run()
  {
    Message localMessage;
    if ((this.this$0.jdField_a_of_type_Bbva.b()) && (this.this$0.jdField_a_of_type_AndroidViewSurfaceView != null))
    {
      localMessage = Message.obtain();
      localMessage.arg1 = this.this$0.jdField_a_of_type_Bbva.b();
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPreviewActivity", 2, "此时时间为+" + localMessage.arg1);
      }
      this.this$0.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(localMessage.arg1);
      if (this.this$0.jdField_a_of_type_MqqOsMqqHandler != null) {}
    }
    else
    {
      return;
    }
    this.this$0.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
    this.this$0.jdField_a_of_type_MqqOsMqqHandler.post(this.this$0.jdField_a_of_type_JavaLangRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity.21
 * JD-Core Version:    0.7.0.1
 */