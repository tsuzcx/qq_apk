package com.tencent.magicbrush.ui;

import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 13})
public final class i$b$a
{
  @Nullable
  public static Object a(i.b paramb)
  {
    paramb = paramb.getThisView();
    if (paramb != null)
    {
      if ((paramb instanceof TextureView)) {
        return ((TextureView)paramb).getSurfaceTexture();
      }
      if ((paramb instanceof SurfaceView))
      {
        paramb = ((SurfaceView)paramb).getHolder();
        Intrinsics.checkExpressionValueIsNotNull(paramb, "it.holder");
        return paramb.getSurface();
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.ui.i.b.a
 * JD-Core Version:    0.7.0.1
 */