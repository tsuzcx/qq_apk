package com.tencent.biz.qqstory.playvideo.player;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.OnLogListener;

public class VideoViewFactory$TVKSDKOnLogListener
  implements TVK_SDKMgr.OnLogListener
{
  public int a = 0;
  
  public int d(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2);
    }
    return 0;
  }
  
  public int e(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.e(paramString1, 2, paramString2);
    }
    return 0;
  }
  
  public int i(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(paramString1, 2, paramString2);
    }
    return 0;
  }
  
  public int v(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2);
    }
    return 0;
  }
  
  public int w(String paramString1, String paramString2)
  {
    if ((paramString2 != null) && (paramString2.contains("INFO_TRY_AGAIN_LATER"))) {}
    try
    {
      this.a = Integer.parseInt(paramString2.substring(paramString2.lastIndexOf("=") + 1));
    }
    catch (Exception localException)
    {
      label35:
      break label35;
    }
    if (QLog.isColorLevel()) {
      QLog.w(paramString1, 2, paramString2);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.VideoViewFactory.TVKSDKOnLogListener
 * JD-Core Version:    0.7.0.1
 */