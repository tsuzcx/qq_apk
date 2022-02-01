package com.tencent.mobileqq.activity.springfestival.entry.model;

import com.tencent.mobileqq.utils.TimeFormatterUtils;
import java.io.Serializable;

public class TimeInfo
  implements Serializable
{
  public long begin;
  public long end;
  
  public TimeInfo(long paramLong1, long paramLong2)
  {
    this.begin = paramLong1;
    this.end = paramLong2;
  }
  
  public static TimeInfo newEmpty()
  {
    return new TimeInfo(0L, 0L);
  }
  
  public void copyFrom(TimeInfo paramTimeInfo)
  {
    this.begin = paramTimeInfo.begin;
    this.end = paramTimeInfo.end;
  }
  
  public String toString()
  {
    return "TimeInfo{begin=" + TimeFormatterUtils.b(this.begin) + ", end=" + TimeFormatterUtils.b(this.end) + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.model.TimeInfo
 * JD-Core Version:    0.7.0.1
 */