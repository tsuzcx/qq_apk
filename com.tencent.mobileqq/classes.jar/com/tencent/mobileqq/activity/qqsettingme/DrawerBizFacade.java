package com.tencent.mobileqq.activity.qqsettingme;

import android.graphics.Bitmap;
import android.util.SparseArray;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeSuperMemberPayButtonBean;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.VipInfoObserver;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.handler.AnonymousObserver;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchServer;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.webview.api.ISonicPreloaderService;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.webview.data.SonicParserInfo;
import com.tencent.mobileqq.webview.data.SonicPreloadData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.opt.clearmemory.MemoryClearManager;
import com.tencent.qqperf.opt.clearmemory.MemoryClearManager.IClearMemoryListener;
import com.tencent.qqperf.tools.SceneTracker;
import com.tencent.widget.UpSideDownDrawable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class DrawerBizFacade
  extends BaseDrawerBizFacade
  implements IProcessorDispatcher
{
  @ConfigInject(configPath="/Foundation/QQActivity/src/main/resources/Inject_QQSettingMe_processor.yml", version=2)
  private static ArrayList<Class<? extends IQQSettingMeProcessor>> f = new ArrayList();
  public final MutableLiveData<BusinessInfoCheckUpdate.AppInfo> d = new MutableLiveData();
  public MemoryClearManager.IClearMemoryListener e = new DrawerBizFacade.ClearDynamicDrawable(this);
  private final HashMap<String, IQQSettingMeProcessor> g = new HashMap();
  private final ArrayList<String> h = new ArrayList();
  private final ConcurrentHashMap<String, UpSideDownDrawable> i = new ConcurrentHashMap();
  private boolean j;
  private boolean k;
  private WeakReference<FrameHelperActivity> l = new WeakReference(null);
  private final VipInfoObserver m = new DrawerBizFacade.1(this);
  private final GameCenterObserver n = new DrawerBizFacade.2(this);
  private final CardObserver o = new DrawerBizFacade.3(this);
  private final AnonymousObserver p = new DrawerBizFacade.4(this);
  private final FriendListObserver q = new DrawerBizFacade.5(this);
  private final ProfileCardObserver r = new DrawerBizFacade.6(this);
  
  static
  {
    f.add(QQSettingMeDrawerProcessor.class);
    f.add(QQSettingMeDailyProcessor.class);
    f.add(QQSettingMeQRCodeProcessor.class);
    f.add(QQSettingMeApolloProcessor.class);
    f.add(QQSettingMeShoppingProcessor.class);
    f.add(QQSettingMeWalletProcessor.class);
    f.add(QQSettingMeMiniGameProcessor.class);
    f.add(QQSettingMeLoveZoneProcessor.class);
    f.add(QQSettingMeKingCardProcessor.class);
    f.add(QQSettingMeFileProcessor.class);
    f.add(QQSettingMeQFavProcessor.class);
    f.add(QQSettingMePhotoProcessor.class);
    f.add(QQSettingMeSettingProcessor.class);
    f.add(QQSettingMeWeatherProcessor.class);
    f.add(QQSettingMeNightModeProcessor.class);
    f.add(QQSettingMeDocumentProcessor.class);
    f.add(QQSettingMeDressUpProcessor.class);
    f.add(QQSettingMeSignatureProcessor.class);
    f.add(QQSettingMeProfileBubbleProcessor.class);
    f.add(QQSettingMeAvatarProcessor.class);
    f.add(QQSettingMeHeadVipProcessor.class);
    f.add(QQSettingMeNicknameProcessor.class);
    f.add(QQSettingMeSuperMemberProcessor.class);
    f.add(QQSettingMePrettyNumProcessor.class);
    f.add(QQSettingMeVideoProcessor.class);
    f.add(QQSettingMeQQCircleProcessor.class);
  }
  
  private IQQSettingMeProcessor a(Class<? extends IQQSettingMeProcessor> paramClass)
  {
    if (paramClass == null)
    {
      QLog.d("QQSettingRedesign", 1, "handleProcessorClz: processorClz == null");
      return null;
    }
    try
    {
      localIQQSettingMeProcessor = (IQQSettingMeProcessor)paramClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      paramClass = null;
    }
    catch (InvocationTargetException paramClass) {}catch (InstantiationException paramClass) {}catch (IllegalAccessException paramClass) {}catch (NoSuchMethodException paramClass) {}
    IQQSettingMeProcessor localIQQSettingMeProcessor = null;
    if (localIQQSettingMeProcessor == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "handleProcessorClzz: processor=null, exception:", paramClass);
      }
      return null;
    }
    return localIQQSettingMeProcessor;
  }
  
  private void b(Class<? extends IQQSettingMeProcessor> paramClass)
  {
    paramClass = a(paramClass);
    if (paramClass == null) {
      return;
    }
    if ((!QQSettingMeConstant.a(paramClass.b())) || ((QQSettingMeConstant.a(paramClass.b())) && (this.h.contains(paramClass.b())))) {
      this.g.put(paramClass.b(), paramClass);
    }
  }
  
  private void l()
  {
    Object localObject;
    try
    {
      FrameHelperActivity localFrameHelperActivity = FrameHelperActivity.a((BaseActivity)QBaseActivity.sTopActivity);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localObject = null;
    }
    if (localObject != null) {
      this.l = new WeakReference(localObject);
    }
  }
  
  private void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "preloadSonicSession");
    }
    if (!((ISonicPreloaderService)QRoute.api(ISonicPreloaderService.class)).enablePreloadSonic()) {
      return;
    }
    long l1 = System.currentTimeMillis();
    Object localObject1 = this.d.getValue();
    int i1 = 0;
    Object localObject4 = null;
    if ((localObject1 != null) && (((BusinessInfoCheckUpdate.AppInfo)this.d.getValue()).iNewFlag.get() != 0)) {
      localObject3 = new SonicParserInfo(((BusinessInfoCheckUpdate.AppInfo)this.d.getValue()).buffer.get(), 0L, 0);
    } else {
      localObject3 = null;
    }
    QQSettingMeSuperMemberProcessor localQQSettingMeSuperMemberProcessor = (QQSettingMeSuperMemberProcessor)b("d_vip_identity");
    BusinessInfoCheckUpdate.AppInfo localAppInfo;
    if (localQQSettingMeSuperMemberProcessor != null)
    {
      localAppInfo = localQQSettingMeSuperMemberProcessor.l().a;
      if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0)) {
        localObject1 = new SonicParserInfo(localAppInfo.buffer.get(), localAppInfo.preload_ts.get(), 1000);
      } else {
        localObject1 = null;
      }
    }
    else
    {
      localAppInfo = null;
      localObject1 = localAppInfo;
    }
    Object localObject2 = (QQSettingMeDressUpProcessor)b("d_decoration");
    if (localObject2 != null)
    {
      localObject2 = (BusinessInfoCheckUpdate.AppInfo)((QQSettingMeDressUpProcessor)localObject2).a.getValue();
      if ((localObject2 != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get() != 0)) {
        localObject4 = new SonicParserInfo(((BusinessInfoCheckUpdate.AppInfo)localObject2).buffer.get(), ((BusinessInfoCheckUpdate.AppInfo)localObject2).preload_ts.get(), 1001);
      }
    }
    else
    {
      localObject2 = null;
    }
    Object localObject3 = ((ISonicPreloaderService)QRoute.api(ISonicPreloaderService.class)).getSonicPreloadDataList((SonicParserInfo)localObject3);
    SparseArray localSparseArray1 = ((ISonicPreloaderService)QRoute.api(ISonicPreloaderService.class)).getSonicPreloadDataList((SonicParserInfo)localObject1);
    SparseArray localSparseArray2 = ((ISonicPreloaderService)QRoute.api(ISonicPreloaderService.class)).getSonicPreloadDataList((SonicParserInfo)localObject4);
    localObject4 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if ((localObject3 != null) && (((SparseArray)localObject3).size() > 0))
    {
      localObject1 = localObject3;
      while (i1 < ((SparseArray)localObject1).size())
      {
        localObject3 = (SonicPreloadData)((SparseArray)localObject1).valueAt(i1);
        if (1000 == ((SonicPreloadData)localObject3).a)
        {
          if (localQQSettingMeSuperMemberProcessor != null)
          {
            ((SonicPreloadData)localObject3).b = localQQSettingMeSuperMemberProcessor.l().b;
            ((ArrayList)localObject4).add(localObject3);
          }
        }
        else if (1001 == ((SonicPreloadData)localObject3).a)
        {
          ((SonicPreloadData)localObject3).b = IndividuationUrlHelper.a("personalIndex");
          ((ArrayList)localObject4).add(localObject3);
        }
        i1 += 1;
      }
    }
    if ((localSparseArray1 != null) && (localSparseArray1.size() > 0))
    {
      localObject1 = (SonicPreloadData)localSparseArray1.valueAt(0);
      if (localQQSettingMeSuperMemberProcessor != null)
      {
        ((SonicPreloadData)localObject1).b = localQQSettingMeSuperMemberProcessor.l().b;
        localArrayList1.add(localObject1);
      }
    }
    if ((localSparseArray2 != null) && (localSparseArray2.size() > 0))
    {
      localObject1 = (SonicPreloadData)localSparseArray2.valueAt(0);
      ((SonicPreloadData)localObject1).b = IndividuationUrlHelper.a("personalIndex");
      localArrayList2.add(localObject1);
    }
    localObject1 = (IWebProcessManagerService)this.a.getRuntimeService(IWebProcessManagerService.class, "");
    if (((IWebProcessManagerService)localObject1).preloadSonicSession((ArrayList)localObject4)) {
      ((IRedTouchManager)this.a.getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick("200010.200012");
    }
    if ((((IWebProcessManagerService)localObject1).preloadSonicSession(localArrayList1)) && (localAppInfo != null)) {
      localAppInfo.preload_ts.set(System.currentTimeMillis());
    }
    if ((((IWebProcessManagerService)localObject1).preloadSonicSession(localArrayList2)) && (localObject2 != null)) {
      ((BusinessInfoCheckUpdate.AppInfo)localObject2).preload_ts.set(System.currentTimeMillis());
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("preloadSonicSession parse cost: ");
      ((StringBuilder)localObject1).append(System.currentTimeMillis() - l1);
      QLog.d("QQSettingRedesign", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void a()
  {
    Iterator localIterator = this.g.values().iterator();
    while (localIterator.hasNext()) {
      ((IQQSettingMeProcessor)localIterator.next()).c();
    }
    ThreadManagerV2.executeOnSubThread(new DrawerBizFacade.7(this));
    ThreadManager.getUIHandler().postDelayed(new DrawerBizFacade.8(this), 5000L);
  }
  
  public void a(QQSettingMe paramQQSettingMe)
  {
    Iterator localIterator = this.g.values().iterator();
    while (localIterator.hasNext()) {
      ((IQQSettingMeProcessor)localIterator.next()).a(paramQQSettingMe);
    }
  }
  
  public void a(String paramString)
  {
    if (QQSettingMeConstant.a(paramString))
    {
      this.h.add(paramString);
      return;
    }
    IQQSettingMeProcessor localIQQSettingMeProcessor = a(QQSettingMeBaseMenuProcessor.class);
    if (localIQQSettingMeProcessor == null) {
      return;
    }
    localIQQSettingMeProcessor.a(paramString);
    this.g.put(paramString, localIQQSettingMeProcessor);
  }
  
  public void a(String paramString, UpSideDownDrawable paramUpSideDownDrawable)
  {
    if (paramUpSideDownDrawable == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "[storeDynamicDrawable] drawable to be stored is null");
      }
    }
    else {
      this.i.put(paramString, paramUpSideDownDrawable);
    }
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    if ((this.j) && (this.a != null))
    {
      this.a.unRegistObserver(this.n);
      ((QQAppInterface)this.a).removeObserver(this.o);
      ((QQAppInterface)this.a).removeObserver(this.q);
      ((QQAppInterface)this.a).removeObserver(this.r);
      ((QQAppInterface)this.a).removeObserver(this.m);
      ((QQAppInterface)this.a).removeObserver(this.p);
      MemoryClearManager.b().b(this.e);
    }
    this.a = paramAppRuntime;
    if (this.a != null)
    {
      this.a.registObserver(this.n);
      ((QQAppInterface)this.a).addObserver(this.o);
      ((QQAppInterface)this.a).addObserver(this.p);
      ((QQAppInterface)this.a).addObserver(this.q, true);
      ((QQAppInterface)this.a).addObserver(this.r, true);
      ((QQAppInterface)this.a).addObserver(this.m, true);
      MemoryClearManager.b().a(this.e);
    }
    if (this.a == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "fillData(), app == null");
      }
      return;
    }
    Iterator localIterator = this.g.values().iterator();
    while (localIterator.hasNext()) {
      ((IQQSettingMeProcessor)localIterator.next()).a(paramAppRuntime);
    }
  }
  
  public void a(AppRuntime paramAppRuntime, QBaseActivity paramQBaseActivity)
  {
    super.a(paramAppRuntime, paramQBaseActivity);
    Iterator localIterator = f.iterator();
    while (localIterator.hasNext()) {
      b((Class)localIterator.next());
    }
    localIterator = this.g.values().iterator();
    while (localIterator.hasNext()) {
      ((IQQSettingMeProcessor)localIterator.next()).a(paramAppRuntime, paramQBaseActivity);
    }
    l();
  }
  
  public void a(boolean paramBoolean)
  {
    ThreadManager.excute(new DrawerBizFacade.9(this, paramBoolean), 16, null, false);
  }
  
  public IQQSettingMeProcessor b(String paramString)
  {
    return (IQQSettingMeProcessor)this.g.get(paramString);
  }
  
  public void b()
  {
    super.b();
    SceneTracker.a().a("QQSettingMe");
    if (!this.j)
    {
      this.a.registObserver(this.n);
      ((QQAppInterface)this.a).addObserver(this.o, true);
      ((QQAppInterface)this.a).addObserver(this.q, true);
      ((QQAppInterface)this.a).addObserver(this.r, true);
      ((QQAppInterface)this.a).addObserver(this.m, true);
      ((QQAppInterface)this.a).addObserver(this.p, true);
      MemoryClearManager.b().a(this.e);
      this.j = true;
    }
    Iterator localIterator = this.g.values().iterator();
    while (localIterator.hasNext()) {
      ((IQQSettingMeProcessor)localIterator.next()).d();
    }
    a(true);
    if (this.l.get() == null) {
      l();
    }
    this.k = true;
  }
  
  public UpSideDownDrawable c(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return (UpSideDownDrawable)this.i.get(paramString);
  }
  
  public void c()
  {
    super.c();
    Iterator localIterator = this.g.values().iterator();
    while (localIterator.hasNext()) {
      ((IQQSettingMeProcessor)localIterator.next()).e();
    }
    SceneTracker.a().b("QQSettingMe");
    this.k = false;
  }
  
  public void d()
  {
    if ((this.j) && (this.a != null))
    {
      this.a.unRegistObserver(this.n);
      ((QQAppInterface)this.a).removeObserver(this.o);
      ((QQAppInterface)this.a).removeObserver(this.q);
      ((QQAppInterface)this.a).removeObserver(this.r);
      ((QQAppInterface)this.a).removeObserver(this.m);
      ((QQAppInterface)this.a).removeObserver(this.p);
    }
    if (this.j) {
      MemoryClearManager.b().b(this.e);
    }
    Iterator localIterator = this.g.values().iterator();
    while (localIterator.hasNext()) {
      ((IQQSettingMeProcessor)localIterator.next()).f();
    }
  }
  
  public void e()
  {
    Iterator localIterator = this.g.values().iterator();
    while (localIterator.hasNext()) {
      ((IQQSettingMeProcessor)localIterator.next()).g();
    }
  }
  
  public void f()
  {
    Iterator localIterator = this.g.values().iterator();
    while (localIterator.hasNext()) {
      ((IQQSettingMeProcessor)localIterator.next()).h();
    }
    ((IRedTouchServer)this.a.getRuntimeService(IRedTouchServer.class, "")).notifyUI(4, true, null);
  }
  
  public void g()
  {
    Iterator localIterator = this.g.values().iterator();
    while (localIterator.hasNext()) {
      ((IQQSettingMeProcessor)localIterator.next()).j();
    }
  }
  
  public void h()
  {
    Iterator localIterator = this.g.values().iterator();
    while (localIterator.hasNext()) {
      ((IQQSettingMeProcessor)localIterator.next()).k();
    }
  }
  
  public void i()
  {
    this.h.clear();
    this.g.clear();
  }
  
  public void j()
  {
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((IRedTouchManager)this.a.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath("200010.200012");
    QQSettingMeRedTouchUtil.a(localAppInfo);
    this.d.postValue(localAppInfo);
  }
  
  public int k()
  {
    int i3 = this.i.size();
    int i1 = 0;
    int i2 = 0;
    if (i3 > 0)
    {
      Iterator localIterator = this.i.values().iterator();
      i1 = i2;
      while (localIterator.hasNext())
      {
        Bitmap localBitmap = ((UpSideDownDrawable)localIterator.next()).getBitmap();
        if (localBitmap != null) {
          i1 += Utils.a(localBitmap);
        }
      }
      this.i.clear();
    }
    return i1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.DrawerBizFacade
 * JD-Core Version:    0.7.0.1
 */