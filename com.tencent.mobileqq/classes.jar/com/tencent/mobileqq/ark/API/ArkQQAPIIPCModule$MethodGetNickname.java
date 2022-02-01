package com.tencent.mobileqq.ark.API;

import android.os.Bundle;
import android.text.TextUtils;

public abstract class ArkQQAPIIPCModule$MethodGetNickname
  implements ArkQQAPIIPCModule.IPCMethod
{
  private final String a;
  
  public ArkQQAPIIPCModule$MethodGetNickname(String paramString)
  {
    this.a = paramString;
  }
  
  public Bundle a()
  {
    Bundle localBundle = new Bundle();
    if (!TextUtils.isEmpty(this.a)) {
      localBundle.putString("Uin", this.a);
    }
    return localBundle;
  }
  
  public String a()
  {
    return "QQ.GetNickname";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkQQAPIIPCModule.MethodGetNickname
 * JD-Core Version:    0.7.0.1
 */