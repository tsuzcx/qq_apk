package com.qq.ac.sdk.api;

import android.content.Context;
import com.b.a.j;
import com.qq.ac.sdk.d.a;

public class AcInterface
{
  public static void init(Context paramContext)
  {
    j.a(paramContext);
  }
  
  public static void initMTA() {}
  
  public static void setAppID(String paramString)
  {
    j.c(paramString);
  }
  
  public static void setAppKey(String paramString)
  {
    j.a(paramString);
  }
  
  public static void setImei(String paramString)
  {
    j.b(paramString);
  }
  
  public static void setUid(String paramString, AcType.UidType paramUidType, AcType.Gender paramGender)
  {
    j.a(paramString, paramUidType.getString(), paramGender.getString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.qq.ac.sdk.api.AcInterface
 * JD-Core Version:    0.7.0.1
 */