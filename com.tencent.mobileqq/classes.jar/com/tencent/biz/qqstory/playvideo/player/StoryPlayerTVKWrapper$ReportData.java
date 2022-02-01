package com.tencent.biz.qqstory.playvideo.player;

import java.util.ArrayList;
import java.util.Collections;

public class StoryPlayerTVKWrapper$ReportData
  implements Cloneable
{
  public ArrayList<Integer> a = new ArrayList();
  public String b;
  public boolean c;
  public long d;
  public String e;
  public int f;
  public int g;
  public long h;
  public String i;
  public long j;
  public long k;
  public long l;
  public String m;
  
  public StoryPlayerTVKWrapper$ReportData() {}
  
  public StoryPlayerTVKWrapper$ReportData(ReportData paramReportData)
  {
    this.a.addAll(paramReportData.a);
    this.b = paramReportData.b;
    this.c = paramReportData.c;
    this.d = paramReportData.d;
    this.e = paramReportData.e;
    this.f = paramReportData.f;
    this.g = paramReportData.g;
    this.h = paramReportData.h;
    this.i = paramReportData.i;
    this.j = paramReportData.j;
    this.m = paramReportData.m;
  }
  
  public void a()
  {
    this.a.clear();
    this.b = null;
    this.c = false;
    this.d = 0L;
    this.e = null;
    this.f = 0;
    this.g = 0;
    this.h = 0L;
    this.i = null;
    this.j = 0L;
    this.m = null;
  }
  
  public long b()
  {
    if (this.a.size() >= 3) {
      return ((Integer)Collections.max(this.a)).intValue();
    }
    return -1L;
  }
  
  public long c()
  {
    if (this.a.size() >= 3) {
      return ((Integer)Collections.min(this.a)).intValue();
    }
    return -1L;
  }
  
  public long d()
  {
    if (this.a.size() < 3) {
      return -1L;
    }
    int i2 = Math.min(this.a.size(), 10);
    int n = 0;
    int i1 = 0;
    while (n < i2)
    {
      i1 += ((Integer)this.a.get(n)).intValue();
      n += 1;
    }
    return i1 / i2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.f);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.g);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.h);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" ");
    localStringBuilder.append(d());
    localStringBuilder.append(" ");
    localStringBuilder.append(c());
    localStringBuilder.append(" ");
    localStringBuilder.append(b());
    localStringBuilder.append(" ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.i);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.j);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.m);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.StoryPlayerTVKWrapper.ReportData
 * JD-Core Version:    0.7.0.1
 */