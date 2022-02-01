package com.tencent.biz.pubaccount.readinjoy.common;

import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;

public class GalleryReportedUtils$ReportData
{
  public BaseArticleInfo a;
  public String a;
  public String b;
  public String c;
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  
  public GalleryReportedUtils$ReportData(BaseArticleInfo paramBaseArticleInfo)
  {
    this.a = paramBaseArticleInfo;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof ReportData)) {
      return false;
    }
    paramObject = (ReportData)paramObject;
    return this.a.equals(paramObject.a);
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.GalleryReportedUtils.ReportData
 * JD-Core Version:    0.7.0.1
 */