package com.tencent.mobileqq.activity.contact.newfriend;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.KplRoleInfo.WZRYUIinfo;
import com.tencent.mobileqq.newfriend.FriendSystemMessage;
import com.tencent.mobileqq.newfriend.NewFriendMessage;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Locale;
import tencent.mobileim.structmsg.structmsg.AddFrdSNInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class SystemMsgItemBuilder
  extends NewFriendBaseBuilder
  implements View.OnClickListener
{
  public long a;
  private NewFriendManager jdField_a_of_type_ComTencentMobileqqAppNewFriendManager;
  private String jdField_a_of_type_JavaLangString;
  private structmsg.StructMsg jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
  private long b;
  
  public SystemMsgItemBuilder(Context paramContext, QQAppInterface paramQQAppInterface, SystemMsgListAdapter paramSystemMsgListAdapter, NewFriendMessage paramNewFriendMessage)
  {
    super(paramContext, paramQQAppInterface, paramSystemMsgListAdapter, paramNewFriendMessage);
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = ((FriendSystemMessage)paramNewFriendMessage).a.getSystemMsg();
    this.b = ((FriendSystemMessage)paramNewFriendMessage).a.uniseq;
    this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder = a(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager = ((NewFriendManager)paramQQAppInterface.getManager(33));
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint32_source_flag.has()) {}
    for (int i = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint32_source_flag.get();; i = 0)
    {
      if ((i & 0x8) == 8)
      {
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint64_discuss_uin.has()) {
          this.jdField_a_of_type_Long = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint64_discuss_uin.get();
        }
        if (!this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.has()) {
          break label343;
        }
      }
      label326:
      label343:
      for (paramContext = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get();; paramContext = null)
      {
        long l;
        if (this.jdField_a_of_type_Long != 0L)
        {
          this.jdField_a_of_type_JavaLangString = ContactUtils.c(paramQQAppInterface, String.valueOf(this.jdField_a_of_type_Long));
          if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
          {
            paramQQAppInterface = (DiscussionHandler)paramQQAppInterface.a(6);
            if (paramQQAppInterface != null) {
              paramQQAppInterface.a(this.jdField_a_of_type_Long);
            }
            if (QLog.isColorLevel())
            {
              paramSystemMsgListAdapter = Locale.getDefault();
              l = this.jdField_a_of_type_Long;
              if (paramQQAppInterface != null) {
                break label326;
              }
            }
          }
        }
        for (paramQQAppInterface = "handler is null";; paramQQAppInterface = "handler is not null")
        {
          QLog.i("addFriendTag", 2, String.format(paramSystemMsgListAdapter, "SystemMsgItemBuilder need get discuss info %d  %s", new Object[] { Long.valueOf(l), paramQQAppInterface }));
          if (QLog.isColorLevel()) {
            QLog.i("addFriendTag", 2, String.format(Locale.getDefault(), "SystemMsgItemBuilder source_flag: %d  discussUin: %d mDiscussName: %s msg_source: %s", new Object[] { Integer.valueOf(i), Long.valueOf(this.jdField_a_of_type_Long), this.jdField_a_of_type_JavaLangString, paramContext }));
          }
          return;
        }
        this.jdField_a_of_type_JavaLangString = null;
        this.jdField_a_of_type_Long = 0L;
        return;
      }
    }
  }
  
  private void a(SystemMsgItemBuilder.SystemMsgItemHolder paramSystemMsgItemHolder)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("SystemMsgItemBuilder", 2, "handleBuddySystemMsg! start " + paramSystemMsgItemHolder.jdField_a_of_type_Long);
    }
    int j = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
    KplRoleInfo.WZRYUIinfo localWZRYUIinfo = null;
    if (FriendSystemMessage.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, true)) {
      localWZRYUIinfo = KplRoleInfo.WZRYUIinfo.createInfo(String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), paramSystemMsgItemHolder.h.getText().toString(), "", this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get(), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get());
    }
    switch (j)
    {
    case 11: 
    default: 
      i = 0;
    case 1: 
    case 9: 
    case 10: 
    case 0: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 12: 
      for (;;)
      {
        Object localObject2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get();
        Object localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get());
        }
        localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, AddRequestActivity.class);
        ((Intent)localObject2).putExtra("infoid", paramSystemMsgItemHolder.jdField_a_of_type_Long);
        ((Intent)localObject2).putExtra("infouin", String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
        ((Intent)localObject2).putExtra("infonick", (String)localObject1);
        ((Intent)localObject2).putExtra("infotime", this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_time.get());
        ((Intent)localObject2).putExtra("msg_type", this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get());
        ((Intent)localObject2).putExtra("strNickName", (String)localObject1);
        ((Intent)localObject2).putExtra("verify_msg", this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
        ((Intent)localObject2).putExtra("msg_source", this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get());
        ((Intent)localObject2).putExtra("msg_troopuin", this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
        ((Intent)localObject2).putExtra("system_message_summary", this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get());
        ((Intent)localObject2).putExtra("info_dealwith_msg", this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_detail.get());
        ((Intent)localObject2).putExtra("msg_title", this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_title.get());
        ((Intent)localObject2).putExtra("msg_source_id", this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get());
        if (i > 0) {
          ((Intent)localObject2).putExtra("verify_type", i);
        }
        if (localWZRYUIinfo != null)
        {
          ((Intent)localObject2).putExtra("param_wzry_data", localWZRYUIinfo);
          ((Intent)localObject2).putExtra("strNickName", localWZRYUIinfo.nick);
          ((Intent)localObject2).putExtra("infonick", localWZRYUIinfo.nick);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800843B", "0X800843B", 0, 0, "", "", "", "");
        }
        a((structmsg.StructMsg)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), this.b);
        ((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult((Intent)localObject2, 227);
        this.jdField_a_of_type_ComTencentMobileqqAppNewFriendManager.e();
        return;
        i = 2;
        continue;
        i = 2;
        continue;
        i = 0;
      }
    }
    paramSystemMsgItemHolder = new Intent();
    paramSystemMsgItemHolder.putExtra("param_wzry_data", localWZRYUIinfo);
    SystemMessageHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get(), j, this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get(), paramSystemMsgItemHolder);
  }
  
  private void a(SystemMsgItemBuilder.SystemMsgItemHolder paramSystemMsgItemHolder, int paramInt, View.OnClickListener paramOnClickListener)
  {
    paramSystemMsgItemHolder.jdField_a_of_type_Long = paramInt;
    paramSystemMsgItemHolder.jdField_f_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get());
    paramSystemMsgItemHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
    String str = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get());
    Object localObject3 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    Object localObject2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get();
    Friends localFriends = ((FriendsManager)localObject3).a(String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
    Object localObject1 = localObject2;
    if (localFriends != null)
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(localFriends.remark)) {
        localObject1 = localFriends.remark;
      }
    }
    localObject2 = localObject1;
    if (ProfileActivity.e(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get()))
    {
      localObject3 = ((FriendsManager)localObject3).b(str);
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        localObject2 = localObject3;
      }
    }
    localObject1 = localObject2;
    if (FriendSystemMessage.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, true))
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.bytes_game_nick.has())
      {
        localObject3 = new String(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.bytes_game_nick.get().toByteArray());
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          localObject1 = KplRoleInfo.WZRYUIinfo.buildNickName((String)localObject2, (String)localObject3);
        }
      }
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = str;
    }
    paramSystemMsgItemHolder.h.setText((CharSequence)localObject2);
    if ((!TextUtils.isEmpty(str)) && (Utils.b(str)))
    {
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839766);
      ((Drawable)localObject1).setBounds(0, 0, AIOUtils.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      paramSystemMsgItemHolder.h.setCompoundDrawables(null, null, (Drawable)localObject1, null);
      paramSystemMsgItemHolder.h.setCompoundDrawablePadding(AIOUtils.a(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      if (QLog.isColorLevel()) {
        QLog.d("SystemMsgItemBuilder", 2, "bindBuddySystemMsgView|position is : " + paramInt + ",name is : " + (String)localObject2 + ",source is : " + this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get());
      }
      this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.a(paramSystemMsgItemHolder);
      paramSystemMsgItemHolder.jdField_f_of_type_AndroidWidgetImageView.setTag(paramSystemMsgItemHolder);
      paramSystemMsgItemHolder.l.setVisibility(8);
      if (!this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.has()) {
        break label1967;
      }
    }
    label548:
    label1967:
    for (localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get();; localObject1 = null)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
        {
          localObject1 = String.format(Locale.getDefault(), "来源：%s-%s", new Object[] { localObject1, this.jdField_a_of_type_JavaLangString });
          paramSystemMsgItemHolder.j.setText((CharSequence)localObject1);
          paramSystemMsgItemHolder.j.setVisibility(0);
          label565:
          if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg != null)
          {
            if (TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get())) {
              break label877;
            }
            if (TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_qna.get())) {
              break label854;
            }
            paramSystemMsgItemHolder.i.setText(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_qna.get());
            label633:
            paramInt = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
            if (QLog.isColorLevel()) {
              QLog.d("SystemMsgItemBuilder", 2, "bindBuddySystemMsgView|myAllowFlag : " + paramInt);
            }
            switch (paramInt)
            {
            }
          }
        }
      }
      for (;;)
      {
        paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setTag(paramSystemMsgItemHolder);
        paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramOnClickListener);
        paramOnClickListener = this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131494243);
        if (paramOnClickListener != null) {
          paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setTextColor(paramOnClickListener);
        }
        paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130838515);
        return;
        paramSystemMsgItemHolder.h.setCompoundDrawables(null, null, null, null);
        break;
        localObject1 = String.format(Locale.getDefault(), "来源：%s", new Object[] { localObject1 });
        break label548;
        paramSystemMsgItemHolder.j.setVisibility(8);
        break label565;
        label854:
        paramSystemMsgItemHolder.i.setText(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
        break label633;
        label877:
        paramSystemMsgItemHolder.i.setText(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get());
        break label633;
        if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get() != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().get(0)).name.get())))
        {
          paramSystemMsgItemHolder.k.setVisibility(8);
          paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
          localObject1 = ((structmsg.SystemMsgAction)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().get(0)).name.get();
          paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject1);
        }
        for (;;)
        {
          b(paramSystemMsgItemHolder);
          break;
          if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get() != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().size() == 0))
          {
            paramSystemMsgItemHolder.k.setVisibility(0);
            localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
            paramSystemMsgItemHolder.k.setText((CharSequence)localObject1);
            paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          }
        }
        paramSystemMsgItemHolder.k.setVisibility(0);
        localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
        paramSystemMsgItemHolder.k.setText((CharSequence)localObject1);
        paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        b(paramSystemMsgItemHolder);
        continue;
        paramSystemMsgItemHolder.k.setVisibility(0);
        localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
        paramSystemMsgItemHolder.k.setText((CharSequence)localObject1);
        paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        b(paramSystemMsgItemHolder);
        continue;
        paramSystemMsgItemHolder.k.setVisibility(8);
        paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        continue;
        paramSystemMsgItemHolder.k.setVisibility(8);
        paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        continue;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get()))
        {
          paramSystemMsgItemHolder.j.setText(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
          paramSystemMsgItemHolder.i.setText(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get());
        }
        for (;;)
        {
          paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          paramSystemMsgItemHolder.k.setVisibility(8);
          break;
          paramSystemMsgItemHolder.j.setVisibility(8);
        }
        paramSystemMsgItemHolder.k.setVisibility(0);
        localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
        paramSystemMsgItemHolder.k.setText((CharSequence)localObject1);
        paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        b(paramSystemMsgItemHolder);
        continue;
        paramSystemMsgItemHolder.k.setVisibility(0);
        localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
        paramSystemMsgItemHolder.k.setText((CharSequence)localObject1);
        paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        continue;
        if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get() != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().get(0)).name.get())))
        {
          paramSystemMsgItemHolder.k.setVisibility(8);
          paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
          localObject1 = ((structmsg.SystemMsgAction)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().get(0)).name.get();
          paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject1);
        }
        for (;;)
        {
          b(paramSystemMsgItemHolder);
          break;
          paramSystemMsgItemHolder.k.setVisibility(0);
          localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
          paramSystemMsgItemHolder.k.setText((CharSequence)localObject1);
          paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        }
        if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get() != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().get(0)).name.get())))
        {
          paramSystemMsgItemHolder.k.setVisibility(8);
          paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
          localObject1 = ((structmsg.SystemMsgAction)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().get(0)).name.get();
          paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject1);
        }
        for (;;)
        {
          b(paramSystemMsgItemHolder);
          break;
          paramSystemMsgItemHolder.k.setVisibility(0);
          localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
          paramSystemMsgItemHolder.k.setText((CharSequence)localObject1);
          paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        }
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.reqsubtype.has()) {
          if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.reqsubtype.get() == 1)
          {
            paramSystemMsgItemHolder.k.setVisibility(0);
            localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
            paramSystemMsgItemHolder.k.setText((CharSequence)localObject1);
            paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          }
          else if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.reqsubtype.get() == 2)
          {
            paramSystemMsgItemHolder.k.setVisibility(8);
            paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
            continue;
            paramSystemMsgItemHolder.k.setVisibility(0);
            localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
            paramSystemMsgItemHolder.k.setText((CharSequence)localObject1);
            paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
            paramSystemMsgItemHolder.j.setVisibility(8);
          }
        }
      }
    }
  }
  
  private void a(structmsg.StructMsg paramStructMsg, long paramLong)
  {
    if (paramStructMsg != null)
    {
      long l = ((structmsg.StructMsg)paramStructMsg.get()).msg_seq.get() + ((structmsg.StructMsg)paramStructMsg.get()).msg_type.get();
      FriendSystemMsgController.a().a(Long.valueOf(l), (structmsg.StructMsg)paramStructMsg.get());
      FriendSystemMsgController.a().b(l);
      FriendSystemMsgController.a().a(paramLong);
    }
  }
  
  private void b(SystemMsgItemBuilder.SystemMsgItemHolder paramSystemMsgItemHolder)
  {
    int i = -1;
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_gender.has()) {
      i = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_gender.get();
    }
    int j;
    switch (i)
    {
    default: 
      paramSystemMsgItemHolder.l.setBackgroundResource(2130843152);
      j = 0;
      i = 0;
      k = i;
      if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_age.has())
      {
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_age.get() <= 0) {
          break label207;
        }
        paramSystemMsgItemHolder.l.setText(String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_age.get()));
      }
      break;
    }
    for (int k = 1;; k = i)
    {
      paramSystemMsgItemHolder.l.setCompoundDrawablesWithIntrinsicBounds(j, 0, 0, 0);
      if (k == 0) {
        break label222;
      }
      paramSystemMsgItemHolder.l.setVisibility(0);
      paramSystemMsgItemHolder.l.setPadding(8, 4, 8, 4);
      return;
      j = 2130843151;
      paramSystemMsgItemHolder.l.setBackgroundResource(2130843152);
      i = 1;
      break;
      j = 2130843149;
      paramSystemMsgItemHolder.l.setBackgroundResource(2130843150);
      i = 1;
      break;
      label207:
      paramSystemMsgItemHolder.l.setText("");
    }
    label222:
    paramSystemMsgItemHolder.l.setVisibility(8);
  }
  
  protected int a()
  {
    return ((FriendSystemMessage)this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage).a.mSysmsgMenuFlag;
  }
  
  public View a(int paramInt, View paramView)
  {
    SystemMsgItemBuilder.SystemMsgItemHolder localSystemMsgItemHolder;
    if ((paramView == null) || (!(paramView.getTag() instanceof SystemMsgItemBuilder.SystemMsgItemHolder)))
    {
      localSystemMsgItemHolder = new SystemMsgItemBuilder.SystemMsgItemHolder();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2130970650, localSystemMsgItemHolder);
      localSystemMsgItemHolder.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366543));
      localSystemMsgItemHolder.h = ((TextView)paramView.findViewById(2131362899));
      localSystemMsgItemHolder.i = ((TextView)paramView.findViewById(2131369991));
      localSystemMsgItemHolder.l = ((TextView)paramView.findViewById(2131371530));
      localSystemMsgItemHolder.j = ((TextView)paramView.findViewById(2131369993));
      localSystemMsgItemHolder.k = ((TextView)paramView.findViewById(2131368975));
      localSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131368974));
      paramView.setTag(localSystemMsgItemHolder);
      localSystemMsgItemHolder.jdField_f_of_type_AndroidViewView.setTag(localSystemMsgItemHolder);
      localSystemMsgItemHolder.jdField_f_of_type_AndroidViewView.setOnClickListener(this);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage, localSystemMsgItemHolder, this);
      if (this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage.a()) {
        break label259;
      }
      localSystemMsgItemHolder.jdField_f_of_type_AndroidViewView.setBackgroundResource(2130838595);
      if (Utils.b(String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()))) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800826D", "0X800826D", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      a(localSystemMsgItemHolder, paramInt, this);
      return paramView;
      localSystemMsgItemHolder = (SystemMsgItemBuilder.SystemMsgItemHolder)paramView.getTag();
      break;
      label259:
      localSystemMsgItemHolder.jdField_f_of_type_AndroidViewView.setBackgroundResource(2130838591);
    }
  }
  
  protected void a()
  {
    MessageForSystemMsg localMessageForSystemMsg = ((FriendSystemMessage)this.jdField_a_of_type_ComTencentMobileqqNewfriendNewFriendMessage).a;
    this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.a.j();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, localMessageForSystemMsg.frienduin, localMessageForSystemMsg.istroop, localMessageForSystemMsg.uniseq);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A74", "0X8006A74", 0, 0, "", "", "", "");
    if (FriendSystemMessage.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, true)) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800843D", "0X800843D", 0, 0, "", "", "", "");
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      a(paramView);
    }
    int i;
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            paramView = paramView.getTag();
          } while ((paramView == null) || (!(paramView instanceof SystemMsgItemBuilder.SystemMsgItemHolder)));
          paramView = (SystemMsgItemBuilder.SystemMsgItemHolder)paramView;
        } while (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_type.get() != 1);
        a(paramView);
        switch (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get())
        {
        default: 
          return;
        case 1: 
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80076FF", "0X80076FF", 0, 0, "", "", "", "");
          return;
        case 2: 
        case 3: 
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007701", "0X8007701", 0, 0, "", "", "", "");
          return;
        case 13: 
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007702", "0X8007702", 0, 0, "", "", "", "");
          return;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007703", "0X8007703", 0, 0, "", "", "", "");
        return;
        paramView = paramView.getTag();
      } while ((paramView == null) || (!(paramView instanceof SystemMsgItemBuilder.SystemMsgItemHolder)));
      if (!NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext))
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131433023), 0).b(b());
        return;
      }
      paramView = (SystemMsgItemBuilder.SystemMsgItemHolder)paramView;
      a((structmsg.StructMsg)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), this.b);
      long l1 = FriendSystemMsgController.a().b();
      paramView = FriendSystemMsgController.a().a(Long.valueOf(l1));
      if (paramView == null) {
        break label817;
      }
      i = paramView.msg_type.get();
      l1 = paramView.msg_seq.get();
      long l2 = paramView.req_uin.get();
      int j = paramView.msg.sub_type.get();
      int k = paramView.msg.src_id.get();
      int m = paramView.msg.sub_src_id.get();
      int n = paramView.msg.group_msg_type.get();
      localObject = paramView.msg.actions.get();
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break;
      }
      localObject = (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject).get(0)).action_info.get();
      ((structmsg.SystemMsgActionInfo)localObject).remark.set("");
      ((structmsg.SystemMsgActionInfo)localObject).group_id.set(0);
      structmsg.AddFrdSNInfo localAddFrdSNInfo = new structmsg.AddFrdSNInfo();
      localAddFrdSNInfo.uint32_not_see_dynamic.set(0);
      localAddFrdSNInfo.uint32_set_sn.set(0);
      ((structmsg.SystemMsgActionInfo)localObject).addFrdSNInfo.set(localAddFrdSNInfo);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(i, l1, l2, j, k, m, n, (structmsg.SystemMsgActionInfo)localObject, 0, paramView, false);
      i = 1;
      if (i != 0) {
        this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.a.a.c();
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "frd_recommend", "Frd_accept", 0, 0, "1", "", "", "");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007700", "0X8007700", 0, 0, "", "", "", "");
      if (Utils.b(String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()))) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800826E", "0X800826E", 0, 0, "", "", "", "");
      }
    } while (!FriendSystemMessage.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, true));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800843C", "0X800843C", 0, 0, "", "", "", "");
    return;
    paramView = new StringBuilder().append("agree, ");
    if (localObject != null)
    {
      i = ((List)localObject).size();
      label793:
      QLog.d("SystemMsgItemBuilder", 1, i);
    }
    for (;;)
    {
      i = 0;
      break;
      i = -1;
      break label793;
      label817:
      QLog.d("SystemMsgItemBuilder", 1, "agree");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.SystemMsgItemBuilder
 * JD-Core Version:    0.7.0.1
 */