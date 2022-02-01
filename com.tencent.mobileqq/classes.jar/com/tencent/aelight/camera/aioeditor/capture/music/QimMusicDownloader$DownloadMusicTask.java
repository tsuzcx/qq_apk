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
  MusicDownloadListener jdField_a_of_type_ComTencentAelightCameraStructEditorMusicDownloadListener;
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public QimMusicDownloader$DownloadMusicTask(String paramString1, String paramString2, MusicDownloadListener paramMusicDownloadListener)
  {
    this.b = paramString1;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_ComTencentAelightCameraStructEditorMusicDownloadListener = paramMusicDownloadListener;
  }
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("begin download ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(this.b);
      QLog.d("MusicProviderView.Downloader", 2, ((StringBuilder)localObject).toString());
    }
    if ((Utils.a()) && (Utils.b() < 31457280L))
    {
      localObject = this.jdField_a_of_type_ComTencentAelightCameraStructEditorMusicDownloadListener;
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
    localObject = new File(this.jdField_a_of_type_JavaLangString);
    long l1 = SystemClock.uptimeMillis();
    localObject = new DownloadTask(this.b, (File)localObject);
    ((DownloadTask)localObject).n = true;
    ((DownloadTask)localObject).b = 2;
    ((DownloadTask)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    ((DownloadTask)localObject).b(512);
    ((DownloadTask)localObject).a(this.jdField_a_of_type_ComTencentAelightCameraStructEditorMusicDownloadListener);
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
      localStringBuilder.append(((DownloadTask)localObject).jdField_a_of_type_JavaLangString);
      QLog.i("MusicProviderView.Downloader", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.music.QimMusicDownloader.DownloadMusicTask
 * JD-Core Version:    0.7.0.1
 */