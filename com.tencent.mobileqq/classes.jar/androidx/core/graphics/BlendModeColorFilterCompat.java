package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class BlendModeColorFilterCompat
{
  @Nullable
  public static ColorFilter createBlendModeColorFilterCompat(int paramInt, @NonNull BlendModeCompat paramBlendModeCompat)
  {
    Object localObject1 = null;
    Object localObject2;
    if (Build.VERSION.SDK_INT >= 29)
    {
      localObject2 = BlendModeUtils.obtainBlendModeFromCompat(paramBlendModeCompat);
      paramBlendModeCompat = localObject1;
      if (localObject2 != null) {
        paramBlendModeCompat = new BlendModeColorFilter(paramInt, (BlendMode)localObject2);
      }
    }
    do
    {
      return paramBlendModeCompat;
      localObject2 = BlendModeUtils.obtainPorterDuffFromCompat(paramBlendModeCompat);
      paramBlendModeCompat = localObject1;
    } while (localObject2 == null);
    return new PorterDuffColorFilter(paramInt, (PorterDuff.Mode)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.graphics.BlendModeColorFilterCompat
 * JD-Core Version:    0.7.0.1
 */