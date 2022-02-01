package com.tencent.common.danmaku.data;

public final class BaseDanmaku$TimePassedData
  implements Comparable<TimePassedData>
{
  public long a;
  public final BaseDanmaku.ITimePassedListener b;
  
  public int a(TimePassedData paramTimePassedData)
  {
    if (paramTimePassedData == null) {
      return 1;
    }
    long l1 = this.a;
    long l2 = paramTimePassedData.a;
    if (l1 > l2) {
      return -1;
    }
    if (l1 < l2) {
      return 1;
    }
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mRemainTime:");
    localStringBuilder.append(this.a);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.data.BaseDanmaku.TimePassedData
 * JD-Core Version:    0.7.0.1
 */