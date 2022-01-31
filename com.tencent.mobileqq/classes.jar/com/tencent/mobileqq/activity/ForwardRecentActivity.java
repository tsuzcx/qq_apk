package com.tencent.mobileqq.activity;

import Wallet.PfaFriend;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.dataline.activities.LiteActivity;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.device.DeviceHeadMgr;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.utils.SmartDeviceUtil;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.qwallet.TopayManager;
import com.tencent.mobileqq.activity.qwallet.TopayManager.TopayListener;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper.GoldMsgChatState;
import com.tencent.mobileqq.adapter.ForwardRecentListAdapter;
import com.tencent.mobileqq.adapter.ForwardRecentListAdapter.DisplayData;
import com.tencent.mobileqq.adapter.ForwardRecentListAdapter.ForwardViewHolder;
import com.tencent.mobileqq.app.AutomatorObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseActivity;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardChooseFriendOption;
import com.tencent.mobileqq.forward.ForwardConstants;
import com.tencent.mobileqq.forward.ForwardH5PTVOption;
import com.tencent.mobileqq.forward.ForwardOptionBuilder;
import com.tencent.mobileqq.search.activity.ContactSearchComponentActivity;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ForwardSendPicUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialogWtihInputAndChoose;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import snr;
import sns;
import snt;
import snu;
import snv;
import snw;
import snx;
import sny;
import snz;
import soa;
import sob;
import soc;
import sod;
import soe;
import sof;

