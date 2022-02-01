package com.tencent.biz.pubaccount.weishi_new.combo.msg.bean;

import UserGrowth.stNotifyMsg;

public class WSMsgSectionData
{
  private int a;
  private int b;
  private WSMsgSectionData.SectionInfo c;
  private stNotifyMsg d;
  private int e = -1;
  private boolean f;
  
  public WSMsgSectionData(int paramInt1, int paramInt2, WSMsgSectionData.SectionInfo paramSectionInfo, stNotifyMsg paramstNotifyMsg)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramSectionInfo;
    this.d = paramstNotifyMsg;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public WSMsgSectionData.SectionInfo c()
  {
    return this.c;
  }
  
  public stNotifyMsg d()
  {
    return this.d;
  }
  
  public int e()
  {
    return this.e;
  }
  
  public boolean f()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.msg.bean.WSMsgSectionData
 * JD-Core Version:    0.7.0.1
 */