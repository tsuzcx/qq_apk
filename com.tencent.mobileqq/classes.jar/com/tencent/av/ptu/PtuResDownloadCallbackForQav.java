package com.tencent.av.ptu;

import android.content.Intent;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEDownloadCallBack;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class PtuResDownloadCallbackForQav
  implements IAEDownloadCallBack
{
  final WeakReference<QQAppInterface> a;
  
  public PtuResDownloadCallbackForQav(QQAppInterface paramQQAppInterface)
  {
    this.a = new WeakReference(paramQQAppInterface);
  }
  
  public void onAEDownloadFinish(AEResInfo paramAEResInfo, String paramString, boolean paramBoolean, int paramInt)
  {
    if (paramAEResInfo == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("onAEResDownloadResult, package[");
      paramString.append(paramAEResInfo.index);
      paramString.append(", isDownloaded[");
      paramString.append(paramBoolean);
      paramString.append("], errorType[");
      paramString.append(paramInt);
      paramString.append("]");
      QLog.i("PtuResChecker", 2, paramString.toString());
    }
    paramString = (QQAppInterface)this.a.get();
    if ((paramString != null) && (paramString.isVideoChatting()))
    {
      Intent localIntent = new Intent("tencent.video.q2v.ptusoDownloadRet");
      localIntent.putExtra("packageIdx", paramAEResInfo.index);
      localIntent.putExtra("isDownloaded", paramBoolean);
      localIntent.putExtra("errorType", paramInt);
      paramString.getApp().sendBroadcast(localIntent);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramAEResInfo = new StringBuilder();
      paramAEResInfo.append("onAEDownloadFinish, no need notify video, app[");
      paramAEResInfo.append(paramString);
      paramAEResInfo.append("]");
      QLog.i("PtuResChecker", 2, paramAEResInfo.toString());
    }
  }
  
  public void onAEProgressUpdate(AEResInfo paramAEResInfo, long paramLong1, long paramLong2)
  {
    if ((QLog.isDevelopLevel()) && ((paramLong1 == 0L) || (paramLong2 == paramLong1)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAEProgressUpdate, package[");
      if (paramAEResInfo == null) {
        paramAEResInfo = "null";
      } else {
        paramAEResInfo = Integer.valueOf(paramAEResInfo.index);
      }
      localStringBuilder.append(paramAEResInfo);
      localStringBuilder.append("]");
      QLog.i("PtuResChecker", 4, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ptu.PtuResDownloadCallbackForQav
 * JD-Core Version:    0.7.0.1
 */