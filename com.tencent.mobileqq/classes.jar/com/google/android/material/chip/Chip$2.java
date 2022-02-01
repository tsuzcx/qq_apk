package com.google.android.material.chip;

import android.annotation.TargetApi;
import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.NonNull;

class Chip$2
  extends ViewOutlineProvider
{
  Chip$2(Chip paramChip) {}
  
  @TargetApi(21)
  public void getOutline(View paramView, @NonNull Outline paramOutline)
  {
    if (Chip.a(this.a) != null)
    {
      Chip.a(this.a).getOutline(paramOutline);
      return;
    }
    paramOutline.setAlpha(0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.chip.Chip.2
 * JD-Core Version:    0.7.0.1
 */