package com.google.android.filament.android;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import com.google.android.filament.Engine;
import com.google.android.filament.Texture;

public final class TextureHelper
{
  private static final int BITMAP_CONFIG_ALPHA_8 = 0;
  private static final int BITMAP_CONFIG_HARDWARE = 5;
  private static final int BITMAP_CONFIG_RGBA_4444 = 2;
  private static final int BITMAP_CONFIG_RGBA_8888 = 3;
  private static final int BITMAP_CONFIG_RGBA_F16 = 4;
  private static final int BITMAP_CONFIG_RGB_565 = 1;
  
  private static native void nSetBitmap(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, Bitmap paramBitmap, int paramInt6);
  
  public static void setBitmap(@NonNull Engine paramEngine, @NonNull Texture paramTexture, @IntRange(from=0L) int paramInt1, @IntRange(from=0L) int paramInt2, @IntRange(from=0L) int paramInt3, @IntRange(from=0L) int paramInt4, @IntRange(from=0L) int paramInt5, @NonNull Bitmap paramBitmap)
  {
    int i = toNativeFormat(paramBitmap.getConfig());
    if ((i == 2) || (i == 5)) {
      throw new IllegalArgumentException("Unsupported config: ARGB_4444 or HARDWARE");
    }
    nSetBitmap(paramTexture.getNativeObject(), paramEngine.getNativeObject(), paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramBitmap, i);
  }
  
  public static void setBitmap(@NonNull Engine paramEngine, @NonNull Texture paramTexture, @IntRange(from=0L) int paramInt, @NonNull Bitmap paramBitmap)
  {
    setBitmap(paramEngine, paramTexture, paramInt, 0, 0, paramTexture.getWidth(paramInt), paramTexture.getHeight(paramInt), paramBitmap);
  }
  
  private static int toNativeFormat(Bitmap.Config paramConfig)
  {
    switch (TextureHelper.1.$SwitchMap$android$graphics$Bitmap$Config[paramConfig.ordinal()])
    {
    case 4: 
    default: 
      return 3;
    case 1: 
      return 0;
    case 2: 
      return 1;
    case 3: 
      return 2;
    case 5: 
      return 4;
    }
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.filament.android.TextureHelper
 * JD-Core Version:    0.7.0.1
 */