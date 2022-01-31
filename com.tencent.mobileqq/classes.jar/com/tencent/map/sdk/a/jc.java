package com.tencent.map.sdk.a;

import android.content.Context;

public class jc
{
  private static int a = 0;
  
  public static int a()
  {
    try
    {
      int i = a;
      return i;
    }
    finally {}
  }
  
  public static void a(Context paramContext)
  {
    try
    {
      a = gf.a(paramContext).b("handDrawMapVer");
      return;
    }
    finally {}
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    try
    {
      a = paramInt;
      gf.a(paramContext).a("handDrawMapVer", paramInt);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.jc
 * JD-Core Version:    0.7.0.1
 */