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
import com.tencent.mobileqq.activity.recent.bannerprocessor.VerifyPhoneBannerProcessor;
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
  @ConfigInject(configPath="/Foundation/QQActivity/src/main/resources/Inject_banner_processor_map.yml", version=5)
  private static ArrayList<Class<? extends IBannerProcessor>> A;
  @ConfigInject(configPath="/Foundation/QQActivity/src/main/resources/Inject_banner_processor_map.yml", version=5)
  private static ArrayList<Class<? extends IBannerProcessor>> B;
  @ConfigInject(configPath="/Foundation/QQActivity/src/main/resources/Inject_banner_processor_map.yml", version=5)
  private static ArrayList<Class<? extends IBannerProcessor>> C;
  @ConfigInject(configPath="/Foundation/QQActivity/src/main/resources/Inject_banner_processor_map.yml", version=5)
  private static ArrayList<Class<? extends IBannerProcessor>> D;
  public static int a;
  public static int b;
  private static volatile BannerManager d;
  private static volatile boolean e;
  private static int f;
  private static int g;
  private static int h;
  private static int i;
  private static int j;
  private static int k;
  private static int l;
  private static int m;
  private static int n;
  private static int o;
  private static int p;
  private static int q;
  private static int r;
  @ConfigInject(configPath="/Foundation/QQActivity/src/main/resources/Inject_banner_processor_map.yml", version=5)
  private static ArrayList<Class<? extends IBannerProcessor>> x = new ArrayList();
  @ConfigInject(configPath="/Foundation/QQActivity/src/main/resources/Inject_banner_processor_map.yml", version=5)
  private static ArrayList<Class<? extends IBannerProcessor>> y;
  @ConfigInject(configPath="/Foundation/QQActivity/src/main/resources/Inject_banner_processor_map.yml", version=5)
  private static ArrayList<Class<? extends IBannerProcessor>> z;
  private final HashMap<Integer, IBannerProcessor> E = new HashMap();
  private final ArrayList<IBannerOnAddToView> F = new ArrayList();
  private final ArrayList<IBannerOnUpdateBannerState> G = new ArrayList();
  private final ArrayList<IBannerLifecycle> H = new ArrayList();
  private final ArrayList<IBannerViewScroll> I = new ArrayList();
  public boolean c = false;
  private QBaseActivity s;
  private XListView t;
  private Banner[] u;
  private final SparseArray<ArrayList<Integer>> v = new SparseArray(7);
  private SparseArray<ArrayList<Integer>> w;
  
  static
  {
    x.add(NetStateBannerProcessor.class);
    x.add(PhoneUnityBannerProcessor.class);
    x.add(SecureModifyPwdNotifyBannerProcessor.class);
    x.add(WifiSecurityCheckBannerProcessor.class);
    x.add(SecurePhoneChangeNotifyBannerProcessor.class);
    x.add(ArkInfoBannerProcessor.class);
    x.add(MissedCallBannerProcessor.class);
    x.add(HotSpotBannerProcessor.class);
    x.add(MobileUnityBannerProcessor.class);
    x.add(WifiPhotoBannerProcessor.class);
    x.add(NetNeedSignOnBannerProcessor.class);
    x.add(IllegalNetworkBannerProcessor.class);
    x.add(DonDisturbBannerProcessor.class);
    x.add(PCOnlineBannerProcessor.class);
    x.add(UpgradeBannerProcessor.class);
    x.add(UpdateBannerProcessor.class);
    x.add(InstallUpgradeBannerProcessor.class);
    x.add(ContactBannerProcessor.class);
    x.add(TroopAssistBannerProcessor.class);
    x.add(SetPwdBannerProcessor.class);
    x.add(NotificationGuideBannerProcessor.class);
    x.add(SecurityDetectBannerProcessor.class);
    x.add(VasADBannerProcessor.class);
    x.add(PushBannerProcessor.class);
    x.add(QQWifiBannerProcessor.class);
    x.add(RenewalsBannerProcessor.class);
    x.add(ThemeVersionUpdateBannerProcessor.class);
    x.add(ThemeOverdueBannerProcessor.class);
    x.add(TimUpgradeBannerProcessor.class);
    x.add(AutoStatusBannerProcessor.class);
    x.add(VerifyPhoneBannerProcessor.class);
    y = new ArrayList();
    y.add(LoginDevicesBannerProcessor.class);
    z = new ArrayList();
    z.add(ComicBannerProcessor.class);
    z.add(BrowserBannerProcessor.class);
    z.add(GameCenterBannerProcessor.class);
    z.add(GameBannerProcessor.class);
    z.add(RunningBannerProcessor.class);
    z.add(MsgProxyBannerProcessor.class);
    z.add(GeneralBannerProcessor.class);
    A = new ArrayList();
    A.add(MusicPlayerBannerProcessor.class);
    B = new ArrayList();
    B.add(MultiVideoBannerProcessor.class);
    B.add(QLinkTransingBannerProcessor.class);
    C = new ArrayList();
    C.add(MsgBackupBannerProcessor.class);
    D = new ArrayList();
    D.add(BeginnerGuideBannerProcessor.class);
  }
  
  public static BannerManager a()
  {
    if (d == null) {
      try
      {
        if (d == null) {
          d = new BannerManager();
        }
      }
      finally {}
    }
    return d;
  }
  
  private void a(Banner paramBanner)
  {
    if (paramBanner != null)
    {
      if (paramBanner.c != null) {
        return;
      }
      IBannerProcessor localIBannerProcessor = (IBannerProcessor)this.E.get(Integer.valueOf(paramBanner.a));
      if (localIBannerProcessor == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent.banner", 2, new Object[] { "initBannerView: key=", Integer.valueOf(paramBanner.a), ", processor=null" });
        }
        return;
      }
      paramBanner.c = localIBannerProcessor.a(paramBanner);
      if ((paramBanner.c instanceof TipsBar)) {
        a((TipsBar)paramBanner.c, localIBannerProcessor.a());
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
      if (paramBanner.c == null) {
        return;
      }
      TextHook.updateFont(paramBanner.c);
      IBannerProcessor localIBannerProcessor = (IBannerProcessor)this.E.get(Integer.valueOf(paramBanner.a));
      if (localIBannerProcessor == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent.banner", 2, new Object[] { "updateBanner: key=", Integer.valueOf(paramBanner.a), ", processor=null" });
        }
        return;
      }
      localIBannerProcessor.a(paramBanner, paramMessage);
      if ((paramBanner.c instanceof TipsBar)) {
        a((TipsBar)paramBanner.c);
      }
    }
  }
  
  private void a(TipsBar paramTipsBar)
  {
    if (this.c)
    {
      String str = QQTheme.getCurrentThemeId();
      if ((!QQTheme.isDefaultTheme()) && (!QQTheme.isThemeSimpleDayUI(str)))
      {
        if (paramTipsBar.getBarType() == 6) {
          paramTipsBar.setBarType(2);
        } else if (!QQTheme.isNowThemeIsNight()) {
          paramTipsBar.setBarType(2);
        }
      }
      else if (paramTipsBar.getBarType() == 2) {
        paramTipsBar.setBarType(6);
      }
    }
    else if (paramTipsBar.getBarType() == 6)
    {
      paramTipsBar.setBarType(2);
    }
    paramTipsBar.a();
  }
  
  private void a(TipsBar paramTipsBar, int paramInt)
  {
    String str = QQTheme.getCurrentThemeId();
    if ((paramInt == 2) && (this.c) && ((QQTheme.isDefaultTheme()) || (QQTheme.isThemeSimpleDayUI(str))))
    {
      paramTipsBar.setBarType(6);
      return;
    }
    paramTipsBar.setBarType(paramInt);
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
      if ((paramBanner.c != null) && (!paramBanner.d) && (!paramBoolean))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent.banner", 2, "fight.addHeaderView_3.");
        }
        Object localObject = this.F.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((IBannerOnAddToView)((Iterator)localObject).next()).b(paramBanner);
        }
        this.t.addHeaderView(paramBanner.c, 1);
        localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (localObject != null) {
          a((AppRuntime)localObject, paramBanner.a);
        }
        paramBanner.d = true;
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
      paramClass = (IBannerProcessor)paramClass.getDeclaredConstructor(new Class[] { QBaseActivity.class }).newInstance(new Object[] { this.s });
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
    this.E.put(Integer.valueOf(localClass.b()), localClass);
    if ((localClass instanceof IBannerViewScroll)) {
      this.I.add((IBannerViewScroll)localClass);
    }
    if ((localClass instanceof IBannerLifecycle)) {
      this.H.add((IBannerLifecycle)localClass);
    }
    if ((localClass instanceof IBannerOnAddToView)) {
      this.F.add((IBannerOnAddToView)localClass);
    }
    if ((localClass instanceof IBannerOnUpdateBannerState)) {
      this.G.add((IBannerOnUpdateBannerState)localClass);
    }
    return true;
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    Object localObject = this.s;
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
      Object localObject1 = (ArrayList)this.v.get(i1);
      if (localObject1 != null)
      {
        Iterator localIterator = ((ArrayList)localObject1).iterator();
        boolean bool = false;
        while (localIterator.hasNext())
        {
          int i2 = ((Integer)localIterator.next()).intValue();
          Banner localBanner = this.u[i2];
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
    this.E.clear();
    this.I.clear();
    this.H.clear();
    this.F.clear();
    this.G.clear();
    f = 1;
    g = f;
    Iterator localIterator = x.iterator();
    while (localIterator.hasNext()) {
      if (a((Class)localIterator.next())) {
        g += 1;
      }
    }
    h = g;
    i = h;
    localIterator = y.iterator();
    while (localIterator.hasNext()) {
      if (a((Class)localIterator.next())) {
        i += 1;
      }
    }
    a = i;
    b = a;
    localIterator = z.iterator();
    while (localIterator.hasNext()) {
      if (a((Class)localIterator.next())) {
        b += 1;
      }
    }
    j = b;
    k = j;
    localIterator = A.iterator();
    while (localIterator.hasNext()) {
      if (a((Class)localIterator.next())) {
        k += 1;
      }
    }
    l = k;
    m = l;
    localIterator = B.iterator();
    while (localIterator.hasNext()) {
      if (a((Class)localIterator.next())) {
        m += 1;
      }
    }
    n = m;
    o = n;
    localIterator = C.iterator();
    while (localIterator.hasNext()) {
      if (a((Class)localIterator.next())) {
        o += 1;
      }
    }
    p = o;
    q = p;
    localIterator = D.iterator();
    while (localIterator.hasNext()) {
      if (a((Class)localIterator.next())) {
        q += 1;
      }
    }
    r = q;
  }
  
  private boolean e()
  {
    int i1 = 0;
    while (i1 < 7)
    {
      List localList = (List)this.v.get(i1);
      if (!((List)this.w.get(i1)).equals(localList)) {
        return false;
      }
      i1 += 1;
    }
    return true;
  }
  
  private boolean f()
  {
    int i1 = 0;
    while (i1 < 7)
    {
      if (!((List)this.w.get(i1)).isEmpty()) {
        return false;
      }
      i1 += 1;
    }
    return true;
  }
  
  private void g()
  {
    int i1 = 0;
    while (i1 < 7)
    {
      ArrayList localArrayList = (ArrayList)this.w.get(i1);
      if (localArrayList != null) {
        this.v.put(i1, new ArrayList(localArrayList));
      }
      i1 += 1;
    }
  }
  
  private void h()
  {
    if (this.w == null) {
      this.w = new SparseArray(7);
    }
    int i1 = 0;
    Object localObject;
    while (i1 < 7)
    {
      localObject = (ArrayList)this.w.get(i1);
      if (localObject == null)
      {
        localObject = new ArrayList(1);
        this.w.put(i1, localObject);
      }
      else
      {
        ((ArrayList)localObject).clear();
      }
      i1 += 1;
    }
    i1 = f;
    while (i1 < g)
    {
      localObject = this.u;
      if ((localObject[i1] != null) && (localObject[i1].a())) {
        ((ArrayList)this.w.get(0)).add(Integer.valueOf(i1));
      }
      i1 += 1;
    }
    i1 = h;
    while (i1 < i)
    {
      localObject = this.u;
      if ((localObject[i1] != null) && (localObject[i1].a())) {
        ((ArrayList)this.w.get(1)).add(Integer.valueOf(i1));
      }
      i1 += 1;
    }
    i1 = a;
    while (i1 < b)
    {
      localObject = this.u;
      if ((localObject[i1] != null) && (localObject[i1].a())) {
        ((ArrayList)this.w.get(2)).add(Integer.valueOf(i1));
      }
      i1 += 1;
    }
    i1 = j;
    while (i1 < k)
    {
      localObject = this.u;
      if ((localObject[i1] != null) && (localObject[i1].a())) {
        ((ArrayList)this.w.get(3)).add(Integer.valueOf(i1));
      }
      i1 += 1;
    }
    i1 = l;
    while (i1 < m)
    {
      localObject = this.u;
      if ((localObject[i1] != null) && (localObject[i1].a())) {
        ((ArrayList)this.w.get(4)).add(Integer.valueOf(i1));
      }
      i1 += 1;
    }
    i1 = n;
    while (i1 < o)
    {
      localObject = this.u;
      if ((localObject[i1] != null) && (localObject[i1].a())) {
        ((ArrayList)this.w.get(5)).add(Integer.valueOf(i1));
      }
      i1 += 1;
    }
    i1 = p;
    while (i1 < q)
    {
      localObject = this.u;
      if ((localObject[i1] != null) && (localObject[i1].a())) {
        ((ArrayList)this.w.get(6)).add(Integer.valueOf(i1));
      }
      i1 += 1;
    }
  }
  
  private void i()
  {
    int i1 = 0;
    while (i1 < 7)
    {
      Object localObject = (ArrayList)this.v.get(i1);
      if ((localObject != null) && (((ArrayList)localObject).size() != 0))
      {
        Iterator localIterator = ((ArrayList)localObject).iterator();
        while (localIterator.hasNext())
        {
          int i2 = ((Integer)localIterator.next()).intValue();
          Banner localBanner = this.u[i2];
          if ((localBanner != null) && (localBanner.c != null) && (localBanner.d))
          {
            this.t.removeHeaderView(localBanner.c);
            localObject = this.s;
            if (localObject != null) {
              localObject = ((QBaseActivity)localObject).getAppRuntime();
            } else {
              localObject = null;
            }
            if (localObject != null) {
              b((AppRuntime)localObject, localBanner.a);
            }
            localBanner.d = false;
            if (!localBanner.a()) {
              localBanner.c = null;
            }
          }
        }
      }
      i1 += 1;
    }
  }
  
  @Nullable
  public Banner a(int paramInt)
  {
    if (!e) {
      return null;
    }
    return this.u[paramInt];
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (!e) {
      return;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = String.valueOf(paramInt1);
      IBannerProcessor localIBannerProcessor = (IBannerProcessor)this.E.get(Integer.valueOf(paramInt1));
      if (localIBannerProcessor != null) {
        localObject = localIBannerProcessor.getClass().getSimpleName();
      }
      QLog.d("Q.recent.banner", 2, new Object[] { "updateBannerState|[", localObject, ",", Integer.valueOf(paramInt2), "]" });
    }
    if ((paramInt1 >= 1) && (paramInt1 < r))
    {
      localObject = this.u;
      if (localObject[paramInt1] != null) {
        localObject[paramInt1].b = paramInt2;
      } else if ((localObject[paramInt1] == null) && (Banner.a(paramInt2))) {
        this.u[paramInt1] = new Banner(paramInt1, paramInt2);
      }
      localObject = this.G.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((IBannerOnUpdateBannerState)((Iterator)localObject).next()).a(paramInt1, paramInt2);
      }
    }
    c(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (!e) {
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
    if (!e)
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
      Object localObject1 = (IBannerProcessor)this.E.get(Integer.valueOf(paramInt));
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
    if (!e)
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
    h();
    boolean bool1 = e();
    boolean bool2 = f();
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, new Object[] { "[refresh] refreshBanner: invoked. ", " isToShowBannersEmpty: ", Boolean.valueOf(bool2), " isBannersEqual: ", Boolean.valueOf(bool1) });
    }
    if ((bool1) && (bool2)) {
      return;
    }
    if (bool2)
    {
      i();
      return;
    }
    if (!bool1)
    {
      i();
      g();
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
    if (!e)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "transitMessage !sInit");
      }
      return;
    }
    IBannerProcessor localIBannerProcessor = (IBannerProcessor)this.E.get(Integer.valueOf(paramInt));
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
      this.s = paramQBaseActivity;
      this.t = paramXListView;
      d();
      this.u = new Banner[r];
      e = true;
      return;
    }
    finally {}
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    Iterator localIterator = this.E.keySet().iterator();
    while (localIterator.hasNext())
    {
      int i1 = ((Integer)localIterator.next()).intValue();
      IBannerProcessor localIBannerProcessor = (IBannerProcessor)this.E.get(Integer.valueOf(i1));
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
    this.c = paramBoolean;
  }
  
  public int b(int paramInt)
  {
    if (!e) {
      return 0;
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      Banner[] arrayOfBanner = this.u;
      localObject1 = localObject2;
      if (paramInt < arrayOfBanner.length) {
        localObject1 = arrayOfBanner[paramInt];
      }
    }
    if (localObject1 == null) {
      return 0;
    }
    return localObject1.b;
  }
  
  public void b()
  {
    Iterator localIterator = this.E.keySet().iterator();
    while (localIterator.hasNext())
    {
      int i1 = ((Integer)localIterator.next()).intValue();
      IBannerProcessor localIBannerProcessor = (IBannerProcessor)this.E.get(Integer.valueOf(i1));
      if (localIBannerProcessor == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent.banner", 2, new Object[] { "onAccountChanged: key=", Integer.valueOf(i1), ", processor=null" });
        }
        return;
      }
      localIBannerProcessor.c();
    }
    a(-1, null);
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
      Iterator localIterator = this.H.iterator();
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
      this.s = null;
      this.t = null;
      this.E.clear();
      this.I.clear();
      this.H.clear();
      this.F.clear();
      this.G.clear();
      this.u = null;
      e = false;
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
    Iterator localIterator = this.I.iterator();
    while (localIterator.hasNext()) {
      ((IBannerViewScroll)localIterator.next()).a(paramBoolean);
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 1, "onResume");
    }
    Iterator localIterator = this.H.iterator();
    while (localIterator.hasNext()) {
      ((IBannerLifecycle)localIterator.next()).d();
    }
  }
  
  public boolean c(int paramInt)
  {
    boolean bool1 = e;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      Banner[] arrayOfBanner = this.u;
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
  
  public boolean d(int paramInt)
  {
    boolean bool1 = e;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      Banner[] arrayOfBanner = this.u;
      localObject1 = localObject2;
      if (paramInt < arrayOfBanner.length) {
        localObject1 = arrayOfBanner[paramInt];
      }
    }
    bool1 = bool2;
    if (localObject1 != null)
    {
      bool1 = bool2;
      if (localObject1.d) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.banner.BannerManager
 * JD-Core Version:    0.7.0.1
 */