package com.tencent.ilive.audiencepages.room.bizmodule;

import com.tencent.ilivesdk.avplayerbuilderservice_interface.AVPlayerBuilderServiceInterface;
import com.tencent.livesdk.accountengine.UserInitStateCallback;

class AVPreloadPlayerModule$1
  implements UserInitStateCallback
{
  AVPreloadPlayerModule$1(AVPreloadPlayerModule paramAVPreloadPlayerModule) {}
  
  public void onAvInitFail()
  {
    AVPreloadPlayerModule.a(this.a).onLoginEvent(4, "");
    AVPreloadPlayerModule.a(this.a, "播放器初始化失败");
  }
  
  public void onAvInitSucceed()
  {
    AVPreloadPlayerModule.a(this.a).onLoginEvent(3, "");
  }
  
  public void onLoginFail(int paramInt)
  {
    AVPreloadPlayerModule.a(this.a).onLoginEvent(2, "");
  }
  
  public void onLoginSucceed()
  {
    AVPreloadPlayerModule.a(this.a).onLoginEvent(1, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.bizmodule.AVPreloadPlayerModule.1
 * JD-Core Version:    0.7.0.1
 */