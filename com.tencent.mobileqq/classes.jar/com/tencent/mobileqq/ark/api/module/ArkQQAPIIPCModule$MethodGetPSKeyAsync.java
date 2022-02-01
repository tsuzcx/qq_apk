package com.tencent.mobileqq.ark.api.module;

import android.os.Bundle;
import com.tencent.mobileqq.ark.ipc.IPCMethod;

public abstract class ArkQQAPIIPCModule$MethodGetPSKeyAsync
  implements IPCMethod
{
  private final String a;
  
  public ArkQQAPIIPCModule$MethodGetPSKeyAsync(String paramString)
  {
    this.a = paramString;
  }
  
  public String a()
  {
    return "QQ.GetPSKeyAsync";
  }
  
  public Bundle b()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("domain", this.a);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkQQAPIIPCModule.MethodGetPSKeyAsync
 * JD-Core Version:    0.7.0.1
 */