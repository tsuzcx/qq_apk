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
    if (((FriendsManager)this.a.getManager(QQManagerFactory.FRIENDS_MANAGER)).m(this.b) == null) {
      ((FriendListHandler)this.a.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.viewholder.FriendNodeViewHolder.1
 * JD-Core Version:    0.7.0.1
 */