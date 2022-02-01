package com.tencent.mobileqq.activity.framebusiness;

import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contacts.base.Contacts;
import com.tencent.mobileqq.activity.home.IFrameBusinessInterface;
import com.tencent.mobileqq.activity.home.ITabFrameController;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.home.impl.FrameInfoBean;
import com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.FrameFragment.DragViewTouchListener;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class ContactsInjectImpl
  implements IFrameBusinessInterface
{
  public static final String a = FrameControllerUtil.jdField_b_of_type_JavaLangString;
  public static final String b;
  
  static
  {
    jdField_b_of_type_JavaLangString = Contacts.class.getName();
  }
  
  public void a()
  {
    TabFrameControllerImpl.registerFrameInfo(new FrameInfoBean(Contacts.class, FrameControllerUtil.c, FrameControllerUtil.jdField_b_of_type_JavaLangString, 2130850812, 2130850813, 2131693918, 12, 3));
  }
  
  public void a(FrameFragment paramFrameFragment)
  {
    paramFrameFragment = paramFrameFragment.a(Contacts.class);
    if (paramFrameFragment != null) {
      ((Contacts)paramFrameFragment).g();
    }
  }
  
  public void a(FrameFragment paramFrameFragment, int paramInt1, Frame paramFrame, int paramInt2)
  {
    if ((paramInt1 == FrameControllerUtil.jdField_b_of_type_Int) && (paramInt2 != FrameControllerUtil.jdField_b_of_type_Int) && (paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime != null))
    {
      paramFrameFragment = (QCallFacade)paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.RECENT_CALL_FACADE);
      if (paramFrameFragment != null) {
        paramFrameFragment.a(MessageCache.a());
      }
    }
  }
  
  public void a(FrameFragment paramFrameFragment, FrameFragment.DragViewTouchListener paramDragViewTouchListener)
  {
    TabDragAnimationView localTabDragAnimationView = (TabDragAnimationView)paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[2].findViewById(2131378843);
    localTabDragAnimationView.setOnTouchListener(paramDragViewTouchListener);
    localTabDragAnimationView.setExpectedLogoMoveDistance(ViewUtils.b(2.0F));
    localTabDragAnimationView.a("联系人");
    paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray.put(FrameControllerUtil.c, localTabDragAnimationView);
    paramFrameFragment.b.put(FrameControllerUtil.c, (TextView)paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[2].findViewById(2131380635));
  }
  
  public void a(FrameFragment paramFrameFragment, String paramString)
  {
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).updateTabContentDescription(paramFrameFragment, FrameControllerUtil.jdField_b_of_type_JavaLangString, ((ITabFrameController)QRoute.api(ITabFrameController.class)).getCurrentTabTag(paramFrameFragment.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost));
  }
  
  public void a(RedTouch paramRedTouch, FrameFragment paramFrameFragment, int paramInt, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, RedTouchManager paramRedTouchManager)
  {
    if (paramInt == 33)
    {
      paramRedTouch = (RedTouch)paramFrameFragment.jdField_a_of_type_JavaUtilHashMap.get(FrameControllerUtil.jdField_b_of_type_JavaLangString);
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
    return false;
  }
  
  public void b()
  {
    FrameInfoBean localFrameInfoBean = ((ITabFrameController)QRoute.api(ITabFrameController.class)).getFrameInfoByClazz(Contacts.class);
    localFrameInfoBean.a(FrameControllerUtil.c);
    QLog.d("TabFrameControllerImplBusiness", 1, "doOnUpdateFrameInfo className: " + localFrameInfoBean.a().getName() + " tabIndex: " + localFrameInfoBean.a());
  }
  
  public void b(FrameFragment paramFrameFragment)
  {
    paramFrameFragment.a(FrameControllerUtil.c, 2130850961, 2130850962);
  }
  
  public void b(FrameFragment paramFrameFragment, String paramString)
  {
    if (jdField_b_of_type_JavaLangString.equals(paramString)) {
      ThreadManager.getSubThreadHandler().postDelayed(new ContactsInjectImpl.1(this, paramFrameFragment), 500L);
    }
  }
  
  public void c(FrameFragment paramFrameFragment) {}
  
  public void d(FrameFragment paramFrameFragment) {}
  
  public void e(FrameFragment paramFrameFragment) {}
  
  public void f(FrameFragment paramFrameFragment) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.ContactsInjectImpl
 * JD-Core Version:    0.7.0.1
 */