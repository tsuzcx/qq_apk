package com.tencent.gamecenter.common.util;

import aahi;
import aahx;
import aahz;

public class ScreenshotManager$2
  implements Runnable
{
  public ScreenshotManager$2(aahx paramaahx, String paramString, aahz paramaahz) {}
  
  public void run()
  {
    if (this.this$0.a(aahx.a(this.this$0), this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Aahz.a(0, "succ");
      aahi.a("gamecenter_shot_key", this.jdField_a_of_type_JavaLangString);
      return;
    }
    this.jdField_a_of_type_Aahz.a(-200, "save file fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.ScreenshotManager.2
 * JD-Core Version:    0.7.0.1
 */