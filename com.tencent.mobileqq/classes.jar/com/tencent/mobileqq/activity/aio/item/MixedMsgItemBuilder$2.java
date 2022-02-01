package com.tencent.mobileqq.activity.aio.item;

import ahda;
import bdsh;
import com.tencent.image.URLDrawable;

public class MixedMsgItemBuilder$2
  implements Runnable
{
  public MixedMsgItemBuilder$2(ahda paramahda, String paramString, URLDrawable paramURLDrawable) {}
  
  public void run()
  {
    if (bdsh.b(this.jdField_a_of_type_JavaLangString)) {}
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