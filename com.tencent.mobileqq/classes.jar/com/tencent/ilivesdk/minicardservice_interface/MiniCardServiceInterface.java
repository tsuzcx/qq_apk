package com.tencent.ilivesdk.minicardservice_interface;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.minicardservice_interface.model.FollowUserReqModel;
import com.tencent.ilivesdk.minicardservice_interface.model.MiniCardReqModel;
import com.tencent.ilivesdk.minicardservice_interface.model.QueryFollowReqModel;

public abstract interface MiniCardServiceInterface
  extends ServiceBaseInterface
{
  public abstract void addUserInfoUpdateListener(OnUserInfoUpdateCallback paramOnUserInfoUpdateCallback);
  
  public abstract void followUser(FollowUserReqModel paramFollowUserReqModel, OnFollowUserCallback paramOnFollowUserCallback);
  
  public abstract void init(MiniCardServiceAdapter paramMiniCardServiceAdapter);
  
  public abstract void queryFollowStatus(QueryFollowReqModel paramQueryFollowReqModel, OnQueryFollowCallback paramOnQueryFollowCallback);
  
  public abstract void queryMiniCardInfo(MiniCardReqModel paramMiniCardReqModel, OnQueryMiniCardInfoCallback paramOnQueryMiniCardInfoCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.minicardservice_interface.MiniCardServiceInterface
 * JD-Core Version:    0.7.0.1
 */