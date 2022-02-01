package com.tencent.biz.pubaccount.weishi_new.net;

import cooperation.qzone.QUA;
import cooperation.qzone.util.QZLog;

public class WeishiHeaderConst
{
  public static String a = "1522415138827987";
  public static int b = 760;
  public static String c = "";
  public static String d = "";
  public static int e = 0;
  
  static
  {
    int j = a();
    int i;
    if (j == -1) {
      i = 760;
    } else {
      i = j;
    }
    b = i;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("appversion:");
    localStringBuilder.append(j);
    QZLog.d("WeishiHeaderConst", 4, localStringBuilder.toString());
  }
  
  static int a()
  {
    String str = QUA.getQUA3();
    int i = str.indexOf(".");
    int j = str.lastIndexOf(".");
    if (j > i)
    {
      if (j - i != 2) {
        return -1;
      }
      if (i <= 1) {
        return -1;
      }
    }
    try
    {
      i = Integer.parseInt(str.substring(i - 1, j + 2).replace(".", ""));
      return i;
    }
    catch (Throwable localThrowable) {}
    return -1;
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.net.WeishiHeaderConst
 * JD-Core Version:    0.7.0.1
 */