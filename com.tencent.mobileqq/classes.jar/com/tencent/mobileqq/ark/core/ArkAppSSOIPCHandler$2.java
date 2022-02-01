package com.tencent.mobileqq.ark.core;

import android.os.Bundle;
import com.tencent.mobileqq.ark.ipc.IPCMethod;

final class ArkAppSSOIPCHandler$2
  implements IPCMethod
{
  ArkAppSSOIPCHandler$2(String paramString1, String paramString2, int paramInt1, int paramInt2, ArkAppSSOIPCHandler.OnSendMsgComplete paramOnSendMsgComplete) {}
  
  public String a()
  {
    return "ARK.SendSSOMsg";
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    int i;
    if (paramBundle != null)
    {
      paramBoolean = paramBundle.getBoolean("result_is_success");
      i = paramBundle.getInt("result_notify_type");
      paramBundle = paramBundle.getString("result_data");
    }
    else
    {
      i = 0;
      paramBundle = "";
    }
    this.e.a(paramBoolean, i, paramBundle);
  }
  
  public Bundle b()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param_cmd", this.a);
    localBundle.putString("param_data", this.b);
    localBundle.putInt("param_timeout", this.c);
    localBundle.putInt("param_notify_type", this.d);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.core.ArkAppSSOIPCHandler.2
 * JD-Core Version:    0.7.0.1
 */