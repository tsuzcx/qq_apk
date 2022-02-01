package com.tencent.mobileqq.activity.framebusiness;

import android.util.SparseArray;
import android.view.View;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.activity.Now;
import com.tencent.mobileqq.activity.home.IFrameBusinessInterface;
import com.tencent.mobileqq.activity.home.ITabFrameController;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.home.impl.FrameInfoBean;
import com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.FrameFragment.DragViewTouchListener;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class NowInjectImpl
  implements IFrameBusinessInterface
{
  public static final String a = FrameControllerUtil.e;
  public static final String b = Now.class.getName();
  
  public static void g(FrameFragment paramFrameFragment)
  {
    paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[4] = null;
    paramFrameFragment.jdField_a_of_type_JavaUtilHashMap.remove(FrameControllerUtil.e);
    paramFrameFragment.jdField_a_of_type_JavaUtilHashMap.remove(FrameControllerUtil.e + "_num");
    paramFrameFragment.a(Now.class);
  }
  
  public void a()
  {
    TabFrameControllerImpl.registerFrameInfo(new FrameInfoBean(Now.class, FrameControllerUtil.f, FrameControllerUtil.e, 2130850816, 2130850817, 2131699758, 15, 5));
  }
  
  public void a(FrameFragment paramFrameFragment)
  {
    paramFrameFragment = paramFrameFragment.a(Now.class);
    if (paramFrameFragment != null) {
      ((Now)paramFrameFragment).b();
    }
  }
  
  public void a(FrameFragment paramFrameFragment, int paramInt1, Frame paramFrame, int paramInt2) {}
  
  public void a(FrameFragment paramFrameFragment, FrameFragment.DragViewTouchListener paramDragViewTouchListener) {}
  
  public void a(FrameFragment paramFrameFragment, String paramString)
  {
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).updateTabContentDescription(paramFrameFragment, FrameControllerUtil.e, ((ITabFrameController)QRoute.api(ITabFrameController.class)).getCurrentTabTag(paramFrameFragment.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost));
  }
  
  public void a(RedTouch paramRedTouch, FrameFragment paramFrameFragment, int paramInt, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, RedTouchManager paramRedTouchManager)
  {
    if (paramInt == 37)
    {
      paramRedTouch = (RedTouch)paramFrameFragment.jdField_a_of_type_JavaUtilHashMap.get(FrameControllerUtil.e);
      ((ITabFrameController)QRoute.api(ITabFrameController.class)).updateRedTouch(paramFrameFragment, paramInt, paramRedTouch, paramRedTypeInfo);
    }
  }
  
  public void a(HashMap<String, View> paramHashMap, boolean paramBoolean)
  {
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).setSoundEffectsEnableForTab(paramHashMap, paramBoolean, a);
  }
  
  public void a(AppRuntime paramAppRuntime, SparseArray<TabDragAnimationView> paramSparseArray, int paramInt) {}
  
  public boolean a(FrameFragment paramFrameFragment)
  {
    if (paramFrameFragment.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost == null) {
      return false;
    }
    if (paramFrameFragment.a() == FrameControllerUtil.f) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.redPointclearStoryRedPointIfNeeded", 2, "当前是nowtab的话，清理红点==>isCurrentTabNowTab:" + bool);
      }
      if ((!bool) || (paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime == null)) {
        break;
      }
      oidb_0x791.RedDotInfo localRedDotInfo = ((TroopRedTouchManager)paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.MGR_RED_TOUCH_EX)).a();
      if ((localRedDotInfo != null) && (localRedDotInfo.uint32_appid.get() == 52)) {
        break;
      }
      ((ITabFrameController)QRoute.api(ITabFrameController.class)).updateTabRedTouch(paramFrameFragment, 37, null);
      return true;
    }
  }
  
  public void b()
  {
    FrameInfoBean localFrameInfoBean = ((ITabFrameController)QRoute.api(ITabFrameController.class)).getFrameInfoByClazz(Now.class);
    localFrameInfoBean.a(FrameControllerUtil.f);
    QLog.d("TabFrameControllerImplBusiness", 1, "doOnUpdateFrameInfo className: " + localFrameInfoBean.a().getName() + " tabIndex: " + localFrameInfoBean.a());
  }
  
  public void b(FrameFragment paramFrameFragment) {}
  
  public void b(FrameFragment paramFrameFragment, String paramString)
  {
    if (b.equals(paramString)) {
      StoryReportor.a("story_tab", "clk", 0, ((TroopRedTouchManager)paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.MGR_RED_TOUCH_EX)).b(), new String[0]);
    }
  }
  
  public void c(FrameFragment paramFrameFragment) {}
  
  public void d(FrameFragment paramFrameFragment) {}
  
  public void e(FrameFragment paramFrameFragment) {}
  
  public void f(FrameFragment paramFrameFragment) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.NowInjectImpl
 * JD-Core Version:    0.7.0.1
 */