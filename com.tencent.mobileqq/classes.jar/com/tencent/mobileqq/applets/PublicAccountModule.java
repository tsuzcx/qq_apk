package com.tencent.mobileqq.applets;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class PublicAccountModule
  extends QIPCModule
{
  private static PublicAccountModule a;
  
  public PublicAccountModule(String paramString)
  {
    super(paramString);
  }
  
  public static PublicAccountModule a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new PublicAccountModule("PublicAccountModule");
        }
      }
      finally {}
    }
    return a;
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("PublicAccountModule : ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramBundle.toString());
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(", ");
      localStringBuilder.append(paramInt);
      QLog.d("PublicAccountModule", 2, new Object[] { localObject, localStringBuilder.toString() });
    }
    if ("ACTION_REPORT_PUBLIC_ACCOUNT_FOLLOW_INFO_IN_WEBVIEW".equalsIgnoreCase(paramString))
    {
      paramInt = paramBundle.getInt("BUNDLE_KEY_REPORT_INFO_SOURCE", -1);
      localObject = paramBundle.getString("BUNDLE_KEY_REPORT_INFO_PUIN", "");
      boolean bool = paramBundle.getBoolean("BUNDLE_KEY_REPORT_INFO_IS_FOLLOW", false);
      if ((paramInt != -1) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
          paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        } else {
          paramString = null;
        }
        if (paramString == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountModule", 2, "app is null!");
          }
          return null;
        }
        PublicAccountStateReporter.a(paramString, bool, (String)localObject, paramInt);
        return null;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountModule", 2, new Object[] { "empty error: source=", Integer.valueOf(paramInt), " uin=", localObject });
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.applets.PublicAccountModule
 * JD-Core Version:    0.7.0.1
 */