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
  private static ArrayList<Class<? extends IQQSettingMeProcessor>> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public final MutableLiveData<BusinessInfoCheckUpdate.AppInfo> a;
  private final CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new DrawerBizFacade.3(this);
  private final FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new DrawerBizFacade.5(this);
  private final VipInfoObserver jdField_a_of_type_ComTencentMobileqqAppVipInfoObserver = new DrawerBizFacade.1(this);
  private final GameCenterObserver jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver = new DrawerBizFacade.2(this);
  private final AnonymousObserver jdField_a_of_type_ComTencentMobileqqProfilecardBussinessAnonymousHandlerAnonymousObserver = new DrawerBizFacade.4(this);
  private final ProfileCardObserver jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver = new DrawerBizFacade.6(this);
  public MemoryClearManager.IClearMemoryListener a;
  private final HashMap<String, IQQSettingMeProcessor> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final ConcurrentHashMap<String, UpSideDownDrawable> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private WeakReference<FrameHelperActivity> jdField_a_of_type_MqqUtilWeakReference = new WeakReference(null);
  private boolean jdField_a_of_type_Boolean;
  private final ArrayList<String> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList.add(QQSettingMeDrawerProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(QQSettingMeDailyProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(QQSettingMeQRCodeProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(QQSettingMeApolloProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(QQSettingMeShoppingProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(QQSettingMeWalletProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(QQSettingMeMiniGameProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(QQSettingMeLoveZoneProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(QQSettingMeKingCardProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(QQSettingMeFileProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(QQSettingMeQFavProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(QQSettingMePhotoProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(QQSettingMeSettingProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(QQSettingMeWeatherProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(QQSettingMeNightModeProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(QQSettingMeDocumentProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(QQSettingMeDressUpProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(QQSettingMeSignatureProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(QQSettingMeProfileBubbleProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(QQSettingMeAvatarProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(QQSettingMeHeadVipProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(QQSettingMeNicknameProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(QQSettingMeSuperMemberProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(QQSettingMePrettyNumProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(QQSettingMeVideoProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(QQSettingMeQQCircleProcessor.class);
  }
  
  public DrawerBizFacade()
  {
    this.jdField_a_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
    this.jdField_a_of_type_ComTencentQqperfOptClearmemoryMemoryClearManager$IClearMemoryListener = new DrawerBizFacade.ClearDynamicDrawable(this);
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
  
  private void a(Class<? extends IQQSettingMeProcessor> paramClass)
  {
    paramClass = a(paramClass);
    if (paramClass == null) {
      return;
    }
    if ((!QQSettingMeConstant.a(paramClass.a())) || ((QQSettingMeConstant.a(paramClass.a())) && (this.jdField_b_of_type_JavaUtilArrayList.contains(paramClass.a())))) {
      this.jdField_a_of_type_JavaUtilHashMap.put(paramClass.a(), paramClass);
    }
  }
  
  private void k()
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
      this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(localObject);
    }
  }
  
  private void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "preloadSonicSession");
    }
    if (!((ISonicPreloaderService)QRoute.api(ISonicPreloaderService.class)).enablePreloadSonic()) {
      return;
    }
    long l = System.currentTimeMillis();
    Object localObject1 = this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.getValue();
    int i = 0;
    Object localObject4 = null;
    if ((localObject1 != null) && (((BusinessInfoCheckUpdate.AppInfo)this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.getValue()).iNewFlag.get() != 0)) {
      localObject3 = new SonicParserInfo(((BusinessInfoCheckUpdate.AppInfo)this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.getValue()).buffer.get(), 0L, 0);
    } else {
      localObject3 = null;
    }
    QQSettingMeSuperMemberProcessor localQQSettingMeSuperMemberProcessor = (QQSettingMeSuperMemberProcessor)a("d_vip_identity");
    BusinessInfoCheckUpdate.AppInfo localAppInfo;
    if (localQQSettingMeSuperMemberProcessor != null)
    {
      localAppInfo = localQQSettingMeSuperMemberProcessor.b().jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo;
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
    Object localObject2 = (QQSettingMeDressUpProcessor)a("d_decoration");
    if (localObject2 != null)
    {
      localObject2 = (BusinessInfoCheckUpdate.AppInfo)((QQSettingMeDressUpProcessor)localObject2).jdField_a_of_type_AndroidxLifecycleMutableLiveData.getValue();
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
      while (i < ((SparseArray)localObject1).size())
      {
        localObject3 = (SonicPreloadData)((SparseArray)localObject1).valueAt(i);
        if (1000 == ((SonicPreloadData)localObject3).jdField_a_of_type_Int)
        {
          if (localQQSettingMeSuperMemberProcessor != null)
          {
            ((SonicPreloadData)localObject3).jdField_a_of_type_JavaLangString = localQQSettingMeSuperMemberProcessor.b().jdField_a_of_type_JavaLangString;
            ((ArrayList)localObject4).add(localObject3);
          }
        }
        else if (1001 == ((SonicPreloadData)localObject3).jdField_a_of_type_Int)
        {
          ((SonicPreloadData)localObject3).jdField_a_of_type_JavaLangString = IndividuationUrlHelper.a("personalIndex");
          ((ArrayList)localObject4).add(localObject3);
        }
        i += 1;
      }
    }
    if ((localSparseArray1 != null) && (localSparseArray1.size() > 0))
    {
      localObject1 = (SonicPreloadData)localSparseArray1.valueAt(0);
      if (localQQSettingMeSuperMemberProcessor != null)
      {
        ((SonicPreloadData)localObject1).jdField_a_of_type_JavaLangString = localQQSettingMeSuperMemberProcessor.b().jdField_a_of_type_JavaLangString;
        localArrayList1.add(localObject1);
      }
    }
    if ((localSparseArray2 != null) && (localSparseArray2.size() > 0))
    {
      localObject1 = (SonicPreloadData)localSparseArray2.valueAt(0);
      ((SonicPreloadData)localObject1).jdField_a_of_type_JavaLangString = IndividuationUrlHelper.a("personalIndex");
      localArrayList2.add(localObject1);
    }
    localObject1 = (IWebProcessManagerService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IWebProcessManagerService.class, "");
    if (((IWebProcessManagerService)localObject1).preloadSonicSession((ArrayList)localObject4)) {
      ((IRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick("200010.200012");
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
      ((StringBuilder)localObject1).append(System.currentTimeMillis() - l);
      QLog.d("QQSettingRedesign", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public int a()
  {
    int k = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size();
    int i = 0;
    int j = 0;
    if (k > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
      i = j;
      while (localIterator.hasNext())
      {
        Bitmap localBitmap = ((UpSideDownDrawable)localIterator.next()).getBitmap();
        if (localBitmap != null) {
          i += Utils.a(localBitmap);
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
    return i;
  }
  
  public IQQSettingMeProcessor a(String paramString)
  {
    return (IQQSettingMeProcessor)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public UpSideDownDrawable a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return (UpSideDownDrawable)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext()) {
      ((IQQSettingMeProcessor)localIterator.next()).a();
    }
    ThreadManagerV2.executeOnSubThread(new DrawerBizFacade.7(this));
    ThreadManager.getUIHandler().postDelayed(new DrawerBizFacade.8(this), 5000L);
  }
  
  public void a(QQSettingMe paramQQSettingMe)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext()) {
      ((IQQSettingMeProcessor)localIterator.next()).a(paramQQSettingMe);
    }
  }
  
  public void a(String paramString)
  {
    if (QQSettingMeConstant.a(paramString))
    {
      this.jdField_b_of_type_JavaUtilArrayList.add(paramString);
      return;
    }
    IQQSettingMeProcessor localIQQSettingMeProcessor = a(QQSettingMeBaseMenuProcessor.class);
    if (localIQQSettingMeProcessor == null) {
      return;
    }
    localIQQSettingMeProcessor.a(paramString);
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localIQQSettingMeProcessor);
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
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramUpSideDownDrawable);
    }
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_MqqAppAppRuntime != null))
    {
      this.jdField_a_of_type_MqqAppAppRuntime.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
      ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).removeObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
      ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppVipInfoObserver);
      ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).removeObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessAnonymousHandlerAnonymousObserver);
      MemoryClearManager.a().b(this.jdField_a_of_type_ComTencentQqperfOptClearmemoryMemoryClearManager$IClearMemoryListener);
    }
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    if (this.jdField_a_of_type_MqqAppAppRuntime != null)
    {
      this.jdField_a_of_type_MqqAppAppRuntime.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
      ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).addObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessAnonymousHandlerAnonymousObserver);
      ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver, true);
      ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).addObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver, true);
      ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).addObserver(this.jdField_a_of_type_ComTencentMobileqqAppVipInfoObserver, true);
      MemoryClearManager.a().a(this.jdField_a_of_type_ComTencentQqperfOptClearmemoryMemoryClearManager$IClearMemoryListener);
    }
    if (this.jdField_a_of_type_MqqAppAppRuntime == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "fillData(), app == null");
      }
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext()) {
      ((IQQSettingMeProcessor)localIterator.next()).a(paramAppRuntime);
    }
  }
  
  public void a(AppRuntime paramAppRuntime, QBaseActivity paramQBaseActivity)
  {
    super.a(paramAppRuntime, paramQBaseActivity);
    Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      a((Class)localIterator.next());
    }
    localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext()) {
      ((IQQSettingMeProcessor)localIterator.next()).a(paramAppRuntime, paramQBaseActivity);
    }
    k();
  }
  
  public void a(boolean paramBoolean)
  {
    ThreadManager.excute(new DrawerBizFacade.9(this, paramBoolean), 16, null, false);
  }
  
  public void b()
  {
    super.b();
    SceneTracker.a().a("QQSettingMe");
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_MqqAppAppRuntime.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
      ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver, true);
      ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver, true);
      ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).addObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver, true);
      ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).addObserver(this.jdField_a_of_type_ComTencentMobileqqAppVipInfoObserver, true);
      ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).addObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessAnonymousHandlerAnonymousObserver, true);
      MemoryClearManager.a().a(this.jdField_a_of_type_ComTencentQqperfOptClearmemoryMemoryClearManager$IClearMemoryListener);
      this.jdField_a_of_type_Boolean = true;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext()) {
      ((IQQSettingMeProcessor)localIterator.next()).b();
    }
    a(true);
    if (this.jdField_a_of_type_MqqUtilWeakReference.get() == null) {
      k();
    }
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void c()
  {
    super.c();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext()) {
      ((IQQSettingMeProcessor)localIterator.next()).c();
    }
    SceneTracker.a().b("QQSettingMe");
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_MqqAppAppRuntime != null))
    {
      this.jdField_a_of_type_MqqAppAppRuntime.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
      ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
      ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).removeObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
      ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppVipInfoObserver);
      ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).removeObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardBussinessAnonymousHandlerAnonymousObserver);
    }
    if (this.jdField_a_of_type_Boolean) {
      MemoryClearManager.a().b(this.jdField_a_of_type_ComTencentQqperfOptClearmemoryMemoryClearManager$IClearMemoryListener);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext()) {
      ((IQQSettingMeProcessor)localIterator.next()).d();
    }
  }
  
  public void e()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext()) {
      ((IQQSettingMeProcessor)localIterator.next()).e();
    }
  }
  
  public void f()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext()) {
      ((IQQSettingMeProcessor)localIterator.next()).f();
    }
    ((IRedTouchServer)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchServer.class, "")).notifyUI(4, true, null);
  }
  
  public void g()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext()) {
      ((IQQSettingMeProcessor)localIterator.next()).h();
    }
  }
  
  public void h()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext()) {
      ((IQQSettingMeProcessor)localIterator.next()).i();
    }
  }
  
  public void i()
  {
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public void j()
  {
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((IRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath("200010.200012");
    QQSettingMeRedTouchUtil.a(localAppInfo);
    this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.postValue(localAppInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.DrawerBizFacade
 * JD-Core Version:    0.7.0.1
 */