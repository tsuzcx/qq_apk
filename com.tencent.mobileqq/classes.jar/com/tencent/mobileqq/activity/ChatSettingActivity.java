package com.tencent.mobileqq.activity;

import MQQ.GetRoamToastRsp;
import Override;
import QQService.EVIPSPEC;
import aaqo;
import adqj;
import adqk;
import adql;
import adqm;
import adqn;
import adqo;
import adqp;
import adqq;
import adqr;
import adqs;
import adqt;
import adqu;
import adqv;
import adqw;
import adqx;
import adqy;
import adqz;
import adra;
import adrb;
import adrc;
import adrd;
import adre;
import adrf;
import adrg;
import adrh;
import agij;
import aift;
import allu;
import almg;
import almi;
import amci;
import amdh;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anri;
import anvi;
import anvk;
import anvx;
import anxi;
import anyz;
import anzr;
import aocc;
import aocy;
import aodb;
import aodm;
import aome;
import aqlp;
import aqlq;
import aqlr;
import aqxe;
import argb;
import argc;
import arxx;
import aslo;
import aslz;
import asmj;
import asqn;
import asrm;
import asss;
import atlf;
import awtp;
import axlr;
import axmy;
import axny;
import aydj;
import bbtd;
import bbvn;
import bcrg;
import bdfk;
import bdla;
import bejv;
import beki;
import bgyo;
import bhbx;
import bhdj;
import bhff;
import bhjf;
import bhjg;
import bhjh;
import bhnp;
import bint;
import biqh;
import bisl;
import bity;
import bjxa;
import bkzi;
import blha;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.chat.ui.MessageNotificationSettingFragment;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.NamePlateCfgInfo;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.mutualmark.view.MutualMarkIconsView;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.nowsummarycard.NowSummaryCard.NearbyUserFollowReq;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import com.tencent.widget.XListView;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import ntb;

public class ChatSettingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, asrm
{
  private static final boolean jdField_b_of_type_Boolean = AppSetting.jdField_c_of_type_Boolean;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private allu jdField_a_of_type_Allu = new adre(this);
  private almi jdField_a_of_type_Almi = new adrf(this);
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Intent jdField_a_of_type_AndroidContentIntent;
  private View jdField_a_of_type_AndroidViewView;
  public ViewGroup a;
  private Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  anvi jdField_a_of_type_Anvi = new adqr(this);
  anyz jdField_a_of_type_Anyz = new adqv(this);
  private aocc jdField_a_of_type_Aocc = new adqn(this);
  private aodb jdField_a_of_type_Aodb = new adqo(this);
  private aodm jdField_a_of_type_Aodm = new adqu(this);
  aqlq jdField_a_of_type_Aqlq = new adqj(this);
  aslz jdField_a_of_type_Aslz = new adqt(this);
  private bbtd jdField_a_of_type_Bbtd = new adqw(this);
  private bisl jdField_a_of_type_Bisl;
  private blha jdField_a_of_type_Blha;
  QvipSpecialSoundManager jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new adqs(this);
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  MutualMarkIconsView jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView;
  public RichStatus a;
  public FormSimpleItem a;
  public FormSwitchItem a;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  public String a;
  private WeakReference<FaceDrawable> jdField_a_of_type_JavaLangRefWeakReference;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new adqq(this);
  public boolean a;
  private final int jdField_b_of_type_Int = 1;
  private Dialog jdField_b_of_type_AndroidAppDialog;
  private View jdField_b_of_type_AndroidViewView;
  private Button jdField_b_of_type_AndroidWidgetButton;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private bisl jdField_b_of_type_Bisl;
  FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public FormSwitchItem b;
  private String jdField_b_of_type_JavaLangString = ChatSettingActivity.class.getSimpleName();
  private WeakReference<FaceDrawable> jdField_b_of_type_JavaLangRefWeakReference;
  private final int jdField_c_of_type_Int = 2;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  FormSimpleItem jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public FormSwitchItem c;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private final int jdField_d_of_type_Int = 3;
  public TextView d;
  FormSimpleItem jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public FormSwitchItem d;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  public TextView e;
  FormSimpleItem jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public FormSwitchItem e;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  TextView jdField_f_of_type_AndroidWidgetTextView;
  FormSimpleItem jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public FormSwitchItem f;
  private String jdField_f_of_type_JavaLangString;
  private boolean jdField_f_of_type_Boolean;
  TextView jdField_g_of_type_AndroidWidgetTextView;
  private FormSimpleItem jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private String jdField_g_of_type_JavaLangString;
  private boolean jdField_g_of_type_Boolean = true;
  public TextView h;
  private FormSimpleItem jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private String jdField_h_of_type_JavaLangString;
  private boolean jdField_h_of_type_Boolean;
  private TextView jdField_i_of_type_AndroidWidgetTextView;
  private String jdField_i_of_type_JavaLangString = "";
  private boolean jdField_i_of_type_Boolean;
  private TextView jdField_j_of_type_AndroidWidgetTextView;
  private String jdField_j_of_type_JavaLangString = "";
  private boolean jdField_j_of_type_Boolean;
  private TextView jdField_k_of_type_AndroidWidgetTextView;
  private String jdField_k_of_type_JavaLangString = "";
  private TextView l;
  
  public ChatSettingActivity()
  {
    this.jdField_a_of_type_JavaLangString = "ChatSettingActivity.nearby";
  }
  
