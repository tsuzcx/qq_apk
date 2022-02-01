package com.tencent.mobileqq.ark.api.module;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.ark.ipc.IPCMethod;

public abstract class ArkQQAPIIPCModule$MethodGetNicknameByView
  implements IPCMethod
{
  private final String a;
  private final long b;
  
  public ArkQQAPIIPCModule$MethodGetNicknameByView(String paramString, long paramLong)
  {
    this.a = paramString;
    this.b = paramLong;
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
    localBundle.putLong("ViewHandle", this.b);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkQQAPIIPCModule.MethodGetNicknameByView
 * JD-Core Version:    0.7.0.1
 */