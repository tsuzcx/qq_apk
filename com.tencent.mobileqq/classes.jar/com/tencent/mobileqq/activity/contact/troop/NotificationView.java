package com.tencent.mobileqq.activity.contact.troop;

import acmw;
import aiyp;
import ajdx;
import ajed;
import ajeg;
import ajeh;
import ajei;
import ajej;
import ajek;
import ajel;
import ajem;
import ajen;
import ajeo;
import ajfq;
import ajfr;
import ajhg;
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
import antp;
import anvk;
import anvx;
import anyz;
import aoce;
import aooy;
import awub;
import awzf;
import bdla;
import bdzy;
import bgiv;
import bhbu;
import bisl;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.Stranger;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.mobileqq.widget.SlideDetectListView.OnSlideListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.OnScrollListener;
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
  implements aiyp, View.OnClickListener, FaceDecoder.DecodeTaskCompletionListener, SlideDetectListView.OnSlideListener, AbsListView.OnScrollListener
{
  protected static int b;
  protected static long c;
  public final long a;
  public ajed a;
  public ajfr a;
  public Context a;
  protected View.OnClickListener a;
  protected View.OnTouchListener a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  anyz jdField_a_of_type_Anyz = new ajej(this);
  protected awzf a;
  public bisl a;
  protected FaceDecoder a;
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
    this.jdField_a_of_type_MqqOsMqqHandler = new ajeh(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ajei(this);
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new ajek(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new ajem(this);
    this.jdField_a_of_type_Ajfr = new ajeo(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(long paramLong, structmsg.StructMsg paramStructMsg)
  {
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("structMsg", paramStructMsg.toByteArray());
    bgiv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong, new ajen(this), localBundle);
  }
  
  private void a(ajeg paramajeg, String paramString, List<structmsg.SystemMsgAction> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      if ((paramString == null) || ("".equals(paramString))) {
        if (paramList.size() > 1)
        {
          paramajeg.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramList.get(1)).name.get());
          paramajeg.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755352);
          paramajeg.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839381);
        }
      }
      for (;;)
      {
        paramajeg.jdField_a_of_type_AndroidWidgetButton.setContentDescription(paramajeg.jdField_a_of_type_AndroidWidgetButton.getText() + "");
        paramajeg.jdField_a_of_type_AndroidWidgetButton.setTag(paramajeg);
        paramajeg.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        return;
        paramajeg.jdField_a_of_type_AndroidWidgetButton.setText("");
        continue;
        paramajeg.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramList.get(0)).name.get());
        paramajeg.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755351);
        paramajeg.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839380);
      }
    }
    paramajeg.jdField_a_of_type_AndroidWidgetButton.setText("");
    paramajeg.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
  }
  
  private void a(ajeg paramajeg, structmsg.StructMsg paramStructMsg)
  {
    if ((paramajeg == null) || (paramStructMsg == null)) {
      return;
    }
    if ((paramajeg.jdField_a_of_type_Int == 2) && (paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.has()))
    {
      String str1 = paramStructMsg.msg.action_uin_qq_nick.get().toStringUtf8();
      switch (paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.get())
      {
      default: 
        paramStructMsg = str1;
      }
      for (;;)
      {
        paramajeg.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg);
        return;
        paramStructMsg = paramStructMsg.msg.action_uin_nick.get();
        continue;
        Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        if (localObject == null) {
          break;
        }
        String str2 = String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get());
        String str3 = String.valueOf(paramStructMsg.msg.action_uin.get());
        paramStructMsg = ((TroopManager)localObject).d(str2);
        str1 = ContactUtils.getTroopNickName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str3, str2, paramStructMsg, true, null);
        paramStructMsg = str1;
        if (TextUtils.isEmpty(str1))
        {
          paramStructMsg = ((TroopManager)localObject).a(str2, str3);
          continue;
          localObject = (antp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
          if (localObject == null) {
            break;
          }
          paramStructMsg = ((antp)localObject).a(String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()), String.valueOf(paramStructMsg.msg.action_uin.get()));
          if (paramStructMsg == null) {
            break;
          }
          paramStructMsg = paramStructMsg.getDiscussionMemberName();
        }
      }
    }
    switch (ajfq.a(paramajeg.jdField_a_of_type_Int))
    {
    default: 
      paramajeg.jdField_a_of_type_AndroidWidgetTextView.setText(paramajeg.jdField_b_of_type_JavaLangString);
      return;
    case 0: 
      paramajeg.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg.msg.group_name.get());
      return;
    case 1: 
      paramajeg.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg.msg.action_uin_nick.get());
      return;
    }
    paramajeg.jdField_a_of_type_AndroidWidgetTextView.setText(paramajeg.jdField_b_of_type_JavaLangString);
  }
  
  private void a(ajeg paramajeg, structmsg.StructMsg paramStructMsg, int paramInt, String paramString)
  {
    if (paramajeg.jdField_a_of_type_Int == 80)
    {
      paramStructMsg = paramStructMsg.msg.actions.get();
      paramajeg.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
      paramajeg.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramStructMsg.get(0)).name.get());
      paramajeg.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755352);
      paramajeg.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839381);
      paramajeg.jdField_a_of_type_AndroidWidgetButton.setContentDescription(paramajeg.jdField_a_of_type_AndroidWidgetButton.getText() + "");
      paramajeg.jdField_a_of_type_AndroidWidgetButton.setTag(paramajeg);
      paramajeg.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    }
    while (TextUtils.isEmpty(paramajeg.jdField_a_of_type_AndroidWidgetButton.getText()))
    {
      paramajeg.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      return;
      if (paramInt == 1)
      {
        paramStructMsg = paramStructMsg.msg.actions.get();
        paramajeg.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
        a(paramajeg, paramString, paramStructMsg);
      }
      else
      {
        paramajeg.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
        paramajeg.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
        paramajeg.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755977);
        paramajeg.jdField_a_of_type_AndroidWidgetButton.setText(paramStructMsg.msg.msg_decided.get());
        paramStructMsg = (RelativeLayout.LayoutParams)paramajeg.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
      }
    }
    paramajeg.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
  }
  
  private void a(ajeg paramajeg, structmsg.StructMsg paramStructMsg, String paramString)
  {
    paramajeg.jdField_c_of_type_AndroidWidgetTextView.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755978);
    paramajeg.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#a6a6a6"));
    Object localObject;
    if (paramajeg.jdField_a_of_type_Int == 11)
    {
      localObject = paramStructMsg.msg.msg_additional.get();
      paramString = (String)localObject;
      if (((String)localObject).length() > 15) {
        paramString = ((String)localObject).subSequence(0, 15) + "...";
      }
    }
    for (;;)
    {
      localObject = paramString;
      if (paramStructMsg.msg.pic_url.has()) {
        if (TextUtils.isEmpty(paramString)) {
          break label358;
        }
      }
      label358:
      for (localObject = anvx.a(2131707087) + paramString;; localObject = anvx.a(2131707077))
      {
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label369;
        }
        paramajeg.jdField_c_of_type_AndroidWidgetTextView.setSingleLine(true);
        paramajeg.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        paramajeg.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
        localObject = new ArrayList();
        if ((paramajeg.jdField_a_of_type_Int == 1) || (paramajeg.jdField_a_of_type_Int == 22)) {
          ((List)localObject).add(paramString);
        }
        ((List)localObject).add(paramStructMsg.msg.msg_qna.get());
        ((List)localObject).add(paramStructMsg.msg.msg_actor_describe.get());
        ((List)localObject).add(paramStructMsg.msg.msg_additional_list.get());
        ((List)localObject).add(paramStructMsg.msg.msg_additional.get());
        if ((paramajeg.jdField_a_of_type_Int == 12) || (paramajeg.jdField_a_of_type_Int == 83)) {
          ((List)localObject).add(paramStructMsg.msg.msg_detail.get());
        }
        localObject = ((List)localObject).iterator();
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          paramString = (String)((Iterator)localObject).next();
        } while ((paramString == null) || (paramString.isEmpty()));
        break;
      }
      label369:
      paramajeg.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
      paramString = "";
    }
  }
  
  private void a(XListView paramXListView, String paramString, Bitmap paramBitmap)
  {
    ajeg localajeg;
    String str;
    if (this.jdField_c_of_type_Int == 0)
    {
      int j = paramXListView.getChildCount();
      int i = 0;
      while (i < j)
      {
        localajeg = (ajeg)paramXListView.getChildAt(i).getTag();
        if (localajeg == null) {
          i += 1;
        } else {
          switch (ajfq.a(localajeg.jdField_a_of_type_Int))
          {
          default: 
            str = String.valueOf(localajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
          }
        }
      }
    }
    while ((localajeg != null) && (paramString.equals(str)))
    {
      localajeg.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      return;
      str = localajeg.jdField_a_of_type_JavaLangString;
      continue;
      str = String.valueOf(localajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
    }
  }
  
  private void a(structmsg.StructMsg paramStructMsg, long paramLong)
  {
    if (paramStructMsg != null)
    {
      String str = ((structmsg.StructMsg)paramStructMsg.get()).msg_seq.get() + "_" + ((structmsg.StructMsg)paramStructMsg.get()).msg_type.get();
      bdzy.a().a(str, (structmsg.StructMsg)paramStructMsg.get());
      bdzy.a().b(str);
      bdzy.a().a(paramLong);
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
        break label216;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().a(i, l1, l2, j, k, m, n, (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)localList.get(paramInt)).action_info.get(), paramInt);
    }
    label216:
    for (bool = true;; bool = false)
    {
      if ((k == 116) && (m == 0)) {
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_discuss", "", "verify_msg", "Clk_agree", 0, 0, String.valueOf(paramStructMsg.msg.group_code.get()), "", "", "");
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
  
  private void b(ajeg paramajeg)
  {
    int i = 1;
    if (paramajeg == null) {
      return;
    }
    Object localObject;
    String str;
    switch (ajfq.a(paramajeg.jdField_a_of_type_Int))
    {
    default: 
      localObject = String.valueOf(paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
      i = 4;
      str = paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_name.get() + this.jdField_a_of_type_AndroidContentContext.getString(2131696246);
    }
    for (;;)
    {
      localObject = ajfq.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder, (String)localObject, i);
      paramajeg.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(str);
      paramajeg.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      return;
      localObject = paramajeg.jdField_a_of_type_JavaLangString;
      str = paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get() + this.jdField_a_of_type_AndroidContentContext.getString(2131696245);
      continue;
      localObject = String.valueOf(paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
      str = paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.get() + this.jdField_a_of_type_AndroidContentContext.getString(2131696244);
    }
  }
  
  private void b(ajeg paramajeg, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NotificationView", 2, "jumpToTroopRequestActivity!" + paramajeg.jdField_a_of_type_Long + ": dealMsgType = " + paramInt);
    }
    Intent localIntent = new Intent(a(), TroopRequestActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putLong("troopMsgId", paramajeg.jdField_a_of_type_Long);
    localBundle.putInt("mTroopMsgType", paramajeg.jdField_a_of_type_Int);
    localBundle.putString("mTroopCode", String.valueOf(paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()));
    localBundle.putString("troopmanagerUin", String.valueOf(paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get()));
    localBundle.putString("troopsMsg", paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
    if (paramajeg.jdField_b_of_type_Int < this.jdField_a_of_type_Ajed.jdField_a_of_type_Int) {}
    for (boolean bool = true;; bool = false)
    {
      localBundle.putBoolean("is_unread", bool);
      localBundle.putString("troopRequestUin", String.valueOf(paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
      localBundle.putString("troopsummary", paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get());
      localBundle.putLong("infotime", paramajeg.jdField_b_of_type_Long);
      if ((a() instanceof TroopActivity)) {
        localBundle.putBoolean("troop_invitee_is_friend", a((ArrayList)((TroopActivity)a()).jdField_a_of_type_JavaUtilList, String.valueOf(paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get())));
      }
      if (paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() != 83) {
        localIntent.putExtra("troopMsgDealInfo", paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_detail.get());
      }
      a((structmsg.StructMsg)paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), paramajeg.jdField_c_of_type_Long);
      localBundle.putInt("t_s_f", 1001);
      localIntent.putExtras(localBundle);
      a(localIntent);
      return;
    }
  }
  
  private void b(ajeg paramajeg, structmsg.StructMsg paramStructMsg, String paramString)
  {
    antp localantp = (antp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
    String str = paramString;
    if (localantp != null)
    {
      paramStructMsg = localantp.a(String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()));
      str = paramString;
      if (paramStructMsg != null) {
        str = paramStructMsg.discussionName;
      }
    }
    paramajeg.jdField_c_of_type_AndroidWidgetTextView.setText(anvx.a(2131707075) + str);
    paramajeg.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  private void c(ajeg paramajeg, structmsg.StructMsg paramStructMsg, String paramString)
  {
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localTroopManager != null) {
      paramString = localTroopManager.a(String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()));
    }
    paramajeg.jdField_c_of_type_AndroidWidgetTextView.setText(anvx.a(2131707086) + paramString);
    paramajeg.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  private void k()
  {
    a(this.jdField_a_of_type_Anyz);
  }
  
  private void l()
  {
    b(this.jdField_a_of_type_Anyz);
  }
  
  private void m()
  {
    a(2131559956);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131373821));
    this.jdField_e_of_type_AndroidViewView = findViewById(2131373812);
    n();
    p();
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(this);
  }
  
  private void n()
  {
    if (this.g == null) {
      this.g = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561545, null);
    }
    this.h = this.g.findViewById(2131378315);
    this.h.setOnClickListener(this);
    if (ThemeUtil.isDefaultTheme()) {
      this.h.setBackgroundResource(2130839458);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.g.findViewById(2131378316));
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView != null)
      {
        AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
        this.g.setLayoutParams(localLayoutParams);
        this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.addHeaderView(this.g);
      }
      int i = bdzy.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (i <= 0) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(i + "");
      return;
      this.h.setBackgroundResource(2130839455);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
  }
  
  private void o()
  {
    int i = ((aoce)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.RECOMMEND_TROOP_MANAGER)).jdField_c_of_type_Int;
    this.jdField_a_of_type_Ajed = new ajed(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, i, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView);
    this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getMsgList(AppConstants.TROOP_SYSTEM_MSG_UIN, 0);
    TroopNotifyAndRecommendView.setAndCheckNotifyFollowSeq(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ArrayList localArrayList = new ArrayList();
    i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localArrayList.add(this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - i - 1));
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilList = localArrayList;
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_Ajed);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setDividerHeight(1);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0) && (!(this.jdField_a_of_type_JavaUtilList.get(0) instanceof MessageForSystemMsg)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("NotificationView", 2, "initListData error");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.clearGroupSystemMsgHistory();
      this.jdField_a_of_type_Ajed.a(null);
      return;
    }
    this.jdField_a_of_type_Ajed.a(this.jdField_a_of_type_JavaUtilList);
    i();
  }
  
  private void p()
  {
    if (this.f == null) {
      this.f = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561542, null);
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
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692125), 0).b(a());
          return;
        }
      } while ((this.jdField_a_of_type_Awzf != null) && (this.jdField_a_of_type_Awzf.a()));
      this.jdField_d_of_type_Boolean = true;
      this.f.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().h();
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
    if ((ajhg.a()) && (ajhg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("NotificationView", 2, "needRefresh =" + bool);
      }
      if (!bool) {
        break label187;
      }
      if (this.h != null) {
        this.h.setVisibility(0);
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        i = bdzy.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (QLog.isColorLevel()) {
          QLog.d("NotificationView", 2, "refreshTroopSuspiciousDisplay num =" + i);
        }
        if (i <= 0) {
          break label175;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(i + "");
      }
      bhbu.a("Grp_contacts_news", "notice", "unnormal_exp", 0, 0, new String[0]);
    }
    label175:
    label187:
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
    return getResources().getDimensionPixelSize(2131299080);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().d(AppConstants.TROOP_NOTIFICATION_UIN, 9000, 0 - bdzy.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    bdzy.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    this.jdField_c_of_type_Boolean = false;
    if ((this.jdField_a_of_type_Ajed != null) && (this.jdField_a_of_type_Ajed.getCount() > 0))
    {
      i();
      this.jdField_a_of_type_Ajed.notifyDataSetChanged();
      s();
    }
    a(false);
  }
  
  public void a(ajeg paramajeg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NotificationView", 2, "handleGroupSystemMsg! start " + paramajeg.jdField_a_of_type_Long);
    }
    b(paramajeg, 998);
    Object localObject = paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_info.msg_alert.get();
    String str4 = paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "";
    String str2;
    int i;
    label140:
    String str1;
    if (paramajeg.jdField_b_of_type_Int < this.jdField_a_of_type_Ajed.jdField_a_of_type_Int)
    {
      str2 = "1";
      i = paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_inviter_role.get();
      if ((i != 2) && (i != 3)) {
        break label304;
      }
      i = 0;
      switch (paramajeg.jdField_a_of_type_Int)
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
        paramajeg = "";
        localObject = "";
        str1 = "";
      }
    }
    for (;;)
    {
      bhbu.a("Grp_contacts_news", "notice", str1, 3, 0, new String[] { str4, str2, localObject, paramajeg });
      return;
      str2 = "0";
      break;
      label304:
      i = 1;
      break label140;
      str1 = "enter_askjoin";
      if ((localObject == null) || ("".equals(localObject))) {}
      for (localObject = "1";; localObject = "0")
      {
        if (paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() != 1) {
          break label366;
        }
        paramajeg = "0";
        break;
      }
      label366:
      long l = paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actor_uin.get();
      if ((l != 0L) && (!(l + "").equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {}
      for (paramajeg = "2";; paramajeg = "1") {
        break;
      }
      paramajeg = "";
      localObject = "";
      str1 = "refuseask_page";
      continue;
      if (paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() == 1) {}
      for (paramajeg = "0";; paramajeg = "1")
      {
        localObject = "";
        str1 = "enter_invite";
        break;
      }
      if (i != 0) {}
      String str3;
      for (paramajeg = "0";; paramajeg = "1")
      {
        str1 = "refuseinvite_page";
        str3 = "";
        localObject = paramajeg;
        paramajeg = str3;
        break;
      }
      if (i != 0) {}
      for (paramajeg = "0";; paramajeg = "1")
      {
        str1 = "refuseagree_page";
        str3 = "";
        localObject = paramajeg;
        paramajeg = str3;
        break;
      }
      paramajeg = "";
      localObject = "";
      str1 = "quit_page";
      continue;
      str1 = "byquit_page";
      paramajeg = "";
      localObject = "0";
      continue;
      str1 = "byquit_page";
      paramajeg = "";
      localObject = "1";
      continue;
      if ((paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "").equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {}
      for (paramajeg = "0";; paramajeg = "1")
      {
        str1 = "set_admin_page";
        str3 = "";
        localObject = paramajeg;
        paramajeg = str3;
        break;
      }
      str1 = "un_admin_page";
      paramajeg = "";
      localObject = "0";
      continue;
      str1 = "un_admin_page";
      paramajeg = "";
      localObject = "1";
    }
  }
  
  public void a(ajeg paramajeg, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NotificationView", 2, "bindTroopSystemMsgView! start " + paramajeg.jdField_a_of_type_Long);
    }
    structmsg.StructMsg localStructMsg = paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
    paramajeg.jdField_a_of_type_Long = paramInt;
    paramajeg.jdField_a_of_type_JavaLangString = (localStructMsg.req_uin.get() + "");
    paramajeg.jdField_a_of_type_Int = localStructMsg.msg.group_msg_type.get();
    paramInt = localStructMsg.msg.sub_type.get();
    paramajeg.jdField_b_of_type_Long = localStructMsg.msg_time.get();
    paramajeg.jdField_b_of_type_JavaLangString = localStructMsg.msg.req_uin_nick.get();
    String str;
    Object localObject;
    if ((paramajeg.jdField_b_of_type_JavaLangString != null) && (!paramajeg.jdField_b_of_type_JavaLangString.equals("")))
    {
      a(paramajeg, localStructMsg);
      paramajeg.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      str = localStructMsg.msg.group_info.msg_alert.get();
      a(paramajeg, localStructMsg, str);
      if (paramajeg.jdField_a_of_type_Int != 22) {
        break label464;
      }
      localObject = localStructMsg.msg;
      paramajeg.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      SpannableString localSpannableString = new SpannableString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131719151, new Object[] { ((structmsg.SystemMsg)localObject).action_uin_nick.get() }));
      localSpannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#00a5e0")), 6, ((structmsg.SystemMsg)localObject).action_uin_nick.get().length() + 6, 33);
      paramajeg.jdField_c_of_type_AndroidWidgetTextView.setText(localSpannableString);
      paramajeg.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new ajel(this, (structmsg.SystemMsg)localObject));
      label305:
      localObject = TroopUtils.getMsgInfo(localStructMsg, localStructMsg.msg.msg_describe.get());
      if (localObject == null) {
        break label553;
      }
      paramajeg.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    }
    for (;;)
    {
      a(paramajeg, localStructMsg, paramInt, str);
      if ((paramInt == 2) && (paramajeg.jdField_a_of_type_Int == 2) && (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(String.valueOf(localStructMsg.msg.group_code.get())) != null)) {
        awub.a().b(String.valueOf(localStructMsg.msg.group_code.get()), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      paramajeg.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(paramajeg);
      paramajeg.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramajeg.jdField_a_of_type_AndroidWidgetImageView.setTag(paramajeg);
      paramajeg.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      b(paramajeg);
      return;
      paramajeg.jdField_b_of_type_JavaLangString = paramajeg.jdField_a_of_type_JavaLangString;
      break;
      label464:
      if ((paramajeg.jdField_a_of_type_Int != 2) || (!localStructMsg.msg.msg_invite_extinfo.uint32_src_type.has())) {
        break label305;
      }
      switch (localStructMsg.msg.msg_invite_extinfo.uint32_src_type.get())
      {
      case 0: 
      default: 
        break;
      case 1: 
        c(paramajeg, localStructMsg, "");
        break;
      case 2: 
        b(paramajeg, localStructMsg, "");
        break;
        label553:
        localObject = localStructMsg.msg.msg_additional.get();
        if ((localObject == null) || ("".equals(localObject))) {
          paramajeg.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131695923));
        } else {
          paramajeg.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        }
        break;
      }
    }
  }
  
  protected void a(Intent paramIntent, ajdx paramajdx)
  {
    super.a(paramIntent, paramajdx);
    k();
    m();
    o();
    this.jdField_a_of_type_Awzf = ((awzf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOPINFO_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnScrollToTopListener(this);
    this.jdField_a_of_type_Bisl = new bisl(this.jdField_a_of_type_AndroidContentContext, a());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    if (ajfq.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) > 0) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().a(3);
    }
    ajfq.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
  
  protected void c()
  {
    super.c();
    a(false);
  }
  
  protected void d()
  {
    super.d();
    this.jdField_c_of_type_Boolean = false;
    if ((this.jdField_a_of_type_Ajed != null) && (this.jdField_a_of_type_Ajed.getCount() > 0) && (this.jdField_e_of_type_Boolean))
    {
      this.jdField_a_of_type_Ajed.jdField_a_of_type_Int = bdzy.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_Ajed.notifyDataSetChanged();
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
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.pause();
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.cancelPendingRequests();
  }
  
  protected void g()
  {
    super.g();
    l();
    if (this.jdField_a_of_type_Ajed != null)
    {
      this.jdField_a_of_type_Ajed.a();
      this.jdField_a_of_type_Ajed = null;
    }
    ajfq.b();
    if ((this.jdField_a_of_type_Ajed != null) && (this.jdField_a_of_type_Ajed.getCount() > 0)) {
      s();
    }
    if (this.jdField_c_of_type_Boolean) {
      bdzy.a().b();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(getClass());
    if (this.jdField_a_of_type_Awzf != null) {
      this.jdField_a_of_type_Awzf.a(false);
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.clearGroupSystemMsg();
    bdzy.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    this.jdField_a_of_type_JavaUtilList.clear();
    if (this.jdField_a_of_type_Ajed != null) {
      this.jdField_a_of_type_Ajed.a();
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1012);
  }
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if ((l - jdField_c_of_type_Long > 0L) && (l - jdField_c_of_type_Long < 800L)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      jdField_c_of_type_Long = l;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131373803: 
        if ((paramView.getTag() instanceof ajeg))
        {
          Object localObject2 = (ajeg)paramView.getTag();
          if (localObject2 != null)
          {
            Object localObject3 = ((ajeg)localObject2).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
            int i = ((ajeg)localObject2).jdField_a_of_type_Int;
            Object localObject1;
            if (ajfq.a(i) == 0)
            {
              localObject1 = TroopInfoActivity.a(String.valueOf(((ajeg)localObject2).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()), 4);
              ((Bundle)localObject1).putInt("t_s_f", 1001);
              TroopUtils.openTroopInfoActivity(a(), (Bundle)localObject1, 2);
              if ((i == 2) || (i == 10) || (i == 12))
              {
                i = 1;
                localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                localObject2 = ((ajeg)localObject2).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "";
                if (i == 0) {
                  break label264;
                }
              }
              for (localObject1 = "0";; localObject1 = "1")
              {
                bdla.b((QQAppInterface)localObject3, "P_CliOper", "Grp_contacts", "", "notice", "see_data", 0, 0, (String)localObject2, (String)localObject1, "", "");
                break;
                i = 0;
                break label178;
              }
            }
            if ((((ajeg)localObject2).jdField_a_of_type_Int != 2) || (!TroopInfo.isQidianPrivateTroop(((ajeg)localObject2).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint32_group_flagext3.get()))) {
              if (((ajeg)localObject2).jdField_a_of_type_Int == 82)
              {
                localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, AccountDetailActivity.class);
                ((Intent)localObject1).putExtra("uin", ((ajeg)localObject2).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "");
                ((Intent)localObject1).putExtra("source", 112);
                a((Intent)localObject1);
              }
              else
              {
                l = ((structmsg.StructMsg)localObject3).req_uin.get();
                switch (ajfq.a(i))
                {
                default: 
                  localObject1 = String.valueOf(l);
                  if (((anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b((String)localObject1)) {
                    localObject1 = new ProfileActivity.AllInOne((String)localObject1, 1);
                  }
                  break;
                }
                for (;;)
                {
                  l = ((structmsg.StructMsg)localObject3).msg.uint32_group_flagext3.get();
                  boolean bool = TroopInfo.isQidianPrivateTroop(l);
                  i = ((structmsg.StructMsg)localObject3).msg.group_msg_type.get();
                  if (QLog.isColorLevel()) {
                    QLog.d(".troop.qidian_private_troop", 2, "notification headView onClick: msgType=" + i + ", isQidianPrivateTroop=" + bool + ", flagExt3=" + l);
                  }
                  if ((bool) && (i == 2)) {
                    break;
                  }
                  ProfileActivity.b(a(), (ProfileActivity.AllInOne)localObject1);
                  bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_contacts", "", "notice", "see_fromdata", 0, 0, ((ajeg)localObject2).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get() + "", "3", "", "");
                  break;
                  localObject1 = ((ajeg)localObject2).jdField_a_of_type_JavaLangString;
                  break label430;
                  localObject1 = String.valueOf(((ajeg)localObject2).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
                  break label430;
                  if ((((structmsg.StructMsg)localObject3).msg.group_msg_type.get() == 2) && (((structmsg.StructMsg)localObject3).msg.sub_type.get() == 3))
                  {
                    localObject1 = new ProfileActivity.AllInOne((String)localObject1, 26);
                    ((ProfileActivity.AllInOne)localObject1).jdField_d_of_type_Int = 1;
                  }
                  else
                  {
                    localObject1 = new ProfileActivity.AllInOne((String)localObject1, 24);
                    TroopUtils.prepareTroopNotifyData((structmsg.StructMsg)localObject3, (ProfileActivity.AllInOne)localObject1);
                  }
                }
              }
            }
          }
        }
        break;
      case 2131378315: 
        label178:
        if (QLog.isColorLevel()) {
          QLog.d(".troop.qidian_private_troop", 2, "TroopSuspiciousFragment click");
        }
        label264:
        label430:
        bhbu.a("Grp_contacts_news", "notice", "unnormal_clk", 0, 0, new String[0]);
        TroopSuspiciousFragment.a(this.jdField_a_of_type_AndroidContentContext);
      }
    }
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
    if ((this.jdField_a_of_type_Ajed != null) && (paramInt == 0) && (this.jdField_d_of_type_Int == this.jdField_a_of_type_Ajed.getCount())) {
      q();
    }
    this.jdField_c_of_type_Int = paramInt;
    if (paramInt != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.cancelPendingRequests();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.pause();
    }
    while (!this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.resume();
  }
  
  public void onSlideCancelled(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    paramSlideDetectListView = (ShaderAnimLayout)paramView.findViewById(2131379575);
    if (paramSlideDetectListView != null)
    {
      paramSlideDetectListView.hide();
      paramSlideDetectListView = (Button)paramSlideDetectListView.findViewById(2131379574);
      if (paramSlideDetectListView != null) {
        paramSlideDetectListView.setTag(null);
      }
    }
  }
  
  public void onSlideStarted(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    ajeg localajeg = (ajeg)paramView.getTag();
    if ((localajeg != null) && ((localajeg instanceof ajeg)))
    {
      paramView = (ShaderAnimLayout)paramView.findViewById(2131379575);
      if (paramView != null) {
        break label38;
      }
    }
    label38:
    Button localButton;
    do
    {
      return;
      localButton = (Button)paramView.findViewById(2131379574);
    } while (localButton == null);
    paramSlideDetectListView.setDeleteAreaWidth(paramView.getLayoutParams().width);
    paramView.show();
    localButton.setTag(localajeg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.NotificationView
 * JD-Core Version:    0.7.0.1
 */