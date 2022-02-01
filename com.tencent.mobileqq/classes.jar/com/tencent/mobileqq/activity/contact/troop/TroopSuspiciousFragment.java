package com.tencent.mobileqq.activity.contact.troop;

import ajcv;
import ajdf;
import ajeg;
import ajeq;
import ajfp;
import ajfq;
import ajfr;
import ajfs;
import ajft;
import ajfu;
import ajfv;
import ajfw;
import ajfx;
import ajfy;
import ajfz;
import ajga;
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
import anhk;
import ankw;
import anni;
import anqd;
import aobu;
import aobv;
import aogd;
import awhx;
import awne;
import bcst;
import bdgn;
import bdgo;
import bfup;
import bglf;
import bgnt;
import bgtn;
import biau;
import bkho;
import bkif;
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
  implements aobv
{
  public int a;
  private ajcv jdField_a_of_type_Ajcv;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ajfw(this);
  anqd jdField_a_of_type_Anqd = new ajfz(this);
  public aobu a;
  protected awne a;
  private biau jdField_a_of_type_Biau;
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
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new ajfx(this);
    this.jdField_a_of_type_MqqOsMqqHandler = new ajfq(this);
  }
  
  private void a(int paramInt1, String paramString, int paramInt2, long paramLong)
  {
    if (this.jdField_a_of_type_Biau != null) {
      this.jdField_a_of_type_Biau.dismiss();
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131692412);
    Object localObject;
    if (paramInt1 == 1)
    {
      localObject = bdgn.a().a(Long.valueOf(paramLong));
      if ((localObject != null) && (((structmsg.StructMsg)localObject).msg.group_msg_type.get() == 82)) {
        localObject = paramString;
      }
    }
    for (;;)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, (CharSequence)localObject, 0).b(a());
      long l = bdgn.a().a();
      bdgo.a(bdgn.a().a(Long.valueOf(paramLong)), paramInt1, paramString, paramInt2);
      paramString = bdgn.a().a(Long.valueOf(paramLong));
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
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(anhk.O, 0, l, paramString.toByteArray());
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
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131692406);
      continue;
      if (paramInt1 == 2)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131692411);
      }
      else
      {
        localObject = str;
        if (paramInt1 == 0)
        {
          localStructMsg = bdgn.a().a(Long.valueOf(paramLong));
          localObject = str;
          if (localStructMsg != null)
          {
            localObject = str;
            if (localStructMsg.msg.group_msg_type.get() == 82) {
              localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131692411);
            }
          }
        }
      }
    }
  }
  
  private void a(ajdf paramajdf, ajeg paramajeg, structmsg.StructMsg paramStructMsg, int paramInt, String paramString)
  {
    if (paramajeg.jdField_a_of_type_Int == 80)
    {
      paramajdf = paramStructMsg.msg.actions.get();
      paramajeg.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
      paramajeg.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramajdf.get(0)).name.get());
      paramajeg.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131755350);
      paramajeg.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839317);
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
        if ((paramStructMsg != null) && (paramStructMsg.size() > 0))
        {
          if ((paramString == null) || ("".equals(paramString))) {
            if (paramStructMsg.size() > 1)
            {
              paramajeg.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramStructMsg.get(1)).name.get());
              paramajeg.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131755350);
              paramajeg.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839317);
            }
          }
          for (;;)
          {
            paramajeg.jdField_a_of_type_AndroidWidgetButton.setContentDescription(paramajeg.jdField_a_of_type_AndroidWidgetButton.getText() + "");
            paramajeg.jdField_a_of_type_AndroidWidgetButton.setTag(paramajdf);
            paramajeg.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
            break;
            paramajeg.jdField_a_of_type_AndroidWidgetButton.setText("");
            continue;
            paramajeg.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramStructMsg.get(0)).name.get());
            paramajeg.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131755349);
            paramajeg.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839316);
          }
        }
        paramajeg.jdField_a_of_type_AndroidWidgetButton.setText("");
        paramajeg.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
      }
      else
      {
        paramajeg.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
        paramajeg.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
        paramajeg.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131755971);
        paramajeg.jdField_a_of_type_AndroidWidgetButton.setText(paramStructMsg.msg.msg_decided.get());
        paramajdf = (RelativeLayout.LayoutParams)paramajeg.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
      }
    }
    paramajeg.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
  }
  
  private void a(ajdf paramajdf, MessageRecord paramMessageRecord, int paramInt)
  {
    ajeg localajeg = (ajeg)paramajdf;
    if ((paramMessageRecord == null) || (!(paramMessageRecord instanceof MessageForSystemMsg))) {}
    for (;;)
    {
      return;
      localajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = ((MessageForSystemMsg)paramMessageRecord).getSystemMsg();
      localajeg.jdField_c_of_type_Long = paramMessageRecord.uniseq;
      if (paramMessageRecord != null) {}
      for (int i = ((MessageForSystemMsg)paramMessageRecord).getSystemMsg().msg_type.get(); i == 2; i = 2)
      {
        if (paramInt < this.c)
        {
          ajga.a(paramajdf.a(), true);
          paramMessageRecord = localajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
          localajeg.jdField_a_of_type_Long = paramInt;
          localajeg.jdField_a_of_type_JavaLangString = (paramMessageRecord.req_uin.get() + "");
          localajeg.jdField_a_of_type_Int = paramMessageRecord.msg.group_msg_type.get();
          paramInt = paramMessageRecord.msg.sub_type.get();
          localajeg.jdField_b_of_type_Long = paramMessageRecord.msg_time.get();
          localajeg.jdField_b_of_type_JavaLangString = paramMessageRecord.msg.req_uin_nick.get();
          if ((localajeg.jdField_b_of_type_JavaLangString == null) || (localajeg.jdField_b_of_type_JavaLangString.equals(""))) {
            break label370;
          }
        }
        for (;;)
        {
          c(localajeg, paramMessageRecord);
          localajeg.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          String str = paramMessageRecord.msg.group_info.msg_alert.get();
          b(localajeg, paramMessageRecord);
          a(localajeg, paramMessageRecord);
          a(paramajdf, localajeg, paramMessageRecord, paramInt, str);
          if ((paramInt == 2) && (localajeg.jdField_a_of_type_Int == 2) && (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(String.valueOf(paramMessageRecord.msg.group_code.get())) != null)) {
            awhx.a().b(String.valueOf(paramMessageRecord.msg.group_code.get()), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          }
          localajeg.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(paramajdf);
          localajeg.jdField_a_of_type_AndroidWidgetImageView.setTag(paramajdf);
          localajeg.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          b(localajeg);
          return;
          ajga.a(paramajdf.a(), false);
          break;
          label370:
          localajeg.jdField_b_of_type_JavaLangString = localajeg.jdField_a_of_type_JavaLangString;
        }
      }
    }
  }
  
  private void a(ajeg paramajeg)
  {
    if (paramajeg == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopSuspiciousFragment", 2, "jumpToTroopRequestActivity!" + paramajeg.jdField_a_of_type_Long);
    }
    ajga.a(paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, "unnormal_edit");
    Intent localIntent = new Intent(getActivity(), TroopRequestActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putLong("troopMsgId", paramajeg.jdField_a_of_type_Long);
    localBundle.putInt("mTroopMsgType", paramajeg.jdField_a_of_type_Int);
    localBundle.putString("mTroopCode", String.valueOf(paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()));
    localBundle.putString("troopmanagerUin", String.valueOf(paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get()));
    localBundle.putString("troopsMsg", paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
    int i = bdgn.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (paramajeg.jdField_b_of_type_Int < i) {}
    for (boolean bool = true;; bool = false)
    {
      localBundle.putBoolean("is_unread", bool);
      localBundle.putString("troopRequestUin", String.valueOf(paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
      localBundle.putString("troopsummary", paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get());
      localBundle.putLong("infotime", paramajeg.jdField_b_of_type_Long);
      if ((getActivity() instanceof TroopActivity)) {
        localBundle.putBoolean("troop_invitee_is_friend", a((ArrayList)((TroopActivity)getActivity()).jdField_a_of_type_JavaUtilList, String.valueOf(paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get())));
      }
      if (paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() != 83) {
        localIntent.putExtra("troopMsgDealInfo", paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_detail.get());
      }
      ajga.a((structmsg.StructMsg)paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get());
      a((structmsg.StructMsg)paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), paramajeg.jdField_c_of_type_Long);
      localBundle.putInt("t_s_f", 1001);
      localBundle.putBoolean("troop_suspicious_request", true);
      localIntent.putExtras(localBundle);
      startActivity(localIntent);
      return;
    }
  }
  
  private void a(ajeg paramajeg, structmsg.StructMsg paramStructMsg)
  {
    String str = bfup.a(paramStructMsg, paramStructMsg.msg.msg_describe.get());
    if (str != null)
    {
      paramajeg.jdField_b_of_type_AndroidWidgetTextView.setText(str);
      return;
    }
    paramStructMsg = paramStructMsg.msg.msg_additional.get();
    if ((paramStructMsg == null) || ("".equals(paramStructMsg)))
    {
      paramajeg.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131695489));
      return;
    }
    paramajeg.jdField_b_of_type_AndroidWidgetTextView.setText(paramStructMsg);
  }
  
  public static void a(Context paramContext)
  {
    PublicFragmentActivity.a(paramContext, new Intent(), TroopSuspiciousFragment.class);
  }
  
  private void a(RecyclerView paramRecyclerView, String paramString, Bitmap paramBitmap)
  {
    Object localObject;
    ajeg localajeg;
    if (this.jdField_a_of_type_Int == 0)
    {
      int j = paramRecyclerView.getChildCount();
      int i = 0;
      while (i < j)
      {
        localObject = paramRecyclerView.findViewHolderForAdapterPosition(i);
        if ((localObject == null) || (!(localObject instanceof ajeg)))
        {
          i += 1;
        }
        else
        {
          localajeg = (ajeg)localObject;
          switch (ajeq.a(localajeg.jdField_a_of_type_Int))
          {
          default: 
            localObject = String.valueOf(localajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
          }
        }
      }
    }
    while ((localajeg != null) && (paramString.equals(localObject)))
    {
      localajeg.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      return;
      localObject = localajeg.jdField_a_of_type_JavaLangString;
      continue;
      localObject = String.valueOf(localajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
    }
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    b();
    this.jdField_a_of_type_Biau = new biau(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, a());
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView = ((OverScrollRecyclerView)paramView.findViewById(2131378102));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.addOnScrollListener(new ajfp(this));
    this.jdField_a_of_type_Aobu = new aobu(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Aobu.a(this);
  }
  
  private void a(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong)
  {
    if (this.jdField_a_of_type_Biau != null) {
      this.jdField_a_of_type_Biau.dismiss();
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131717746);
    if (!TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, paramString2, 0).b(a());
      bdgo.a(bdgn.a().a(Long.valueOf(paramLong)), paramInt, paramString1, paramString3);
      paramString1 = bdgn.a().a(Long.valueOf(paramLong));
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
    bdgn.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    if (this.jdField_a_of_type_Ajcv != null)
    {
      this.jdField_a_of_type_Ajcv.a();
      this.jdField_a_of_type_Ajcv.a(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_Ajcv.notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(true);
    }
  }
  
  private void a(structmsg.StructMsg paramStructMsg, long paramLong)
  {
    if (paramStructMsg != null)
    {
      long l = ((structmsg.StructMsg)paramStructMsg.get()).msg_seq.get() + ((structmsg.StructMsg)paramStructMsg.get()).msg_type.get();
      bdgn.a().a(Long.valueOf(l), (structmsg.StructMsg)paramStructMsg.get());
      bdgn.a().b(l);
      bdgn.a().a(paramLong);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_Boolean))
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131718379);
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
        bcst.b(null, "P_CliOper", "Grp_discuss", "", "verify_msg", "Clk_agree", 0, 0, String.valueOf(paramStructMsg.msg.group_code.get()), "", "", "");
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
    this.rightViewImg.setImageResource(2130840281);
    this.rightViewImg.setOnClickListener(new ajfs(this));
  }
  
  private void b(ajeg paramajeg)
  {
    int i = 1;
    if (paramajeg == null) {
      return;
    }
    Object localObject;
    String str;
    switch (ajeq.a(paramajeg.jdField_a_of_type_Int))
    {
    default: 
      localObject = String.valueOf(paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
      i = 4;
      str = paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_name.get() + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131695811);
    }
    for (;;)
    {
      localObject = ajeq.a(this.jdField_a_of_type_Aobu, (String)localObject, i);
      paramajeg.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(str);
      paramajeg.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      return;
      localObject = paramajeg.jdField_a_of_type_JavaLangString;
      str = paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get() + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131695810);
      continue;
      localObject = String.valueOf(paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
      str = paramajeg.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.get() + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131695809);
    }
  }
  
  private void b(ajeg paramajeg, structmsg.StructMsg paramStructMsg)
  {
    Object localObject = "";
    if (paramStructMsg.msg.bytes_warning_tips.get() != null) {
      localObject = paramStructMsg.msg.bytes_warning_tips.get().toStringUtf8();
    }
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramajeg.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      if (paramajeg.jdField_a_of_type_Int != 22) {
        break label237;
      }
      paramStructMsg = paramStructMsg.msg;
      paramajeg.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject = new SpannableString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131718377, new Object[] { paramStructMsg.action_uin_nick.get() }));
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#00a5e0")), 6, paramStructMsg.action_uin_nick.get().length() + 6, 33);
      paramajeg.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      paramajeg.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new ajfv(this, paramStructMsg));
    }
    label237:
    while ((paramajeg.jdField_a_of_type_Int != 2) || (!paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.has()))
    {
      return;
      paramajeg.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramajeg.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130847795);
      ((Drawable)localObject).setBounds(0, 0, bgtn.a(16.0F), bgtn.a(16.0F));
      paramajeg.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(bgtn.a(5.0F));
      paramajeg.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
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
      paramajeg.jdField_c_of_type_AndroidWidgetTextView.setText(anni.a(2131706397) + paramStructMsg);
      paramajeg.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
      ankw localankw = (ankw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53);
      localObject = str;
      if (localankw != null)
      {
        paramStructMsg = localankw.a(String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()));
        localObject = str;
        if (paramStructMsg != null) {
          localObject = paramStructMsg.discussionName;
        }
      }
      paramajeg.jdField_c_of_type_AndroidWidgetTextView.setText(anni.a(2131706386) + (String)localObject);
      paramajeg.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_Ajcv = new ajft(this, getActivity(), 2131559902);
    this.jdField_a_of_type_Ajcv.a(2131559903);
    this.jdField_a_of_type_Ajcv.a(2131561561);
    this.jdField_a_of_type_Ajcv.a(new ajfu(this));
  }
  
  private void c(ajeg paramajeg, structmsg.StructMsg paramStructMsg)
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
        Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
        if (localObject == null) {
          break;
        }
        String str2 = String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get());
        String str3 = String.valueOf(paramStructMsg.msg.action_uin.get());
        paramStructMsg = ((TroopManager)localObject).d(str2);
        str1 = bglf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str3, str2, paramStructMsg, true, null);
        paramStructMsg = str1;
        if (TextUtils.isEmpty(str1))
        {
          paramStructMsg = ((TroopManager)localObject).a(str2, str3);
          continue;
          localObject = (ankw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53);
          if (localObject == null) {
            break;
          }
          paramStructMsg = ((ankw)localObject).a(String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()), String.valueOf(paramStructMsg.msg.action_uin.get()));
          if (paramStructMsg == null) {
            break;
          }
          paramStructMsg = paramStructMsg.getDiscussionMemberName();
        }
      }
    }
    switch (ajeq.a(paramajeg.jdField_a_of_type_Int))
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
  
  private void d()
  {
    this.jdField_b_of_type_Int = bdgn.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setAdapter(this.jdField_a_of_type_Ajcv);
    this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(anhk.O, 0);
    ajga.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
      this.jdField_a_of_type_Ajcv.a(null);
      return;
    }
    this.jdField_a_of_type_Ajcv.a(this.jdField_a_of_type_JavaUtilList);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anqd);
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anqd);
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
        if (!bgnt.d(BaseApplication.getContext()))
        {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131691985), 0).b(a());
          return;
        }
      } while ((this.jdField_a_of_type_Awne != null) && (this.jdField_a_of_type_Awne.b()));
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_Ajcv != null) {
        this.jdField_a_of_type_Ajcv.a(new ajfy(this));
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
    if (this.jdField_a_of_type_Ajcv != null) {
      this.jdField_a_of_type_Ajcv.b();
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void i()
  {
    this.c = bdgn.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    bkho localbkho = (bkho)bkif.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null);
    localbkho.a(2131695585, 5);
    localbkho.c(2131690582);
    localbkho.a(new ajfr(this, localbkho));
    if ((!localbkho.isShowing()) && (this != null) && (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing())) {}
    try
    {
      localbkho.show();
      return;
    }
    catch (WindowManager.BadTokenException localBadTokenException)
    {
      localBadTokenException.printStackTrace();
    }
  }
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131298998);
  }
  
  public void a()
  {
    j();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.x();
    bdgn.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    this.jdField_a_of_type_JavaUtilList.clear();
    if (this.jdField_a_of_type_Ajcv != null) {
      this.jdField_a_of_type_Ajcv.a();
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1012);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    this.jdField_a_of_type_Awne = ((awne)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37));
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = getActivity();
    a(this.mContentView);
    c();
    d();
    e();
  }
  
  public int getContentLayoutId()
  {
    return 2131561593;
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
    setTitle(getActivity().getString(2131698367));
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
    bdgn.a().b();
    if (this.jdField_a_of_type_Aobu != null) {
      this.jdField_a_of_type_Aobu.a(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(getClass());
    }
    if (this.jdField_a_of_type_Awne != null) {
      this.jdField_a_of_type_Awne.b(false);
    }
  }
  
  public void onFinish()
  {
    super.onFinish();
    if ((this.jdField_b_of_type_Int > 0) && (this.jdField_a_of_type_Ajcv != null) && (this.jdField_a_of_type_Ajcv.a() > 0)) {
      j();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    i();
    bdgn.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
  }
  
  public void onStop()
  {
    super.onStop();
    this.jdField_a_of_type_Aobu.c();
    this.jdField_a_of_type_Aobu.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopSuspiciousFragment
 * JD-Core Version:    0.7.0.1
 */