package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.qphone.base.util.QLog;

class NearbyChatPie$8
  extends FriendListObserver
{
  NearbyChatPie$8(NearbyChatPie paramNearbyChatPie) {}
  
  protected void onAddFriend(String paramString)
  {
    if ((this.a.ah.b.equals(paramString)) && (QLog.isColorLevel()))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a.c);
      ((StringBuilder)localObject).append("Q.nearby.follow");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAddFriend, addUin:");
      localStringBuilder.append(paramString);
      localStringBuilder.append("|updateSession");
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.8
 * JD-Core Version:    0.7.0.1
 */