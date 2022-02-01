package com.tencent.biz.pubaccount.weishi_new.net;

import cooperation.qzone.QUA;
import cooperation.qzone.util.QZLog;

public class WeishiHeaderConst
{
  public static int a = 0;
  public static String a = "1522415138827987";
  public static int b;
  public static String b;
  public static String c;
  
  static
  {
    int j = a();
    int i;
    if (j == -1) {
      i = 760;
    } else {
      i = j;
    }
    a = i;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("appversion:");
    localStringBuilder.append(j);
    QZLog.d("WeishiHeaderConst", 4, localStringBuilder.toString());
    a = 760;
    jdField_b_of_type_JavaLangString = "";
    c = "";
    jdField_b_of_type_Int = 0;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.net.WeishiHeaderConst
 * JD-Core Version:    0.7.0.1
 */