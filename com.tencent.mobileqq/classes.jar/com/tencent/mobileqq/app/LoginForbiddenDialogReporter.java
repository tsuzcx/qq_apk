package com.tencent.mobileqq.app;

import com.tencent.mobileqq.statistics.ReportController;
import mqq.app.AppRuntime;

public class LoginForbiddenDialogReporter
{
  public static void a(AppRuntime paramAppRuntime, String paramString, int paramInt)
  {
    String str;
    if (a(paramString)) {
      str = paramString;
    } else {
      str = "";
    }
    ReportController.a(paramAppRuntime, "dc00898", "", str, "0X800BAB7", "0X800BAB7", paramInt, 0, "", "", "", paramString);
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    String str1;
    if (paramInt2 != 1) {
      if (paramInt2 != 40) {
        str1 = "3";
      }
    }
    for (;;)
    {
      break;
      str1 = "2";
      continue;
      str1 = "1";
    }
    String str2;
    if (a(paramString1)) {
      str2 = paramString1;
    } else {
      str2 = "";
    }
    ReportController.a(paramAppRuntime, "dc00898", "", str2, "0X800BAB6", "0X800BAB6", paramInt1, 0, paramString2, str1, paramString3, paramString1);
  }
  
  private static boolean a(String paramString)
  {
    return LoginFailedHelper.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.LoginForbiddenDialogReporter
 * JD-Core Version:    0.7.0.1
 */