package com.etrump.mixlayout;

import aloz;
import bdbg;
import com.tencent.qphone.base.util.QLog;
import fx;

public class FontManager$8
  implements Runnable
{
  public FontManager$8(fx paramfx, aloz paramaloz, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Aloz.a(this.jdField_a_of_type_JavaLangString) == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("tag.vasFont.enlarge", 2, "enableEnlargeFontEffect --> extensionInfo is null.");
      }
      bdbg.a(this.jdField_a_of_type_JavaLangString);
      bdbg.a(this.this$0.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.etrump.mixlayout.FontManager.8
 * JD-Core Version:    0.7.0.1
 */