package com.etrump.mixlayout;

import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class FontManager$10
  implements Runnable
{
  FontManager$10(FontManager paramFontManager, String paramString, int paramInt) {}
  
  public void run()
  {
    if (FontManager.a(this.this$0).containsKey(this.jdField_a_of_type_JavaLangString))
    {
      ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)FontManager.a(this.this$0).get(this.jdField_a_of_type_JavaLangString);
      if (localConcurrentHashMap.containsKey(Integer.valueOf(this.jdField_a_of_type_Int)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VasFont", 2, "updateDiyConfig uin = " + this.jdField_a_of_type_JavaLangString + " fontId = " + this.jdField_a_of_type_Int);
        }
        localConcurrentHashMap.remove(Integer.valueOf(this.jdField_a_of_type_Int));
        VasUtils.a(this.this$0.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.etrump.mixlayout.FontManager.10
 * JD-Core Version:    0.7.0.1
 */