package com.bumptech.glide.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.ListPreloader.PreloadSizeProvider;
import com.bumptech.glide.request.target.SizeReadyCallback;
import java.util.Arrays;

public class ViewPreloadSizeProvider<T>
  implements ListPreloader.PreloadSizeProvider<T>, SizeReadyCallback
{
  private int[] a;
  private ViewPreloadSizeProvider.SizeViewTarget b;
  
  public void a(int paramInt1, int paramInt2)
  {
    this.a = new int[] { paramInt1, paramInt2 };
    this.b = null;
  }
  
  @Nullable
  public int[] a(@NonNull T paramT, int paramInt1, int paramInt2)
  {
    paramT = this.a;
    if (paramT == null) {
      return null;
    }
    return Arrays.copyOf(paramT, paramT.length);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.util.ViewPreloadSizeProvider
 * JD-Core Version:    0.7.0.1
 */