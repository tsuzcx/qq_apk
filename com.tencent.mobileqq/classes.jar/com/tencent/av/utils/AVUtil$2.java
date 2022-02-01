package com.tencent.av.utils;

import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import mqq.util.WeakReference;

final class AVUtil$2
  implements Runnable
{
  public void run()
  {
    if ((Activity)this.a.get() == null) {
      return;
    }
    try
    {
      localObject = Class.forName("com.meizu.internal.picker.ResultSender");
      Field localField = ((Class)localObject).getDeclaredField("sAccessibilityManager");
      i = 1;
      localField.setAccessible(true);
      localObject = localField.get(localObject);
      localField = Class.forName("android.view.accessibility.AccessibilityManager").getDeclaredField("mHighTextContrastStateChangeListeners");
      localField.setAccessible(true);
      if (localField.get(localObject) != null) {
        localField.set(localObject, null);
      } else {
        i = 2;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Object localObject;
      int i;
      break label94;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      break label89;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      break label84;
    }
    catch (Throwable localThrowable)
    {
      label78:
      break label78;
    }
    i = 6;
    break label96;
    label84:
    i = 5;
    break label96;
    label89:
    i = 4;
    break label96;
    label94:
    i = 3;
    label96:
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fixMemoryLeakForMeizu, ret[");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("]");
      QLog.i("AVUtil", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.AVUtil.2
 * JD-Core Version:    0.7.0.1
 */