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
      paramViewHolder.setTextColor(((Context)localObject).getResources().getColorStateList(2131168016));
      paramViewHolder.setLinkTextColor(((Context)localObject).getResources().getColorStateList(2131168008));
      paramViewHolder.setSpannableFactory(QQText.SPANNABLE_FACTORY);
      paramViewHolder.setMaxWidth(BaseChatItemLayout.e);
      paramViewHolder.setMovementMethod(LinkMovementMethod.getInstance());
      paramViewHolder.setId(2131430581);
      paramBaseChatItemLayout.v = paramViewHolder;
    }
    ((ETTextView)paramBaseChatItemLayout.v).setFont(0, paramChatMessage.uniseq);
    if (!TextUtils.isEmpty(paramChatMessage.getExtInfoFromExtStr("sens_msg_ctrl_info")))
    {
      paramView = ((ETTextView)paramBaseChatItemLayout.v).getETLayout();
      if (paramView != null) {
        paramView.b = (paramChatMessage.uniseq + 1L);
      }
    }
    paramBaseChatItemLayout.v.setTextSize(0, this.f.r);
    int i = BaseChatItemLayout.getTextPaddingAlignHead();
    int j = BaseChatItemLayout.getTextPaddingAlignError();
    if (paramChatMessage.isSend())
    {
      i = BaseChatItemLayout.getTextPaddingAlignError();
      j = BaseChatItemLayout.getTextPaddingAlignHead();
    }
    paramBaseChatItemLayout.v.setPadding(i, BaseChatItemLayout.n, j, BaseChatItemLayout.o);
    if ((paramChatMessage instanceof MessageForDeviceText))
    {
      paramView = (MessageForDeviceText)paramChatMessage;
      if (paramChatMessage.msgtype == -2008)
      {
        if (paramChatMessage.isSend()) {
          paramBaseChatItemLayout.v.setText(((Context)localObject).getString(2131916158));
        } else {
          paramBaseChatItemLayout.v.setText(((Context)localObject).getString(2131916157));
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
        paramBaseChatItemLayout.v.setMovementMethod(LinkMovementMethod.getInstance());
        paramBaseChatItemLayout.v.setText(paramView);
      }
      else
      {
        paramBaseChatItemLayout.v.setText(paramView.sb);
      }
    }
    else
    {
      paramBaseChatItemLayout.v.setText(paramChatMessage.msg);
    }
    paramBaseChatItemLayout.v.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramBaseChatItemLayout.v.setOnLongClickListener(paramOnLongClickAndTouchListener);
    if ((paramBaseChatItemLayout.v instanceof AnimationTextView)) {
      ((AnimationTextView)paramBaseChatItemLayout.v).onDoubleClick = new DeviceTextItemBuilder.5(this);
    }
    return paramViewHolder;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt != 2131444710)
    {
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    paramContext = (DeviceMsgHandle)this.d.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
    paramChatMessage = (MessageForDeviceText)paramChatMessage;
    paramContext.a(this.d, this.e, this.f, paramChatMessage);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = AIOUtils.a(paramView);
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    localQQCustomMenu.a(2131431492, HardCodeUtil.a(2131901348), 2130839057);
    if ((paramView.extraflag == 32768) && (paramView.isSendFromLocal())) {
      localQQCustomMenu.a(2131444710, this.e.getString(2131915632), 2130839073);
    }
    ChatActivityFacade.a(localQQCustomMenu, this.e, this.f.a);
    if (AIOUtils.a(5) == 1) {
      localQQCustomMenu.a(2131432813, this.e.getString(2131889171), 2130839065);
    }
    super.a(localQQCustomMenu, this.e, 2131428089, null, null);
    return localQQCustomMenu.d();
  }
  
  protected void b(View paramView)
  {
    if (AIOUtils.a(paramView).isMultiMsg) {
      return;
    }
    paramView = (MessageForDeviceText)AIOUtils.a(paramView);
    String str1 = this.e.getString(2131886574);
    String str2 = this.e.getString(2131886575);
    if (paramView.isSendFromLocal()) {
      DialogUtil.a(this.e, 230, str1, str2, new DeviceTextItemBuilder.1(this, paramView), new DeviceTextItemBuilder.2(this)).show();
    }
  }
  
  protected void c(View paramView)
  {
    ChatMessage localChatMessage = AIOUtils.a(paramView);
    if (localChatMessage == null) {
      return;
    }
    if (localChatMessage.istroop == 9501)
    {
      if (localChatMessage.isSendFromLocal())
      {
        super.c(paramView);
        return;
      }
      if ("device_groupchat".equals(localChatMessage.extStr)) {
        super.c(paramView);
      }
    }
  }
  
  protected boolean h()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.DeviceTextItemBuilder
 * JD-Core Version:    0.7.0.1
 */