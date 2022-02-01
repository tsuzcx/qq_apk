package com.tencent.ilivesdk.coverservice_interface;

import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;

public abstract interface CoverServiceAdapter
{
  public abstract HttpInterface getHttp();
  
  public abstract LogInterface getLogger();
  
  public abstract LoginServiceInterface getLoginService();
  
  public abstract boolean isSvrTestEnv();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.coverservice_interface.CoverServiceAdapter
 * JD-Core Version:    0.7.0.1
 */