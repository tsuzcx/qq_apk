package com.tencent.biz.qqstory.playmode.util;

public class PlayModeUtils$DebugInfo
{
  public int a;
  public long a;
  public long b;
  public long c;
  public long d;
  public long e;
  public long f;
  public long g;
  
  public String a()
  {
    if (this.a == 0L) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder("cost001").append("  ");
    localStringBuilder.append(this.b - this.a).append("  ");
    localStringBuilder.append(this.c - this.a).append("  ");
    localStringBuilder.append(this.d - this.a).append("  ");
    localStringBuilder.append(this.f - this.a).append("  ");
    localStringBuilder.append(this.g - this.a).append("  ");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.PlayModeUtils.DebugInfo
 * JD-Core Version:    0.7.0.1
 */