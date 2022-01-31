package com.google.android.filament;

import androidx.annotation.NonNull;

public class TextureSampler
{
  int mSampler = 0;
  
  public TextureSampler()
  {
    this(TextureSampler.MinFilter.LINEAR_MIPMAP_LINEAR, TextureSampler.MagFilter.LINEAR, TextureSampler.WrapMode.REPEAT);
  }
  
  public TextureSampler(@NonNull TextureSampler.CompareMode paramCompareMode)
  {
    this(paramCompareMode, TextureSampler.CompareFunction.LESS_EQUAL);
  }
  
  public TextureSampler(@NonNull TextureSampler.CompareMode paramCompareMode, @NonNull TextureSampler.CompareFunction paramCompareFunction)
  {
    this.mSampler = nCreateCompareSampler(paramCompareMode.ordinal(), paramCompareFunction.ordinal());
  }
  
  public TextureSampler(@NonNull TextureSampler.MagFilter paramMagFilter)
  {
    this(paramMagFilter, TextureSampler.WrapMode.CLAMP_TO_EDGE);
  }
  
  public TextureSampler(@NonNull TextureSampler.MagFilter paramMagFilter, @NonNull TextureSampler.WrapMode paramWrapMode)
  {
    this(minFilterFromMagFilter(paramMagFilter), paramMagFilter, paramWrapMode);
  }
  
  public TextureSampler(@NonNull TextureSampler.MinFilter paramMinFilter, @NonNull TextureSampler.MagFilter paramMagFilter, @NonNull TextureSampler.WrapMode paramWrapMode)
  {
    this(paramMinFilter, paramMagFilter, paramWrapMode, paramWrapMode, paramWrapMode);
  }
  
  public TextureSampler(@NonNull TextureSampler.MinFilter paramMinFilter, @NonNull TextureSampler.MagFilter paramMagFilter, @NonNull TextureSampler.WrapMode paramWrapMode1, @NonNull TextureSampler.WrapMode paramWrapMode2, @NonNull TextureSampler.WrapMode paramWrapMode3)
  {
    this.mSampler = nCreateSampler(paramMinFilter.ordinal(), paramMagFilter.ordinal(), paramWrapMode1.ordinal(), paramWrapMode2.ordinal(), paramWrapMode3.ordinal());
  }
  
  private static TextureSampler.MinFilter minFilterFromMagFilter(@NonNull TextureSampler.MagFilter paramMagFilter)
  {
    switch (TextureSampler.1.$SwitchMap$com$google$android$filament$TextureSampler$MagFilter[paramMagFilter.ordinal()])
    {
    default: 
      return TextureSampler.MinFilter.LINEAR;
    }
    return TextureSampler.MinFilter.NEAREST;
  }
  
  private static native int nCreateCompareSampler(int paramInt1, int paramInt2);
  
  private static native int nCreateSampler(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  private static native float nGetAnisotropy(int paramInt);
  
  private static native int nGetCompareFunction(int paramInt);
  
  private static native int nGetCompareMode(int paramInt);
  
  private static native int nGetMagFilter(int paramInt);
  
  private static native int nGetMinFilter(int paramInt);
  
  private static native int nGetWrapModeR(int paramInt);
  
  private static native int nGetWrapModeS(int paramInt);
  
  private static native int nGetWrapModeT(int paramInt);
  
  private static native int nSetAnisotropy(int paramInt, float paramFloat);
  
  private static native int nSetCompareFunction(int paramInt1, int paramInt2);
  
  private static native int nSetCompareMode(int paramInt1, int paramInt2);
  
  private static native int nSetMagFilter(int paramInt1, int paramInt2);
  
  private static native int nSetMinFilter(int paramInt1, int paramInt2);
  
  private static native int nSetWrapModeR(int paramInt1, int paramInt2);
  
  private static native int nSetWrapModeS(int paramInt1, int paramInt2);
  
  private static native int nSetWrapModeT(int paramInt1, int paramInt2);
  
  public float getAnisotropy()
  {
    return nGetAnisotropy(this.mSampler);
  }
  
  public TextureSampler.CompareFunction getCompareFunction()
  {
    return TextureSampler.CompareFunction.values()[nGetCompareFunction(this.mSampler)];
  }
  
  public TextureSampler.CompareMode getCompareMode()
  {
    return TextureSampler.CompareMode.values()[nGetCompareMode(this.mSampler)];
  }
  
  public TextureSampler.MagFilter getMagFilter()
  {
    return TextureSampler.MagFilter.values()[nGetMagFilter(this.mSampler)];
  }
  
  public TextureSampler.MinFilter getMinFilter()
  {
    return TextureSampler.MinFilter.values()[nGetMinFilter(this.mSampler)];
  }
  
  public TextureSampler.WrapMode getWrapModeR()
  {
    return TextureSampler.WrapMode.values()[nGetWrapModeR(this.mSampler)];
  }
  
  public TextureSampler.WrapMode getWrapModeS()
  {
    return TextureSampler.WrapMode.values()[nGetWrapModeS(this.mSampler)];
  }
  
  public TextureSampler.WrapMode getWrapModeT()
  {
    return TextureSampler.WrapMode.values()[nGetWrapModeT(this.mSampler)];
  }
  
  public void setAnisotropy(float paramFloat)
  {
    this.mSampler = nSetAnisotropy(this.mSampler, paramFloat);
  }
  
  public void setCompareFunction(TextureSampler.CompareFunction paramCompareFunction)
  {
    this.mSampler = nSetCompareFunction(this.mSampler, paramCompareFunction.ordinal());
  }
  
  public void setCompareMode(TextureSampler.CompareMode paramCompareMode)
  {
    this.mSampler = nSetCompareMode(this.mSampler, paramCompareMode.ordinal());
  }
  
  public void setMagFilter(TextureSampler.MagFilter paramMagFilter)
  {
    this.mSampler = nSetMagFilter(this.mSampler, paramMagFilter.ordinal());
  }
  
  public void setMinFilter(TextureSampler.MinFilter paramMinFilter)
  {
    this.mSampler = nSetMinFilter(this.mSampler, paramMinFilter.ordinal());
  }
  
  public void setWrapModeR(TextureSampler.WrapMode paramWrapMode)
  {
    this.mSampler = nSetWrapModeR(this.mSampler, paramWrapMode.ordinal());
  }
  
  public void setWrapModeS(TextureSampler.WrapMode paramWrapMode)
  {
    this.mSampler = nSetWrapModeS(this.mSampler, paramWrapMode.ordinal());
  }
  
  public void setWrapModeT(TextureSampler.WrapMode paramWrapMode)
  {
    this.mSampler = nSetWrapModeT(this.mSampler, paramWrapMode.ordinal());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.filament.TextureSampler
 * JD-Core Version:    0.7.0.1
 */