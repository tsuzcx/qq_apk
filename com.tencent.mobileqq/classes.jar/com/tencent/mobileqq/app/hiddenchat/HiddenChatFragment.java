package com.tencent.mobileqq.app.hiddenchat;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.BeancurdManager;
import com.tencent.mobileqq.activity.aio.helper.HiddenChatHelper;
import com.tencent.mobileqq.activity.miniaio.MiniMsgIPCClient;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.activity.recent.OnRecentUserOpsListener;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentReportHelper;
import com.tencent.mobileqq.activity.recent.RecentTroopMenuOption;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatCenterManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.FeedsManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.api.IHotChatUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.settings.fragment.PermissionPrivacyFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.handler.ITroopCommonlyUsedHandler;
import com.tencent.mobileqq.troop.api.observer.TroopCommonlyUsedObserver;
import com.tencent.mobileqq.troop.troopsetting.api.ITroopSettingHandler;
import com.tencent.mobileqq.troop.troopsetting.api.TroopSettingObserver;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.notification.NotifyIdManager;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.os.MqqHandler;

public class HiddenChatFragment
  extends IphoneTitleBarFragment
  implements Handler.Callback, View.OnClickListener, OnRecentUserOpsListener, DragFrameLayout.OnDragModeChangedListener, Observer
{
  XListView a;
  RecentAdapter b;
  DragFrameLayout c;
  MiniMsgUser d;
  protected TroopCommonlyUsedObserver e = new HiddenChatFragment.2(this);
  private MqqHandler f;
  private MqqHandler g;
  private QQAppInterface h;
  private HiddenChatComparator i;
  private RecentTroopMenuOption j;
  private TroopSettingObserver k = new HiddenChatFragment.3(this);
  private FriendListObserver l = new HiddenChatFragment.4(this);
  
  public static List<RecentUser> a(List<RecentUser> paramList1, List<RecentUser> paramList2)
  {
    if (paramList2 != null)
    {
      if (paramList2.isEmpty()) {
        return paramList1;
      }
      paramList2 = paramList2.iterator();
      while (paramList2.hasNext())
      {
        RecentUser localRecentUser1 = (RecentUser)paramList2.next();
        int m = 0;
        Iterator localIterator = paramList1.iterator();
        while (localIterator.hasNext())
        {
          RecentUser localRecentUser2 = (RecentUser)localIterator.next();
          if ((localRecentUser1.getType() == localRecentUser2.getType()) && (localRecentUser2.uin.equals(localRecentUser1.uin))) {
            m = 1;
          }
        }
        if (m == 0) {
          paramList1.add(localRecentUser1);
        }
      }
    }
    return paramList1;
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, Intent paramIntent)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.putExtra("FromType", paramInt1);
    localIntent.putExtra("should_restore_from_kill", false);
    PublicFragmentActivity.a((Activity)paramContext, localIntent, HiddenChatFragment.class, paramInt2);
  }
  
  private void a(List<RecentBaseData> paramList)
  {
    Object localObject = this.c;
    if ((localObject != null) && (((DragFrameLayout)localObject).getMode() == -1) && (getBaseActivity() != null))
    {
      if (getBaseActivity().getIntent() == null) {
        return;
      }
      localObject = this.b;
      if (localObject != null)
      {
        int m = 0;
        int n = 0;
        ((RecentAdapter)localObject).a(0);
        this.b.a(paramList);
        int i2 = getBaseActivity().getIntent().getIntExtra("FromType", 0);
        if (paramList != null)
        {
          paramList = paramList.iterator();
          int i1 = 0;
          m = n;
          n = i1;
          while (paramList.hasNext()) {
            if (((RecentBaseData)paramList.next()).getRecentUserType() == 1) {
              m += 1;
            } else {
              n += 1;
            }
          }
        }
        else
        {
          n = 0;
        }
        paramList = getBaseActivity().app;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(m);
        ReportController.b(paramList, "dc00898", "", "", "0X800A34B", "0X800A34B", i2, n, ((StringBuilder)localObject).toString(), "0", "", "");
      }
    }
  }
  
  private boolean a(RecentBaseData paramRecentBaseData, boolean paramBoolean, RecentUserProxy paramRecentUserProxy, String paramString)
  {
    Object localObject = (TroopManager)this.h.getManager(QQManagerFactory.TROOP_MANAGER);
    String str = ((TroopManager)localObject).v(paramRecentBaseData.getRecentUserUin());
    boolean bool2 = TextUtils.isEmpty(str);
    boolean bool1 = false;
    if (!bool2)
    {
      if (!((ITroopCommonlyUsedHandler)this.h.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopCommonlyUsedHandlerName())).a(str, paramBoolean ^ true)) {
        return true;
      }
      paramRecentUserProxy = ((TroopManager)localObject).g(paramRecentBaseData.getRecentUserUin());
      if (paramRecentUserProxy != null)
      {
        m = paramRecentUserProxy.troopmask;
        if ((m != 1) && (m == 4))
        {
          m = 3;
          break label123;
        }
      }
      m = 0;
      label123:
      paramRecentUserProxy = new ReportTask(this.h).a("P_CliOper").b("Grp_msg").c("Msglist").d("Clk_top_right");
      paramString = paramRecentBaseData.getRecentUserUin();
      if (paramBoolean) {
        paramRecentBaseData = "0";
      } else {
        paramRecentBaseData = "1";
      }
      paramRecentUserProxy.a(new String[] { paramString, String.valueOf(m), paramRecentBaseData }).a();
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.e("tag_hidden_chat", 2, "TroopManage.getTroopCodeByTroopUin return null...");
    }
    int m = paramRecentBaseData.getRecentUserType();
    if ((paramString != null) && (paramString.length() != 0) && (paramRecentUserProxy != null))
    {
      localObject = paramRecentUserProxy.c(paramString, m);
      paramRecentBaseData = (RecentBaseData)localObject;
      if (localObject == null) {
        paramRecentBaseData = new RecentUser(paramString, m);
      }
      if (((IHotChatUtil)QRoute.api(IHotChatUtil.class)).checkIsHCRecentUser(this.h, paramRecentBaseData))
      {
        if (paramBoolean) {
          paramRecentBaseData.showUpTime = (System.currentTimeMillis() / 1000L);
        } else {
          paramRecentBaseData.showUpTime = 0L;
        }
        paramRecentUserProxy.b(paramRecentBaseData);
        b();
      }
      return false;
    }
    if (QLog.isColorLevel())
    {
      paramRecentBaseData = new StringBuilder();
      paramRecentBaseData.append("onMenuItemClick error, %s ");
      if (paramString == null) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramRecentBaseData.append(paramBoolean);
      paramRecentBaseData.append(" ");
      paramBoolean = bool1;
      if (paramRecentUserProxy == null) {
        paramBoolean = true;
      }
      paramRecentBaseData.append(paramBoolean);
      QLog.d("tag_hidden_chat", 2, paramRecentBaseData.toString());
    }
    return true;
  }
  
  protected MiniMsgUserParam a()
  {
    Object localObject = getBaseActivity().getApplication().getResources().getDrawable(2130841878);
    int i2 = (int)this.rightViewText.getPaint().measureText(this.rightViewText.getText().toString());
    int m = getBaseActivity().getApplication().getResources().getDisplayMetrics().widthPixels;
    int n = ImmersiveUtils.getStatusBarHeight(getBaseActivity());
    int i1 = ViewUtils.dpToPx(16.0F);
    i2 = (ViewUtils.dpToPx(52.0F) - i2) / 2;
    int i3 = ViewUtils.dpToPx(56.0F);
    int i4 = ((Drawable)localObject).getIntrinsicWidth();
    int i5 = ViewUtils.dip2px(5.0F);
    localObject = new MiniMsgUserParam();
    ((MiniMsgUserParam)localObject).businessName = 24;
    ((MiniMsgUserParam)localObject).accessType = 0;
    ((MiniMsgUserParam)localObject).entryType = 1;
    ((MiniMsgUserParam)localObject).positionX = (m - (i1 - i2) - i3 - i4);
    ((MiniMsgUserParam)localObject).positionY = (n + i5);
    ((MiniMsgUserParam)localObject).colorType = 1;
    ((MiniMsgUserParam)localObject).filterMsgType = 1;
    return localObject;
  }
  
  protected void a(int paramInt, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    RecentUserProxy localRecentUserProxy = this.h.getProxyManager().g();
    paramString = paramRecentBaseData.getRecentUserUin();
    FriendsManager localFriendsManager = (FriendsManager)this.h.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (paramInt == 5000)
    {
      paramString = this.j;
      if (paramString != null) {
        paramString.a(paramRecentBaseData, paramBoolean);
      }
    }
    else if (paramInt == 5001)
    {
      ((HotChatCenterManager)this.h.getManager(QQManagerFactory.HOTCHAT_CENTER_MANAGER)).a(paramBoolean);
    }
    else if (paramInt == 1)
    {
      if (!a(paramRecentBaseData, paramBoolean, localRecentUserProxy, paramString)) {}
    }
    else if ((paramInt == 0) && (localFriendsManager.n(paramString)))
    {
      paramRecentBaseData = this.h;
      int m;
      if (paramBoolean) {
        m = 1;
      } else {
        m = 2;
      }
      ReportController.b(paramRecentBaseData, "CliOper", "", "", "0X8009DCE", "0X8009DCE", 0, m, "0", "0", "", "");
      if (!NetworkUtil.isNetworkAvailable(this.h.getApp().getApplicationContext()))
      {
        QQToast.makeText(getBaseActivity(), 1, 2131893879, 0).show(getBaseActivity().getTitleBarHeight());
        return;
      }
      if (QLog.isColorLevel())
      {
        paramRecentBaseData = new StringBuilder();
        paramRecentBaseData.append("setChatAtTop top: ");
        paramRecentBaseData.append(paramBoolean);
        paramRecentBaseData.append(" uin: ");
        paramRecentBaseData.append(paramString);
        paramRecentBaseData.append(" userType: ");
        paramRecentBaseData.append(paramInt);
        QLog.d("tag_hidden_chat", 2, paramRecentBaseData.toString());
      }
      FriendsStatusUtil.a(this.h, paramString, paramBoolean);
    }
    ReportController.b(this.h, "dc00898", "", "", "0X800A353", "0X800A353", 0, 0, "0", "0", "", "");
  }
  
  void b()
  {
    HiddenChatFragment.1 local1 = new HiddenChatFragment.1(this);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      MqqHandler localMqqHandler = this.f;
      if (localMqqHandler != null) {
        localMqqHandler.post(local1);
      }
    }
    else if (this.f != null)
    {
      local1.run();
    }
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.f = new MqqHandler(ThreadManagerV2.getRecentThreadLooper(), this);
    this.g = new MqqHandler(Looper.getMainLooper(), this);
    if ((getBaseActivity().getAppRuntime() instanceof QQAppInterface))
    {
      this.h = ((QQAppInterface)getQBaseActivity().getAppRuntime());
      this.h.addObserver(this.e);
      this.h.addObserver(this.k);
      this.h.addObserver(this.l);
      this.h.getMessageFacade().addObserver(this);
      this.h.setHandler(HiddenChatSettingFragment.class, this.f);
    }
    if (FrameHelperActivity.G())
    {
      FrameHelperActivity.c(true);
      FrameHelperActivity.H();
    }
    this.i = new HiddenChatComparator(this.h);
    this.a = ((XListView)this.mContentView.findViewById(2131435037));
    this.b = new RecentAdapter(getBaseActivity(), getBaseActivity().app, this.a, this, 0);
    this.b.a(0);
    this.a.setAdapter(this.b);
    if (this.c == null)
    {
      this.c = DragFrameLayout.a(getBaseActivity());
      this.c.a(this, false);
    }
    this.b.a(this.c);
    setTitle(getString(2131894125));
    this.rightViewText.setText(2131916361);
    this.rightViewText.setVisibility(0);
    this.rightViewText.setOnClickListener(this);
    paramLayoutInflater = a();
    this.d = new MiniMsgUser(getBaseActivity(), paramLayoutInflater);
  }
  
  protected int getContentLayoutId()
  {
    return 2131629155;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((getBaseActivity() != null) && (getBaseActivity().app.isLogin()))
    {
      int m = paramMessage.what;
      if (m != 1)
      {
        if (m != 2) {
          return true;
        }
        a((List)paramMessage.obj);
        return true;
      }
      b();
      return true;
    }
    return false;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    boolean bool = super.onBackEvent();
    HiddenChatHelper.a(getBaseActivity(), PermissionPrivacyFragment.class);
    return bool;
  }
  
  public void onChange(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    paramDragFrameLayout = this.c;
    if ((paramDragFrameLayout != null) && (paramDragFrameLayout.getMode() == -1))
    {
      b();
      ReportController.b(getBaseActivity().app, "dc00898", "", "", "0X800A354", "0X800A354", 0, 0, "", "0", "", "");
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.rightViewText) {
      HiddenChatSettingFragment.a(getBaseActivity(), 0);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onClick(View paramView, Object paramObject) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.c;
    if (localObject != null) {
      ((DragFrameLayout)localObject).a(this);
    }
    localObject = this.b;
    if (localObject != null) {
      ((RecentAdapter)localObject).h();
    }
    localObject = this.a;
    if (localObject != null) {
      ((XListView)localObject).setAdapter(null);
    }
    this.h.removeObserver(this.e);
    this.h.removeObserver(this.k);
    this.h.removeObserver(this.l);
    this.h.getMessageFacade().deleteObserver(this);
    this.h.removeHandler(HiddenChatSettingFragment.class);
    this.b = null;
    localObject = this.d;
    if (localObject != null)
    {
      ((MiniMsgUser)localObject).destroy();
      this.d = null;
    }
    MiniMsgIPCClient.getInstance().clearBusiness(24);
    localObject = this.f;
    if (localObject != null) {
      ((MqqHandler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.g;
    if (localObject != null) {
      ((MqqHandler)localObject).removeCallbacksAndMessages(null);
    }
  }
  
  public void onMenuItemClick(String paramString1, RecentBaseData paramRecentBaseData, String paramString2)
  {
    Resources localResources = getResources();
    int m = paramRecentBaseData.getRecentUserType();
    if ((m == 1) && (this.j == null)) {
      this.j = new RecentTroopMenuOption(this.h, getBaseActivity());
    }
    if (Utils.a(paramString1, localResources.getString(2131888206))) {
      a(m, paramRecentBaseData, paramString2, false);
    } else if (Utils.a(paramString1, localResources.getString(2131888211))) {
      a(m, paramRecentBaseData, paramString2, true);
    } else if (Utils.a(paramString1, localResources.getString(2131890181))) {
      a(m, paramRecentBaseData, paramString2, false);
    } else if (Utils.a(paramString1, localResources.getString(2131890183))) {
      a(m, paramRecentBaseData, paramString2, true);
    }
    if (Utils.a(paramString1, localResources.getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.c[4])))
    {
      if ((paramRecentBaseData instanceof RecentUserBaseData))
      {
        paramString2 = (RecentUserBaseData)paramRecentBaseData;
        RecentUtil.a(this.h, paramString2.e(), true, true);
        b();
      }
    }
    else if ((Utils.a(paramString1, localResources.getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.c[5]))) && ((paramRecentBaseData instanceof RecentUserBaseData)))
    {
      paramString2 = ((RecentUserBaseData)paramRecentBaseData).e();
      this.h.getConversationFacade().b(paramString2.uin, paramString2.getType(), 1);
      b();
    }
    if (Utils.a(paramString1, localResources.getString(2131888205)))
    {
      if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        QQToast.makeText(BaseApplication.getContext(), 2131889169, 1, 0).show(getBaseActivity().getTitleBarHeight());
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("tag_hidden_chat", 2, "onMenuItemClick mHiddenChat cancel hide");
      }
      paramString1 = paramRecentBaseData.getRecentUserUin();
      if (m == 1)
      {
        m = (int)NetConnInfoCenter.getServerTime();
        ((ITroopSettingHandler)getBaseActivity().app.getBusinessHandler(BusinessHandlerFactory.TROOP_SETTING_HANDLER)).a(paramString1, getBaseActivity().app.getCurrentUin(), 0, 512, m);
        return;
      }
      if (m == 0) {
        ((FriendListHandler)getBaseActivity().app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).setHiddenChat(new String[] { paramString1 }, new boolean[] { false }, new int[] { m });
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    MiniMsgUser localMiniMsgUser = this.d;
    if (localMiniMsgUser != null) {
      localMiniMsgUser.onBackground();
    }
  }
  
  public void onRecentBaseDataClick(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    if ((!(paramRecentBaseData instanceof RecentUserBaseData)) && (QLog.isColorLevel())) {
      QLog.d("tag_hidden_chat", 2, "NOT THE RIGHT Recent type");
    }
    paramView = ((RecentUserBaseData)paramRecentBaseData).e();
    Bundle localBundle = new Bundle();
    localBundle.putInt("hidden_aio_msg_source", 1);
    RecentUtil.a(getBaseActivity(), this.h, paramView, paramString, paramBoolean, 0, paramRecentBaseData, localBundle, null);
    getBaseActivity().overridePendingTransition(2130772009, 2130772010);
    paramRecentBaseData.clearUnReadNum();
    NotifyIdManager.a(this.h).c(paramRecentBaseData.getRecentUserUin());
    if (paramView != null)
    {
      paramRecentBaseData = (FeedsManager)this.h.getManager(QQManagerFactory.QZONE_NEW_STATUS_MANAGER);
      paramRecentBaseData.setFeedInfoRead(paramView.uin);
      if (FeedsManager.isShowStatus(paramView.uin))
      {
        paramString = (BeancurdManager)this.h.getManager(QQManagerFactory.BEANCURD_MANAGER);
        if (paramString != null)
        {
          long l1 = paramString.b(paramView.uin);
          FeedsManager.saveToken(paramView.uin, l1);
          paramRecentBaseData.reportClickExpose();
          paramString.a(2, 2);
        }
      }
      else
      {
        paramView = this.h.getMessageFacade().r(paramView.uin, paramView.getType());
        if ((paramView != null) && (paramView.msgtype == -1034))
        {
          paramView = (BeancurdManager)this.h.getManager(QQManagerFactory.BEANCURD_MANAGER);
          if (paramView != null) {
            paramView.a(2, 1);
          }
        }
      }
    }
  }
  
  public void onRecentBaseDataDelete(RecentBaseData paramRecentBaseData, String paramString)
  {
    if (paramRecentBaseData == null) {
      return;
    }
    paramString = null;
    int m = -1;
    if ((paramRecentBaseData instanceof RecentUserBaseData))
    {
      RecentUserBaseData localRecentUserBaseData = (RecentUserBaseData)paramRecentBaseData;
      paramString = localRecentUserBaseData.e();
      m = localRecentUserBaseData.mPosition;
    }
    if (paramString != null)
    {
      RecentReportHelper.a(this.h, paramRecentBaseData, paramString);
      RecentUtil.a(this.h, paramString, m);
      TroopAssistantManager.a().b(paramString.uin, this.h);
    }
    b();
    ReportController.b(this.h, "dc00898", "", "", "0X800A352", "0X800A352", 0, 0, "0", "0", "", "");
  }
  
  public void onResume()
  {
    super.onResume();
    b();
    MiniMsgUser localMiniMsgUser = this.d;
    if (localMiniMsgUser != null) {
      localMiniMsgUser.onForeground();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    MiniMsgUser localMiniMsgUser = this.d;
    if ((localMiniMsgUser != null) && (paramBoolean)) {
      localMiniMsgUser.showEntry();
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if (!HiddenChatHelper.a(paramObservable.frienduin, paramObservable.istroop, this.h)) {
        return;
      }
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.hiddenchat.HiddenChatFragment
 * JD-Core Version:    0.7.0.1
 */