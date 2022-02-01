package com.tencent.mobileqq.activity.aio.item.supplier;

import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.core.msglist.item.ItemBuilderSupplier;
import com.tencent.mobileqq.activity.aio.item.TroopSignItemBuilder.TroopSignVideoItemBuilder;
import com.tencent.mobileqq.data.ChatMessage;

public class TroopSignVideoSupplier
  extends ItemBuilderSupplier
{
  public ChatItemBuilder b(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    return new TroopSignItemBuilder.TroopSignVideoItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, (TroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.supplier.TroopSignVideoSupplier
 * JD-Core Version:    0.7.0.1
 */