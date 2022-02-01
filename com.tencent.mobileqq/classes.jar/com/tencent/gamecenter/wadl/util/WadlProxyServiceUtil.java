package com.tencent.gamecenter.wadl.util;

public class WadlProxyServiceUtil
{
  public static String a = "WadlProxyServiceUtil";
  private static WadlProxyServiceWrap b;
  
  public static WadlProxyServiceWrap a()
  {
    if (b == null) {
      synchronized (a)
      {
        if (b == null) {
          b = new WadlProxyServiceWrap();
        }
      }
    }
    return b;
  }
  
  public static void b()
  {
    WadlProxyServiceWrap localWadlProxyServiceWrap = b;
    if (localWadlProxyServiceWrap != null)
    {
      localWadlProxyServiceWrap.c();
      b = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.util.WadlProxyServiceUtil
 * JD-Core Version:    0.7.0.1
 */