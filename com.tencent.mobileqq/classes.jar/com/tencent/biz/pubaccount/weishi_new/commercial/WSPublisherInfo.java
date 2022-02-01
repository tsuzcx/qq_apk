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
    stFunctionalIconInfo localstFunctionalIconInfo = this.a;
    if (localstFunctionalIconInfo == null) {
      return null;
    }
    return localstFunctionalIconInfo.jump;
  }
  
  public String a()
  {
    stFunctionalIconInfo localstFunctionalIconInfo = this.a;
    if (localstFunctionalIconInfo == null) {
      return null;
    }
    return localstFunctionalIconInfo.imgUrl;
  }
  
  public String b()
  {
    stFunctionalIconInfo localstFunctionalIconInfo = this.a;
    if (localstFunctionalIconInfo == null) {
      return null;
    }
    return localstFunctionalIconInfo.text;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.commercial.WSPublisherInfo
 * JD-Core Version:    0.7.0.1
 */