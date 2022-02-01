package com.tencent.mobileqq.ark.api.module;

import android.os.Bundle;
import com.tencent.mobileqq.ark.ipc.IPCMethod;

public abstract class ArkQQAPIIPCModule$MethodGetUserInformation
  implements IPCMethod
{
  private final String a;
  
  public ArkQQAPIIPCModule$MethodGetUserInformation(String paramString)
  {
    this.a = paramString;
  }
  
  public String a()
  {
    return "QQ.GetUserInformation";
  }
  
  public Bundle b()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", this.a);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkQQAPIIPCModule.MethodGetUserInformation
 * JD-Core Version:    0.7.0.1
 */