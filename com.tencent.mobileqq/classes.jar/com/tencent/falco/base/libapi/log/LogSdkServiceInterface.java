package com.tencent.falco.base.libapi.log;

import android.content.Context;
import com.tencent.falco.base.libapi.ServiceBaseInterface;

public abstract interface LogSdkServiceInterface
  extends ServiceBaseInterface
{
  public abstract void flush();
  
  public abstract LogInterface getLog();
  
  public abstract void init(Context paramContext);
  
  public abstract void onAppStart();
  
  public abstract void onAppStop();
  
  public abstract void setUUID(String paramString);
  
  public abstract void setUid(String paramString);
  
  public abstract void upload(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.libapi.log.LogSdkServiceInterface
 * JD-Core Version:    0.7.0.1
 */