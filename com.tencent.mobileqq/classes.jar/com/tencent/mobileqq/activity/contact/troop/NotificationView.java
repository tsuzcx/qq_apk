package com.tencent.mobileqq.activity.contact.troop;

import aexv;
import afaw;
import afaz;
import afbb;
import afbc;
import afbd;
import afbe;
import afbf;
import afbg;
import afbh;
import afbi;
import afbj;
import afce;
import afcf;
import afcz;
import ajed;
import ajhh;
import ajjj;
import ajjy;
import ajmm;
import ajqt;
import akaq;
import akcl;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import arjb;
import arom;
import awqx;
import axcz;
import azhu;
import azlj;
import azwg;
import azwh;
import azzx;
import babh;
import badq;
import bbms;
import bbmy;
import bbob;
import begh;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
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
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import tencent.mobileim.structmsg.structmsg.GroupInfo;
import tencent.mobileim.structmsg.structmsg.MsgInviteExt;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class NotificationView
  extends BaseTroopView
  implements aexv, View.OnClickListener, azwh, bbob, begh
{
  protected static int b;
  protected static long c;
  public final long a;
  public afaz a;
  public afcf a;
  ajmm jdField_a_of_type_Ajmm = new afbe(this);
  public Context a;
  protected View.OnClickListener a;
  protected View.OnTouchListener a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected arom a;
  protected azwg a;
  public bbms a;
  protected SlideDetectListView a;
  public List<MessageRecord> a;
  public MqqHandler a;
  public final long b;
  protected View.OnClickListener b;
  protected int c;
  protected boolean c;
  protected int d;
  public boolean d;
  public View e;
  private boolean e;
  protected View f;
  private View g;
  private View h;
  
  static
  {
    jdField_b_of_type_Int = 1;
  }
  
  public NotificationView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Long = 1000L;
    this.jdField_b_of_type_Long = 500L;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_MqqOsMqqHandler = new afbc(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new afbd(this);
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new afbf(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new afbh(this);
    this.jdField_a_of_type_Afcf = new afbj(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(long paramLong, structmsg.StructMsg paramStructMsg)
  {
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("structMsg", paramStructMsg.toByteArray());
    azhu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong, new afbi(this), localBundle);
  }
  
  private void a(afbb paramafbb, structmsg.StructMsg paramStructMsg)
  {
    if ((paramafbb == null) || (paramStructMsg == null)) {
      return;
    }
    if ((paramafbb.jdField_a_of_type_Int == 2) && (paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.has()))
    {
      String str1 = paramStructMsg.msg.action_uin_qq_nick.get().toStringUtf8();
      switch (paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.get())
      {
      default: 
        paramStructMsg = str1;
      }
      for (;;)
      {
        paramafbb.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg);
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
        str1 = babh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str3, str2, paramStructMsg, true, null);
        paramStructMsg = str1;
        if (TextUtils.isEmpty(str1))
        {
          paramStructMsg = ((TroopManager)localObject).a(str2, str3);
          continue;
          localObject = (ajhh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53);
          if (localObject == null) {
            break;
          }
          paramStructMsg = ((ajhh)localObject).a(String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()), String.valueOf(paramStructMsg.msg.action_uin.get()));
          if (paramStructMsg == null) {
            break;
          }
          paramStructMsg = paramStructMsg.getDiscussionMemberName();
        }
      }
    }
    switch (afce.a(paramafbb.jdField_a_of_type_Int))
    {
    default: 
      paramafbb.jdField_a_of_type_AndroidWidgetTextView.setText(paramafbb.jdField_b_of_type_JavaLangString);
      return;
    case 0: 
      paramafbb.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg.msg.group_name.get());
      return;
    case 1: 
      paramafbb.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg.msg.action_uin_nick.get());
      return;
    }
    paramafbb.jdField_a_of_type_AndroidWidgetTextView.setText(paramafbb.jdField_b_of_type_JavaLangString);
  }
  
  private void a(XListView paramXListView, String paramString, Bitmap paramBitmap)
  {
    afbb localafbb;
    String str;
    if (this.jdField_c_of_type_Int == 0)
    {
      int j = paramXListView.getChildCount();
      int i = 0;
      while (i < j)
      {
        localafbb = (afbb)paramXListView.getChildAt(i).getTag();
        if (localafbb == null) {
          i += 1;
        } else {
          switch (afce.a(localafbb.jdField_a_of_type_Int))
          {
          default: 
            str = String.valueOf(localafbb.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
          }
        }
      }
    }
    while ((localafbb != null) && (paramString.equals(str)))
    {
      localafbb.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      return;
      str = localafbb.jdField_a_of_type_JavaLangString;
      continue;
      str = String.valueOf(localafbb.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
    }
  }
  
  private void a(structmsg.StructMsg paramStructMsg, long paramLong)
  {
    if (paramStructMsg != null)
    {
      long l = ((structmsg.StructMsg)paramStructMsg.get()).msg_seq.get() + ((structmsg.StructMsg)paramStructMsg.get()).msg_type.get();
      axcz.a().a(Long.valueOf(l), (structmsg.StructMsg)paramStructMsg.get());
      axcz.a().b(l);
      axcz.a().a(paramLong);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    a(0, paramBoolean);
  }
  
  private boolean a(int paramInt, structmsg.StructMsg paramStructMsg)
  {
    boolean bool = false;
    int k;
    int m;
    if (paramStructMsg != null)
    {
      int i = paramStructMsg.msg_type.get();
      long l1 = paramStructMsg.msg_seq.get();
      long l2 = paramStructMsg.req_uin.get();
      int j = paramStructMsg.msg.sub_type.get();
      k = paramStructMsg.msg.src_id.get();
      m = paramStructMsg.msg.sub_src_id.get();
      int n = paramStructMsg.msg.group_msg_type.get();
      List localList = paramStructMsg.msg.actions.get();
      if ((localList == null) || (paramInt >= localList.size())) {
        break label220;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(i, l1, l2, j, k, m, n, (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)localList.get(paramInt)).action_info.get(), paramInt);
    }
    label220:
    for (bool = true;; bool = false)
    {
      if ((k == 116) && (m == 0)) {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_discuss", "", "verify_msg", "Clk_agree", 0, 0, String.valueOf(paramStructMsg.msg.group_code.get()), "", "", "");
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
      QLog.d("NotificationView", 2, "checkInviteeIsFriend stranger list is empty ");
    }
    return false;
  }
  
  private void b(afbb paramafbb)
  {
    int i = 1;
    if (paramafbb == null) {
      return;
    }
    Object localObject;
    String str;
    switch (afce.a(paramafbb.jdField_a_of_type_Int))
    {
    default: 
      localObject = String.valueOf(paramafbb.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
      i = 4;
      str = paramafbb.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_name.get() + this.jdField_a_of_type_AndroidContentContext.getString(2131631092);
    }
    for (;;)
    {
      localObject = afce.a(this.jdField_a_of_type_Azwg, (String)localObject, i);
      paramafbb.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(str);
      paramafbb.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      return;
      localObject = paramafbb.jdField_a_of_type_JavaLangString;
      str = paramafbb.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get() + this.jdField_a_of_type_AndroidContentContext.getString(2131631091);
      continue;
      localObject = String.valueOf(paramafbb.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
      str = paramafbb.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.get() + this.jdField_a_of_type_AndroidContentContext.getString(2131631090);
    }
  }
  
  private void b(afbb paramafbb, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NotificationView", 2, "jumpToTroopRequestActivity!" + paramafbb.jdField_a_of_type_Long + ": dealMsgType = " + paramInt);
    }
    Intent localIntent = new Intent(a(), TroopRequestActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putLong("troopMsgId", paramafbb.jdField_a_of_type_Long);
    localBundle.putInt("mTroopMsgType", paramafbb.jdField_a_of_type_Int);
    localBundle.putString("mTroopCode", String.valueOf(paramafbb.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()));
    localBundle.putString("troopmanagerUin", String.valueOf(paramafbb.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get()));
    localBundle.putString("troopsMsg", paramafbb.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
    if (paramafbb.jdField_b_of_type_Int < this.jdField_a_of_type_Afaz.jdField_a_of_type_Int) {}
    for (boolean bool = true;; bool = false)
    {
      localBundle.putBoolean("is_unread", bool);
      localBundle.putString("troopRequestUin", String.valueOf(paramafbb.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
      localBundle.putString("troopsummary", paramafbb.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get());
      localBundle.putLong("infotime", paramafbb.jdField_b_of_type_Long);
      if ((a() instanceof TroopActivity)) {
        localBundle.putBoolean("troop_invitee_is_friend", a((ArrayList)((TroopActivity)a()).jdField_a_of_type_JavaUtilList, String.valueOf(paramafbb.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get())));
      }
      if (paramafbb.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() != 83) {
        localIntent.putExtra("troopMsgDealInfo", paramafbb.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_detail.get());
      }
      a((structmsg.StructMsg)paramafbb.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), paramafbb.jdField_c_of_type_Long);
      localBundle.putInt("t_s_f", 1001);
      localIntent.putExtras(localBundle);
      a(localIntent);
      return;
    }
  }
  
  private void k()
  {
    a(this.jdField_a_of_type_Ajmm);
  }
  
  private void l()
  {
    b(this.jdField_a_of_type_Ajmm);
  }
  
  private void m()
  {
    a(2131494134);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131306843));
    this.jdField_e_of_type_AndroidViewView = findViewById(2131306839);
    n();
    p();
    this.jdField_a_of_type_Azwg = new azwg(getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Azwg.a(this);
  }
  
  private void n()
  {
    if (this.g == null) {
      this.g = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495539, null);
    }
    this.h = this.g.findViewById(2131310915);
    this.h.setOnClickListener(this);
    if (ThemeUtil.isDefaultTheme()) {
      this.h.setBackgroundResource(2130839104);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.g.findViewById(2131310916));
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView != null)
      {
        AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
        this.g.setLayoutParams(localLayoutParams);
        this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.addHeaderView(this.g);
      }
      int i = axcz.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (i <= 0) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(i + "");
      return;
      this.h.setBackgroundResource(2130839101);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
  }
  
  private void o()
  {
    int i = ((ajqt)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(22)).jdField_c_of_type_Int;
    this.jdField_a_of_type_Afaz = new afaz(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, i, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView);
    this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(ajed.N, 0);
    TroopNotifyAndRecommendView.setAndCheckNotifyFollowSeq(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ArrayList localArrayList = new ArrayList();
    i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localArrayList.add(this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - i - 1));
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilList = localArrayList;
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_Afaz);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setDividerHeight(1);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0) && (!(this.jdField_a_of_type_JavaUtilList.get(0) instanceof MessageForSystemMsg)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("NotificationView", 2, "initListData error");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.w();
      this.jdField_a_of_type_Afaz.a(null);
      return;
    }
    this.jdField_a_of_type_Afaz.a(this.jdField_a_of_type_JavaUtilList);
    i();
  }
  
  private void p()
  {
    if (this.f == null) {
      this.f = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495536, null);
    }
    if (this.f.getParent() == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.addFooterView(this.f);
    }
    this.f.setVisibility(8);
  }
  
  private void q()
  {
    if (this.jdField_d_of_type_Boolean) {}
    do
    {
      do
      {
        return;
        if (!badq.d(BaseApplication.getContext()))
        {
          bbmy.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131626719), 0).b(a());
          return;
        }
      } while ((this.jdField_a_of_type_Arom != null) && (this.jdField_a_of_type_Arom.a()));
      this.jdField_d_of_type_Boolean = true;
      this.f.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().h();
    } while (!QLog.isColorLevel());
    QLog.i("NotificationView", 2, "loadNextPage.get next page.");
  }
  
  private void r()
  {
    if (this.f != null) {
      this.f.setVisibility(8);
    }
    this.jdField_d_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.i("NotificationView", 2, "stopLoadMore().");
    }
  }
  
  private void s()
  {
    ThreadManager.post(new NotificationView.5(this), 8, null, false);
    if (QLog.isColorLevel()) {
      QLog.i("NotificationView", 2, "sendReadConfirm is end!");
    }
  }
  
  private void t()
  {
    boolean bool;
    if ((afcz.a()) && (afcz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("NotificationView", 2, "needRefresh =" + bool);
      }
      if (!bool) {
        break label189;
      }
      if (this.h != null) {
        this.h.setVisibility(0);
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        i = axcz.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (QLog.isColorLevel()) {
          QLog.d("NotificationView", 2, "refreshTroopSuspiciousDisplay num =" + i);
        }
        if (i <= 0) {
          break label176;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(i + "");
      }
      azzx.a("Grp_contacts_news", "notice", "unnormal_exp", 0, 0, new String[0]);
    }
    label176:
    label189:
    while (this.h == null) {
      for (;;)
      {
        int i;
        return;
        bool = false;
        break;
        this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      }
    }
    this.h.setVisibility(8);
  }
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131167766);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(ajed.V, 9000, 0 - axcz.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    axcz.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    this.jdField_c_of_type_Boolean = false;
    if ((this.jdField_a_of_type_Afaz != null) && (this.jdField_a_of_type_Afaz.getCount() > 0))
    {
      i();
      this.jdField_a_of_type_Afaz.notifyDataSetChanged();
      s();
    }
    a(false);
  }
  
  public void a(afbb paramafbb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NotificationView", 2, "handleGroupSystemMsg! start " + paramafbb.jdField_a_of_type_Long);
    }
    b(paramafbb, 998);
    Object localObject = paramafbb.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_info.msg_alert.get();
    String str4 = paramafbb.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "";
    String str2;
    int i;
    label141:
    String str1;
    if (paramafbb.jdField_b_of_type_Int < this.jdField_a_of_type_Afaz.jdField_a_of_type_Int)
    {
      str2 = "1";
      i = paramafbb.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_inviter_role.get();
      if ((i != 2) && (i != 3)) {
        break label307;
      }
      i = 0;
      switch (paramafbb.jdField_a_of_type_Int)
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
        paramafbb = "";
        localObject = "";
        str1 = "";
      }
    }
    for (;;)
    {
      azzx.a("Grp_contacts_news", "notice", str1, 3, 0, new String[] { str4, str2, localObject, paramafbb });
      return;
      str2 = "0";
      break;
      label307:
      i = 1;
      break label141;
      str1 = "enter_askjoin";
      if ((localObject == null) || ("".equals(localObject))) {}
      for (localObject = "1";; localObject = "0")
      {
        if (paramafbb.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() != 1) {
          break label370;
        }
        paramafbb = "0";
        break;
      }
      label370:
      long l = paramafbb.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actor_uin.get();
      if ((l != 0L) && (!(l + "").equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {}
      for (paramafbb = "2";; paramafbb = "1") {
        break;
      }
      paramafbb = "";
      localObject = "";
      str1 = "refuseask_page";
      continue;
      if (paramafbb.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() == 1) {}
      for (paramafbb = "0";; paramafbb = "1")
      {
        localObject = "";
        str1 = "enter_invite";
        break;
      }
      if (i != 0) {}
      String str3;
      for (paramafbb = "0";; paramafbb = "1")
      {
        str1 = "refuseinvite_page";
        str3 = "";
        localObject = paramafbb;
        paramafbb = str3;
        break;
      }
      if (i != 0) {}
      for (paramafbb = "0";; paramafbb = "1")
      {
        str1 = "refuseagree_page";
        str3 = "";
        localObject = paramafbb;
        paramafbb = str3;
        break;
      }
      paramafbb = "";
      localObject = "";
      str1 = "quit_page";
      continue;
      str1 = "byquit_page";
      paramafbb = "";
      localObject = "0";
      continue;
      str1 = "byquit_page";
      paramafbb = "";
      localObject = "1";
      continue;
      if ((paramafbb.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "").equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {}
      for (paramafbb = "0";; paramafbb = "1")
      {
        str1 = "set_admin_page";
        str3 = "";
        localObject = paramafbb;
        paramafbb = str3;
        break;
      }
      str1 = "un_admin_page";
      paramafbb = "";
      localObject = "0";
      continue;
      str1 = "un_admin_page";
      paramafbb = "";
      localObject = "1";
    }
  }
  
  public void a(afbb paramafbb, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NotificationView", 2, "bindTroopSystemMsgView! start " + paramafbb.jdField_a_of_type_Long);
    }
    structmsg.StructMsg localStructMsg = paramafbb.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
    paramafbb.jdField_a_of_type_Long = paramInt;
    paramafbb.jdField_a_of_type_JavaLangString = (localStructMsg.req_uin.get() + "");
    paramafbb.jdField_a_of_type_Int = localStructMsg.msg.group_msg_type.get();
    paramInt = localStructMsg.msg.sub_type.get();
    paramafbb.jdField_b_of_type_Long = localStructMsg.msg_time.get();
    paramafbb.jdField_b_of_type_JavaLangString = localStructMsg.msg.req_uin_nick.get();
    String str;
    label258:
    Object localObject2;
    if ((paramafbb.jdField_b_of_type_JavaLangString != null) && (!paramafbb.jdField_b_of_type_JavaLangString.equals("")))
    {
      a(paramafbb, localStructMsg);
      paramafbb.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      str = localStructMsg.msg.group_info.msg_alert.get();
      localObject1 = "";
      paramafbb.jdField_c_of_type_AndroidWidgetTextView.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131690322);
      paramafbb.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#a6a6a6"));
      if ((TextUtils.isEmpty(str)) || ((paramafbb.jdField_a_of_type_Int != 1) && (paramafbb.jdField_a_of_type_Int != 22))) {
        break label822;
      }
      paramafbb.jdField_c_of_type_AndroidWidgetTextView.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131690323);
      localObject1 = str;
      if (paramafbb.jdField_a_of_type_Int == 11)
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
          break label1020;
        }
        localObject2 = ajjy.a(2131641841) + (String)localObject1;
      }
      label370:
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label1031;
      }
      paramafbb.jdField_c_of_type_AndroidWidgetTextView.setSingleLine(true);
      paramafbb.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      paramafbb.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      label403:
      if (paramafbb.jdField_a_of_type_Int != 22) {
        break label1043;
      }
      localObject1 = localStructMsg.msg;
      paramafbb.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject2 = new SpannableString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131654097, new Object[] { ((structmsg.SystemMsg)localObject1).action_uin_nick.get() }));
      ((SpannableString)localObject2).setSpan(new ForegroundColorSpan(Color.parseColor("#00a5e0")), 6, ((structmsg.SystemMsg)localObject1).action_uin_nick.get().length() + 6, 33);
      paramafbb.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      paramafbb.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new afbg(this, (structmsg.SystemMsg)localObject1));
    }
    for (;;)
    {
      localObject1 = azlj.a(localStructMsg, localStructMsg.msg.msg_describe.get());
      if (localObject1 == null) {
        break label1296;
      }
      paramafbb.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      label551:
      if (paramafbb.jdField_a_of_type_Int != 80) {
        break label1353;
      }
      localObject1 = localStructMsg.msg.actions.get();
      paramafbb.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
      paramafbb.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)((List)localObject1).get(0)).name.get());
      paramafbb.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131689801);
      paramafbb.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839032);
      paramafbb.jdField_a_of_type_AndroidWidgetButton.setContentDescription(paramafbb.jdField_a_of_type_AndroidWidgetButton.getText() + "");
      paramafbb.jdField_a_of_type_AndroidWidgetButton.setTag(paramafbb);
      paramafbb.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      label679:
      if (!TextUtils.isEmpty(paramafbb.jdField_a_of_type_AndroidWidgetButton.getText())) {
        break label1665;
      }
      paramafbb.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      label701:
      if ((paramInt == 2) && (paramafbb.jdField_a_of_type_Int == 2) && (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(String.valueOf(localStructMsg.msg.group_code.get())) != null)) {
        arjb.a().b(String.valueOf(localStructMsg.msg.group_code.get()), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      paramafbb.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(paramafbb);
      paramafbb.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramafbb.jdField_a_of_type_AndroidWidgetImageView.setTag(paramafbb);
      paramafbb.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      b(paramafbb);
      return;
      paramafbb.jdField_b_of_type_JavaLangString = paramafbb.jdField_a_of_type_JavaLangString;
      break;
      label822:
      if (!TextUtils.isEmpty(localStructMsg.msg.msg_qna.get()))
      {
        localObject1 = localStructMsg.msg.msg_qna.get();
        break label258;
      }
      if (!TextUtils.isEmpty(localStructMsg.msg.msg_actor_describe.get()))
      {
        localObject1 = azlj.a(localStructMsg, localStructMsg.msg.msg_actor_describe.get());
        break label258;
      }
      if (!TextUtils.isEmpty(localStructMsg.msg.msg_additional_list.get()))
      {
        localObject1 = localStructMsg.msg.msg_additional_list.get();
        break label258;
      }
      if (!TextUtils.isEmpty(localStructMsg.msg.msg_additional.get()))
      {
        localObject1 = localStructMsg.msg.msg_additional.get();
        break label258;
      }
      if ((!TextUtils.isEmpty(localStructMsg.msg.msg_detail.get())) && (paramafbb.jdField_a_of_type_Int == 12))
      {
        localObject1 = localStructMsg.msg.msg_detail.get();
        break label258;
      }
      if (paramafbb.jdField_a_of_type_Int != 83) {
        break label258;
      }
      localObject1 = localStructMsg.msg.msg_detail.get();
      break label258;
      label1020:
      localObject2 = ajjy.a(2131641831);
      break label370;
      label1031:
      paramafbb.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      break label403;
      label1043:
      if ((paramafbb.jdField_a_of_type_Int == 2) && (localStructMsg.msg.msg_invite_extinfo.uint32_src_type.has()))
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
      paramafbb.jdField_c_of_type_AndroidWidgetTextView.setText(ajjy.a(2131641840) + (String)localObject1);
      paramafbb.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      break;
      Object localObject3 = (ajhh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((ajhh)localObject3).a(String.valueOf(localStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()));
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = ((DiscussionInfo)localObject3).discussionName;
        }
      }
      paramafbb.jdField_c_of_type_AndroidWidgetTextView.setText(ajjy.a(2131641829) + (String)localObject1);
      paramafbb.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      break;
      label1296:
      localObject1 = localStructMsg.msg.msg_additional.get();
      if ((localObject1 == null) || ("".equals(localObject1)))
      {
        paramafbb.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131630783));
        break label551;
      }
      paramafbb.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      break label551;
      label1353:
      if (paramInt == 1)
      {
        localObject1 = localStructMsg.msg.actions.get();
        paramafbb.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          if ((str == null) || ("".equals(str))) {
            if (((List)localObject1).size() > 1)
            {
              paramafbb.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)((List)localObject1).get(1)).name.get());
              paramafbb.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131689801);
              paramafbb.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839032);
            }
          }
          for (;;)
          {
            paramafbb.jdField_a_of_type_AndroidWidgetButton.setContentDescription(paramafbb.jdField_a_of_type_AndroidWidgetButton.getText() + "");
            paramafbb.jdField_a_of_type_AndroidWidgetButton.setTag(paramafbb);
            paramafbb.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
            break;
            paramafbb.jdField_a_of_type_AndroidWidgetButton.setText("");
            continue;
            paramafbb.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)((List)localObject1).get(0)).name.get());
            paramafbb.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131689800);
            paramafbb.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839031);
          }
        }
        paramafbb.jdField_a_of_type_AndroidWidgetButton.setText("");
        paramafbb.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
        break label679;
      }
      paramafbb.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
      paramafbb.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
      paramafbb.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131690321);
      paramafbb.jdField_a_of_type_AndroidWidgetButton.setText(localStructMsg.msg.msg_decided.get());
      localObject1 = (RelativeLayout.LayoutParams)paramafbb.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
      break label679;
      label1665:
      paramafbb.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      break label701;
    }
  }
  
  protected void a(Intent paramIntent, afaw paramafaw)
  {
    super.a(paramIntent, paramafaw);
    k();
    m();
    o();
    this.jdField_a_of_type_Arom = ((arom)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnScrollToTopListener(this);
    this.jdField_a_of_type_Bbms = new bbms(this.jdField_a_of_type_AndroidContentContext, a());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    if (afce.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) > 0) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(3);
    }
    afce.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    afbb localafbb = (afbb)paramView.getTag();
    if ((localafbb != null) && ((localafbb instanceof afbb)))
    {
      paramView = (ShaderAnimLayout)paramView.findViewById(2131312047);
      if (paramView != null) {
        break label38;
      }
    }
    label38:
    Button localButton;
    do
    {
      return;
      localButton = (Button)paramView.findViewById(2131312046);
    } while (localButton == null);
    paramSlideDetectListView.setDeleteAreaWidth(paramView.getLayoutParams().width);
    paramView.a();
    localButton.setTag(localafbb);
  }
  
  public boolean a(float paramFloat)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getChildCount() - this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getHeaderViewsCount() > 0)
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getChildAt(this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getChildCount() - 1);
      int[] arrayOfInt = new int[2];
      localView.getLocationOnScreen(arrayOfInt);
      int i = arrayOfInt[1];
      if (paramFloat > localView.getMeasuredHeight() + i) {
        return true;
      }
    }
    return false;
  }
  
  public void b(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    paramSlideDetectListView = (ShaderAnimLayout)paramView.findViewById(2131312047);
    if (paramSlideDetectListView != null)
    {
      paramSlideDetectListView.e();
      paramSlideDetectListView = (Button)paramSlideDetectListView.findViewById(2131312046);
      if (paramSlideDetectListView != null) {
        paramSlideDetectListView.setTag(null);
      }
    }
  }
  
  protected void c()
  {
    super.c();
    a(false);
  }
  
  protected void d()
  {
    super.d();
    this.jdField_c_of_type_Boolean = false;
    if ((this.jdField_a_of_type_Afaz != null) && (this.jdField_a_of_type_Afaz.getCount() > 0) && (this.jdField_e_of_type_Boolean))
    {
      this.jdField_a_of_type_Afaz.jdField_a_of_type_Int = axcz.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_Afaz.notifyDataSetChanged();
    }
    this.jdField_e_of_type_Boolean = true;
    t();
  }
  
  protected void e()
  {
    super.e();
  }
  
  protected void f()
  {
    super.f();
    this.jdField_a_of_type_Azwg.c();
    this.jdField_a_of_type_Azwg.a();
  }
  
  protected void g()
  {
    super.g();
    l();
    if (this.jdField_a_of_type_Afaz != null)
    {
      this.jdField_a_of_type_Afaz.a();
      this.jdField_a_of_type_Afaz = null;
    }
    afce.b();
    if ((this.jdField_a_of_type_Afaz != null) && (this.jdField_a_of_type_Afaz.getCount() > 0)) {
      s();
    }
    if (this.jdField_c_of_type_Boolean) {
      axcz.a().b();
    }
    this.jdField_a_of_type_Azwg.a(null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(getClass());
    if (this.jdField_a_of_type_Arom != null) {
      this.jdField_a_of_type_Arom.a(false);
    }
  }
  
  public void i()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_e_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void j()
  {
    s();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.u();
    axcz.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    this.jdField_a_of_type_JavaUtilList.clear();
    if (this.jdField_a_of_type_Afaz != null) {
      this.jdField_a_of_type_Afaz.a();
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1012);
  }
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if ((l - jdField_c_of_type_Long > 0L) && (l - jdField_c_of_type_Long < 800L)) {}
    Object localObject1;
    Object localObject2;
    int i;
    label251:
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
          }
        } while (!(paramView.getTag() instanceof afbb));
        localObject1 = (afbb)paramView.getTag();
      } while (localObject1 == null);
      localObject2 = ((afbb)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
      i = ((afbb)localObject1).jdField_a_of_type_Int;
      if (afce.a(i) == 0)
      {
        paramView = TroopInfoActivity.a(String.valueOf(((afbb)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()), 4);
        paramView.putInt("t_s_f", 1001);
        azlj.a(a(), paramView, 2);
        if ((i == 2) || (i == 10) || (i == 12))
        {
          i = 1;
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          localObject1 = ((afbb)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "";
          if (i == 0) {
            break label251;
          }
        }
        for (paramView = "0";; paramView = "1")
        {
          awqx.b((QQAppInterface)localObject2, "P_CliOper", "Grp_contacts", "", "notice", "see_data", 0, 0, (String)localObject1, paramView, "", "");
          return;
          i = 0;
          break;
        }
      }
    } while ((((afbb)localObject1).jdField_a_of_type_Int == 2) && (TroopInfo.isQidianPrivateTroop(((afbb)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint32_group_flagext3.get())));
    if (((afbb)localObject1).jdField_a_of_type_Int == 82)
    {
      paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, AccountDetailActivity.class);
      paramView.putExtra("uin", ((afbb)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "");
      paramView.putExtra("source", 112);
      a(paramView);
      return;
    }
    l = ((structmsg.StructMsg)localObject2).req_uin.get();
    switch (afce.a(i))
    {
    default: 
      paramView = String.valueOf(l);
      label409:
      if (((ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(paramView)) {
        paramView = new ProfileActivity.AllInOne(paramView, 1);
      }
      break;
    }
    for (;;)
    {
      l = ((structmsg.StructMsg)localObject2).msg.uint32_group_flagext3.get();
      boolean bool = TroopInfo.isQidianPrivateTroop(l);
      i = ((structmsg.StructMsg)localObject2).msg.group_msg_type.get();
      if (QLog.isColorLevel()) {
        QLog.d(".troop.qidian_private_troop", 2, "notification headView onClick: msgType=" + i + ", isQidianPrivateTroop=" + bool + ", flagExt3=" + l);
      }
      if ((bool) && (i == 2)) {
        break;
      }
      ProfileActivity.b(a(), paramView);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_contacts", "", "notice", "see_fromdata", 0, 0, ((afbb)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "", "3", "", "");
      return;
      paramView = ((afbb)localObject1).jdField_a_of_type_JavaLangString;
      break label409;
      paramView = String.valueOf(((afbb)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
      break label409;
      if ((((structmsg.StructMsg)localObject2).msg.group_msg_type.get() == 2) && (((structmsg.StructMsg)localObject2).msg.sub_type.get() == 3))
      {
        paramView = new ProfileActivity.AllInOne(paramView, 26);
        paramView.jdField_d_of_type_Int = 1;
      }
      else
      {
        paramView = new ProfileActivity.AllInOne(paramView, 24);
        azlj.a((structmsg.StructMsg)localObject2, paramView);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(".troop.qidian_private_troop", 2, "TroopSuspiciousFragment click");
    }
    azzx.a("Grp_contacts_news", "notice", "unnormal_clk", 0, 0, new String[0]);
    TroopSuspiciousFragment.a(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, paramString, paramBitmap);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_d_of_type_Int = (paramInt1 + paramInt2 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((this.jdField_a_of_type_Afaz != null) && (paramInt == 0) && (this.jdField_d_of_type_Int == this.jdField_a_of_type_Afaz.getCount())) {
      q();
    }
    this.jdField_c_of_type_Int = paramInt;
    if (paramInt != 0)
    {
      this.jdField_a_of_type_Azwg.a();
      this.jdField_a_of_type_Azwg.c();
    }
    while (!this.jdField_a_of_type_Azwg.a()) {
      return;
    }
    this.jdField_a_of_type_Azwg.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.NotificationView
 * JD-Core Version:    0.7.0.1
 */