package com.tencent.biz.pubaccount.weishi_new.combo.msg.bean;

import UserGrowth.stSchema;

public class WSMsgSectionData$SectionInfo
{
  private int a;
  private String b;
  private int c;
  private stSchema d;
  
  public WSMsgSectionData$SectionInfo(int paramInt1, String paramString, int paramInt2, stSchema paramstSchema)
  {
    this.a = paramInt1;
    this.b = paramString;
    this.c = paramInt2;
    this.d = paramstSchema;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public stSchema d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.msg.bean.WSMsgSectionData.SectionInfo
 * JD-Core Version:    0.7.0.1
 */