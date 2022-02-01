package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;

public class TroopGiftMsgItemBuilder$TroopGiftMsgItemSenderBuilder
  extends TroopGiftMsgItemBuilder
{
  public TroopGiftMsgItemBuilder$TroopGiftMsgItemSenderBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner, paramBaseChatPie);
  }
  
  public View a(BaseChatItemLayout paramBaseChatItemLayout)
  {
    return LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131563138, paramBaseChatItemLayout, false);
  }
  
  public BaseBubbleBuilder.ViewHolder a()
  {
    return new TroopGiftMsgItemBuilder.TroopGiftMsgSenderHolder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopGiftMsgItemBuilder.TroopGiftMsgItemSenderBuilder
 * JD-Core Version:    0.7.0.1
 */