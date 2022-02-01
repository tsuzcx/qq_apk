package com.etrump.mixlayout;

import anyw;
import bhkt;
import com.tencent.qphone.base.util.QLog;
import gc;

public class FontManager$8
  implements Runnable
{
  public FontManager$8(gc paramgc, anyw paramanyw, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Anyw.a(this.jdField_a_of_type_JavaLangString) == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("tag.vasFont.enlarge", 2, "enableEnlargeFontEffect --> extensionInfo is null.");
      }
      bhkt.a(this.jdField_a_of_type_JavaLangString);
      bhkt.a(this.this$0.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.etrump.mixlayout.FontManager.8
 * JD-Core Version:    0.7.0.1
 */