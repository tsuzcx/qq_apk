package com.tencent.falco.base.libapi.hostproxy;

public abstract interface HostChargeCallback
{
  public abstract void onChargeError(int paramInt, String paramString);
  
  public abstract void onChargeOk(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.libapi.hostproxy.HostChargeCallback
 * JD-Core Version:    0.7.0.1
 */