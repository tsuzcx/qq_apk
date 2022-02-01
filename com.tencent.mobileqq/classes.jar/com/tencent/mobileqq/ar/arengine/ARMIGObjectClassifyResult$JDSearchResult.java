package com.tencent.mobileqq.ar.arengine;

import android.graphics.RectF;

public class ARMIGObjectClassifyResult$JDSearchResult
{
  public int a;
  public String b;
  public int c;
  public String d;
  public String e;
  ARMIGObjectClassifyResult.JDSearchItem[] f;
  public String g;
  public RectF h = new RectF();
  public int i = -1;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ssoErrCode:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",ssoErrMsg:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",errCode:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",errMsg:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",sessionId:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(",moreUrl:");
    localStringBuilder.append(this.g);
    int j = 0;
    for (;;)
    {
      ARMIGObjectClassifyResult.JDSearchItem[] arrayOfJDSearchItem = this.f;
      if ((arrayOfJDSearchItem == null) || (j >= arrayOfJDSearchItem.length)) {
        break;
      }
      localStringBuilder.append("\n{index=");
      localStringBuilder.append(j);
      localStringBuilder.append(":");
      localStringBuilder.append(this.f[j].toString());
      localStringBuilder.append("}\n");
      j += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARMIGObjectClassifyResult.JDSearchResult
 * JD-Core Version:    0.7.0.1
 */