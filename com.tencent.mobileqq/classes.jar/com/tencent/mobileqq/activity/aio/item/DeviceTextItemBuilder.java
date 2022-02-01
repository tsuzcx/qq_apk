package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForDeviceText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.AnimationTextView;

public class DeviceTextItemBuilder
  extends TextItemBuilder
{
  public DeviceTextItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    Object localObject = paramBaseChatItemLayout.getContext();
    paramBaseChatItemLayout = (TextItemBuilder.Holder)paramViewHolder;
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = new ETTextView((Context)localObject);
      paramViewHolder.setTextColor(((Context)localObject).getResources().getColorStateList(2131167075));
      paramViewHolder.setLinkTextColor(((Context)localObject).getResources().getColorStateList(2131167068));
      paramViewHolder.setSpannableFactory(QQText.SPANNABLE_FACTORY);
      paramViewHolder.setMaxWidth(BaseChatItemLayout.e);
      paramViewHolder.setMovementMethod(LinkMovementMethod.getInstance());
      paramViewHolder.setId(2131364524);
      paramBaseChatItemLayout.d = paramViewHolder;
    }
    ((ETTextView)paramBaseChatItemLayout.d).setFont(0, paramChatMessage.uniseq);
    if (!TextUtils.isEmpty(paramChatMessage.getExtInfoFromExtStr("sens_msg_ctrl_info")))
    {
      paramView = ((ETTextView)paramBaseChatItemLayout.d).getETLayout();
      if (paramView != null) {
        paramView.a = (paramChatMessage.uniseq + 1L);
      }
    }
    paramBaseChatItemLayout.d.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    int i = BaseChatItemLayout.o;
    int j = BaseChatItemLayout.p;
    if (paramChatMessage.isSend())
    {
      i = BaseChatItemLayout.p;
      j = BaseChatItemLayout.o;
    }
    paramBaseChatItemLayout.d.setPadding(i, BaseChatItemLayout.m, j, BaseChatItemLayout.n);
    if ((paramChatMessage instanceof MessageForDeviceText))
    {
      paramView = (MessageForDeviceText)paramChatMessage;
      if (paramChatMessage.msgtype == -2008)
      {
        if (paramChatMessage.isSend()) {
          paramBaseChatItemLayout.d.setText(((Context)localObject).getString(2131718657));
        } else {
          paramBaseChatItemLayout.d.setText(((Context)localObject).getString(2131718656));
        }
      }
      else if ("device_lock_msg".equals(paramView.extStr))
      {
        localObject = paramView.msg;
        paramChatMessage = new TextPaint();
        paramChatMessage.setColor(-12541697);
        paramChatMessage.setUnderlineText(true);
        paramView = new SpannableString((CharSequence)localObject);
        i = ((String)localObject).indexOf("点这里开启QQ设备锁");
        j = ((String)localObject).indexOf("QQ设备锁介绍");
        localObject = new DeviceTextItemBuilder.3(this);
        DeviceTextItemBuilder.4 local4 = new DeviceTextItemBuilder.4(this);
        ((ClickableSpan)localObject).updateDrawState(paramChatMessage);
        local4.updateDrawState(paramChatMessage);
        paramView.setSpan(localObject, i, i + 10, 33);
        paramView.setSpan(local4, j, j + 7, 33);
        paramBaseChatItemLayout.d.setMovementMethod(LinkMovementMethod.getInstance());
        paramBaseChatItemLayout.d.setText(paramView);
      }
      else
      {
        paramBaseChatItemLayout.d.setText(paramView.sb);
      }
    }
    else
    {
      paramBaseChatItemLayout.d.setText(paramChatMessage.msg);
    }
    paramBaseChatItemLayout.d.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramBaseChatItemLayout.d.setOnLongClickListener(paramOnLongClickAndTouchListener);
    if ((paramBaseChatItemLayout.d instanceof AnimationTextView)) {
      ((AnimationTextView)paramBaseChatItemLayout.d).onDoubleClick = new DeviceTextItemBuilder.5(this);
    }
    return paramViewHolder;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt != 2131376471)
    {
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    paramContext = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
    paramChatMessage = (MessageForDeviceText)paramChatMessage;
    paramContext.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage);
  }
  
  protected void a(View paramView)
  {
    if (AIOUtils.a(paramView).isMultiMsg) {
      return;
    }
    paramView = (MessageForDeviceText)AIOUtils.a(paramView);
    String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131689933);
    String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131689934);
    if (paramView.isSendFromLocal()) {
      DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new DeviceTextItemBuilder.1(this, paramView), new DeviceTextItemBuilder.2(this)).show();
    }
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = AIOUtils.a(paramView);
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    localQQCustomMenu.a(2131365311, HardCodeUtil.a(2131703388), 2130838903);
    if ((paramView.extraflag == 32768) && (paramView.isSendFromLocal())) {
      localQQCustomMenu.a(2131376471, this.jdField_a_of_type_AndroidContentContext.getString(2131718154), 2130838919);
    }
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    if (AIOUtils.a(5) == 1) {
      localQQCustomMenu.a(2131366494, this.jdField_a_of_type_AndroidContentContext.getString(2131692184), 2130838911);
    }
    super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362480, null, null);
    return localQQCustomMenu.a();
  }
  
  protected void b(View paramView)
  {
    ChatMessage localChatMessage = AIOUtils.a(paramView);
    if (localChatMessage == null) {
      return;
    }
    if (localChatMessage.istroop == 9501)
    {
      if (localChatMessage.isSendFromLocal())
      {
        super.b(paramView);
        return;
      }
      if ("device_groupchat".equals(localChatMessage.extStr)) {
        super.b(paramView);
      }
    }
  }
  
  protected boolean b()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.DeviceTextItemBuilder
 * JD-Core Version:    0.7.0.1
 */