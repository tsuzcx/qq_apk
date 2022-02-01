package com.tencent.mobileqq.activity.miniaio;

import android.content.Context;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.msglist.item.ItemBuilderFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;

public class MiniChatItemFactory
  extends ItemBuilderFactory
{
  boolean a;
  
  public MiniChatItemFactory(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
  {
    super(paramContext, paramQQAppInterface, paramSessionInfo, paramAIOAnimationConatiner, paramBaseChatPie);
    this.jdField_a_of_type_Boolean = false;
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 62) || (paramInt == 96) || (paramInt == 75);
  }
  
  public ChatItemBuilder a(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    if (a(a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage)))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniChatTextItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniChatTextItemBuilder = new MiniChatTextItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      paramChatMessage = a(this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniChatTextItemBuilder, paramBaseAdapter);
    }
    else
    {
      paramChatMessage = super.a(paramChatMessage, paramBaseAdapter);
    }
    if ((paramChatMessage instanceof BaseBubbleBuilder)) {
      ((BaseBubbleBuilder)paramChatMessage).b = true;
    }
    return paramChatMessage;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniChatItemFactory
 * JD-Core Version:    0.7.0.1
 */