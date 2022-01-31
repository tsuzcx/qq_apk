package com.tencent.mobileqq.activity.contact.troop;

import ahkp;
import ahkz;
import ahpe;
import ahpp;
import ahqa;
import ahqb;
import ahqc;
import ahqd;
import ahqe;
import ahqf;
import ahqg;
import ahqh;
import ahqi;
import ahqj;
import ahqk;
import ahql;
import alof;
import alrk;
import alud;
import alwx;
import amlp;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager.BadTokenException;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import auao;
import auga;
import azqs;
import bafj;
import bcpx;
import bdbb;
import bdbc;
import bdgc;
import bdin;
import bdoo;
import bety;
import bhuf;
import bhus;
import com.tencent.biz.qqstory.widget.OverScrollRecyclerView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.Stranger;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
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

public class TroopSuspiciousFragment
  extends IphoneTitleBarFragment
  implements bdbc
{
  public int a;
  private ahkp jdField_a_of_type_Ahkp;
  alwx jdField_a_of_type_Alwx = new ahqk(this);
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ahqh(this);
  protected auga a;
  public bdbb a;
  private bety jdField_a_of_type_Bety;
  private OverScrollRecyclerView jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView;
  public BaseActivity a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public List<MessageRecord> a;
  public MqqHandler a;
  public boolean a;
  private int b;
  protected View.OnClickListener b;
  private int c;
  
  public TroopSuspiciousFragment()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new ahqi(this);
    this.jdField_a_of_type_MqqOsMqqHandler = new ahqb(this);
  }
  
  private void a(ahkz paramahkz, MessageRecord paramMessageRecord, int paramInt)
  {
    ahpe localahpe = (ahpe)paramahkz;
    if ((paramMessageRecord == null) || (!(paramMessageRecord instanceof MessageForSystemMsg))) {}
    int i;
    do
    {
      return;
      localahpe.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = ((MessageForSystemMsg)paramMessageRecord).getSystemMsg();
      localahpe.jdField_c_of_type_Long = paramMessageRecord.uniseq;
      i = 2;
      if (paramMessageRecord != null) {
        i = ((MessageForSystemMsg)paramMessageRecord).getSystemMsg().msg_type.get();
      }
    } while (i != 2);
    structmsg.StructMsg localStructMsg;
    label206:
    String str;
    label314:
    Object localObject1;
    if (paramInt < this.c)
    {
      ahql.a(paramahkz.a(), true);
      localStructMsg = localahpe.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
      localahpe.jdField_a_of_type_Long = paramInt;
      localahpe.jdField_a_of_type_JavaLangString = (localStructMsg.req_uin.get() + "");
      localahpe.jdField_a_of_type_Int = localStructMsg.msg.group_msg_type.get();
      paramInt = localStructMsg.msg.sub_type.get();
      localahpe.jdField_b_of_type_Long = localStructMsg.msg_time.get();
      localahpe.jdField_b_of_type_JavaLangString = localStructMsg.msg.req_uin_nick.get();
      if ((localahpe.jdField_b_of_type_JavaLangString == null) || (localahpe.jdField_b_of_type_JavaLangString.equals(""))) {
        break label902;
      }
      a(localahpe, localStructMsg);
      localahpe.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      str = localStructMsg.msg.group_info.msg_alert.get();
      paramMessageRecord = "";
      localahpe.jdField_c_of_type_AndroidWidgetTextView.setTextAppearance(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131755952);
      localahpe.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#a6a6a6"));
      if ((TextUtils.isEmpty(str)) || ((localahpe.jdField_a_of_type_Int != 1) && (localahpe.jdField_a_of_type_Int != 22))) {
        break label915;
      }
      localahpe.jdField_c_of_type_AndroidWidgetTextView.setTextAppearance(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131755953);
      paramMessageRecord = str;
      if (localahpe.jdField_a_of_type_Int == 11)
      {
        localObject1 = localStructMsg.msg.msg_additional.get();
        paramMessageRecord = (MessageRecord)localObject1;
        if (((String)localObject1).length() > 15) {
          paramMessageRecord = ((String)localObject1).subSequence(0, 15) + "...";
        }
      }
      if (localStructMsg.msg.pic_url.has())
      {
        if (TextUtils.isEmpty(paramMessageRecord)) {
          break label1115;
        }
        new StringBuilder().append(alud.a(2131708021)).append(paramMessageRecord).toString();
      }
      label421:
      paramMessageRecord = "";
      if (localStructMsg.msg.bytes_warning_tips.get() != null) {
        paramMessageRecord = localStructMsg.msg.bytes_warning_tips.get().toStringUtf8();
      }
      if (!TextUtils.isEmpty(paramMessageRecord)) {
        break label1125;
      }
      localahpe.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      label470:
      if (localahpe.jdField_a_of_type_Int != 22) {
        break label1204;
      }
      paramMessageRecord = localStructMsg.msg;
      localahpe.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject1 = new SpannableString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131720544, new Object[] { paramMessageRecord.action_uin_nick.get() }));
      ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(Color.parseColor("#00a5e0")), 6, paramMessageRecord.action_uin_nick.get().length() + 6, 33);
      localahpe.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      localahpe.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new ahqg(this, paramMessageRecord));
    }
    for (;;)
    {
      paramMessageRecord = bcpx.a(localStructMsg, localStructMsg.msg.msg_describe.get());
      if (paramMessageRecord == null) {
        break label1464;
      }
      localahpe.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageRecord);
      label623:
      if (localahpe.jdField_a_of_type_Int != 80) {
        break label1522;
      }
      paramMessageRecord = localStructMsg.msg.actions.get();
      localahpe.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
      localahpe.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramMessageRecord.get(0)).name.get());
      localahpe.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131755344);
      localahpe.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839142);
      localahpe.jdField_a_of_type_AndroidWidgetButton.setContentDescription(localahpe.jdField_a_of_type_AndroidWidgetButton.getText() + "");
      localahpe.jdField_a_of_type_AndroidWidgetButton.setTag(localahpe);
      localahpe.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      label760:
      if (!TextUtils.isEmpty(localahpe.jdField_a_of_type_AndroidWidgetButton.getText())) {
        break label1849;
      }
      localahpe.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      label784:
      if ((paramInt == 2) && (localahpe.jdField_a_of_type_Int == 2) && (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(String.valueOf(localStructMsg.msg.group_code.get())) != null)) {
        auao.a().b(String.valueOf(localStructMsg.msg.group_code.get()), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      localahpe.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(paramahkz);
      localahpe.jdField_a_of_type_AndroidWidgetImageView.setTag(paramahkz);
      localahpe.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      b(localahpe);
      return;
      ahql.a(paramahkz.a(), false);
      break;
      label902:
      localahpe.jdField_b_of_type_JavaLangString = localahpe.jdField_a_of_type_JavaLangString;
      break label206;
      label915:
      if (!TextUtils.isEmpty(localStructMsg.msg.msg_qna.get()))
      {
        paramMessageRecord = localStructMsg.msg.msg_qna.get();
        break label314;
      }
      if (!TextUtils.isEmpty(localStructMsg.msg.msg_actor_describe.get()))
      {
        paramMessageRecord = bcpx.a(localStructMsg, localStructMsg.msg.msg_actor_describe.get());
        break label314;
      }
      if (!TextUtils.isEmpty(localStructMsg.msg.msg_additional_list.get()))
      {
        paramMessageRecord = localStructMsg.msg.msg_additional_list.get();
        break label314;
      }
      if (!TextUtils.isEmpty(localStructMsg.msg.msg_additional.get()))
      {
        paramMessageRecord = localStructMsg.msg.msg_additional.get();
        break label314;
      }
      if ((!TextUtils.isEmpty(localStructMsg.msg.msg_detail.get())) && (localahpe.jdField_a_of_type_Int == 12))
      {
        paramMessageRecord = localStructMsg.msg.msg_detail.get();
        break label314;
      }
      if (localahpe.jdField_a_of_type_Int != 83) {
        break label314;
      }
      paramMessageRecord = localStructMsg.msg.msg_detail.get();
      break label314;
      label1115:
      alud.a(2131708011);
      break label421;
      label1125:
      localahpe.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localahpe.jdField_c_of_type_AndroidWidgetTextView.setText(paramMessageRecord);
      paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130847336);
      paramMessageRecord.setBounds(0, 0, bdoo.a(16.0F), bdoo.a(16.0F));
      localahpe.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(bdoo.a(5.0F));
      localahpe.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables(paramMessageRecord, null, null, null);
      break label470;
      label1204:
      if ((localahpe.jdField_a_of_type_Int == 2) && (localStructMsg.msg.msg_invite_extinfo.uint32_src_type.has()))
      {
        localObject1 = "";
        switch (localStructMsg.msg.msg_invite_extinfo.uint32_src_type.get())
        {
        }
      }
    }
    paramMessageRecord = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    if (paramMessageRecord != null) {}
    for (paramMessageRecord = paramMessageRecord.a(String.valueOf(localStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()));; paramMessageRecord = "")
    {
      localahpe.jdField_c_of_type_AndroidWidgetTextView.setText(alud.a(2131708020) + paramMessageRecord);
      localahpe.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      break;
      Object localObject2 = (alrk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53);
      paramMessageRecord = (MessageRecord)localObject1;
      if (localObject2 != null)
      {
        localObject2 = ((alrk)localObject2).a(String.valueOf(localStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()));
        paramMessageRecord = (MessageRecord)localObject1;
        if (localObject2 != null) {
          paramMessageRecord = ((DiscussionInfo)localObject2).discussionName;
        }
      }
      localahpe.jdField_c_of_type_AndroidWidgetTextView.setText(alud.a(2131708009) + paramMessageRecord);
      localahpe.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      break;
      label1464:
      paramMessageRecord = localStructMsg.msg.msg_additional.get();
      if ((paramMessageRecord == null) || ("".equals(paramMessageRecord)))
      {
        localahpe.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131696664));
        break label623;
      }
      localahpe.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageRecord);
      break label623;
      label1522:
      if (paramInt == 1)
      {
        paramMessageRecord = localStructMsg.msg.actions.get();
        localahpe.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
        if ((paramMessageRecord != null) && (paramMessageRecord.size() > 0))
        {
          if ((str == null) || ("".equals(str))) {
            if (paramMessageRecord.size() > 1)
            {
              localahpe.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramMessageRecord.get(1)).name.get());
              localahpe.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131755344);
              localahpe.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839142);
            }
          }
          for (;;)
          {
            localahpe.jdField_a_of_type_AndroidWidgetButton.setContentDescription(localahpe.jdField_a_of_type_AndroidWidgetButton.getText() + "");
            localahpe.jdField_a_of_type_AndroidWidgetButton.setTag(paramahkz);
            localahpe.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
            break;
            localahpe.jdField_a_of_type_AndroidWidgetButton.setText("");
            continue;
            localahpe.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramMessageRecord.get(0)).name.get());
            localahpe.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131755343);
            localahpe.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839141);
          }
        }
        localahpe.jdField_a_of_type_AndroidWidgetButton.setText("");
        localahpe.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
        break label760;
      }
      localahpe.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
      localahpe.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
      localahpe.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131755951);
      localahpe.jdField_a_of_type_AndroidWidgetButton.setText(localStructMsg.msg.msg_decided.get());
      paramMessageRecord = (RelativeLayout.LayoutParams)localahpe.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
      break label760;
      label1849:
      localahpe.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      break label784;
    }
  }
  
  private void a(ahpe paramahpe)
  {
    if (paramahpe == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopSuspiciousFragment", 2, "jumpToTroopRequestActivity!" + paramahpe.jdField_a_of_type_Long);
    }
    ahql.a(paramahpe.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, "unnormal_edit");
    Intent localIntent = new Intent(getActivity(), TroopRequestActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putLong("troopMsgId", paramahpe.jdField_a_of_type_Long);
    localBundle.putInt("mTroopMsgType", paramahpe.jdField_a_of_type_Int);
    localBundle.putString("mTroopCode", String.valueOf(paramahpe.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()));
    localBundle.putString("troopmanagerUin", String.valueOf(paramahpe.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get()));
    localBundle.putString("troopsMsg", paramahpe.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
    int i = bafj.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (paramahpe.jdField_b_of_type_Int < i) {}
    for (boolean bool = true;; bool = false)
    {
      localBundle.putBoolean("is_unread", bool);
      localBundle.putString("troopRequestUin", String.valueOf(paramahpe.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
      localBundle.putString("troopsummary", paramahpe.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get());
      localBundle.putLong("infotime", paramahpe.jdField_b_of_type_Long);
      if ((getActivity() instanceof TroopActivity)) {
        localBundle.putBoolean("troop_invitee_is_friend", a((ArrayList)((TroopActivity)getActivity()).jdField_a_of_type_JavaUtilList, String.valueOf(paramahpe.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get())));
      }
      if (paramahpe.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() != 83) {
        localIntent.putExtra("troopMsgDealInfo", paramahpe.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_detail.get());
      }
      ahql.a((structmsg.StructMsg)paramahpe.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get());
      a((structmsg.StructMsg)paramahpe.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), paramahpe.jdField_c_of_type_Long);
      localBundle.putInt("t_s_f", 1001);
      localBundle.putBoolean("troop_suspicious_request", true);
      localIntent.putExtras(localBundle);
      startActivity(localIntent);
      return;
    }
  }
  
  private void a(ahpe paramahpe, structmsg.StructMsg paramStructMsg)
  {
    if ((paramahpe == null) || (paramStructMsg == null)) {
      return;
    }
    if ((paramahpe.jdField_a_of_type_Int == 2) && (paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.has()))
    {
      String str1 = paramStructMsg.msg.action_uin_qq_nick.get().toStringUtf8();
      switch (paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.get())
      {
      default: 
        paramStructMsg = str1;
      }
      for (;;)
      {
        paramahpe.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg);
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
    switch (ahpp.a(paramahpe.jdField_a_of_type_Int))
    {
    default: 
      paramahpe.jdField_a_of_type_AndroidWidgetTextView.setText(paramahpe.jdField_b_of_type_JavaLangString);
      return;
    case 0: 
      paramahpe.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg.msg.group_name.get());
      return;
    case 1: 
      paramahpe.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg.msg.action_uin_nick.get());
      return;
    }
    paramahpe.jdField_a_of_type_AndroidWidgetTextView.setText(paramahpe.jdField_b_of_type_JavaLangString);
  }
  
  public static void a(Context paramContext)
  {
    PublicFragmentActivity.a(paramContext, new Intent(), TroopSuspiciousFragment.class);
  }
  
  private void a(RecyclerView paramRecyclerView, String paramString, Bitmap paramBitmap)
  {
    Object localObject;
    ahpe localahpe;
    if (this.jdField_a_of_type_Int == 0)
    {
      int j = paramRecyclerView.getChildCount();
      int i = 0;
      while (i < j)
      {
        localObject = paramRecyclerView.findViewHolderForAdapterPosition(i);
        if ((localObject == null) || (!(localObject instanceof ahpe)))
        {
          i += 1;
        }
        else
        {
          localahpe = (ahpe)localObject;
          switch (ahpp.a(localahpe.jdField_a_of_type_Int))
          {
          default: 
            localObject = String.valueOf(localahpe.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
          }
        }
      }
    }
    while ((localahpe != null) && (paramString.equals(localObject)))
    {
      localahpe.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      return;
      localObject = localahpe.jdField_a_of_type_JavaLangString;
      continue;
      localObject = String.valueOf(localahpe.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
    }
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    b();
    this.jdField_a_of_type_Bety = new bety(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, a());
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView = ((OverScrollRecyclerView)paramView.findViewById(2131377291));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.addOnScrollListener(new ahqa(this));
    this.jdField_a_of_type_Bdbb = new bdbb(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Bdbb.a(this);
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
      Object localObject = paramStructMsg.msg.actions.get();
      if ((localObject == null) || (paramInt >= ((List)localObject).size())) {
        break label226;
      }
      localObject = (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject).get(paramInt)).action_info.get();
      ((structmsg.SystemMsgActionInfo)localObject).uint32_req_msg_type.set(2);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(i, l1, l2, j, k, m, n, (structmsg.SystemMsgActionInfo)localObject, paramInt);
    }
    label226:
    for (bool = true;; bool = false)
    {
      if ((k == 116) && (m == 0)) {
        azqs.b(null, "P_CliOper", "Grp_discuss", "", "verify_msg", "Clk_agree", 0, 0, String.valueOf(paramStructMsg.msg.group_code.get()), "", "", "");
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
      QLog.d("TroopSuspiciousFragment", 2, "checkInviteeIsFriend stranger list is empty ");
    }
    return false;
  }
  
  private void b()
  {
    if (this.rightViewImg == null) {
      return;
    }
    this.rightViewImg.setVisibility(0);
    this.rightViewImg.setImageResource(2130840102);
    this.rightViewImg.setOnClickListener(new ahqd(this));
  }
  
  private void b(ahpe paramahpe)
  {
    int i = 1;
    if (paramahpe == null) {
      return;
    }
    Object localObject;
    String str;
    switch (ahpp.a(paramahpe.jdField_a_of_type_Int))
    {
    default: 
      localObject = String.valueOf(paramahpe.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
      i = 4;
      str = paramahpe.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_name.get() + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131696982);
    }
    for (;;)
    {
      localObject = ahpp.a(this.jdField_a_of_type_Bdbb, (String)localObject, i);
      paramahpe.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(str);
      paramahpe.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      return;
      localObject = paramahpe.jdField_a_of_type_JavaLangString;
      str = paramahpe.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get() + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131696981);
      continue;
      localObject = String.valueOf(paramahpe.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
      str = paramahpe.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.get() + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131696980);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_Ahkp = new ahqe(this, getActivity(), 2131559763);
    this.jdField_a_of_type_Ahkp.a(2131559764);
    this.jdField_a_of_type_Ahkp.a(2131561328);
    this.jdField_a_of_type_Ahkp.a(new ahqf(this));
  }
  
  private void d()
  {
    this.jdField_b_of_type_Int = bafj.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setAdapter(this.jdField_a_of_type_Ahkp);
    this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(alof.O, 0);
    ahql.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localArrayList.add(this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - i - 1));
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilList = localArrayList;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0) && (!(this.jdField_a_of_type_JavaUtilList.get(0) instanceof MessageForSystemMsg)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopSuspiciousFragment", 2, "initListData error");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.x();
      this.jdField_a_of_type_Ahkp.a(null);
      return;
    }
    this.jdField_a_of_type_Ahkp.a(this.jdField_a_of_type_JavaUtilList);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alwx);
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alwx);
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      do
      {
        return;
        if (!bdin.d(BaseApplication.getContext()))
        {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131692398), 0).b(a());
          return;
        }
      } while ((this.jdField_a_of_type_Auga != null) && (this.jdField_a_of_type_Auga.b()));
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_Ahkp != null) {
        this.jdField_a_of_type_Ahkp.a(new ahqj(this));
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().c(3);
    } while (!QLog.isColorLevel());
    QLog.i("TroopSuspiciousFragment", 2, "loadNextPage.get next page.");
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopSuspiciousFragment", 2, "stopLoadMore().");
    }
    if (this.jdField_a_of_type_Ahkp != null) {
      this.jdField_a_of_type_Ahkp.b();
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void i()
  {
    this.c = bafj.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1012);
    }
  }
  
  private void j()
  {
    ThreadManager.post(new TroopSuspiciousFragment.11(this), 8, null, false);
  }
  
  private void k()
  {
    bhuf localbhuf = (bhuf)bhus.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null);
    localbhuf.a(2131696760, 5);
    localbhuf.c(2131690648);
    localbhuf.a(new ahqc(this, localbhuf));
    if ((!localbhuf.isShowing()) && (this != null) && (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing())) {}
    try
    {
      localbhuf.show();
      return;
    }
    catch (WindowManager.BadTokenException localBadTokenException)
    {
      localBadTokenException.printStackTrace();
    }
  }
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131298914);
  }
  
  public void a()
  {
    j();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.w();
    bafj.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    this.jdField_a_of_type_JavaUtilList.clear();
    if (this.jdField_a_of_type_Ahkp != null) {
      this.jdField_a_of_type_Ahkp.a();
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1012);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    this.jdField_a_of_type_Auga = ((auga)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37));
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = getActivity();
    a(this.mContentView);
    c();
    d();
    e();
  }
  
  public int getContentLayoutId()
  {
    return 2131561360;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = getActivity();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppInterface());
  }
  
  public View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(getActivity().getString(2131699924));
    return localView;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    a(this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView, paramString, paramBitmap);
  }
  
  public void onDestroy()
  {
    f();
    super.onDestroy();
    bafj.a().b();
    if (this.jdField_a_of_type_Bdbb != null) {
      this.jdField_a_of_type_Bdbb.a(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(getClass());
    }
    if (this.jdField_a_of_type_Auga != null) {
      this.jdField_a_of_type_Auga.b(false);
    }
  }
  
  public void onFinish()
  {
    super.onFinish();
    if ((this.jdField_b_of_type_Int > 0) && (this.jdField_a_of_type_Ahkp != null) && (this.jdField_a_of_type_Ahkp.a() > 0)) {
      j();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    i();
    bafj.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
  }
  
  public void onStop()
  {
    super.onStop();
    this.jdField_a_of_type_Bdbb.c();
    this.jdField_a_of_type_Bdbb.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopSuspiciousFragment
 * JD-Core Version:    0.7.0.1
 */