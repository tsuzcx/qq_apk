package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.biz.pubaccount.ecshopassit.aio.IEcshopChatPie.IRefreshCallback;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import java.util.List;

class PublicAccountChatPie$54
  implements IEcshopChatPie.IRefreshCallback
{
  PublicAccountChatPie$54(PublicAccountChatPie paramPublicAccountChatPie, CharSequence paramCharSequence, int paramInt) {}
  
  public void a(List<ChatMessage> paramList)
  {
    if (PublicAccountChatPie.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.a.post(new PublicAccountChatPie.54.1(this));
    }
    PublicAccountChatPie.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie).a().a(false);
    PublicAccountChatPie.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie, paramList, this.jdField_a_of_type_JavaLangCharSequence, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.54
 * JD-Core Version:    0.7.0.1
 */