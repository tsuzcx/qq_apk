package com.tencent.aelight.camera.api.impl;

import com.tencent.aelight.camera.aeeditor.manage.AEEditorResourceDownloader.ResDownLoadListener;
import java.util.concurrent.CountDownLatch;

final class AEPhotoAIManagerImpl$1
  implements AEEditorResourceDownloader.ResDownLoadListener
{
  AEPhotoAIManagerImpl$1(boolean[] paramArrayOfBoolean, CountDownLatch paramCountDownLatch) {}
  
  public void a(int paramInt) {}
  
  public void a(boolean paramBoolean)
  {
    this.a[0] = paramBoolean;
    this.b.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.api.impl.AEPhotoAIManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */