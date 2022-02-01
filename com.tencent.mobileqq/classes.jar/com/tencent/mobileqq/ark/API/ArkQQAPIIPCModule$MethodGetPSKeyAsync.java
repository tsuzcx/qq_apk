package com.tencent.mobileqq.ark.API;

import android.os.Bundle;

public abstract class ArkQQAPIIPCModule$MethodGetPSKeyAsync
  implements ArkQQAPIIPCModule.IPCMethod
{
  private final String a;
  
  public ArkQQAPIIPCModule$MethodGetPSKeyAsync(String paramString)
  {
    this.a = paramString;
  }
  
  public Bundle a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("domain", this.a);
    return localBundle;
  }
  
  public String a()
  {
    return "QQ.GetPSKeyAsync";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkQQAPIIPCModule.MethodGetPSKeyAsync
 * JD-Core Version:    0.7.0.1
 */