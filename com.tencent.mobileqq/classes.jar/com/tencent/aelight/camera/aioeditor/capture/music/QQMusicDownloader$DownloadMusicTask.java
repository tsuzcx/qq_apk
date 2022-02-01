package com.tencent.aelight.camera.aioeditor.capture.music;

import android.os.SystemClock;
import com.tencent.aelight.camera.struct.editor.MusicDownloadListener;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.mobileqq.shortvideo.resource.SpecialAVFilterResource;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.SdkContext;
import java.io.File;

class QQMusicDownloader$DownloadMusicTask
  implements Runnable
{
  DownloadTask a;
  MusicDownloadListener b;
  
  public QQMusicDownloader$DownloadMusicTask(DownloadTask paramDownloadTask, MusicDownloadListener paramMusicDownloadListener)
  {
    this.a = paramDownloadTask;
    this.b = paramMusicDownloadListener;
  }
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("begin download ");
      ((StringBuilder)localObject).append(this.a.b);
      QLog.d("QQMusicDownloader", 2, ((StringBuilder)localObject).toString());
    }
    if ((Utils.b()) && (Utils.c() < 31457280L))
    {
      localObject = this.b;
      if (localObject != null) {
        ((MusicDownloadListener)localObject).a(this.a.b, false);
      }
      QLog.e("QQMusicDownloader", 1, "download err no space");
      return;
    }
    String str = QQStoryConstant.c;
    Object localObject = str;
    if (SdkContext.getInstance() != null)
    {
      localObject = str;
      if (SdkContext.getInstance().getResources() != null)
      {
        localObject = str;
        if (SdkContext.getInstance().getResources().getAVFilterResource() != null)
        {
          localObject = str;
          if (SdkContext.getInstance().getResources().getAVFilterResource().getMusicResPath() != null) {
            localObject = SdkContext.getInstance().getResources().getAVFilterResource().getMusicResPath();
          }
        }
      }
    }
    localObject = new File((String)localObject);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    long l1 = SystemClock.uptimeMillis();
    int i = DownloaderFactory.a(this.a, null, null);
    long l2 = SystemClock.uptimeMillis();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("download cost ");
      ((StringBuilder)localObject).append(l2 - l1);
      ((StringBuilder)localObject).append(" result ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" key ");
      ((StringBuilder)localObject).append(this.a.b);
      QLog.i("QQMusicDownloader", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.music.QQMusicDownloader.DownloadMusicTask
 * JD-Core Version:    0.7.0.1
 */