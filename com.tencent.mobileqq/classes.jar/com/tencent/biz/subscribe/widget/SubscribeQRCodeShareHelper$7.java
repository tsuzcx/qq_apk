package com.tencent.biz.subscribe.widget;

import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;

class SubscribeQRCodeShareHelper$7
  implements Runnable
{
  SubscribeQRCodeShareHelper$7(SubscribeQRCodeShareHelper paramSubscribeQRCodeShareHelper) {}
  
  public void run()
  {
    if (SubscribeQRCodeShareHelper.a(this.this$0))
    {
      String str = SubscribeQRCodeShareHelper.a(this.this$0, SubscribeQRCodeShareHelper.a(this.this$0));
      QZoneHelper.forwardToPublishMood(SubscribeQRCodeShareHelper.a(this.this$0), QZoneHelper.UserInfo.getInstance(), str, "写说说", SubscribeShareHelper.a(SubscribeQRCodeShareHelper.a(this.this$0)), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.7
 * JD-Core Version:    0.7.0.1
 */