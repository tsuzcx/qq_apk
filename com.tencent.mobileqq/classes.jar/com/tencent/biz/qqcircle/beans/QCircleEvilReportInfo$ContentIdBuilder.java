package com.tencent.biz.qqcircle.beans;

import android.text.TextUtils;
import java.net.URLEncoder;

public class QCircleEvilReportInfo$ContentIdBuilder
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  
  public ContentIdBuilder a(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(this.a))
    {
      localStringBuilder.append("feed_id=");
      localStringBuilder.append(this.a);
      localStringBuilder.append("|");
    }
    if (!TextUtils.isEmpty(this.d))
    {
      localStringBuilder.append("ctim=");
      localStringBuilder.append(this.d);
      localStringBuilder.append("|");
    }
    if (!TextUtils.isEmpty(this.e))
    {
      localStringBuilder.append("poster_id=");
      localStringBuilder.append(this.e);
      localStringBuilder.append("|");
    }
    if (!TextUtils.isEmpty(this.b))
    {
      localStringBuilder.append("comment_id=");
      localStringBuilder.append(this.b);
      localStringBuilder.append("|");
    }
    if (!TextUtils.isEmpty(this.c))
    {
      localStringBuilder.append("reply_id=");
      localStringBuilder.append(this.c);
      localStringBuilder.append("|");
    }
    if (!TextUtils.isEmpty(this.f))
    {
      localStringBuilder.append("tag_name=");
      localStringBuilder.append(URLEncoder.encode(this.f));
      localStringBuilder.append("|");
    }
    if (!TextUtils.isEmpty(this.g))
    {
      localStringBuilder.append("account_type=");
      localStringBuilder.append(URLEncoder.encode(this.g));
      localStringBuilder.append("|");
    }
    localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    return localStringBuilder.toString();
  }
  
  public ContentIdBuilder b(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public ContentIdBuilder c(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public ContentIdBuilder d(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public ContentIdBuilder e(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public ContentIdBuilder f(String paramString)
  {
    this.f = paramString;
    return this;
  }
  
  public ContentIdBuilder g(String paramString)
  {
    this.g = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.beans.QCircleEvilReportInfo.ContentIdBuilder
 * JD-Core Version:    0.7.0.1
 */