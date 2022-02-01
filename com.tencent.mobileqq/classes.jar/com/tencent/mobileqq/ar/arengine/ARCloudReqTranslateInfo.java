package com.tencent.mobileqq.ar.arengine;

import android.text.TextUtils;

public class ARCloudReqTranslateInfo
{
  public String a;
  public String b;
  public String c;
  
  public String a()
  {
    if (TextUtils.isEmpty(this.b)) {
      return "";
    }
    return this.b;
  }
  
  public String b()
  {
    if (TextUtils.isEmpty(this.c)) {
      return "";
    }
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudReqTranslateInfo
 * JD-Core Version:    0.7.0.1
 */