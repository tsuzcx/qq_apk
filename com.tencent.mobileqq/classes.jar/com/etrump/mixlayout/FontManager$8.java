package com.etrump.mixlayout;

import ajxn;
import bbby;
import com.tencent.qphone.base.util.QLog;
import ho;

public class FontManager$8
  implements Runnable
{
  public FontManager$8(ho paramho, ajxn paramajxn, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Ajxn.a(this.jdField_a_of_type_JavaLangString) == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("tag.vasFont.enlarge", 2, "enableEnlargeFontEffect --> extensionInfo is null.");
      }
      bbby.a(this.jdField_a_of_type_JavaLangString);
      bbby.a(this.this$0.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.etrump.mixlayout.FontManager.8
 * JD-Core Version:    0.7.0.1
 */