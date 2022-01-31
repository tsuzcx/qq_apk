package com.tencent.mobileqq.activity.aio;

import android.widget.TextView;
import com.tencent.mobileqq.data.IntimateInfo;

class IntimateTitleSwitchView$4
  implements Runnable
{
  IntimateTitleSwitchView$4(IntimateTitleSwitchView paramIntimateTitleSwitchView) {}
  
  public void run()
  {
    IntimateTitleSwitchView.c(this.this$0);
    this.this$0.removeCallbacks(IntimateTitleSwitchView.a(this.this$0));
    this.this$0.postDelayed(IntimateTitleSwitchView.a(this.this$0), 2000L);
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo != null)
    {
      if (this.this$0.jdField_a_of_type_Int != 3) {
        break label126;
      }
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.currentScore >= this.this$0.d) {
        break label111;
      }
      this.this$0.e.setText(2131693748);
    }
    for (;;)
    {
      if (!this.this$0.jdField_a_of_type_Boolean) {
        IntimateTitleSwitchView.d(this.this$0);
      }
      return;
      label111:
      this.this$0.e.setText(2131693747);
      continue;
      label126:
      if (this.this$0.jdField_a_of_type_Int == 2)
      {
        if (this.this$0.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.currentScore < this.this$0.d) {
          this.this$0.e.setText(2131693746);
        } else {
          this.this$0.e.setText(2131693745);
        }
      }
      else if (this.this$0.jdField_a_of_type_Int == 1) {
        if (this.this$0.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.currentScore < this.this$0.d) {
          this.this$0.e.setText(2131693750);
        } else {
          this.this$0.e.setText(2131693749);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateTitleSwitchView.4
 * JD-Core Version:    0.7.0.1
 */