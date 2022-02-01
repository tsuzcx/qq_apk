package com.tencent.aelight.camera.aioeditor.capture.util;

import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import java.util.Random;

public class PasterUtil
{
  private static Random a = new Random();
  
  public static PasterUtil.Position a()
  {
    int i = ScreenUtil.SCREEN_WIDTH / 4;
    int j = a.nextInt(ScreenUtil.SCREEN_WIDTH / 2);
    int k = ScreenUtil.SCREEN_WIDTH / 4;
    int m = a.nextInt(ScreenUtil.SCREEN_WIDTH / 2);
    return new PasterUtil.Position(ScreenUtil.SCREEN_WIDTH / 2 + (i - j), (ScreenUtil.SCREEN_HIGHT - ScreenUtil.dip2px(249.0F)) / 2 + (k - m));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.util.PasterUtil
 * JD-Core Version:    0.7.0.1
 */