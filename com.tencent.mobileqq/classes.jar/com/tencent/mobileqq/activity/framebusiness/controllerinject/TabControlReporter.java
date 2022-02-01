package com.tencent.mobileqq.activity.framebusiness.controllerinject;

import android.text.TextUtils;
import android.widget.TabHost.TabSpec;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQTabHost;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class TabControlReporter
{
  private static ITabDataUtil a;
  
  static
  {
    try
    {
      a = (ITabDataUtil)((Class)TabDataUtil.a.get(0)).newInstance();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("TabControlReporter", 1, "TabUIHelper static statement: ", localException);
    }
  }
  
  public static void a()
  {
    ReportController.b(null, "dc00898", "", "", "0X800BE80", "0X800BE80", 0, 0, "", "", "", "");
  }
  
  public static void a(QQTabHost paramQQTabHost, ArrayList<TabHost.TabSpec> paramArrayList)
  {
    if ((paramQQTabHost != null) && (paramArrayList != null))
    {
      int j = paramQQTabHost.getCurrentTab();
      int i = 0;
      while (i < paramArrayList.size())
      {
        paramQQTabHost = (TabHost.TabSpec)paramArrayList.get(i);
        if (paramQQTabHost != null)
        {
          int k = b(paramQQTabHost.getTag());
          String str = b();
          if (j == i) {
            paramQQTabHost = "选中";
          } else {
            paramQQTabHost = "非选中";
          }
          ReportController.b(null, "dc00898", "", "", "0X800BE2B", "0X800BE2B", k, 0, "", "", str, paramQQTabHost);
        }
        i += 1;
      }
    }
  }
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("TabControlReporter", 1, "reportTabDlgFirstShow error: configStr is empty");
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800BE08", "0X800BE08", c(paramString), 0, "", "", "", "");
  }
  
  public static void a(String paramString, int paramInt)
  {
    int i = b(paramString);
    paramString = new StringBuilder();
    paramString.append(paramInt);
    paramString.append("");
    ReportController.b(null, "dc00898", "", "", "0X800BE01", "0X800BE01", i, 0, paramString.toString(), "", "", "");
  }
  
  public static void a(String paramString, int paramInt, boolean paramBoolean)
  {
    int i = b(paramString);
    if (paramBoolean) {
      paramString = "2";
    } else {
      paramString = "1";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    ReportController.b(null, "dc00898", "", "", "0X800BE00", "0X800BE00", i, 0, localStringBuilder.toString(), paramString, b(), "");
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("TabControlReporter", 1, "reportTabDlgFirstClk error: displayName is empty");
      return;
    }
    int i = d(paramString);
    if (paramBoolean) {
      paramString = "2";
    } else {
      paramString = "1";
    }
    ReportController.b(null, "dc00898", "", "", "0X800BE09", "0X800BE09", i, 0, paramString, "", "", "");
  }
  
  public static void a(boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = "2";
    } else {
      str = "1";
    }
    ReportController.b(null, "dc00898", "", "", "0X800BE81", "0X800BE81", 0, 0, str, "", "", "");
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    String str;
    if (paramBoolean2)
    {
      if (paramBoolean1) {
        str = "2";
      } else {
        str = "1";
      }
      ReportController.b(null, "dc00898", "", "", "0X800BE8C", "0X800BE8C", 0, 0, str, "", "", "");
      return;
    }
    if (paramBoolean1) {
      str = "2";
    } else {
      str = "1";
    }
    ReportController.b(null, "dc00898", "", "", "0X800BE83", "0X800BE83", 0, 0, str, "", "", "");
  }
  
  private static int b(String paramString)
  {
    return a.a(paramString);
  }
  
  private static String b()
  {
    int i = TabDataHelper.getModelType();
    if (i != 2)
    {
      if (i != 3) {
        return "默认模式";
      }
      return "青少年模式";
    }
    return "简洁模式";
  }
  
  public static void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ReportController.b(null, "dc00898", "", "", "0X800BE8B", "0X800BE8B", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800BE82", "0X800BE82", 0, 0, "", "", "", "");
  }
  
  private static int c(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("TabControlReporter", 1, "getDlgShowReportType error: configStr is empty");
      return 0;
    }
    if ((paramString.contains("NEW_WORLD")) && (paramString.contains("GUILD"))) {
      return 3;
    }
    if (paramString.contains("NEW_WORLD")) {
      return 1;
    }
    if (paramString.contains("GUILD")) {
      return 2;
    }
    return 0;
  }
  
  private static int d(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("TabControlReporter", 1, "getDlgFirstClkReportType error: configStr is empty");
      return 0;
    }
    if ((paramString.contains("“频道”")) && (paramString.contains("“小世界”"))) {
      return 3;
    }
    if (paramString.contains("“小世界”")) {
      return 1;
    }
    if (paramString.contains("“频道”")) {
      return 2;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.controllerinject.TabControlReporter
 * JD-Core Version:    0.7.0.1
 */