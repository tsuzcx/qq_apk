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
    case 29: 
      return BlendMode.LUMINOSITY;
    case 28: 
      return BlendMode.COLOR;
    case 27: 
      return BlendMode.SATURATION;
    case 26: 
      return BlendMode.HUE;
    case 25: 
      return BlendMode.MULTIPLY;
    case 24: 
      return BlendMode.EXCLUSION;
    case 23: 
      return BlendMode.DIFFERENCE;
    case 22: 
      return BlendMode.SOFT_LIGHT;
    case 21: 
      return BlendMode.HARD_LIGHT;
    case 20: 
      return BlendMode.COLOR_BURN;
    case 19: 
      return BlendMode.COLOR_DODGE;
    case 18: 
      return BlendMode.LIGHTEN;
    case 17: 
      return BlendMode.DARKEN;
    case 16: 
      return BlendMode.OVERLAY;
    case 15: 
      return BlendMode.SCREEN;
    case 14: 
      return BlendMode.MODULATE;
    case 13: 
      return BlendMode.PLUS;
    case 12: 
      return BlendMode.XOR;
    case 11: 
      return BlendMode.DST_ATOP;
    case 10: 
      return BlendMode.SRC_ATOP;
    case 9: 
      return BlendMode.DST_OUT;
    case 8: 
      return BlendMode.SRC_OUT;
    case 7: 
      return BlendMode.DST_IN;
    case 6: 
      return BlendMode.SRC_IN;
    case 5: 
      return BlendMode.DST_OVER;
    case 4: 
      return BlendMode.SRC_OVER;
    case 3: 
      return BlendMode.DST;
    case 2: 
      return BlendMode.SRC;
    }
    return BlendMode.CLEAR;
  }
  
  @Nullable
  static PorterDuff.Mode obtainPorterDuffFromCompat(@Nullable BlendModeCompat paramBlendModeCompat)
  {
    if (paramBlendModeCompat != null)
    {
      switch (BlendModeUtils.1.$SwitchMap$androidx$core$graphics$BlendModeCompat[paramBlendModeCompat.ordinal()])
      {
      default: 
        return null;
      case 18: 
        return PorterDuff.Mode.LIGHTEN;
      case 17: 
        return PorterDuff.Mode.DARKEN;
      case 16: 
        return PorterDuff.Mode.OVERLAY;
      case 15: 
        return PorterDuff.Mode.SCREEN;
      case 14: 
        return PorterDuff.Mode.MULTIPLY;
      case 13: 
        return PorterDuff.Mode.ADD;
      case 12: 
        return PorterDuff.Mode.XOR;
      case 11: 
        return PorterDuff.Mode.DST_ATOP;
      case 10: 
        return PorterDuff.Mode.SRC_ATOP;
      case 9: 
        return PorterDuff.Mode.DST_OUT;
      case 8: 
        return PorterDuff.Mode.SRC_OUT;
      case 7: 
        return PorterDuff.Mode.DST_IN;
      case 6: 
        return PorterDuff.Mode.SRC_IN;
      case 5: 
        return PorterDuff.Mode.DST_OVER;
      case 4: 
        return PorterDuff.Mode.SRC_OVER;
      case 3: 
        return PorterDuff.Mode.DST;
      case 2: 
        return PorterDuff.Mode.SRC;
      }
      return PorterDuff.Mode.CLEAR;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.graphics.BlendModeUtils
 * JD-Core Version:    0.7.0.1
 */