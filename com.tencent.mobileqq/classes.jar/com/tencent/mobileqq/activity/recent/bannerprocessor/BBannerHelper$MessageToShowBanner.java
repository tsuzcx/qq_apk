package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.support.annotation.NonNull;

public final class BBannerHelper$MessageToShowBanner
{
  public final int a;
  @NonNull
  public final String b;
  public final int c;
  @NonNull
  public final String d;
  @NonNull
  public final BBannerHelper.IBannerInteract e;
  
  public BBannerHelper$MessageToShowBanner(int paramInt1, @NonNull String paramString1, int paramInt2, @NonNull String paramString2, @NonNull BBannerHelper.IBannerInteract paramIBannerInteract)
  {
    this.a = paramInt1;
    this.b = paramString1;
    this.c = paramInt2;
    this.d = paramString2;
    this.e = paramIBannerInteract;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (MessageToShowBanner)paramObject;
      if (this.a != paramObject.a) {
        return false;
      }
      if (this.c != paramObject.c) {
        return false;
      }
      if (!this.b.equals(paramObject.b)) {
        return false;
      }
      return this.d.equals(paramObject.d);
    }
    return false;
  }
  
  public int hashCode()
  {
    return ((this.a * 31 + this.b.hashCode()) * 31 + this.c) * 31 + this.d.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MessageToShowBanner{bannerLev=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", businessCategory='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", iconIdx=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", wording='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", callback=");
    localStringBuilder.append(this.e);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.BBannerHelper.MessageToShowBanner
 * JD-Core Version:    0.7.0.1
 */