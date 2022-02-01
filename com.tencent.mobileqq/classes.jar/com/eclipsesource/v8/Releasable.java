package com.eclipsesource.v8;

import java.io.Closeable;

public abstract interface Releasable
  extends Closeable
{
  public abstract void close();
  
  public abstract void release();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.eclipsesource.v8.Releasable
 * JD-Core Version:    0.7.0.1
 */