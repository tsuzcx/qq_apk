package com.tencent.mobileqq.app.soso;

import NearbyGroup.Attr;
import NearbyGroup.Cell;
import NearbyGroup.GPS;
import NearbyGroup.LBSInfo;
import NearbyGroup.Wifi;
import aacn;
import aaco;
import aacp;
import aacq;
import aacr;
import aacu;
import aacv;
import aacw;
import aacx;
import aacy;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.geolocation.internal.TencentLog;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.highway.utils.HwNetworkUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.battery.BatteryStatsImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
  private static SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private static Handler jdField_a_of_type_AndroidOsHandler;
  private static TencentLocationListener jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener;
  private static TencentLocationManager jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager;
  private static TencentLog jdField_a_of_type_ComTencentMapGeolocationInternalTencentLog;
  private static final SosoInterface.OnLocationListener jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener;
  public static SosoInterface.SosoLbsInfo a;
  public static final Object a;
  private static final ArrayList jdField_a_of_type_JavaUtilArrayList;
  private static final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private static boolean jdField_a_of_type_Boolean;
  private static long[] jdField_a_of_type_ArrayOfLong;
  private static int b;
  public static long b;
  private static int c;
  public static long c;
  private static int jdField_d_of_type_Int;
  private static long jdField_d_of_type_Long;
  
  static
  {
    jdField_a_of_type_Int = 2000;
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), new aacn());
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    jdField_a_of_type_ArrayOfLong = new long[] { 0L, 0L, 0L, 0L, 0L };
    jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("sosoCache", 4);
    jdField_a_of_type_Boolean = true;
    if (BaseApplicationImpl.sProcessId == 1) {
      jdField_a_of_type_AndroidContentSharedPreferences.edit().clear().commit();
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    localIntentFilter.addAction("android.intent.action.SCREEN_ON");
    aacq localaacq = new aacq();
    try
    {
      BaseApplicationImpl.getContext().registerReceiver(localaacq, localIntentFilter);
      jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener = new aacr();
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener = new aacu(0, false, false, 0L, false, false, "reqRawData");
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
  
  public static LBSInfo a()
  {
    return a(false, a());
  }
  
  public static LBSInfo a(boolean paramBoolean, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    Attr localAttr = null;
    if (paramSosoLbsInfo == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    Object localObject2;
    if (paramSosoLbsInfo.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject1 = paramSosoLbsInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (SosoInterface.SosoCell)((Iterator)localObject1).next();
        localArrayList.add(new Cell((short)((SosoInterface.SosoCell)localObject2).jdField_a_of_type_Int, (short)((SosoInterface.SosoCell)localObject2).jdField_b_of_type_Int, ((SosoInterface.SosoCell)localObject2).jdField_c_of_type_Int, ((SosoInterface.SosoCell)localObject2).jdField_d_of_type_Int, (short)((SosoInterface.SosoCell)localObject2).e));
      }
    }
    for (;;)
    {
      try
      {
        if (paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation == null) {
          break label313;
        }
        if (!paramBoolean) {
          continue;
        }
        localObject1 = new GPS((int)(paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_a_of_type_Double * 1000000.0D), (int)(paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_b_of_type_Double * 1000000.0D), -1, 1);
      }
      catch (Exception localException)
      {
        Iterator localIterator;
        SosoInterface.SosoWifi localSosoWifi;
        localGPS = null;
        continue;
        if (paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute == null) {
          continue;
        }
        localAttr = new Attr(paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute.jdField_a_of_type_JavaLangString, paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute.jdField_b_of_type_JavaLangString, paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute.jdField_c_of_type_JavaLangString);
        return new LBSInfo(localGPS, (ArrayList)localObject2, localArrayList, localAttr);
      }
      localObject2 = new ArrayList();
      if (paramSosoLbsInfo.jdField_b_of_type_JavaUtilArrayList != null)
      {
        localIterator = paramSosoLbsInfo.jdField_b_of_type_JavaUtilArrayList.iterator();
        if (localIterator.hasNext())
        {
          localSosoWifi = (SosoInterface.SosoWifi)localIterator.next();
          if (localSosoWifi == null) {
            continue;
          }
          ((ArrayList)localObject2).add(new Wifi(localSosoWifi.jdField_a_of_type_Long, (short)localSosoWifi.jdField_a_of_type_Int));
          continue;
          localObject1 = new GPS((int)(paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_c_of_type_Double * 1000000.0D), (int)(paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_d_of_type_Double * 1000000.0D), -1, 0);
          continue;
        }
      }
      label313:
      GPS localGPS = null;
    }
  }
  
  private static SharedPreferences a()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("sosoConfig", 4);
  }
  
  public static SosoInterface.SosoLbsInfo a()
  {
    if (jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo == null) {
      return null;
    }
    SosoInterface.SosoLbsInfo localSosoLbsInfo = new SosoInterface.SosoLbsInfo();
    localSosoLbsInfo.jdField_a_of_type_ArrayOfByte = jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ArrayOfByte;
    if (jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation != null) {
      localSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation = jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.a();
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
    ThreadManager.getSubThreadHandler().post(new aacy());
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      jdField_a_of_type_JavaUtilArrayList.clear();
      return;
    }
  }
  
  public static void a(long paramLong)
  {
    a().edit().putLong("normal_enter_conversation_time", paramLong).commit();
  }
  
  /* Error */
  @java.lang.Deprecated
  public static void a(long paramLong, String paramString)
  {
    // Byte code:
    //   0: invokestatic 337	com/tencent/mobileqq/app/ThreadManager:getSubThread	()Ljava/lang/Thread;
    //   3: invokestatic 342	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   6: if_acmpeq +15 -> 21
    //   9: invokestatic 342	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   12: invokestatic 347	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   15: invokevirtual 350	android/os/Looper:getThread	()Ljava/lang/Thread;
    //   18: if_acmpne +31 -> 49
    //   21: new 352	android/util/AndroidRuntimeException
    //   24: dup
    //   25: new 354	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 355	java/lang/StringBuilder:<init>	()V
    //   32: ldc_w 357
    //   35: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_2
    //   39: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 364	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokespecial 366	android/util/AndroidRuntimeException:<init>	(Ljava/lang/String;)V
    //   48: athrow
    //   49: invokestatic 342	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   52: invokevirtual 370	java/lang/Thread:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   55: astore 12
    //   57: ldc_w 296
    //   60: astore 11
    //   62: aload 11
    //   64: astore 10
    //   66: aload 12
    //   68: ifnull +96 -> 164
    //   71: aload 11
    //   73: astore 10
    //   75: aload 12
    //   77: arraylength
    //   78: iconst_4
    //   79: if_icmplt +85 -> 164
    //   82: aload 12
    //   84: iconst_3
    //   85: aaload
    //   86: astore 10
    //   88: new 354	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 355	java/lang/StringBuilder:<init>	()V
    //   95: aload 10
    //   97: invokevirtual 375	java/lang/StackTraceElement:getClassName	()Ljava/lang/String;
    //   100: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: ldc_w 377
    //   106: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload 10
    //   111: invokevirtual 380	java/lang/StackTraceElement:getMethodName	()Ljava/lang/String;
    //   114: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 364	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: astore 11
    //   122: aload 11
    //   124: astore 10
    //   126: invokestatic 383	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   129: ifeq +35 -> 164
    //   132: ldc_w 385
    //   135: iconst_2
    //   136: new 354	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 355	java/lang/StringBuilder:<init>	()V
    //   143: ldc_w 387
    //   146: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload 11
    //   151: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 364	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokestatic 391	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   160: aload 11
    //   162: astore 10
    //   164: lload_0
    //   165: lconst_0
    //   166: lcmp
    //   167: ifle +141 -> 308
    //   170: invokestatic 396	android/os/SystemClock:elapsedRealtime	()J
    //   173: getstatic 397	com/tencent/mobileqq/app/soso/SosoInterface:jdField_a_of_type_Long	J
    //   176: lload_0
    //   177: ladd
    //   178: lcmp
    //   179: ifge +129 -> 308
    //   182: invokestatic 383	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   185: ifeq +30 -> 215
    //   188: ldc_w 385
    //   191: iconst_2
    //   192: new 354	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 355	java/lang/StringBuilder:<init>	()V
    //   199: ldc_w 399
    //   202: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload_2
    //   206: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: invokevirtual 364	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 401	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   215: new 403	java/util/HashMap
    //   218: dup
    //   219: invokespecial 404	java/util/HashMap:<init>	()V
    //   222: astore 11
    //   224: aload_2
    //   225: ifnull +20 -> 245
    //   228: aload_2
    //   229: invokevirtual 409	java/lang/String:length	()I
    //   232: ifle +13 -> 245
    //   235: aload 11
    //   237: ldc_w 411
    //   240: aload_2
    //   241: invokevirtual 415	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   244: pop
    //   245: aload 10
    //   247: invokestatic 290	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   250: ifne +14 -> 264
    //   253: aload 11
    //   255: ldc_w 417
    //   258: aload 10
    //   260: invokevirtual 415	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   263: pop
    //   264: aload 11
    //   266: ldc_w 419
    //   269: getstatic 425	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   272: invokevirtual 428	java/lang/Boolean:booleanValue	()Z
    //   275: invokestatic 431	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   278: invokevirtual 415	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   281: pop
    //   282: invokestatic 435	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:a	()Ljava/lang/String;
    //   285: astore_2
    //   286: invokestatic 115	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   289: invokestatic 440	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   292: aload_2
    //   293: ldc_w 442
    //   296: iconst_1
    //   297: lconst_0
    //   298: lconst_0
    //   299: aload 11
    //   301: ldc_w 296
    //   304: invokevirtual 445	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   307: return
    //   308: invokestatic 383	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   311: ifeq +40 -> 351
    //   314: ldc_w 385
    //   317: iconst_2
    //   318: new 354	java/lang/StringBuilder
    //   321: dup
    //   322: invokespecial 355	java/lang/StringBuilder:<init>	()V
    //   325: ldc_w 447
    //   328: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: aload_2
    //   332: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: ldc_w 449
    //   338: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: lload_0
    //   342: invokevirtual 452	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   345: invokevirtual 364	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokestatic 401	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   351: getstatic 135	com/tencent/mobileqq/app/soso/SosoInterface:jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener	Lcom/tencent/mobileqq/app/soso/SosoInterface$OnLocationListener;
    //   354: aload_2
    //   355: putfield 455	com/tencent/mobileqq/app/soso/SosoInterface$OnLocationListener:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   358: getstatic 135	com/tencent/mobileqq/app/soso/SosoInterface:jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener	Lcom/tencent/mobileqq/app/soso/SosoInterface$OnLocationListener;
    //   361: invokestatic 458	com/tencent/mobileqq/app/soso/SosoInterface:a	(Lcom/tencent/mobileqq/app/soso/SosoInterface$OnLocationListener;)V
    //   364: invokestatic 396	android/os/SystemClock:elapsedRealtime	()J
    //   367: lstore_0
    //   368: iconst_0
    //   369: istore 9
    //   371: iconst_0
    //   372: istore 8
    //   374: iload 8
    //   376: istore 7
    //   378: getstatic 33	com/tencent/mobileqq/app/soso/SosoInterface:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   381: astore 11
    //   383: iload 8
    //   385: istore 7
    //   387: aload 11
    //   389: monitorenter
    //   390: iload 9
    //   392: istore 8
    //   394: invokestatic 396	android/os/SystemClock:elapsedRealtime	()J
    //   397: lstore_3
    //   398: iload 9
    //   400: istore 8
    //   402: getstatic 397	com/tencent/mobileqq/app/soso/SosoInterface:jdField_a_of_type_Long	J
    //   405: lstore 5
    //   407: lload_3
    //   408: lload 5
    //   410: ldc2_w 459
    //   413: ladd
    //   414: lcmp
    //   415: ifge +80 -> 495
    //   418: iconst_1
    //   419: istore 7
    //   421: aload 11
    //   423: monitorexit
    //   424: invokestatic 383	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   427: ifeq -120 -> 307
    //   430: ldc_w 385
    //   433: iconst_2
    //   434: new 354	java/lang/StringBuilder
    //   437: dup
    //   438: invokespecial 355	java/lang/StringBuilder:<init>	()V
    //   441: ldc_w 462
    //   444: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: getstatic 465	com/tencent/mobileqq/app/NearbyHandler:jdField_a_of_type_Int	I
    //   450: invokevirtual 468	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   453: ldc_w 470
    //   456: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: aload_2
    //   460: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: ldc_w 472
    //   466: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: iload 7
    //   471: invokevirtual 475	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   474: ldc_w 477
    //   477: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: invokestatic 396	android/os/SystemClock:elapsedRealtime	()J
    //   483: lload_0
    //   484: lsub
    //   485: invokevirtual 452	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   488: invokevirtual 364	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   491: invokestatic 401	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   494: return
    //   495: iload 9
    //   497: istore 8
    //   499: getstatic 33	com/tencent/mobileqq/app/soso/SosoInterface:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   502: ldc2_w 478
    //   505: invokevirtual 482	java/lang/Object:wait	(J)V
    //   508: iconst_0
    //   509: istore 7
    //   511: goto -90 -> 421
    //   514: iload 7
    //   516: istore 8
    //   518: aload 11
    //   520: monitorexit
    //   521: aload 10
    //   523: athrow
    //   524: astore 10
    //   526: bipush 245
    //   528: putstatic 465	com/tencent/mobileqq/app/NearbyHandler:jdField_a_of_type_Int	I
    //   531: goto -107 -> 424
    //   534: astore 10
    //   536: goto -22 -> 514
    //   539: astore 10
    //   541: iload 8
    //   543: istore 7
    //   545: goto -31 -> 514
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	548	0	paramLong	long
    //   0	548	2	paramString	String
    //   397	11	3	l1	long
    //   405	4	5	l2	long
    //   376	168	7	bool1	boolean
    //   372	170	8	bool2	boolean
    //   369	127	9	bool3	boolean
    //   64	458	10	localObject1	Object
    //   524	1	10	localInterruptedException	java.lang.InterruptedException
    //   534	1	10	localObject2	Object
    //   539	1	10	localObject3	Object
    //   60	459	11	localObject4	Object
    //   55	28	12	arrayOfStackTraceElement	StackTraceElement[]
    // Exception table:
    //   from	to	target	type
    //   378	383	524	java/lang/InterruptedException
    //   387	390	524	java/lang/InterruptedException
    //   521	524	524	java/lang/InterruptedException
    //   421	424	534	finally
    //   394	398	539	finally
    //   402	407	539	finally
    //   499	508	539	finally
    //   518	521	539	finally
  }
  
  public static void a(SosoInterface.OnLocationListener paramOnLocationListener)
  {
    if (paramOnLocationListener == null) {}
    SosoInterface.SosoLbsInfo localSosoLbsInfo;
    int i;
    label201:
    label214:
    label224:
    int j;
    long l2;
    for (;;)
    {
      return;
      Object localObject;
      for (;;)
      {
        try
        {
          if (SosoInterface.OnLocationListener.a(paramOnLocationListener)) {
            SosoInterface.OnLocationListener.a(paramOnLocationListener, false);
          }
          localSosoLbsInfo = null;
          StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
          if (paramOnLocationListener == jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener)
          {
            i = 4;
            localObject = localSosoLbsInfo;
            if (arrayOfStackTraceElement != null)
            {
              localObject = localSosoLbsInfo;
              if (arrayOfStackTraceElement.length >= i + 1)
              {
                localObject = arrayOfStackTraceElement[i];
                localObject = ((StackTraceElement)localObject).getClassName() + "." + ((StackTraceElement)localObject).getMethodName();
              }
            }
            i = 0;
            boolean bool = NetworkUtil.d(BaseApplicationImpl.getContext());
            if (bool) {
              break label201;
            }
            i = 1;
            if (i == 0) {
              break label224;
            }
            if (QLog.isColorLevel()) {
              QLog.d("SOSO.LBS", 2, "startLocation() return. perCheckCode=" + i + " hasNet=" + bool);
            }
            localObject = b();
            if (!paramOnLocationListener.jdField_e_of_type_Boolean) {
              break label214;
            }
            b(paramOnLocationListener, i, (SosoInterface.SosoLbsInfo)localObject);
            break;
          }
        }
        finally {}
        i = 3;
        continue;
        if (!jdField_a_of_type_Boolean) {
          i = -10001;
        }
      }
      paramOnLocationListener.a(i, (SosoInterface.SosoLbsInfo)localObject);
      continue;
      if (jdField_a_of_type_ComTencentMapGeolocationInternalTencentLog == null) {}
      j = 0;
      l2 = SystemClock.elapsedRealtime();
      if (jdField_a_of_type_ArrayOfLong[0] <= 0L) {
        break label683;
      }
      l1 = l2 - jdField_a_of_type_ArrayOfLong[0];
      label257:
      paramOnLocationListener.jdField_g_of_type_Long = l1;
      i = j;
      if (paramOnLocationListener.jdField_e_of_type_Long > 0L)
      {
        i = j;
        if (!paramOnLocationListener.jdField_f_of_type_Boolean)
        {
          if (!paramOnLocationListener.jdField_g_of_type_Boolean) {
            break label538;
          }
          if (jdField_a_of_type_ArrayOfLong[paramOnLocationListener.jdField_c_of_type_Int] <= 0L) {
            break label691;
          }
          l1 = l2 - jdField_a_of_type_ArrayOfLong[paramOnLocationListener.jdField_c_of_type_Int];
          label316:
          paramOnLocationListener.jdField_f_of_type_Long = l1;
          l1 = jdField_a_of_type_AndroidContentSharedPreferences.getLong("time_key_" + paramOnLocationListener.jdField_c_of_type_Int, 0L);
          if (l1 <= 0L) {
            break label699;
          }
          l1 = l2 - l1;
          label370:
          paramOnLocationListener.jdField_h_of_type_Long = l1;
          i = j;
          if (jdField_a_of_type_ArrayOfLong[paramOnLocationListener.jdField_c_of_type_Int] > 0L)
          {
            i = j;
            if (l2 < jdField_a_of_type_ArrayOfLong[paramOnLocationListener.jdField_c_of_type_Int] + paramOnLocationListener.jdField_e_of_type_Long)
            {
              localSosoLbsInfo = b();
              if (!paramOnLocationListener.jdField_e_of_type_Boolean) {
                break;
              }
              b(paramOnLocationListener, 0, localSosoLbsInfo);
              break label678;
            }
          }
        }
      }
      label434:
      if (i == 0) {
        break label660;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SOSO.LBS", 2, "startLocation() lis=" + paramOnLocationListener.jdField_c_of_type_JavaLangString + " use cache and callback now");
      }
      b(true, paramOnLocationListener.jdField_g_of_type_Boolean, 0L, 0, 0, paramOnLocationListener.jdField_c_of_type_JavaLangString, "ERROR_OK", (String)localObject, paramOnLocationListener.jdField_h_of_type_Boolean, paramOnLocationListener.jdField_c_of_type_Int, true, paramOnLocationListener.jdField_e_of_type_Long, paramOnLocationListener.jdField_f_of_type_Long, paramOnLocationListener.jdField_g_of_type_Long, paramOnLocationListener.jdField_h_of_type_Long);
    }
    paramOnLocationListener.a(0, localSosoLbsInfo);
    break label678;
    label538:
    if (jdField_a_of_type_Long > 0L)
    {
      l1 = l2 - jdField_a_of_type_Long;
      label554:
      paramOnLocationListener.jdField_f_of_type_Long = l1;
      l1 = jdField_a_of_type_AndroidContentSharedPreferences.getLong("key_raw_time", 0L);
      if (l1 <= 0L) {
        break label720;
      }
    }
    label660:
    label678:
    label683:
    label691:
    label699:
    label707:
    label720:
    for (long l1 = l2 - l1;; l1 = -1L)
    {
      paramOnLocationListener.jdField_h_of_type_Long = l1;
      i = j;
      if (jdField_a_of_type_Long <= 0L) {
        break label434;
      }
      i = j;
      if (l2 >= jdField_a_of_type_Long + paramOnLocationListener.jdField_e_of_type_Long) {
        break label434;
      }
      i = j;
      if (jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo == null) {
        break label434;
      }
      localSosoLbsInfo = a();
      if (paramOnLocationListener.jdField_e_of_type_Boolean)
      {
        b(paramOnLocationListener, 0, localSosoLbsInfo);
      }
      else
      {
        paramOnLocationListener.a(0, localSosoLbsInfo);
        break label707;
        ThreadManager.getSubThreadHandler().post(new aacw(paramOnLocationListener));
        break;
        i = 1;
        break label434;
        l1 = -1L;
        break label257;
        l1 = -1L;
        break label316;
        l1 = -1L;
        break label370;
      }
      i = 1;
      break label434;
      l1 = -1L;
      break label554;
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
  
  public static SosoInterface.SosoLbsInfo b()
  {
    if ((jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo == null) || (jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation == null)) {
      return null;
    }
    SosoInterface.SosoLbsInfo localSosoLbsInfo = new SosoInterface.SosoLbsInfo();
    localSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation = jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.a();
    return localSosoLbsInfo;
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
            a(new aaco(0, true, false, 0L, false, false, "official"));
            a(new aacp(0, false, false, 0L, false, false, "official"));
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
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation = new SosoInterface.SosoLocation(1, paramTencentLocation.getLatitude(), paramTencentLocation.getLongitude());
    }
    jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_b_of_type_Double = paramTencentLocation.getLongitude();
    jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_a_of_type_Double = paramTencentLocation.getLatitude();
    jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.l = paramTencentLocation.getVerifyKey();
    jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_a_of_type_Int = paramTencentLocation.getFakeReason();
    jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_a_of_type_Long = paramTencentLocation.getTime();
    jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_b_of_type_Float = paramTencentLocation.getSpeed();
    jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.m = paramTencentLocation.getSourceProvider();
    switch (paramInt)
    {
    }
    for (;;)
    {
      jdField_a_of_type_AndroidContentSharedPreferences.edit().commit();
      jdField_b_of_type_Long = SystemClock.elapsedRealtime();
      if (jdField_b_of_type_Long - jdField_c_of_type_Long > 3000L)
      {
        a(String.valueOf(paramTencentLocation.getLongitude()), String.valueOf(paramTencentLocation.getLatitude()));
        jdField_c_of_type_Long = jdField_b_of_type_Long;
        if (QLog.isColorLevel()) {
          QLog.d("SOSO.LBS", 2, "saveGeogInfo cost: " + (SystemClock.elapsedRealtime() - jdField_c_of_type_Long));
        }
      }
      LbsInfoReportManager.a(jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation, paramString);
      return;
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_a_of_type_JavaUtilList = paramTencentLocation.getPoiList();
      jdField_a_of_type_ArrayOfLong[4] = SystemClock.elapsedRealtime();
      jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("time_key_4", SystemClock.elapsedRealtime());
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_c_of_type_JavaLangString = paramTencentLocation.getNation();
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_d_of_type_JavaLangString = paramTencentLocation.getProvince();
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_e_of_type_JavaLangString = paramTencentLocation.getCity();
      String str = paramTencentLocation.getCityCode();
      if ((!TextUtils.isEmpty(str)) && (!str.equalsIgnoreCase("unknown"))) {
        jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.f = str;
      }
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.g = paramTencentLocation.getDistrict();
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.h = paramTencentLocation.getTown();
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.i = paramTencentLocation.getVillage();
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.j = paramTencentLocation.getStreet();
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.k = paramTencentLocation.getStreetNo();
      jdField_a_of_type_ArrayOfLong[3] = SystemClock.elapsedRealtime();
      jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("time_key_3", SystemClock.elapsedRealtime());
      a().edit().putString("city", jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_e_of_type_JavaLangString).commit();
      if (paramInt == 1)
      {
        jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_a_of_type_JavaLangString = paramTencentLocation.getName();
        jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_b_of_type_JavaLangString = paramTencentLocation.getAddress();
        jdField_a_of_type_ArrayOfLong[1] = SystemClock.elapsedRealtime();
        jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("time_key_1", SystemClock.elapsedRealtime());
      }
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_e_of_type_Double = paramTencentLocation.getAltitude();
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_a_of_type_Float = paramTencentLocation.getAccuracy();
      jdField_a_of_type_ArrayOfLong[0] = SystemClock.elapsedRealtime();
      jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("time_key_0", SystemClock.elapsedRealtime());
    }
  }
  
  public static void b(SosoInterface.OnLocationListener paramOnLocationListener)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      jdField_a_of_type_JavaUtilArrayList.remove(paramOnLocationListener);
      SosoInterface.OnLocationListener.a(paramOnLocationListener, true);
      SosoInterface.OnLocationListener.b(paramOnLocationListener, false);
      if (QLog.isColorLevel()) {
        QLog.d("SOSO.LBS", 2, "removeOnLocationListener() lis=" + paramOnLocationListener.jdField_c_of_type_JavaLangString + " removed.");
      }
      if (jdField_a_of_type_JavaUtilArrayList.size() == 0)
      {
        ThreadManager.getSubThreadHandler().post(new aacx());
        if (QLog.isColorLevel()) {
          QLog.d("SOSO.LBS", 2, "removeOnLocationListener() listener is empty. remveUpdate and stop LBS");
        }
      }
      return;
    }
  }
  
  private static void b(SosoInterface.OnLocationListener paramOnLocationListener, int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (paramOnLocationListener == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new aacv(paramOnLocationListener, paramInt, paramSosoLbsInfo));
  }
  
  private static void b(String paramString, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    if (jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo == null) {
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo = new SosoInterface.SosoLbsInfo();
    }
    try
    {
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      localJSONObject = new JSONObject(new String(paramArrayOfByte, "UTF-8"));
      d2 = 0.0D;
      d1 = d2;
      for (;;)
      {
        try
        {
          paramArrayOfByte = localJSONObject.getJSONObject("location");
          d1 = d2;
          d2 = paramArrayOfByte.getDouble("latitude");
          d1 = d2;
          d3 = paramArrayOfByte.getDouble("longitude");
          d1 = d3;
        }
        catch (JSONException paramArrayOfByte)
        {
          SosoInterface.SosoAttribute localSosoAttribute;
          ArrayList localArrayList1;
          int j;
          int i;
          Object localObject;
          ArrayList localArrayList2;
          double d3 = 0.0D;
          d2 = d1;
          d1 = d3;
          continue;
          boolean bool = false;
          continue;
        }
        try
        {
          paramArrayOfByte = localJSONObject.getJSONObject("attribute");
          localSosoAttribute = new SosoInterface.SosoAttribute(paramArrayOfByte.getString("imei"), paramArrayOfByte.getString("imsi"), paramArrayOfByte.getString("phonenum"), paramArrayOfByte.getString("qq"), paramArrayOfByte.getBoolean("roaming"));
          localArrayList1 = new ArrayList();
          paramArrayOfByte = localJSONObject.getJSONArray("cells");
          j = paramArrayOfByte.length();
          i = 0;
          if (i < j)
          {
            localObject = paramArrayOfByte.getJSONObject(i);
            int k = ((JSONObject)localObject).getInt("mcc");
            int m = ((JSONObject)localObject).getInt("mnc");
            int n = ((JSONObject)localObject).getInt("lac");
            int i1 = ((JSONObject)localObject).getInt("cellid");
            int i2 = ((JSONObject)localObject).getInt("rss");
            if (i != 0) {
              continue;
            }
            bool = true;
            localArrayList1.add(new SosoInterface.SosoCell(k, m, n, i1, i2, bool));
            i += 1;
          }
        }
        catch (JSONException paramArrayOfByte)
        {
          localSosoAttribute = new SosoInterface.SosoAttribute("", "", "", "", false);
          continue;
          localArrayList2 = new ArrayList();
          paramArrayOfByte = localJSONObject.getJSONArray("wifis");
          i = 0;
          j = paramArrayOfByte.length();
          if (i < j)
          {
            localObject = paramArrayOfByte.getJSONObject(i);
            localArrayList2.add(new SosoInterface.SosoWifi(((JSONObject)localObject).getString("mac"), ((JSONObject)localObject).getInt("rssi")));
            i += 1;
          }
          else
          {
            paramArrayOfByte = "";
          }
        }
      }
    }
    catch (Exception paramString)
    {
      JSONObject localJSONObject;
      double d2;
      double d1;
      label410:
      return;
    }
    try
    {
      localObject = localJSONObject.getString("version");
      paramArrayOfByte = (byte[])localObject;
      l = localJSONObject.getLong("source");
    }
    catch (JSONException localJSONException)
    {
      l = 0L;
      byte[] arrayOfByte = paramArrayOfByte;
      break label410;
    }
    if (jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation == null) {
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation = new SosoInterface.SosoLocation(0, d2, d1);
    }
    for (;;)
    {
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoAttribute = localSosoAttribute;
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_JavaUtilArrayList = localArrayList1;
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_b_of_type_JavaUtilArrayList = localArrayList2;
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_Long = l;
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_JavaLangString = ((String)localObject);
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_b_of_type_JavaLangString = paramString;
      jdField_a_of_type_Long = SystemClock.elapsedRealtime();
      jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("key_raw_time", jdField_a_of_type_Long).commit();
      return;
      if (d2 != 0.0D) {
        jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_c_of_type_Double = d2;
      }
      if (d1 != 0.0D) {
        jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.jdField_d_of_type_Double = d1;
      }
    }
  }
  
  private static void b(boolean paramBoolean1, boolean paramBoolean2, long paramLong1, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, boolean paramBoolean3, int paramInt3, boolean paramBoolean4, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    if ((String.valueOf(paramString2).equals("ERROR_NETWORK")) && ((paramInt2 == -4) || (paramInt2 == -17))) {
      break label28;
    }
    label280:
    label539:
    for (;;)
    {
      label28:
      return;
      if (((!paramBoolean1) && (HwNetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext()))) || (paramBoolean1))
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("param_FailCode", Integer.toString(paramInt1));
        if ((paramString1 != null) && (paramString1.length() > 0)) {
          localHashMap.put("param_caller", paramString1);
        }
        if ((paramString2 != null) && (paramString2.length() > 0)) {
          localHashMap.put("param_reason", paramString2);
        }
        if (!TextUtils.isEmpty(paramString3)) {
          localHashMap.put("param_caller_route", paramString3);
        }
        localHashMap.put("param_detail", Integer.toString(paramInt2));
        localHashMap.put("param_useCache", Boolean.toString(paramBoolean4));
        localHashMap.put("param_askGps", Boolean.toString(paramBoolean3));
        localHashMap.put("param_costTime", Long.toString(paramLong1));
        localHashMap.put("param_level", String.valueOf(paramInt3));
        localHashMap.put("param_reuseInterval", Long.toString(paramLong2));
        localHashMap.put("param_curInterval", Long.toString(paramLong3));
        localHashMap.put("param_geoInterval", Long.toString(paramLong4));
        localHashMap.put("param_globalInterval", Long.toString(paramLong5));
        paramString3 = EarlyDownloadManager.a();
        if (paramBoolean4) {
          if (paramBoolean2)
          {
            paramString2 = "actSosoLocationCache";
            StatisticCollector.a(BaseApplicationImpl.getContext()).a(paramString3, paramString2, paramBoolean1, paramLong1, 0L, localHashMap, "");
            paramString2 = BatteryStatsImpl.a();
            if (!paramBoolean2) {
              break label527;
            }
            label310:
            paramString2.a("requestSoso", new Object[] { Integer.valueOf(paramInt3), Boolean.valueOf(paramBoolean3), paramString1, Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(paramLong4), Long.valueOf(paramLong5) });
            if (BaseApplicationImpl.sProcessId != 1) {
              break label533;
            }
          }
        }
        for (paramLong2 = Conversation.jdField_b_of_type_Long;; paramLong2 = b())
        {
          if ((paramLong2 <= 0L) || (SystemClock.elapsedRealtime() - paramLong2 >= 60000L)) {
            break label539;
          }
          paramString2 = new HashMap();
          if ((paramString1 == null) || (paramString1.length() <= 0)) {
            break;
          }
          paramString2.put("param_caller", paramString1);
          StatisticCollector.a(BaseApplicationImpl.getContext()).a(paramString3, "actLocationEarly", paramBoolean1, paramLong1, 0L, paramString2, "");
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("SOSO.LBS", 2, "location too early: " + paramString1);
          return;
          paramString2 = "actSosoRawDataCache";
          break label280;
          if (paramBoolean2)
          {
            paramString2 = "actSosoLocation";
            break label280;
          }
          paramString2 = "actSosoRawData";
          break label280;
          paramInt3 = -1;
          break label310;
        }
      }
    }
  }
  
  private static void d(SosoInterface.OnLocationListener paramOnLocationListener)
  {
    if (paramOnLocationListener == null) {
      return;
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (!jdField_a_of_type_JavaUtilArrayList.contains(paramOnLocationListener)) {
        jdField_a_of_type_JavaUtilArrayList.add(paramOnLocationListener);
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
      SosoInterface.OnLocationListener localOnLocationListener;
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
          return;
        }
        i = jdField_a_of_type_JavaUtilArrayList.size() - 1;
        if (i < 0) {
          break label101;
        }
        localOnLocationListener = (SosoInterface.OnLocationListener)jdField_a_of_type_JavaUtilArrayList.get(i);
        if (localOnLocationListener == null) {
          break label110;
        }
        if (localOnLocationListener.jdField_g_of_type_Boolean)
        {
          SosoInterface.SosoLbsInfo localSosoLbsInfo1 = b();
          if (!localOnLocationListener.jdField_e_of_type_Boolean) {
            break label90;
          }
          b(localOnLocationListener, -10000, localSosoLbsInfo1);
        }
      }
      SosoInterface.SosoLbsInfo localSosoLbsInfo2 = a();
      continue;
      label90:
      localOnLocationListener.a(-10000, localSosoLbsInfo2);
      break label110;
      label101:
      jdField_a_of_type_JavaUtilArrayList.clear();
      return;
      label110:
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.soso.SosoInterface
 * JD-Core Version:    0.7.0.1
 */