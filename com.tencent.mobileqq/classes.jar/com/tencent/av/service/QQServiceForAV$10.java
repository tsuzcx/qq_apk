package com.tencent.av.service;

import android.content.Intent;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class QQServiceForAV$10
  extends FriendListObserver
{
  QQServiceForAV$10(QQServiceForAV paramQQServiceForAV) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onUpdateFriendInfo uin = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("QQServiceForAV", 2, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onUpdateFriendInfo isSuccess = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("QQServiceForAV", 2, ((StringBuilder)localObject).toString());
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a();
    if ((paramBoolean) && (paramString != null))
    {
      Intent localIntent = new Intent();
      localIntent.setAction("tencent.video.q2v.ACTION_ON_UPDATE_FRIEND_INFO");
      localIntent.putExtra("uin", paramString);
      localObject = (FriendsManager)QQServiceForAV.p(this.a).getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (localObject != null)
      {
        localObject = ((FriendsManager)localObject).m(paramString);
        if (localObject != null)
        {
          localObject = ContactUtils.a((Friends)localObject);
          break label155;
        }
      }
      localObject = paramString;
      label155:
      localIntent.putExtra("nick", (String)localObject);
      localIntent.setPackage(localQQAppInterface.getApplication().getPackageName());
      localQQAppInterface.getApp().sendBroadcast(localIntent);
      this.a.s.remove(paramString);
      if (this.a.b()) {
        localQQAppInterface.removeObserver(this.a.v);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.service.QQServiceForAV.10
 * JD-Core Version:    0.7.0.1
 */