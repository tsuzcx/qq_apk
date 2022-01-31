package com.tencent.biz.pubaccount;

import bdgk;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketPopupView;
import com.tencent.qqmini.sdk.utils.LiuHaiUtils;
import com.tencent.widget.FadeIconImageView;
import xin;

class PublicAccountBrowser$7$1
  implements Runnable
{
  PublicAccountBrowser$7$1(PublicAccountBrowser.7 param7) {}
  
  public void run()
  {
    long l1 = bdgk.k();
    long l2 = PublicAccountBrowser.b(this.a.this$0).getWidth();
    long l3 = xin.b(this.a.this$0, 10.0F);
    int i = PublicAccountBrowser.a(this.a.this$0).getHeight();
    int j = xin.b(this.a.this$0, 15.0F);
    int k = LiuHaiUtils.getStatusBarHeight(this.a.this$0);
    PublicAccountBrowser.a(this.a.this$0, PublicAccountBrowser.b(this.a.this$0), (int)(l1 - l2 - l3), i + j + k, true, true, RIJRedPacketManager.a().c(), RIJRedPacketManager.a().h());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountBrowser.7.1
 * JD-Core Version:    0.7.0.1
 */