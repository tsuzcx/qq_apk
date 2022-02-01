package com.tencent.biz.qqcircle.beans;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class QCircleMessageNoticeInfo
{
  private List<String> a;
  private int b;
  private String c;
  private String d;
  private String e;
  
  public QCircleMessageNoticeInfo(List<String> paramList, int paramInt, String paramString1, String paramString2)
  {
    this.a = paramList;
    this.b = paramInt;
    this.d = paramString1;
    this.e = paramString2;
  }
  
  public List<String> a()
  {
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    List localList = this.a;
    if ((localList != null) && (localList.size() > 0)) {
      localLinkedHashSet.addAll(this.a);
    }
    return new ArrayList(localLinkedHashSet);
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public int c()
  {
    return this.b;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public String e()
  {
    return this.e;
  }
  
  public boolean f()
  {
    return (a().size() > 0) || (c() > 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.beans.QCircleMessageNoticeInfo
 * JD-Core Version:    0.7.0.1
 */