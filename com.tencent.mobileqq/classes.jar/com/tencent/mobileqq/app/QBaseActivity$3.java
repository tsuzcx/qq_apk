package com.tencent.mobileqq.app;

import android.content.Context;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class QBaseActivity$3
  implements Runnable
{
  QBaseActivity$3(QBaseActivity paramQBaseActivity) {}
  
  public void run()
  {
    try
    {
      if (QBaseActivity.access$200() == null)
      {
        localObject3 = QBaseActivity.access$100().a();
        localObject1 = (SensorManager)this.this$0.getApplicationContext().getSystemService("sensor");
      }
    }
    finally
    {
      Object localObject3;
      Object localObject1;
      label54:
      StringBuilder localStringBuilder;
      String str4;
      for (;;)
      {
        label274:
        throw localObject2;
      }
    }
    try
    {
      ((SensorManager)localObject1).registerListener((SensorEventListener)localObject3, ((SensorManager)localObject1).getDefaultSensor(1), 2);
      QBaseActivity.access$202((ShakeListener)localObject3);
    }
    catch (IllegalStateException localIllegalStateException)
    {
      break label54;
    }
    localStringBuilder = new StringBuilder("SystemSensorManager.mSensorListeners:\n");
    localObject3 = null;
    try
    {
      Object localObject4 = Class.forName("android.hardware.SystemSensorManager").getDeclaredField("mSensorListeners");
      ((Field)localObject4).setAccessible(true);
      localObject4 = ((HashMap)((Field)localObject4).get(localObject1)).keySet().iterator();
      for (;;)
      {
        localObject1 = localObject3;
        if (!((Iterator)localObject4).hasNext()) {
          break;
        }
        localStringBuilder.append(((Iterator)localObject4).next());
        localStringBuilder.append("\n");
      }
      String str1;
      String str2;
      String str3;
      if (TextUtils.isEmpty(str4)) {
        break label274;
      }
    }
    catch (Throwable localThrowable)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("turnOnShake Throwable=");
      ((StringBuilder)localObject3).append(localThrowable);
      str1 = ((StringBuilder)localObject3).toString();
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("turnOnShake IllegalAccessException=");
      ((StringBuilder)localObject3).append(localIllegalAccessException);
      str2 = ((StringBuilder)localObject3).toString();
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("turnOnShake NoSuchFieldException=");
      ((StringBuilder)localObject3).append(localNoSuchFieldException);
      str3 = ((StringBuilder)localObject3).toString();
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("turnOnShake ClassNotFoundException=");
      ((StringBuilder)localObject3).append(localClassNotFoundException);
      str4 = ((StringBuilder)localObject3).toString();
    }
    localStringBuilder.append(str4);
    QLog.d("qqBaseActivity", 1, str4);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.QBaseActivity.3
 * JD-Core Version:    0.7.0.1
 */