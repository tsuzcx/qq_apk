package com.getkeepsafe.relinker;

import android.content.Context;

public class ReLinker
{
  public static void a(Context paramContext, String paramString)
  {
    a(paramContext, paramString, null, null);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, ReLinker.LoadListener paramLoadListener)
  {
    new ReLinkerInstance().a(paramContext, paramString1, paramString2, paramLoadListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.getkeepsafe.relinker.ReLinker
 * JD-Core Version:    0.7.0.1
 */