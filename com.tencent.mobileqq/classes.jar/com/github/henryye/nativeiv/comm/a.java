package com.github.henryye.nativeiv.comm;

import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import androidx.annotation.Nullable;

class a
{
  private static int a()
  {
    return 4;
  }
  
  static int a(int paramInt)
  {
    if (paramInt == 4) {
      return 5121;
    }
    if (paramInt == 3) {
      return 5121;
    }
    if (paramInt == 2) {
      return 5121;
    }
    return 0;
  }
  
  static int a(@Nullable Bitmap.Config paramConfig)
  {
    if (paramConfig != null)
    {
      if (paramConfig == Bitmap.Config.ARGB_8888) {
        return 4;
      }
      if (paramConfig == Bitmap.Config.ARGB_4444) {
        return 4;
      }
      if (paramConfig == Bitmap.Config.RGB_565) {
        return 4;
      }
      if (paramConfig == Bitmap.Config.ALPHA_8) {
        return 2;
      }
      if (Build.VERSION.SDK_INT >= 26) {
        return 4;
      }
      return a();
    }
    return a();
  }
  
  static int b(int paramInt)
  {
    if (paramInt == 4) {
      return 6408;
    }
    if (paramInt == 3) {
      return 6407;
    }
    if (paramInt == 2) {
      return 6406;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.github.henryye.nativeiv.comm.a
 * JD-Core Version:    0.7.0.1
 */