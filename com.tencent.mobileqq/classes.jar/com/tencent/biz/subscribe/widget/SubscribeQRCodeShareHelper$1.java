package com.tencent.biz.subscribe.widget;

import com.tencent.mobileqq.utils.FileUtils;

class SubscribeQRCodeShareHelper$1
  implements Runnable
{
  SubscribeQRCodeShareHelper$1(SubscribeQRCodeShareHelper paramSubscribeQRCodeShareHelper) {}
  
  public void run()
  {
    FileUtils.a(SubscribeQRCodeShareHelper.a(this.this$0), true);
    FileUtils.c(SubscribeQRCodeShareHelper.a(this.this$0) + ".nomedia");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.1
 * JD-Core Version:    0.7.0.1
 */