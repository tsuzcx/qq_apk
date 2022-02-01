package com.tencent.biz.pubaccount.weishi_new.drama.report;

import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerParam;

public class WSDramaVideoPlayReportParams
{
  private String a;
  private String b;
  private int c;
  private boolean d;
  private boolean e;
  private WSPlayerParam f;
  
  public WSDramaVideoPlayReportParams(String paramString, WSPlayerParam paramWSPlayerParam)
  {
    this.a = paramString;
    this.f = paramWSPlayerParam;
  }
  
  public WSDramaVideoPlayReportParams a(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
  
  public WSDramaVideoPlayReportParams a(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public WSDramaVideoPlayReportParams a(boolean paramBoolean)
  {
    this.d = paramBoolean;
    return this;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public WSDramaVideoPlayReportParams b(boolean paramBoolean)
  {
    this.e = paramBoolean;
    return this;
  }
  
  public WSPlayerParam b()
  {
    return this.f;
  }
  
  public boolean c()
  {
    return this.d;
  }
  
  public String d()
  {
    return this.b;
  }
  
  public int e()
  {
    return this.c;
  }
  
  public boolean f()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.report.WSDramaVideoPlayReportParams
 * JD-Core Version:    0.7.0.1
 */