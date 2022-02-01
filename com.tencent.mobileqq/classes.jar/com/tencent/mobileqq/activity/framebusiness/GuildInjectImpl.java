package com.tencent.mobileqq.activity.framebusiness;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.TabWidget;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.activity.home.ITabFrameController;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.home.impl.FrameInfoBean;
import com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.FrameFragment.DragViewTouchListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IGuildContextApi;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.handler.QQGuildObserver;
import com.tencent.mobileqq.guild.mainframe.GuildMainFrameConstants;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService.UnreadCntInfo;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.widget.QQTabHost;
import com.tencent.mobileqq.widget.TabDragAnimationView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

public class GuildInjectImpl
  extends BaseFrameBusiness
{
  private static boolean a = false;
  private static final QQGuildObserver b = ;
  
  public static View a(TabFrameControllerImpl paramTabFrameControllerImpl, Context paramContext, int paramInt)
  {
    paramContext = ((ITabFrameController)QRoute.api(ITabFrameController.class)).getFrameInfoByIndex(FrameControllerUtil.k);
    paramTabFrameControllerImpl = paramTabFrameControllerImpl.generateTabItem(-1, paramContext.e(), paramInt, paramContext.f(), paramContext.g(), paramContext.h(), paramContext.i());
    paramTabFrameControllerImpl.setOnClickListener(new GuildInjectImpl.1());
    return paramTabFrameControllerImpl;
  }
  
  public static void a(boolean paramBoolean, FrameFragment paramFrameFragment, TabFrameControllerImpl paramTabFrameControllerImpl)
  {
    paramBoolean = b(paramBoolean);
    if (a("onTabFrameConstruct() addFrame", a))
    {
      paramTabFrameControllerImpl.addFrame(paramFrameFragment, paramFrameFragment.W, ((IGuildMainFrameApi)QRoute.api(IGuildMainFrameApi.class)).getGuildMainFrameClass(), paramFrameFragment.z[10]);
      i(paramFrameFragment);
    }
    else if (paramFrameFragment.a(((IGuildMainFrameApi)QRoute.api(IGuildMainFrameApi.class)).getGuildMainFrameClass()) != null)
    {
      paramFrameFragment.B.remove(FrameControllerUtil.k);
      paramFrameFragment.C.remove(FrameControllerUtil.k);
      paramFrameFragment.b(((IGuildMainFrameApi)QRoute.api(IGuildMainFrameApi.class)).getGuildMainFrameClass());
    }
    if (paramBoolean) {
      j(paramFrameFragment);
    }
  }
  
  private static boolean a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuildInjectImpl", 2, new Object[] { "will handle by ", paramString, " ? ", Boolean.valueOf(paramBoolean) });
    }
    return paramBoolean;
  }
  
  private void b(FrameFragment paramFrameFragment, int paramInt)
  {
    paramFrameFragment = ((IGuildContextApi)QRoute.api(IGuildContextApi.class)).getChildFragmentManager(paramFrameFragment.getActivity()).findFragmentByTag(((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).getGuildChatFragmentClassName());
    if ((paramFrameFragment != null) && (((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).judgeIsGuildChatFragment(paramFrameFragment)) && (paramFrameFragment.isVisible()))
    {
      IGuildFeatureAdapterApi localIGuildFeatureAdapterApi = (IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class);
      boolean bool;
      if (paramInt != FrameControllerUtil.k) {
        bool = true;
      } else {
        bool = false;
      }
      localIGuildFeatureAdapterApi.guildChatFragmentNotifyHiddenChanged(paramFrameFragment, bool, GuildMainFrameConstants.y);
    }
  }
  
  private static boolean b(boolean paramBoolean)
  {
    if (paramBoolean == a) {
      return false;
    }
    a = paramBoolean;
    return true;
  }
  
  public static boolean c()
  {
    return a;
  }
  
  @NotNull
  private static QQGuildObserver d()
  {
    return new GuildInjectImpl.2();
  }
  
  public static void i(FrameFragment paramFrameFragment)
  {
    IGuildUnreadCntService.UnreadCntInfo localUnreadCntInfo = ((IGuildUnreadCntService)paramFrameFragment.A.getRuntimeService(IGuildUnreadCntService.class, "")).getAllGuildAtUnreadCntInfo();
    int k = localUnreadCntInfo.b;
    int j = 0;
    int i = j;
    if (k == 1)
    {
      i = (int)localUnreadCntInfo.a;
      if (i < 0) {
        i = j;
      }
    }
    ((MainFragment)paramFrameFragment).a(48, 16, Integer.valueOf(i));
  }
  
  private static void j(FrameFragment paramFrameFragment)
  {
    try
    {
      ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).adjustTab(paramFrameFragment.C());
      return;
    }
    catch (NullPointerException paramFrameFragment)
    {
      QLog.d("GuildInjectImpl", 4, paramFrameFragment, new Object[] { "adjustTabSafely" });
    }
  }
  
  private void k(FrameFragment paramFrameFragment)
  {
    Intent localIntent = paramFrameFragment.C().getIntent();
    if (localIntent == null) {
      return;
    }
    Bundle localBundle = localIntent.getExtras();
    if (localBundle == null) {
      return;
    }
    if (localBundle.getBoolean("GOTO_GUILD_TAB", false))
    {
      localIntent.putExtra("GOTO_GUILD_TAB", false);
      paramFrameFragment.s.setCurrentTab(FrameControllerUtil.k);
      ((IGuildMainFrameApi)QRoute.api(IGuildMainFrameApi.class)).handleJumpAction(paramFrameFragment, localBundle);
    }
  }
  
  public void a()
  {
    TabFrameControllerImpl.registerFrameInfo(new FrameInfoBean(((IGuildMainFrameApi)QRoute.api(IGuildMainFrameApi.class)).getGuildMainFrameClass(), true, FrameControllerUtil.k, FrameControllerUtil.s, 2130852562, 2130852566, 2131890238, 19, 0));
  }
  
  public void a(FrameFragment paramFrameFragment)
  {
    Frame localFrame = paramFrameFragment.a(((IGuildMainFrameApi)QRoute.api(IGuildMainFrameApi.class)).getGuildMainFrameClass());
    int i;
    if ((paramFrameFragment.s != null) && (paramFrameFragment.s.getTabWidget() != null)) {
      i = paramFrameFragment.s.getTabWidget().getHeight();
    } else {
      i = -1;
    }
    ((IGuildMainFrameApi)QRoute.api(IGuildMainFrameApi.class)).onPostThemeChanged(localFrame, i);
  }
  
  public void a(FrameFragment paramFrameFragment, int paramInt)
  {
    if (paramInt == FrameControllerUtil.k) {
      ((MainFragment)paramFrameFragment).a(48, 18, Boolean.valueOf(false));
    }
  }
  
  public void a(FrameFragment paramFrameFragment, int paramInt1, Frame paramFrame, int paramInt2)
  {
    paramFrame = paramFrameFragment.G;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(FrameControllerUtil.s);
    ((StringBuilder)localObject).append("_num");
    paramFrame = (DragTextView)paramFrame.get(((StringBuilder)localObject).toString());
    if (paramInt2 == FrameControllerUtil.k)
    {
      paramFrame.setTag(FrameControllerUtil.s);
      paramFrame.setOnModeChangeListener(paramFrameFragment.Q);
      paramFrame.setDragViewType(2);
      paramFrame.setDragGroup(FrameControllerUtil.s);
      localObject = (TabDragAnimationView)paramFrameFragment.B.get(FrameControllerUtil.k);
      MainFragment localMainFragment = (MainFragment)paramFrameFragment;
      localMainFragment.g.a = ((TabDragAnimationView)localObject);
      localMainFragment.g.b = paramFrame;
      if ((paramFrameFragment.s != null) && (paramFrameFragment.s.getTabWidget() != null) && (paramFrameFragment.s.getTabWidget().getHeight() > 0))
      {
        paramFrame = paramFrameFragment.a(((IGuildMainFrameApi)QRoute.api(IGuildMainFrameApi.class)).getGuildMainFrameClass());
        ((IGuildMainFrameApi)QRoute.api(IGuildMainFrameApi.class)).setTabHeight(paramFrame, paramFrameFragment.s.getTabWidget().getHeight());
      }
    }
    else
    {
      paramFrame.setOnModeChangeListener(null);
    }
    paramFrame = paramFrameFragment.G;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(FrameControllerUtil.s);
    ((StringBuilder)localObject).append("_icon");
    paramFrame = (DragTextView)paramFrame.get(((StringBuilder)localObject).toString());
    if (paramFrame != null) {
      paramFrame.setOnModeChangeListener(null);
    }
    b(paramFrameFragment, paramInt2);
  }
  
  public void a(FrameFragment paramFrameFragment, FrameFragment.DragViewTouchListener paramDragViewTouchListener)
  {
    TabDragAnimationView localTabDragAnimationView = (TabDragAnimationView)paramFrameFragment.z[10].findViewById(2131446751);
    TextView localTextView = (TextView)paramFrameFragment.z[10].findViewById(2131448791);
    int i = FrameControllerUtil.k;
    localTabDragAnimationView.setOnTouchListener(paramDragViewTouchListener);
    localTabDragAnimationView.a("社群");
    paramFrameFragment.B.put(i, localTabDragAnimationView);
    paramFrameFragment.C.put(i, localTextView);
    QLog.d("GuildInjectImpl", 1, new Object[] { "doOnTabDragIconAddTv GuildTab=", Integer.valueOf(i) });
  }
  
  public void a(FrameFragment paramFrameFragment, String paramString)
  {
    ((ITabFrameController)QRoute.api(ITabFrameController.class)).updateTabContentDescription(paramFrameFragment, FrameControllerUtil.s, ((ITabFrameController)QRoute.api(ITabFrameController.class)).getCurrentTabTag(paramFrameFragment.s));
  }
  
  public void a(RedTouch paramRedTouch, FrameFragment paramFrameFragment, int paramInt, BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo, IRedTouchManager paramIRedTouchManager)
  {
    if (paramInt == 48)
    {
      paramRedTouch = paramFrameFragment.G;
      paramRedTypeInfo = new StringBuilder();
      paramRedTypeInfo.append(FrameControllerUtil.s);
      paramRedTypeInfo.append("_num");
      ((DragTextView)paramRedTouch.get(paramRedTypeInfo.toString())).setOnModeChangeListener(paramFrameFragment.Q);
    }
  }
  
  public void a(HashMap<String, View> paramHashMap, boolean paramBoolean) {}
  
  public void b()
  {
    FrameInfoBean localFrameInfoBean = ((ITabFrameController)QRoute.api(ITabFrameController.class)).getFrameInfoByClazz(((IGuildMainFrameApi)QRoute.api(IGuildMainFrameApi.class)).getGuildMainFrameClass());
    localFrameInfoBean.a(FrameControllerUtil.k);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doOnUpdateFrameInfo className: ");
    localStringBuilder.append(localFrameInfoBean.a().getName());
    localStringBuilder.append(" tabIndex: ");
    localStringBuilder.append(localFrameInfoBean.c());
    QLog.d("GuildInjectImpl", 1, localStringBuilder.toString());
  }
  
  public void b(FrameFragment paramFrameFragment) {}
  
  public void b(FrameFragment paramFrameFragment, String paramString) {}
  
  public void d(FrameFragment paramFrameFragment)
  {
    if (!a("doOnResumeAfter()", a)) {
      return;
    }
    k(paramFrameFragment);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.GuildInjectImpl
 * JD-Core Version:    0.7.0.1
 */