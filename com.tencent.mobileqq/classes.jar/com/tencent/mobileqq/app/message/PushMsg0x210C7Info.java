package com.tencent.mobileqq.app.message;

import android.support.annotation.NonNull;
import java.util.HashSet;

public class PushMsg0x210C7Info
{
  public static final HashSet<PushMsg0x210C7Info> g = new HashSet();
  public long a;
  public long b;
  public long c;
  public int d;
  public int e;
  public boolean f;
  
  public PushMsg0x210C7Info(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.a = paramLong1;
    this.b = paramLong2;
    this.c = paramLong3;
    this.d = paramInt1;
    this.e = paramInt2;
    this.f = paramBoolean;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PushMsg0x210_c7Info{");
    localStringBuilder.append("fromUin:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", ");
    localStringBuilder.append("msgSeq:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", ");
    localStringBuilder.append("msgTime:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", ");
    localStringBuilder.append("onlinePush:");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", ");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.PushMsg0x210C7Info
 * JD-Core Version:    0.7.0.1
 */