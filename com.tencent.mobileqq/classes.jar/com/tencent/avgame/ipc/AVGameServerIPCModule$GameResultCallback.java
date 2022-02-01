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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("GameResultCallback onReslut, playId[");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("], fileType[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("], url[");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("]");
      QLog.i("AVGameServerIPCModule_GameRC", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (AVGameServerIPCModule)this.a.get();
    if (localObject == null) {
      return;
    }
    ((AVGameServerIPCModule)localObject).a(true, paramString1, paramInt, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ipc.AVGameServerIPCModule.GameResultCallback
 * JD-Core Version:    0.7.0.1
 */