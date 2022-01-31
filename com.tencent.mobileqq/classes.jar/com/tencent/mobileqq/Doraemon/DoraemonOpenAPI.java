package com.tencent.mobileqq.Doraemon;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.Doraemon.impl.DefaultDoraemonAPIManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import rbm;

public class DoraemonOpenAPI
{
  public static DoraemonAPIManager a(Activity paramActivity, int paramInt, String paramString)
  {
    return a(paramActivity, paramInt, paramString, null);
  }
  
  public static DoraemonAPIManager a(Activity paramActivity, int paramInt, String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DoraemonOpenAPI", 2, "createAPIManager type=" + paramInt + ", appid=" + paramString);
    }
    Object localObject = null;
    paramBundle = localObject;
    switch (paramInt)
    {
    default: 
      paramBundle = localObject;
    }
    for (;;)
    {
      if (paramBundle == null) {
        QLog.e("DoraemonOpenAPI", 1, "can not create APIManager type=" + paramInt + ", appid=" + paramString);
      }
      return paramBundle;
      paramBundle = new DefaultDoraemonAPIManager(paramActivity, paramInt, paramString);
      continue;
      paramBundle = new DefaultDoraemonAPIManager(paramActivity, paramInt, paramString);
    }
  }
  
  public static void a()
  {
    ThreadManager.post(new rbm(), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.DoraemonOpenAPI
 * JD-Core Version:    0.7.0.1
 */