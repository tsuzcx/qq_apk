package com.tencent.mobileqq.Doraemon.util;

import android.text.TextUtils;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class DoraemonUtil
{
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 7;
    case 7: 
      return 14;
    case 6: 
      return 13;
    case 5: 
      return 12;
    case 4: 
      return 11;
    case 3: 
      return 9;
    }
    return 0;
  }
  
  public static String a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5)
            {
              if (paramInt != 6) {
                return "android";
              }
              return "qqpay";
            }
            return "limi";
          }
          return "mini_app";
        }
        return "mini_game";
      }
      return "ark";
    }
    return "web";
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoraemonOpenAPI.util", 2, "url is empty");
      }
      return null;
    }
    if ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("scheme not match ");
        localStringBuilder.append(paramString);
        QLog.d("DoraemonOpenAPI.util", 2, localStringBuilder.toString());
      }
      return null;
    }
    int i = paramString.indexOf('?');
    int j = paramString.indexOf('#');
    if (i == -1)
    {
      if (j == -1) {
        i = paramString.length();
      } else {
        i = j;
      }
    }
    else if (j != -1) {
      i = Math.min(i, j);
    }
    return paramString.substring(0, i);
  }
  
  public static void a(APICallback paramAPICallback, int paramInt)
  {
    ThreadManager.getUIHandler().post(new DoraemonUtil.4(paramAPICallback, paramInt));
  }
  
  public static void a(APICallback paramAPICallback, int paramInt, String paramString)
  {
    ThreadManager.getUIHandler().post(new DoraemonUtil.2(paramAPICallback, paramInt, paramString));
  }
  
  public static void a(APICallback paramAPICallback, JSONObject paramJSONObject)
  {
    ThreadManager.getUIHandler().post(new DoraemonUtil.1(paramAPICallback, paramJSONObject));
  }
  
  public static boolean a()
  {
    return MobileQQ.sProcessId == 1;
  }
  
  public static void b(APICallback paramAPICallback, JSONObject paramJSONObject)
  {
    ThreadManager.getUIHandler().post(new DoraemonUtil.3(paramAPICallback, paramJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.util.DoraemonUtil
 * JD-Core Version:    0.7.0.1
 */