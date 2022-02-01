package com.tencent.mobileqq.activity;

import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.richmedia.capture.view.QIdentityCircleLayout;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.youtu.ytagreflectlivecheck.ui.YTReflectLayout;

class QQIdentiferActivity$3
  implements Runnable
{
  QQIdentiferActivity$3(QQIdentiferActivity paramQQIdentiferActivity, View paramView) {}
  
  public void run()
  {
    int i = ImmersiveUtils.getStatusBarHeight(this.this$0);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.a.getLayoutParams();
    localLayoutParams.topMargin += i;
    this.a.setLayoutParams(localLayoutParams);
    i = QQIdentiferActivity.access$300(this.this$0).getHeight();
    int j = QQIdentiferActivity.access$300(this.this$0).getWidth();
    int k = this.this$0.mYTReflectLayout.getHeight();
    localLayoutParams = (RelativeLayout.LayoutParams)QQIdentiferActivity.access$300(this.this$0).getLayoutParams();
    localLayoutParams.topMargin = (k / 2 - j - (i - j) / 2);
    QQIdentiferActivity.access$300(this.this$0).setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQIdentiferActivity.3
 * JD-Core Version:    0.7.0.1
 */