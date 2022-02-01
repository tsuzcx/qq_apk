package com.tencent.mobileqq.app;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class LoginFailedHelper
{
  private HashMap<String, Integer> a = new HashMap();
  
  private void a(Context paramContext, String paramString)
  {
    DialogUtil.a(paramContext, 230, HardCodeUtil.a(2131706365), paramString, 2131692531, 2131694615, new LoginFailedHelper.3(this), null).show();
  }
  
  public static void a(Context paramContext, String paramString, AppRuntime paramAppRuntime)
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(paramContext, 230);
    localQQCustomDialog.setTitle(2131699685);
    localQQCustomDialog.setMessage(2131699684);
    localQQCustomDialog.setPositiveButton(2131694615, new LoginFailedHelper.4(paramContext, paramString, paramAppRuntime));
    localQQCustomDialog.setCancelable(true);
    localQQCustomDialog.show();
  }
  
  private void a(String paramString)
  {
    if (this.a.containsKey(paramString))
    {
      this.a.put(paramString, Integer.valueOf(((Integer)this.a.get(paramString)).intValue() + 1));
      return;
    }
    this.a.put(paramString, Integer.valueOf(1));
  }
  
  private void a(AppRuntime paramAppRuntime, Context paramContext, String paramString1, int paramInt, String paramString2, Runnable paramRunnable)
  {
    if (paramRunnable == null)
    {
      QLog.e("LoginFailedHelper", 1, "onClick action is null");
      return;
    }
    DialogUtil.a(paramContext, 230, HardCodeUtil.a(2131706365), paramString2, 2131692531, 2131694615, new LoginFailedHelper.1(this, paramAppRuntime, paramString1, paramInt), new LoginFailedHelper.2(this, paramRunnable, paramAppRuntime, paramString1, paramInt)).show();
  }
  
  private void a(AppRuntime paramAppRuntime, String paramString1, int paramInt, String paramString2)
  {
    if (a(paramString1)) {}
    for (String str = paramString1;; str = "")
    {
      ReportController.a(paramAppRuntime, "dc00898", "", str, paramString2, paramString2, paramInt, 0, ((Integer)this.a.get(paramString1)).toString(), "", paramString1, "");
      return;
    }
  }
  
  public static boolean a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.charAt(0) == '0') || (paramString.length() < 5) || (paramString.length() > 12)) {
      return false;
    }
    paramString = paramString.toCharArray();
    int j = paramString.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label67;
      }
      if (!Character.isDigit(paramString[i])) {
        break;
      }
      i += 1;
    }
    label67:
    return true;
  }
  
  public void a(AppRuntime paramAppRuntime, Activity paramActivity, String paramString1, int paramInt, String paramString2, Runnable paramRunnable)
  {
    if ((paramAppRuntime == null) || (paramActivity == null) || (paramString1 == null))
    {
      QLog.e("LoginFailedHelper", 1, "either app, activity or uin is null.");
      return;
    }
    if (paramActivity.isFinishing())
    {
      QLog.d("LoginFailedHelper", 1, "activity is not running.");
      return;
    }
    if (paramString2 == null) {
      paramString2 = "";
    }
    for (;;)
    {
      a(paramString1);
      if (((Integer)this.a.get(paramString1)).intValue() >= 3)
      {
        a(paramAppRuntime, paramActivity, paramString1, paramInt, paramString2, paramRunnable);
        a(paramAppRuntime, paramString1, paramInt, "0X800B8F5");
        return;
      }
      a(paramActivity, paramString2);
      a(paramAppRuntime, paramString1, paramInt, "0X800B8F4");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.LoginFailedHelper
 * JD-Core Version:    0.7.0.1
 */