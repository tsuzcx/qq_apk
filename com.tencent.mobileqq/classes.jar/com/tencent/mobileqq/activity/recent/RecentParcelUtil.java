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
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
  private static AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private static AtomicInteger jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
  
  public static int a()
  {
    return jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  @Nullable
  public static RecentBaseData a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, @NonNull RecentUser paramRecentUser)
  {
    try
    {
      paramBaseQQAppInterface = ConversationDataFactory.a(paramRecentUser, paramBaseQQAppInterface, paramContext, false);
      if ((paramRecentUser.parceledRecentBaseData != null) && (paramBaseQQAppInterface != null))
      {
        boolean bool = ParcelHelper.a(paramBaseQQAppInterface, paramRecentUser.parceledRecentBaseData);
        if (QLog.isColorLevel())
        {
          QLog.e("RecentParcelUtil", 1, new Object[] { "bytesToObject status=", Boolean.valueOf(bool), " user=", paramRecentUser.uin });
          paramBaseQQAppInterface.printDataItem();
          if (((paramBaseQQAppInterface instanceof RecentUserBaseData)) && (((RecentUserBaseData)paramBaseQQAppInterface).a() != null)) {
            QLog.d("RecentParcelUtil", 1, new Object[] { "RecentUser info=[showUpTime=", Long.valueOf(((RecentUserBaseData)paramBaseQQAppInterface).a().showUpTime), " opTime=", Long.valueOf(((RecentUserBaseData)paramBaseQQAppInterface).a().opTime) });
          }
        }
        if (bool) {
          return paramBaseQQAppInterface;
        }
        return null;
      }
    }
    catch (ParcelHelper.FieldChangedException paramBaseQQAppInterface)
    {
      QLog.e("RecentParcelUtil", 1, "FieldChangedException ", paramBaseQQAppInterface);
      return null;
    }
    catch (Throwable paramBaseQQAppInterface)
    {
      QLog.e("RecentParcelUtil", 1, "getRecentUserData fail, 请对应的开发检查是否使用了不该使用的字段", paramBaseQQAppInterface);
      a(paramContext, false, paramBaseQQAppInterface);
      return null;
    }
    paramBaseQQAppInterface = null;
    return paramBaseQQAppInterface;
  }
  
  public static String a(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("BootOptimize", 0);
    String str = paramContext.getString("8.5.5_has_crash_when_parcel_because", "");
    paramContext.edit().putString("8.5.5_has_crash_when_parcel_because", "").apply();
    return str;
  }
  
  public static void a()
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  static void a(int paramInt1, int paramInt2)
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt1);
    jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt2);
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
      if (paramBoolean) {
        paramContext.putLong("_last_crash_time", System.currentTimeMillis());
      }
      for (;;)
      {
        paramContext.apply();
        jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        return;
        paramContext.putBoolean("8.5.5_has_crash_when_parcel", true);
        if (paramThrowable != null)
        {
          while (paramThrowable.getCause() != null) {
            paramThrowable = paramThrowable.getCause();
          }
          StringWriter localStringWriter = new StringWriter();
          paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
          paramContext.putString("8.5.5_has_crash_when_parcel_because", localStringWriter.getBuffer().toString());
        }
      }
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, @NonNull List<Object> paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    label185:
    do
    {
      return;
      int j = Math.min(paramInt, paramList.size());
      int i = 0;
      if (i < paramList.size())
      {
        Object localObject = paramList.get(i);
        int k;
        RecentUser localRecentUser;
        if ((localObject instanceof RecentBaseData))
        {
          localObject = (RecentBaseData)localObject;
          if (j <= 0) {
            continue;
          }
          k = j - 1;
          localRecentUser = ((RecentUserBaseData)localObject).mUser;
          localObject = ((IRecentUserProxyService)paramBaseQQAppInterface.getRuntimeService(IRecentUserProxyService.class)).getRecentUserCache();
          if (localObject != null) {
            ((RecentUserProxy)localObject).b(localRecentUser, true);
          }
          j = k;
          if (QLog.isColorLevel()) {
            if (localRecentUser != null) {
              break label185;
            }
          }
        }
        for (localObject = "";; localObject = localRecentUser.uin)
        {
          QLog.d("RecentParcelUtil", 2, new Object[] { "saveRecentUserData, ", localObject, " forceUpdateParcelData=true" });
          j = k;
          i += 1;
          break;
          new Object[2][0] = "saveRecentUserData, ignore data class=";
          throw new NullPointerException();
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("RecentParcelUtil", 2, new Object[] { "saveRecentUserData, size=", Integer.valueOf(paramInt), " lastData.size()=", Integer.valueOf(paramList.size()) });
  }
  
  public static void a(@NonNull BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean)
  {
    paramBaseQQAppInterface.getApp().getSharedPreferences("BootOptimize", 0).edit().putBoolean("_useParcelForBoot", paramBoolean).apply();
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public static boolean a(Context paramContext)
  {
    return paramContext.getSharedPreferences("BootOptimize", 0).getBoolean("8.5.5_has_crash_when_parcel", false);
  }
  
  public static boolean a(@NonNull BaseQQAppInterface paramBaseQQAppInterface)
  {
    if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(b(paramBaseQQAppInterface));
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    }
    return jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public static int b()
  {
    return jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public static boolean b(Context paramContext)
  {
    if (paramContext == null) {}
    long l;
    do
    {
      return true;
      l = paramContext.getSharedPreferences("BootOptimize", 0).getLong("_last_crash_time", 0L);
    } while (System.currentTimeMillis() - l > 1800000L);
    return false;
  }
  
  private static boolean b(@NonNull BaseQQAppInterface paramBaseQQAppInterface)
  {
    paramBaseQQAppInterface = paramBaseQQAppInterface.getApp().getSharedPreferences("BootOptimize", 0);
    boolean bool2 = paramBaseQQAppInterface.getBoolean("_useParcelForBoot", true);
    boolean bool3 = paramBaseQQAppInterface.getBoolean("8.5.5_has_crash_when_parcel", false);
    long l = paramBaseQQAppInterface.getLong("_last_crash_time", 0L);
    if (System.currentTimeMillis() - l < 1800000L) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BootOptimize", 2, new Object[] { "getUseBootOptimize=[isDebugVersion=", Boolean.valueOf(false), ", use_parcel:", Boolean.valueOf(bool2), ", has_crash=", Boolean.valueOf(bool3), ", appVersion=", "8.5.5", ", lastCrashTime=", Long.valueOf(l), " recentCrash=", Boolean.valueOf(bool1), "]" });
      }
      if ((!bool2) || (bool3) || (bool1)) {
        break;
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentParcelUtil
 * JD-Core Version:    0.7.0.1
 */