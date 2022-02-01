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
import android.support.v4.app.FragmentActivity;
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
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatCenterManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.TroopHandler;
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
import com.tencent.mobileqq.nearby.HotChatUtil;
import com.tencent.mobileqq.settings.fragment.PermissionPrivacyFragment;
import com.tencent.mobileqq.settings.util.PrivacySettingUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
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
  protected BizTroopObserver a;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new HiddenChatFragment.4(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopBusinessObserver jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver = new HiddenChatFragment.3(this);
  private HiddenChatComparator jdField_a_of_type_ComTencentMobileqqAppHiddenchatHiddenChatComparator;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private MqqHandler b;
  
  public HiddenChatFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new HiddenChatFragment.2(this);
  }
  
  public static List<RecentUser> a(List<RecentUser> paramList1, List<RecentUser> paramList2)
  {
    if ((paramList2 == null) || (paramList2.isEmpty())) {
      return paramList1;
    }
    paramList2 = paramList2.iterator();
    label22:
    label51:
    label120:
    label121:
    for (;;)
    {
      RecentUser localRecentUser1;
      int i;
      if (paramList2.hasNext())
      {
        localRecentUser1 = (RecentUser)paramList2.next();
        Iterator localIterator = paramList1.iterator();
        i = 0;
        if (localIterator.hasNext())
        {
          RecentUser localRecentUser2 = (RecentUser)localIterator.next();
          if ((localRecentUser1.getType() != localRecentUser2.getType()) || (!localRecentUser2.uin.equals(localRecentUser1.uin))) {
            break label120;
          }
          i = 1;
        }
      }
      for (;;)
      {
        break label51;
        if (i != 0) {
          break label121;
        }
        paramList1.add(localRecentUser1);
        break label22;
        break;
      }
    }
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
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() != -1) || (getActivity() == null) || (getActivity().getIntent() == null)) {}
    while (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(paramList);
    int m = getActivity().getIntent().getIntExtra("FromType", 0);
    int j;
    int i;
    if (paramList != null)
    {
      paramList = paramList.iterator();
      j = 0;
      i = 0;
      if (paramList.hasNext())
      {
        int k;
        if (((RecentBaseData)paramList.next()).getRecentUserType() == 1)
        {
          k = j;
          j = i + 1;
        }
        for (i = k;; i = k)
        {
          k = j;
          j = i;
          i = k;
          break;
          k = j + 1;
          j = i;
        }
      }
    }
    for (;;)
    {
      ReportController.b(getActivity().app, "dc00898", "", "", "0X800A34B", "0X800A34B", m, j, "" + i, "0", "", "");
      return;
      j = 0;
      i = 0;
    }
  }
  
  private boolean a(RecentBaseData paramRecentBaseData, boolean paramBoolean, RecentUserProxy paramRecentUserProxy, String paramString)
  {
    boolean bool = false;
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    String str = ((TroopManager)localObject).d(paramRecentBaseData.getRecentUserUin());
    int i;
    if (!TextUtils.isEmpty(str))
    {
      paramRecentUserProxy = (BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BIZ_TROOP_HANDLER);
      if (paramBoolean) {}
      for (i = 0; !paramRecentUserProxy.a(str, i); i = 1) {
        return true;
      }
      paramRecentUserProxy = ((TroopManager)localObject).c(paramRecentBaseData.getRecentUserUin());
      if (paramRecentUserProxy != null) {}
      switch (paramRecentUserProxy.troopmask)
      {
      case 2: 
      case 3: 
      default: 
        i = 0;
        label127:
        paramRecentUserProxy = new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("P_CliOper").b("Grp_msg").c("Msglist").d("Clk_top_right");
        paramString = paramRecentBaseData.getRecentUserUin();
        if (paramBoolean)
        {
          paramRecentBaseData = "0";
          label173:
          paramRecentUserProxy.a(new String[] { paramString, String.valueOf(i), paramRecentBaseData }).a();
        }
        break;
      }
    }
    do
    {
      return false;
      i = 0;
      break label127;
      i = 3;
      break label127;
      paramRecentBaseData = "1";
      break label173;
      if (QLog.isColorLevel()) {
        QLog.e("tag_hidden_chat", 2, "TroopManage.getTroopCodeByTroopUin return null...");
      }
      i = paramRecentBaseData.getRecentUserType();
      if ((paramString == null) || (paramString.length() == 0) || (paramRecentUserProxy == null))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        paramRecentBaseData = new StringBuilder().append("onMenuItemClick error, %s ");
        if (paramString == null) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          paramRecentBaseData = paramRecentBaseData.append(paramBoolean).append(" ");
          paramBoolean = bool;
          if (paramRecentUserProxy == null) {
            paramBoolean = true;
          }
          QLog.d("tag_hidden_chat", 2, paramBoolean);
          return true;
        }
      }
      localObject = paramRecentUserProxy.b(paramString, i);
      paramRecentBaseData = (RecentBaseData)localObject;
      if (localObject == null) {
        paramRecentBaseData = new RecentUser(paramString, i);
      }
    } while (!HotChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData));
    if (paramBoolean) {}
    for (paramRecentBaseData.showUpTime = (System.currentTimeMillis() / 1000L);; paramRecentBaseData.showUpTime = 0L)
    {
      paramRecentUserProxy.b(paramRecentBaseData);
      a();
      break;
    }
  }
  
  protected MiniMsgUserParam a()
  {
    Object localObject = getActivity().getApplication().getResources().getDrawable(2130841206);
    int m = (int)this.rightViewText.getPaint().measureText(this.rightViewText.getText().toString());
    int i = getActivity().getApplication().getResources().getDisplayMetrics().widthPixels;
    int j = ImmersiveUtils.getStatusBarHeight(getActivity());
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
    ((MiniMsgUserParam)localObject).positionY = (i2 + j);
    ((MiniMsgUserParam)localObject).colorType = 1;
    ((MiniMsgUserParam)localObject).filterMsgType = 1;
    return localObject;
  }
  
  void a()
  {
    HiddenChatFragment.1 local1 = new HiddenChatFragment.1(this);
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
      if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
        this.jdField_a_of_type_MqqOsMqqHandler.post(local1);
      }
    }
    while (this.jdField_a_of_type_MqqOsMqqHandler == null) {
      return;
    }
    local1.run();
  }
  
  protected void a(int paramInt, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    RecentUserProxy localRecentUserProxy;
    FriendsManager localFriendsManager;
    if (paramBoolean)
    {
      localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
      paramString = paramRecentBaseData.getRecentUserUin();
      localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (paramInt != 5000) {
        break label94;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption.a(paramRecentBaseData, paramBoolean);
      }
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A353", "0X800A353", 0, 0, "0", "0", "", "");
      return;
      break;
      label94:
      if (paramInt == 5001)
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
        if (paramBoolean) {}
        for (int i = 1;; i = 2)
        {
          ReportController.b(paramRecentBaseData, "CliOper", "", "", "0X8009DCE", "0X8009DCE", 0, i, "0", "0", "", "");
          if (NetworkUtil.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext())) {
            break;
          }
          QQToast.a(getActivity(), 1, 2131696097, 0).b(getActivity().getTitleBarHeight());
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("tag_hidden_chat", 2, "setChatAtTop top: " + paramBoolean + " uin: " + paramString + " userType: " + paramInt);
        }
        FriendsStatusUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramBoolean);
      }
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    if ((!(paramRecentBaseData instanceof RecentUserBaseData)) && (QLog.isColorLevel())) {
      QLog.d("tag_hidden_chat", 2, "NOT THE RIGHT Recent type");
    }
    paramView = ((RecentUserBaseData)paramRecentBaseData).a();
    Bundle localBundle = new Bundle();
    localBundle.putInt("hidden_aio_msg_source", 1);
    RecentUtil.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, paramString, paramBoolean, 0, paramRecentBaseData, localBundle, null);
    getActivity().overridePendingTransition(2130771994, 2130771995);
    paramRecentBaseData.clearUnReadNum();
    NotifyIdManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(paramRecentBaseData.getRecentUserUin());
    if (paramView != null)
    {
      paramRecentBaseData = (FeedsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QZONE_NEW_STATUS_MANAGER);
      paramRecentBaseData.setFeedInfoRead(paramView.uin);
      if (!FeedsManager.isShowStatus(paramView.uin)) {
        break label186;
      }
      paramString = (BeancurdManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER);
      if (paramString != null)
      {
        long l = paramString.a(paramView.uin);
        FeedsManager.saveToken(paramView.uin, l);
        paramRecentBaseData.reportClickExpose();
        paramString.a(2, 2);
      }
    }
    label186:
    do
    {
      do
      {
        return;
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(paramView.uin, paramView.getType());
      } while ((paramView == null) || (paramView.msgtype != -1034));
      paramView = (BeancurdManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER);
    } while (paramView == null);
    paramView.a(2, 1);
  }
  
  public void a(View paramView, Object paramObject) {}
  
  public void a(RecentBaseData paramRecentBaseData, String paramString)
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
  
  public void a(String paramString1, RecentBaseData paramRecentBaseData, String paramString2)
  {
    Resources localResources = getResources();
    int i = paramRecentBaseData.getRecentUserType();
    if ((i == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption == null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentTroopMenuOption = new RecentTroopMenuOption(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity());
    }
    if (Utils.a(paramString1, localResources.getString(2131691339)))
    {
      a(i, paramRecentBaseData, paramString2, false);
      if (!Utils.a(paramString1, localResources.getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.a[4]))) {
        break label242;
      }
      if ((paramRecentBaseData instanceof RecentUserBaseData))
      {
        paramString2 = (RecentUserBaseData)paramRecentBaseData;
        RecentUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2.a(), true, true);
        a();
      }
      label114:
      if (Utils.a(paramString1, localResources.getString(2131691338)))
      {
        if (NetworkUtil.d(BaseApplication.getContext())) {
          break label300;
        }
        QQToast.a(BaseApplication.getContext(), 2131692257, 1, 0).b(getActivity().getTitleBarHeight());
      }
    }
    label242:
    do
    {
      return;
      if (Utils.a(paramString1, localResources.getString(2131691342)))
      {
        a(i, paramRecentBaseData, paramString2, true);
        break;
      }
      if (Utils.a(paramString1, localResources.getString(2131693107)))
      {
        a(i, paramRecentBaseData, paramString2, false);
        break;
      }
      if (!Utils.a(paramString1, localResources.getString(2131693109))) {
        break;
      }
      a(i, paramRecentBaseData, paramString2, true);
      break;
      if ((!Utils.a(paramString1, localResources.getString(com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder.a[5]))) || (!(paramRecentBaseData instanceof RecentUserBaseData))) {
        break label114;
      }
      paramString2 = ((RecentUserBaseData)paramRecentBaseData).a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(paramString2.uin, paramString2.getType(), 1);
      a();
      break label114;
      if (QLog.isColorLevel()) {
        QLog.d("tag_hidden_chat", 2, "onMenuItemClick mHiddenChat cancel hide");
      }
      paramString1 = paramRecentBaseData.getRecentUserUin();
      if (i == 1)
      {
        i = (int)NetConnInfoCenter.getServerTime();
        ((TroopHandler)getActivity().app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a(paramString1, getActivity().app.getCurrentUin(), 0, 512, i);
        return;
      }
    } while (i != 0);
    label300:
    ((FriendListHandler)getActivity().app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).setHiddenChat(new String[] { paramString1 }, new boolean[] { false }, new int[] { i });
  }
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() == -1))
    {
      a();
      ReportController.b(getActivity().app, "dc00898", "", "", "0X800A354", "0X800A354", 0, 0, "", "0", "", "");
    }
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(ThreadManagerV2.getRecentThreadLooper(), this);
    this.b = new MqqHandler(Looper.getMainLooper(), this);
    if ((getActivity().getAppRuntime() instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getActivity().getAppRuntime());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addObserver(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(HiddenChatSettingFragment.class, this.jdField_a_of_type_MqqOsMqqHandler);
    }
    if (FrameHelperActivity.b())
    {
      FrameHelperActivity.c(true);
      FrameHelperActivity.w();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppHiddenchatHiddenChatComparator = new HiddenChatComparator(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.mContentView.findViewById(2131368425));
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = new RecentAdapter(getActivity(), getActivity().app, this.jdField_a_of_type_ComTencentWidgetXListView, this, 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.a(getActivity());
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
    setTitle(getString(2131696334));
    this.rightViewText.setText(2131719114);
    this.rightViewText.setVisibility(0);
    this.rightViewText.setOnClickListener(this);
    paramLayoutInflater = a();
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser = new MiniMsgUser(getActivity(), paramLayoutInflater);
  }
  
  public int getContentLayoutId()
  {
    return 2131562906;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((getActivity() == null) || (!getActivity().app.isLogin())) {
      return false;
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      a();
      continue;
      a((List)paramMessage.obj);
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    boolean bool = super.onBackEvent();
    if (PrivacySettingUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {}
    for (Object localObject = PermissionPrivacyFragment.class;; localObject = QQSettingChatOperationFragment.class)
    {
      HiddenChatHelper.a(getActivity(), (Class)localObject);
      return bool;
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.rightViewText) {
      HiddenChatSettingFragment.a(getActivity(), 0);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.b();
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().deleteObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(HiddenChatSettingFragment.class);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter = null;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.destroy();
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser = null;
    }
    MiniMsgIPCClient.getInstance().clearBusiness(24);
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
    if (this.b != null) {
      this.b.removeCallbacksAndMessages(null);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.onBackground();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.onForeground();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser != null) && (paramBoolean)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.showEntry();
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if (HiddenChatHelper.a(paramObservable.frienduin, paramObservable.istroop, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {}
    }
    else
    {
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.hiddenchat.HiddenChatFragment
 * JD-Core Version:    0.7.0.1
 */