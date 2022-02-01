package com.tencent.av.app;

import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.qphone.base.util.QLog;

class AvAddFriendService$3
  extends FriendListObserver
{
  AvAddFriendService$3(AvAddFriendService paramAvAddFriendService) {}
  
  protected void onAddFriend(String paramString)
  {
    super.onAddFriend(paramString);
    if (QLog.isColorLevel())
    {
      String str = AvAddFriendService.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAddFriend 进入好友列表");
      localStringBuilder.append(paramString);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    AvAddFriendService.a(this.a, paramString, 4);
    this.a.b(paramString);
  }
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    super.onUpdateDelFriend(paramBoolean, paramObject);
    paramObject = String.valueOf((Long)paramObject);
    if (QLog.isColorLevel())
    {
      String str = AvAddFriendService.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdateDelFriend 删除好友");
      localStringBuilder.append(paramObject);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    AvAddFriendService.a(this.a, paramObject, 0);
    this.a.b(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.AvAddFriendService.3
 * JD-Core Version:    0.7.0.1
 */