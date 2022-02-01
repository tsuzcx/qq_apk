package com.qq.wx.voice.embedqqegg.util;

import android.util.Log;

public class LogTool
{
  public static boolean isShow = false;
  
  public static void d(int paramInt)
  {
    if (isShow) {
      Log.d("WXVoiceDebug", String.valueOf(paramInt));
    }
  }
  
  public static void d(String paramString)
  {
    if (isShow) {
      Log.d("WXVoiceDebug", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.qq.wx.voice.embedqqegg.util.LogTool
 * JD-Core Version:    0.7.0.1
 */