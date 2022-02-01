package com.tencent.mobileqq.activity.aio.drawer;

import android.text.TextUtils;
import com.tencent.mobileqq.dpc.DPCObserver;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class AIODrawerDpc
{
  public static DPCObserver c = new AIODrawerDpc.1();
  private static final String d = DPCNames.aio_config.name();
  private static AIODrawerDpc e;
  public boolean a = true;
  public boolean b = true;
  private String f;
  
  private AIODrawerDpc()
  {
    ((IDPCApi)QRoute.api(IDPCApi.class)).addObserver(c);
  }
  
  public static AIODrawerDpc a()
  {
    if (e == null) {
      b(false);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getInstance: ");
      localStringBuilder.append(e);
      QLog.d("AIODrawerDpc", 2, localStringBuilder.toString());
    }
    return e;
  }
  
  private static void b(boolean paramBoolean)
  {
    try
    {
      long l1 = System.currentTimeMillis();
      if (e == null)
      {
        e = new AIODrawerDpc();
        paramBoolean = true;
      }
      if (paramBoolean) {
        try
        {
          Object localObject1 = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(d);
          e.f = ((String)localObject1);
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject1 = ((String)localObject1).split("\\|");
            if (localObject1.length >= 19)
            {
              if (Integer.valueOf(localObject1[18]).intValue() == 1) {
                e.a = true;
              } else {
                e.a = false;
              }
            }
            else {
              e.a = true;
            }
            if (localObject1.length >= 20)
            {
              if (Integer.valueOf(localObject1[19]).intValue() == 1) {
                e.b = true;
              } else {
                e.b = false;
              }
            }
            else {
              e.b = true;
            }
          }
        }
        catch (Exception localException)
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("load exp:");
          localStringBuilder2.append(localException.getMessage());
          QLog.d("AIODrawerDpc", 1, localStringBuilder2.toString());
          e.a = true;
          e.b = true;
        }
      }
      if (QLog.isColorLevel())
      {
        long l2 = System.currentTimeMillis();
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("loadDpc: ");
        localStringBuilder1.append(e);
        localStringBuilder1.append(", costMills: ");
        localStringBuilder1.append(l2 - l1);
        QLog.d("AIODrawerDpc", 2, localStringBuilder1.toString());
      }
      return;
    }
    finally {}
  }
  
  public static boolean b()
  {
    AIODrawerDpc localAIODrawerDpc = a();
    if (localAIODrawerDpc != null) {
      return localAIODrawerDpc.a;
    }
    return true;
  }
  
  public static boolean c()
  {
    AIODrawerDpc localAIODrawerDpc = a();
    if (localAIODrawerDpc != null) {
      return localAIODrawerDpc.b;
    }
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AIODrawerDpc{dpcValue='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isSupport=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", needPreInflate=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.drawer.AIODrawerDpc
 * JD-Core Version:    0.7.0.1
 */