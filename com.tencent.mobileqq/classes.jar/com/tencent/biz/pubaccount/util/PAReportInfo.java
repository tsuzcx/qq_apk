package com.tencent.biz.pubaccount.util;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.statistics.Reporting;

public class PAReportInfo
  extends Entity
  implements Cloneable
{
  public String actionName;
  public int count;
  public int fromType;
  public String mainAction;
  public String msgIds;
  public String r2;
  public String r3;
  public String r4;
  public int result;
  public String subAction;
  public String tag;
  public String toUin;
  
  public PAReportInfo() {}
  
  public PAReportInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, int paramInt3, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    this.actionName = paramString5;
    this.count = paramInt2;
    this.fromType = paramInt1;
    this.mainAction = paramString2;
    this.r2 = paramString6;
    this.r3 = paramString7;
    this.r4 = paramString8;
    this.msgIds = paramString9;
    this.result = paramInt3;
    this.subAction = paramString4;
    this.tag = paramString1;
    this.toUin = paramString3;
  }
  
  public Reporting clone()
  {
    try
    {
      Reporting localReporting = (Reporting)super.clone();
      return localReporting;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PAReportInfo
 * JD-Core Version:    0.7.0.1
 */