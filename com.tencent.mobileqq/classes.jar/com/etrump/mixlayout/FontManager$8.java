package com.etrump.mixlayout;

import alto;
import bdfp;
import com.tencent.qphone.base.util.QLog;
import fx;

public class FontManager$8
  implements Runnable
{
  public FontManager$8(fx paramfx, alto paramalto, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Alto.a(this.jdField_a_of_type_JavaLangString) == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("tag.vasFont.enlarge", 2, "enableEnlargeFontEffect --> extensionInfo is null.");
      }
      bdfp.a(this.jdField_a_of_type_JavaLangString);
      bdfp.a(this.this$0.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.etrump.mixlayout.FontManager.8
 * JD-Core Version:    0.7.0.1
 */