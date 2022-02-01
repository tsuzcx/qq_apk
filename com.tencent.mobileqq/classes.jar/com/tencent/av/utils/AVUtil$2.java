package com.tencent.av.utils;

import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import mqq.util.WeakReference;

public final class AVUtil$2
  implements Runnable
{
  public void run()
  {
    if ((Activity)this.a.get() == null) {
      return;
    }
    for (;;)
    {
      try
      {
        Object localObject = Class.forName("com.meizu.internal.picker.ResultSender");
        Field localField = ((Class)localObject).getDeclaredField("sAccessibilityManager");
        localField.setAccessible(true);
        localObject = localField.get(localObject);
        localField = Class.forName("android.view.accessibility.AccessibilityManager").getDeclaredField("mHighTextContrastStateChangeListeners");
        localField.setAccessible(true);
        if (localField.get(localObject) == null) {
          continue;
        }
        localField.set(localObject, null);
        i = 1;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        i = 3;
        continue;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        i = 4;
        continue;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        i = 5;
        continue;
      }
      catch (Throwable localThrowable)
      {
        int i = 6;
        continue;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("AVUtil", 2, "fixMemoryLeakForMeizu, ret[" + i + "]");
      return;
      i = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.utils.AVUtil.2
 * JD-Core Version:    0.7.0.1
 */