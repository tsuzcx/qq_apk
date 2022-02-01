package com.tencent.mobileqq.activity.contact.troop;

import ajoe;
import ajoo;
import ajpp;
import ajpz;
import ajqy;
import ajqz;
import ajra;
import ajrb;
import ajrc;
import ajrd;
import ajre;
import ajrf;
import ajrg;
import ajrh;
import ajri;
import ajrj;
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
import antf;
import anws;
import anzj;
import aocj;
import aoof;
import aoog;
import aoti;
import axap;
import axfw;
import bdll;
import bdzi;
import bdzj;
import bguq;
import bhlg;
import bhnv;
import bhtq;
import bjbs;
import blir;
import blji;
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
  implements aoog
{
  public int a;
  private ajoe jdField_a_of_type_Ajoe;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ajrf(this);
  aocj jdField_a_of_type_Aocj = new ajri(this);
  public aoof a;
  protected axfw a;
  private bjbs jdField_a_of_type_Bjbs;
  private OverScrollRecyclerView jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView;
  public BaseActivity a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected List<MessageRecord> a;
  public MqqHandler a;
  protected boolean a;
  private int b;
  protected View.OnClickListener b;
  private int c;
  
  public TroopSuspiciousFragment()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new ajrg(this);
    this.jdField_a_of_type_MqqOsMqqHandler = new ajqz(this);
  }
  
  private void a(int paramInt1, String paramString, int paramInt2, long paramLong)
  {
    if (this.jdField_a_of_type_Bjbs != null) {
      this.jdField_a_of_type_Bjbs.dismiss();
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131692418);
    Object localObject;
    if (paramInt1 == 1)
    {
      localObject = bdzi.a().a(Long.valueOf(paramLong));
      if ((localObject != null) && (((structmsg.StructMsg)localObject).msg.group_msg_type.get() == 82)) {
        localObject = paramString;
      }
    }
    for (;;)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, (CharSequence)localObject, 0).b(a());
      long l = bdzi.a().a();
      bdzj.a(bdzi.a().a(Long.valueOf(paramLong)), paramInt1, paramString, paramInt2);
      paramString = bdzi.a().a(Long.valueOf(paramLong));
      if (paramString != null)
      {
        paramInt2 = paramString.msg.group_inviter_role.get();
        if (((paramInt2 == 2) || (paramInt2 == 3)) && (paramInt1 == 1))
        {
          localObject = "" + paramString.msg.group_code.get();
          str = paramString.msg.group_name.get();
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c((String)localObject, str);
        }
      }
      if (l != 0L) {}
      try
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (paramString != null)) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(antf.O, 0, l, paramString.toByteArray());
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          structmsg.StructMsg localStructMsg;
          paramString.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.i("TroopSuspiciousFragment", 2, "onSendSystemMsgActionFin Exception!");
          }
        }
      }
      i();
      return;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131692412);
      continue;
      if (paramInt1 == 2)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131692417);
      }
      else
      {
        localObject = str;
        if (paramInt1 == 0)
        {
          localStructMsg = bdzi.a().a(Long.valueOf(paramLong));
          localObject = str;
          if (localStructMsg != null)
          {
            localObject = str;
            if (localStructMsg.msg.group_msg_type.get() == 82) {
              localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131692417);
            }
          }
        }
      }
    }
  }
  
  private void a(ajoo paramajoo, ajpp paramajpp, structmsg.StructMsg paramStructMsg, int paramInt, String paramString)
  {
    if (paramajpp.jdField_a_of_type_Int == 80)
    {
      paramajoo = paramStructMsg.msg.actions.get();
      paramajpp.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
      paramajpp.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramajoo.get(0)).name.get());
      paramajpp.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131755351);
      paramajpp.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839325);
      paramajpp.jdField_a_of_type_AndroidWidgetButton.setContentDescription(paramajpp.jdField_a_of_type_AndroidWidgetButton.getText() + "");
      paramajpp.jdField_a_of_type_AndroidWidgetButton.setTag(paramajpp);
      paramajpp.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    }
    while (TextUtils.isEmpty(paramajpp.jdField_a_of_type_AndroidWidgetButton.getText()))
    {
      paramajpp.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      return;
      if (paramInt == 1)
      {
        paramStructMsg = paramStructMsg.msg.actions.get();
        paramajpp.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
        if ((paramStructMsg != null) && (paramStructMsg.size() > 0))
        {
          if ((paramString == null) || ("".equals(paramString))) {
            if (paramStructMsg.size() > 1)
            {
              paramajpp.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramStructMsg.get(1)).name.get());
              paramajpp.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131755351);
              paramajpp.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839325);
            }
          }
          for (;;)
          {
            paramajpp.jdField_a_of_type_AndroidWidgetButton.setContentDescription(paramajpp.jdField_a_of_type_AndroidWidgetButton.getText() + "");
            paramajpp.jdField_a_of_type_AndroidWidgetButton.setTag(paramajoo);
            paramajpp.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
            break;
            paramajpp.jdField_a_of_type_AndroidWidgetButton.setText("");
            continue;
            paramajpp.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramStructMsg.get(0)).name.get());
            paramajpp.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131755350);
            paramajpp.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839324);
          }
        }
        paramajpp.jdField_a_of_type_AndroidWidgetButton.setText("");
        paramajpp.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
      }
      else
      {
        paramajpp.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
        paramajpp.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
        paramajpp.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131755972);
        paramajpp.jdField_a_of_type_AndroidWidgetButton.setText(paramStructMsg.msg.msg_decided.get());
        paramajoo = (RelativeLayout.LayoutParams)paramajpp.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
      }
    }
    paramajpp.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
  }
  
  private void a(ajoo paramajoo, MessageRecord paramMessageRecord, int paramInt)
  {
    ajpp localajpp = (ajpp)paramajoo;
    if ((paramMessageRecord == null) || (!(paramMessageRecord instanceof MessageForSystemMsg))) {}
    for (;;)
    {
      return;
      localajpp.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = ((MessageForSystemMsg)paramMessageRecord).getSystemMsg();
      localajpp.jdField_c_of_type_Long = paramMessageRecord.uniseq;
      if (paramMessageRecord != null) {}
      for (int i = ((MessageForSystemMsg)paramMessageRecord).getSystemMsg().msg_type.get(); i == 2; i = 2)
      {
        if (paramInt < this.c)
        {
          ajrj.a(paramajoo.a(), true);
          paramMessageRecord = localajpp.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
          localajpp.jdField_a_of_type_Long = paramInt;
          localajpp.jdField_a_of_type_JavaLangString = (paramMessageRecord.req_uin.get() + "");
          localajpp.jdField_a_of_type_Int = paramMessageRecord.msg.group_msg_type.get();
          paramInt = paramMessageRecord.msg.sub_type.get();
          localajpp.jdField_b_of_type_Long = paramMessageRecord.msg_time.get();
          localajpp.jdField_b_of_type_JavaLangString = paramMessageRecord.msg.req_uin_nick.get();
          if ((localajpp.jdField_b_of_type_JavaLangString == null) || (localajpp.jdField_b_of_type_JavaLangString.equals(""))) {
            break label370;
          }
        }
        for (;;)
        {
          c(localajpp, paramMessageRecord);
          localajpp.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          String str = paramMessageRecord.msg.group_info.msg_alert.get();
          b(localajpp, paramMessageRecord);
          a(localajpp, paramMessageRecord);
          a(paramajoo, localajpp, paramMessageRecord, paramInt, str);
          if ((paramInt == 2) && (localajpp.jdField_a_of_type_Int == 2) && (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(String.valueOf(paramMessageRecord.msg.group_code.get())) != null)) {
            axap.a().b(String.valueOf(paramMessageRecord.msg.group_code.get()), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          }
          localajpp.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(paramajoo);
          localajpp.jdField_a_of_type_AndroidWidgetImageView.setTag(paramajoo);
          localajpp.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          b(localajpp);
          return;
          ajrj.a(paramajoo.a(), false);
          break;
          label370:
          localajpp.jdField_b_of_type_JavaLangString = localajpp.jdField_a_of_type_JavaLangString;
        }
      }
    }
  }
  
  private void a(ajpp paramajpp)
  {
    if (paramajpp == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopSuspiciousFragment", 2, "jumpToTroopRequestActivity!" + paramajpp.jdField_a_of_type_Long);
    }
    ajrj.a(paramajpp.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, "unnormal_edit");
    Intent localIntent = new Intent(getActivity(), TroopRequestActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putLong("troopMsgId", paramajpp.jdField_a_of_type_Long);
    localBundle.putInt("mTroopMsgType", paramajpp.jdField_a_of_type_Int);
    localBundle.putString("mTroopCode", String.valueOf(paramajpp.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()));
    localBundle.putString("troopmanagerUin", String.valueOf(paramajpp.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get()));
    localBundle.putString("troopsMsg", paramajpp.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
    int i = bdzi.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (paramajpp.jdField_b_of_type_Int < i) {}
    for (boolean bool = true;; bool = false)
    {
      localBundle.putBoolean("is_unread", bool);
      localBundle.putString("troopRequestUin", String.valueOf(paramajpp.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
      localBundle.putString("troopsummary", paramajpp.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get());
      localBundle.putLong("infotime", paramajpp.jdField_b_of_type_Long);
      if ((getActivity() instanceof TroopActivity)) {
        localBundle.putBoolean("troop_invitee_is_friend", a((ArrayList)((TroopActivity)getActivity()).jdField_a_of_type_JavaUtilList, String.valueOf(paramajpp.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get())));
      }
      if (paramajpp.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() != 83) {
        localIntent.putExtra("troopMsgDealInfo", paramajpp.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_detail.get());
      }
      ajrj.a((structmsg.StructMsg)paramajpp.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get());
      a((structmsg.StructMsg)paramajpp.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), paramajpp.jdField_c_of_type_Long);
      localBundle.putInt("t_s_f", 1001);
      localBundle.putBoolean("troop_suspicious_request", true);
      localIntent.putExtras(localBundle);
      startActivity(localIntent);
      return;
    }
  }
  
  private void a(ajpp paramajpp, structmsg.StructMsg paramStructMsg)
  {
    String str = bguq.a(paramStructMsg, paramStructMsg.msg.msg_describe.get());
    if (str != null)
    {
      paramajpp.jdField_b_of_type_AndroidWidgetTextView.setText(str);
      return;
    }
    paramStructMsg = paramStructMsg.msg.msg_additional.get();
    if ((paramStructMsg == null) || ("".equals(paramStructMsg)))
    {
      paramajpp.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131695532));
      return;
    }
    paramajpp.jdField_b_of_type_AndroidWidgetTextView.setText(paramStructMsg);
  }
  
  public static void a(Context paramContext)
  {
    PublicFragmentActivity.a(paramContext, new Intent(), TroopSuspiciousFragment.class);
  }
  
  private void a(RecyclerView paramRecyclerView, String paramString, Bitmap paramBitmap)
  {
    Object localObject;
    ajpp localajpp;
    if (this.jdField_a_of_type_Int == 0)
    {
      int j = paramRecyclerView.getChildCount();
      int i = 0;
      while (i < j)
      {
        localObject = paramRecyclerView.findViewHolderForAdapterPosition(i);
        if ((localObject == null) || (!(localObject instanceof ajpp)))
        {
          i += 1;
        }
        else
        {
          localajpp = (ajpp)localObject;
          switch (ajpz.a(localajpp.jdField_a_of_type_Int))
          {
          default: 
            localObject = String.valueOf(localajpp.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
          }
        }
      }
    }
    while ((localajpp != null) && (paramString.equals(localObject)))
    {
      localajpp.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      return;
      localObject = localajpp.jdField_a_of_type_JavaLangString;
      continue;
      localObject = String.valueOf(localajpp.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
    }
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    b();
    this.jdField_a_of_type_Bjbs = new bjbs(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, a());
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView = ((OverScrollRecyclerView)paramView.findViewById(2131378259));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.addOnScrollListener(new ajqy(this));
    this.jdField_a_of_type_Aoof = new aoof(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Aoof.a(this);
  }
  
  private void a(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong)
  {
    if (this.jdField_a_of_type_Bjbs != null) {
      this.jdField_a_of_type_Bjbs.dismiss();
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131717877);
    if (!TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, paramString2, 0).b(a());
      bdzj.a(bdzi.a().a(Long.valueOf(paramLong)), paramInt, paramString1, paramString3);
      paramString1 = bdzi.a().a(Long.valueOf(paramLong));
      if ((paramString1 != null) && (paramString1.msg_type.get() == 2)) {
        i();
      }
      return;
      paramString2 = str;
    }
  }
  
  private void a(List<MessageRecord> paramList)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramList != null) && (paramList.size() > 0))
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList = TroopNotifyAndRecommendView.a(this.jdField_a_of_type_JavaUtilList, paramList);
    }
    bdzi.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    if (this.jdField_a_of_type_Ajoe != null)
    {
      this.jdField_a_of_type_Ajoe.a();
      this.jdField_a_of_type_Ajoe.a(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_Ajoe.notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(true);
    }
  }
  
  private void a(structmsg.StructMsg paramStructMsg, long paramLong)
  {
    if (paramStructMsg != null)
    {
      long l = ((structmsg.StructMsg)paramStructMsg.get()).msg_seq.get() + ((structmsg.StructMsg)paramStructMsg.get()).msg_type.get();
      bdzi.a().a(Long.valueOf(l), (structmsg.StructMsg)paramStructMsg.get());
      bdzi.a().b(l);
      bdzi.a().a(paramLong);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_Boolean))
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131718515);
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, str, 0).b(a());
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
        bdll.b(null, "P_CliOper", "Grp_discuss", "", "verify_msg", "Clk_agree", 0, 0, String.valueOf(paramStructMsg.msg.group_code.get()), "", "", "");
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
    this.rightViewImg.setImageResource(2130840291);
    this.rightViewImg.setOnClickListener(new ajrb(this));
  }
  
  private void b(ajpp paramajpp)
  {
    int i = 1;
    if (paramajpp == null) {
      return;
    }
    Object localObject;
    String str;
    switch (ajpz.a(paramajpp.jdField_a_of_type_Int))
    {
    default: 
      localObject = String.valueOf(paramajpp.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
      i = 4;
      str = paramajpp.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_name.get() + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131695854);
    }
    for (;;)
    {
      localObject = ajpz.a(this.jdField_a_of_type_Aoof, (String)localObject, i);
      paramajpp.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(str);
      paramajpp.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      return;
      localObject = paramajpp.jdField_a_of_type_JavaLangString;
      str = paramajpp.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get() + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131695853);
      continue;
      localObject = String.valueOf(paramajpp.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
      str = paramajpp.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.get() + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131695852);
    }
  }
  
  private void b(ajpp paramajpp, structmsg.StructMsg paramStructMsg)
  {
    Object localObject = "";
    if (paramStructMsg.msg.bytes_warning_tips.get() != null) {
      localObject = paramStructMsg.msg.bytes_warning_tips.get().toStringUtf8();
    }
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramajpp.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      if (paramajpp.jdField_a_of_type_Int != 22) {
        break label237;
      }
      paramStructMsg = paramStructMsg.msg;
      paramajpp.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject = new SpannableString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131718513, new Object[] { paramStructMsg.action_uin_nick.get() }));
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#00a5e0")), 6, paramStructMsg.action_uin_nick.get().length() + 6, 33);
      paramajpp.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      paramajpp.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new ajre(this, paramStructMsg));
    }
    label237:
    while ((paramajpp.jdField_a_of_type_Int != 2) || (!paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.has()))
    {
      return;
      paramajpp.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramajpp.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130847814);
      ((Drawable)localObject).setBounds(0, 0, bhtq.a(16.0F), bhtq.a(16.0F));
      paramajpp.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(bhtq.a(5.0F));
      paramajpp.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
      break;
    }
    String str = "";
    switch (paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.get())
    {
    case 0: 
    default: 
      return;
    case 1: 
      localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      if (localObject == null) {
        break;
      }
    }
    for (paramStructMsg = ((TroopManager)localObject).a(String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()));; paramStructMsg = "")
    {
      paramajpp.jdField_c_of_type_AndroidWidgetTextView.setText(anzj.a(2131706504) + paramStructMsg);
      paramajpp.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
      anws localanws = (anws)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53);
      localObject = str;
      if (localanws != null)
      {
        paramStructMsg = localanws.a(String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()));
        localObject = str;
        if (paramStructMsg != null) {
          localObject = paramStructMsg.discussionName;
        }
      }
      paramajpp.jdField_c_of_type_AndroidWidgetTextView.setText(anzj.a(2131706493) + (String)localObject);
      paramajpp.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_Ajoe = new ajrc(this, getActivity(), 2131559908);
    this.jdField_a_of_type_Ajoe.a(2131559909);
    this.jdField_a_of_type_Ajoe.a(2131561602);
    this.jdField_a_of_type_Ajoe.a(new ajrd(this));
  }
  
  private void c(ajpp paramajpp, structmsg.StructMsg paramStructMsg)
  {
    if ((paramajpp == null) || (paramStructMsg == null)) {
      return;
    }
    if ((paramajpp.jdField_a_of_type_Int == 2) && (paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.has()))
    {
      String str1 = paramStructMsg.msg.action_uin_qq_nick.get().toStringUtf8();
      switch (paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.get())
      {
      default: 
        paramStructMsg = str1;
      }
      for (;;)
      {
        paramajpp.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg);
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
        str1 = bhlg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str3, str2, paramStructMsg, true, null);
        paramStructMsg = str1;
        if (TextUtils.isEmpty(str1))
        {
          paramStructMsg = ((TroopManager)localObject).a(str2, str3);
          continue;
          localObject = (anws)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53);
          if (localObject == null) {
            break;
          }
          paramStructMsg = ((anws)localObject).a(String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()), String.valueOf(paramStructMsg.msg.action_uin.get()));
          if (paramStructMsg == null) {
            break;
          }
          paramStructMsg = paramStructMsg.getDiscussionMemberName();
        }
      }
    }
    switch (ajpz.a(paramajpp.jdField_a_of_type_Int))
    {
    default: 
      paramajpp.jdField_a_of_type_AndroidWidgetTextView.setText(paramajpp.jdField_b_of_type_JavaLangString);
      return;
    case 0: 
      paramajpp.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg.msg.group_name.get());
      return;
    case 1: 
      paramajpp.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg.msg.action_uin_nick.get());
      return;
    }
    paramajpp.jdField_a_of_type_AndroidWidgetTextView.setText(paramajpp.jdField_b_of_type_JavaLangString);
  }
  
  private void d()
  {
    this.jdField_b_of_type_Int = bdzi.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setAdapter(this.jdField_a_of_type_Ajoe);
    this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(antf.O, 0);
    ajrj.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.y();
      this.jdField_a_of_type_Ajoe.a(null);
      return;
    }
    this.jdField_a_of_type_Ajoe.a(this.jdField_a_of_type_JavaUtilList);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aocj);
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aocj);
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
        if (!bhnv.d(BaseApplication.getContext()))
        {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131691989), 0).b(a());
          return;
        }
      } while ((this.jdField_a_of_type_Axfw != null) && (this.jdField_a_of_type_Axfw.b()));
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_Ajoe != null) {
        this.jdField_a_of_type_Ajoe.a(new ajrh(this));
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
    if (this.jdField_a_of_type_Ajoe != null) {
      this.jdField_a_of_type_Ajoe.b();
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void i()
  {
    this.c = bdzi.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    blir localblir = (blir)blji.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null);
    localblir.a(2131695628, 5);
    localblir.c(2131690580);
    localblir.a(new ajra(this, localblir));
    if ((!localblir.isShowing()) && (this != null) && (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing())) {}
    try
    {
      localblir.show();
      return;
    }
    catch (WindowManager.BadTokenException localBadTokenException)
    {
      localBadTokenException.printStackTrace();
    }
  }
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131299011);
  }
  
  public void a()
  {
    j();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.x();
    bdzi.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    this.jdField_a_of_type_JavaUtilList.clear();
    if (this.jdField_a_of_type_Ajoe != null) {
      this.jdField_a_of_type_Ajoe.a();
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1012);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    this.jdField_a_of_type_Axfw = ((axfw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37));
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = getActivity();
    a(this.mContentView);
    c();
    d();
    e();
  }
  
  public int getContentLayoutId()
  {
    return 2131561634;
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
    setTitle(getActivity().getString(2131698469));
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
    bdzi.a().b();
    if (this.jdField_a_of_type_Aoof != null) {
      this.jdField_a_of_type_Aoof.a(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(getClass());
    }
    if (this.jdField_a_of_type_Axfw != null) {
      this.jdField_a_of_type_Axfw.b(false);
    }
  }
  
  public void onFinish()
  {
    super.onFinish();
    if ((this.jdField_b_of_type_Int > 0) && (this.jdField_a_of_type_Ajoe != null) && (this.jdField_a_of_type_Ajoe.a() > 0)) {
      j();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    i();
    bdzi.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
  }
  
  public void onStop()
  {
    super.onStop();
    this.jdField_a_of_type_Aoof.c();
    this.jdField_a_of_type_Aoof.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopSuspiciousFragment
 * JD-Core Version:    0.7.0.1
 */