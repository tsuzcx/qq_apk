package com.tencent.biz.pubaccount.weishi_new.commercial;

import UserGrowth.stBusinessIconInfo;
import UserGrowth.stIconButton;
import UserGrowth.stSchema;

public class WSCommercialInfo
  extends AbsWSRichWidgetData
{
  private final stBusinessIconInfo a;
  
  public WSCommercialInfo(stBusinessIconInfo paramstBusinessIconInfo)
  {
    super(3);
    this.a = paramstBusinessIconInfo;
  }
  
  public stSchema a()
  {
    if (this.a == null) {
      return null;
    }
    return this.a.schema;
  }
  
  public String a()
  {
    if ((this.a == null) || (this.a.button == null)) {
      return null;
    }
    return this.a.button.buttonIcon;
  }
  
  public int b()
  {
    if (this.a == null) {
      return 0;
    }
    return this.a.type;
  }
  
  public String b()
  {
    if ((this.a == null) || (this.a.button == null)) {
      return null;
    }
    return this.a.button.buttonText;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.commercial.WSCommercialInfo
 * JD-Core Version:    0.7.0.1
 */