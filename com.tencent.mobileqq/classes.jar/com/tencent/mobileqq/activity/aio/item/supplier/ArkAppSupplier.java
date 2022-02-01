package com.tencent.mobileqq.activity.aio.item.supplier;

import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.msglist.item.ItemBuilderSupplier;
import com.tencent.mobileqq.activity.aio.item.ArkAppItemBubbleBuilder;
import com.tencent.mobileqq.activity.aio.item.ArkAppItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ArkAppPublicAccountItemBuilder;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkAppMessage.Config;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;

public class ArkAppSupplier
  extends ItemBuilderSupplier
{
  private ArkAppItemBubbleBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppItemBubbleBuilder;
  private ArkAppItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppItemBuilder;
  private ArkAppPublicAccountItemBuilder jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppPublicAccountItemBuilder;
  
  protected ChatItemBuilder a(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    if ((paramChatMessage instanceof MessageForArkApp))
    {
      paramChatMessage = (MessageForArkApp)paramChatMessage;
      ArkAppMessage.Config localConfig = new ArkAppMessage.Config();
      if (paramChatMessage.ark_app_message != null)
      {
        localConfig.fromString(paramChatMessage.ark_app_message.config);
        if ((localConfig.showSender != null) && (localConfig.showSender.intValue() == 0))
        {
          i = 0;
          break label67;
        }
      }
    }
    int i = 1;
    label67:
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != 1008) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != 1038))
    {
      if ((i != 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != 9501))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppItemBubbleBuilder == null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppItemBubbleBuilder = new ArkAppItemBubbleBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
        }
        return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppItemBubbleBuilder;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppItemBuilder = new ArkAppItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppItemBuilder;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppPublicAccountItemBuilder == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppPublicAccountItemBuilder = new ArkAppPublicAccountItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseAdapter, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppPublicAccountItemBuilder;
  }
  
  protected ChatItemBuilder b(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.supplier.ArkAppSupplier
 * JD-Core Version:    0.7.0.1
 */