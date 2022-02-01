package com.tencent.mobileqq.banner;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseArray;
import com.tencent.mobileqq.activity.recent.bannerprocessor.ApolloGameBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.ArkInfoBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.AutoStatusBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.BeginnerGuideBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.BrowserBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.ComicBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.ContactBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.DonDisturbBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.GameBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.GameCenterBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.GeneralBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.HotSpotBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.IllegalNetworkBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.InstallUpgradeBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.LoginDevicesBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.MissedCallBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.MobileUnityBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.MsgBackupBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.MsgProxyBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.MultiVideoBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.MusicPlayerBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.NetNeedSignOnBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.NetStateBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.NotificationGuideBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.PCOnlineBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.PhoneUnityBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.PushBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.QBossADBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.QFileMusicPlayingBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.QLinkTransingBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.QQWifiBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.ReaderBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.RenewalsBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.RunningBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.SecureModifyPwdNotifyBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.SecurePhoneChangeNotifyBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.SecurityDetectBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.SetPwdBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.ThemeOverdueBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.ThemeVersionUpdateBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.TimUpgradeBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.TroopAssistBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.UpdateBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.UpgradeBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.WifiPhotoBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.WifiSecurityCheckBannerProcessor;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.banner.processor.IBannerLifecycle;
import com.tencent.mobileqq.banner.processor.IBannerOnAddToView;
import com.tencent.mobileqq.banner.processor.IBannerOnUpdateBannerState;
import com.tencent.mobileqq.banner.processor.IBannerProcessor;
import com.tencent.mobileqq.banner.processor.IBannerViewScroll;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.TextHook;
import com.tencent.widget.XListView;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class BannerManager
{
  public static int a;
  private static volatile BannerManager jdField_a_of_type_ComTencentMobileqqBannerBannerManager;
  @ConfigInject(configPath="/Foundation/QQActivity/src/main/resources/Inject_banner_processor_map.yml", version=5)
  private static HashMap<String, Class<? extends IBannerProcessor>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public static int b;
  @ConfigInject(configPath="/Foundation/QQActivity/src/main/resources/Inject_banner_processor_map.yml", version=5)
  private static HashMap<String, Class<? extends IBannerProcessor>> jdField_b_of_type_JavaUtilHashMap;
  private static volatile boolean jdField_b_of_type_Boolean;
  private static int jdField_c_of_type_Int;
  @ConfigInject(configPath="/Foundation/QQActivity/src/main/resources/Inject_banner_processor_map.yml", version=5)
  private static HashMap<String, Class<? extends IBannerProcessor>> jdField_c_of_type_JavaUtilHashMap;
  private static int jdField_d_of_type_Int;
  @ConfigInject(configPath="/Foundation/QQActivity/src/main/resources/Inject_banner_processor_map.yml", version=5)
  private static HashMap<String, Class<? extends IBannerProcessor>> jdField_d_of_type_JavaUtilHashMap;
  private static int jdField_e_of_type_Int;
  @ConfigInject(configPath="/Foundation/QQActivity/src/main/resources/Inject_banner_processor_map.yml", version=5)
  private static HashMap<String, Class<? extends IBannerProcessor>> jdField_e_of_type_JavaUtilHashMap;
  private static int jdField_f_of_type_Int;
  @ConfigInject(configPath="/Foundation/QQActivity/src/main/resources/Inject_banner_processor_map.yml", version=5)
  private static HashMap<String, Class<? extends IBannerProcessor>> jdField_f_of_type_JavaUtilHashMap;
  private static int jdField_g_of_type_Int;
  @ConfigInject(configPath="/Foundation/QQActivity/src/main/resources/Inject_banner_processor_map.yml", version=5)
  private static HashMap<String, Class<? extends IBannerProcessor>> jdField_g_of_type_JavaUtilHashMap;
  private static int jdField_h_of_type_Int;
  private static int i;
  private static int j;
  private static int k;
  private static int l;
  private static int m;
  private static int n;
  private static int o;
  private final SparseArray<ArrayList<Integer>> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(7);
  private QBaseActivity jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private final ArrayList<IBannerOnAddToView> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  private Banner[] jdField_a_of_type_ArrayOfComTencentMobileqqBannerBanner;
  private SparseArray<ArrayList<Integer>> jdField_b_of_type_AndroidUtilSparseArray;
  private final ArrayList<IBannerOnUpdateBannerState> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private final ArrayList<IBannerLifecycle> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  private final ArrayList<IBannerViewScroll> jdField_d_of_type_JavaUtilArrayList = new ArrayList();
  private final HashMap<String, IBannerProcessor> jdField_h_of_type_JavaUtilHashMap = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap.put("30", AutoStatusBannerProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("29", TimUpgradeBannerProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("28", ThemeOverdueBannerProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("27", ThemeVersionUpdateBannerProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("26", RenewalsBannerProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("25", QQWifiBannerProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("24", PushBannerProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("23", QBossADBannerProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("22", SecurityDetectBannerProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("21", NotificationGuideBannerProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("20", SetPwdBannerProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("19", TroopAssistBannerProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("18", ContactBannerProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("17", InstallUpgradeBannerProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("16", UpdateBannerProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("15", UpgradeBannerProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("14", PCOnlineBannerProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("13", DonDisturbBannerProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("12", IllegalNetworkBannerProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("11", NetNeedSignOnBannerProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("10", WifiPhotoBannerProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("9", MobileUnityBannerProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("8", HotSpotBannerProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("7", MissedCallBannerProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("6", ArkInfoBannerProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("5", SecurePhoneChangeNotifyBannerProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("4", WifiSecurityCheckBannerProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("3", SecureModifyPwdNotifyBannerProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("2", PhoneUnityBannerProcessor.class);
    jdField_a_of_type_JavaUtilHashMap.put("1", NetStateBannerProcessor.class);
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_JavaUtilHashMap.put("31", LoginDevicesBannerProcessor.class);
    jdField_c_of_type_JavaUtilHashMap = new HashMap();
    jdField_c_of_type_JavaUtilHashMap.put("40", GeneralBannerProcessor.class);
    jdField_c_of_type_JavaUtilHashMap.put("39", MsgProxyBannerProcessor.class);
    jdField_c_of_type_JavaUtilHashMap.put("38", ApolloGameBannerProcessor.class);
    jdField_c_of_type_JavaUtilHashMap.put("37", RunningBannerProcessor.class);
    jdField_c_of_type_JavaUtilHashMap.put("36", GameBannerProcessor.class);
    jdField_c_of_type_JavaUtilHashMap.put("35", GameCenterBannerProcessor.class);
    jdField_c_of_type_JavaUtilHashMap.put("34", BrowserBannerProcessor.class);
    jdField_c_of_type_JavaUtilHashMap.put("33", ComicBannerProcessor.class);
    jdField_c_of_type_JavaUtilHashMap.put("32", ReaderBannerProcessor.class);
    jdField_d_of_type_JavaUtilHashMap = new HashMap();
    jdField_d_of_type_JavaUtilHashMap.put("41", MusicPlayerBannerProcessor.class);
    jdField_e_of_type_JavaUtilHashMap = new HashMap();
    jdField_e_of_type_JavaUtilHashMap.put("44", QFileMusicPlayingBannerProcessor.class);
    jdField_e_of_type_JavaUtilHashMap.put("43", QLinkTransingBannerProcessor.class);
    jdField_e_of_type_JavaUtilHashMap.put("42", MultiVideoBannerProcessor.class);
    jdField_f_of_type_JavaUtilHashMap = new HashMap();
    jdField_f_of_type_JavaUtilHashMap.put("45", MsgBackupBannerProcessor.class);
    jdField_g_of_type_JavaUtilHashMap = new HashMap();
    jdField_g_of_type_JavaUtilHashMap.put("46", BeginnerGuideBannerProcessor.class);
  }
  
  private BannerManager()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static BannerManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqBannerBannerManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqBannerBannerManager == null) {
        jdField_a_of_type_ComTencentMobileqqBannerBannerManager = new BannerManager();
      }
      return jdField_a_of_type_ComTencentMobileqqBannerBannerManager;
    }
    finally {}
  }
  
  private void a(Banner paramBanner)
  {
    if ((paramBanner == null) || (paramBanner.jdField_a_of_type_AndroidViewView != null)) {}
    do
    {
      IBannerProcessor localIBannerProcessor;
      do
      {
        return;
        localIBannerProcessor = (IBannerProcessor)this.jdField_h_of_type_JavaUtilHashMap.get(String.valueOf(paramBanner.jdField_a_of_type_Int));
        if (localIBannerProcessor != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.recent.banner", 2, new Object[] { "initBannerView: key=", Integer.valueOf(paramBanner.jdField_a_of_type_Int), ", processor=null" });
      return;
      paramBanner.jdField_a_of_type_AndroidViewView = localIBannerProcessor.a(paramBanner);
      if ((paramBanner.jdField_a_of_type_AndroidViewView instanceof TipsBar)) {
        a((TipsBar)paramBanner.jdField_a_of_type_AndroidViewView, localIBannerProcessor.a());
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("Q.recent.banner", 2, new Object[] { "initBannerView | banner = ", paramBanner });
  }
  
  private void a(Banner paramBanner, Message paramMessage)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.recent.banner", 2, new Object[] { "updateBanner| banner = ", paramBanner, ", msg = ", paramMessage });
    }
    if ((paramBanner == null) || (paramBanner.jdField_a_of_type_AndroidViewView == null)) {}
    do
    {
      IBannerProcessor localIBannerProcessor;
      do
      {
        return;
        TextHook.updateFont(paramBanner.jdField_a_of_type_AndroidViewView);
        localIBannerProcessor = (IBannerProcessor)this.jdField_h_of_type_JavaUtilHashMap.get(String.valueOf(paramBanner.jdField_a_of_type_Int));
        if (localIBannerProcessor != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.recent.banner", 2, new Object[] { "updateBanner: key=", Integer.valueOf(paramBanner.jdField_a_of_type_Int), ", processor=null" });
      return;
      localIBannerProcessor.a(paramBanner, paramMessage);
    } while (!(paramBanner.jdField_a_of_type_AndroidViewView instanceof TipsBar));
    a((TipsBar)paramBanner.jdField_a_of_type_AndroidViewView);
  }
  
  private void a(TipsBar paramTipsBar)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      String str = QQTheme.a();
      if ((QQTheme.d()) || (QQTheme.c(str))) {
        if (paramTipsBar.a() == 2) {
          paramTipsBar.setBarType(6);
        }
      }
    }
    for (;;)
    {
      paramTipsBar.a();
      return;
      if (paramTipsBar.a() == 6)
      {
        paramTipsBar.setBarType(2);
      }
      else if (!QQTheme.a())
      {
        paramTipsBar.setBarType(2);
        continue;
        if (paramTipsBar.a() == 6) {
          paramTipsBar.setBarType(2);
        }
      }
    }
  }
  
  private void a(TipsBar paramTipsBar, int paramInt)
  {
    String str = QQTheme.a();
    if ((paramInt == 2) && (this.jdField_a_of_type_Boolean) && ((QQTheme.d()) || (QQTheme.c(str))))
    {
      paramTipsBar.setBarType(6);
      return;
    }
    paramTipsBar.setBarType(paramInt);
  }
  
  private boolean a()
  {
    int i1 = 0;
    while (i1 < 7)
    {
      List localList = (List)this.jdField_a_of_type_AndroidUtilSparseArray.get(i1);
      if (!((List)this.jdField_b_of_type_AndroidUtilSparseArray.get(i1)).equals(localList)) {
        return false;
      }
      i1 += 1;
    }
    return true;
  }
  
  private boolean a(Banner paramBanner, boolean paramBoolean, Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 1, new Object[] { "[banner] addBannerViewToMsgTabHeader: invoked. ", " refreshMsg: ", paramMessage, " banner: ", paramBanner });
    }
    if (paramBanner == null) {
      return false;
    }
    a(paramBanner);
    try
    {
      Iterator localIterator;
      if ((paramBanner.jdField_a_of_type_AndroidViewView != null) && (!paramBanner.jdField_a_of_type_Boolean) && (!paramBoolean))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent.banner", 2, "fight.addHeaderView_3.");
        }
        localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      }
      while (localIterator.hasNext())
      {
        ((IBannerOnAddToView)localIterator.next()).a(paramBanner);
        continue;
        a(paramBanner, paramMessage);
      }
    }
    catch (Exception localException)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.recent.banner", 2, new Object[] { "initBanner|", localException.toString() });
      }
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(paramBanner.jdField_a_of_type_AndroidViewView, 1);
      AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
      if (localAppRuntime != null) {
        a(localAppRuntime, paramBanner.jdField_a_of_type_Int);
      }
      paramBanner.jdField_a_of_type_Boolean = true;
    }
  }
  
  private boolean a(String paramString, Class<? extends IBannerProcessor> paramClass)
  {
    Class<? extends IBannerProcessor> localClass = null;
    if (paramClass == null)
    {
      QLog.d("Q.recent.banner", 1, "handleProcessorClz: processorClz == null");
      return false;
    }
    try
    {
      paramClass = (IBannerProcessor)paramClass.getDeclaredConstructor(new Class[] { QBaseActivity.class }).newInstance(new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity });
      localClass = paramClass;
      paramClass = null;
    }
    catch (InvocationTargetException paramClass)
    {
      break label54;
    }
    catch (InstantiationException paramClass)
    {
      break label54;
    }
    catch (IllegalAccessException paramClass)
    {
      break label54;
    }
    catch (NoSuchMethodException paramClass)
    {
      label54:
      break label54;
    }
    if (localClass == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "handleProcessorClzz: processor=null, exception:", paramClass);
      }
      return false;
    }
    this.jdField_h_of_type_JavaUtilHashMap.put(paramString, localClass);
    if ((localClass instanceof IBannerViewScroll)) {
      this.jdField_d_of_type_JavaUtilArrayList.add((IBannerViewScroll)localClass);
    }
    if ((localClass instanceof IBannerLifecycle)) {
      this.jdField_c_of_type_JavaUtilArrayList.add((IBannerLifecycle)localClass);
    }
    if ((localClass instanceof IBannerOnAddToView)) {
      this.jdField_a_of_type_JavaUtilArrayList.add((IBannerOnAddToView)localClass);
    }
    if ((localClass instanceof IBannerOnUpdateBannerState)) {
      this.jdField_b_of_type_JavaUtilArrayList.add((IBannerOnUpdateBannerState)localClass);
    }
    return true;
  }
  
  private boolean b()
  {
    int i1 = 0;
    while (i1 < 7)
    {
      if (!((List)this.jdField_b_of_type_AndroidUtilSparseArray.get(i1)).isEmpty()) {
        return false;
      }
      i1 += 1;
    }
    return true;
  }
  
  private void c()
  {
    this.jdField_h_of_type_JavaUtilHashMap.clear();
    this.jdField_d_of_type_JavaUtilArrayList.clear();
    this.jdField_c_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    jdField_c_of_type_Int = 1;
    jdField_d_of_type_Int = jdField_c_of_type_Int;
    Iterator localIterator = jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    String str;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (a(str, (Class)jdField_a_of_type_JavaUtilHashMap.get(str))) {
        jdField_d_of_type_Int += 1;
      }
    }
    jdField_e_of_type_Int = jdField_d_of_type_Int;
    jdField_f_of_type_Int = jdField_e_of_type_Int;
    localIterator = jdField_b_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (a(str, (Class)jdField_b_of_type_JavaUtilHashMap.get(str))) {
        jdField_f_of_type_Int += 1;
      }
    }
    jdField_a_of_type_Int = jdField_f_of_type_Int;
    jdField_b_of_type_Int = jdField_a_of_type_Int;
    localIterator = jdField_c_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (a(str, (Class)jdField_c_of_type_JavaUtilHashMap.get(str))) {
        jdField_b_of_type_Int += 1;
      }
    }
    jdField_g_of_type_Int = jdField_b_of_type_Int;
    jdField_h_of_type_Int = jdField_g_of_type_Int;
    localIterator = jdField_d_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (a(str, (Class)jdField_d_of_type_JavaUtilHashMap.get(str))) {
        jdField_h_of_type_Int += 1;
      }
    }
    i = jdField_h_of_type_Int;
    j = i;
    localIterator = jdField_e_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (a(str, (Class)jdField_e_of_type_JavaUtilHashMap.get(str))) {
        j += 1;
      }
    }
    k = j;
    l = k;
    localIterator = jdField_f_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (a(str, (Class)jdField_f_of_type_JavaUtilHashMap.get(str))) {
        l += 1;
      }
    }
    m = l;
    n = m;
    localIterator = jdField_g_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if (a(str, (Class)jdField_g_of_type_JavaUtilHashMap.get(str))) {
        n += 1;
      }
    }
    o = n;
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    AppRuntime localAppRuntime;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity != null)
    {
      localAppRuntime = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime();
      if (paramInt2 != 2) {
        break label36;
      }
      if (localAppRuntime != null) {
        a(localAppRuntime, paramInt1);
      }
    }
    label36:
    while ((paramInt2 != 0) || (localAppRuntime == null))
    {
      return;
      localAppRuntime = null;
      break;
    }
    b(localAppRuntime, paramInt1);
  }
  
  private void c(int paramInt, Message paramMessage)
  {
    int i1 = 0;
    Object localObject;
    if (i1 < 7)
    {
      localObject = (ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(i1);
      if (localObject != null)
      {
        Iterator localIterator = ((ArrayList)localObject).iterator();
        boolean bool = false;
        label36:
        if (localIterator.hasNext())
        {
          int i2 = ((Integer)localIterator.next()).intValue();
          Banner localBanner = this.jdField_a_of_type_ArrayOfComTencentMobileqqBannerBanner[i2];
          if (paramMessage == null)
          {
            localObject = null;
            label77:
            if (paramInt != i2) {
              localObject = null;
            }
            if (!a(localBanner, bool, (Message)localObject)) {
              break label220;
            }
            if ((QLog.isColorLevel()) && (!bool)) {
              QLog.d("Q.recent.banner", 2, new Object[] { "showAllBanner, show banner, banner_layer:", Integer.valueOf(i1), " bannerId:", Integer.valueOf(i2) });
            }
            if ((QLog.isColorLevel()) && (bool)) {
              QLog.d("Q.recent.banner", 2, new Object[] { "showAllBanner, cache banner, banner_layer:", Integer.valueOf(i1), " bannerId:", Integer.valueOf(i2) });
            }
            bool = true;
          }
        }
      }
    }
    label220:
    for (;;)
    {
      break label36;
      localObject = Message.obtain(paramMessage);
      break label77;
      i1 += 1;
      break;
      return;
    }
  }
  
  private void d()
  {
    int i1 = 0;
    while (i1 < 7)
    {
      ArrayList localArrayList = (ArrayList)this.jdField_b_of_type_AndroidUtilSparseArray.get(i1);
      if (localArrayList != null) {
        this.jdField_a_of_type_AndroidUtilSparseArray.put(i1, new ArrayList(localArrayList));
      }
      i1 += 1;
    }
  }
  
  private void e()
  {
    if (this.jdField_b_of_type_AndroidUtilSparseArray == null) {
      this.jdField_b_of_type_AndroidUtilSparseArray = new SparseArray(7);
    }
    int i1 = 0;
    if (i1 < 7)
    {
      ArrayList localArrayList = (ArrayList)this.jdField_b_of_type_AndroidUtilSparseArray.get(i1);
      if (localArrayList == null)
      {
        localArrayList = new ArrayList(1);
        this.jdField_b_of_type_AndroidUtilSparseArray.put(i1, localArrayList);
      }
      for (;;)
      {
        i1 += 1;
        break;
        localArrayList.clear();
      }
    }
    i1 = jdField_c_of_type_Int;
    while (i1 < jdField_d_of_type_Int)
    {
      if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqBannerBanner[i1] != null) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqBannerBanner[i1].a())) {
        ((ArrayList)this.jdField_b_of_type_AndroidUtilSparseArray.get(0)).add(Integer.valueOf(i1));
      }
      i1 += 1;
    }
    i1 = jdField_e_of_type_Int;
    while (i1 < jdField_f_of_type_Int)
    {
      if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqBannerBanner[i1] != null) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqBannerBanner[i1].a())) {
        ((ArrayList)this.jdField_b_of_type_AndroidUtilSparseArray.get(1)).add(Integer.valueOf(i1));
      }
      i1 += 1;
    }
    i1 = jdField_a_of_type_Int;
    while (i1 < jdField_b_of_type_Int)
    {
      if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqBannerBanner[i1] != null) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqBannerBanner[i1].a())) {
        ((ArrayList)this.jdField_b_of_type_AndroidUtilSparseArray.get(2)).add(Integer.valueOf(i1));
      }
      i1 += 1;
    }
    i1 = jdField_g_of_type_Int;
    while (i1 < jdField_h_of_type_Int)
    {
      if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqBannerBanner[i1] != null) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqBannerBanner[i1].a())) {
        ((ArrayList)this.jdField_b_of_type_AndroidUtilSparseArray.get(3)).add(Integer.valueOf(i1));
      }
      i1 += 1;
    }
    i1 = i;
    while (i1 < j)
    {
      if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqBannerBanner[i1] != null) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqBannerBanner[i1].a())) {
        ((ArrayList)this.jdField_b_of_type_AndroidUtilSparseArray.get(4)).add(Integer.valueOf(i1));
      }
      i1 += 1;
    }
    i1 = k;
    while (i1 < l)
    {
      if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqBannerBanner[i1] != null) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqBannerBanner[i1].a())) {
        ((ArrayList)this.jdField_b_of_type_AndroidUtilSparseArray.get(5)).add(Integer.valueOf(i1));
      }
      i1 += 1;
    }
    i1 = m;
    while (i1 < n)
    {
      if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqBannerBanner[i1] != null) && (this.jdField_a_of_type_ArrayOfComTencentMobileqqBannerBanner[i1].a())) {
        ((ArrayList)this.jdField_b_of_type_AndroidUtilSparseArray.get(6)).add(Integer.valueOf(i1));
      }
      i1 += 1;
    }
  }
  
  private void f()
  {
    int i1 = 0;
    if (i1 < 7)
    {
      Object localObject = (ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(i1);
      if ((localObject == null) || (((ArrayList)localObject).size() == 0)) {}
      for (;;)
      {
        i1 += 1;
        break;
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          int i2 = ((Integer)((Iterator)localObject).next()).intValue();
          Banner localBanner = this.jdField_a_of_type_ArrayOfComTencentMobileqqBannerBanner[i2];
          if ((localBanner != null) && (localBanner.jdField_a_of_type_AndroidViewView != null) && (localBanner.jdField_a_of_type_Boolean))
          {
            this.jdField_a_of_type_ComTencentWidgetXListView.removeHeaderView(localBanner.jdField_a_of_type_AndroidViewView);
            AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            if (localAppRuntime != null) {
              b(localAppRuntime, localBanner.jdField_a_of_type_Int);
            }
            localBanner.jdField_a_of_type_Boolean = false;
            if (!localBanner.a()) {
              localBanner.jdField_a_of_type_AndroidViewView = null;
            }
          }
        }
      }
    }
  }
  
  public int a(int paramInt)
  {
    if (!jdField_b_of_type_Boolean) {}
    Object localObject1;
    do
    {
      return 0;
      Object localObject2 = null;
      localObject1 = localObject2;
      if (paramInt >= 0)
      {
        localObject1 = localObject2;
        if (paramInt < this.jdField_a_of_type_ArrayOfComTencentMobileqqBannerBanner.length) {
          localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqBannerBanner[paramInt];
        }
      }
    } while (localObject1 == null);
    return ((Banner)localObject1).jdField_b_of_type_Int;
  }
  
  @Nullable
  public Banner a(int paramInt)
  {
    if (!jdField_b_of_type_Boolean) {
      return null;
    }
    return this.jdField_a_of_type_ArrayOfComTencentMobileqqBannerBanner[paramInt];
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_h_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      IBannerProcessor localIBannerProcessor = (IBannerProcessor)this.jdField_h_of_type_JavaUtilHashMap.get(str);
      if (localIBannerProcessor == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent.banner", 2, new Object[] { "onAccountChanged: key=", str, ", processor=null" });
        }
        return;
      }
      localIBannerProcessor.a();
    }
    a(-1, null);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (!jdField_b_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = (IBannerProcessor)this.jdField_h_of_type_JavaUtilHashMap.get(String.valueOf(paramInt1));
      if (localObject == null) {
        break label188;
      }
    }
    label188:
    for (Object localObject = localObject.getClass().getSimpleName();; localObject = String.valueOf(paramInt1))
    {
      QLog.d("Q.recent.banner", 2, new Object[] { "updateBannerState|[", localObject, ",", Integer.valueOf(paramInt2), "]" });
      if ((paramInt1 >= 1) && (paramInt1 < o))
      {
        if (this.jdField_a_of_type_ArrayOfComTencentMobileqqBannerBanner[paramInt1] != null) {
          this.jdField_a_of_type_ArrayOfComTencentMobileqqBannerBanner[paramInt1].jdField_b_of_type_Int = paramInt2;
        }
        for (;;)
        {
          localObject = this.jdField_b_of_type_JavaUtilArrayList.iterator();
          while (((Iterator)localObject).hasNext()) {
            ((IBannerOnUpdateBannerState)((Iterator)localObject).next()).a(paramInt1, paramInt2);
          }
          if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqBannerBanner[paramInt1] == null) && (Banner.a(paramInt2))) {
            this.jdField_a_of_type_ArrayOfComTencentMobileqqBannerBanner[paramInt1] = new Banner(paramInt1, paramInt2);
          }
        }
      }
      c(paramInt1, paramInt2);
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong)
  {
    Message localMessage = Message.obtain();
    localMessage.what = paramInt2;
    a(paramInt1, localMessage, paramLong);
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    Message localMessage = Message.obtain();
    localMessage.what = paramInt2;
    a(paramInt1, localMessage, paramLong, paramBoolean);
  }
  
  public void a(int paramInt1, int paramInt2, Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, new Object[] { "updateStateAndRefreshBanner: [", Integer.valueOf(paramInt1), ", ", Integer.valueOf(paramInt2), "]" });
    }
    if (!jdField_b_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "updateStateAndRefreshBanner !sInit");
      }
      return;
    }
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, new Object[] { "updateStateAndRefreshBanner: Looper.myLooper() != Looper.getMainLooper()", Integer.valueOf(paramInt1) });
      }
      ThreadManagerV2.getUIHandlerV2().post(new BannerManager.2(this, paramMessage, paramInt1, paramInt2));
      return;
    }
    a(paramInt1, paramInt2);
    a(paramInt1, paramMessage);
  }
  
  public void a(int paramInt, Message paramMessage)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = (IBannerProcessor)this.jdField_h_of_type_JavaUtilHashMap.get(String.valueOf(paramInt));
      if (localObject1 == null) {
        break label311;
      }
    }
    label142:
    label151:
    label311:
    for (Object localObject1 = localObject1.getClass().getSimpleName();; localObject1 = String.valueOf(paramInt))
    {
      Object localObject2;
      Object localObject3;
      if (paramMessage == null)
      {
        localObject2 = "null";
        if (paramMessage != null) {
          break label142;
        }
        localObject3 = "null";
        label55:
        QLog.d("Q.recent.banner", 2, new Object[] { "refreshBanner: [", localObject1, ", ", localObject2, ", ", localObject3, "]" });
        if (jdField_b_of_type_Boolean) {
          break label151;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent.banner", 2, "refreshBanner !sInit");
        }
      }
      boolean bool1;
      boolean bool2;
      do
      {
        return;
        localObject2 = Integer.valueOf(paramMessage.what);
        break;
        localObject3 = paramMessage.obj;
        break label55;
        if (Looper.myLooper() != Looper.getMainLooper())
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent.banner", 2, new Object[] { "refreshBanner: Looper.myLooper() != Looper.getMainLooper()", Integer.valueOf(paramInt) });
          }
          ThreadManagerV2.getUIHandlerV2().post(new BannerManager.1(this, paramInt, paramMessage));
          return;
        }
        e();
        bool1 = a();
        bool2 = b();
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent.banner", 2, new Object[] { "[refresh] refreshBanner: invoked. ", " isToShowBannersEmpty: ", Boolean.valueOf(bool2), " isBannersEqual: ", Boolean.valueOf(bool1) });
        }
      } while ((bool1) && (bool2));
      if (bool2)
      {
        f();
        return;
      }
      if (!bool1)
      {
        f();
        d();
      }
      c(paramInt, paramMessage);
      return;
    }
  }
  
  public void a(int paramInt, @NonNull Message paramMessage, long paramLong)
  {
    a(paramInt, paramMessage, paramLong, false);
  }
  
  public void a(int paramInt, @NonNull Message paramMessage, long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, new Object[] { "transitMessage: bannerId=", Integer.valueOf(paramInt), ", msg.what=", Integer.valueOf(paramMessage.what) });
    }
    if (!jdField_b_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "transitMessage !sInit");
      }
    }
    IBannerProcessor localIBannerProcessor;
    do
    {
      return;
      localIBannerProcessor = (IBannerProcessor)this.jdField_h_of_type_JavaUtilHashMap.get(String.valueOf(paramInt));
      if (localIBannerProcessor != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.recent.banner", 2, "transitMessage: processor=null");
    return;
    localIBannerProcessor.a(paramMessage, paramLong, paramBoolean);
  }
  
  public void a(QBaseActivity paramQBaseActivity, XListView paramXListView)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, new Object[] { "bind, QBaseActivity:", paramQBaseActivity });
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = paramQBaseActivity;
      this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
      c();
      this.jdField_a_of_type_ArrayOfComTencentMobileqqBannerBanner = new Banner[o];
      jdField_b_of_type_Boolean = true;
      return;
    }
    finally {}
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    Iterator localIterator = this.jdField_h_of_type_JavaUtilHashMap.keySet().iterator();
    for (;;)
    {
      IBannerProcessor localIBannerProcessor;
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localIBannerProcessor = (IBannerProcessor)this.jdField_h_of_type_JavaUtilHashMap.get(str);
        if (localIBannerProcessor != null) {
          break label84;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent.banner", 2, new Object[] { "onBeforeAccountChanged: key=", str, ", processor=null" });
        }
      }
      return;
      label84:
      localIBannerProcessor.a(paramAppRuntime);
    }
  }
  
  public void a(@NonNull AppRuntime paramAppRuntime, int paramInt)
  {
    ((IBannerListenerService)paramAppRuntime.getRuntimeService(IBannerListenerService.class, "")).notifyBannerShow(paramInt);
  }
  
  public void a(@NonNull AppRuntime paramAppRuntime, BannerListener paramBannerListener)
  {
    ((IBannerListenerService)paramAppRuntime.getRuntimeService(IBannerListenerService.class, "")).addBannerListener(paramBannerListener);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(int paramInt)
  {
    if (!jdField_b_of_type_Boolean) {}
    Object localObject1;
    do
    {
      return false;
      Object localObject2 = null;
      localObject1 = localObject2;
      if (paramInt >= 0)
      {
        localObject1 = localObject2;
        if (paramInt < this.jdField_a_of_type_ArrayOfComTencentMobileqqBannerBanner.length) {
          localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqBannerBanner[paramInt];
        }
      }
    } while ((localObject1 == null) || (!((Banner)localObject1).a()));
    return true;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 1, "onResume");
    }
    Iterator localIterator = this.jdField_c_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((IBannerLifecycle)localIterator.next()).b();
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    Message localMessage = Message.obtain();
    localMessage.what = paramInt2;
    b(paramInt1, localMessage);
  }
  
  public void b(int paramInt, @NonNull Message paramMessage)
  {
    a(paramInt, paramMessage, 0L);
  }
  
  public void b(AppRuntime paramAppRuntime)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "onDestroy");
      }
      Iterator localIterator = this.jdField_c_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((IBannerLifecycle)localIterator.next()).b(paramAppRuntime);
      }
      return;
    }
    catch (Exception paramAppRuntime)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "onDestroy", paramAppRuntime);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = null;
      this.jdField_a_of_type_ComTencentWidgetXListView = null;
      this.jdField_h_of_type_JavaUtilHashMap.clear();
      this.jdField_d_of_type_JavaUtilArrayList.clear();
      this.jdField_c_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_ArrayOfComTencentMobileqqBannerBanner = null;
      jdField_b_of_type_Boolean = false;
    }
  }
  
  public void b(@NonNull AppRuntime paramAppRuntime, int paramInt)
  {
    ((IBannerListenerService)paramAppRuntime.getRuntimeService(IBannerListenerService.class, "")).notifyBannerDismiss(paramInt);
  }
  
  public void b(@NonNull AppRuntime paramAppRuntime, BannerListener paramBannerListener)
  {
    ((IBannerListenerService)paramAppRuntime.getRuntimeService(IBannerListenerService.class, "")).removeBannerListener(paramBannerListener);
  }
  
  public void b(boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_d_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((IBannerViewScroll)localIterator.next()).a(paramBoolean);
    }
  }
  
  public boolean b(int paramInt)
  {
    if (!jdField_b_of_type_Boolean) {}
    Object localObject1;
    do
    {
      return false;
      Object localObject2 = null;
      localObject1 = localObject2;
      if (paramInt >= 0)
      {
        localObject1 = localObject2;
        if (paramInt < this.jdField_a_of_type_ArrayOfComTencentMobileqqBannerBanner.length) {
          localObject1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqBannerBanner[paramInt];
        }
      }
    } while ((localObject1 == null) || (!((Banner)localObject1).jdField_a_of_type_Boolean));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.banner.BannerManager
 * JD-Core Version:    0.7.0.1
 */