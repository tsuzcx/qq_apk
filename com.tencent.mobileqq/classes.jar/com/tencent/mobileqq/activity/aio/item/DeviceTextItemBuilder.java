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
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    Object localObject = paramBaseChatItemLayout.getContext();
    paramBaseChatItemLayout = (TextItemBuilder.Holder)paramViewHolder;
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = new ETTextView((Context)localObject);
      paramViewHolder.setTextColor(((Context)localObject).getResources().getColorStateList(2131167052));
      paramViewHolder.setLinkTextColor(((Context)localObject).getResources().getColorStateList(2131167045));
      paramViewHolder.setSpannableFactory(QQText.SPANNABLE_FACTORY);
      paramViewHolder.setMaxWidth(BaseChatItemLayout.e);
      paramViewHolder.setMovementMethod(LinkMovementMethod.getInstance());
      paramViewHolder.setId(2131364637);
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
    int j = BaseChatItemLayout.o;
    int i = BaseChatItemLayout.p;
    if (paramChatMessage.isSend())
    {
      j = BaseChatItemLayout.p;
      i = BaseChatItemLayout.o;
    }
    paramBaseChatItemLayout.d.setPadding(j, BaseChatItemLayout.m, i, BaseChatItemLayout.n);
    if ((paramChatMessage instanceof MessageForDeviceText))
    {
      paramView = (MessageForDeviceText)paramChatMessage;
      if (paramChatMessage.msgtype == -2008) {
        if (paramChatMessage.isSend()) {
          paramBaseChatItemLayout.d.setText(((Context)localObject).getString(2131718941));
        }
      }
    }
    for (;;)
    {
      paramBaseChatItemLayout.d.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramBaseChatItemLayout.d.setOnLongClickListener(paramOnLongClickAndTouchListener);
      if ((paramBaseChatItemLayout.d instanceof AnimationTextView)) {
        ((AnimationTextView)paramBaseChatItemLayout.d).onDoubleClick = new DeviceTextItemBuilder.5(this);
      }
      return paramViewHolder;
      paramBaseChatItemLayout.d.setText(((Context)localObject).getString(2131718940));
      continue;
      if ("device_lock_msg".equals(paramView.extStr))
      {
        localObject = paramView.msg;
        paramChatMessage = new TextPaint();
        paramChatMessage.setColor(-12541697);
        paramChatMessage.setUnderlineText(true);
        paramView = new SpannableString((CharSequence)localObject);
        i = ((String)localObject).indexOf("点这里开启QQ设备锁");
        j = "点这里开启QQ设备锁".length();
        int k = ((String)localObject).indexOf("QQ设备锁介绍");
        int m = "QQ设备锁介绍".length();
        localObject = new DeviceTextItemBuilder.3(this);
        DeviceTextItemBuilder.4 local4 = new DeviceTextItemBuilder.4(this);
        ((ClickableSpan)localObject).updateDrawState(paramChatMessage);
        local4.updateDrawState(paramChatMessage);
        paramView.setSpan(localObject, i, j + i, 33);
        paramView.setSpan(local4, k, m + k, 33);
        paramBaseChatItemLayout.d.setMovementMethod(LinkMovementMethod.getInstance());
        paramBaseChatItemLayout.d.setText(paramView);
      }
      else
      {
        paramBaseChatItemLayout.d.setText(paramView.sb);
        continue;
        paramBaseChatItemLayout.d.setText(paramChatMessage.msg);
      }
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    paramContext = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
    paramChatMessage = (MessageForDeviceText)paramChatMessage;
    paramContext.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage);
  }
  
  public void a(View paramView)
  {
    if (AIOUtils.a(paramView).isMultiMsg) {}
    String str1;
    String str2;
    do
    {
      return;
      paramView = (MessageForDeviceText)AIOUtils.a(paramView);
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131690018);
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131690019);
    } while (!paramView.isSendFromLocal());
    DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new DeviceTextItemBuilder.1(this, paramView), new DeviceTextItemBuilder.2(this)).show();
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = AIOUtils.a(paramView);
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    localQQCustomMenu.a(2131365448, HardCodeUtil.a(2131703256), 2130839050);
    if ((paramView.extraflag == 32768) && (paramView.isSendFromLocal())) {
      localQQCustomMenu.a(2131376982, this.jdField_a_of_type_AndroidContentContext.getString(2131718489), 2130839066);
    }
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    if (AIOUtils.a(5) == 1) {
      localQQCustomMenu.a(2131366625, this.jdField_a_of_type_AndroidContentContext.getString(2131692258), 2130839058);
    }
    super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362524, null, null);
    return localQQCustomMenu.a();
  }
  
  public void b(View paramView)
  {
    ChatMessage localChatMessage = AIOUtils.a(paramView);
    if (localChatMessage == null) {}
    do
    {
      do
      {
        return;
      } while (localChatMessage.istroop != 9501);
      if (localChatMessage.isSendFromLocal())
      {
        super.b(paramView);
        return;
      }
    } while (!"device_groupchat".equals(localChatMessage.extStr));
    super.b(paramView);
  }
  
  protected boolean b()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.DeviceTextItemBuilder
 * JD-Core Version:    0.7.0.1
 */