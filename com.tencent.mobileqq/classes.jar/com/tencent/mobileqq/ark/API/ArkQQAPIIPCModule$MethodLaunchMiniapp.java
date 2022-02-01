package com.tencent.mobileqq.ark.API;

import android.os.Bundle;

public abstract class ArkQQAPIIPCModule$MethodLaunchMiniapp
  implements ArkQQAPIIPCModule.IPCMethod
{
  private final String a;
  
  public ArkQQAPIIPCModule$MethodLaunchMiniapp(String paramString)
  {
    this.a = paramString;
  }
  
  public Bundle a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("url", this.a);
    return localBundle;
  }
  
  public String a()
  {
    return "QQ.LaunchMiniappHandler";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkQQAPIIPCModule.MethodLaunchMiniapp
 * JD-Core Version:    0.7.0.1
 */