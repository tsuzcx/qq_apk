package com.tencent.lbssearch.object.param;

import android.text.TextUtils;

public class Geo2AddressParam$PoiOptions
{
  public static final String ADDRESS_FORMAT_DEFAULT = "";
  public static final String ADDRESS_FORMAT_SHORT = "short";
  public static final int POLICY_DEFAULT = 1;
  public static final int POLICY_O2O = 2;
  public static final int POLICY_SHARE = 5;
  public static final int POLICY_SOCIAL = 4;
  public static final int POLICY_TRIP = 3;
  private String a;
  private int b;
  private int c;
  private int d;
  private int e;
  private String[] f;
  
  public PoiOptions setAddressFormat(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public PoiOptions setCategorys(String... paramVarArgs)
  {
    this.f = paramVarArgs;
    return this;
  }
  
  public PoiOptions setPageIndex(int paramInt)
  {
    this.d = paramInt;
    return this;
  }
  
  public PoiOptions setPageSize(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
  
  public PoiOptions setPolicy(int paramInt)
  {
    this.e = paramInt;
    return this;
  }
  
  public PoiOptions setRadius(int paramInt)
  {
    this.b = paramInt;
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    if (!TextUtils.isEmpty(this.a)) {
      localStringBuilder1.append(";address_format=").append(this.a);
    }
    if ((this.b > 0) && (this.b <= 5000)) {
      localStringBuilder1.append(";radius=").append(this.b);
    }
    if ((this.d > 0) && (this.d <= 20) && (this.c > 0) && (this.c <= 20))
    {
      localStringBuilder1.append(";page_index=").append(this.d);
      localStringBuilder1.append(";page_size=").append(this.c);
    }
    if (this.e > 0) {
      localStringBuilder1.append(";policy=").append(this.e);
    }
    if ((this.f != null) && (this.f.length > 0))
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      String[] arrayOfString = this.f;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder2.append(arrayOfString[i]).append(",");
        i += 1;
      }
      i = localStringBuilder2.lastIndexOf(",");
      localStringBuilder2.delete(i, i + 1);
      localStringBuilder1.append(";category=").append(localStringBuilder2.toString());
    }
    if (localStringBuilder1.indexOf(";") == 0) {
      localStringBuilder1.delete(0, 1);
    }
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.lbssearch.object.param.Geo2AddressParam.PoiOptions
 * JD-Core Version:    0.7.0.1
 */