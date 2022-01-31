package com.squareup.okhttp.internal.framed;

import java.io.Closeable;

public abstract interface FrameReader
  extends Closeable
{
  public abstract boolean nextFrame(FrameReader.Handler paramHandler);
  
  public abstract void readConnectionPreface();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.internal.framed.FrameReader
 * JD-Core Version:    0.7.0.1
 */