  private void A()
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      a(2131692125, 1);
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_f_of_type_Boolean);
    }
    for (;;)
    {
      return;
      Object localObject1 = (awtp)this.app.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
      if (localObject1 != null) {}
      try
      {
        l1 = Long.parseLong(this.jdField_i_of_type_JavaLangString);
        if (l1 > 0L)
        {
          Object localObject2 = new ArrayList();
          ((ArrayList)localObject2).add(Long.valueOf(l1));
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "startStangerShield, tuin=" + l1 + ", mIsShield=" + this.jdField_f_of_type_Boolean + ", mIsFollowed=" + this.jdField_a_of_type_Boolean);
          }
          if (this.jdField_f_of_type_Boolean)
          {
            ((awtp)localObject1).b(this.jdField_a_of_type_Int, (List)localObject2);
            this.jdField_h_of_type_Boolean = true;
            QQAppInterface localQQAppInterface = this.app;
            if (!this.jdField_f_of_type_Boolean) {
              break label511;
            }
            localObject2 = "cancel_aio";
            if (this.jdField_a_of_type_Int != 1001) {
              break label519;
            }
            str2 = "0";
            if (!this.jdField_f_of_type_Boolean) {
              break label527;
            }
            localObject1 = "";
            bdla.b(localQQAppInterface, "dc00899", "grp_lbs", "", "c2c_tmp", (String)localObject2, 0, 0, str2, "1", (String)localObject1, "");
            if ((this.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_Int == 10002) || (this.jdField_a_of_type_Int == 1003))
            {
              if (!this.jdField_f_of_type_Boolean) {
                break label548;
              }
              if ((this.jdField_c_of_type_JavaLangString != null) && (this.jdField_c_of_type_JavaLangString.length() > 0))
              {
                this.app.getMsgHandler().b(this.jdField_c_of_type_JavaLangString);
                this.jdField_h_of_type_Boolean = true;
              }
              if (QLog.isColorLevel()) {
                QLog.d(this.jdField_a_of_type_JavaLangString, 2, "startStangerShield, mCurUin=" + this.jdField_c_of_type_JavaLangString + ", mIsShield=" + this.jdField_f_of_type_Boolean + ", mShieldByThis=" + this.jdField_h_of_type_Boolean);
              }
            }
            if ((this.jdField_h_of_type_Boolean) && (this.jdField_a_of_type_Int != 1010)) {
              continue;
            }
            if (!this.jdField_f_of_type_Boolean) {
              break label587;
            }
            bdla.b(this.app, "CliOper", "", this.jdField_i_of_type_JavaLangString, "0X8004954", "0X8004954", 0, 0, "", "", "", "");
            return;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          long l1 = 0L;
          continue;
          if (this.jdField_a_of_type_Boolean)
          {
            if (ChatActivityUtils.a.size() > 5) {
              ChatActivityUtils.a.poll();
            }
            ChatActivityUtils.a.offer(l1 + "");
          }
          ((awtp)localObject1).a(this.jdField_a_of_type_Int, localException);
          continue;
          a(1, anvx.a(2131701254));
          continue;
          label511:
          String str1 = "block_aio";
          continue;
          label519:
          String str2 = "1";
          continue;
          label527:
          if (this.jdField_a_of_type_Boolean)
          {
            localObject1 = "0";
          }
          else
          {
            localObject1 = "1";
            continue;
            label548:
            if ((this.jdField_c_of_type_JavaLangString != null) && (this.jdField_c_of_type_JavaLangString.length() > 0))
            {
              this.app.getMsgHandler().a(this.jdField_c_of_type_JavaLangString);
              this.jdField_h_of_type_Boolean = true;
            }
          }
        }
        label587:
        bdla.b(this.app, "CliOper", "", this.jdField_i_of_type_JavaLangString, "0X8004953", "0X8004953", 0, 0, "", "", "", "");
      }
    }
  }
  
  private void B()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "refreshShieldButton, mCurType=" + this.jdField_a_of_type_Int + ", mIsShield=" + this.jdField_f_of_type_Boolean);
    }
    if (this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem != null)
    {
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_f_of_type_Boolean);
      if (AppSetting.jdField_c_of_type_Boolean) {
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131690811));
      }
    }
    if ((this.jdField_a_of_type_Int == 1003) || (!this.jdField_g_of_type_Boolean)) {
      if ((this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem != null) && (this.jdField_c_of_type_AndroidViewView != null))
      {
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      }
    }
    while ((this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem == null) || (this.jdField_c_of_type_AndroidViewView == null)) {
      return;
    }
    if (!b()) {
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
    }
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
  }
  
  private void C()
  {
    int m;
    if ((1001 == this.jdField_a_of_type_Int) || (10002 == this.jdField_a_of_type_Int)) {
      if (this.jdField_a_of_type_Boolean) {
        m = 2131696101;
      }
    }
    for (;;)
    {
      String str = getString(m);
      this.jdField_a_of_type_AndroidWidgetButton.setText(str);
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(str);
      return;
      m = 2131696099;
      continue;
      m = 2131690809;
    }
  }
  
  private void D()
  {
    int m = 0;
    if (this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem == null) {}
    Object localObject;
    do
    {
      return;
      localObject = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if ((localObject != null) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))) {
        this.jdField_e_of_type_Boolean = ((anvk)localObject).e(this.jdField_c_of_type_JavaLangString);
      }
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_e_of_type_Boolean);
      z();
      if (AppSetting.jdField_c_of_type_Boolean) {
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131690811));
      }
    } while (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem == null);
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if ((!this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) && (!this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()))
      {
        m = 0;
        ((FormSwitchItem)localObject).setVisibility(m);
      }
    }
    for (;;)
    {
      label140:
      if (jdField_b_of_type_Boolean)
      {
        return;
        m = 8;
        break;
        if (!this.app.getCurrentUin().equals(this.jdField_c_of_type_JavaLangString))
        {
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
          localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
          if ((this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) || (this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())) {
            break label211;
          }
        }
      }
    }
    for (;;)
    {
      ((FormSwitchItem)localObject).setVisibility(m);
      break label140;
      break;
      label211:
      m = 8;
    }
  }
  
  private void E()
  {
    if (this.app != null)
    {
      MqqHandler localMqqHandler = this.app.getHandler(Conversation.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendEmptyMessage(1009);
      }
      localMqqHandler = this.app.getHandler(TroopAssistantActivity.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendEmptyMessage(1);
      }
    }
  }
  
  private void F()
  {
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.jdField_c_of_type_JavaLangString, 46);
    localAllInOne.jdField_a_of_type_Int = 19;
    localAllInOne.jdField_h_of_type_JavaLangString = ContactUtils.getFriendNick(this.app, this.jdField_c_of_type_JavaLangString);
    if ((TextUtils.isEmpty(localAllInOne.jdField_h_of_type_JavaLangString)) || (localAllInOne.jdField_h_of_type_JavaLangString.equals(this.jdField_c_of_type_JavaLangString))) {
      localAllInOne.jdField_h_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    }
    localAllInOne.jdField_f_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    localAllInOne.jdField_e_of_type_Int = this.jdField_a_of_type_Int;
    localAllInOne.g = 5;
    localAllInOne.jdField_h_of_type_Int = 61;
    Object localObject;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      localAllInOne.jdField_a_of_type_AndroidOsBundle = aaqo.a(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.i("NewReportPlugin", 2, String.format("start-profile: %s", new Object[] { localAllInOne.jdField_a_of_type_AndroidOsBundle }));
      }
      if ((this.jdField_a_of_type_Int != 1001) && (this.jdField_a_of_type_Int != 10002) && (this.jdField_a_of_type_Int != 10004) && (this.jdField_a_of_type_Int != 1010) && ((this.jdField_a_of_type_Int != 1022) || ((this.jdField_f_of_type_Int != 3007) && (this.jdField_f_of_type_Int != 2007) && (this.jdField_f_of_type_Int != 4007) && (this.jdField_f_of_type_Int != 3019) && (this.jdField_f_of_type_Int != 2019)))) {
        break label732;
      }
      localObject = new Intent(this, NearbyPeopleProfileActivity.class);
      if (this.jdField_a_of_type_Int == 1001)
      {
        localAllInOne.jdField_h_of_type_Int = 12;
        if (axny.a(this.jdField_c_of_type_JavaLangString)) {
          ((Intent)localObject).putExtra("param_tiny_id", Long.valueOf(this.jdField_c_of_type_JavaLangString));
        }
        ((Intent)localObject).putExtra("frome_where", 21);
        label468:
        ((Intent)localObject).putExtra("AllInOne", localAllInOne);
        if (!bhbx.a(this.jdField_c_of_type_JavaLangString, this.app.getCurrentAccountUin())) {
          break label720;
        }
        ((Intent)localObject).putExtra("param_mode", 2);
      }
      break;
    }
    for (;;)
    {
      startActivityForResult((Intent)localObject, 3);
      return;
      localAllInOne.jdField_a_of_type_Int = 42;
      break;
      localAllInOne.jdField_a_of_type_Int = 86;
      break;
      localAllInOne.jdField_a_of_type_Int = 76;
      break;
      localAllInOne.jdField_a_of_type_Int = 22;
      localAllInOne.jdField_d_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
      break;
      localAllInOne.jdField_a_of_type_Int = 70;
      break;
      localAllInOne.jdField_a_of_type_Int = 47;
      localAllInOne.jdField_e_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
      break;
      localAllInOne.jdField_a_of_type_Int = 2;
      break;
      localAllInOne.jdField_a_of_type_Int = 34;
      break;
      localAllInOne.jdField_a_of_type_Int = 57;
      break;
      localAllInOne.jdField_a_of_type_Int = 72;
      break;
      localAllInOne.jdField_a_of_type_Int = 74;
      break;
      localAllInOne.jdField_a_of_type_Int = 27;
      break;
      localAllInOne.jdField_a_of_type_Int = 58;
      break;
      localAllInOne.jdField_a_of_type_Int = 96;
      break;
      localAllInOne.jdField_a_of_type_Int = 115;
      break;
      localAllInOne.jdField_a_of_type_Int = 117;
      break;
      if (this.jdField_a_of_type_Int == 10002)
      {
        ((Intent)localObject).putExtra("frome_where", 22);
        break label468;
      }
      if (this.jdField_a_of_type_Int == 1010)
      {
        localAllInOne.jdField_h_of_type_Int = 13;
        break label468;
      }
      localAllInOne.jdField_h_of_type_Int = 30;
      break label468;
      label720:
      ((Intent)localObject).putExtra("param_mode", 3);
    }
    label732:
    if ((this.jdField_a_of_type_Int == 1037) || (this.jdField_a_of_type_Int == 1044) || (this.jdField_a_of_type_Int == 1045))
    {
      ProfileActivity.a(this, localAllInOne, this.jdField_a_of_type_AndroidContentIntent.getIntExtra("ExtendFriendLimitChatFromeType", 0), 3);
      return;
    }
    if (this.jdField_a_of_type_AndroidContentIntent.hasExtra("param_wzry_data"))
    {
      localObject = this.jdField_a_of_type_AndroidContentIntent.getSerializableExtra("param_wzry_data");
      if (localObject != null) {
        localAllInOne.b.putSerializable("param_wzry_data", (Serializable)localObject);
      }
    }
    ProfileActivity.a(this, localAllInOne, 3);
  }
  
  private void G()
  {
    int m = 3999;
    int n = 0;
    Object localObject = null;
    switch (this.jdField_a_of_type_Int)
    {
    }
    while (m == 3007)
    {
      if (anxi.a(this.app, this.jdField_c_of_type_JavaLangString)) {
        break label448;
      }
      b();
      return;
      m = 3004;
      n = 3;
      localObject = getIntent().getStringExtra("troop_uin");
      continue;
      m = 3007;
      n = 3;
      continue;
      m = 3043;
      n = 3;
      continue;
      m = 3071;
      n = 1;
      continue;
      m = 3003;
      continue;
      m = 3005;
      n = 3;
      localObject = getIntent().getStringExtra("troop_uin");
      continue;
      m = 3008;
      n = 12;
      continue;
      m = 3006;
      n = 12;
      continue;
      m = 3013;
      continue;
      m = 3008;
      n = 11;
      continue;
      m = 3003;
      n = 2;
      continue;
      m = 3041;
      n = 11;
      continue;
      m = 3019;
      continue;
      m = 3099;
      n = 1;
      continue;
      m = 3094;
      n = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("subId", 0);
      continue;
      m = 3072;
      n = 2;
      continue;
      m = 3080;
      n = 3;
      continue;
      m = 3071;
      n = 5192;
      continue;
      m = 3076;
      n = 6;
    }
    if ((m == 3019) && (!arxx.a(this.app, this.jdField_c_of_type_JavaLangString)))
    {
      b();
      return;
    }
    label448:
    if ((this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 4) || (this.jdField_a_of_type_Int == 4000) || (this.jdField_a_of_type_Int == 1006)) {}
    for (localObject = AddFriendLogicActivity.a(this, 2, this.jdField_k_of_type_JavaLangString, null, m, n, this.jdField_d_of_type_JavaLangString, null, null, setLastActivityName(), null);; localObject = AddFriendLogicActivity.a(this, 1, this.jdField_c_of_type_JavaLangString, (String)localObject, m, n, this.jdField_d_of_type_JavaLangString, null, null, setLastActivityName(), null))
    {
      if (m == 3094) {
        ((Intent)localObject).putExtra("entrance", 3);
      }
      if (localObject != null)
      {
        Serializable localSerializable = aift.a(this, this.jdField_a_of_type_Int, false, false);
        if (localSerializable != null) {
          ((Intent)localObject).putExtra("param_wzry_data", localSerializable);
        }
      }
      startActivity((Intent)localObject);
      return;
    }
  }
  
  private void H()
  {
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.jdField_c_of_type_JavaLangString, 1);
    localAllInOne.jdField_h_of_type_JavaLangString = ContactUtils.getFriendNick(this.app, this.jdField_c_of_type_JavaLangString);
    if (3000 != this.jdField_a_of_type_Int)
    {
      localAllInOne.jdField_f_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      localAllInOne.jdField_e_of_type_Int = this.jdField_a_of_type_Int;
    }
    localAllInOne.g = 5;
    localAllInOne.jdField_h_of_type_Int = 61;
    localAllInOne.jdField_a_of_type_AndroidOsBundle = aaqo.a(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.i("NewReportPlugin", 2, String.format("start-profile: %s", new Object[] { localAllInOne.jdField_a_of_type_AndroidOsBundle }));
    }
    ProfileActivity.a(this, localAllInOne, 3);
  }
  
  private void I()
  {
    if ((this.jdField_b_of_type_Bisl != null) && (this.jdField_b_of_type_Bisl.isShowing())) {}
    try
    {
      this.jdField_b_of_type_Bisl.cancel();
      this.jdField_b_of_type_Bisl = null;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void J()
  {
    ChatSettingActivity.22 local22 = new ChatSettingActivity.22(this);
    if (!this.jdField_j_of_type_Boolean) {
      ThreadManager.post(local22, 8, null, true);
    }
  }
  
  private void K()
  {
    if (this.jdField_a_of_type_Int == 0) {
      if (this.jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView != null) {
        this.jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.a(this.app, this.jdField_c_of_type_JavaLangString, 2);
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.setVisibility(8);
  }
  
  private void L()
  {
    boolean bool = FriendsStatusUtil.a(this.jdField_c_of_type_JavaLangString, this.app);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
      a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      if (AppSetting.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131694154));
      }
    }
  }
  
  private void M()
  {
    boolean bool = agij.a(this.jdField_c_of_type_JavaLangString, this.app);
    FormSwitchItem localFormSwitchItem;
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
      a();
      localFormSwitchItem = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if ((this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) || (this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())) {
        break label80;
      }
    }
    label80:
    for (int m = 0;; m = 8)
    {
      localFormSwitchItem.setVisibility(m);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      return;
    }
  }
  
  private int a(String paramString, int paramInt, StringBuilder paramStringBuilder)
  {
    SQLiteDatabase localSQLiteDatabase = this.app.getReadableDatabase();
    if (localSQLiteDatabase == null) {}
    do
    {
      do
      {
        return 0;
        StringBuilder localStringBuilder = new StringBuilder(" where msgtype != ");
        localStringBuilder.append(-2006);
        paramString = bhff.a(MessageRecord.getOldTableName(paramString, paramInt), MessageRecord.getTableName(paramString, paramInt), localSQLiteDatabase, localStringBuilder.toString());
      } while (paramString == null);
      paramString = localSQLiteDatabase.rawQuery(paramString.toString(), null);
    } while (paramString == null);
    long l1;
    if ((paramString.getCount() > 0) && (paramStringBuilder != null))
    {
      paramString.moveToLast();
      if (paramInt != 3000) {
        break label153;
      }
      l1 = paramString.getLong(paramString.getColumnIndex("shmsgseq"));
    }
    for (;;)
    {
      if (l1 > 0L) {
        paramStringBuilder.append(String.valueOf(l1));
      }
      paramInt = paramString.getCount();
      paramString.close();
      return paramInt;
      label153:
      if (paramInt == 0) {
        l1 = paramString.getLong(paramString.getColumnIndex("time"));
      } else if (paramInt == 1) {
        l1 = paramString.getLong(paramString.getColumnIndex("shmsgseq"));
      } else {
        l1 = 0L;
      }
    }
  }
  
  private TextView a(View paramView1, View paramView2)
  {
    if ((paramView1 == null) || (paramView2 == null) || (!(paramView2 instanceof ViewGroup))) {
      return null;
    }
    TextView localTextView = (TextView)paramView1.findViewById(2131378106);
    if (localTextView == null) {
      return null;
    }
    ((ViewGroup)paramView1).removeView(localTextView);
    paramView1 = localTextView.getLayoutParams();
    if ((paramView1 instanceof LinearLayout.LayoutParams)) {
      ((LinearLayout.LayoutParams)paramView1).setMargins(0, AIOUtils.dp2px(5.0F, getResources()), 0, 0);
    }
    ((ViewGroup)paramView2).addView(localTextView);
    return localTextView;
  }
  
  private RichStatus a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = ((anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(paramString);
    if (paramString != null) {
      return paramString.getRichStatus();
    }
    return null;
  }
  
  private String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      localObject = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    } while (localObject == null);
    Friends localFriends = ((anvk)localObject).e(paramString);
    if (localFriends != null) {
      if (localFriends.remark != null)
      {
        paramString = localFriends.remark;
        localObject = paramString;
        if (TextUtils.isEmpty(paramString))
        {
          localObject = paramString;
          if (TextUtils.isEmpty(localFriends.name)) {}
        }
      }
    }
    for (Object localObject = localFriends.name;; localObject = null)
    {
      return localObject;
      paramString = null;
      break;
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).b(getTitleBarHeight());
  }
  
  private void a(int paramInt, String paramString)
  {
    if (this.jdField_d_of_type_Boolean) {
      return;
    }
    if (paramInt == -1)
    {
      QQToast.a(this, paramString, 0).b(getTitleBarHeight());
      return;
    }
    QQToast.a(this, paramInt, paramString, 0).b(getTitleBarHeight());
  }
  
  private void a(Intent paramIntent)
  {
    String str = null;
    if (paramIntent != null) {
      str = paramIntent.getStringExtra("result");
    }
    paramIntent = str;
    if (str == null) {
      paramIntent = "";
    }
    if (NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      if (!paramIntent.equals(this.jdField_g_of_type_JavaLangString))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.setFriendComment(this.jdField_c_of_type_JavaLangString, paramIntent, false);
          this.jdField_e_of_type_Int |= 0x1;
          c(paramIntent);
          g(getString(2131690752));
          this.jdField_a_of_type_Bisl.show();
          return;
        }
        a(2131693257, 1);
        return;
      }
      a(2131693243, 0);
      return;
    }
    a(2131694302, 1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, int paramInt1, adrh paramadrh, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "startDelAllMsg......");
    }
    bint localbint = new bint(paramActivity, paramQQAppInterface, true);
    localbint.a(new adqz(paramadrh, paramQQAppInterface, paramString, paramInt1, paramActivity));
    localbint.a(paramInt2);
  }
  
  private void a(RichStatus paramRichStatus, TextView paramTextView)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = paramRichStatus;
    this.jdField_h_of_type_AndroidWidgetTextView = paramTextView;
    if ((paramRichStatus == null) || (paramTextView == null)) {
      return;
    }
    Object localObject = paramRichStatus.toSpannableString(null);
    if (!TextUtils.isEmpty(paramRichStatus.actionText))
    {
      localObject = new SpannableStringBuilder((CharSequence)localObject);
      ((SpannableStringBuilder)localObject).insert(0, "[S] ");
      bbvn localbbvn = (bbvn)this.app.getManager(QQManagerFactory.STATUS_MANAGER);
      if (localbbvn != null) {}
      for (paramRichStatus = localbbvn.a(paramRichStatus.actionId, 200);; paramRichStatus = bgyo.a(getResources(), 2130849591))
      {
        paramRichStatus = new bity(getResources(), paramRichStatus, false, false);
        int m = (int)(paramTextView.getTextSize() * 1.1F + 0.5F);
        paramRichStatus.setBounds(0, 0, m, m);
        paramRichStatus = new biqh(paramRichStatus, 0);
        paramRichStatus.a(-0.1F);
        ((SpannableStringBuilder)localObject).setSpan(paramRichStatus, 0, "[S]".length(), 17);
        paramTextView.setVisibility(0);
        paramTextView.setText((CharSequence)localObject);
        return;
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramTextView.setVisibility(0);
      paramTextView.setText((CharSequence)localObject);
      return;
    }
    paramTextView.setVisibility(8);
  }
  
  private void a(String paramString)
  {
    NowSummaryCard.NearbyUserFollowReq localNearbyUserFollowReq = new NowSummaryCard.NearbyUserFollowReq();
    localNearbyUserFollowReq.from.set(0);
    localNearbyUserFollowReq.id_type.set(0);
    localNearbyUserFollowReq.target_id.set(Long.valueOf(this.jdField_c_of_type_JavaLangString).longValue());
    localNearbyUserFollowReq.operation.set(Integer.valueOf(paramString).intValue());
    ntb.a(this.app, new adrc(this, paramString), localNearbyUserFollowReq.toByteArray(), "NowSummaryCard.NearbyUserFollow");
  }
  
  private void a(String paramString, int paramInt)
  {
    QQToast.a(BaseApplication.getContext(), paramInt, paramString, 0).b(getTitleBarHeight());
  }
  
  private boolean a()
  {
    return ((almg)this.app.getManager(QQManagerFactory.TEMP_MSG_BOX)).a(this.jdField_c_of_type_JavaLangString, 0);
  }
  
  private boolean a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  private boolean a(String paramString)
  {
    return ((anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString);
  }
  
  private String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    anvk localanvk = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    paramString = localanvk.e(paramString);
    if (paramString != null)
    {
      paramString = localanvk.a(paramString.groupid + "");
      if (paramString == null) {}
    }
    for (paramString = paramString.group_name;; paramString = null) {
      return paramString;
    }
  }
  
  private void b(Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return;
      int m = paramIntent.getByteExtra("result", (byte)0);
      paramIntent = ((anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(String.valueOf(m));
    } while (paramIntent == null);
    d(paramIntent.group_name);
  }
  
  private void b(String paramString)
  {
    QQAppInterface localQQAppInterface = this.app;
    String str2 = this.jdField_c_of_type_JavaLangString;
    if (this.jdField_a_of_type_Int == 1001) {}
    for (String str1 = "2";; str1 = "1")
    {
      if (this.jdField_a_of_type_Int == 1001) {}
      anzr.a(localQQAppInterface, str2, str1, paramString, 3, new adrd(this, paramString));
      return;
    }
  }
  
  private boolean b()
  {
    return this.jdField_a_of_type_Int == 1001;
  }
  
  private void c(String paramString)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      if (!TextUtils.isEmpty(paramString)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      }
    }
    else {
      return;
    }
    paramString = ContactUtils.getFriendNick(this.app, this.jdField_c_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  private void d(String paramString)
  {
    if ((this.jdField_g_of_type_AndroidWidgetTextView != null) && (paramString != null)) {
      this.jdField_g_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER));
  }
  
  private void e(String paramString)
  {
    Object localObject = this.app.getMessageFacade().getMsgList(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int);
    if ((localObject != null) && (!((List)localObject).isEmpty())) {
      if (!((MessageRecord)((List)localObject).get(((List)localObject).size() - 1)).isSendFromLocal()) {}
    }
    for (long l1 = ((MessageRecord)((List)localObject).get(((List)localObject).size() - 1)).time + 2L;; l1 = 0L) {
      for (;;)
      {
        this.app.getMessageFacade().clearHistory(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int);
        this.app.getMessageFacade().onCurrentMessageDeleted(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int);
        this.app.getFileManagerDataCenter().a(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int);
        if (paramString != null) {}
        try
        {
          l2 = Long.parseLong(paramString);
          l1 = Math.max(l2, l1);
          if (l1 > 0L) {
            this.app.getMsgCache().a(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int, l1);
          }
          paramString = this.app.getHandler(Conversation.class);
          localObject = paramString.obtainMessage(1017);
          ((Message)localObject).obj = this.jdField_c_of_type_JavaLangString;
          ((Message)localObject).arg1 = this.jdField_a_of_type_Int;
          paramString.sendMessage((Message)localObject);
          return;
          l1 = ((MessageRecord)((List)localObject).get(((List)localObject).size() - 1)).time;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            paramString.printStackTrace();
            long l2 = 0L;
          }
        }
      }
    }
  }
  
  private void f()
  {
    addObserver(this.jdField_a_of_type_Anvi);
    addObserver(this.jdField_a_of_type_Anyz);
    addObserver(this.jdField_a_of_type_Aodm);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    addObserver(this.jdField_a_of_type_Aocc);
    addObserver(this.jdField_a_of_type_Aodb);
    addObserver(this.jdField_a_of_type_Aqlq);
    addObserver(this.jdField_a_of_type_Aslz);
    addObserver(this.jdField_a_of_type_Allu);
    this.app.registObserver(this.jdField_a_of_type_Almi);
    this.app.setHandler(ChatSettingActivity.class, this.jdField_a_of_type_MqqOsMqqHandler);
    bbvn localbbvn = (bbvn)this.app.getManager(QQManagerFactory.STATUS_MANAGER);
    if (localbbvn != null) {
      localbbvn.a(this.jdField_a_of_type_Bbtd);
    }
  }
  
  private void f(String paramString)
  {
    bkzi localbkzi = bkzi.a(this);
    if (bhbx.b(paramString)) {
      localbkzi.a(2131690602);
    }
    for (;;)
    {
      localbkzi.a(2131691457, 3);
      localbkzi.c(2131690697);
      localbkzi.a(new adqp(this, paramString, localbkzi));
      localbkzi.show();
      return;
      if (axlr.a(this.app, this.jdField_c_of_type_JavaLangString, true)) {
        localbkzi.a(2131690604);
      } else {
        localbkzi.a(2131690603);
      }
    }
  }
  
  private void g()
  {
    removeObserver(this.jdField_a_of_type_Anvi);
    removeObserver(this.jdField_a_of_type_Anyz);
    removeObserver(this.jdField_a_of_type_Aodm);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    removeObserver(this.jdField_a_of_type_Aocc);
    removeObserver(this.jdField_a_of_type_Aodb);
    removeObserver(this.jdField_a_of_type_Aqlq);
    removeObserver(this.jdField_a_of_type_Aslz);
    removeObserver(this.jdField_a_of_type_Allu);
    this.app.unRegistObserver(this.jdField_a_of_type_Almi);
    this.app.removeHandler(ChatSettingActivity.class);
    bbvn localbbvn = (bbvn)this.app.getManager(QQManagerFactory.STATUS_MANAGER);
    if (localbbvn != null)
    {
      localbbvn.b(this.jdField_a_of_type_Bbtd);
      return;
    }
    this.jdField_a_of_type_Bbtd = null;
  }
  
  private void g(String paramString)
  {
    this.jdField_a_of_type_Bisl = new bisl(this, getTitleBarHeight());
    this.jdField_a_of_type_Bisl.setContentView(2131562799);
    if ((paramString == null) || ("".equals(paramString.trim())))
    {
      this.jdField_a_of_type_Bisl.a(getString(2131718527));
      return;
    }
    this.jdField_a_of_type_Bisl.a(paramString);
  }
  
  private void h()
  {
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("uin");
    this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("uinname");
    if (this.jdField_d_of_type_JavaLangString == null) {
      this.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    }
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("uintype", -1);
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("follow_flag", false);
    if ((this.jdField_a_of_type_Int == 0) && (!a(this.jdField_c_of_type_JavaLangString))) {
      this.jdField_a_of_type_Int = 1003;
    }
    if ((1 == this.jdField_a_of_type_Int) || (1000 == this.jdField_a_of_type_Int) || (1004 == this.jdField_a_of_type_Int)) {
      this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("troop_uin");
    }
    this.jdField_f_of_type_Int = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("add_friend_source_id", 3999);
    this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("real_troop_uin");
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager = new QvipSpecialSoundManager(this, this.app);
  }
  
  private void i()
  {
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      m();
    }
    for (;;)
    {
      setTitle(2131690783);
      setLeftViewName(2131690499);
      setContentBackgroundResource(2130838911);
      return;
      k();
    }
  }
  
  private void j()
  {
    WebProcessManager localWebProcessManager = (WebProcessManager)this.app.getManager(QQManagerFactory.WEBPROCESS_MANAGER);
    if (localWebProcessManager == null) {}
    do
    {
      do
      {
        return;
      } while (!localWebProcessManager.d());
      localWebProcessManager.e();
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_b_of_type_JavaLangString, 2, "start preloadWebProcess");
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)View.inflate(this, 2131559346, null));
    try
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundResource(2130838911);
      this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    }
    catch (Throwable localThrowable)
    {
      try
      {
        this.jdField_a_of_type_AndroidViewView = View.inflate(this, 2131558905, null);
        this.jdField_a_of_type_ComTencentWidgetXListView.setPadding(0, 0, 0, 0);
        this.jdField_a_of_type_Blha = new blha(this.jdField_a_of_type_AndroidViewView);
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Blha);
        super.setContentView(this.jdField_a_of_type_ComTencentWidgetXListView);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131367293));
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367292));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367294));
        this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131381241));
        this.jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView = ((MutualMarkIconsView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371752));
        this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365325));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131377792));
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131364497));
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131377441));
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131364196));
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364210));
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131362145));
        this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365490));
        this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376519));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131377923));
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131377447));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131377442));
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131377444));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131377443));
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131377445));
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131377440));
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364195));
        this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131376926));
        this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376927));
        this.jdField_a_of_type_AndroidViewView.findViewById(2131365497).setOnClickListener(this);
        this.jdField_f_of_type_AndroidWidgetTextView.setBackgroundResource(2130839496);
        this.jdField_a_of_type_AndroidViewView.findViewById(2131376920).setOnClickListener(this);
        this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
        this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
        boolean bool = aqlr.b(this.app);
        Object localObject1 = this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem;
        int m;
        if (bool)
        {
          m = 0;
          label635:
          ((FormSwitchItem)localObject1).setVisibility(m);
          localObject1 = this.jdField_b_of_type_AndroidWidgetTextView;
          if (!bool) {
            break label1839;
          }
          m = 0;
          label651:
          ((TextView)localObject1).setVisibility(m);
          if (bool)
          {
            this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(aqlr.a(this.app, this.jdField_c_of_type_JavaLangString));
            this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
            bdla.b(this.app, "dc00898", "", "", "0X800B330", "0X800B330", aqlp.a(this.app).a(this.jdField_c_of_type_JavaLangString), 0, "", "", "", "");
          }
          this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(FriendsStatusUtil.a(this.app, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int));
          this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
          this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this);
          this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
          this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
          this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
          this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
          if (Build.VERSION.SDK_INT > 25) {
            break label1845;
          }
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
          label831:
          if (AppSetting.jdField_c_of_type_Boolean)
          {
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(getString(2131693261));
            this.jdField_b_of_type_AndroidWidgetRelativeLayout.setContentDescription(getString(2131689626));
            this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131690764));
            this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131718544));
            this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131716737));
            this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131694344) + getString(2131718561));
            this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131694154));
            this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131696085));
            this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131690812));
            this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131694922));
            this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131694919));
            this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131689592));
            this.jdField_f_of_type_AndroidWidgetTextView.setContentDescription(getString(2131691457));
            this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription("从过滤消息移出");
            this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(getString(2131689511));
            this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(anvx.a(2131718906));
          }
          this.jdField_g_of_type_JavaLangString = a(this.jdField_c_of_type_JavaLangString);
          if (this.jdField_g_of_type_JavaLangString == null) {
            this.jdField_g_of_type_JavaLangString = "";
          }
          c(this.jdField_g_of_type_JavaLangString);
          if (this.jdField_g_of_type_JavaLangString != null) {
            this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_g_of_type_JavaLangString);
          }
          Object localObject2 = bhjf.a(this.app, this.jdField_c_of_type_JavaLangString);
          bool = bhjf.a(localObject2[0]);
          if (bool)
          {
            localObject1 = bhjg.a(localObject2[0]);
            if ((!bhjf.b(localObject2[1])) && (!((bhjg)localObject1).a()))
            {
              localObject2 = bhjf.a(this.app, this.jdField_c_of_type_JavaLangString, (bhjg)localObject1, false);
              VipUtils.a(getResources(), this.jdField_b_of_type_AndroidWidgetImageView, (String)localObject2, getResources().getDrawable(bhjf.a((bhjg)localObject1)));
            }
          }
          bhjh.a(this.app, this.jdField_c_of_type_JavaLangString, "VIA_AIO_CHATSETTINGS").a();
          m = VipUtils.a(this.app, this.jdField_c_of_type_JavaLangString);
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_b_of_type_JavaLangString, 2, "bindView: vip=" + m);
          }
          if ((m >> 8 != 3) || (bdfk.b())) {
            break label1903;
          }
          localObject1 = bhjf.a(this.app, this.jdField_c_of_type_JavaLangString, EVIPSPEC.E_SP_BIGCLUB);
          if ((m & 0xF) != 1) {
            break label1857;
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167170));
          if (!bool) {
            VipUtils.a(getResources(), this.jdField_b_of_type_AndroidWidgetImageView, (String)localObject1, getResources().getDrawable(2130847076));
          }
          label1362:
          NamePlateCfgInfo.vipNamePlateExposeReport(this.app, this.jdField_c_of_type_JavaLangString);
          this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(VipUtils.e(1));
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          label1392:
          if (this.jdField_c_of_type_JavaLangString != null)
          {
            localObject1 = FaceDrawable.getUserFaceDrawable(this.app, this.jdField_c_of_type_JavaLangString, (byte)3);
            this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
          }
          this.jdField_h_of_type_JavaLangString = b(this.jdField_c_of_type_JavaLangString);
          if (this.jdField_h_of_type_JavaLangString == null) {
            this.jdField_h_of_type_JavaLangString = "";
          }
          d(this.jdField_h_of_type_JavaLangString);
          w();
          if (!a()) {
            this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
          }
          if (!bhbx.b(this.jdField_c_of_type_JavaLangString)) {
            break label2128;
          }
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
          localObject1 = (LinearLayout.LayoutParams)this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject1).topMargin = DisplayUtil.dip2px(this, 20.0F);
          this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
          localObject1 = ((anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).c(AppConstants.BABY_Q_UIN);
          this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((Card)localObject1).babyQSwitch);
          this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
          ((anri)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).v();
        }
        for (;;)
        {
          if (bjxa.b(this.app, this.jdField_c_of_type_JavaLangString)) {
            this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          }
          if (this.app != null)
          {
            D();
            K();
            L();
          }
          M();
          if (this.app.getCurrentUin().equals(this.jdField_c_of_type_JavaLangString))
          {
            this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
            this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
            this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
            this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
            this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
            this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
            this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
            this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
          }
          if (!a(this.jdField_c_of_type_JavaLangString)) {
            this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
          }
          l();
          return;
          localThrowable = localThrowable;
          QLog.i(this.jdField_b_of_type_JavaLangString, 1, localThrowable.toString());
          break;
          m = 8;
          break label635;
          label1839:
          m = 8;
          break label651;
          label1845:
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
          break label831;
          label1857:
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167170));
          if (bool) {
            break label1362;
          }
          VipUtils.a(getResources(), this.jdField_b_of_type_AndroidWidgetImageView, localThrowable, getResources().getDrawable(2130847074));
          break label1362;
          label1903:
          if ((m >> 8 == 1) && (!bdfk.b()))
          {
            this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167170));
            this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(VipUtils.e(0));
            this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            break label1392;
          }
          if ((m >> 8 == 2) && (!bdfk.b()))
          {
            String str = bhjf.a(this.app, this.jdField_c_of_type_JavaLangString, EVIPSPEC.E_SP_SUPERVIP);
            if ((m & 0xF) == 1)
            {
              this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167170));
              if (!bool) {
                VipUtils.a(getResources(), this.jdField_b_of_type_AndroidWidgetImageView, str, getResources().getDrawable(2130847076));
              }
            }
            for (;;)
            {
              this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(VipUtils.e(1));
              this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
              break;
              this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167170));
              if (!bool) {
                VipUtils.a(getResources(), this.jdField_b_of_type_AndroidWidgetImageView, str, getResources().getDrawable(2130847074));
              }
            }
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(VipUtils.e(0));
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          break label1392;
          label2128:
          this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        }
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError) {}
    }
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() != 0) {
      return;
    }
    Object localObject = ((argb)aqxe.a().a(551)).a(4);
    FormSimpleItem localFormSimpleItem;
    if ((localObject != null) && (((argc)localObject).jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      boolean bool = ((bejv)this.app.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER)).a(4, 2, this.jdField_c_of_type_JavaLangString);
      localFormSimpleItem = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      if (!bool) {
        break label138;
      }
    }
    label138:
    for (localObject = "已开启";; localObject = "未开启")
    {
      localFormSimpleItem.setRightText((CharSequence)localObject);
      if (!beki.a(this.app, "SP_KEY_SING_TOGETHER_FRIEND_RED_DOT_SHOW", true, false)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130841419));
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
  }
  
  private void m()
  {
    Object localObject1 = View.inflate(this, 2131558907, null);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)((View)localObject1).findViewById(2131365022));
    this.jdField_a_of_type_ComTencentWidgetXListView.setPadding(0, 0, 0, 0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_AndroidViewView = View.inflate(this, 2131558906, null);
    this.jdField_a_of_type_Blha = new blha(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Blha);
    super.setContentView((View)localObject1);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131378103);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131378105));
    this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131364679));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378104));
    this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378101));
    this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131377446));
    this.jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131378875));
    this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378876));
    this.l = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376520));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131378102));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131364054));
    this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130839496);
    if (b()) {
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    }
    int m;
    label567:
    label628:
    String str;
    label708:
    label876:
    boolean bool;
    label828:
    label971:
    QQAppInterface localQQAppInterface;
    if (this.jdField_a_of_type_Int == 1036)
    {
      if (a(this.jdField_c_of_type_JavaLangString))
      {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      }
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      if ((1001 == this.jdField_a_of_type_Int) || (10002 == this.jdField_a_of_type_Int)) {
        C();
      }
      if ((this.jdField_a_of_type_Int == 1037) || (this.jdField_a_of_type_Int == 1044) || (this.jdField_a_of_type_Int == 1045))
      {
        this.jdField_k_of_type_AndroidWidgetTextView = a((View)localObject1, this.jdField_a_of_type_AndroidViewView);
        n();
      }
      if (!a()) {
        this.l.setVisibility(8);
      }
      this.l.setOnClickListener(this);
      if (this.jdField_k_of_type_AndroidWidgetTextView == null) {
        this.jdField_k_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131378106));
      }
      if (AppSetting.jdField_c_of_type_Boolean)
      {
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.setContentDescription(getString(2131693261));
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131690810));
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131690812));
        localObject1 = this.jdField_a_of_type_AndroidWidgetButton;
        if ((1001 != this.jdField_a_of_type_Int) && (10002 != this.jdField_a_of_type_Int)) {
          break label1472;
        }
        if (!this.jdField_a_of_type_Boolean) {
          break label1465;
        }
        m = 2131696101;
        ((Button)localObject1).setContentDescription(getString(m));
        this.jdField_k_of_type_AndroidWidgetTextView.setContentDescription(getString(2131689512));
        this.l.setContentDescription("从过滤消息移出");
      }
      if (this.jdField_a_of_type_Int != 10004) {
        break label1479;
      }
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setContentDescription("");
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_k_of_type_AndroidWidgetTextView.setOnClickListener(this);
      if ((this.jdField_a_of_type_Int != 1006) || (this.jdField_a_of_type_AndroidContentIntent == null) || (!this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isShieldMsgSwitchUnClickable", false))) {
        break label1490;
      }
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setClickable(false);
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setEnabled(false);
      localObject1 = this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
      if (localObject1 != null) {
        ((Switch)localObject1).setEnabled(false);
      }
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_k_of_type_AndroidWidgetTextView.setOnClickListener(this);
      if ((this.jdField_a_of_type_Int != 1010) && (this.jdField_a_of_type_Int != 1001) && (this.jdField_a_of_type_Int != 10002) && ((this.jdField_a_of_type_Int != 1022) || ((this.jdField_f_of_type_Int != 3007) && (this.jdField_f_of_type_Int != 2007) && (this.jdField_f_of_type_Int != 4007) && (this.jdField_f_of_type_Int != 3019) && (this.jdField_f_of_type_Int != 2019)))) {
        break label1524;
      }
      if (!axny.a(this.jdField_c_of_type_JavaLangString)) {
        break label1517;
      }
      m = 202;
      localObject1 = FaceDrawable.getStrangerFaceDrawable(this.app, m, this.jdField_c_of_type_JavaLangString, true);
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localObject1);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      if (this.jdField_a_of_type_Int == 1001) {
        o();
      }
      this.jdField_i_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      if ((this.jdField_a_of_type_Int == 1000) || (this.jdField_a_of_type_Int == 1004)) {
        this.jdField_j_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("troop_uin");
      }
      if ((this.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_Int == 10002)) {
        break label1682;
      }
      if (this.jdField_a_of_type_Int == 1006)
      {
        this.jdField_k_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
        if (!TextUtils.isEmpty(this.jdField_k_of_type_JavaLangString)) {
          break label1637;
        }
        this.jdField_g_of_type_Boolean = false;
      }
      localObject1 = (awtp)this.app.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
      if ((localObject1 != null) && (!TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString))) {
        this.jdField_f_of_type_Boolean = ((awtp)localObject1).a(this.jdField_i_of_type_JavaLangString);
      }
      if (QLog.isColorLevel())
      {
        str = this.jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder().append("initStrangerView, shieldMsgManger=");
        if (localObject1 != null) {
          break label1677;
        }
        bool = true;
        label1044:
        QLog.d(str, 2, bool);
      }
      label1059:
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "initStrangerView, curType=" + this.jdField_a_of_type_Int + ", mShieldUin=" + this.jdField_i_of_type_JavaLangString + ", mIsShield=" + this.jdField_f_of_type_Boolean + ", mShieldEnable=" + this.jdField_g_of_type_Boolean);
      }
      if (!a(this.jdField_a_of_type_Int)) {
        break label1786;
      }
      this.jdField_k_of_type_AndroidWidgetTextView.setVisibility(0);
      label1153:
      this.jdField_i_of_type_AndroidWidgetTextView.setText(this.jdField_d_of_type_JavaLangString);
      this.jdField_i_of_type_Boolean = true;
      B();
      localObject1 = new String[1];
      localObject1[0] = this.jdField_c_of_type_JavaLangString;
      if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler == null) {
        e();
      }
      if ((this.jdField_a_of_type_Int != 1010) && (this.jdField_a_of_type_Int != 1001) && (this.jdField_a_of_type_Int != 10002) && (this.jdField_a_of_type_Int != 10004) && ((this.jdField_a_of_type_Int != 1022) || ((this.jdField_f_of_type_Int != 3007) && (this.jdField_f_of_type_Int != 2007) && (this.jdField_f_of_type_Int != 4007) && (this.jdField_f_of_type_Int != 3019) && (this.jdField_f_of_type_Int != 2019)))) {
        break label1798;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.getStrangerRichStatus((String[])localObject1, true);
      label1305:
      if ((this.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_Int == 10002))
      {
        localQQAppInterface = this.app;
        if (this.jdField_a_of_type_Int != 1001) {
          break label1810;
        }
        localObject1 = "0";
        label1345:
        if (!this.jdField_a_of_type_Boolean) {
          break label1817;
        }
        str = "0";
        label1357:
        if (!this.jdField_f_of_type_Boolean) {
          break label1825;
        }
      }
    }
    label1677:
    label1682:
    label1810:
    label1817:
    label1825:
    for (Object localObject2 = "0";; localObject2 = "1")
    {
      bdla.b(localQQAppInterface, "dc00899", "grp_lbs", "", "c2c_tmp", "exp_aio_set", 0, 0, (String)localObject1, str, (String)localObject2, "");
      if ((this.jdField_a_of_type_Int == 1037) || (this.jdField_a_of_type_Int == 1044) || (this.jdField_a_of_type_Int == 1045)) {
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      }
      return;
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      break;
      label1465:
      m = 2131696099;
      break label567;
      label1472:
      m = 2131690809;
      break label567;
      label1479:
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      break label628;
      label1490:
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setClickable(true);
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setEnabled(true);
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      break label708;
      label1517:
      m = 200;
      break label828;
      label1524:
      if (this.jdField_a_of_type_Int == 1006)
      {
        localObject1 = FaceDrawable.getMobileFaceDrawable(this.app, this.jdField_c_of_type_JavaLangString, (byte)3);
        this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
        break label876;
      }
      if ((this.jdField_a_of_type_Int == 1044) || (this.jdField_a_of_type_Int == 1045))
      {
        localObject1 = asmj.a(this.app, this.jdField_c_of_type_JavaLangString);
        this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
        break label876;
      }
      localObject1 = FaceDrawable.getFaceDrawable(this.app, 1, this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localObject1);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      break label876;
      label1637:
      localObject1 = ContactUtils.getUinByPhoneNum(this.app, this.jdField_k_of_type_JavaLangString);
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        this.jdField_g_of_type_Boolean = false;
        break label971;
      }
      this.jdField_g_of_type_Boolean = true;
      this.jdField_i_of_type_JavaLangString = ((String)localObject1);
      break label971;
      bool = false;
      break label1044;
      localObject1 = ((anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(this.jdField_i_of_type_JavaLangString);
      if (QLog.isColorLevel())
      {
        str = this.jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder().append("initStrangerView, f=");
        if (localObject1 != null) {
          break label1773;
        }
      }
      label1773:
      for (bool = true;; bool = false)
      {
        QLog.d(str, 2, bool);
        if ((localObject1 == null) || (((Friends)localObject1).groupid != -1002)) {
          break label1778;
        }
        this.jdField_f_of_type_Boolean = true;
        break;
      }
      label1778:
      this.jdField_f_of_type_Boolean = false;
      break label1059;
      label1786:
      this.jdField_k_of_type_AndroidWidgetTextView.setVisibility(8);
      break label1153;
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.getStrangerRichStatus((String[])localObject1, false);
      break label1305;
      localObject1 = "1";
      break label1345;
      str = "1";
      break label1357;
    }
  }
  
  private void n()
  {
    int i3 = 8;
    int i1 = 1;
    int i2 = 0;
    Object localObject;
    int n;
    if ((((aslo)this.app.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).f() > 0) && (asss.a(this.app).a()))
    {
      m = 1;
      localObject = this.jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      if (m == 0) {
        break label181;
      }
      n = 0;
      label55:
      ((FormSimpleItem)localObject).setVisibility(n);
      localObject = this.jdField_j_of_type_AndroidWidgetTextView;
      n = i3;
      if (m != 0) {
        n = 0;
      }
      ((TextView)localObject).setVisibility(n);
      FormSimpleItem localFormSimpleItem = this.jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      if (m == 0) {
        break label187;
      }
      localObject = this;
      label95:
      localFormSimpleItem.setOnClickListener((View.OnClickListener)localObject);
      localObject = (ViewGroup.MarginLayoutParams)this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.getLayoutParams();
      i3 = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
      n = i2;
      if (m != 0) {
        n = AIOUtils.dp2px(12.0F, getResources());
      }
      ((ViewGroup.MarginLayoutParams)localObject).setMargins(i3, n, ((ViewGroup.MarginLayoutParams)localObject).rightMargin, ((ViewGroup.MarginLayoutParams)localObject).bottomMargin);
      localObject = this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (m == 0) {
        break label193;
      }
    }
    label181:
    label187:
    label193:
    for (int m = i1;; m = 3)
    {
      ((FormSwitchItem)localObject).setBgType(m);
      return;
      m = 0;
      break;
      n = 8;
      break label55;
      localObject = null;
      break label95;
    }
  }
  
  private void o()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(this.jdField_c_of_type_JavaLangString));
    if (axny.a(this.jdField_c_of_type_JavaLangString)) {}
    for (int m = 0;; m = 1)
    {
      ((aydj)this.app.getManager(QQManagerFactory.MINI_CARD_MANAGER)).a(localArrayList, m, new adra(this));
      return;
    }
  }
  
  private void p()
  {
    switch (this.app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0).getInt("message_roam_flag" + this.app.getCurrentAccountUin(), 0))
    {
    default: 
      return;
    case 5: 
      getResources().getString(2131716597);
      return;
    case 4: 
      getResources().getString(2131716595);
      return;
    case 3: 
      getResources().getString(2131716596);
      return;
    case 2: 
      getResources().getString(2131716598);
      return;
    }
    getResources().getString(2131716605);
  }
  
  private void q()
  {
    bdla.b(this.app, "dc00898", "", "", "0X800B6B9", "0X800B6B9", 0, 0, "", "", "", "");
    if (!NetworkUtil.isNetworkAvailable())
    {
      QQToast.a(getActivity(), 1, 2131692392, 0).a();
      return;
    }
    QQCustomDialog localQQCustomDialog = bhdj.a(this, 230).setMessage(getResources().getString(2131698561)).setPositiveButton(getResources().getString(2131698560), new adqk(this)).setNegativeButton(getResources().getString(2131698559), new adrg(this));
    localQQCustomDialog.show();
    ((TextView)localQQCustomDialog.findViewById(2131365644)).setGravity(17);
  }
  
  private void r()
  {
    bhdj.a(this, 230).setMessage(anvx.a(2131701217)).setPositiveButton(17039370, new adqm(this)).setNegativeButton(17039360, new adql(this)).show();
  }
  
  private void s()
  {
    Intent localIntent = new Intent(getActivity(), SelectMemberActivity.class);
    localIntent.putExtra("param_type", 3000);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_from", 1001);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_c_of_type_JavaLangString);
    localIntent.putStringArrayListExtra("param_uins_selected_default", localArrayList);
    localIntent.putExtra("param_entrance", 29);
    localIntent.putExtra("param_add_passed_members_to_result_set", true);
    localIntent.putExtra("param_max", 100 - localArrayList.size() - 1);
    startActivityForResult(localIntent, 2);
  }
  
  private void t()
  {
    ChatHistoryActivity.a(this, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_d_of_type_JavaLangString, 1001);
  }
  
  private void u()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("vasUsePreWebview", true);
    localIntent.putExtra("chatbg_intent_frinedUin", this.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_a_of_type_Int);
    localIntent.putExtra("bg_replace_entrance", 62);
    localIntent.putExtra("hide_left_button", false);
    localIntent.putExtra("show_right_close_button", false);
    localIntent.putExtra("individuation_url_type", 40305);
    VasWebviewUtil.openQQBrowserWithoutAD(this, bhnp.a(this, "background", ""), 33554432L, localIntent, true, 1);
  }
  
  private void v()
  {
    Intent localIntent = AIOUtils.setOpenAIOIntent(new Intent(this, SplashActivity.class), null);
    localIntent.putExtra("uin", this.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("uinname", this.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_a_of_type_Int);
    localIntent.putExtra("isNeedUpdate", this.jdField_c_of_type_Boolean);
    startActivity(localIntent);
  }
  
  private void w()
  {
    Object localObject = this.app.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 0);
    if ((((SharedPreferences)localObject).getBoolean("special_care_chat_setting", true)) && (!amci.a(this.jdField_c_of_type_JavaLangString, this.app)))
    {
      localObject = getResources().getDrawable(2130850430);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon((Drawable)localObject);
    }
    boolean bool;
    do
    {
      return;
      bool = ((SharedPreferences)localObject).getBoolean("special_care_red_point_one", false);
      ((SharedPreferences)localObject).getBoolean("special_care_red_point_two", false);
    } while (!bool);
    localObject = getResources().getDrawable(2130850427);
    getResources().getDrawable(2130839337);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon((Drawable)localObject);
  }
  
  private void x()
  {
    ChatSettingActivity.15 local15 = new ChatSettingActivity.15(this, new StringBuilder());
    if (!this.jdField_j_of_type_Boolean)
    {
      ThreadManager.post(local15, 8, null, true);
      a(2, getString(2131690034));
    }
  }
  
  private void y()
  {
    boolean bool = true;
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      a(2131692125, 1);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_e_of_type_Boolean);
    }
    do
    {
      return;
      z();
    } while (this.jdField_a_of_type_Int != 0);
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler == null)
    {
      e();
      return;
    }
    try
    {
      l1 = Long.parseLong(this.jdField_c_of_type_JavaLangString);
      if (l1 > 0L)
      {
        FriendListHandler localFriendListHandler = this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
        if (!this.jdField_e_of_type_Boolean)
        {
          localFriendListHandler.changeFriendShieldFlag(l1, bool);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l1 = 0L;
        continue;
        bool = false;
      }
      a(1, anvx.a(2131701211));
    }
  }
  
  private void z()
  {
    int n = 0;
    Object localObject = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
    if (!this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())
    {
      m = 0;
      ((FormSimpleItem)localObject).setVisibility(m);
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if ((this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) || (this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())) {
        break label67;
      }
    }
    label67:
    for (int m = n;; m = 8)
    {
      ((FormSwitchItem)localObject).setVisibility(m);
      a();
      return;
      m = 8;
      break;
    }
  }
  
  public int a()
  {
    return 2;
  }
  
  public Dialog a()
  {
    return this.jdField_a_of_type_AndroidAppDialog;
  }
  
  public void a()
  {
    FormSimpleItem localFormSimpleItem = this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem;
    if ((!this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) && (!this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) && (!this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())) {}
    for (int m = 0;; m = 8)
    {
      localFormSimpleItem.setVisibility(m);
      return;
    }
  }
  
  public void a(Dialog paramDialog)
  {
    this.jdField_a_of_type_AndroidAppDialog = paramDialog;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString)
  {
    asqn.a(paramQQAppInterface, paramContext, paramInt, paramString, this);
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_AndroidAppDialog == null) {
      this.jdField_b_of_type_AndroidAppDialog = anxi.a(this, getString(2131694232), new adqx(this), new adqy(this));
    }
    if ((this.jdField_b_of_type_AndroidAppDialog != null) && (!this.jdField_b_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_b_of_type_AndroidAppDialog.show();
    }
  }
  
  public void c()
  {
    asqn.a(this.app, this, this.jdField_a_of_type_Int, this.jdField_c_of_type_JavaLangString, this);
  }
  
  public void d()
  {
    asqn.a(this);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_d_of_type_Boolean = false;
    if (-1 == paramInt2) {
      switch (paramInt1)
      {
      }
    }
    while ((paramInt2 != 0) || (3 != paramInt1) || (paramIntent == null) || (!paramIntent.getBooleanExtra("finchat", false)))
    {
      do
      {
        return;
        v();
        finish();
        return;
        a(paramIntent);
        return;
        b(paramIntent);
        return;
        switch (paramIntent.getIntExtra("param_subtype", -1))
        {
        default: 
          return;
        case 0: 
          bdla.b(this.app, "CliOper", "", "", "discuss", "creat_discuss_c2cplus", 0, 0, "", "", "", "");
          TroopUtils.enterTroopAio(this, paramIntent.getStringExtra("roomId"), true);
          return;
        }
        Intent localIntent = AIOUtils.setOpenAIOIntent(new Intent(this, SplashActivity.class), null);
        paramIntent = paramIntent.getStringExtra("roomId");
        localIntent.putExtra("uin", paramIntent);
        localIntent.putExtra("uintype", 3000);
        localIntent.putExtra("uinname", ContactUtils.getDiscussionName(this.app, getApplicationContext(), paramIntent));
        localIntent.putExtra("isBack2Root", true);
        startActivity(localIntent);
        finish();
        return;
      } while (paramIntent == null);
      this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("follow_flag", false);
      C();
      return;
    }
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentIntent = getIntent();
    e();
    f();
    h();
    i();
    j();
    bdla.b(this.app, "dc00899", "Grp_create", "", "search", "c2c_grpcreate_exp", 0, 0, "", "", "", "");
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_j_of_type_Boolean = true;
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
    try
    {
      if ((this.jdField_a_of_type_Bisl != null) && (this.jdField_a_of_type_Bisl.isShowing()) && (!isFinishing()))
      {
        this.jdField_a_of_type_Bisl.dismiss();
        this.jdField_a_of_type_Bisl = null;
      }
      if ((this.jdField_b_of_type_AndroidAppDialog != null) && (this.jdField_b_of_type_AndroidAppDialog.isShowing()))
      {
        this.jdField_b_of_type_AndroidAppDialog.dismiss();
        this.jdField_b_of_type_AndroidAppDialog = null;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        FaceDrawable localFaceDrawable;
        localThrowable.printStackTrace();
      }
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      localFaceDrawable = (FaceDrawable)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localFaceDrawable != null) {
        localFaceDrawable.cancel();
      }
    }
    if (this.jdField_b_of_type_JavaLangRefWeakReference != null)
    {
      localFaceDrawable = (FaceDrawable)this.jdField_b_of_type_JavaLangRefWeakReference.get();
      if (localFaceDrawable != null) {
        localFaceDrawable.cancel();
      }
    }
    g();
    this.jdField_i_of_type_Boolean = false;
  }
  
  public void doOnPause()
  {
    this.jdField_d_of_type_Boolean = true;
    E();
    ApngImage.pauseAll();
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    this.jdField_d_of_type_Boolean = false;
    if (this.jdField_a_of_type_MqqOsMqqHandler != null)
    {
      if (this.jdField_i_of_type_Boolean)
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(32);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(32, 200L);
      }
      if (this.jdField_a_of_type_Int == 0)
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(33);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(33, 200L);
      }
    }
    super.doOnResume();
    ApngImage.playByTag(27);
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem != null)
    {
      str = getString(2131716737);
      SpecialCareInfo localSpecialCareInfo = ((anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.jdField_c_of_type_JavaLangString);
      if ((localSpecialCareInfo != null) && (localSpecialCareInfo.globalSwitch != 0)) {
        break label256;
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getString(2131718420));
    }
    for (String str = str + getString(2131718420);; str = str + getString(2131718421))
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(str);
      if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_MqqOsMqqHandler != null) && (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(34)))
      {
        int m = axmy.a();
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(34, m * 1000);
      }
      if (this.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
        ((aocy)this.app.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).f();
      }
      l();
      return;
      label256:
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getString(2131718421));
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem != null))
    {
      p();
      ((VasExtensionHandler)this.app.getBusinessHandler(BusinessHandlerFactory.VAS_EXTENSION_HANDLER)).a(new String[] { this.app.getCurrentAccountUin() }, new int[] { 42255 });
    }
  }
  
  public void finish()
  {
    if ((1001 == this.jdField_a_of_type_Int) || (10002 == this.jdField_a_of_type_Int))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("follow_flag", this.jdField_a_of_type_Boolean);
      setResult(-1, localIntent);
    }
    super.finish();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Object localObject1;
    int m;
    if ((this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem != null) && (paramCompoundButton == this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())) {
      if (NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        ((anri)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).m(paramBoolean);
        localObject1 = this.app;
        if (paramBoolean)
        {
          m = 1;
          bdla.b((QQAppInterface)localObject1, "dc00898", "", "", "0X800723C", "0X800723C", 0, 0, String.valueOf(m), "", "", "");
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      m = 0;
      break;
      a(2131692125, 1);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
      localObject1 = this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (!paramBoolean) {}
      for (boolean bool = true;; bool = false)
      {
        ((FormSwitchItem)localObject1).setChecked(bool);
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
        break;
      }
      Object localObject2;
      if ((this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem != null) && (this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.a() == paramCompoundButton))
      {
        if (this.jdField_f_of_type_Boolean != paramBoolean)
        {
          localObject2 = this.app;
          if (paramBoolean)
          {
            localObject1 = "1";
            label193:
            bdla.b((QQAppInterface)localObject2, "CliOper", "", "", "0X80040EE", "0X80040EE", 0, 0, "2", (String)localObject1, "", "");
            localObject2 = new HashMap();
            if (!paramBoolean) {
              break label350;
            }
          }
          label350:
          for (localObject1 = "1";; localObject1 = "2")
          {
            ((HashMap)localObject2).put("button", localObject1);
            ((HashMap)localObject2).put("frompage", String.valueOf(a()));
            ((HashMap)localObject2).put("to_uid", this.jdField_c_of_type_JavaLangString);
            UserAction.onUserActionToTunnel("0AND0Y11VZ3PFHQD", "click#block_page#block", true, -1L, -1L, (Map)localObject2, true, true);
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onCheckedChanged, isCheck=" + paramBoolean);
            }
            A();
            break;
            localObject1 = "0";
            break label193;
          }
        }
      }
      else
      {
        if ((this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem != null) && (this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.a() == paramCompoundButton))
        {
          if (!FriendsStatusUtil.a(this.app, paramBoolean, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int))
          {
            this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
            localObject1 = this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem;
            if (!paramBoolean)
            {
              bool = true;
              label416:
              ((FormSwitchItem)localObject1).setChecked(bool);
              this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
              QQToast.a(this, 1, anvx.a(2131701223), 0).b(getTitleBarHeight());
            }
          }
          else
          {
            localObject1 = this.app;
            if (!paramBoolean) {
              break label502;
            }
          }
          label502:
          for (m = 1;; m = 2)
          {
            bdla.b((QQAppInterface)localObject1, "CliOper", "", "", "0X8009DCE", "0X8009DCE", 0, m, "0", "0", "", "");
            break;
            bool = false;
            break label416;
          }
        }
        if ((this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem != null) && (this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.a() == paramCompoundButton))
        {
          localObject1 = this.app;
          if (paramBoolean)
          {
            m = 1;
            label537:
            bdla.b((QQAppInterface)localObject1, "CliOper", "", "", "0X8009DCF", "0X8009DCF", 0, m, "0", "0", "", "");
            if (this.jdField_e_of_type_Boolean == paramBoolean) {
              continue;
            }
            if (!this.jdField_e_of_type_Boolean) {
              break label626;
            }
            bdla.b(this.app, "CliOper", "", "", "0X80040EE", "0X80040EE", 0, 0, "0", "1", "", "");
          }
          for (;;)
          {
            y();
            break;
            m = 2;
            break label537;
            label626:
            bdla.b(this.app, "CliOper", "", "", "0X80040EE", "0X80040EE", 0, 0, "0", "0", "", "");
          }
        }
        else
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a() == paramCompoundButton))
          {
            if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
            {
              a(2131692125, 1);
              this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
              if (!paramCompoundButton.isChecked()) {}
              for (bool = true;; bool = false)
              {
                ((FormSwitchItem)localObject1).setChecked(bool);
                this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
                break;
              }
            }
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_b_of_type_JavaLangString, 2, new Object[] { "mDoNotDisturb switch, now value=", Boolean.valueOf(paramCompoundButton.isChecked()) });
            }
            localObject1 = this.app;
            localObject2 = this.jdField_c_of_type_JavaLangString;
            m = this.jdField_a_of_type_Int;
            long l1;
            if (paramCompoundButton.isChecked())
            {
              l1 = bcrg.a();
              label806:
              FriendsStatusUtil.b((QQAppInterface)localObject1, (String)localObject2, m, l1, true, false);
              a();
              localObject1 = this.app;
              if (!paramCompoundButton.isChecked()) {
                break label876;
              }
            }
            label876:
            for (m = 1;; m = 2)
            {
              bdla.b((QQAppInterface)localObject1, "CliOper", "", "", "0X8009DCD", "0X8009DCD", 0, m, "0", "0", "", "");
              break;
              l1 = 0L;
              break label806;
            }
          }
          if ((this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem != null) && (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a() == paramCompoundButton))
          {
            if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
            {
              a(2131692125, 1);
              this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
              localObject1 = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
              if (!paramCompoundButton.isChecked()) {}
              for (bool = true;; bool = false)
              {
                ((FormSwitchItem)localObject1).setChecked(bool);
                this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
                break;
              }
            }
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_b_of_type_JavaLangString, 2, new Object[] { "mHiddenChat switch, now value=", Boolean.valueOf(paramCompoundButton.isChecked()) });
            }
            if (paramBoolean) {
              aome.a(this.app).a(this);
            }
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
            localObject2 = this.jdField_c_of_type_JavaLangString;
            m = this.jdField_a_of_type_Int;
            ((FriendListHandler)localObject1).setHiddenChat(new String[] { localObject2 }, new boolean[] { paramBoolean }, new int[] { m });
            a();
            if ((this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem != null))
            {
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
              if ((!this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) && (!this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()))
              {
                m = 0;
                label1103:
                ((FormSwitchItem)localObject1).setVisibility(m);
              }
            }
            else
            {
              localObject1 = this.app;
              if (!paramBoolean) {
                break label1160;
              }
            }
            label1160:
            for (m = 1;; m = 2)
            {
              bdla.b((QQAppInterface)localObject1, "dc00898", "", "", "0X800A348", "0X800A348", 1, m, "0", "0", "", "");
              break;
              m = 8;
              break label1103;
            }
          }
          if ((this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem != null) && (this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.a() == paramCompoundButton))
          {
            if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
            {
              a(2131692125, 1);
              this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
              localObject1 = this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem;
              if (!paramCompoundButton.isChecked()) {}
              for (bool = true;; bool = false)
              {
                ((FormSwitchItem)localObject1).setChecked(bool);
                this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
                break;
              }
            }
            ((aqlp)this.app.getManager(QQManagerFactory.C2C_SHORTCUT_BAR_MANAGER)).a(paramBoolean, this.jdField_c_of_type_JavaLangString);
            bdla.b(this.app, "dc00898", "", "", "0X800B331", "0X800B331", aqlp.a(this.app).a(this.jdField_c_of_type_JavaLangString), 0, "", "", "", "");
          }
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      s();
      bdla.b(this.app, "CliOper", "", "", "0X80040EB", "0X80040EB", 0, 0, "", "", "", "");
      bdla.b(this.app, "dc00899", "Grp_create", "", "search", "c2c_grpcreate_clk", 0, 0, "", "", "", "");
      continue;
      t();
      bdla.b(this.app, "dc00898", "", "", "0X800A0AC", "0X800A0AC", 0, 0, "", "", "", "");
      bdla.b(this.app, "CliOper", "", "", "0X80040EC", "0X80040EC", 0, 0, "0", "", "", "");
      continue;
      u();
      bdla.b(this.app, "CliOper", "", "", "0X8004E0E", "0X8004E0E", 0, 0, "", "", "", "");
      continue;
      J();
      bdla.b(this.app, "CliOper", "", "", "0X80040EF", "0X80040EF", 0, 0, "", "", "", "");
      continue;
      x();
      bdla.b(this.app, "CliOper", "", "", "0X80040F1", "0X80040F1", 0, 0, "", "", "", "");
      continue;
      bdla.b(this.app, "CliOper", "", "", "0X80040F3", "0X80040F3", 0, 0, "", "", "", "");
      if (a(this.jdField_a_of_type_Int)) {
        aaqo.a(this, this.jdField_a_of_type_Int, this.jdField_c_of_type_JavaLangString, this.app.getCurrentAccountUin(), this.jdField_f_of_type_JavaLangString);
      }
      Object localObject1 = new HashMap();
      ((HashMap)localObject1).put("to_uid", this.jdField_c_of_type_JavaLangString);
      ((HashMap)localObject1).put("frompage", String.valueOf(a()));
      UserAction.onUserActionToTunnel("0AND0Y11VZ3PFHQD", "click#complaint_page#complaint", true, -1L, -1L, (Map)localObject1, true, true);
      continue;
      bdla.b(this.app, "dc00898", "", "", "0X800A17C", "0X800A17C", 1, 0, "", "", "", "");
      a(this.app, this, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int, new adrb(this), 2);
      continue;
      F();
      continue;
      label665:
      label680:
      Object localObject2;
      if ((1001 == this.jdField_a_of_type_Int) || (10002 == this.jdField_a_of_type_Int))
      {
        QQAppInterface localQQAppInterface;
        label716:
        String str;
        if (this.jdField_a_of_type_Boolean)
        {
          localObject1 = "2";
          if (1001 != this.jdField_a_of_type_Int) {
            break label795;
          }
          a((String)localObject1);
          awtp localawtp = (awtp)this.app.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
          localQQAppInterface = this.app;
          if (!"1".equals(localObject1)) {
            break label803;
          }
          localObject2 = "follow_aio";
          if (this.jdField_a_of_type_Int != 1001) {
            break label811;
          }
          str = "0";
          label731:
          if (!"1".equals(localObject1)) {
            break label826;
          }
          if (!localawtp.a(this.jdField_c_of_type_JavaLangString)) {
            break label819;
          }
          localObject1 = "1";
        }
        for (;;)
        {
          bdla.b(localQQAppInterface, "dc00899", "grp_lbs", "", "c2c_tmp", (String)localObject2, 0, 0, str, "1", (String)localObject1, "");
          break;
          localObject1 = "1";
          break label665;
          label795:
          b((String)localObject1);
          break label680;
          label803:
          localObject2 = "unfollow_aio";
          break label716;
          label811:
          str = "1";
          break label731;
          label819:
          localObject1 = "0";
          continue;
          label826:
          localObject1 = "";
        }
      }
      if ((1036 == this.jdField_a_of_type_Int) && (this.jdField_f_of_type_Boolean))
      {
        r();
      }
      else
      {
        G();
        bdla.b(this.app, "CliOper", "", "", "0X80040F2", "0X80040F2", 0, 0, "", "", "", "");
        continue;
        H();
        continue;
        bhjh.a(this.app, this.jdField_c_of_type_JavaLangString, "VIA_AIO_CHATSETTINGS").onTouch(paramView, null);
        continue;
        f(this.jdField_c_of_type_JavaLangString);
        if (bhbx.b(this.jdField_c_of_type_JavaLangString)) {
          bdla.b(this.app, "dc00898", "", "", "0X8007FDE", "0X8007FDE", 0, 0, "", "", "", "");
        }
        bdla.b(this.app, "CliOper", "", "", "0X80040F0", "0X80040F0", 0, 0, "", "", "", "");
        continue;
        localObject1 = this.app.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 0);
        ((SharedPreferences)localObject1).edit().putBoolean("special_care_chat_setting", false).commit();
        if (((SharedPreferences)localObject1).getBoolean("special_care_red_point_one", false)) {
          ((SharedPreferences)localObject1).edit().putBoolean("special_care_red_point_one", false).commit();
        }
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
        amdh.a(this, this.jdField_c_of_type_JavaLangString, 2);
        bdla.b(null, "CliOper", "", "", "0X80050E4", "0X80050E4", 0, 0, "0", "", "", "");
        continue;
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("uin", this.jdField_c_of_type_JavaLangString);
        ((Intent)localObject1).putExtra("uintype", this.jdField_a_of_type_Int);
        MessageNotificationSettingFragment.a(this, (Intent)localObject1);
        continue;
        localObject1 = (GetRoamToastRsp)this.jdField_a_of_type_AndroidViewViewGroup.getTag();
        if (localObject1 != null)
        {
          bdla.b(this.app, "dc00898", "", "", "0X8009E32", "0X8009E32", 0, 0, "", "", "", "");
          localObject2 = new Intent(this, QQBrowserActivity.class);
          ((Intent)localObject2).putExtra("url", ((GetRoamToastRsp)localObject1).sUrl);
          ((Intent)localObject2).putExtra("isShowAd", false);
          startActivity((Intent)localObject2);
          continue;
          localObject1 = (GetRoamToastRsp)this.jdField_a_of_type_AndroidViewViewGroup.getTag();
          if (localObject1 != null)
          {
            bdla.b(this.app, "dc00898", "", "", "0X8009E77", "0X8009E77", 0, 0, "", "", "", "");
            ((aocy)this.app.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a((GetRoamToastRsp)localObject1);
          }
          this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
          continue;
          if (this.jdField_a_of_type_Int == 10008) {
            bdla.b(this.app, "dc00898", "", "", "0X800ADC7", "0X800ADC7", 0, 0, "", "", "", "");
          }
          aaqo.a(this, this.jdField_a_of_type_Int, this.jdField_c_of_type_JavaLangString, this.app.getCurrentAccountUin());
          continue;
          bdla.b(this.app, "dc00899", "c2c_AIO", "", "sing_tab", "clk_setsing", 0, 1, this.jdField_c_of_type_JavaLangString, "", "", "");
          localObject1 = (bejv)this.app.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
          boolean bool = ((bejv)localObject1).a(4, 2, this.jdField_c_of_type_JavaLangString);
          localObject2 = beki.a(bool, 5);
          if (bool) {
            ((bejv)localObject1).b(this, this.jdField_c_of_type_JavaLangString, 2, 4, 5, (Bundle)localObject2);
          }
          for (;;)
          {
            beki.a(this.app, "SP_KEY_SING_TOGETHER_FRIEND_RED_DOT_SHOW", false, false);
            l();
            break;
            ((bejv)localObject1).a(this, this.jdField_c_of_type_JavaLangString, 2, 4, 5, (Bundle)localObject2);
          }
          a(this.app, this, this.jdField_a_of_type_Int, this.jdField_c_of_type_JavaLangString);
          continue;
          q();
        }
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingActivity
 * JD-Core Version:    0.7.0.1
 */