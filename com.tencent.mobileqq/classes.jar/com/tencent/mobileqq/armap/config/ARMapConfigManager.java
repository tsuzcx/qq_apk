package com.tencent.mobileqq.armap.config;

import aaxy;
import aaxz;
import aayb;
import aayc;
import aayd;
import aaye;
import aayf;
import aayg;
import aayh;
import aayi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.armap.ArMapHandler;
import com.tencent.mobileqq.armap.ArMapObserver;
import com.tencent.mobileqq.armap.ArMapUtil;
import com.tencent.mobileqq.armap.ArMapUtil.CurfewResInfo;
import com.tencent.mobileqq.armap.ResDownloadManager;
import com.tencent.mobileqq.armap.ResDownloadManager.IResDownloadListener;
import com.tencent.mobileqq.armap.ipc.ArMapIPCProxy;
import com.tencent.mobileqq.armap.utils.ARResUtil;
import com.tencent.mobileqq.armap.wealthgod.ARMapDPC;
import com.tencent.mobileqq.armap.wealthgod.SplashBitmapUtils;
import com.tencent.mobileqq.armap.wealthgod.WealthGodInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.precover.PrecoverUtils;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import com.tencent.util.WeakReferenceHandler;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class ARMapConfigManager
  implements Manager
{
  public static long a;
  private double jdField_a_of_type_Double;
  private aayi jdField_a_of_type_Aayi;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new aaye(this);
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public SosoInterface.OnLocationListener a;
  private ArMapHandler jdField_a_of_type_ComTencentMobileqqArmapArMapHandler;
  private ArMapObserver jdField_a_of_type_ComTencentMobileqqArmapArMapObserver = new aayd(this);
  private ResDownloadManager.IResDownloadListener jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager$IResDownloadListener = new aaxz(this);
  private ResDownloadManager jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager;
  private ARMapConfig jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig;
  private ARMapConfigManager.ARMapShower jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfigManager$ARMapShower;
  private ConfigCheckHander jdField_a_of_type_ComTencentMobileqqArmapConfigConfigCheckHander;
  public volatile WealthGodInfo a;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  public String a;
  private SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat;
  public boolean a;
  private double jdField_b_of_type_Double;
  public long b;
  private Handler.Callback jdField_b_of_type_AndroidOsHandler$Callback = new aayf(this);
  private SosoInterface.OnLocationListener jdField_b_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener = new aayc(this, 3, true, true, 120000L, false, false, "wealthgod_locate_check");
  private Object jdField_b_of_type_JavaLangObject = new Object();
  public boolean b;
  long jdField_c_of_type_Long;
  private SosoInterface.OnLocationListener jdField_c_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener = new aayg(this, 3, true, true, 60000L, false, false, "ARMapDataPreload");
  public boolean c;
  public long d;
  private SosoInterface.OnLocationListener d;
  public boolean d;
  public volatile long e = -1L;
  public boolean e;
  public volatile long f = 60000L;
  public boolean f;
  private long g;
  public boolean g;
  private long h = 300000L;
  public boolean h;
  private long jdField_i_of_type_Long = 900000L;
  private boolean jdField_i_of_type_Boolean;
  private long jdField_j_of_type_Long = 300000L;
  private boolean jdField_j_of_type_Boolean;
  private long jdField_k_of_type_Long;
  private boolean jdField_k_of_type_Boolean;
  
  public ARMapConfigManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_Long = 900000L;
    this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener = new aayb(this, 3, true, true, 60000L, false, false, "ARMapDataPreload");
    this.jdField_d_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener = new aayh(this, 3, true, true, 60000L, false, false, "ARMapDataPreload");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    ArMapIPCProxy.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqArmapConfigConfigCheckHander = new ConfigCheckHander(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ThreadManager.postImmediately(new aaxy(this), null, true);
    this.jdField_a_of_type_ComTencentMobileqqArmapArMapHandler = ((ArMapHandler)paramQQAppInterface.a(101));
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this.jdField_b_of_type_AndroidOsHandler$Callback);
    if (QLog.isColorLevel()) {
      QLog.d("ARMapConfigManager", 2, "construct ARMapConfigManager mHandler = " + this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler + ",mCallback = " + this.jdField_a_of_type_AndroidOsHandler$Callback + ",mUIHandler = " + this.jdField_a_of_type_AndroidOsHandler + ",mUICallback = " + this.jdField_b_of_type_AndroidOsHandler$Callback);
    }
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqArmapArMapObserver);
    ArMapUtil.jdField_a_of_type_Boolean = paramQQAppInterface.getApp().getSharedPreferences("envSwitch", 4).getBoolean("armap_debug_switch", false);
  }
  
  private int a(WealthGodInfo arg1)
  {
    int i1 = 0;
    int n = 0;
    String str;
    int m;
    if (??? != null)
    {
      str = ???.a + "_" + ???.jdField_c_of_type_Long;
      if ((this.jdField_a_of_type_Aayi == null) || (!this.jdField_a_of_type_Aayi.jdField_a_of_type_JavaLangString.equalsIgnoreCase(str))) {
        break label119;
      }
      m = this.jdField_a_of_type_Aayi.jdField_a_of_type_Int;
      n = m;
      if (QLog.isColorLevel())
      {
        QLog.d("ARMapConfigManager", 2, "getPendantStatus:" + m + ",actKey:" + str);
        n = m;
      }
    }
    return n;
    for (;;)
    {
      label119:
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_Aayi = new aayi(null);
        this.jdField_a_of_type_Aayi.jdField_a_of_type_JavaLangString = str;
        Object localObject2 = ArMapUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).getString("wealth_god_pendant_status", "");
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label278;
        }
        localObject2 = ((String)localObject2).split("#");
        if (localObject2 == null) {
          break label278;
        }
        n = localObject2.length;
        m = 0;
        if (m >= n) {
          break label278;
        }
        if (localObject2[m].equalsIgnoreCase(str))
        {
          m = 1;
          localObject2 = this.jdField_a_of_type_Aayi;
          n = i1;
          if (m != 0) {
            n = 2;
          }
          ((aayi)localObject2).jdField_a_of_type_Int = n;
          m = this.jdField_a_of_type_Aayi.jdField_a_of_type_Int;
          if (QLog.isColorLevel()) {
            QLog.d("ARMapConfigManager", 2, "create a new pendant!");
          }
        }
      }
      m += 1;
      continue;
      label278:
      m = 0;
    }
  }
  
  public static WealthGodInfo a(List paramList)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramList != null)
    {
      localObject1 = localObject2;
      if (paramList.size() > 0)
      {
        Collections.sort(paramList);
        localObject1 = (WealthGodInfo)paramList.get(paramList.size() - 1);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ARMapConfigManager", 2, "calculateRecentWealthGodInfo recentInfo:" + localObject1 + ",wealthGodInfoList:" + paramList);
    }
    return localObject1;
  }
  
  private String a(int paramInt)
  {
    String str = String.format("http://map.myapp.com/myapp/shuttle/qqvectors/%s.bin", new Object[] { String.valueOf(paramInt) });
    if (QLog.isColorLevel()) {
      QLog.d("ARMapConfigManager.preloadMap", 2, "getMapDataFileUrl:" + str);
    }
    return str;
  }
  
  private String a(long paramLong)
  {
    Object localObject = null;
    if (this.jdField_a_of_type_JavaTextSimpleDateFormat == null)
    {
      this.jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
      this.jdField_a_of_type_JavaTextSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    }
    try
    {
      String str = this.jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(paramLong));
      localObject = str;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ARMapConfigManager", 2, "getCurrentDateString exception", localException);
    }
    return localObject;
    return null;
  }
  
  private void b(double paramDouble1, double paramDouble2)
  {
    QLog.d("ARMapConfigManager.preloadMap", 1, "preloadARMapData lat:" + paramDouble1 + ",lon:" + paramDouble2);
    int m = ArMapUtil.a(paramDouble1, paramDouble2);
    String str = a(m);
    File localFile = new File(ARResUtil.a(m));
    if (this.jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager = ((ResDownloadManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(190));
      this.jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager.a(this.jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager$IResDownloadListener);
    }
    PreloadMapRDHandler.UserData localUserData = new PreloadMapRDHandler.UserData();
    localUserData.jdField_a_of_type_Int = m;
    localUserData.jdField_a_of_type_Boolean = localFile.exists();
    this.jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager.a(str, "", ".bin", false, 3, localUserData);
  }
  
  private void b(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapConfigManager", 2, "queryWealthGodInfo ,delayMills:" + paramLong);
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(3);
    Message localMessage = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage();
    localMessage.what = 3;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessageDelayed(localMessage, paramLong);
  }
  
  private void c(double paramDouble1, double paramDouble2)
  {
    QLog.d("ARMapConfigManager.preloadMap", 1, "preloadGridMapData lat:" + paramDouble1 + ",lng:" + paramDouble2);
    try
    {
      TencentMap.preLoadTiles(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getBaseContext(), new LatLng(paramDouble1, paramDouble2), 4000.0D, 16);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("ARMapConfigManager.preloadMap", 1, "preloadGridMapData exp:" + localException.getMessage());
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.d("ARMapConfigManager.preloadMap", 1, "preloadGridMapData oom");
    }
  }
  
  private void c(long paramLong)
  {
    if (a()) {
      if (QLog.isColorLevel()) {
        QLog.d("ARMapConfigManager", 2, "ARMapForbidden sendCheckConfigMsg  return");
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(0);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(0, paramLong);
    } while (!QLog.isColorLevel());
    QLog.d("ARMapConfigManager", 2, "sendCheckConfigMsg, delayMills:" + paramLong);
  }
  
  private void d(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null)
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(4);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(4, paramLong);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ARMapConfigManager", 2, "sendCloseEnterMsg...delayMills:" + paramLong);
    }
  }
  
  private void e(long paramLong)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4, paramLong);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ARMapConfigManager", 2, "openWealthGodEnter delayMills:" + paramLong);
    }
  }
  
  private boolean f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ARMapConfigManager.preloadMap", 2, "checkPreLoadARMapConfig mARMapConfig = null");
      }
    }
    int m;
    int n;
    do
    {
      do
      {
        do
        {
          do
          {
            ARMapConfig localARMapConfig;
            do
            {
              return false;
              localARMapConfig = this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig;
              long l = MessageCache.a() * 1000L;
              if ((l >= localARMapConfig.mapPreloadBeginTime) && (l <= localARMapConfig.mapPreLoadEndTime)) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.d("ARMapConfigManager.preloadMap", 2, "checkPreLoadARMapConfig no preload time");
            return false;
            m = NetworkUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext());
            n = localARMapConfig.mapPreLoadNetType;
            if (QLog.isColorLevel()) {
              QLog.d("ARMapConfigManager.preloadMap", 2, "checkPreLoadARMapConfig curNetType:" + m + ",netTypeConfig:" + n);
            }
            if ((n != 1) && (n != 5)) {
              break;
            }
          } while (m != 1);
          return true;
          if (n != 2) {
            break;
          }
        } while ((m != 1) && (m != 4));
        return true;
        if (n != 3) {
          break;
        }
      } while ((m != 1) && (m != 4) && (m != 3));
      return true;
    } while ((n != 4) || ((m != 1) && (m != 4) && (m != 3) && (m != 2)));
    return true;
  }
  
  private void g()
  {
    ARMapDPC localARMapDPC = SplashBitmapUtils.a();
    if (localARMapDPC == null) {}
    for (int m = 0;; m = localARMapDPC.jdField_a_of_type_Int)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ARMapConfigManager", 2, "startResPreDownload, dpc=" + localARMapDPC + ", dpcValue=" + m);
      }
      boolean bool = PrecoverUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_armap_res_cover");
      if (QLog.isColorLevel()) {
        QLog.d("ARMapConfigManager", 2, "startResPreDownload, need report=" + bool);
      }
      if (bool) {
        PrecoverUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_armap_res_cover");
      }
      if (a(m))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqArmapConfigConfigCheckHander != null) {
          this.jdField_a_of_type_ComTencentMobileqqArmapConfigConfigCheckHander.b(bool);
        }
        new StarConfigCheckHander(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(bool);
      }
      return;
    }
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapConfigManager", 2, "stopAllCheckTask...");
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(0);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(5);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(4);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(6);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(2);
    this.jdField_j_of_type_Boolean = false;
    this.jdField_k_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(3);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
  }
  
  private void i()
  {
    boolean bool = false;
    Object localObject = ArMapUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (((SharedPreferences)localObject).getBoolean("armap_preload_offline", false))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ARMapConfigManager.preloadMap", 2, "preloadARMapData return! hadEnterMap");
      }
      if (new File(ARResUtil.c).exists())
      {
        FileUtils.a(ARResUtil.c);
        if (QLog.isColorLevel()) {
          QLog.d("ARMapConfigManager", 2, "preloadARMapData remove dir");
        }
      }
    }
    long l2;
    do
    {
      do
      {
        return;
        if (f()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ARMapConfigManager.preloadMap", 2, "preloadARMapData return! config check failed");
      return;
      long l1 = ((SharedPreferences)localObject).getLong("armap_preload_timestamp", 0L);
      l2 = ArMapUtil.b(MessageCache.a() * 1000L);
      if (QLog.isColorLevel()) {
        QLog.d("ARMapConfigManager.preloadMap", 2, "preloadARMapData lastTimeCode:" + l1 + ",curTimeStamp:" + l2);
      }
      if ((l2 >= 0L) && (l2 > l1)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ARMapConfigManager.preloadMap", 2, "preloadARMapData timeCode error!");
    return;
    ((SharedPreferences)localObject).edit().putLong("armap_preload_timestamp", l2).commit();
    localObject = SplashBitmapUtils.a();
    if (localObject == null) {}
    for (float f1 = 0.2F;; f1 = ((ARMapDPC)localObject).d)
    {
      if (Math.random() < f1) {
        bool = true;
      }
      if (bool) {
        SosoInterface.a(this.jdField_c_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ARMapConfigManager.preloadMap", 2, "preloadARMapData preloadRate:" + f1 + ",needPreload:" + bool);
      return;
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ARMapConfigManager.preloadMap", 2, "checkPreloadGridMap mARMapConfig == null");
      }
    }
    long l1;
    Object localObject;
    long l3;
    do
    {
      do
      {
        return;
        l1 = MessageCache.a() * 1000L;
        if ((l1 >= this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig.preLoadGridMapBeginTime) && (l1 <= this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig.preLoadGridMapEndTime)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ARMapConfigManager.preloadMap", 2, "checkPreloadGridMap not config time!");
      return;
      localObject = ArMapUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      long l2 = ((SharedPreferences)localObject).getLong("armap_preload_gridmap_timecode", 0L);
      l3 = ArMapUtil.b(l1);
      if (QLog.isColorLevel()) {
        QLog.d("ARMapConfigManager.preloadMap", 2, "checkPreloadGridMap lastTimeCode:" + l2 + ",curTimeStamp:" + l3);
      }
      if ((l3 >= 0L) && (l3 > l2)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ARMapConfigManager.preloadMap", 2, "checkPreloadGridMap timeCode error");
    return;
    ARMapDPC localARMapDPC = SplashBitmapUtils.a();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(l1);
    int n = localCalendar.get(11);
    float f1;
    label226:
    int m;
    label233:
    boolean bool2;
    if ((n >= 0) && (n < 7)) {
      if (localARMapDPC == null)
      {
        f1 = 0.2F;
        if (localARMapDPC != null) {
          break label475;
        }
        m = 0;
        bool2 = a(m);
        if (Math.random() >= f1) {
          break label484;
        }
      }
    }
    label475:
    label484:
    for (boolean bool1 = true;; bool1 = false)
    {
      QLog.d("ARMapConfigManager.preloadMap", 1, "checkPreloadGridMap preloadRate:" + f1 + ",needPreload:" + bool1 + ",netType:" + m + ",isNetCanPreDown:" + bool2);
      if ((!bool1) || (!bool2)) {
        break;
      }
      SosoInterface.a(this.jdField_d_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
      ((SharedPreferences)localObject).edit().putLong("armap_preload_gridmap_timecode", l3).commit();
      localObject = new HashMap();
      ((HashMap)localObject).put("timeCode", String.valueOf(l3));
      ((HashMap)localObject).put("hourOfDay", String.valueOf(n));
      StatisticCollector.a(BaseApplicationImpl.getContext()).a("", "ARMAP_PRELOAD_GRIDMAP_COUNT", true, 0L, 0L, (HashMap)localObject, "", false);
      return;
      f1 = localARMapDPC.jdField_a_of_type_Float;
      break label226;
      if ((n >= 7) && (n < 15))
      {
        if (localARMapDPC == null) {}
        for (f1 = 0.1F;; f1 = localARMapDPC.jdField_b_of_type_Float) {
          break;
        }
      }
      if (localARMapDPC == null) {}
      for (f1 = 0.1F;; f1 = localARMapDPC.c) {
        break;
      }
      m = localARMapDPC.jdField_a_of_type_Int;
      break label233;
    }
  }
  
  public double a()
  {
    return this.jdField_a_of_type_Double;
  }
  
  public int a()
  {
    ARMapConfig localARMapConfig = a();
    if (localARMapConfig == null) {}
    for (int m = 0;; m = localARMapConfig.version)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ARMapConfigManager", 2, "getConfigVersion:" + m);
      }
      return m;
    }
  }
  
  public long a()
  {
    return this.e;
  }
  
  public long a(WealthGodInfo paramWealthGodInfo)
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    if (paramWealthGodInfo != null) {
      if (l < paramWealthGodInfo.jdField_c_of_type_Long - this.jdField_j_of_type_Long)
      {
        this.jdField_k_of_type_Long = ((this.jdField_j_of_type_Long * Math.random()));
        l = paramWealthGodInfo.jdField_c_of_type_Long - this.jdField_k_of_type_Long;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        paramWealthGodInfo = ArMapUtil.a(l, "yyyy-MM-dd HH:mm:ss");
        QLog.d("ARMapConfigManager", 2, "calcutePendantShowTime pendantShowTime:" + l + "|" + paramWealthGodInfo);
      }
      return l;
      QLog.d("ARMapConfigManager", 2, "calcutePendantShowTime pendantShowTime already in Gap");
      continue;
      l = -1L;
    }
  }
  
  public ARMapConfig a()
  {
    return a(true);
  }
  
  public ARMapConfig a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig == null) && (paramBoolean))
    {
      a();
      if (QLog.isColorLevel()) {
        QLog.d("ARMapConfigManager", 2, "getARMapConfig:" + this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig);
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig;
  }
  
  public ConfigCheckHander a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArmapConfigConfigCheckHander;
  }
  
  public WealthGodInfo a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ARMapConfigManager", 2, String.format("getWealthGodInfoCache mWealthGodInfoCache=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo }));
      }
      WealthGodInfo localWealthGodInfo = this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo;
      return localWealthGodInfo;
    }
    finally {}
  }
  
  public String a()
  {
    String str2 = "";
    String str1 = str2;
    if (this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig != null)
    {
      str1 = str2;
      if (this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig.wealthGodConfig != null) {
        str1 = ARResUtil.b(this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig.wealthGodConfig.resMd5);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ARMapConfigManager", 2, "getWealthGodResPath path:" + str1);
    }
    return str1;
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig = ARMapConfig.readFromFile(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (QLog.isColorLevel()) {
          QLog.d("ARMapConfigManager", 2, "loadConfigFromFile,mARMapConfig =   " + this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig);
        }
      }
      return;
    }
  }
  
  public void a(double paramDouble1, double paramDouble2)
  {
    try
    {
      this.jdField_a_of_type_Double = paramDouble1;
      this.jdField_b_of_type_Double = paramDouble2;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int m = (int)(Math.random() * 100.0D);
    if ((m <= paramInt) && (m >= 0) && (paramBoolean1)) {
      this.jdField_b_of_type_Boolean = true;
    }
    if ((m <= paramInt) && (m >= 0) && (paramBoolean2)) {
      this.jdField_c_of_type_Boolean = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ARMapConfigManager", 2, "checkCanShowDailyPendantOrNot ,percent = " + paramInt + ",randomPendant = " + m + ",randomBreath = " + m + ",mCanShowDailyPendant = " + this.jdField_b_of_type_Boolean + ",mCanShowDailyBreath = " + this.jdField_c_of_type_Boolean + ",pendantSwitcher = " + paramBoolean1 + ",splashLight = " + paramBoolean2);
    }
  }
  
  void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapConfigManager", 2, "startRegulaLocate ,delayMills:" + paramLong);
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(2);
    Message localMessage = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage();
    localMessage.what = 2;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessageDelayed(localMessage, paramLong);
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    try
    {
      long l = this.e;
      this.e = paramLong;
      if ((paramBoolean) && (paramLong > 0L) && (l != this.e))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ARMapConfigManager", 2, "updateADCode need reRequeat WealthGodInfo beforeADCode:" + l + ",updateADCode:" + paramLong);
        }
        b(0L);
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public void a(ARMapConfig paramARMapConfig, int paramInt)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: invokestatic 174	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +39 -> 47
    //   11: ldc 176
    //   13: iconst_2
    //   14: new 178	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   21: ldc_w 842
    //   24: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: iload_2
    //   28: invokevirtual 269	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   31: ldc_w 844
    //   34: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_1
    //   38: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   47: aload_0
    //   48: getfield 44	com/tencent/mobileqq/armap/config/ARMapConfigManager:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   51: astore 5
    //   53: aload 5
    //   55: monitorenter
    //   56: aload_0
    //   57: aload_1
    //   58: putfield 307	com/tencent/mobileqq/armap/config/ARMapConfigManager:jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig	Lcom/tencent/mobileqq/armap/config/ARMapConfig;
    //   61: aload_0
    //   62: getfield 307	com/tencent/mobileqq/armap/config/ARMapConfigManager:jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig	Lcom/tencent/mobileqq/armap/config/ARMapConfig;
    //   65: ifnull +346 -> 411
    //   68: aload_0
    //   69: aload_0
    //   70: getfield 307	com/tencent/mobileqq/armap/config/ARMapConfigManager:jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig	Lcom/tencent/mobileqq/armap/config/ARMapConfig;
    //   73: getfield 795	com/tencent/mobileqq/armap/config/ARMapConfig:wealthGodConfig	Lcom/tencent/mobileqq/armap/config/ARMapConfig$WealthGodConfig;
    //   76: getfield 847	com/tencent/mobileqq/armap/config/ARMapConfig$WealthGodConfig:locateFrequency	I
    //   79: i2l
    //   80: putfield 52	com/tencent/mobileqq/armap/config/ARMapConfigManager:h	J
    //   83: aload_0
    //   84: getfield 307	com/tencent/mobileqq/armap/config/ARMapConfigManager:jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig	Lcom/tencent/mobileqq/armap/config/ARMapConfig;
    //   87: getfield 795	com/tencent/mobileqq/armap/config/ARMapConfig:wealthGodConfig	Lcom/tencent/mobileqq/armap/config/ARMapConfig$WealthGodConfig;
    //   90: getfield 850	com/tencent/mobileqq/armap/config/ARMapConfig$WealthGodConfig:pbReqInterval	I
    //   93: ifle +18 -> 111
    //   96: aload_0
    //   97: aload_0
    //   98: getfield 307	com/tencent/mobileqq/armap/config/ARMapConfigManager:jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig	Lcom/tencent/mobileqq/armap/config/ARMapConfig;
    //   101: getfield 795	com/tencent/mobileqq/armap/config/ARMapConfig:wealthGodConfig	Lcom/tencent/mobileqq/armap/config/ARMapConfig$WealthGodConfig;
    //   104: getfield 850	com/tencent/mobileqq/armap/config/ARMapConfig$WealthGodConfig:pbReqInterval	I
    //   107: i2l
    //   108: putfield 64	com/tencent/mobileqq/armap/config/ARMapConfigManager:f	J
    //   111: aload_0
    //   112: aload_0
    //   113: getfield 307	com/tencent/mobileqq/armap/config/ARMapConfigManager:jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig	Lcom/tencent/mobileqq/armap/config/ARMapConfig;
    //   116: getfield 795	com/tencent/mobileqq/armap/config/ARMapConfig:wealthGodConfig	Lcom/tencent/mobileqq/armap/config/ARMapConfig$WealthGodConfig;
    //   119: getfield 853	com/tencent/mobileqq/armap/config/ARMapConfig$WealthGodConfig:locatePreCheckGap	I
    //   122: i2l
    //   123: putfield 54	com/tencent/mobileqq/armap/config/ARMapConfigManager:jdField_i_of_type_Long	J
    //   126: aload_0
    //   127: aload_0
    //   128: getfield 307	com/tencent/mobileqq/armap/config/ARMapConfigManager:jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig	Lcom/tencent/mobileqq/armap/config/ARMapConfig;
    //   131: getfield 795	com/tencent/mobileqq/armap/config/ARMapConfig:wealthGodConfig	Lcom/tencent/mobileqq/armap/config/ARMapConfig$WealthGodConfig;
    //   134: getfield 856	com/tencent/mobileqq/armap/config/ARMapConfig$WealthGodConfig:pendantPreShowGap	I
    //   137: i2l
    //   138: putfield 56	com/tencent/mobileqq/armap/config/ARMapConfigManager:jdField_j_of_type_Long	J
    //   141: aload_0
    //   142: aload_0
    //   143: getfield 307	com/tencent/mobileqq/armap/config/ARMapConfigManager:jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig	Lcom/tencent/mobileqq/armap/config/ARMapConfig;
    //   146: getfield 795	com/tencent/mobileqq/armap/config/ARMapConfig:wealthGodConfig	Lcom/tencent/mobileqq/armap/config/ARMapConfig$WealthGodConfig;
    //   149: getfield 859	com/tencent/mobileqq/armap/config/ARMapConfig$WealthGodConfig:permanentLedBeginTime	J
    //   152: putfield 860	com/tencent/mobileqq/armap/config/ARMapConfigManager:jdField_c_of_type_Long	J
    //   155: aload_0
    //   156: aload_0
    //   157: getfield 307	com/tencent/mobileqq/armap/config/ARMapConfigManager:jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig	Lcom/tencent/mobileqq/armap/config/ARMapConfig;
    //   160: getfield 795	com/tencent/mobileqq/armap/config/ARMapConfig:wealthGodConfig	Lcom/tencent/mobileqq/armap/config/ARMapConfig$WealthGodConfig;
    //   163: getfield 863	com/tencent/mobileqq/armap/config/ARMapConfig$WealthGodConfig:permanentLedEndTime	J
    //   166: putfield 865	com/tencent/mobileqq/armap/config/ARMapConfigManager:jdField_d_of_type_Long	J
    //   169: aload_0
    //   170: getfield 307	com/tencent/mobileqq/armap/config/ARMapConfigManager:jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig	Lcom/tencent/mobileqq/armap/config/ARMapConfig;
    //   173: getfield 795	com/tencent/mobileqq/armap/config/ARMapConfig:wealthGodConfig	Lcom/tencent/mobileqq/armap/config/ARMapConfig$WealthGodConfig;
    //   176: getfield 868	com/tencent/mobileqq/armap/config/ARMapConfig$WealthGodConfig:showSpecialLoadingPage	I
    //   179: iconst_1
    //   180: if_icmpne +8 -> 188
    //   183: aload_0
    //   184: iconst_1
    //   185: putfield 869	com/tencent/mobileqq/armap/config/ARMapConfigManager:jdField_a_of_type_Boolean	Z
    //   188: aload_0
    //   189: getfield 307	com/tencent/mobileqq/armap/config/ARMapConfigManager:jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig	Lcom/tencent/mobileqq/armap/config/ARMapConfig;
    //   192: getfield 795	com/tencent/mobileqq/armap/config/ARMapConfig:wealthGodConfig	Lcom/tencent/mobileqq/armap/config/ARMapConfig$WealthGodConfig;
    //   195: getfield 872	com/tencent/mobileqq/armap/config/ARMapConfig$WealthGodConfig:pendantDisplayDuration	I
    //   198: ifle +18 -> 216
    //   201: aload_0
    //   202: aload_0
    //   203: getfield 307	com/tencent/mobileqq/armap/config/ARMapConfigManager:jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig	Lcom/tencent/mobileqq/armap/config/ARMapConfig;
    //   206: getfield 795	com/tencent/mobileqq/armap/config/ARMapConfig:wealthGodConfig	Lcom/tencent/mobileqq/armap/config/ARMapConfig$WealthGodConfig;
    //   209: getfield 872	com/tencent/mobileqq/armap/config/ARMapConfig$WealthGodConfig:pendantDisplayDuration	I
    //   212: i2l
    //   213: putfield 48	com/tencent/mobileqq/armap/config/ARMapConfigManager:jdField_b_of_type_Long	J
    //   216: invokestatic 174	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   219: ifeq +143 -> 362
    //   222: ldc 176
    //   224: iconst_2
    //   225: new 178	java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   232: ldc_w 842
    //   235: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: iload_2
    //   239: invokevirtual 269	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   242: ldc_w 844
    //   245: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: aload_1
    //   249: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   252: ldc_w 874
    //   255: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: aload_0
    //   259: getfield 52	com/tencent/mobileqq/armap/config/ARMapConfigManager:h	J
    //   262: invokevirtual 245	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   265: ldc_w 876
    //   268: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: aload_0
    //   272: getfield 64	com/tencent/mobileqq/armap/config/ARMapConfigManager:f	J
    //   275: invokevirtual 245	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   278: ldc_w 878
    //   281: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: aload_0
    //   285: getfield 54	com/tencent/mobileqq/armap/config/ARMapConfigManager:jdField_i_of_type_Long	J
    //   288: invokevirtual 245	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   291: ldc_w 880
    //   294: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: aload_0
    //   298: getfield 56	com/tencent/mobileqq/armap/config/ARMapConfigManager:jdField_j_of_type_Long	J
    //   301: invokevirtual 245	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   304: ldc_w 882
    //   307: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: aload_0
    //   311: getfield 860	com/tencent/mobileqq/armap/config/ARMapConfigManager:jdField_c_of_type_Long	J
    //   314: invokevirtual 245	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   317: ldc_w 884
    //   320: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: aload_0
    //   324: getfield 865	com/tencent/mobileqq/armap/config/ARMapConfigManager:jdField_d_of_type_Long	J
    //   327: invokevirtual 245	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   330: ldc_w 886
    //   333: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: aload_0
    //   337: getfield 869	com/tencent/mobileqq/armap/config/ARMapConfigManager:jdField_a_of_type_Boolean	Z
    //   340: invokevirtual 595	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   343: ldc_w 888
    //   346: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: aload_0
    //   350: getfield 48	com/tencent/mobileqq/armap/config/ARMapConfigManager:jdField_b_of_type_Long	J
    //   353: invokevirtual 245	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   356: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   359: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   362: aload_0
    //   363: getfield 307	com/tencent/mobileqq/armap/config/ARMapConfigManager:jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig	Lcom/tencent/mobileqq/armap/config/ARMapConfig;
    //   366: getfield 795	com/tencent/mobileqq/armap/config/ARMapConfig:wealthGodConfig	Lcom/tencent/mobileqq/armap/config/ARMapConfig$WealthGodConfig;
    //   369: getfield 891	com/tencent/mobileqq/armap/config/ARMapConfig$WealthGodConfig:showDailyPendantPercent	I
    //   372: istore_2
    //   373: aload_0
    //   374: getfield 307	com/tencent/mobileqq/armap/config/ARMapConfigManager:jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig	Lcom/tencent/mobileqq/armap/config/ARMapConfig;
    //   377: getfield 795	com/tencent/mobileqq/armap/config/ARMapConfig:wealthGodConfig	Lcom/tencent/mobileqq/armap/config/ARMapConfig$WealthGodConfig;
    //   380: getfield 894	com/tencent/mobileqq/armap/config/ARMapConfig$WealthGodConfig:pendantSwitcher	I
    //   383: iconst_1
    //   384: if_icmpne +66 -> 450
    //   387: iconst_1
    //   388: istore_3
    //   389: aload_0
    //   390: getfield 307	com/tencent/mobileqq/armap/config/ARMapConfigManager:jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig	Lcom/tencent/mobileqq/armap/config/ARMapConfig;
    //   393: getfield 795	com/tencent/mobileqq/armap/config/ARMapConfig:wealthGodConfig	Lcom/tencent/mobileqq/armap/config/ARMapConfig$WealthGodConfig;
    //   396: getfield 897	com/tencent/mobileqq/armap/config/ARMapConfig$WealthGodConfig:splashLight	I
    //   399: iconst_1
    //   400: if_icmpne +55 -> 455
    //   403: aload_0
    //   404: iload_2
    //   405: iload_3
    //   406: iload 4
    //   408: invokevirtual 899	com/tencent/mobileqq/armap/config/ARMapConfigManager:a	(IZZ)V
    //   411: aload 5
    //   413: monitorexit
    //   414: invokestatic 903	com/tencent/mobileqq/app/ThreadManager:getFileThreadHandler	()Lmqq/os/MqqHandler;
    //   417: new 905	aaya
    //   420: dup
    //   421: aload_0
    //   422: invokespecial 906	aaya:<init>	(Lcom/tencent/mobileqq/armap/config/ARMapConfigManager;)V
    //   425: invokevirtual 912	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   428: pop
    //   429: aload_0
    //   430: iconst_1
    //   431: putfield 404	com/tencent/mobileqq/armap/config/ARMapConfigManager:jdField_i_of_type_Boolean	Z
    //   434: aload_0
    //   435: lconst_0
    //   436: invokespecial 525	com/tencent/mobileqq/armap/config/ARMapConfigManager:c	(J)V
    //   439: aload_0
    //   440: invokespecial 914	com/tencent/mobileqq/armap/config/ARMapConfigManager:i	()V
    //   443: aload_0
    //   444: invokespecial 916	com/tencent/mobileqq/armap/config/ARMapConfigManager:j	()V
    //   447: aload_0
    //   448: monitorexit
    //   449: return
    //   450: iconst_0
    //   451: istore_3
    //   452: goto -63 -> 389
    //   455: iconst_0
    //   456: istore 4
    //   458: goto -55 -> 403
    //   461: astore_1
    //   462: aload 5
    //   464: monitorexit
    //   465: aload_1
    //   466: athrow
    //   467: astore_1
    //   468: aload_0
    //   469: monitorexit
    //   470: aload_1
    //   471: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	472	0	this	ARMapConfigManager
    //   0	472	1	paramARMapConfig	ARMapConfig
    //   0	472	2	paramInt	int
    //   388	64	3	bool1	boolean
    //   1	456	4	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   56	111	461	finally
    //   111	188	461	finally
    //   188	216	461	finally
    //   216	362	461	finally
    //   362	387	461	finally
    //   389	403	461	finally
    //   403	411	461	finally
    //   411	414	461	finally
    //   462	465	461	finally
    //   5	47	467	finally
    //   47	56	467	finally
    //   414	447	467	finally
    //   465	467	467	finally
  }
  
  public void a(ARMapConfigManager.ARMapShower paramARMapShower)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapConfigManager", 2, "addShower...... shower = " + paramARMapShower);
    }
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(6, 0, 0, paramARMapShower).sendToTarget();
  }
  
  public void a(WealthGodInfo paramWealthGodInfo)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ARMapConfigManager", 2, "updateWealthGodInfo:" + paramWealthGodInfo);
      }
      this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo = paramWealthGodInfo;
      this.g = NetConnInfoCenter.getServerTimeMillis();
      return;
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    if (c()) {
      if (QLog.isColorLevel()) {
        QLog.d("ARMapConfigManager", 2, "checkRestorePendantBreathStatus inCurfew ,return . actKey = " + paramString);
      }
    }
    for (;;)
    {
      return;
      SharedPreferences localSharedPreferences = ArMapUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      try
      {
        l1 = Long.decode(localSharedPreferences.getString("pendant_breath_dismiss_timestamp", "")).longValue();
        long l2 = MessageCache.a() * 1000L;
        if (QLog.isColorLevel()) {
          QLog.d("ARMapConfigManager", 2, "checkRestorePendantBreathStatus actKey:" + paramString + ",dismissTimestamp:" + l1 + ",curTime:" + l2);
        }
        if ((TextUtils.isEmpty(paramString)) || (l1 <= l2)) {
          continue;
        }
        boolean bool = paramString.equals("daily_pendant_breath");
        if (QLog.isColorLevel()) {
          QLog.d("ARMapConfigManager", 2, "checkRestorePendantBreathStatus need restore , isDaily:" + bool);
        }
        a(paramString, true, 0L);
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          long l1 = 0L;
        }
      }
    }
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      if (paramLong == 0L) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      localMessage.obj = paramString;
      localMessage.arg1 = paramInt;
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, paramLong);
      if (QLog.isColorLevel()) {
        QLog.d("ARMapConfigManager", 2, "dismissPendantBreath key:" + paramString + ",dismissReason:" + paramInt + ",delayMills" + paramLong);
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean, long paramLong)
  {
    int n = 1;
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ARMapConfigManager", 2, "showPendantBreath key:" + paramString + ",isRecovery:" + paramBoolean + ",delayMills:" + paramLong + ",key is showing,return.");
      }
      return;
    }
    Object localObject = ArMapUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).getString("wealth_god_pendant_status", "");
    int m;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("#");
      if (localObject != null)
      {
        int i1 = localObject.length;
        m = 0;
        label131:
        if (m < i1) {
          if (!localObject[m].equalsIgnoreCase(paramString)) {}
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if ((!bool) && (this.jdField_a_of_type_AndroidOsHandler != null))
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
        localObject = Message.obtain();
        ((Message)localObject).what = 0;
        if (!paramBoolean) {
          break label289;
        }
      }
      label289:
      for (m = n;; m = 0)
      {
        ((Message)localObject).arg1 = m;
        ((Message)localObject).obj = paramString;
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, paramLong);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ARMapConfigManager", 2, "showPendantBreath key:" + paramString + ",isRecovery:" + paramBoolean + ",delayMills:" + paramLong + ",hasShown:" + bool);
        return;
        m += 1;
        break label131;
      }
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    if (Build.VERSION.SDK_INT < 14) {
      bool = true;
    }
    Object localObject = SplashBitmapUtils.a();
    if (localObject == null) {}
    for (localObject = "ON";; localObject = ((ARMapDPC)localObject).jdField_b_of_type_JavaLangString)
    {
      if ("OFF".equals(localObject)) {
        bool = true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ARMapConfigManager", 2, "isARMapForbidden resutl = " + bool + ",dpconfig = " + (String)localObject);
      }
      if (bool) {
        QLog.d("ARMapConfigManager", 1, "isARMapForbidden resutl = " + bool + ",dpconfig = " + (String)localObject);
      }
      return bool;
    }
  }
  
  public boolean a(int paramInt)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("ARMapConfigManager", 2, "isNetworkCanPredown");
    }
    if (paramInt == 1) {
      return true;
    }
    int m = NetworkUtil.a(BaseApplicationImpl.getContext());
    if (paramInt == 0) {
      if ((m != 1) && (m != 4)) {}
    }
    for (bool = true;; bool = true) {
      do
      {
        if (QLog.isColorLevel()) {
          QLog.d("ARMapConfigManager", 2, "isNetworkCanPredown, type=" + m + ", dpcValue=" + paramInt + ", can=" + bool);
        }
        return bool;
      } while ((m != 1) && (m != 4) && (m != 3));
    }
  }
  
  public double b()
  {
    return this.jdField_b_of_type_Double;
  }
  
  public long b()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ARMapConfigManager", 2, String.format("getCacheUpdateTime mCacheUpdateTime=%s", new Object[] { Long.valueOf(this.g) }));
      }
      long l = this.g;
      return l;
    }
    finally {}
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapConfigManager", 2, "checkPermanentBreathLED");
    }
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = ArMapUtil.a(this.jdField_c_of_type_Long);
    if (l1 > ArMapUtil.a(this.jdField_d_of_type_Long)) {
      if (QLog.isColorLevel()) {
        QLog.d("ARMapConfigManager", 2, "checkPermanentBreathLED over time");
      }
    }
    while (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    if (l2 > l1) {}
    for (l1 = l2 - l1;; l1 = 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ARMapConfigManager", 2, "checkPermanentBreathLED turn on ,delayMills = " + l1);
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, l1);
      return;
    }
  }
  
  public void b(ARMapConfigManager.ARMapShower paramARMapShower)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapConfigManager", 2, "removeShower.....");
    }
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(7, 0, 0, null).sendToTarget();
  }
  
  public void b(String paramString)
  {
    int n = 0;
    if (QLog.isColorLevel()) {
      QLog.d("ARMapConfigManager", 2, "markActPendantBreathHasShown acKey:" + paramString);
    }
    if ((TextUtils.isEmpty(paramString)) || (paramString.equals("daily_pendant_breath"))) {
      return;
    }
    SharedPreferences localSharedPreferences = ArMapUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    String str = localSharedPreferences.getString("wealth_god_pendant_status", "");
    String[] arrayOfString = str.split("#");
    if (arrayOfString != null)
    {
      int i1 = arrayOfString.length;
      m = 0;
      if (m < i1) {
        if (!arrayOfString[m].equalsIgnoreCase(paramString)) {}
      }
    }
    for (int m = n;; m = 1)
    {
      if (m != 0) {
        if (str.length() > 255) {
          label132:
          localSharedPreferences.edit().putString("wealth_god_pendant_status", paramString).commit();
        }
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label227;
        }
        QLog.d("ARMapConfigManager", 2, "markActPendantBreathHasShown |list = " + paramString);
        return;
        m += 1;
        break;
        paramString = str + "#" + paramString;
        break label132;
        paramString = str;
      }
      label227:
      break;
    }
  }
  
  public boolean b()
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig.wealthGodConfig != null) {
        break label27;
      }
      bool2 = bool1;
    }
    label27:
    String str1;
    String str2;
    do
    {
      do
      {
        return bool2;
        if (!c()) {
          break;
        }
        bool2 = bool1;
      } while (!QLog.isColorLevel());
      QLog.d("ARMapConfigManager", 2, "checkShouldShowDailyBreathe inCurfew ,return false");
      return false;
      SharedPreferences localSharedPreferences = ArMapUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      str1 = localSharedPreferences.getString("wealth_god_daily_breathe_date", null);
      str2 = a(NetConnInfoCenter.getServerTimeMillis());
      bool1 = bool3;
      if (str2 != null)
      {
        bool1 = bool3;
        if (!TextUtils.equals(str2, str1))
        {
          bool1 = true;
          localSharedPreferences.edit().putString("wealth_god_daily_breathe_date", str2).commit();
        }
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("ARMapConfigManager", 2, "checkShouldShowDailyBreathe breatheDate:" + str1 + ",curDate:" + str2 + ",result:" + bool1);
    return bool1;
  }
  
  public long c()
  {
    long l = -1L;
    if (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo != null) {
      l = this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.jdField_c_of_type_Long;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ARMapConfigManager", 2, "nextActiveBeginTime  res:" + l + ",mWealthGodInfoCache:" + this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo + " mCuoFengTime:" + this.jdField_k_of_type_Long);
    }
    return l;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapConfigManager", 2, "onEnterARMapLoadingPage mShower=" + this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfigManager$ARMapShower + "   this=" + this + " mApp=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig != null) {
      return ArMapUtil.a(this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig).jdField_a_of_type_Boolean;
    }
    return false;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapConfigManager", 2, "onEnterARMap ,mShower  = " + this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfigManager$ARMapShower + "   this=" + this + " mApp=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface + ",mCurShownPendantKey = " + this.jdField_a_of_type_JavaLangString);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfigManager$ARMapShower != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      a(this.jdField_a_of_type_JavaLangString, 3, 0L);
    }
  }
  
  public boolean d()
  {
    boolean bool2 = false;
    long l1 = -1L;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo != null)
    {
      long l2 = MessageCache.a() * 1000L;
      bool1 = bool2;
      l1 = l2;
      if (l2 > this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.jdField_c_of_type_Long)
      {
        bool1 = bool2;
        l1 = l2;
        if (l2 < this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.jdField_d_of_type_Long)
        {
          bool1 = true;
          l1 = l2;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ARMapConfigManager", 2, "isActTime:" + bool1 + ",mWealthGodInfoCache:" + this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo + " mCuoFengTime:" + this.jdField_k_of_type_Long + "  curTime:" + l1);
    }
    return bool1;
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig != null) && (this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig.isWealthGodEnterOpen()) && (this.jdField_j_of_type_Boolean)) {
      a(0L);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig != null) && (this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig.isWealthGodEnterOpen()) && (this.jdField_k_of_type_Boolean)) {
      b(0L);
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onMsgTabResume,needReSetLocateTimer = ").append(this.jdField_j_of_type_Boolean).append(",needReSetWealthTimer = ").append(this.jdField_k_of_type_Boolean).append(",EntryON = ");
      if (this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig == null) {
        break label134;
      }
    }
    label134:
    for (boolean bool = this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig.isWealthGodEnterOpen();; bool = false)
    {
      QLog.d("ARMapConfigManager", 2, bool);
      return;
    }
  }
  
  public boolean e()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    long l;
    if (this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo != null)
    {
      l = MessageCache.a() * 1000L;
      if (l >= this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.jdField_c_of_type_Long - this.jdField_k_of_type_Long) {
        break label98;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ARMapConfigManager", 2, "canRefreshMsg can:" + bool1 + ",mWealthGodInfoCache:" + this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo + " mCuoFengTime:" + this.jdField_k_of_type_Long);
      }
      return bool1;
      label98:
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig.wealthGodConfig != null)
        {
          bool1 = bool2;
          if (l < this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.jdField_c_of_type_Long + this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig.wealthGodConfig.dragRefreshAfterBegin)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ARMapConfigManager", 2, "canRefreshMsg beginTime:" + this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.jdField_c_of_type_Long + " endTime:" + this.jdField_a_of_type_ComTencentMobileqqArmapWealthgodWealthGodInfo.jdField_d_of_type_Long + ", curTime:" + l + ", dragRefreshAfterBegin:" + this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig.wealthGodConfig.dragRefreshAfterBegin);
            }
            bool1 = false;
          }
        }
      }
    }
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapConfigManager", 2, "onMsgTabStop");
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapConfigManager", 2, "onDestroy");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqArmapArMapObserver);
    this.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfigManager$ARMapShower = null;
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null) {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
    }
    ArMapIPCProxy.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.config.ARMapConfigManager
 * JD-Core Version:    0.7.0.1
 */