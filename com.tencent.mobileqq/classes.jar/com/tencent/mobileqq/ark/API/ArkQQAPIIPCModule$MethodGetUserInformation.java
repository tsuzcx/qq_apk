package com.tencent.mobileqq.ark.API;

import android.os.Bundle;

public abstract class ArkQQAPIIPCModule$MethodGetUserInformation
  implements ArkQQAPIIPCModule.IPCMethod
{
  private final String a;
  
  public ArkQQAPIIPCModule$MethodGetUserInformation(String paramString)
  {
    this.a = paramString;
  }
  
  public Bundle a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", this.a);
    return localBundle;
  }
  
  public String a()
  {
    return "QQ.GetUserInformation";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkQQAPIIPCModule.MethodGetUserInformation
 * JD-Core Version:    0.7.0.1
 */