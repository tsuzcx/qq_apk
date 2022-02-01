package com.tencent.av.ui;

import android.os.Handler;
import android.widget.TextView;
import com.tencent.av.VideoController;

class VoiceChangeChooseDialog$1
  implements Runnable
{
  public void run()
  {
    if ((VoiceChangeChooseDialog.a(this.this$0) == 1) && (!this.this$0.jdField_a_of_type_Boolean))
    {
      this.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(2131695975);
      VoiceChangeChooseDialog.a(this.this$0, 2);
      this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().aq = true;
      this.this$0.jdField_a_of_type_AndroidOsHandler.postDelayed(this.this$0.jdField_a_of_type_JavaLangRunnable, 10000L);
      return;
    }
    if (VoiceChangeChooseDialog.a(this.this$0) == 2)
    {
      this.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(2131695977);
      VoiceChangeChooseDialog.a(this.this$0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VoiceChangeChooseDialog.1
 * JD-Core Version:    0.7.0.1
 */