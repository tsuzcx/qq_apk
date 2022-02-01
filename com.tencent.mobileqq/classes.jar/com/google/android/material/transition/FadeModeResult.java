package com.google.android.material.transition;

class FadeModeResult
{
  final int a;
  final int b;
  final boolean c;
  
  private FadeModeResult(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramBoolean;
  }
  
  static FadeModeResult a(int paramInt1, int paramInt2)
  {
    return new FadeModeResult(paramInt1, paramInt2, false);
  }
  
  static FadeModeResult b(int paramInt1, int paramInt2)
  {
    return new FadeModeResult(paramInt1, paramInt2, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.transition.FadeModeResult
 * JD-Core Version:    0.7.0.1
 */