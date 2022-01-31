package com.tencent.mobileqq.activity;

import acle;
import aclf;
import aclg;
import aclh;
import acli;
import aclj;
import aclk;
import acll;
import aclm;
import acln;
import aclo;
import aclp;
import aclq;
import aclr;
import acls;
import aclt;
import aclu;
import aclv;
import aclw;
import aclx;
import acly;
import aclz;
import afns;
import afnt;
import ajsd;
import ajto;
import ajvi;
import ajxj;
import ajxl;
import ajya;
import akat;
import akgy;
import akhp;
import akil;
import akqw;
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
import axqy;
import aydd;
import bajl;
import baxy;
import baxz;
import bbac;
import bbak;
import bbcz;
import bbkp;
import bcqf;
import bcql;
import bfpc;
import bfpp;
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
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqt;
import mxf;
import sfe;
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
  implements ajsd, baxz
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
  public afnt a;
  ajto jdField_a_of_type_Ajto = new aclh(this);
  ajxj jdField_a_of_type_Ajxj = new acli(this);
  protected akat a;
  akgy jdField_a_of_type_Akgy = new aclp(this);
  public akhp a;
  protected akil a;
  public Handler a;
  protected SpannableStringBuilder a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aclw(this);
  protected View a;
  public Button a;
  protected ImageView a;
  protected LinearLayout a;
  protected TextView a;
  protected baxy a;
  protected bcqf a;
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
  View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new aclj(this);
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  public LinearLayout c;
  protected TextView c;
  protected String c;
  protected boolean c;
  private String cW;
  View.OnClickListener jdField_d_of_type_AndroidViewView$OnClickListener = new aclk(this);
  private LinearLayout jdField_d_of_type_AndroidWidgetLinearLayout;
  public TextView d;
  public String d;
  public boolean d;
  View.OnClickListener jdField_e_of_type_AndroidViewView$OnClickListener = new acll(this);
  private LinearLayout jdField_e_of_type_AndroidWidgetLinearLayout;
  protected TextView e;
  protected String e;
  View.OnClickListener jdField_f_of_type_AndroidViewView$OnClickListener = new aclm(this);
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
    jdField_b_of_type_Boolean = AppSetting.jdField_d_of_type_Boolean;
  }
  
  public TroopRequestActivity()
  {
    this.jdField_s_of_type_JavaLangString = "";
    this.jdField_t_of_type_JavaLangString = "";
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new aclx(this);
    this.jdField_a_of_type_AndroidOsHandler = new acle(this);
    this.jdField_a_of_type_Akil = new aclf(this);
    this.jdField_a_of_type_Akat = new aclg(this);
    this.jdField_g_of_type_AndroidViewView$OnClickListener = new acln(this);
    this.jdField_a_of_type_Afnt = new acls(this);
    this.jdField_h_of_type_AndroidViewView$OnClickListener = new aclt(this);
  }
  
  public static String a(long paramLong)
  {
    Time localTime1 = new Time();
    localTime1.set(paramLong);
    long l1 = System.currentTimeMillis();
    Time localTime2 = new Time();
    localTime2.set(l1);
    if (localTime1.year == localTime2.year) {
      return bbkp.a(paramLong, true, "MM-dd");
    }
    return bbkp.a(paramLong, true, "yyyy-MM-dd");
  }
  
  private void a(long paramLong, structmsg.StructMsg paramStructMsg)
  {
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("structMsg", paramStructMsg.toByteArray());
    bajl.a(this.app, paramLong, new aclq(this), localBundle);
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, structmsg.StructMsg paramStructMsg, afnt paramafnt)
  {
    if ((paramQQAppInterface == null) || (paramafnt == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    afns.a(paramString, paramStructMsg);
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
    mxf.a(paramQQAppInterface, new aclr(paramString, paramContext, paramafnt, paramStructMsg), ((oidb_sso.OIDBSSOPkg)localObject1).toByteArray(), "OidbSvc.0x88d_0");
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
      localObject1 = getString(2131694074);
      this.jdField_o_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      if (paramCard.age <= 0) {
        break label579;
      }
      localObject1 = paramCard.age + getString(2131719971);
      this.jdField_p_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      this.jdField_p_of_type_AndroidWidgetTextView.setContentDescription((CharSequence)localObject1);
      this.jdField_p_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject2 = "";
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramCard.strCountry))
      {
        localObject1 = localObject2;
        if (!paramCard.strCountry.equals(getString(2131717071))) {
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
      TextView localTextView = (TextView)this.jdField_f_of_type_AndroidWidgetLinearLayout.findViewById(2131375163);
      if (QLog.isColorLevel()) {
        QLog.d("Q.systemmsg.TroopRequestActivity", 2, "updateLevelAndVip bSuperVipOpen=" + bool1 + ",bQQVipOpen=" + bool2 + ",VipLevel=" + i1 + ",QQLevel=" + paramCard.iQQLevel);
      }
      if ((bool1) || (bool2)) {
        ((SpannableStringBuilder)localObject1).append(bbak.a(localTextView, (Resources)localObject2, bool1, bool2, Math.max(i1, 1)));
      }
      if (paramCard.iQQLevel >= 0) {
        ((SpannableStringBuilder)localObject1).append(bbac.a(this, 15, paramCard.mQQLevelType, paramCard.iQQLevel, false));
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
      this.jdField_f_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      return;
      if (paramCard.shGender == 1)
      {
        localObject1 = getString(2131692394);
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
    long l1 = aydd.a().b();
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = aydd.a().a(Long.valueOf(l1));
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
    long l1 = aydd.a().b();
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = aydd.a().a(Long.valueOf(l1));
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
    long l1 = aydd.a().b();
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = aydd.a().a(Long.valueOf(l1));
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
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131377831);
    localLinearLayout.setVisibility(8);
    this.jdField_a_of_type_Baxy = new baxy(this, this.app);
    this.jdField_a_of_type_Baxy.a(this);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get();
    this.jdField_a_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
    this.cW = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
    this.jdField_l_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get());
    this.jdField_m_of_type_JavaLangString = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get();
    label298:
    Object localObject1;
    label600:
    int i2;
    if (this.jdField_m_of_type_JavaLangString.startsWith(getString(2131720003)))
    {
      this.jdField_m_of_type_JavaLangString = this.jdField_m_of_type_JavaLangString.replace(getString(2131720003), "");
      setLeftViewName(2131691088);
      setTitle(a(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get()));
      this.jdField_a_of_type_AndroidViewView = findViewById(2131377822);
      this.jdField_b_of_type_AndroidViewView = ((LinearLayout)findViewById(2131377823));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377819));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131377827));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377830));
      this.jdField_o_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377828));
      this.jdField_p_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377825));
      this.jdField_q_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377826));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377816));
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131377824));
      this.r = ((TextView)findViewById(2131377821));
      this.jdField_s_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377818));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131362208));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131375064));
      this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131377820));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377817));
      this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_g_of_type_AndroidViewView$OnClickListener);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131377814));
      localObject1 = mqt.b(BaseApplication.getContext(), 2130839016);
      if (localObject1 == null) {
        break label853;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131377815));
      this.jdField_e_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131375156));
      this.jdField_f_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131375162));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131375154));
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131375159));
      localObject1 = (TextView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131375161);
      if (localObject1 != null) {
        ((TextView)localObject1).setText(sfe.a(this.app, getApplicationContext()));
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
      if (!this.jdField_m_of_type_JavaLangString.startsWith(getString(2131719986))) {
        break label298;
      }
      this.jdField_m_of_type_JavaLangString = this.jdField_m_of_type_JavaLangString.replace(getString(2131719986), "");
      break label298;
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130839016);
      break label600;
      label866:
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131375158));
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131375157));
      this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131375160));
      this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView = ((AnimationTextView)findViewById(2131375163));
      this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131375155));
      this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372107));
      this.jdField_k_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365056));
      this.jdField_n_of_type_JavaLangString = getIntent().getExtras().getString("troopMsgDealInfo");
      this.jdField_c_of_type_AndroidViewView = findViewById(2131379356);
      this.jdField_t_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379357));
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364284));
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
          if (((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 3) || (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 19)) && ((TextUtils.equals(String.valueOf(90000000L), this.cW)) || (TextUtils.equals(String.valueOf(90000000L), this.jdField_l_of_type_JavaLangString)))) {
            this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
          }
          this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377813));
          if (TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_info.msg_alert.get())) {
            break label2188;
          }
          this.jdField_b_of_type_AndroidWidgetButton.setTextAppearance(this, 2131755083);
          this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130839043);
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
          this.jdField_l_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376069));
          this.jdField_n_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
          this.jdField_l_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          super.getString(2131719545);
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
          this.jdField_i_of_type_Int = 2131719370;
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
            this.jdField_d_of_type_AndroidWidgetTextView.setTextAppearance(this, 2131755080);
            this.jdField_d_of_type_AndroidWidgetTextView.setText(((structmsg.SystemMsgAction)((List)localObject1).get(0)).detail_name.get());
            this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(((structmsg.SystemMsgAction)((List)localObject1).get(0)).detail_name.get());
            this.jdField_d_of_type_AndroidWidgetTextView.setBackgroundResource(2130839026);
            this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
            break;
          }
          if ((this.jdField_d_of_type_AndroidWidgetTextView == null) || (TextUtils.isEmpty(this.jdField_n_of_type_JavaLangString))) {
            break;
          }
          this.jdField_d_of_type_AndroidWidgetTextView.setTextAppearance(getApplicationContext(), 2131755929);
          this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_n_of_type_JavaLangString);
          this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_n_of_type_JavaLangString);
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
          break;
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          break label1438;
          this.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this, 2131755080);
          this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839026);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          break label1438;
          if (this.jdField_b_of_type_Int != 2) {
            break label2266;
          }
          this.jdField_s_of_type_JavaLangString = this.cW;
          this.jdField_t_of_type_JavaLangString = "0";
          this.jdField_i_of_type_Int = 2131720504;
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
      paramBoolean2 = paramString3.equals(getString(2131719995));
      paramString3 = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics(paramString3);
      i1 = (int)(paramString3.density * 17.0F);
      paramString3 = new StringBuilder(paramString1);
      paramString3.insert(localMatcher.end(), " " + paramString2);
      paramString3 = new SpannableStringBuilder(paramString3.toString());
      int i2 = localMatcher.end() + " ".length();
      boolean bool = paramString1.contains(ajya.a(2131715751));
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
      if (paramString.contains(getString(2131720003)))
      {
        str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get();
        if (TextUtils.isEmpty(str)) {
          break;
        }
        return a(paramString, str, getString(2131720003), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "", paramBoolean1, paramBoolean2);
      }
      if (paramString.contains(getString(2131719986)))
      {
        str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.get();
        if (TextUtils.isEmpty(str)) {
          break;
        }
        return a(paramString, str, getString(2131719986), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get() + "", paramBoolean1, paramBoolean2);
      }
      if (paramString.contains(getString(2131719987)))
      {
        str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actor_uin_nick.get();
        if (TextUtils.isEmpty(str)) {
          break;
        }
        return a(paramString, str, getString(2131719987), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actor_uin.get() + "", paramBoolean1, paramBoolean2);
      }
      if (paramString.contains(getString(2131719995)))
      {
        str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_name.get();
        if (TextUtils.isEmpty(str)) {
          break;
        }
        return a(paramString, str, getString(2131719995), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "", paramBoolean1, paramBoolean2);
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
      str = getString(2131696585);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.systemmsg.TroopRequestActivity", 2, String.format("getTitle msgType:%s subType:%s, srcId:%s, subSrcId:%s, title:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get()), Integer.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get()), Integer.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get()), str }));
      }
      return str;
      str = getString(2131696590);
      continue;
      str = getString(2131696589);
      continue;
      str = getString(2131696592);
      continue;
      str = getString(2131696587);
      continue;
      str = getString(2131696588);
      continue;
      str = getString(2131696596);
      continue;
      str = getString(2131696584);
      continue;
      str = getString(2131696593);
      continue;
      str = getString(2131696594);
      continue;
      str = getString(2131696595);
      continue;
      str = getString(2131696573);
      continue;
      str = getString(2131696591);
      continue;
      str = getString(2131696597);
      continue;
      str = getString(2131696586);
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
    bcql.a(this, paramString, 0).b(getTitleBarHeight());
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
    return (paramString.contains(getString(2131720003))) || (paramString.contains(getString(2131719987))) || (paramString.contains(getString(2131719995))) || (paramString.contains(getString(2131719986)));
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
      Object localObject2 = bbcz.a(this.app, str2, str1, (String)localObject1, true, null);
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break label212;
      }
      localObject1 = localTroopManager.a(str1, str2);
      break label212;
      localObject2 = (ajvi)this.app.getManager(53);
      if (localObject2 == null) {
        break label212;
      }
      localObject2 = ((ajvi)localObject2).a(String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_invite_extinfo.uint64_src_code.get()), String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get()));
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
        this.cW = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actor_uin.get());
      }
      else if ((((String)localObject1).contains("%req_uin%")) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.has()))
      {
        this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get();
      }
    }
  }
  
  public void c()
  {
    Object localObject = afns.a(this.jdField_a_of_type_Baxy, this.jdField_b_of_type_JavaLangString, 1);
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
    if ((this.jdField_b_of_type_Int == 10) || (this.jdField_b_of_type_Int == 12)) {
      this.jdField_j_of_type_JavaLangString = (this.jdField_c_of_type_JavaLangString + getString(2131696803));
    }
    for (;;)
    {
      localObject = this.jdField_d_of_type_AndroidViewView$OnClickListener;
      this.jdField_a_of_type_AndroidViewView.setOnClickListener((View.OnClickListener)localObject);
      if ((TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint32_group_flagext3.get())) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 2))
      {
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
        ((ImageView)findViewById(2131377814)).setVisibility(4);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_j_of_type_JavaLangString);
      if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
      }
      try
      {
        if (this.app != null)
        {
          localObject = (ajxl)this.app.getManager(51);
          if (localObject != null) {
            ThreadManager.post(new TroopRequestActivity.1(this, (ajxl)localObject), 8, null, true);
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
              this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(new aclo(this));
              this.jdField_a_of_type_ComTencentImageURLImageView.setContentDescription(ajya.a(2131715748));
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
              this.jdField_j_of_type_JavaLangString = (this.jdField_c_of_type_JavaLangString + getString(2131696804));
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
    Object localObject = afns.a(this.jdField_a_of_type_Baxy, this.jdField_g_of_type_JavaLangString, 4);
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
    this.jdField_j_of_type_JavaLangString = (this.jdField_h_of_type_JavaLangString + getString(2131696805));
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
        if (!((String)localObject).contains(getString(2131719986))) {
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
        this.jdField_j_of_type_AndroidWidgetTextView.setOnClickListener(new aclv(this));
        axqy.b(this.app, "P_CliOper", "Grp_public", "", "oper", "exp_invite", 0, 0, "", "", "", this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "");
        label616:
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() != 83) {
          break label1022;
        }
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_pay_group_extinfo.has())
        {
          localObject = (structmsg.MsgPayGroupExt)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_pay_group_extinfo.get();
          long l1 = ((structmsg.MsgPayGroupExt)localObject).uint64_join_grp_time.get();
          long l2 = ((structmsg.MsgPayGroupExt)localObject).uint64_quit_grp_time.get();
          localObject = ajya.a(2131715750) + bbkp.a(this, l1 * 1000L, true) + "\n" + ajya.a(2131715749) + bbkp.a(this, l2 * 1000L, true);
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
        if (this.jdField_a_of_type_Akhp == null) {
          break label177;
        }
        this.jdField_a_of_type_Akhp.d(this.jdField_a_of_type_JavaLangString);
        break label177;
        label861:
        this.r.setText("");
        break label198;
        label873:
        this.jdField_s_of_type_AndroidWidgetTextView.setText(this.jdField_k_of_type_JavaLangString);
        this.jdField_s_of_type_AndroidWidgetTextView.setVisibility(0);
        break label242;
        label895:
        if (!((String)localObject).contains(getString(2131720003))) {
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
        bajl.a(this.app, this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get(), new aclu(this));
        break label544;
        label1001:
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(8);
        break label616;
        label1022:
        if (((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 3) || (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 19)) && ((TextUtils.equals(String.valueOf(90000000L), this.cW)) || (TextUtils.equals(String.valueOf(90000000L), this.jdField_l_of_type_JavaLangString))))
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
    super.setContentView(2131560392);
    setContentBackgroundResource(2130838514);
    this.jdField_a_of_type_Akhp = ((akhp)this.app.a(20));
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
      this.app.removeObserver(this.jdField_a_of_type_Akat);
    }
    if (this.jdField_a_of_type_Baxy != null) {
      this.jdField_a_of_type_Baxy.a(null);
    }
    super.doOnDestroy();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
  }
  
  public void doOnStart()
  {
    this.app.addObserver(this.jdField_a_of_type_Akil);
    this.app.addObserver(this.jdField_a_of_type_Akat);
    this.app.addObserver(this.jdField_a_of_type_Ajto);
    this.app.addObserver(this.jdField_a_of_type_Ajxj);
    this.app.addObserver(this.jdField_a_of_type_Akgy);
    super.doOnStart();
  }
  
  public void doOnStop()
  {
    this.app.removeObserver(this.jdField_a_of_type_Akil);
    this.app.removeObserver(this.jdField_a_of_type_Ajto);
    this.app.removeObserver(this.jdField_a_of_type_Ajxj);
    this.app.removeObserver(this.jdField_a_of_type_Akgy);
    if (this.jdField_b_of_type_Int != 82) {
      this.app.removeObserver(this.jdField_a_of_type_Akat);
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
    bfpc localbfpc = (bfpc)bfpp.a(this, null);
    String str = "";
    if (this.jdField_i_of_type_Int != 0) {
      str = getString(this.jdField_i_of_type_Int);
    }
    localbfpc.a(str);
    localbfpc.a(getString(2131719544), 3);
    localbfpc.a(new acly(this, localbfpc));
    localbfpc.c(2131690596);
    localbfpc.show();
  }
  
  public void g()
  {
    bfpc localbfpc = (bfpc)bfpp.a(this, null);
    localbfpc.a(getString(2131690621), 3);
    localbfpc.a(new aclz(this, localbfpc));
    localbfpc.c(2131690596);
    localbfpc.show();
  }
  
  public void h()
  {
    try
    {
      if (this.jdField_a_of_type_Bcqf == null)
      {
        this.jdField_a_of_type_Bcqf = new bcqf(getActivity(), getTitleBarHeight());
        this.jdField_a_of_type_Bcqf.c(2131694931);
        this.jdField_a_of_type_Bcqf.c(false);
      }
      this.jdField_a_of_type_Bcqf.show();
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
      if ((this.jdField_a_of_type_Bcqf != null) && (this.jdField_a_of_type_Bcqf.isShowing())) {
        this.jdField_a_of_type_Bcqf.dismiss();
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
        new StringBuilder().append(getResources().getString(2131719996)).append(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get()).toString();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRequestActivity
 * JD-Core Version:    0.7.0.1
 */