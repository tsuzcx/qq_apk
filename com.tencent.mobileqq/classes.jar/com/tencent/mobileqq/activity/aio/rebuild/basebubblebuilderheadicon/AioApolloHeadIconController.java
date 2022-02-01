package com.tencent.mobileqq.activity.aio.rebuild.basebubblebuilderheadicon;

import android.content.Context;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.extendfriend.apollo.aio.AioApolloHelper;
import com.tencent.mobileqq.extendfriend.apollo.face.Util;
import com.tencent.mobileqq.utils.ViewUtils;

public class AioApolloHeadIconController
  extends BaseDefaultHeadIconController
{
  private String a(ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend()) {
      return paramChatMessage.selfuin;
    }
    return paramChatMessage.senderuin;
  }
  
  private void c(Object paramObject)
  {
    a(paramObject, 0, AIOUtils.b(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), ViewUtils.a(45.0F), ViewUtils.a(60.0F), false);
  }
  
  public boolean a()
  {
    return AioApolloHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
  
  protected void b()
  {
    String str = a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    c(Util.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.basebubblebuilderheadicon.AioApolloHeadIconController
 * JD-Core Version:    0.7.0.1
 */