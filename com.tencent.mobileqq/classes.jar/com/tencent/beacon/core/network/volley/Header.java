package com.tencent.beacon.core.network.volley;

import android.text.TextUtils;

public final class Header
{
  private final String mName;
  private final String mValue;
  
  public Header(String paramString1, String paramString2)
  {
    this.mName = paramString1;
    this.mValue = paramString2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (Header.class != paramObject.getClass())) {
        return false;
      }
      paramObject = (Header)paramObject;
    } while ((TextUtils.equals(this.mName, paramObject.mName)) && (TextUtils.equals(this.mValue, paramObject.mValue)));
    return false;
  }
  
  public final String getName()
  {
    return this.mName;
  }
  
  public final String getValue()
  {
    return this.mValue;
  }
  
  public int hashCode()
  {
    return this.mName.hashCode() * 31 + this.mValue.hashCode();
  }
  
  public String toString()
  {
    return "Header[name=" + this.mName + ",value=" + this.mValue + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.network.volley.Header
 * JD-Core Version:    0.7.0.1
 */