package com.tencent.map.sdk.a;

import android.text.TextUtils;

public abstract class cc
{
  private cc.a a;
  
  public cc(String paramString)
  {
    String str;
    if (ac.b()) {
      str = "_test_";
    } else {
      str = "_";
    }
    StringBuilder localStringBuilder = new StringBuilder("halley_schedule_");
    localStringBuilder.append(ac.c());
    localStringBuilder.append(str);
    localStringBuilder.append(ac.g());
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    localStringBuilder.append(".db");
    paramString = localStringBuilder.toString();
    this.a = new cc.a(this, ac.a(), paramString);
  }
  
  public final void a(String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      if ((!TextUtils.isEmpty(paramString)) && (paramArrayOfByte != null)) {
        this.a.a(paramString, paramArrayOfByte);
      }
      return;
    }
    finally {}
  }
  
  public final byte[] a(String paramString)
  {
    try
    {
      paramString = this.a.a(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.cc
 * JD-Core Version:    0.7.0.1
 */