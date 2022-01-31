package com.tencent.mobileqq.app.soso;

import ampj;
import ampk;
import ampo;
import ampp;
import ampq;
import ampr;
import amps;
import ampt;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import apks;
import azri;
import azsk;
import bdin;
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
  private static final ampt jdField_a_of_type_Ampt;
  private static Handler jdField_a_of_type_AndroidOsHandler;
  private static TencentLocationListener jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener;
  private static TencentLocationManager jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager;
  private static TencentLog jdField_a_of_type_ComTencentMapGeolocationInternalTencentLog;
  private static SosoInterface.SosoLbsInfo jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo;
  private static final Object jdField_a_of_type_JavaLangObject;
  public static volatile String a;
  private static final ArrayList<ampt> jdField_a_of_type_JavaUtilArrayList;
  private static final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  public static volatile boolean a;
  private static long[] jdField_a_of_type_ArrayOfLong;
  private static int jdField_b_of_type_Int;
  private static long jdField_b_of_type_Long;
  private static boolean jdField_b_of_type_Boolean;
  private static int jdField_c_of_type_Int;
  private static long jdField_c_of_type_Long;
  private static boolean jdField_c_of_type_Boolean;
  private static int jdField_d_of_type_Int;
  private static long jdField_d_of_type_Long;
  private static int e;
  
  static
  {
    jdField_a_of_type_Int = 2000;
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_JavaLangString = "";
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), new ampo());
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    jdField_a_of_type_ArrayOfLong = new long[] { 0L, 0L, 0L, 0L, 0L };
    jdField_b_of_type_Boolean = true;
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    localIntentFilter.addAction("android.intent.action.SCREEN_ON");
    ampq localampq = new ampq();
    try
    {
      BaseApplicationImpl.getContext().registerReceiver(localampq, localIntentFilter);
      jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener = new ampr();
      jdField_a_of_type_Ampt = new amps(0, false, false, 0L, false, false, "reqRawData");
      jdField_c_of_type_Boolean = true;
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
    ThreadManager.getSubThreadHandler().post(new SosoInterface.9());
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
    //   0: invokestatic 432	com/tencent/mobileqq/app/ThreadManager:getSubThread	()Ljava/lang/Thread;
    //   3: invokestatic 437	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   6: if_acmpeq +15 -> 21
    //   9: invokestatic 437	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   12: invokestatic 442	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   15: invokevirtual 445	android/os/Looper:getThread	()Ljava/lang/Thread;
    //   18: if_acmpne +31 -> 49
    //   21: new 447	android/util/AndroidRuntimeException
    //   24: dup
    //   25: new 179	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   32: ldc_w 449
    //   35: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_2
    //   39: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokespecial 451	android/util/AndroidRuntimeException:<init>	(Ljava/lang/String;)V
    //   48: athrow
    //   49: invokestatic 437	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   52: invokevirtual 455	java/lang/Thread:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   55: astore 12
    //   57: ldc 37
    //   59: astore 11
    //   61: aload 11
    //   63: astore 10
    //   65: aload 12
    //   67: ifnull +95 -> 162
    //   70: aload 11
    //   72: astore 10
    //   74: aload 12
    //   76: arraylength
    //   77: iconst_4
    //   78: if_icmplt +84 -> 162
    //   81: aload 12
    //   83: iconst_3
    //   84: aaload
    //   85: astore 10
    //   87: new 179	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   94: aload 10
    //   96: invokevirtual 460	java/lang/StackTraceElement:getClassName	()Ljava/lang/String;
    //   99: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: ldc_w 462
    //   105: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: aload 10
    //   110: invokevirtual 465	java/lang/StackTraceElement:getMethodName	()Ljava/lang/String;
    //   113: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: astore 11
    //   121: aload 11
    //   123: astore 10
    //   125: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   128: ifeq +34 -> 162
    //   131: ldc 177
    //   133: iconst_2
    //   134: new 179	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   141: ldc_w 467
    //   144: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: aload 11
    //   149: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokestatic 199	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   158: aload 11
    //   160: astore 10
    //   162: lload_0
    //   163: lconst_0
    //   164: lcmp
    //   165: ifle +139 -> 304
    //   168: invokestatic 206	android/os/SystemClock:elapsedRealtime	()J
    //   171: getstatic 210	com/tencent/mobileqq/app/soso/SosoInterface:jdField_a_of_type_Long	J
    //   174: lload_0
    //   175: ladd
    //   176: lcmp
    //   177: ifge +127 -> 304
    //   180: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   183: ifeq +29 -> 212
    //   186: ldc 177
    //   188: iconst_2
    //   189: new 179	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   196: ldc_w 469
    //   199: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload_2
    //   203: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: invokestatic 471	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   212: new 473	java/util/HashMap
    //   215: dup
    //   216: invokespecial 474	java/util/HashMap:<init>	()V
    //   219: astore 11
    //   221: aload_2
    //   222: ifnull +20 -> 242
    //   225: aload_2
    //   226: invokevirtual 477	java/lang/String:length	()I
    //   229: ifle +13 -> 242
    //   232: aload 11
    //   234: ldc_w 479
    //   237: aload_2
    //   238: invokevirtual 483	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   241: pop
    //   242: aload 10
    //   244: invokestatic 324	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   247: ifne +14 -> 261
    //   250: aload 11
    //   252: ldc_w 485
    //   255: aload 10
    //   257: invokevirtual 483	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   260: pop
    //   261: aload 11
    //   263: ldc_w 487
    //   266: getstatic 493	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   269: invokevirtual 496	java/lang/Boolean:booleanValue	()Z
    //   272: invokestatic 499	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   275: invokevirtual 483	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   278: pop
    //   279: invokestatic 503	apks:a	()Ljava/lang/String;
    //   282: astore_2
    //   283: invokestatic 91	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   286: invokestatic 508	azri:a	(Landroid/content/Context;)Lazri;
    //   289: aload_2
    //   290: ldc_w 510
    //   293: iconst_1
    //   294: lconst_0
    //   295: lconst_0
    //   296: aload 11
    //   298: ldc 37
    //   300: invokevirtual 513	azri:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   303: return
    //   304: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   307: ifeq +39 -> 346
    //   310: ldc 177
    //   312: iconst_2
    //   313: new 179	java/lang/StringBuilder
    //   316: dup
    //   317: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   320: ldc_w 515
    //   323: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: aload_2
    //   327: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: ldc_w 517
    //   333: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: lload_0
    //   337: invokevirtual 189	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   340: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: invokestatic 471	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   346: getstatic 111	com/tencent/mobileqq/app/soso/SosoInterface:jdField_a_of_type_Ampt	Lampt;
    //   349: aload_2
    //   350: putfield 522	ampt:tag	Ljava/lang/String;
    //   353: getstatic 111	com/tencent/mobileqq/app/soso/SosoInterface:jdField_a_of_type_Ampt	Lampt;
    //   356: invokestatic 525	com/tencent/mobileqq/app/soso/SosoInterface:a	(Lampt;)V
    //   359: invokestatic 206	android/os/SystemClock:elapsedRealtime	()J
    //   362: lstore_0
    //   363: iconst_0
    //   364: istore 9
    //   366: iconst_0
    //   367: istore 8
    //   369: iload 8
    //   371: istore 7
    //   373: getstatic 35	com/tencent/mobileqq/app/soso/SosoInterface:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   376: astore 11
    //   378: iload 8
    //   380: istore 7
    //   382: aload 11
    //   384: monitorenter
    //   385: iload 9
    //   387: istore 8
    //   389: invokestatic 206	android/os/SystemClock:elapsedRealtime	()J
    //   392: lstore_3
    //   393: iload 9
    //   395: istore 8
    //   397: getstatic 210	com/tencent/mobileqq/app/soso/SosoInterface:jdField_a_of_type_Long	J
    //   400: lstore 5
    //   402: lload_3
    //   403: lload 5
    //   405: ldc2_w 526
    //   408: ladd
    //   409: lcmp
    //   410: ifge +67 -> 477
    //   413: iconst_1
    //   414: istore 7
    //   416: aload 11
    //   418: monitorexit
    //   419: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   422: ifeq -119 -> 303
    //   425: ldc 177
    //   427: iconst_2
    //   428: new 179	java/lang/StringBuilder
    //   431: dup
    //   432: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   435: ldc_w 529
    //   438: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: aload_2
    //   442: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: ldc_w 531
    //   448: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: iload 7
    //   453: invokevirtual 283	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   456: ldc_w 533
    //   459: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: invokestatic 206	android/os/SystemClock:elapsedRealtime	()J
    //   465: lload_0
    //   466: lsub
    //   467: invokevirtual 189	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   470: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   473: invokestatic 471	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   476: return
    //   477: iload 9
    //   479: istore 8
    //   481: getstatic 35	com/tencent/mobileqq/app/soso/SosoInterface:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   484: ldc2_w 534
    //   487: invokevirtual 538	java/lang/Object:wait	(J)V
    //   490: iconst_0
    //   491: istore 7
    //   493: goto -77 -> 416
    //   496: iload 7
    //   498: istore 8
    //   500: aload 11
    //   502: monitorexit
    //   503: aload 10
    //   505: athrow
    //   506: astore 10
    //   508: goto -89 -> 419
    //   511: astore 10
    //   513: goto -17 -> 496
    //   516: astore 10
    //   518: iload 8
    //   520: istore 7
    //   522: goto -26 -> 496
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	525	0	paramLong	long
    //   0	525	2	paramString	String
    //   392	11	3	l1	long
    //   400	4	5	l2	long
    //   371	150	7	bool1	boolean
    //   367	152	8	bool2	boolean
    //   364	114	9	bool3	boolean
    //   63	441	10	localObject1	Object
    //   506	1	10	localInterruptedException	java.lang.InterruptedException
    //   511	1	10	localObject2	Object
    //   516	1	10	localObject3	Object
    //   59	442	11	localObject4	Object
    //   55	27	12	arrayOfStackTraceElement	java.lang.StackTraceElement[]
    // Exception table:
    //   from	to	target	type
    //   373	378	506	java/lang/InterruptedException
    //   382	385	506	java/lang/InterruptedException
    //   503	506	506	java/lang/InterruptedException
    //   416	419	511	finally
    //   389	393	516	finally
    //   397	402	516	finally
    //   481	490	516	finally
    //   500	503	516	finally
  }
  
  public static void a(ampt paramampt)
  {
    int j = 1;
    if (paramampt == null) {
      return;
    }
    for (;;)
    {
      boolean bool;
      label57:
      try
      {
        if (ampt.access$1500(paramampt)) {
          ampt.access$1502(paramampt, false);
        }
        bool = bdin.d(BaseApplicationImpl.getContext());
        if ((!b()) || ("official_location".equals(paramampt.tag))) {
          break label151;
        }
        i = 1;
      }
      finally {}
      if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
        jdField_a_of_type_JavaLangString = c();
      }
      SosoInterface.SosoLbsInfo localSosoLbsInfo;
      if (i != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SOSO.LBS", 2, "startLocation() return. perCheckCode=" + i + " hasNet=" + bool);
        }
        localSosoLbsInfo = a(paramampt.level, true);
        if (paramampt.uiThread)
        {
          b(paramampt, i, localSosoLbsInfo);
          break;
          label151:
          i = 0;
        }
      }
      while (bool)
      {
        if (!jdField_b_of_type_Boolean)
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
          QLog.i("SOSO.LBS", 2, "发现启动时定位业务：" + paramampt.tag);
          i = j;
          break label57;
          paramampt.onLocationFinish(i, localSosoLbsInfo);
          break;
          if (jdField_a_of_type_ComTencentMapGeolocationInternalTencentLog == null) {}
          ThreadManager.getSubThreadHandler().post(new SosoInterface.6(paramampt));
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
              break label664;
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
            if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
              jdField_a_of_type_JavaLangString = c();
            }
            ampk.a(new ampp("official_location", false));
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
      ampj.a(jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation, paramString);
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
  
  public static void b(ampt paramampt)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      jdField_a_of_type_JavaUtilArrayList.remove(paramampt);
      ampt.access$1502(paramampt, true);
      ampt.access$1602(paramampt, false);
      if (QLog.isColorLevel()) {
        QLog.d("SOSO.LBS", 2, "removeOnLocationListener() lis=" + paramampt.tag + " removed.");
      }
      if (jdField_a_of_type_JavaUtilArrayList.size() == 0)
      {
        ThreadManager.getSubThreadHandler().post(new SosoInterface.8());
        if (QLog.isColorLevel()) {
          QLog.d("SOSO.LBS", 2, "removeOnLocationListener() listener is empty. remveUpdate and stop LBS");
        }
      }
      return;
    }
  }
  
  private static void b(ampt paramampt, int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (paramampt == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new SosoInterface.5(paramampt, paramInt, paramSosoLbsInfo));
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
    String str = apks.a();
    if (paramBoolean4) {
      if (paramBoolean2)
      {
        paramString2 = "actSosoLocationCache";
        label191:
        azri.a(BaseApplicationImpl.getContext()).a(str, paramString2, paramBoolean1, paramLong, 0L, localHashMap, "");
        paramString2 = azsk.a();
        if (!paramBoolean2) {
          break label405;
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
      azri.a(BaseApplicationImpl.getContext()).a(str, "actLocationEarly", paramBoolean1, paramLong, 0L, paramString2, "");
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
      label405:
      paramInt2 = -1;
    }
  }
  
  public static boolean b()
  {
    if (!jdField_c_of_type_Boolean) {
      return false;
    }
    if (c()) {}
    for (long l = Conversation.jdField_b_of_type_Long; (l > 0L) && (SystemClock.elapsedRealtime() - l < 60000L); l = b()) {
      return true;
    }
    jdField_c_of_type_Boolean = false;
    return false;
  }
  
  /* Error */
  private static String c()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 972	com/tencent/mobileqq/app/soso/SosoInterface:jdField_a_of_type_Boolean	Z
    //   6: ifeq +12 -> 18
    //   9: getstatic 39	com/tencent/mobileqq/app/soso/SosoInterface:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   12: astore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: iconst_1
    //   19: putstatic 972	com/tencent/mobileqq/app/soso/SosoInterface:jdField_a_of_type_Boolean	Z
    //   22: invokestatic 340	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   25: new 974	com/tencent/mobileqq/app/soso/SosoInterface$7
    //   28: dup
    //   29: invokespecial 975	com/tencent/mobileqq/app/soso/SosoInterface$7:<init>	()V
    //   32: invokevirtual 349	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   35: pop
    //   36: getstatic 39	com/tencent/mobileqq/app/soso/SosoInterface:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   39: astore_0
    //   40: goto -27 -> 13
    //   43: astore_0
    //   44: ldc 2
    //   46: monitorexit
    //   47: aload_0
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	28	0	str	String
    //   43	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	13	43	finally
    //   18	40	43	finally
  }
  
  private static boolean c()
  {
    return BaseApplicationImpl.sProcessId == 1;
  }
  
  private static void d(ampt paramampt)
  {
    if (paramampt == null) {
      return;
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (!jdField_a_of_type_JavaUtilArrayList.contains(paramampt)) {
        jdField_a_of_type_JavaUtilArrayList.add(paramampt);
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
      ampt localampt;
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
          return;
        }
        i = jdField_a_of_type_JavaUtilArrayList.size() - 1;
        if (i < 0) {
          break label107;
        }
        localampt = (ampt)jdField_a_of_type_JavaUtilArrayList.get(i);
        if (localampt == null) {
          break label116;
        }
        if (localampt.reqLocation)
        {
          SosoInterface.SosoLbsInfo localSosoLbsInfo1 = a(localampt.level, true);
          if (!localampt.uiThread) {
            break label96;
          }
          b(localampt, -10000, localSosoLbsInfo1);
        }
      }
      SosoInterface.SosoLbsInfo localSosoLbsInfo2 = a(true);
      continue;
      label96:
      localampt.onLocationFinish(-10000, localSosoLbsInfo2);
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