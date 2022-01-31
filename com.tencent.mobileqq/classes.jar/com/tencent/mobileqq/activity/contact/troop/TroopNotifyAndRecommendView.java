package com.tencent.mobileqq.activity.contact.troop;

import abta;
import ahld;
import ahoe;
import ahok;
import ahot;
import ahpp;
import ahpq;
import ahpr;
import ahps;
import ahpt;
import ahpu;
import ahpv;
import ahpw;
import ahpx;
import ahpy;
import ahpz;
import ahql;
import alof;
import alrk;
import alto;
import alud;
import alwx;
import ambh;
import ameq;
import amlp;
import ampt;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import auao;
import auga;
import ayzl;
import azqs;
import bafj;
import bbpf;
import bcmi;
import bcpx;
import bcwe;
import bdbk;
import bdes;
import bdgc;
import bdhj;
import bdin;
import bety;
import bhtv;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.Stranger;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.SwipListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.os.MqqHandler;
import tencent.mobileim.structmsg.structmsg.GroupInfo;
import tencent.mobileim.structmsg.structmsg.MsgInviteExt;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class TroopNotifyAndRecommendView
  extends BaseTroopView
  implements ahld, View.OnClickListener, bhtv, Observer
{
  protected static long c;
  public final long a;
  public ahot a;
  public ahpq a;
  alwx jdField_a_of_type_Alwx = new ahpv(this);
  public ambh a;
  ameq jdField_a_of_type_Ameq = new ahps(this);
  protected ampt a;
  public Context a;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  protected View.OnClickListener a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private auga jdField_a_of_type_Auga;
  public bety a;
  SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  public List<MessageRecord> a;
  public MqqHandler a;
  protected int b;
  public final long b;
  protected View.OnClickListener b;
  protected int c;
  protected boolean c;
  private int d;
  protected boolean d;
  private int e;
  protected View e;
  protected boolean e;
  private View f;
  protected boolean f;
  private View g;
  protected boolean g;
  protected boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  
  public TroopNotifyAndRecommendView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Long = 1000L;
    this.jdField_b_of_type_Long = 500L;
    this.jdField_a_of_type_MqqOsMqqHandler = new ahpt(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ahpu(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new ahpx(this);
    this.jdField_a_of_type_Ahpq = new ahpz(this);
    this.jdField_f_of_type_Boolean = true;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public static long a(List<MessageRecord> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = (MessageRecord)paramList.get(0);
      if ((paramList instanceof MessageForSystemMsg))
      {
        paramList = ((MessageForSystemMsg)paramList).getSystemMsg();
        if ((paramList != null) && (paramList.msg_seq.has()))
        {
          long l = paramList.msg_seq.get();
          if (l > 0L) {
            return l;
          }
        }
      }
    }
    return 0L;
  }
  
  public static List<MessageRecord> a(List<MessageRecord> paramList1, List<MessageRecord> paramList2)
  {
    if ((paramList1 == null) || (paramList2 == null)) {
      return paramList1;
    }
    if (a(paramList1) >= a(paramList2))
    {
      paramList1.addAll(paramList2);
      return paramList1;
    }
    paramList2.addAll(paramList1);
    return paramList2;
  }
  
  private void a(long paramLong, structmsg.StructMsg paramStructMsg)
  {
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("structMsg", paramStructMsg.toByteArray());
    bcmi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong, new ahpy(this), localBundle);
  }
  
  private void a(ahok paramahok, structmsg.StructMsg paramStructMsg)
  {
    if ((paramahok == null) || (paramStructMsg == null)) {
      return;
    }
    if ((paramahok.jdField_a_of_type_Int == 2) && (paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.has()))
    {
      String str1 = paramStructMsg.msg.action_uin_qq_nick.get().toStringUtf8();
      switch (paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.get())
      {
      default: 
        paramStructMsg = str1;
      }
      for (;;)
      {
        paramahok.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg);
        return;
        paramStructMsg = paramStructMsg.msg.action_uin_nick.get();
        continue;
        Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
        if (localObject == null) {
          break;
        }
        String str2 = String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get());
        String str3 = String.valueOf(paramStructMsg.msg.action_uin.get());
        paramStructMsg = ((TroopManager)localObject).d(str2);
        str1 = bdgc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str3, str2, paramStructMsg, true, null);
        paramStructMsg = str1;
        if (TextUtils.isEmpty(str1))
        {
          paramStructMsg = ((TroopManager)localObject).a(str2, str3);
          continue;
          localObject = (alrk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53);
          if (localObject == null) {
            break;
          }
          paramStructMsg = ((alrk)localObject).a(String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()), String.valueOf(paramStructMsg.msg.action_uin.get()));
          if (paramStructMsg == null) {
            break;
          }
          paramStructMsg = paramStructMsg.getDiscussionMemberName();
        }
      }
    }
    switch (ahpp.a(paramahok.jdField_a_of_type_Int))
    {
    default: 
      paramahok.jdField_a_of_type_AndroidWidgetTextView.setText(paramahok.jdField_b_of_type_JavaLangString);
      return;
    case 0: 
      paramahok.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg.msg.group_name.get());
      return;
    case 1: 
      paramahok.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg.msg.action_uin_nick.get());
      return;
    }
    paramahok.jdField_a_of_type_AndroidWidgetTextView.setText(paramahok.jdField_b_of_type_JavaLangString);
  }
  
  private void a(structmsg.StructMsg paramStructMsg, long paramLong)
  {
    if (paramStructMsg != null)
    {
      long l = ((structmsg.StructMsg)paramStructMsg.get()).msg_seq.get() + ((structmsg.StructMsg)paramStructMsg.get()).msg_type.get();
      bafj.a().a(Long.valueOf(l), (structmsg.StructMsg)paramStructMsg.get());
      bafj.a().b(l);
      bafj.a().a(paramLong);
    }
  }
  
  private boolean a(int paramInt, structmsg.StructMsg paramStructMsg)
  {
    boolean bool = false;
    int i1;
    int i2;
    if (paramStructMsg != null)
    {
      int m = paramStructMsg.msg_type.get();
      long l1 = paramStructMsg.msg_seq.get();
      long l2 = paramStructMsg.req_uin.get();
      int n = paramStructMsg.msg.sub_type.get();
      i1 = paramStructMsg.msg.src_id.get();
      i2 = paramStructMsg.msg.sub_src_id.get();
      int i3 = paramStructMsg.msg.group_msg_type.get();
      List localList = paramStructMsg.msg.actions.get();
      if ((localList == null) || (paramInt >= localList.size())) {
        break label220;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(m, l1, l2, n, i1, i2, i3, (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)localList.get(paramInt)).action_info.get(), paramInt);
    }
    label220:
    for (bool = true;; bool = false)
    {
      if ((i1 == 116) && (i2 == 0)) {
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_discuss", "", "verify_msg", "Clk_agree", 0, 0, String.valueOf(paramStructMsg.msg.group_code.get()), "", "", "");
      }
      return bool;
    }
  }
  
  private boolean a(List<Stranger> paramList, String paramString)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      do
      {
        if (!paramList.hasNext()) {
          break;
        }
      } while (!TextUtils.equals(((Stranger)paramList.next()).uin, paramString));
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "checkInviteeIsFriend stranger list is empty ");
    }
    return false;
  }
  
  private void b(ahok paramahok)
  {
    int m = 1;
    if (paramahok == null) {
      return;
    }
    Object localObject;
    String str;
    switch (ahpp.a(paramahok.jdField_a_of_type_Int))
    {
    default: 
      localObject = String.valueOf(paramahok.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
      m = 4;
      str = paramahok.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_name.get() + this.jdField_a_of_type_AndroidContentContext.getString(2131696982);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = bdhj.b();
      }
      localObject = bdbk.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), m, (String)localObject, 3, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      paramahok.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(str);
      paramahok.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      return;
      localObject = paramahok.jdField_a_of_type_JavaLangString;
      str = paramahok.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get() + this.jdField_a_of_type_AndroidContentContext.getString(2131696981);
      continue;
      localObject = String.valueOf(paramahok.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
      str = paramahok.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.get() + this.jdField_a_of_type_AndroidContentContext.getString(2131696980);
    }
  }
  
  private void b(ahok paramahok, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "jumpToTroopRequestActivity!" + paramahok.jdField_a_of_type_Long + ": dealMsgType = " + paramInt);
    }
    Intent localIntent = new Intent(a(), TroopRequestActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putLong("troopMsgId", paramahok.jdField_a_of_type_Long);
    localBundle.putInt("mTroopMsgType", paramahok.jdField_a_of_type_Int);
    localBundle.putString("mTroopCode", String.valueOf(paramahok.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()));
    localBundle.putString("troopmanagerUin", String.valueOf(paramahok.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get()));
    localBundle.putString("troopsMsg", paramahok.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
    if ((this.jdField_a_of_type_Ahot != null) && (paramahok.jdField_b_of_type_Int < this.jdField_a_of_type_Ahot.jdField_a_of_type_Int)) {}
    for (boolean bool = true;; bool = false)
    {
      localBundle.putBoolean("is_unread", bool);
      localBundle.putString("troopRequestUin", String.valueOf(paramahok.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
      localBundle.putString("troopsummary", paramahok.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get());
      localBundle.putLong("infotime", paramahok.jdField_b_of_type_Long);
      if ((a() instanceof TroopActivity)) {
        localBundle.putBoolean("troop_invitee_is_friend", a((ArrayList)((TroopActivity)a()).jdField_a_of_type_JavaUtilList, String.valueOf(paramahok.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get())));
      }
      if (paramahok.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() != 83) {
        localIntent.putExtra("troopMsgDealInfo", paramahok.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_detail.get());
      }
      a((structmsg.StructMsg)paramahok.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), paramahok.jdField_c_of_type_Long);
      localBundle.putInt("t_s_f", 1001);
      localIntent.putExtras(localBundle);
      a(localIntent);
      return;
    }
  }
  
  private void o()
  {
    if (this.jdField_f_of_type_AndroidViewView == null) {
      this.jdField_f_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561331, null);
    }
    this.jdField_g_of_type_AndroidViewView = this.jdField_f_of_type_AndroidViewView.findViewById(2131377289);
    this.jdField_g_of_type_AndroidViewView.setOnClickListener(new ahpr(this));
    if (ThemeUtil.isDefaultTheme()) {
      this.jdField_g_of_type_AndroidViewView.setBackgroundResource(2130839217);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_f_of_type_AndroidViewView.findViewById(2131377290));
      if (this.jdField_a_of_type_ComTencentWidgetSwipListView != null)
      {
        AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
        this.jdField_f_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
        this.jdField_a_of_type_ComTencentWidgetSwipListView.addHeaderView(this.jdField_f_of_type_AndroidViewView);
      }
      int m = bafj.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (m <= 0) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(m + "");
      return;
      this.jdField_g_of_type_AndroidViewView.setBackgroundResource(2130839214);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
  }
  
  private void p()
  {
    int m = bafj.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.jdField_a_of_type_Ahot != null) {
      this.jdField_a_of_type_Ahot.jdField_a_of_type_Int = m;
    }
    this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(alof.N, 0);
    setAndCheckNotifyFollowSeq(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ArrayList localArrayList = new ArrayList();
    m = 0;
    while (m < this.jdField_a_of_type_JavaUtilList.size())
    {
      localArrayList.add(this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - m - 1));
      m += 1;
    }
    this.jdField_a_of_type_JavaUtilList = localArrayList;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0) && (!(this.jdField_a_of_type_JavaUtilList.get(0) instanceof MessageForSystemMsg)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotifyAndRecommendView", 2, "initNotificationListData error");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.x();
      if (this.jdField_a_of_type_Ahot != null) {
        this.jdField_a_of_type_Ahot.a(null);
      }
      return;
    }
    if (this.jdField_a_of_type_Ahot != null)
    {
      this.jdField_a_of_type_Ahot.a(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_Ahot.a(this.jdField_a_of_type_Ambh);
    }
    q();
  }
  
  private void q()
  {
    Object localObject3 = "";
    String str = "";
    Object localObject2 = str;
    Object localObject1 = localObject3;
    Intent localIntent;
    int m;
    if ((getContext() instanceof Activity))
    {
      localIntent = ((Activity)getContext()).getIntent();
      localObject2 = str;
      localObject1 = localObject3;
      if (localIntent != null)
      {
        m = localIntent.getIntExtra("key_from", 0);
        if (m == 1)
        {
          localObject1 = "3";
          localObject2 = "1";
        }
      }
    }
    for (;;)
    {
      bdes.a("Grp_contacts_news", "notice", "enter_verify", 0, 0, new String[] { localObject2, localObject1 });
      return;
      localObject2 = str;
      localObject1 = localObject3;
      if (m == 2)
      {
        localObject3 = "3";
        if (localIntent.getBooleanExtra("has_red", false))
        {
          str = "2";
          localObject2 = localObject3;
          localObject1 = str;
          if (this.jdField_a_of_type_JavaUtilList == null) {
            break label310;
          }
          localObject2 = localObject3;
          localObject1 = str;
          if (this.jdField_a_of_type_JavaUtilList.size() <= 0) {
            break label310;
          }
          localObject1 = (MessageRecord)this.jdField_a_of_type_JavaUtilList.get(0);
          if (!(localObject1 instanceof MessageForSystemMsg)) {
            break label302;
          }
          long l = ((MessageForSystemMsg)localObject1).getSystemMsg().msg.group_code.get();
          localObject1 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(l + "");
          if (localObject1 == null) {
            break label302;
          }
          if (((TroopInfo)localObject1).isAdmin()) {
            localObject1 = "1";
          }
        }
        for (;;)
        {
          localObject2 = "2";
          break;
          localObject1 = "2";
          continue;
          localObject1 = "3";
          localObject2 = "3";
          break;
          label302:
          localObject1 = "3";
        }
      }
      label310:
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
  }
  
  private void r()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "sendReadConfirm lll");
    }
    ThreadManager.post(new TroopNotifyAndRecommendView.5(this), 8, null, false);
    if (QLog.isColorLevel()) {
      QLog.i("TroopNotifyAndRecommendView", 2, "sendReadConfirm is end!");
    }
  }
  
  private void s()
  {
    if (this.jdField_e_of_type_AndroidViewView == null) {
      this.jdField_e_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561328, null);
    }
    if (this.jdField_e_of_type_AndroidViewView.getParent() == null) {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.addFooterView(this.jdField_e_of_type_AndroidViewView);
    }
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
  }
  
  public static void setAndCheckNotifyFollowSeq(List<MessageRecord> paramList, QQAppInterface paramQQAppInterface)
  {
    if (paramList.size() >= 40)
    {
      paramList = (MessageRecord)paramList.get(39);
      if ((paramList instanceof MessageForSystemMsg))
      {
        paramList = ((MessageForSystemMsg)paramList).getSystemMsg();
        if ((paramList != null) && (paramList.msg_seq.has()))
        {
          long l = paramList.msg_seq.get();
          if (l > 0L) {
            paramQQAppInterface.a().e("following_group_seq", l);
          }
        }
      }
    }
  }
  
  private void t()
  {
    if (this.h) {}
    do
    {
      do
      {
        do
        {
          return;
          if (!bdin.d(BaseApplication.getContext()))
          {
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692398), 0).b(a());
            return;
          }
          if ((this.jdField_a_of_type_Ahot == null) || (this.jdField_a_of_type_Ahot.a())) {
            break;
          }
        } while ((this.jdField_a_of_type_Auga != null) && (this.jdField_a_of_type_Auga.a()));
        this.h = true;
        this.jdField_e_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().h();
      } while (!QLog.isColorLevel());
      QLog.i("TroopNotifyAndRecommendView", 2, "loadNextPage.get next page of Notofication");
      return;
      if ((this.jdField_a_of_type_Ambh.jdField_a_of_type_Int != 1) && (this.j))
      {
        this.h = true;
        this.jdField_e_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_Ambh.a();
        if (QLog.isColorLevel()) {
          QLog.i("TroopNotifyAndRecommendView", 2, "loadNextPage.get next page of recommend");
        }
        bdes.a("Grp_contacts_news", "notice", "recom_,more", 2, 0, new String[0]);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.i("TroopNotifyAndRecommendView", 2, "ray test touch the end of list.");
  }
  
  private void u()
  {
    if (this.jdField_e_of_type_AndroidViewView != null) {
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    }
    this.h = false;
    if (QLog.isColorLevel()) {
      QLog.i("TroopNotifyAndRecommendView", 2, "stopLoadMore().");
    }
  }
  
  private void v()
  {
    boolean bool;
    if (this.jdField_a_of_type_Ahot != null)
    {
      if ((!ahql.a()) || (!ahql.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
        break label116;
      }
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotifyAndRecommendView", 2, "needFooter =" + bool + ", showRecommend =" + this.j);
      }
      if ((!bool) || (!this.j)) {
        break label121;
      }
      this.jdField_a_of_type_Ahot.a(true);
      bdes.a("Grp_contacts_news", "notice", "unnormal_exp", 0, 0, new String[0]);
    }
    for (;;)
    {
      this.jdField_a_of_type_Ahot.notifyDataSetChanged();
      return;
      label116:
      bool = false;
      break;
      label121:
      this.jdField_a_of_type_Ahot.a(false);
    }
  }
  
  private void w()
  {
    boolean bool;
    if ((ahql.a()) && (ahql.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (!this.j))
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotifyAndRecommendView", 2, "needRefresh =" + bool + ",showRecommend =" + this.j);
      }
      if (!bool) {
        break label209;
      }
      if (this.jdField_g_of_type_AndroidViewView != null) {
        this.jdField_g_of_type_AndroidViewView.setVisibility(0);
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        m = bafj.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (QLog.isColorLevel()) {
          QLog.d("TroopNotifyAndRecommendView", 2, "refreshTroopSuspiciousDisplay num =" + m);
        }
        if (m <= 0) {
          break label196;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(m + "");
      }
      bdes.a("Grp_contacts_news", "notice", "unnormal_exp", 0, 0, new String[0]);
    }
    label196:
    label209:
    while (this.jdField_g_of_type_AndroidViewView == null) {
      for (;;)
      {
        int m;
        return;
        bool = false;
        break;
        this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      }
    }
    this.jdField_g_of_type_AndroidViewView.setVisibility(8);
  }
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131298914);
  }
  
  public void a(ahok paramahok)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "handleGroupSystemMsg! start " + paramahok.jdField_a_of_type_Long);
    }
    b(paramahok, 998);
    Object localObject = paramahok.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_info.msg_alert.get();
    String str4 = paramahok.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "";
    String str2;
    int m;
    label148:
    String str1;
    if ((this.jdField_a_of_type_Ahot != null) && (paramahok.jdField_b_of_type_Int < this.jdField_a_of_type_Ahot.jdField_a_of_type_Int))
    {
      str2 = "1";
      m = paramahok.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_inviter_role.get();
      if ((m != 2) && (m != 3)) {
        break label315;
      }
      m = 0;
      switch (paramahok.jdField_a_of_type_Int)
      {
      case 4: 
      case 5: 
      case 8: 
      case 9: 
      case 14: 
      case 17: 
      case 18: 
      case 19: 
      case 20: 
      case 21: 
      default: 
        paramahok = "";
        localObject = "";
        str1 = "";
      }
    }
    for (;;)
    {
      bdes.a("Grp_contacts_news", "notice", str1, 3, 0, new String[] { str4, str2, localObject, paramahok });
      return;
      str2 = "0";
      break;
      label315:
      m = 1;
      break label148;
      str1 = "enter_askjoin";
      if ((localObject == null) || ("".equals(localObject))) {}
      for (localObject = "1";; localObject = "0")
      {
        if (paramahok.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() != 1) {
          break label378;
        }
        paramahok = "0";
        break;
      }
      label378:
      long l = paramahok.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actor_uin.get();
      if ((l != 0L) && (!(l + "").equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {}
      for (paramahok = "2";; paramahok = "1") {
        break;
      }
      paramahok = "";
      localObject = "";
      str1 = "refuseask_page";
      continue;
      if (paramahok.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() == 1) {}
      for (paramahok = "0";; paramahok = "1")
      {
        localObject = "";
        str1 = "enter_invite";
        break;
      }
      if (m != 0) {}
      String str3;
      for (paramahok = "0";; paramahok = "1")
      {
        str1 = "refuseinvite_page";
        str3 = "";
        localObject = paramahok;
        paramahok = str3;
        break;
      }
      if (m != 0) {}
      for (paramahok = "0";; paramahok = "1")
      {
        str1 = "refuseagree_page";
        str3 = "";
        localObject = paramahok;
        paramahok = str3;
        break;
      }
      paramahok = "";
      localObject = "";
      str1 = "quit_page";
      continue;
      str1 = "byquit_page";
      paramahok = "";
      localObject = "0";
      continue;
      str1 = "byquit_page";
      paramahok = "";
      localObject = "1";
      continue;
      if ((paramahok.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "").equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {}
      for (paramahok = "0";; paramahok = "1")
      {
        str1 = "set_admin_page";
        str3 = "";
        localObject = paramahok;
        paramahok = str3;
        break;
      }
      str1 = "un_admin_page";
      paramahok = "";
      localObject = "0";
      continue;
      str1 = "un_admin_page";
      paramahok = "";
      localObject = "1";
    }
  }
  
  public void a(ahok paramahok, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "bindTroopSystemMsgView! start " + paramahok.jdField_a_of_type_Long);
    }
    structmsg.StructMsg localStructMsg = paramahok.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
    paramahok.jdField_a_of_type_Long = paramInt;
    paramahok.jdField_a_of_type_JavaLangString = (localStructMsg.req_uin.get() + "");
    paramahok.jdField_a_of_type_Int = localStructMsg.msg.group_msg_type.get();
    paramInt = localStructMsg.msg.sub_type.get();
    paramahok.jdField_b_of_type_Long = localStructMsg.msg_time.get();
    paramahok.jdField_b_of_type_JavaLangString = localStructMsg.msg.req_uin_nick.get();
    String str;
    label233:
    Object localObject2;
    if ((paramahok.jdField_b_of_type_JavaLangString != null) && (!paramahok.jdField_b_of_type_JavaLangString.equals("")))
    {
      a(paramahok, localStructMsg);
      paramahok.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      str = localStructMsg.msg.group_info.msg_alert.get();
      localObject1 = "";
      if ((TextUtils.isEmpty(str)) || ((paramahok.jdField_a_of_type_Int != 1) && (paramahok.jdField_a_of_type_Int != 22))) {
        break label1066;
      }
      paramahok.jdField_c_of_type_AndroidWidgetTextView.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755953);
      localObject1 = str;
      if (paramahok.jdField_a_of_type_Int == 11)
      {
        localObject2 = localStructMsg.msg.msg_additional.get();
        localObject1 = localObject2;
        if (((String)localObject2).length() > 15) {
          localObject1 = ((String)localObject2).subSequence(0, 15) + "...";
        }
      }
      localObject2 = localObject1;
      if (localStructMsg.msg.pic_url.has())
      {
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label1270;
        }
        localObject2 = alud.a(2131716080) + (String)localObject1;
      }
      label350:
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label1281;
      }
      paramahok.jdField_c_of_type_AndroidWidgetTextView.setSingleLine(true);
      paramahok.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      paramahok.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      label383:
      if (paramahok.jdField_a_of_type_Int != 22) {
        break label1293;
      }
      localObject1 = localStructMsg.msg;
      paramahok.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject2 = new SpannableString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131720544, new Object[] { ((structmsg.SystemMsg)localObject1).action_uin_nick.get() }));
      ((SpannableString)localObject2).setSpan(new ForegroundColorSpan(Color.parseColor("#00a5e0")), 6, ((structmsg.SystemMsg)localObject1).action_uin_nick.get().length() + 6, 33);
      paramahok.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      paramahok.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new ahpw(this, (structmsg.SystemMsg)localObject1));
    }
    label538:
    label668:
    label690:
    label976:
    int m;
    for (;;)
    {
      localObject1 = bcpx.a(localStructMsg, localStructMsg.msg.msg_describe.get());
      if (localObject1 == null) {
        break label1557;
      }
      paramahok.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      if (paramahok.jdField_a_of_type_Int != 80) {
        break label1618;
      }
      localObject1 = localStructMsg.msg.actions.get();
      paramahok.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
      paramahok.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)((List)localObject1).get(0)).name.get());
      paramahok.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755344);
      paramahok.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839142);
      paramahok.jdField_a_of_type_AndroidWidgetButton.setContentDescription(paramahok.jdField_a_of_type_AndroidWidgetButton.getText() + "");
      paramahok.jdField_a_of_type_AndroidWidgetButton.setTag(paramahok);
      paramahok.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      if (!TextUtils.isEmpty(paramahok.jdField_a_of_type_AndroidWidgetButton.getText())) {
        break label1925;
      }
      paramahok.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      if ((paramInt == 2) && (paramahok.jdField_a_of_type_Int == 2) && (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(String.valueOf(localStructMsg.msg.group_code.get())) != null)) {
        auao.a().b(String.valueOf(localStructMsg.msg.group_code.get()), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      if (localStructMsg.msg.bytes_warning_tips.get() == null) {
        break label1936;
      }
      localObject1 = localStructMsg.msg.bytes_warning_tips.get().toStringUtf8();
      label789:
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label1944;
      }
      paramahok.d.setText((CharSequence)localObject1);
      paramahok.d.setVisibility(0);
      label814:
      if (QLog.isColorLevel()) {
        QLog.d("Q.security_verify", 2, String.format("bindTroopSystemMsgView reqUin: %s, warningTips: %s", new Object[] { paramahok.jdField_a_of_type_JavaLangString, localObject1 }));
      }
      paramahok.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(paramahok);
      paramahok.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramahok.jdField_a_of_type_AndroidWidgetImageView.setTag(paramahok);
      if ((paramahok.jdField_a_of_type_Int != 8) && (paramahok.jdField_a_of_type_Int != 7)) {
        break label1956;
      }
      paramahok.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
      label902:
      b(paramahok);
      if (((paramahok.jdField_a_of_type_Int == 1) || (paramahok.jdField_a_of_type_Int == 22) || (paramahok.jdField_a_of_type_Int == 60)) && (QLog.isColorLevel()))
      {
        if ((!localStructMsg.msg.has()) || (!localStructMsg.msg.src_id.has())) {
          break label1967;
        }
        paramInt = localStructMsg.msg.src_id.get();
        if ((!localStructMsg.msg.has()) || (!localStructMsg.msg.sub_src_id.has())) {
          break label1972;
        }
        m = localStructMsg.msg.sub_src_id.get();
        label1013:
        QLog.i("TroopNotifyAndRecommendView", 2, String.format("joinGroup subSourceID=%d sourceID=%d msgType=%d", new Object[] { Integer.valueOf(m), Integer.valueOf(paramInt), Integer.valueOf(paramahok.jdField_a_of_type_Int) }));
      }
      return;
      paramahok.jdField_b_of_type_JavaLangString = paramahok.jdField_a_of_type_JavaLangString;
      break;
      label1066:
      if (!TextUtils.isEmpty(localStructMsg.msg.msg_qna.get()))
      {
        localObject1 = localStructMsg.msg.msg_qna.get();
        break label233;
      }
      if (!TextUtils.isEmpty(localStructMsg.msg.msg_actor_describe.get()))
      {
        localObject1 = bcpx.a(localStructMsg, localStructMsg.msg.msg_actor_describe.get());
        break label233;
      }
      if (!TextUtils.isEmpty(localStructMsg.msg.msg_additional_list.get()))
      {
        localObject1 = localStructMsg.msg.msg_additional_list.get();
        break label233;
      }
      if (!TextUtils.isEmpty(localStructMsg.msg.msg_additional.get()))
      {
        localObject1 = localStructMsg.msg.msg_additional.get();
        break label233;
      }
      if ((!TextUtils.isEmpty(localStructMsg.msg.msg_detail.get())) && (paramahok.jdField_a_of_type_Int == 12))
      {
        localObject1 = localStructMsg.msg.msg_detail.get();
        break label233;
      }
      if (paramahok.jdField_a_of_type_Int != 83) {
        break label233;
      }
      localObject1 = localStructMsg.msg.msg_detail.get();
      break label233;
      label1270:
      localObject2 = alud.a(2131716081);
      break label350;
      label1281:
      paramahok.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      break label383;
      label1293:
      if ((paramahok.jdField_a_of_type_Int == 2) && (localStructMsg.msg.msg_invite_extinfo.uint32_src_type.has()))
      {
        localObject2 = "";
        switch (localStructMsg.msg.msg_invite_extinfo.uint32_src_type.get())
        {
        }
      }
    }
    Object localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    if (localObject1 != null) {}
    for (localObject1 = ((TroopManager)localObject1).a(String.valueOf(localStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()));; localObject1 = "")
    {
      paramahok.jdField_c_of_type_AndroidWidgetTextView.setText(alud.a(2131716084) + (String)localObject1);
      paramahok.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      break;
      Object localObject3 = (alrk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((alrk)localObject3).a(String.valueOf(localStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()));
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = ((DiscussionInfo)localObject3).discussionName;
        }
      }
      paramahok.jdField_c_of_type_AndroidWidgetTextView.setText(alud.a(2131716082) + (String)localObject1);
      paramahok.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      break;
      label1557:
      localObject1 = localStructMsg.msg.msg_additional.get();
      if ((localObject1 == null) || ("".equals(localObject1)))
      {
        paramahok.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131696664));
        break label538;
      }
      paramahok.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      break label538;
      label1618:
      if (paramInt == 1)
      {
        localObject1 = localStructMsg.msg.actions.get();
        paramahok.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          if ((str == null) || ("".equals(str))) {
            if (((List)localObject1).size() > 1)
            {
              paramahok.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)((List)localObject1).get(1)).name.get());
              paramahok.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755344);
              paramahok.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839142);
            }
          }
          for (;;)
          {
            paramahok.jdField_a_of_type_AndroidWidgetButton.setContentDescription(paramahok.jdField_a_of_type_AndroidWidgetButton.getText() + "");
            paramahok.jdField_a_of_type_AndroidWidgetButton.setTag(paramahok);
            paramahok.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
            break;
            paramahok.jdField_a_of_type_AndroidWidgetButton.setText("");
            continue;
            paramahok.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)((List)localObject1).get(0)).name.get());
            paramahok.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755343);
            paramahok.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839141);
          }
        }
        paramahok.jdField_a_of_type_AndroidWidgetButton.setText("");
        paramahok.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
        break label668;
      }
      paramahok.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
      paramahok.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
      paramahok.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755951);
      paramahok.jdField_a_of_type_AndroidWidgetButton.setText(localStructMsg.msg.msg_decided.get());
      break label668;
      label1925:
      paramahok.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      break label690;
      label1936:
      localObject1 = "";
      break label789;
      label1944:
      paramahok.d.setVisibility(8);
      break label814;
      label1956:
      paramahok.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      break label902;
      label1967:
      paramInt = -1;
      break label976;
      label1972:
      m = -1;
      break label1013;
    }
  }
  
  protected void a(Intent paramIntent, ahoe paramahoe)
  {
    super.a(paramIntent, paramahoe);
    this.jdField_a_of_type_Ambh = ((ambh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(22));
    this.jdField_a_of_type_Auga = ((auga)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37));
    i();
    b(paramIntent, paramahoe);
    c(paramIntent, paramahoe);
  }
  
  public void a(List<RecommendTroopItem> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "handleRecommendDataResult: " + Log.getStackTraceString(new RuntimeException("debug trace")));
    }
    this.jdField_a_of_type_Ahoe.a(new TroopNotifyAndRecommendView.12(this, paramList));
  }
  
  public boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      m();
      b();
    }
  }
  
  protected int b()
  {
    int i1 = ambh.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (i1 > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(alof.W, 9000, 0 - i1);
      this.jdField_a_of_type_Ambh.b();
      n();
    }
    int n = 0;
    int m = n;
    if (this.jdField_a_of_type_Ambh != null)
    {
      m = n;
      if (!this.jdField_b_of_type_Boolean)
      {
        m = n;
        if (i1 > 0) {
          m = 1;
        }
      }
    }
    return m;
  }
  
  protected void b(Intent paramIntent, ahoe paramahoe)
  {
    a(this.jdField_a_of_type_Alwx);
    s();
    p();
    this.jdField_a_of_type_Bety = new bety(this.jdField_a_of_type_AndroidContentContext, a());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    if (ahpp.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) > 0) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(3);
    }
    ahpp.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.jdField_a_of_type_Ahot != null) {
      this.jdField_a_of_type_Ahot.notifyDataSetChanged();
    }
    int m = bafj.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "notification num:" + m);
    }
    this.jdField_a_of_type_Ambh.jdField_c_of_type_Int = m;
    int n = ambh.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(alof.W, 9000, 0 - (m + n));
    bafj.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    this.jdField_c_of_type_Boolean = false;
  }
  
  protected void c(Intent paramIntent, ahoe paramahoe)
  {
    super.a(paramIntent, paramahoe);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
    a(this.jdField_a_of_type_Ameq);
    k();
  }
  
  protected void d()
  {
    super.d();
    this.jdField_c_of_type_Boolean = false;
    if (this.i)
    {
      ahpp.b();
      bafj.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
      if (this.jdField_a_of_type_Ahot != null)
      {
        this.jdField_a_of_type_Ahot.jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_Ahot.notifyDataSetChanged();
      }
      this.jdField_a_of_type_Ambh.jdField_c_of_type_Int = bafj.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    v();
    w();
    this.i = true;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int m = (int)paramMotionEvent.getX();
    int n = (int)paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      this.jdField_e_of_type_Int = n;
      this.d = m;
      return super.dispatchTouchEvent(paramMotionEvent);
      getParent().requestDisallowInterceptTouchEvent(true);
      continue;
      int i1 = m - this.d;
      int i2 = n - this.jdField_e_of_type_Int;
      if ((i1 > 20) || (i1 < -20)) {
        this.k = true;
      }
      if (((i2 > 20) || (i2 < -20)) && (!this.k))
      {
        getParent().requestDisallowInterceptTouchEvent(false);
        continue;
        this.k = false;
      }
    }
  }
  
  protected void e()
  {
    super.e();
  }
  
  protected void f()
  {
    super.f();
    if (this.jdField_a_of_type_Ambh != null) {
      this.jdField_a_of_type_Ambh.b();
    }
  }
  
  protected void g()
  {
    super.g();
    if ((this.jdField_a_of_type_Ahot != null) && (this.jdField_a_of_type_Ahot.a() > 0)) {
      r();
    }
    b(this.jdField_a_of_type_Ameq);
    MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(TroopNotifyAndRecommendView.class);
    if (localMqqHandler != null) {
      localMqqHandler.removeCallbacksAndMessages(null);
    }
    b(this.jdField_a_of_type_Alwx);
    if (this.jdField_a_of_type_Ahot != null)
    {
      this.jdField_a_of_type_Ahot.a();
      this.jdField_a_of_type_Ahot.notifyDataSetChanged();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
    ahpp.b();
    bafj.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    if (this.jdField_c_of_type_Boolean) {
      bafj.a().b();
    }
    bcwe.a(a()).a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(getClass());
    if (this.jdField_a_of_type_Ampt != null) {
      SosoInterface.b(this.jdField_a_of_type_Ampt);
    }
    this.jdField_a_of_type_Ambh.b();
    this.jdField_a_of_type_Ambh.d();
    this.jdField_a_of_type_Ambh.a();
    if (this.jdField_a_of_type_Auga != null) {
      this.jdField_a_of_type_Auga.a(false);
    }
  }
  
  public void i()
  {
    a(2131559751);
    this.jdField_a_of_type_Ahot = new ahot(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getContext(), this.jdField_a_of_type_Ahoe, this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)findViewById(2131378439));
    o();
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_Ahot);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnScrollListener(this);
  }
  
  public void j()
  {
    r();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.v();
    bafj.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    this.jdField_a_of_type_JavaUtilList.clear();
    if (this.jdField_a_of_type_Ahot != null)
    {
      this.jdField_a_of_type_Ahot.a();
      this.jdField_a_of_type_Ahot.notifyDataSetChanged();
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1012);
  }
  
  public void k()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 4, "onChecked........");
    }
    this.j = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getBoolean("show_new_troop_recommend", false);
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "getNotificationRecommendTroopList showOpen is :" + this.j);
    }
    if ((this.jdField_f_of_type_Boolean) && (this.j))
    {
      this.jdField_f_of_type_Boolean = false;
      this.jdField_a_of_type_Ambh.a();
    }
    if ((!this.j) && (this.jdField_a_of_type_Ahot != null))
    {
      this.jdField_a_of_type_Ahot.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_Ahot.notifyDataSetChanged();
    }
    b();
    l();
  }
  
  protected void l()
  {
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_Ahot != null) && (this.jdField_a_of_type_Ahot.a()))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopNotifyAndRecommendView", 4, "reportPv");
      }
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_recom", "", "msg_page", "exp", 0, 0, "", "", "", "");
    }
  }
  
  public void m()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 4, "refreshRecommendTroopList");
    }
    if (this.jdField_g_of_type_Boolean) {}
    while (!QLog.isDevelopLevel()) {
      return;
    }
    QLog.d("TroopNotifyAndRecommendView", 4, "refreshRecommendTroopList start ");
  }
  
  protected void n()
  {
    if ((this.jdField_a_of_type_Ambh != null) && (!this.jdField_b_of_type_Boolean) && (ambh.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) > 0))
    {
      a(1, true);
      return;
    }
    a(1, false);
  }
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if ((l - jdField_c_of_type_Long > 0L) && (l - jdField_c_of_type_Long < 800L)) {}
    Object localObject1;
    Object localObject2;
    int m;
    label226:
    do
    {
      do
      {
        do
        {
          return;
          jdField_c_of_type_Long = l;
          switch (paramView.getId())
          {
          default: 
            return;
          case 2131371018: 
            bbpf.a(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            return;
          }
        } while (!(paramView.getTag() instanceof ahok));
        localObject1 = (ahok)paramView.getTag();
      } while (localObject1 == null);
      localObject2 = ((ahok)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
      m = ((ahok)localObject1).jdField_a_of_type_Int;
      if (ahpp.a(m) == 0)
      {
        paramView = TroopInfoActivity.a(String.valueOf(((ahok)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()), 4);
        paramView.putInt("t_s_f", 1001);
        bcpx.a(a(), paramView, 2);
        if ((m == 2) || (m == 10) || (m == 12))
        {
          m = 1;
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          String str = ((ahok)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "";
          if (m == 0) {
            break label330;
          }
          paramView = "0";
          azqs.b((QQAppInterface)localObject2, "P_CliOper", "Grp_contacts", "", "notice", "see_data", 0, 0, str, paramView, "", "");
          localObject1 = ((ahok)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code + "";
          if (m == 0) {
            break label337;
          }
        }
        for (paramView = "0";; paramView = "1")
        {
          bdes.a("Grp_contacts_news", "notice", "see_data", 0, 0, new String[] { localObject1, paramView });
          return;
          m = 0;
          break;
          paramView = "1";
          break label226;
        }
      }
    } while ((((ahok)localObject1).jdField_a_of_type_Int == 2) && (TroopInfo.isQidianPrivateTroop(((ahok)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint32_group_flagext3.get())));
    label330:
    label337:
    if (((ahok)localObject1).jdField_a_of_type_Int == 82)
    {
      paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, AccountDetailActivity.class);
      paramView.putExtra("uin", ((ahok)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "");
      paramView.putExtra("source", 112);
      a(paramView);
      return;
    }
    l = ((structmsg.StructMsg)localObject2).req_uin.get();
    switch (ahpp.a(m))
    {
    default: 
      paramView = String.valueOf(l);
      label493:
      if (((alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(paramView)) {
        paramView = new ProfileActivity.AllInOne(paramView, 1);
      }
      break;
    }
    for (;;)
    {
      l = ((structmsg.StructMsg)localObject2).msg.uint32_group_flagext3.get();
      boolean bool = TroopInfo.isQidianPrivateTroop(l);
      m = ((structmsg.StructMsg)localObject2).msg.group_msg_type.get();
      if (QLog.isColorLevel()) {
        QLog.d(".troop.qidian_private_troop", 2, "notification headView onClick: msgType=" + m + ", isQidianPrivateTroop=" + bool + ", flagExt3=" + l);
      }
      if ((bool) && (m == 2)) {
        break;
      }
      ProfileActivity.b(a(), paramView);
      bdes.a("Grp_contacts_news", "notice", "see_fromdata", 0, 0, new String[] { ((ahok)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code + "", "3" });
      return;
      paramView = ((ahok)localObject1).jdField_a_of_type_JavaLangString;
      break label493;
      paramView = String.valueOf(((ahok)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
      break label493;
      if ((((structmsg.StructMsg)localObject2).msg.group_msg_type.get() == 2) && (((structmsg.StructMsg)localObject2).msg.sub_type.get() == 3))
      {
        paramView = new ProfileActivity.AllInOne(paramView, 26);
        paramView.d = 1;
      }
      else
      {
        paramView = new ProfileActivity.AllInOne(paramView, 24);
        bcpx.a((structmsg.StructMsg)localObject2, paramView);
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_b_of_type_Int = (paramInt1 + paramInt2 - 1);
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyAndRecommendView", 2, "ray test firstvis:" + paramInt1 + " viscount:" + paramInt2);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramAbsListView = new StringBuilder().append("ray test lastindex:").append(this.jdField_b_of_type_Int).append("list count");
      if (this.jdField_a_of_type_Ahot == null) {
        break label100;
      }
    }
    label100:
    for (int m = this.jdField_a_of_type_Ahot.getCount();; m = 0)
    {
      QLog.d("TroopNotifyAndRecommendView", 2, m);
      if ((this.jdField_a_of_type_Ahot != null) && (paramInt == 0) && (this.jdField_b_of_type_Int == this.jdField_a_of_type_Ahot.getCount() - 1)) {
        t();
      }
      this.jdField_c_of_type_Int = paramInt;
      return;
    }
  }
  
  public void update(Observable paramObservable, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView
 * JD-Core Version:    0.7.0.1
 */