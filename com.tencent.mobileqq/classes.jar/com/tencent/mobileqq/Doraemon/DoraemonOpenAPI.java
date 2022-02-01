package com.tencent.mobileqq.Doraemon;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.Doraemon.impl.DefaultDoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.impl.QQPayDoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.impl.webview.WebViewDoraemonAPIManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class DoraemonOpenAPI
{
  public static DoraemonAPIManager a(@NonNull Activity paramActivity, int paramInt, String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("createAPIManager type=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", appid=");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("DoraemonOpenAPI", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = null;
    String str = null;
    if (paramActivity == null)
    {
      QLog.e("DoraemonOpenAPI", 1, "can not create APIManager activity == null");
      return null;
    }
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("DoraemonOpenAPI", 1, "can not create APIManager appid is empty");
    }
    if (paramInt != 0)
    {
      if ((paramInt != 1) && (paramInt != 3) && (paramInt != 4) && (paramInt != 5))
      {
        if (paramInt != 6) {
          paramActivity = (Activity)localObject;
        } else {
          paramActivity = new QQPayDoraemonAPIManager(paramActivity, paramInt, paramString);
        }
      }
      else
      {
        DefaultDoraemonAPIManager localDefaultDoraemonAPIManager = new DefaultDoraemonAPIManager(paramActivity, paramInt, paramString);
        if (paramBundle != null)
        {
          paramActivity = paramBundle.getString("sdkVersion");
          localObject = paramBundle.getString("pkgName");
          str = paramBundle.getString("signature");
          paramBundle = (Bundle)localObject;
          localObject = str;
        }
        else
        {
          paramBundle = null;
          localObject = paramBundle;
          paramActivity = str;
        }
        ((DefaultDoraemonAPIManager)localDefaultDoraemonAPIManager).a(paramActivity, paramBundle, (String)localObject);
        paramActivity = localDefaultDoraemonAPIManager;
      }
    }
    else
    {
      if (paramBundle == null) {
        paramBundle = null;
      } else {
        paramBundle = paramBundle.getString("urlSummary", "");
      }
      if (TextUtils.isEmpty(paramBundle))
      {
        QLog.e("DoraemonOpenAPI", 1, "can not create APIManger url is empty");
        return null;
      }
      paramActivity = new WebViewDoraemonAPIManager(paramActivity, paramInt, paramString, paramBundle);
    }
    if (paramActivity == null)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("can not create APIManager type=");
      paramBundle.append(paramInt);
      paramBundle.append(", appid=");
      paramBundle.append(paramString);
      QLog.e("DoraemonOpenAPI", 1, paramBundle.toString());
      return paramActivity;
    }
    paramActivity.a();
    return paramActivity;
  }
  
  public static void a()
  {
    ThreadManager.post(new DoraemonOpenAPI.1(), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.DoraemonOpenAPI
 * JD-Core Version:    0.7.0.1
 */