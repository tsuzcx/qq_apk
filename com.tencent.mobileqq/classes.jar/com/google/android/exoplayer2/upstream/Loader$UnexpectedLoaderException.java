package com.google.android.exoplayer2.upstream;

import java.io.IOException;

public final class Loader$UnexpectedLoaderException
  extends IOException
{
  public Loader$UnexpectedLoaderException(Throwable paramThrowable)
  {
    super("Unexpected " + paramThrowable.getClass().getSimpleName() + ": " + paramThrowable.getMessage(), paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.upstream.Loader.UnexpectedLoaderException
 * JD-Core Version:    0.7.0.1
 */