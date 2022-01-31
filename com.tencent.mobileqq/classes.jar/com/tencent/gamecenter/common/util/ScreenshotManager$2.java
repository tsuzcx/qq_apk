package com.tencent.gamecenter.common.util;

import yoa;
import yoo;
import yoq;

public class ScreenshotManager$2
  implements Runnable
{
  public ScreenshotManager$2(yoo paramyoo, String paramString, yoq paramyoq) {}
  
  public void run()
  {
    if (this.this$0.a(yoo.a(this.this$0), this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Yoq.a(0, "succ");
      yoa.a("gamecenter_shot_key", this.jdField_a_of_type_JavaLangString);
      return;
    }
    this.jdField_a_of_type_Yoq.a(-200, "save file fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.ScreenshotManager.2
 * JD-Core Version:    0.7.0.1
 */