package com.tencent.biz.pubaccount.util.monitor;

import java.util.Arrays;

class DropFrameData
{
  public long a;
  public String a;
  public long[] a;
  public long b;
  public long c;
  public long d;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DropFrameData{scene='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", frameCount=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", dropTimes=");
    localStringBuilder.append(Arrays.toString(this.jdField_a_of_type_ArrayOfLong));
    localStringBuilder.append(", scrollDurationMs=");
    localStringBuilder.append(this.d);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.monitor.DropFrameData
 * JD-Core Version:    0.7.0.1
 */