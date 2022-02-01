package com.tencent.av.smallscreen;

import android.os.Handler;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.UITools;

class SmallScreenVideoControlUI$TimmerRunnable
  implements Runnable
{
  SmallScreenVideoControlUI$TimmerRunnable(SmallScreenVideoControlUI paramSmallScreenVideoControlUI) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentAvVideoController != null) && (this.this$0.jdField_b_of_type_Boolean))
    {
      long l = this.this$0.jdField_a_of_type_ComTencentAvVideoController.a();
      if ((this.this$0.jdField_b_of_type_JavaLangString == null) || (l != 0L))
      {
        this.this$0.jdField_b_of_type_JavaLangString = UITools.a(l);
        if ((this.this$0.jdField_a_of_type_AndroidWidgetTextView != null) && (!this.this$0.c))
        {
          this.this$0.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(UITools.a(this.this$0.jdField_b_of_type_JavaLangString));
          this.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(this.this$0.jdField_b_of_type_JavaLangString);
        }
      }
      this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideoControlUI.TimmerRunnable
 * JD-Core Version:    0.7.0.1
 */