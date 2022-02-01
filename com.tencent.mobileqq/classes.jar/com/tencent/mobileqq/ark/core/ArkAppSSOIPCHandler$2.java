package com.tencent.mobileqq.ark.core;

import android.os.Bundle;
import com.tencent.mobileqq.ark.ipc.IPCMethod;

final class ArkAppSSOIPCHandler$2
  implements IPCMethod
{
  ArkAppSSOIPCHandler$2(String paramString1, String paramString2, int paramInt1, int paramInt2, ArkAppSSOIPCHandler.OnSendMsgComplete paramOnSendMsgComplete) {}
  
  public Bundle a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("param_cmd", this.jdField_a_of_type_JavaLangString);
    localBundle.putString("param_data", this.jdField_b_of_type_JavaLangString);
    localBundle.putInt("param_timeout", this.jdField_a_of_type_Int);
    localBundle.putInt("param_notify_type", this.jdField_b_of_type_Int);
    return localBundle;
  }
  
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
    this.jdField_a_of_type_ComTencentMobileqqArkCoreArkAppSSOIPCHandler$OnSendMsgComplete.a(paramBoolean, i, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.core.ArkAppSSOIPCHandler.2
 * JD-Core Version:    0.7.0.1
 */