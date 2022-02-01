package com.tencent.mobileqq.ar.arengine;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

class ARReport$2
  implements Runnable
{
  ARReport$2(ARReport paramARReport, String paramString, long paramLong1, long paramLong2, int paramInt1, long paramLong3, long paramLong4, int paramInt2, long paramLong5, int paramInt3, long paramLong6, long paramLong7, int paramInt4) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    String str = this.a;
    if (str != null) {
      localHashMap.put("cloud_download_imgId", String.valueOf(str));
    }
    long l1 = this.b;
    if (l1 > 0L) {
      localHashMap.put("cloud_download_feature_size", String.valueOf(l1));
    }
    if (ARReport.a(this.this$0, this.c)) {
      localHashMap.put("cloud_download_feature_time", String.valueOf(this.c));
    }
    int m = this.d;
    if (m > -1) {
      localHashMap.put("cloud_download_feature_code", String.valueOf(m));
    }
    l1 = this.e;
    if (l1 > 0L) {
      localHashMap.put("cloud_download_model_size", String.valueOf(l1));
    }
    if (ARReport.a(this.this$0, this.f)) {
      localHashMap.put("cloud_download_model_time", String.valueOf(this.f));
    }
    m = this.g;
    if (m > -1) {
      localHashMap.put("cloud_download_model_code", String.valueOf(m));
    }
    l1 = this.h;
    if (l1 > 0L) {
      localHashMap.put("cloud_download_unzip_time", String.valueOf(l1));
    }
    m = this.i;
    if (m > -1) {
      localHashMap.put("cloud_download_type", String.valueOf(m));
    }
    localHashMap.put("cloud_download_net_type", String.valueOf(NetworkUtil.getSystemNetwork(BaseApplication.getContext())));
    if (ARReport.a(this.this$0, this.j)) {
      localHashMap.put("cloud_download_all_time", String.valueOf(this.j));
    }
    l1 = this.k;
    if (l1 > 0L) {
      localHashMap.put("cloud_download_net_size", String.valueOf(l1));
    }
    m = this.l;
    if (m > -1) {
      localHashMap.put("cloud_download_all_result", String.valueOf(m));
    }
    localHashMap.put("cloud_download_type", "0");
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "AndroidactARCloudDownLoad", true, 0L, 0L, localHashMap, "", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARReport.2
 * JD-Core Version:    0.7.0.1
 */