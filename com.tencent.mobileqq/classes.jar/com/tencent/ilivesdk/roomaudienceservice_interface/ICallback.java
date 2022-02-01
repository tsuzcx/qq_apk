package com.tencent.ilivesdk.roomaudienceservice_interface;

import java.util.List;

public abstract interface ICallback
{
  public abstract void onFail(int paramInt, String paramString);
  
  public abstract void onSuccess(List<UserServer> paramList, boolean paramBoolean, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.roomaudienceservice_interface.ICallback
 * JD-Core Version:    0.7.0.1
 */