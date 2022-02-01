package com.tencent.avgame.ipc;

import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.download.AEResInfo;
import dov.com.qq.im.ae.download.AEResManager.AEDownloadCallBack;
import mqq.util.WeakReference;

class AVGameServerIPCModule$PtvSoLoadCallback
  implements AEResManager.AEDownloadCallBack
{
  final WeakReference<AVGameServerIPCModule> a;
  
  AVGameServerIPCModule$PtvSoLoadCallback(AVGameServerIPCModule paramAVGameServerIPCModule)
  {
    this.a = new WeakReference(paramAVGameServerIPCModule);
  }
  
  public void onAEDownloadFinish(AEResInfo paramAEResInfo, String paramString, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVGameServerIPCModule", 2, "onAEResDownloadResult, package[" + paramAEResInfo.a + "], isDownloaded[" + paramBoolean + "], errorType[" + paramInt + "]");
    }
    paramAEResInfo = (AVGameServerIPCModule)this.a.get();
    if (paramAEResInfo != null) {
      paramAEResInfo.a(1, paramBoolean, paramString);
    }
  }
  
  public void onAEProgressUpdate(AEResInfo paramAEResInfo, long paramLong1, long paramLong2)
  {
    if (QLog.isDevelopLevel())
    {
      float f = 0.0F;
      if (paramLong2 != 0L) {
        f = (float)paramLong1 / (float)paramLong2;
      }
      QLog.i("AVGameServerIPCModule", 4, "onAEProgressUpdate, [" + f + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.ipc.AVGameServerIPCModule.PtvSoLoadCallback
 * JD-Core Version:    0.7.0.1
 */