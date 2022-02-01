package com.tencent.mobileqq.activity.aio.item;

import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.transfile.AbsDownloader;

public final class ReplyTextItemBuilder$12
  implements Runnable
{
  public ReplyTextItemBuilder$12(String paramString, URLDrawable paramURLDrawable) {}
  
  public void run()
  {
    if ((AbsDownloader.hasFile(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() != 1)) {}
    try
    {
      this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder.12
 * JD-Core Version:    0.7.0.1
 */