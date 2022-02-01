package com.tencent.luggage.wxa.kn;

public class a
{
  private static a.a a;
  
  public static void a(a.a parama)
  {
    a = parama;
  }
  
  public static void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (a != null)
    {
      if (paramVarArgs != null) {
        String.format(paramString2, paramVarArgs);
      }
      a.a(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static void b(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (a != null)
    {
      if (paramVarArgs != null) {
        String.format(paramString2, paramVarArgs);
      }
      a.b(paramString1, paramString2, paramVarArgs);
    }
  }
  
  public static void c(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (a != null)
    {
      if (paramVarArgs != null) {
        String.format(paramString2, paramVarArgs);
      }
      a.c(paramString1, paramString2, paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kn.a
 * JD-Core Version:    0.7.0.1
 */