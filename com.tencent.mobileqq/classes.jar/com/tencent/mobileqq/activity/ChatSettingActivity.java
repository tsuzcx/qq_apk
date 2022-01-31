package com.tencent.mobileqq.activity;

import MQQ.GetRoamToastRsp;
import QQService.EVIPSPEC;
import aasx;
import aasy;
import aasz;
import aata;
import aatb;
import aatc;
import aatd;
import aate;
import aatf;
import aatg;
import aath;
import aati;
import aatj;
import aatk;
import aatl;
import aatm;
import aatn;
import actj;
import adic;
import aetq;
import aiiz;
import aijy;
import ajsd;
import ajti;
import ajto;
import ajxj;
import ajxl;
import ajya;
import ajzj;
import akat;
import akbl;
import akfa;
import akfv;
import akfy;
import akgh;
import akng;
import ampl;
import amvz;
import amwa;
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
import anml;
import aoze;
import arrn;
import aset;
import asxd;
import asyj;
import awcf;
import aweq;
import awzy;
import axmv;
import axqy;
import aync;
import aynp;
import banb;
import baxi;
import baxn;
import bayh;
import bbbr;
import bbcz;
import bbdj;
import bbfd;
import bbfj;
import bbgu;
import bblt;
import bblu;
import bblv;
import bbqd;
import bbrd;
import bcln;
import bcnx;
import bcqf;
import bcql;
import bcry;
import bduf;
import bfpc;
import bfxx;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
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
import com.tencent.mobileqq.utils.VipUtils;
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
import xkn;

