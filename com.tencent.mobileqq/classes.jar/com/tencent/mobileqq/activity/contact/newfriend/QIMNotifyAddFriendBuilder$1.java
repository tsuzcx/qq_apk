package com.tencent.mobileqq.activity.contact.newfriend;

import com.tencent.mobileqq.activity.contact.newfriend.msg.QIMNotifyAddFriendMsg;
import com.tencent.mobileqq.app.QIMNewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;

class QIMNotifyAddFriendBuilder$1
  implements Runnable
{
  QIMNotifyAddFriendBuilder$1(QIMNotifyAddFriendBuilder paramQIMNotifyAddFriendBuilder) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQIMNewFriendManager.b(((QIMNotifyAddFriendMsg)this.this$0.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendMessage).a);
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new QIMNotifyAddFriendBuilder.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.QIMNotifyAddFriendBuilder.1
 * JD-Core Version:    0.7.0.1
 */