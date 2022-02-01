package com.tencent.mobileqq.banner;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseArray;
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
import com.tencent.mobileqq.activity.recent.bannerprocessor.QLinkTransingBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.QQWifiBannerProcessor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.RenewalsBannerProcessor;
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
import com.tencent.mobileqq.activity.recent.bannerprocessor.VasADBannerProcessor;
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
import com.tencent.mobileqq.vashealth.RunningBannerProcessor;
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
  private static ArrayList<Class<? extends IBannerProcessor>> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public static int b;
  @ConfigInject(configPath="/Foundation/QQActivity/src/main/resources/Inject_banner_processor_map.yml", version=5)
  private static ArrayList<Class<? extends IBannerProcessor>> jdField_b_of_type_JavaUtilArrayList;
  private static volatile boolean jdField_b_of_type_Boolean;
  private static int jdField_c_of_type_Int;
  @ConfigInject(configPath="/Foundation/QQActivity/src/main/resources/Inject_banner_processor_map.yml", version=5)
  private static ArrayList<Class<? extends IBannerProcessor>> jdField_c_of_type_JavaUtilArrayList;
  private static int jdField_d_of_type_Int;
  @ConfigInject(configPath="/Foundation/QQActivity/src/main/resources/Inject_banner_processor_map.yml", version=5)
  private static ArrayList<Class<? extends IBannerProcessor>> jdField_d_of_type_JavaUtilArrayList;
  private static int jdField_e_of_type_Int;
  @ConfigInject(configPath="/Foundation/QQActivity/src/main/resources/Inject_banner_processor_map.yml", version=5)
  private static ArrayList<Class<? extends IBannerProcessor>> jdField_e_of_type_JavaUtilArrayList;
  private static int jdField_f_of_type_Int;
  @ConfigInject(configPath="/Foundation/QQActivity/src/main/resources/Inject_banner_processor_map.yml", version=5)
  private static ArrayList<Class<? extends IBannerProcessor>> jdField_f_of_type_JavaUtilArrayList;
  private static int jdField_g_of_type_Int;
  @ConfigInject(configPath="/Foundation/QQActivity/src/main/resources/Inject_banner_processor_map.yml", version=5)
  private static ArrayList<Class<? extends IBannerProcessor>> jdField_g_of_type_JavaUtilArrayList;
  private static int jdField_h_of_type_Int;
  private static int jdField_i_of_type_Int;
  private static int jdField_j_of_type_Int;
  private static int jdField_k_of_type_Int;
  private static int l;
  private static int m;
  private static int n;
  private static int o;
  private final SparseArray<ArrayList<Integer>> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(7);
  private QBaseActivity jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private final HashMap<Integer, IBannerProcessor> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public boolean a;
  private Banner[] jdField_a_of_type_ArrayOfComTencentMobileqqBannerBanner;
  private SparseArray<ArrayList<Integer>> jdField_b_of_type_AndroidUtilSparseArray;
  private final ArrayList<IBannerOnAddToView> jdField_h_of_type_JavaUtilArrayList = new ArrayList();
  private final ArrayList<IBannerOnUpdateBannerState> jdField_i_of_type_JavaUtilArrayList = new ArrayList();
  private final ArrayList<IBannerLifecycle> jdField_j_of_type_JavaUtilArrayList = new ArrayList();
  private final ArrayList<IBannerViewScroll> jdField_k_of_type_JavaUtilArrayList = new ArrayList();
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList.add(NetStateBannerProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(PhoneUnityBannerProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(SecureModifyPwdNotifyBannerProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(WifiSecurityCheckBannerProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(SecurePhoneChangeNotifyBannerProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(ArkInfoBannerProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(MissedCallBannerProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(HotSpotBannerProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(MobileUnityBannerProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(WifiPhotoBannerProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(NetNeedSignOnBannerProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(IllegalNetworkBannerProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(DonDisturbBannerProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(PCOnlineBannerProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(UpgradeBannerProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(UpdateBannerProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(InstallUpgradeBannerProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(ContactBannerProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(TroopAssistBannerProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(SetPwdBannerProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(NotificationGuideBannerProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(SecurityDetectBannerProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(VasADBannerProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(PushBannerProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(QQWifiBannerProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(RenewalsBannerProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(ThemeVersionUpdateBannerProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(ThemeOverdueBannerProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(TimUpgradeBannerProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(AutoStatusBannerProcessor.class);
    jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    jdField_b_of_type_JavaUtilArrayList.add(LoginDevicesBannerProcessor.class);
    jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    jdField_c_of_type_JavaUtilArrayList.add(ComicBannerProcessor.class);
    jdField_c_of_type_JavaUtilArrayList.add(BrowserBannerProcessor.class);
    jdField_c_of_type_JavaUtilArrayList.add(GameCenterBannerProcessor.class);
    jdField_c_of_type_JavaUtilArrayList.add(GameBannerProcessor.class);
    jdField_c_of_type_JavaUtilArrayList.add(RunningBannerProcessor.class);
    jdField_c_of_type_JavaUtilArrayList.add(MsgProxyBannerProcessor.class);
    jdField_c_of_type_JavaUtilArrayList.add(GeneralBannerProcessor.class);
    jdField_d_of_type_JavaUtilArrayList = new ArrayList();
    jdField_d_of_type_JavaUtilArrayList.add(MusicPlayerBannerProcessor.class);
    jdField_e_of_type_JavaUtilArrayList = new ArrayList();
    jdField_e_of_type_JavaUtilArrayList.add(MultiVideoBannerProcessor.class);
    jdField_e_of_type_JavaUtilArrayList.add(QLinkTransingBannerProcessor.class);
    jdField_f_of_type_JavaUtilArrayList = new ArrayList();
    jdField_f_of_type_JavaUtilArrayList.add(MsgBackupBannerProcessor.class);
    jdField_g_of_type_JavaUtilArrayList = new ArrayList();
    jdField_g_of_type_JavaUtilArrayList.add(BeginnerGuideBannerProcessor.class);
  }
  
  private BannerManager()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static BannerManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqBannerBannerManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqBannerBannerManager == null) {
          jdField_a_of_type_ComTencentMobileqqBannerBannerManager = new BannerManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqBannerBannerManager;
  }
  
  private void a(Banner paramBanner)
  {
    if (paramBanner != null)
    {
      if (paramBanner.jdField_a_of_type_AndroidViewView != null) {
        return;
      }
      IBannerProcessor localIBannerProcessor = (IBannerProcessor)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramBanner.jdField_a_of_type_Int));
      if (localIBannerProcessor == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent.banner", 2, new Object[] { "initBannerView: key=", Integer.valueOf(paramBanner.jdField_a_of_type_Int), ", processor=null" });
        }
        return;
      }
      paramBanner.jdField_a_of_type_AndroidViewView = localIBannerProcessor.a(paramBanner);
      if ((paramBanner.jdField_a_of_type_AndroidViewView instanceof TipsBar)) {
        a((TipsBar)paramBanner.jdField_a_of_type_AndroidViewView, localIBannerProcessor.a());
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.recent.banner", 2, new Object[] { "initBannerView | banner = ", paramBanner });
      }
    }
  }
  
  private void a(Banner paramBanner, Message paramMessage)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.recent.banner", 2, new Object[] { "updateBanner| banner = ", paramBanner, ", msg = ", paramMessage });
    }
    if (paramBanner != null)
    {
      if (paramBanner.jdField_a_of_type_AndroidViewView == null) {
        return;
      }
      TextHook.updateFont(paramBanner.jdField_a_of_type_AndroidViewView);
      IBannerProcessor localIBannerProcessor = (IBannerProcessor)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramBanner.jdField_a_of_type_Int));
      if (localIBannerProcessor == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent.banner", 2, new Object[] { "updateBanner: key=", Integer.valueOf(paramBanner.jdField_a_of_type_Int), ", processor=null" });
        }
        return;
      }
      localIBannerProcessor.a(paramBanner, paramMessage);
      if ((paramBanner.jdField_a_of_type_AndroidViewView instanceof TipsBar)) {
        a((TipsBar)paramBanner.jdField_a_of_type_AndroidViewView);
      }
    }
  }
  
  private void a(TipsBar paramTipsBar)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      String str = QQTheme.a();
      if ((!QQTheme.e()) && (!QQTheme.d(str)))
      {
        if (paramTipsBar.a() == 6) {
          paramTipsBar.setBarType(2);
        } else if (!QQTheme.a()) {
          paramTipsBar.setBarType(2);
        }
      }
      else if (paramTipsBar.a() == 2) {
        paramTipsBar.setBarType(6);
      }
    }
    else if (paramTipsBar.a() == 6)
    {
      paramTipsBar.setBarType(2);
    }
    paramTipsBar.a();
  }
  
  private void a(TipsBar paramTipsBar, int paramInt)
  {
    String str = QQTheme.a();
    if ((paramInt == 2) && (this.jdField_a_of_type_Boolean) && ((QQTheme.e()) || (QQTheme.d(str))))
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
      if ((paramBanner.jdField_a_of_type_AndroidViewView != null) && (!paramBanner.jdField_a_of_type_Boolean) && (!paramBoolean))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent.banner", 2, "fight.addHeaderView_3.");
        }
        Object localObject = this.jdField_h_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((IBannerOnAddToView)((Iterator)localObject).next()).a(paramBanner);
        }
        this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(paramBanner.jdField_a_of_type_AndroidViewView, 1);
        localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (localObject != null) {
          a((AppRuntime)localObject, paramBanner.jdField_a_of_type_Int);
        }
        paramBanner.jdField_a_of_type_Boolean = true;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.recent.banner", 2, new Object[] { "initBanner|", localException.toString() });
      }
    }
    a(paramBanner, paramMessage);
    return true;
  }
  
  private boolean a(Class<? extends IBannerProcessor> paramClass)
  {
    if (paramClass == null)
    {
      QLog.d("Q.recent.banner", 1, "handleProcessorClz: processorClz == null");
      return false;
    }
    Class<? extends IBannerProcessor> localClass = null;
    try
    {
      paramClass = (IBannerProcessor)paramClass.getDeclaredConstructor(new Class[] { QBaseActivity.class }).newInstance(new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity });
      localClass = paramClass;
      paramClass = null;
    }
    catch (InvocationTargetException paramClass) {}catch (InstantiationException paramClass) {}catch (IllegalAccessException paramClass) {}catch (NoSuchMethodException paramClass) {}
    if (localClass == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "handleProcessorClzz: processor=null, exception:", paramClass);
      }
      return false;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(localClass.b()), localClass);
    if ((localClass instanceof IBannerViewScroll)) {
      this.jdField_k_of_type_JavaUtilArrayList.add((IBannerViewScroll)localClass);
    }
    if ((localClass instanceof IBannerLifecycle)) {
      this.jdField_j_of_type_JavaUtilArrayList.add((IBannerLifecycle)localClass);
    }
    if ((localClass instanceof IBannerOnAddToView)) {
      this.jdField_h_of_type_JavaUtilArrayList.add((IBannerOnAddToView)localClass);
    }
    if ((localClass instanceof IBannerOnUpdateBannerState)) {
      this.jdField_i_of_type_JavaUtilArrayList.add((IBannerOnUpdateBannerState)localClass);
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
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_k_of_type_JavaUtilArrayList.clear();
    this.jdField_j_of_type_JavaUtilArrayList.clear();
    this.jdField_h_of_type_JavaUtilArrayList.clear();
    this.jdField_i_of_type_JavaUtilArrayList.clear();
    jdField_c_of_type_Int = 1;
    jdField_d_of_type_Int = jdField_c_of_type_Int;
    Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      if (a((Class)localIterator.next())) {
        jdField_d_of_type_Int += 1;
      }
    }
    jdField_e_of_type_Int = jdField_d_of_type_Int;
    jdField_f_of_type_Int = jdField_e_of_type_Int;
    localIterator = jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      if (a((Class)localIterator.next())) {
        jdField_f_of_type_Int += 1;
      }
    }
    jdField_a_of_type_Int = jdField_f_of_type_Int;
    jdField_b_of_type_Int = jdField_a_of_type_Int;
    localIterator = jdField_c_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      if (a((Class)localIterator.next())) {
        jdField_b_of_type_Int += 1;
      }
    }
    jdField_g_of_type_Int = jdField_b_of_type_Int;
    jdField_h_of_type_Int = jdField_g_of_type_Int;
    localIterator = jdField_d_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      if (a((Class)localIterator.next())) {
        jdField_h_of_type_Int += 1;
      }
    }
    jdField_i_of_type_Int = jdField_h_of_type_Int;
    jdField_j_of_type_Int = jdField_i_of_type_Int;
    localIterator = jdField_e_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      if (a((Class)localIterator.next())) {
        jdField_j_of_type_Int += 1;
      }
    }
    jdField_k_of_type_Int = jdField_j_of_type_Int;
    l = jdField_k_of_type_Int;
    localIterator = jdField_f_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      if (a((Class)localIterator.next())) {
        l += 1;
      }
    }
    m = l;
    n = m;
    localIterator = jdField_g_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      if (a((Class)localIterator.next())) {
        n += 1;
      }
    }
    o = n;
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
    if (localObject != null) {
      localObject = ((QBaseActivity)localObject).getAppRuntime();
    } else {
      localObject = null;
    }
    if (paramInt2 == 2)
    {
      if (localObject != null) {
        a((AppRuntime)localObject, paramInt1);
      }
    }
    else if ((paramInt2 == 0) && (localObject != null)) {
      b((AppRuntime)localObject, paramInt1);
    }
  }
  
  private void c(int paramInt, Message paramMessage)
  {
    int i1 = 0;
    while (i1 < 7)
    {
      Object localObject1 = (ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(i1);
      if (localObject1 != null)
      {
        Iterator localIterator = ((ArrayList)localObject1).iterator();
        boolean bool = false;
        while (localIterator.hasNext())
        {
          int i2 = ((Integer)localIterator.next()).intValue();
          Banner localBanner = this.jdField_a_of_type_ArrayOfComTencentMobileqqBannerBanner[i2];
          Object localObject2 = null;
          if (paramMessage == null) {
            localObject1 = null;
          } else {
            localObject1 = Message.obtain(paramMessage);
          }
          if (paramInt != i2) {
            localObject1 = localObject2;
          }
          if (a(localBanner, bool, (Message)localObject1))
          {
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
      i1 += 1;
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
    Object localObject;
    while (i1 < 7)
    {
      localObject = (ArrayList)this.jdField_b_of_type_AndroidUtilSparseArray.get(i1);
      if (localObject == null)
      {
        localObject = new ArrayList(1);
        this.jdField_b_of_type_AndroidUtilSparseArray.put(i1, localObject);
      }
      else
      {
        ((ArrayList)localObject).clear();
      }
      i1 += 1;
    }
    i1 = jdField_c_of_type_Int;
    while (i1 < jdField_d_of_type_Int)
    {
      localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqBannerBanner;
      if ((localObject[i1] != null) && (localObject[i1].a())) {
        ((ArrayList)this.jdField_b_of_type_AndroidUtilSparseArray.get(0)).add(Integer.valueOf(i1));
      }
      i1 += 1;
    }
    i1 = jdField_e_of_type_Int;
    while (i1 < jdField_f_of_type_Int)
    {
      localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqBannerBanner;
      if ((localObject[i1] != null) && (localObject[i1].a())) {
        ((ArrayList)this.jdField_b_of_type_AndroidUtilSparseArray.get(1)).add(Integer.valueOf(i1));
      }
      i1 += 1;
    }
    i1 = jdField_a_of_type_Int;
    while (i1 < jdField_b_of_type_Int)
    {
      localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqBannerBanner;
      if ((localObject[i1] != null) && (localObject[i1].a())) {
        ((ArrayList)this.jdField_b_of_type_AndroidUtilSparseArray.get(2)).add(Integer.valueOf(i1));
      }
      i1 += 1;
    }
    i1 = jdField_g_of_type_Int;
    while (i1 < jdField_h_of_type_Int)
    {
      localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqBannerBanner;
      if ((localObject[i1] != null) && (localObject[i1].a())) {
        ((ArrayList)this.jdField_b_of_type_AndroidUtilSparseArray.get(3)).add(Integer.valueOf(i1));
      }
      i1 += 1;
    }
    i1 = jdField_i_of_type_Int;
    while (i1 < jdField_j_of_type_Int)
    {
      localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqBannerBanner;
      if ((localObject[i1] != null) && (localObject[i1].a())) {
        ((ArrayList)this.jdField_b_of_type_AndroidUtilSparseArray.get(4)).add(Integer.valueOf(i1));
      }
      i1 += 1;
    }
    i1 = jdField_k_of_type_Int;
    while (i1 < l)
    {
      localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqBannerBanner;
      if ((localObject[i1] != null) && (localObject[i1].a())) {
        ((ArrayList)this.jdField_b_of_type_AndroidUtilSparseArray.get(5)).add(Integer.valueOf(i1));
      }
      i1 += 1;
    }
    i1 = m;
    while (i1 < n)
    {
      localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqBannerBanner;
      if ((localObject[i1] != null) && (localObject[i1].a())) {
        ((ArrayList)this.jdField_b_of_type_AndroidUtilSparseArray.get(6)).add(Integer.valueOf(i1));
      }
      i1 += 1;
    }
  }
  
  private void f()
  {
    int i1 = 0;
    while (i1 < 7)
    {
      Object localObject = (ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(i1);
      if ((localObject != null) && (((ArrayList)localObject).size() != 0))
      {
        Iterator localIterator = ((ArrayList)localObject).iterator();
        while (localIterator.hasNext())
        {
          int i2 = ((Integer)localIterator.next()).intValue();
          Banner localBanner = this.jdField_a_of_type_ArrayOfComTencentMobileqqBannerBanner[i2];
          if ((localBanner != null) && (localBanner.jdField_a_of_type_AndroidViewView != null) && (localBanner.jdField_a_of_type_Boolean))
          {
            this.jdField_a_of_type_ComTencentWidgetXListView.removeHeaderView(localBanner.jdField_a_of_type_AndroidViewView);
            localObject = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
            if (localObject != null) {
              localObject = ((QBaseActivity)localObject).getAppRuntime();
            } else {
              localObject = null;
            }
            if (localObject != null) {
              b((AppRuntime)localObject, localBanner.jdField_a_of_type_Int);
            }
            localBanner.jdField_a_of_type_Boolean = false;
            if (!localBanner.a()) {
              localBanner.jdField_a_of_type_AndroidViewView = null;
            }
          }
        }
      }
      i1 += 1;
    }
  }
  
  public int a(int paramInt)
  {
    if (!jdField_b_of_type_Boolean) {
      return 0;
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      Banner[] arrayOfBanner = this.jdField_a_of_type_ArrayOfComTencentMobileqqBannerBanner;
      localObject1 = localObject2;
      if (paramInt < arrayOfBanner.length) {
        localObject1 = arrayOfBanner[paramInt];
      }
    }
    if (localObject1 == null) {
      return 0;
    }
    return localObject1.jdField_b_of_type_Int;
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
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      int i1 = ((Integer)localIterator.next()).intValue();
      IBannerProcessor localIBannerProcessor = (IBannerProcessor)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i1));
      if (localIBannerProcessor == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent.banner", 2, new Object[] { "onAccountChanged: key=", Integer.valueOf(i1), ", processor=null" });
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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = String.valueOf(paramInt1);
      IBannerProcessor localIBannerProcessor = (IBannerProcessor)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt1));
      if (localIBannerProcessor != null) {
        localObject = localIBannerProcessor.getClass().getSimpleName();
      }
      QLog.d("Q.recent.banner", 2, new Object[] { "updateBannerState|[", localObject, ",", Integer.valueOf(paramInt2), "]" });
    }
    if ((paramInt1 >= 1) && (paramInt1 < o))
    {
      localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqBannerBanner;
      if (localObject[paramInt1] != null) {
        localObject[paramInt1].jdField_b_of_type_Int = paramInt2;
      } else if ((localObject[paramInt1] == null) && (Banner.a(paramInt2))) {
        this.jdField_a_of_type_ArrayOfComTencentMobileqqBannerBanner[paramInt1] = new Banner(paramInt1, paramInt2);
      }
      localObject = this.jdField_i_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((IBannerOnUpdateBannerState)((Iterator)localObject).next()).a(paramInt1, paramInt2);
      }
    }
    c(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (!jdField_b_of_type_Boolean) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = paramInt3;
    a(paramInt1, paramInt2, localMessage);
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
      String str = String.valueOf(paramInt);
      Object localObject1 = (IBannerProcessor)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
      if (localObject1 != null) {
        str = localObject1.getClass().getSimpleName();
      }
      Object localObject2 = "null";
      if (paramMessage == null) {
        localObject1 = "null";
      } else {
        localObject1 = Integer.valueOf(paramMessage.what);
      }
      if (paramMessage != null) {
        localObject2 = paramMessage.obj;
      }
      QLog.d("Q.recent.banner", 2, new Object[] { "refreshBanner: [", str, ", ", localObject1, ", ", localObject2, "]" });
    }
    if (!jdField_b_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "refreshBanner !sInit");
      }
      return;
    }
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, new Object[] { "refreshBanner: Looper.myLooper() != Looper.getMainLooper()", Integer.valueOf(paramInt) });
      }
      ThreadManagerV2.getUIHandlerV2().post(new BannerManager.1(this, paramInt, paramMessage));
      return;
    }
    e();
    boolean bool1 = a();
    boolean bool2 = b();
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, new Object[] { "[refresh] refreshBanner: invoked. ", " isToShowBannersEmpty: ", Boolean.valueOf(bool2), " isBannersEqual: ", Boolean.valueOf(bool1) });
    }
    if ((bool1) && (bool2)) {
      return;
    }
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
    if (!jdField_b_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "transitMessage !sInit");
      }
      return;
    }
    IBannerProcessor localIBannerProcessor = (IBannerProcessor)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (localIBannerProcessor == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "transitMessage: processor=null");
      }
      return;
    }
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
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      int i1 = ((Integer)localIterator.next()).intValue();
      IBannerProcessor localIBannerProcessor = (IBannerProcessor)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i1));
      if (localIBannerProcessor == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent.banner", 2, new Object[] { "onBeforeAccountChanged: key=", Integer.valueOf(i1), ", processor=null" });
        }
        return;
      }
      localIBannerProcessor.b(paramAppRuntime);
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
    boolean bool1 = jdField_b_of_type_Boolean;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      Banner[] arrayOfBanner = this.jdField_a_of_type_ArrayOfComTencentMobileqqBannerBanner;
      localObject1 = localObject2;
      if (paramInt < arrayOfBanner.length) {
        localObject1 = arrayOfBanner[paramInt];
      }
    }
    bool1 = bool2;
    if (localObject1 != null)
    {
      bool1 = bool2;
      if (localObject1.a()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 1, "onResume");
    }
    Iterator localIterator = this.jdField_j_of_type_JavaUtilArrayList.iterator();
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
      Iterator localIterator = this.jdField_j_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((IBannerLifecycle)localIterator.next()).a(paramAppRuntime);
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
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      this.jdField_k_of_type_JavaUtilArrayList.clear();
      this.jdField_j_of_type_JavaUtilArrayList.clear();
      this.jdField_h_of_type_JavaUtilArrayList.clear();
      this.jdField_i_of_type_JavaUtilArrayList.clear();
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
    Iterator localIterator = this.jdField_k_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((IBannerViewScroll)localIterator.next()).a(paramBoolean);
    }
  }
  
  public boolean b(int paramInt)
  {
    boolean bool1 = jdField_b_of_type_Boolean;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      Banner[] arrayOfBanner = this.jdField_a_of_type_ArrayOfComTencentMobileqqBannerBanner;
      localObject1 = localObject2;
      if (paramInt < arrayOfBanner.length) {
        localObject1 = arrayOfBanner[paramInt];
      }
    }
    bool1 = bool2;
    if (localObject1 != null)
    {
      bool1 = bool2;
      if (localObject1.jdField_a_of_type_Boolean) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.banner.BannerManager
 * JD-Core Version:    0.7.0.1
 */