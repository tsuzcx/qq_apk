package com.tencent.biz.pubaccount.util.monitor;

import java.util.Arrays;

class DropFrameData
{
  public String a;
  public long b;
  public long c;
  public long d;
  public long[] e;
  public long f;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DropFrameData{scene='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", frameCount=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", dropTimes=");
    localStringBuilder.append(Arrays.toString(this.e));
    localStringBuilder.append(", scrollDurationMs=");
    localStringBuilder.append(this.f);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.monitor.DropFrameData
 * JD-Core Version:    0.7.0.1
 */