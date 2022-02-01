package com.tencent.mobileqq.ark.vipreport;

import android.os.Bundle;
import com.tencent.mobileqq.ark.ipc.IPCMethod;
import com.tencent.qphone.base.util.QLog;

final class ArkVipReporterIPCHandler$1
  implements IPCMethod
{
  ArkVipReporterIPCHandler$1(String paramString) {}
  
  public Bundle a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("content", this.a);
    return localBundle;
  }
  
  public String a()
  {
    return "ARK.VipReport";
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = new StringBuilder();
    paramBundle.append("onResultCallback, success=");
    paramBundle.append(paramBoolean);
    QLog.i("ArkApp.ArkVipReporterIPCHandler", 1, paramBundle.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.vipreport.ArkVipReporterIPCHandler.1
 * JD-Core Version:    0.7.0.1
 */