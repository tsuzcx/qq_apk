package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import java.io.File;

final class HardwareConfigState
{
  private static final File a = new File("/proc/self/fd");
  private static volatile HardwareConfigState d;
  private volatile int b;
  private volatile boolean c = true;
  
  static HardwareConfigState a()
  {
    if (d == null) {
      try
      {
        if (d == null) {
          d = new HardwareConfigState();
        }
      }
      finally {}
    }
    return d;
  }
  
  private boolean b()
  {
    try
    {
      int i = this.b + 1;
      this.b = i;
      if (i >= 50)
      {
        bool = false;
        this.b = 0;
        i = a.list().length;
        if (i < 700) {
          bool = true;
        }
        this.c = bool;
        if ((!this.c) && (Log.isLoggable("Downsampler", 5)))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors ");
          localStringBuilder.append(i);
          localStringBuilder.append(", limit ");
          localStringBuilder.append(700);
          Log.w("Downsampler", localStringBuilder.toString());
        }
      }
      boolean bool = this.c;
      return bool;
    }
    finally {}
  }
  
  @TargetApi(26)
  boolean a(int paramInt1, int paramInt2, BitmapFactory.Options paramOptions, DecodeFormat paramDecodeFormat, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (Build.VERSION.SDK_INT >= 26) && (paramDecodeFormat != DecodeFormat.PREFER_ARGB_8888_DISALLOW_HARDWARE))
    {
      if (paramBoolean2) {
        return false;
      }
      if ((paramInt1 >= 128) && (paramInt2 >= 128) && (b())) {
        paramBoolean1 = true;
      } else {
        paramBoolean1 = false;
      }
      if (paramBoolean1)
      {
        paramOptions.inPreferredConfig = Bitmap.Config.HARDWARE;
        paramOptions.inMutable = false;
      }
      return paramBoolean1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.bitmap.HardwareConfigState
 * JD-Core Version:    0.7.0.1
 */