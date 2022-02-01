package com.tencent.livesdk.livesdkplayer.renderview;

import android.annotation.SuppressLint;
import android.content.Context;

public class TPViewFactory
{
  @SuppressLint({"ObsoleteSdkInt"})
  public static ITPViewBase createPlayView(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean1) {
      return new TPTextureView(paramContext);
    }
    return new TPSurfaceView(paramContext, paramBoolean2, paramBoolean3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.livesdkplayer.renderview.TPViewFactory
 * JD-Core Version:    0.7.0.1
 */