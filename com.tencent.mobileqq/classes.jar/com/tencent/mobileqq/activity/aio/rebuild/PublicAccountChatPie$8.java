package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.bubble.ChatXListView;

class PublicAccountChatPie$8
  implements Runnable
{
  PublicAccountChatPie$8(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void run()
  {
    int i = UIUtils.a(this.this$0.jdField_a_of_type_AndroidContentContext, 80.0F);
    if ("top".equals(PublicAccountChatPie.a(this.this$0))) {
      i = 0;
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setPadding(this.this$0.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingLeft(), this.this$0.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingTop(), this.this$0.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingRight(), i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.8
 * JD-Core Version:    0.7.0.1
 */