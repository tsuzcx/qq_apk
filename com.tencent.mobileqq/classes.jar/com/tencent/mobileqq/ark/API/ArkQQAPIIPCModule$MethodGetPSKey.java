package com.tencent.mobileqq.ark.API;

import android.os.Bundle;
import android.text.TextUtils;

public abstract class ArkQQAPIIPCModule$MethodGetPSKey
  implements ArkQQAPIIPCModule.IPCMethod
{
  private final String a;
  
  public ArkQQAPIIPCModule$MethodGetPSKey(String paramString)
  {
    this.a = paramString;
  }
  
  public Bundle a()
  {
    Bundle localBundle = new Bundle();
    if (!TextUtils.isEmpty(this.a)) {
      localBundle.putString("Domain", this.a);
    }
    return localBundle;
  }
  
  public String a()
  {
    return "QQ.GetPSKey";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkQQAPIIPCModule.MethodGetPSKey
 * JD-Core Version:    0.7.0.1
 */