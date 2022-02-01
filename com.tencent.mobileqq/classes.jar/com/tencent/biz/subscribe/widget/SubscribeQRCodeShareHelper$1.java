package com.tencent.biz.subscribe.widget;

import com.tencent.mobileqq.utils.FileUtils;

class SubscribeQRCodeShareHelper$1
  implements Runnable
{
  SubscribeQRCodeShareHelper$1(SubscribeQRCodeShareHelper paramSubscribeQRCodeShareHelper) {}
  
  public void run()
  {
    FileUtils.delete(SubscribeQRCodeShareHelper.a(this.this$0), true);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(SubscribeQRCodeShareHelper.a(this.this$0));
    localStringBuilder.append(".nomedia");
    FileUtils.createFileIfNotExits(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.1
 * JD-Core Version:    0.7.0.1
 */