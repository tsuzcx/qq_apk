package com.tencent.mobileqq.activity.aio.item.supplier;

import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.core.msglist.item.ItemBuilderSupplier;
import com.tencent.mobileqq.activity.aio.item.ArkFlashChatItemBubbleBuilder;
import com.tencent.mobileqq.data.ChatMessage;

public class ArkFlashChatSupplier
  extends ItemBuilderSupplier
{
  public ChatItemBuilder b(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    return new ArkFlashChatItemBubbleBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.supplier.ArkFlashChatSupplier
 * JD-Core Version:    0.7.0.1
 */