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
    StringBuilder localStringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(this.a))
    {
      localStringBuilder.append(";address_format=");
      localStringBuilder.append(this.a);
    }
    int i = this.b;
    if ((i > 0) && (i <= 5000))
    {
      localStringBuilder.append(";radius=");
      localStringBuilder.append(this.b);
    }
    i = this.d;
    if ((i > 0) && (i <= 20))
    {
      i = this.c;
      if ((i > 0) && (i <= 20))
      {
        localStringBuilder.append(";page_index=");
        localStringBuilder.append(this.d);
        localStringBuilder.append(";page_size=");
        localStringBuilder.append(this.c);
      }
    }
    if (this.e > 0)
    {
      localStringBuilder.append(";policy=");
      localStringBuilder.append(this.e);
    }
    Object localObject = this.f;
    if ((localObject != null) && (localObject.length > 0))
    {
      localObject = new StringBuilder();
      String[] arrayOfString = this.f;
      int j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        ((StringBuilder)localObject).append(arrayOfString[i]);
        ((StringBuilder)localObject).append(",");
        i += 1;
      }
      i = ((StringBuilder)localObject).lastIndexOf(",");
      ((StringBuilder)localObject).delete(i, i + 1);
      localStringBuilder.append(";category=");
      localStringBuilder.append(((StringBuilder)localObject).toString());
    }
    if (localStringBuilder.indexOf(";") == 0) {
      localStringBuilder.delete(0, 1);
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.lbssearch.object.param.Geo2AddressParam.PoiOptions
 * JD-Core Version:    0.7.0.1
 */