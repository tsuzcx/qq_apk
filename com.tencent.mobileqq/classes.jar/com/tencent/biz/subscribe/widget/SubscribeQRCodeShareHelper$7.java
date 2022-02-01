package com.tencent.biz.subscribe.widget;

import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import zlp;
import zlv;

public class SubscribeQRCodeShareHelper$7
  implements Runnable
{
  public SubscribeQRCodeShareHelper$7(zlp paramzlp) {}
  
  public void run()
  {
    if (zlp.a(this.this$0))
    {
      String str = zlp.a(this.this$0, zlp.a(this.this$0));
      QZoneHelper.forwardToPublishMood(zlp.a(this.this$0), QZoneHelper.UserInfo.getInstance(), str, "写说说", zlv.a(zlp.a(this.this$0)), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.7
 * JD-Core Version:    0.7.0.1
 */