package com.tencent.falco.base.libapi.wns;

import android.content.Context;
import com.tencent.falco.base.libapi.ServiceBaseInterface;

public abstract interface WnsInterface
  extends ServiceBaseInterface
{
  public abstract void init(Context paramContext, int paramInt, boolean paramBoolean);
  
  public abstract boolean isGlobalInitialized();
  
  public abstract void login(String paramString1, String paramString2, int paramInt, WnsLoginCallback paramWnsLoginCallback);
  
  public abstract void logout(WnsLogoutCallback paramWnsLogoutCallback);
  
  public abstract void send(String paramString, byte[] paramArrayOfByte, int paramInt, WnsSendCallback paramWnsSendCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.libapi.wns.WnsInterface
 * JD-Core Version:    0.7.0.1
 */