package com.google.android.material.slider;

import androidx.annotation.NonNull;
import java.util.Locale;

public final class BasicLabelFormatter
  implements LabelFormatter
{
  @NonNull
  public String a(float paramFloat)
  {
    if (paramFloat >= 1.0E+012F) {
      return String.format(Locale.US, "%.1fT", new Object[] { Float.valueOf(paramFloat / 1.0E+012F) });
    }
    if (paramFloat >= 1.0E+009F) {
      return String.format(Locale.US, "%.1fB", new Object[] { Float.valueOf(paramFloat / 1.0E+009F) });
    }
    if (paramFloat >= 1000000.0F) {
      return String.format(Locale.US, "%.1fM", new Object[] { Float.valueOf(paramFloat / 1000000.0F) });
    }
    if (paramFloat >= 1000.0F) {
      return String.format(Locale.US, "%.1fK", new Object[] { Float.valueOf(paramFloat / 1000.0F) });
    }
    return String.format(Locale.US, "%.0f", new Object[] { Float.valueOf(paramFloat) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.slider.BasicLabelFormatter
 * JD-Core Version:    0.7.0.1
 */