package com.tencent.ilivesdk.userinfoservice_interface;

import com.tencent.ilivesdk.userinfoservice_interface.model.UserInfo;
import java.util.List;

public abstract interface UserInfoServiceInterface$OnBatchQueryUserInfosCallback
{
  public abstract void onFail(boolean paramBoolean, int paramInt, String paramString);
  
  public abstract void onSuccess(List<UserInfo> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.userinfoservice_interface.UserInfoServiceInterface.OnBatchQueryUserInfosCallback
 * JD-Core Version:    0.7.0.1
 */