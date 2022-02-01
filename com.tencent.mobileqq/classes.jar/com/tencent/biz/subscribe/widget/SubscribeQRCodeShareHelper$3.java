package com.tencent.biz.subscribe.widget;

import aakt;
import aakv;
import aakw;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import bclx;
import bqcd;
import com.tencent.mobileqq.widget.share.ShareActionSheet;

public class SubscribeQRCodeShareHelper$3
  implements Runnable
{
  public SubscribeQRCodeShareHelper$3(aakt paramaakt, AbsSubscribeShareCardView paramAbsSubscribeShareCardView) {}
  
  public void run()
  {
    aakt.a(this.this$0, false);
    int j = aakt.a(this.this$0).getActionSheetPanelViewHeight();
    if (!bclx.a(aakt.a(this.this$0))) {}
    for (int i = bclx.c(aakt.a(this.this$0));; i = bclx.b)
    {
      RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, i - bqcd.a(aakt.a(this.this$0)) - j);
      aakt.a(this.this$0).setAdvBgColor(0);
      RelativeLayout localRelativeLayout = new RelativeLayout(aakt.a(this.this$0));
      localRelativeLayout.setLayoutParams(localLayoutParams1);
      localRelativeLayout.setBackgroundColor(0);
      localRelativeLayout.setOnClickListener(new aakv(this));
      ImageView localImageView = new ImageView(aakt.a(this.this$0));
      localImageView.setOnClickListener(new aakw(this));
      RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(bclx.a(225.0F), bclx.a(420.0F));
      localLayoutParams2.addRule(13);
      localRelativeLayout.addView(localImageView, localLayoutParams2);
      localImageView.setImageBitmap(this.a.a());
      aakt.a(this.this$0).setAdvView(localRelativeLayout, localLayoutParams1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.3
 * JD-Core Version:    0.7.0.1
 */