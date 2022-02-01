package com.tencent.avgame.ipc;

import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEDownloadCallBack;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class AVGameServerIPCModule$PtvSoLoadCallback
  implements IAEDownloadCallBack
{
  final WeakReference<AVGameServerIPCModule> a;
  
  AVGameServerIPCModule$PtvSoLoadCallback(AVGameServerIPCModule paramAVGameServerIPCModule)
  {
    this.a = new WeakReference(paramAVGameServerIPCModule);
  }
  
  public void onAEDownloadFinish(AEResInfo paramAEResInfo, String paramString, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAEResDownloadResult, package[");
      localStringBuilder.append(paramAEResInfo.index);
      localStringBuilder.append("], isDownloaded[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], errorType[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.i("AVGameServerIPCModule", 2, localStringBuilder.toString());
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
      paramAEResInfo = new StringBuilder();
      paramAEResInfo.append("onAEProgressUpdate, [");
      paramAEResInfo.append(f);
      paramAEResInfo.append("]");
      QLog.i("AVGameServerIPCModule", 4, paramAEResInfo.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ipc.AVGameServerIPCModule.PtvSoLoadCallback
 * JD-Core Version:    0.7.0.1
 */