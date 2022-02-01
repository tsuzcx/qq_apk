package com.tencent.gamecenter.common.util;

import com.tencent.gamecenter.wadl.util.GameCenterSpUtils;

class ScreenshotManager$2
  implements Runnable
{
  ScreenshotManager$2(ScreenshotManager paramScreenshotManager, String paramString, ScreenshotManager.ShotCallback paramShotCallback) {}
  
  public void run()
  {
    ScreenshotManager localScreenshotManager = this.this$0;
    if (localScreenshotManager.a(ScreenshotManager.a(localScreenshotManager), this.a))
    {
      this.b.a(0, "succ");
      GameCenterSpUtils.b("gamecenter_shot_key", this.a);
      return;
    }
    this.b.a(-200, "save file fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.ScreenshotManager.2
 * JD-Core Version:    0.7.0.1
 */