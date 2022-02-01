package com.tencent.intervideo.nowproxy;

public class AppidConfig
{
  public static String APPID_KUAIBAO = "1028";
  public static String APPID_QB = "1023";
  public static String APPID_QB_FAST = "1031";
  public static String APPID_QQ = "2";
  
  public static boolean isBrowserPlugin(String paramString)
  {
    return (APPID_QB.equals(paramString)) || (APPID_QB_FAST.equals(paramString));
  }
  
  public static boolean isKuaiBaoPlugin(String paramString)
  {
    return APPID_KUAIBAO.equals(paramString);
  }
  
  public static boolean isQQPlugin(String paramString)
  {
    return APPID_QQ.equals(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.AppidConfig
 * JD-Core Version:    0.7.0.1
 */