package com.tencent.mobileqq.activity.framebusiness;

import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.util.SparseArray;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TabWidget;
import android.widget.TextView;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.activity.home.ITabFrameController;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.home.impl.FrameInfoBean;
import com.tencent.mobileqq.activity.home.impl.FrameInitBean;
import com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl;
import com.tencent.mobileqq.activity.qcircle.QCircleFrame;
import com.tencent.mobileqq.activity.qcircle.QCircleThirdTabConfig.INotifyTabRefresh;
import com.tencent.mobileqq.activity.qcircle.QCircleThirdTabConfig.QCircleTabBucketRequest;
import com.tencent.mobileqq.activity.qcircle.utils.QCircleThemeUtils;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.FrameFragment.DragViewTouchListener;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.auto.engine.lib.ASInject;
import com.tencent.mobileqq.qcircle.api.IQCircleConfigApi;
import com.tencent.mobileqq.qcircle.api.event.QCircleFrameEvent;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchTab;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQTabHost;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import common.config.service.QzoneConfig.QzoneConfigChangeListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class QCircleInjectImpl
  extends BaseFrameBusiness
  implements SimpleEventReceiver
{
  private static final int a = ScreenUtil.dip2px(42.0F);
  private static WeakReference<FrameFragment> b;
  private static WeakReference<FrameFragment> c;
  private static QCircleThemeUtils d = new QCircleThemeUtils();
  private static Runnable e;
  private static PopupWindow h;
  private static Runnable i;
  private static Runnable j;
  private static int k = 0;
  private static FrameInitBean l;
  private boolean f;
  private final String[] g = { "1000", "1103", "2971", "2921", "3064", "3063", "3066", "3065", "3067", "3491", "2920" };
  
  public static QCircleThirdTabConfig.INotifyTabRefresh a(MainFragment paramMainFragment)
  {
    if (paramMainFragment.d == null)
    {
      QLog.d("QCircleThirdTabConfig", 1, "inject listener");
      c = new WeakReference(paramMainFragment);
      paramMainFragment.d = new QCircleInjectImpl.10();
    }
    return paramMainFragment.d;
  }
  
  public static void a(TabFrameControllerImpl paramTabFrameControllerImpl, FrameFragment paramFrameFragment, FrameInitBean paramFrameInitBean)
  {
    l = paramFrameInitBean;
    QCircleThemeUtils.a(paramFrameInitBean);
    n(paramFrameFragment);
    k();
    j();
    QLog.i("TabFrameControllerImpl", 1, "initQCircleTab enter");
    if (((MainFragment)paramFrameFragment).i == null) {
      QzoneConfig.getInstance().addListener(i(paramFrameFragment));
    }
    if (paramFrameInitBean.b())
    {
      if (paramFrameFragment.z[8] == null)
      {
        paramFrameInitBean = paramTabFrameControllerImpl.generateTabItem(-1, 2130852578, -1, 2130852580, 2131895628, 17, 8);
        if (paramFrameInitBean == null)
        {
          QLog.e("TabFrameControllerImpl", 1, "initQCircleTab qcircleTab is generate null");
          return;
        }
        paramFrameInitBean.setId(23);
        paramFrameInitBean.setOnClickListener(new QCircleInjectImpl.4(paramFrameFragment));
        paramFrameFragment.z[8] = new RedTouchTab(paramFrameFragment.C(), paramFrameInitBean).c(49).c(3.0F).a(true).d(5).a();
        paramFrameInitBean.setContentDescription(paramFrameFragment.getResources().getString(2131895628));
      }
      QLog.i("TabFrameControllerImpl", 1, "initQCircleTab mTabs[8] is not null");
      paramFrameFragment.G.put(FrameControllerUtil.r, paramFrameFragment.z[8]);
      paramFrameInitBean = paramFrameFragment.G;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(FrameControllerUtil.r);
      ((StringBuilder)localObject).append("_num");
      paramFrameInitBean.put(((StringBuilder)localObject).toString(), paramFrameFragment.z[8].findViewById(2131449076));
      paramFrameInitBean = (TabDragAnimationView)paramFrameFragment.z[8].findViewById(2131446751);
      localObject = (TextView)paramFrameFragment.z[8].findViewById(2131448791);
      if ((paramFrameInitBean != null) && (localObject != null))
      {
        paramFrameFragment.B.put(FrameControllerUtil.j, paramFrameInitBean);
        paramFrameFragment.C.put(FrameControllerUtil.j, localObject);
        paramTabFrameControllerImpl.addFrame(paramFrameFragment, paramFrameFragment.W, QCircleFrame.class, paramFrameFragment.z[8]);
        QCircleFrame.a = true;
        QLog.i("TabFrameControllerImpl", 1, "initQCircleTab addFrame success");
        c(paramFrameFragment, "initQCircleTab");
      }
      l();
      return;
    }
    paramFrameFragment.B.remove(FrameControllerUtil.j);
    paramFrameFragment.C.remove(FrameControllerUtil.j);
    paramFrameFragment.b(QCircleFrame.class);
    QCircleFrame.a = false;
    QLog.i("TabFrameControllerImpl", 1, "initQCircleTab remove qcircleTab");
  }
  
  public static void a(FrameFragment paramFrameFragment, String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("update at ");
    localStringBuilder.append(paramString);
    QLog.i("updateQCircleRedDot", 1, localStringBuilder.toString());
    if (!QCircleFrame.a)
    {
      paramFrameFragment = new StringBuilder();
      paramFrameFragment.append("will not update QCircleRedDot because not show at");
      paramFrameFragment.append(paramString);
      QLog.i("updateQCircleRedDot", 1, paramFrameFragment.toString());
      return;
    }
    ThreadManagerV2.executeOnSubThread(new QCircleInjectImpl.3(paramFrameFragment));
  }
  
  private static void b(FrameFragment paramFrameFragment, boolean paramBoolean)
  {
    if (paramFrameFragment != null)
    {
      if (paramFrameFragment.C() == null) {
        return;
      }
      if (paramBoolean) {
        return;
      }
      paramFrameFragment.C().moveTaskToBack(true);
      paramFrameFragment = new StringBuilder();
      paramFrameFragment.append("onFlashShowBackEventCall flashShowFrame:");
      paramFrameFragment.append(paramBoolean);
      QLog.d("ASDynamicEngine_back", 1, paramFrameFragment.toString());
    }
  }
  
  public static void c(FrameFragment paramFrameFragment, String paramString)
  {
    a(paramFrameFragment, paramString, false);
  }
  
  public static void d() {}
  
  public static QzoneConfig.QzoneConfigChangeListener i(FrameFragment paramFrameFragment)
  {
    MainFragment localMainFragment = (MainFragment)paramFrameFragment;
    if (localMainFragment.i == null) {
      localMainFragment.i = new QCircleInjectImpl.9(paramFrameFragment);
    }
    return localMainFragment.i;
  }
  
  public static int j(FrameFragment paramFrameFragment)
  {
    paramFrameFragment = paramFrameFragment.u;
    if (paramFrameFragment.size() >= 4)
    {
      FrameInitBean localFrameInitBean = l;
      if (localFrameInitBean != null)
      {
        if ((localFrameInitBean.c()) && (paramFrameFragment.size() == 5)) {
          return 2;
        }
        return 1;
      }
    }
    return 0;
  }
  
  private static void j()
  {
    if (RFApplication.getApplication() == null) {
      return;
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_KICKED");
    localIntentFilter.addAction("mqq.intent.action.FORCE_LOGOUT");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_CHANGED");
    localIntentFilter.addAction("mqq.intent.action.LOGOUT");
    localIntentFilter.addAction("mqq.intent.action.LOGIN");
    MobileQQ.sMobileQQ.registerReceiver(new QCircleInjectImpl.6(), localIntentFilter);
  }
  
  private static void k()
  {
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null).getCurrentAccountUin();
    SharedPreferences localSharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences("QCBT-QCircleInjectImpl", 0);
    long l1 = Long.parseLong(localSharedPreferences.getString((String)localObject, "0"));
    long l2 = System.currentTimeMillis();
    if (l2 - l1 < 86400000L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("don't need to send request lasRequest:");
      ((StringBuilder)localObject).append(l1);
      QLog.i("QCBT-QCircleInjectImpl", 1, ((StringBuilder)localObject).toString());
      return;
    }
    VSNetworkHelper.getInstance().sendRequest(new QCircleThirdTabConfig.QCircleTabBucketRequest(), new QCircleInjectImpl.7(localSharedPreferences, (String)localObject, l2));
  }
  
  private static void l()
  {
    if (e != null) {
      return;
    }
    e = new QCircleInjectImpl.8();
    ThreadManager.getSubThreadHandler().post(e);
  }
  
  private static void m(FrameFragment paramFrameFragment)
  {
    if (i == null) {
      i = new QCircleInjectImpl.1(paramFrameFragment);
    }
    if (j == null) {
      j = new QCircleInjectImpl.2(paramFrameFragment);
    }
    ThreadManager.getUIHandler().postDelayed(i, 4500L);
  }
  
  private static void n(FrameFragment paramFrameFragment)
  {
    ASInject.g().setBackEventListener(new QCircleInjectImpl.5(paramFrameFragment));
  }
  
  private static void o(FrameFragment paramFrameFragment)
  {
    if (p(paramFrameFragment))
    {
      m(paramFrameFragment);
      QCircleHostGlobalInfo.setHasShowEntranceGuideTips(true);
    }
  }
  
  private static boolean p(FrameFragment paramFrameFragment)
  {
    if (paramFrameFragment != null)
    {
      paramFrameFragment = l;
      if ((paramFrameFragment != null) && (paramFrameFragment.b()) && (((IQCircleConfigApi)QRoute.api(IQCircleConfigApi.class)).isShowQQCircleMainTabEntrance(StudyModeManager.h())) && (QCircleHostGlobalInfo.needShowEntranceGuideTips())) {
        return true;
      }
    }
    return false;
  }
  
  public void a()
  {
    TabFrameControllerImpl.registerFrameInfo(new FrameInfoBean(QCircleFrame.class, FrameControllerUtil.j, FrameControllerUtil.r, 2130852578, 2130852580, 2131895628, 17, 8));
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public void a(FrameFragment paramFrameFragment)
  {
    QCircleFrame localQCircleFrame = (QCircleFrame)paramFrameFragment.a(QCircleFrame.class);
    if (localQCircleFrame != null) {
      localQCircleFrame.l();
    }
    d.a(paramFrameFragment);
  }
  
  public void a(FrameFragment paramFrameFragment, int paramInt1, Frame paramFrame, int paramInt2)
  {
    QCircleFrame localQCircleFrame = (QCircleFrame)paramFrameFragment.a(QCircleFrame.class);
    if (localQCircleFrame != null) {
      localQCircleFrame.a((MainFragment)paramFrameFragment);
    }
    boolean bool;
    if (paramInt2 == FrameControllerUtil.j) {
      bool = true;
    } else {
      bool = false;
    }
    this.f = bool;
    if (this.f)
    {
      if ((paramFrameFragment.s != null) && (paramFrameFragment.s.getTabWidget() != null) && (paramFrameFragment.s.getTabWidget().getHeight() > 0) && (localQCircleFrame != null)) {
        localQCircleFrame.b(paramFrameFragment.s.getTabWidget().getHeight());
      }
      if (localQCircleFrame != null) {
        localQCircleFrame.a(paramFrame);
      }
      if (i != null) {
        ThreadManager.getUIHandler().removeCallbacks(i);
      }
    }
    else if ((paramFrame instanceof QCircleFrame))
    {
      ((QCircleFrame)paramFrame).a(paramInt2);
    }
  }
  
  public void a(FrameFragment paramFrameFragment, FrameFragment.DragViewTouchListener paramDragViewTouchListener) {}
  
  public void a(FrameFragment paramFrameFragment, String paramString) {}
  
  public void a(RedTouch paramRedTouch, FrameFragment paramFrameFragment, int paramInt, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, IRedTouchManager paramIRedTouchManager)
  {
    if (paramInt == 40) {
      c(paramFrameFragment, "updateTabRedTouch");
    }
  }
  
  public void a(HashMap<String, View> paramHashMap, boolean paramBoolean) {}
  
  public void a(AppRuntime paramAppRuntime, SparseArray<TabDragAnimationView> paramSparseArray, int paramInt) {}
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (paramBoolean) {
      FrameHelperActivity.b(this.f ^ true);
    }
  }
  
  public boolean a(AppRuntime paramAppRuntime)
  {
    return false;
  }
  
  public void b()
  {
    Object localObject = ((ITabFrameController)QRoute.api(ITabFrameController.class)).getFrameInfoByClazz(QCircleFrame.class);
    ((FrameInfoBean)localObject).a(FrameControllerUtil.j);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doOnUpdateFrameInfo className: ");
    localStringBuilder.append(((FrameInfoBean)localObject).a().getName());
    localStringBuilder.append(" tabIndex: ");
    localStringBuilder.append(((FrameInfoBean)localObject).c());
    QLog.d("QCBT-QCircleInjectImpl", 1, localStringBuilder.toString());
    localObject = b;
    if (localObject != null) {
      d.a((FrameFragment)((WeakReference)localObject).get());
    }
  }
  
  public void b(FrameFragment paramFrameFragment)
  {
    if (c()) {
      k(paramFrameFragment);
    }
    d.a(paramFrameFragment);
  }
  
  public void b(FrameFragment paramFrameFragment, String paramString) {}
  
  public void c(FrameFragment paramFrameFragment) {}
  
  public boolean c()
  {
    String str = ThemeUtil.getCurrentThemeId();
    if (str != null)
    {
      String[] arrayOfString = this.g;
      int n = arrayOfString.length;
      int m = 0;
      while (m < n)
      {
        if (str.equals(arrayOfString[m])) {
          return false;
        }
        m += 1;
      }
    }
    return true;
  }
  
  public void d(FrameFragment paramFrameFragment)
  {
    Frame localFrame = paramFrameFragment.a(QCircleFrame.class);
    if (localFrame != null) {
      ((QCircleFrame)localFrame).o();
    }
    if (this.f) {
      FrameHelperActivity.c(false);
    }
    o(paramFrameFragment);
  }
  
  public boolean e(FrameFragment paramFrameFragment)
  {
    d.a(paramFrameFragment);
    return false;
  }
  
  public void f(FrameFragment paramFrameFragment) {}
  
  public void g(FrameFragment paramFrameFragment) {}
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFrameEvent.class);
    return localArrayList;
  }
  
  public void h(FrameFragment paramFrameFragment) {}
  
  public void k(FrameFragment paramFrameFragment) {}
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleFrameEvent))
    {
      WeakReference localWeakReference = b;
      if (localWeakReference != null)
      {
        if (localWeakReference.get() == null) {
          return;
        }
        paramSimpleBaseEvent = (QCircleFrameEvent)paramSimpleBaseEvent;
        if (paramSimpleBaseEvent.mTriggerSelectedQCircleTab)
        {
          int m = j((FrameFragment)b.get());
          ((FrameFragment)b.get()).a(m);
          return;
        }
        if (paramSimpleBaseEvent.mAddTab) {
          ((ITabFrameController)QRoute.api(ITabFrameController.class)).setFrames((FrameFragment)b.get(), false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.QCircleInjectImpl
 * JD-Core Version:    0.7.0.1
 */