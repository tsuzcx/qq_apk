package com.tencent.biz.subscribe.widget;

import com.tencent.mobileqq.utils.FileUtils;
import zlp;

public class SubscribeQRCodeShareHelper$1
  implements Runnable
{
  public SubscribeQRCodeShareHelper$1(zlp paramzlp) {}
  
  public void run()
  {
    FileUtils.delete(zlp.a(this.this$0), true);
    FileUtils.createFileIfNotExits(zlp.a(this.this$0) + ".nomedia");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.1
 * JD-Core Version:    0.7.0.1
 */