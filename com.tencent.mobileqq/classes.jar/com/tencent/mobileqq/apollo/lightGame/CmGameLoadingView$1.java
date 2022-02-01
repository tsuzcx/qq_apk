package com.tencent.mobileqq.apollo.lightGame;

import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker;
import com.tencent.mobileqq.app.HardCodeUtil;

class CmGameLoadingView$1
  implements Runnable
{
  CmGameLoadingView$1(CmGameLoadingView paramCmGameLoadingView, int paramInt, CmGameStartChecker paramCmGameStartChecker) {}
  
  public void run()
  {
    String str;
    if (this.jdField_a_of_type_Int == 1) {
      str = HardCodeUtil.a(2131702136);
    }
    for (;;)
    {
      this.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      this.this$0.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
      str = HardCodeUtil.a(2131702134);
      this.this$0.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131702143));
      this.this$0.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.this$0.setProgressViewVisibility(false);
      this.this$0.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new CmGameLoadingView.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.lightGame.CmGameLoadingView.1
 * JD-Core Version:    0.7.0.1
 */