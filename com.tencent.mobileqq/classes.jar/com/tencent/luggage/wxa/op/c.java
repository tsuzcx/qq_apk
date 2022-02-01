package com.tencent.luggage.wxa.op;

import androidx.annotation.NonNull;

public final class c
{
  @NonNull
  public final String a;
  @NonNull
  public final String b;
  @NonNull
  public final String c;
  
  public c(@NonNull String paramString1, @NonNull String paramString2, @NonNull String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AppBrandPipEventBaseInfo{appId='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", pagePath='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", videoUrl='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.op.c
 * JD-Core Version:    0.7.0.1
 */