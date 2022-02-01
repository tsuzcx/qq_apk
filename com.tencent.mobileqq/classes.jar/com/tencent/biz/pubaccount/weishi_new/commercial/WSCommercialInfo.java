package com.tencent.biz.pubaccount.weishi_new.commercial;

import UserGrowth.stBusinessIconInfo;
import UserGrowth.stIconButton;
import UserGrowth.stSchema;

public class WSCommercialInfo
  extends AbsWSRichWidgetData
{
  protected final stBusinessIconInfo a;
  
  public WSCommercialInfo(stBusinessIconInfo paramstBusinessIconInfo)
  {
    super(3);
    this.a = paramstBusinessIconInfo;
  }
  
  public stSchema a()
  {
    stBusinessIconInfo localstBusinessIconInfo = this.a;
    if (localstBusinessIconInfo == null) {
      return null;
    }
    return localstBusinessIconInfo.schema;
  }
  
  public String b()
  {
    stBusinessIconInfo localstBusinessIconInfo = this.a;
    if ((localstBusinessIconInfo != null) && (localstBusinessIconInfo.button != null)) {
      return this.a.button.buttonIcon;
    }
    return null;
  }
  
  public String c()
  {
    stBusinessIconInfo localstBusinessIconInfo = this.a;
    if ((localstBusinessIconInfo != null) && (localstBusinessIconInfo.button != null)) {
      return this.a.button.buttonText;
    }
    return null;
  }
  
  public int k()
  {
    stBusinessIconInfo localstBusinessIconInfo = this.a;
    if (localstBusinessIconInfo == null) {
      return 0;
    }
    return localstBusinessIconInfo.type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.commercial.WSCommercialInfo
 * JD-Core Version:    0.7.0.1
 */