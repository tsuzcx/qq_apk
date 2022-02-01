package com.google.android.material.transition;

class FadeModeEvaluators
{
  private static final FadeModeEvaluator a = new FadeModeEvaluators.1();
  private static final FadeModeEvaluator b = new FadeModeEvaluators.2();
  private static final FadeModeEvaluator c = new FadeModeEvaluators.3();
  private static final FadeModeEvaluator d = new FadeModeEvaluators.4();
  
  static FadeModeEvaluator a(int paramInt, boolean paramBoolean)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt == 3) {
            return d;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Invalid fade mode: ");
          localStringBuilder.append(paramInt);
          throw new IllegalArgumentException(localStringBuilder.toString());
        }
        return c;
      }
      if (paramBoolean) {
        return b;
      }
      return a;
    }
    if (paramBoolean) {
      return a;
    }
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.transition.FadeModeEvaluators
 * JD-Core Version:    0.7.0.1
 */