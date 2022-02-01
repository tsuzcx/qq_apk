package com.tencent.biz.qqstory.msgTabNode.view.viewholder;

import amsw;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import wai;

public class FriendNodeViewHolder$1
  implements Runnable
{
  public FriendNodeViewHolder$1(wai paramwai, QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    if (((amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).e(this.jdField_a_of_type_JavaLangString) == null) {
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(1)).getFriendInfo(this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.viewholder.FriendNodeViewHolder.1
 * JD-Core Version:    0.7.0.1
 */