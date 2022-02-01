package com.tencent.mobileqq.activity.framebusiness;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TabWidget;
import android.widget.TextView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.activity.home.IFrameBusinessInterface;
import com.tencent.mobileqq.activity.home.ITabFrameController;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.home.impl.FrameInfoBean;
import com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl;
import com.tencent.mobileqq.activity.qcircle.QCircleFrame;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.FrameFragment.DragViewTouchListener;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.event.QCircleFrameEvent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.redtouch.RedTouchTab;
import com.tencent.mobileqq.studymode.StudyModeManager;
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

public class QCircleInjectImpl
  implements SimpleEventReceiver, IFrameBusinessInterface
{
  private static WeakReference<FrameFragment> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private final String[] jdField_a_of_type_ArrayOfJavaLangString = { "1000", "1103", "2971", "2921", "3064", "3063", "3066", "3065", "3067", "3491", "2920" };
  
  private TextView a(FrameFragment paramFrameFragment)
  {
    if ((paramFrameFragment != null) && (paramFrameFragment.b != null)) {
      return (TextView)paramFrameFragment.b.get(FrameControllerUtil.j);
    }
    return null;
  }
  
  private TabDragAnimationView a(FrameFragment paramFrameFragment)
  {
    if ((paramFrameFragment != null) && (paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray != null)) {
      return (TabDragAnimationView)paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray.get(FrameControllerUtil.j);
    }
    return null;
  }
  
  public static QzoneConfig.QzoneConfigChangeListener a(FrameFragment paramFrameFragment)
  {
    if (((MainFragment)paramFrameFragment).a == null) {
      ((MainFragment)paramFrameFragment).a = new QCircleInjectImpl.3(paramFrameFragment);
    }
    return ((MainFragment)paramFrameFragment).a;
  }
  
  public static void a(TabFrameControllerImpl paramTabFrameControllerImpl, FrameFragment paramFrameFragment)
  {
    QLog.i("TabFrameControllerImpl", 1, "initQCircleTab enter");
    if (((MainFragment)paramFrameFragment).a == null) {
      QzoneConfig.getInstance().addListener(a(paramFrameFragment));
    }
    if (QzoneConfig.isShowQQCircleMainTabEntrance(StudyModeManager.a()))
    {
      Object localObject;
      if (paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[8] == null)
      {
        localObject = paramTabFrameControllerImpl.generateTabItem(-1, 2130850822, -1, 2130850823, 2131697845, 17, 0);
        if (localObject == null) {
          QLog.e("TabFrameControllerImpl", 1, "initQCircleTab qcircleTab is generate null");
        }
      }
      TextView localTextView;
      do
      {
        return;
        ((View)localObject).setId(23);
        ((View)localObject).setOnClickListener(new QCircleInjectImpl.2(paramFrameFragment));
        paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[8] = new RedTouchTab(paramFrameFragment.getActivity(), (View)localObject).b(49).e(3).a(true).c(5).a();
        ((View)localObject).setContentDescription(paramFrameFragment.getResources().getString(2131697845));
        QLog.i("TabFrameControllerImpl", 1, "initQCircleTab mTabs[8] is not null");
        paramFrameFragment.jdField_a_of_type_JavaUtilHashMap.put(FrameControllerUtil.g, paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[8]);
        paramFrameFragment.jdField_a_of_type_JavaUtilHashMap.put(FrameControllerUtil.g + "_num", paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[8].findViewById(2131380896));
        localObject = (TabDragAnimationView)paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[8].findViewById(2131378843);
        localTextView = (TextView)paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[8].findViewById(2131380635);
      } while ((localObject == null) || (localTextView == null));
      paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray.put(FrameControllerUtil.j, localObject);
      paramFrameFragment.b.put(FrameControllerUtil.j, localTextView);
      paramTabFrameControllerImpl.addFrame(paramFrameFragment, paramFrameFragment.jdField_a_of_type_AndroidViewView, QCircleFrame.class, paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[8]);
      QCircleFrame.jdField_a_of_type_Boolean = true;
      QLog.i("TabFrameControllerImpl", 1, "initQCircleTab addFrame success");
      c(paramFrameFragment, "initQCircleTab");
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
    QLog.i("updateQCircleRedDot", 1, "update at " + paramString);
    if (!QCircleFrame.jdField_a_of_type_Boolean)
    {
      QLog.i("updateQCircleRedDot", 1, "will not update QCircleRedDot because not show at" + paramString);
      return;
    }
    ThreadManagerV2.executeOnSubThread(new QCircleInjectImpl.1(paramFrameFragment));
  }
  
  private void a(boolean paramBoolean1, FrameFragment paramFrameFragment, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (a(paramFrameFragment) != null))
    {
      if (paramBoolean2) {
        a(paramFrameFragment).setTextColor(MobileQQ.sMobileQQ.getResources().getColorStateList(2131167030));
      }
    }
    else {
      return;
    }
    a(paramFrameFragment).setTextColor(MobileQQ.sMobileQQ.getResources().getColor(2131167130));
  }
  
  public static void c(FrameFragment paramFrameFragment, String paramString)
  {
    a(paramFrameFragment, paramString, false);
  }
  
  public void a()
  {
    TabFrameControllerImpl.registerFrameInfo(new FrameInfoBean(QCircleFrame.class, FrameControllerUtil.j, FrameControllerUtil.g, 2130850822, 2130850823, 2131697845, 17, 0));
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public void a(FrameFragment paramFrameFragment) {}
  
  public void a(FrameFragment paramFrameFragment, int paramInt1, Frame paramFrame, int paramInt2)
  {
    QCircleFrame localQCircleFrame = (QCircleFrame)paramFrameFragment.a(QCircleFrame.class);
    if (localQCircleFrame != null) {
      localQCircleFrame.a((MainFragment)paramFrameFragment);
    }
    boolean bool;
    if (paramInt2 == FrameControllerUtil.j)
    {
      bool = true;
      this.jdField_a_of_type_Boolean = bool;
      if (!this.jdField_a_of_type_Boolean) {
        break label117;
      }
      if ((paramFrameFragment.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost != null) && (paramFrameFragment.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.getTabWidget() != null) && (paramFrameFragment.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.getTabWidget().getHeight() > 0) && (localQCircleFrame != null)) {
        localQCircleFrame.b(paramFrameFragment.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.getTabWidget().getHeight());
      }
      if (localQCircleFrame != null) {
        localQCircleFrame.a(paramFrame);
      }
    }
    label117:
    while (!(paramFrame instanceof QCircleFrame))
    {
      return;
      bool = false;
      break;
    }
    ((QCircleFrame)paramFrame).a(paramInt2);
  }
  
  public void a(FrameFragment paramFrameFragment, FrameFragment.DragViewTouchListener paramDragViewTouchListener) {}
  
  public void a(FrameFragment paramFrameFragment, String paramString) {}
  
  public void a(RedTouch paramRedTouch, FrameFragment paramFrameFragment, int paramInt, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, RedTouchManager paramRedTouchManager)
  {
    if (paramInt == 40) {
      c(paramFrameFragment, "updateTabRedTouch");
    }
  }
  
  public void a(HashMap<String, View> paramHashMap, boolean paramBoolean) {}
  
  public void a(AppRuntime paramAppRuntime, SparseArray<TabDragAnimationView> paramSparseArray, int paramInt) {}
  
  public boolean a()
  {
    String str = ThemeUtil.a();
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
    a(a(), paramFrameFragment, this.jdField_a_of_type_Boolean);
    return false;
  }
  
  public void b()
  {
    FrameInfoBean localFrameInfoBean = ((ITabFrameController)QRoute.api(ITabFrameController.class)).getFrameInfoByClazz(QCircleFrame.class);
    localFrameInfoBean.a(FrameControllerUtil.j);
    QLog.d("TabFrameControllerImplBusiness", 1, "doOnUpdateFrameInfo className: " + localFrameInfoBean.a().getName() + " tabIndex: " + localFrameInfoBean.a());
  }
  
  public void b(FrameFragment paramFrameFragment)
  {
    if (a()) {
      g(paramFrameFragment);
    }
  }
  
  public void b(FrameFragment paramFrameFragment, String paramString) {}
  
  public void c(FrameFragment paramFrameFragment) {}
  
  public void d(FrameFragment paramFrameFragment)
  {
    paramFrameFragment = paramFrameFragment.a(QCircleFrame.class);
    if (paramFrameFragment != null) {
      ((QCircleFrame)paramFrameFragment).c();
    }
  }
  
  public void e(FrameFragment paramFrameFragment) {}
  
  public void f(FrameFragment paramFrameFragment) {}
  
  public void g(FrameFragment paramFrameFragment)
  {
    if (paramFrameFragment == null) {}
    float f;
    TabDragAnimationView localTabDragAnimationView;
    Object localObject;
    do
    {
      return;
      f = paramFrameFragment.getResources().getDisplayMetrics().density;
      localTabDragAnimationView = a(paramFrameFragment);
      if (localTabDragAnimationView != null)
      {
        int i = Math.round(50.0F * f);
        localTabDragAnimationView.c = ThemeUtil.c();
        localTabDragAnimationView.a = null;
        int j = (int)(29.0F * f + 0.5F);
        localTabDragAnimationView.setIconSize(j, j);
        localTabDragAnimationView.setAnimEnable(false);
        localTabDragAnimationView.setIconGravity(2);
        j = (int)(5.0F * f + 0.5F);
        localTabDragAnimationView.setPadding(0, j, 0, j);
        if (localTabDragAnimationView.getLayoutParams() != null)
        {
          localObject = new RelativeLayout.LayoutParams(localTabDragAnimationView.getLayoutParams());
          ((RelativeLayout.LayoutParams)localObject).height = i;
          localTabDragAnimationView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      localObject = a(paramFrameFragment);
    } while ((localObject == null) || (((TextView)localObject).getLayoutParams() == null));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((TextView)localObject).getLayoutParams();
    localLayoutParams.addRule(12, 0);
    localLayoutParams.addRule(3, localTabDragAnimationView.getId());
    localLayoutParams.bottomMargin = (-Math.round(f * 6.0F));
    ((TextView)localObject).setLayoutParams(localLayoutParams);
    ((TextView)localObject).setVisibility(0);
    a(true, paramFrameFragment, this.jdField_a_of_type_Boolean);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFrameEvent.class);
    return localArrayList;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof QCircleFrameEvent)) && (((QCircleFrameEvent)paramSimpleBaseEvent).mTriggerSelectedQCircleTab) && (jdField_a_of_type_JavaLangRefWeakReference != null) && (jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((FrameFragment)jdField_a_of_type_JavaLangRefWeakReference.get()).a(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.QCircleInjectImpl
 * JD-Core Version:    0.7.0.1
 */