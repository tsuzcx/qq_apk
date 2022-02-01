package com.tencent.mobileqq.activity.framebusiness;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import com.tencent.imcore.message.ConversationProxy;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.ITabFrameController;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.home.impl.FrameInfoBean;
import com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.FrameFragment.DragViewTouchListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class ConversationInjectImpl
  extends BaseFrameBusiness
{
  public static final String a;
  public static final Random a;
  public static final int[] a;
  public static final int[] b;
  
  static
  {
    jdField_a_of_type_JavaLangString = FrameControllerUtil.jdField_a_of_type_JavaLangString;
    jdField_a_of_type_ArrayOfInt = new int[] { 2130850751, 2130841349, 2130841350, 2130841351, 2130841352, 2130841353, 2130841355, 2130841354 };
    b = new int[] { 2130850750, 2130841356, 2130841357, 2130841358 };
    jdField_a_of_type_JavaUtilRandom = new Random();
  }
  
  public static void a(FrameFragment paramFrameFragment, TabDragAnimationView paramTabDragAnimationView, AppRuntime paramAppRuntime, Runnable paramRunnable)
  {
    int[] arrayOfInt = jdField_a_of_type_ArrayOfInt;
    int m = arrayOfInt.length - 1;
    int j = arrayOfInt.length - 1;
    int k = jdField_a_of_type_JavaUtilRandom.nextInt(100000) % m;
    int i = k;
    if (k == FrameFragment.jdField_a_of_type_Int) {
      i = (k + 1) % m;
    }
    FrameFragment.jdField_a_of_type_Int = i;
    arrayOfInt = jdField_a_of_type_ArrayOfInt;
    if (!((ITabFrameController)QRoute.api(ITabFrameController.class)).hasUnReadRedPacket(paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime)) {
      j = i;
    }
    paramTabDragAnimationView.setBgPressedDrawable(arrayOfInt[j]);
    if (paramRunnable != null)
    {
      ThreadManager.getSubThreadHandler().removeCallbacks(paramRunnable);
      ThreadManager.getSubThreadHandler().post(paramRunnable);
    }
    if (QLog.isColorLevel())
    {
      paramFrameFragment = new StringBuilder();
      paramFrameFragment.append("updateTabFocusIcon currIndex = ");
      paramFrameFragment.append(i);
      QLog.d("DynimiIcon", 2, paramFrameFragment.toString());
    }
    ReportController.b(paramAppRuntime, "dc00898", "", "", "0X8009CDD", "0X8009CDD", 0, 0, "", "", "", "");
    if (FrameFragment.f)
    {
      FrameFragment.f = false;
      ReportController.b(paramAppRuntime, "dc00898", "", "", "0X8009CDB", "0X8009CDB", 0, 0, "", "", "", "");
    }
  }
  
  public static void i(FrameFragment paramFrameFragment)
  {
    TabDragAnimationView localTabDragAnimationView = (TabDragAnimationView)paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray.get(FrameControllerUtil.jdField_a_of_type_Int);
    Object localObject = (String)localTabDragAnimationView.getTag();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onConversationTabIconMoveResult mIsDefaultTheme = ");
      localStringBuilder.append(paramFrameFragment.h);
      localStringBuilder.append(", tag = ");
      localStringBuilder.append((String)localObject);
      QLog.d("DynimiIcon", 2, localStringBuilder.toString());
    }
    if ((paramFrameFragment.h) && (paramFrameFragment.a() == FrameControllerUtil.jdField_a_of_type_Int) && (!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(FrameControllerUtil.jdField_a_of_type_JavaLangString)))
    {
      localObject = (Conversation)paramFrameFragment.a(Conversation.class);
      int i;
      if (localObject != null) {
        i = ((Conversation)localObject).d;
      } else {
        i = 0;
      }
      if (i <= 0)
      {
        a(paramFrameFragment, localTabDragAnimationView, paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime, paramFrameFragment.jdField_a_of_type_JavaLangRunnable);
        if (!paramFrameFragment.j) {
          paramFrameFragment.j = true;
        }
      }
    }
  }
  
  public void a()
  {
    TabFrameControllerImpl.registerFrameInfo(new FrameInfoBean(Conversation.class, FrameControllerUtil.jdField_a_of_type_Int, FrameControllerUtil.jdField_a_of_type_JavaLangString, 2130850750, 2130850751, 2131693875, 11, 2));
  }
  
  public void a(FrameFragment paramFrameFragment)
  {
    paramFrameFragment = paramFrameFragment.a(Conversation.class);
    if (paramFrameFragment != null) {
      ((Conversation)paramFrameFragment).g();
    }
  }
  
  public void a(FrameFragment paramFrameFragment, int paramInt1, Frame paramFrame, int paramInt2)
  {
    paramFrame = paramFrameFragment.jdField_a_of_type_JavaUtilHashMap;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(FrameControllerUtil.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append("_num");
    paramFrame = (DragTextView)paramFrame.get(((StringBuilder)localObject).toString());
    if (paramInt2 == FrameControllerUtil.jdField_a_of_type_Int)
    {
      paramFrame.setOnModeChangeListener(paramFrameFragment.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
      paramFrame.setDragViewType(2);
      TabDragAnimationView localTabDragAnimationView = (TabDragAnimationView)paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray.get(FrameControllerUtil.jdField_a_of_type_Int);
      localObject = (MainFragment)paramFrameFragment;
      ((MainFragment)localObject).a.jdField_a_of_type_ComTencentMobileqqWidgetTabDragAnimationView = localTabDragAnimationView;
      if (localTabDragAnimationView != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DynimiIcon", 2, "onTabChanged ConversationTab");
        }
        try
        {
          localTabDragAnimationView.setOnDoubleTapListener(paramFrameFragment.jdField_a_of_type_ComTencentMobileqqActivityHomeImplTabFrameControllerImpl$FrameDoubleTapListener);
        }
        catch (Throwable paramFrameFragment)
        {
          QLog.e("DynimiIcon", 2, paramFrameFragment, new Object[0]);
        }
      }
      ((MainFragment)localObject).a.jdField_a_of_type_AndroidViewView = paramFrame;
      return;
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
      QLog.e("DynimiIcon", 2, paramFrameFragment, new Object[0]);
    }
    paramFrame.setOnModeChangeListener(null);
  }
  
  public void a(FrameFragment paramFrameFragment, FrameFragment.DragViewTouchListener paramDragViewTouchListener)
  {
    TabDragAnimationView localTabDragAnimationView = (TabDragAnimationView)paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131378232);
    localTabDragAnimationView.setOnTouchListener(paramDragViewTouchListener);
    localTabDragAnimationView.a("消息");
    paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray.put(FrameControllerUtil.jdField_a_of_type_Int, localTabDragAnimationView);
    paramFrameFragment.b.put(FrameControllerUtil.jdField_a_of_type_Int, (TextView)paramFrameFragment.jdField_a_of_type_ArrayOfAndroidViewView[0].findViewById(2131379917));
  }
  
  public void a(FrameFragment paramFrameFragment, String paramString)
  {
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).updateTabContentDescription(paramFrameFragment, FrameControllerUtil.jdField_a_of_type_JavaLangString, ((ITabFrameController)QRoute.api(ITabFrameController.class)).getCurrentTabTag(paramFrameFragment.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost));
  }
  
  public void a(RedTouch paramRedTouch, FrameFragment paramFrameFragment, int paramInt, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, IRedTouchManager paramIRedTouchManager)
  {
    if (paramInt == 35) {
      paramFrameFragment.a(paramRedTypeInfo, paramIRedTouchManager);
    }
  }
  
  public void a(HashMap<String, View> paramHashMap, boolean paramBoolean)
  {
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).setSoundEffectsEnableForTab(paramHashMap, paramBoolean, jdField_a_of_type_JavaLangString);
  }
  
  public void a(AppRuntime paramAppRuntime, SparseArray<TabDragAnimationView> paramSparseArray, int paramInt)
  {
    paramSparseArray = (TabDragAnimationView)paramSparseArray.get(FrameControllerUtil.jdField_a_of_type_Int);
    boolean bool = ((ITabFrameController)QRoute.api(ITabFrameController.class)).hasUnReadRedPacket(paramAppRuntime);
    int j = 0;
    int i;
    if (bool)
    {
      paramInt = jdField_a_of_type_ArrayOfInt.length - 1;
      FrameFragment.jdField_a_of_type_Int = paramInt;
      i = 3;
    }
    else if (paramInt >= 30)
    {
      paramInt = 5;
      FrameFragment.jdField_a_of_type_Int = 5;
      i = 2;
    }
    else
    {
      FrameFragment.jdField_a_of_type_Int = 0;
      i = 0;
      paramInt = j;
    }
    paramSparseArray.setBgPressedDrawable(jdField_a_of_type_ArrayOfInt[paramInt]);
    paramSparseArray.setBgDrawable(b[i]);
  }
  
  public boolean a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = ((QQAppInterface)paramAppRuntime).getProxyManager().a();
    if ((paramAppRuntime != null) && (RecentDataListManager.a().a.size() > 0))
    {
      Object localObject = new ArrayList(RecentDataListManager.a().a);
      if (((List)localObject).size() > 0)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          RecentBaseData localRecentBaseData = (RecentBaseData)((Iterator)localObject).next();
          if (localRecentBaseData != null)
          {
            int i;
            if ((localRecentBaseData.mUnreadFlag != 1) && (localRecentBaseData.mUnreadFlag != 4)) {
              i = 0;
            } else {
              i = 1;
            }
            if ((i != 0) && (paramAppRuntime.a(localRecentBaseData))) {
              return true;
            }
          }
        }
      }
    }
    return false;
  }
  
  public void b()
  {
    FrameInfoBean localFrameInfoBean = ((ITabFrameController)QRoute.api(ITabFrameController.class)).getFrameInfoByClazz(Conversation.class);
    localFrameInfoBean.a(FrameControllerUtil.jdField_a_of_type_Int);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doOnUpdateFrameInfo className: ");
    localStringBuilder.append(localFrameInfoBean.a().getName());
    localStringBuilder.append(" tabIndex: ");
    localStringBuilder.append(localFrameInfoBean.a());
    QLog.d("TabFrameControllerImplBusiness", 1, localStringBuilder.toString());
  }
  
  public void b(FrameFragment paramFrameFragment)
  {
    paramFrameFragment.a(FrameControllerUtil.jdField_a_of_type_Int, 2130850903, 2130850904);
  }
  
  public void b(FrameFragment paramFrameFragment, String paramString) {}
  
  public void c(FrameFragment paramFrameFragment)
  {
    Object localObject = (Conversation)paramFrameFragment.a(Conversation.class);
    int i;
    if (localObject != null) {
      i = ((Conversation)localObject).d;
    } else {
      i = 0;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDoubleTap() unReadCount = ");
      ((StringBuilder)localObject).append(i);
      QLog.d("DynimiIcon", 2, ((StringBuilder)localObject).toString());
    }
    localObject = paramFrameFragment.a();
    if ((localObject instanceof Conversation)) {
      ((Conversation)localObject).k();
    }
    if (i == 0) {
      h(paramFrameFragment);
    }
  }
  
  public void e(FrameFragment paramFrameFragment)
  {
    if (paramFrameFragment.a() == FrameControllerUtil.jdField_a_of_type_Int) {
      ((ITabFrameController)QRoute.api(ITabFrameController.class)).revertTabIconChange(paramFrameFragment);
    }
  }
  
  public void f(FrameFragment paramFrameFragment)
  {
    paramFrameFragment = (TabDragAnimationView)paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray.get(FrameControllerUtil.jdField_a_of_type_Int);
    SkinEngine localSkinEngine = SkinEngine.getInstances();
    int k = 2130850738;
    boolean bool = localSkinEngine.checkResExist(2130850738);
    int j = 2130850739;
    int i;
    if ((bool) && (SkinEngine.getInstances().checkResExist(2130850739))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      j = jdField_a_of_type_ArrayOfInt[0];
    }
    paramFrameFragment.setBgPressedDrawable(j);
    if (i != 0) {
      i = k;
    } else {
      i = b[0];
    }
    paramFrameFragment.setBgDrawable(i);
  }
  
  public void g(FrameFragment paramFrameFragment)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("revertConversationIconChange mPreResIndex = ");
      ((StringBuilder)localObject).append(FrameFragment.jdField_a_of_type_Int);
      QLog.d("DynimiIcon", 2, ((StringBuilder)localObject).toString());
    }
    FrameFragment.f = true;
    int i = 0;
    paramFrameFragment.j = false;
    Object localObject = (Conversation)paramFrameFragment.a(Conversation.class);
    if (localObject != null) {
      i = ((Conversation)localObject).d;
    }
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).updateTabDefaultFocusIcon(paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime, paramFrameFragment.h, paramFrameFragment.jdField_a_of_type_AndroidUtilSparseArray, i);
  }
  
  public void h(FrameFragment paramFrameFragment)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onConversationTabIconDoubleClick mIsDefaultTheme = ");
      ((StringBuilder)localObject).append(paramFrameFragment.h);
      QLog.d("DynimiIcon", 2, ((StringBuilder)localObject).toString());
    }
    if (paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime != null)
    {
      localObject = ((QQAppInterface)paramFrameFragment.jdField_a_of_type_MqqAppAppRuntime).getHandler(Conversation.class);
      if (localObject != null) {
        ((MqqHandler)localObject).sendMessage(((MqqHandler)localObject).obtainMessage(1071));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.ConversationInjectImpl
 * JD-Core Version:    0.7.0.1
 */