package com.tencent.mobileqq.activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.richmedia.capture.view.CircleBarView;
import com.tencent.mobileqq.richmedia.capture.view.QIdentityCircleLayout;
import com.tencent.mobileqq.util.Utils;

class QQIdentiferActivity$8
  implements Runnable
{
  QQIdentiferActivity$8(QQIdentiferActivity paramQQIdentiferActivity) {}
  
  public void run()
  {
    int i = QQIdentiferActivity.access$900(this.this$0).getTop();
    int j = QQIdentiferActivity.access$300(this.this$0).getTop();
    View localView = this.this$0.findViewById(2131378819);
    int k = localView.getHeight();
    int m = Utils.a(15.0F, this.this$0.getResources());
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
    localLayoutParams.topMargin = (i + j - k - m);
    localView.setLayoutParams(localLayoutParams);
    QQIdentiferActivity.access$1000(this.this$0).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQIdentiferActivity.8
 * JD-Core Version:    0.7.0.1
 */