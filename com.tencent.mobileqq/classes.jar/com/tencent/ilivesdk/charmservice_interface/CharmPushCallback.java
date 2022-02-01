package com.tencent.ilivesdk.charmservice_interface;

import com.tencent.ilivesdk.charmservice_interface.model.CharmInfo;

public abstract interface CharmPushCallback
{
  public abstract void onReceiveCharmInfoFail(String paramString);
  
  public abstract void onReceiveCharmInfoSuccess(CharmInfo paramCharmInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.charmservice_interface.CharmPushCallback
 * JD-Core Version:    0.7.0.1
 */