package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.activity.recent.parcelUtils.ParcelHelper;
import com.tencent.mobileqq.activity.recent.parcelUtils.ParcelHelper.FieldChangedException;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class RecentParcelUtil
{
  private static AtomicBoolean a = new AtomicBoolean(true);
  private static AtomicBoolean b = new AtomicBoolean(false);
  private static AtomicInteger c = new AtomicInteger(-1);
  private static AtomicInteger d = new AtomicInteger(-1);
  
  public static int a()
  {
    return c.get();
  }
  
  @Nullable
  public static RecentBaseData a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, @NonNull RecentUser paramRecentUser)
  {
    try
    {
      paramBaseQQAppInterface = ConversationDataFactory.a(paramRecentUser, paramBaseQQAppInterface, paramContext, false);
      if (paramRecentUser.parceledRecentBaseData != null)
      {
        if (paramBaseQQAppInterface == null) {
          return null;
        }
        boolean bool = ParcelHelper.a(paramBaseQQAppInterface, paramRecentUser.parceledRecentBaseData);
        if (QLog.isColorLevel())
        {
          QLog.e("RecentParcelUtil", 1, new Object[] { "bytesToObject status=", Boolean.valueOf(bool), " user=", paramRecentUser.uin });
          paramBaseQQAppInterface.printDataItem();
          if (((paramBaseQQAppInterface instanceof RecentUserBaseData)) && (((RecentUserBaseData)paramBaseQQAppInterface).e() != null)) {
            QLog.d("RecentParcelUtil", 1, new Object[] { "RecentUser info=[showUpTime=", Long.valueOf(((RecentUserBaseData)paramBaseQQAppInterface).e().showUpTime), " opTime=", Long.valueOf(((RecentUserBaseData)paramBaseQQAppInterface).e().opTime) });
          }
        }
        if (!bool) {
          return null;
        }
        return paramBaseQQAppInterface;
      }
      return null;
    }
    catch (Throwable paramBaseQQAppInterface)
    {
      QLog.e("RecentParcelUtil", 1, "getRecentUserData fail, 请对应的开发检查是否使用了不该使用的字段", paramBaseQQAppInterface);
      a(paramContext, false, paramBaseQQAppInterface);
      return null;
    }
    catch (ParcelHelper.FieldChangedException paramBaseQQAppInterface)
    {
      QLog.e("RecentParcelUtil", 1, "FieldChangedException ", paramBaseQQAppInterface);
    }
    return null;
  }
  
  static void a(int paramInt1, int paramInt2)
  {
    c.set(paramInt1);
    d.set(paramInt2);
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    a(paramContext, paramBoolean, null);
  }
  
  public static void a(Context paramContext, boolean paramBoolean, @Nullable Throwable paramThrowable)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("BootOptimize", 0).edit();
      if (paramBoolean)
      {
        paramContext.putLong("_last_crash_time", System.currentTimeMillis());
      }
      else
      {
        paramContext.putBoolean("8.8.17_has_crash_when_parcel", true);
        if (paramThrowable != null)
        {
          while (paramThrowable.getCause() != null) {
            paramThrowable = paramThrowable.getCause();
          }
          StringWriter localStringWriter = new StringWriter();
          paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
          paramContext.putString("8.8.17_has_crash_when_parcel_because", localStringWriter.getBuffer().toString());
        }
      }
      paramContext.apply();
      a.set(true);
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, @NonNull List<Object> paramList, int paramInt)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      int j = Math.min(paramInt, paramList.size());
      int i = 0;
      while (i < paramList.size())
      {
        Object localObject = paramList.get(i);
        if ((localObject instanceof RecentBaseData))
        {
          localObject = (RecentBaseData)localObject;
          if (j <= 0) {
            break;
          }
          int k = j - 1;
          RecentUser localRecentUser = ((RecentUserBaseData)localObject).mUser;
          localObject = ((IRecentUserProxyService)paramBaseQQAppInterface.getRuntimeService(IRecentUserProxyService.class)).getRecentUserCache();
          if (localObject != null) {
            ((RecentUserProxy)localObject).b(localRecentUser, true);
          }
          j = k;
          if (QLog.isColorLevel())
          {
            if (localRecentUser == null) {
              localObject = "";
            } else {
              localObject = localRecentUser.uin;
            }
            QLog.d("RecentParcelUtil", 2, new Object[] { "saveRecentUserData, ", localObject, " forceUpdateParcelData=true" });
            j = k;
          }
        }
        else
        {
          new Object[2][0] = "saveRecentUserData, ignore data class=";
          throw new NullPointerException();
        }
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RecentParcelUtil", 2, new Object[] { "saveRecentUserData, size=", Integer.valueOf(paramInt), " lastData.size()=", Integer.valueOf(paramList.size()) });
      }
    }
  }
  
  public static void a(@NonNull BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean)
  {
    paramBaseQQAppInterface.getApp().getSharedPreferences("BootOptimize", 0).edit().putBoolean("_useParcelForBoot", paramBoolean).apply();
    a.set(true);
  }
  
  public static boolean a(Context paramContext)
  {
    return paramContext.getSharedPreferences("BootOptimize", 0).getBoolean("8.8.17_has_crash_when_parcel", false);
  }
  
  public static boolean a(@NonNull BaseQQAppInterface paramBaseQQAppInterface)
  {
    if (a.get())
    {
      b.set(b(paramBaseQQAppInterface));
      a.set(false);
    }
    return b.get();
  }
  
  public static int b()
  {
    return d.get();
  }
  
  public static String b(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("BootOptimize", 0);
    String str = paramContext.getString("8.8.17_has_crash_when_parcel_because", "");
    paramContext.edit().putString("8.8.17_has_crash_when_parcel_because", "").apply();
    return str;
  }
  
  private static boolean b(@NonNull BaseQQAppInterface paramBaseQQAppInterface)
  {
    paramBaseQQAppInterface = paramBaseQQAppInterface.getApp();
    boolean bool3 = false;
    paramBaseQQAppInterface = paramBaseQQAppInterface.getSharedPreferences("BootOptimize", 0);
    boolean bool4 = paramBaseQQAppInterface.getBoolean("_useParcelForBoot", true);
    boolean bool5 = paramBaseQQAppInterface.getBoolean("8.8.17_has_crash_when_parcel", false);
    long l = paramBaseQQAppInterface.getLong("_last_crash_time", 0L);
    boolean bool1;
    if (System.currentTimeMillis() - l < 1800000L) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BootOptimize", 2, new Object[] { "getUseBootOptimize=[isDebugVersion=", Boolean.valueOf(false), ", use_parcel:", Boolean.valueOf(bool4), ", has_crash=", Boolean.valueOf(bool5), ", appVersion=", "8.8.17", ", lastCrashTime=", Long.valueOf(l), " recentCrash=", Boolean.valueOf(bool1), "]" });
    }
    boolean bool2 = bool3;
    if (bool4)
    {
      bool2 = bool3;
      if (!bool5)
      {
        bool2 = bool3;
        if (!bool1) {
          bool2 = true;
        }
      }
    }
    return bool2;
  }
  
  public static void c()
  {
    a.set(true);
  }
  
  public static boolean c(Context paramContext)
  {
    if (paramContext == null) {
      return true;
    }
    long l = paramContext.getSharedPreferences("BootOptimize", 0).getLong("_last_crash_time", 0L);
    return System.currentTimeMillis() - l > 1800000L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentParcelUtil
 * JD-Core Version:    0.7.0.1
 */