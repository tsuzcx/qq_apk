package com.google.android.material.transition;

public final class MaterialFadeThrough
  extends MaterialVisibility<FadeThroughProvider>
{
  public MaterialFadeThrough()
  {
    super(a(), b());
  }
  
  private static FadeThroughProvider a()
  {
    return new FadeThroughProvider();
  }
  
  private static VisibilityAnimatorProvider b()
  {
    ScaleProvider localScaleProvider = new ScaleProvider();
    localScaleProvider.a(false);
    localScaleProvider.a(0.92F);
    return localScaleProvider;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.transition.MaterialFadeThrough
 * JD-Core Version:    0.7.0.1
 */