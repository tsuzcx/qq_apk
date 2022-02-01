package com.tencent.biz.subscribe.widget;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import zlp;
import zlr;
import zls;

public class SubscribeQRCodeShareHelper$3
  implements Runnable
{
  public SubscribeQRCodeShareHelper$3(zlp paramzlp, AbsSubscribeShareCardView paramAbsSubscribeShareCardView) {}
  
  public void run()
  {
    zlp.a(this.this$0, false);
    int j = zlp.a(this.this$0).getActionSheetPanelViewHeight();
    if (!ScreenUtil.checkDeviceHasNavigationBar(zlp.a(this.this$0))) {}
    for (int i = ScreenUtil.getRealHeight(zlp.a(this.this$0));; i = ScreenUtil.SCREEN_HIGHT)
    {
      RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, i - LiuHaiUtils.a(zlp.a(this.this$0)) - j);
      zlp.a(this.this$0).setAdvBgColor(0);
      RelativeLayout localRelativeLayout = new RelativeLayout(zlp.a(this.this$0));
      localRelativeLayout.setLayoutParams(localLayoutParams1);
      localRelativeLayout.setBackgroundColor(0);
      localRelativeLayout.setOnClickListener(new zlr(this));
      ImageView localImageView = new ImageView(zlp.a(this.this$0));
      localImageView.setOnClickListener(new zls(this));
      RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(ScreenUtil.dip2px(225.0F), ScreenUtil.dip2px(420.0F));
      localLayoutParams2.addRule(13);
      localRelativeLayout.addView(localImageView, localLayoutParams2);
      localImageView.setImageBitmap(this.a.a());
      zlp.a(this.this$0).setAdvView(localRelativeLayout, localLayoutParams1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.3
 * JD-Core Version:    0.7.0.1
 */