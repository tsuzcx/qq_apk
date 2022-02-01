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
import com.tencent.mobileqq.fragment.QQSettingChatOperationFragment;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.api.IHotChatUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.settings.fragment.PermissionPrivacyFragment;
import com.tencent.mobileqq.settings.util.PrivacySettingUtil;
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
  MiniMsgUser jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser;
  RecentAdapter jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter;
  private RecentTroopMenuOption jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption;
  DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new HiddenChatFragment.4(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HiddenChatComparator jdField_a_of_type_ComTencentMobileqqAppHiddenchatHiddenChatComparator;
  protected TroopCommonlyUsedObserver a;
  private TroopSettingObserver jdField_a_of_type_ComTencentMobileqqTroopTroopsettingApiTroopSettingObserver = new HiddenChatFragment.3(this);
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private MqqHandler b;
  
  public HiddenChatFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopCommonlyUsedObserver = new HiddenChatFragment.2(this);
  }
  
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
        int i = 0;
        Iterator localIterator = paramList1.iterator();
        while (localIterator.hasNext())
        {
          RecentUser localRecentUser2 = (RecentUser)localIterator.next();
          if ((localRecentUser1.getType() == localRecentUser2.getType()) && (localRecentUser2.uin.equals(localRecentUser1.uin))) {
            i = 1;
          }
        }
        if (i == 0) {
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
    if ((localObject != null) && (((DragFrameLayout)localObject).a() == -1) && (getBaseActivity() != null))
    {
      if (getBaseActivity().getIntent() == null) {
        return;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter;
      if (localObject != null)
      {
        int i = 0;
        int j = 0;
        ((RecentAdapter)localObject).a(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(paramList);
        int m = getBaseActivity().getIntent().getIntExtra("FromType", 0);
        if (paramList != null)
        {
          paramList = paramList.iterator();
          int k = 0;
          i = j;
          j = k;
          while (paramList.hasNext()) {
            if (((RecentBaseData)paramList.next()).getRecentUserType() == 1) {
              i += 1;
            } else {
              j += 1;
            }
          }
        }
        else
        {
          j = 0;
        }
        paramList = getBaseActivity().app;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(i);
        ReportController.b(paramList, "dc00898", "", "", "0X800A34B", "0X800A34B", m, j, ((StringBuilder)localObject).toString(), "0", "", "");
      }
    }
  }
  
  private boolean a(RecentBaseData paramRecentBaseData, boolean paramBoolean, RecentUserProxy paramRecentUserProxy, String paramString)
  {
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    String str = ((TroopManager)localObject).d(paramRecentBaseData.getRecentUserUin());
    boolean bool2 = TextUtils.isEmpty(str);
    boolean bool1 = false;
    if (!bool2)
    {
      if (!((ITroopCommonlyUsedHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopCommonlyUsedHandlerName())).a(str, paramBoolean ^ true)) {
        return true;
      }
      paramRecentUserProxy = ((TroopManager)localObject).c(paramRecentBaseData.getRecentUserUin());
      if (paramRecentUserProxy != null)
      {
        i = paramRecentUserProxy.troopmask;
        if ((i != 1) && (i == 4))
        {
          i = 3;
          break label123;
        }
      }
      i = 0;
      label123:
      paramRecentUserProxy = new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("P_CliOper").b("Grp_msg").c("Msglist").d("Clk_top_right");
      paramString = paramRecentBaseData.getRecentUserUin();
      if (paramBoolean) {
        paramRecentBaseData = "0";
      } else {
        paramRecentBaseData = "1";
      }
      paramRecentUserProxy.a(new String[] { paramString, String.valueOf(i), paramRecentBaseData }).a();
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.e("tag_hidden_chat", 2, "TroopManage.getTroopCodeByTroopUin return null...");
    }
    int i = paramRecentBaseData.getRecentUserType();
    if ((paramString != null) && (paramString.length() != 0) && (paramRecentUserProxy != null))
    {
      localObject = paramRecentUserProxy.b(paramString, i);
      paramRecentBaseData = (RecentBaseData)localObject;
      if (localObject == null) {
        paramRecentBaseData = new RecentUser(paramString, i);
      }
      if (((IHotChatUtil)QRoute.api(IHotChatUtil.class)).checkIsHCRecentUser(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData))
      {
        if (paramBoolean) {
          paramRecentBaseData.showUpTime = (System.currentTimeMillis() / 1000L);
        } else {
          paramRecentBaseData.showUpTime = 0L;
        }
        paramRecentUserProxy.b(paramRecentBaseData);
        a();
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
    Object localObject = getBaseActivity().getApplication().getResources().getDrawable(2130841087);
    int m = (int)this.rightViewText.getPaint().measureText(this.rightViewText.getText().toString());
    int i = getBaseActivity().getApplication().getResources().getDisplayMetrics().widthPixels;
    int j = ImmersiveUtils.getStatusBarHeight(getBaseActivity());
    int k = ViewUtils.b(16.0F);
    m = (ViewUtils.b(52.0F) - m) / 2;
    int n = ViewUtils.b(56.0F);
    int i1 = ((Drawable)localObject).getIntrinsicWidth();
    int i2 = ViewUtils.a(5.0F);
    localObject = new MiniMsgUserParam();
    ((MiniMsgUserParam)localObject).businessName = 24;
    ((MiniMsgUserParam)localObject).accessType = 0;
    ((MiniMsgUserParam)localObject).entryType = 1;
    ((MiniMsgUserParam)localObject).positionX = (i - (k - m) - n - i1);
    ((MiniMsgUserParam)localObject).positionY = (j + i2);
    ((MiniMsgUserParam)localObject).colorType = 1;
    ((MiniMsgUserParam)localObject).filterMsgType = 1;
    return localObject;
  }
  
  void a()
  {
    HiddenChatFragment.1 local1 = new HiddenChatFragment.1(this);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      MqqHandler localMqqHandler = this.jdField_a_of_type_MqqOsMqqHandler;
      if (localMqqHandler != null) {
        localMqqHandler.post(local1);
      }
    }
    else if (this.jdField_a_of_type_MqqOsMqqHandler != null)
    {
      local1.run();
    }
  }
  
  protected void a(int paramInt, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    RecentUserProxy localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    paramString = paramRecentBaseData.getRecentUserUin();
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (paramInt == 5000)
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption;
      if (paramString != null) {
        paramString.a(paramRecentBaseData, paramBoolean);
      }
    }
    else if (paramInt == 5001)
    {
      ((HotChatCenterManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOTCHAT_CENTER_MANAGER)).a(paramBoolean);
    }
    else if (paramInt == 1)
    {
      if (!a(paramRecentBaseData, paramBoolean, localRecentUserProxy, paramString)) {}
    }
    else if ((paramInt == 0) && (localFriendsManager.b(paramString)))
    {
      paramRecentBaseData = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      int i;
      if (paramBoolean) {
        i = 1;
      } else {
        i = 2;
      }
      ReportController.b(paramRecentBaseData, "CliOper", "", "", "0X8009DCE", "0X8009DCE", 0, i, "0", "0", "", "");
      if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext()))
      {
        QQToast.a(getBaseActivity(), 1, 2131696114, 0).b(getBaseActivity().getTitleBarHeight());
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
      FriendsStatusUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramBoolean);
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A353", "0X800A353", 0, 0, "0", "0", "", "");
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(ThreadManagerV2.getRecentThreadLooper(), this);
    this.b = new MqqHandler(Looper.getMainLooper(), this);
    if ((getBaseActivity().getAppRuntime() instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getQBaseActivity().getAppRuntime());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopCommonlyUsedObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingApiTroopSettingObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addObserver(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(HiddenChatSettingFragment.class, this.jdField_a_of_type_MqqOsMqqHandler);
    }
    if (FrameHelperActivity.b())
    {
      FrameHelperActivity.b(true);
      FrameHelperActivity.w();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppHiddenchatHiddenChatComparator = new HiddenChatComparator(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.mContentView.findViewById(2131368176));
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = new RecentAdapter(getBaseActivity(), getBaseActivity().app, this.jdField_a_of_type_ComTencentWidgetXListView, this, 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.a(getBaseActivity());
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
    setTitle(getString(2131696353));
    this.rightViewText.setText(2131718832);
    this.rightViewText.setVisibility(0);
    this.rightViewText.setOnClickListener(this);
    paramLayoutInflater = a();
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser = new MiniMsgUser(getBaseActivity(), paramLayoutInflater);
  }
  
  protected int getContentLayoutId()
  {
    return 2131562721;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((getBaseActivity() != null) && (getBaseActivity().app.isLogin()))
    {
      int i = paramMessage.what;
      if (i != 1)
      {
        if (i != 2) {
          return true;
        }
        a((List)paramMessage.obj);
        return true;
      }
      a();
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
    Object localObject;
    if (PrivacySettingUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      localObject = PermissionPrivacyFragment.class;
    } else {
      localObject = QQSettingChatOperationFragment.class;
    }
    HiddenChatHelper.a(getBaseActivity(), (Class)localObject);
    return bool;
  }
  
  public void onChange(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    paramDragFrameLayout = this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
    if ((paramDragFrameLayout != null) && (paramDragFrameLayout.a() == -1))
    {
      a();
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
    if (localObject != null) {
      ((DragFrameLayout)localObject).a(this);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter;
    if (localObject != null) {
      ((RecentAdapter)localObject).b();
    }
    localObject = this.jdField_a_of_type_ComTencentWidgetXListView;
    if (localObject != null) {
      ((XListView)localObject).setAdapter(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopCommonlyUsedObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingApiTroopSettingObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().deleteObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(HiddenChatSettingFragment.class);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = null;
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser;
    if (localObject != null)
    {
      ((MiniMsgUser)localObject).destroy();
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser = null;
    }
    MiniMsgIPCClient.getInstance().clearBusiness(24);
    localObject = this.jdField_a_of_type_MqqOsMqqHandler;
    if (localObject != null) {
      ((MqqHandler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.b;
    if (localObject != null) {
      ((MqqHandler)localObject).removeCallbacksAndMessages(null);
    }
  }
  
  public void onMenuItemClick(String paramString1, RecentBaseData paramRecentBaseData, String paramString2)
  {
    Resources localResources = getResources();
    int i = paramRecentBaseData.getRecentUserType();
    if ((i == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption == null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption = new RecentTroopMenuOption(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getBaseActivity());
    }
    if (Utils.a(paramString1, localResources.getString(2131691260))) {
      a(i, paramRecentBaseData, paramString2, false);
    } else if (Utils.a(paramString1, localResources.getString(2131691263))) {
      a(i, paramRecentBaseData, paramString2, true);
    } else if (Utils.a(paramString1, localResources.getString(2131693067))) {
      a(i, paramRecentBaseData, paramString2, false);
    } else if (Utils.a(paramString1, localResources.getString(2131693069))) {
      a(i, paramRecentBaseData, paramString2, true);
    }
    if (Utils.a(paramString1, localResources.getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.a[4])))
    {
      if ((paramRecentBaseData instanceof RecentUserBaseData))
      {
        paramString2 = (RecentUserBaseData)paramRecentBaseData;
        RecentUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2.a(), true, true);
        a();
      }
    }
    else if ((Utils.a(paramString1, localResources.getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.a[5]))) && ((paramRecentBaseData instanceof RecentUserBaseData)))
    {
      paramString2 = ((RecentUserBaseData)paramRecentBaseData).a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(paramString2.uin, paramString2.getType(), 1);
      a();
    }
    if (Utils.a(paramString1, localResources.getString(2131691259)))
    {
      if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        QQToast.a(BaseApplication.getContext(), 2131692183, 1, 0).b(getBaseActivity().getTitleBarHeight());
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("tag_hidden_chat", 2, "onMenuItemClick mHiddenChat cancel hide");
      }
      paramString1 = paramRecentBaseData.getRecentUserUin();
      if (i == 1)
      {
        i = (int)NetConnInfoCenter.getServerTime();
        ((ITroopSettingHandler)getBaseActivity().app.getBusinessHandler(BusinessHandlerFactory.TROOP_SETTING_HANDLER)).a(paramString1, getBaseActivity().app.getCurrentUin(), 0, 512, i);
        return;
      }
      if (i == 0) {
        ((FriendListHandler)getBaseActivity().app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).setHiddenChat(new String[] { paramString1 }, new boolean[] { false }, new int[] { i });
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    MiniMsgUser localMiniMsgUser = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser;
    if (localMiniMsgUser != null) {
      localMiniMsgUser.onBackground();
    }
  }
  
  public void onRecentBaseDataClick(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    if ((!(paramRecentBaseData instanceof RecentUserBaseData)) && (QLog.isColorLevel())) {
      QLog.d("tag_hidden_chat", 2, "NOT THE RIGHT Recent type");
    }
    paramView = ((RecentUserBaseData)paramRecentBaseData).a();
    Bundle localBundle = new Bundle();
    localBundle.putInt("hidden_aio_msg_source", 1);
    RecentUtil.a(getBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, paramString, paramBoolean, 0, paramRecentBaseData, localBundle, null);
    getBaseActivity().overridePendingTransition(2130772006, 2130772007);
    paramRecentBaseData.clearUnReadNum();
    NotifyIdManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(paramRecentBaseData.getRecentUserUin());
    if (paramView != null)
    {
      paramRecentBaseData = (FeedsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QZONE_NEW_STATUS_MANAGER);
      paramRecentBaseData.setFeedInfoRead(paramView.uin);
      if (FeedsManager.isShowStatus(paramView.uin))
      {
        paramString = (BeancurdManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER);
        if (paramString != null)
        {
          long l = paramString.a(paramView.uin);
          FeedsManager.saveToken(paramView.uin, l);
          paramRecentBaseData.reportClickExpose();
          paramString.a(2, 2);
        }
      }
      else
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(paramView.uin, paramView.getType());
        if ((paramView != null) && (paramView.msgtype == -1034))
        {
          paramView = (BeancurdManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER);
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
    int i = -1;
    if ((paramRecentBaseData instanceof RecentUserBaseData))
    {
      RecentUserBaseData localRecentUserBaseData = (RecentUserBaseData)paramRecentBaseData;
      paramString = localRecentUserBaseData.a();
      i = localRecentUserBaseData.mPosition;
    }
    if (paramString != null)
    {
      RecentReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData, paramString);
      RecentUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, i);
      TroopAssistantManager.a().b(paramString.uin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    a();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A352", "0X800A352", 0, 0, "0", "0", "", "");
  }
  
  public void onResume()
  {
    super.onResume();
    a();
    MiniMsgUser localMiniMsgUser = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser;
    if (localMiniMsgUser != null) {
      localMiniMsgUser.onForeground();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    MiniMsgUser localMiniMsgUser = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser;
    if ((localMiniMsgUser != null) && (paramBoolean)) {
      localMiniMsgUser.showEntry();
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if (!HiddenChatHelper.a(paramObservable.frienduin, paramObservable.istroop, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        return;
      }
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.hiddenchat.HiddenChatFragment
 * JD-Core Version:    0.7.0.1
 */