package com.tencent.avgame.ipc;

import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import mqq.util.WeakReference;

class AVGameServerIPCModule$MyAvatarObserver
  extends AvatarObserver
{
  private final WeakReference<AVGameServerIPCModule> a;
  
  public AVGameServerIPCModule$MyAvatarObserver(AVGameServerIPCModule paramAVGameServerIPCModule)
  {
    this.a = new WeakReference(paramAVGameServerIPCModule);
  }
  
  public void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    AVGameServerIPCModule localAVGameServerIPCModule = (AVGameServerIPCModule)this.a.get();
    if ((paramBoolean) && (localAVGameServerIPCModule != null) && (AVGameServerIPCModule.a(localAVGameServerIPCModule, paramString, 0))) {
      localAVGameServerIPCModule.a(1, paramString, 200);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.ipc.AVGameServerIPCModule.MyAvatarObserver
 * JD-Core Version:    0.7.0.1
 */