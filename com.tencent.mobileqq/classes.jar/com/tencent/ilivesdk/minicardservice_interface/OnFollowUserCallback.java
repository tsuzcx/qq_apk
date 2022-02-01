package com.tencent.ilivesdk.minicardservice_interface;

import com.tencent.ilivesdk.minicardservice_interface.model.FollowUserRspModel;

public abstract interface OnFollowUserCallback
{
  public abstract void onFollowUserFail(String paramString);
  
  public abstract void onFollowUserSuccess(FollowUserRspModel paramFollowUserRspModel);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.minicardservice_interface.OnFollowUserCallback
 * JD-Core Version:    0.7.0.1
 */