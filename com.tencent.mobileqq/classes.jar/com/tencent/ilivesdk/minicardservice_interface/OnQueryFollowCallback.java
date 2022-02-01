package com.tencent.ilivesdk.minicardservice_interface;

import com.tencent.ilivesdk.minicardservice_interface.model.QueryFollowRspModel;

public abstract interface OnQueryFollowCallback
{
  public abstract void onQueryFollowFail(String paramString);
  
  public abstract void onQueryFollowSuccess(QueryFollowRspModel paramQueryFollowRspModel);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.minicardservice_interface.OnQueryFollowCallback
 * JD-Core Version:    0.7.0.1
 */