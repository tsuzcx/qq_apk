package com.tencent.av.ptu;

import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.download.AEResInfo;
import dov.com.qq.im.ae.download.AEResManager.AEDownloadCallBack;
import java.lang.ref.WeakReference;

public class PtuResDownloadCallbackForQav
  implements AEResManager.AEDownloadCallBack
{
  final WeakReference<QQAppInterface> a;
  
  public PtuResDownloadCallbackForQav(QQAppInterface paramQQAppInterface)
  {
    this.a = new WeakReference(paramQQAppInterface);
  }
  
  public void onAEDownloadFinish(AEResInfo paramAEResInfo, String paramString, boolean paramBoolean, int paramInt)
  {
    if (paramAEResInfo == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("PtuResChecker", 2, "onAEResDownloadResult, package[" + paramAEResInfo.a + ", isDownloaded[" + paramBoolean + "], errorType[" + paramInt + "]");
      }
      paramString = (QQAppInterface)this.a.get();
      if ((paramString != null) && (paramString.isVideoChatting()))
      {
        Intent localIntent = new Intent("tencent.video.q2v.ptusoDownloadRet");
        localIntent.putExtra("packageIdx", paramAEResInfo.a);
        localIntent.putExtra("isDownloaded", paramBoolean);
        localIntent.putExtra("errorType", paramInt);
        paramString.getApp().sendBroadcast(localIntent);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.i("PtuResChecker", 2, "onAEDownloadFinish, no need notify video, app[" + paramString + "]");
  }
  
  public void onAEProgressUpdate(AEResInfo paramAEResInfo, long paramLong1, long paramLong2)
  {
    StringBuilder localStringBuilder;
    if ((QLog.isDevelopLevel()) && ((paramLong1 == 0L) || (paramLong2 == paramLong1)))
    {
      localStringBuilder = new StringBuilder().append("onAEProgressUpdate, package[");
      if (paramAEResInfo != null) {
        break label61;
      }
    }
    label61:
    for (paramAEResInfo = "null";; paramAEResInfo = Integer.valueOf(paramAEResInfo.a))
    {
      QLog.i("PtuResChecker", 4, paramAEResInfo + "]");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ptu.PtuResDownloadCallbackForQav
 * JD-Core Version:    0.7.0.1
 */