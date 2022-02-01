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
    Object localObject = this.this$0.c(this.a, true);
    if (localObject != null)
    {
      GetUserInfoHandler.UpdateUserInfoEvent localUpdateUserInfoEvent = this.b;
      localUpdateUserInfoEvent.a = ((QQUserUIItem)localObject);
      this.c.a(localUpdateUserInfoEvent);
      return;
    }
    localObject = new ArrayList();
    ((ArrayList)localObject).add(new QQUserUIItem.UserID("", this.a));
    new GetUserInfoHandler(this.c).a(1, (List)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.UserManager.1
 * JD-Core Version:    0.7.0.1
 */