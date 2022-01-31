package com.tencent.mobileqq.activity.aio.item;

import afwa;
import baqn;
import com.tencent.image.URLDrawable;

public class MixedMsgItemBuilder$2
  implements Runnable
{
  public MixedMsgItemBuilder$2(afwa paramafwa, String paramString, URLDrawable paramURLDrawable) {}
  
  public void run()
  {
    if (baqn.b(this.jdField_a_of_type_JavaLangString)) {}
    try
    {
      this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MixedMsgItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */