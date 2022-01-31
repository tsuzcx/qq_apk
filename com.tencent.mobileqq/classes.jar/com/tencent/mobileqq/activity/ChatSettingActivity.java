package com.tencent.mobileqq.activity;

import MQQ.GetRoamToastRsp;
import QQService.EVIPSPEC;
import aajj;
import aajk;
import aajl;
import aajm;
import aajn;
import aajo;
import aajp;
import aajq;
import aajr;
import aajs;
import aajt;
import aaju;
import aajv;
import aajw;
import aajx;
import aajy;
import aajz;
import aciy;
import acxd;
import aeiv;
import ahwj;
import ajed;
import ajfi;
import ajfo;
import ajjh;
import ajjj;
import ajjy;
import ajlf;
import ajmm;
import ajnd;
import ajqr;
import ajrm;
import ajrp;
import ajry;
import ajyv;
import alzw;
import amfw;
import amfx;
import amis;
import amvy;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
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
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aoig;
import aqvv;
import arip;
import asax;
import ascd;
import avck;
import avev;
import awao;
import awnu;
import awqx;
import axmt;
import axng;
import azlj;
import azvq;
import azvv;
import azwp;
import azzz;
import babh;
import babr;
import badk;
import badq;
import bafb;
import bajr;
import bant;
import baot;
import bbhy;
import bbkk;
import bbms;
import bbmy;
import bboi;
import bcpn;
import begr;
import bepm;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.specialcare.QQSpecialCareSettingActivity;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.chat.ui.MessageNotificationSettingFragment;
import com.tencent.mobileqq.config.business.qvip.QVipBigClubSVIP9Config;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.NamePlateCfgInfo;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.mutualmark.view.MutualMarkIconsView;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.MultiImageTextView;
import com.tencent.widget.Switch;
import com.tencent.widget.XListView;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import xbq;

