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
  MusicDownloadListener jdField_a_of_type_ComTencentAelightCameraStructEditorMusicDownloadListener;
  DownloadTask jdField_a_of_type_ComTencentMobileqqVipDownloadTask;
  
  public QQMusicDownloader$DownloadMusicTask(DownloadTask paramDownloadTask, MusicDownloadListener paramMusicDownloadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask = paramDownloadTask;
    this.jdField_a_of_type_ComTencentAelightCameraStructEditorMusicDownloadListener = paramMusicDownloadListener;
  }
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("begin download ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask.a);
      QLog.d("QQMusicDownloader", 2, ((StringBuilder)localObject).toString());
    }
    if ((Utils.a()) && (Utils.b() < 31457280L))
    {
      localObject = this.jdField_a_of_type_ComTencentAelightCameraStructEditorMusicDownloadListener;
      if (localObject != null) {
        ((MusicDownloadListener)localObject).a(this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask.a, false);
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
    int i = DownloaderFactory.a(this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask, null, null);
    long l2 = SystemClock.uptimeMillis();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("download cost ");
      ((StringBuilder)localObject).append(l2 - l1);
      ((StringBuilder)localObject).append(" result ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" key ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask.a);
      QLog.i("QQMusicDownloader", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.music.QQMusicDownloader.DownloadMusicTask
 * JD-Core Version:    0.7.0.1
 */