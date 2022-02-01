package com.tencent.luggage.wxa.dc;

public enum u
{
  public static final String[] a = { "/cgi-bin/micromsg-bin/rcptinfoquery", "/cgi-bin/mmoc-bin/hardware/getwerunuserstate" };
  
  public static boolean a(String paramString)
  {
    String[] arrayOfString = a;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfString[i].equals(paramString)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dc.u
 * JD-Core Version:    0.7.0.1
 */