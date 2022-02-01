package com.tencent.mobileqq.ark.api.module;

import android.os.Bundle;
import com.tencent.mobileqq.ark.ipc.IPCMethod;

public abstract class ArkQQAPIIPCModule$MethodLogin
  implements IPCMethod
{
  private final long a;
  private final long b;
  
  public ArkQQAPIIPCModule$MethodLogin(long paramLong1, long paramLong2)
  {
    this.a = paramLong1;
    this.b = paramLong2;
  }
  
  public Bundle a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("srcAppID", this.a);
    localBundle.putLong("dstAppID", this.b);
    return localBundle;
  }
  
  public String a()
  {
    return "QQ.Login";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkQQAPIIPCModule.MethodLogin
 * JD-Core Version:    0.7.0.1
 */