package com.tencent.beacon.core.e;

public class j
{
  public static String a(String paramString)
  {
    return paramString.trim().replace(" ", "").replace("\t", "").replace("&", "").replace(":", "").replace("=", "").replace(";", "");
  }
  
  public static void a(String[] paramArrayOfString)
  {
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      if (paramArrayOfString[i] == null) {
        paramArrayOfString[i] = "";
      }
      i += 1;
    }
  }
  
  public static boolean b(String paramString)
  {
    return (paramString == null) || (paramString.equals(""));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.e.j
 * JD-Core Version:    0.7.0.1
 */