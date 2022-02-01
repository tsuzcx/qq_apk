package com.google.android.material.transition.platform;

import androidx.annotation.RequiresApi;

@RequiresApi(21)
public final class MaterialFade
  extends MaterialVisibility<FadeProvider>
{
  public MaterialFade()
  {
    super(a(), b());
  }
  
  private static FadeProvider a()
  {
    FadeProvider localFadeProvider = new FadeProvider();
    localFadeProvider.a(0.3F);
    return localFadeProvider;
  }
  
  private static VisibilityAnimatorProvider b()
  {
    ScaleProvider localScaleProvider = new ScaleProvider();
    localScaleProvider.a(false);
    localScaleProvider.a(0.8F);
    return localScaleProvider;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.transition.platform.MaterialFade
 * JD-Core Version:    0.7.0.1
 */