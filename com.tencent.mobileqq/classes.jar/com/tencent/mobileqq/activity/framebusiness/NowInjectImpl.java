package com.tencent.mobileqq.activity.framebusiness;

import android.view.View;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.activity.Now;
import com.tencent.mobileqq.activity.home.ITabFrameController;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.home.impl.FrameInfoBean;
import com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class NowInjectImpl
  extends BaseFrameBusiness
{
  public static final String a = FrameControllerUtil.e;
  public static final String b = Now.class.getName();
  
  public static void h(FrameFragment paramFrameFragment)
  {
    paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[4] = null;
    paramFrameFragment.jdField_a_of_type_JavaUtilHashMap.remove(FrameControllerUtil.e);
    HashMap localHashMap = paramFrameFragment.jdField_a_of_type_JavaUtilHashMap;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(FrameControllerUtil.e);
    localStringBuilder.append("_num");
    localHashMap.remove(localStringBuilder.toString());
    paramFrameFragment.a(Now.class);
  }
  
  public void a()
  {
    TabFrameControllerImpl.registerFrameInfo(new FrameInfoBean(Now.class, FrameControllerUtil.f, FrameControllerUtil.e, 2130850752, 2130850753, 2131699899, 15, 5));
  }
  
  public void a(FrameFragment paramFrameFragment)
  {
    paramFrameFragment = paramFrameFragment.a(Now.class);
    if (paramFrameFragment != null) {
      ((Now)paramFrameFragment).g();
    }
  }
  
  public void a(FrameFragment paramFrameFragment, String paramString)
  {
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).updateTabContentDescription(paramFrameFragment, FrameControllerUtil.e, ((ITabFrameController)QRoute.api(ITabFrameController.class)).getCurrentTabTag(paramFrameFragment.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost));
  }
  
  public void a(RedTouch paramRedTouch, FrameFragment paramFrameFragment, int paramInt, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, IRedTouchManager paramIRedTouchManager)
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
  
  public boolean a(FrameFragment paramFrameFragment)
  {
    if (paramFrameFragment.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost == null) {
      return false;
    }
    boolean bool;
    if (paramFrameFragment.a() == FrameControllerUtil.f) {
      bool = true;
    } else {
      bool = false;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("当前是nowtab的话，清理红点==>isCurrentTabNowTab:");
      ((StringBuilder)localObject).append(bool);
      QLog.d("Q.qqstory.redPointclearStoryRedPointIfNeeded", 2, ((StringBuilder)localObject).toString());
    }
    if ((bool) && (paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime != null))
    {
      localObject = ((TroopRedTouchManager)paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.MGR_RED_TOUCH_EX)).a();
      if ((localObject != null) && (((oidb_0x791.RedDotInfo)localObject).uint32_appid.get() == 52)) {
        return false;
      }
      ((ITabFrameController)QRoute.api(ITabFrameController.class)).updateTabRedTouch(paramFrameFragment, 37, null);
      return true;
    }
    return false;
  }
  
  public void b()
  {
    FrameInfoBean localFrameInfoBean = ((ITabFrameController)QRoute.api(ITabFrameController.class)).getFrameInfoByClazz(Now.class);
    localFrameInfoBean.a(FrameControllerUtil.f);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doOnUpdateFrameInfo className: ");
    localStringBuilder.append(localFrameInfoBean.a().getName());
    localStringBuilder.append(" tabIndex: ");
    localStringBuilder.append(localFrameInfoBean.a());
    QLog.d("TabFrameControllerImplBusiness", 1, localStringBuilder.toString());
  }
  
  public void b(FrameFragment paramFrameFragment, String paramString)
  {
    if (b.equals(paramString)) {
      StoryReportor.a("story_tab", "clk", 0, ((TroopRedTouchManager)paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.MGR_RED_TOUCH_EX)).b(), new String[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.NowInjectImpl
 * JD-Core Version:    0.7.0.1
 */