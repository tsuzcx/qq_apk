package com.tencent.avgame.ipc;

import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.util.WeakReference;

class AVGameServerIPCModule$MyFriendListObserver
  extends FriendListObserver
{
  private final WeakReference<AVGameServerIPCModule> a;
  private final WeakReference<QQAppInterface> b;
  
  public AVGameServerIPCModule$MyFriendListObserver(AVGameServerIPCModule paramAVGameServerIPCModule, QQAppInterface paramQQAppInterface)
  {
    this.a = new WeakReference(paramAVGameServerIPCModule);
    this.b = new WeakReference(paramQQAppInterface);
  }
  
  public void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    AVGameServerIPCModule localAVGameServerIPCModule = (AVGameServerIPCModule)this.a.get();
    QQAppInterface localQQAppInterface = (QQAppInterface)this.b.get();
    if ((paramBoolean) && (localAVGameServerIPCModule != null) && (AVGameServerIPCModule.a(localAVGameServerIPCModule, paramString, 1))) {
      localAVGameServerIPCModule.a(0, paramString, AVGameServerIPCModule.a(localAVGameServerIPCModule, 0, paramString, localQQAppInterface));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.ipc.AVGameServerIPCModule.MyFriendListObserver
 * JD-Core Version:    0.7.0.1
 */