package com.google.android.exoplayer2.upstream;

import java.io.IOException;

public abstract interface Loader$Callback<T extends Loader.Loadable>
{
  public abstract void onLoadCanceled(T paramT, long paramLong1, long paramLong2, boolean paramBoolean);
  
  public abstract void onLoadCompleted(T paramT, long paramLong1, long paramLong2);
  
  public abstract int onLoadError(T paramT, long paramLong1, long paramLong2, IOException paramIOException);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.upstream.Loader.Callback
 * JD-Core Version:    0.7.0.1
 */