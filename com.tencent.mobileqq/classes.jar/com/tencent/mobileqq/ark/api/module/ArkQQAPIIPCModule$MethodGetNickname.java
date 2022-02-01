package com.tencent.mobileqq.ark.api.module;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.ark.ipc.IPCMethod;

public abstract class ArkQQAPIIPCModule$MethodGetNickname
  implements IPCMethod
{
  private final String a;
  
  public ArkQQAPIIPCModule$MethodGetNickname(String paramString)
  {
    this.a = paramString;
  }
  
  public String a()
  {
    return "QQ.GetNickname";
  }
  
  public Bundle b()
  {
    Bundle localBundle = new Bundle();
    if (!TextUtils.isEmpty(this.a)) {
      localBundle.putString("Uin", this.a);
    }
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkQQAPIIPCModule.MethodGetNickname
 * JD-Core Version:    0.7.0.1
 */