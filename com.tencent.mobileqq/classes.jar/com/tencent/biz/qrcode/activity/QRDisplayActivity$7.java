package com.tencent.biz.qrcode.activity;

import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;

class QRDisplayActivity$7
  implements Runnable
{
  QRDisplayActivity$7(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void run()
  {
    int i = this.this$0.c.getHeight();
    int j = this.this$0.b.getHeight();
    if (j < i)
    {
      View localView = this.this$0.findViewById(2131442858);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      if (this.this$0.t == 2)
      {
        localLayoutParams.topMargin = 0;
        localLayoutParams.bottomMargin = 0;
      }
      else if (this.this$0.t == 5)
      {
        localLayoutParams.topMargin += (i - j) / 2;
      }
      else
      {
        localLayoutParams.topMargin = 50;
      }
      if ("1103".equals(ThemeUtil.curThemeId)) {
        localView.setBackgroundDrawable(null);
      }
      localView.setLayoutParams(localLayoutParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.7
 * JD-Core Version:    0.7.0.1
 */