package com.tencent.ilinkservice;

import java.util.Vector;

abstract interface IlinkServiceTdiCallback$a
{
  public abstract void addDeviceCallbackTask(String paramString1, String paramString2, Class[] paramArrayOfClass, Object... paramVarArgs);
  
  public abstract void addServiceCallbackTask(String paramString1, String paramString2, Class[] paramArrayOfClass, Object... paramVarArgs);
  
  public abstract String getCallerByTaskid(int paramInt);
  
  public abstract Vector<String> getCloneCallers(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilinkservice.IlinkServiceTdiCallback.a
 * JD-Core Version:    0.7.0.1
 */