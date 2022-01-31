package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
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
import uwb;
import uwc;
import uwd;
import uwe;
import uwf;

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
      paramViewHolder.setTextColor(((Context)localObject).getResources().getColorStateList(2131494227));
      paramViewHolder.setLinkTextColor(((Context)localObject).getResources().getColorStateList(2131494224));
      paramViewHolder.setSpannableFactory(QQText.a);
      paramViewHolder.setMaxWidth(BaseChatItemLayout.d);
      paramViewHolder.setMovementMethod(LinkMovementMethod.getInstance());
      paramViewHolder.setId(2131363575);
      paramBaseChatItemLayout.e = paramViewHolder;
    }
    ((ETTextView)paramBaseChatItemLayout.e).setFont(0, paramChatMessage.uniseq);
    if (!TextUtils.isEmpty(paramChatMessage.getExtInfoFromExtStr("sens_msg_ctrl_info")))
    {
      paramView = ((ETTextView)paramBaseChatItemLayout.e).a();
      if (paramView != null) {
        paramView.a = (paramChatMessage.uniseq + 1L);
      }
    }
    paramBaseChatItemLayout.e.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    int j = BaseChatItemLayout.n;
    int i = BaseChatItemLayout.o;
    if (paramChatMessage.isSend())
    {
      j = BaseChatItemLayout.o;
      i = BaseChatItemLayout.n;
    }
    paramBaseChatItemLayout.e.setPadding(j, BaseChatItemLayout.l, i, BaseChatItemLayout.m);
    if ((paramChatMessage instanceof MessageForDeviceText))
    {
      paramView = (MessageForDeviceText)paramChatMessage;
      if (paramChatMessage.msgtype == -2008) {
        if (paramChatMessage.isSend()) {
          paramBaseChatItemLayout.e.setText(((Context)localObject).getString(2131436164));
        }
      }
    }
    for (;;)
    {
      paramBaseChatItemLayout.e.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramBaseChatItemLayout.e.setOnLongClickListener(paramOnLongClickAndTouchListener);
      if ((paramBaseChatItemLayout.e instanceof AnimationTextView)) {
        ((AnimationTextView)paramBaseChatItemLayout.e).a = new uwf(this);
      }
      return paramViewHolder;
      paramBaseChatItemLayout.e.setText(((Context)localObject).getString(2131436163));
      continue;
      if ("device_lock_msg".equals(paramView.extStr))
      {
        localObject = paramView.msg;
        paramChatMessage = new TextPaint();
        paramChatMessage.setColor(Color.rgb(26, 144, 240));
        paramChatMessage.setUnderlineText(true);
        paramView = new SpannableString((CharSequence)localObject);
        i = ((String)localObject).indexOf("点这里开启QQ设备锁");
        j = "点这里开启QQ设备锁".length();
        int k = ((String)localObject).indexOf("QQ设备锁介绍");
        int m = "QQ设备锁介绍".length();
        localObject = new uwd(this);
        uwe localuwe = new uwe(this);
        ((ClickableSpan)localObject).updateDrawState(paramChatMessage);
        localuwe.updateDrawState(paramChatMessage);
        paramView.setSpan(localObject, i, j + i, 33);
        paramView.setSpan(localuwe, k, m + k, 33);
        paramBaseChatItemLayout.e.setMovementMethod(LinkMovementMethod.getInstance());
        paramBaseChatItemLayout.e.setText(paramView);
      }
      else
      {
        paramBaseChatItemLayout.e.setText(paramView.sb);
        continue;
        paramBaseChatItemLayout.e.setText(paramChatMessage.msg);
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
    paramContext = (DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49);
    paramChatMessage = (MessageForDeviceText)paramChatMessage;
    paramContext.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage);
  }
  
  protected void a(View paramView)
  {
    if (AIOUtils.a(paramView).isMultiMsg) {}
    String str1;
    String str2;
    do
    {
      return;
      paramView = (MessageForDeviceText)AIOUtils.a(paramView);
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131433635);
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131433636);
    } while (!paramView.isSendFromLocal());
    DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new uwb(this, paramView), new uwc(this)).show();
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = AIOUtils.a(paramView);
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    localQQCustomMenu.a(2131375573, "复制", 2130838305);
    if ((paramView.extraflag == 32768) && (paramView.isSendFromLocal())) {
      localQQCustomMenu.a(2131375575, this.jdField_a_of_type_AndroidContentContext.getString(2131433721), 2130838317);
    }
    if (AIOUtils.a(5) == 1) {
      localQQCustomMenu.a(2131366776, this.jdField_a_of_type_AndroidContentContext.getString(2131431563), 2130838312);
    }
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    return localQQCustomMenu.a();
  }
  
  protected void b(View paramView)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.DeviceTextItemBuilder
 * JD-Core Version:    0.7.0.1
 */