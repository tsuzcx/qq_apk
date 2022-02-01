package com.tencent.av.utils;

import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import mqq.util.WeakReference;

public final class AVUtil$1
  implements Runnable
{
  public AVUtil$1(WeakReference paramWeakReference) {}
  
  public void run()
  {
    Activity localActivity = (Activity)this.a.get();
    if (localActivity == null) {
      return;
    }
    for (;;)
    {
      try
      {
        Object localObject1 = Class.forName("android.rms.iaware.FastgrabConfigReader");
        Object localObject2 = ((Class)localObject1).getDeclaredField("mFastgrabConfigReader");
        ((Field)localObject2).setAccessible(true);
        localObject2 = ((Field)localObject2).get(localObject1);
        localObject1 = ((Class)localObject1).getDeclaredField("mContext");
        ((Field)localObject1).setAccessible(true);
        if (((Field)localObject1).get(localObject2) != localActivity) {
          continue;
        }
        ((Field)localObject1).set(localObject2, null);
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
      QLog.i("AVUtil", 2, "fixMemoryLeakForHuaWei, ret[" + i + "]");
      return;
      i = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.utils.AVUtil.1
 * JD-Core Version:    0.7.0.1
 */