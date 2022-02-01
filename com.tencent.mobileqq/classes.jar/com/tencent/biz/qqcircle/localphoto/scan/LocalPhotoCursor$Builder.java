package com.tencent.biz.qqcircle.localphoto.scan;

import android.content.Context;
import java.util.List;

public class LocalPhotoCursor$Builder
{
  private Context a;
  private int b;
  private int c;
  private long d;
  private long e;
  private int f;
  private List<String> g;
  
  public Builder a(int paramInt)
  {
    this.b = paramInt;
    return this;
  }
  
  public Builder a(long paramLong)
  {
    this.d = paramLong;
    return this;
  }
  
  public Builder a(Context paramContext)
  {
    this.a = paramContext;
    return this;
  }
  
  public Builder a(List<String> paramList)
  {
    this.g = paramList;
    return this;
  }
  
  public LocalPhotoCursor a()
  {
    return new LocalPhotoCursor(this, null);
  }
  
  public Builder b(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
  
  public Builder b(long paramLong)
  {
    this.e = paramLong;
    return this;
  }
  
  public Builder c(int paramInt)
  {
    this.f = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.localphoto.scan.LocalPhotoCursor.Builder
 * JD-Core Version:    0.7.0.1
 */