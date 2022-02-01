package com.tencent.aelight.camera.ae.cmshow;

import android.text.TextUtils;
import com.tencent.aelight.camera.aeeditor.data.AEEditorDownloadResBean;
import com.tencent.aelight.camera.cmsshow.api.CMJoyEssentialDownloadCallback;
import com.tencent.aelight.camera.log.AEQLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

class AECMShowResourceManager$1
  implements Runnable
{
  AECMShowResourceManager$1(AECMShowResourceManager paramAECMShowResourceManager, List paramList, CMJoyEssentialDownloadCallback paramCMJoyEssentialDownloadCallback) {}
  
  public void run()
  {
    AECMShowResourceManager.a(this.this$0);
    boolean[] arrayOfBoolean = new boolean[1];
    arrayOfBoolean[0] = true;
    HashMap localHashMap = new HashMap();
    CountDownLatch localCountDownLatch = new CountDownLatch(this.a.size());
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (TextUtils.isEmpty(str))
      {
        AEQLog.a("AECMShowResourceManager", "[downloadEssentialResource], resId is null");
        arrayOfBoolean[0] = false;
        localCountDownLatch.countDown();
      }
      else
      {
        Object localObject = AECMShowResourceManager.a(this.this$0, str);
        if (localObject == null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[downloadEssentialResource], resId=");
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(", download bean is null");
          AEQLog.a("AECMShowResourceManager", ((StringBuilder)localObject).toString());
          arrayOfBoolean[0] = false;
          localHashMap.put(str, null);
          localCountDownLatch.countDown();
        }
        else if (this.this$0.b((AEEditorDownloadResBean)localObject))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[downloadEssentialResource], resId=");
          localStringBuilder.append(str);
          localStringBuilder.append(", res exists");
          AEQLog.a("AECMShowResourceManager", localStringBuilder.toString());
          localHashMap.put(str, this.this$0.a((AEEditorDownloadResBean)localObject));
          localCountDownLatch.countDown();
        }
        else
        {
          this.this$0.a((AEEditorDownloadResBean)localObject, new AECMShowResourceManager.1.1(this, str, localHashMap, (AEEditorDownloadResBean)localObject, arrayOfBoolean, localCountDownLatch));
        }
      }
    }
    try
    {
      localCountDownLatch.await();
    }
    catch (InterruptedException localInterruptedException)
    {
      AEQLog.a("AECMShowResourceManager", "[downloadEssentialResource], e=", localInterruptedException);
    }
    CMJoyEssentialDownloadCallback localCMJoyEssentialDownloadCallback = this.b;
    if (localCMJoyEssentialDownloadCallback != null) {
      localCMJoyEssentialDownloadCallback.a(arrayOfBoolean[0], localHashMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.cmshow.AECMShowResourceManager.1
 * JD-Core Version:    0.7.0.1
 */