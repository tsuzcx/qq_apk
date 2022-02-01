package com.tencent.ilivesdk.userinfoservice_interface;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.userinfoservice_interface.model.UserInfo;
import java.util.List;

public abstract interface UserInfoServiceInterface
  extends ServiceBaseInterface
{
  public abstract void batchQueryUserInfos(List<Long> paramList, long paramLong, UserInfoServiceInterface.OnBatchQueryUserInfosCallback paramOnBatchQueryUserInfosCallback);
  
  public abstract void batchQueryUserInfos(List<Long> paramList, UserInfoServiceInterface.OnBatchQueryUserInfosCallback paramOnBatchQueryUserInfosCallback);
  
  public abstract UserInfo getSelfInfo();
  
  public abstract void init(UserInfoServiceAdapter paramUserInfoServiceAdapter);
  
  public abstract void queryUserInfo(long paramLong1, long paramLong2, UserInfoServiceInterface.OnQueryUserInfoCallback paramOnQueryUserInfoCallback);
  
  public abstract void queryUserInfo(long paramLong, UserInfoServiceInterface.OnQueryUserInfoCallback paramOnQueryUserInfoCallback);
  
  public abstract void setSelfInfo(UserInfo paramUserInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.userinfoservice_interface.UserInfoServiceInterface
 * JD-Core Version:    0.7.0.1
 */