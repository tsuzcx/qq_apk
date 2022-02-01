package com.tencent.ilivesdk.minicardservice_interface;

import com.tencent.ilivesdk.minicardservice_interface.model.MiniCardRspModel;

public abstract interface OnQueryMiniCardInfoCallback
{
  public abstract void onFetchMiniCardFail(String paramString);
  
  public abstract void onFetchMiniCardSuccess(MiniCardRspModel paramMiniCardRspModel);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.minicardservice_interface.OnQueryMiniCardInfoCallback
 * JD-Core Version:    0.7.0.1
 */