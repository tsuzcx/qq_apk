package com.tencent.mobileqq.activity.aio.item;

import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.transfile.AbsDownloader;

final class ReplyTextItemBuilder$12
  implements Runnable
{
  ReplyTextItemBuilder$12(String paramString, URLDrawable paramURLDrawable) {}
  
  public void run()
  {
    if ((AbsDownloader.hasFile(this.a)) && (this.b.getStatus() != 1)) {}
    try
    {
      this.b.startDownload();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder.12
 * JD-Core Version:    0.7.0.1
 */