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
    int i = this.jdField_a_of_type_Int;
    if ((i == 3) || (i == 4)) {
      try
      {
        i = Integer.parseInt(this.e);
        return i;
      }
      catch (Throwable localThrowable)
      {
        QLog.i("WTogether", 1, "init WTVideoInfo", localThrowable);
      }
    }
    return 0;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("_");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("_");
    localStringBuilder.append(this.d);
    localStringBuilder.append("_");
    localStringBuilder.append(this.e);
    localStringBuilder.append("_");
    localStringBuilder.append(this.f);
    localStringBuilder.append("_");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append("_");
    localStringBuilder.append(this.g);
    localStringBuilder.append("_");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    return localStringBuilder.toString();
  }
  
  public boolean a()
  {
    int i = this.jdField_a_of_type_Int;
    return (i == 2) || (i == 4);
  }
  
  public boolean a(WTVideoInfo paramWTVideoInfo)
  {
    boolean bool1;
    if (this == paramWTVideoInfo) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2 = bool1;
    if (!bool1)
    {
      bool2 = bool1;
      if (paramWTVideoInfo != null)
      {
        if ((this.jdField_a_of_type_Int == paramWTVideoInfo.jdField_a_of_type_Int) && (this.jdField_a_of_type_Long != paramWTVideoInfo.jdField_a_of_type_Long) && (TextUtils.equals(this.jdField_b_of_type_JavaLangString, paramWTVideoInfo.jdField_b_of_type_JavaLangString)) && (TextUtils.equals(this.d, paramWTVideoInfo.d)) && (TextUtils.equals(this.e, paramWTVideoInfo.e)) && (TextUtils.equals(this.f, paramWTVideoInfo.f)) && (this.jdField_b_of_type_Int == paramWTVideoInfo.jdField_b_of_type_Int) && (TextUtils.equals(this.g, paramWTVideoInfo.g))) {
          return true;
        }
        bool2 = false;
      }
    }
    return bool2;
  }
  
  public boolean b()
  {
    int i = this.jdField_a_of_type_Int;
    return (i == 4) || (i == 3);
  }
  
  public boolean c()
  {
    int i = this.jdField_a_of_type_Int;
    boolean bool2 = false;
    boolean bool1;
    if ((i != 0) && (i != 1) && (i != 2))
    {
      if (i != 3)
      {
        if (i != 4) {
          return false;
        }
        bool1 = bool2;
        if (!TextUtils.isEmpty(this.d))
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(this.e))
          {
            bool1 = bool2;
            if (!TextUtils.isEmpty(this.f))
            {
              bool1 = bool2;
              if (TextUtils.isEmpty(this.g)) {}
            }
          }
        }
      }
      else
      {
        for (;;)
        {
          return true;
          bool1 = bool2;
          if (TextUtils.isEmpty(this.d)) {
            break;
          }
          bool1 = bool2;
          if (TextUtils.isEmpty(this.e)) {
            break;
          }
          bool1 = bool2;
          if (TextUtils.isEmpty(this.f)) {
            break;
          }
        }
      }
    }
    else {
      bool1 = TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString) ^ true;
    }
    return bool1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoInfo{videoSrcType: ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", title: ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", url: ");
    Object localObject = this.jdField_b_of_type_JavaLangString;
    if (localObject == null) {
      localObject = "null";
    } else {
      localObject = Integer.valueOf(((String)localObject).length());
    }
    localStringBuilder.append(localObject);
    localStringBuilder.append(", cookie: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", vid: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", strPlatForm: ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", strSDTForm: ");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", isPay: ");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", strLivePid: ");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", mediaFormat: ");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.data.WTVideoInfo
 * JD-Core Version:    0.7.0.1
 */