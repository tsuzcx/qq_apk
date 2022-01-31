package com.tencent.mobileqq.app.soso;

import akuf;
import akug;
import akuk;
import akul;
import akum;
import akun;
import akuo;
import akup;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import anox;
import axrl;
import axsn;
import bbev;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.geolocation.internal.TencentLog;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.highway.utils.HwNetworkUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.BuiltInServlet;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SosoInterface
{
  public static int a;
  public static long a;
  private static final akup jdField_a_of_type_Akup;
  private static Handler jdField_a_of_type_AndroidOsHandler;
  private static TencentLocationListener jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener;
  private static TencentLocationManager jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager;
  private static TencentLog jdField_a_of_type_ComTencentMapGeolocationInternalTencentLog;
  private static SosoInterface.SosoLbsInfo jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo;
  private static final Object jdField_a_of_type_JavaLangObject;
  private static final ArrayList<akup> jdField_a_of_type_JavaUtilArrayList;
  private static final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private static boolean jdField_a_of_type_Boolean;
  private static long[] jdField_a_of_type_ArrayOfLong;
  private static int jdField_b_of_type_Int;
  private static long jdField_b_of_type_Long;
  private static boolean jdField_b_of_type_Boolean;
  private static int jdField_c_of_type_Int;
  private static long jdField_c_of_type_Long;
  private static int jdField_d_of_type_Int;
  private static long jdField_d_of_type_Long;
  private static int e;
  
  static
  {
    jdField_a_of_type_Int = 2000;
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), new akuk());
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    jdField_a_of_type_ArrayOfLong = new long[] { 0L, 0L, 0L, 0L, 0L };
    jdField_a_of_type_Boolean = true;
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    localIntentFilter.addAction("android.intent.action.SCREEN_ON");
    akum localakum = new akum();
    try
    {
      BaseApplicationImpl.getContext().registerReceiver(localakum, localIntentFilter);
      jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener = new akun();
      jdField_a_of_type_Akup = new akuo(0, false, false, 0L, false, false, "reqRawData");
      jdField_b_of_type_Boolean = true;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          localException.printStackTrace();
        }
      }
    }
  }
  
  private static SharedPreferences a()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("sosoConfig", 4);
  }
  
  @Deprecated
  public static SosoInterface.SosoLbsInfo a()
  {
    return a(true);
  }
  
  public static SosoInterface.SosoLbsInfo a(int paramInt, boolean paramBoolean)
  {
    if ((jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo == null) || (jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation == null)) {
      return null;
    }
    SosoInterface.SosoLbsInfo localSosoLbsInfo = new SosoInterface.SosoLbsInfo();
    localSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation = jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.a(paramInt, paramBoolean);
    return localSosoLbsInfo;
  }
  
  public static SosoInterface.SosoLbsInfo a(long paramLong, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    SosoInterface.SosoLbsInfo localSosoLbsInfo = null;
    boolean bool = true;
    if ((paramLong <= 5000L) || (paramInt == 4))
    {
      localObject = localSosoLbsInfo;
      if (QLog.isColorLevel())
      {
        QLog.i("SOSO.LBS", 2, "getCanUsedLbsInfoCache maxCacheInterval is: " + paramLong + " directly return.");
        localObject = localSosoLbsInfo;
      }
    }
    EIPCResult localEIPCResult;
    do
    {
      do
      {
        do
        {
          long l;
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      return localObject;
                      if (!c()) {
                        break;
                      }
                      l = SystemClock.elapsedRealtime();
                      localObject = localSosoLbsInfo;
                    } while (paramLong <= 0L);
                    localObject = localSosoLbsInfo;
                  } while (paramBoolean1);
                  if (!paramBoolean2) {
                    break;
                  }
                  localObject = localSosoLbsInfo;
                } while (jdField_a_of_type_ArrayOfLong[paramInt] <= 0L);
                localObject = localSosoLbsInfo;
              } while (l >= jdField_a_of_type_ArrayOfLong[paramInt] + paramLong);
              return a(paramInt, true);
              localObject = localSosoLbsInfo;
            } while (jdField_a_of_type_Long <= 0L);
            localObject = localSosoLbsInfo;
          } while (l >= jdField_a_of_type_Long + paramLong);
          localObject = localSosoLbsInfo;
        } while (jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo == null);
        return a(true);
        localObject = new Bundle();
        ((Bundle)localObject).putLong("max_cache_interval", paramLong);
        ((Bundle)localObject).putBoolean("goon", paramBoolean1);
        ((Bundle)localObject).putInt("level", paramInt);
        ((Bundle)localObject).putBoolean("req_location", paramBoolean2);
        localEIPCResult = QIPCClientHelper.getInstance().getClient().callServer("soso_interface", "get_lbs_info", (Bundle)localObject);
        if ((localEIPCResult == null) || (!localEIPCResult.isSuccess())) {
          break;
        }
        localEIPCResult.data.setClassLoader(SosoInterface.class.getClassLoader());
        localSosoLbsInfo = (SosoInterface.SosoLbsInfo)localEIPCResult.data.getParcelable("soso_lbs_info");
        localObject = localSosoLbsInfo;
      } while (!QLog.isColorLevel());
      localObject = new StringBuilder().append("getCanUsedLbsInfoCache result is ok ,info is null: ");
      if (localSosoLbsInfo == null) {}
      for (paramBoolean1 = bool;; paramBoolean1 = false)
      {
        QLog.i("SOSO.LBS", 2, paramBoolean1);
        return localSosoLbsInfo;
      }
      localObject = localSosoLbsInfo;
    } while (!QLog.isColorLevel());
    Object localObject = new StringBuilder().append("getCanUsedLbsInfoCache result is not ok. code: ");
    if (localEIPCResult == null) {}
    for (paramInt = -1;; paramInt = localEIPCResult.code)
    {
      QLog.i("SOSO.LBS", 2, paramInt);
      return null;
    }
  }
  
  public static SosoInterface.SosoLbsInfo a(boolean paramBoolean)
  {
    if (jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo == null) {
      return null;
    }
    SosoInterface.SosoLbsInfo localSosoLbsInfo = new SosoInterface.SosoLbsInfo();
    localSosoLbsInfo.jdField_a_of_type_ArrayOfByte = jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ArrayOfByte;
    if (jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation != null) {
      localSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation = jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.a(0, paramBoolean);
    }
    if (jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute != null) {
      localSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute = jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute.a();
    }
    ArrayList localArrayList = new ArrayList();
    if (jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_JavaUtilArrayList != null) {
      localArrayList.addAll(jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_JavaUtilArrayList);
    }
    localSosoLbsInfo.jdField_a_of_type_JavaUtilArrayList = localArrayList;
    localArrayList = new ArrayList();
    if (jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_b_of_type_JavaUtilArrayList != null) {
      localArrayList.addAll(jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_b_of_type_JavaUtilArrayList);
    }
    localSosoLbsInfo.jdField_b_of_type_JavaUtilArrayList = localArrayList;
    localSosoLbsInfo.jdField_a_of_type_Long = jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_Long;
    localSosoLbsInfo.jdField_a_of_type_JavaLangString = jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_JavaLangString;
    localSosoLbsInfo.jdField_b_of_type_JavaLangString = jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_b_of_type_JavaLangString;
    return localSosoLbsInfo;
  }
  
  public static String a()
  {
    SosoInterface.SosoLbsInfo localSosoLbsInfo = b();
    if ((localSosoLbsInfo != null) && (localSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation != null) && (!TextUtils.isEmpty(localSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_e_of_type_JavaLangString))) {
      return localSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_e_of_type_JavaLangString;
    }
    return a().getString("city", "");
  }
  
  public static void a()
  {
    ThreadManager.getSubThreadHandler().post(new SosoInterface.8());
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      jdField_a_of_type_JavaUtilArrayList.clear();
      return;
    }
  }
  
  public static void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (paramSosoLbsInfo == null) {
      return;
    }
    if (jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo == null)
    {
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo = new SosoInterface.SosoLbsInfo();
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation = new SosoInterface.SosoLocation();
    }
    jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_b_of_type_Float = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_b_of_type_Float;
    jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_b_of_type_Double = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_b_of_type_Double;
    jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_a_of_type_Double = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_a_of_type_Double;
    jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.l = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.l;
    jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_a_of_type_Int = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_a_of_type_Int;
    jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_a_of_type_Long = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_a_of_type_Long;
    jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.m = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.m;
    switch (paramInt)
    {
    case 2: 
    default: 
      return;
    }
    for (;;)
    {
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_e_of_type_Double = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_e_of_type_Double;
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_a_of_type_Float = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_a_of_type_Float;
      jdField_a_of_type_ArrayOfLong[0] = SystemClock.elapsedRealtime();
      return;
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_c_of_type_JavaLangString = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_c_of_type_JavaLangString;
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_d_of_type_JavaLangString = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_d_of_type_JavaLangString;
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_e_of_type_JavaLangString = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_e_of_type_JavaLangString;
      String str = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.f;
      if ((!TextUtils.isEmpty(str)) && (!str.equalsIgnoreCase("unknown"))) {
        jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.f = str;
      }
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.g = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.g;
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.h = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.h;
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.i = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.i;
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.j = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.j;
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.k = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.k;
      jdField_a_of_type_ArrayOfLong[3] = SystemClock.elapsedRealtime();
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_a_of_type_JavaLangString = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_a_of_type_JavaLangString;
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_b_of_type_JavaLangString = paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_b_of_type_JavaLangString;
      jdField_a_of_type_ArrayOfLong[1] = SystemClock.elapsedRealtime();
    }
  }
  
  public static void a(long paramLong)
  {
    a().edit().putLong("normal_enter_conversation_time", paramLong).commit();
  }
  
  /* Error */
  @Deprecated
  public static void a(long paramLong, String paramString)
  {
    // Byte code:
    //   0: invokestatic 431	com/tencent/mobileqq/app/ThreadManager:getSubThread	()Ljava/lang/Thread;
    //   3: invokestatic 436	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   6: if_acmpeq +15 -> 21
    //   9: invokestatic 436	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   12: invokestatic 441	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   15: invokevirtual 444	android/os/Looper:getThread	()Ljava/lang/Thread;
    //   18: if_acmpne +31 -> 49
    //   21: new 446	android/util/AndroidRuntimeException
    //   24: dup
    //   25: new 174	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   32: ldc_w 448
    //   35: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_2
    //   39: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokespecial 450	android/util/AndroidRuntimeException:<init>	(Ljava/lang/String;)V
    //   48: athrow
    //   49: invokestatic 436	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   52: invokevirtual 454	java/lang/Thread:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   55: astore 12
    //   57: ldc_w 327
    //   60: astore 11
    //   62: aload 11
    //   64: astore 10
    //   66: aload 12
    //   68: ifnull +95 -> 163
    //   71: aload 11
    //   73: astore 10
    //   75: aload 12
    //   77: arraylength
    //   78: iconst_4
    //   79: if_icmplt +84 -> 163
    //   82: aload 12
    //   84: iconst_3
    //   85: aaload
    //   86: astore 10
    //   88: new 174	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   95: aload 10
    //   97: invokevirtual 459	java/lang/StackTraceElement:getClassName	()Ljava/lang/String;
    //   100: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: ldc_w 461
    //   106: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload 10
    //   111: invokevirtual 464	java/lang/StackTraceElement:getMethodName	()Ljava/lang/String;
    //   114: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: astore 11
    //   122: aload 11
    //   124: astore 10
    //   126: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   129: ifeq +34 -> 163
    //   132: ldc 172
    //   134: iconst_2
    //   135: new 174	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   142: ldc_w 466
    //   145: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: aload 11
    //   150: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokestatic 194	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   159: aload 11
    //   161: astore 10
    //   163: lload_0
    //   164: lconst_0
    //   165: lcmp
    //   166: ifle +140 -> 306
    //   169: invokestatic 201	android/os/SystemClock:elapsedRealtime	()J
    //   172: getstatic 205	com/tencent/mobileqq/app/soso/SosoInterface:jdField_a_of_type_Long	J
    //   175: lload_0
    //   176: ladd
    //   177: lcmp
    //   178: ifge +128 -> 306
    //   181: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   184: ifeq +29 -> 213
    //   187: ldc 172
    //   189: iconst_2
    //   190: new 174	java/lang/StringBuilder
    //   193: dup
    //   194: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   197: ldc_w 468
    //   200: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: aload_2
    //   204: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokestatic 470	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   213: new 472	java/util/HashMap
    //   216: dup
    //   217: invokespecial 473	java/util/HashMap:<init>	()V
    //   220: astore 11
    //   222: aload_2
    //   223: ifnull +20 -> 243
    //   226: aload_2
    //   227: invokevirtual 476	java/lang/String:length	()I
    //   230: ifle +13 -> 243
    //   233: aload 11
    //   235: ldc_w 478
    //   238: aload_2
    //   239: invokevirtual 482	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   242: pop
    //   243: aload 10
    //   245: invokestatic 321	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   248: ifne +14 -> 262
    //   251: aload 11
    //   253: ldc_w 484
    //   256: aload 10
    //   258: invokevirtual 482	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   261: pop
    //   262: aload 11
    //   264: ldc_w 486
    //   267: getstatic 492	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   270: invokevirtual 495	java/lang/Boolean:booleanValue	()Z
    //   273: invokestatic 498	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   276: invokevirtual 482	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   279: pop
    //   280: invokestatic 502	anox:a	()Ljava/lang/String;
    //   283: astore_2
    //   284: invokestatic 86	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   287: invokestatic 507	axrl:a	(Landroid/content/Context;)Laxrl;
    //   290: aload_2
    //   291: ldc_w 509
    //   294: iconst_1
    //   295: lconst_0
    //   296: lconst_0
    //   297: aload 11
    //   299: ldc_w 327
    //   302: invokevirtual 512	axrl:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   305: return
    //   306: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   309: ifeq +39 -> 348
    //   312: ldc 172
    //   314: iconst_2
    //   315: new 174	java/lang/StringBuilder
    //   318: dup
    //   319: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   322: ldc_w 514
    //   325: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: aload_2
    //   329: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: ldc_w 516
    //   335: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: lload_0
    //   339: invokevirtual 184	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   342: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   345: invokestatic 470	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   348: getstatic 106	com/tencent/mobileqq/app/soso/SosoInterface:jdField_a_of_type_Akup	Lakup;
    //   351: aload_2
    //   352: putfield 521	akup:tag	Ljava/lang/String;
    //   355: getstatic 106	com/tencent/mobileqq/app/soso/SosoInterface:jdField_a_of_type_Akup	Lakup;
    //   358: invokestatic 524	com/tencent/mobileqq/app/soso/SosoInterface:a	(Lakup;)V
    //   361: invokestatic 201	android/os/SystemClock:elapsedRealtime	()J
    //   364: lstore_0
    //   365: iconst_0
    //   366: istore 9
    //   368: iconst_0
    //   369: istore 8
    //   371: iload 8
    //   373: istore 7
    //   375: getstatic 34	com/tencent/mobileqq/app/soso/SosoInterface:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   378: astore 11
    //   380: iload 8
    //   382: istore 7
    //   384: aload 11
    //   386: monitorenter
    //   387: iload 9
    //   389: istore 8
    //   391: invokestatic 201	android/os/SystemClock:elapsedRealtime	()J
    //   394: lstore_3
    //   395: iload 9
    //   397: istore 8
    //   399: getstatic 205	com/tencent/mobileqq/app/soso/SosoInterface:jdField_a_of_type_Long	J
    //   402: lstore 5
    //   404: lload_3
    //   405: lload 5
    //   407: ldc2_w 525
    //   410: ladd
    //   411: lcmp
    //   412: ifge +67 -> 479
    //   415: iconst_1
    //   416: istore 7
    //   418: aload 11
    //   420: monitorexit
    //   421: invokestatic 170	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   424: ifeq -119 -> 305
    //   427: ldc 172
    //   429: iconst_2
    //   430: new 174	java/lang/StringBuilder
    //   433: dup
    //   434: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   437: ldc_w 528
    //   440: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: aload_2
    //   444: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: ldc_w 530
    //   450: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: iload 7
    //   455: invokevirtual 278	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   458: ldc_w 532
    //   461: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: invokestatic 201	android/os/SystemClock:elapsedRealtime	()J
    //   467: lload_0
    //   468: lsub
    //   469: invokevirtual 184	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   472: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   475: invokestatic 470	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   478: return
    //   479: iload 9
    //   481: istore 8
    //   483: getstatic 34	com/tencent/mobileqq/app/soso/SosoInterface:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   486: ldc2_w 533
    //   489: invokevirtual 537	java/lang/Object:wait	(J)V
    //   492: iconst_0
    //   493: istore 7
    //   495: goto -77 -> 418
    //   498: iload 7
    //   500: istore 8
    //   502: aload 11
    //   504: monitorexit
    //   505: aload 10
    //   507: athrow
    //   508: astore 10
    //   510: goto -89 -> 421
    //   513: astore 10
    //   515: goto -17 -> 498
    //   518: astore 10
    //   520: iload 8
    //   522: istore 7
    //   524: goto -26 -> 498
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	527	0	paramLong	long
    //   0	527	2	paramString	String
    //   394	11	3	l1	long
    //   402	4	5	l2	long
    //   373	150	7	bool1	boolean
    //   369	152	8	bool2	boolean
    //   366	114	9	bool3	boolean
    //   64	442	10	localObject1	Object
    //   508	1	10	localInterruptedException	java.lang.InterruptedException
    //   513	1	10	localObject2	Object
    //   518	1	10	localObject3	Object
    //   60	443	11	localObject4	Object
    //   55	28	12	arrayOfStackTraceElement	java.lang.StackTraceElement[]
    // Exception table:
    //   from	to	target	type
    //   375	380	508	java/lang/InterruptedException
    //   384	387	508	java/lang/InterruptedException
    //   505	508	508	java/lang/InterruptedException
    //   418	421	513	finally
    //   391	395	518	finally
    //   399	404	518	finally
    //   483	492	518	finally
    //   502	505	518	finally
  }
  
  public static void a(akup paramakup)
  {
    int j = 1;
    if (paramakup == null) {
      return;
    }
    for (;;)
    {
      boolean bool;
      label57:
      SosoInterface.SosoLbsInfo localSosoLbsInfo;
      try
      {
        if (akup.access$1500(paramakup)) {
          akup.access$1502(paramakup, false);
        }
        bool = bbev.d(BaseApplicationImpl.getContext());
        if ((!b()) || ("official_location".equals(paramakup.tag))) {
          break label136;
        }
        i = 1;
      }
      finally {}
      if (i != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SOSO.LBS", 2, "startLocation() return. perCheckCode=" + i + " hasNet=" + bool);
        }
        localSosoLbsInfo = a(paramakup.level, true);
        if (paramakup.uiThread)
        {
          b(paramakup, i, localSosoLbsInfo);
          break;
          label136:
          i = 0;
        }
      }
      while (bool)
      {
        if (!jdField_a_of_type_Boolean)
        {
          i = -10001;
          break label57;
        }
        if (i != 0)
        {
          j = -10003;
          i = j;
          if (!QLog.isColorLevel()) {
            break label57;
          }
          QLog.i("SOSO.LBS", 2, "发现启动时定位业务：" + paramakup.tag);
          i = j;
          break label57;
          paramakup.onLocationFinish(i, localSosoLbsInfo);
          break;
          if (jdField_a_of_type_ComTencentMapGeolocationInternalTencentLog == null) {}
          ThreadManager.getSubThreadHandler().post(new SosoInterface.6(paramakup));
          break;
        }
        i = 0;
        break label57;
      }
      int i = j;
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    NewIntent localNewIntent = new NewIntent(BaseApplicationImpl.getApplication(), BuiltInServlet.class);
    localNewIntent.putExtra("action", 2204);
    localNewIntent.putExtra("longitude", paramString1);
    localNewIntent.putExtra("latitude", paramString2);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(localNewIntent);
  }
  
  public static void a(String paramString, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    for (;;)
    {
      return;
      if (jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo == null)
      {
        jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo = new SosoInterface.SosoLbsInfo();
        jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation = new SosoInterface.SosoLocation();
      }
      for (;;)
      {
        try
        {
          jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
          localJSONObject = new JSONObject(new String(paramArrayOfByte, "UTF-8"));
          d2 = 0.0D;
          d1 = d2;
        }
        catch (Exception localException)
        {
          JSONObject localJSONObject;
          Object localObject1;
          SosoInterface.SosoAttribute localSosoAttribute;
          ArrayList localArrayList1;
          int j;
          int i;
          Object localObject3;
          ArrayList localArrayList2;
          Object localObject2;
          continue;
        }
        try
        {
          localObject1 = localJSONObject.getJSONObject("location");
          d1 = d2;
          d2 = ((JSONObject)localObject1).getDouble("latitude");
          d1 = d2;
          d3 = ((JSONObject)localObject1).getDouble("longitude");
          d1 = d3;
        }
        catch (JSONException localJSONException2)
        {
          d3 = 0.0D;
          d2 = d1;
          d1 = d3;
          continue;
          bool = false;
          continue;
        }
        try
        {
          localObject1 = localJSONObject.getJSONObject("attribute");
          localSosoAttribute = new SosoInterface.SosoAttribute(((JSONObject)localObject1).getString("imei"), ((JSONObject)localObject1).getString("imsi"), ((JSONObject)localObject1).getString("phonenum"), ((JSONObject)localObject1).getString("qq"), ((JSONObject)localObject1).getBoolean("roaming"));
          localArrayList1 = new ArrayList();
          localObject1 = localJSONObject.getJSONArray("cells");
          j = ((JSONArray)localObject1).length();
          i = 0;
          if (i < j)
          {
            localObject3 = ((JSONArray)localObject1).getJSONObject(i);
            int k = ((JSONObject)localObject3).getInt("mcc");
            int m = ((JSONObject)localObject3).getInt("mnc");
            int n = ((JSONObject)localObject3).getInt("lac");
            int i1 = ((JSONObject)localObject3).getInt("cellid");
            int i2 = ((JSONObject)localObject3).getInt("rss");
            if (i != 0) {
              break label669;
            }
            bool = true;
            localArrayList1.add(new SosoInterface.SosoCell(k, m, n, i1, i2, bool));
            i += 1;
            continue;
          }
        }
        catch (JSONException localJSONException1)
        {
          localSosoAttribute = new SosoInterface.SosoAttribute("", "", "", "", false);
          continue;
          localArrayList2 = new ArrayList();
          localObject2 = localJSONObject.getJSONArray("wifis");
          i = 0;
          j = ((JSONArray)localObject2).length();
          if (i < j)
          {
            localObject3 = ((JSONArray)localObject2).getJSONObject(i);
            localArrayList2.add(new SosoInterface.SosoWifi(((JSONObject)localObject3).getString("mac"), ((JSONObject)localObject3).getInt("rssi")));
            i += 1;
            continue;
          }
          localObject2 = "";
          try
          {
            localObject3 = localJSONObject.getString("version");
            localObject2 = localObject3;
            l = localJSONObject.getLong("source");
          }
          catch (JSONException localJSONException3)
          {
            long l = 0L;
            Object localObject4 = localObject2;
            continue;
            i = paramString.code;
            continue;
          }
          if (d2 != 0.0D) {
            jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_c_of_type_Double = d2;
          }
          if (d1 != 0.0D) {
            jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_d_of_type_Double = d1;
          }
          jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute = localSosoAttribute;
          jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_JavaUtilArrayList = localArrayList1;
          jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_b_of_type_JavaUtilArrayList = localArrayList2;
          jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_Long = l;
          jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_JavaLangString = ((String)localObject3);
          jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_b_of_type_JavaLangString = paramString;
          jdField_a_of_type_Long = SystemClock.elapsedRealtime();
          if (c()) {
            break;
          }
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("provider", paramString);
          ((Bundle)localObject2).putByteArray("raw_data", paramArrayOfByte);
          ((Bundle)localObject2).putBoolean("req_location", false);
          paramString = QIPCClientHelper.getInstance().getClient().callServer("soso_interface", "set_lbs_info", (Bundle)localObject2);
          if (!QLog.isColorLevel()) {
            break;
          }
          paramArrayOfByte = new StringBuilder().append("update raw data, ipc result code: ");
          if (paramString == null)
          {
            i = -1;
            QLog.i("SOSO.LBS", 2, i);
            return;
          }
        }
      }
    }
  }
  
  public static boolean a()
  {
    return a().getInt("last_location_err_code", -1) == 0;
  }
  
  public static boolean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SOSO.LBS", 2, "saveSosoInterfaceConfig: " + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    a().edit().putString("config", paramString).commit();
    return true;
  }
  
  private static long b()
  {
    return a().getLong("normal_enter_conversation_time", 0L);
  }
  
  @Deprecated
  public static SosoInterface.SosoLbsInfo b()
  {
    if ((jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo == null) || (jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation == null)) {
      return null;
    }
    SosoInterface.SosoLbsInfo localSosoLbsInfo = new SosoInterface.SosoLbsInfo();
    localSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation = jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.a(4, true);
    return localSosoLbsInfo;
  }
  
  public static String b()
  {
    SosoInterface.SosoLbsInfo localSosoLbsInfo = b();
    if ((localSosoLbsInfo != null) && (localSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation != null) && (!TextUtils.isEmpty(localSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.f))) {
      return localSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.f;
    }
    return a().getString("adcode", "");
  }
  
  public static void b()
  {
    SharedPreferences localSharedPreferences = a();
    Object localObject = localSharedPreferences.getString("config", "");
    long l = localSharedPreferences.getLong("lastLocationTime", 0L);
    if (QLog.isColorLevel()) {
      QLog.i("SOSO.LBS", 2, "startOfficialLocation. config is: " + (String)localObject + " lastLocationTime: " + l);
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          localObject = new JSONObject((String)localObject);
          int i = ((JSONObject)localObject).getInt("isLoginLBSOpen");
          int j = ((JSONObject)localObject).getInt("loginLBSInterval");
          if ((i == 1) && (NetConnInfoCenter.getServerTime() - l >= j))
          {
            akug.a(new akul("official_location", false));
            localSharedPreferences.edit().putLong("lastLocationTime", NetConnInfoCenter.getServerTime()).commit();
            return;
          }
        }
        catch (JSONException localJSONException) {}
      }
    } while (!QLog.isDevelopLevel());
    localJSONException.printStackTrace();
  }
  
  private static void b(int paramInt)
  {
    a().edit().putInt("last_location_err_code", paramInt).commit();
  }
  
  private static void b(int paramInt, TencentLocation paramTencentLocation, String paramString)
  {
    if (paramTencentLocation == null) {
      return;
    }
    if (jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo == null)
    {
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo = new SosoInterface.SosoLbsInfo();
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation = new SosoInterface.SosoLocation();
    }
    jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_b_of_type_Double = paramTencentLocation.getLongitude();
    jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_a_of_type_Double = paramTencentLocation.getLatitude();
    jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.l = paramTencentLocation.getVerifyKey();
    jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_a_of_type_Int = paramTencentLocation.getFakeReason();
    jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_a_of_type_Long = paramTencentLocation.getTime();
    jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_b_of_type_Float = paramTencentLocation.getSpeed();
    jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.m = paramTencentLocation.getSourceProvider();
    Object localObject;
    switch (paramInt)
    {
    case 2: 
    default: 
      jdField_b_of_type_Long = SystemClock.elapsedRealtime();
      if (jdField_b_of_type_Long - jdField_c_of_type_Long > 3000L)
      {
        a(String.valueOf(paramTencentLocation.getLongitude()), String.valueOf(paramTencentLocation.getLatitude()));
        jdField_c_of_type_Long = jdField_b_of_type_Long;
        if (QLog.isColorLevel()) {
          QLog.d("SOSO.LBS", 2, "saveGeogInfo cost: " + (SystemClock.elapsedRealtime() - jdField_c_of_type_Long));
        }
      }
      if (!c())
      {
        paramTencentLocation = new Bundle();
        paramTencentLocation.putInt("level", paramInt);
        paramTencentLocation.putBoolean("req_location", true);
        paramTencentLocation.putParcelable("soso_lbs_info", jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo);
        paramTencentLocation = QIPCClientHelper.getInstance().getClient().callServer("soso_interface", "set_lbs_info", paramTencentLocation);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder().append("update location ipc result code: ");
          if (paramTencentLocation != null) {
            break label687;
          }
        }
      }
      break;
    }
    label687:
    for (paramInt = -1;; paramInt = paramTencentLocation.code)
    {
      QLog.i("SOSO.LBS", 2, paramInt);
      akuf.a(jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation, paramString);
      return;
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_a_of_type_JavaUtilList = paramTencentLocation.getPoiList();
      jdField_a_of_type_ArrayOfLong[4] = SystemClock.elapsedRealtime();
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_c_of_type_JavaLangString = paramTencentLocation.getNation();
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_d_of_type_JavaLangString = paramTencentLocation.getProvince();
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_e_of_type_JavaLangString = paramTencentLocation.getCity();
      localObject = paramTencentLocation.getCityCode();
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equalsIgnoreCase("unknown"))) {
        jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.f = ((String)localObject);
      }
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.g = paramTencentLocation.getDistrict();
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.h = paramTencentLocation.getTown();
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.i = paramTencentLocation.getVillage();
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.j = paramTencentLocation.getStreet();
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.k = paramTencentLocation.getStreetNo();
      jdField_a_of_type_ArrayOfLong[3] = SystemClock.elapsedRealtime();
      a().edit().putString("adcode", jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.f);
      a().edit().putString("city", jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_e_of_type_JavaLangString).commit();
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_a_of_type_JavaLangString = paramTencentLocation.getName();
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_b_of_type_JavaLangString = paramTencentLocation.getAddress();
      jdField_a_of_type_ArrayOfLong[1] = SystemClock.elapsedRealtime();
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_e_of_type_Double = paramTencentLocation.getAltitude();
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_a_of_type_Float = paramTencentLocation.getAccuracy();
      jdField_a_of_type_ArrayOfLong[0] = SystemClock.elapsedRealtime();
      break;
    }
  }
  
  public static void b(akup paramakup)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      jdField_a_of_type_JavaUtilArrayList.remove(paramakup);
      akup.access$1502(paramakup, true);
      akup.access$1602(paramakup, false);
      if (QLog.isColorLevel()) {
        QLog.d("SOSO.LBS", 2, "removeOnLocationListener() lis=" + paramakup.tag + " removed.");
      }
      if (jdField_a_of_type_JavaUtilArrayList.size() == 0)
      {
        ThreadManager.getSubThreadHandler().post(new SosoInterface.7());
        if (QLog.isColorLevel()) {
          QLog.d("SOSO.LBS", 2, "removeOnLocationListener() listener is empty. remveUpdate and stop LBS");
        }
      }
      return;
    }
  }
  
  private static void b(akup paramakup, int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (paramakup == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new SosoInterface.5(paramakup, paramInt, paramSosoLbsInfo));
  }
  
  private static void b(boolean paramBoolean1, boolean paramBoolean2, long paramLong, int paramInt1, String paramString1, String paramString2, boolean paramBoolean3, int paramInt2, boolean paramBoolean4)
  {
    if ((String.valueOf(paramString2).equals("ERROR_NETWORK")) && ((paramInt1 == -4) || (paramInt1 == -17)))
    {
      break label28;
      break label28;
    }
    label28:
    while (((paramBoolean1) || (!HwNetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext()))) && (!paramBoolean1)) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", Integer.toString(paramInt1));
    if ((paramString1 != null) && (paramString1.length() > 0)) {
      localHashMap.put("param_caller", paramString1);
    }
    if ((paramString2 != null) && (paramString2.length() > 0)) {
      localHashMap.put("param_reason", paramString2);
    }
    localHashMap.put("param_useCache", Boolean.toString(paramBoolean4));
    localHashMap.put("param_askGps", Boolean.toString(paramBoolean3));
    localHashMap.put("param_costTime", Long.toString(paramLong));
    localHashMap.put("param_level", String.valueOf(paramInt2));
    String str = anox.a();
    if (paramBoolean4) {
      if (paramBoolean2)
      {
        paramString2 = "actSosoLocationCache";
        label191:
        axrl.a(BaseApplicationImpl.getContext()).a(str, paramString2, paramBoolean1, paramLong, 0L, localHashMap, "");
        paramString2 = axsn.a();
        if (!paramBoolean2) {
          break label407;
        }
      }
    }
    for (;;)
    {
      paramString2.a("requestSoso", new Object[] { Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean3), paramString1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
      if (!b()) {
        break;
      }
      paramString2 = new HashMap();
      if ((paramString1 == null) || (paramString1.length() <= 0)) {
        break;
      }
      paramString2.put("param_caller", paramString1);
      axrl.a(BaseApplicationImpl.getContext()).a(str, "actLocationEarly", paramBoolean1, paramLong, 0L, paramString2, "");
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("SOSO.LBS", 2, "location too early: " + paramString1);
      return;
      paramString2 = "actSosoRawDataCache";
      break label191;
      if (paramBoolean2)
      {
        paramString2 = "actSosoLocation";
        break label191;
      }
      paramString2 = "actSosoRawData";
      break label191;
      label407:
      paramInt2 = -1;
    }
  }
  
  public static boolean b()
  {
    if (!jdField_b_of_type_Boolean) {
      return false;
    }
    if (c()) {}
    for (long l = Conversation.jdField_b_of_type_Long; (l > 0L) && (SystemClock.elapsedRealtime() - l < 60000L); l = b()) {
      return true;
    }
    jdField_b_of_type_Boolean = false;
    return false;
  }
  
  private static boolean c()
  {
    return BaseApplicationImpl.sProcessId == 1;
  }
  
  private static void d(akup paramakup)
  {
    if (paramakup == null) {
      return;
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (!jdField_a_of_type_JavaUtilArrayList.contains(paramakup)) {
        jdField_a_of_type_JavaUtilArrayList.add(paramakup);
      }
      return;
    }
  }
  
  private static void e()
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
    if ((jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener != null) && (jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager != null))
    {
      jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager.removeUpdates(jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener);
      jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager = null;
    }
    jdField_b_of_type_Int = 0;
    if (QLog.isColorLevel()) {
      QLog.d("SOSO.LBS", 2, "stopLocation() stop LBS");
    }
  }
  
  private static void f()
  {
    for (;;)
    {
      int i;
      akup localakup;
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
          return;
        }
        i = jdField_a_of_type_JavaUtilArrayList.size() - 1;
        if (i < 0) {
          break label107;
        }
        localakup = (akup)jdField_a_of_type_JavaUtilArrayList.get(i);
        if (localakup == null) {
          break label116;
        }
        if (localakup.reqLocation)
        {
          SosoInterface.SosoLbsInfo localSosoLbsInfo1 = a(localakup.level, true);
          if (!localakup.uiThread) {
            break label96;
          }
          b(localakup, -10000, localSosoLbsInfo1);
        }
      }
      SosoInterface.SosoLbsInfo localSosoLbsInfo2 = a(true);
      continue;
      label96:
      localakup.onLocationFinish(-10000, localSosoLbsInfo2);
      break label116;
      label107:
      jdField_a_of_type_JavaUtilArrayList.clear();
      return;
      label116:
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.soso.SosoInterface
 * JD-Core Version:    0.7.0.1
 */