public class ChatSettingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private static final boolean jdField_b_of_type_Boolean = AppSetting.jdField_c_of_type_Boolean;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  ajfo jdField_a_of_type_Ajfo = new aajl(this);
  ajjh jdField_a_of_type_Ajjh = new aajk(this);
  ajmm jdField_a_of_type_Ajmm = new aajn(this);
  private ajqr jdField_a_of_type_Ajqr = new aajv(this);
  private ajrp jdField_a_of_type_Ajrp = new aajw(this);
  private ajry jdField_a_of_type_Ajry = new aajm(this);
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Intent jdField_a_of_type_AndroidContentIntent;
  private View jdField_a_of_type_AndroidViewView;
  public ViewGroup a;
  private Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private avck jdField_a_of_type_Avck = new aajo(this);
  private bbms jdField_a_of_type_Bbms;
  private bepm jdField_a_of_type_Bepm;
  QvipSpecialSoundManager jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager;
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  MutualMarkIconsView jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView;
  public RichStatus a;
  public FormSimpleItem a;
  public FormSwitchItem a;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  public String a;
  private WeakReference<azwp> jdField_a_of_type_JavaLangRefWeakReference;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new aajy(this);
  public boolean a;
  private final int jdField_b_of_type_Int = 1;
  private View jdField_b_of_type_AndroidViewView;
  private Button jdField_b_of_type_AndroidWidgetButton;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private bbms jdField_b_of_type_Bbms;
  public FormSimpleItem b;
  public FormSwitchItem b;
  private String jdField_b_of_type_JavaLangString = ChatSettingActivity.class.getSimpleName();
  private WeakReference<azwp> jdField_b_of_type_JavaLangRefWeakReference;
  private final int jdField_c_of_type_Int = 2;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  public TextView c;
  FormSimpleItem jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public FormSwitchItem c;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private final int jdField_d_of_type_Int = 3;
  TextView jdField_d_of_type_AndroidWidgetTextView;
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
  public TextView f;
  FormSimpleItem jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private String jdField_f_of_type_JavaLangString;
  private boolean jdField_f_of_type_Boolean;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  FormSimpleItem jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private String jdField_g_of_type_JavaLangString;
  private boolean jdField_g_of_type_Boolean = true;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  private FormSimpleItem jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private String jdField_h_of_type_JavaLangString;
  private boolean jdField_h_of_type_Boolean;
  private String jdField_i_of_type_JavaLangString = "";
  private boolean jdField_i_of_type_Boolean;
  private String jdField_j_of_type_JavaLangString = "";
  private boolean jdField_j_of_type_Boolean;
  private String k = "";
  
  public ChatSettingActivity()
  {
    this.jdField_a_of_type_JavaLangString = "ChatSettingActivity.nearby";
  }
  
  private void A()
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
  
  private void B()
  {
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.jdField_c_of_type_JavaLangString, 46);
    localAllInOne.jdField_a_of_type_Int = 19;
    localAllInOne.jdField_h_of_type_JavaLangString = babh.a(this.app, this.jdField_c_of_type_JavaLangString);
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
      localAllInOne.jdField_a_of_type_AndroidOsBundle = xbq.a(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.i("NewReportPlugin", 2, String.format("start-profile: %s", new Object[] { localAllInOne.jdField_a_of_type_AndroidOsBundle }));
      }
      if ((this.jdField_a_of_type_Int != 1001) && (this.jdField_a_of_type_Int != 10002) && (this.jdField_a_of_type_Int != 10004) && (this.jdField_a_of_type_Int != 1010) && ((this.jdField_a_of_type_Int != 1022) || ((this.jdField_f_of_type_Int != 3007) && (this.jdField_f_of_type_Int != 2007) && (this.jdField_f_of_type_Int != 4007) && (this.jdField_f_of_type_Int != 3019) && (this.jdField_f_of_type_Int != 2019)))) {
        break label657;
      }
      localObject = new Intent(this, NearbyPeopleProfileActivity.class);
      if (this.jdField_a_of_type_Int == 1001)
      {
        localAllInOne.jdField_h_of_type_Int = 12;
        ((Intent)localObject).putExtra("frome_where", 21);
        label415:
        ((Intent)localObject).putExtra("AllInOne", localAllInOne);
        if (!azzz.a(this.jdField_c_of_type_JavaLangString, this.app.getCurrentAccountUin())) {
          break label646;
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
      if (this.jdField_a_of_type_Int == 10002)
      {
        ((Intent)localObject).putExtra("frome_where", 22);
        break label415;
      }
      if (this.jdField_a_of_type_Int == 1010)
      {
        localAllInOne.jdField_h_of_type_Int = 13;
        break label415;
      }
      localAllInOne.jdField_h_of_type_Int = 30;
      break label415;
      label646:
      ((Intent)localObject).putExtra("param_mode", 3);
    }
    label657:
    if ((this.jdField_a_of_type_Int == 1037) || (this.jdField_a_of_type_Int == 1044))
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
  
  private void C()
  {
    int m = 3999;
    int n = 0;
    Object localObject = null;
    switch (this.jdField_a_of_type_Int)
    {
    }
    while (m == 3007)
    {
      if (ajlf.a(this.app, this.jdField_c_of_type_JavaLangString)) {
        break label404;
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
      int i1 = 3094;
      if (this.jdField_a_of_type_AndroidContentIntent.getIntExtra("ExtendFriendLimitChatFromeType", 0) == 1) {}
      for (m = 9;; m = 8)
      {
        n = m;
        m = i1;
        break;
      }
      m = 3072;
      n = 2;
    }
    if ((m == 3019) && (!amvy.a(this.app, this.jdField_c_of_type_JavaLangString)))
    {
      b();
      return;
    }
    label404:
    if ((this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 4) || (this.jdField_a_of_type_Int == 4000) || (this.jdField_a_of_type_Int == 1006)) {}
    for (localObject = AddFriendLogicActivity.a(this, 2, this.k, null, m, n, this.jdField_d_of_type_JavaLangString, null, null, setLastActivityName(), null);; localObject = AddFriendLogicActivity.a(this, 1, this.jdField_c_of_type_JavaLangString, (String)localObject, m, n, this.jdField_d_of_type_JavaLangString, null, null, setLastActivityName(), null))
    {
      if (m == 3094) {
        ((Intent)localObject).putExtra("entrance", 3);
      }
      if (localObject != null)
      {
        Serializable localSerializable = aeiv.a(this, this.jdField_a_of_type_Int, false, false);
        if (localSerializable != null) {
          ((Intent)localObject).putExtra("param_wzry_data", localSerializable);
        }
      }
      startActivity((Intent)localObject);
      return;
    }
  }
  
  private void D()
  {
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.jdField_c_of_type_JavaLangString, 1);
    localAllInOne.jdField_h_of_type_JavaLangString = babh.a(this.app, this.jdField_c_of_type_JavaLangString);
    if (3000 != this.jdField_a_of_type_Int)
    {
      localAllInOne.jdField_f_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      localAllInOne.jdField_e_of_type_Int = this.jdField_a_of_type_Int;
    }
    localAllInOne.g = 5;
    localAllInOne.jdField_h_of_type_Int = 61;
    localAllInOne.jdField_a_of_type_AndroidOsBundle = xbq.a(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.i("NewReportPlugin", 2, String.format("start-profile: %s", new Object[] { localAllInOne.jdField_a_of_type_AndroidOsBundle }));
    }
    ProfileActivity.a(this, localAllInOne, 3);
  }
  
  private void E()
  {
    if ((this.jdField_b_of_type_Bbms != null) && (this.jdField_b_of_type_Bbms.isShowing())) {}
    try
    {
      this.jdField_b_of_type_Bbms.cancel();
      this.jdField_b_of_type_Bbms = null;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void F()
  {
    ChatSettingActivity.14 local14 = new ChatSettingActivity.14(this);
    if (!this.jdField_j_of_type_Boolean) {
      ThreadManager.post(local14, 8, null, true);
    }
  }
  
  private void G()
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
  
  private void H()
  {
    boolean bool = FriendsStatusUtil.a(this.jdField_c_of_type_JavaLangString, this.app);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
      a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      if (AppSetting.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131628764));
      }
    }
  }
  
  private void I()
  {
    boolean bool = acxd.a(this.jdField_c_of_type_JavaLangString, this.app);
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
    SQLiteDatabase localSQLiteDatabase = this.app.b();
    if (localSQLiteDatabase == null) {}
    do
    {
      do
      {
        return 0;
        StringBuilder localStringBuilder = new StringBuilder(" where msgtype != ");
        localStringBuilder.append(-2006);
        paramString = badk.a(MessageRecord.getOldTableName(paramString, paramInt), MessageRecord.getTableName(paramString, paramInt), localSQLiteDatabase, localStringBuilder.toString());
      } while (paramString == null);
      paramString = localSQLiteDatabase.a(paramString.toString(), null);
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
    TextView localTextView = (TextView)paramView1.findViewById(2131310746);
    if (localTextView == null) {
      return null;
    }
    ((ViewGroup)paramView1).removeView(localTextView);
    paramView1 = localTextView.getLayoutParams();
    if ((paramView1 instanceof LinearLayout.LayoutParams)) {
      ((LinearLayout.LayoutParams)paramView1).setMargins(0, aciy.a(5.0F, getResources()), 0, 0);
    }
    ((ViewGroup)paramView2).addView(localTextView);
    return localTextView;
  }
  
  private RichStatus a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = ((ajjj)this.app.getManager(51)).a(paramString);
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
      localObject = (ajjj)this.app.getManager(51);
    } while (localObject == null);
    Friends localFriends = ((ajjj)localObject).e(paramString);
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
    bbmy.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).b(getTitleBarHeight());
  }
  
  private void a(int paramInt, String paramString)
  {
    if (this.jdField_d_of_type_Boolean) {
      return;
    }
    if (paramInt == -1)
    {
      bbmy.a(this, paramString, 0).b(getTitleBarHeight());
      return;
    }
    bbmy.a(this, paramInt, paramString, 0).b(getTitleBarHeight());
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
    if (badq.d(BaseApplication.getContext()))
    {
      if (!paramIntent.equals(this.jdField_g_of_type_JavaLangString))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(this.jdField_c_of_type_JavaLangString, paramIntent, false);
          this.jdField_e_of_type_Int |= 0x1;
          a(paramIntent);
          e(getString(2131625109));
          this.jdField_a_of_type_Bbms.show();
          return;
        }
        a(2131627883, 1);
        return;
      }
      a(2131627864, 0);
      return;
    }
    a(2131629006, 1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, int paramInt1, aajz paramaajz, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "startDelAllMsg......");
    }
    bbhy localbbhy = new bbhy(paramActivity, paramQQAppInterface, true);
    localbbhy.a(new aajr(paramaajz, paramQQAppInterface, paramString, paramInt1, paramActivity));
    localbbhy.a(paramInt2);
  }
  
  private void a(RichStatus paramRichStatus, TextView paramTextView)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = paramRichStatus;
    this.jdField_f_of_type_AndroidWidgetTextView = paramTextView;
    if ((paramRichStatus == null) || (paramTextView == null)) {
      return;
    }
    Object localObject = paramRichStatus.toSpannableString(null);
    if (!TextUtils.isEmpty(paramRichStatus.actionText))
    {
      localObject = new SpannableStringBuilder((CharSequence)localObject);
      ((SpannableStringBuilder)localObject).insert(0, "[S] ");
      avev localavev = (avev)this.app.getManager(15);
      if (localavev != null) {}
      for (paramRichStatus = localavev.a(paramRichStatus.actionId, 200);; paramRichStatus = azvq.a(getResources(), 2130848301))
      {
        paramRichStatus = new bboi(getResources(), paramRichStatus, false, false);
        int m = (int)(paramTextView.getTextSize() * 1.1F + 0.5F);
        paramRichStatus.setBounds(0, 0, m, m);
        paramRichStatus = new bbkk(paramRichStatus, 0);
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
    paramString = babh.a(this.app, this.jdField_c_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  private void a(String paramString, int paramInt)
  {
    bbmy.a(BaseApplication.getContext(), paramInt, paramString, 0).b(getTitleBarHeight());
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
    return ((ajjj)this.app.getManager(51)).b(paramString);
  }
  
  private String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    ajjj localajjj = (ajjj)this.app.getManager(51);
    paramString = localajjj.e(paramString);
    if (paramString != null)
    {
      paramString = localajjj.a(paramString.groupid + "");
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
      paramIntent = ((ajjj)this.app.getManager(51)).a(String.valueOf(m));
    } while (paramIntent == null);
    b(paramIntent.group_name);
  }
  
  private void b(String paramString)
  {
    if ((this.jdField_e_of_type_AndroidWidgetTextView != null) && (paramString != null)) {
      this.jdField_e_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.a(1));
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
  
  private void d()
  {
    addObserver(this.jdField_a_of_type_Ajjh);
    addObserver(this.jdField_a_of_type_Ajmm);
    addObserver(this.jdField_a_of_type_Ajry);
    addObserver(this.jdField_a_of_type_Ajfo);
    addObserver(this.jdField_a_of_type_Ajqr);
    addObserver(this.jdField_a_of_type_Ajrp);
    this.app.setHandler(ChatSettingActivity.class, this.jdField_a_of_type_MqqOsMqqHandler);
    avev localavev = (avev)this.app.getManager(15);
    if (localavev != null) {
      localavev.a(this.jdField_a_of_type_Avck);
    }
  }
  
  private void d(String paramString)
  {
    begr localbegr = begr.a(this);
    if (azzz.b(paramString)) {
      localbegr.a(2131624897);
    }
    for (;;)
    {
      localbegr.a(2131625939, 3);
      localbegr.c(2131625035);
      localbegr.a(new aajx(this, paramString, localbegr));
      localbegr.show();
      return;
      if (asax.a(this.app, this.jdField_c_of_type_JavaLangString, true)) {
        localbegr.a(2131624899);
      } else {
        localbegr.a(2131624898);
      }
    }
  }
  
  private void e()
  {
    removeObserver(this.jdField_a_of_type_Ajjh);
    removeObserver(this.jdField_a_of_type_Ajmm);
    removeObserver(this.jdField_a_of_type_Ajry);
    removeObserver(this.jdField_a_of_type_Ajfo);
    removeObserver(this.jdField_a_of_type_Ajqr);
    removeObserver(this.jdField_a_of_type_Ajrp);
    this.app.removeHandler(ChatSettingActivity.class);
    avev localavev = (avev)this.app.getManager(15);
    if (localavev != null)
    {
      localavev.b(this.jdField_a_of_type_Avck);
      return;
    }
    this.jdField_a_of_type_Avck = null;
  }
  
  private void e(String paramString)
  {
    this.jdField_a_of_type_Bbms = new bbms(this, getTitleBarHeight());
    this.jdField_a_of_type_Bbms.setContentView(2131496755);
    if ((paramString == null) || ("".equals(paramString.trim())))
    {
      this.jdField_a_of_type_Bbms.a(getString(2131653452));
      return;
    }
    this.jdField_a_of_type_Bbms.a(paramString);
  }
  
  private void f()
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
  
  private void g()
  {
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      l();
    }
    for (;;)
    {
      setTitle(2131625179);
      setLeftViewName(2131624770);
      setContentBackgroundResource(2130838503);
      return;
      i();
    }
  }
  
  private void h()
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
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)View.inflate(this, 2131493599, null));
    try
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundResource(2130838503);
      this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    }
    catch (Throwable localThrowable)
    {
      try
      {
        this.jdField_a_of_type_AndroidViewView = View.inflate(this, 2131493208, null);
        this.jdField_a_of_type_ComTencentWidgetXListView.setPadding(0, 0, 0, 0);
        this.jdField_a_of_type_Bepm = new bepm(this.jdField_a_of_type_AndroidViewView);
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Bepm);
        super.setContentView(this.jdField_a_of_type_ComTencentWidgetXListView);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131301101));
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131301100));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131301102));
        this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131313431));
        this.jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView = ((MutualMarkIconsView)this.jdField_a_of_type_AndroidViewView.findViewById(2131304936));
        this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131299280));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131303645));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131310435));
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131298527));
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131310156));
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131296532));
        this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299429));
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131310564));
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131310162));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131310157));
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131310159));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131310158));
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131310160));
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131310155));
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298256));
        this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131309723));
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131309724));
        this.jdField_a_of_type_AndroidViewView.findViewById(2131299436).setOnClickListener(this);
        this.jdField_d_of_type_AndroidWidgetTextView.setBackgroundResource(2130839144);
        this.jdField_a_of_type_AndroidViewView.findViewById(2131309717).setOnClickListener(this);
        this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
        this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(FriendsStatusUtil.a(this.app, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int));
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
        this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
        label684:
        int m;
        if (Build.VERSION.SDK_INT <= 25)
        {
          this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
          this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
          if (AppSetting.jdField_c_of_type_Boolean)
          {
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(getString(2131627895));
            this.jdField_b_of_type_AndroidWidgetRelativeLayout.setContentDescription(getString(2131624173));
            this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131625157));
            this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131653475));
            this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131651682));
            this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131629062) + getString(2131653496));
            this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131628764));
            this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131630935));
            this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131625222));
            this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131629820));
            this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131629817));
            this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131624132));
            this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131625939));
            this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(getString(2131624035));
            this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(ajjy.a(2131635931));
            this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(ajjy.a(2131653774));
          }
          this.jdField_g_of_type_JavaLangString = a(this.jdField_c_of_type_JavaLangString);
          if (this.jdField_g_of_type_JavaLangString == null) {
            this.jdField_g_of_type_JavaLangString = "";
          }
          a(this.jdField_g_of_type_JavaLangString);
          if (this.jdField_g_of_type_JavaLangString != null) {
            this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_g_of_type_JavaLangString);
          }
          m = bajr.a(this.app, this.jdField_c_of_type_JavaLangString);
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_b_of_type_JavaLangString, 2, "bindView: vip=" + m);
          }
          Object localObject = amis.c();
          if ((m >> 8 != 3) || (awnu.b())) {
            break label1672;
          }
          if ((m & 0xF) != 1) {
            break label1611;
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131101391));
          localObject = bajr.a(this.app, ((QVipBigClubSVIP9Config)localObject).mAPngIconUrl, this.jdField_c_of_type_JavaLangString, EVIPSPEC.E_SP_BIGCLUB);
          bajr.a(getResources(), this.jdField_b_of_type_AndroidWidgetImageView, (String)localObject, getResources().getDrawable(2130845973));
          label1116:
          NamePlateCfgInfo.vipNamePlateExposeReport(this.app, this.jdField_c_of_type_JavaLangString);
          this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(bajr.e(1));
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          label1146:
          if (this.jdField_c_of_type_JavaLangString != null)
          {
            localObject = azwp.a(this.app, this.jdField_c_of_type_JavaLangString, (byte)3);
            this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
          }
          this.jdField_h_of_type_JavaLangString = b(this.jdField_c_of_type_JavaLangString);
          if (this.jdField_h_of_type_JavaLangString == null) {
            this.jdField_h_of_type_JavaLangString = "";
          }
          b(this.jdField_h_of_type_JavaLangString);
          s();
          if (!azzz.b(this.jdField_c_of_type_JavaLangString)) {
            break label1912;
          }
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
          this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
          localObject = (LinearLayout.LayoutParams)this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject).topMargin = azvv.a(this, 20.0F);
          this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLayoutParams((ViewGroup.LayoutParams)localObject);
          this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
          localObject = ((ajjj)this.app.getManager(51)).c(ajed.aB);
          this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((Card)localObject).babyQSwitch);
          this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
          ((ajfi)this.app.a(2)).w();
        }
        for (;;)
        {
          if (bcpn.b(this.app, this.jdField_c_of_type_JavaLangString)) {
            this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          }
          if (this.app != null)
          {
            z();
            G();
            H();
          }
          I();
          if (this.app.c().equals(this.jdField_c_of_type_JavaLangString))
          {
            this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
            this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
            this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
            this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
            this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
            this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
            this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
            this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
            this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
          }
          if (!a(this.jdField_c_of_type_JavaLangString))
          {
            this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
            this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
          }
          j();
          k();
          return;
          localThrowable = localThrowable;
          QLog.i(this.jdField_b_of_type_JavaLangString, 1, localThrowable.toString());
          break;
          this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
          break label684;
          label1611:
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131101391));
          String str = bajr.a(this.app, localThrowable.mAPngIconUrl, this.jdField_c_of_type_JavaLangString, EVIPSPEC.E_SP_BIGCLUB);
          bajr.a(getResources(), this.jdField_b_of_type_AndroidWidgetImageView, str, getResources().getDrawable(2130845971));
          break label1116;
          label1672:
          if ((m >> 8 == 1) && (!awnu.b()))
          {
            this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131101391));
            this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(bajr.e(0));
            this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            break label1146;
          }
          if ((m >> 8 == 2) && (!awnu.b()))
          {
            if ((m & 0xF) == 1)
            {
              this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131101391));
              str = bajr.a(this.app, str.mAPngIconUrl, this.jdField_c_of_type_JavaLangString, EVIPSPEC.E_SP_SUPERVIP);
              bajr.a(getResources(), this.jdField_b_of_type_AndroidWidgetImageView, str, getResources().getDrawable(2130845973));
            }
            for (;;)
            {
              this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(bajr.e(1));
              this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
              break;
              this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131101391));
              str = bajr.a(this.app, str.mAPngIconUrl, this.jdField_c_of_type_JavaLangString, EVIPSPEC.E_SP_SUPERVIP);
              bajr.a(getResources(), this.jdField_b_of_type_AndroidWidgetImageView, str, getResources().getDrawable(2130845971));
            }
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(bajr.e(0));
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          break label1146;
          label1912:
          this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        }
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError) {}
    }
  }
  
  private void j()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem == null) {}
    while (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() != 0) {
      return;
    }
    boolean bool = ((ListenTogetherManager)this.app.getManager(331)).a(2, this.jdField_c_of_type_JavaLangString);
    FormSimpleItem localFormSimpleItem = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
    String str;
    if (bool)
    {
      str = ajjy.a(2131635922);
      localFormSimpleItem.setRightText(str);
      if (!aqvv.a(this.app, "listen_together_c2c_red_dot_show", true, false)) {
        break label149;
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130840934));
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(ajjy.a(2131635931) + " " + this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.a().getText());
      return;
      str = ajjy.a(2131635965);
      break;
      label149:
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() != 0) {
      return;
    }
    Object localObject = ((amfw)alzw.a().a(551)).a(4);
    FormSimpleItem localFormSimpleItem;
    if ((localObject != null) && (((amfx)localObject).jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      boolean bool = ((axmt)this.app.getManager(339)).a(4, 2, this.jdField_c_of_type_JavaLangString);
      localFormSimpleItem = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      if (!bool) {
        break label138;
      }
    }
    label138:
    for (localObject = "已开启";; localObject = "未开启")
    {
      localFormSimpleItem.setRightText((CharSequence)localObject);
      if (!axng.a(this.app, "SP_KEY_SING_TOGETHER_FRIEND_RED_DOT_SHOW", true, false)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130840934));
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
  }
  
  private void l()
  {
    Object localObject1 = View.inflate(this, 2131493210, null);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)((View)localObject1).findViewById(2131299006));
    this.jdField_a_of_type_ComTencentWidgetXListView.setPadding(0, 0, 0, 0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_AndroidViewView = View.inflate(this, 2131493209, null);
    this.jdField_a_of_type_Bepm = new bepm(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Bepm);
    super.setContentView((View)localObject1);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131310743);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131310745));
    this.jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131298692));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131310744));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131310741));
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131310161));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131310742));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131298120));
    this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130839144);
    int m;
    label462:
    label593:
    label735:
    String str;
    label513:
    label830:
    boolean bool;
    label902:
    label917:
    label1012:
    QQAppInterface localQQAppInterface;
    if (this.jdField_a_of_type_Int == 1036)
    {
      if (a(this.jdField_c_of_type_JavaLangString))
      {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      }
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      if ((1001 == this.jdField_a_of_type_Int) || (10002 == this.jdField_a_of_type_Int)) {
        y();
      }
      if ((this.jdField_a_of_type_Int == 1037) || (this.jdField_a_of_type_Int == 1044)) {
        this.jdField_h_of_type_AndroidWidgetTextView = a((View)localObject1, this.jdField_a_of_type_AndroidViewView);
      }
      if (this.jdField_h_of_type_AndroidWidgetTextView == null) {
        this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131310746));
      }
      if (AppSetting.jdField_c_of_type_Boolean)
      {
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.setContentDescription(getString(2131627895));
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131625218));
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131625222));
        localObject1 = this.jdField_a_of_type_AndroidWidgetButton;
        if ((1001 != this.jdField_a_of_type_Int) && (10002 != this.jdField_a_of_type_Int)) {
          break label1321;
        }
        if (!this.jdField_a_of_type_Boolean) {
          break label1314;
        }
        m = 2131630954;
        ((Button)localObject1).setContentDescription(getString(m));
        this.jdField_h_of_type_AndroidWidgetTextView.setContentDescription(getString(2131624038));
      }
      if (this.jdField_a_of_type_Int != 10004) {
        break label1328;
      }
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setContentDescription("");
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_h_of_type_AndroidWidgetTextView.setOnClickListener(this);
      if ((this.jdField_a_of_type_Int != 1006) || (this.jdField_a_of_type_AndroidContentIntent == null) || (!this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("isShieldMsgSwitchUnClickable", false))) {
        break label1339;
      }
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setClickable(false);
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setEnabled(false);
      localObject1 = this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
      if (localObject1 != null) {
        ((Switch)localObject1).setEnabled(false);
      }
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_h_of_type_AndroidWidgetTextView.setOnClickListener(this);
      if ((this.jdField_a_of_type_Int != 1010) && (this.jdField_a_of_type_Int != 1001) && (this.jdField_a_of_type_Int != 10002) && ((this.jdField_a_of_type_Int != 1022) || ((this.jdField_f_of_type_Int != 3007) && (this.jdField_f_of_type_Int != 2007) && (this.jdField_f_of_type_Int != 4007) && (this.jdField_f_of_type_Int != 3019) && (this.jdField_f_of_type_Int != 2019)))) {
        break label1366;
      }
      localObject1 = azwp.a(this.app, 200, this.jdField_c_of_type_JavaLangString, true);
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localObject1);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      this.jdField_i_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      if ((this.jdField_a_of_type_Int == 1000) || (this.jdField_a_of_type_Int == 1004)) {
        this.jdField_j_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("troop_uin");
      }
      if ((this.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_Int == 10002)) {
        break label1481;
      }
      if (this.jdField_a_of_type_Int == 1006)
      {
        this.k = this.jdField_c_of_type_JavaLangString;
        if (!TextUtils.isEmpty(this.k)) {
          break label1436;
        }
        this.jdField_g_of_type_Boolean = false;
      }
      localObject1 = (arip)this.app.getManager(16);
      if ((localObject1 != null) && (!TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString))) {
        this.jdField_f_of_type_Boolean = ((arip)localObject1).a(this.jdField_i_of_type_JavaLangString);
      }
      if (QLog.isColorLevel())
      {
        str = this.jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder().append("initStrangerView, shieldMsgManger=");
        if (localObject1 != null) {
          break label1476;
        }
        bool = true;
        QLog.d(str, 2, bool);
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "initStrangerView, curType=" + this.jdField_a_of_type_Int + ", mShieldUin=" + this.jdField_i_of_type_JavaLangString + ", mIsShield=" + this.jdField_f_of_type_Boolean + ", mShieldEnable=" + this.jdField_g_of_type_Boolean);
      }
      if (!a(this.jdField_a_of_type_Int)) {
        break label1584;
      }
      this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_g_of_type_AndroidWidgetTextView.setText(this.jdField_d_of_type_JavaLangString);
      this.jdField_i_of_type_Boolean = true;
      x();
      localObject1 = new String[1];
      localObject1[0] = this.jdField_c_of_type_JavaLangString;
      if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler == null) {
        c();
      }
      if ((this.jdField_a_of_type_Int != 1010) && (this.jdField_a_of_type_Int != 1001) && (this.jdField_a_of_type_Int != 10002) && (this.jdField_a_of_type_Int != 10004) && ((this.jdField_a_of_type_Int != 1022) || ((this.jdField_f_of_type_Int != 3007) && (this.jdField_f_of_type_Int != 2007) && (this.jdField_f_of_type_Int != 4007) && (this.jdField_f_of_type_Int != 3019) && (this.jdField_f_of_type_Int != 2019)))) {
        break label1596;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a((String[])localObject1, true);
      label1164:
      if ((this.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_Int == 10002))
      {
        localQQAppInterface = this.app;
        if (this.jdField_a_of_type_Int != 1001) {
          break label1608;
        }
        localObject1 = "0";
        label1204:
        if (!this.jdField_a_of_type_Boolean) {
          break label1615;
        }
        str = "0";
        label1216:
        if (!this.jdField_f_of_type_Boolean) {
          break label1623;
        }
      }
    }
    label1314:
    label1321:
    label1328:
    label1339:
    label1366:
    label1623:
    for (Object localObject2 = "0";; localObject2 = "1")
    {
      awqx.b(localQQAppInterface, "dc00899", "grp_lbs", "", "c2c_tmp", "exp_aio_set", 0, 0, (String)localObject1, str, (String)localObject2, "");
      if ((this.jdField_a_of_type_Int == 1037) || (this.jdField_a_of_type_Int == 1044)) {
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      }
      return;
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      break;
      m = 2131630952;
      break label462;
      m = 2131625217;
      break label462;
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      break label513;
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setClickable(true);
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setEnabled(true);
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      break label593;
      if (this.jdField_a_of_type_Int == 1006)
      {
        localObject1 = azwp.b(this.app, this.jdField_c_of_type_JavaLangString, (byte)3);
        this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
        break label735;
      }
      localObject1 = azwp.a(this.app, 1, this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localObject1);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      break label735;
      localObject1 = babh.e(this.app, this.k);
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        this.jdField_g_of_type_Boolean = false;
        break label830;
      }
      this.jdField_g_of_type_Boolean = true;
      this.jdField_i_of_type_JavaLangString = ((String)localObject1);
      break label830;
      bool = false;
      break label902;
      localObject1 = ((ajjj)this.app.getManager(51)).e(this.jdField_i_of_type_JavaLangString);
      if (QLog.isColorLevel())
      {
        str = this.jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder().append("initStrangerView, f=");
        if (localObject1 != null) {
          break label1571;
        }
      }
      for (bool = true;; bool = false)
      {
        QLog.d(str, 2, bool);
        if ((localObject1 == null) || (((Friends)localObject1).groupid != -1002)) {
          break label1576;
        }
        this.jdField_f_of_type_Boolean = true;
        break;
      }
      this.jdField_f_of_type_Boolean = false;
      break label917;
      this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(8);
      break label1012;
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a((String[])localObject1, false);
      break label1164;
      localObject1 = "1";
      break label1204;
      str = "1";
      break label1216;
    }
  }
  
  private void m()
  {
    switch (this.app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0).getInt("message_roam_flag" + this.app.getCurrentAccountUin(), 0))
    {
    default: 
      return;
    case 5: 
      getResources().getString(2131651481);
      return;
    case 4: 
      getResources().getString(2131651479);
      return;
    case 3: 
      getResources().getString(2131651480);
      return;
    case 2: 
      getResources().getString(2131651482);
      return;
    }
    getResources().getString(2131651499);
  }
  
  private void n()
  {
    babr.a(this, 230).setMessage(ajjy.a(2131635924)).setPositiveButton(17039370, new aaju(this)).setNegativeButton(17039360, new aajt(this)).show();
  }
  
  private void o()
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
  
  private void p()
  {
    ChatHistoryActivity.a(this, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_d_of_type_JavaLangString, 1001);
  }
  
  private void q()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("vasUsePreWebview", true);
    localIntent.putExtra("chatbg_intent_frinedUin", this.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_a_of_type_Int);
    localIntent.putExtra("bg_replace_entrance", 62);
    localIntent.putExtra("hide_left_button", false);
    localIntent.putExtra("show_right_close_button", false);
    localIntent.putExtra("individuation_url_type", 40305);
    VasWebviewUtil.openQQBrowserWithoutAD(this, bant.a(this, "background", ""), 33554432L, localIntent, true, 1);
  }
  
  private void r()
  {
    Intent localIntent = aciy.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtra("uin", this.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("uinname", this.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_a_of_type_Int);
    localIntent.putExtra("isNeedUpdate", this.jdField_c_of_type_Boolean);
    startActivity(localIntent);
  }
  
  private void s()
  {
    Object localObject = this.app.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 0);
    if ((((SharedPreferences)localObject).getBoolean("special_care_chat_setting", true)) && (!ahwj.a(this.jdField_c_of_type_JavaLangString, this.app)))
    {
      localObject = getResources().getDrawable(2130849056);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon((Drawable)localObject);
    }
    boolean bool;
    do
    {
      return;
      bool = ((SharedPreferences)localObject).getBoolean("special_care_red_point_one", false);
      ((SharedPreferences)localObject).getBoolean("special_care_red_point_two", false);
    } while (!bool);
    localObject = getResources().getDrawable(2130849053);
    getResources().getDrawable(2130838988);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon((Drawable)localObject);
  }
  
  private void t()
  {
    ChatSettingActivity.7 local7 = new ChatSettingActivity.7(this, new StringBuilder());
    if (!this.jdField_j_of_type_Boolean)
    {
      ThreadManager.post(local7, 8, null, true);
      a(2, getString(2131624487));
    }
  }
  
  private void u()
  {
    boolean bool = true;
    if (!badq.d(BaseApplication.getContext()))
    {
      a(2131626719, 1);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_e_of_type_Boolean);
    }
    do
    {
      return;
      v();
    } while (this.jdField_a_of_type_Int != 0);
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler == null)
    {
      c();
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
      a(1, ajjy.a(2131635918));
    }
  }
  
  private void v()
  {
    int n = 0;
    Object localObject = this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
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
  
  private void w()
  {
    if (!badq.d(BaseApplication.getContext()))
    {
      a(2131626719, 1);
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_f_of_type_Boolean);
    }
    for (;;)
    {
      return;
      Object localObject1 = (arip)this.app.getManager(16);
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
            ((arip)localObject1).b(this.jdField_a_of_type_Int, (List)localObject2);
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
            awqx.b(localQQAppInterface, "dc00899", "grp_lbs", "", "c2c_tmp", (String)localObject2, 0, 0, str2, "1", (String)localObject1, "");
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
            awqx.b(this.app, "CliOper", "", this.jdField_i_of_type_JavaLangString, "0X8004954", "0X8004954", 0, 0, "", "", "", "");
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
          ((arip)localObject1).a(this.jdField_a_of_type_Int, localException);
          continue;
          a(1, ajjy.a(2131635962));
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
        awqx.b(this.app, "CliOper", "", this.jdField_i_of_type_JavaLangString, "0X8004953", "0X8004953", 0, 0, "", "", "", "");
      }
    }
  }
  
  private void x()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "refreshShieldButton, mCurType=" + this.jdField_a_of_type_Int + ", mIsShield=" + this.jdField_f_of_type_Boolean);
    }
    if (this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem != null)
    {
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_f_of_type_Boolean);
      if (AppSetting.jdField_c_of_type_Boolean) {
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131625221));
      }
    }
    if ((this.jdField_a_of_type_Int == 1003) || (!this.jdField_g_of_type_Boolean)) {
      if ((this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem != null) && (this.jdField_c_of_type_AndroidViewView != null))
      {
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      }
    }
    while ((this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem == null) || (this.jdField_c_of_type_AndroidViewView == null)) {
      return;
    }
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
  }
  
  private void y()
  {
    int m;
    if ((1001 == this.jdField_a_of_type_Int) || (10002 == this.jdField_a_of_type_Int)) {
      if (this.jdField_a_of_type_Boolean) {
        m = 2131630954;
      }
    }
    for (;;)
    {
      String str = getString(m);
      this.jdField_a_of_type_AndroidWidgetButton.setText(str);
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(str);
      return;
      m = 2131630952;
      continue;
      m = 2131625217;
    }
  }
  
  private void z()
  {
    int m = 0;
    Object localObject = (ajjj)this.app.getManager(51);
    if ((localObject != null) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))) {
      this.jdField_e_of_type_Boolean = ((ajjj)localObject).e(this.jdField_c_of_type_JavaLangString);
    }
    if (this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem != null)
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_e_of_type_Boolean);
      v();
      if (AppSetting.jdField_c_of_type_Boolean) {
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131625221));
      }
    }
    if (this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem == null) {
      return;
    }
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if ((!this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) && (!this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()))
      {
        m = 0;
        ((FormSwitchItem)localObject).setVisibility(m);
      }
    }
    for (;;)
    {
      label139:
      if (jdField_b_of_type_Boolean)
      {
        return;
        m = 8;
        break;
        if (!this.app.c().equals(this.jdField_c_of_type_JavaLangString))
        {
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
          localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
          if ((this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) || (this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())) {
            break label210;
          }
        }
      }
    }
    for (;;)
    {
      ((FormSwitchItem)localObject).setVisibility(m);
      break label139;
      break;
      label210:
      m = 8;
    }
  }
  
  public void a()
  {
    FormSimpleItem localFormSimpleItem = this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem;
    if ((!this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) && (!this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) && (!this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())) {}
    for (int m = 0;; m = 8)
    {
      localFormSimpleItem.setVisibility(m);
      return;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null) {
      this.jdField_a_of_type_AndroidAppDialog = ajlf.a(this, getString(2131628890), new aajp(this), new aajq(this));
    }
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (!this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
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
      r();
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
        awqx.b(this.app, "CliOper", "", "", "discuss", "creat_discuss_c2cplus", 0, 0, "", "", "", "");
        azlj.a(this, paramIntent.getStringExtra("roomId"), true);
        return;
      }
      Intent localIntent = aciy.a(new Intent(this, SplashActivity.class), null);
      paramIntent = paramIntent.getStringExtra("roomId");
      localIntent.putExtra("uin", paramIntent);
      localIntent.putExtra("uintype", 3000);
      localIntent.putExtra("uinname", babh.a(this.app, getApplicationContext(), paramIntent));
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
    c();
    d();
    f();
    g();
    h();
    awqx.b(this.app, "dc00899", "Grp_create", "", "search", "c2c_grpcreate_exp", 0, 0, "", "", "", "");
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
      if ((this.jdField_a_of_type_Bbms != null) && (this.jdField_a_of_type_Bbms.isShowing()) && (!isFinishing()))
      {
        this.jdField_a_of_type_Bbms.dismiss();
        this.jdField_a_of_type_Bbms = null;
      }
      if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()))
      {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
        this.jdField_a_of_type_AndroidAppDialog = null;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        azwp localazwp;
        localThrowable.printStackTrace();
      }
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      localazwp = (azwp)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localazwp != null) {
        localazwp.a();
      }
    }
    if (this.jdField_b_of_type_JavaLangRefWeakReference != null)
    {
      localazwp = (azwp)this.jdField_b_of_type_JavaLangRefWeakReference.get();
      if (localazwp != null) {
        localazwp.a();
      }
    }
    e();
    this.jdField_i_of_type_Boolean = false;
  }
  
  public void doOnPause()
  {
    this.jdField_d_of_type_Boolean = true;
    A();
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
    if (this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem != null)
    {
      str = getString(2131651682);
      SpecialCareInfo localSpecialCareInfo = ((ajjj)this.app.getManager(51)).a(this.jdField_c_of_type_JavaLangString);
      if ((localSpecialCareInfo != null) && (localSpecialCareInfo.globalSwitch != 0)) {
        break label258;
      }
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getString(2131653316));
    }
    for (String str = str + getString(2131653316);; str = str + getString(2131653317))
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(str);
      if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_MqqOsMqqHandler != null) && (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(34)))
      {
        int m = ascd.a();
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(34, m * 1000);
      }
      if (this.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
        ((ajrm)this.app.a(13)).f();
      }
      j();
      k();
      return;
      label258:
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getString(2131653317));
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem != null))
    {
      m();
      ((baot)this.app.a(71)).a(new String[] { this.app.getCurrentAccountUin() }, new int[] { 42255 });
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
    if ((this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem != null) && (paramCompoundButton == this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.a())) {
      if (badq.d(BaseApplication.getContext()))
      {
        ((ajfi)this.app.a(2)).m(paramBoolean);
        paramCompoundButton = this.app;
        if (paramBoolean)
        {
          m = 1;
          awqx.b(paramCompoundButton, "dc00898", "", "", "0X800723C", "0X800723C", 0, 0, String.valueOf(m), "", "", "");
        }
      }
    }
    label270:
    label408:
    label563:
    do
    {
      do
      {
        do
        {
          return;
          m = 0;
          break;
          a(2131626719, 1);
          this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
          paramCompoundButton = this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem;
          if (!paramBoolean) {}
          for (paramBoolean = true;; paramBoolean = false)
          {
            paramCompoundButton.setChecked(paramBoolean);
            this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
            return;
          }
          if ((this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem == null) || (this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.a() != paramCompoundButton)) {
            break label270;
          }
        } while (this.jdField_f_of_type_Boolean == paramBoolean);
        if (paramBoolean) {
          awqx.b(this.app, "CliOper", "", "", "0X80040EE", "0X80040EE", 0, 0, "2", "1", "", "");
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onCheckedChanged, isCheck=" + paramBoolean);
          }
          w();
          return;
          awqx.b(this.app, "CliOper", "", "", "0X80040EE", "0X80040EE", 0, 0, "2", "0", "", "");
        }
        if ((this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem != null) && (this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.a() == paramCompoundButton))
        {
          boolean bool;
          if (!FriendsStatusUtil.a(this.app, paramBoolean, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int))
          {
            this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
            paramCompoundButton = this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem;
            if (!paramBoolean)
            {
              bool = true;
              paramCompoundButton.setChecked(bool);
              this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
              bbmy.a(this, 1, ajjy.a(2131635930), 0).b(getTitleBarHeight());
            }
          }
          else
          {
            paramCompoundButton = this.app;
            if (!paramBoolean) {
              break label408;
            }
          }
          for (m = 1;; m = 2)
          {
            awqx.b(paramCompoundButton, "CliOper", "", "", "0X8009DCE", "0X8009DCE", 0, m, "0", "0", "", "");
            return;
            bool = false;
            break;
          }
        }
        if ((this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem == null) || (this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.a() != paramCompoundButton)) {
          break label563;
        }
        paramCompoundButton = this.app;
        if (!paramBoolean) {
          break label523;
        }
        m = 1;
        awqx.b(paramCompoundButton, "CliOper", "", "", "0X8009DCF", "0X8009DCF", 0, m, "0", "0", "", "");
      } while (this.jdField_e_of_type_Boolean == paramBoolean);
      if (this.jdField_e_of_type_Boolean) {
        awqx.b(this.app, "CliOper", "", "", "0X80040EE", "0X80040EE", 0, 0, "0", "1", "", "");
      }
      for (;;)
      {
        u();
        return;
        m = 2;
        break;
        awqx.b(this.app, "CliOper", "", "", "0X80040EE", "0X80040EE", 0, 0, "0", "0", "", "");
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a() == paramCompoundButton))
      {
        if (!badq.d(BaseApplication.getContext()))
        {
          a(2131626719, 1);
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
          localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
          if (!paramCompoundButton.isChecked()) {}
          for (paramBoolean = true;; paramBoolean = false)
          {
            ((FormSwitchItem)localObject).setChecked(paramBoolean);
            this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
            return;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, new Object[] { "mDoNotDisturb switch, now value=", Boolean.valueOf(paramCompoundButton.isChecked()) });
        }
        localObject = this.app;
        String str = this.jdField_c_of_type_JavaLangString;
        m = this.jdField_a_of_type_Int;
        long l;
        if (paramCompoundButton.isChecked())
        {
          l = awao.a();
          FriendsStatusUtil.b((QQAppInterface)localObject, str, m, l, true, false);
          a();
          localObject = this.app;
          if (!paramCompoundButton.isChecked()) {
            break label772;
          }
        }
        for (m = 1;; m = 2)
        {
          awqx.b((QQAppInterface)localObject, "CliOper", "", "", "0X8009DCD", "0X8009DCD", 0, m, "0", "0", "", "");
          return;
          l = 0L;
          break;
        }
      }
    } while ((this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem == null) || (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a() != paramCompoundButton));
    label523:
    if (!badq.d(BaseApplication.getContext()))
    {
      a(2131626719, 1);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
      localObject = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (!paramCompoundButton.isChecked()) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        ((FormSwitchItem)localObject).setChecked(paramBoolean);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
        return;
      }
    }
    label772:
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, new Object[] { "mHiddenChat switch, now value=", Boolean.valueOf(paramCompoundButton.isChecked()) });
    }
    if (paramBoolean) {
      ajyv.a(this.app).a(this);
    }
    paramCompoundButton = this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
    Object localObject = this.jdField_c_of_type_JavaLangString;
    int m = this.jdField_a_of_type_Int;
    paramCompoundButton.a(new String[] { localObject }, new boolean[] { paramBoolean }, new int[] { m });
    a();
    paramCompoundButton = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    if ((!this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) && (!this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()))
    {
      m = 0;
      paramCompoundButton.setVisibility(m);
      paramCompoundButton = this.app;
      if (!paramBoolean) {
        break label1030;
      }
    }
    label1030:
    for (m = 1;; m = 2)
    {
      awqx.b(paramCompoundButton, "dc00898", "", "", "0X800A348", "0X800A348", 1, m, "0", "0", "", "");
      return;
      m = 8;
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131299280: 
    case 2131298527: 
    case 2131310156: 
    case 2131296532: 
    case 2131298692: 
    case 2131310746: 
    case 2131299436: 
    case 2131310745: 
    case 2131310742: 
    case 2131301101: 
    case 2131313431: 
    case 2131298120: 
    case 2131299429: 
    case 2131310564: 
    case 2131310159: 
    case 2131309723: 
      do
      {
        do
        {
          return;
          o();
          awqx.b(this.app, "CliOper", "", "", "0X80040EB", "0X80040EB", 0, 0, "", "", "", "");
          awqx.b(this.app, "dc00899", "Grp_create", "", "search", "c2c_grpcreate_clk", 0, 0, "", "", "", "");
          return;
          p();
          awqx.b(this.app, "dc00898", "", "", "0X800A0AC", "0X800A0AC", 0, 0, "", "", "", "");
          awqx.b(this.app, "CliOper", "", "", "0X80040EC", "0X80040EC", 0, 0, "0", "", "", "");
          return;
          q();
          awqx.b(this.app, "CliOper", "", "", "0X8004E0E", "0X8004E0E", 0, 0, "", "", "", "");
          return;
          F();
          awqx.b(this.app, "CliOper", "", "", "0X80040EF", "0X80040EF", 0, 0, "", "", "", "");
          return;
          t();
          awqx.b(this.app, "CliOper", "", "", "0X80040F1", "0X80040F1", 0, 0, "", "", "", "");
          return;
          awqx.b(this.app, "CliOper", "", "", "0X80040F3", "0X80040F3", 0, 0, "", "", "", "");
        } while (!a(this.jdField_a_of_type_Int));
        xbq.a(this, this.jdField_a_of_type_Int, this.jdField_c_of_type_JavaLangString, this.app.getCurrentAccountUin(), this.jdField_f_of_type_JavaLangString);
        return;
        awqx.b(this.app, "dc00898", "", "", "0X800A17C", "0X800A17C", 1, 0, "", "", "", "");
        a(this.app, this, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int, new aajj(this), 2);
        return;
        B();
        return;
        if ((1001 == this.jdField_a_of_type_Int) || (10002 == this.jdField_a_of_type_Int))
        {
          Object localObject2;
          Object localObject3;
          if (this.jdField_a_of_type_Boolean)
          {
            paramView = "2";
            localObject2 = this.app;
            localObject3 = this.jdField_c_of_type_JavaLangString;
            if (this.jdField_a_of_type_Int != 1001) {
              break label740;
            }
            localObject1 = "2";
            if (this.jdField_a_of_type_Int != 1001) {
              break label748;
            }
            ajnd.a((QQAppInterface)localObject2, (String)localObject3, (String)localObject1, paramView, 3, new aajs(this, paramView));
            arip localarip = (arip)this.app.getManager(16);
            localObject3 = this.app;
            if (!"1".equals(paramView)) {
              break label751;
            }
            localObject1 = "follow_aio";
            if (this.jdField_a_of_type_Int != 1001) {
              break label759;
            }
            localObject2 = "0";
            if (!"1".equals(paramView)) {
              break label774;
            }
            if (!localarip.a(this.jdField_c_of_type_JavaLangString)) {
              break label767;
            }
            paramView = "1";
          }
          for (;;)
          {
            awqx.b((QQAppInterface)localObject3, "dc00899", "grp_lbs", "", "c2c_tmp", (String)localObject1, 0, 0, (String)localObject2, "1", paramView, "");
            return;
            paramView = "1";
            break;
            localObject1 = "1";
            break label598;
            break label608;
            localObject1 = "unfollow_aio";
            break label663;
            localObject2 = "1";
            break label678;
            paramView = "0";
            continue;
            paramView = "";
          }
        }
        if ((1036 == this.jdField_a_of_type_Int) && (this.jdField_f_of_type_Boolean))
        {
          n();
          return;
        }
        C();
        awqx.b(this.app, "CliOper", "", "", "0X80040F2", "0X80040F2", 0, 0, "", "", "", "");
        return;
        D();
        return;
        int m = bajr.a(this.app, this.jdField_c_of_type_JavaLangString);
        if (m >> 8 == 3) {
          bajr.a(this.app, this, m, this.jdField_c_of_type_JavaLangString, "jhan_dhyltszy");
        }
        for (;;)
        {
          awqx.b(this.app, "dc00898", "", "", "qq_vip", "0X8009CAC", 0, 0, "", "", "", "");
          return;
          bajr.b(this.app, this, "mios.p.cl.cztx_ltszy");
        }
        d(this.jdField_c_of_type_JavaLangString);
        if (azzz.b(this.jdField_c_of_type_JavaLangString)) {
          awqx.b(this.app, "dc00898", "", "", "0X8007FDE", "0X8007FDE", 0, 0, "", "", "", "");
        }
        awqx.b(this.app, "CliOper", "", "", "0X80040F0", "0X80040F0", 0, 0, "", "", "", "");
        return;
        paramView = this.app.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 0);
        paramView.edit().putBoolean("special_care_chat_setting", false).commit();
        if (paramView.getBoolean("special_care_red_point_one", false)) {
          paramView.edit().putBoolean("special_care_red_point_one", false).commit();
        }
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
        paramView = new Intent(this, QQSpecialCareSettingActivity.class);
        paramView.putExtra("key_friend_uin", this.jdField_c_of_type_JavaLangString);
        paramView.putExtra("key_start_from", 2);
        startActivity(paramView);
        awqx.b(null, "CliOper", "", "", "0X80050E4", "0X80050E4", 0, 0, "0", "", "", "");
        return;
        paramView = new Intent();
        paramView.putExtra("uin", this.jdField_c_of_type_JavaLangString);
        paramView.putExtra("uintype", this.jdField_a_of_type_Int);
        MessageNotificationSettingFragment.a(this, paramView);
        return;
        paramView = (GetRoamToastRsp)this.jdField_a_of_type_AndroidViewViewGroup.getTag();
      } while (paramView == null);
      awqx.b(this.app, "dc00898", "", "", "0X8009E32", "0X8009E32", 0, 0, "", "", "", "");
      localObject1 = new Intent(this, QQBrowserActivity.class);
      ((Intent)localObject1).putExtra("url", paramView.sUrl);
      ((Intent)localObject1).putExtra("isShowAd", false);
      startActivity((Intent)localObject1);
      return;
    case 2131309717: 
      paramView = (GetRoamToastRsp)this.jdField_a_of_type_AndroidViewViewGroup.getTag();
      if (paramView != null)
      {
        awqx.b(this.app, "dc00898", "", "", "0X8009E77", "0X8009E77", 0, 0, "", "", "", "");
        ((ajrm)this.app.a(13)).a(paramView);
      }
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      return;
    case 2131298256: 
      xbq.a(this, this.jdField_a_of_type_Int, this.jdField_c_of_type_JavaLangString, this.app.getCurrentAccountUin());
      return;
    case 2131303645: 
      label598:
      label608:
      label740:
      label748:
      label751:
      label759:
      label767:
      aqvv.b(this.app, this, 2, this.jdField_c_of_type_JavaLangString, 0);
      label663:
      label678:
      aqvv.a(this.app, "listen_together_c2c_red_dot_show", false, false);
      label774:
      awqx.b(null, "dc00899", "c2c_AIO", "", "music_tab", "clk_setmusic", 0, 0, this.jdField_c_of_type_JavaLangString, "", "", "");
      return;
    }
    awqx.b(this.app, "dc00899", "c2c_AIO", "", "sing_tab", "clk_setsing", 0, 1, this.jdField_c_of_type_JavaLangString, "", "", "");
    paramView = (axmt)this.app.getManager(339);
    boolean bool = paramView.a(4, 2, this.jdField_c_of_type_JavaLangString);
    Object localObject1 = axng.a(bool, 5);
    if (bool) {
      paramView.b(this, this.jdField_c_of_type_JavaLangString, 2, 4, 5, (Bundle)localObject1);
    }
    for (;;)
    {
      axng.a(this.app, "SP_KEY_SING_TOGETHER_FRIEND_RED_DOT_SHOW", false, false);
      k();
      return;
      paramView.a(this, this.jdField_c_of_type_JavaLangString, 2, 4, 5, (Bundle)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingActivity
 * JD-Core Version:    0.7.0.1
 */