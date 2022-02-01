package com.tencent.mobileqq.activity.framebusiness;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.IFrameBusinessInterface;
import com.tencent.mobileqq.activity.home.ITabFrameController;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.home.impl.FrameInfoBean;
import com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.FrameFragment.DragViewTouchListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Random;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class ConversationInjectImpl
  implements IFrameBusinessInterface
{
  public static final String a;
  public static final Random a;
  public static final int[] a;
  public static final int[] b;
  
  static
  {
    jdField_a_of_type_JavaLangString = FrameControllerUtil.jdField_a_of_type_JavaLangString;
    jdField_a_of_type_ArrayOfInt = new int[] { 2130850815, 2130841468, 2130841469, 2130841470, 2130841471, 2130841472, 2130841474, 2130841473 };
    b = new int[] { 2130850814, 2130841475, 2130841476, 2130841477 };
    jdField_a_of_type_JavaUtilRandom = new Random();
  }
  
  public static void a(FrameFragment paramFrameFragment, TabDragAnimationView paramTabDragAnimationView, AppRuntime paramAppRuntime, Runnable paramRunnable)
  {
    int k = jdField_a_of_type_ArrayOfInt.length - 1;
    int j = jdField_a_of_type_ArrayOfInt.length;
    int i = jdField_a_of_type_JavaUtilRandom.nextInt(100000) % k;
    if (i == FrameFragment.jdField_a_of_type_Int) {
      i = (i + 1) % k;
    }
    for (;;)
    {
      FrameFragment.jdField_a_of_type_Int = i;
      int[] arrayOfInt = jdField_a_of_type_ArrayOfInt;
      if (((ITabFrameController)QRoute.api(ITabFrameController.class)).hasUnReadRedPacket(paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime)) {
        j -= 1;
      }
      for (;;)
      {
        paramTabDragAnimationView.setBgPressedDrawable(arrayOfInt[j]);
        if (paramRunnable != null)
        {
          ThreadManager.getSubThreadHandler().removeCallbacks(paramRunnable);
          ThreadManager.getSubThreadHandler().post(paramRunnable);
        }
        if (QLog.isColorLevel()) {
          QLog.d("DynimiIcon", 2, "updateTabFocusIcon currIndex = " + i);
        }
        ReportController.b(paramAppRuntime, "dc00898", "", "", "0X8009CDD", "0X8009CDD", 0, 0, "", "", "", "");
        if (FrameFragment.f)
        {
          FrameFragment.f = false;
          ReportController.b(paramAppRuntime, "dc00898", "", "", "0X8009CDB", "0X8009CDB", 0, 0, "", "", "", "");
        }
        return;
        j = i;
      }
    }
  }
  
  public static void h(FrameFragment paramFrameFragment)
  {
    TabDragAnimationView localTabDragAnimationView = (TabDragAnimationView)paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray.get(FrameControllerUtil.jdField_a_of_type_Int);
    Object localObject = (String)localTabDragAnimationView.getTag();
    if (QLog.isColorLevel()) {
      QLog.d("DynimiIcon", 2, "onConversationTabIconMoveResult mIsDefaultTheme = " + paramFrameFragment.h + ", tag = " + (String)localObject);
    }
    if ((paramFrameFragment.h) && (paramFrameFragment.a() == FrameControllerUtil.jdField_a_of_type_Int) && (!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(FrameControllerUtil.jdField_a_of_type_JavaLangString)))
    {
      localObject = (Conversation)paramFrameFragment.a(Conversation.class);
      if (localObject == null) {
        break label148;
      }
    }
    label148:
    for (int i = ((Conversation)localObject).d;; i = 0)
    {
      if (i <= 0)
      {
        a(paramFrameFragment, localTabDragAnimationView, paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime, paramFrameFragment.jdField_a_of_type_JavaLangRunnable);
        if (!paramFrameFragment.j) {
          paramFrameFragment.j = true;
        }
      }
      return;
    }
  }
  
  public void a()
  {
    TabFrameControllerImpl.registerFrameInfo(new FrameInfoBean(Conversation.class, FrameControllerUtil.jdField_a_of_type_Int, FrameControllerUtil.jdField_a_of_type_JavaLangString, 2130850814, 2130850815, 2131693919, 11, 2));
  }
  
  public void a(FrameFragment paramFrameFragment)
  {
    paramFrameFragment = paramFrameFragment.a(Conversation.class);
    if (paramFrameFragment != null) {
      ((Conversation)paramFrameFragment).b();
    }
  }
  
  public void a(FrameFragment paramFrameFragment, int paramInt1, Frame paramFrame, int paramInt2)
  {
    paramFrame = (DragTextView)paramFrameFragment.jdField_a_of_type_JavaUtilHashMap.get(FrameControllerUtil.jdField_a_of_type_JavaLangString + "_num");
    if (paramInt2 == FrameControllerUtil.jdField_a_of_type_Int)
    {
      paramFrame.setOnModeChangeListener(paramFrameFragment.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
      paramFrame.setDragViewType(2);
      TabDragAnimationView localTabDragAnimationView = (TabDragAnimationView)paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray.get(FrameControllerUtil.jdField_a_of_type_Int);
      ((MainFragment)paramFrameFragment).a.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView = localTabDragAnimationView;
      if (localTabDragAnimationView != null) {
        if (QLog.isColorLevel()) {
          QLog.d("DynimiIcon", 2, "onTabChanged ConversationTab");
        }
      }
      try
      {
        localTabDragAnimationView.setOnDoubleTapListener(paramFrameFragment.jdField_a_of_type_ComTencentMobileqqActivityHomeImplTabFrameControllerImpl$FrameDoubleTapListener);
        ((MainFragment)paramFrameFragment).a.jdField_a_of_type_AndroidViewView = paramFrame;
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.e("DynimiIcon", 2, localThrowable, new Object[0]);
        }
      }
    }
    try
    {
      paramFrameFragment = (TabDragAnimationView)paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray.get(FrameControllerUtil.jdField_a_of_type_Int);
      if (paramFrameFragment != null) {
        paramFrameFragment.setOnDoubleTapListener(null);
      }
    }
    catch (Throwable paramFrameFragment)
    {
      for (;;)
      {
        QLog.e("DynimiIcon", 2, paramFrameFragment, new Object[0]);
      }
    }
    paramFrame.setOnModeChangeListener(null);
  }
  
  public void a(FrameFragment paramFrameFragment, FrameFragment.DragViewTouchListener paramDragViewTouchListener)
  {
    TabDragAnimationView localTabDragAnimationView = (TabDragAnimationView)paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131378843);
    localTabDragAnimationView.setOnTouchListener(paramDragViewTouchListener);
    localTabDragAnimationView.a("消息");
    paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray.put(FrameControllerUtil.jdField_a_of_type_Int, localTabDragAnimationView);
    paramFrameFragment.b.put(FrameControllerUtil.jdField_a_of_type_Int, (TextView)paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131380635));
  }
  
  public void a(FrameFragment paramFrameFragment, String paramString)
  {
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).updateTabContentDescription(paramFrameFragment, FrameControllerUtil.jdField_a_of_type_JavaLangString, ((ITabFrameController)QRoute.api(ITabFrameController.class)).getCurrentTabTag(paramFrameFragment.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost));
  }
  
  public void a(RedTouch paramRedTouch, FrameFragment paramFrameFragment, int paramInt, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, RedTouchManager paramRedTouchManager)
  {
    if (paramInt == 35) {
      paramFrameFragment.a(paramRedTypeInfo, paramRedTouchManager);
    }
  }
  
  public void a(HashMap<String, View> paramHashMap, boolean paramBoolean)
  {
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).setSoundEffectsEnableForTab(paramHashMap, paramBoolean, jdField_a_of_type_JavaLangString);
  }
  
  public void a(AppRuntime paramAppRuntime, SparseArray<TabDragAnimationView> paramSparseArray, int paramInt)
  {
    int i = 0;
    paramSparseArray = (TabDragAnimationView)paramSparseArray.get(FrameControllerUtil.jdField_a_of_type_Int);
    if (((ITabFrameController)QRoute.api(ITabFrameController.class)).hasUnReadRedPacket(paramAppRuntime))
    {
      i = jdField_a_of_type_ArrayOfInt.length - 1;
      FrameFragment.jdField_a_of_type_Int = i;
      paramInt = 3;
    }
    for (;;)
    {
      paramSparseArray.setBgPressedDrawable(jdField_a_of_type_ArrayOfInt[i]);
      paramSparseArray.setBgDrawable(b[paramInt]);
      return;
      if (paramInt >= 30)
      {
        i = 5;
        FrameFragment.jdField_a_of_type_Int = 5;
        paramInt = 2;
      }
      else
      {
        FrameFragment.jdField_a_of_type_Int = 0;
        paramInt = 0;
      }
    }
  }
  
  public boolean a(FrameFragment paramFrameFragment)
  {
    return false;
  }
  
  public void b()
  {
    FrameInfoBean localFrameInfoBean = ((ITabFrameController)QRoute.api(ITabFrameController.class)).getFrameInfoByClazz(Conversation.class);
    localFrameInfoBean.a(FrameControllerUtil.jdField_a_of_type_Int);
    QLog.d("TabFrameControllerImplBusiness", 1, "doOnUpdateFrameInfo className: " + localFrameInfoBean.a().getName() + " tabIndex: " + localFrameInfoBean.a());
  }
  
  public void b(FrameFragment paramFrameFragment)
  {
    paramFrameFragment.a(FrameControllerUtil.jdField_a_of_type_Int, 2130850963, 2130850964);
  }
  
  public void b(FrameFragment paramFrameFragment, String paramString) {}
  
  public void c(FrameFragment paramFrameFragment)
  {
    Object localObject = (Conversation)paramFrameFragment.a(Conversation.class);
    if (localObject != null) {}
    for (int i = ((Conversation)localObject).d;; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DynimiIcon", 2, "onDoubleTap() unReadCount = " + i);
      }
      localObject = paramFrameFragment.a();
      if ((localObject instanceof Conversation)) {
        ((Conversation)localObject).i();
      }
      if (i == 0) {
        g(paramFrameFragment);
      }
      return;
    }
  }
  
  public void d(FrameFragment paramFrameFragment) {}
  
  public void e(FrameFragment paramFrameFragment)
  {
    if (paramFrameFragment.a() == FrameControllerUtil.jdField_a_of_type_Int) {
      ((ITabFrameController)QRoute.api(ITabFrameController.class)).revertTabIconChange(paramFrameFragment);
    }
  }
  
  public void f(FrameFragment paramFrameFragment)
  {
    paramFrameFragment = (TabDragAnimationView)paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray.get(FrameControllerUtil.jdField_a_of_type_Int);
    paramFrameFragment.setBgPressedDrawable(jdField_a_of_type_ArrayOfInt[0]);
    paramFrameFragment.setBgDrawable(b[0]);
  }
  
  public void g(FrameFragment paramFrameFragment)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DynimiIcon", 2, "onConversationTabIconDoubleClick mIsDefaultTheme = " + paramFrameFragment.h);
    }
    if (paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime != null)
    {
      MqqHandler localMqqHandler = ((QQAppInterface)paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime).getHandler(Conversation.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendMessage(localMqqHandler.obtainMessage(1071));
      }
      if (paramFrameFragment.h)
      {
        a(paramFrameFragment, (TabDragAnimationView)paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray.get(FrameControllerUtil.jdField_a_of_type_Int), paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime, paramFrameFragment.jdField_a_of_type_JavaLangRunnable);
        if (!paramFrameFragment.j) {
          paramFrameFragment.j = true;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.ConversationInjectImpl
 * JD-Core Version:    0.7.0.1
 */