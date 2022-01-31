package com.tencent.gamecenter.common.util;

import yez;
import yfn;
import yfp;

public class ScreenshotManager$2
  implements Runnable
{
  public ScreenshotManager$2(yfn paramyfn, String paramString, yfp paramyfp) {}
  
  public void run()
  {
    if (this.this$0.a(yfn.a(this.this$0), this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Yfp.a(0, "succ");
      yez.a("gamecenter_shot_key", this.jdField_a_of_type_JavaLangString);
      return;
    }
    this.jdField_a_of_type_Yfp.a(-200, "save file fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.ScreenshotManager.2
 * JD-Core Version:    0.7.0.1
 */