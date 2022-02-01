package com.android.dx.rop.code;

public final class ConservativeTranslationAdvice
  implements TranslationAdvice
{
  public static final ConservativeTranslationAdvice THE_ONE = new ConservativeTranslationAdvice();
  
  public int getMaxOptimalRegisterCount()
  {
    return 2147483647;
  }
  
  public boolean hasConstantOperation(Rop paramRop, RegisterSpec paramRegisterSpec1, RegisterSpec paramRegisterSpec2)
  {
    return false;
  }
  
  public boolean requiresSourcesInOrder(Rop paramRop, RegisterSpecList paramRegisterSpecList)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.rop.code.ConservativeTranslationAdvice
 * JD-Core Version:    0.7.0.1
 */