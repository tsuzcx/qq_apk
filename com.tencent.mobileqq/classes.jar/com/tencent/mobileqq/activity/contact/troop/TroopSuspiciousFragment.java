package com.tencent.mobileqq.activity.contact.troop;

import ajdm;
import ajdw;
import ajfc;
import ajfq;
import ajgv;
import ajgw;
import ajgx;
import ajgy;
import ajgz;
import ajha;
import ajhb;
import ajhc;
import ajhd;
import ajhe;
import ajhf;
import ajhg;
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
import antp;
import anvx;
import anyz;
import aooy;
import awub;
import awzf;
import bdla;
import bdzy;
import bdzz;
import bisl;
import bkzi;
import bkzz;
import com.tencent.biz.qqstory.widget.OverScrollRecyclerView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
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
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
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
  implements FaceDecoder.DecodeTaskCompletionListener
{
  public int a;
  private ajdm jdField_a_of_type_Ajdm;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ajhc(this);
  anyz jdField_a_of_type_Anyz = new ajhf(this);
  protected awzf a;
  private bisl jdField_a_of_type_Bisl;
  private OverScrollRecyclerView jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView;
  public BaseActivity a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public FaceDecoder a;
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
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new ajhd(this);
    this.jdField_a_of_type_MqqOsMqqHandler = new ajgw(this);
  }
  
  private void a(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    if (this.jdField_a_of_type_Bisl != null) {
      this.jdField_a_of_type_Bisl.dismiss();
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131692568);
    Object localObject;
    if (paramInt1 == 1)
    {
      localObject = bdzy.a().a(paramString2);
      if ((localObject != null) && (((structmsg.StructMsg)localObject).msg.group_msg_type.get() == 82)) {
        localObject = paramString1;
      }
    }
    for (;;)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, (CharSequence)localObject, 0).b(a());
      long l = bdzy.a().a();
      bdzz.a(bdzy.a().a(paramString2), paramInt1, paramString1, paramInt2);
      paramString1 = bdzy.a().a(paramString2);
      if (paramString1 != null)
      {
        paramInt2 = paramString1.msg.group_inviter_role.get();
        if (((paramInt2 == 2) || (paramInt2 == 3)) && (paramInt1 == 1))
        {
          paramString2 = "" + paramString1.msg.group_code.get();
          localObject = paramString1.msg.group_name.get();
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().c(paramString2, (String)localObject);
        }
      }
      if (l != 0L) {}
      try
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (paramString1 != null)) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().updateMsgContentByUniseq(AppConstants.TROOP_SUSPICIOUS_MSG_UIN, 0, l, paramString1.toByteArray());
        }
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          structmsg.StructMsg localStructMsg;
          paramString1.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.i("TroopSuspiciousFragment", 2, "onSendSystemMsgActionFin Exception!");
          }
        }
      }
      i();
      return;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131692562);
      continue;
      if (paramInt1 == 2)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131692567);
      }
      else
      {
        localObject = str;
        if (paramInt1 == 0)
        {
          localStructMsg = bdzy.a().a(paramString2);
          localObject = str;
          if (localStructMsg != null)
          {
            localObject = str;
            if (localStructMsg.msg.group_msg_type.get() == 82) {
              localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131692567);
            }
          }
        }
      }
    }
  }
  
  private void a(ajdw paramajdw, ajfc paramajfc, structmsg.StructMsg paramStructMsg, int paramInt, String paramString)
  {
    if (paramajfc.jdField_a_of_type_Int == 80)
    {
      paramajdw = paramStructMsg.msg.actions.get();
      paramajfc.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
      paramajfc.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramajdw.get(0)).name.get());
      paramajfc.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131755352);
      paramajfc.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839381);
      paramajfc.jdField_a_of_type_AndroidWidgetButton.setContentDescription(paramajfc.jdField_a_of_type_AndroidWidgetButton.getText() + "");
      paramajfc.jdField_a_of_type_AndroidWidgetButton.setTag(paramajfc);
      paramajfc.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    }
    while (TextUtils.isEmpty(paramajfc.jdField_a_of_type_AndroidWidgetButton.getText()))
    {
      paramajfc.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      return;
      if (paramInt == 1)
      {
        paramStructMsg = paramStructMsg.msg.actions.get();
        paramajfc.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
        if ((paramStructMsg != null) && (paramStructMsg.size() > 0))
        {
          if ((paramString == null) || ("".equals(paramString))) {
            if (paramStructMsg.size() > 1)
            {
              paramajfc.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramStructMsg.get(1)).name.get());
              paramajfc.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131755352);
              paramajfc.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839381);
            }
          }
          for (;;)
          {
            paramajfc.jdField_a_of_type_AndroidWidgetButton.setContentDescription(paramajfc.jdField_a_of_type_AndroidWidgetButton.getText() + "");
            paramajfc.jdField_a_of_type_AndroidWidgetButton.setTag(paramajdw);
            paramajfc.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
            break;
            paramajfc.jdField_a_of_type_AndroidWidgetButton.setText("");
            continue;
            paramajfc.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramStructMsg.get(0)).name.get());
            paramajfc.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131755351);
            paramajfc.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839380);
          }
        }
        paramajfc.jdField_a_of_type_AndroidWidgetButton.setText("");
        paramajfc.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
      }
      else
      {
        paramajfc.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
        paramajfc.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
        paramajfc.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131755977);
        paramajfc.jdField_a_of_type_AndroidWidgetButton.setText(paramStructMsg.msg.msg_decided.get());
        paramajdw = (RelativeLayout.LayoutParams)paramajfc.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
      }
    }
    paramajfc.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
  }
  
  private void a(ajdw paramajdw, MessageRecord paramMessageRecord, int paramInt)
  {
    ajfc localajfc = (ajfc)paramajdw;
    if ((paramMessageRecord == null) || (!(paramMessageRecord instanceof MessageForSystemMsg))) {}
    for (;;)
    {
      return;
      localajfc.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = ((MessageForSystemMsg)paramMessageRecord).getSystemMsg();
      localajfc.jdField_c_of_type_Long = paramMessageRecord.uniseq;
      if (paramMessageRecord != null) {}
      for (int i = ((MessageForSystemMsg)paramMessageRecord).getSystemMsg().msg_type.get(); i == 2; i = 2)
      {
        if (paramInt < this.c)
        {
          ajhg.a(paramajdw.a(), true);
          paramMessageRecord = localajfc.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
          localajfc.jdField_a_of_type_Long = paramInt;
          localajfc.jdField_a_of_type_JavaLangString = (paramMessageRecord.req_uin.get() + "");
          localajfc.jdField_a_of_type_Int = paramMessageRecord.msg.group_msg_type.get();
          paramInt = paramMessageRecord.msg.sub_type.get();
          localajfc.jdField_b_of_type_Long = paramMessageRecord.msg_time.get();
          localajfc.jdField_b_of_type_JavaLangString = paramMessageRecord.msg.req_uin_nick.get();
          if ((localajfc.jdField_b_of_type_JavaLangString == null) || (localajfc.jdField_b_of_type_JavaLangString.equals(""))) {
            break label371;
          }
        }
        for (;;)
        {
          c(localajfc, paramMessageRecord);
          localajfc.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          String str = paramMessageRecord.msg.group_info.msg_alert.get();
          b(localajfc, paramMessageRecord);
          a(localajfc, paramMessageRecord);
          a(paramajdw, localajfc, paramMessageRecord, paramInt, str);
          if ((paramInt == 2) && (localajfc.jdField_a_of_type_Int == 2) && (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(String.valueOf(paramMessageRecord.msg.group_code.get())) != null)) {
            awub.a().b(String.valueOf(paramMessageRecord.msg.group_code.get()), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          }
          localajfc.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(paramajdw);
          localajfc.jdField_a_of_type_AndroidWidgetImageView.setTag(paramajdw);
          localajfc.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          b(localajfc);
          return;
          ajhg.a(paramajdw.a(), false);
          break;
          label371:
          localajfc.jdField_b_of_type_JavaLangString = localajfc.jdField_a_of_type_JavaLangString;
        }
      }
    }
  }
  
  private void a(ajfc paramajfc)
  {
    if (paramajfc == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopSuspiciousFragment", 2, "jumpToTroopRequestActivity!" + paramajfc.jdField_a_of_type_Long);
    }
    ajhg.a(paramajfc.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, "unnormal_edit");
    Intent localIntent = new Intent(getActivity(), TroopRequestActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putLong("troopMsgId", paramajfc.jdField_a_of_type_Long);
    localBundle.putInt("mTroopMsgType", paramajfc.jdField_a_of_type_Int);
    localBundle.putString("mTroopCode", String.valueOf(paramajfc.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()));
    localBundle.putString("troopmanagerUin", String.valueOf(paramajfc.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get()));
    localBundle.putString("troopsMsg", paramajfc.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
    int i = bdzy.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (paramajfc.jdField_b_of_type_Int < i) {}
    for (boolean bool = true;; bool = false)
    {
      localBundle.putBoolean("is_unread", bool);
      localBundle.putString("troopRequestUin", String.valueOf(paramajfc.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
      localBundle.putString("troopsummary", paramajfc.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get());
      localBundle.putLong("infotime", paramajfc.jdField_b_of_type_Long);
      if ((getActivity() instanceof TroopActivity)) {
        localBundle.putBoolean("troop_invitee_is_friend", a((ArrayList)((TroopActivity)getActivity()).jdField_a_of_type_JavaUtilList, String.valueOf(paramajfc.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get())));
      }
      if (paramajfc.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() != 83) {
        localIntent.putExtra("troopMsgDealInfo", paramajfc.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_detail.get());
      }
      ajhg.a((structmsg.StructMsg)paramajfc.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get());
      a((structmsg.StructMsg)paramajfc.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), paramajfc.jdField_c_of_type_Long);
      localBundle.putInt("t_s_f", 1001);
      localBundle.putBoolean("troop_suspicious_request", true);
      localIntent.putExtras(localBundle);
      startActivity(localIntent);
      return;
    }
  }
  
  private void a(ajfc paramajfc, structmsg.StructMsg paramStructMsg)
  {
    String str = TroopUtils.getMsgInfo(paramStructMsg, paramStructMsg.msg.msg_describe.get());
    if (str != null)
    {
      paramajfc.jdField_b_of_type_AndroidWidgetTextView.setText(str);
      return;
    }
    paramStructMsg = paramStructMsg.msg.msg_additional.get();
    if ((paramStructMsg == null) || ("".equals(paramStructMsg)))
    {
      paramajfc.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131695923));
      return;
    }
    paramajfc.jdField_b_of_type_AndroidWidgetTextView.setText(paramStructMsg);
  }
  
  public static void a(Context paramContext)
  {
    PublicFragmentActivity.a(paramContext, new Intent(), TroopSuspiciousFragment.class);
  }
  
  private void a(RecyclerView paramRecyclerView, String paramString, Bitmap paramBitmap)
  {
    Object localObject;
    ajfc localajfc;
    if (this.jdField_a_of_type_Int == 0)
    {
      int j = paramRecyclerView.getChildCount();
      int i = 0;
      while (i < j)
      {
        localObject = paramRecyclerView.findViewHolderForAdapterPosition(i);
        if ((localObject == null) || (!(localObject instanceof ajfc)))
        {
          i += 1;
        }
        else
        {
          localajfc = (ajfc)localObject;
          switch (ajfq.a(localajfc.jdField_a_of_type_Int))
          {
          default: 
            localObject = String.valueOf(localajfc.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
          }
        }
      }
    }
    while ((localajfc != null) && (paramString.equals(localObject)))
    {
      localajfc.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      return;
      localObject = localajfc.jdField_a_of_type_JavaLangString;
      continue;
      localObject = String.valueOf(localajfc.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
    }
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    b();
    this.jdField_a_of_type_Bisl = new bisl(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, a());
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView = ((OverScrollRecyclerView)paramView.findViewById(2131378317));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.addOnScrollListener(new ajgv(this));
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(this);
  }
  
  private void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    if (this.jdField_a_of_type_Bisl != null) {
      this.jdField_a_of_type_Bisl.dismiss();
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131718500);
    if (!TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, paramString2, 0).b(a());
      bdzz.a(bdzy.a().a(paramString4), paramInt, paramString1, paramString3);
      paramString1 = bdzy.a().a(paramString4);
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
    bdzy.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    if (this.jdField_a_of_type_Ajdm != null)
    {
      this.jdField_a_of_type_Ajdm.a();
      this.jdField_a_of_type_Ajdm.a(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_Ajdm.notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().a(true);
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
    if ((paramBoolean) && (this.jdField_a_of_type_Boolean))
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131719153);
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().a(i, l1, l2, j, k, m, n, (structmsg.SystemMsgActionInfo)localObject, paramInt);
    }
    label226:
    for (bool = true;; bool = false)
    {
      if ((k == 116) && (m == 0)) {
        bdla.b(null, "P_CliOper", "Grp_discuss", "", "verify_msg", "Clk_agree", 0, 0, String.valueOf(paramStructMsg.msg.group_code.get()), "", "", "");
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
    this.rightViewImg.setImageResource(2130840365);
    this.rightViewImg.setOnClickListener(new ajgy(this));
  }
  
  private void b(ajfc paramajfc)
  {
    int i = 1;
    if (paramajfc == null) {
      return;
    }
    Object localObject;
    String str;
    switch (ajfq.a(paramajfc.jdField_a_of_type_Int))
    {
    default: 
      localObject = String.valueOf(paramajfc.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
      i = 4;
      str = paramajfc.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_name.get() + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131696246);
    }
    for (;;)
    {
      localObject = ajfq.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder, (String)localObject, i);
      paramajfc.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(str);
      paramajfc.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      return;
      localObject = paramajfc.jdField_a_of_type_JavaLangString;
      str = paramajfc.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get() + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131696245);
      continue;
      localObject = String.valueOf(paramajfc.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
      str = paramajfc.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.get() + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131696244);
    }
  }
  
  private void b(ajfc paramajfc, structmsg.StructMsg paramStructMsg)
  {
    Object localObject = "";
    if (paramStructMsg.msg.bytes_warning_tips.get() != null) {
      localObject = paramStructMsg.msg.bytes_warning_tips.get().toStringUtf8();
    }
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramajfc.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      if (paramajfc.jdField_a_of_type_Int != 22) {
        break label237;
      }
      paramStructMsg = paramStructMsg.msg;
      paramajfc.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject = new SpannableString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131719151, new Object[] { paramStructMsg.action_uin_nick.get() }));
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#00a5e0")), 6, paramStructMsg.action_uin_nick.get().length() + 6, 33);
      paramajfc.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      paramajfc.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new ajhb(this, paramStructMsg));
    }
    label237:
    while ((paramajfc.jdField_a_of_type_Int != 2) || (!paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.has()))
    {
      return;
      paramajfc.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramajfc.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130847815);
      ((Drawable)localObject).setBounds(0, 0, ViewUtils.dip2px(16.0F), ViewUtils.dip2px(16.0F));
      paramajfc.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(ViewUtils.dip2px(5.0F));
      paramajfc.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
      break;
    }
    String str = "";
    switch (paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.get())
    {
    case 0: 
    default: 
      return;
    case 1: 
      localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      if (localObject == null) {
        break;
      }
    }
    for (paramStructMsg = ((TroopManager)localObject).a(String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()));; paramStructMsg = "")
    {
      paramajfc.jdField_c_of_type_AndroidWidgetTextView.setText(anvx.a(2131707086) + paramStructMsg);
      paramajfc.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
      antp localantp = (antp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
      localObject = str;
      if (localantp != null)
      {
        paramStructMsg = localantp.a(String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()));
        localObject = str;
        if (paramStructMsg != null) {
          localObject = paramStructMsg.discussionName;
        }
      }
      paramajfc.jdField_c_of_type_AndroidWidgetTextView.setText(anvx.a(2131707075) + (String)localObject);
      paramajfc.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_Ajdm = new ajgz(this, getActivity(), 2131559954);
    this.jdField_a_of_type_Ajdm.a(2131559955);
    this.jdField_a_of_type_Ajdm.a(2131561542);
    this.jdField_a_of_type_Ajdm.a(new ajha(this));
  }
  
  private void c(ajfc paramajfc, structmsg.StructMsg paramStructMsg)
  {
    if ((paramajfc == null) || (paramStructMsg == null)) {
      return;
    }
    if ((paramajfc.jdField_a_of_type_Int == 2) && (paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.has()))
    {
      String str1 = paramStructMsg.msg.action_uin_qq_nick.get().toStringUtf8();
      switch (paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.get())
      {
      default: 
        paramStructMsg = str1;
      }
      for (;;)
      {
        paramajfc.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg);
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
    switch (ajfq.a(paramajfc.jdField_a_of_type_Int))
    {
    default: 
      paramajfc.jdField_a_of_type_AndroidWidgetTextView.setText(paramajfc.jdField_b_of_type_JavaLangString);
      return;
    case 0: 
      paramajfc.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg.msg.group_name.get());
      return;
    case 1: 
      paramajfc.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg.msg.action_uin_nick.get());
      return;
    }
    paramajfc.jdField_a_of_type_AndroidWidgetTextView.setText(paramajfc.jdField_b_of_type_JavaLangString);
  }
  
  private void d()
  {
    this.jdField_b_of_type_Int = bdzy.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setAdapter(this.jdField_a_of_type_Ajdm);
    this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getMsgList(AppConstants.TROOP_SUSPICIOUS_MSG_UIN, 0);
    ajhg.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.clearGroupSystemMsgHistory();
      this.jdField_a_of_type_Ajdm.a(null);
      return;
    }
    this.jdField_a_of_type_Ajdm.a(this.jdField_a_of_type_JavaUtilList);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anyz);
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anyz);
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
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
        {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131692125), 0).b(a());
          return;
        }
      } while ((this.jdField_a_of_type_Awzf != null) && (this.jdField_a_of_type_Awzf.b()));
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_Ajdm != null) {
        this.jdField_a_of_type_Ajdm.a(new ajhe(this));
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().c(3);
    } while (!QLog.isColorLevel());
    QLog.i("TroopSuspiciousFragment", 2, "loadNextPage.get next page.");
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopSuspiciousFragment", 2, "stopLoadMore().");
    }
    if (this.jdField_a_of_type_Ajdm != null) {
      this.jdField_a_of_type_Ajdm.b();
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.c = bdzy.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
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
    bkzi localbkzi = (bkzi)bkzz.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null);
    localbkzi.a(2131696019, 5);
    localbkzi.c(2131690697);
    localbkzi.a(new ajgx(this, localbkzi));
    if ((!localbkzi.isShowing()) && (this != null) && (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing())) {}
    try
    {
      localbkzi.show();
      return;
    }
    catch (WindowManager.BadTokenException localBadTokenException)
    {
      localBadTokenException.printStackTrace();
    }
  }
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131299080);
  }
  
  public void a()
  {
    j();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.clearGroupSuspiciousMsg();
    bdzy.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    this.jdField_a_of_type_JavaUtilList.clear();
    if (this.jdField_a_of_type_Ajdm != null) {
      this.jdField_a_of_type_Ajdm.a();
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1012);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    this.jdField_a_of_type_Awzf = ((awzf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOPINFO_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = getActivity();
    a(this.mContentView);
    c();
    d();
    e();
  }
  
  public int getContentLayoutId()
  {
    return 2131561576;
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
    setTitle(getActivity().getString(2131698935));
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
    bdzy.a().b();
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(getClass());
    }
    if (this.jdField_a_of_type_Awzf != null) {
      this.jdField_a_of_type_Awzf.b(false);
    }
  }
  
  public void onFinish()
  {
    super.onFinish();
    if ((this.jdField_b_of_type_Int > 0) && (this.jdField_a_of_type_Ajdm != null) && (this.jdField_a_of_type_Ajdm.a() > 0)) {
      j();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    i();
    bdzy.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
  }
  
  public void onStop()
  {
    super.onStop();
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.pause();
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.cancelPendingRequests();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopSuspiciousFragment
 * JD-Core Version:    0.7.0.1
 */