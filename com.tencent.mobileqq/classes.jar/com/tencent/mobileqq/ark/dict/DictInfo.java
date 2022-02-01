package com.tencent.mobileqq.ark.dict;

import android.text.TextUtils;

public class DictInfo
{
  public int a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  
  public boolean a()
  {
    return (this.a >= 0) && (!TextUtils.isEmpty(this.b)) && (!TextUtils.isEmpty(this.c)) && (!TextUtils.isEmpty(this.d)) && (!TextUtils.isEmpty(this.e));
  }
  
  public boolean b()
  {
    return (!TextUtils.isEmpty(this.f)) && (!TextUtils.isEmpty(this.g)) && (!TextUtils.isEmpty(this.h));
  }
  
  public void c()
  {
    this.f = null;
    this.g = null;
    this.h = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.dict.DictInfo
 * JD-Core Version:    0.7.0.1
 */