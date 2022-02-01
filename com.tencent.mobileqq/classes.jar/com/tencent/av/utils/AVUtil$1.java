package com.tencent.av.utils;

import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import mqq.util.WeakReference;

final class AVUtil$1
  implements Runnable
{
  AVUtil$1(WeakReference paramWeakReference) {}
  
  public void run()
  {
    Object localObject1 = (Activity)this.a.get();
    if (localObject1 == null) {
      return;
    }
    try
    {
      Object localObject2 = Class.forName("android.rms.iaware.FastgrabConfigReader");
      Object localObject3 = ((Class)localObject2).getDeclaredField("mFastgrabConfigReader");
      i = 1;
      ((Field)localObject3).setAccessible(true);
      localObject3 = ((Field)localObject3).get(localObject2);
      localObject2 = ((Class)localObject2).getDeclaredField("mContext");
      ((Field)localObject2).setAccessible(true);
      if (((Field)localObject2).get(localObject3) == localObject1) {
        ((Field)localObject2).set(localObject3, null);
      } else {
        i = 2;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      int i;
      break label99;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      break label94;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      break label89;
    }
    catch (Throwable localThrowable)
    {
      label83:
      break label83;
    }
    i = 6;
    break label101;
    label89:
    i = 5;
    break label101;
    label94:
    i = 4;
    break label101;
    label99:
    i = 3;
    label101:
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("fixMemoryLeakForHuaWei, ret[");
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append("]");
      QLog.i("AVUtil", 2, ((StringBuilder)localObject1).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.AVUtil.1
 * JD-Core Version:    0.7.0.1
 */