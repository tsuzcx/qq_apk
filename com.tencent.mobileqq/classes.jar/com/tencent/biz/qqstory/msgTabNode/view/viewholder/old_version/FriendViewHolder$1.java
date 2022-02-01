package com.tencent.biz.qqstory.msgTabNode.view.viewholder.old_version;

import amsw;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import wau;

public class FriendViewHolder$1
  implements Runnable
{
  public FriendViewHolder$1(wau paramwau, QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    if (((amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).e(this.jdField_a_of_type_JavaLangString) == null) {
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(1)).getFriendInfo(this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.viewholder.old_version.FriendViewHolder.1
 * JD-Core Version:    0.7.0.1
 */