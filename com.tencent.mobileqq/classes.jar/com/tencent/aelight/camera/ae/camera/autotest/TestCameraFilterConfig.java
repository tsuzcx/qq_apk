package com.tencent.aelight.camera.ae.camera.autotest;

import com.google.gson.Gson;
import com.tencent.aelight.camera.ae.camera.autotest.beans.AutoTestConfigBeans;
import com.tencent.aelight.camera.ae.debug.AECameraDebug;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.reflect.Type;

public class TestCameraFilterConfig
{
  private volatile AutoTestConfigBeans a = null;
  
  public static TestCameraFilterConfig a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sInstance code:");
    localStringBuilder.append(TestCameraFilterConfig.Instance.a);
    QLog.i("TestCameraFilterConfig", 4, localStringBuilder.toString());
    return TestCameraFilterConfig.Instance.a;
  }
  
  private void d()
  {
    Object localObject1 = new File("/sdcard/qq_img_auto_test/qq_camera_test.json");
    if (!((File)localObject1).exists())
    {
      QLog.d("TestCameraFilterConfig", 4, "intiParamsFromJson over|no config json file:/sdcard/qq_img_auto_test/qq_camera_test.json");
      return;
    }
    for (;;)
    {
      try
      {
        localObject1 = FileUtils.readFileToString((File)localObject1);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("content:");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("TestCameraFilterConfig", 4, ((StringBuilder)localObject2).toString());
        localObject2 = new TestCameraFilterConfig.1(this).getType();
        localObject1 = (AutoTestConfigBeans)new Gson().fromJson((String)localObject1, (Type)localObject2);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("beans:");
        ((StringBuilder)localObject2).append(localObject1);
        QLog.d("TestCameraFilterConfig", 4, ((StringBuilder)localObject2).toString());
        if (localObject1 != null)
        {
          ((AutoTestConfigBeans)localObject1).a();
          this.a = ((AutoTestConfigBeans)localObject1);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("videoTestMode:");
          ((StringBuilder)localObject2).append(this.a.a);
          ((StringBuilder)localObject2).append(",imageTestMode:");
          ((StringBuilder)localObject2).append(this.a.c);
          QLog.d("TestCameraFilterConfig", 4, ((StringBuilder)localObject2).toString());
          int i = this.a.a;
          boolean bool2 = false;
          if (i > 0)
          {
            if (this.a.a != 1) {
              break label342;
            }
            bool1 = true;
            AECameraDebug.a(bool1, this.a.b);
          }
          if (this.a.c > 0)
          {
            bool1 = bool2;
            if (((AutoTestConfigBeans)localObject1).c == 1) {
              bool1 = true;
            }
            AECameraDebug.a = bool1;
            AECameraDebug.b = AECameraDebug.a;
          }
        }
        QLog.d("TestCameraFilterConfig", 4, "intiParamsFromJson over.");
        return;
      }
      catch (Exception localException)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("intiParamsFromJson:exception:");
        ((StringBuilder)localObject2).append(localException.getMessage());
        QLog.e("TestCameraFilterConfig", 4, ((StringBuilder)localObject2).toString());
        return;
      }
      label342:
      boolean bool1 = false;
    }
  }
  
  public void b()
  {
    if (this.a != null) {
      return;
    }
    d();
  }
  
  public AutoImageTestManager c()
  {
    if (AECameraDebug.b) {
      return new AutoImageTestManager(this.a.d);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.autotest.TestCameraFilterConfig
 * JD-Core Version:    0.7.0.1
 */