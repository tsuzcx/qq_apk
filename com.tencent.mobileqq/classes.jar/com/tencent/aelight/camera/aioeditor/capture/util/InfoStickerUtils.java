package com.tencent.aelight.camera.aioeditor.capture.util;

import android.text.TextUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class InfoStickerUtils
{
  public static String a()
  {
    long l = System.currentTimeMillis();
    return new SimpleDateFormat("MM/dd").format(new Date(l));
  }
  
  public static String a(long paramLong)
  {
    if (paramLong == -1L) {
      paramLong = System.currentTimeMillis();
    }
    return new SimpleDateFormat("yyyy MMMM dd", Locale.US).format(new Date(paramLong)).toUpperCase();
  }
  
  public static String a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject1 = null;
    if (bool)
    {
      SLog.e("InfoStickerUtils", "location is null while spliting location!");
      return null;
    }
    Object localObject2 = paramString.split("·");
    if (localObject2.length == 1)
    {
      localObject2 = localObject2[0];
      localObject1 = localObject2;
      if (((String)localObject2).endsWith(HardCodeUtil.a(2064187697))) {
        localObject1 = paramString.substring(0, paramString.length() - 1);
      }
    }
    else if (localObject2.length > 1)
    {
      localObject1 = localObject2[0];
    }
    SLog.b("InfoStickerUtils", "location name is %s.", localObject1);
    return localObject1;
  }
  
  public static String b(long paramLong)
  {
    if (paramLong == -1L) {
      paramLong = System.currentTimeMillis();
    }
    return new SimpleDateFormat("HH:mm").format(new Date(paramLong));
  }
  
  public static String c(long paramLong)
  {
    if (paramLong == -1L) {
      paramLong = System.currentTimeMillis();
    }
    return new SimpleDateFormat("dd").format(new Date(paramLong));
  }
  
  public static String d(long paramLong)
  {
    if (paramLong == -1L) {
      paramLong = System.currentTimeMillis();
    }
    return new SimpleDateFormat("MMM", Locale.US).format(new Date(paramLong)).toUpperCase();
  }
  
  public static String e(long paramLong)
  {
    if (paramLong == -1L) {
      paramLong = System.currentTimeMillis();
    }
    return new SimpleDateFormat("yyyy").format(new Date(paramLong));
  }
  
  public static String f(long paramLong)
  {
    if (paramLong == -1L) {
      paramLong = System.currentTimeMillis();
    }
    return new SimpleDateFormat("MMM dd HH:mm", Locale.US).format(new Date(paramLong)).toUpperCase();
  }
  
  public static String g(long paramLong)
  {
    if (paramLong == -1L) {
      paramLong = System.currentTimeMillis();
    }
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yy MM dd", Locale.US);
    Date localDate = new Date(paramLong);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("'");
    localStringBuilder.append(localSimpleDateFormat.format(localDate).toUpperCase());
    return localStringBuilder.toString();
  }
  
  public static String h(long paramLong)
  {
    if (paramLong == -1L) {
      paramLong = System.currentTimeMillis();
    }
    return new SimpleDateFormat("HHmm").format(new Date(paramLong));
  }
  
  public static String i(long paramLong)
  {
    if (paramLong == -1L) {
      paramLong = System.currentTimeMillis();
    }
    return new SimpleDateFormat("HHmm").format(new Date(paramLong - 60000L));
  }
  
  public static String[] j(long paramLong)
  {
    if (paramLong == -1L) {
      paramLong = System.currentTimeMillis();
    }
    Object localObject2 = Calendar.getInstance();
    ((Calendar)localObject2).setTime(new Date(paramLong));
    Object localObject1 = new LunarSolarConverter.Solar();
    ((LunarSolarConverter.Solar)localObject1).c = ((Calendar)localObject2).get(1);
    ((LunarSolarConverter.Solar)localObject1).b = (((Calendar)localObject2).get(2) + 1);
    ((LunarSolarConverter.Solar)localObject1).a = ((Calendar)localObject2).get(5);
    localObject2 = LunarSolarConverter.a((LunarSolarConverter.Solar)localObject1);
    String[] arrayOfString = new String[4];
    arrayOfString[0] = LunarSolarConverter.a(((LunarSolarConverter.Solar)localObject1).c);
    if (((LunarSolarConverter.Lunar)localObject2).a)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2064187682));
      ((StringBuilder)localObject1).append(LunarSolarConverter.b(((LunarSolarConverter.Lunar)localObject2).c));
      arrayOfString[1] = ((StringBuilder)localObject1).toString();
    }
    else
    {
      arrayOfString[1] = LunarSolarConverter.b(((LunarSolarConverter.Lunar)localObject2).c);
    }
    arrayOfString[2] = String.valueOf(LunarSolarConverter.c(((LunarSolarConverter.Lunar)localObject2).b).charAt(0));
    arrayOfString[3] = String.valueOf(LunarSolarConverter.c(((LunarSolarConverter.Lunar)localObject2).b).charAt(1));
    if (QLog.isColorLevel()) {
      QLog.d("InfoStickerUtils", 2, TextUtils.join("  ", arrayOfString));
    }
    return arrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.util.InfoStickerUtils
 * JD-Core Version:    0.7.0.1
 */