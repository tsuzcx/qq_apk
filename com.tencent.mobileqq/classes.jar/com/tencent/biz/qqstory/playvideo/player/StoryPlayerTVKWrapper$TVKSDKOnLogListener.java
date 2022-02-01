package com.tencent.biz.qqstory.playvideo.player;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.OnLogListener;

public class StoryPlayerTVKWrapper$TVKSDKOnLogListener
  implements TVK_SDKMgr.OnLogListener
{
  public int d(String paramString1, String paramString2)
  {
    SLog.b(paramString1, paramString2);
    return 0;
  }
  
  public int e(String paramString1, String paramString2)
  {
    SLog.e(paramString1, paramString2);
    return 0;
  }
  
  public int i(String paramString1, String paramString2)
  {
    SLog.c(paramString1, paramString2);
    return 0;
  }
  
  public int v(String paramString1, String paramString2)
  {
    SLog.b(paramString1, paramString2);
    return 0;
  }
  
  public int w(String paramString1, String paramString2)
  {
    SLog.d(paramString1, paramString2);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.StoryPlayerTVKWrapper.TVKSDKOnLogListener
 * JD-Core Version:    0.7.0.1
 */