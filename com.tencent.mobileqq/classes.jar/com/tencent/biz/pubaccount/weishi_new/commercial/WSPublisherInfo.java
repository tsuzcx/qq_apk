package com.tencent.biz.pubaccount.weishi_new.commercial;

import UserGrowth.stFunctionalIconInfo;
import UserGrowth.stSchema;

public class WSPublisherInfo
  extends AbsWSRichWidgetData
{
  private final stFunctionalIconInfo a;
  
  public WSPublisherInfo(stFunctionalIconInfo paramstFunctionalIconInfo)
  {
    super(1);
    this.a = paramstFunctionalIconInfo;
  }
  
  public stSchema a()
  {
    if (this.a == null) {
      return null;
    }
    return this.a.jump;
  }
  
  public String a()
  {
    if (this.a == null) {
      return null;
    }
    return this.a.imgUrl;
  }
  
  public String b()
  {
    if (this.a == null) {
      return null;
    }
    return this.a.text;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.commercial.WSPublisherInfo
 * JD-Core Version:    0.7.0.1
 */