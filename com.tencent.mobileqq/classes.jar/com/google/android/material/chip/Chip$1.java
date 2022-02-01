package com.google.android.material.chip;

import android.graphics.Typeface;
import androidx.annotation.NonNull;
import com.google.android.material.resources.TextAppearanceFontCallback;

class Chip$1
  extends TextAppearanceFontCallback
{
  Chip$1(Chip paramChip) {}
  
  public void a(int paramInt) {}
  
  public void a(@NonNull Typeface paramTypeface, boolean paramBoolean)
  {
    Chip localChip = this.a;
    if (Chip.a(localChip).e()) {
      paramTypeface = Chip.a(this.a).a();
    } else {
      paramTypeface = this.a.getText();
    }
    localChip.setText(paramTypeface);
    this.a.requestLayout();
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.chip.Chip.1
 * JD-Core Version:    0.7.0.1
 */