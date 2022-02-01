package com.tencent.biz.qqstory.msgTabNode.view.viewholder;

import anvk;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import wpd;

public class FriendNodeViewHolder$1
  implements Runnable
{
  public FriendNodeViewHolder$1(wpd paramwpd, QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    if (((anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(this.jdField_a_of_type_JavaLangString) == null) {
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.viewholder.FriendNodeViewHolder.1
 * JD-Core Version:    0.7.0.1
 */