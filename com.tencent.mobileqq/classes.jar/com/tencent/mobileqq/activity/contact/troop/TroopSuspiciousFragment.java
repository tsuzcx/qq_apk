package com.tencent.mobileqq.activity.contact.troop;

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
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.activity.contact.recommendtroop.base.CommonAdapter;
import com.tencent.mobileqq.activity.contact.recommendtroop.base.ViewHolder;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.Stranger;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.managers.TroopRemindSettingManager;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.systemmsg.SystemMsgUtils;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.OverScrollRecyclerView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
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
  implements DecodeTaskCompletionListener
{
  protected int a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new TroopSuspiciousFragment.6(this);
  private CommonAdapter jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseCommonAdapter;
  protected BaseActivity a;
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new TroopSuspiciousFragment.9(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected IFaceDecoder a;
  protected TroopInfoManager a;
  private OverScrollRecyclerView jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  protected List<MessageRecord> a;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new TroopSuspiciousFragment.10(this);
  protected boolean a;
  private int b;
  protected View.OnClickListener b;
  protected boolean b;
  private int c;
  
  public TroopSuspiciousFragment()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new TroopSuspiciousFragment.7(this);
  }
  
  private void a(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131692705);
    Object localObject;
    if (paramInt1 == 1)
    {
      localObject = GroupSystemMsgController.a().a(paramString2);
      if ((localObject != null) && (((structmsg.StructMsg)localObject).msg.group_msg_type.get() == 82)) {
        localObject = paramString1;
      }
    }
    for (;;)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, (CharSequence)localObject, 0).b(a());
      long l = GroupSystemMsgController.a().a();
      SystemMsgUtils.a(GroupSystemMsgController.a().a(paramString2), paramInt1, paramString1, paramInt2);
      paramString1 = GroupSystemMsgController.a().a(paramString2);
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
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(AppConstants.TROOP_SUSPICIOUS_MSG_UIN, 0, l, paramString1.toByteArray());
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
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131692699);
      continue;
      if (paramInt1 == 2)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131692704);
      }
      else
      {
        localObject = str;
        if (paramInt1 == 0)
        {
          localStructMsg = GroupSystemMsgController.a().a(paramString2);
          localObject = str;
          if (localStructMsg != null)
          {
            localObject = str;
            if (localStructMsg.msg.group_msg_type.get() == 82) {
              localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131692704);
            }
          }
        }
      }
    }
  }
  
  public static void a(Context paramContext)
  {
    PublicFragmentActivity.a(paramContext, new Intent(), TroopSuspiciousFragment.class);
  }
  
  private void a(RecyclerView paramRecyclerView, String paramString, Bitmap paramBitmap)
  {
    Object localObject;
    SuspiciousHolder localSuspiciousHolder;
    if (this.jdField_a_of_type_Int == 0)
    {
      int j = paramRecyclerView.getChildCount();
      int i = 0;
      while (i < j)
      {
        localObject = paramRecyclerView.findViewHolderForAdapterPosition(i);
        if ((localObject == null) || (!(localObject instanceof SuspiciousHolder)))
        {
          i += 1;
        }
        else
        {
          localSuspiciousHolder = (SuspiciousHolder)localObject;
          switch (TroopNotificationUtils.a(localSuspiciousHolder.jdField_a_of_type_Int))
          {
          default: 
            localObject = String.valueOf(localSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
          }
        }
      }
    }
    while ((localSuspiciousHolder != null) && (paramString.equals(localObject)))
    {
      localSuspiciousHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      return;
      localObject = localSuspiciousHolder.jdField_a_of_type_JavaLangString;
      continue;
      localObject = String.valueOf(localSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
    }
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    b();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, a());
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView = ((OverScrollRecyclerView)paramView.findViewById(2131378743));
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView.addOnScrollListener(new TroopSuspiciousFragment.1(this));
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
  }
  
  private void a(ViewHolder paramViewHolder, SuspiciousHolder paramSuspiciousHolder, structmsg.StructMsg paramStructMsg, int paramInt, String paramString)
  {
    if (paramSuspiciousHolder.jdField_a_of_type_Int == 80)
    {
      paramViewHolder = paramStructMsg.msg.actions.get();
      paramSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
      paramSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramViewHolder.get(0)).name.get());
      paramSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131755358);
      paramSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839458);
      paramSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setContentDescription(paramSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.getText() + "");
      paramSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setTag(paramSuspiciousHolder);
      paramSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    }
    while (TextUtils.isEmpty(paramSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.getText()))
    {
      paramSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      return;
      if (paramInt == 1)
      {
        paramStructMsg = paramStructMsg.msg.actions.get();
        paramSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
        if ((paramStructMsg != null) && (paramStructMsg.size() > 0))
        {
          if ((paramString == null) || ("".equals(paramString))) {
            if (paramStructMsg.size() > 1)
            {
              paramSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramStructMsg.get(1)).name.get());
              paramSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131755358);
              paramSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839458);
            }
          }
          for (;;)
          {
            paramSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setContentDescription(paramSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.getText() + "");
            paramSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setTag(paramViewHolder);
            paramSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
            break;
            paramSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setText("");
            continue;
            paramSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramStructMsg.get(0)).name.get());
            paramSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131755357);
            paramSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839457);
          }
        }
        paramSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setText("");
        paramSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
      }
      else
      {
        paramSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
        paramSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
        paramSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131755991);
        paramSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setText(paramStructMsg.msg.msg_decided.get());
        paramViewHolder = (RelativeLayout.LayoutParams)paramSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
      }
    }
    paramSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
  }
  
  private void a(ViewHolder paramViewHolder, MessageRecord paramMessageRecord, int paramInt)
  {
    SuspiciousHolder localSuspiciousHolder = (SuspiciousHolder)paramViewHolder;
    if ((paramMessageRecord == null) || (!(paramMessageRecord instanceof MessageForSystemMsg))) {}
    for (;;)
    {
      return;
      localSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = ((MessageForSystemMsg)paramMessageRecord).getSystemMsg();
      localSuspiciousHolder.jdField_c_of_type_Long = paramMessageRecord.uniseq;
      if (paramMessageRecord != null) {}
      for (int i = ((MessageForSystemMsg)paramMessageRecord).getSystemMsg().msg_type.get(); i == 2; i = 2)
      {
        if (paramInt < this.c)
        {
          TroopSuspiciousHelper.a(paramViewHolder.a(), true);
          paramMessageRecord = localSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
          localSuspiciousHolder.jdField_a_of_type_Long = paramInt;
          localSuspiciousHolder.jdField_a_of_type_JavaLangString = (paramMessageRecord.req_uin.get() + "");
          localSuspiciousHolder.jdField_a_of_type_Int = paramMessageRecord.msg.group_msg_type.get();
          paramInt = paramMessageRecord.msg.sub_type.get();
          localSuspiciousHolder.jdField_b_of_type_Long = paramMessageRecord.msg_time.get();
          localSuspiciousHolder.jdField_b_of_type_JavaLangString = paramMessageRecord.msg.req_uin_nick.get();
          if ((localSuspiciousHolder.jdField_b_of_type_JavaLangString == null) || (localSuspiciousHolder.jdField_b_of_type_JavaLangString.equals(""))) {
            break label371;
          }
        }
        for (;;)
        {
          c(localSuspiciousHolder, paramMessageRecord);
          localSuspiciousHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          String str = paramMessageRecord.msg.group_info.msg_alert.get();
          b(localSuspiciousHolder, paramMessageRecord);
          a(localSuspiciousHolder, paramMessageRecord);
          a(paramViewHolder, localSuspiciousHolder, paramMessageRecord, paramInt, str);
          if ((paramInt == 2) && (localSuspiciousHolder.jdField_a_of_type_Int == 2) && (((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(String.valueOf(paramMessageRecord.msg.group_code.get())) != null)) {
            TroopRemindSettingManager.a().b(String.valueOf(paramMessageRecord.msg.group_code.get()), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          }
          localSuspiciousHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(paramViewHolder);
          localSuspiciousHolder.jdField_a_of_type_AndroidWidgetImageView.setTag(paramViewHolder);
          localSuspiciousHolder.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          b(localSuspiciousHolder);
          return;
          TroopSuspiciousHelper.a(paramViewHolder.a(), false);
          break;
          label371:
          localSuspiciousHolder.jdField_b_of_type_JavaLangString = localSuspiciousHolder.jdField_a_of_type_JavaLangString;
        }
      }
    }
  }
  
  private void a(SuspiciousHolder paramSuspiciousHolder)
  {
    if (paramSuspiciousHolder == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopSuspiciousFragment", 2, "jumpToTroopRequestActivity!" + paramSuspiciousHolder.jdField_a_of_type_Long);
    }
    TroopSuspiciousHelper.a(paramSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, "unnormal_edit");
    Intent localIntent = new Intent(getActivity(), TroopRequestActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putLong("troopMsgId", paramSuspiciousHolder.jdField_a_of_type_Long);
    localBundle.putInt("mTroopMsgType", paramSuspiciousHolder.jdField_a_of_type_Int);
    localBundle.putString("mTroopCode", String.valueOf(paramSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()));
    localBundle.putString("troopmanagerUin", String.valueOf(paramSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get()));
    localBundle.putString("troopsMsg", paramSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
    int i = GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (paramSuspiciousHolder.jdField_b_of_type_Int < i) {}
    for (boolean bool = true;; bool = false)
    {
      localBundle.putBoolean("is_unread", bool);
      localBundle.putString("troopRequestUin", String.valueOf(paramSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
      localBundle.putString("troopsummary", paramSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get());
      localBundle.putLong("infotime", paramSuspiciousHolder.jdField_b_of_type_Long);
      if ((getActivity() instanceof TroopActivity)) {
        localBundle.putBoolean("troop_invitee_is_friend", a((ArrayList)((TroopActivity)getActivity()).jdField_a_of_type_JavaUtilList, String.valueOf(paramSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get())));
      }
      if (paramSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() != 83) {
        localIntent.putExtra("troopMsgDealInfo", paramSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_detail.get());
      }
      TroopSuspiciousHelper.a((structmsg.StructMsg)paramSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get());
      a((structmsg.StructMsg)paramSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), paramSuspiciousHolder.jdField_c_of_type_Long);
      localBundle.putInt("t_s_f", 1001);
      localBundle.putBoolean("troop_suspicious_request", true);
      localIntent.putExtras(localBundle);
      startActivity(localIntent);
      return;
    }
  }
  
  private void a(SuspiciousHolder paramSuspiciousHolder, structmsg.StructMsg paramStructMsg)
  {
    String str = TroopUtils.a(paramStructMsg, paramStructMsg.msg.msg_describe.get());
    if (str != null)
    {
      paramSuspiciousHolder.jdField_b_of_type_AndroidWidgetTextView.setText(str);
      return;
    }
    paramStructMsg = paramStructMsg.msg.msg_additional.get();
    if ((paramStructMsg == null) || ("".equals(paramStructMsg)))
    {
      paramSuspiciousHolder.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131696171));
      return;
    }
    paramSuspiciousHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramStructMsg);
  }
  
  private void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131719023);
    if (!TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, paramString2, 0).b(a());
      SystemMsgUtils.a(GroupSystemMsgController.a().a(paramString4), paramInt, paramString1, paramString3);
      paramString1 = GroupSystemMsgController.a().a(paramString4);
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
    GroupSystemMsgController.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseCommonAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseCommonAdapter.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseCommonAdapter.a(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseCommonAdapter.notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().a(true);
    }
  }
  
  private void a(structmsg.StructMsg paramStructMsg, long paramLong)
  {
    if (paramStructMsg != null)
    {
      String str = ((structmsg.StructMsg)paramStructMsg.get()).msg_seq.get() + "_" + ((structmsg.StructMsg)paramStructMsg.get()).msg_type.get();
      GroupSystemMsgController.a().a(str, (structmsg.StructMsg)paramStructMsg.get());
      GroupSystemMsgController.a().b(str);
      GroupSystemMsgController.a().a(paramLong);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_b_of_type_Boolean))
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131719695);
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
        ReportController.b(null, "P_CliOper", "Grp_discuss", "", "verify_msg", "Clk_agree", 0, 0, String.valueOf(paramStructMsg.msg.group_code.get()), "", "", "");
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
    this.rightViewImg.setImageResource(2130840478);
    this.rightViewImg.setOnClickListener(new TroopSuspiciousFragment.2(this));
  }
  
  private void b(SuspiciousHolder paramSuspiciousHolder)
  {
    int i = 1;
    if (paramSuspiciousHolder == null) {
      return;
    }
    Object localObject;
    String str;
    switch (TroopNotificationUtils.a(paramSuspiciousHolder.jdField_a_of_type_Int))
    {
    default: 
      localObject = String.valueOf(paramSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
      i = 4;
      str = paramSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_name.get() + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131696499);
    }
    for (;;)
    {
      localObject = TroopNotificationUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, (String)localObject, i);
      paramSuspiciousHolder.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(str);
      paramSuspiciousHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      return;
      localObject = paramSuspiciousHolder.jdField_a_of_type_JavaLangString;
      str = paramSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get() + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131696498);
      continue;
      localObject = String.valueOf(paramSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
      str = paramSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.get() + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131696497);
    }
  }
  
  private void b(SuspiciousHolder paramSuspiciousHolder, structmsg.StructMsg paramStructMsg)
  {
    Object localObject = "";
    if (paramStructMsg.msg.bytes_warning_tips.get() != null) {
      localObject = paramStructMsg.msg.bytes_warning_tips.get().toStringUtf8();
    }
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramSuspiciousHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      if (paramSuspiciousHolder.jdField_a_of_type_Int != 22) {
        break label237;
      }
      paramStructMsg = paramStructMsg.msg;
      paramSuspiciousHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject = new SpannableString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131719693, new Object[] { paramStructMsg.action_uin_nick.get() }));
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#00a5e0")), 6, paramStructMsg.action_uin_nick.get().length() + 6, 33);
      paramSuspiciousHolder.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      paramSuspiciousHolder.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new TroopSuspiciousFragment.5(this, paramStructMsg));
    }
    label237:
    while ((paramSuspiciousHolder.jdField_a_of_type_Int != 2) || (!paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.has()))
    {
      return;
      paramSuspiciousHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramSuspiciousHolder.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130848172);
      ((Drawable)localObject).setBounds(0, 0, ViewUtils.a(16.0F), ViewUtils.a(16.0F));
      paramSuspiciousHolder.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(ViewUtils.a(5.0F));
      paramSuspiciousHolder.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
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
      paramSuspiciousHolder.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131707611) + paramStructMsg);
      paramSuspiciousHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
      DiscussionManager localDiscussionManager = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
      localObject = str;
      if (localDiscussionManager != null)
      {
        paramStructMsg = localDiscussionManager.a(String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()));
        localObject = str;
        if (paramStructMsg != null) {
          localObject = paramStructMsg.discussionName;
        }
      }
      paramSuspiciousHolder.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131707600) + (String)localObject);
      paramSuspiciousHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseCommonAdapter = new TroopSuspiciousFragment.3(this, getActivity(), 2131560030);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseCommonAdapter.a(2131560031);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseCommonAdapter.a(2131561659);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseCommonAdapter.a(new TroopSuspiciousFragment.4(this));
  }
  
  private void c(SuspiciousHolder paramSuspiciousHolder, structmsg.StructMsg paramStructMsg)
  {
    if ((paramSuspiciousHolder == null) || (paramStructMsg == null)) {
      return;
    }
    if ((paramSuspiciousHolder.jdField_a_of_type_Int == 2) && (paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.has()))
    {
      String str1 = paramStructMsg.msg.action_uin_qq_nick.get().toStringUtf8();
      switch (paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.get())
      {
      default: 
        paramStructMsg = str1;
      }
      for (;;)
      {
        paramSuspiciousHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg);
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
        str1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str3, str2, paramStructMsg, true, null);
        paramStructMsg = str1;
        if (TextUtils.isEmpty(str1))
        {
          paramStructMsg = ((TroopManager)localObject).a(str2, str3);
          continue;
          localObject = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
          if (localObject == null) {
            break;
          }
          paramStructMsg = ((DiscussionManager)localObject).a(String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()), String.valueOf(paramStructMsg.msg.action_uin.get()));
          if (paramStructMsg == null) {
            break;
          }
          paramStructMsg = paramStructMsg.getDiscussionMemberName();
        }
      }
    }
    switch (TroopNotificationUtils.a(paramSuspiciousHolder.jdField_a_of_type_Int))
    {
    default: 
      paramSuspiciousHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramSuspiciousHolder.jdField_b_of_type_JavaLangString);
      return;
    case 0: 
      paramSuspiciousHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg.msg.group_name.get());
      return;
    case 1: 
      paramSuspiciousHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg.msg.action_uin_nick.get());
      return;
    }
    paramSuspiciousHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramSuspiciousHolder.jdField_b_of_type_JavaLangString);
  }
  
  private void d()
  {
    this.jdField_b_of_type_Int = GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseCommonAdapter);
    this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(AppConstants.TROOP_SUSPICIOUS_MSG_UIN, 0);
    TroopSuspiciousHelper.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
      this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseCommonAdapter.a(null);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseCommonAdapter.a(this.jdField_a_of_type_JavaUtilList);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    }
  }
  
  private void g()
  {
    if (this.jdField_b_of_type_Boolean) {}
    do
    {
      do
      {
        return;
        if (!NetworkUtil.d(BaseApplication.getContext()))
        {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getString(2131692257), 0).b(a());
          return;
        }
      } while ((this.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager != null) && (this.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager.b()));
      this.jdField_b_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseCommonAdapter != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseCommonAdapter.a(new TroopSuspiciousFragment.8(this));
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseCommonAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseCommonAdapter.b();
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.c = GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null);
    localActionSheet.addButton(2131696267, 5);
    localActionSheet.addCancelButton(2131690800);
    localActionSheet.setOnButtonClickListener(new TroopSuspiciousFragment.12(this, localActionSheet));
    if ((!localActionSheet.isShowing()) && (this != null) && (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing())) {}
    try
    {
      localActionSheet.show();
      return;
    }
    catch (WindowManager.BadTokenException localBadTokenException)
    {
      localBadTokenException.printStackTrace();
    }
  }
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131299166);
  }
  
  public void a()
  {
    j();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.clearGroupSuspiciousMsg();
    GroupSystemMsgController.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
    this.jdField_a_of_type_JavaUtilList.clear();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseCommonAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseCommonAdapter.a();
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1012);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    this.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager = ((TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOPINFO_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = getActivity();
    a(this.mContentView);
    c();
    d();
    e();
  }
  
  public int getContentLayoutId()
  {
    return 2131561693;
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
    setTitle(getActivity().getString(2131699279));
    return localView;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollRecyclerView, paramString, paramBitmap);
  }
  
  public void onDestroy()
  {
    f();
    super.onDestroy();
    GroupSystemMsgController.a().b();
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(getClass());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqModelTroopInfoManager.b(false);
    }
  }
  
  public void onFinish()
  {
    super.onFinish();
    if ((this.jdField_b_of_type_Int > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseCommonAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityContactRecommendtroopBaseCommonAdapter.a() > 0)) {
      j();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    i();
    GroupSystemMsgController.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
  }
  
  public void onStop()
  {
    super.onStop();
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.pause();
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.cancelPendingRequests();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopSuspiciousFragment
 * JD-Core Version:    0.7.0.1
 */