public class ForwardRecentActivity
  extends ForwardBaseActivity
  implements TopayManager.TopayListener, ForwardConstants
{
  int jdField_a_of_type_Int;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  public Uri a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new snu(this);
  View jdField_a_of_type_AndroidViewView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  private ForwardRecentListAdapter jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentListAdapter;
  private AutomatorObserver jdField_a_of_type_ComTencentMobileqqAppAutomatorObserver = new snx(this);
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new snv(this);
  private TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new snw(this);
  public ForwardBaseOption a;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  String jdField_a_of_type_JavaLangString;
  private List jdField_a_of_type_JavaUtilList;
  public boolean a;
  public int b;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public String b;
  boolean jdField_b_of_type_Boolean = false;
  public int c;
  View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  public boolean c;
  View jdField_d_of_type_AndroidViewView;
  boolean jdField_d_of_type_Boolean = false;
  View jdField_e_of_type_AndroidViewView;
  private boolean jdField_e_of_type_Boolean;
  View f;
  View g;
  View h;
  View i;
  View j;
  private View k;
  
  public ForwardRecentActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption = null;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
  }
  
  private List a(List paramList)
  {
    return this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(paramList);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131362840));
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setFitsSystemWindows(true);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(0, ImmersiveUtils.a(this), 0, 0);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131362862));
    super.findViewById(2131363245).setVisibility(8);
    super.findViewById(2131363473).setVisibility(8);
    super.findViewById(2131363474).setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131363381));
    this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.b());
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131363428));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131433015);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (AppSetting.jdField_b_of_type_Boolean) {
      AccessibilityUtil.b(this.jdField_a_of_type_AndroidWidgetTextView, Button.class.getName());
    }
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)super.findViewById(2131363507));
    if (AppSetting.jdField_b_of_type_Boolean) {
      ViewCompat.setImportantForAccessibility(this.jdField_a_of_type_ComTencentWidgetXListView, 2);
    }
    Object localObject1 = LayoutInflater.from(this);
    Object localObject2 = ((LayoutInflater)localObject1).inflate(2130971517, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    ((View)localObject2).findViewById(2131368321).setVisibility(8);
    Object localObject3 = (EditText)((View)localObject2).findViewById(2131368322);
    ((EditText)localObject3).setFocusable(false);
    ((EditText)localObject3).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    ((EditText)localObject3).setCursorVisible(false);
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView((View)localObject2);
    this.k = ((LayoutInflater)localObject1).inflate(2130968998, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    if (Build.VERSION.SDK_INT >= 9) {
      this.k.setOverScrollMode(2);
    }
    if (this.jdField_a_of_type_Int != 9501) {
      this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.k);
    }
    this.jdField_a_of_type_AndroidViewView = this.k.findViewById(2131364653);
    this.jdField_b_of_type_AndroidViewView = this.k.findViewById(2131363908);
    this.jdField_c_of_type_AndroidViewView = this.k.findViewById(2131363913);
    this.jdField_d_of_type_AndroidViewView = this.k.findViewById(2131364651);
    this.jdField_e_of_type_AndroidViewView = this.k.findViewById(2131364655);
    this.f = this.k.findViewById(2131364646);
    this.g = this.k.findViewById(2131364647);
    this.h = this.k.findViewById(2131364649);
    this.i = this.k.findViewById(2131364650);
    this.j = this.k.findViewById(2131364645);
    this.f.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.g.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.h.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.i.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.j.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_e_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (((this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.e)) || (this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.m))) && (this.jdField_e_of_type_Boolean))
    {
      localObject2 = (QQStoryManager)this.app.getManager(180);
      if ((!((QQStoryManager)localObject2).jdField_b_of_type_Boolean) || (!((QQStoryManager)localObject2).jdField_a_of_type_Boolean))
      {
        localObject3 = ((LayoutInflater)localObject1).inflate(2130968806, null);
        ((View)localObject3).setFocusable(true);
        ((TextView)((View)localObject3).findViewById(2131363838)).setText(2131435935);
        this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView((View)localObject3);
        if ((!((QQStoryManager)localObject2).jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.m)))
        {
          f();
          StoryReportor.a("plus_shoot", "exp_option", 0, 0, new String[] { "", "", "", "" });
        }
        if ((!((QQStoryManager)localObject2).jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.e))) {
          g();
        }
      }
    }
    localObject1 = ((LayoutInflater)localObject1).inflate(2130968806, null);
    ((View)localObject1).setFocusable(true);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131363838));
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131433302);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView((View)localObject1);
      if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.f)) {
        c();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.j)) {
        e();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.g)) {
        d();
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.e)) && (!this.jdField_e_of_type_Boolean)) {
        h();
      }
      if (getSharedPreferences(this.app.getCurrentAccountUin(), 0).getBoolean("forward_share_card", true)) {
        this.k.findViewById(2131364648).setVisibility(0);
      }
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131433301);
    }
  }
  
  private void a(int paramInt)
  {
    int m = 32;
    if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.b)) {
      m = 33;
    }
    paramInt = m;
    if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.h)) {
      paramInt = m | 0x100;
    }
    m = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.i)) {
      m = paramInt | 0x4;
    }
    paramInt = m;
    if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.d)) {
      paramInt = m | 0x8;
    }
    m = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.c)) {
      m = paramInt | 0x10 | 0x200000 | 0x400000;
    }
    ContactSearchComponentActivity.a(this, null, 7, m, 561243);
    ReportController.b(this.app, "CliOper", "", "", "0X8004049", "0X8004049", 0, 0, "", "", "", "");
  }
  
  private void b()
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.b)) && (!this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.c)) && (!this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.d)))
    {
      if (QLog.isColorLevel()) {
        QLog.w("ForwardOption.ForwardEntranceActivity", 2, "-->adjustEntryLayout--don't support friends, troop and discuss forward, remove mEntryHeader");
      }
      if ((!(this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption instanceof ForwardChooseFriendOption)) || (this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.l))) {
        this.jdField_a_of_type_ComTencentWidgetXListView.removeHeaderView(this.k);
      }
    }
    do
    {
      return;
      if (!this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.b))
      {
        if (QLog.isColorLevel()) {
          QLog.w("ForwardOption.ForwardEntranceActivity", 2, "-->adjustEntryLayout--don't support friends forward, set friendBtn gone");
        }
        this.f.setVisibility(8);
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.h))
      {
        if (QLog.isColorLevel()) {
          QLog.w("ForwardOption.ForwardEntranceActivity", 2, "-->adjustEntryLayout--don't support phone contacts forward, set contactBtn gone");
        }
        this.g.setVisibility(8);
        this.k.findViewById(2131364648).setVisibility(8);
      }
      if ((!this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.c)) || (this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.l)))
      {
        if (QLog.isColorLevel()) {
          QLog.w("ForwardOption.ForwardEntranceActivity", 2, "-->adjustEntryLayout--don't support discuss forward, set multiChatBtn gone");
        }
        this.i.setVisibility(8);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.n))
      {
        if (QLog.isColorLevel()) {
          QLog.w("ForwardOption.ForwardEntranceActivity", 2, "-->adjustEntryLayout--support all friend, set allFriendBtn visible");
        }
        this.j.setVisibility(0);
      }
      if ((!this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.c)) && (!this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.d)))
      {
        if (QLog.isColorLevel()) {
          QLog.w("ForwardOption.ForwardEntranceActivity", 2, "-->adjustEntryLayout--don't support troop and discuss forward, set troopDiscussionBtn gone");
        }
        this.h.setVisibility(8);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption instanceof ForwardH5PTVOption))
      {
        if ((!this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.b)) && (!this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.c)))
        {
          if (QLog.isColorLevel()) {
            QLog.w("ForwardOption.ForwardEntranceActivity", 2, "-->adjustEntryLayout--don't support friends and troop forward, set friendBtn gone");
          }
          this.f.setVisibility(8);
          this.i.setVisibility(8);
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.b))
        {
          if (QLog.isColorLevel()) {
            QLog.w("ForwardOption.ForwardEntranceActivity", 2, "-->adjustEntryLayout--don't support friends");
          }
          this.f.setVisibility(8);
          this.i.setVisibility(8);
        }
      }
    } while ((!(this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption instanceof ForwardChooseFriendOption)) || (this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.l)));
    this.i.setVisibility(0);
  }
  
  private void c()
  {
    View localView = getLayoutInflater().inflate(2130971487, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    ((ImageView)localView.findViewById(2131362719)).setBackgroundResource(2130841588);
    TextView localTextView = (TextView)localView.findViewById(2131363896);
    localTextView.setText("我的电脑");
    localTextView.setContentDescription("我的电脑");
    localView.setOnClickListener(new sny(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(localView);
    if (((RegisterProxySvcPackHandler)this.app.a(10)).f() != 0)
    {
      localView = getLayoutInflater().inflate(2130971487, this.jdField_a_of_type_ComTencentWidgetXListView, false);
      ((ImageView)localView.findViewById(2131362719)).setBackgroundResource(2130841586);
      localTextView = (TextView)localView.findViewById(2131363896);
      localTextView.setText("我的iPad");
      localTextView.setContentDescription("我的iPad");
      localView.setOnClickListener(new snz(this));
      this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(localView);
    }
  }
  
  private void d()
  {
    View localView = getLayoutInflater().inflate(2130971487, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    ((ImageView)localView.findViewById(2131362719)).setBackgroundResource(2130841578);
    ((TextView)localView.findViewById(2131363896)).setText(2131431604);
    localView.setOnClickListener(new soa(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(localView);
  }
  
  private void e()
  {
    SmartDeviceProxyMgr localSmartDeviceProxyMgr = (SmartDeviceProxyMgr)this.app.a(51);
    DeviceInfo[] arrayOfDeviceInfo;
    if (localSmartDeviceProxyMgr.a())
    {
      arrayOfDeviceInfo = localSmartDeviceProxyMgr.a();
      if ((arrayOfDeviceInfo != null) && (arrayOfDeviceInfo.length > 0)) {
        break label38;
      }
    }
    label38:
    do
    {
      return;
      arrayOfDeviceInfo = this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(arrayOfDeviceInfo);
    } while (arrayOfDeviceInfo == null);
    int n = arrayOfDeviceInfo.length;
    int m = 0;
    label60:
    DeviceInfo localDeviceInfo;
    if (m < n)
    {
      localDeviceInfo = arrayOfDeviceInfo[m];
      if (localDeviceInfo.isAdmin != 2) {
        break label87;
      }
    }
    for (;;)
    {
      m += 1;
      break label60;
      break;
      label87:
      if ((!localSmartDeviceProxyMgr.c(localDeviceInfo.din)) || (localSmartDeviceProxyMgr.a(localDeviceInfo.din, 17)))
      {
        View localView = super.getLayoutInflater().inflate(2130971487, this.jdField_a_of_type_ComTencentWidgetXListView, false);
        ((ImageView)localView.findViewById(2131362719)).setImageBitmap(DeviceHeadMgr.getInstance().getDeviceHeadByDin(String.valueOf(localDeviceInfo.din)));
        TextView localTextView = (TextView)localView.findViewById(2131363896);
        String str = SmartDeviceUtil.a(localDeviceInfo);
        localTextView.setText(str);
        localView.setOnClickListener(new sob(this, super.getResources(), localDeviceInfo, str));
        this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(localView);
      }
    }
  }
  
  private void f()
  {
    View localView = getLayoutInflater().inflate(2130971487, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    ((ImageView)localView.findViewById(2131362719)).setBackgroundResource(2130843497);
    ((TextView)localView.findViewById(2131363896)).setText(2131433294);
    localView.setOnClickListener(new soc(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(localView);
  }
  
  private void g()
  {
    View localView = getLayoutInflater().inflate(2130971487, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    ((ImageView)localView.findViewById(2131362719)).setBackgroundResource(2130844732);
    ((TextView)localView.findViewById(2131363896)).setText(2131435090);
    localView.setOnClickListener(new sod(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(localView);
  }
  
  private void h()
  {
    View localView = getLayoutInflater().inflate(2130971487, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    ((ImageView)localView.findViewById(2131362719)).setBackgroundResource(2130844732);
    ((TextView)localView.findViewById(2131363896)).setText(2131435090);
    localView.setOnClickListener(new soe(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(localView);
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new sof(this);
      IntentFilter localIntentFilter = new IntentFilter("ShareToQZoneAndFinishTheLastActivity");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
  }
  
  private void j()
  {
    int n = 0;
    Object localObject;
    if (this.app.e())
    {
      this.jdField_a_of_type_JavaUtilList = a(this.app.a().a().a(true));
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("refreshRecentList 01 forwardList size is: ");
        if (this.jdField_a_of_type_JavaUtilList != null) {
          break label228;
        }
      }
      label228:
      for (m = 0;; m = this.jdField_a_of_type_JavaUtilList.size())
      {
        QLog.i("ForwardOption.ForwardEntranceActivity", 2, m);
        if (this.jdField_a_of_type_JavaUtilList == null) {
          break label252;
        }
        localObject = new ArrayList();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          RecentUser localRecentUser = (RecentUser)localIterator.next();
          if ((localRecentUser.lFlag == 16L) || (localRecentUser.type == 10005)) {
            ((List)localObject).add(localRecentUser);
          }
          if ((localRecentUser.type == 1) && (TroopInfo.isQidianPrivateTroop(this.app, localRecentUser.uin))) {
            ((List)localObject).add(localRecentUser);
          }
          if ((this.jdField_d_of_type_Boolean) && (TextUtils.equals(localRecentUser.uin, this.app.getCurrentAccountUin()))) {
            ((List)localObject).add(localRecentUser);
          }
        }
      }
      this.jdField_a_of_type_JavaUtilList.removeAll((Collection)localObject);
      label252:
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("refreshRecentList forwardList size is: ");
        if (this.jdField_a_of_type_JavaUtilList != null) {
          break label356;
        }
      }
    }
    label356:
    for (int m = n;; m = this.jdField_a_of_type_JavaUtilList.size())
    {
      QLog.i("ForwardOption.ForwardEntranceActivity", 2, m);
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentListAdapter != null) {
        break;
      }
      localObject = new snt(this);
      if (this.jdField_a_of_type_ComTencentWidgetXListView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentListAdapter = new ForwardRecentListAdapter(this, this.app, this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_JavaUtilList, (View.OnClickListener)localObject);
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentListAdapter);
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentListAdapter.a(this.jdField_a_of_type_JavaUtilList);
  }
  
  private void k()
  {
    Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), null);
    Object localObject1 = new Bundle(this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a());
    ((Bundle)localObject1).putBoolean("PhotoConst.HANDLE_DEST_RESULT", true);
    ((Bundle)localObject1).putBoolean("PhotoConst.IS_FORWARD", true);
    ((Bundle)localObject1).putInt("PhotoConst.SEND_BUSINESS_TYPE", 1031);
    ((Bundle)localObject1).putBoolean("PicContants.NEED_COMPRESS", false);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("extra_image_sender_tag", "sessionInfo.aioAlbum");
    localIntent.putExtra("isBack2Root", false);
    localIntent.putExtras((Bundle)localObject1);
    Object localObject2 = ((Bundle)localObject1).getString("GALLERY.FORWORD_LOCAL_PATH");
    localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(localObject2);
    localObject2 = (SmartDeviceProxyMgr)this.app.a(51);
    try
    {
      bool = ((SmartDeviceProxyMgr)localObject2).a(Long.parseLong(localIntent.getStringExtra("uin")), 17);
      if (bool)
      {
        localIntent.putExtra("send_in_background", true);
        localIntent.putExtra("sIsCloudPrinter", true);
        PhotoUtils.a(this, localIntent, (ArrayList)localObject1, 0, true);
        if (NetworkUtil.a(BaseApplication.getContext()) != 0) {
          QQToast.a(this.app.getApp(), 2, 2131435089, 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131558448));
        }
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool = false;
        continue;
        PhotoUtils.a(this, localIntent, (ArrayList)localObject1, 0, false);
      }
    }
  }
  
  public void a(long paramLong, String paramString)
  {
    Object localObject = getIntent();
    if (localObject != null) {}
    for (localObject = ((Intent)localObject).getExtras();; localObject = null)
    {
      if (localObject != null) {}
      for (localObject = new Bundle((Bundle)localObject);; localObject = new Bundle())
      {
        ((Bundle)localObject).putInt("uintype", 0);
        ((Bundle)localObject).putString("uin", paramLong + "");
        if (paramString != null) {
          ((Bundle)localObject).putString("uinname", paramString);
        }
        this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.a.intValue(), (Bundle)localObject);
        this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.d();
        return;
      }
    }
  }
  
  public void a(AdapterView paramAdapterView, View paramView, long paramLong)
  {
    a("0X8007827");
    Object localObject = (ForwardRecentListAdapter.ForwardViewHolder)paramView.getTag();
    paramView = ((ForwardRecentListAdapter.ForwardViewHolder)localObject).a.a;
    if ((this.jdField_a_of_type_Boolean) && (paramView != null)) {}
    switch (paramView.type)
    {
    default: 
      if (paramView != null)
      {
        paramAdapterView = getIntent();
        if (paramAdapterView == null) {
          break label482;
        }
      }
      break;
    }
    label467:
    label482:
    for (paramAdapterView = paramAdapterView.getExtras();; paramAdapterView = null)
    {
      if (paramAdapterView != null)
      {
        paramAdapterView = new Bundle(paramAdapterView);
        label107:
        paramAdapterView.putInt("uintype", paramView.type);
        paramAdapterView.putString("uin", paramView.uin);
        paramAdapterView.putString("troop_uin", paramView.troopUin);
        if (paramView.type != 3000) {
          break label467;
        }
        paramAdapterView.putString("uinname", ForwardUtils.a(this.app, ((ForwardRecentListAdapter.ForwardViewHolder)localObject).jdField_b_of_type_JavaLangString, paramView.uin));
      }
      for (;;)
      {
        paramAdapterView.putBoolean("forward_report_confirm", true);
        paramAdapterView.putString("forward_report_confirm_action_name", "0X8005A13");
        paramAdapterView.putString("forward_report_confirm_reverse2", "5");
        paramAdapterView.putLong("gold_msg_amount_of_money", 0L);
        if (GoldMsgChatHelper.a(getIntent(), paramView.type))
        {
          localObject = GoldMsgChatHelper.a().a(paramView.type, paramView.uin);
          if (localObject != null) {
            paramAdapterView.putLong("gold_msg_amount_of_money", ((GoldMsgChatHelper.GoldMsgChatState)localObject).b);
          }
        }
        paramAdapterView.putInt("chooseFriendFrom", QQCustomDialogWtihInputAndChoose.a.intValue());
        this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.a.intValue(), paramAdapterView);
        this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.d();
        if ((paramView.type == 3000) || (paramView.type == 1)) {
          new ReportTask(this.app).a("dc00899").b("Grp_listNew").c("send_to").d("clk_grp").a(new String[] { "0" }).a();
        }
        return;
        ReportCenter.a().a(this.app.getAccount(), "", this.jdField_b_of_type_JavaLangString, "1000", "30", "0", false);
        break;
        ReportCenter.a().a(this.app.getAccount(), "", this.jdField_b_of_type_JavaLangString, "1000", "31", "0", false);
        break;
        ReportCenter.a().a(this.app.getAccount(), "", this.jdField_b_of_type_JavaLangString, "1000", "32", "0", false);
        break;
        paramAdapterView = new Bundle();
        break label107;
        paramAdapterView.putString("uinname", ((ForwardRecentListAdapter.ForwardViewHolder)localObject).jdField_b_of_type_JavaLangString);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (getIntent().getBooleanExtra("forward_source_from_shoot_quick", false)) {
      ReportController.b(this.app, "CliOper", "", "", paramString, paramString, 0, 0, "", "", "", "");
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if (isFinishing()) {}
    do
    {
      return;
      localObject1 = TopayManager.a(this, paramBoolean, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
    } while (localObject1 == null);
    Object localObject2 = ((HashMap)localObject1).get(TopayManager.jdField_b_of_type_JavaLangString);
    if (localObject2 != null)
    {
      localObject2 = (ArrayList)localObject2;
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a().putStringArrayList("choose_friend_feedbacks", (ArrayList)localObject2);
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    Object localObject1 = ((HashMap)localObject1).get(TopayManager.jdField_a_of_type_JavaLangString);
    if (localObject1 != null) {}
    for (localObject1 = (ArrayList)localObject1;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        int m = 0;
        if (m < ((ArrayList)localObject1).size())
        {
          localObject2 = (PfaFriend)((ArrayList)localObject1).get(m);
          if ((localObject2 == null) || (TextUtils.isEmpty(((PfaFriend)localObject2).uin))) {}
          for (;;)
          {
            m += 1;
            break;
            if ((!this.jdField_d_of_type_Boolean) || (this.app == null) || (!TextUtils.equals(((PfaFriend)localObject2).uin, this.app.getCurrentAccountUin())))
            {
              RecentUser localRecentUser = new RecentUser();
              localRecentUser.uin = ((PfaFriend)localObject2).uin;
              localRecentUser.type = 0;
              this.jdField_a_of_type_JavaUtilList.add(localRecentUser);
            }
          }
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentListAdapter == null)
      {
        localObject1 = new sns(this);
        this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentListAdapter = new ForwardRecentListAdapter(this, this.app, this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_JavaUtilList, (View.OnClickListener)localObject1);
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentListAdapter);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentListAdapter.a(this.jdField_a_of_type_JavaUtilList);
      return;
    }
  }
  
  protected boolean a(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption = ForwardOptionBuilder.a(getIntent(), this.app, this);
    if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a();
      if (isFinishing()) {
        return false;
      }
    }
    else
    {
      finish();
      return false;
    }
    paramBundle = getIntent();
    this.jdField_e_of_type_Boolean = paramBundle.getBooleanExtra("forward_ability_entrence_show_in_share", false);
    this.jdField_d_of_type_Boolean = paramBundle.getBooleanExtra("choose_friend_isForConfess", false);
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Int = paramBundle.getIntExtra("forward_source_uin_type", 0);
        this.jdField_a_of_type_AndroidNetUri = paramBundle.getData();
        if (paramBundle.getIntExtra("forward_type", -1) == 11) {
          this.jdField_a_of_type_Boolean = true;
        }
        this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("pkg_name");
        long l = paramBundle.getLongExtra("req_share_id", 0L);
        if (l > 0L) {
          this.jdField_b_of_type_JavaLangString = String.valueOf(l);
        }
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardEntranceActivity", 2, "-->doOnCreate_init--isSdkShare = " + this.jdField_a_of_type_Boolean + ", pkgName = " + this.jdField_a_of_type_JavaLangString + ", appid =" + this.jdField_b_of_type_JavaLangString);
        }
        this.jdField_c_of_type_Boolean = paramBundle.getBooleanExtra("FORWARD_RECENT_TOPAY_LIST", false);
        this.jdField_b_of_type_Int = paramBundle.getIntExtra("choose_friend_businessType", 0);
        this.jdField_c_of_type_Int = paramBundle.getIntExtra("choose_friend_businessSubType", 0);
        if ((!this.jdField_c_of_type_Boolean) && (this.jdField_b_of_type_Int == 1) && (this.jdField_c_of_type_Int > 0) && (this.jdField_c_of_type_Int < 3)) {
          this.jdField_c_of_type_Boolean = true;
        }
        a();
        if (this.app.getCurrentAccountUin() == null) {
          finish();
        }
        if (!this.jdField_c_of_type_Boolean) {
          continue;
        }
        a(true);
        this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.c();
        b();
        l = paramBundle.getLongExtra("forward_send_to_uin", 0L);
        if (l != 0L) {
          a(l, paramBundle.getStringExtra("forward_send_to_uin_nickname"));
        }
      }
      catch (Exception localException)
      {
        Intent localIntent;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ForwardOption.ForwardEntranceActivity", 2, "exception in ForwardRecentActivity", localException);
        finish();
        continue;
        if ((this.jdField_b_of_type_Int != 1) || (this.jdField_c_of_type_Int != 2)) {
          continue;
        }
        ReportController.b(this.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "autofriendpay.payerselectpage.show", 0, 0, "", "", "", "");
        continue;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("StructingMsgItemBuildertime", 4, "zhuanfa end:" + System.currentTimeMillis());
      }
      if (this.jdField_c_of_type_Boolean)
      {
        if ((this.jdField_b_of_type_Int != 1) || (this.jdField_c_of_type_Int != 1)) {
          continue;
        }
        ReportController.b(this.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "autofriendpay.buyerselectpage.show", 0, 0, "", "", "", "");
      }
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = true;
        localIntent = new Intent();
        localIntent.putExtra("call_by_forward", true);
        if (this.jdField_a_of_type_AndroidNetUri != null) {
          localIntent.setData(this.jdField_a_of_type_AndroidNetUri);
        }
        localIntent.putExtras(this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a());
        localIntent.putExtras(paramBundle.getExtras());
        localIntent.putExtra("isForConfessDirectFriendsTitle", this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.b());
        localIntent.setClass(this, ForwardFriendListActivity.class);
        localIntent.putExtra("extra_choose_friend", 5);
        startActivityForResult(localIntent, 20000);
      }
      return true;
      j();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    a(false);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    do
    {
      do
      {
        return;
        if (getIntent().getExtras().getBoolean("jump_to_mobileqq_share", false)) {
          setResult(10, paramIntent);
        }
        for (;;)
        {
          finish();
          return;
          setResult(-1, paramIntent);
        }
        setResult(-1, paramIntent);
        finish();
        return;
        if (paramIntent.getBooleanExtra("select_memeber_single_friend", false))
        {
          localObject1 = paramIntent.getExtras();
          paramInt2 = paramIntent.getIntExtra("select_memeber_single_friend_type", 2);
          paramInt1 = paramInt2;
          if (paramInt2 == 4) {
            paramInt1 = 1;
          }
          paramInt2 = paramInt1;
          if (paramInt1 == 0) {
            paramInt2 = 2;
          }
          ((Bundle)localObject1).putBoolean("forward_report_confirm", true);
          ((Bundle)localObject1).putString("forward_report_confirm_action_name", "0X8005A14");
          ((Bundle)localObject1).putString("forward_report_confirm_reverse2", Integer.toString(paramInt2));
          this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.b.intValue(), (Bundle)localObject1);
          ReportCenter.a().a(this.app.getAccount(), "", this.jdField_b_of_type_JavaLangString, "1000", "30", "0", false);
          return;
        }
        Object localObject1 = paramIntent.getStringExtra("roomId");
        Object localObject2;
        if (!StringUtil.a((String)localObject1))
        {
          j();
          ReportController.b(this.app, "CliOper", "", "", "0X80056B0", "0X80056B0", 0, 0, "", "", "", "");
          paramInt1 = paramIntent.getIntExtra("select_memeber_discussion_memeber_count", 0);
          localObject2 = new Bundle();
          ((Bundle)localObject2).putBoolean("forward_report_confirm", true);
          ((Bundle)localObject2).putString("forward_report_confirm_action_name", "0X8005A15");
          ((Bundle)localObject2).putString("forward_report_confirm_reverse2", Integer.toString(paramInt1));
          this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a((String)localObject1, paramIntent.getStringExtra("discussName"), (Bundle)localObject2);
        }
        ReportCenter.a().a(this.app.getAccount(), "", this.jdField_b_of_type_JavaLangString, "1000", "32", "0", false);
        return;
        this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(paramInt1, paramInt2, paramIntent);
        return;
        paramIntent.putExtra("chooseFriendFrom", QQCustomDialogWtihInputAndChoose.b);
        if (getIntent() != null) {}
        for (boolean bool = getIntent().getBooleanExtra("choose_friend_needConfirm", false);; bool = false)
        {
          if (bool)
          {
            localObject1 = getIntent().getStringExtra("choose_friend_confirmTitle");
            localObject2 = getIntent().getStringExtra("choose_friend_confirmContent");
            paramIntent.putExtra("choose_friend_needConfirm", bool);
            paramIntent.putExtra("choose_friend_confirmTitle", (String)localObject1);
            paramIntent.putExtra("choose_friend_confirmContent", (String)localObject2);
          }
          SearchUtils.a(paramIntent, this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(paramInt1, paramInt2, paramIntent);
        return;
        if (paramInt2 != 1) {
          break;
        }
      } while (20000 != paramInt1);
      finish();
      return;
    } while ((20000 != paramInt1) || (paramInt2 == -1) || (!this.jdField_b_of_type_Boolean));
    finish();
  }
  
  public void doOnBackPressed()
  {
    if (!isFinishing())
    {
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(false);
      com.tencent.mobileqq.app.PhoneContactManagerImp.g = false;
    }
    super.doOnBackPressed();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    setTheme(2131624738);
    super.doOnCreate(paramBundle);
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorObserver);
    setContentViewNoTitle(2130969000);
    return a(paramBundle);
  }
  
  protected void doOnDestroy()
  {
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorObserver);
    if (this.jdField_c_of_type_Boolean) {
      TopayManager.a(this.app);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentListAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentListAdapter.X_();
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption != null) {
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.s();
    }
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
    super.doOnDestroy();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    int m = 1;
    super.doOnNewIntent(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardEntranceActivity", 2, "ForwardOption.ForwardEntranceActivity onNewIntent()");
    }
    if (paramIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false))
    {
      paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      if ((paramIntent != null) && (!paramIntent.isEmpty())) {
        break label54;
      }
    }
    label54:
    int n;
    label273:
    label290:
    for (;;)
    {
      return;
      paramIntent = (String)paramIntent.get(0);
      Bundle localBundle = this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a();
      n = localBundle.getInt("key_forward_ability_type", 0);
      String str1 = localBundle.getString("uin");
      int i1 = localBundle.getInt("uintype", -1);
      String str2 = localBundle.getString("troop_uin");
      localBundle.getString("uinname");
      boolean bool = localBundle.getBoolean("FORWARD_IS_QZONE_SHARE");
      localBundle.putBoolean("FORWARD_IS_EDITED", true);
      if (!bool) {
        break;
      }
      if ((n == ForwardAbility.ForwardAbilityType.f.intValue()) || (n == ForwardAbility.ForwardAbilityType.k.intValue()))
      {
        LiteActivity.a(this.app, paramIntent, this);
        bool = true;
        m = 0;
        if (!bool) {
          break label273;
        }
        setResult(-1);
      }
      for (;;)
      {
        if (m != 0) {
          break label290;
        }
        finish();
        return;
        if (n == ForwardAbility.ForwardAbilityType.g.intValue())
        {
          this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a().putString("forward_filepath", paramIntent);
          this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a().putString("GALLERY.FORWORD_LOCAL_PATH", paramIntent);
          this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.q();
          bool = true;
          break;
        }
        bool = ForwardSendPicUtil.a(this.app, paramIntent, str1, i1, str2, true, this);
        m = 0;
        break;
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardEntranceActivity", 2, "failed to send pic from qzone");
        }
      }
    }
    if ((n == ForwardAbility.ForwardAbilityType.f.intValue()) || (n == ForwardAbility.ForwardAbilityType.k.intValue()))
    {
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a().putString("forward_extra", paramIntent);
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.b(n);
      return;
    }
    if (n == ForwardAbility.ForwardAbilityType.g.intValue())
    {
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a().putString("forward_filepath", paramIntent);
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a().putString("GALLERY.FORWORD_LOCAL_PATH", paramIntent);
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.q();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a().putString("GALLERY.FORWORD_LOCAL_PATH", paramIntent);
    k();
    ReportController.b(this.app, "CliOper", "", "", "0X800514C", "0X800514C", 0, 0, "", "", "", "");
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption != null) {
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.h();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (AppSetting.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription("取消");
      this.jdField_a_of_type_AndroidWidgetTextView.postDelayed(new snr(this), 1000L);
    }
    if (BaseApplicationImpl.appStartTime > 0L) {
      Log.d("AutoMonitor", "actStartSel, cost=" + (SystemClock.uptimeMillis() - BaseApplicationImpl.appStartTime));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption != null) {
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.i();
    }
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2131034121, 2131034122);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardRecentActivity
 * JD-Core Version:    0.7.0.1
 */