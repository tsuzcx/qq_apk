package com.tencent.av.ui;

import com.tencent.av.AVLog;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.ReportController;

public class BeautyToolbar$DataReport
{
  public static void a(String paramString)
  {
    ReportController.b(null, "CliOper", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  public static void b(String paramString)
  {
    int i = 0;
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof VideoAppInterface)) {
      i = ((VideoAppInterface)localObject).b("BEAUTY_SKIN");
    }
    if (i > 0) {}
    for (localObject = "0X80076B4";; localObject = "0X80076B3")
    {
      a((String)localObject);
      AVLog.printColorLog("BeautyToolbar", "DataReport onUserBeauty:" + paramString + "|" + i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.BeautyToolbar.DataReport
 * JD-Core Version:    0.7.0.1
 */