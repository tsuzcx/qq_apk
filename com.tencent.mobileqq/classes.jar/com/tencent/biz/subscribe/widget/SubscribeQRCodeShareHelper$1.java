package com.tencent.biz.subscribe.widget;

import aaau;
import com.tencent.mobileqq.utils.FileUtils;

public class SubscribeQRCodeShareHelper$1
  implements Runnable
{
  public SubscribeQRCodeShareHelper$1(aaau paramaaau) {}
  
  public void run()
  {
    FileUtils.delete(aaau.a(this.this$0), true);
    FileUtils.createFileIfNotExits(aaau.a(this.this$0) + ".nomedia");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.1
 * JD-Core Version:    0.7.0.1
 */