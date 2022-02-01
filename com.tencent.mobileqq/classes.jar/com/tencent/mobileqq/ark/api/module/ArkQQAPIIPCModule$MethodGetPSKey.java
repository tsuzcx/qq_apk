package com.tencent.mobileqq.ark.api.module;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.ark.ipc.IPCMethod;

public abstract class ArkQQAPIIPCModule$MethodGetPSKey
  implements IPCMethod
{
  private final String a;
  
  public ArkQQAPIIPCModule$MethodGetPSKey(String paramString)
  {
    this.a = paramString;
  }
  
  public String a()
  {
    return "QQ.GetPSKey";
  }
  
  public Bundle b()
  {
    Bundle localBundle = new Bundle();
    if (!TextUtils.isEmpty(this.a)) {
      localBundle.putString("Domain", this.a);
    }
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkQQAPIIPCModule.MethodGetPSKey
 * JD-Core Version:    0.7.0.1
 */