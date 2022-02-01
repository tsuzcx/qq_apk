package com.etrump.mixlayout;

import amsw;
import bfua;
import com.tencent.qphone.base.util.QLog;
import gb;

public class FontManager$8
  implements Runnable
{
  public FontManager$8(gb paramgb, amsw paramamsw, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Amsw.a(this.jdField_a_of_type_JavaLangString) == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("tag.vasFont.enlarge", 2, "enableEnlargeFontEffect --> extensionInfo is null.");
      }
      bfua.a(this.jdField_a_of_type_JavaLangString);
      bfua.a(this.this$0.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.etrump.mixlayout.FontManager.8
 * JD-Core Version:    0.7.0.1
 */