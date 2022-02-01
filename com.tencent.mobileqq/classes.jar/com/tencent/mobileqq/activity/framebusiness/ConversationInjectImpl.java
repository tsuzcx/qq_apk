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
import com.tencent.mobileqq.qcircle.api.IQCircleNativeFrameApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
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
  public static final String a = FrameControllerUtil.l;
  public static final int[] b = { 2130852560, 2130842150, 2130842151, 2130842152, 2130842153, 2130842154, 2130842156, 2130842155 };
  public static final int[] c = { 2130852558, 2130842157, 2130842158, 2130842159 };
  public static final Random d = new Random();
  
  public static void a(FrameFragment paramFrameFragment, TabDragAnimationView paramTabDragAnimationView, AppRuntime paramAppRuntime, Runnable paramRunnable)
  {
    int[] arrayOfInt = b;
    int m = arrayOfInt.length - 1;
    int j = arrayOfInt.length - 1;
    int k = d.nextInt(100000) % m;
    int i = k;
    if (k == FrameFragment.n) {
      i = (k + 1) % m;
    }
    FrameFragment.n = i;
    arrayOfInt = b;
    if (!((ITabFrameController)QRoute.api(ITabFrameController.class)).hasUnReadRedPacket(paramFrameFragment.A)) {
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
    if (FrameFragment.p)
    {
      FrameFragment.p = false;
      ReportController.b(paramAppRuntime, "dc00898", "", "", "0X8009CDB", "0X8009CDB", 0, 0, "", "", "", "");
    }
  }
  
  private boolean c()
  {
    return (((IQCircleNativeFrameApi)QRoute.api(IQCircleNativeFrameApi.class)).isNewLayerMode()) && (QCircleConfigHelper.a(StudyModeManager.h()));
  }
  
  public static void j(FrameFragment paramFrameFragment)
  {
    TabDragAnimationView localTabDragAnimationView = (TabDragAnimationView)paramFrameFragment.B.get(FrameControllerUtil.a);
    Object localObject = (String)localTabDragAnimationView.getTag();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onConversationTabIconMoveResult mIsDefaultTheme = ");
      localStringBuilder.append(paramFrameFragment.J);
      localStringBuilder.append(", tag = ");
      localStringBuilder.append((String)localObject);
      QLog.d("DynimiIcon", 2, localStringBuilder.toString());
    }
    if ((paramFrameFragment.J) && (paramFrameFragment.w() == FrameControllerUtil.a) && (!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(FrameControllerUtil.l)))
    {
      localObject = (Conversation)paramFrameFragment.a(Conversation.class);
      int i;
      if (localObject != null) {
        i = ((Conversation)localObject).O;
      } else {
        i = 0;
      }
      if (i <= 0)
      {
        a(paramFrameFragment, localTabDragAnimationView, paramFrameFragment.A, paramFrameFragment.U);
        if (!paramFrameFragment.N) {
          paramFrameFragment.N = true;
        }
      }
    }
  }
  
  public void a()
  {
    TabFrameControllerImpl.registerFrameInfo(new FrameInfoBean(Conversation.class, FrameControllerUtil.a, FrameControllerUtil.l, 2130852558, 2130852560, 2131891480, 11, 2));
  }
  
  public void a(FrameFragment paramFrameFragment)
  {
    paramFrameFragment = paramFrameFragment.a(Conversation.class);
    if (paramFrameFragment != null) {
      ((Conversation)paramFrameFragment).l();
    }
  }
  
  public void a(FrameFragment paramFrameFragment, int paramInt1, Frame paramFrame, int paramInt2)
  {
    paramFrame = paramFrameFragment.G;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(FrameControllerUtil.l);
    ((StringBuilder)localObject).append("_num");
    paramFrame = (DragTextView)paramFrame.get(((StringBuilder)localObject).toString());
    if (paramInt2 == FrameControllerUtil.a)
    {
      paramFrame.setTag(FrameControllerUtil.l);
      paramFrame.setOnModeChangeListener(paramFrameFragment.Q);
      paramFrame.setDragGroup(FrameControllerUtil.l);
      paramFrame.setDragViewType(2);
      TabDragAnimationView localTabDragAnimationView = (TabDragAnimationView)paramFrameFragment.B.get(FrameControllerUtil.a);
      localObject = (MainFragment)paramFrameFragment;
      ((MainFragment)localObject).g.a = localTabDragAnimationView;
      if (localTabDragAnimationView != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DynimiIcon", 2, "onTabChanged ConversationTab");
        }
        try
        {
          localTabDragAnimationView.setOnDoubleTapListener(paramFrameFragment.aa);
          paramFrame.setOnDoubleTapListener(paramFrameFragment.aa);
        }
        catch (Throwable paramFrameFragment)
        {
          QLog.e("DynimiIcon", 2, paramFrameFragment, new Object[0]);
        }
      }
      ((MainFragment)localObject).g.b = paramFrame;
      return;
    }
    try
    {
      paramFrameFragment = (TabDragAnimationView)paramFrameFragment.B.get(FrameControllerUtil.a);
      if (paramFrameFragment != null) {
        paramFrameFragment.setOnDoubleTapListener(null);
      }
      if (paramFrame != null) {
        paramFrame.setOnDoubleTapListener(null);
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
    TabDragAnimationView localTabDragAnimationView = (TabDragAnimationView)paramFrameFragment.z[0].findViewById(2131446751);
    localTabDragAnimationView.setOnTouchListener(paramDragViewTouchListener);
    localTabDragAnimationView.a("消息");
    paramFrameFragment.B.put(FrameControllerUtil.a, localTabDragAnimationView);
    paramFrameFragment.C.put(FrameControllerUtil.a, (TextView)paramFrameFragment.z[0].findViewById(2131448791));
  }
  
  public void a(FrameFragment paramFrameFragment, String paramString)
  {
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).updateTabContentDescription(paramFrameFragment, FrameControllerUtil.l, ((ITabFrameController)QRoute.api(ITabFrameController.class)).getCurrentTabTag(paramFrameFragment.s));
  }
  
  public void a(RedTouch paramRedTouch, FrameFragment paramFrameFragment, int paramInt, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, IRedTouchManager paramIRedTouchManager)
  {
    if (paramInt == 35) {
      paramFrameFragment.a(paramRedTypeInfo, paramIRedTouchManager);
    }
  }
  
  public void a(HashMap<String, View> paramHashMap, boolean paramBoolean)
  {
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).setSoundEffectsEnableForTab(paramHashMap, paramBoolean, a);
  }
  
  public void a(AppRuntime paramAppRuntime, SparseArray<TabDragAnimationView> paramSparseArray, int paramInt)
  {
    if (c()) {
      return;
    }
    paramSparseArray = (TabDragAnimationView)paramSparseArray.get(FrameControllerUtil.a);
    boolean bool = ((ITabFrameController)QRoute.api(ITabFrameController.class)).hasUnReadRedPacket(paramAppRuntime);
    int j = 0;
    int i;
    if (bool)
    {
      paramInt = b.length - 1;
      FrameFragment.n = paramInt;
      i = 3;
    }
    else if (paramInt >= 30)
    {
      paramInt = 5;
      FrameFragment.n = 5;
      i = 2;
    }
    else
    {
      FrameFragment.n = 0;
      i = 0;
      paramInt = j;
    }
    paramSparseArray.setBgPressedDrawable(b[paramInt]);
    paramSparseArray.setBgDrawable(c[i]);
  }
  
  public boolean a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = ((QQAppInterface)paramAppRuntime).getProxyManager().h();
    if ((paramAppRuntime != null) && (RecentDataListManager.a().c.size() > 0))
    {
      Object localObject = new ArrayList(RecentDataListManager.a().c);
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
    localFrameInfoBean.a(FrameControllerUtil.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doOnUpdateFrameInfo className: ");
    localStringBuilder.append(localFrameInfoBean.a().getName());
    localStringBuilder.append(" tabIndex: ");
    localStringBuilder.append(localFrameInfoBean.c());
    QLog.d("TabFrameControllerImplBusiness", 1, localStringBuilder.toString());
  }
  
  public void b(FrameFragment paramFrameFragment)
  {
    paramFrameFragment.a(FrameControllerUtil.a, 2130852755, 2130852756);
  }
  
  public void b(FrameFragment paramFrameFragment, String paramString) {}
  
  public void c(FrameFragment paramFrameFragment)
  {
    Object localObject = (Conversation)paramFrameFragment.a(Conversation.class);
    int i;
    if (localObject != null) {
      i = ((Conversation)localObject).O;
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
    localObject = paramFrameFragment.v();
    if ((localObject instanceof Conversation)) {
      ((Conversation)localObject).o();
    }
    if (i == 0) {
      i(paramFrameFragment);
    }
  }
  
  public void f(FrameFragment paramFrameFragment)
  {
    if (paramFrameFragment.w() == FrameControllerUtil.a) {
      ((ITabFrameController)QRoute.api(ITabFrameController.class)).revertTabIconChange(paramFrameFragment);
    }
  }
  
  public void g(FrameFragment paramFrameFragment)
  {
    if (c()) {
      return;
    }
    paramFrameFragment = (TabDragAnimationView)paramFrameFragment.B.get(FrameControllerUtil.a);
    SkinEngine localSkinEngine = SkinEngine.getInstances();
    int k = 2130852542;
    boolean bool = localSkinEngine.checkResExist(2130852542);
    int j = 2130852543;
    int i;
    if ((bool) && (SkinEngine.getInstances().checkResExist(2130852543))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      j = b[0];
    }
    paramFrameFragment.setBgPressedDrawable(j);
    if (i != 0) {
      i = k;
    } else {
      i = c[0];
    }
    paramFrameFragment.setBgDrawable(i);
  }
  
  public void h(FrameFragment paramFrameFragment)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("revertConversationIconChange mPreResIndex = ");
      ((StringBuilder)localObject).append(FrameFragment.n);
      QLog.d("DynimiIcon", 2, ((StringBuilder)localObject).toString());
    }
    FrameFragment.p = true;
    int i = 0;
    paramFrameFragment.N = false;
    Object localObject = (Conversation)paramFrameFragment.a(Conversation.class);
    if (localObject != null) {
      i = ((Conversation)localObject).O;
    }
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).updateTabDefaultFocusIcon(paramFrameFragment.A, paramFrameFragment.J, paramFrameFragment.B, i);
  }
  
  public void i(FrameFragment paramFrameFragment)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onConversationTabIconDoubleClick mIsDefaultTheme = ");
      ((StringBuilder)localObject).append(paramFrameFragment.J);
      QLog.d("DynimiIcon", 2, ((StringBuilder)localObject).toString());
    }
    if (paramFrameFragment.A != null)
    {
      localObject = ((QQAppInterface)paramFrameFragment.A).getHandler(Conversation.class);
      if (localObject != null) {
        ((MqqHandler)localObject).sendMessage(((MqqHandler)localObject).obtainMessage(1071));
      }
      if (paramFrameFragment.J)
      {
        a(paramFrameFragment, (TabDragAnimationView)paramFrameFragment.B.get(FrameControllerUtil.a), paramFrameFragment.A, paramFrameFragment.U);
        if (!paramFrameFragment.N) {
          paramFrameFragment.N = true;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.ConversationInjectImpl
 * JD-Core Version:    0.7.0.1
 */