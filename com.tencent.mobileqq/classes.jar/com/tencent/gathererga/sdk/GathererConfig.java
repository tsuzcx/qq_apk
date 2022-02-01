package com.tencent.gathererga.sdk;

import android.content.Context;
import com.tencent.gathererga.core.internal.GathererConfigInternal;

public class GathererConfig
  extends GathererConfigInternal
{
  private GathererConfig(GathererConfig.Builder paramBuilder)
  {
    this.a = GathererConfig.Builder.a(paramBuilder);
    this.b = GathererConfig.Builder.b(paramBuilder);
    this.c = GathererConfig.Builder.c(paramBuilder);
    this.d = GathererConfig.Builder.d(paramBuilder);
    this.e = GathererConfig.Builder.e(paramBuilder);
    this.k = GathererConfig.Builder.f(paramBuilder);
    this.f = GathererConfig.Builder.g(paramBuilder);
    this.g = GathererConfig.Builder.h(paramBuilder);
    this.h = GathererConfig.Builder.i(paramBuilder);
    this.i = GathererConfig.Builder.j(paramBuilder);
    this.j = GathererConfig.Builder.k(paramBuilder);
  }
  
  public static GathererConfig.Builder a(Context paramContext, int paramInt)
  {
    return new GathererConfig.Builder(paramContext, paramInt, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gathererga.sdk.GathererConfig
 * JD-Core Version:    0.7.0.1
 */