public class ChatSettingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private static final boolean jdField_b_of_type_Boolean = AppSetting.jdField_d_of_type_Boolean;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  ajto jdField_a_of_type_Ajto = new aasz(this);
  ajxj jdField_a_of_type_Ajxj = new aasy(this);
  akat jdField_a_of_type_Akat = new aatb(this);
  private akfa jdField_a_of_type_Akfa = new aatj(this);
  private akfy jdField_a_of_type_Akfy = new aatk(this);
  private akgh jdField_a_of_type_Akgh = new aata(this);
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Intent jdField_a_of_type_AndroidContentIntent;
  private View jdField_a_of_type_AndroidViewView;
  public ViewGroup a;
  private Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private awcf jdField_a_of_type_Awcf = new aatc(this);
  private bcqf jdField_a_of_type_Bcqf;
  private bfxx jdField_a_of_type_Bfxx;
  QvipSpecialSoundManager jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager;
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  MutualMarkIconsView jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView;
  public RichStatus a;
  public FormSimpleItem a;
  public FormSwitchItem a;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  public String a;
  private WeakReference<bayh> jdField_a_of_type_JavaLangRefWeakReference;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new aatm(this);
  public boolean a;
  private final int jdField_b_of_type_Int = 1;
  private View jdField_b_of_type_AndroidViewView;
  private Button jdField_b_of_type_AndroidWidgetButton;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private bcqf jdField_b_of_type_Bcqf;
  public FormSimpleItem b;
  public FormSwitchItem b;
  private String jdField_b_of_type_JavaLangString = ChatSettingActivity.class.getSimpleName();
  private WeakReference<bayh> jdField_b_of_type_JavaLangRefWeakReference;
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
    localAllInOne.jdField_h_of_type_JavaLangString = bbcz.a(this.app, this.jdField_c_of_type_JavaLangString);
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
      localAllInOne.jdField_a_of_type_AndroidOsBundle = xkn.a(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int);
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
        if (!bbbr.a(this.jdField_c_of_type_JavaLangString, this.app.getCurrentAccountUin())) {
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
      if (ajzj.a(this.app, this.jdField_c_of_type_JavaLangString)) {
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
    if ((m == 3019) && (!anml.a(this.app, this.jdField_c_of_type_JavaLangString)))
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
        Serializable localSerializable = aetq.a(this, this.jdField_a_of_type_Int, false, false);
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
    localAllInOne.jdField_h_of_type_JavaLangString = bbcz.a(this.app, this.jdField_c_of_type_JavaLangString);
    if (3000 != this.jdField_a_of_type_Int)
    {
      localAllInOne.jdField_f_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      localAllInOne.jdField_e_of_type_Int = this.jdField_a_of_type_Int;
    }
    localAllInOne.g = 5;
    localAllInOne.jdField_h_of_type_Int = 61;
    localAllInOne.jdField_a_of_type_AndroidOsBundle = xkn.a(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.i("NewReportPlugin", 2, String.format("start-profile: %s", new Object[] { localAllInOne.jdField_a_of_type_AndroidOsBundle }));
    }
    ProfileActivity.a(this, localAllInOne, 3);
  }
  
  private void E()
  {
    if ((this.jdField_b_of_type_Bcqf != null) && (this.jdField_b_of_type_Bcqf.isShowing())) {}
    try
    {
      this.jdField_b_of_type_Bcqf.cancel();
      this.jdField_b_of_type_Bcqf = null;
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
      if (AppSetting.jdField_d_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131694425));
      }
    }
  }
  
  private void I()
  {
    boolean bool = adic.a(this.jdField_c_of_type_JavaLangString, this.app);
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
        paramString = bbfd.a(MessageRecord.getOldTableName(paramString, paramInt), MessageRecord.getTableName(paramString, paramInt), localSQLiteDatabase, localStringBuilder.toString());
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
    TextView localTextView = (TextView)paramView1.findViewById(2131376544);
    if (localTextView == null) {
      return null;
    }
    ((ViewGroup)paramView1).removeView(localTextView);
    paramView1 = localTextView.getLayoutParams();
    if ((paramView1 instanceof LinearLayout.LayoutParams)) {
      ((LinearLayout.LayoutParams)paramView1).setMargins(0, actj.a(5.0F, getResources()), 0, 0);
    }
    ((ViewGroup)paramView2).addView(localTextView);
    return localTextView;
  }
  
  private RichStatus a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = ((ajxl)this.app.getManager(51)).a(paramString);
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
      localObject = (ajxl)this.app.getManager(51);
    } while (localObject == null);
    Friends localFriends = ((ajxl)localObject).e(paramString);
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
    bcql.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).b(getTitleBarHeight());
  }
  
  private void a(int paramInt, String paramString)
  {
    if (this.jdField_d_of_type_Boolean) {
      return;
    }
    if (paramInt == -1)
    {
      bcql.a(this, paramString, 0).b(getTitleBarHeight());
      return;
    }
    bcql.a(this, paramInt, paramString, 0).b(getTitleBarHeight());
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
    if (bbfj.d(BaseApplication.getContext()))
    {
      if (!paramIntent.equals(this.jdField_g_of_type_JavaLangString))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(this.jdField_c_of_type_JavaLangString, paramIntent, false);
          this.jdField_e_of_type_Int |= 0x1;
          a(paramIntent);
          e(getString(2131690670));
          this.jdField_a_of_type_Bcqf.show();
          return;
        }
        a(2131693525, 1);
        return;
      }
      a(2131693506, 0);
      return;
    }
    a(2131694671, 1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, int paramInt1, aatn paramaatn, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "startDelAllMsg......");
    }
    bcln localbcln = new bcln(paramActivity, paramQQAppInterface, true);
    localbcln.a(new aatf(paramaatn, paramQQAppInterface, paramString, paramInt1, paramActivity));
    localbcln.a(paramInt2);
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
      aweq localaweq = (aweq)this.app.getManager(15);
      if (localaweq != null) {}
      for (paramRichStatus = localaweq.a(paramRichStatus.actionId, 200);; paramRichStatus = baxi.a(getResources(), 2130848539))
      {
        paramRichStatus = new bcry(getResources(), paramRichStatus, false, false);
        int m = (int)(paramTextView.getTextSize() * 1.1F + 0.5F);
        paramRichStatus.setBounds(0, 0, m, m);
        paramRichStatus = new bcnx(paramRichStatus, 0);
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
    paramString = bbcz.a(this.app, this.jdField_c_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  private void a(String paramString, int paramInt)
  {
    bcql.a(BaseApplication.getContext(), paramInt, paramString, 0).b(getTitleBarHeight());
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
    return ((ajxl)this.app.getManager(51)).b(paramString);
  }
  
  private String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    ajxl localajxl = (ajxl)this.app.getManager(51);
    paramString = localajxl.e(paramString);
    if (paramString != null)
    {
      paramString = localajxl.a(paramString.groupid + "");
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
      paramIntent = ((ajxl)this.app.getManager(51)).a(String.valueOf(m));
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
    addObserver(this.jdField_a_of_type_Ajxj);
    addObserver(this.jdField_a_of_type_Akat);
    addObserver(this.jdField_a_of_type_Akgh);
    addObserver(this.jdField_a_of_type_Ajto);
    addObserver(this.jdField_a_of_type_Akfa);
    addObserver(this.jdField_a_of_type_Akfy);
    this.app.setHandler(ChatSettingActivity.class, this.jdField_a_of_type_MqqOsMqqHandler);
    aweq localaweq = (aweq)this.app.getManager(15);
    if (localaweq != null) {
      localaweq.a(this.jdField_a_of_type_Awcf);
    }
  }
  
  private void d(String paramString)
  {
    bfpc localbfpc = bfpc.a(this);
    if (bbbr.b(paramString)) {
      localbfpc.a(2131690458);
    }
    for (;;)
    {
      localbfpc.a(2131691515, 3);
      localbfpc.c(2131690596);
      localbfpc.a(new aatl(this, paramString, localbfpc));
      localbfpc.show();
      return;
      if (asxd.a(this.app, this.jdField_c_of_type_JavaLangString, true)) {
        localbfpc.a(2131690460);
      } else {
        localbfpc.a(2131690459);
      }
    }
  }
  
  private void e()
  {
    removeObserver(this.jdField_a_of_type_Ajxj);
    removeObserver(this.jdField_a_of_type_Akat);
    removeObserver(this.jdField_a_of_type_Akgh);
    removeObserver(this.jdField_a_of_type_Ajto);
    removeObserver(this.jdField_a_of_type_Akfa);
    removeObserver(this.jdField_a_of_type_Akfy);
    this.app.removeHandler(ChatSettingActivity.class);
    aweq localaweq = (aweq)this.app.getManager(15);
    if (localaweq != null)
    {
      localaweq.b(this.jdField_a_of_type_Awcf);
      return;
    }
    this.jdField_a_of_type_Awcf = null;
  }
  
  private void e(String paramString)
  {
    this.jdField_a_of_type_Bcqf = new bcqf(this, getTitleBarHeight());
    this.jdField_a_of_type_Bcqf.setContentView(2131562355);
    if ((paramString == null) || ("".equals(paramString.trim())))
    {
      this.jdField_a_of_type_Bcqf.a(getString(2131719292));
      return;
    }
    this.jdField_a_of_type_Bcqf.a(paramString);
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
      setTitle(2131690740);
      setLeftViewName(2131690331);
      setContentBackgroundResource(2130838514);
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
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)View.inflate(this, 2131559168, null));
    try
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundResource(2130838514);
      this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    }
    catch (Throwable localThrowable)
    {
      try
      {
        this.jdField_a_of_type_AndroidViewView = View.inflate(this, 2131558764, null);
        this.jdField_a_of_type_ComTencentWidgetXListView.setPadding(0, 0, 0, 0);
        this.jdField_a_of_type_Bfxx = new bfxx(this.jdField_a_of_type_AndroidViewView);
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Bfxx);
        super.setContentView(this.jdField_a_of_type_ComTencentWidgetXListView);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131366711));
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366710));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366712));
        this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379270));
        this.jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView = ((MutualMarkIconsView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370601));
        this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364842));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131369315));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131376229));
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131364084));
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131375922));
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131362072));
        this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364996));
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131376359));
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131375928));
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131375923));
        this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131375925));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131375924));
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131375926));
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131375921));
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363810));
        this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131375480));
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131375481));
        this.jdField_a_of_type_AndroidViewView.findViewById(2131365003).setOnClickListener(this);
        this.jdField_d_of_type_AndroidWidgetTextView.setBackgroundResource(2130839169);
        this.jdField_a_of_type_AndroidViewView.findViewById(2131375474).setOnClickListener(this);
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
        boolean bool;
        int m;
        if (Build.VERSION.SDK_INT <= 25)
        {
          this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
          this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
          if (AppSetting.jdField_d_of_type_Boolean)
          {
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(getString(2131693537));
            this.jdField_b_of_type_AndroidWidgetRelativeLayout.setContentDescription(getString(2131689713));
            this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131690718));
            this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131719315));
            this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131717485));
            this.jdField_g_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131694728) + getString(2131719336));
            this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131694425));
            this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131696648));
            this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131690783));
            this.jdField_e_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131695502));
            this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131695499));
            this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131689672));
            this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131691515));
            this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(getString(2131689575));
            this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(ajya.a(2131701726));
            this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(ajya.a(2131719669));
          }
          this.jdField_g_of_type_JavaLangString = a(this.jdField_c_of_type_JavaLangString);
          if (this.jdField_g_of_type_JavaLangString == null) {
            this.jdField_g_of_type_JavaLangString = "";
          }
          a(this.jdField_g_of_type_JavaLangString);
          if (this.jdField_g_of_type_JavaLangString != null) {
            this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_g_of_type_JavaLangString);
          }
          Object localObject2 = bblt.a(this.app, this.jdField_c_of_type_JavaLangString);
          bool = bblt.a(localObject2[0]);
          if (bool)
          {
            localObject1 = bblu.a(localObject2[0]);
            if ((!bblt.b(localObject2[1])) && (!((bblu)localObject1).a()))
            {
              localObject2 = bblt.a(this.app, this.jdField_c_of_type_JavaLangString, (bblu)localObject1, false);
              VipUtils.a(getResources(), this.jdField_b_of_type_AndroidWidgetImageView, (String)localObject2, getResources().getDrawable(bblt.a((bblu)localObject1)));
            }
          }
          bblv.a(this.app, this.jdField_c_of_type_JavaLangString, "VIA_AIO_CHATSETTINGS").a();
          m = VipUtils.a(this.app, this.jdField_c_of_type_JavaLangString);
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_b_of_type_JavaLangString, 2, "bindView: vip=" + m);
          }
          if ((m >> 8 != 3) || (axmv.b())) {
            break label1759;
          }
          Object localObject1 = bblt.a(this.app, this.jdField_c_of_type_JavaLangString, EVIPSPEC.E_SP_BIGCLUB);
          if ((m & 0xF) != 1) {
            break label1713;
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166986));
          if (!bool) {
            VipUtils.a(getResources(), this.jdField_b_of_type_AndroidWidgetImageView, (String)localObject1, getResources().getDrawable(2130846160));
          }
          label1218:
          NamePlateCfgInfo.vipNamePlateExposeReport(this.app, this.jdField_c_of_type_JavaLangString);
          this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(VipUtils.e(1));
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          label1248:
          if (this.jdField_c_of_type_JavaLangString != null)
          {
            localObject1 = bayh.a(this.app, this.jdField_c_of_type_JavaLangString, (byte)3);
            this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
          }
          this.jdField_h_of_type_JavaLangString = b(this.jdField_c_of_type_JavaLangString);
          if (this.jdField_h_of_type_JavaLangString == null) {
            this.jdField_h_of_type_JavaLangString = "";
          }
          b(this.jdField_h_of_type_JavaLangString);
          s();
          if (!bbbr.b(this.jdField_c_of_type_JavaLangString)) {
            break label1984;
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
          localObject1 = (LinearLayout.LayoutParams)this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject1).topMargin = baxn.a(this, 20.0F);
          this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
          localObject1 = ((ajxl)this.app.getManager(51)).c(ajsd.aC);
          this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((Card)localObject1).babyQSwitch);
          this.jdField_d_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
          ((ajti)this.app.a(2)).w();
        }
        for (;;)
        {
          if (bduf.b(this.app, this.jdField_c_of_type_JavaLangString)) {
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
          label1713:
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166986));
          if (bool) {
            break label1218;
          }
          VipUtils.a(getResources(), this.jdField_b_of_type_AndroidWidgetImageView, localThrowable, getResources().getDrawable(2130846158));
          break label1218;
          label1759:
          if ((m >> 8 == 1) && (!axmv.b()))
          {
            this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166986));
            this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(VipUtils.e(0));
            this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            break label1248;
          }
          if ((m >> 8 == 2) && (!axmv.b()))
          {
            String str = bblt.a(this.app, this.jdField_c_of_type_JavaLangString, EVIPSPEC.E_SP_SUPERVIP);
            if ((m & 0xF) == 1)
            {
              this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166986));
              if (!bool) {
                VipUtils.a(getResources(), this.jdField_b_of_type_AndroidWidgetImageView, str, getResources().getDrawable(2130846160));
              }
            }
            for (;;)
            {
              this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(VipUtils.e(1));
              this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
              break;
              this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166986));
              if (!bool) {
                VipUtils.a(getResources(), this.jdField_b_of_type_AndroidWidgetImageView, str, getResources().getDrawable(2130846158));
              }
            }
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(VipUtils.e(0));
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          break label1248;
          label1984:
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
      str = ajya.a(2131701717);
      localFormSimpleItem.setRightText(str);
      if (!arrn.a(this.app, "listen_together_c2c_red_dot_show", true, false)) {
        break label149;
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130840998));
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(ajya.a(2131701726) + " " + this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.a().getText());
      return;
      str = ajya.a(2131701760);
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
    Object localObject = ((amvz)ampl.a().a(551)).a(4);
    FormSimpleItem localFormSimpleItem;
    if ((localObject != null) && (((amwa)localObject).jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      boolean bool = ((aync)this.app.getManager(339)).a(4, 2, this.jdField_c_of_type_JavaLangString);
      localFormSimpleItem = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      if (!bool) {
        break label138;
      }
    }
    label138:
    for (localObject = "已开启";; localObject = "未开启")
    {
      localFormSimpleItem.setRightText((CharSequence)localObject);
      if (!aynp.a(this.app, "SP_KEY_SING_TOGETHER_FRIEND_RED_DOT_SHOW", true, false)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130840998));
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
  }
  
  private void l()
  {
    Object localObject1 = View.inflate(this, 2131558766, null);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)((View)localObject1).findViewById(2131364565));
    this.jdField_a_of_type_ComTencentWidgetXListView.setPadding(0, 0, 0, 0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_AndroidViewView = View.inflate(this, 2131558765, null);
    this.jdField_a_of_type_Bfxx = new bfxx(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Bfxx);
    super.setContentView((View)localObject1);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131376541);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131376543));
    this.jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131364249));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376542));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376539));
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131375927));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131376540));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131363671));
    this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130839169);
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
        this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131376544));
      }
      if (AppSetting.jdField_d_of_type_Boolean)
      {
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.setContentDescription(getString(2131693537));
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131690779));
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131690783));
        localObject1 = this.jdField_a_of_type_AndroidWidgetButton;
        if ((1001 != this.jdField_a_of_type_Int) && (10002 != this.jdField_a_of_type_Int)) {
          break label1321;
        }
        if (!this.jdField_a_of_type_Boolean) {
          break label1314;
        }
        m = 2131696667;
        ((Button)localObject1).setContentDescription(getString(m));
        this.jdField_h_of_type_AndroidWidgetTextView.setContentDescription(getString(2131689578));
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
      localObject1 = bayh.a(this.app, 200, this.jdField_c_of_type_JavaLangString, true);
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
      localObject1 = (aset)this.app.getManager(16);
      if ((localObject1 != null) && (!TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString))) {
        this.jdField_f_of_type_Boolean = ((aset)localObject1).a(this.jdField_i_of_type_JavaLangString);
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
      axqy.b(localQQAppInterface, "dc00899", "grp_lbs", "", "c2c_tmp", "exp_aio_set", 0, 0, (String)localObject1, str, (String)localObject2, "");
      if ((this.jdField_a_of_type_Int == 1037) || (this.jdField_a_of_type_Int == 1044)) {
        this.jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      }
      return;
      this.jdField_h_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      break;
      m = 2131696665;
      break label462;
      m = 2131690778;
      break label462;
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      break label513;
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setClickable(true);
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setEnabled(true);
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      break label593;
      if (this.jdField_a_of_type_Int == 1006)
      {
        localObject1 = bayh.b(this.app, this.jdField_c_of_type_JavaLangString, (byte)3);
        this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
        break label735;
      }
      localObject1 = bayh.a(this.app, 1, this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localObject1);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      break label735;
      localObject1 = bbcz.e(this.app, this.k);
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
      localObject1 = ((ajxl)this.app.getManager(51)).e(this.jdField_i_of_type_JavaLangString);
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
      getResources().getString(2131717284);
      return;
    case 4: 
      getResources().getString(2131717282);
      return;
    case 3: 
      getResources().getString(2131717283);
      return;
    case 2: 
      getResources().getString(2131717285);
      return;
    }
    getResources().getString(2131717302);
  }
  
  private void n()
  {
    bbdj.a(this, 230).setMessage(ajya.a(2131701719)).setPositiveButton(17039370, new aati(this)).setNegativeButton(17039360, new aath(this)).show();
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
    VasWebviewUtil.openQQBrowserWithoutAD(this, bbqd.a(this, "background", ""), 33554432L, localIntent, true, 1);
  }
  
  private void r()
  {
    Intent localIntent = actj.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtra("uin", this.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("uinname", this.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_a_of_type_Int);
    localIntent.putExtra("isNeedUpdate", this.jdField_c_of_type_Boolean);
    startActivity(localIntent);
  }
  
  private void s()
  {
    Object localObject = this.app.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 0);
    if ((((SharedPreferences)localObject).getBoolean("special_care_chat_setting", true)) && (!aiiz.a(this.jdField_c_of_type_JavaLangString, this.app)))
    {
      localObject = getResources().getDrawable(2130849300);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon((Drawable)localObject);
    }
    boolean bool;
    do
    {
      return;
      bool = ((SharedPreferences)localObject).getBoolean("special_care_red_point_one", false);
      ((SharedPreferences)localObject).getBoolean("special_care_red_point_two", false);
    } while (!bool);
    localObject = getResources().getDrawable(2130849297);
    getResources().getDrawable(2130839016);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon((Drawable)localObject);
  }
  
  private void t()
  {
    ChatSettingActivity.7 local7 = new ChatSettingActivity.7(this, new StringBuilder());
    if (!this.jdField_j_of_type_Boolean)
    {
      ThreadManager.post(local7, 8, null, true);
      a(2, getString(2131690041));
    }
  }
  
  private void u()
  {
    boolean bool = true;
    if (!bbfj.d(BaseApplication.getContext()))
    {
      a(2131692321, 1);
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
      a(1, ajya.a(2131701713));
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
    if (!bbfj.d(BaseApplication.getContext()))
    {
      a(2131692321, 1);
      this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_f_of_type_Boolean);
    }
    for (;;)
    {
      return;
      Object localObject1 = (aset)this.app.getManager(16);
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
            ((aset)localObject1).b(this.jdField_a_of_type_Int, (List)localObject2);
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
            axqy.b(localQQAppInterface, "dc00899", "grp_lbs", "", "c2c_tmp", (String)localObject2, 0, 0, str2, "1", (String)localObject1, "");
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
            axqy.b(this.app, "CliOper", "", this.jdField_i_of_type_JavaLangString, "0X8004954", "0X8004954", 0, 0, "", "", "", "");
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
          ((aset)localObject1).a(this.jdField_a_of_type_Int, localException);
          continue;
          a(1, ajya.a(2131701757));
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
        axqy.b(this.app, "CliOper", "", this.jdField_i_of_type_JavaLangString, "0X8004953", "0X8004953", 0, 0, "", "", "", "");
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
      if (AppSetting.jdField_d_of_type_Boolean) {
        this.jdField_f_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131690782));
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
        m = 2131696667;
      }
    }
    for (;;)
    {
      String str = getString(m);
      this.jdField_a_of_type_AndroidWidgetButton.setText(str);
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(str);
      return;
      m = 2131696665;
      continue;
      m = 2131690778;
    }
  }
  
  private void z()
  {
    int m = 0;
    Object localObject = (ajxl)this.app.getManager(51);
    if ((localObject != null) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))) {
      this.jdField_e_of_type_Boolean = ((ajxl)localObject).e(this.jdField_c_of_type_JavaLangString);
    }
    if (this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem != null)
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_e_of_type_Boolean);
      v();
      if (AppSetting.jdField_d_of_type_Boolean) {
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131690782));
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
      this.jdField_a_of_type_AndroidAppDialog = ajzj.a(this, getString(2131694552), new aatd(this), new aate(this));
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
        axqy.b(this.app, "CliOper", "", "", "discuss", "creat_discuss_c2cplus", 0, 0, "", "", "", "");
        banb.a(this, paramIntent.getStringExtra("roomId"), true);
        return;
      }
      Intent localIntent = actj.a(new Intent(this, SplashActivity.class), null);
      paramIntent = paramIntent.getStringExtra("roomId");
      localIntent.putExtra("uin", paramIntent);
      localIntent.putExtra("uintype", 3000);
      localIntent.putExtra("uinname", bbcz.a(this.app, getApplicationContext(), paramIntent));
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
    axqy.b(this.app, "dc00899", "Grp_create", "", "search", "c2c_grpcreate_exp", 0, 0, "", "", "", "");
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
      if ((this.jdField_a_of_type_Bcqf != null) && (this.jdField_a_of_type_Bcqf.isShowing()) && (!isFinishing()))
      {
        this.jdField_a_of_type_Bcqf.dismiss();
        this.jdField_a_of_type_Bcqf = null;
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
        bayh localbayh;
        localThrowable.printStackTrace();
      }
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      localbayh = (bayh)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localbayh != null) {
        localbayh.a();
      }
    }
    if (this.jdField_b_of_type_JavaLangRefWeakReference != null)
    {
      localbayh = (bayh)this.jdField_b_of_type_JavaLangRefWeakReference.get();
      if (localbayh != null) {
        localbayh.a();
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
      str = getString(2131717485);
      SpecialCareInfo localSpecialCareInfo = ((ajxl)this.app.getManager(51)).a(this.jdField_c_of_type_JavaLangString);
      if ((localSpecialCareInfo != null) && (localSpecialCareInfo.globalSwitch != 0)) {
        break label258;
      }
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getString(2131719156));
    }
    for (String str = str + getString(2131719156);; str = str + getString(2131719157))
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(str);
      if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_MqqOsMqqHandler != null) && (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(34)))
      {
        int m = asyj.a();
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(34, m * 1000);
      }
      if (this.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
        ((akfv)this.app.a(13)).f();
      }
      j();
      k();
      return;
      label258:
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getString(2131719157));
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem != null))
    {
      m();
      ((bbrd)this.app.a(71)).a(new String[] { this.app.getCurrentAccountUin() }, new int[] { 42255 });
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
      if (bbfj.d(BaseApplication.getContext()))
      {
        ((ajti)this.app.a(2)).m(paramBoolean);
        paramCompoundButton = this.app;
        if (paramBoolean)
        {
          m = 1;
          axqy.b(paramCompoundButton, "dc00898", "", "", "0X800723C", "0X800723C", 0, 0, String.valueOf(m), "", "", "");
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
          a(2131692321, 1);
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
          axqy.b(this.app, "CliOper", "", "", "0X80040EE", "0X80040EE", 0, 0, "2", "1", "", "");
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onCheckedChanged, isCheck=" + paramBoolean);
          }
          w();
          return;
          axqy.b(this.app, "CliOper", "", "", "0X80040EE", "0X80040EE", 0, 0, "2", "0", "", "");
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
              bcql.a(this, 1, ajya.a(2131701725), 0).b(getTitleBarHeight());
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
            axqy.b(paramCompoundButton, "CliOper", "", "", "0X8009DCE", "0X8009DCE", 0, m, "0", "0", "", "");
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
        axqy.b(paramCompoundButton, "CliOper", "", "", "0X8009DCF", "0X8009DCF", 0, m, "0", "0", "", "");
      } while (this.jdField_e_of_type_Boolean == paramBoolean);
      if (this.jdField_e_of_type_Boolean) {
        axqy.b(this.app, "CliOper", "", "", "0X80040EE", "0X80040EE", 0, 0, "0", "1", "", "");
      }
      for (;;)
      {
        u();
        return;
        m = 2;
        break;
        axqy.b(this.app, "CliOper", "", "", "0X80040EE", "0X80040EE", 0, 0, "0", "0", "", "");
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a() == paramCompoundButton))
      {
        if (!bbfj.d(BaseApplication.getContext()))
        {
          a(2131692321, 1);
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
          l = awzy.a();
          FriendsStatusUtil.b((QQAppInterface)localObject, str, m, l, true, false);
          a();
          localObject = this.app;
          if (!paramCompoundButton.isChecked()) {
            break label772;
          }
        }
        for (m = 1;; m = 2)
        {
          axqy.b((QQAppInterface)localObject, "CliOper", "", "", "0X8009DCD", "0X8009DCD", 0, m, "0", "0", "", "");
          return;
          l = 0L;
          break;
        }
      }
    } while ((this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem == null) || (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a() != paramCompoundButton));
    label523:
    if (!bbfj.d(BaseApplication.getContext()))
    {
      a(2131692321, 1);
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
      akng.a(this.app).a(this);
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
      axqy.b(paramCompoundButton, "dc00898", "", "", "0X800A348", "0X800A348", 1, m, "0", "0", "", "");
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
    case 2131364842: 
    case 2131364084: 
    case 2131375922: 
    case 2131362072: 
    case 2131364249: 
    case 2131376544: 
    case 2131365003: 
    case 2131376543: 
    case 2131376540: 
    case 2131366711: 
    case 2131379270: 
    case 2131363671: 
    case 2131364996: 
    case 2131376359: 
    case 2131375925: 
    case 2131375480: 
      do
      {
        do
        {
          return;
          o();
          axqy.b(this.app, "CliOper", "", "", "0X80040EB", "0X80040EB", 0, 0, "", "", "", "");
          axqy.b(this.app, "dc00899", "Grp_create", "", "search", "c2c_grpcreate_clk", 0, 0, "", "", "", "");
          return;
          p();
          axqy.b(this.app, "dc00898", "", "", "0X800A0AC", "0X800A0AC", 0, 0, "", "", "", "");
          axqy.b(this.app, "CliOper", "", "", "0X80040EC", "0X80040EC", 0, 0, "0", "", "", "");
          return;
          q();
          axqy.b(this.app, "CliOper", "", "", "0X8004E0E", "0X8004E0E", 0, 0, "", "", "", "");
          return;
          F();
          axqy.b(this.app, "CliOper", "", "", "0X80040EF", "0X80040EF", 0, 0, "", "", "", "");
          return;
          t();
          axqy.b(this.app, "CliOper", "", "", "0X80040F1", "0X80040F1", 0, 0, "", "", "", "");
          return;
          axqy.b(this.app, "CliOper", "", "", "0X80040F3", "0X80040F3", 0, 0, "", "", "", "");
        } while (!a(this.jdField_a_of_type_Int));
        xkn.a(this, this.jdField_a_of_type_Int, this.jdField_c_of_type_JavaLangString, this.app.getCurrentAccountUin(), this.jdField_f_of_type_JavaLangString);
        return;
        axqy.b(this.app, "dc00898", "", "", "0X800A17C", "0X800A17C", 1, 0, "", "", "", "");
        a(this.app, this, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int, new aasx(this), 2);
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
              break label736;
            }
            localObject1 = "2";
            if (this.jdField_a_of_type_Int != 1001) {
              break label743;
            }
            akbl.a((QQAppInterface)localObject2, (String)localObject3, (String)localObject1, paramView, 3, new aatg(this, paramView));
            aset localaset = (aset)this.app.getManager(16);
            localObject3 = this.app;
            if (!"1".equals(paramView)) {
              break label746;
            }
            localObject1 = "follow_aio";
            if (this.jdField_a_of_type_Int != 1001) {
              break label753;
            }
            localObject2 = "0";
            if (!"1".equals(paramView)) {
              break label768;
            }
            if (!localaset.a(this.jdField_c_of_type_JavaLangString)) {
              break label761;
            }
            paramView = "1";
          }
          for (;;)
          {
            axqy.b((QQAppInterface)localObject3, "dc00899", "grp_lbs", "", "c2c_tmp", (String)localObject1, 0, 0, (String)localObject2, "1", paramView, "");
            return;
            paramView = "1";
            break;
            localObject1 = "1";
            break label597;
            break label607;
            localObject1 = "unfollow_aio";
            break label660;
            localObject2 = "1";
            break label675;
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
        axqy.b(this.app, "CliOper", "", "", "0X80040F2", "0X80040F2", 0, 0, "", "", "", "");
        return;
        D();
        return;
        bblv.a(this.app, this.jdField_c_of_type_JavaLangString, "VIA_AIO_CHATSETTINGS").onTouch(paramView, null);
        return;
        d(this.jdField_c_of_type_JavaLangString);
        if (bbbr.b(this.jdField_c_of_type_JavaLangString)) {
          axqy.b(this.app, "dc00898", "", "", "0X8007FDE", "0X8007FDE", 0, 0, "", "", "", "");
        }
        axqy.b(this.app, "CliOper", "", "", "0X80040F0", "0X80040F0", 0, 0, "", "", "", "");
        return;
        paramView = this.app.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 0);
        paramView.edit().putBoolean("special_care_chat_setting", false).commit();
        if (paramView.getBoolean("special_care_red_point_one", false)) {
          paramView.edit().putBoolean("special_care_red_point_one", false).commit();
        }
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
        aijy.a(this, this.jdField_c_of_type_JavaLangString, 2);
        axqy.b(null, "CliOper", "", "", "0X80050E4", "0X80050E4", 0, 0, "0", "", "", "");
        return;
        paramView = new Intent();
        paramView.putExtra("uin", this.jdField_c_of_type_JavaLangString);
        paramView.putExtra("uintype", this.jdField_a_of_type_Int);
        MessageNotificationSettingFragment.a(this, paramView);
        return;
        paramView = (GetRoamToastRsp)this.jdField_a_of_type_AndroidViewViewGroup.getTag();
      } while (paramView == null);
      axqy.b(this.app, "dc00898", "", "", "0X8009E32", "0X8009E32", 0, 0, "", "", "", "");
      localObject1 = new Intent(this, QQBrowserActivity.class);
      ((Intent)localObject1).putExtra("url", paramView.sUrl);
      ((Intent)localObject1).putExtra("isShowAd", false);
      startActivity((Intent)localObject1);
      return;
    case 2131375474: 
      paramView = (GetRoamToastRsp)this.jdField_a_of_type_AndroidViewViewGroup.getTag();
      if (paramView != null)
      {
        axqy.b(this.app, "dc00898", "", "", "0X8009E77", "0X8009E77", 0, 0, "", "", "", "");
        ((akfv)this.app.a(13)).a(paramView);
      }
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      return;
    case 2131363810: 
      xkn.a(this, this.jdField_a_of_type_Int, this.jdField_c_of_type_JavaLangString, this.app.getCurrentAccountUin());
      return;
    case 2131369315: 
      label597:
      label607:
      label736:
      label743:
      label746:
      label753:
      label761:
      arrn.b(this.app, this, 2, this.jdField_c_of_type_JavaLangString, 0);
      label660:
      label675:
      arrn.a(this.app, "listen_together_c2c_red_dot_show", false, false);
      label768:
      axqy.b(null, "dc00899", "c2c_AIO", "", "music_tab", "clk_setmusic", 0, 0, this.jdField_c_of_type_JavaLangString, "", "", "");
      return;
    }
    axqy.b(this.app, "dc00899", "c2c_AIO", "", "sing_tab", "clk_setsing", 0, 1, this.jdField_c_of_type_JavaLangString, "", "", "");
    paramView = (aync)this.app.getManager(339);
    boolean bool = paramView.a(4, 2, this.jdField_c_of_type_JavaLangString);
    Object localObject1 = aynp.a(bool, 5);
    if (bool) {
      paramView.b(this, this.jdField_c_of_type_JavaLangString, 2, 4, 5, (Bundle)localObject1);
    }
    for (;;)
    {
      aynp.a(this.app, "SP_KEY_SING_TOGETHER_FRIEND_RED_DOT_SHOW", false, false);
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