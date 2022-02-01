package com.tencent.aelight.camera.aioeditor.capture.music;

import com.tencent.aelight.camera.aioeditor.capture.view.QIMCommonLoadingProgress;
import com.tencent.aelight.camera.struct.editor.MusicDownloadListener;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

public class QQMusicDownloadListener
  extends MusicDownloadListener
{
  private ConcurrentHashMap<String, MusicItemInfo> a;
  private ConcurrentHashMap<String, DownloadTask> b;
  private MusicDownloadListener c;
  
  public QQMusicDownloadListener(ConcurrentHashMap<String, MusicItemInfo> paramConcurrentHashMap, ConcurrentHashMap<String, DownloadTask> paramConcurrentHashMap1, MusicDownloadListener paramMusicDownloadListener)
  {
    this.a = paramConcurrentHashMap;
    this.b = paramConcurrentHashMap1;
    this.c = paramMusicDownloadListener;
  }
  
  public void a(int paramInt)
  {
    this.c.a(paramInt);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCancel key=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("QQMusicDownloadListener", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (MusicItemInfo)this.a.get(paramString);
    if (localObject != null) {
      ((MusicItemInfo)localObject).mProgress = -1;
    }
    this.a.remove(paramString);
    this.b.remove(paramString);
    this.c.a(paramString);
    QIMCommonLoadingProgress.a(localObject).d();
  }
  
  public void a(String paramString, int paramInt)
  {
    MusicItemInfo localMusicItemInfo = (MusicItemInfo)this.a.get(paramString);
    int i = paramInt;
    if (localMusicItemInfo != null)
    {
      i = paramInt;
      if (paramInt == 100)
      {
        i = paramInt;
        if (this.b.contains(localMusicItemInfo.getLocalPath())) {
          i = 99;
        }
      }
      localMusicItemInfo.mProgress = i;
    }
    this.c.a(paramString, i);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    MusicItemInfo localMusicItemInfo = (MusicItemInfo)this.a.get(paramString);
    if (localMusicItemInfo != null) {
      if (!paramBoolean)
      {
        QIMCommonLoadingProgress.a(localMusicItemInfo).d();
        localMusicItemInfo.mProgress = -1;
        this.a.remove(paramString);
        this.b.remove(paramString);
      }
      else
      {
        localMusicItemInfo.mProgress = 1;
      }
    }
    this.c.a(paramString, paramBoolean);
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    MusicItemInfo localMusicItemInfo = (MusicItemInfo)this.a.get(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("QQMusicDownloadListener", 2, new Object[] { "onFinish, info:", localMusicItemInfo });
    }
    boolean bool = paramBoolean;
    if (localMusicItemInfo != null) {
      if (paramBoolean)
      {
        localMusicItemInfo.mProgress = 100;
        QIMCommonLoadingProgress.a(localMusicItemInfo).c();
        bool = paramBoolean;
        if (localMusicItemInfo.isMyMusicInfo())
        {
          bool = paramBoolean;
          if (localMusicItemInfo.fileSize > 0L)
          {
            File localFile = new File(paramString);
            if (localFile.length() != localMusicItemInfo.fileSize)
            {
              localMusicItemInfo.mProgress = -1;
              QIMCommonLoadingProgress.a(localMusicItemInfo).d();
              paramBoolean = false;
            }
            bool = paramBoolean;
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("file.length =");
              localStringBuilder.append(localFile.length());
              localStringBuilder.append(" info.fileSize=");
              localStringBuilder.append(localMusicItemInfo.fileSize);
              QLog.d("QQMusicDownloadListener", 2, localStringBuilder.toString());
              bool = paramBoolean;
            }
          }
        }
      }
      else
      {
        localMusicItemInfo.mProgress = -1;
        QIMCommonLoadingProgress.a(localMusicItemInfo).d();
        bool = paramBoolean;
      }
    }
    this.a.remove(paramString);
    this.b.remove(paramString);
    this.c.a(paramString, bool, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.music.QQMusicDownloadListener
 * JD-Core Version:    0.7.0.1
 */