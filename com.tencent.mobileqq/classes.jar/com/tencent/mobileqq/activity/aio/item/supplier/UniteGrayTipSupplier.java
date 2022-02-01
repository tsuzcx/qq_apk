package com.tencent.mobileqq.activity.aio.item.supplier;

import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.core.msglist.item.ItemBuilderSupplier;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.graytip.UniteGrayTipItemBuilder;

public class UniteGrayTipSupplier
  extends ItemBuilderSupplier
{
  public ChatItemBuilder b(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    return new UniteGrayTipItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.supplier.UniteGrayTipSupplier
 * JD-Core Version:    0.7.0.1
 */