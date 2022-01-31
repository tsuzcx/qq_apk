package com.tencent.biz.subscribe.widget;

import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import awmc;
import bahv;
import bjeh;
import wfw;

public class SubscribeQRCodeShareHelper$2
  implements Runnable
{
  public SubscribeQRCodeShareHelper$2(wfw paramwfw, SubscribeSharedCardView paramSubscribeSharedCardView) {}
  
  public void run()
  {
    int j = this.this$0.a.a.getHeight();
    int k = this.this$0.a.b.getHeight();
    if (!awmc.a(wfw.a(this.this$0))) {}
    for (int i = awmc.c(wfw.a(this.this$0));; i = awmc.b)
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, i - bjeh.a(wfw.a(this.this$0)) - (k + j));
      this.this$0.a.d(Color.parseColor("#00000000"));
      this.this$0.a.a(this.a, localLayoutParams);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.2
 * JD-Core Version:    0.7.0.1
 */