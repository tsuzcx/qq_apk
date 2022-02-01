package com.tencent.biz.pubaccount.Advertisement.manager;

import java.util.HashMap;

class AdvertisementStatistics$Report
{
  public String a = "IMAX_Ad_StartCost";
  public String b = "";
  public String c = "";
  public int d = -1;
  public int e = -1;
  public long f = -1L;
  public long g = -1L;
  public long h = -1L;
  public long i = -1L;
  public boolean j = true;
  
  public HashMap<String, String> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("adid", this.b);
    localHashMap.put("vid", this.c);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.d);
    localHashMap.put("webPreloaded", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.e);
    localHashMap.put("videoPreloaded", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.g);
    localHashMap.put("webProStartCost", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.f);
    localHashMap.put("webActStartCost", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.h);
    localHashMap.put("actDisplayCost", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.i);
    localHashMap.put("videoDisplayCost", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.j);
    localHashMap.put("isFirst", localStringBuilder.toString());
    return localHashMap;
  }
  
  public void b()
  {
    this.b = "";
    this.c = "";
    this.d = -1;
    this.e = -1;
    this.f = -1L;
    this.g = -1L;
    this.h = -1L;
    this.i = -1L;
    this.j = true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("[name:");
    localStringBuilder2.append(this.a);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(" adid:");
    localStringBuilder2.append(this.b);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(" vid:");
    localStringBuilder2.append(this.c);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(" webPreloaded:");
    localStringBuilder2.append(this.d);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(" videoPreloaded:");
    localStringBuilder2.append(this.e);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(" webProStartCost:");
    localStringBuilder2.append(this.g);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(" webActStartCost:");
    localStringBuilder2.append(this.f);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(" actDisplayCost:");
    localStringBuilder2.append(this.h);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(" videoDisplayCost:");
    localStringBuilder2.append(this.i);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(" isFirst:");
    localStringBuilder2.append(this.j);
    localStringBuilder2.append("]");
    localStringBuilder1.append(localStringBuilder2.toString());
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementStatistics.Report
 * JD-Core Version:    0.7.0.1
 */