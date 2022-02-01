package com.tencent.mobileqq.app.hiddenchat;

import adab;
import aggr;
import aguy;
import alml;
import alms;
import aloy;
import alpa;
import alpb;
import alpv;
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
import antz;
import anua;
import anyu;
import anyw;
import anzm;
import aoip;
import aojs;
import aoqy;
import aoqz;
import aora;
import aorb;
import apaw;
import axan;
import axug;
import bdll;
import bdlq;
import bhjx;
import bhnv;
import bhtq;
import blhw;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.miniaio.MiniMsgIPCClient;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.FeedsManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.fragment.QQSettingChatOperationFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.os.MqqHandler;

public class HiddenChatFragment
  extends IphoneTitleBarFragment
  implements alml, alpv, Handler.Callback, View.OnClickListener, Observer
{
  alms jdField_a_of_type_Alms;
  private alpa jdField_a_of_type_Alpa;
  protected anua a;
  private anyu jdField_a_of_type_Anyu = new aorb(this);
  private aojs jdField_a_of_type_Aojs = new aora(this);
  private aoqy jdField_a_of_type_Aoqy;
  MiniMsgUser jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser;
  DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private MqqHandler b;
  
  public HiddenChatFragment()
  {
    this.jdField_a_of_type_Anua = new aoqz(this);
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
    while (this.jdField_a_of_type_Alms == null) {
      return;
    }
    this.jdField_a_of_type_Alms.a(0);
    this.jdField_a_of_type_Alms.a(paramList);
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
      bdll.b(getActivity().app, "dc00898", "", "", "0X800A34B", "0X800A34B", m, j, "" + i, "0", "", "");
      return;
      j = 0;
      i = 0;
    }
  }
  
  private boolean a(RecentBaseData paramRecentBaseData, boolean paramBoolean, apaw paramapaw, String paramString)
  {
    boolean bool = false;
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    String str = ((TroopManager)localObject).d(paramRecentBaseData.getRecentUserUin());
    int i;
    if (!TextUtils.isEmpty(str))
    {
      paramapaw = (antz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22);
      if (paramBoolean) {}
      for (i = 0; !paramapaw.a(str, i); i = 1) {
        return true;
      }
      paramapaw = ((TroopManager)localObject).c(paramRecentBaseData.getRecentUserUin());
      if (paramapaw != null) {}
      switch (paramapaw.troopmask)
      {
      case 2: 
      case 3: 
      default: 
        i = 0;
        label127:
        paramapaw = new bdlq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("P_CliOper").b("Grp_msg").c("Msglist").d("Clk_top_right");
        paramString = paramRecentBaseData.getRecentUserUin();
        if (paramBoolean)
        {
          paramRecentBaseData = "0";
          label172:
          paramapaw.a(new String[] { paramString, String.valueOf(i), paramRecentBaseData }).a();
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
      break label172;
      if (QLog.isColorLevel()) {
        QLog.e("tag_hidden_chat", 2, "TroopManage.getTroopCodeByTroopUin return null...");
      }
      i = paramRecentBaseData.getRecentUserType();
      if ((paramString == null) || (paramString.length() == 0) || (paramapaw == null))
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
          if (paramapaw == null) {
            paramBoolean = true;
          }
          QLog.d("tag_hidden_chat", 2, paramBoolean);
          return true;
        }
      }
      localObject = (RecentUser)paramapaw.findRecentUser(paramString, i);
      paramRecentBaseData = (RecentBaseData)localObject;
      if (localObject == null) {
        paramRecentBaseData = new RecentUser(paramString, i);
      }
    } while (!axug.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData));
    if (paramBoolean) {}
    for (paramRecentBaseData.showUpTime = (System.currentTimeMillis() / 1000L);; paramRecentBaseData.showUpTime = 0L)
    {
      paramapaw.saveRecentUser(paramRecentBaseData);
      a();
      break;
    }
  }
  
  public void a()
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
    apaw localapaw;
    anyw localanyw;
    if (paramBoolean)
    {
      localapaw = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      paramString = paramRecentBaseData.getRecentUserUin();
      localanyw = (anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if (paramInt != 5000) {
        break label93;
      }
      if (this.jdField_a_of_type_Alpa != null) {
        this.jdField_a_of_type_Alpa.a(paramRecentBaseData, paramBoolean);
      }
    }
    for (;;)
    {
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A353", "0X800A353", 0, 0, "0", "0", "", "");
      return;
      break;
      label93:
      if (paramInt == 5001)
      {
        ((anzm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(255)).a(paramBoolean);
      }
      else if (paramInt == 1)
      {
        if (!a(paramRecentBaseData, paramBoolean, localapaw, paramString)) {}
      }
      else if ((paramInt == 0) && (localanyw.b(paramString)))
      {
        paramRecentBaseData = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (paramBoolean) {}
        for (int i = 1;; i = 2)
        {
          bdll.b(paramRecentBaseData, "CliOper", "", "", "0X8009DCE", "0X8009DCE", 0, i, "0", "0", "", "");
          if (bhnv.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext())) {
            break;
          }
          QQToast.a(getActivity(), 1, 2131695458, 0).b(getActivity().getTitleBarHeight());
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
    paramView = (RecentUser)((RecentUserBaseData)paramRecentBaseData).getRecentUser();
    Bundle localBundle = new Bundle();
    localBundle.putInt("hidden_aio_msg_source", 1);
    alpb.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, paramString, paramBoolean, 0, paramRecentBaseData, localBundle, null);
    getActivity().overridePendingTransition(2130771992, 2130771993);
    paramRecentBaseData.clearUnReadNum();
    blhw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(paramRecentBaseData.getRecentUserUin());
    if (paramView != null)
    {
      paramRecentBaseData = (FeedsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(275);
      paramRecentBaseData.setFeedInfoRead(paramView.uin);
      if (!FeedsManager.isShowStatus(paramView.uin)) {
        break label189;
      }
      paramString = (aggr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(282);
      if (paramString != null)
      {
        long l = paramString.a(paramView.uin);
        FeedsManager.saveToken(paramView.uin, l);
        paramRecentBaseData.reportClickExpose();
        paramString.a(2, 2);
      }
    }
    label189:
    do
    {
      do
      {
        return;
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView.uin, paramView.getType());
      } while ((paramView == null) || (paramView.msgtype != -1034));
      paramView = (aggr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(282);
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
      paramString = (RecentUser)localRecentUserBaseData.getRecentUser();
      i = localRecentUserBaseData.mPosition;
    }
    if (paramString != null)
    {
      aloy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData, paramString);
      alpb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, i);
      axan.a().b(paramString.uin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    a();
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A352", "0X800A352", 0, 0, "0", "0", "", "");
  }
  
  public void a(String paramString1, RecentBaseData paramRecentBaseData, String paramString2)
  {
    Resources localResources = getResources();
    int i = paramRecentBaseData.getRecentUserType();
    if ((i == 1) && (this.jdField_a_of_type_Alpa == null)) {
      this.jdField_a_of_type_Alpa = new alpa(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity());
    }
    if (bhjx.a(paramString1, localResources.getString(2131691106)))
    {
      a(i, paramRecentBaseData, paramString2, false);
      if (!bhjx.a(paramString1, localResources.getString(alnt.a[4]))) {
        break label245;
      }
      if ((paramRecentBaseData instanceof RecentUserBaseData))
      {
        paramString2 = (RecentUserBaseData)paramRecentBaseData;
        alpb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentUser)paramString2.getRecentUser(), true, true);
        a();
      }
      label117:
      if (bhjx.a(paramString1, localResources.getString(2131691105)))
      {
        if (bhnv.d(BaseApplication.getContext())) {
          break label306;
        }
        QQToast.a(BaseApplication.getContext(), 2131691989, 1, 0).b(getActivity().getTitleBarHeight());
      }
    }
    label245:
    do
    {
      return;
      if (bhjx.a(paramString1, localResources.getString(2131691109)))
      {
        a(i, paramRecentBaseData, paramString2, true);
        break;
      }
      if (bhjx.a(paramString1, localResources.getString(2131692805)))
      {
        a(i, paramRecentBaseData, paramString2, false);
        break;
      }
      if (!bhjx.a(paramString1, localResources.getString(2131692807))) {
        break;
      }
      a(i, paramRecentBaseData, paramString2, true);
      break;
      if ((!bhjx.a(paramString1, localResources.getString(alnt.a[5]))) || (!(paramRecentBaseData instanceof RecentUserBaseData))) {
        break label117;
      }
      paramString2 = (RecentUser)((RecentUserBaseData)paramRecentBaseData).getRecentUser();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString2.uin, paramString2.getType(), 1);
      a();
      break label117;
      if (QLog.isColorLevel()) {
        QLog.d("tag_hidden_chat", 2, "onMenuItemClick mHiddenChat cancel hide");
      }
      paramString1 = paramRecentBaseData.getRecentUserUin();
      if (i == 1)
      {
        i = (int)NetConnInfoCenter.getServerTime();
        ((aoip)getActivity().app.a(20)).a(paramString1, getActivity().app.c(), 0, 512, i);
        return;
      }
    } while (i != 0);
    label306:
    ((FriendListHandler)getActivity().app.a(1)).a(new String[] { paramString1 }, new boolean[] { false }, new int[] { i });
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(ThreadManagerV2.getRecentThreadLooper(), this);
    this.b = new MqqHandler(Looper.getMainLooper(), this);
    if ((getActivity().getAppRuntime() instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getActivity().getAppRuntime());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anua);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aojs);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anyu);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(HiddenChatSettingFragment.class, this.jdField_a_of_type_MqqOsMqqHandler);
    }
    if (FrameHelperActivity.b())
    {
      FrameHelperActivity.c(true);
      FrameHelperActivity.s();
    }
    this.jdField_a_of_type_Aoqy = new aoqy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.mContentView.findViewById(2131368032));
    this.jdField_a_of_type_Alms = new alms(getActivity(), getActivity().app, this.jdField_a_of_type_ComTencentWidgetXListView, this, 0);
    this.jdField_a_of_type_Alms.a(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Alms);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.a(getActivity());
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    }
    this.jdField_a_of_type_Alms.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
    setTitle(getString(2131695693));
    this.rightViewText.setText(2131717964);
    this.rightViewText.setVisibility(0);
    this.rightViewText.setOnClickListener(this);
    paramLayoutInflater = getMiniMsgUserParam();
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser = new MiniMsgUser(getActivity(), paramLayoutInflater);
  }
  
  public int getContentLayoutId()
  {
    return 2131562809;
  }
  
  public MiniMsgUserParam getMiniMsgUserParam()
  {
    Object localObject = getActivity().getApplication().getResources().getDrawable(2130841023);
    int m = (int)this.rightViewText.getPaint().measureText(this.rightViewText.getText().toString());
    int i = getActivity().getApplication().getResources().getDisplayMetrics().widthPixels;
    int j = ImmersiveUtils.getStatusBarHeight(getActivity());
    int k = bhtq.b(16.0F);
    m = (bhtq.b(52.0F) - m) / 2;
    int n = bhtq.b(56.0F);
    int i1 = ((Drawable)localObject).getIntrinsicWidth();
    int i2 = bhtq.a(5.0F);
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
    aguy.a(getActivity(), QQSettingChatOperationFragment.class);
    return bool;
  }
  
  public void onChange(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() == -1))
    {
      a();
      bdll.b(getActivity().app, "dc00898", "", "", "0X800A354", "0X800A354", 0, 0, "", "0", "", "");
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
    if (this.jdField_a_of_type_Alms != null) {
      this.jdField_a_of_type_Alms.b();
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anua);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aojs);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anyu);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(HiddenChatSettingFragment.class);
    this.jdField_a_of_type_Alms = null;
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
      if (aguy.a(paramObservable.frienduin, paramObservable.istroop, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {}
    }
    else
    {
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.hiddenchat.HiddenChatFragment
 * JD-Core Version:    0.7.0.1
 */