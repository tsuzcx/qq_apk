package com.tencent.mobileqq.activity;

import adfr;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;

public class AddFriendLogicActivity$MyFriendListObserver$1
  implements Runnable
{
  public AddFriendLogicActivity$MyFriendListObserver$1(adfr paramadfr, String paramString) {}
  
  public void run()
  {
    ((FriendListHandler)this.jdField_a_of_type_Adfr.a.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).addFriendToFriendList(this.jdField_a_of_type_JavaLangString, 0, 3999, "", true, false, -1L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendLogicActivity.MyFriendListObserver.1
 * JD-Core Version:    0.7.0.1
 */