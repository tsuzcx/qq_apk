package com.tencent.biz.pubaccount.weishi_new.player.wrapper.tvkplayer;

import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.OnLogListener;

class TVKPlayerSdkMgr$SDKLogListener
  implements TVK_SDKMgr.OnLogListener
{
  public int d(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("WS_PLAYER_SDK_");
      localStringBuilder.append(paramString1);
      WSLog.b(localStringBuilder.toString(), 2, paramString2);
    }
    return 0;
  }
  
  public int e(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WS_PLAYER_SDK_");
    localStringBuilder.append(paramString1);
    WSLog.d(localStringBuilder.toString(), 1, paramString2);
    return 0;
  }
  
  public int i(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("WS_PLAYER_SDK_");
      localStringBuilder.append(paramString1);
      WSLog.a(localStringBuilder.toString(), 2, paramString2);
    }
    return 0;
  }
  
  public int v(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("WS_PLAYER_SDK_");
      localStringBuilder.append(paramString1);
      WSLog.b(localStringBuilder.toString(), 2, paramString2);
    }
    return 0;
  }
  
  public int w(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("WS_PLAYER_SDK_");
      localStringBuilder.append(paramString1);
      WSLog.c(localStringBuilder.toString(), 2, paramString2);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.wrapper.tvkplayer.TVKPlayerSdkMgr.SDKLogListener
 * JD-Core Version:    0.7.0.1
 */