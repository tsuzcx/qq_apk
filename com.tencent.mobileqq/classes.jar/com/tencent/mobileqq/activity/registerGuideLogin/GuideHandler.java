package com.tencent.mobileqq.activity.registerGuideLogin;

import android.content.Intent;
import android.os.Build;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class GuideHandler
{
  public static final String[] a = { "H60-L02", "H60-L01" };
  
  private static int a(Intent paramIntent)
  {
    boolean bool1 = paramIntent.getBooleanExtra("from_register_guide", false);
    boolean bool2 = paramIntent.getBooleanExtra("isActionSend", false);
    boolean bool3 = paramIntent.getBooleanExtra("from_register_choose", false);
    boolean bool4 = paramIntent.getBooleanExtra("is_need_login_with_mask", false);
    if ((!bool1) && (!bool2) && (!bool3) && (!bool4))
    {
      paramIntent = MobileQQ.sMobileQQ.getAllAccounts();
      if ((paramIntent == null) || (paramIntent.isEmpty())) {
        return 101;
      }
    }
    return 102;
  }
  
  public static GuideBaseFragment a(QBaseActivity paramQBaseActivity, AppRuntime paramAppRuntime)
  {
    int i = a(paramQBaseActivity.getIntent());
    if (i != 101)
    {
      if (i != 102) {
        return new LoginView(paramAppRuntime);
      }
      return new LoginView(paramAppRuntime);
    }
    return new RegisterGuideView(paramAppRuntime);
  }
  
  public static boolean a(String[] paramArrayOfString)
  {
    String str = Build.MODEL;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isKeyBoardBlackList model=");
      localStringBuilder.append(str);
      QLog.d("GuideHandler", 2, localStringBuilder.toString());
    }
    if (str != null)
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (str.equals(paramArrayOfString[i])) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.GuideHandler
 * JD-Core Version:    0.7.0.1
 */