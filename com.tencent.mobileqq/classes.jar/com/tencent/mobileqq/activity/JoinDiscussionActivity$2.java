package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qphone.base.util.QLog;

class JoinDiscussionActivity$2
  extends FriendListObserver
{
  JoinDiscussionActivity$2(JoinDiscussionActivity paramJoinDiscussionActivity) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramString = (FriendsManager)this.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a.a);
      localStringBuilder.append("");
      paramString = paramString.e(localStringBuilder.toString());
      if (paramString != null)
      {
        this.a.e = paramString.name;
        JoinDiscussionActivity.a(this.a);
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("IphoneTitleBarActivity", 2, "get owner name failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.JoinDiscussionActivity.2
 * JD-Core Version:    0.7.0.1
 */