package com.tencent.ad.tangram.device;

import android.content.Context;
import android.support.annotation.Keep;

@Keep
public abstract interface AdTAIDAdapter
{
  public abstract AdTAID.Entity getEntity(Context paramContext, String paramString);
  
  public abstract void init(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.device.AdTAIDAdapter
 * JD-Core Version:    0.7.0.1
 */