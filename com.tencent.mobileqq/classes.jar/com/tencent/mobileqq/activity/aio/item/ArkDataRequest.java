package com.tencent.mobileqq.activity.aio.item;

import android.text.TextUtils;

abstract class ArkDataRequest
{
  protected int a;
  protected int b;
  protected String c;
  protected String d;
  protected ArkDataRequest.IDataRequestCallback e;
  
  public int a()
  {
    return this.b;
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(ArkDataRequest.IDataRequestCallback paramIDataRequestCallback)
  {
    this.e = paramIDataRequestCallback;
  }
  
  public boolean a(String paramString)
  {
    c();
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    this.c = paramString;
    this.b = -1;
    return true;
  }
  
  public String b()
  {
    return this.d;
  }
  
  public abstract boolean b(String paramString);
  
  public abstract void c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkDataRequest
 * JD-Core Version:    0.7.0.1
 */