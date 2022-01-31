package com.tencent.mobileqq.app;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class CommonModule
  extends QIPCModule
{
  public static CommonModule a;
  
  private CommonModule()
  {
    super("CommonModule");
  }
  
  public static CommonModule a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new CommonModule();
      }
      return a;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommonModule", 2, "action = " + paramString + ", params = " + paramBundle);
    }
    paramBundle = new Bundle();
    if ("getPhoneBindState".equals(paramString))
    {
      paramString = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramString instanceof QQAppInterface))
      {
        paramBundle.putInt("selfBindState", ((PhoneContactManager)((QQAppInterface)paramString).getManager(10)).c());
        return EIPCResult.createSuccessResult(paramBundle);
      }
    }
    return EIPCResult.createSuccessResult(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.CommonModule
 * JD-Core Version:    0.7.0.1
 */