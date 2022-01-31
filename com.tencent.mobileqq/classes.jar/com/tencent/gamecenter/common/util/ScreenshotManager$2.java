package com.tencent.gamecenter.common.util;

import aact;
import aadi;
import aadk;

public class ScreenshotManager$2
  implements Runnable
{
  public ScreenshotManager$2(aadi paramaadi, String paramString, aadk paramaadk) {}
  
  public void run()
  {
    if (this.this$0.a(aadi.a(this.this$0), this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Aadk.a(0, "succ");
      aact.a("gamecenter_shot_key", this.jdField_a_of_type_JavaLangString);
      return;
    }
    this.jdField_a_of_type_Aadk.a(-200, "save file fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.ScreenshotManager.2
 * JD-Core Version:    0.7.0.1
 */