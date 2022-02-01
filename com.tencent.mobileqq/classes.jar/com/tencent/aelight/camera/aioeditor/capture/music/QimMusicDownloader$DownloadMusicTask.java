package com.tencent.aelight.camera.aioeditor.capture.music;

import android.os.SystemClock;
import com.tencent.aelight.camera.struct.editor.MusicDownloadListener;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.mobileqq.shortvideo.resource.SpecialAVFilterResource;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.SdkContext;
import java.io.File;

class QimMusicDownloader$DownloadMusicTask
  implements Runnable
{
  String a;
  String b;
  MusicDownloadListener c;
  
  public QimMusicDownloader$DownloadMusicTask(String paramString1, String paramString2, MusicDownloadListener paramMusicDownloadListener)
  {
    this.b = paramString1;
    this.a = paramString2;
    this.c = paramMusicDownloadListener;
  }
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("begin download ");
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(this.b);
      QLog.d("MusicProviderView.Downloader", 2, ((StringBuilder)localObject).toString());
    }
    if ((Utils.b()) && (Utils.c() < 31457280L))
    {
      localObject = this.c;
      if (localObject != null) {
        ((MusicDownloadListener)localObject).a(this.b, false);
      }
      QLog.e("MusicProviderView.Downloader", 1, "download err no space");
      return;
    }
    Object localObject = new File(SdkContext.getInstance().getResources().getAVFilterResource().getMusicResPath());
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = new File(this.a);
    long l1 = SystemClock.uptimeMillis();
    localObject = new DownloadTask(this.b, (File)localObject);
    ((DownloadTask)localObject).J = true;
    ((DownloadTask)localObject).e = 2;
    ((DownloadTask)localObject).b = this.a;
    ((DownloadTask)localObject).b(512);
    ((DownloadTask)localObject).a(this.c);
    int i = DownloaderFactory.a((DownloadTask)localObject, null, null);
    long l2 = SystemClock.uptimeMillis();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("download cost ");
      localStringBuilder.append(l2 - l1);
      localStringBuilder.append(" result ");
      localStringBuilder.append(i);
      localStringBuilder.append(" key ");
      localStringBuilder.append(((DownloadTask)localObject).b);
      QLog.i("MusicProviderView.Downloader", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.music.QimMusicDownloader.DownloadMusicTask
 * JD-Core Version:    0.7.0.1
 */