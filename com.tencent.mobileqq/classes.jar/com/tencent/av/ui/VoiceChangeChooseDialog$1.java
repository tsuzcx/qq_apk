package com.tencent.av.ui;

import android.os.Handler;
import android.widget.TextView;
import com.tencent.av.VideoController;
import mlo;

public class VoiceChangeChooseDialog$1
  implements Runnable
{
  public void run()
  {
    if ((mlo.a(this.this$0) == 1) && (!this.this$0.jdField_a_of_type_Boolean))
    {
      this.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(2131695499);
      mlo.a(this.this$0, 2);
      this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().az = true;
      this.this$0.jdField_a_of_type_AndroidOsHandler.postDelayed(this.this$0.jdField_a_of_type_JavaLangRunnable, 10000L);
    }
    while (mlo.a(this.this$0) != 2) {
      return;
    }
    this.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(2131695501);
    mlo.a(this.this$0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.VoiceChangeChooseDialog.1
 * JD-Core Version:    0.7.0.1
 */