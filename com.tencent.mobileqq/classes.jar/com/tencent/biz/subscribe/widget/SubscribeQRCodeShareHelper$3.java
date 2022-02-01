package com.tencent.biz.subscribe.widget;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.util.LiuHaiUtils;

class SubscribeQRCodeShareHelper$3
  implements Runnable
{
  SubscribeQRCodeShareHelper$3(SubscribeQRCodeShareHelper paramSubscribeQRCodeShareHelper, AbsSubscribeShareCardView paramAbsSubscribeShareCardView) {}
  
  public void run()
  {
    SubscribeQRCodeShareHelper.a(this.this$0, false);
    int j = SubscribeQRCodeShareHelper.g(this.this$0).getActionSheetPanelViewHeight();
    int i;
    if (!ScreenUtil.checkDeviceHasNavigationBar(SubscribeQRCodeShareHelper.c(this.this$0))) {
      i = ScreenUtil.getRealHeight(SubscribeQRCodeShareHelper.c(this.this$0));
    } else {
      i = ScreenUtil.SCREEN_HIGHT;
    }
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, i - LiuHaiUtils.b(SubscribeQRCodeShareHelper.c(this.this$0)) - j);
    SubscribeQRCodeShareHelper.g(this.this$0).setAdvBgColor(0);
    RelativeLayout localRelativeLayout = new RelativeLayout(SubscribeQRCodeShareHelper.c(this.this$0));
    localRelativeLayout.setLayoutParams(localLayoutParams1);
    localRelativeLayout.setBackgroundColor(0);
    localRelativeLayout.setOnClickListener(new SubscribeQRCodeShareHelper.3.1(this));
    ImageView localImageView = new ImageView(SubscribeQRCodeShareHelper.c(this.this$0));
    localImageView.setOnClickListener(new SubscribeQRCodeShareHelper.3.2(this));
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(ScreenUtil.dip2px(225.0F), ScreenUtil.dip2px(420.0F));
    localLayoutParams2.addRule(13);
    localRelativeLayout.addView(localImageView, localLayoutParams2);
    localImageView.setImageBitmap(this.a.getSharedBitmap());
    SubscribeQRCodeShareHelper.g(this.this$0).setAdvView(localRelativeLayout, localLayoutParams1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.3
 * JD-Core Version:    0.7.0.1
 */