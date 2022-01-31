package com.tencent.mobileqq.activity;

import aeco;
import aecp;
import aecq;
import aecr;
import aecs;
import aect;
import aecu;
import aecv;
import aecw;
import aecx;
import aecy;
import aecz;
import aeda;
import aedb;
import aedc;
import aedd;
import aede;
import aedf;
import aedg;
import aedh;
import aedi;
import aedj;
import ahla;
import ahlb;
import aljq;
import allb;
import almv;
import alox;
import aloz;
import alpo;
import alsi;
import alyo;
import alzf;
import amab;
import amha;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.format.Time;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import azmj;
import baba;
import bchz;
import bcws;
import bcwt;
import bcyw;
import bcze;
import bdbt;
import bdjj;
import bepp;
import bhpy;
import bhql;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mtn;
import mzy;
import swy;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqGroupInfo;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.mobileim.structmsg.structmsg.GroupInfo;
import tencent.mobileim.structmsg.structmsg.MsgInviteExt;
import tencent.mobileim.structmsg.structmsg.MsgPayGroupExt;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class TroopRequestActivity
  extends IphoneTitleBarActivity
  implements aljq, bcwt
{
  public static int a;
  protected static long b;
  public static final boolean b;
  public static long c;
  public static int d;
  public static final int e;
  public static final int f;
  public static final int g;
  public static final int h;
  protected long a;
  public ahlb a;
  allb jdField_a_of_type_Allb = new aecr(this);
  alox jdField_a_of_type_Alox = new aecs(this);
  protected alsi a;
  alyo jdField_a_of_type_Alyo = new aecz(this);
  public alzf a;
  protected amab a;
  public Handler a;
  protected SpannableStringBuilder a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aedg(this);
  protected View a;
  public Button a;
  protected ImageView a;
  protected LinearLayout a;
  protected TextView a;
  protected bcws a;
  protected bepp a;
  protected URLImageView a;
  protected AnimationTextView a;
  public String a;
  public structmsg.StructMsg a;
  public short a;
  public boolean a;
  private LinearLayout[] jdField_a_of_type_ArrayOfAndroidWidgetLinearLayout = new LinearLayout[jdField_d_of_type_Int];
  private RelativeLayout[] jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout = new RelativeLayout[jdField_d_of_type_Int - 1];
  public int b;
  View.OnClickListener b;
  protected View b;
  public Button b;
  protected ImageView b;
  public LinearLayout b;
  protected TextView b;
  public String b;
  protected int c;
  View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new aect(this);
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  public LinearLayout c;
  protected TextView c;
  protected String c;
  protected boolean c;
  private String cX;
  View.OnClickListener jdField_d_of_type_AndroidViewView$OnClickListener = new aecu(this);
  private LinearLayout jdField_d_of_type_AndroidWidgetLinearLayout;
  public TextView d;
  public String d;
  public boolean d;
  View.OnClickListener jdField_e_of_type_AndroidViewView$OnClickListener = new aecv(this);
  private LinearLayout jdField_e_of_type_AndroidWidgetLinearLayout;
  protected TextView e;
  protected String e;
  View.OnClickListener jdField_f_of_type_AndroidViewView$OnClickListener = new aecw(this);
  private LinearLayout jdField_f_of_type_AndroidWidgetLinearLayout;
  protected TextView f;
  protected String f;
  View.OnClickListener g;
  protected TextView g;
  protected String g;
  private View.OnClickListener h;
  protected TextView h;
  protected String h;
  protected int i;
  protected TextView i;
  protected String i;
  public TextView j;
  protected String j;
  protected TextView k;
  protected String k;
  protected TextView l;
  public String l;
  protected TextView m;
  protected String m;
  protected TextView n;
  protected String n;
  public TextView o;
  public String o;
  TextView p;
  public String p;
  TextView q;
  protected String q;
  private TextView r;
  public String r;
  private TextView s;
  public String s;
  private TextView t;
  public String t;
  
  static
  {
    jdField_a_of_type_Int = 10;
    int i1 = jdField_d_of_type_Int;
    jdField_d_of_type_Int = i1 + 1;
    jdField_e_of_type_Int = i1;
    i1 = jdField_d_of_type_Int;
    jdField_d_of_type_Int = i1 + 1;
    jdField_f_of_type_Int = i1;
    i1 = jdField_d_of_type_Int;
    jdField_d_of_type_Int = i1 + 1;
    jdField_g_of_type_Int = i1;
    i1 = jdField_d_of_type_Int;
    jdField_d_of_type_Int = i1 + 1;
    jdField_h_of_type_Int = i1;
    jdField_b_of_type_Boolean = AppSetting.jdField_c_of_type_Boolean;
  }
  
  public TroopRequestActivity()
  {
    this.jdField_s_of_type_JavaLangString = "";
    this.jdField_t_of_type_JavaLangString = "";
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new aedh(this);
    this.jdField_a_of_type_AndroidOsHandler = new aeco(this);
    this.jdField_a_of_type_Amab = new aecp(this);
    this.jdField_a_of_type_Alsi = new aecq(this);
    this.jdField_g_of_type_AndroidViewView$OnClickListener = new aecx(this);
    this.jdField_a_of_type_Ahlb = new aedc(this);
    this.jdField_h_of_type_AndroidViewView$OnClickListener = new aedd(this);
  }
  
  public static String a(long paramLong)
  {
    Time localTime1 = new Time();
    localTime1.set(paramLong);
    long l1 = System.currentTimeMillis();
    Time localTime2 = new Time();
    localTime2.set(l1);
    if (localTime1.year == localTime2.year) {
      return bdjj.a(paramLong, true, "MM-dd");
    }
    return bdjj.a(paramLong, true, "yyyy-MM-dd");
  }
  
  private void a(long paramLong, structmsg.StructMsg paramStructMsg)
  {
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("structMsg", paramStructMsg.toByteArray());
    bchz.a(this.app, paramLong, new aeda(this), localBundle);
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, structmsg.StructMsg paramStructMsg, ahlb paramahlb)
  {
    if ((paramQQAppInterface == null) || (paramahlb == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    ahla.a(paramString, paramStructMsg);
    Object localObject2 = new oidb_0x88d.GroupInfo();
    ((oidb_0x88d.GroupInfo)localObject2).uint32_app_privilege_flag.set(0);
    Object localObject1 = new oidb_0x88d.ReqGroupInfo();
    ((oidb_0x88d.ReqGroupInfo)localObject1).uint64_group_code.set(Long.parseLong(paramString));
    ((oidb_0x88d.ReqGroupInfo)localObject1).stgroupinfo.set((MessageMicro)localObject2);
    localObject2 = new oidb_0x88d.ReqBody();
    ((oidb_0x88d.ReqBody)localObject2).uint32_appid.set(paramQQAppInterface.getAppid());
    ((oidb_0x88d.ReqBody)localObject2).stzreqgroupinfo.add((MessageMicro)localObject1);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(2189);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(14);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x88d.ReqBody)localObject2).toByteArray()));
    mzy.a(paramQQAppInterface, new aedb(paramString, paramContext, paramahlb, paramStructMsg), ((oidb_sso.OIDBSSOPkg)localObject1).toByteArray(), "OidbSvc.0x88d_0");
  }
  
  private void a(Card paramCard)
  {
    if (this.jdField_b_of_type_Int == 82) {}
    do
    {
      do
      {
        return;
        if (paramCard != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.systemmsg.TroopRequestActivity", 2, "updateSimpleInfo card is null!");
      return;
    } while ((this.jdField_o_of_type_AndroidWidgetTextView == null) || (this.jdField_p_of_type_AndroidWidgetTextView == null));
    this.jdField_o_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_p_of_type_AndroidWidgetTextView.setVisibility(0);
    Object localObject1 = "";
    label152:
    Object localObject2;
    boolean bool1;
    if (paramCard.shGender == 0)
    {
      localObject1 = getString(2131694190);
      this.jdField_o_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      if (paramCard.age <= 0) {
        break label579;
      }
      localObject1 = paramCard.age + getString(2131720506);
      this.jdField_p_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      this.jdField_p_of_type_AndroidWidgetTextView.setContentDescription((CharSequence)localObject1);
      this.jdField_p_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject2 = "";
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramCard.strCountry))
      {
        localObject1 = localObject2;
        if (!paramCard.strCountry.equals(getString(2131717443))) {
          localObject1 = paramCard.strCountry;
        }
      }
      localObject2 = localObject1;
      if (!TextUtils.isEmpty(paramCard.strProvince)) {
        localObject2 = (String)localObject1 + " " + paramCard.strProvince;
      }
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramCard.strCity)) {
        localObject1 = (String)localObject2 + " " + paramCard.strCity;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        this.jdField_q_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        this.jdField_q_of_type_AndroidWidgetTextView.setContentDescription((CharSequence)localObject1);
        this.jdField_q_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      localObject1 = new SpannableStringBuilder();
      if ((this.jdField_b_of_type_Int != 1) && (this.jdField_b_of_type_Int != 22) && (this.jdField_b_of_type_Int != 60)) {
        break label620;
      }
      localObject2 = getResources();
      if (paramCard.bSuperVipOpen != 1) {
        break label609;
      }
      bool1 = true;
      label370:
      if (paramCard.bQQVipOpen != 1) {
        break label614;
      }
    }
    label579:
    label609:
    label614:
    for (boolean bool2 = true;; bool2 = false)
    {
      int i1 = paramCard.iQQVipLevel;
      TextView localTextView = (TextView)this.jdField_f_of_type_AndroidWidgetLinearLayout.findViewById(2131375644);
      if (QLog.isColorLevel()) {
        QLog.d("Q.systemmsg.TroopRequestActivity", 2, "updateLevelAndVip bSuperVipOpen=" + bool1 + ",bQQVipOpen=" + bool2 + ",VipLevel=" + i1 + ",QQLevel=" + paramCard.iQQLevel);
      }
      if ((bool1) || (bool2)) {
        ((SpannableStringBuilder)localObject1).append(bcze.a(localTextView, (Resources)localObject2, bool1, bool2, Math.max(i1, 1)));
      }
      if (paramCard.iQQLevel >= 0) {
        ((SpannableStringBuilder)localObject1).append(bcyw.a(this, 15, paramCard.mQQLevelType, paramCard.iQQLevel, false));
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
      this.jdField_f_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      return;
      if (paramCard.shGender == 1)
      {
        localObject1 = getString(2131692470);
        break;
      }
      this.jdField_o_of_type_AndroidWidgetTextView.setVisibility(8);
      break;
      this.jdField_p_of_type_AndroidWidgetTextView.setText("");
      this.jdField_p_of_type_AndroidWidgetTextView.setContentDescription("");
      this.jdField_p_of_type_AndroidWidgetTextView.setVisibility(8);
      break label152;
      bool1 = false;
      break label370;
    }
    label620:
    this.jdField_f_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  private boolean a()
  {
    boolean bool2 = false;
    long l1 = baba.a().b();
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = baba.a().a(Long.valueOf(l1));
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null)
    {
      int i1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_type.get();
      l1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_seq.get();
      long l2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get();
      int i2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
      int i3 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get();
      int i4 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get();
      int i5 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get();
      List localList = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get();
      bool1 = bool2;
      if (localList != null)
      {
        bool1 = bool2;
        if (localList.size() < 0)
        {
          ((structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)localList.get(0)).action_info.get()).blacklist.set(true);
          this.app.a().a().a(i1, l1, l2, i2, i3, i4, i5, (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)localList.get(0)).action_info.get(), 0);
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private boolean a(int paramInt)
  {
    boolean bool2 = false;
    long l1 = baba.a().b();
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = baba.a().a(Long.valueOf(l1));
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null)
    {
      int i1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_type.get();
      l1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_seq.get();
      long l2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get();
      int i2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
      int i3 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get();
      int i4 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get();
      int i5 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get();
      List localList = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get();
      bool1 = bool2;
      if (localList != null)
      {
        bool1 = bool2;
        if (paramInt < localList.size())
        {
          this.app.a().a().a(i1, l1, l2, i2, i3, i4, i5, (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)localList.get(paramInt)).action_info.get(), paramInt);
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void j()
  {
    long l1 = baba.a().b();
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = baba.a().a(Long.valueOf(l1));
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg == null)
    {
      finish();
      return;
    }
    int i1;
    if (QLog.isColorLevel())
    {
      l1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint32_group_flagext3.get();
      boolean bool = TroopInfo.isQidianPrivateTroop(l1);
      i1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get();
      QLog.d(".troop.qidian_private_troop", 2, "TroopRequestActivity init: msgType=" + i1 + ", isQidianPrivateTroop=" + bool + ", flagExt3=" + l1);
    }
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131378375);
    localLinearLayout.setVisibility(8);
    this.jdField_a_of_type_Bcws = new bcws(this, this.app);
    this.jdField_a_of_type_Bcws.a(this);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get();
    this.jdField_a_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
    this.cX = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
    this.jdField_l_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get());
    this.jdField_m_of_type_JavaLangString = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get();
    label298:
    Object localObject1;
    label600:
    int i2;
    if (this.jdField_m_of_type_JavaLangString.startsWith(getString(2131720538)))
    {
      this.jdField_m_of_type_JavaLangString = this.jdField_m_of_type_JavaLangString.replace(getString(2131720538), "");
      setLeftViewName(2131691141);
      setTitle(a(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get()));
      this.jdField_a_of_type_AndroidViewView = findViewById(2131378366);
      this.jdField_b_of_type_AndroidViewView = ((LinearLayout)findViewById(2131378367));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378363));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378371));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378374));
      this.jdField_o_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378372));
      this.jdField_p_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378369));
      this.jdField_q_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378370));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378360));
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131378368));
      this.r = ((TextView)findViewById(2131378365));
      this.jdField_s_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378362));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131362228));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131375544));
      this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131378364));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378361));
      this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_g_of_type_AndroidViewView$OnClickListener);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378358));
      localObject1 = mtn.b(BaseApplication.getContext(), 2130839097);
      if (localObject1 == null) {
        break label853;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131378359));
      this.jdField_e_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131375637));
      this.jdField_f_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131375643));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131375635));
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131375640));
      localObject1 = (TextView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131375642);
      if (localObject1 != null) {
        ((TextView)localObject1).setText(swy.a(this.app, getApplicationContext()));
      }
      this.jdField_a_of_type_ArrayOfAndroidWidgetLinearLayout[jdField_e_of_type_Int] = this.jdField_e_of_type_AndroidWidgetLinearLayout;
      this.jdField_a_of_type_ArrayOfAndroidWidgetLinearLayout[jdField_f_of_type_Int] = this.jdField_f_of_type_AndroidWidgetLinearLayout;
      this.jdField_a_of_type_ArrayOfAndroidWidgetLinearLayout[jdField_g_of_type_Int] = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      this.jdField_a_of_type_ArrayOfAndroidWidgetLinearLayout[jdField_h_of_type_Int] = this.jdField_b_of_type_AndroidWidgetLinearLayout;
      int i3 = this.jdField_d_of_type_AndroidWidgetLinearLayout.getChildCount();
      i2 = 0;
      i1 = 0;
      label766:
      if (i2 >= i3) {
        break label866;
      }
      if (!(this.jdField_d_of_type_AndroidWidgetLinearLayout.getChildAt(i2) instanceof RelativeLayout)) {
        break label2271;
      }
      this.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i1] = ((RelativeLayout)this.jdField_d_of_type_AndroidWidgetLinearLayout.getChildAt(i2));
      i1 += 1;
    }
    label853:
    label2261:
    label2266:
    label2271:
    for (;;)
    {
      i2 += 1;
      break label766;
      if (!this.jdField_m_of_type_JavaLangString.startsWith(getString(2131720521))) {
        break label298;
      }
      this.jdField_m_of_type_JavaLangString = this.jdField_m_of_type_JavaLangString.replace(getString(2131720521), "");
      break label298;
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130839097);
      break label600;
      label866:
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131375639));
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131375638));
      this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131375641));
      this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView = ((AnimationTextView)findViewById(2131375644));
      this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131375636));
      this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372425));
      this.jdField_k_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365141));
      this.jdField_n_of_type_JavaLangString = getIntent().getExtras().getString("troopMsgDealInfo");
      this.jdField_c_of_type_AndroidViewView = findViewById(2131380070);
      this.jdField_t_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380071));
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364352));
      a();
      localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get();
      Object localObject2;
      if ((localObject1 != null) && (((List)localObject1).size() >= 2)) {
        if (this.jdField_b_of_type_Int == 82)
        {
          this.rightViewText.setVisibility(0);
          this.rightViewText.setText(((structmsg.SystemMsgAction)((List)localObject1).get(0)).detail_name.get());
          this.rightViewText.setContentDescription(((structmsg.SystemMsgAction)((List)localObject1).get(0)).detail_name.get());
          this.rightViewText.setEnabled(true);
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)((List)localObject1).get(1)).detail_name.get());
          localObject2 = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject2).leftMargin = 0;
          this.jdField_a_of_type_AndroidWidgetButton.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(((structmsg.SystemMsgAction)((List)localObject1).get(1)).detail_name.get());
          localLinearLayout.setVisibility(0);
          if (((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 3) || (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 19)) && ((TextUtils.equals(String.valueOf(90000000L), this.cX)) || (TextUtils.equals(String.valueOf(90000000L), this.jdField_l_of_type_JavaLangString)))) {
            this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
          }
          this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378357));
          if (TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_info.msg_alert.get())) {
            break label2188;
          }
          this.jdField_b_of_type_AndroidWidgetButton.setTextAppearance(this, 2131755086);
          this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130839124);
          if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() != 1) || ((this.jdField_b_of_type_Int != 1) && (this.jdField_b_of_type_Int != 22))) {
            break label2176;
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_info.msg_alert.get());
          this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_info.msg_alert.get());
          if ((localObject1 != null) && (((List)localObject1).size() == 1)) {
            this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_f_of_type_AndroidViewView$OnClickListener);
          }
          this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_f_of_type_AndroidViewView$OnClickListener);
          this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_f_of_type_AndroidViewView$OnClickListener);
          this.rightViewText.setOnClickListener(this.jdField_f_of_type_AndroidViewView$OnClickListener);
          this.jdField_n_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131361883));
          this.jdField_m_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131361882));
          this.jdField_l_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376568));
          this.jdField_n_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
          this.jdField_l_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          super.getString(2131720077);
          super.getString(2131689578);
          this.jdField_n_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_m_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_l_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_s_of_type_JavaLangString = "";
          if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() != 1) {
            break label2266;
          }
          if ((this.jdField_b_of_type_Int != 1) && (this.jdField_b_of_type_Int != 22)) {
            break label2221;
          }
          this.jdField_s_of_type_JavaLangString = this.jdField_l_of_type_JavaLangString;
          this.jdField_t_of_type_JavaLangString = "1";
          this.jdField_i_of_type_Int = 2131719854;
          i1 = 1;
        }
      }
      for (;;)
      {
        if (i1 != 0)
        {
          this.jdField_n_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_m_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_l_of_type_AndroidWidgetTextView.setVisibility(0);
        }
        if (((this.jdField_b_of_type_Int != 1) && (this.jdField_b_of_type_Int != 22) && (this.jdField_b_of_type_Int != 60)) || (!QLog.isColorLevel())) {
          break;
        }
        if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.has()) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.has()))
        {
          i1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get();
          label1772:
          if ((!this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.has()) || (!this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.has())) {
            break label2261;
          }
        }
        for (i2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get();; i2 = -1)
        {
          QLog.i("Q.systemmsg.TroopRequestActivity", 2, String.format("joinGroup subSourceID=%d sourceID=%d msgType=%d", new Object[] { Integer.valueOf(i2), Integer.valueOf(i1), Integer.valueOf(this.jdField_b_of_type_Int) }));
          return;
          i1 = 0;
          if (i1 < ((List)localObject1).size())
          {
            localObject2 = ((structmsg.SystemMsgAction)((List)localObject1).get(i1)).detail_name.get();
            if (i1 != 0) {
              break label1932;
            }
            this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
            this.jdField_b_of_type_AndroidWidgetButton.setText((CharSequence)localObject2);
            this.jdField_b_of_type_AndroidWidgetButton.setContentDescription((CharSequence)localObject2);
          }
          for (;;)
          {
            localLinearLayout.setVisibility(0);
            i1 += 1;
            break label1859;
            break;
            if (i1 == 1)
            {
              this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
              this.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject2);
              this.jdField_a_of_type_AndroidWidgetButton.setContentDescription((CharSequence)localObject2);
            }
            else if (i1 == 2)
            {
              this.rightViewText.setVisibility(0);
              this.rightViewText.setText((CharSequence)localObject2);
              this.rightViewText.setContentDescription((CharSequence)localObject2);
              this.rightViewText.setEnabled(true);
            }
          }
          if ((localObject1 != null) && (((List)localObject1).size() == 1))
          {
            this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
            this.jdField_d_of_type_AndroidWidgetTextView.setTextAppearance(this, 2131755083);
            this.jdField_d_of_type_AndroidWidgetTextView.setText(((structmsg.SystemMsgAction)((List)localObject1).get(0)).detail_name.get());
            this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(((structmsg.SystemMsgAction)((List)localObject1).get(0)).detail_name.get());
            this.jdField_d_of_type_AndroidWidgetTextView.setBackgroundResource(2130839107);
            this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
            break;
          }
          if ((this.jdField_d_of_type_AndroidWidgetTextView == null) || (TextUtils.isEmpty(this.jdField_n_of_type_JavaLangString))) {
            break;
          }
          this.jdField_d_of_type_AndroidWidgetTextView.setTextAppearance(getApplicationContext(), 2131755948);
          this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_n_of_type_JavaLangString);
          this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_n_of_type_JavaLangString);
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
          break;
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          break label1438;
          this.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this, 2131755083);
          this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839107);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          break label1438;
          if (this.jdField_b_of_type_Int != 2) {
            break label2266;
          }
          this.jdField_s_of_type_JavaLangString = this.cX;
          this.jdField_t_of_type_JavaLangString = "0";
          this.jdField_i_of_type_Int = 2131721043;
          i1 = 1;
          break label1669;
          i1 = -1;
          break label1772;
        }
        i1 = 0;
      }
    }
  }
  
  private void k()
  {
    startActivityForResult(AddFriendLogicActivity.a(this, this.jdField_a_of_type_JavaLangString, this.jdField_h_of_type_JavaLangString, this.jdField_a_of_type_Short, 10014, this.jdField_o_of_type_JavaLangString, this.jdField_p_of_type_JavaLangString, null, null, null), 0);
  }
  
  public SpannableStringBuilder a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1;
    String str;
    if (paramBoolean2)
    {
      i1 = paramString1.indexOf(paramString3);
      if (i1 > 0)
      {
        str = paramString1.substring(paramString3.length() + i1, paramString1.length());
        paramString1 = paramString1.substring(0, i1 + paramString3.length());
      }
    }
    for (;;)
    {
      Matcher localMatcher = Pattern.compile(paramString3).matcher(paramString1);
      if (!localMatcher.find()) {
        return null;
      }
      paramBoolean2 = paramString3.equals(getString(2131720530));
      paramString3 = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics(paramString3);
      i1 = (int)(paramString3.density * 17.0F);
      paramString3 = new StringBuilder(paramString1);
      paramString3.insert(localMatcher.end(), " " + paramString2);
      paramString3 = new SpannableStringBuilder(paramString3.toString());
      int i2 = localMatcher.end() + " ".length();
      boolean bool = paramString1.contains(alpo.a(2131716123));
      if (paramBoolean1)
      {
        paramString1 = new TroopRequestActivity.NumberSpan(this, bool, paramString2, paramString4, paramBoolean2);
        if (paramString2.length() + i2 > paramString3.length())
        {
          i1 = paramString3.length();
          paramString3.setSpan(paramString1, i2, i1, 33);
        }
      }
      else
      {
        if (localMatcher.end() <= paramString3.length()) {
          break label292;
        }
      }
      label292:
      for (i1 = paramString3.length();; i1 = localMatcher.end())
      {
        paramString3.delete(localMatcher.start(), i1);
        paramString3.append(str);
        return paramString3;
        i1 = paramString2.length() + i2;
        break;
      }
      str = "";
    }
  }
  
  public SpannableStringBuilder a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramString == null) {
      return null;
    }
    if (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint32_group_flagext3.get()))
    {
      int i1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get();
      if ((i1 == 16) || (i1 == 3)) {
        paramBoolean1 = false;
      }
    }
    for (;;)
    {
      String str;
      if (paramString.contains(getString(2131720538)))
      {
        str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get();
        if (TextUtils.isEmpty(str)) {
          break;
        }
        return a(paramString, str, getString(2131720538), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "", paramBoolean1, paramBoolean2);
      }
      if (paramString.contains(getString(2131720521)))
      {
        str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.get();
        if (TextUtils.isEmpty(str)) {
          break;
        }
        return a(paramString, str, getString(2131720521), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get() + "", paramBoolean1, paramBoolean2);
      }
      if (paramString.contains(getString(2131720522)))
      {
        str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actor_uin_nick.get();
        if (TextUtils.isEmpty(str)) {
          break;
        }
        return a(paramString, str, getString(2131720522), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actor_uin.get() + "", paramBoolean1, paramBoolean2);
      }
      if (paramString.contains(getString(2131720530)))
      {
        str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_name.get();
        if (TextUtils.isEmpty(str)) {
          break;
        }
        return a(paramString, str, getString(2131720530), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "", paramBoolean1, paramBoolean2);
      }
      return new SpannableStringBuilder(paramString);
    }
  }
  
  public String a(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = getString(2131696760);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.systemmsg.TroopRequestActivity", 2, String.format("getTitle msgType:%s subType:%s, srcId:%s, subSrcId:%s, title:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get()), Integer.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get()), Integer.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get()), str }));
      }
      return str;
      str = getString(2131696765);
      continue;
      str = getString(2131696764);
      continue;
      str = getString(2131696767);
      continue;
      str = getString(2131696762);
      continue;
      str = getString(2131696763);
      continue;
      str = getString(2131696771);
      continue;
      str = getString(2131696759);
      continue;
      str = getString(2131696768);
      continue;
      str = getString(2131696769);
      continue;
      str = getString(2131696770);
      continue;
      str = getString(2131696748);
      continue;
      str = getString(2131696766);
      continue;
      str = getString(2131696772);
      continue;
      str = getString(2131696761);
    }
  }
  
  public void a()
  {
    b();
    switch (this.jdField_b_of_type_Int)
    {
    }
    for (;;)
    {
      e();
      return;
      c();
      continue;
      d();
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (!isResume()) {
      return;
    }
    QQToast.a(this, paramString, 0).b(getTitleBarHeight());
    finish();
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(paramBoolean);
    }
    if (this.jdField_b_of_type_AndroidWidgetButton != null) {
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(paramBoolean);
    }
  }
  
  boolean a(String paramString)
  {
    return (paramString.contains(getString(2131720538))) || (paramString.contains(getString(2131720522))) || (paramString.contains(getString(2131720530))) || (paramString.contains(getString(2131720521)));
  }
  
  public void b()
  {
    label125:
    Object localObject1;
    if ((this.jdField_b_of_type_Int == 10) || (this.jdField_b_of_type_Int == 12) || (this.jdField_b_of_type_Int == 2))
    {
      if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.has())
      {
        this.jdField_b_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
        this.jdField_l_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      }
      if ((this.jdField_b_of_type_Int != 12) && (this.jdField_b_of_type_Int != 35) && (this.jdField_b_of_type_Int != 10) && (this.jdField_b_of_type_Int != 2)) {
        break label749;
      }
      this.jdField_c_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.get());
      if ((this.jdField_b_of_type_Int == 2) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_invite_extinfo.uint32_src_type.has())) {
        localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_qq_nick.get().toStringUtf8();
      }
      switch (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_invite_extinfo.uint32_src_type.get())
      {
      default: 
        label212:
        this.jdField_c_of_type_JavaLangString = ((String)localObject1);
        if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.pic_url.has()) && (!TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.pic_url.get().toStringUtf8()))) {
          this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.pic_url.get().toStringUtf8();
        }
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 83)
        {
          if (!TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_detail.get()))
          {
            this.r.setVisibility(0);
            this.jdField_a_of_type_AndroidTextSpannableStringBuilder = new SpannableStringBuilder(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_detail.get());
          }
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          label353:
          if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.has()) {
            this.jdField_k_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
          }
          if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_time.has()) {
            this.jdField_a_of_type_Long = Long.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_time.get()).longValue();
          }
          if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.has()) {
            this.jdField_g_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
          }
          if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_name.has()) {
            this.jdField_h_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_name.get());
          }
          if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.has()) && (this.jdField_b_of_type_Int != 10)) {
            this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get();
          }
          if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_inviter_role.has()) {
            this.jdField_c_of_type_Int = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_inviter_role.get();
          }
          if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_actor_describe.has())
          {
            localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_actor_describe.get();
            if ((!((String)localObject1).contains("%action_uin%")) || (!this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.has())) {
              break label1045;
            }
            this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.get();
          }
        }
        break;
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.bytes_warning_tips.get() != null) {
        this.jdField_q_of_type_JavaLangString = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.bytes_warning_tips.get().toStringUtf8();
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.security_verify", 2, String.format("decodeData reqUin: %s, warningTips: %s", new Object[] { this.jdField_b_of_type_JavaLangString, this.jdField_q_of_type_JavaLangString }));
      }
      return;
      if (!this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.has()) {
        break;
      }
      this.jdField_b_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get());
      break;
      label749:
      this.jdField_c_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get());
      break label125;
      localObject1 = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.get());
      break label212;
      TroopManager localTroopManager = (TroopManager)this.app.getManager(52);
      if (localTroopManager == null) {
        break label212;
      }
      String str1 = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_invite_extinfo.uint64_src_code.get());
      String str2 = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
      localObject1 = localTroopManager.d(str1);
      Object localObject2 = bdbt.a(this.app, str2, str1, (String)localObject1, true, null);
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break label212;
      }
      localObject1 = localTroopManager.a(str1, str2);
      break label212;
      localObject2 = (almv)this.app.getManager(53);
      if (localObject2 == null) {
        break label212;
      }
      localObject2 = ((almv)localObject2).a(String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_invite_extinfo.uint64_src_code.get()), String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get()));
      if (localObject2 == null) {
        break label212;
      }
      localObject1 = ((DiscussionMemberInfo)localObject2).getDiscussionMemberName();
      break label212;
      if (!this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.has()) {
        break label353;
      }
      this.r.setVisibility(0);
      localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get();
      if (a((String)localObject1))
      {
        this.jdField_a_of_type_AndroidTextSpannableStringBuilder = a((String)localObject1, true, true);
        this.r.setMovementMethod(LinkMovementMethod.getInstance());
        break label353;
      }
      this.jdField_a_of_type_AndroidTextSpannableStringBuilder = new SpannableStringBuilder((CharSequence)localObject1);
      break label353;
      label1045:
      if ((((String)localObject1).contains("%actor_uin%")) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actor_uin_nick.has()))
      {
        this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actor_uin_nick.get();
        this.cX = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actor_uin.get());
      }
      else if ((((String)localObject1).contains("%req_uin%")) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.has()))
      {
        this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get();
      }
    }
  }
  
  public void c()
  {
    Object localObject = ahla.a(this.jdField_a_of_type_Bcws, this.jdField_b_of_type_JavaLangString, 1);
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
    if ((this.jdField_b_of_type_Int == 10) || (this.jdField_b_of_type_Int == 12)) {
      this.jdField_j_of_type_JavaLangString = (this.jdField_c_of_type_JavaLangString + getString(2131696978));
    }
    for (;;)
    {
      localObject = this.jdField_d_of_type_AndroidViewView$OnClickListener;
      this.jdField_a_of_type_AndroidViewView.setOnClickListener((View.OnClickListener)localObject);
      if ((TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint32_group_flagext3.get())) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 2))
      {
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
        ((ImageView)findViewById(2131378358)).setVisibility(4);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_j_of_type_JavaLangString);
      if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
      }
      try
      {
        if (this.app != null)
        {
          localObject = (aloz)this.app.getManager(51);
          if (localObject != null) {
            ThreadManager.post(new TroopRequestActivity.1(this, (aloz)localObject), 8, null, true);
          }
        }
        if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
          this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
        }
      }
      catch (Exception localException)
      {
        try
        {
          do
          {
            for (;;)
            {
              localObject = URLDrawable.getDrawable(this.jdField_d_of_type_JavaLangString);
              this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
              this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(new aecy(this));
              this.jdField_a_of_type_ComTencentImageURLImageView.setContentDescription(alpo.a(2131716120));
              if (TextUtils.isEmpty(this.jdField_a_of_type_AndroidTextSpannableStringBuilder)) {
                break label655;
              }
              this.r.setText(this.jdField_a_of_type_AndroidTextSpannableStringBuilder);
              if (this.jdField_b_of_type_Int == 80)
              {
                this.r.setMaxLines(3);
                this.r.setSingleLine(false);
              }
              if (!TextUtils.isEmpty(this.jdField_k_of_type_JavaLangString)) {
                break label667;
              }
              this.jdField_s_of_type_AndroidWidgetTextView.setVisibility(8);
              if (this.jdField_a_of_type_Long != 0L)
              {
                localObject = a(this.jdField_a_of_type_Long * 1000L);
                this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
              }
              if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
                break label689;
              }
              localObject = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_actor_describe.get().split("：");
              if (localObject.length > 0) {
                this.jdField_f_of_type_AndroidWidgetTextView.setText(localObject[0]);
              }
              this.jdField_g_of_type_AndroidWidgetTextView.setText(this.jdField_e_of_type_JavaLangString);
              this.jdField_g_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_e_of_type_AndroidViewView$OnClickListener);
              this.jdField_e_of_type_AndroidWidgetLinearLayout.setVisibility(0);
              if ((this.jdField_b_of_type_Int != 1) && (this.jdField_b_of_type_Int != 22) && (this.jdField_b_of_type_Int != 60)) {
                break label701;
              }
              this.jdField_f_of_type_AndroidWidgetLinearLayout.setVisibility(0);
              if ((TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) || (this.jdField_b_of_type_Int == 2)) {
                break label713;
              }
              this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
              this.jdField_h_of_type_AndroidWidgetTextView.setText(this.jdField_f_of_type_JavaLangString);
              if (TextUtils.isEmpty(this.jdField_q_of_type_JavaLangString)) {
                break label725;
              }
              this.jdField_t_of_type_AndroidWidgetTextView.setText(this.jdField_q_of_type_JavaLangString);
              this.jdField_c_of_type_AndroidViewView.setVisibility(0);
              this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_h_of_type_AndroidViewView$OnClickListener);
              return;
              this.jdField_j_of_type_JavaLangString = (this.jdField_c_of_type_JavaLangString + getString(2131696979));
              break;
              this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
            }
            localException = localException;
          } while (!QLog.isColorLevel());
          QLog.w("TroopRequestActivity", 2, "getCard Exception! ");
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.systemmsg.TroopRequestActivity", 2, localIllegalArgumentException.toString());
            }
            this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
            continue;
            label655:
            this.r.setText("");
            continue;
            label667:
            this.jdField_s_of_type_AndroidWidgetTextView.setText(this.jdField_k_of_type_JavaLangString);
            this.jdField_s_of_type_AndroidWidgetTextView.setVisibility(0);
            continue;
            label689:
            this.jdField_e_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            continue;
            label701:
            this.jdField_f_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            continue;
            label713:
            this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          }
          label725:
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        }
      }
    }
  }
  
  public void d()
  {
    Object localObject = ahla.a(this.jdField_a_of_type_Bcws, this.jdField_g_of_type_JavaLangString, 4);
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
    this.jdField_j_of_type_JavaLangString = (this.jdField_h_of_type_JavaLangString + getString(2131696980));
    if (this.jdField_b_of_type_Int == 8)
    {
      this.jdField_a_of_type_AndroidViewView.setEnabled(false);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_j_of_type_JavaLangString);
      if (!TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString)) {
        break label826;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
      label112:
      localObject = (TroopManager)this.app.getManager(52);
      if (localObject == null) {
        break label1167;
      }
    }
    label1157:
    label1167:
    for (localObject = ((TroopManager)localObject).b(String.valueOf(this.jdField_a_of_type_JavaLangString));; localObject = null)
    {
      if ((localObject != null) && (((TroopInfo)localObject).dwGroupClassExt != 0L))
      {
        ThreadManager.post(new TroopRequestActivity.3(this, (TroopInfo)localObject), 8, null, true);
        label177:
        if (TextUtils.isEmpty(this.jdField_a_of_type_AndroidTextSpannableStringBuilder)) {
          break label861;
        }
        this.r.setText(this.jdField_a_of_type_AndroidTextSpannableStringBuilder);
        label198:
        if (this.jdField_b_of_type_Int == 80)
        {
          this.r.setMaxLines(3);
          this.r.setSingleLine(false);
        }
        if (!TextUtils.isEmpty(this.jdField_k_of_type_JavaLangString)) {
          break label873;
        }
        this.jdField_s_of_type_AndroidWidgetTextView.setVisibility(8);
        label242:
        if (this.jdField_a_of_type_Long != 0L)
        {
          localObject = a(this.jdField_a_of_type_Long * 1000L);
          this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        }
        if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
          break label924;
        }
        localObject = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_actor_describe.get();
        String[] arrayOfString = ((String)localObject).split("：");
        if (arrayOfString.length > 0) {
          this.jdField_f_of_type_AndroidWidgetTextView.setText(arrayOfString[0]);
        }
        this.jdField_g_of_type_AndroidWidgetTextView.setText(this.jdField_e_of_type_JavaLangString);
        if (!((String)localObject).contains(getString(2131720521))) {
          break label895;
        }
        this.jdField_g_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_e_of_type_AndroidViewView$OnClickListener);
        label362:
        this.jdField_e_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        if (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint32_group_flagext3.get()))
        {
          int i1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get();
          if ((i1 == 7) || (i1 == 11) || (i1 == 3) || (i1 == 16) || (i1 == 15)) {
            this.jdField_g_of_type_AndroidWidgetTextView.setOnClickListener(null);
          }
        }
        label441:
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() != 82) {
          break label1001;
        }
        if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.size() == 0) || (TextUtils.isEmpty(this.jdField_n_of_type_JavaLangString))) {
          break label936;
        }
        this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_i_of_type_AndroidWidgetTextView.setText(this.jdField_n_of_type_JavaLangString);
        label504:
        localObject = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get();
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label948;
        }
        this.jdField_j_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        label544:
        this.jdField_j_of_type_AndroidWidgetTextView.setOnClickListener(new aedf(this));
        azmj.b(this.app, "P_CliOper", "Grp_public", "", "oper", "exp_invite", 0, 0, "", "", "", this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "");
        label616:
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() != 83) {
          break label1022;
        }
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_pay_group_extinfo.has())
        {
          localObject = (structmsg.MsgPayGroupExt)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_pay_group_extinfo.get();
          long l1 = ((structmsg.MsgPayGroupExt)localObject).uint64_join_grp_time.get();
          long l2 = ((structmsg.MsgPayGroupExt)localObject).uint64_quit_grp_time.get();
          localObject = alpo.a(2131716122) + bdjj.a(this, l1 * 1000L, true) + "\n" + alpo.a(2131716121) + bdjj.a(this, l2 * 1000L, true);
          this.jdField_k_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_k_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        }
      }
      for (;;)
      {
        e();
        if (TextUtils.isEmpty(this.jdField_q_of_type_JavaLangString)) {
          break label1157;
        }
        this.jdField_t_of_type_AndroidWidgetTextView.setText(this.jdField_q_of_type_JavaLangString);
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_h_of_type_AndroidViewView$OnClickListener);
        return;
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
        break;
        label826:
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_h_of_type_JavaLangString);
        break label112;
        if (this.jdField_a_of_type_Alzf == null) {
          break label177;
        }
        this.jdField_a_of_type_Alzf.d(this.jdField_a_of_type_JavaLangString);
        break label177;
        label861:
        this.r.setText("");
        break label198;
        label873:
        this.jdField_s_of_type_AndroidWidgetTextView.setText(this.jdField_k_of_type_JavaLangString);
        this.jdField_s_of_type_AndroidWidgetTextView.setVisibility(0);
        break label242;
        label895:
        if (!((String)localObject).contains(getString(2131720538))) {
          break label362;
        }
        this.jdField_g_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
        break label362;
        label924:
        this.jdField_e_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        break label441;
        label936:
        this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(8);
        break label504;
        label948:
        if (QLog.isColorLevel()) {
          QLog.i(".troop.troop_pubaccount", 2, "mStructMsg.msg.req_uin_nick is empty from StructMsg_IM.proto");
        }
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        bchz.a(this.app, this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get(), new aede(this));
        break label544;
        label1001:
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(8);
        break label616;
        label1022:
        if (((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 3) || (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 19)) && ((TextUtils.equals(String.valueOf(90000000L), this.cX)) || (TextUtils.equals(String.valueOf(90000000L), this.jdField_l_of_type_JavaLangString))))
        {
          if (!TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_detail.get()))
          {
            this.jdField_k_of_type_AndroidWidgetTextView.setVisibility(0);
            this.jdField_k_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_detail.get());
          }
          this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(-16777216);
          this.jdField_g_of_type_AndroidWidgetTextView.setOnClickListener(null);
        }
      }
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      return;
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (-1 == paramInt2)
    {
      if (paramInt1 != 0) {
        break label21;
      }
      i();
    }
    for (;;)
    {
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      label21:
      if (paramInt1 != 1005) {}
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131560500);
    setContentBackgroundResource(2130838591);
    this.jdField_a_of_type_Alzf = ((alzf)this.app.a(20));
    j();
    if (getIntent().getExtras().getBoolean("groupman_refuse", false))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    }
    this.jdField_c_of_type_Boolean = getIntent().getBooleanExtra("troop_invitee_is_friend", false);
    this.jdField_d_of_type_Boolean = getIntent().getBooleanExtra("troop_suspicious_request", false);
    if ((this.jdField_c_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_c_of_type_Boolean)) {
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
    for (;;)
    {
      return true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.systemmsg.TroopRequestActivity", 2, "isShowStrangerTips == " + this.jdField_c_of_type_Boolean);
      }
    }
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_b_of_type_Int == 82) {
      this.app.removeObserver(this.jdField_a_of_type_Alsi);
    }
    if (this.jdField_a_of_type_Bcws != null) {
      this.jdField_a_of_type_Bcws.a(null);
    }
    super.doOnDestroy();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
  }
  
  public void doOnStart()
  {
    this.app.addObserver(this.jdField_a_of_type_Amab);
    this.app.addObserver(this.jdField_a_of_type_Alsi);
    this.app.addObserver(this.jdField_a_of_type_Allb);
    this.app.addObserver(this.jdField_a_of_type_Alox);
    this.app.addObserver(this.jdField_a_of_type_Alyo);
    super.doOnStart();
  }
  
  public void doOnStop()
  {
    this.app.removeObserver(this.jdField_a_of_type_Amab);
    this.app.removeObserver(this.jdField_a_of_type_Allb);
    this.app.removeObserver(this.jdField_a_of_type_Alox);
    this.app.removeObserver(this.jdField_a_of_type_Alyo);
    if (this.jdField_b_of_type_Int != 82) {
      this.app.removeObserver(this.jdField_a_of_type_Alsi);
    }
    super.doOnStop();
  }
  
  public void e()
  {
    int i1 = 0;
    int i2 = 0;
    if (i1 < jdField_d_of_type_Int)
    {
      int i3 = i2;
      if (this.jdField_a_of_type_ArrayOfAndroidWidgetLinearLayout[i1] != null)
      {
        i3 = i2;
        if (this.jdField_a_of_type_ArrayOfAndroidWidgetLinearLayout[i1].getVisibility() != 8)
        {
          this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          i3 = 1;
        }
      }
      if (i1 > 0)
      {
        if (this.jdField_a_of_type_ArrayOfAndroidWidgetLinearLayout[(i1 - 1)].getVisibility() != 8) {
          break label90;
        }
        this.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[(i1 - 1)].setVisibility(8);
      }
      for (;;)
      {
        i1 += 1;
        i2 = i3;
        break;
        label90:
        this.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[(i1 - 1)].setVisibility(0);
      }
    }
    if (i2 != 0)
    {
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      return;
    }
    this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  public void f()
  {
    bhpy localbhpy = (bhpy)bhql.a(this, null);
    String str = "";
    if (this.jdField_i_of_type_Int != 0) {
      str = getString(this.jdField_i_of_type_Int);
    }
    localbhpy.a(str);
    localbhpy.a(getString(2131720076), 3);
    localbhpy.a(new aedi(this, localbhpy));
    localbhpy.c(2131690648);
    localbhpy.show();
  }
  
  public void g()
  {
    bhpy localbhpy = (bhpy)bhql.a(this, null);
    localbhpy.a(getString(2131690673), 3);
    localbhpy.a(new aedj(this, localbhpy));
    localbhpy.c(2131690648);
    localbhpy.show();
  }
  
  public void h()
  {
    try
    {
      if (this.jdField_a_of_type_Bepp == null)
      {
        this.jdField_a_of_type_Bepp = new bepp(getActivity(), getTitleBarHeight());
        this.jdField_a_of_type_Bepp.c(2131695088);
        this.jdField_a_of_type_Bepp.c(false);
      }
      this.jdField_a_of_type_Bepp.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.systemmsg.TroopRequestActivity", 2, localException.toString());
    }
  }
  
  public void i()
  {
    try
    {
      if ((this.jdField_a_of_type_Bepp != null) && (this.jdField_a_of_type_Bepp.isShowing())) {
        this.jdField_a_of_type_Bepp.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.systemmsg.TroopRequestActivity", 2, localException.toString());
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    paramString = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get();
    paramBitmap = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get();
    if (paramString != null)
    {
      this.r.setVisibility(0);
      if (a(paramBitmap))
      {
        paramString = a(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get(), true, true);
        this.r.setMovementMethod(LinkMovementMethod.getInstance());
      }
      if (!TextUtils.isEmpty(paramString)) {
        this.r.setText(paramString);
      }
    }
    else
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_actor_describe.get())) {
        break label136;
      }
    }
    for (;;)
    {
      if (this.jdField_b_of_type_Int == 11) {}
      return;
      this.r.setText("");
      break;
      label136:
      if (!TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get())) {
        new StringBuilder().append(getResources().getString(2131720531)).append(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get()).toString();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRequestActivity
 * JD-Core Version:    0.7.0.1
 */