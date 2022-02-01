package com.google.protobuf;

final class Android
{
  private static final Class<?> a = a("libcore.io.Memory");
  private static final boolean b;
  
  static
  {
    boolean bool;
    if (a("org.robolectric.Robolectric") != null) {
      bool = true;
    } else {
      bool = false;
    }
    b = bool;
  }
  
  private static <T> Class<T> a(String paramString)
  {
    try
    {
      paramString = Class.forName(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      label7:
      break label7;
    }
    return null;
  }
  
  static boolean a()
  {
    return (a != null) && (!b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.Android
 * JD-Core Version:    0.7.0.1
 */