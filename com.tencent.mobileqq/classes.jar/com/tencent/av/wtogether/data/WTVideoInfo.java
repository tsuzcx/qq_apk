package com.tencent.av.wtogether.data;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class WTVideoInfo
{
  public final int a;
  public final long a;
  public final String a;
  public final int b;
  public final String b;
  public final String c;
  public final String d;
  public final String e;
  public final String f;
  public final String g;
  
  public WTVideoInfo(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt2, String paramString7, long paramLong)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramString5;
    this.f = paramString6;
    this.jdField_b_of_type_Int = paramInt2;
    this.g = paramString7;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public int a()
  {
    int i = 0;
    if ((this.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_Int == 4)) {}
    try
    {
      i = Integer.parseInt(this.e);
      return i;
    }
    catch (Throwable localThrowable)
    {
      QLog.i("WTogether", 1, "init WTVideoInfo", localThrowable);
    }
    return 0;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_Int + "_" + this.jdField_b_of_type_JavaLangString + "_" + this.d + "_" + this.e + "_" + this.f + "_" + this.jdField_b_of_type_Int + "_" + this.g + "_" + this.jdField_a_of_type_Long;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 4);
  }
  
  public boolean a(WTVideoInfo paramWTVideoInfo)
  {
    boolean bool;
    if (this == paramWTVideoInfo) {
      bool = true;
    }
    while ((!bool) && (paramWTVideoInfo != null)) {
      if ((this.jdField_a_of_type_Int == paramWTVideoInfo.jdField_a_of_type_Int) && (this.jdField_a_of_type_Long != paramWTVideoInfo.jdField_a_of_type_Long) && (TextUtils.equals(this.jdField_b_of_type_JavaLangString, paramWTVideoInfo.jdField_b_of_type_JavaLangString)) && (TextUtils.equals(this.d, paramWTVideoInfo.d)) && (TextUtils.equals(this.e, paramWTVideoInfo.e)) && (TextUtils.equals(this.f, paramWTVideoInfo.f)) && (this.jdField_b_of_type_Int == paramWTVideoInfo.jdField_b_of_type_Int) && (TextUtils.equals(this.g, paramWTVideoInfo.g)))
      {
        return true;
        bool = false;
      }
      else
      {
        return false;
      }
    }
    return bool;
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Int == 4) || (this.jdField_a_of_type_Int == 3);
  }
  
  public boolean c()
  {
    boolean bool = true;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      bool = false;
    }
    do
    {
      do
      {
        do
        {
          return bool;
        } while (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString));
        return false;
      } while ((!TextUtils.isEmpty(this.d)) && (!TextUtils.isEmpty(this.e)) && (!TextUtils.isEmpty(this.f)));
      return false;
    } while ((!TextUtils.isEmpty(this.d)) && (!TextUtils.isEmpty(this.e)) && (!TextUtils.isEmpty(this.f)) && (!TextUtils.isEmpty(this.g)));
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("VideoInfo{videoSrcType: ").append(this.jdField_a_of_type_Int).append(", title: ").append(this.jdField_a_of_type_JavaLangString).append(", url: ");
    if (this.jdField_b_of_type_JavaLangString == null) {}
    for (Object localObject = "null";; localObject = Integer.valueOf(this.jdField_b_of_type_JavaLangString.length())) {
      return localObject + ", cookie: " + this.c + ", vid: " + this.d + ", strPlatForm: " + this.e + ", strSDTForm: " + this.f + ", isPay: " + this.jdField_b_of_type_Int + ", strLivePid: " + this.g + ", mediaFormat: " + this.jdField_a_of_type_Long + "}";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.data.WTVideoInfo
 * JD-Core Version:    0.7.0.1
 */