package com.tencent.hippy.qq.utils;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;

public class HippyCommonUtils
{
  public static void checkDebugHippyUpdate(QQAppInterface paramQQAppInterface, AppActivity paramAppActivity, String paramString)
  {
    String str = paramString;
    if (!isMqqapi(paramString))
    {
      paramString = Uri.parse(paramString);
      str = paramString.getQueryParameter("module");
      Object localObject = paramString.getQueryParameter("url");
      paramString = paramString.getQueryParameter("framework");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mqqapi://hippy/open?bundleName=");
      localStringBuilder.append(str);
      localStringBuilder.append("&bundleUrl=");
      localStringBuilder.append((String)localObject);
      str = localStringBuilder.toString();
      if (!TextUtils.isEmpty(paramString))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append("&framework=");
        ((StringBuilder)localObject).append(paramString);
        str = ((StringBuilder)localObject).toString();
      }
    }
    handleMqqJump(paramQQAppInterface, paramAppActivity, str);
  }
  
  public static boolean checkHippyQRCode(String paramString)
  {
    TextUtils.isEmpty(paramString);
    return false;
  }
  
  public static AppInterface getAppInterface()
  {
    Object localObject3 = BaseApplicationImpl.getApplication();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((BaseApplicationImpl)localObject3).getRuntime();
      if ((localObject3 instanceof ToolAppRuntime))
      {
        localObject3 = ((AppRuntime)localObject3).getAppRuntime("modular_web");
        localObject1 = localObject2;
        if ((localObject3 instanceof AppInterface)) {
          return (AppInterface)localObject3;
        }
      }
      else
      {
        localObject1 = localObject2;
        if ((localObject3 instanceof AppInterface)) {
          localObject1 = (AppInterface)localObject3;
        }
      }
    }
    return localObject1;
  }
  
  public static int getModuleOnlineConfig(String paramString)
  {
    paramString = Aladdin.getConfig(311).getString(paramString, "");
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    try
    {
      int i = Integer.valueOf(paramString).intValue();
      return i;
    }
    catch (NumberFormatException paramString) {}
    return 0;
  }
  
  public static void handleMqqJump(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString)
  {
    paramQQAppInterface = JumpParser.a(paramQQAppInterface, paramActivity, paramString);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a();
    }
  }
  
  private static boolean hasHippyParams(String paramString)
  {
    Object localObject = Uri.parse(paramString);
    paramString = ((Uri)localObject).getQueryParameter("module");
    localObject = ((Uri)localObject).getQueryParameter("url");
    return (!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty((CharSequence)localObject));
  }
  
  private static boolean isMqqapi(String paramString)
  {
    return paramString.startsWith("mqqapi");
  }
  
  private static boolean isQbScheme(String paramString)
  {
    return (paramString.startsWith("qb://react")) || (paramString.startsWith("qb://hippy"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.utils.HippyCommonUtils
 * JD-Core Version:    0.7.0.1
 */