package com.tencent.aelight.camera.aeeditor.module.aifilter;

import com.tencent.aelight.camera.aeeditor.manage.AEEditorResourceDownloader.ResDownLoadListener;
import java.util.concurrent.CountDownLatch;

final class AIFilterProxyBase$2
  implements AEEditorResourceDownloader.ResDownLoadListener
{
  AIFilterProxyBase$2(boolean[] paramArrayOfBoolean, CountDownLatch paramCountDownLatch) {}
  
  public void a(int paramInt) {}
  
  public void a(boolean paramBoolean)
  {
    this.a[0] = paramBoolean;
    this.b.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.aifilter.AIFilterProxyBase.2
 * JD-Core Version:    0.7.0.1
 */