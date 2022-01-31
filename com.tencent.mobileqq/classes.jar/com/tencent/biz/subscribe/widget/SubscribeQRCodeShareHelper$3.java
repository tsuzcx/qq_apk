package com.tencent.biz.subscribe.widget;

import android.graphics.Color;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import azgq;
import bngs;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import yjk;
import yjm;
import yjn;

public class SubscribeQRCodeShareHelper$3
  implements Runnable
{
  public SubscribeQRCodeShareHelper$3(yjk paramyjk, AbsSubscribeShareCardView paramAbsSubscribeShareCardView) {}
  
  public void run()
  {
    yjk.a(this.this$0, false);
    int j = this.this$0.a.a.getHeight();
    int k = this.this$0.a.b.getHeight();
    if (!azgq.a(yjk.a(this.this$0))) {}
    for (int i = azgq.c(yjk.a(this.this$0));; i = azgq.b)
    {
      RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, i - bngs.a(yjk.a(this.this$0)) - (k + j));
      this.this$0.a.setAdvBgColor(Color.parseColor("#00000000"));
      RelativeLayout localRelativeLayout = new RelativeLayout(yjk.a(this.this$0));
      localRelativeLayout.setLayoutParams(localLayoutParams1);
      localRelativeLayout.setBackgroundColor(0);
      localRelativeLayout.setOnClickListener(new yjm(this));
      ImageView localImageView = new ImageView(yjk.a(this.this$0));
      localImageView.setOnClickListener(new yjn(this));
      RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(azgq.a(225.0F), azgq.a(420.0F));
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