package com.tencent.featuretoggle.hltxkg.common.c.b.a;

import android.text.TextUtils;

public abstract class a
{
  private a.a a;
  
  public a(String paramString)
  {
    String str;
    if (com.tencent.featuretoggle.hltxkg.common.a.b()) {
      str = "_test_";
    } else {
      str = "_";
    }
    StringBuilder localStringBuilder = new StringBuilder("halley_schedule_");
    localStringBuilder.append(com.tencent.featuretoggle.hltxkg.common.a.c());
    localStringBuilder.append(str);
    localStringBuilder.append(com.tencent.featuretoggle.hltxkg.common.a.h());
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    localStringBuilder.append(".db");
    paramString = localStringBuilder.toString();
    this.a = new a.a(this, com.tencent.featuretoggle.hltxkg.common.a.a(), paramString, null, 1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.common.c.b.a.a
 * JD-Core Version:    0.7.0.1
 */