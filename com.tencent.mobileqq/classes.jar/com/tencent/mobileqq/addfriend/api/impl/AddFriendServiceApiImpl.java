package com.tencent.mobileqq.addfriend.api.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.addfriend.api.IAddFriendServiceApi;
import com.tencent.mobileqq.friend.handler.FriendHandler;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppRuntime;

public class AddFriendServiceApiImpl
  implements IAddFriendServiceApi
{
  private static final String ADD_FRIEND_REQUEST_SP = "add_friend_request_sp";
  private static final long REQUEST_DISPLAY_DURATION = 500654080L;
  private static final long REQUEST_MAYKNOW_DISPLAY_DURATION = 86400000L;
  private static final long REQUEST_PHONECONTACT_DISPLAY_DURATION = 259200000L;
  private SharedPreferences addFriendSp = null;
  AppInterface mApp;
  
  private SharedPreferences getAddFriendSp()
  {
    if (this.addFriendSp == null)
    {
      BaseApplication localBaseApplication = this.mApp.getApp();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.mApp.getCurrentAccountUin());
      localStringBuilder.append("add_friend_request_sp");
      this.addFriendSp = localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0);
    }
    return this.addFriendSp;
  }
  
  public boolean hasSendAddFriendReq(String paramString)
  {
    return hasSendAddFriendReq(paramString, false);
  }
  
  public boolean hasSendAddFriendReq(String paramString, boolean paramBoolean)
  {
    return hasSendAddFriendReq(paramString, paramBoolean, false);
  }
  
  public boolean hasSendAddFriendReq(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    long l2 = getAddFriendSp().getLong(paramString, 0L);
    long l1 = l2;
    if (l2 == 0L)
    {
      l1 = l2;
      if (paramString.startsWith("+")) {
        l1 = getAddFriendSp().getLong(paramString.replace("+", ""), 0L);
      }
    }
    l2 = l1;
    if (l1 == 0L)
    {
      l2 = l1;
      if (paramString.startsWith("+86")) {
        l2 = getAddFriendSp().getLong(paramString.replace("+86", ""), 0L);
      }
    }
    if (l2 == 0L) {
      return false;
    }
    l2 = System.currentTimeMillis() - l2;
    if (paramBoolean1) {
      l1 = 259200000L;
    } else {
      l1 = 500654080L;
    }
    if (paramBoolean2) {
      l1 = 86400000L;
    }
    if ((l2 > 0L) && (l2 < l1)) {
      return true;
    }
    getAddFriendSp().edit().remove(paramString).commit();
    return false;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = ((AppInterface)paramAppRuntime);
  }
  
  public void onDestroy() {}
  
  public void setAddFriendReqStatus(String paramString, boolean paramBoolean)
  {
    int i = 1;
    if (paramBoolean) {
      getAddFriendSp().edit().putLong(paramString, System.currentTimeMillis()).commit();
    } else if (getAddFriendSp().contains(paramString)) {
      getAddFriendSp().edit().remove(paramString).commit();
    } else {
      i = 0;
    }
    if (i != 0) {
      ((FriendHandler)this.mApp.getBusinessHandler(FriendHandler.class.getName())).notifyUI(102, paramBoolean, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.addfriend.api.impl.AddFriendServiceApiImpl
 * JD-Core Version:    0.7.0.1
 */