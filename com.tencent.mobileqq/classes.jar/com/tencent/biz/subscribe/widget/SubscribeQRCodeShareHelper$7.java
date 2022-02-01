package com.tencent.biz.subscribe.widget;

import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;

class SubscribeQRCodeShareHelper$7
  implements Runnable
{
  SubscribeQRCodeShareHelper$7(SubscribeQRCodeShareHelper paramSubscribeQRCodeShareHelper) {}
  
  public void run()
  {
    if (SubscribeQRCodeShareHelper.k(this.this$0))
    {
      Object localObject = this.this$0;
      localObject = SubscribeQRCodeShareHelper.a((SubscribeQRCodeShareHelper)localObject, SubscribeQRCodeShareHelper.a((SubscribeQRCodeShareHelper)localObject));
      QZoneHelper.forwardToPublishMood(SubscribeQRCodeShareHelper.c(this.this$0), QZoneHelper.UserInfo.getInstance(), (String)localObject, "写说说", SubscribeShareHelper.a(SubscribeQRCodeShareHelper.f(this.this$0)), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.7
 * JD-Core Version:    0.7.0.1
 */