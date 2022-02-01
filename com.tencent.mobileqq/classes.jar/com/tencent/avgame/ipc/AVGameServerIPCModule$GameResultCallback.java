package com.tencent.avgame.ipc;

import com.tencent.avgame.gameresult.GameResultUploadMgrForRemote.GameResultUploadCallback;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class AVGameServerIPCModule$GameResultCallback
  implements GameResultUploadMgrForRemote.GameResultUploadCallback
{
  final WeakReference<AVGameServerIPCModule> a;
  
  AVGameServerIPCModule$GameResultCallback(AVGameServerIPCModule paramAVGameServerIPCModule)
  {
    this.a = new WeakReference(paramAVGameServerIPCModule);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVGameServerIPCModule_GameRC", 2, "GameResultCallback onReslut, playId[" + paramString1 + "], fileType[" + paramInt + "], url[" + paramString2 + "]");
    }
    AVGameServerIPCModule localAVGameServerIPCModule = (AVGameServerIPCModule)this.a.get();
    if (localAVGameServerIPCModule == null) {
      return;
    }
    localAVGameServerIPCModule.a(true, paramString1, paramInt, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.ipc.AVGameServerIPCModule.GameResultCallback
 * JD-Core Version:    0.7.0.1
 */