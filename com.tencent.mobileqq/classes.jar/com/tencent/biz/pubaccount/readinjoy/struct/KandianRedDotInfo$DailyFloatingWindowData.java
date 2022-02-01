package com.tencent.biz.pubaccount.readinjoy.struct;

import java.io.Serializable;

public class KandianRedDotInfo$DailyFloatingWindowData
  implements Serializable
{
  public boolean remove = false;
  public String rowkey = "";
  public String topicID = "";
  public int type = 0;
  public String url = "";
  
  public void clear()
  {
    this.type = 0;
    this.url = "";
    this.topicID = "";
    this.rowkey = "";
    this.remove = false;
  }
  
  public String toString()
  {
    return "DailyFloatingWindowData{type=" + this.type + ", url='" + this.url + '\'' + ", topicID='" + this.topicID + '\'' + ", rowkey='" + this.rowkey + '\'' + ", remove=" + this.remove + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo.DailyFloatingWindowData
 * JD-Core Version:    0.7.0.1
 */