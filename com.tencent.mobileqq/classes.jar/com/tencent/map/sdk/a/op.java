package com.tencent.map.sdk.a;

import android.content.Context;

public final class op
{
  static final String[] a = { "txmapengine", "txnavengine" };
  
  public static void a(Context paramContext, String paramString)
  {
    try
    {
      System.loadLibrary(paramString);
      StringBuilder localStringBuilder = new StringBuilder("loadLibary:");
      localStringBuilder.append(paramString);
      localStringBuilder.append("  successful");
      or.a(localStringBuilder.toString());
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      label35:
      boolean bool;
      break label35;
    }
    bool = oq.a(paramContext, paramString);
    paramContext = new StringBuilder("loadLibary:");
    paramContext.append(paramString);
    paramContext.append(" result:");
    paramContext.append(bool);
    or.a(paramContext.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.op
 * JD-Core Version:    0.7.0.1
 */