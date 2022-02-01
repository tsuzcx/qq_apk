package com.tencent.biz.pubaccount.weishi_new.combo.msg.bean;

import UserGrowth.stMsgRedDotCount;
import java.util.List;
import java.util.Map;

public class WSMsgPageData
{
  private boolean a;
  private boolean b;
  private String c;
  private boolean d;
  private List<WSMsgSectionData> e;
  private Map<Integer, stMsgRedDotCount> f;
  
  public WSMsgPageData(boolean paramBoolean1, boolean paramBoolean2, String paramString, boolean paramBoolean3, List<WSMsgSectionData> paramList, Map<Integer, stMsgRedDotCount> paramMap)
  {
    this.a = paramBoolean1;
    this.b = paramBoolean2;
    this.c = paramString;
    this.d = paramBoolean3;
    this.e = paramList;
    this.f = paramMap;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString, boolean paramBoolean3)
  {
    this.a = paramBoolean1;
    this.b = paramBoolean2;
    this.c = paramString;
    this.d = paramBoolean3;
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public boolean d()
  {
    return this.d;
  }
  
  public List<WSMsgSectionData> e()
  {
    return this.e;
  }
  
  public stMsgRedDotCount f()
  {
    Map localMap = this.f;
    if (localMap == null) {
      return null;
    }
    return (stMsgRedDotCount)localMap.get(Integer.valueOf(2));
  }
  
  public stMsgRedDotCount g()
  {
    Map localMap = this.f;
    if (localMap == null) {
      return null;
    }
    return (stMsgRedDotCount)localMap.get(Integer.valueOf(4));
  }
  
  public stMsgRedDotCount h()
  {
    Map localMap = this.f;
    if (localMap == null) {
      return null;
    }
    return (stMsgRedDotCount)localMap.get(Integer.valueOf(5));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.msg.bean.WSMsgPageData
 * JD-Core Version:    0.7.0.1
 */