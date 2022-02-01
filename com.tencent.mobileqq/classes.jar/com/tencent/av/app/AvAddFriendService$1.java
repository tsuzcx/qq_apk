package com.tencent.av.app;

import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.qphone.base.util.QLog;

class AvAddFriendService$1
  extends AvatarObserver
{
  AvAddFriendService$1(AvAddFriendService paramAvAddFriendService) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = AvAddFriendService.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("好友onUpdateCustomHead success = ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", uin = ");
      localStringBuilder.append(paramString);
      QLog.d(str, 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.AvAddFriendService.1
 * JD-Core Version:    0.7.0.1
 */