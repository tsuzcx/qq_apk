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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.newfriend.msg.FriendSystemMessage;
import com.tencent.mobileqq.activity.contact.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.activity.contact.newfriend.poke.NewFriendNotifyPokeMsgHelper;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.KplRoleInfo.WZRYUIinfo;
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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
  private NewFriendManager jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendManager;
  private String jdField_a_of_type_JavaLangString;
  private structmsg.StructMsg jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
  private long b;
  
  public SystemMsgItemBuilder(Context paramContext, QQAppInterface paramQQAppInterface, SystemMsgListAdapter paramSystemMsgListAdapter, NewFriendMessage paramNewFriendMessage)
  {
    super(paramContext, paramQQAppInterface, paramSystemMsgListAdapter, paramNewFriendMessage);
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = ((FriendSystemMessage)paramNewFriendMessage).a.getSystemMsg();
    this.jdField_b_of_type_Long = ((FriendSystemMessage)paramNewFriendMessage).a.uniseq;
    this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder = a(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendManager = ((NewFriendManager)paramQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER));
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint32_source_flag.has()) {}
    for (int i = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint32_source_flag.get();; i = 0)
    {
      if ((i & 0x8) == 8)
      {
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint64_discuss_uin.has()) {
          this.jdField_a_of_type_Long = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint64_discuss_uin.get();
        }
        if (!this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.has()) {
          break label367;
        }
      }
      label348:
      label367:
      for (paramSystemMsgListAdapter = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get();; paramSystemMsgListAdapter = null)
      {
        if (this.jdField_a_of_type_Long != 0L)
        {
          this.jdField_a_of_type_JavaLangString = ContactUtils.c(paramQQAppInterface, String.valueOf(this.jdField_a_of_type_Long));
          if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
          {
            paramQQAppInterface = (DiscussionHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
            if (paramQQAppInterface != null) {
              paramQQAppInterface.a(this.jdField_a_of_type_Long);
            }
            if (QLog.isColorLevel())
            {
              paramNewFriendMessage = Locale.getDefault();
              long l = this.jdField_a_of_type_Long;
              if (paramQQAppInterface != null) {
                break label348;
              }
              paramQQAppInterface = "handler is null";
              QLog.i("addFriendTag", 2, String.format(paramNewFriendMessage, "SystemMsgItemBuilder need get discuss info %d  %s", new Object[] { Long.valueOf(l), paramQQAppInterface }));
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.i("addFriendTag", 2, String.format(Locale.getDefault(), "SystemMsgItemBuilder source_flag: %d  discussUin: %d mDiscussName: %s msg_source: %s", new Object[] { Integer.valueOf(i), Long.valueOf(this.jdField_a_of_type_Long), this.jdField_a_of_type_JavaLangString, paramSystemMsgListAdapter }));
        }
        for (;;)
        {
          this.jdField_b_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131297492);
          return;
          paramQQAppInterface = "handler is not null";
          break;
          this.jdField_a_of_type_JavaLangString = null;
          this.jdField_a_of_type_Long = 0L;
        }
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
        a((structmsg.StructMsg)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), this.jdField_b_of_type_Long);
        ((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult((Intent)localObject2, 227);
        this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendManager.g();
        return;
        i = 2;
        continue;
        i = 2;
        continue;
        i = 0;
      }
    case 2: 
    case 3: 
      SystemMessageHelper.a(this.jdField_a_of_type_AndroidContentContext, String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
      return;
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
    a(paramSystemMsgItemHolder, paramInt, String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.a(paramSystemMsgItemHolder);
    paramSystemMsgItemHolder.jdField_f_of_type_AndroidWidgetImageView.setTag(paramSystemMsgItemHolder);
    paramSystemMsgItemHolder.l.setVisibility(8);
    g(paramSystemMsgItemHolder);
    a(paramSystemMsgItemHolder, paramOnClickListener);
  }
  
  private void a(SystemMsgItemBuilder.SystemMsgItemHolder paramSystemMsgItemHolder, int paramInt, String paramString)
  {
    Object localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get();
    localObject1 = ((FriendsManager)localObject1).b(String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
    if ((localObject1 != null) && (!TextUtils.isEmpty(((Friends)localObject1).remark))) {
      localObject2 = ((Friends)localObject1).remark;
    }
    for (;;)
    {
      localObject1 = localObject2;
      if (FriendSystemMessage.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, true))
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.bytes_game_nick.has())
        {
          String str = new String(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.bytes_game_nick.get().toByteArray());
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(str)) {
            localObject1 = KplRoleInfo.WZRYUIinfo.buildNickName((String)localObject2, str);
          }
        }
      }
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = paramString;
      }
      paramSystemMsgItemHolder.h.setText((CharSequence)localObject2);
      if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.bytes_name_more.has()) {}
      for (localObject1 = new String(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.bytes_name_more.get().toByteArray());; localObject1 = null)
      {
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          paramSystemMsgItemHolder.n.setVisibility(8);
          if ((TextUtils.isEmpty(paramString)) || (!Utils.b(paramString))) {
            break label447;
          }
          paramString = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841947);
          paramString.setBounds(0, 0, AIOUtils.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          paramSystemMsgItemHolder.h.setCompoundDrawables(null, null, paramString, null);
          paramSystemMsgItemHolder.h.setCompoundDrawablePadding(AIOUtils.a(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SystemMsgItemBuilder", 2, "bindBuddySystemMsgView|position is : " + paramInt + ",name is : " + (String)localObject2 + ",source is : " + this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get());
          }
          return;
          paramSystemMsgItemHolder.n.setVisibility(0);
          localObject1 = "（" + (String)localObject1 + "）";
          paramSystemMsgItemHolder.n.setText((CharSequence)localObject1);
          break;
          label447:
          paramSystemMsgItemHolder.h.setCompoundDrawables(null, null, null, null);
        }
      }
    }
  }
  
  private void a(SystemMsgItemBuilder.SystemMsgItemHolder paramSystemMsgItemHolder, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg != null)
    {
      f(paramSystemMsgItemHolder);
      int i = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
      if (QLog.isColorLevel()) {
        QLog.d("SystemMsgItemBuilder", 2, "bindBuddySystemMsgView|myAllowFlag : " + i);
      }
      switch (i)
      {
      }
    }
    for (;;)
    {
      paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setTag(paramSystemMsgItemHolder);
      paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramOnClickListener);
      paramSystemMsgItemHolder.jdField_g_of_type_AndroidWidgetImageView.setTag(paramSystemMsgItemHolder);
      paramSystemMsgItemHolder.jdField_g_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
      return;
      c(paramSystemMsgItemHolder);
      continue;
      paramSystemMsgItemHolder.k.setVisibility(0);
      String str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
      paramSystemMsgItemHolder.k.setText(str);
      paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      h(paramSystemMsgItemHolder);
      NewFriendNotifyPokeMsgHelper.a(paramSystemMsgItemHolder, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      continue;
      paramSystemMsgItemHolder.k.setVisibility(8);
      paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      continue;
      e(paramSystemMsgItemHolder);
      continue;
      paramSystemMsgItemHolder.k.setVisibility(0);
      str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
      paramSystemMsgItemHolder.k.setText(str);
      paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      continue;
      d(paramSystemMsgItemHolder);
      continue;
      if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.reqsubtype.has()) {
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.reqsubtype.get() == 1)
        {
          paramSystemMsgItemHolder.k.setVisibility(0);
          str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
          paramSystemMsgItemHolder.k.setText(str);
          paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        }
        else if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.reqsubtype.get() == 2)
        {
          paramSystemMsgItemHolder.k.setVisibility(8);
          paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          continue;
          paramSystemMsgItemHolder.k.setVisibility(0);
          str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
          paramSystemMsgItemHolder.k.setText(str);
          paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          paramSystemMsgItemHolder.j.setVisibility(8);
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
    paramSystemMsgItemHolder.jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
    paramSystemMsgItemHolder.h.setVisibility(0);
    paramSystemMsgItemHolder.n.setVisibility(8);
    paramSystemMsgItemHolder.i.setVisibility(0);
    paramSystemMsgItemHolder.l.setVisibility(0);
    paramSystemMsgItemHolder.j.setVisibility(0);
    paramSystemMsgItemHolder.k.setVisibility(8);
    paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    paramSystemMsgItemHolder.jdField_g_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void c(SystemMsgItemBuilder.SystemMsgItemHolder paramSystemMsgItemHolder)
  {
    String str;
    if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get() != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().get(0)).name.get())))
    {
      paramSystemMsgItemHolder.k.setVisibility(8);
      paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      str = ((structmsg.SystemMsgAction)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().get(0)).name.get();
      paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setText(str);
    }
    for (;;)
    {
      h(paramSystemMsgItemHolder);
      return;
      if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get() != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().size() == 0))
      {
        paramSystemMsgItemHolder.k.setVisibility(0);
        str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
        paramSystemMsgItemHolder.k.setText(str);
        paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
    }
  }
  
  private void d(SystemMsgItemBuilder.SystemMsgItemHolder paramSystemMsgItemHolder)
  {
    String str;
    if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get() != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().get(0)).name.get())))
    {
      paramSystemMsgItemHolder.k.setVisibility(8);
      paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      str = ((structmsg.SystemMsgAction)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().get(0)).name.get();
      paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setText(str);
    }
    for (;;)
    {
      h(paramSystemMsgItemHolder);
      return;
      paramSystemMsgItemHolder.k.setVisibility(0);
      str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
      paramSystemMsgItemHolder.k.setText(str);
      paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      NewFriendNotifyPokeMsgHelper.a(paramSystemMsgItemHolder, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  private void e(SystemMsgItemBuilder.SystemMsgItemHolder paramSystemMsgItemHolder)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get()))
    {
      paramSystemMsgItemHolder.j.setText(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
      paramSystemMsgItemHolder.i.setText(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get());
    }
    for (;;)
    {
      paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      paramSystemMsgItemHolder.k.setVisibility(8);
      return;
      paramSystemMsgItemHolder.j.setVisibility(8);
    }
  }
  
  private void f(SystemMsgItemBuilder.SystemMsgItemHolder paramSystemMsgItemHolder)
  {
    paramSystemMsgItemHolder.i.setText(FriendSystemMessage.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg));
  }
  
  private void g(SystemMsgItemBuilder.SystemMsgItemHolder paramSystemMsgItemHolder)
  {
    String str = null;
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.has()) {
      str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get();
    }
    if (!TextUtils.isEmpty(str))
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
      for (str = String.format(Locale.getDefault(), HardCodeUtil.a(2131714586), new Object[] { str, this.jdField_a_of_type_JavaLangString });; str = String.format(Locale.getDefault(), HardCodeUtil.a(2131714589), new Object[] { str }))
      {
        paramSystemMsgItemHolder.j.setText(str);
        paramSystemMsgItemHolder.j.setVisibility(0);
        return;
      }
    }
    paramSystemMsgItemHolder.j.setVisibility(8);
  }
  
  private void h(SystemMsgItemBuilder.SystemMsgItemHolder paramSystemMsgItemHolder)
  {
    int i = -1;
    int j = 0;
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_gender.has()) {
      i = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_gender.get();
    }
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_age.has()) {
      j = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_age.get();
    }
    a(paramSystemMsgItemHolder.l, i, j, null);
  }
  
  protected int a()
  {
    return ((FriendSystemMessage)this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendMessage).a.mSysmsgMenuFlag;
  }
  
  public View a(int paramInt, View paramView)
  {
    SystemMsgItemBuilder.SystemMsgItemHolder localSystemMsgItemHolder;
    if ((paramView == null) || (!(paramView.getTag() instanceof SystemMsgItemBuilder.SystemMsgItemHolder)))
    {
      localSystemMsgItemHolder = new SystemMsgItemBuilder.SystemMsgItemHolder();
      paramView = a(this.jdField_a_of_type_AndroidContentContext, 2131561658, localSystemMsgItemHolder);
      a(paramView, this.jdField_b_of_type_Int);
      localSystemMsgItemHolder.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361796));
      localSystemMsgItemHolder.h = ((TextView)paramView.findViewById(2131372288));
      localSystemMsgItemHolder.n = ((TextView)paramView.findViewById(2131378271));
      localSystemMsgItemHolder.i = ((TextView)paramView.findViewById(2131377005));
      localSystemMsgItemHolder.l = ((TextView)paramView.findViewById(2131362338));
      localSystemMsgItemHolder.j = ((TextView)paramView.findViewById(2131378318));
      localSystemMsgItemHolder.k = ((TextView)paramView.findViewById(2131377001));
      localSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131376990));
      localSystemMsgItemHolder.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131376994));
      b(localSystemMsgItemHolder.jdField_f_of_type_AndroidWidgetImageView);
      paramView.setTag(localSystemMsgItemHolder);
      localSystemMsgItemHolder.jdField_g_of_type_AndroidViewView.setTag(localSystemMsgItemHolder);
      localSystemMsgItemHolder.jdField_g_of_type_AndroidViewView.setOnClickListener(this);
      a(this.jdField_a_of_type_AndroidContentContext, paramView, paramInt, this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendMessage, localSystemMsgItemHolder, this);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendMessage.a()) {
        break label307;
      }
      a(localSystemMsgItemHolder.jdField_g_of_type_AndroidViewView, true);
      if (Utils.b(String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()))) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800826D", "0X800826D", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      a(localSystemMsgItemHolder, paramInt, this);
      return paramView;
      localSystemMsgItemHolder = (SystemMsgItemBuilder.SystemMsgItemHolder)paramView.getTag();
      b(localSystemMsgItemHolder);
      break;
      label307:
      a(localSystemMsgItemHolder.jdField_g_of_type_AndroidViewView, false);
    }
  }
  
  protected void a()
  {
    MessageForSystemMsg localMessageForSystemMsg = ((FriendSystemMessage)this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendMessage).a;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.a.j();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().a(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, localMessageForSystemMsg.frienduin, localMessageForSystemMsg.istroop, localMessageForSystemMsg.uniseq);
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
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject1 = paramView.getTag();
      if ((localObject1 != null) && ((localObject1 instanceof SystemMsgItemBuilder.SystemMsgItemHolder)))
      {
        localObject1 = (SystemMsgItemBuilder.SystemMsgItemHolder)localObject1;
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_type.get() == 1)
        {
          a((SystemMsgItemBuilder.SystemMsgItemHolder)localObject1);
          switch (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get())
          {
          default: 
            break;
          case 1: 
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80076FF", "0X80076FF", 0, 0, "", "", "", "");
            break;
          case 2: 
          case 3: 
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007701", "0X8007701", 0, 0, "", "", "", "");
            break;
          case 13: 
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007702", "0X8007702", 0, 0, "", "", "", "");
            break;
          case 6: 
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007703", "0X8007703", 0, 0, "", "", "", "");
            continue;
            localObject1 = paramView.getTag();
            if ((localObject1 != null) && ((localObject1 instanceof SystemMsgItemBuilder.SystemMsgItemHolder))) {
              if (!NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext))
              {
                QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692257), 0).b(c());
              }
              else
              {
                localObject1 = (SystemMsgItemBuilder.SystemMsgItemHolder)localObject1;
                a((structmsg.StructMsg)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), this.jdField_b_of_type_Long);
                long l1 = FriendSystemMsgController.a().b();
                localObject1 = FriendSystemMsgController.a().a(Long.valueOf(l1));
                int i;
                if (localObject1 != null)
                {
                  i = ((structmsg.StructMsg)localObject1).msg_type.get();
                  l1 = ((structmsg.StructMsg)localObject1).msg_seq.get();
                  long l2 = ((structmsg.StructMsg)localObject1).req_uin.get();
                  int j = ((structmsg.StructMsg)localObject1).msg.sub_type.get();
                  int k = ((structmsg.StructMsg)localObject1).msg.src_id.get();
                  int m = ((structmsg.StructMsg)localObject1).msg.sub_src_id.get();
                  int n = ((structmsg.StructMsg)localObject1).msg.group_msg_type.get();
                  Object localObject2 = ((structmsg.StructMsg)localObject1).msg.actions.get();
                  if ((localObject2 != null) && (((List)localObject2).size() > 0))
                  {
                    localObject2 = (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject2).get(0)).action_info.get();
                    ((structmsg.SystemMsgActionInfo)localObject2).remark.set("");
                    ((structmsg.SystemMsgActionInfo)localObject2).group_id.set(0);
                    structmsg.AddFrdSNInfo localAddFrdSNInfo = new structmsg.AddFrdSNInfo();
                    localAddFrdSNInfo.uint32_not_see_dynamic.set(0);
                    localAddFrdSNInfo.uint32_set_sn.set(0);
                    ((structmsg.SystemMsgActionInfo)localObject2).addFrdSNInfo.set(localAddFrdSNInfo);
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().a(i, l1, l2, j, k, m, n, (structmsg.SystemMsgActionInfo)localObject2, 0, (structmsg.StructMsg)localObject1, false);
                    i = 1;
                    if (i != 0) {
                      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.a.a.c();
                    }
                    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "frd_recommend", "Frd_accept", 0, 0, "1", "", "", "");
                    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007700", "0X8007700", 0, 0, "", "", "", "");
                    if (Utils.b(String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()))) {
                      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800826E", "0X800826E", 0, 0, "", "", "", "");
                    }
                    if (!FriendSystemMessage.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, true)) {
                      continue;
                    }
                    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800843C", "0X800843C", 0, 0, "", "", "", "");
                    continue;
                  }
                  localObject1 = new StringBuilder().append("agree, ");
                  if (localObject2 != null)
                  {
                    i = ((List)localObject2).size();
                    label848:
                    QLog.d("SystemMsgItemBuilder", 1, i);
                  }
                }
                for (;;)
                {
                  i = 0;
                  break;
                  i = -1;
                  break label848;
                  QLog.d("SystemMsgItemBuilder", 1, "agree");
                }
                if ((paramView.getTag() != null) && ((paramView.getTag() instanceof SystemMsgItemBuilder.SystemMsgItemHolder)))
                {
                  localObject1 = (SystemMsgItemBuilder.SystemMsgItemHolder)paramView.getTag();
                  if (!NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext))
                  {
                    QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692257), 0).b(c());
                  }
                  else
                  {
                    a((structmsg.StructMsg)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), this.jdField_b_of_type_Long);
                    NewFriendNotifyPokeMsgHelper.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localObject1);
                  }
                }
              }
            }
            break;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.SystemMsgItemBuilder
 * JD-Core Version:    0.7.0.1
 */