package com.tencent.mobileqq.activity;

import afur;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.richmedia.capture.view.CircleBarView;

class QQIdentiferActivity$8
  implements Runnable
{
  QQIdentiferActivity$8(QQIdentiferActivity paramQQIdentiferActivity) {}
  
  public void run()
  {
    int i = QQIdentiferActivity.a(this.this$0).getTop();
    int j = QQIdentiferActivity.a(this.this$0).getTop();
    View localView = this.this$0.findViewById(2131378811);
    int k = localView.getHeight();
    int m = afur.a(15.0F, this.this$0.getResources());
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
    localLayoutParams.topMargin = (i + j - k - m);
    localView.setLayoutParams(localLayoutParams);
    QQIdentiferActivity.a(this.this$0).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQIdentiferActivity.8
 * JD-Core Version:    0.7.0.1
 */