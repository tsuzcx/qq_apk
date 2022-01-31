package com.tencent.biz.pubaccount.readinjoy.engine;

import java.io.Serializable;
import java.util.ArrayList;

public class SPEventReportSwitch$SPEventReportCondition
  implements Serializable
{
  private boolean needReportNextTime;
  private ArrayList timeSeq;
  
  public String toString()
  {
    return "SPEventReportCondition{needReportNextTime=" + this.needReportNextTime + ", timeSeq=" + this.timeSeq + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.SPEventReportSwitch.SPEventReportCondition
 * JD-Core Version:    0.7.0.1
 */