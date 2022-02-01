package com.tencent.mobileqq.app;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class SignInModule
  extends QIPCModule
{
  private static SignInModule a;
  
  private SignInModule()
  {
    super("SignInModule");
  }
  
  public static SignInModule a()
  {
    if (a == null) {
      a = new SignInModule();
    }
    return a;
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    paramInt = paramBundle.getInt("type", 1);
    int i = paramBundle.getInt("result", 2);
    int j = paramBundle.getInt("day", 1);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("SignInModule onCall type = ");
      paramString.append(paramInt);
      paramString.append(",result = ");
      paramString.append(i);
      paramString.append(",day = ");
      paramString.append(j);
      QLog.i("DailySignIn", 2, paramString.toString());
    }
    if (i == 0)
    {
      paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (paramString != null)
      {
        paramString.getPreferences();
        paramString = (CardHandler)paramString.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
        if (QLog.isColorLevel()) {
          QLog.i("DailySignIn", 2, "get oidb0x922 by web");
        }
        paramString.c(0);
        paramString.f();
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.SignInModule
 * JD-Core Version:    0.7.0.1
 */