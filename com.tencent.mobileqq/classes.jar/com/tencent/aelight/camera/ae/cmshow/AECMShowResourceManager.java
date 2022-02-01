package com.tencent.aelight.camera.ae.cmshow;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.aelight.camera.ae.AEPath.CMJOY.FILES;
import com.tencent.aelight.camera.ae.cmshow.config.AECMShowConfigManager;
import com.tencent.aelight.camera.aeeditor.data.AEEditorDownloadResBean;
import com.tencent.aelight.camera.aeeditor.manage.AEEditorResourceDownloader;
import com.tencent.aelight.camera.cmsshow.api.CMJoyEssentialDownloadCallback;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class AECMShowResourceManager
  extends AEEditorResourceDownloader
{
  private HashMap<String, AEEditorDownloadResBean> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final CountDownLatch jdField_a_of_type_JavaUtilConcurrentCountDownLatch = new CountDownLatch(1);
  
  private AECMShowResourceManager()
  {
    super("", AEPath.CMJOY.FILES.b, 4, "AECMShowResourceManager");
  }
  
  public static AECMShowResourceManager a()
  {
    return AECMShowResourceManager.InstanceHolder.a;
  }
  
  @Nullable
  private AEEditorDownloadResBean a(String paramString)
  {
    return (AEEditorDownloadResBean)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  private void c()
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch)
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.getCount() <= 0L)
      {
        AEQLog.a("AECMShowResourceManager", "[prepareResourceConfig], configured");
        return;
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      this.jdField_a_of_type_JavaUtilHashMap.putAll(AECMShowConfigManager.a().a());
      this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
      try
      {
        this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.await();
      }
      catch (InterruptedException localInterruptedException)
      {
        AEQLog.a("AECMShowResourceManager", "[prepareResourceConfig], e=", localInterruptedException);
      }
      return;
    }
  }
  
  protected void a(@NonNull List<AEEditorDownloadResBean> paramList) {}
  
  public void a(@NonNull List<String> paramList, @Nullable CMJoyEssentialDownloadCallback paramCMJoyEssentialDownloadCallback)
  {
    ThreadManager.excute(new AECMShowResourceManager.1(this, paramList, paramCMJoyEssentialDownloadCallback), 128, null, false);
  }
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, String paramString) {}
  
  protected void b(@NonNull List<AEEditorDownloadResBean> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.cmshow.AECMShowResourceManager
 * JD-Core Version:    0.7.0.1
 */