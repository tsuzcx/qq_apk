package com.tencent.mobileqq.activity.aio.core.msglist.item;

import android.content.Context;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;

public abstract class ItemBuilderSupplier<T extends ChatItemBuilder>
{
  protected Context a;
  private T a;
  protected SessionInfo a;
  protected AIOAnimationConatiner a;
  protected BaseChatPie a;
  protected QQAppInterface a;
  
  protected T a(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatItemBuilder == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioChatItemBuilder = b(paramChatMessage, paramBaseAdapter);
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioChatItemBuilder;
  }
  
  public void a(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, BaseChatPie paramBaseChatPie, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = paramAIOAnimationConatiner;
  }
  
  protected boolean a()
  {
    return true;
  }
  
  protected abstract T b(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.msglist.item.ItemBuilderSupplier
 * JD-Core Version:    0.7.0.1
 */