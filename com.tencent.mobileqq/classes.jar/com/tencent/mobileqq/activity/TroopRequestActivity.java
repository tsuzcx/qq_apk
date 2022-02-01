package com.tencent.mobileqq.activity;

import Override;
import afgs;
import afgt;
import afgu;
import afgv;
import afgw;
import afgx;
import afgy;
import afgz;
import afha;
import afhb;
import afhc;
import afhd;
import afhe;
import afhf;
import afhg;
import afhh;
import afhi;
import afhj;
import afhk;
import afhl;
import afhm;
import afhn;
import afho;
import ajfn;
import ajfq;
import ajfr;
import ajhw;
import ajhx;
import ajia;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.format.Time;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
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
import antp;
import anvi;
import anvk;
import anvx;
import anyz;
import aoec;
import aoep;
import aofu;
import aooy;
import bdla;
import bdzy;
import bgiv;
import bhaa;
import bhai;
import bhid;
import bisl;
import bkzi;
import bkzz;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mrx;
import ntb;
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
import usu;

public class TroopRequestActivity
  extends IphoneTitleBarActivity
  implements AppConstants, FaceDecoder.DecodeTaskCompletionListener
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
  public ajfr a;
  public Handler a;
  protected SpannableStringBuilder a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new afhm(this);
  protected View a;
  public Button a;
  protected ImageView a;
  protected LinearLayout a;
  protected TextView a;
  anvi jdField_a_of_type_Anvi = new afgy(this);
  protected anyz a;
  aoec jdField_a_of_type_Aoec = new afhe(this);
  public aoep a;
  protected aofu a;
  protected bisl a;
  protected URLImageView a;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new afgx(this);
  protected FaceDecoder a;
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
  View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new afgz(this);
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  public LinearLayout c;
  protected TextView c;
  protected String c;
  protected boolean c;
  View.OnClickListener jdField_d_of_type_AndroidViewView$OnClickListener = new afha(this);
  private LinearLayout jdField_d_of_type_AndroidWidgetLinearLayout;
  public TextView d;
  public String d;
  public boolean d;
  View.OnClickListener jdField_e_of_type_AndroidViewView$OnClickListener = new afhb(this);
  private LinearLayout jdField_e_of_type_AndroidWidgetLinearLayout;
  protected TextView e;
  protected String e;
  View.OnClickListener jdField_f_of_type_AndroidViewView$OnClickListener = new afhc(this);
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
  public int j;
  public TextView j;
  protected String j;
  int k;
  protected TextView k;
  protected String k;
  public int l;
  protected TextView l;
  protected String l;
  protected TextView m;
  public String m;
  protected TextView n;
  protected String n;
  public TextView o;
  protected String o;
  TextView p;
  public String p;
  TextView q;
  public String q;
  protected TextView r;
  protected String r;
  private TextView s;
  public String s;
  private TextView t;
  public String t;
  private TextView u;
  public String u;
  private String v;
  
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
    this.jdField_t_of_type_JavaLangString = "";
    this.jdField_u_of_type_JavaLangString = "";
    this.jdField_j_of_type_Int = 0;
    this.jdField_k_of_type_Int = 0;
    this.jdField_l_of_type_Int = 0;
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new afhn(this);
    this.jdField_a_of_type_AndroidOsHandler = new afgu(this);
    this.jdField_a_of_type_Aofu = new afgv(this);
    this.jdField_a_of_type_Anyz = new afgw(this);
    this.jdField_g_of_type_AndroidViewView$OnClickListener = new afhd(this);
    this.jdField_a_of_type_Ajfr = new afhh(this);
    this.jdField_h_of_type_AndroidViewView$OnClickListener = new afhi(this);
  }
  
  public static String a(long paramLong)
  {
    Time localTime1 = new Time();
    localTime1.set(paramLong);
    long l1 = System.currentTimeMillis();
    Time localTime2 = new Time();
    localTime2.set(l1);
    if (localTime1.year == localTime2.year) {
      return bhid.a(paramLong, true, "MM-dd");
    }
    return bhid.a(paramLong, true, "yyyy-MM-dd");
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 1)
    {
      paramInt = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
      if (paramInt != 2) {
        break label35;
      }
      this.jdField_o_of_type_JavaLangString = getString(2131699050);
    }
    label35:
    do
    {
      return;
      if (paramInt == 3)
      {
        this.jdField_o_of_type_JavaLangString = getString(2131699059);
        return;
      }
    } while (paramInt != 4);
    this.jdField_o_of_type_JavaLangString = getString(2131699053);
  }
  
  private void a(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 1)
    {
      this.jdField_a_of_type_AndroidTextSpannableStringBuilder = new SpannableStringBuilder(getString(2131699058) + " " + getString(2131699056));
      localForegroundColorSpan = new ForegroundColorSpan(Color.parseColor("#00CAFC"));
      this.jdField_a_of_type_AndroidTextSpannableStringBuilder.setSpan(localForegroundColorSpan, 5, this.jdField_a_of_type_AndroidTextSpannableStringBuilder.length(), 33);
      this.jdField_a_of_type_AndroidTextSpannableStringBuilder.setSpan(new afgs(this, paramString), 5, this.jdField_a_of_type_AndroidTextSpannableStringBuilder.length(), 33);
      this.s.setMovementMethod(LinkMovementMethod.getInstance());
    }
    while (paramInt1 != 2)
    {
      ForegroundColorSpan localForegroundColorSpan;
      return;
    }
    paramString = "";
    if (paramInt2 == 2) {
      paramString = getString(2131699065);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidTextSpannableStringBuilder = new SpannableStringBuilder(paramString + getString(2131699055));
      return;
      if (paramInt2 == 3) {
        paramString = getString(2131699067);
      }
    }
  }
  
  private void a(int paramInt, String paramString1, long paramLong1, long paramLong2, long paramLong3, String paramString2, String paramString3)
  {
    if (paramInt == 1) {
      if (TextUtils.isEmpty(paramString3)) {}
    }
    for (;;)
    {
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2))
      {
        paramString1 = paramString2;
        if (paramLong3 > 0L) {
          paramString1 = String.valueOf(paramLong3);
        }
      }
      if ((!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString1))) {
        this.jdField_l_of_type_JavaLangString = (getString(2131699057) + " " + paramString3 + getString(2131699054) + paramString1);
      }
      for (;;)
      {
        return;
        if (paramLong2 <= 0L) {
          break label166;
        }
        paramString3 = String.valueOf(paramLong2);
        break;
        if (paramInt == 2)
        {
          if (!TextUtils.isEmpty(paramString1)) {}
          while (!TextUtils.isEmpty(paramString1))
          {
            this.jdField_e_of_type_JavaLangString = paramString1;
            return;
            if (paramLong1 > 0L) {
              paramString1 = String.valueOf(paramLong1);
            } else {
              paramString1 = "";
            }
          }
        }
      }
      label166:
      paramString3 = "";
    }
  }
  
  private void a(long paramLong, structmsg.StructMsg paramStructMsg)
  {
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("structMsg", paramStructMsg.toByteArray());
    bgiv.a(this.app, paramLong, new afhf(this), localBundle);
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, structmsg.StructMsg paramStructMsg, ajfr paramajfr)
  {
    if ((paramQQAppInterface == null) || (paramajfr == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    ajfq.a(paramString, paramStructMsg);
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
    ntb.a(paramQQAppInterface, new afhg(paramString, paramContext, paramajfr, paramStructMsg), ((oidb_sso.OIDBSSOPkg)localObject1).toByteArray(), "OidbSvc.0x88d_0");
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
      localObject1 = getString(2131693752);
      this.jdField_o_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      if (paramCard.age <= 0) {
        break label577;
      }
      localObject1 = paramCard.age + getString(2131719132);
      this.jdField_p_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      this.jdField_p_of_type_AndroidWidgetTextView.setContentDescription((CharSequence)localObject1);
      this.jdField_p_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject2 = "";
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramCard.strCountry))
      {
        localObject1 = localObject2;
        if (!paramCard.strCountry.equals(getString(2131716404))) {
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
        break label618;
      }
      localObject2 = getResources();
      if (paramCard.bSuperVipOpen != 1) {
        break label607;
      }
      bool1 = true;
      label368:
      if (paramCard.bQQVipOpen != 1) {
        break label612;
      }
    }
    label577:
    label607:
    label612:
    for (boolean bool2 = true;; bool2 = false)
    {
      int i1 = paramCard.iQQVipLevel;
      TextView localTextView = (TextView)this.jdField_f_of_type_AndroidWidgetLinearLayout.findViewById(2131376574);
      if (QLog.isColorLevel()) {
        QLog.d("Q.systemmsg.TroopRequestActivity", 2, "updateLevelAndVip bSuperVipOpen=" + bool1 + ",bQQVipOpen=" + bool2 + ",VipLevel=" + i1 + ",QQLevel=" + paramCard.iQQLevel);
      }
      if ((bool1) || (bool2)) {
        ((SpannableStringBuilder)localObject1).append(bhai.a(localTextView, (Resources)localObject2, bool1, bool2, Math.max(i1, 1)));
      }
      if (paramCard.iQQLevel >= 0) {
        ((SpannableStringBuilder)localObject1).append(bhaa.a(this, 15, paramCard.mQQLevelType, paramCard.iQQLevel, false));
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
      this.jdField_f_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      return;
      if (paramCard.shGender == 1)
      {
        localObject1 = getString(2131692198);
        break;
      }
      this.jdField_o_of_type_AndroidWidgetTextView.setVisibility(8);
      break;
      this.jdField_p_of_type_AndroidWidgetTextView.setText("");
      this.jdField_p_of_type_AndroidWidgetTextView.setContentDescription("");
      this.jdField_p_of_type_AndroidWidgetTextView.setVisibility(8);
      break label152;
      bool1 = false;
      break label368;
    }
    label618:
    this.jdField_f_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  private boolean a()
  {
    boolean bool2 = false;
    Object localObject = bdzy.a().b();
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = bdzy.a().a((String)localObject);
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null)
    {
      int i1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_type.get();
      long l1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_seq.get();
      long l2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get();
      int i2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
      int i3 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get();
      int i4 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get();
      int i5 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get();
      localObject = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get();
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((List)localObject).size() < 0)
        {
          ((structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject).get(0)).action_info.get()).blacklist.set(true);
          this.app.getMsgHandler().a().a(i1, l1, l2, i2, i3, i4, i5, (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject).get(0)).action_info.get(), 0);
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private boolean a(int paramInt)
  {
    boolean bool2 = false;
    Object localObject = bdzy.a().b();
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = bdzy.a().a((String)localObject);
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null)
    {
      int i1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_type.get();
      long l1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_seq.get();
      long l2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get();
      int i2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
      int i3 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get();
      int i4 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get();
      int i5 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get();
      localObject = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get();
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (paramInt < ((List)localObject).size())
        {
          this.app.getMsgHandler().a().a(i1, l1, l2, i2, i3, i4, i5, (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject).get(paramInt)).action_info.get(), paramInt);
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void i()
  {
    Object localObject1 = bdzy.a().b();
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = bdzy.a().a((String)localObject1);
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg == null)
    {
      finish();
      return;
    }
    int i1;
    if (QLog.isColorLevel())
    {
      long l1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint32_group_flagext3.get();
      boolean bool = TroopInfo.isQidianPrivateTroop(l1);
      i1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get();
      QLog.d(".troop.qidian_private_troop", 2, "TroopRequestActivity init: msgType=" + i1 + ", isQidianPrivateTroop=" + bool + ", flagExt3=" + l1);
    }
    localObject1 = (LinearLayout)findViewById(2131379520);
    ((LinearLayout)localObject1).setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(this, this.app);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(this);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get();
    this.jdField_a_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
    this.v = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
    this.jdField_m_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get());
    this.jdField_n_of_type_JavaLangString = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get();
    label295:
    Object localObject2;
    label597:
    int i2;
    if (this.jdField_n_of_type_JavaLangString.startsWith(getString(2131719154)))
    {
      this.jdField_n_of_type_JavaLangString = this.jdField_n_of_type_JavaLangString.replace(getString(2131719154), "");
      setLeftViewName(2131691074);
      setTitle(a(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get()));
      this.jdField_a_of_type_AndroidViewView = findViewById(2131379511);
      this.jdField_b_of_type_AndroidViewView = ((LinearLayout)findViewById(2131379512));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379507));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131379516));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379519));
      this.jdField_o_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379517));
      this.jdField_p_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379514));
      this.jdField_q_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379515));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379504));
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131379513));
      this.s = ((TextView)findViewById(2131379510));
      this.jdField_t_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379506));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131362323));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131376468));
      this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131379509));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379505));
      this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_g_of_type_AndroidViewView$OnClickListener);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131379502));
      localObject2 = mrx.b(BaseApplication.getContext(), 2130839337);
      if (localObject2 == null) {
        break label850;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131379503));
      this.jdField_e_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131376567));
      this.jdField_f_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131376573));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131376565));
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131376570));
      localObject2 = (TextView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131376572);
      if (localObject2 != null) {
        ((TextView)localObject2).setText(usu.a(this.app, getApplicationContext()));
      }
      this.jdField_a_of_type_ArrayOfAndroidWidgetLinearLayout[jdField_e_of_type_Int] = this.jdField_e_of_type_AndroidWidgetLinearLayout;
      this.jdField_a_of_type_ArrayOfAndroidWidgetLinearLayout[jdField_f_of_type_Int] = this.jdField_f_of_type_AndroidWidgetLinearLayout;
      this.jdField_a_of_type_ArrayOfAndroidWidgetLinearLayout[jdField_g_of_type_Int] = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      this.jdField_a_of_type_ArrayOfAndroidWidgetLinearLayout[jdField_h_of_type_Int] = this.jdField_b_of_type_AndroidWidgetLinearLayout;
      int i3 = this.jdField_d_of_type_AndroidWidgetLinearLayout.getChildCount();
      i2 = 0;
      i1 = 0;
      label763:
      if (i2 >= i3) {
        break label863;
      }
      if (!(this.jdField_d_of_type_AndroidWidgetLinearLayout.getChildAt(i2) instanceof RelativeLayout)) {
        break label2290;
      }
      this.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i1] = ((RelativeLayout)this.jdField_d_of_type_AndroidWidgetLinearLayout.getChildAt(i2));
      i1 += 1;
    }
    label850:
    label863:
    label2280:
    label2285:
    label2290:
    for (;;)
    {
      i2 += 1;
      break label763;
      if (!this.jdField_n_of_type_JavaLangString.startsWith(getString(2131719142))) {
        break label295;
      }
      this.jdField_n_of_type_JavaLangString = this.jdField_n_of_type_JavaLangString.replace(getString(2131719142), "");
      break label295;
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130839337);
      break label597;
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376569));
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376568));
      this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376571));
      this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView = ((AnimationTextView)findViewById(2131376574));
      this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376566));
      this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373328));
      this.jdField_k_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365551));
      this.jdField_o_of_type_JavaLangString = getIntent().getExtras().getString("troopMsgDealInfo");
      this.jdField_c_of_type_AndroidViewView = findViewById(2131381334);
      this.jdField_u_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131381335));
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364725));
      this.jdField_r_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379508));
      a();
      localObject2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get();
      Object localObject3;
      if ((localObject2 != null) && (((List)localObject2).size() >= 2) && (this.jdField_k_of_type_Int != 2)) {
        if (this.jdField_b_of_type_Int == 82)
        {
          this.rightViewText.setVisibility(0);
          this.rightViewText.setText(((structmsg.SystemMsgAction)((List)localObject2).get(0)).detail_name.get());
          this.rightViewText.setContentDescription(((structmsg.SystemMsgAction)((List)localObject2).get(0)).detail_name.get());
          this.rightViewText.setEnabled(true);
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)((List)localObject2).get(1)).detail_name.get());
          localObject3 = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject3).leftMargin = 0;
          this.jdField_a_of_type_AndroidWidgetButton.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(((structmsg.SystemMsgAction)((List)localObject2).get(1)).detail_name.get());
          ((LinearLayout)localObject1).setVisibility(0);
          if (((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 3) || (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 19)) && ((TextUtils.equals(String.valueOf(90000000L), this.v)) || (TextUtils.equals(String.valueOf(90000000L), this.jdField_m_of_type_JavaLangString)))) {
            this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
          }
          this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379501));
          if (TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_info.msg_alert.get())) {
            break label2207;
          }
          this.jdField_b_of_type_AndroidWidgetButton.setTextAppearance(this, 2131755088);
          this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130839364);
          if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() != 1) || ((this.jdField_b_of_type_Int != 1) && (this.jdField_b_of_type_Int != 22))) {
            break label2195;
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_info.msg_alert.get());
          this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_info.msg_alert.get());
          if ((localObject2 != null) && (((List)localObject2).size() == 1)) {
            this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_f_of_type_AndroidViewView$OnClickListener);
          }
          this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_f_of_type_AndroidViewView$OnClickListener);
          this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_f_of_type_AndroidViewView$OnClickListener);
          this.rightViewText.setOnClickListener(this.jdField_f_of_type_AndroidViewView$OnClickListener);
          this.jdField_n_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131361931));
          this.jdField_m_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131361930));
          this.jdField_l_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377607));
          this.jdField_n_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
          this.jdField_l_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          super.getString(2131718818);
          super.getString(2131689512);
          this.jdField_n_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_m_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_l_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_t_of_type_JavaLangString = "";
          if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() != 1) {
            break label2285;
          }
          if ((this.jdField_b_of_type_Int != 1) && (this.jdField_b_of_type_Int != 22)) {
            break label2240;
          }
          this.jdField_t_of_type_JavaLangString = this.jdField_m_of_type_JavaLangString;
          this.jdField_u_of_type_JavaLangString = "1";
          this.jdField_i_of_type_Int = 2131718579;
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
          label1791:
          if ((!this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.has()) || (!this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.has())) {
            break label2280;
          }
        }
        for (i2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get();; i2 = -1)
        {
          QLog.i("Q.systemmsg.TroopRequestActivity", 2, String.format("joinGroup subSourceID=%d sourceID=%d msgType=%d", new Object[] { Integer.valueOf(i2), Integer.valueOf(i1), Integer.valueOf(this.jdField_b_of_type_Int) }));
          return;
          i1 = 0;
          if (i1 < ((List)localObject2).size())
          {
            localObject3 = ((structmsg.SystemMsgAction)((List)localObject2).get(i1)).detail_name.get();
            if (i1 != 0) {
              break label1951;
            }
            this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
            this.jdField_b_of_type_AndroidWidgetButton.setText((CharSequence)localObject3);
            this.jdField_b_of_type_AndroidWidgetButton.setContentDescription((CharSequence)localObject3);
          }
          for (;;)
          {
            ((LinearLayout)localObject1).setVisibility(0);
            i1 += 1;
            break label1878;
            break;
            if (i1 == 1)
            {
              this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
              this.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject3);
              this.jdField_a_of_type_AndroidWidgetButton.setContentDescription((CharSequence)localObject3);
            }
            else if (i1 == 2)
            {
              this.rightViewText.setVisibility(0);
              this.rightViewText.setText((CharSequence)localObject3);
              this.rightViewText.setContentDescription((CharSequence)localObject3);
              this.rightViewText.setEnabled(true);
            }
          }
          if ((localObject2 != null) && (((List)localObject2).size() == 1))
          {
            this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
            this.jdField_d_of_type_AndroidWidgetTextView.setTextAppearance(this, 2131755085);
            this.jdField_d_of_type_AndroidWidgetTextView.setText(((structmsg.SystemMsgAction)((List)localObject2).get(0)).detail_name.get());
            this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(((structmsg.SystemMsgAction)((List)localObject2).get(0)).detail_name.get());
            this.jdField_d_of_type_AndroidWidgetTextView.setBackgroundResource(2130839347);
            this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
            break;
          }
          if ((this.jdField_d_of_type_AndroidWidgetTextView == null) || (TextUtils.isEmpty(this.jdField_o_of_type_JavaLangString))) {
            break;
          }
          this.jdField_d_of_type_AndroidWidgetTextView.setTextAppearance(getApplicationContext(), 2131755974);
          this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_o_of_type_JavaLangString);
          this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_o_of_type_JavaLangString);
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
          break;
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          break label1457;
          this.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this, 2131755085);
          this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839347);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          break label1457;
          if (this.jdField_b_of_type_Int != 2) {
            break label2285;
          }
          this.jdField_t_of_type_JavaLangString = this.v;
          this.jdField_u_of_type_JavaLangString = "0";
          this.jdField_i_of_type_Int = 2131719619;
          i1 = 1;
          break label1688;
          i1 = -1;
          break label1791;
        }
        i1 = 0;
      }
    }
  }
  
  private void j()
  {
    if (this.jdField_b_of_type_Int == 91)
    {
      k();
      return;
    }
    Object localObject1;
    if (this.jdField_b_of_type_Int == 2)
    {
      localObject1 = (ajia)((ajfn)this.app.getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER)).a(2).a(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg);
      if (localObject1 != null) {
        this.jdField_l_of_type_Int = ((ajia)localObject1).jdField_a_of_type_Int;
      }
    }
    if ((this.jdField_b_of_type_Int == 10) || (this.jdField_b_of_type_Int == 12) || (this.jdField_b_of_type_Int == 2))
    {
      if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.has())
      {
        this.jdField_b_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
        this.jdField_m_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      }
      label132:
      if ((this.jdField_b_of_type_Int != 12) && (this.jdField_b_of_type_Int != 35) && (this.jdField_b_of_type_Int != 10) && (this.jdField_b_of_type_Int != 2)) {
        break label809;
      }
      this.jdField_c_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.get());
      label187:
      if ((this.jdField_b_of_type_Int == 2) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_invite_extinfo.uint32_src_type.has())) {
        localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_qq_nick.get().toStringUtf8();
      }
      switch (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_invite_extinfo.uint32_src_type.get())
      {
      default: 
        label272:
        this.jdField_c_of_type_JavaLangString = ((String)localObject1);
        if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.pic_url.has()) && (!TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.pic_url.get().toStringUtf8()))) {
          this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.pic_url.get().toStringUtf8();
        }
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 83)
        {
          if (!TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_detail.get()))
          {
            this.s.setVisibility(0);
            this.jdField_a_of_type_AndroidTextSpannableStringBuilder = new SpannableStringBuilder(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_detail.get());
          }
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          label413:
          if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.has()) {
            this.jdField_l_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
          }
          if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_time.has()) {
            this.jdField_a_of_type_Long = Long.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_time.get()).longValue();
          }
          if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.has()) {
            this.jdField_h_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
          }
          if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_name.has()) {
            this.jdField_i_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_name.get());
          }
          if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.has()) && (this.jdField_b_of_type_Int != 10)) {
            this.jdField_g_of_type_JavaLangString = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get();
          }
          if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_inviter_role.has()) {
            this.jdField_c_of_type_Int = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_inviter_role.get();
          }
          if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_actor_describe.has())
          {
            localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_actor_describe.get();
            if ((!((String)localObject1).contains("%action_uin%")) || (!this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.has())) {
              break label1107;
            }
            this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.get();
          }
        }
        break;
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.bytes_warning_tips.get() != null) {
        this.jdField_r_of_type_JavaLangString = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.bytes_warning_tips.get().toStringUtf8();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.security_verify", 2, String.format("decodeData reqUin: %s, warningTips: %s", new Object[] { this.jdField_b_of_type_JavaLangString, this.jdField_r_of_type_JavaLangString }));
      return;
      if (!this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.has()) {
        break label132;
      }
      this.jdField_b_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get());
      break label132;
      label809:
      this.jdField_c_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get());
      break label187;
      localObject1 = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.get());
      break label272;
      TroopManager localTroopManager = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
      if (localTroopManager == null) {
        break label272;
      }
      String str1 = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_invite_extinfo.uint64_src_code.get());
      String str2 = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
      localObject1 = localTroopManager.d(str1);
      Object localObject2 = ContactUtils.getTroopNickName(this.app, str2, str1, (String)localObject1, true, null);
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break label272;
      }
      localObject1 = localTroopManager.a(str1, str2);
      break label272;
      localObject2 = (antp)this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER);
      if (localObject2 == null) {
        break label272;
      }
      localObject2 = ((antp)localObject2).a(String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_invite_extinfo.uint64_src_code.get()), String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get()));
      if (localObject2 == null) {
        break label272;
      }
      localObject1 = ((DiscussionMemberInfo)localObject2).getDiscussionMemberName();
      break label272;
      if (!this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.has()) {
        break label413;
      }
      this.s.setVisibility(0);
      localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get();
      if (a((String)localObject1))
      {
        this.jdField_a_of_type_AndroidTextSpannableStringBuilder = a((String)localObject1, true, true);
        this.s.setMovementMethod(LinkMovementMethod.getInstance());
        break label413;
      }
      this.jdField_a_of_type_AndroidTextSpannableStringBuilder = new SpannableStringBuilder((CharSequence)localObject1);
      break label413;
      label1107:
      if ((((String)localObject1).contains("%actor_uin%")) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actor_uin_nick.has()))
      {
        this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actor_uin_nick.get();
        this.v = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actor_uin.get());
      }
      else if ((((String)localObject1).contains("%req_uin%")) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.has()))
      {
        this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get();
      }
    }
  }
  
  private void k()
  {
    Object localObject = (ajhw)((ajfn)this.app.getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER)).a(91).a(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg);
    if (localObject == null) {
      return;
    }
    int i1 = ((ajhw)localObject).jdField_c_of_type_Int;
    String str1 = ((ajhw)localObject).jdField_b_of_type_JavaLangString;
    long l1 = ((ajhw)localObject).jdField_b_of_type_Long;
    int i2 = ((ajhw)localObject).jdField_a_of_type_Int;
    long l2 = ((ajhw)localObject).jdField_d_of_type_Long;
    long l3 = ((ajhw)localObject).jdField_e_of_type_Long;
    String str2 = ((ajhw)localObject).jdField_e_of_type_JavaLangString;
    String str3 = ((ajhw)localObject).jdField_d_of_type_JavaLangString;
    long l4 = ((ajhw)localObject).jdField_c_of_type_Long;
    localObject = ((ajhw)localObject).jdField_c_of_type_JavaLangString;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.jdField_i_of_type_JavaLangString = ((String)localObject);
    }
    for (;;)
    {
      a(i1, i2, String.valueOf(l3));
      a(i1, str1, l1, l2, l3, str2, str3);
      a(i1);
      this.jdField_k_of_type_Int = i1;
      this.jdField_h_of_type_JavaLangString = String.valueOf(l4);
      this.jdField_a_of_type_JavaLangString = this.jdField_h_of_type_JavaLangString;
      this.jdField_a_of_type_Long = (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_seq.get() / 1000000L);
      return;
      if (l4 > 0L) {
        this.jdField_i_of_type_JavaLangString = String.valueOf(l4);
      }
    }
  }
  
  private void l()
  {
    startActivityForResult(AddFriendLogicActivity.a(this, this.jdField_a_of_type_JavaLangString, this.jdField_i_of_type_JavaLangString, this.jdField_a_of_type_Short, 10014, this.jdField_p_of_type_JavaLangString, this.jdField_q_of_type_JavaLangString, null, null, null), 0);
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
      paramBoolean2 = paramString3.equals(getString(2131719149));
      paramString3 = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics(paramString3);
      i1 = (int)(paramString3.density * 17.0F);
      paramString3 = new StringBuilder(paramString1);
      paramString3.insert(localMatcher.end(), " " + paramString2);
      paramString3 = new SpannableStringBuilder(paramString3.toString());
      int i2 = localMatcher.end() + " ".length();
      boolean bool = paramString1.contains(anvx.a(2131715105));
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
          break label290;
        }
      }
      label290:
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
      if (paramString.contains(getString(2131719154)))
      {
        str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get();
        if (TextUtils.isEmpty(str)) {
          break;
        }
        return a(paramString, str, getString(2131719154), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "", paramBoolean1, paramBoolean2);
      }
      if (paramString.contains(getString(2131719142)))
      {
        str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.get();
        if (TextUtils.isEmpty(str)) {
          break;
        }
        return a(paramString, str, getString(2131719142), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get() + "", paramBoolean1, paramBoolean2);
      }
      if (paramString.contains(getString(2131719143)))
      {
        str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actor_uin_nick.get();
        if (TextUtils.isEmpty(str)) {
          break;
        }
        return a(paramString, str, getString(2131719143), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actor_uin.get() + "", paramBoolean1, paramBoolean2);
      }
      if (paramString.contains(getString(2131719149)))
      {
        str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_name.get();
        if (TextUtils.isEmpty(str)) {
          break;
        }
        return a(paramString, str, getString(2131719149), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "", paramBoolean1, paramBoolean2);
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
      str = getString(2131696022);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.systemmsg.TroopRequestActivity", 2, String.format("getTitle msgType:%s subType:%s, srcId:%s, subSrcId:%s, title:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get()), Integer.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get()), Integer.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get()), str }));
      }
      return str;
      str = getString(2131696027);
      continue;
      str = getString(2131696026);
      continue;
      str = getString(2131696029);
      continue;
      str = getString(2131696024);
      continue;
      str = getString(2131696025);
      continue;
      str = getString(2131696033);
      continue;
      str = getString(2131696021);
      continue;
      str = getString(2131696030);
      continue;
      str = getString(2131696031);
      continue;
      str = getString(2131696032);
      continue;
      str = getString(2131696009);
      continue;
      str = getString(2131696028);
      continue;
      str = getString(2131696034);
      continue;
      str = getString(2131696023);
      continue;
      str = getString(2131696020);
    }
  }
  
  public void a()
  {
    j();
    switch (this.jdField_b_of_type_Int)
    {
    }
    for (;;)
    {
      d();
      return;
      b();
      continue;
      c();
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
    return (paramString.contains(getString(2131719154))) || (paramString.contains(getString(2131719143))) || (paramString.contains(getString(2131719149))) || (paramString.contains(getString(2131719142)));
  }
  
  public void b()
  {
    Object localObject = ajfq.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder, this.jdField_b_of_type_JavaLangString, 1);
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
    if ((this.jdField_b_of_type_Int == 10) || (this.jdField_b_of_type_Int == 12)) {
      this.jdField_k_of_type_JavaLangString = (this.jdField_c_of_type_JavaLangString + getString(2131696244));
    }
    for (;;)
    {
      localObject = this.jdField_d_of_type_AndroidViewView$OnClickListener;
      this.jdField_a_of_type_AndroidViewView.setOnClickListener((View.OnClickListener)localObject);
      if ((TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint32_group_flagext3.get())) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 2))
      {
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
        ((ImageView)findViewById(2131379502)).setVisibility(4);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_k_of_type_JavaLangString);
      if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
      }
      try
      {
        if (this.app != null)
        {
          localObject = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
          if (localObject != null) {
            ThreadManager.post(new TroopRequestActivity.2(this, (anvk)localObject), 8, null, true);
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
              this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(new afhj(this));
              this.jdField_a_of_type_ComTencentImageURLImageView.setContentDescription(anvx.a(2131715102));
              if (TextUtils.isEmpty(this.jdField_a_of_type_AndroidTextSpannableStringBuilder)) {
                break label750;
              }
              this.s.setText(this.jdField_a_of_type_AndroidTextSpannableStringBuilder);
              if (this.jdField_b_of_type_Int == 80)
              {
                this.s.setMaxLines(3);
                this.s.setSingleLine(false);
              }
              if (!TextUtils.isEmpty(this.jdField_l_of_type_JavaLangString)) {
                break label762;
              }
              this.jdField_t_of_type_AndroidWidgetTextView.setVisibility(8);
              if (this.jdField_a_of_type_Long != 0L)
              {
                localObject = a(this.jdField_a_of_type_Long * 1000L);
                this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
              }
              if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
                break label784;
              }
              localObject = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_actor_describe.get().split("：");
              if (localObject.length > 0)
              {
                this.jdField_f_of_type_AndroidWidgetTextView.setText(localObject[0]);
                this.jdField_f_of_type_AndroidWidgetTextView.setContentDescription(localObject[0] + this.jdField_f_of_type_JavaLangString);
                this.jdField_f_of_type_AndroidWidgetTextView.setFocusable(true);
              }
              this.jdField_g_of_type_AndroidWidgetTextView.setText(this.jdField_f_of_type_JavaLangString);
              this.jdField_g_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_e_of_type_AndroidViewView$OnClickListener);
              this.jdField_e_of_type_AndroidWidgetLinearLayout.setVisibility(0);
              if ((this.jdField_b_of_type_Int != 1) && (this.jdField_b_of_type_Int != 22) && (this.jdField_b_of_type_Int != 60)) {
                break label796;
              }
              this.jdField_f_of_type_AndroidWidgetLinearLayout.setVisibility(0);
              if ((TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) || (this.jdField_b_of_type_Int == 2)) {
                break label808;
              }
              this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
              this.jdField_h_of_type_AndroidWidgetTextView.setText(this.jdField_g_of_type_JavaLangString);
              if (TextUtils.isEmpty(this.jdField_r_of_type_JavaLangString)) {
                break label820;
              }
              this.jdField_u_of_type_AndroidWidgetTextView.setText(this.jdField_r_of_type_JavaLangString);
              this.jdField_c_of_type_AndroidViewView.setVisibility(0);
              this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_h_of_type_AndroidViewView$OnClickListener);
              if (this.jdField_l_of_type_Int == 0) {
                break label832;
              }
              bdla.b(null, "dc00898", "", "", "0X800B5B0", "0X800B5B0", 0, 0, "", "", "", "");
              this.jdField_r_of_type_AndroidWidgetTextView.setVisibility(0);
              this.jdField_r_of_type_AndroidWidgetTextView.setText(getString(2131699075));
              return;
              this.jdField_k_of_type_JavaLangString = (this.jdField_c_of_type_JavaLangString + getString(2131696245));
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
            label750:
            this.s.setText("");
            continue;
            label762:
            this.jdField_t_of_type_AndroidWidgetTextView.setText(this.jdField_l_of_type_JavaLangString);
            this.jdField_t_of_type_AndroidWidgetTextView.setVisibility(0);
            continue;
            label784:
            this.jdField_e_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            continue;
            label796:
            this.jdField_f_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            continue;
            label808:
            this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            continue;
            label820:
            this.jdField_c_of_type_AndroidViewView.setVisibility(8);
          }
          label832:
          this.jdField_r_of_type_AndroidWidgetTextView.setVisibility(8);
        }
      }
    }
  }
  
  public void c()
  {
    Object localObject = ajfq.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder, this.jdField_h_of_type_JavaLangString, 4);
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
    this.jdField_k_of_type_JavaLangString = (this.jdField_i_of_type_JavaLangString + getString(2131696246));
    if (this.jdField_b_of_type_Int == 8)
    {
      this.jdField_a_of_type_AndroidViewView.setEnabled(false);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_k_of_type_JavaLangString);
      if (!TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString)) {
        break label875;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
      label112:
      localObject = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
      if (localObject == null) {
        break label1226;
      }
    }
    label178:
    label199:
    label584:
    label1226:
    for (localObject = ((TroopManager)localObject).b(String.valueOf(this.jdField_a_of_type_JavaLangString));; localObject = null)
    {
      if ((localObject != null) && (((TroopInfo)localObject).dwGroupClassExt != 0L))
      {
        ThreadManager.post(new TroopRequestActivity.4(this, (TroopInfo)localObject), 8, null, true);
        if (TextUtils.isEmpty(this.jdField_a_of_type_AndroidTextSpannableStringBuilder)) {
          break label910;
        }
        this.s.setText(this.jdField_a_of_type_AndroidTextSpannableStringBuilder);
        if (this.jdField_b_of_type_Int == 80)
        {
          this.s.setMaxLines(3);
          this.s.setSingleLine(false);
        }
        if (!TextUtils.isEmpty(this.jdField_l_of_type_JavaLangString)) {
          break label922;
        }
        this.jdField_t_of_type_AndroidWidgetTextView.setVisibility(8);
        label243:
        if (this.jdField_a_of_type_Long != 0L)
        {
          localObject = a(this.jdField_a_of_type_Long * 1000L);
          this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        }
        if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
          break label981;
        }
        localObject = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_actor_describe.get();
        String[] arrayOfString = ((String)localObject).split("：");
        if (arrayOfString.length > 0)
        {
          this.jdField_f_of_type_AndroidWidgetTextView.setText(arrayOfString[0]);
          this.jdField_f_of_type_AndroidWidgetTextView.setContentDescription(arrayOfString[0] + this.jdField_f_of_type_JavaLangString);
          this.jdField_f_of_type_AndroidWidgetTextView.setFocusable(true);
        }
        this.jdField_g_of_type_AndroidWidgetTextView.setText(this.jdField_f_of_type_JavaLangString);
        if (!((String)localObject).contains(getString(2131719142))) {
          break label952;
        }
        this.jdField_g_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_e_of_type_AndroidViewView$OnClickListener);
        this.jdField_e_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        if (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint32_group_flagext3.get()))
        {
          int i1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get();
          if ((i1 == 7) || (i1 == 11) || (i1 == 3) || (i1 == 16) || (i1 == 15)) {
            this.jdField_g_of_type_AndroidWidgetTextView.setOnClickListener(null);
          }
        }
        label481:
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() != 82) {
          break label1058;
        }
        if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.size() == 0) || (TextUtils.isEmpty(this.jdField_o_of_type_JavaLangString))) {
          break label993;
        }
        this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_i_of_type_AndroidWidgetTextView.setText(this.jdField_o_of_type_JavaLangString);
        localObject = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get();
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label1005;
        }
        this.jdField_j_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_j_of_type_AndroidWidgetTextView.setOnClickListener(new afhl(this));
        bdla.b(this.app, "P_CliOper", "Grp_public", "", "oper", "exp_invite", 0, 0, "", "", "", this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "");
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() != 83) {
          break label1079;
        }
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_pay_group_extinfo.has())
        {
          localObject = (structmsg.MsgPayGroupExt)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_pay_group_extinfo.get();
          long l1 = ((structmsg.MsgPayGroupExt)localObject).uint64_join_grp_time.get();
          long l2 = ((structmsg.MsgPayGroupExt)localObject).uint64_quit_grp_time.get();
          localObject = anvx.a(2131715104) + bhid.a(this, l1 * 1000L, true) + "\n" + anvx.a(2131715103) + bhid.a(this, l2 * 1000L, true);
          this.jdField_k_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_k_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        }
        d();
        if (TextUtils.isEmpty(this.jdField_r_of_type_JavaLangString)) {
          break label1214;
        }
        this.jdField_u_of_type_AndroidWidgetTextView.setText(this.jdField_r_of_type_JavaLangString);
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_h_of_type_AndroidViewView$OnClickListener);
      }
      for (;;)
      {
        this.jdField_r_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
        break;
        label875:
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_i_of_type_JavaLangString);
        break label112;
        if (this.jdField_a_of_type_Aoep == null) {
          break label178;
        }
        this.jdField_a_of_type_Aoep.d(this.jdField_a_of_type_JavaLangString);
        break label178;
        this.s.setText("");
        break label199;
        this.jdField_t_of_type_AndroidWidgetTextView.setText(this.jdField_l_of_type_JavaLangString);
        this.jdField_t_of_type_AndroidWidgetTextView.setSingleLine(true);
        this.jdField_t_of_type_AndroidWidgetTextView.setVisibility(0);
        break label243;
        if (!((String)localObject).contains(getString(2131719154))) {
          break label402;
        }
        this.jdField_g_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
        break label402;
        label981:
        this.jdField_e_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        break label481;
        label993:
        this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(8);
        break label544;
        label1005:
        if (QLog.isColorLevel()) {
          QLog.i(".troop.troop_pubaccount", 2, "mStructMsg.msg.req_uin_nick is empty from StructMsg_IM.proto");
        }
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        bgiv.a(this.app, this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get(), new afhk(this));
        break label584;
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(8);
        break label656;
        if (((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() != 3) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() != 19)) || ((!TextUtils.equals(String.valueOf(90000000L), this.v)) && (!TextUtils.equals(String.valueOf(90000000L), this.jdField_m_of_type_JavaLangString)))) {
          break label807;
        }
        if (!TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_detail.get()))
        {
          this.jdField_k_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_k_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_detail.get());
        }
        this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        this.jdField_g_of_type_AndroidWidgetTextView.setOnClickListener(null);
        break label807;
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      }
    }
  }
  
  public void d()
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
    if (-1 == paramInt2)
    {
      if (paramInt1 != 0) {
        break label21;
      }
      h();
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
    super.setContentView(2131560731);
    setContentBackgroundResource(2130838911);
    this.jdField_a_of_type_Aoep = ((aoep)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER));
    i();
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
      this.jdField_j_of_type_Int = getIntent().getIntExtra("troopfromtab", 0);
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
      this.app.removeObserver(this.jdField_a_of_type_Anyz);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(null);
    }
    super.doOnDestroy();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
  }
  
  public void doOnStart()
  {
    this.app.addObserver(this.jdField_a_of_type_Aofu);
    this.app.addObserver(this.jdField_a_of_type_Anyz);
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.app.addObserver(this.jdField_a_of_type_Anvi);
    this.app.addObserver(this.jdField_a_of_type_Aoec);
    super.doOnStart();
  }
  
  public void doOnStop()
  {
    this.app.removeObserver(this.jdField_a_of_type_Aofu);
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.app.removeObserver(this.jdField_a_of_type_Anvi);
    this.app.removeObserver(this.jdField_a_of_type_Aoec);
    if (this.jdField_b_of_type_Int != 82) {
      this.app.removeObserver(this.jdField_a_of_type_Anyz);
    }
    super.doOnStop();
  }
  
  public void e()
  {
    bkzi localbkzi = (bkzi)bkzz.a(this, null);
    String str = "";
    if (this.jdField_i_of_type_Int != 0) {
      str = getString(this.jdField_i_of_type_Int);
    }
    localbkzi.a(str);
    localbkzi.a(getString(2131718817), 3);
    localbkzi.a(new afho(this, localbkzi));
    localbkzi.c(2131690697);
    localbkzi.show();
  }
  
  public void f()
  {
    bkzi localbkzi = (bkzi)bkzz.a(this, null);
    localbkzi.a(getString(2131690717), 3);
    localbkzi.a(new afgt(this, localbkzi));
    localbkzi.c(2131690697);
    localbkzi.show();
  }
  
  public void g()
  {
    try
    {
      if (this.jdField_a_of_type_Bisl == null)
      {
        this.jdField_a_of_type_Bisl = new bisl(getActivity(), getTitleBarHeight());
        this.jdField_a_of_type_Bisl.c(2131694477);
        this.jdField_a_of_type_Bisl.c(false);
      }
      this.jdField_a_of_type_Bisl.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.systemmsg.TroopRequestActivity", 2, localException.toString());
    }
  }
  
  public void h()
  {
    try
    {
      if ((this.jdField_a_of_type_Bisl != null) && (this.jdField_a_of_type_Bisl.isShowing())) {
        this.jdField_a_of_type_Bisl.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.systemmsg.TroopRequestActivity", 2, localException.toString());
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    paramString = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get();
    paramBitmap = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get();
    if (paramString != null)
    {
      this.s.setVisibility(0);
      if (a(paramBitmap))
      {
        paramString = a(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get(), true, true);
        this.s.setMovementMethod(LinkMovementMethod.getInstance());
      }
      if (!TextUtils.isEmpty(paramString)) {
        this.s.setText(paramString);
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
      this.s.setText("");
      break;
      label136:
      if (!TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get())) {
        new StringBuilder().append(getResources().getString(2131719150)).append(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get()).toString();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRequestActivity
 * JD-Core Version:    0.7.0.1
 */