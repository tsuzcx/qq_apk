package com.tencent.mobileqq.activity.framebusiness;

import android.content.res.Resources;
import android.util.SparseArray;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TabWidget;
import android.widget.TextView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.activity.home.ITabFrameController;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.home.impl.FrameInfoBean;
import com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl;
import com.tencent.mobileqq.activity.qcircle.QCircleFrame;
import com.tencent.mobileqq.activity.qcircle.QCircleThirdTabConfig.INotifyTabRefresh;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.FrameFragment.DragViewTouchListener;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.IQCircleConfigApi;
import com.tencent.mobileqq.qcircle.api.event.QCircleFrameEvent;
import com.tencent.mobileqq.qcircle.api.event.QCircleTabConfigChangeEvent;
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
import mqq.os.MqqHandler;

public class QCircleInjectImpl
  extends BaseFrameBusiness
  implements SimpleEventReceiver
{
  private static final int jdField_a_of_type_Int = ScreenUtil.dip2px(170.0F);
  private static Runnable jdField_a_of_type_JavaLangRunnable;
  private static WeakReference<FrameFragment> jdField_a_of_type_JavaLangRefWeakReference;
  private static final int jdField_b_of_type_Int = ScreenUtil.dip2px(42.0F);
  private static WeakReference<FrameFragment> jdField_b_of_type_JavaLangRefWeakReference;
  private PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  private boolean jdField_a_of_type_Boolean;
  private final String[] jdField_a_of_type_ArrayOfJavaLangString = { "1000", "1103", "2971", "2921", "3064", "3063", "3066", "3065", "3067", "3491", "2920" };
  private Runnable jdField_b_of_type_JavaLangRunnable;
  private boolean jdField_b_of_type_Boolean;
  private Runnable c;
  
  public static QCircleThirdTabConfig.INotifyTabRefresh a(MainFragment paramMainFragment)
  {
    if (paramMainFragment.jdField_a_of_type_ComTencentMobileqqActivityQcircleQCircleThirdTabConfig$INotifyTabRefresh == null)
    {
      QLog.d("QCircleThirdTabConfig", 1, "inject listener");
      jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramMainFragment);
      paramMainFragment.jdField_a_of_type_ComTencentMobileqqActivityQcircleQCircleThirdTabConfig$INotifyTabRefresh = new QCircleInjectImpl.7();
    }
    return paramMainFragment.jdField_a_of_type_ComTencentMobileqqActivityQcircleQCircleThirdTabConfig$INotifyTabRefresh;
  }
  
  public static QzoneConfig.QzoneConfigChangeListener a(FrameFragment paramFrameFragment)
  {
    MainFragment localMainFragment = (MainFragment)paramFrameFragment;
    if (localMainFragment.jdField_a_of_type_CommonConfigServiceQzoneConfig$QzoneConfigChangeListener == null) {
      localMainFragment.jdField_a_of_type_CommonConfigServiceQzoneConfig$QzoneConfigChangeListener = new QCircleInjectImpl.6(paramFrameFragment);
    }
    return localMainFragment.jdField_a_of_type_CommonConfigServiceQzoneConfig$QzoneConfigChangeListener;
  }
  
  public static void a(TabFrameControllerImpl paramTabFrameControllerImpl, FrameFragment paramFrameFragment)
  {
    QLog.i("TabFrameControllerImpl", 1, "initQCircleTab enter");
    if (((MainFragment)paramFrameFragment).jdField_a_of_type_CommonConfigServiceQzoneConfig$QzoneConfigChangeListener == null) {
      QzoneConfig.getInstance().addListener(a(paramFrameFragment));
    }
    if (QzoneConfig.isShowQQCircleMainTabEntrance(StudyModeManager.a()))
    {
      if (paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[8] == null)
      {
        localObject1 = paramTabFrameControllerImpl.generateTabItem(-1, 2130850758, -1, 2130850759, 2131697851, 17, 0);
        if (localObject1 == null)
        {
          QLog.e("TabFrameControllerImpl", 1, "initQCircleTab qcircleTab is generate null");
          return;
        }
        ((View)localObject1).setId(23);
        ((View)localObject1).setOnClickListener(new QCircleInjectImpl.4(paramFrameFragment));
        paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[8] = new RedTouchTab(paramFrameFragment.a(), (View)localObject1).b(49).e(3).a(true).c(5).a();
        ((View)localObject1).setContentDescription(paramFrameFragment.getResources().getString(2131697851));
      }
      QLog.i("TabFrameControllerImpl", 1, "initQCircleTab mTabs[8] is not null");
      paramFrameFragment.jdField_a_of_type_JavaUtilHashMap.put(FrameControllerUtil.g, paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[8]);
      Object localObject1 = paramFrameFragment.jdField_a_of_type_JavaUtilHashMap;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(FrameControllerUtil.g);
      ((StringBuilder)localObject2).append("_num");
      ((HashMap)localObject1).put(((StringBuilder)localObject2).toString(), paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[8].findViewById(2131380161));
      localObject1 = (TabDragAnimationView)paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[8].findViewById(2131378232);
      localObject2 = (TextView)paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[8].findViewById(2131379917);
      if ((localObject1 != null) && (localObject2 != null))
      {
        paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray.put(FrameControllerUtil.j, localObject1);
        paramFrameFragment.b.put(FrameControllerUtil.j, localObject2);
        paramTabFrameControllerImpl.addFrame(paramFrameFragment, paramFrameFragment.jdField_a_of_type_AndroidViewView, QCircleFrame.class, paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[8]);
        QCircleFrame.jdField_a_of_type_Boolean = true;
        QLog.i("TabFrameControllerImpl", 1, "initQCircleTab addFrame success");
        c(paramFrameFragment, "initQCircleTab");
      }
      d();
      return;
    }
    paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray.remove(FrameControllerUtil.j);
    paramFrameFragment.b.remove(FrameControllerUtil.j);
    paramFrameFragment.a(QCircleFrame.class);
    QCircleFrame.jdField_a_of_type_Boolean = false;
    QLog.i("TabFrameControllerImpl", 1, "initQCircleTab remove qcircleTab");
  }
  
  public static void a(FrameFragment paramFrameFragment, String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("update at ");
    localStringBuilder.append(paramString);
    QLog.i("updateQCircleRedDot", 1, localStringBuilder.toString());
    if (!QCircleFrame.jdField_a_of_type_Boolean)
    {
      paramFrameFragment = new StringBuilder();
      paramFrameFragment.append("will not update QCircleRedDot because not show at");
      paramFrameFragment.append(paramString);
      QLog.i("updateQCircleRedDot", 1, paramFrameFragment.toString());
      return;
    }
    ThreadManagerV2.executeOnSubThread(new QCircleInjectImpl.3(paramFrameFragment));
  }
  
  public static void c()
  {
    Object localObject = jdField_b_of_type_JavaLangRefWeakReference;
    if ((localObject != null) && ((((WeakReference)localObject).get() instanceof MainFragment)))
    {
      localObject = (MainFragment)jdField_b_of_type_JavaLangRefWeakReference.get();
      if (((MainFragment)localObject).jdField_a_of_type_ComTencentMobileqqActivityQcircleQCircleThirdTabConfig$INotifyTabRefresh != null) {
        ((MainFragment)localObject).jdField_a_of_type_ComTencentMobileqqActivityQcircleQCircleThirdTabConfig$INotifyTabRefresh.a((MainFragment)localObject);
      }
    }
  }
  
  public static void c(FrameFragment paramFrameFragment, String paramString)
  {
    a(paramFrameFragment, paramString, false);
  }
  
  private static void d()
  {
    if (jdField_a_of_type_JavaLangRunnable != null) {
      return;
    }
    jdField_a_of_type_JavaLangRunnable = new QCircleInjectImpl.5();
    ThreadManager.getSubThreadHandler().post(jdField_a_of_type_JavaLangRunnable);
  }
  
  private void i(FrameFragment paramFrameFragment)
  {
    if (this.jdField_b_of_type_JavaLangRunnable == null) {
      this.jdField_b_of_type_JavaLangRunnable = new QCircleInjectImpl.1(this, paramFrameFragment);
    }
    if (this.c == null) {
      this.c = new QCircleInjectImpl.2(this, paramFrameFragment);
    }
    ThreadManager.getUIHandler().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 500L);
  }
  
  public void a()
  {
    TabFrameControllerImpl.registerFrameInfo(new FrameInfoBean(QCircleFrame.class, FrameControllerUtil.j, FrameControllerUtil.g, 2130850758, 2130850759, 2131697851, 17, 0));
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public void a(FrameFragment paramFrameFragment)
  {
    paramFrameFragment = (QCircleFrame)paramFrameFragment.a(QCircleFrame.class);
    if (paramFrameFragment != null) {
      paramFrameFragment.i();
    }
  }
  
  public void a(FrameFragment paramFrameFragment, int paramInt1, int paramInt2)
  {
    if ((paramFrameFragment != null) && (paramInt1 == 0) && (this.jdField_b_of_type_Boolean) && (((IQCircleConfigApi)QRoute.api(IQCircleConfigApi.class)).isShowQQCircleMainTabEntrance(StudyModeManager.a())))
    {
      i(paramFrameFragment);
      this.jdField_b_of_type_Boolean = false;
    }
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
    this.jdField_a_of_type_Boolean = bool;
    if (this.jdField_a_of_type_Boolean)
    {
      if ((paramFrameFragment.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost != null) && (paramFrameFragment.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.getTabWidget() != null) && (paramFrameFragment.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.getTabWidget().getHeight() > 0) && (localQCircleFrame != null)) {
        localQCircleFrame.b(paramFrameFragment.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.getTabWidget().getHeight());
      }
      if (localQCircleFrame != null) {
        localQCircleFrame.a(paramFrame);
      }
      ThreadManager.getUIHandler().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      return;
    }
    if ((paramFrame instanceof QCircleFrame)) {
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
  
  public boolean a()
  {
    String str = ThemeUtil.getCurrentThemeId();
    if (str != null)
    {
      String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (str.equals(arrayOfString[i])) {
          return false;
        }
        i += 1;
      }
    }
    return true;
  }
  
  public boolean a(FrameFragment paramFrameFragment)
  {
    return false;
  }
  
  public boolean a(AppRuntime paramAppRuntime)
  {
    return false;
  }
  
  public void b()
  {
    FrameInfoBean localFrameInfoBean = ((ITabFrameController)QRoute.api(ITabFrameController.class)).getFrameInfoByClazz(QCircleFrame.class);
    localFrameInfoBean.a(FrameControllerUtil.j);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doOnUpdateFrameInfo className: ");
    localStringBuilder.append(localFrameInfoBean.a().getName());
    localStringBuilder.append(" tabIndex: ");
    localStringBuilder.append(localFrameInfoBean.a());
    QLog.d("TabFrameControllerImplBusiness", 1, localStringBuilder.toString());
  }
  
  public void b(FrameFragment paramFrameFragment)
  {
    if (a()) {
      h(paramFrameFragment);
    }
  }
  
  public void b(FrameFragment paramFrameFragment, String paramString) {}
  
  public void c(FrameFragment paramFrameFragment) {}
  
  public void d(FrameFragment paramFrameFragment)
  {
    paramFrameFragment = paramFrameFragment.a(QCircleFrame.class);
    if (paramFrameFragment != null) {
      ((QCircleFrame)paramFrameFragment).k();
    }
    if (this.jdField_a_of_type_Boolean) {
      FrameHelperActivity.b(false);
    }
  }
  
  public void e(FrameFragment paramFrameFragment) {}
  
  public void f(FrameFragment paramFrameFragment) {}
  
  public void g(FrameFragment paramFrameFragment) {}
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFrameEvent.class);
    localArrayList.add(QCircleTabConfigChangeEvent.class);
    return localArrayList;
  }
  
  public void h(FrameFragment paramFrameFragment) {}
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleFrameEvent))
    {
      if (((QCircleFrameEvent)paramSimpleBaseEvent).mTriggerSelectedQCircleTab)
      {
        paramSimpleBaseEvent = jdField_a_of_type_JavaLangRefWeakReference;
        if ((paramSimpleBaseEvent != null) && (paramSimpleBaseEvent.get() != null)) {
          ((FrameFragment)jdField_a_of_type_JavaLangRefWeakReference.get()).a(2);
        }
      }
    }
    else if (((paramSimpleBaseEvent instanceof QCircleTabConfigChangeEvent)) && (((QCircleTabConfigChangeEvent)paramSimpleBaseEvent).isShowBottom())) {
      this.jdField_b_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.QCircleInjectImpl
 * JD-Core Version:    0.7.0.1
 */