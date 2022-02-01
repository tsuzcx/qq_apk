package com.tencent.image.api;

public class ReportEventBean
{
  private final String actionName;
  private final int fromType;
  private final String mainAction;
  private final String r2;
  private final String r3;
  private final String r4;
  private final String r5;
  private final int result;
  private final String subAction;
  private final String tag;
  private final String toUin;
  
  public ReportEventBean(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    this.tag = paramString1;
    this.mainAction = paramString2;
    this.toUin = paramString3;
    this.subAction = paramString4;
    this.actionName = paramString5;
    this.fromType = paramInt1;
    this.result = paramInt2;
    this.r2 = paramString6;
    this.r3 = paramString7;
    this.r4 = paramString8;
    this.r5 = paramString9;
  }
  
  public String getActionName()
  {
    return this.actionName;
  }
  
  public int getFromType()
  {
    return this.fromType;
  }
  
  public String getMainAction()
  {
    return this.mainAction;
  }
  
  public String getR2()
  {
    return this.r2;
  }
  
  public String getR3()
  {
    return this.r3;
  }
  
  public String getR4()
  {
    return this.r4;
  }
  
  public String getR5()
  {
    return this.r5;
  }
  
  public int getResult()
  {
    return this.result;
  }
  
  public String getSubAction()
  {
    return this.subAction;
  }
  
  public String getTag()
  {
    return this.tag;
  }
  
  public String getToUin()
  {
    return this.toUin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.api.ReportEventBean
 * JD-Core Version:    0.7.0.1
 */