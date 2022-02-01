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
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    int i;
    if ((localObject instanceof VideoAppInterface)) {
      i = ((VideoAppInterface)localObject).b("BEAUTY_SKIN");
    } else {
      i = 0;
    }
    if (i > 0) {
      localObject = "0X80076B4";
    } else {
      localObject = "0X80076B3";
    }
    a((String)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("DataReport onUserBeauty:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(i);
    AVLog.printColorLog("BeautyToolbar", ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.BeautyToolbar.DataReport
 * JD-Core Version:    0.7.0.1
 */