package com.tencent.mobileqq.activity.qwallet.config;

import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.preload.QWalletIPCConnector;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import eipc.EIPCClient;
import eipc.EIPCResult;

public class QWalletConfigManagerProxy
{
  private static volatile QWalletConfigManagerProxy a;
  
  private QWalletConfigManagerProxy()
  {
    QWalletIPCConnector.a().a();
  }
  
  public static QWalletConfigManagerProxy a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new QWalletConfigManagerProxy();
      }
      return a;
    }
    finally {}
  }
  
  public int a(String paramString, int paramInt, String... paramVarArgs)
  {
    QWalletIPCConnector.a().a();
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 0);
    localBundle.putString("module", paramString);
    localBundle.putInt("def_value", paramInt);
    localBundle.putStringArray("sub_keys", paramVarArgs);
    paramString = QIPCClientHelper.getInstance().getClient().callServer("QWalletIPCModule", "getConfig", localBundle);
    int i = paramInt;
    if (paramString != null)
    {
      i = paramInt;
      if (paramString.isSuccess())
      {
        i = paramInt;
        if (paramString.data != null) {
          i = paramString.data.getInt("res_get_value");
        }
      }
    }
    return i;
  }
  
  public String a(String paramString)
  {
    QWalletIPCConnector.a().a();
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 2);
    localBundle.putString("module", paramString);
    paramString = QIPCClientHelper.getInstance().getClient().callServer("QWalletIPCModule", "getConfig", localBundle);
    if ((paramString != null) && (paramString.isSuccess()) && (paramString.data != null)) {
      return paramString.data.getString("res_get_value");
    }
    return "";
  }
  
  public String a(String paramString1, String paramString2, String... paramVarArgs)
  {
    QWalletIPCConnector.a().a();
    Bundle localBundle = new Bundle();
    localBundle.putInt("oper_type", 1);
    localBundle.putString("module", paramString1);
    localBundle.putString("def_value", paramString2);
    localBundle.putStringArray("sub_keys", paramVarArgs);
    paramVarArgs = QIPCClientHelper.getInstance().getClient().callServer("QWalletIPCModule", "getConfig", localBundle);
    paramString1 = paramString2;
    if (paramVarArgs != null)
    {
      paramString1 = paramString2;
      if (paramVarArgs.isSuccess())
      {
        paramString1 = paramString2;
        if (paramVarArgs.data != null) {
          paramString1 = paramVarArgs.data.getString("res_get_value");
        }
      }
    }
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManagerProxy
 * JD-Core Version:    0.7.0.1
 */