package com.tencent.mobileqq.activity.aio.item;

import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.transfile.AbsDownloader;

class MixedMsgItemBuilder$2
  implements Runnable
{
  MixedMsgItemBuilder$2(MixedMsgItemBuilder paramMixedMsgItemBuilder, String paramString, URLDrawable paramURLDrawable) {}
  
  public void run()
  {
    if (AbsDownloader.hasFile(this.a)) {}
    try
    {
      this.b.startDownload();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MixedMsgItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */