package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.QQUserUIItem.UserID;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.OnGetUserInfoCallback;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.UpdateUserInfoEvent;
import java.util.ArrayList;
import java.util.List;

class UserManager$1
  implements Runnable
{
  UserManager$1(UserManager paramUserManager, String paramString, GetUserInfoHandler.UpdateUserInfoEvent paramUpdateUserInfoEvent, GetUserInfoHandler.OnGetUserInfoCallback paramOnGetUserInfoCallback) {}
  
  public void run()
  {
    Object localObject = this.this$0.a(this.jdField_a_of_type_JavaLangString, true);
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetUserInfoHandler$UpdateUserInfoEvent.a = ((QQUserUIItem)localObject);
      this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetUserInfoHandler$OnGetUserInfoCallback.a(this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetUserInfoHandler$UpdateUserInfoEvent);
      return;
    }
    localObject = new ArrayList();
    ((ArrayList)localObject).add(new QQUserUIItem.UserID("", this.jdField_a_of_type_JavaLangString));
    new GetUserInfoHandler(this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetUserInfoHandler$OnGetUserInfoCallback).a(1, (List)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.UserManager.1
 * JD-Core Version:    0.7.0.1
 */