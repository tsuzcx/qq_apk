package com.tencent.biz.subscribe.widget;

import aaou;
import aaow;
import aaox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import bdep;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;

public class SubscribeQRCodeShareHelper$3
  implements Runnable
{
  public SubscribeQRCodeShareHelper$3(aaou paramaaou, AbsSubscribeShareCardView paramAbsSubscribeShareCardView) {}
  
  public void run()
  {
    aaou.a(this.this$0, false);
    int j = aaou.a(this.this$0).getActionSheetPanelViewHeight();
    if (!bdep.a(aaou.a(this.this$0))) {}
    for (int i = bdep.c(aaou.a(this.this$0));; i = bdep.b)
    {
      RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, i - LiuHaiUtils.a(aaou.a(this.this$0)) - j);
      aaou.a(this.this$0).setAdvBgColor(0);
      RelativeLayout localRelativeLayout = new RelativeLayout(aaou.a(this.this$0));
      localRelativeLayout.setLayoutParams(localLayoutParams1);
      localRelativeLayout.setBackgroundColor(0);
      localRelativeLayout.setOnClickListener(new aaow(this));
      ImageView localImageView = new ImageView(aaou.a(this.this$0));
      localImageView.setOnClickListener(new aaox(this));
      RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(bdep.a(225.0F), bdep.a(420.0F));
      localLayoutParams2.addRule(13);
      localRelativeLayout.addView(localImageView, localLayoutParams2);
      localImageView.setImageBitmap(this.a.a());
      aaou.a(this.this$0).setAdvView(localRelativeLayout, localLayoutParams1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.3
 * JD-Core Version:    0.7.0.1
 */