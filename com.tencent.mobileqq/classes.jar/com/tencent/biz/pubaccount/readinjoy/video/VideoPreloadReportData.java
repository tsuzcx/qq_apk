package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class VideoPreloadReportData
{
  public static int a;
  public static int b = 1;
  public static int c = 2;
  public static int d = 1;
  public int e;
  public int f;
  public int g;
  public int h;
  public int i;
  public int j;
  public int k;
  public int l;
  
  public VideoPreloadReportData(int paramInt1, int paramInt2)
  {
    this.k = paramInt1;
    this.l = paramInt2;
  }
  
  public HashMap a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_hitCount", String.valueOf(this.e));
    localHashMap.put("param_notHitCount", String.valueOf(this.f));
    localHashMap.put("param_triggerCount", String.valueOf(this.g));
    localHashMap.put("param_triggerHitCount", String.valueOf(this.h));
    localHashMap.put("param_distinctTriggerHitCount", String.valueOf(this.i));
    localHashMap.put("param_realTriggerHitCount", String.valueOf(this.j));
    localHashMap.put("param_sceneType", String.valueOf(this.k));
    localHashMap.put("param_strategy", String.valueOf(this.l));
    if (QLog.isColorLevel()) {
      QLog.i("wgs", 2, "VideoPreloadReportData getReportMap " + localHashMap.toString());
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPreloadReportData
 * JD-Core Version:    0.7.0.1
 */