package com.tencent.gamecenter.common.util;

import abuf;
import abuv;
import abux;

public class ScreenshotManager$2
  implements Runnable
{
  public ScreenshotManager$2(abuv paramabuv, String paramString, abux paramabux) {}
  
  public void run()
  {
    if (this.this$0.a(abuv.a(this.this$0), this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Abux.a(0, "succ");
      abuf.a("gamecenter_shot_key", this.jdField_a_of_type_JavaLangString);
      return;
    }
    this.jdField_a_of_type_Abux.a(-200, "save file fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.ScreenshotManager.2
 * JD-Core Version:    0.7.0.1
 */