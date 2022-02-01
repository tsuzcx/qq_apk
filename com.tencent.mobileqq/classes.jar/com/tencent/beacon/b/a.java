package com.tencent.beacon.b;

import com.tencent.beacon.a.b.d;
import com.tencent.beacon.base.util.c;
import com.tencent.beacon.e.b;
import com.tencent.qmsp.sdk.u.U;

public class a
{
  private static boolean a = false;
  
  public static String a(int paramInt)
  {
    for (;;)
    {
      try
      {
        if (!b.a().f()) {
          return "";
        }
      }
      finally
      {
        String[] arrayOfString;
        Object localObject3;
        Object localObject4;
        Object localObject1;
        continue;
        throw localObject2;
        continue;
      }
      try
      {
        arrayOfString = U.c(paramInt);
      }
      catch (Throwable localThrowable2)
      {
        continue;
        paramInt += 1;
        continue;
      }
      try
      {
        arrayOfString = U.c(paramInt);
      }
      catch (Throwable localThrowable1)
      {
        localObject3 = com.tencent.beacon.a.c.f.p().g();
        if (!a)
        {
          localObject4 = d.b();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[beaconId] get bid from qmsp fail! cpuInfo: ");
          localStringBuilder.append((String)localObject3);
          ((d)localObject4).a("501", localStringBuilder.toString(), localThrowable1);
          a = true;
        }
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("[beaconId] get bid from qmsp fail! cpuInfo: ");
        ((StringBuilder)localObject4).append((String)localObject3);
        c.b(((StringBuilder)localObject4).toString(), new Object[0]);
        c.a(localThrowable1);
        localObject1 = null;
      }
    }
    if (localObject1 == null)
    {
      if (!a)
      {
        d.b().a("501", "[beaconId] jni execute error or load so fail!");
        a = true;
      }
      return "";
    }
    com.tencent.beacon.base.util.f.a((String[])localObject1);
    paramInt = 0;
    while (paramInt < localObject1.length)
    {
      localObject1[paramInt] = com.tencent.beacon.base.util.f.a(localObject1[paramInt]);
      paramInt += 1;
    }
    localObject3 = new StringBuilder();
    paramInt = 0;
    if (paramInt < localObject1.length)
    {
      if (paramInt >= 9)
      {
        ((StringBuilder)localObject3).append("k");
        ((StringBuilder)localObject3).append(paramInt + 2);
        ((StringBuilder)localObject3).append(":");
        ((StringBuilder)localObject3).append(localObject1[paramInt]);
        ((StringBuilder)localObject3).append(";");
      }
      else
      {
        ((StringBuilder)localObject3).append("k");
        ((StringBuilder)localObject3).append(paramInt + 1);
        ((StringBuilder)localObject3).append(":");
        ((StringBuilder)localObject3).append(localObject1[paramInt]);
        ((StringBuilder)localObject3).append(";");
      }
    }
    else
    {
      ((StringBuilder)localObject3).append("k10:");
      ((StringBuilder)localObject3).append(1);
      c.a("[BeaconId] %s", new Object[] { localObject3 });
      localObject1 = ((StringBuilder)localObject3).toString();
      return localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.b.a
 * JD-Core Version:    0.7.0.1
 */