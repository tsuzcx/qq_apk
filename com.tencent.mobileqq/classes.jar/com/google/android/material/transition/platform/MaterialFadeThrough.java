package com.google.android.material.transition.platform;

import androidx.annotation.RequiresApi;

@RequiresApi(21)
public final class MaterialFadeThrough
  extends MaterialVisibility<FadeThroughProvider>
{
  public MaterialFadeThrough()
  {
    super(a(), a());
  }
  
  private static FadeThroughProvider a()
  {
    return new FadeThroughProvider();
  }
  
  private static VisibilityAnimatorProvider a()
  {
    ScaleProvider localScaleProvider = new ScaleProvider();
    localScaleProvider.a(false);
    localScaleProvider.a(0.92F);
    return localScaleProvider;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.transition.platform.MaterialFadeThrough
 * JD-Core Version:    0.7.0.1
 */