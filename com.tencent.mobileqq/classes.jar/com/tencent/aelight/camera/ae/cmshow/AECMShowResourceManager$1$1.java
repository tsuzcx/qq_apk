package com.tencent.aelight.camera.ae.cmshow;

import com.tencent.aelight.camera.aeeditor.data.AEEditorDownloadResBean;
import com.tencent.aelight.camera.aeeditor.manage.AEEditorResourceDownloader.ResDownLoadListener;
import com.tencent.aelight.camera.log.AEQLog;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

class AECMShowResourceManager$1$1
  implements AEEditorResourceDownloader.ResDownLoadListener
{
  AECMShowResourceManager$1$1(AECMShowResourceManager.1 param1, String paramString, HashMap paramHashMap, AEEditorDownloadResBean paramAEEditorDownloadResBean, boolean[] paramArrayOfBoolean, CountDownLatch paramCountDownLatch) {}
  
  public void a(int paramInt) {}
  
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder;
    if (paramBoolean)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[downloadEssentialResource], resId=");
      localStringBuilder.append(this.a);
      localStringBuilder.append(", download succeeded");
      AEQLog.a("AECMShowResourceManager", localStringBuilder.toString());
      this.b.put(this.a, this.f.this$0.a(this.c));
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[downloadEssentialResource], resId=");
      localStringBuilder.append(this.a);
      localStringBuilder.append(", download failed");
      AEQLog.a("AECMShowResourceManager", localStringBuilder.toString());
      this.d[0] = false;
      this.b.put(this.a, null);
    }
    this.e.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.cmshow.AECMShowResourceManager.1.1
 * JD-Core Version:    0.7.0.1
 */