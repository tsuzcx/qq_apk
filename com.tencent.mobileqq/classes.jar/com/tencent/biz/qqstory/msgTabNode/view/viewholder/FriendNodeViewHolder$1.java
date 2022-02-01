package com.tencent.biz.qqstory.msgTabNode.view.viewholder;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

class FriendNodeViewHolder$1
  implements Runnable
{
  FriendNodeViewHolder$1(FriendNodeViewHolder paramFriendNodeViewHolder, QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    if (((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(this.jdField_a_of_type_JavaLangString) == null) {
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.viewholder.FriendNodeViewHolder.1
 * JD-Core Version:    0.7.0.1
 */