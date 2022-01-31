package com.tencent.mobileqq.activity;

import aciy;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.qphone.base.util.QLog;

class QQIdentiferActivity$1
  implements Runnable
{
  QQIdentiferActivity$1(QQIdentiferActivity paramQQIdentiferActivity, int paramInt) {}
  
  public void run()
  {
    int j = this.this$0.findViewById(2131298297).getHeight();
    int i = this.a;
    if (j <= 0) {
      i = aciy.a(QQIdentiferActivity.a(this.this$0) + 30, this.this$0.getResources());
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("qq_Identification.act", 2, "marginTop = " + this.a + " cancelHeight=" + j);
      }
      View localView = this.this$0.findViewById(2131311567);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.topMargin = i;
      localView.setLayoutParams(localLayoutParams);
      return;
      if (this.a < j) {
        i = aciy.a(QQIdentiferActivity.a(this.this$0), this.this$0.getResources()) + j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQIdentiferActivity.1
 * JD-Core Version:    0.7.0.1
 */