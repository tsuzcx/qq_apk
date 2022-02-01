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

class QQServiceForAV$9
  extends FriendListObserver
{
  QQServiceForAV$9(QQServiceForAV paramQQServiceForAV) {}
  
  public void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("QQServiceForAV", 2, "onUpdateFriendInfo uin = " + paramString);
      QLog.d("QQServiceForAV", 2, "onUpdateFriendInfo isSuccess = " + paramBoolean);
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a();
    Intent localIntent;
    if ((paramBoolean) && (paramString != null))
    {
      localIntent = new Intent();
      localIntent.setAction("tencent.video.q2v.ACTION_ON_UPDATE_FRIEND_INFO");
      localIntent.putExtra("uin", paramString);
      localObject = (FriendsManager)QQServiceForAV.m(this.a).getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (localObject == null) {
        break label206;
      }
      localObject = ((FriendsManager)localObject).e(paramString);
      if (localObject == null) {
        break label206;
      }
    }
    label206:
    for (Object localObject = ContactUtils.a((Friends)localObject);; localObject = paramString)
    {
      localIntent.putExtra("nick", (String)localObject);
      localIntent.setPackage(localQQAppInterface.getApplication().getPackageName());
      localQQAppInterface.getApp().sendBroadcast(localIntent);
      this.a.jdField_a_of_type_JavaUtilArrayList.remove(paramString);
      if (this.a.b()) {
        localQQAppInterface.removeObserver(this.a.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.service.QQServiceForAV.9
 * JD-Core Version:    0.7.0.1
 */