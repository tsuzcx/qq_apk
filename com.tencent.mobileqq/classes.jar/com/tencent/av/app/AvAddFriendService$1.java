package com.tencent.av.app;

import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.qphone.base.util.QLog;

class AvAddFriendService$1
  extends AvatarObserver
{
  AvAddFriendService$1(AvAddFriendService paramAvAddFriendService) {}
  
  public void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(AvAddFriendService.a, 2, "好友onUpdateCustomHead success = " + paramBoolean + ", uin = " + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.av.app.AvAddFriendService.1
 * JD-Core Version:    0.7.0.1
 */