package com.tencent.biz.subscribe.widget;

import aaau;
import aaaw;
import aaax;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;

public class SubscribeQRCodeShareHelper$3
  implements Runnable
{
  public SubscribeQRCodeShareHelper$3(aaau paramaaau, AbsSubscribeShareCardView paramAbsSubscribeShareCardView) {}
  
  public void run()
  {
    aaau.a(this.this$0, false);
    int j = aaau.a(this.this$0).getActionSheetPanelViewHeight();
    if (!ScreenUtil.checkDeviceHasNavigationBar(aaau.a(this.this$0))) {}
    for (int i = ScreenUtil.getRealHeight(aaau.a(this.this$0));; i = ScreenUtil.SCREEN_HIGHT)
    {
      RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, i - LiuHaiUtils.a(aaau.a(this.this$0)) - j);
      aaau.a(this.this$0).setAdvBgColor(0);
      RelativeLayout localRelativeLayout = new RelativeLayout(aaau.a(this.this$0));
      localRelativeLayout.setLayoutParams(localLayoutParams1);
      localRelativeLayout.setBackgroundColor(0);
      localRelativeLayout.setOnClickListener(new aaaw(this));
      ImageView localImageView = new ImageView(aaau.a(this.this$0));
      localImageView.setOnClickListener(new aaax(this));
      RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(ScreenUtil.dip2px(225.0F), ScreenUtil.dip2px(420.0F));
      localLayoutParams2.addRule(13);
      localRelativeLayout.addView(localImageView, localLayoutParams2);
      localImageView.setImageBitmap(this.a.a());
      aaau.a(this.this$0).setAdvView(localRelativeLayout, localLayoutParams1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.3
 * JD-Core Version:    0.7.0.1
 */