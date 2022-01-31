package com.tencent.mobileqq.activity.bless;

import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.statistics.MTAReportController;
import java.util.Properties;

public class BlessMtaReport
{
  public static void a(String paramString, Properties paramProperties)
  {
    MTAReportController.a(VideoEnvironment.a()).reportKVEvent(paramString, paramProperties);
  }
  
  public static void a(String paramString, Properties paramProperties, int paramInt)
  {
    MTAReportController.a(VideoEnvironment.a()).reportTimeKVEvent(paramString, paramProperties, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessMtaReport
 * JD-Core Version:    0.7.0.1
 */