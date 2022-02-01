package com.tencent.mobileqq.activity.framebusiness;

import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.home.IFrameBusinessInterface;
import com.tencent.mobileqq.activity.home.ITabFrameController;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.home.impl.FrameInfoBean;
import com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.FrameFragment.DragViewTouchListener;
import com.tencent.mobileqq.leba.ILebaFrameApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class LebaInjectImpl
  implements IFrameBusinessInterface
{
  public static final String a = FrameControllerUtil.jdField_d_of_type_JavaLangString;
  
  public void a()
  {
    TabFrameControllerImpl.registerFrameInfo(new FrameInfoBean(((ILebaFrameApi)QRoute.api(ILebaFrameApi.class)).getLebaFrameClass(), FrameControllerUtil.jdField_d_of_type_Int, FrameControllerUtil.jdField_d_of_type_JavaLangString, 2130850818, 2130850819, 2131693920, 14, 4));
  }
  
  public void a(FrameFragment paramFrameFragment)
  {
    paramFrameFragment = paramFrameFragment.a(((ILebaFrameApi)QRoute.api(ILebaFrameApi.class)).getLebaFrameClass());
    ((ILebaFrameApi)QRoute.api(ILebaFrameApi.class)).onPostThemeChanged(paramFrameFragment);
  }
  
  public void a(FrameFragment paramFrameFragment, int paramInt1, Frame paramFrame, int paramInt2) {}
  
  public void a(FrameFragment paramFrameFragment, FrameFragment.DragViewTouchListener paramDragViewTouchListener)
  {
    TabDragAnimationView localTabDragAnimationView = (TabDragAnimationView)paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[3].findViewById(2131378843);
    localTabDragAnimationView.setOnTouchListener(paramDragViewTouchListener);
    localTabDragAnimationView.a("动态");
    paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray.put(FrameControllerUtil.jdField_d_of_type_Int, localTabDragAnimationView);
    paramFrameFragment.b.put(FrameControllerUtil.jdField_d_of_type_Int, (TextView)paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[3].findViewById(2131380635));
  }
  
  public void a(FrameFragment paramFrameFragment, String paramString)
  {
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).updateTabContentDescription(paramFrameFragment, FrameControllerUtil.jdField_d_of_type_JavaLangString, ((ITabFrameController)QRoute.api(ITabFrameController.class)).getCurrentTabTag(paramFrameFragment.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost));
  }
  
  public void a(RedTouch paramRedTouch, FrameFragment paramFrameFragment, int paramInt, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, RedTouchManager paramRedTouchManager)
  {
    if (paramInt == 34)
    {
      paramRedTouch = (RedTouch)paramFrameFragment.jdField_a_of_type_JavaUtilHashMap.get(FrameControllerUtil.jdField_d_of_type_JavaLangString);
      ((ITabFrameController)QRoute.api(ITabFrameController.class)).updateRedTouch(paramFrameFragment, paramInt, paramRedTouch, paramRedTypeInfo);
      paramRedTouchManager.b(0, 30);
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
    FrameInfoBean localFrameInfoBean = ((ITabFrameController)QRoute.api(ITabFrameController.class)).getFrameInfoByClazz(((ILebaFrameApi)QRoute.api(ILebaFrameApi.class)).getLebaFrameClass());
    localFrameInfoBean.a(FrameControllerUtil.jdField_d_of_type_Int);
    QLog.d("TabFrameControllerImplBusiness", 1, "doOnUpdateFrameInfo className: " + localFrameInfoBean.a().getName() + " tabIndex: " + localFrameInfoBean.a());
  }
  
  public void b(FrameFragment paramFrameFragment)
  {
    paramFrameFragment.a(FrameControllerUtil.jdField_d_of_type_Int, -1, 2130850966);
  }
  
  public void b(FrameFragment paramFrameFragment, String paramString)
  {
    if (paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime == null) {}
    do
    {
      do
      {
        return;
      } while (!((ILebaFrameApi)QRoute.api(ILebaFrameApi.class)).isLeba(paramString));
      paramString = paramFrameFragment.a();
    } while (!((ILebaFrameApi)QRoute.api(ILebaFrameApi.class)).isLebaFrame(paramString));
    paramFrameFragment = (RedTouch)paramFrameFragment.jdField_a_of_type_JavaUtilHashMap.get(FrameControllerUtil.jdField_d_of_type_JavaLangString);
    boolean bool;
    if ((paramFrameFragment != null) && (paramFrameFragment.c()))
    {
      bool = true;
      if (paramFrameFragment != null) {
        break label102;
      }
    }
    label102:
    for (paramFrameFragment = null;; paramFrameFragment = paramFrameFragment.a())
    {
      ((ILebaFrameApi)QRoute.api(ILebaFrameApi.class)).onSwitchToLeba(paramString, bool, paramFrameFragment);
      return;
      bool = false;
      break;
    }
  }
  
  public void c(FrameFragment paramFrameFragment) {}
  
  public void d(FrameFragment paramFrameFragment) {}
  
  public void e(FrameFragment paramFrameFragment) {}
  
  public void f(FrameFragment paramFrameFragment) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.LebaInjectImpl
 * JD-Core Version:    0.7.0.1
 */