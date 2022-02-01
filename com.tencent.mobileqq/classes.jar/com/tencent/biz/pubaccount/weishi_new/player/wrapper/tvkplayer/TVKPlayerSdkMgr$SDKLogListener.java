package com.tencent.biz.pubaccount.weishi_new.player.wrapper.tvkplayer;

import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.OnLogListener;

class TVKPlayerSdkMgr$SDKLogListener
  implements TVK_SDKMgr.OnLogListener
{
  public int d(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      WSLog.b("WS_PLAYER_SDK_" + paramString1, 2, paramString2);
    }
    return 0;
  }
  
  public int e(String paramString1, String paramString2)
  {
    WSLog.d("WS_PLAYER_SDK_" + paramString1, 1, paramString2);
    return 0;
  }
  
  public int i(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      WSLog.a("WS_PLAYER_SDK_" + paramString1, 2, paramString2);
    }
    return 0;
  }
  
  public int v(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      WSLog.b("WS_PLAYER_SDK_" + paramString1, 2, paramString2);
    }
    return 0;
  }
  
  public int w(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      WSLog.c("WS_PLAYER_SDK_" + paramString1, 2, paramString2);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.wrapper.tvkplayer.TVKPlayerSdkMgr.SDKLogListener
 * JD-Core Version:    0.7.0.1
 */