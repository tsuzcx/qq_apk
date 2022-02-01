package com.etrump.mixlayout;

import bhiw;
import com.tencent.qphone.base.util.QLog;
import gb;
import java.util.concurrent.ConcurrentHashMap;

public class FontManager$10
  implements Runnable
{
  public FontManager$10(gb paramgb, String paramString, int paramInt) {}
  
  public void run()
  {
    if (gb.a(this.this$0).containsKey(this.jdField_a_of_type_JavaLangString))
    {
      ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)gb.a(this.this$0).get(this.jdField_a_of_type_JavaLangString);
      if (localConcurrentHashMap.containsKey(Integer.valueOf(this.jdField_a_of_type_Int)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VasFont", 2, "updateDiyConfig uin = " + this.jdField_a_of_type_JavaLangString + " fontId = " + this.jdField_a_of_type_Int);
        }
        localConcurrentHashMap.remove(Integer.valueOf(this.jdField_a_of_type_Int));
        bhiw.a(this.this$0.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.etrump.mixlayout.FontManager.10
 * JD-Core Version:    0.7.0.1
 */