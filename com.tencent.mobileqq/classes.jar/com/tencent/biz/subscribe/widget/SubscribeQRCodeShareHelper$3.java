package com.tencent.biz.subscribe.widget;

import android.graphics.Color;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import azkz;
import bnle;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import ynx;
import ynz;
import yoa;

public class SubscribeQRCodeShareHelper$3
  implements Runnable
{
  public SubscribeQRCodeShareHelper$3(ynx paramynx, AbsSubscribeShareCardView paramAbsSubscribeShareCardView) {}
  
  public void run()
  {
    ynx.a(this.this$0, false);
    int j = this.this$0.a.a.getHeight();
    int k = this.this$0.a.b.getHeight();
    if (!azkz.a(ynx.a(this.this$0))) {}
    for (int i = azkz.c(ynx.a(this.this$0));; i = azkz.b)
    {
      RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, i - bnle.a(ynx.a(this.this$0)) - (k + j));
      this.this$0.a.setAdvBgColor(Color.parseColor("#00000000"));
      RelativeLayout localRelativeLayout = new RelativeLayout(ynx.a(this.this$0));
      localRelativeLayout.setLayoutParams(localLayoutParams1);
      localRelativeLayout.setBackgroundColor(0);
      localRelativeLayout.setOnClickListener(new ynz(this));
      ImageView localImageView = new ImageView(ynx.a(this.this$0));
      localImageView.setOnClickListener(new yoa(this));
      RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(azkz.a(225.0F), azkz.a(420.0F));
      localLayoutParams2.addRule(13);
      localRelativeLayout.addView(localImageView, localLayoutParams2);
      localImageView.setImageBitmap(this.a.a());
      this.this$0.a.setAdvView(localRelativeLayout, localLayoutParams1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.3
 * JD-Core Version:    0.7.0.1
 */