package com.tencent.aelight.camera.aioeditor.capture.music;

import android.text.TextUtils;
import com.tencent.aelight.camera.struct.editor.MusicDownloadListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class QQMusicDownloader
{
  public static DownloadTask a(String paramString1, String paramString2, MusicDownloadListener paramMusicDownloadListener)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramString1 = new DownloadTask(paramString1, new File(paramString2));
      paramString1.J = true;
      paramString1.e = 2;
      paramString1.b = paramString2;
      paramString1.b(512);
      paramString1.a(paramMusicDownloadListener);
      return paramString1;
    }
    paramMusicDownloadListener = new StringBuilder();
    paramMusicDownloadListener.append("invalid downlaod params ");
    paramMusicDownloadListener.append(paramString1);
    paramMusicDownloadListener.append(", ");
    paramMusicDownloadListener.append(paramString2);
    QLog.e("QQMusicDownloader", 1, paramMusicDownloadListener.toString());
    return null;
  }
  
  public static void a(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cancel task ");
      localStringBuilder.append(paramDownloadTask.b);
      QLog.i("QQMusicDownloader", 2, localStringBuilder.toString());
    }
    paramDownloadTask.a(true);
  }
  
  public static void a(DownloadTask paramDownloadTask, MusicDownloadListener paramMusicDownloadListener)
  {
    ThreadManager.post(new QQMusicDownloader.DownloadMusicTask(paramDownloadTask, paramMusicDownloadListener), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.music.QQMusicDownloader
 * JD-Core Version:    0.7.0.1
 */