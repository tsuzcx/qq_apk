package com.tencent.mobileqq.activity;

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
import com.tencent.av.utils.BitmapTools;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.contact.troop.TroopNotificationManager;
import com.tencent.mobileqq.activity.contact.troop.TroopNotificationUtils;
import com.tencent.mobileqq.activity.contact.troop.TroopNotificationUtils.TroopPrivilegeCallback;
import com.tencent.mobileqq.activity.contact.troop.generalgroupnotifyparser.AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo;
import com.tencent.mobileqq.activity.contact.troop.generalgroupnotifyparser.GeneralGroupNotifyParser;
import com.tencent.mobileqq.activity.contact.troop.generalgroupnotifyparser.InviteJoinGroupSecFrontParser.InviteJoinGroupSecFrontInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.StrangerObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
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
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.handler.TroopInfoHandler;
import com.tencent.mobileqq.troop.utils.TroopBindPubAccountProtocol;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.QQSettingUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
  implements AppConstants, DecodeTaskCompletionListener
{
  public static int a;
  protected static long b;
  public static final boolean b;
  protected static long c;
  public static int d;
  public static final int e;
  public static final int f;
  public static final int g;
  public static final int h;
  protected long a;
  Handler jdField_a_of_type_AndroidOsHandler = new TroopRequestActivity.11(this);
  protected SpannableStringBuilder a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new TroopRequestActivity.7(this);
  protected View a;
  protected Button a;
  protected ImageView a;
  protected LinearLayout a;
  protected TextView a;
  protected URLImageView a;
  TroopNotificationUtils.TroopPrivilegeCallback jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotificationUtils$TroopPrivilegeCallback = new TroopRequestActivity.25(this);
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new TroopRequestActivity.16(this);
  protected MessageObserver a;
  StrangerObserver jdField_a_of_type_ComTencentMobileqqAppStrangerObserver = new TroopRequestActivity.22(this);
  protected TroopBusinessObserver a;
  protected TroopHandler a;
  protected IFaceDecoder a;
  ProfileCardObserver jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver = new TroopRequestActivity.15(this);
  protected TroopObserver a;
  protected AnimationTextView a;
  protected QQProgressDialog a;
  protected String a;
  protected structmsg.StructMsg a;
  protected short a;
  protected boolean a;
  private LinearLayout[] jdField_a_of_type_ArrayOfAndroidWidgetLinearLayout = new LinearLayout[jdField_d_of_type_Int];
  private RelativeLayout[] jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout = new RelativeLayout[jdField_d_of_type_Int - 1];
  protected int b;
  View.OnClickListener b;
  protected View b;
  protected Button b;
  protected ImageView b;
  protected LinearLayout b;
  protected TextView b;
  protected String b;
  protected int c;
  View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new TroopRequestActivity.17(this);
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  protected LinearLayout c;
  protected TextView c;
  protected String c;
  protected boolean c;
  View.OnClickListener jdField_d_of_type_AndroidViewView$OnClickListener = new TroopRequestActivity.18(this);
  private LinearLayout jdField_d_of_type_AndroidWidgetLinearLayout;
  protected TextView d;
  protected String d;
  protected boolean d;
  View.OnClickListener jdField_e_of_type_AndroidViewView$OnClickListener = new TroopRequestActivity.19(this);
  private LinearLayout jdField_e_of_type_AndroidWidgetLinearLayout;
  protected TextView e;
  protected String e;
  View.OnClickListener jdField_f_of_type_AndroidViewView$OnClickListener = new TroopRequestActivity.20(this);
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
  int j;
  protected TextView j;
  protected String j;
  int k;
  protected TextView k;
  protected String k;
  int l;
  protected TextView l;
  protected String l;
  protected TextView m;
  protected String m;
  protected TextView n;
  protected String n;
  TextView o;
  protected String o;
  TextView p;
  protected String p;
  TextView q;
  protected String q;
  protected TextView r;
  protected String r;
  private TextView s;
  protected String s;
  private TextView t;
  protected String t;
  private TextView u;
  protected String u;
  private String v;
  
  static
  {
    jdField_a_of_type_Int = 10;
    jdField_d_of_type_Int = 0;
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
    jdField_b_of_type_Long = 0L;
    jdField_c_of_type_Long = 0L;
  }
  
  public TroopRequestActivity()
  {
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = null;
    this.jdField_s_of_type_JavaLangString = null;
    this.jdField_t_of_type_JavaLangString = "";
    this.jdField_u_of_type_JavaLangString = "";
    this.jdField_i_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = null;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_j_of_type_Int = 0;
    this.jdField_k_of_type_Int = 0;
    this.jdField_l_of_type_Int = 0;
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new TroopRequestActivity.8(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver = new TroopRequestActivity.12(this);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver = new TroopRequestActivity.13(this);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new TroopRequestActivity.14(this);
    this.jdField_g_of_type_AndroidViewView$OnClickListener = new TroopRequestActivity.21(this);
    this.jdField_h_of_type_AndroidViewView$OnClickListener = new TroopRequestActivity.26(this);
  }
  
  public static String a(long paramLong)
  {
    Time localTime1 = new Time();
    localTime1.set(paramLong);
    long l1 = System.currentTimeMillis();
    Time localTime2 = new Time();
    localTime2.set(l1);
    if (localTime1.year == localTime2.year) {
      return TimeFormatterUtils.a(paramLong, true, "MM-dd");
    }
    return TimeFormatterUtils.a(paramLong, true, "yyyy-MM-dd");
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 1)
    {
      paramInt = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
      if (paramInt != 2) {
        break label35;
      }
      this.jdField_o_of_type_JavaLangString = getString(2131699411);
    }
    label35:
    do
    {
      return;
      if (paramInt == 3)
      {
        this.jdField_o_of_type_JavaLangString = getString(2131699420);
        return;
      }
    } while (paramInt != 4);
    this.jdField_o_of_type_JavaLangString = getString(2131699414);
  }
  
  private void a(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 1)
    {
      this.jdField_a_of_type_AndroidTextSpannableStringBuilder = new SpannableStringBuilder(getString(2131699419) + " " + getString(2131699417));
      localForegroundColorSpan = new ForegroundColorSpan(Color.parseColor("#00CAFC"));
      this.jdField_a_of_type_AndroidTextSpannableStringBuilder.setSpan(localForegroundColorSpan, 5, this.jdField_a_of_type_AndroidTextSpannableStringBuilder.length(), 33);
      this.jdField_a_of_type_AndroidTextSpannableStringBuilder.setSpan(new TroopRequestActivity.1(this, paramString), 5, this.jdField_a_of_type_AndroidTextSpannableStringBuilder.length(), 33);
      this.jdField_s_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }
    while (paramInt1 != 2)
    {
      ForegroundColorSpan localForegroundColorSpan;
      return;
    }
    paramString = "";
    if (paramInt2 == 2) {
      paramString = getString(2131699426);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidTextSpannableStringBuilder = new SpannableStringBuilder(paramString + getString(2131699416));
      return;
      if (paramInt2 == 3) {
        paramString = getString(2131699428);
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
        this.jdField_l_of_type_JavaLangString = (getString(2131699418) + " " + paramString3 + getString(2131699415) + paramString1);
      }
      for (;;)
      {
        return;
        if (paramLong2 <= 0L) {
          break label167;
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
      label167:
      paramString3 = "";
    }
  }
  
  private void a(long paramLong, structmsg.StructMsg paramStructMsg)
  {
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("structMsg", paramStructMsg.toByteArray());
    TroopBindPubAccountProtocol.a(this.app, paramLong, new TroopRequestActivity.23(this), localBundle);
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, structmsg.StructMsg paramStructMsg, TroopNotificationUtils.TroopPrivilegeCallback paramTroopPrivilegeCallback)
  {
    if ((paramQQAppInterface == null) || (paramTroopPrivilegeCallback == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    TroopNotificationUtils.a(paramString, paramStructMsg);
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
    ProtoUtils.a(paramQQAppInterface, new TroopRequestActivity.24(paramString, paramContext, paramTroopPrivilegeCallback, paramStructMsg), ((oidb_sso.OIDBSSOPkg)localObject1).toByteArray(), "OidbSvc.0x88d_0");
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
      localObject1 = getString(2131693923);
      this.jdField_o_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      if (paramCard.age <= 0) {
        break label579;
      }
      localObject1 = paramCard.age + getString(2131719672);
      this.jdField_p_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      this.jdField_p_of_type_AndroidWidgetTextView.setContentDescription((CharSequence)localObject1);
      this.jdField_p_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject2 = "";
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramCard.strCountry))
      {
        localObject1 = localObject2;
        if (!paramCard.strCountry.equals(getString(2131716897))) {
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
      TextView localTextView = (TextView)this.jdField_f_of_type_AndroidWidgetLinearLayout.findViewById(2131376967);
      if (QLog.isColorLevel()) {
        QLog.d("Q.systemmsg.TroopRequestActivity", 2, "updateLevelAndVip bSuperVipOpen=" + bool1 + ",bQQVipOpen=" + bool2 + ",VipLevel=" + i1 + ",QQLevel=" + paramCard.iQQLevel);
      }
      if ((bool1) || (bool2)) {
        ((SpannableStringBuilder)localObject1).append(QQSettingUtil.a(localTextView, (Resources)localObject2, bool1, bool2, Math.max(i1, 1)));
      }
      if (paramCard.iQQLevel >= 0) {
        ((SpannableStringBuilder)localObject1).append(ProfileCardUtil.a(this, 15, paramCard.mQQLevelType, paramCard.iQQLevel, false));
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView.setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
      this.jdField_f_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      return;
      if (paramCard.shGender == 1)
      {
        localObject1 = getString(2131692330);
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
    Object localObject = GroupSystemMsgController.a().b();
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = GroupSystemMsgController.a().a((String)localObject);
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
    Object localObject = GroupSystemMsgController.a().b();
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = GroupSystemMsgController.a().a((String)localObject);
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
    Object localObject1 = GroupSystemMsgController.a().b();
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = GroupSystemMsgController.a().a((String)localObject1);
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
    localObject1 = (LinearLayout)findViewById(2131379943);
    ((LinearLayout)localObject1).setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.app);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get();
    this.jdField_a_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
    this.v = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
    this.jdField_m_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get());
    this.jdField_n_of_type_JavaLangString = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get();
    label309:
    Object localObject2;
    label611:
    int i2;
    if (this.jdField_n_of_type_JavaLangString.startsWith(getString(2131719696)))
    {
      this.jdField_n_of_type_JavaLangString = this.jdField_n_of_type_JavaLangString.replace(getString(2131719696), "");
      setLeftViewName(2131691181);
      setTitle(a(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get()));
      this.jdField_a_of_type_AndroidViewView = findViewById(2131379934);
      this.jdField_b_of_type_AndroidViewView = ((LinearLayout)findViewById(2131379935));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379930));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131379939));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379942));
      this.jdField_o_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379940));
      this.jdField_p_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379937));
      this.jdField_q_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379938));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379927));
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131379936));
      this.jdField_s_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379933));
      this.jdField_t_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379929));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131362351));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131376861));
      this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131379932));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379928));
      this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_g_of_type_AndroidViewView$OnClickListener);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131379925));
      localObject2 = BitmapTools.b(BaseApplication.getContext(), 2130839414);
      if (localObject2 == null) {
        break label875;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
      this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131379926));
      this.jdField_e_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131376960));
      this.jdField_f_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131376966));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131376958));
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131376963));
      localObject2 = (TextView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131376965);
      if (localObject2 != null) {
        ((TextView)localObject2).setText(((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.app, getApplicationContext()));
      }
      this.jdField_a_of_type_ArrayOfAndroidWidgetLinearLayout[jdField_e_of_type_Int] = this.jdField_e_of_type_AndroidWidgetLinearLayout;
      this.jdField_a_of_type_ArrayOfAndroidWidgetLinearLayout[jdField_f_of_type_Int] = this.jdField_f_of_type_AndroidWidgetLinearLayout;
      this.jdField_a_of_type_ArrayOfAndroidWidgetLinearLayout[jdField_g_of_type_Int] = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      this.jdField_a_of_type_ArrayOfAndroidWidgetLinearLayout[jdField_h_of_type_Int] = this.jdField_b_of_type_AndroidWidgetLinearLayout;
      int i3 = this.jdField_d_of_type_AndroidWidgetLinearLayout.getChildCount();
      i2 = 0;
      i1 = 0;
      label788:
      if (i2 >= i3) {
        break label888;
      }
      if (!(this.jdField_d_of_type_AndroidWidgetLinearLayout.getChildAt(i2) instanceof RelativeLayout)) {
        break label2315;
      }
      this.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i1] = ((RelativeLayout)this.jdField_d_of_type_AndroidWidgetLinearLayout.getChildAt(i2));
      i1 += 1;
    }
    label2305:
    label2310:
    label2315:
    for (;;)
    {
      i2 += 1;
      break label788;
      if (!this.jdField_n_of_type_JavaLangString.startsWith(getString(2131719684))) {
        break label309;
      }
      this.jdField_n_of_type_JavaLangString = this.jdField_n_of_type_JavaLangString.replace(getString(2131719684), "");
      break label309;
      label875:
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130839414);
      break label611;
      label888:
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376962));
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376961));
      this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376964));
      this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView = ((AnimationTextView)findViewById(2131376967));
      this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376959));
      this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373652));
      this.jdField_k_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365712));
      this.jdField_o_of_type_JavaLangString = getIntent().getExtras().getString("troopMsgDealInfo");
      this.jdField_c_of_type_AndroidViewView = findViewById(2131381795);
      this.jdField_u_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131381796));
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364843));
      this.jdField_r_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379931));
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
          this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379924));
          if (TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_info.msg_alert.get())) {
            break label2232;
          }
          this.jdField_b_of_type_AndroidWidgetButton.setTextAppearance(this, 2131755090);
          this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130839441);
          if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() != 1) || ((this.jdField_b_of_type_Int != 1) && (this.jdField_b_of_type_Int != 22))) {
            break label2220;
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_info.msg_alert.get());
          this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_info.msg_alert.get());
          label1482:
          if ((localObject2 != null) && (((List)localObject2).size() == 1)) {
            this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_f_of_type_AndroidViewView$OnClickListener);
          }
          this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_f_of_type_AndroidViewView$OnClickListener);
          this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_f_of_type_AndroidViewView$OnClickListener);
          this.rightViewText.setOnClickListener(this.jdField_f_of_type_AndroidViewView$OnClickListener);
          this.jdField_n_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131361931));
          this.jdField_m_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131361930));
          this.jdField_l_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378018));
          this.jdField_n_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
          this.jdField_l_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          super.getString(2131719343);
          super.getString(2131689513);
          this.jdField_n_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_m_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_l_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_t_of_type_JavaLangString = "";
          if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() != 1) {
            break label2310;
          }
          if ((this.jdField_b_of_type_Int != 1) && (this.jdField_b_of_type_Int != 22)) {
            break label2265;
          }
          this.jdField_t_of_type_JavaLangString = this.jdField_m_of_type_JavaLangString;
          this.jdField_u_of_type_JavaLangString = "1";
          this.jdField_i_of_type_Int = 2131719102;
          i1 = 1;
        }
      }
      for (;;)
      {
        label1713:
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
          label1816:
          if ((!this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.has()) || (!this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.has())) {
            break label2305;
          }
        }
        for (i2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get();; i2 = -1)
        {
          QLog.i("Q.systemmsg.TroopRequestActivity", 2, String.format("joinGroup subSourceID=%d sourceID=%d msgType=%d", new Object[] { Integer.valueOf(i2), Integer.valueOf(i1), Integer.valueOf(this.jdField_b_of_type_Int) }));
          return;
          i1 = 0;
          label1903:
          if (i1 < ((List)localObject2).size())
          {
            localObject3 = ((structmsg.SystemMsgAction)((List)localObject2).get(i1)).detail_name.get();
            if (i1 != 0) {
              break label1976;
            }
            this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
            this.jdField_b_of_type_AndroidWidgetButton.setText((CharSequence)localObject3);
            this.jdField_b_of_type_AndroidWidgetButton.setContentDescription((CharSequence)localObject3);
          }
          for (;;)
          {
            ((LinearLayout)localObject1).setVisibility(0);
            i1 += 1;
            break label1903;
            break;
            label1976:
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
            this.jdField_d_of_type_AndroidWidgetTextView.setTextAppearance(this, 2131755087);
            this.jdField_d_of_type_AndroidWidgetTextView.setText(((structmsg.SystemMsgAction)((List)localObject2).get(0)).detail_name.get());
            this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(((structmsg.SystemMsgAction)((List)localObject2).get(0)).detail_name.get());
            this.jdField_d_of_type_AndroidWidgetTextView.setBackgroundResource(2130839424);
            this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
            break;
          }
          if ((this.jdField_d_of_type_AndroidWidgetTextView == null) || (TextUtils.isEmpty(this.jdField_o_of_type_JavaLangString))) {
            break;
          }
          this.jdField_d_of_type_AndroidWidgetTextView.setTextAppearance(getApplicationContext(), 2131755988);
          this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_o_of_type_JavaLangString);
          this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_o_of_type_JavaLangString);
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
          break;
          label2220:
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          break label1482;
          label2232:
          this.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this, 2131755087);
          this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839424);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          break label1482;
          label2265:
          if (this.jdField_b_of_type_Int != 2) {
            break label2310;
          }
          this.jdField_t_of_type_JavaLangString = this.v;
          this.jdField_u_of_type_JavaLangString = "0";
          this.jdField_i_of_type_Int = 2131720197;
          i1 = 1;
          break label1713;
          i1 = -1;
          break label1816;
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
      localObject1 = (InviteJoinGroupSecFrontParser.InviteJoinGroupSecFrontInfo)((TroopNotificationManager)this.app.getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER)).a(2).a(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg);
      if (localObject1 != null) {
        this.jdField_l_of_type_Int = ((InviteJoinGroupSecFrontParser.InviteJoinGroupSecFrontInfo)localObject1).jdField_a_of_type_Int;
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
            this.jdField_s_of_type_AndroidWidgetTextView.setVisibility(0);
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
      Object localObject2 = ContactUtils.a(this.app, str2, str1, (String)localObject1, true, null);
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break label272;
      }
      localObject1 = localTroopManager.a(str1, str2);
      break label272;
      localObject2 = (DiscussionManager)this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER);
      if (localObject2 == null) {
        break label272;
      }
      localObject2 = ((DiscussionManager)localObject2).a(String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_invite_extinfo.uint64_src_code.get()), String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get()));
      if (localObject2 == null) {
        break label272;
      }
      localObject1 = ((DiscussionMemberInfo)localObject2).getDiscussionMemberName();
      break label272;
      if (!this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.has()) {
        break label413;
      }
      this.jdField_s_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get();
      if (a((String)localObject1))
      {
        this.jdField_a_of_type_AndroidTextSpannableStringBuilder = a((String)localObject1, true, true);
        this.jdField_s_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
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
    Object localObject = (AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)((TroopNotificationManager)this.app.getManager(QQManagerFactory.TROOP_NOTIFICATION_MANAGER)).a(91).a(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg);
    if (localObject == null) {
      return;
    }
    int i1 = ((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject).jdField_c_of_type_Int;
    String str1 = ((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject).jdField_b_of_type_JavaLangString;
    long l1 = ((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject).jdField_b_of_type_Long;
    int i2 = ((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject).jdField_a_of_type_Int;
    long l2 = ((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject).jdField_d_of_type_Long;
    long l3 = ((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject).jdField_e_of_type_Long;
    String str2 = ((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject).jdField_e_of_type_JavaLangString;
    String str3 = ((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject).jdField_d_of_type_JavaLangString;
    long l4 = ((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject).jdField_c_of_type_Long;
    localObject = ((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject).jdField_c_of_type_JavaLangString;
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
      paramBoolean2 = paramString3.equals(getString(2131719691));
      paramString3 = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics(paramString3);
      i1 = (int)(paramString3.density * 17.0F);
      paramString3 = new StringBuilder(paramString1);
      paramString3.insert(localMatcher.end(), " " + paramString2);
      paramString3 = new SpannableStringBuilder(paramString3.toString());
      int i2 = localMatcher.end() + " ".length();
      boolean bool = paramString1.contains(HardCodeUtil.a(2131715599));
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
      if (paramString.contains(getString(2131719696)))
      {
        str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get();
        if (TextUtils.isEmpty(str)) {
          break;
        }
        return a(paramString, str, getString(2131719696), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "", paramBoolean1, paramBoolean2);
      }
      if (paramString.contains(getString(2131719684)))
      {
        str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.get();
        if (TextUtils.isEmpty(str)) {
          break;
        }
        return a(paramString, str, getString(2131719684), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get() + "", paramBoolean1, paramBoolean2);
      }
      if (paramString.contains(getString(2131719685)))
      {
        str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actor_uin_nick.get();
        if (TextUtils.isEmpty(str)) {
          break;
        }
        return a(paramString, str, getString(2131719685), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actor_uin.get() + "", paramBoolean1, paramBoolean2);
      }
      if (paramString.contains(getString(2131719691)))
      {
        str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_name.get();
        if (TextUtils.isEmpty(str)) {
          break;
        }
        return a(paramString, str, getString(2131719691), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "", paramBoolean1, paramBoolean2);
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
      str = getString(2131696270);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.systemmsg.TroopRequestActivity", 2, String.format("getTitle msgType:%s subType:%s, srcId:%s, subSrcId:%s, title:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get()), Integer.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get()), Integer.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get()), str }));
      }
      return str;
      str = getString(2131696275);
      continue;
      str = getString(2131696274);
      continue;
      str = getString(2131696277);
      continue;
      str = getString(2131696272);
      continue;
      str = getString(2131696273);
      continue;
      str = getString(2131696281);
      continue;
      str = getString(2131696269);
      continue;
      str = getString(2131696278);
      continue;
      str = getString(2131696279);
      continue;
      str = getString(2131696280);
      continue;
      str = getString(2131696257);
      continue;
      str = getString(2131696276);
      continue;
      str = getString(2131696282);
      continue;
      str = getString(2131696271);
      continue;
      str = getString(2131696268);
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
  
  void a(int paramInt, String paramString)
  {
    if (!isResume()) {
      return;
    }
    QQToast.a(this, paramString, 0).b(getTitleBarHeight());
    finish();
  }
  
  void a(boolean paramBoolean)
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
    return (paramString.contains(getString(2131719696))) || (paramString.contains(getString(2131719685))) || (paramString.contains(getString(2131719691))) || (paramString.contains(getString(2131719684)));
  }
  
  public void b()
  {
    Object localObject = TroopNotificationUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, this.jdField_b_of_type_JavaLangString, 1);
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
    if ((this.jdField_b_of_type_Int == 10) || (this.jdField_b_of_type_Int == 12)) {
      this.jdField_k_of_type_JavaLangString = (this.jdField_c_of_type_JavaLangString + getString(2131696497));
    }
    for (;;)
    {
      localObject = this.jdField_d_of_type_AndroidViewView$OnClickListener;
      this.jdField_a_of_type_AndroidViewView.setOnClickListener((View.OnClickListener)localObject);
      if ((TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint32_group_flagext3.get())) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 2))
      {
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
        ((ImageView)findViewById(2131379925)).setVisibility(4);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_k_of_type_JavaLangString);
      if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
      }
      try
      {
        if (this.app != null)
        {
          localObject = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
          if (localObject != null) {
            ThreadManager.post(new TroopRequestActivity.2(this, (FriendsManager)localObject), 8, null, true);
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
              this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(new TroopRequestActivity.3(this));
              this.jdField_a_of_type_ComTencentImageURLImageView.setContentDescription(HardCodeUtil.a(2131715596));
              if (TextUtils.isEmpty(this.jdField_a_of_type_AndroidTextSpannableStringBuilder)) {
                break label750;
              }
              this.jdField_s_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidTextSpannableStringBuilder);
              if (this.jdField_b_of_type_Int == 80)
              {
                this.jdField_s_of_type_AndroidWidgetTextView.setMaxLines(3);
                this.jdField_s_of_type_AndroidWidgetTextView.setSingleLine(false);
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
              ReportController.b(null, "dc00898", "", "", "0X800B5B0", "0X800B5B0", 0, 0, "", "", "", "");
              this.jdField_r_of_type_AndroidWidgetTextView.setVisibility(0);
              this.jdField_r_of_type_AndroidWidgetTextView.setText(getString(2131699444));
              return;
              this.jdField_k_of_type_JavaLangString = (this.jdField_c_of_type_JavaLangString + getString(2131696498));
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
            this.jdField_s_of_type_AndroidWidgetTextView.setText("");
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
    Object localObject = TroopNotificationUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, this.jdField_h_of_type_JavaLangString, 4);
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
    this.jdField_k_of_type_JavaLangString = (this.jdField_i_of_type_JavaLangString + getString(2131696499));
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
        break label1237;
      }
    }
    label178:
    label199:
    label584:
    label1225:
    label1237:
    for (localObject = ((TroopManager)localObject).b(String.valueOf(this.jdField_a_of_type_JavaLangString));; localObject = null)
    {
      if ((localObject != null) && (((TroopInfo)localObject).dwGroupClassExt != 0L))
      {
        ThreadManager.post(new TroopRequestActivity.4(this, (TroopInfo)localObject), 8, null, true);
        if (TextUtils.isEmpty(this.jdField_a_of_type_AndroidTextSpannableStringBuilder)) {
          break label921;
        }
        this.jdField_s_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidTextSpannableStringBuilder);
        if (this.jdField_b_of_type_Int == 80)
        {
          this.jdField_s_of_type_AndroidWidgetTextView.setMaxLines(3);
          this.jdField_s_of_type_AndroidWidgetTextView.setSingleLine(false);
        }
        if (!TextUtils.isEmpty(this.jdField_l_of_type_JavaLangString)) {
          break label933;
        }
        this.jdField_t_of_type_AndroidWidgetTextView.setVisibility(8);
        label243:
        if (this.jdField_a_of_type_Long != 0L)
        {
          localObject = a(this.jdField_a_of_type_Long * 1000L);
          this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        }
        if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
          break label992;
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
        if (!((String)localObject).contains(getString(2131719684))) {
          break label963;
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
          break label1069;
        }
        if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.size() == 0) || (TextUtils.isEmpty(this.jdField_o_of_type_JavaLangString))) {
          break label1004;
        }
        this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_i_of_type_AndroidWidgetTextView.setText(this.jdField_o_of_type_JavaLangString);
        localObject = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get();
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label1016;
        }
        this.jdField_j_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_j_of_type_AndroidWidgetTextView.setOnClickListener(new TroopRequestActivity.6(this));
        ReportController.b(this.app, "P_CliOper", "Grp_public", "", "oper", "exp_invite", 0, 0, "", "", "", this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "");
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() != 83) {
          break label1090;
        }
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_pay_group_extinfo.has())
        {
          localObject = (structmsg.MsgPayGroupExt)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_pay_group_extinfo.get();
          long l1 = ((structmsg.MsgPayGroupExt)localObject).uint64_join_grp_time.get();
          long l2 = ((structmsg.MsgPayGroupExt)localObject).uint64_quit_grp_time.get();
          localObject = HardCodeUtil.a(2131715598) + TimeFormatterUtils.a(this, l1 * 1000L, true) + "\n" + HardCodeUtil.a(2131715597) + TimeFormatterUtils.a(this, l2 * 1000L, true);
          this.jdField_k_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_k_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        }
        d();
        if (TextUtils.isEmpty(this.jdField_r_of_type_JavaLangString)) {
          break label1225;
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
        localObject = (TroopInfoHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_INFO_HANDLER);
        if (localObject == null) {
          break label178;
        }
        ((TroopInfoHandler)localObject).c(this.jdField_a_of_type_JavaLangString);
        break label178;
        this.jdField_s_of_type_AndroidWidgetTextView.setText("");
        break label199;
        this.jdField_t_of_type_AndroidWidgetTextView.setText(this.jdField_l_of_type_JavaLangString);
        this.jdField_t_of_type_AndroidWidgetTextView.setSingleLine(true);
        this.jdField_t_of_type_AndroidWidgetTextView.setVisibility(0);
        break label243;
        if (!((String)localObject).contains(getString(2131719696))) {
          break label402;
        }
        this.jdField_g_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
        break label402;
        label992:
        this.jdField_e_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        break label481;
        label1004:
        this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(8);
        break label544;
        label1016:
        if (QLog.isColorLevel()) {
          QLog.i(".troop.troop_pubaccount", 2, "mStructMsg.msg.req_uin_nick is empty from StructMsg_IM.proto");
        }
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        TroopBindPubAccountProtocol.a(this.app, this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get(), new TroopRequestActivity.5(this));
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
    super.setContentView(2131560821);
    setContentBackgroundResource(2130838979);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopHandler = ((TroopHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER));
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
      this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(null);
    }
    super.doOnDestroy();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
  }
  
  public void doOnStart()
  {
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppStrangerObserver);
    super.doOnStart();
  }
  
  public void doOnStop()
  {
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppStrangerObserver);
    if (this.jdField_b_of_type_Int != 82) {
      this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    }
    super.doOnStop();
  }
  
  void e()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    String str = "";
    if (this.jdField_i_of_type_Int != 0) {
      str = getString(this.jdField_i_of_type_Int);
    }
    localActionSheet.setMainTitle(str);
    localActionSheet.addButton(getString(2131719342), 3);
    localActionSheet.setOnButtonClickListener(new TroopRequestActivity.9(this, localActionSheet));
    localActionSheet.addCancelButton(2131690800);
    localActionSheet.show();
  }
  
  void f()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.addButton(getString(2131690821), 3);
    localActionSheet.setOnButtonClickListener(new TroopRequestActivity.10(this, localActionSheet));
    localActionSheet.addCancelButton(2131690800);
    localActionSheet.show();
  }
  
  public void g()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getActivity(), getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131694694);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(false);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
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
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
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
      this.jdField_s_of_type_AndroidWidgetTextView.setVisibility(0);
      if (a(paramBitmap))
      {
        paramString = a(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get(), true, true);
        this.jdField_s_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
      }
      if (!TextUtils.isEmpty(paramString)) {
        this.jdField_s_of_type_AndroidWidgetTextView.setText(paramString);
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
      this.jdField_s_of_type_AndroidWidgetTextView.setText("");
      break;
      label136:
      if (!TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get())) {
        new StringBuilder().append(getResources().getString(2131719692)).append(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get()).toString();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRequestActivity
 * JD-Core Version:    0.7.0.1
 */