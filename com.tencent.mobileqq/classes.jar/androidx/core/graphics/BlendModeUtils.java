package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.PorterDuff.Mode;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

class BlendModeUtils
{
  @Nullable
  @RequiresApi(29)
  static BlendMode obtainBlendModeFromCompat(@NonNull BlendModeCompat paramBlendModeCompat)
  {
    switch (BlendModeUtils.1.$SwitchMap$androidx$core$graphics$BlendModeCompat[paramBlendModeCompat.ordinal()])
    {
    default: 
      return null;
    case 1: 
      return BlendMode.CLEAR;
    case 2: 
      return BlendMode.SRC;
    case 3: 
      return BlendMode.DST;
    case 4: 
      return BlendMode.SRC_OVER;
    case 5: 
      return BlendMode.DST_OVER;
    case 6: 
      return BlendMode.SRC_IN;
    case 7: 
      return BlendMode.DST_IN;
    case 8: 
      return BlendMode.SRC_OUT;
    case 9: 
      return BlendMode.DST_OUT;
    case 10: 
      return BlendMode.SRC_ATOP;
    case 11: 
      return BlendMode.DST_ATOP;
    case 12: 
      return BlendMode.XOR;
    case 13: 
      return BlendMode.PLUS;
    case 14: 
      return BlendMode.MODULATE;
    case 15: 
      return BlendMode.SCREEN;
    case 16: 
      return BlendMode.OVERLAY;
    case 17: 
      return BlendMode.DARKEN;
    case 18: 
      return BlendMode.LIGHTEN;
    case 19: 
      return BlendMode.COLOR_DODGE;
    case 20: 
      return BlendMode.COLOR_BURN;
    case 21: 
      return BlendMode.HARD_LIGHT;
    case 22: 
      return BlendMode.SOFT_LIGHT;
    case 23: 
      return BlendMode.DIFFERENCE;
    case 24: 
      return BlendMode.EXCLUSION;
    case 25: 
      return BlendMode.MULTIPLY;
    case 26: 
      return BlendMode.HUE;
    case 27: 
      return BlendMode.SATURATION;
    case 28: 
      return BlendMode.COLOR;
    }
    return BlendMode.LUMINOSITY;
  }
  
  @Nullable
  static PorterDuff.Mode obtainPorterDuffFromCompat(@Nullable BlendModeCompat paramBlendModeCompat)
  {
    if (paramBlendModeCompat != null) {}
    switch (BlendModeUtils.1.$SwitchMap$androidx$core$graphics$BlendModeCompat[paramBlendModeCompat.ordinal()])
    {
    default: 
      return null;
    case 1: 
      return PorterDuff.Mode.CLEAR;
    case 2: 
      return PorterDuff.Mode.SRC;
    case 3: 
      return PorterDuff.Mode.DST;
    case 4: 
      return PorterDuff.Mode.SRC_OVER;
    case 5: 
      return PorterDuff.Mode.DST_OVER;
    case 6: 
      return PorterDuff.Mode.SRC_IN;
    case 7: 
      return PorterDuff.Mode.DST_IN;
    case 8: 
      return PorterDuff.Mode.SRC_OUT;
    case 9: 
      return PorterDuff.Mode.DST_OUT;
    case 10: 
      return PorterDuff.Mode.SRC_ATOP;
    case 11: 
      return PorterDuff.Mode.DST_ATOP;
    case 12: 
      return PorterDuff.Mode.XOR;
    case 13: 
      return PorterDuff.Mode.ADD;
    case 14: 
      return PorterDuff.Mode.MULTIPLY;
    case 15: 
      return PorterDuff.Mode.SCREEN;
    case 16: 
      return PorterDuff.Mode.OVERLAY;
    case 17: 
      return PorterDuff.Mode.DARKEN;
    }
    return PorterDuff.Mode.LIGHTEN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.graphics.BlendModeUtils
 * JD-Core Version:    0.7.0.1
 */