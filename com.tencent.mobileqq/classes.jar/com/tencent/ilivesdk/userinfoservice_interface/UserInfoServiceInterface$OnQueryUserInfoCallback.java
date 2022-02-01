package com.tencent.ilivesdk.userinfoservice_interface;

import com.tencent.ilivesdk.userinfoservice_interface.model.UserInfo;

public abstract interface UserInfoServiceInterface$OnQueryUserInfoCallback
{
  public abstract void onFail(boolean paramBoolean, int paramInt, String paramString);
  
  public abstract void onSuccess(UserInfo paramUserInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.userinfoservice_interface.UserInfoServiceInterface.OnQueryUserInfoCallback
 * JD-Core Version:    0.7.0.1
 */