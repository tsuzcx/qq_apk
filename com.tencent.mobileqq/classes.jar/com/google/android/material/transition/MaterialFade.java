package com.google.android.material.transition;

public final class MaterialFade
  extends MaterialVisibility<FadeProvider>
{
  public MaterialFade()
  {
    super(a(), a());
  }
  
  private static FadeProvider a()
  {
    FadeProvider localFadeProvider = new FadeProvider();
    localFadeProvider.a(0.3F);
    return localFadeProvider;
  }
  
  private static VisibilityAnimatorProvider a()
  {
    ScaleProvider localScaleProvider = new ScaleProvider();
    localScaleProvider.a(false);
    localScaleProvider.a(0.8F);
    return localScaleProvider;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.transition.MaterialFade
 * JD-Core Version:    0.7.0.1
 */