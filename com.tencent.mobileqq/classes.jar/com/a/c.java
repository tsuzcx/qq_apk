package com.a;

import java.io.InputStream;

public final class c
  extends i
{
  private InputStream a;
  private boolean b;
  private long c = -1L;
  
  public final long a()
  {
    return this.c;
  }
  
  public final void a(long paramLong)
  {
    this.c = paramLong;
  }
  
  public final void a(InputStream paramInputStream)
  {
    this.a = paramInputStream;
    this.b = false;
  }
  
  public final InputStream b()
  {
    if (this.a == null) {
      throw new IllegalStateException("Content has not been provided");
    }
    if (this.b) {
      throw new IllegalStateException("Content has been consumed");
    }
    this.b = true;
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.a.c
 * JD-Core Version:    0.7.0.1
 */