package com.tencent.mobileqq.activity.aio.item;

import aduy;
import ayoi;
import com.tencent.image.URLDrawable;

public class MixedMsgItemBuilder$2
  implements Runnable
{
  public MixedMsgItemBuilder$2(aduy paramaduy, String paramString, URLDrawable paramURLDrawable) {}
  
  public void run()
  {
    if (ayoi.b(this.jdField_a_of_type_JavaLangString)) {}
    try
    {
      this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MixedMsgItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */