package com.tencent.mobileqq.activity.richmedia;

import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.statistics.MTAReportController;
import java.util.Properties;

public class ShortVideoMtaReport
{
  private static int a = 10000;
  
  public static void a(int paramInt)
  {
    a = paramInt;
  }
  
  public static void a(String paramString, Properties paramProperties)
  {
    Properties localProperties = paramProperties;
    if (paramProperties == null) {
      localProperties = new Properties();
    }
    localProperties.setProperty("shortvideo_business_type", "" + a);
    MTAReportController.a(VideoEnvironment.a()).reportKVEvent(paramString, localProperties);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.ShortVideoMtaReport
 * JD-Core Version:    0.7.0.1
 */