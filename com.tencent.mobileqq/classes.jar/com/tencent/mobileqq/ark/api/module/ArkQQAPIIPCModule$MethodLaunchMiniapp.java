package com.tencent.mobileqq.ark.api.module;

import android.os.Bundle;
import com.tencent.mobileqq.ark.ipc.IPCMethod;

public abstract class ArkQQAPIIPCModule$MethodLaunchMiniapp
  implements IPCMethod
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkQQAPIIPCModule.MethodLaunchMiniapp
 * JD-Core Version:    0.7.0.1
 */