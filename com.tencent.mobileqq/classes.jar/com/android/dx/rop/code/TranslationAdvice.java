package com.android.dx.rop.code;

public abstract interface TranslationAdvice
{
  public abstract int getMaxOptimalRegisterCount();
  
  public abstract boolean hasConstantOperation(Rop paramRop, RegisterSpec paramRegisterSpec1, RegisterSpec paramRegisterSpec2);
  
  public abstract boolean requiresSourcesInOrder(Rop paramRop, RegisterSpecList paramRegisterSpecList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.code.TranslationAdvice
 * JD-Core Version:    0.7.0.1
 */