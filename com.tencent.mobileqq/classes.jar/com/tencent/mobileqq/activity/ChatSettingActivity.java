package com.tencent.mobileqq.activity;

import MQQ.GetRoamToastRsp;
import Override;
import QQService.EVIPSPEC;
import aber;
import aeew;
import aeex;
import aeey;
import aeez;
import aefa;
import aefb;
import aefc;
import aefd;
import aefe;
import aeff;
import aefg;
import aefh;
import aefi;
import aefj;
import aefk;
import aefl;
import aefm;
import aefn;
import aefo;
import agej;
import aguy;
import aipm;
import amjp;
import amko;
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
import antf;
import anum;
import anuw;
import anyu;
import anyw;
import anzj;
import aoat;
import aocj;
import aodb;
import aofx;
import aogu;
import aogx;
import aohi;
import aoot;
import aorc;
import aqpc;
import aqpd;
import aqpe;
import aran;
import arjb;
import arjc;
import asam;
import asvi;
import asvt;
import ataa;
import atay;
import atce;
import atup;
import axad;
import axsi;
import axtp;
import bbst;
import bbvd;
import bcrg;
import bdgb;
import bdll;
import bejx;
import bekk;
import bguq;
import bhgm;
import bhgr;
import bhjx;
import bhlg;
import bhlq;
import bhnp;
import bhnv;
import bhpc;
import bhty;
import bhtz;
import bhua;
import bhyk;
import biwz;
import bizo;
import bjbs;
import bjdm;
import bkgt;
import blir;
import blrq;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.ThreadManager;
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
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import com.tencent.widget.XListView;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class ChatSettingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, atay
{
  private static final boolean jdField_b_of_type_Boolean = AppSetting.jdField_c_of_type_Boolean;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Intent jdField_a_of_type_AndroidContentIntent;
  private View jdField_a_of_type_AndroidViewView;
  public ViewGroup a;
  private Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  anuw jdField_a_of_type_Anuw = new aefa(this);
  anyu jdField_a_of_type_Anyu = new aeez(this);
  aocj jdField_a_of_type_Aocj = new aefc(this);
  private aofx jdField_a_of_type_Aofx = new aefm(this);
  private aogx jdField_a_of_type_Aogx = new aefn(this);
  private aohi jdField_a_of_type_Aohi = new aefb(this);
  aqpd jdField_a_of_type_Aqpd = new aeew(this);
  asvt jdField_a_of_type_Asvt = new aefg(this);
  private bbst jdField_a_of_type_Bbst = new aefd(this);
  private bjbs jdField_a_of_type_Bjbs;
  private blrq jdField_a_of_type_Blrq;
  QvipSpecialSoundManager jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager;
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  MutualMarkIconsView jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView;
  public RichStatus a;
  public FormSimpleItem a;
  public FormSwitchItem a;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  public String a;
  private WeakReference<aoot> jdField_a_of_type_JavaLangRefWeakReference;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new aeey(this);
  public boolean a;
  private final int jdField_b_of_type_Int = 1;
  private Dialog jdField_b_of_type_AndroidAppDialog;
  private View jdField_b_of_type_AndroidViewView;
  private Button jdField_b_of_type_AndroidWidgetButton;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private bjbs jdField_b_of_type_Bjbs;
  FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public FormSwitchItem b;
  private String jdField_b_of_type_JavaLangString = ChatSettingActivity.class.getSimpleName();
  private WeakReference<aoot> jdField_b_of_type_JavaLangRefWeakReference;
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
  TextView jdField_e_of_type_AndroidWidgetTextView;
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
  public TextView g;
  private FormSimpleItem jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private String jdField_g_of_type_JavaLangString;
  private boolean jdField_g_of_type_Boolean = true;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  private FormSimpleItem jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private String jdField_h_of_type_JavaLangString;
  private boolean jdField_h_of_type_Boolean;
  private TextView jdField_i_of_type_AndroidWidgetTextView;
  private String jdField_i_of_type_JavaLangString = "";
  private boolean jdField_i_of_type_Boolean;
  private TextView jdField_j_of_type_AndroidWidgetTextView;
  private String jdField_j_of_type_JavaLangString = "";
  private boolean jdField_j_of_type_Boolean;
  private String k = "";
  
  public ChatSettingActivity()
  {
    this.jdField_a_of_type_JavaLangString = "ChatSettingActivity.nearby";
  }
  
  private void A()
  {
    int m;
    if ((1001 == this.jdField_a_of_type_Int) || (10002 == this.jdField_a_of_type_Int)) {
      if (this.jdField_a_of_type_Boolean) {
        m = 2131695709;
      }
    }
    for (;;)
    {
      String str = getString(m);
      this.jdField_a_of_type_AndroidWidgetButton.setText(str);
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(str);
      return;
      m = 2131695707;
      continue;
      m = 2131690692;
    }
  }
  
  private void B()
  {
    int m = 0;
    Object localObject = (anyw)this.app.getManager(51);
    if ((localObject != null) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))) {
      this.jdField_e_of_type_Boolean = ((anyw)localObject).e(this.jdField_c_of_type_JavaLangString);
    }
    if (this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem != null)
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_e_of_type_Boolean);
      x();
      if (AppSetting.jdField_c_of_type_Boolean) {
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131690694));
      }
    }
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem == null) {
      return;
    }
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
      label138:
      if (jdField_b_of_type_Boolean)
      {
        return;
        m = 8;
        break;
        if (!this.app.c().equals(this.jdField_c_of_type_JavaLangString))
        {
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
          localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
          if ((this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) || (this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())) {
            break label209;
          }
        }
      }
    }
    for (;;)
    {
      ((FormSwitchItem)localObject).setVisibility(m);
      break label138;
      break;
      label209:
      m = 8;
    }
  }
  
  private void C()
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
  
  private void D()
  {
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.jdField_c_of_type_JavaLangString, 46);
    localAllInOne.jdField_a_of_type_Int = 19;
    localAllInOne.jdField_h_of_type_JavaLangString = bhlg.a(this.app, this.jdField_c_of_type_JavaLangString);
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
      localAllInOne.jdField_a_of_type_AndroidOsBundle = aber.a(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.i("NewReportPlugin", 2, String.format("start-profile: %s", new Object[] { localAllInOne.jdField_a_of_type_AndroidOsBundle }));
      }
      if ((this.jdField_a_of_type_Int != 1001) && (this.jdField_a_of_type_Int != 10002) && (this.jdField_a_of_type_Int != 10004) && (this.jdField_a_of_type_Int != 1010) && ((this.jdField_a_of_type_Int != 1022) || ((this.jdField_f_of_type_Int != 3007) && (this.jdField_f_of_type_Int != 2007) && (this.jdField_f_of_type_Int != 4007) && (this.jdField_f_of_type_Int != 3019) && (this.jdField_f_of_type_Int != 2019)))) {
        break label707;
      }
      localObject = new Intent(this, NearbyPeopleProfileActivity.class);
      if (this.jdField_a_of_type_Int == 1001)
      {
        localAllInOne.jdField_h_of_type_Int = 12;
        ((Intent)localObject).putExtra("frome_where", 21);
        label443:
        ((Intent)localObject).putExtra("AllInOne", localAllInOne);
        if (!bhjx.a(this.jdField_c_of_type_JavaLangString, this.app.getCurrentAccountUin())) {
          break label695;
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
        break label443;
      }
      if (this.jdField_a_of_type_Int == 1010)
      {
        localAllInOne.jdField_h_of_type_Int = 13;
        break label443;
      }
      localAllInOne.jdField_h_of_type_Int = 30;
      break label443;
      label695:
      ((Intent)localObject).putExtra("param_mode", 3);
    }
    label707:
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
  
  private void E()
  {
    int m = 3999;
    int n = 0;
    Object localObject = null;
    switch (this.jdField_a_of_type_Int)
    {
    }
    while (m == 3007)
    {
      if (aoat.a(this.app, this.jdField_c_of_type_JavaLangString)) {
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
    if ((m == 3019) && (!asam.a(this.app, this.jdField_c_of_type_JavaLangString)))
    {
      b();
      return;
    }
    label448:
    if ((this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 4) || (this.jdField_a_of_type_Int == 4000) || (this.jdField_a_of_type_Int == 1006)) {}
    for (localObject = AddFriendLogicActivity.a(this, 2, this.k, null, m, n, this.jdField_d_of_type_JavaLangString, null, null, setLastActivityName(), null);; localObject = AddFriendLogicActivity.a(this, 1, this.jdField_c_of_type_JavaLangString, (String)localObject, m, n, this.jdField_d_of_type_JavaLangString, null, null, setLastActivityName(), null))
    {
      if (m == 3094) {
        ((Intent)localObject).putExtra("entrance", 3);
      }
      if (localObject != null)
      {
        Serializable localSerializable = aipm.a(this, this.jdField_a_of_type_Int, false, false);
        if (localSerializable != null) {
          ((Intent)localObject).putExtra("param_wzry_data", localSerializable);
        }
      }
      startActivity((Intent)localObject);
      return;
    }
  }
  
  private void F()
  {
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.jdField_c_of_type_JavaLangString, 1);
    localAllInOne.jdField_h_of_type_JavaLangString = bhlg.a(this.app, this.jdField_c_of_type_JavaLangString);
    if (3000 != this.jdField_a_of_type_Int)
    {
      localAllInOne.jdField_f_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      localAllInOne.jdField_e_of_type_Int = this.jdField_a_of_type_Int;
    }
    localAllInOne.g = 5;
    localAllInOne.jdField_h_of_type_Int = 61;
    localAllInOne.jdField_a_of_type_AndroidOsBundle = aber.a(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.i("NewReportPlugin", 2, String.format("start-profile: %s", new Object[] { localAllInOne.jdField_a_of_type_AndroidOsBundle }));
    }
    ProfileActivity.a(this, localAllInOne, 3);
  }
  
  private void G()
  {
    if ((this.jdField_b_of_type_Bjbs != null) && (this.jdField_b_of_type_Bjbs.isShowing())) {}
    try
    {
      this.jdField_b_of_type_Bjbs.cancel();
      this.jdField_b_of_type_Bjbs = null;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void H()
  {
    ChatSettingActivity.16 local16 = new ChatSettingActivity.16(this);
    if (!this.jdField_j_of_type_Boolean) {
      ThreadManager.post(local16, 8, null, true);
    }
  }
  
  private void I()
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
  
  private void J()
  {
    boolean bool = FriendsStatusUtil.a(this.jdField_c_of_type_JavaLangString, this.app);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
      a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      if (AppSetting.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131693864));
      }
    }
  }
  
  private void K()
  {
    boolean bool = aguy.a(this.jdField_c_of_type_JavaLangString, this.app);
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
    SQLiteDatabase localSQLiteDatabase = this.app.a();
    if (localSQLiteDatabase == null) {}
    do
    {
      do
      {
        return 0;
        StringBuilder localStringBuilder = new StringBuilder(" where msgtype != ");
        localStringBuilder.append(-2006);
        paramString = bhnp.a(MessageRecord.getOldTableName(paramString, paramInt), MessageRecord.getTableName(paramString, paramInt), localSQLiteDatabase, localStringBuilder.toString());
      } while (paramString == null);
      paramString = localSQLiteDatabase.rawQuery(paramString.toString(), null);
    } while (paramString == null);
    long l;
    if ((paramString.getCount() > 0) && (paramStringBuilder != null))
    {
      paramString.moveToLast();
      if (paramInt != 3000) {
        break label153;
      }
      l = paramString.getLong(paramString.getColumnIndex("shmsgseq"));
    }
    for (;;)
    {
      if (l > 0L) {
        paramStringBuilder.append(String.valueOf(l));
      }
      paramInt = paramString.getCount();
      paramString.close();
      return paramInt;
      label153:
      if (paramInt == 0) {
        l = paramString.getLong(paramString.getColumnIndex("time"));
      } else if (paramInt == 1) {
        l = paramString.getLong(paramString.getColumnIndex("shmsgseq"));
      } else {
        l = 0L;
      }
    }
  }
  
  private TextView a(View paramView1, View paramView2)
  {
    if ((paramView1 == null) || (paramView2 == null) || (!(paramView2 instanceof ViewGroup))) {
      return null;
    }
    TextView localTextView = (TextView)paramView1.findViewById(2131378054);
    if (localTextView == null) {
      return null;
    }
    ((ViewGroup)paramView1).removeView(localTextView);
    paramView1 = localTextView.getLayoutParams();
    if ((paramView1 instanceof LinearLayout.LayoutParams)) {
      ((LinearLayout.LayoutParams)paramView1).setMargins(0, agej.a(5.0F, getResources()), 0, 0);
    }
    ((ViewGroup)paramView2).addView(localTextView);
    return localTextView;
  }
  
  private RichStatus a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = ((anyw)this.app.getManager(51)).a(paramString);
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
      localObject = (anyw)this.app.getManager(51);
    } while (localObject == null);
    Friends localFriends = ((anyw)localObject).e(paramString);
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
    if (bhnv.d(BaseApplication.getContext()))
    {
      if (!paramIntent.equals(this.jdField_g_of_type_JavaLangString))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(this.jdField_c_of_type_JavaLangString, paramIntent, false);
          this.jdField_e_of_type_Int |= 0x1;
          a(paramIntent);
          e(getString(2131690635));
          this.jdField_a_of_type_Bjbs.show();
          return;
        }
        a(2131693035, 1);
        return;
      }
      a(2131693021, 0);
      return;
    }
    a(2131694005, 1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, int paramInt1, aefo paramaefo, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "startDelAllMsg......");
    }
    biwz localbiwz = new biwz(paramActivity, paramQQAppInterface, true);
    localbiwz.a(new aefh(paramaefo, paramQQAppInterface, paramString, paramInt1, paramActivity));
    localbiwz.a(paramInt2);
  }
  
  private void a(RichStatus paramRichStatus, TextView paramTextView)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = paramRichStatus;
    this.jdField_g_of_type_AndroidWidgetTextView = paramTextView;
    if ((paramRichStatus == null) || (paramTextView == null)) {
      return;
    }
    Object localObject = paramRichStatus.toSpannableString(null);
    if (!TextUtils.isEmpty(paramRichStatus.actionText))
    {
      localObject = new SpannableStringBuilder((CharSequence)localObject);
      ((SpannableStringBuilder)localObject).insert(0, "[S] ");
      bbvd localbbvd = (bbvd)this.app.getManager(15);
      if (localbbvd != null) {}
      for (paramRichStatus = localbbvd.a(paramRichStatus.actionId, 200);; paramRichStatus = bhgm.a(getResources(), 2130849586))
      {
        paramRichStatus = new bjdm(getResources(), paramRichStatus, false, false);
        int m = (int)(paramTextView.getTextSize() * 1.1F + 0.5F);
        paramRichStatus.setBounds(0, 0, m, m);
        paramRichStatus = new bizo(paramRichStatus, 0);
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
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      if (!TextUtils.isEmpty(paramString)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      }
    }
    else {
      return;
    }
    paramString = bhlg.a(this.app, this.jdField_c_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  private void a(String paramString, int paramInt)
  {
    QQToast.a(BaseApplication.getContext(), paramInt, paramString, 0).b(getTitleBarHeight());
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
    return ((anyw)this.app.getManager(51)).b(paramString);
  }
  
  private String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    anyw localanyw = (anyw)this.app.getManager(51);
    paramString = localanyw.e(paramString);
    if (paramString != null)
    {
      paramString = localanyw.a(paramString.groupid + "");
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
      paramIntent = ((anyw)this.app.getManager(51)).a(String.valueOf(m));
    } while (paramIntent == null);
    b(paramIntent.group_name);
  }
  
  private void b(String paramString)
  {
    if ((this.jdField_f_of_type_AndroidWidgetTextView != null) && (paramString != null)) {
      this.jdField_f_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  private void c(String paramString)
  {
    Object localObject = this.app.a().b(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int);
    if ((localObject != null) && (!((List)localObject).isEmpty())) {
      if (!((MessageRecord)((List)localObject).get(((List)localObject).size() - 1)).isSendFromLocal()) {}
    }
    for (long l1 = ((MessageRecord)((List)localObject).get(((List)localObject).size() - 1)).time + 2L;; l1 = 0L) {
      for (;;)
      {
        this.app.a().a(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int);
        this.app.a().e(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int);
        this.app.a().a(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int);
        if (paramString != null) {}
        try
        {
          l2 = Long.parseLong(paramString);
          l1 = Math.max(l2, l1);
          if (l1 > 0L) {
            this.app.a().a(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int, l1);
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
  
  private void d(String paramString)
  {
    blir localblir = blir.a(this);
    if (bhjx.b(paramString)) {
      localblir.a(2131690487);
    }
    for (;;)
    {
      localblir.a(2131691332, 3);
      localblir.c(2131690580);
      localblir.a(new aeex(this, paramString, localblir));
      localblir.show();
      return;
      if (axsi.a(this.app, this.jdField_c_of_type_JavaLangString, true)) {
        localblir.a(2131690489);
      } else {
        localblir.a(2131690488);
      }
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.a(1));
  }
  
  private void e(String paramString)
  {
    this.jdField_a_of_type_Bjbs = new bjbs(this, getTitleBarHeight());
    this.jdField_a_of_type_Bjbs.setContentView(2131562849);
    if ((paramString == null) || ("".equals(paramString.trim())))
    {
      this.jdField_a_of_type_Bjbs.a(getString(2131717902));
      return;
    }
    this.jdField_a_of_type_Bjbs.a(paramString);
  }
  
  private void f()
  {
    addObserver(this.jdField_a_of_type_Anyu);
    addObserver(this.jdField_a_of_type_Aocj);
    addObserver(this.jdField_a_of_type_Aohi);
    addObserver(this.jdField_a_of_type_Anuw);
    addObserver(this.jdField_a_of_type_Aofx);
    addObserver(this.jdField_a_of_type_Aogx);
    addObserver(this.jdField_a_of_type_Aqpd);
    addObserver(this.jdField_a_of_type_Asvt);
    this.app.setHandler(ChatSettingActivity.class, this.jdField_a_of_type_MqqOsMqqHandler);
    bbvd localbbvd = (bbvd)this.app.getManager(15);
    if (localbbvd != null) {
      localbbvd.a(this.jdField_a_of_type_Bbst);
    }
  }
  
  private void g()
  {
    removeObserver(this.jdField_a_of_type_Anyu);
    removeObserver(this.jdField_a_of_type_Aocj);
    removeObserver(this.jdField_a_of_type_Aohi);
    removeObserver(this.jdField_a_of_type_Anuw);
    removeObserver(this.jdField_a_of_type_Aofx);
    removeObserver(this.jdField_a_of_type_Aogx);
    removeObserver(this.jdField_a_of_type_Aqpd);
    removeObserver(this.jdField_a_of_type_Asvt);
    this.app.removeHandler(ChatSettingActivity.class);
    bbvd localbbvd = (bbvd)this.app.getManager(15);
    if (localbbvd != null)
    {
      localbbvd.b(this.jdField_a_of_type_Bbst);
      return;
    }
    this.jdField_a_of_type_Bbst = null;
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
      setTitle(2131690666);
      setLeftViewName(2131690384);
      setContentBackgroundResource(2130838778);
      return;
      k();
    }
  }
  
  private void j()
  {
    WebProcessManager localWebProcessManager = (WebProcessManager)this.app.getManager(13);
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
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)View.inflate(this, 2131559290, null));
    try
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundResource(2130838778);
      this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    }
    catch (Throwable localThrowable)
    {
      try
      {
        this.jdField_a_of_type_AndroidViewView = View.inflate(this, 2131558870, null);
        this.jdField_a_of_type_ComTencentWidgetXListView.setPadding(0, 0, 0, 0);
        this.jdField_a_of_type_Blrq = new blrq(this.jdField_a_of_type_AndroidViewView);
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Blrq);
        super.setContentView(this.jdField_a_of_type_ComTencentWidgetXListView);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131367159));
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367158));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367160));
        this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131381170));
        this.jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView = ((MutualMarkIconsView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371598));
        this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365209));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131377751));
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131364398));
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131377405));
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131364100));
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364114));
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131362141));
        this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365364));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131377879));
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131377411));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131377406));
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131377408));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131377407));
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131377409));
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131377404));
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364099));
        this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131376910));
        this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376911));
        this.jdField_a_of_type_AndroidViewView.findViewById(2131365371).setOnClickListener(this);
        this.jdField_e_of_type_AndroidWidgetTextView.setBackgroundResource(2130839440);
        this.jdField_a_of_type_AndroidViewView.findViewById(2131376904).setOnClickListener(this);
        this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
        this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
        boolean bool = aqpe.b(this.app);
        Object localObject1 = this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem;
        int m;
        if (bool)
        {
          m = 0;
          label618:
          ((FormSwitchItem)localObject1).setVisibility(m);
          localObject1 = this.jdField_b_of_type_AndroidWidgetTextView;
          if (!bool) {
            break label1785;
          }
          m = 0;
          label634:
          ((TextView)localObject1).setVisibility(m);
          if (bool)
          {
            this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(aqpe.a(this.app, this.jdField_c_of_type_JavaLangString));
            this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
            bdll.b(this.app, "dc00898", "", "", "0X800B330", "0X800B330", aqpc.a(this.app).a(this.jdField_c_of_type_JavaLangString), 0, "", "", "", "");
          }
          this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(FriendsStatusUtil.a(this.app, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int));
          this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
          this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
          this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
          this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
          this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
          if (Build.VERSION.SDK_INT > 25) {
            break label1791;
          }
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
          label806:
          if (AppSetting.jdField_c_of_type_Boolean)
          {
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(getString(2131693039));
            this.jdField_b_of_type_AndroidWidgetRelativeLayout.setContentDescription(getString(2131689627));
            this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131690647));
            this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131717919));
            this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131716142));
            this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131694045) + getString(2131717934));
            this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131693864));
            this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131695693));
            this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131690695));
            this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131694603));
            this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131694600));
            this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131689593));
            this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(getString(2131691332));
            this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(getString(2131689511));
            this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(anzj.a(2131718279));
          }
          this.jdField_g_of_type_JavaLangString = a(this.jdField_c_of_type_JavaLangString);
          if (this.jdField_g_of_type_JavaLangString == null) {
            this.jdField_g_of_type_JavaLangString = "";
          }
          a(this.jdField_g_of_type_JavaLangString);
          if (this.jdField_g_of_type_JavaLangString != null) {
            this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_g_of_type_JavaLangString);
          }
          Object localObject2 = bhty.a(this.app, this.jdField_c_of_type_JavaLangString);
          bool = bhty.a(localObject2[0]);
          if (bool)
          {
            localObject1 = bhtz.a(localObject2[0]);
            if ((!bhty.b(localObject2[1])) && (!((bhtz)localObject1).a()))
            {
              localObject2 = bhty.a(this.app, this.jdField_c_of_type_JavaLangString, (bhtz)localObject1, false);
              VipUtils.a(getResources(), this.jdField_b_of_type_AndroidWidgetImageView, (String)localObject2, getResources().getDrawable(bhty.a((bhtz)localObject1)));
            }
          }
          bhua.a(this.app, this.jdField_c_of_type_JavaLangString, "VIA_AIO_CHATSETTINGS").a();
          m = VipUtils.a(this.app, this.jdField_c_of_type_JavaLangString);
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_b_of_type_JavaLangString, 2, "bindView: vip=" + m);
          }
          if ((m >> 8 != 3) || (bdgb.b())) {
            break label1849;
          }
          localObject1 = bhty.a(this.app, this.jdField_c_of_type_JavaLangString, EVIPSPEC.E_SP_BIGCLUB);
          if ((m & 0xF) != 1) {
            break label1803;
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167133));
          if (!bool) {
            VipUtils.a(getResources(), this.jdField_b_of_type_AndroidWidgetImageView, (String)localObject1, getResources().getDrawable(2130847071));
          }
          label1327:
          NamePlateCfgInfo.vipNamePlateExposeReport(this.app, this.jdField_c_of_type_JavaLangString);
          this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(VipUtils.e(1));
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          label1357:
          if (this.jdField_c_of_type_JavaLangString != null)
          {
            localObject1 = aoot.a(this.app, this.jdField_c_of_type_JavaLangString, (byte)3);
            this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
          }
          this.jdField_h_of_type_JavaLangString = b(this.jdField_c_of_type_JavaLangString);
          if (this.jdField_h_of_type_JavaLangString == null) {
            this.jdField_h_of_type_JavaLangString = "";
          }
          b(this.jdField_h_of_type_JavaLangString);
          u();
          if (!bhjx.b(this.jdField_c_of_type_JavaLangString)) {
            break label2074;
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
          ((LinearLayout.LayoutParams)localObject1).topMargin = bhgr.a(this, 20.0F);
          this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
          localObject1 = ((anyw)this.app.getManager(51)).c(antf.aC);
          this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((Card)localObject1).babyQSwitch);
          this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
          ((anum)this.app.a(2)).v();
        }
        for (;;)
        {
          if (bkgt.b(this.app, this.jdField_c_of_type_JavaLangString)) {
            this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          }
          if (this.app != null)
          {
            B();
            I();
            J();
          }
          K();
          if (this.app.c().equals(this.jdField_c_of_type_JavaLangString))
          {
            this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
            this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
            this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
            this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
            this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
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
          break label618;
          label1785:
          m = 8;
          break label634;
          label1791:
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
          break label806;
          label1803:
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167133));
          if (bool) {
            break label1327;
          }
          VipUtils.a(getResources(), this.jdField_b_of_type_AndroidWidgetImageView, localThrowable, getResources().getDrawable(2130847069));
          break label1327;
          label1849:
          if ((m >> 8 == 1) && (!bdgb.b()))
          {
            this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167133));
            this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(VipUtils.e(0));
            this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            break label1357;
          }
          if ((m >> 8 == 2) && (!bdgb.b()))
          {
            String str = bhty.a(this.app, this.jdField_c_of_type_JavaLangString, EVIPSPEC.E_SP_SUPERVIP);
            if ((m & 0xF) == 1)
            {
              this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167133));
              if (!bool) {
                VipUtils.a(getResources(), this.jdField_b_of_type_AndroidWidgetImageView, str, getResources().getDrawable(2130847071));
              }
            }
            for (;;)
            {
              this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(VipUtils.e(1));
              this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
              break;
              this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167133));
              if (!bool) {
                VipUtils.a(getResources(), this.jdField_b_of_type_AndroidWidgetImageView, str, getResources().getDrawable(2130847069));
              }
            }
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(VipUtils.e(0));
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          break label1357;
          label2074:
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
    Object localObject = ((arjb)aran.a().a(551)).a(4);
    FormSimpleItem localFormSimpleItem;
    if ((localObject != null) && (((arjc)localObject).jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      boolean bool = ((bejx)this.app.getManager(339)).a(4, 2, this.jdField_c_of_type_JavaLangString);
      localFormSimpleItem = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      if (!bool) {
        break label138;
      }
    }
    label138:
    for (localObject = "已开启";; localObject = "未开启")
    {
      localFormSimpleItem.setRightText((CharSequence)localObject);
      if (!bekk.a(this.app, "SP_KEY_SING_TOGETHER_FRIEND_RED_DOT_SHOW", true, false)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130841377));
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
  }
  
  private void m()
  {
    Object localObject1 = View.inflate(this, 2131558872, null);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)((View)localObject1).findViewById(2131364907));
    this.jdField_a_of_type_ComTencentWidgetXListView.setPadding(0, 0, 0, 0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_AndroidViewView = View.inflate(this, 2131558871, null);
    this.jdField_a_of_type_Blrq = new blrq(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Blrq);
    super.setContentView((View)localObject1);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131378051);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131378053));
    this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131364575));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378052));
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378049));
    this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131377410));
    this.jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131378818));
    this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378819));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131378050));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131363955));
    this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130839440);
    int m;
    label509:
    String str;
    label560:
    label877:
    boolean bool;
    label640:
    label782:
    label949:
    label964:
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
        A();
      }
      if ((this.jdField_a_of_type_Int == 1037) || (this.jdField_a_of_type_Int == 1044) || (this.jdField_a_of_type_Int == 1045))
      {
        this.jdField_j_of_type_AndroidWidgetTextView = a((View)localObject1, this.jdField_a_of_type_AndroidViewView);
        n();
      }
      if (this.jdField_j_of_type_AndroidWidgetTextView == null) {
        this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131378054));
      }
      if (AppSetting.jdField_c_of_type_Boolean)
      {
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.setContentDescription(getString(2131693039));
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131690693));
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131690695));
        localObject1 = this.jdField_a_of_type_AndroidWidgetButton;
        if ((1001 != this.jdField_a_of_type_Int) && (10002 != this.jdField_a_of_type_Int)) {
          break label1377;
        }
        if (!this.jdField_a_of_type_Boolean) {
          break label1371;
        }
        m = 2131695709;
        ((Button)localObject1).setContentDescription(getString(m));
        this.jdField_j_of_type_AndroidWidgetTextView.setContentDescription(getString(2131689512));
      }
      if (this.jdField_a_of_type_Int != 10004) {
        break label1383;
      }
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setContentDescription("");
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_j_of_type_AndroidWidgetTextView.setOnClickListener(this);
      if ((this.jdField_a_of_type_Int != 1006) || (this.jdField_a_of_type_AndroidContentIntent == null) || (!this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isShieldMsgSwitchUnClickable", false))) {
        break label1394;
      }
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setClickable(false);
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setEnabled(false);
      localObject1 = this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
      if (localObject1 != null) {
        ((Switch)localObject1).setEnabled(false);
      }
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_j_of_type_AndroidWidgetTextView.setOnClickListener(this);
      if ((this.jdField_a_of_type_Int != 1010) && (this.jdField_a_of_type_Int != 1001) && (this.jdField_a_of_type_Int != 10002) && ((this.jdField_a_of_type_Int != 1022) || ((this.jdField_f_of_type_Int != 3007) && (this.jdField_f_of_type_Int != 2007) && (this.jdField_f_of_type_Int != 4007) && (this.jdField_f_of_type_Int != 3019) && (this.jdField_f_of_type_Int != 2019)))) {
        break label1421;
      }
      localObject1 = aoot.a(this.app, 200, this.jdField_c_of_type_JavaLangString, true);
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localObject1);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      this.jdField_i_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      if ((this.jdField_a_of_type_Int == 1000) || (this.jdField_a_of_type_Int == 1004)) {
        this.jdField_j_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("troop_uin");
      }
      if ((this.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_Int == 10002)) {
        break label1536;
      }
      if (this.jdField_a_of_type_Int == 1006)
      {
        this.k = this.jdField_c_of_type_JavaLangString;
        if (!TextUtils.isEmpty(this.k)) {
          break label1491;
        }
        this.jdField_g_of_type_Boolean = false;
      }
      localObject1 = (axad)this.app.getManager(16);
      if ((localObject1 != null) && (!TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString))) {
        this.jdField_f_of_type_Boolean = ((axad)localObject1).a(this.jdField_i_of_type_JavaLangString);
      }
      if (QLog.isColorLevel())
      {
        str = this.jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder().append("initStrangerView, shieldMsgManger=");
        if (localObject1 != null) {
          break label1531;
        }
        bool = true;
        QLog.d(str, 2, bool);
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "initStrangerView, curType=" + this.jdField_a_of_type_Int + ", mShieldUin=" + this.jdField_i_of_type_JavaLangString + ", mIsShield=" + this.jdField_f_of_type_Boolean + ", mShieldEnable=" + this.jdField_g_of_type_Boolean);
      }
      if (!a(this.jdField_a_of_type_Int)) {
        break label1639;
      }
      this.jdField_j_of_type_AndroidWidgetTextView.setVisibility(0);
      label1059:
      this.jdField_h_of_type_AndroidWidgetTextView.setText(this.jdField_d_of_type_JavaLangString);
      this.jdField_i_of_type_Boolean = true;
      z();
      localObject1 = new String[1];
      localObject1[0] = this.jdField_c_of_type_JavaLangString;
      if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler == null) {
        e();
      }
      if ((this.jdField_a_of_type_Int != 1010) && (this.jdField_a_of_type_Int != 1001) && (this.jdField_a_of_type_Int != 10002) && (this.jdField_a_of_type_Int != 10004) && ((this.jdField_a_of_type_Int != 1022) || ((this.jdField_f_of_type_Int != 3007) && (this.jdField_f_of_type_Int != 2007) && (this.jdField_f_of_type_Int != 4007) && (this.jdField_f_of_type_Int != 3019) && (this.jdField_f_of_type_Int != 2019)))) {
        break label1651;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a((String[])localObject1, true);
      label1211:
      if ((this.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_Int == 10002))
      {
        localQQAppInterface = this.app;
        if (this.jdField_a_of_type_Int != 1001) {
          break label1663;
        }
        localObject1 = "0";
        label1251:
        if (!this.jdField_a_of_type_Boolean) {
          break label1670;
        }
        str = "0";
        label1263:
        if (!this.jdField_f_of_type_Boolean) {
          break label1678;
        }
      }
    }
    label1421:
    label1678:
    for (Object localObject2 = "0";; localObject2 = "1")
    {
      bdll.b(localQQAppInterface, "dc00899", "grp_lbs", "", "c2c_tmp", "exp_aio_set", 0, 0, (String)localObject1, str, (String)localObject2, "");
      if ((this.jdField_a_of_type_Int == 1037) || (this.jdField_a_of_type_Int == 1044) || (this.jdField_a_of_type_Int == 1045)) {
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      }
      return;
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      break;
      label1371:
      m = 2131695707;
      break label509;
      label1377:
      m = 2131690692;
      break label509;
      label1383:
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      break label560;
      label1394:
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setClickable(true);
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setEnabled(true);
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      break label640;
      if (this.jdField_a_of_type_Int == 1006)
      {
        localObject1 = aoot.b(this.app, this.jdField_c_of_type_JavaLangString, (byte)3);
        this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
        break label782;
      }
      localObject1 = aoot.a(this.app, 1, this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localObject1);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      break label782;
      label1491:
      localObject1 = bhlg.e(this.app, this.k);
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        this.jdField_g_of_type_Boolean = false;
        break label877;
      }
      this.jdField_g_of_type_Boolean = true;
      this.jdField_i_of_type_JavaLangString = ((String)localObject1);
      break label877;
      label1531:
      bool = false;
      break label949;
      localObject1 = ((anyw)this.app.getManager(51)).e(this.jdField_i_of_type_JavaLangString);
      if (QLog.isColorLevel())
      {
        str = this.jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder().append("initStrangerView, f=");
        if (localObject1 != null) {
          break label1626;
        }
      }
      label1626:
      for (bool = true;; bool = false)
      {
        QLog.d(str, 2, bool);
        if ((localObject1 == null) || (((Friends)localObject1).groupid != -1002)) {
          break label1631;
        }
        this.jdField_f_of_type_Boolean = true;
        break;
      }
      label1631:
      this.jdField_f_of_type_Boolean = false;
      break label964;
      label1639:
      this.jdField_j_of_type_AndroidWidgetTextView.setVisibility(8);
      break label1059;
      label1651:
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a((String[])localObject1, false);
      break label1211;
      label1663:
      localObject1 = "1";
      break label1251;
      str = "1";
      break label1263;
    }
  }
  
  private void n()
  {
    int i3 = 8;
    int i1 = 1;
    int i2 = 0;
    Object localObject;
    int n;
    if ((((asvi)this.app.getManager(264)).f() > 0) && (atce.a(this.app).a()))
    {
      m = 1;
      localObject = this.jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      if (m == 0) {
        break label181;
      }
      n = 0;
      label55:
      ((FormSimpleItem)localObject).setVisibility(n);
      localObject = this.jdField_i_of_type_AndroidWidgetTextView;
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
        n = agej.a(12.0F, getResources());
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
    switch (this.app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0).getInt("message_roam_flag" + this.app.getCurrentAccountUin(), 0))
    {
    default: 
      return;
    case 5: 
      getResources().getString(2131716002);
      return;
    case 4: 
      getResources().getString(2131716000);
      return;
    case 3: 
      getResources().getString(2131716001);
      return;
    case 2: 
      getResources().getString(2131716003);
      return;
    }
    getResources().getString(2131716010);
  }
  
  private void p()
  {
    bhlq.a(this, 230).setMessage(anzj.a(2131700631)).setPositiveButton(17039370, new aefl(this)).setNegativeButton(17039360, new aefk(this)).show();
  }
  
  private void q()
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
  
  private void r()
  {
    ChatHistoryActivity.a(this, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_d_of_type_JavaLangString, 1001);
  }
  
  private void s()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("vasUsePreWebview", true);
    localIntent.putExtra("chatbg_intent_frinedUin", this.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_a_of_type_Int);
    localIntent.putExtra("bg_replace_entrance", 62);
    localIntent.putExtra("hide_left_button", false);
    localIntent.putExtra("show_right_close_button", false);
    localIntent.putExtra("individuation_url_type", 40305);
    VasWebviewUtil.openQQBrowserWithoutAD(this, bhyk.a(this, "background", ""), 33554432L, localIntent, true, 1);
  }
  
  private void t()
  {
    Intent localIntent = agej.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtra("uin", this.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("uinname", this.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_a_of_type_Int);
    localIntent.putExtra("isNeedUpdate", this.jdField_c_of_type_Boolean);
    startActivity(localIntent);
  }
  
  private void u()
  {
    Object localObject = this.app.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 0);
    if ((((SharedPreferences)localObject).getBoolean("special_care_chat_setting", true)) && (!amjp.a(this.jdField_c_of_type_JavaLangString, this.app)))
    {
      localObject = getResources().getDrawable(2130850403);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon((Drawable)localObject);
    }
    boolean bool;
    do
    {
      return;
      bool = ((SharedPreferences)localObject).getBoolean("special_care_red_point_one", false);
      ((SharedPreferences)localObject).getBoolean("special_care_red_point_two", false);
    } while (!bool);
    localObject = getResources().getDrawable(2130850400);
    getResources().getDrawable(2130839281);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon((Drawable)localObject);
  }
  
  private void v()
  {
    ChatSettingActivity.9 local9 = new ChatSettingActivity.9(this, new StringBuilder());
    if (!this.jdField_j_of_type_Boolean)
    {
      ThreadManager.post(local9, 8, null, true);
      a(2, getString(2131689986));
    }
  }
  
  private void w()
  {
    boolean bool = true;
    if (!bhnv.d(BaseApplication.getContext()))
    {
      a(2131691989, 1);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_e_of_type_Boolean);
    }
    do
    {
      return;
      x();
    } while (this.jdField_a_of_type_Int != 0);
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler == null)
    {
      e();
      return;
    }
    try
    {
      l = Long.parseLong(this.jdField_c_of_type_JavaLangString);
      if (l > 0L)
      {
        FriendListHandler localFriendListHandler = this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
        if (!this.jdField_e_of_type_Boolean)
        {
          localFriendListHandler.a(l, bool);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l = 0L;
        continue;
        bool = false;
      }
      a(1, anzj.a(2131700625));
    }
  }
  
  private void x()
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
  
  private void y()
  {
    if (!bhnv.d(BaseApplication.getContext()))
    {
      a(2131691989, 1);
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_f_of_type_Boolean);
    }
    for (;;)
    {
      return;
      Object localObject1 = (axad)this.app.getManager(16);
      if (localObject1 != null) {}
      try
      {
        l = Long.parseLong(this.jdField_i_of_type_JavaLangString);
        if (l > 0L)
        {
          Object localObject2 = new ArrayList();
          ((ArrayList)localObject2).add(Long.valueOf(l));
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "startStangerShield, tuin=" + l + ", mIsShield=" + this.jdField_f_of_type_Boolean + ", mIsFollowed=" + this.jdField_a_of_type_Boolean);
          }
          if (this.jdField_f_of_type_Boolean)
          {
            ((axad)localObject1).b(this.jdField_a_of_type_Int, (List)localObject2);
            this.jdField_h_of_type_Boolean = true;
            QQAppInterface localQQAppInterface = this.app;
            if (!this.jdField_f_of_type_Boolean) {
              break label515;
            }
            localObject2 = "cancel_aio";
            if (this.jdField_a_of_type_Int != 1001) {
              break label523;
            }
            str2 = "0";
            if (!this.jdField_f_of_type_Boolean) {
              break label531;
            }
            localObject1 = "";
            bdll.b(localQQAppInterface, "dc00899", "grp_lbs", "", "c2c_tmp", (String)localObject2, 0, 0, str2, "1", (String)localObject1, "");
            if ((this.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_Int == 10002) || (this.jdField_a_of_type_Int == 1003))
            {
              if (!this.jdField_f_of_type_Boolean) {
                break label552;
              }
              if ((this.jdField_c_of_type_JavaLangString != null) && (this.jdField_c_of_type_JavaLangString.length() > 0))
              {
                this.app.a().b(this.jdField_c_of_type_JavaLangString);
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
              break label591;
            }
            bdll.b(this.app, "CliOper", "", this.jdField_i_of_type_JavaLangString, "0X8004954", "0X8004954", 0, 0, "", "", "", "");
            return;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          long l = 0L;
          continue;
          if (this.jdField_a_of_type_Boolean)
          {
            if (ChatActivityUtils.a.size() > 5) {
              ChatActivityUtils.a.poll();
            }
            ChatActivityUtils.a.offer(l + "");
          }
          ((axad)localObject1).a(this.jdField_a_of_type_Int, localException);
          continue;
          a(1, anzj.a(2131700668));
          continue;
          label515:
          String str1 = "block_aio";
          continue;
          label523:
          String str2 = "1";
          continue;
          label531:
          if (this.jdField_a_of_type_Boolean)
          {
            localObject1 = "0";
          }
          else
          {
            localObject1 = "1";
            continue;
            label552:
            if ((this.jdField_c_of_type_JavaLangString != null) && (this.jdField_c_of_type_JavaLangString.length() > 0))
            {
              this.app.a().a(this.jdField_c_of_type_JavaLangString);
              this.jdField_h_of_type_Boolean = true;
            }
          }
        }
        label591:
        bdll.b(this.app, "CliOper", "", this.jdField_i_of_type_JavaLangString, "0X8004953", "0X8004953", 0, 0, "", "", "", "");
      }
    }
  }
  
  private void z()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "refreshShieldButton, mCurType=" + this.jdField_a_of_type_Int + ", mIsShield=" + this.jdField_f_of_type_Boolean);
    }
    if (this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem != null)
    {
      this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_f_of_type_Boolean);
      if (AppSetting.jdField_c_of_type_Boolean) {
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131690694));
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
    this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
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
    ataa.a(paramQQAppInterface, paramContext, paramInt, paramString, this);
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_AndroidAppDialog == null) {
      this.jdField_b_of_type_AndroidAppDialog = aoat.a(this, getString(2131693942), new aefe(this), new aeff(this));
    }
    if ((this.jdField_b_of_type_AndroidAppDialog != null) && (!this.jdField_b_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_b_of_type_AndroidAppDialog.show();
    }
  }
  
  public void c()
  {
    ataa.a(this.app, this, this.jdField_a_of_type_Int, this.jdField_c_of_type_JavaLangString, this);
  }
  
  public void d()
  {
    ataa.a(this);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
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
      return;
      t();
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
        bdll.b(this.app, "CliOper", "", "", "discuss", "creat_discuss_c2cplus", 0, 0, "", "", "", "");
        bguq.a(this, paramIntent.getStringExtra("roomId"), true);
        return;
      }
      Intent localIntent = agej.a(new Intent(this, SplashActivity.class), null);
      paramIntent = paramIntent.getStringExtra("roomId");
      localIntent.putExtra("uin", paramIntent);
      localIntent.putExtra("uintype", 3000);
      localIntent.putExtra("uinname", bhlg.a(this.app, getApplicationContext(), paramIntent));
      localIntent.putExtra("isBack2Root", true);
      startActivity(localIntent);
      finish();
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
    bdll.b(this.app, "dc00899", "Grp_create", "", "search", "c2c_grpcreate_exp", 0, 0, "", "", "", "");
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
      if ((this.jdField_a_of_type_Bjbs != null) && (this.jdField_a_of_type_Bjbs.isShowing()) && (!isFinishing()))
      {
        this.jdField_a_of_type_Bjbs.dismiss();
        this.jdField_a_of_type_Bjbs = null;
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
        aoot localaoot;
        localThrowable.printStackTrace();
      }
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      localaoot = (aoot)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localaoot != null) {
        localaoot.b();
      }
    }
    if (this.jdField_b_of_type_JavaLangRefWeakReference != null)
    {
      localaoot = (aoot)this.jdField_b_of_type_JavaLangRefWeakReference.get();
      if (localaoot != null) {
        localaoot.b();
      }
    }
    g();
    this.jdField_i_of_type_Boolean = false;
  }
  
  public void doOnPause()
  {
    this.jdField_d_of_type_Boolean = true;
    C();
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
      str = getString(2131716142);
      SpecialCareInfo localSpecialCareInfo = ((anyw)this.app.getManager(51)).a(this.jdField_c_of_type_JavaLangString);
      if ((localSpecialCareInfo != null) && (localSpecialCareInfo.globalSwitch != 0)) {
        break label254;
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getString(2131717797));
    }
    for (String str = str + getString(2131717797);; str = str + getString(2131717798))
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(str);
      if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_MqqOsMqqHandler != null) && (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(34)))
      {
        int m = axtp.a();
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(34, m * 1000);
      }
      if (this.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
        ((aogu)this.app.a(13)).f();
      }
      l();
      return;
      label254:
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getString(2131717798));
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem != null))
    {
      o();
      ((VasExtensionHandler)this.app.a(71)).a(new String[] { this.app.getCurrentAccountUin() }, new int[] { 42255 });
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
    Object localObject;
    int m;
    if ((this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem != null) && (paramCompoundButton == this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())) {
      if (bhnv.d(BaseApplication.getContext()))
      {
        ((anum)this.app.a(2)).m(paramBoolean);
        localObject = this.app;
        if (paramBoolean)
        {
          m = 1;
          bdll.b((QQAppInterface)localObject, "dc00898", "", "", "0X800723C", "0X800723C", 0, 0, String.valueOf(m), "", "", "");
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      m = 0;
      break;
      a(2131691989, 1);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
      localObject = this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (!paramBoolean) {}
      for (boolean bool = true;; bool = false)
      {
        ((FormSwitchItem)localObject).setChecked(bool);
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
        break;
      }
      if ((this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem != null) && (this.jdField_g_of_type_ComTencentMobileqqWidgetFormSwitchItem.a() == paramCompoundButton))
      {
        if (this.jdField_f_of_type_Boolean != paramBoolean)
        {
          if (paramBoolean) {
            bdll.b(this.app, "CliOper", "", "", "0X80040EE", "0X80040EE", 0, 0, "2", "1", "", "");
          }
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onCheckedChanged, isCheck=" + paramBoolean);
            }
            y();
            break;
            bdll.b(this.app, "CliOper", "", "", "0X80040EE", "0X80040EE", 0, 0, "2", "0", "", "");
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
            localObject = this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem;
            if (!paramBoolean)
            {
              bool = true;
              label347:
              ((FormSwitchItem)localObject).setChecked(bool);
              this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
              QQToast.a(this, 1, anzj.a(2131700637), 0).b(getTitleBarHeight());
            }
          }
          else
          {
            localObject = this.app;
            if (!paramBoolean) {
              break label433;
            }
          }
          label433:
          for (m = 1;; m = 2)
          {
            bdll.b((QQAppInterface)localObject, "CliOper", "", "", "0X8009DCE", "0X8009DCE", 0, m, "0", "0", "", "");
            break;
            bool = false;
            break label347;
          }
        }
        if ((this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem != null) && (this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.a() == paramCompoundButton))
        {
          localObject = this.app;
          if (paramBoolean)
          {
            m = 1;
            label468:
            bdll.b((QQAppInterface)localObject, "CliOper", "", "", "0X8009DCF", "0X8009DCF", 0, m, "0", "0", "", "");
            if (this.jdField_e_of_type_Boolean == paramBoolean) {
              continue;
            }
            if (!this.jdField_e_of_type_Boolean) {
              break label557;
            }
            bdll.b(this.app, "CliOper", "", "", "0X80040EE", "0X80040EE", 0, 0, "0", "1", "", "");
          }
          for (;;)
          {
            w();
            break;
            m = 2;
            break label468;
            label557:
            bdll.b(this.app, "CliOper", "", "", "0X80040EE", "0X80040EE", 0, 0, "0", "0", "", "");
          }
        }
        else
        {
          String str;
          if ((this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a() == paramCompoundButton))
          {
            if (!bhnv.d(BaseApplication.getContext()))
            {
              a(2131691989, 1);
              this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
              localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
              if (!paramCompoundButton.isChecked()) {}
              for (bool = true;; bool = false)
              {
                ((FormSwitchItem)localObject).setChecked(bool);
                this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
                break;
              }
            }
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_b_of_type_JavaLangString, 2, new Object[] { "mDoNotDisturb switch, now value=", Boolean.valueOf(paramCompoundButton.isChecked()) });
            }
            localObject = this.app;
            str = this.jdField_c_of_type_JavaLangString;
            m = this.jdField_a_of_type_Int;
            long l;
            if (paramCompoundButton.isChecked())
            {
              l = bcrg.a();
              label738:
              FriendsStatusUtil.b((QQAppInterface)localObject, str, m, l, true, false);
              a();
              localObject = this.app;
              if (!paramCompoundButton.isChecked()) {
                break label808;
              }
            }
            label808:
            for (m = 1;; m = 2)
            {
              bdll.b((QQAppInterface)localObject, "CliOper", "", "", "0X8009DCD", "0X8009DCD", 0, m, "0", "0", "", "");
              break;
              l = 0L;
              break label738;
            }
          }
          if ((this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem != null) && (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a() == paramCompoundButton))
          {
            if (!bhnv.d(BaseApplication.getContext()))
            {
              a(2131691989, 1);
              this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
              localObject = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
              if (!paramCompoundButton.isChecked()) {}
              for (bool = true;; bool = false)
              {
                ((FormSwitchItem)localObject).setChecked(bool);
                this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
                break;
              }
            }
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_b_of_type_JavaLangString, 2, new Object[] { "mHiddenChat switch, now value=", Boolean.valueOf(paramCompoundButton.isChecked()) });
            }
            if (paramBoolean) {
              aorc.a(this.app).a(this);
            }
            localObject = this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
            str = this.jdField_c_of_type_JavaLangString;
            m = this.jdField_a_of_type_Int;
            ((FriendListHandler)localObject).a(new String[] { str }, new boolean[] { paramBoolean }, new int[] { m });
            a();
            localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
            if ((!this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) && (!this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()))
            {
              m = 0;
              label1022:
              ((FormSwitchItem)localObject).setVisibility(m);
              localObject = this.app;
              if (!paramBoolean) {
                break label1079;
              }
            }
            label1079:
            for (m = 1;; m = 2)
            {
              bdll.b((QQAppInterface)localObject, "dc00898", "", "", "0X800A348", "0X800A348", 1, m, "0", "0", "", "");
              break;
              m = 8;
              break label1022;
            }
          }
          if ((this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem != null) && (this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.a() == paramCompoundButton))
          {
            if (!bhnv.d(BaseApplication.getContext()))
            {
              a(2131691989, 1);
              this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
              localObject = this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem;
              if (!paramCompoundButton.isChecked()) {}
              for (bool = true;; bool = false)
              {
                ((FormSwitchItem)localObject).setChecked(bool);
                this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
                break;
              }
            }
            ((aqpc)this.app.getManager(380)).a(paramBoolean, this.jdField_c_of_type_JavaLangString);
            bdll.b(this.app, "dc00898", "", "", "0X800B331", "0X800B331", aqpc.a(this.app).a(this.jdField_c_of_type_JavaLangString), 0, "", "", "", "");
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
      q();
      bdll.b(this.app, "CliOper", "", "", "0X80040EB", "0X80040EB", 0, 0, "", "", "", "");
      bdll.b(this.app, "dc00899", "Grp_create", "", "search", "c2c_grpcreate_clk", 0, 0, "", "", "", "");
      continue;
      r();
      bdll.b(this.app, "dc00898", "", "", "0X800A0AC", "0X800A0AC", 0, 0, "", "", "", "");
      bdll.b(this.app, "CliOper", "", "", "0X80040EC", "0X80040EC", 0, 0, "0", "", "", "");
      continue;
      s();
      bdll.b(this.app, "CliOper", "", "", "0X8004E0E", "0X8004E0E", 0, 0, "", "", "", "");
      continue;
      H();
      bdll.b(this.app, "CliOper", "", "", "0X80040EF", "0X80040EF", 0, 0, "", "", "", "");
      continue;
      v();
      bdll.b(this.app, "CliOper", "", "", "0X80040F1", "0X80040F1", 0, 0, "", "", "", "");
      continue;
      bdll.b(this.app, "CliOper", "", "", "0X80040F3", "0X80040F3", 0, 0, "", "", "", "");
      if (a(this.jdField_a_of_type_Int))
      {
        aber.a(this, this.jdField_a_of_type_Int, this.jdField_c_of_type_JavaLangString, this.app.getCurrentAccountUin(), this.jdField_f_of_type_JavaLangString);
        continue;
        bdll.b(this.app, "dc00898", "", "", "0X800A17C", "0X800A17C", 1, 0, "", "", "", "");
        a(this.app, this, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int, new aefi(this), 2);
        continue;
        D();
        continue;
        Object localObject1;
        label594:
        Object localObject2;
        if ((1001 == this.jdField_a_of_type_Int) || (10002 == this.jdField_a_of_type_Int))
        {
          Object localObject3;
          Object localObject4;
          if (this.jdField_a_of_type_Boolean)
          {
            localObject1 = "2";
            localObject3 = this.app;
            localObject4 = this.jdField_c_of_type_JavaLangString;
            if (this.jdField_a_of_type_Int != 1001) {
              break label765;
            }
            localObject2 = "2";
            label621:
            if (this.jdField_a_of_type_Int != 1001) {
              break label773;
            }
            label631:
            aodb.a((QQAppInterface)localObject3, (String)localObject4, (String)localObject2, (String)localObject1, 3, new aefj(this, (String)localObject1));
            axad localaxad = (axad)this.app.getManager(16);
            localObject4 = this.app;
            if (!"1".equals(localObject1)) {
              break label776;
            }
            localObject2 = "follow_aio";
            label686:
            if (this.jdField_a_of_type_Int != 1001) {
              break label784;
            }
            localObject3 = "0";
            label701:
            if (!"1".equals(localObject1)) {
              break label799;
            }
            if (!localaxad.a(this.jdField_c_of_type_JavaLangString)) {
              break label792;
            }
            localObject1 = "1";
          }
          for (;;)
          {
            bdll.b((QQAppInterface)localObject4, "dc00899", "grp_lbs", "", "c2c_tmp", (String)localObject2, 0, 0, (String)localObject3, "1", (String)localObject1, "");
            break;
            localObject1 = "1";
            break label594;
            label765:
            localObject2 = "1";
            break label621;
            label773:
            break label631;
            label776:
            localObject2 = "unfollow_aio";
            break label686;
            label784:
            localObject3 = "1";
            break label701;
            label792:
            localObject1 = "0";
            continue;
            label799:
            localObject1 = "";
          }
        }
        if ((1036 == this.jdField_a_of_type_Int) && (this.jdField_f_of_type_Boolean))
        {
          p();
        }
        else
        {
          E();
          bdll.b(this.app, "CliOper", "", "", "0X80040F2", "0X80040F2", 0, 0, "", "", "", "");
          continue;
          F();
          continue;
          bhua.a(this.app, this.jdField_c_of_type_JavaLangString, "VIA_AIO_CHATSETTINGS").onTouch(paramView, null);
          continue;
          d(this.jdField_c_of_type_JavaLangString);
          if (bhjx.b(this.jdField_c_of_type_JavaLangString)) {
            bdll.b(this.app, "dc00898", "", "", "0X8007FDE", "0X8007FDE", 0, 0, "", "", "", "");
          }
          bdll.b(this.app, "CliOper", "", "", "0X80040F0", "0X80040F0", 0, 0, "", "", "", "");
          continue;
          localObject1 = this.app.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 0);
          ((SharedPreferences)localObject1).edit().putBoolean("special_care_chat_setting", false).commit();
          if (((SharedPreferences)localObject1).getBoolean("special_care_red_point_one", false)) {
            ((SharedPreferences)localObject1).edit().putBoolean("special_care_red_point_one", false).commit();
          }
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
          amko.a(this, this.jdField_c_of_type_JavaLangString, 2);
          bdll.b(null, "CliOper", "", "", "0X80050E4", "0X80050E4", 0, 0, "0", "", "", "");
          continue;
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("uin", this.jdField_c_of_type_JavaLangString);
          ((Intent)localObject1).putExtra("uintype", this.jdField_a_of_type_Int);
          MessageNotificationSettingFragment.a(this, (Intent)localObject1);
          continue;
          localObject1 = (GetRoamToastRsp)this.jdField_a_of_type_AndroidViewViewGroup.getTag();
          if (localObject1 != null)
          {
            bdll.b(this.app, "dc00898", "", "", "0X8009E32", "0X8009E32", 0, 0, "", "", "", "");
            localObject2 = new Intent(this, QQBrowserActivity.class);
            ((Intent)localObject2).putExtra("url", ((GetRoamToastRsp)localObject1).sUrl);
            ((Intent)localObject2).putExtra("isShowAd", false);
            startActivity((Intent)localObject2);
            continue;
            localObject1 = (GetRoamToastRsp)this.jdField_a_of_type_AndroidViewViewGroup.getTag();
            if (localObject1 != null)
            {
              bdll.b(this.app, "dc00898", "", "", "0X8009E77", "0X8009E77", 0, 0, "", "", "", "");
              ((aogu)this.app.a(13)).a((GetRoamToastRsp)localObject1);
            }
            this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
            continue;
            if (this.jdField_a_of_type_Int == 10008) {
              bdll.b(this.app, "dc00898", "", "", "0X800ADC7", "0X800ADC7", 0, 0, "", "", "", "");
            }
            aber.a(this, this.jdField_a_of_type_Int, this.jdField_c_of_type_JavaLangString, this.app.getCurrentAccountUin());
            continue;
            bdll.b(this.app, "dc00899", "c2c_AIO", "", "sing_tab", "clk_setsing", 0, 1, this.jdField_c_of_type_JavaLangString, "", "", "");
            localObject1 = (bejx)this.app.getManager(339);
            boolean bool = ((bejx)localObject1).a(4, 2, this.jdField_c_of_type_JavaLangString);
            localObject2 = bekk.a(bool, 5);
            if (bool) {
              ((bejx)localObject1).b(this, this.jdField_c_of_type_JavaLangString, 2, 4, 5, (Bundle)localObject2);
            }
            for (;;)
            {
              bekk.a(this.app, "SP_KEY_SING_TOGETHER_FRIEND_RED_DOT_SHOW", false, false);
              l();
              break;
              ((bejx)localObject1).a(this, this.jdField_c_of_type_JavaLangString, 2, 4, 5, (Bundle)localObject2);
            }
            a(this.app, this, this.jdField_a_of_type_Int, this.jdField_c_of_type_JavaLangString);
          }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingActivity
 * JD-Core Version:    0.7.0.1
 */