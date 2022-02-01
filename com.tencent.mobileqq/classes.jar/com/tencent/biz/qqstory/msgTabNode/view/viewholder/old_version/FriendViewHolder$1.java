package com.tencent.biz.qqstory.msgTabNode.view.viewholder.old_version;

import anvk;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import wpp;

public class FriendViewHolder$1
  implements Runnable
{
  public FriendViewHolder$1(wpp paramwpp, QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    if (((anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(this.jdField_a_of_type_JavaLangString) == null) {
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.viewholder.old_version.FriendViewHolder.1
 * JD-Core Version:    0.7.0.1
 */