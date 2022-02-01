package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Intent;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.qphone.base.util.QLog;

class NearbyChatPie$9
  extends FriendListObserver
{
  NearbyChatPie$9(NearbyChatPie paramNearbyChatPie) {}
  
  protected void onAddFriend(String paramString)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(paramString))
    {
      Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
      ((Intent)localObject).putExtra("uintype", 0);
      NearbyChatPie.b(this.a, (Intent)localObject);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.a.b);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.9
 * JD-Core Version:    0.7.0.1
 */