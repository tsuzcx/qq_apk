package com.tencent.mobileqq.activity.aio.item;

import ahbp;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.transfile.AbsDownloader;

public class MixedMsgItemBuilder$2
  implements Runnable
{
  public MixedMsgItemBuilder$2(ahbp paramahbp, String paramString, URLDrawable paramURLDrawable) {}
  
  public void run()
  {
    if (AbsDownloader.hasFile(this.jdField_a_of_type_JavaLangString)) {}
    try
    {
      this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MixedMsgItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */