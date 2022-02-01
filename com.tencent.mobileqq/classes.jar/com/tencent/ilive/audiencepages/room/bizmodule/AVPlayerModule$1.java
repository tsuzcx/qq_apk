package com.tencent.ilive.audiencepages.room.bizmodule;

import com.tencent.ilivesdk.avplayerbuilderservice_interface.AVPlayerBuilderServiceInterface;
import com.tencent.livesdk.accountengine.UserInitStateCallback;

class AVPlayerModule$1
  implements UserInitStateCallback
{
  AVPlayerModule$1(AVPlayerModule paramAVPlayerModule) {}
  
  public void onAvInitFail()
  {
    AVPlayerModule.access$000(this.this$0).onLoginEvent(4, "");
    AVPlayerModule.access$100(this.this$0, "播放器初始化失败");
  }
  
  public void onAvInitSucceed()
  {
    AVPlayerModule.access$000(this.this$0).onLoginEvent(3, "");
  }
  
  public void onLoginFail(int paramInt)
  {
    AVPlayerModule.access$000(this.this$0).onLoginEvent(2, "");
  }
  
  public void onLoginSucceed()
  {
    AVPlayerModule.access$000(this.this$0).onLoginEvent(1, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.bizmodule.AVPlayerModule.1
 * JD-Core Version:    0.7.0.1
 */