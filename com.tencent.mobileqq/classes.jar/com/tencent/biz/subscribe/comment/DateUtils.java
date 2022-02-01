package com.tencent.biz.subscribe.comment;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.util.QZLog;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtils
{
  private static final String jdField_a_of_type_JavaLangString = "DateUtils";
  private static StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder(32);
  public static final SimpleDateFormat a;
  public static final SimpleDateFormat b;
  public static final SimpleDateFormat c;
  public static final SimpleDateFormat d;
  
  static
  {
    jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    b = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    c = new SimpleDateFormat("yyyyMMddHHmm");
    d = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
  }
  
  public static String a(long paramLong)
  {
    long l1 = System.currentTimeMillis();
    String str2;
    try
    {
      localObject1 = BaseApplicationImpl.getContext().getString(2131720485);
      String str1 = BaseApplicationImpl.getContext().getString(2131720486);
      str2 = BaseApplicationImpl.getContext().getString(2131720484);
    }
    catch (Exception localException)
    {
      localObject1 = HardCodeUtil.a(2131703013);
      QZLog.d(jdField_a_of_type_JavaLangString, 1, localException, new Object[0]);
      str2 = "%d小时前";
      localObject2 = "%d分钟前";
    }
    long l2 = (l1 - paramLong) / 1000L;
    if (l2 < 60L) {
      return localObject1;
    }
    if (l2 < 3600L) {
      return String.format((String)localObject2, new Object[] { Long.valueOf(l2 / 60L) });
    }
    if (l2 < 86400L) {
      return String.format(str2, new Object[] { Long.valueOf(l2 / 60L / 60L) });
    }
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).setTimeInMillis(paramLong);
    int m = ((Calendar)localObject1).get(5);
    int n = ((Calendar)localObject1).get(11);
    int i1 = ((Calendar)localObject1).get(12);
    int k = ((Calendar)localObject1).get(1);
    int i2 = ((Calendar)localObject1).get(2) + 1;
    int i4 = ((Calendar)localObject1).get(6);
    localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).setTimeInMillis(l1);
    int i3 = ((Calendar)localObject1).get(1);
    int i5 = ((Calendar)localObject1).get(6);
    int i;
    if (i3 != k)
    {
      int j = k;
      i = 0;
      while (j < i3)
      {
        if (((j % 4 == 0) && (j % 100 != 0)) || (j % 400 == 0)) {
          i += 366;
        } else {
          i += 365;
        }
        j += 1;
      }
      i += i5 - i4;
    }
    else
    {
      i = i5 - i4;
    }
    localObject1 = jdField_a_of_type_JavaLangStringBuilder;
    ((StringBuilder)localObject1).delete(0, ((StringBuilder)localObject1).length());
    if (i == 1)
    {
      localObject2 = jdField_a_of_type_JavaLangStringBuilder;
      ((StringBuilder)localObject2).append("昨天");
      if (n < 10)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("0");
        ((StringBuilder)localObject1).append(n);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject1 = Integer.valueOf(n);
      }
      ((StringBuilder)localObject2).append(localObject1);
      ((StringBuilder)localObject2).append(":");
      if (i1 < 10)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("0");
        ((StringBuilder)localObject1).append(i1);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject1 = Integer.valueOf(i1);
      }
      ((StringBuilder)localObject2).append(localObject1);
      return ((StringBuilder)localObject2).toString();
    }
    if (i == 2)
    {
      localObject2 = jdField_a_of_type_JavaLangStringBuilder;
      ((StringBuilder)localObject2).append("前天");
      if (n < 10)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("0");
        ((StringBuilder)localObject1).append(n);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject1 = Integer.valueOf(n);
      }
      ((StringBuilder)localObject2).append(localObject1);
      ((StringBuilder)localObject2).append(":");
      if (i1 < 10)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("0");
        ((StringBuilder)localObject1).append(i1);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject1 = Integer.valueOf(i1);
      }
      ((StringBuilder)localObject2).append(localObject1);
      return ((StringBuilder)localObject2).toString();
    }
    if (i3 != k)
    {
      localObject2 = jdField_a_of_type_JavaLangStringBuilder;
      ((StringBuilder)localObject2).append(k);
      ((StringBuilder)localObject2).append("-");
      if (i2 < 10)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("0");
        ((StringBuilder)localObject1).append(i2);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject1 = Integer.valueOf(i2);
      }
      ((StringBuilder)localObject2).append(localObject1);
      ((StringBuilder)localObject2).append("-");
      if (m < 10)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("0");
        ((StringBuilder)localObject1).append(m);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject1 = Integer.valueOf(m);
      }
      ((StringBuilder)localObject2).append(localObject1);
      return ((StringBuilder)localObject2).toString();
    }
    Object localObject2 = jdField_a_of_type_JavaLangStringBuilder;
    if (i2 < 10)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("0");
      ((StringBuilder)localObject1).append(i2);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = Integer.valueOf(i2);
    }
    ((StringBuilder)localObject2).append(localObject1);
    ((StringBuilder)localObject2).append("-");
    if (m < 10)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("0");
      ((StringBuilder)localObject1).append(m);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = Integer.valueOf(m);
    }
    ((StringBuilder)localObject2).append(localObject1);
    return ((StringBuilder)localObject2).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.DateUtils
 * JD-Core Version:    0.7.0.1
 */