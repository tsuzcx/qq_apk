package com.tencent.biz.subscribe.widget;

import android.graphics.Color;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import axlk;
import bbjq;
import bkvi;
import wur;
import wut;
import wuu;

public class SubscribeQRCodeShareHelper$3
  implements Runnable
{
  public SubscribeQRCodeShareHelper$3(wur paramwur, AbsSubscribeShareCardView paramAbsSubscribeShareCardView) {}
  
  public void run()
  {
    int j = this.this$0.a.a.getHeight();
    int k = this.this$0.a.b.getHeight();
    if (!axlk.a(wur.a(this.this$0))) {}
    for (int i = axlk.c(wur.a(this.this$0));; i = axlk.b)
    {
      RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, i - bkvi.a(wur.a(this.this$0)) - (k + j));
      this.this$0.a.d(Color.parseColor("#00000000"));
      RelativeLayout localRelativeLayout = new RelativeLayout(wur.a(this.this$0));
      localRelativeLayout.setLayoutParams(localLayoutParams1);
      localRelativeLayout.setBackgroundColor(0);
      localRelativeLayout.setOnClickListener(new wut(this));
      ImageView localImageView = new ImageView(wur.a(this.this$0));
      localImageView.setOnClickListener(new wuu(this));
      RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(axlk.a(225.0F), axlk.a(420.0F));
      localLayoutParams2.addRule(13);
      localRelativeLayout.addView(localImageView, localLayoutParams2);
      localImageView.setImageBitmap(this.a.a());
      this.this$0.a.a(localRelativeLayout, localLayoutParams1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.3
 * JD-Core Version:    0.7.0.1
 */