package com.tencent.biz.subscribe.widget;

import aaau;
import aaba;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;

public class SubscribeQRCodeShareHelper$7
  implements Runnable
{
  public SubscribeQRCodeShareHelper$7(aaau paramaaau) {}
  
  public void run()
  {
    if (aaau.a(this.this$0))
    {
      String str = aaau.a(this.this$0, aaau.a(this.this$0));
      QZoneHelper.forwardToPublishMood(aaau.a(this.this$0), QZoneHelper.UserInfo.getInstance(), str, "写说说", aaba.a(aaau.a(this.this$0)), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.7
 * JD-Core Version:    0.7.0.1
 */