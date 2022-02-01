package com.tencent.gamecenter.common.util;

import acik;
import aciy;
import acja;

public class ScreenshotManager$2
  implements Runnable
{
  public ScreenshotManager$2(aciy paramaciy, String paramString, acja paramacja) {}
  
  public void run()
  {
    if (this.this$0.a(aciy.a(this.this$0), this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Acja.a(0, "succ");
      acik.a("gamecenter_shot_key", this.jdField_a_of_type_JavaLangString);
      return;
    }
    this.jdField_a_of_type_Acja.a(-200, "save file fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.ScreenshotManager.2
 * JD-Core Version:    0.7.0.1
 */