package com.tencent.mobileqq.activity.contact.newfriend;

import com.tencent.mobileqq.activity.contact.newfriend.msg.QIMFollowMessage;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

class QIMFollowerAddBuilder$1
  implements Runnable
{
  QIMFollowerAddBuilder$1(QIMFollowerAddBuilder paramQIMFollowerAddBuilder) {}
  
  public void run()
  {
    ((NewFriendManager)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).a(((QIMFollowMessage)this.this$0.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendMessage).a);
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new QIMFollowerAddBuilder.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.QIMFollowerAddBuilder.1
 * JD-Core Version:    0.7.0.1
 */