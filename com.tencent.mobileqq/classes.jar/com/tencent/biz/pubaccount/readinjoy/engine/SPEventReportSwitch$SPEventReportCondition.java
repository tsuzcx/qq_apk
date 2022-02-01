package com.tencent.biz.pubaccount.readinjoy.engine;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeSet;

public class SPEventReportSwitch$SPEventReportCondition
  implements Serializable
{
  private boolean needReportNextTime;
  private ArrayList<TreeSet<Integer>> timeSeq;
  
  public String toString()
  {
    return "SPEventReportCondition{needReportNextTime=" + this.needReportNextTime + ", timeSeq=" + this.timeSeq + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.SPEventReportSwitch.SPEventReportCondition
 * JD-Core Version:    0.7.0.1
 */