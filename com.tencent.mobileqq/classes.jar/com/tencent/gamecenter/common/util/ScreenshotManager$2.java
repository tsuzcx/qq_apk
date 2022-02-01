package com.tencent.gamecenter.common.util;

import com.tencent.gamecenter.wadl.util.GameCenterSpUtils;

class ScreenshotManager$2
  implements Runnable
{
  ScreenshotManager$2(ScreenshotManager paramScreenshotManager, String paramString, ScreenshotManager.ShotCallback paramShotCallback) {}
  
  public void run()
  {
    if (this.this$0.a(ScreenshotManager.a(this.this$0), this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentGamecenterCommonUtilScreenshotManager$ShotCallback.a(0, "succ");
      GameCenterSpUtils.a("gamecenter_shot_key", this.jdField_a_of_type_JavaLangString);
      return;
    }
    this.jdField_a_of_type_ComTencentGamecenterCommonUtilScreenshotManager$ShotCallback.a(-200, "save file fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.ScreenshotManager.2
 * JD-Core Version:    0.7.0.1
 */