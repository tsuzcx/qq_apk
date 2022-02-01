package com.tencent.mobileqq.activity.specialcare;

import com.tencent.mobileqq.activity.specialcare.api.IQvipSpecialSoundManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasDepTemp;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.util.WeakReference;

public class SyncDownloadRunnable
  implements Runnable
{
  public int a;
  private DownloadTask b;
  private File c;
  private String d;
  private WeakReference<IQvipSpecialSoundManager> e;
  
  public SyncDownloadRunnable(DownloadTask paramDownloadTask, File paramFile, String paramString, IQvipSpecialSoundManager paramIQvipSpecialSoundManager)
  {
    this.b = paramDownloadTask;
    this.c = paramFile;
    this.d = paramString;
    this.a = -1;
    this.e = new WeakReference(paramIQvipSpecialSoundManager);
  }
  
  public void run()
  {
    this.a = ((IVasDepTemp)QRoute.api(IVasDepTemp.class)).specialSoundDownload(this.b);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[SyncDownloadRunnable]:resultCode=");
      ((StringBuilder)localObject).append(this.a);
      QLog.d("SyncDownloadRunnable", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.e;
    if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
      ((IQvipSpecialSoundManager)this.e.get()).onSpecialSoundConfigDownloaded(this.a, this.c, this.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.SyncDownloadRunnable
 * JD-Core Version:    0.7.0.1
 */