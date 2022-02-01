package com.android.dx.util;

import java.io.PrintWriter;
import java.io.Writer;

public final class Writers
{
  public static PrintWriter printWriterFor(Writer paramWriter)
  {
    if ((paramWriter instanceof PrintWriter)) {
      return (PrintWriter)paramWriter;
    }
    return new PrintWriter(paramWriter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.util.Writers
 * JD-Core Version:    0.7.0.1
 */