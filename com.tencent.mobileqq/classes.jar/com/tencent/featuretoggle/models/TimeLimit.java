package com.tencent.featuretoggle.models;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class TimeLimit
  extends JceStruct
{
  public String endTime = "";
  public String startTime = "";
  
  public TimeLimit() {}
  
  public TimeLimit(String paramString1, String paramString2)
  {
    this.startTime = paramString1;
    this.endTime = paramString2;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (TimeLimit)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.startTime, paramObject.startTime))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.endTime, paramObject.endTime)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public String getEndTime()
  {
    return this.endTime;
  }
  
  public String getStartTime()
  {
    return this.startTime;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.startTime = paramJceInputStream.readString(0, false);
    this.endTime = paramJceInputStream.readString(1, false);
  }
  
  public void setEndTime(String paramString)
  {
    this.endTime = paramString;
  }
  
  public void setStartTime(String paramString)
  {
    this.startTime = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.startTime;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.endTime;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.models.TimeLimit
 * JD-Core Version:    0.7.0.1
 */