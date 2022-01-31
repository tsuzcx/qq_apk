package com.tencent.gamecenter.common.util;

import yod;
import yor;
import yot;

public class ScreenshotManager$2
  implements Runnable
{
  public ScreenshotManager$2(yor paramyor, String paramString, yot paramyot) {}
  
  public void run()
  {
    if (this.this$0.a(yor.a(this.this$0), this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Yot.a(0, "succ");
      yod.a("gamecenter_shot_key", this.jdField_a_of_type_JavaLangString);
      return;
    }
    this.jdField_a_of_type_Yot.a(-200, "save file fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.ScreenshotManager.2
 * JD-Core Version:    0.7.0.1
 */