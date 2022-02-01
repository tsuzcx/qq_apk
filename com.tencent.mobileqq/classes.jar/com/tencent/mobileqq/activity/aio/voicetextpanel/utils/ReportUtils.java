package com.tencent.mobileqq.activity.aio.voicetextpanel.utils;

import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class ReportUtils
{
  public static void a(int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("issuccess", String.valueOf(paramInt1));
    localHashMap.put("errorcode", String.valueOf(paramInt2));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "pttSliceToText", true, 0L, 0L, localHashMap, "");
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2)
  {
    ReportController.b(null, "dc00898", "", "", paramString, paramString, paramInt1, paramInt2, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.utils.ReportUtils
 * JD-Core Version:    0.7.0.1
 */