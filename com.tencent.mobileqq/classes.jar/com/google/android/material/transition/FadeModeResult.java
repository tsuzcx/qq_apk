package com.google.android.material.transition;

class FadeModeResult
{
  final int jdField_a_of_type_Int;
  final boolean jdField_a_of_type_Boolean;
  final int b;
  
  private FadeModeResult(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_Boolean = paramBoolean;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.transition.FadeModeResult
 * JD-Core Version:    0.7.0.1
 */