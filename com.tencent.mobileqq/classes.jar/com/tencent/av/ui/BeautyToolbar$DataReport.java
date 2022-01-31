package com.tencent.av.ui;

import com.tencent.av.AVLog;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.statistics.ReportController;

public class BeautyToolbar$DataReport
{
  public static void a(String paramString)
  {
    ReportController.b(null, "CliOper", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  public static void b(String paramString)
  {
    int i = AVNotifyCenter.b(paramString);
    if (i > 0) {}
    for (String str = "0X80076B4";; str = "0X80076B3")
    {
      a(str);
      AVLog.c("BeautyToolbar", "DataReport onUserBeauty:" + paramString + "|" + i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.ui.BeautyToolbar.DataReport
 * JD-Core Version:    0.7.0.1
 */