package com.tencent.aelight.camera.aioeditor.capture.music;

import android.text.TextUtils;
import com.tencent.aelight.camera.struct.editor.MusicDownloadListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class QimMusicDownloader
{
  public static void a(String paramString1, String paramString2, MusicDownloadListener paramMusicDownloadListener)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      ThreadManager.post(new QimMusicDownloader.DownloadMusicTask(paramString1, paramString2, paramMusicDownloadListener), 5, null, false);
      return;
    }
    paramMusicDownloadListener = new StringBuilder();
    paramMusicDownloadListener.append("invalid downlaod params ");
    paramMusicDownloadListener.append(paramString1);
    paramMusicDownloadListener.append(", ");
    paramMusicDownloadListener.append(paramString2);
    QLog.e("MusicProviderView.Downloader", 1, paramMusicDownloadListener.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.music.QimMusicDownloader
 * JD-Core Version:    0.7.0.1
 */