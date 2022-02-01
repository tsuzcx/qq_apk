package com.tencent.magicbrush;

import android.graphics.SurfaceTexture;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/MBExternalSurfaceTexture;", "Landroid/graphics/SurfaceTexture;", "texId", "", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "(ILcom/tencent/magicbrush/MBRuntime;)V", "matrix", "", "getTexId", "()I", "destroy", "", "getMatrix", "getTransformMatrix", "mtx", "Companion", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 13})
public final class c
  extends SurfaceTexture
{
  public static final c.a a = new c.a(null);
  private float[] b;
  private final int c;
  private final MBRuntime d;
  
  public final void a()
  {
    setOnFrameAvailableListener(null);
    MBRuntime localMBRuntime = this.d;
    localMBRuntime.nativeDestroyExternalTexture(localMBRuntime.a, this.c);
  }
  
  public void getTransformMatrix(@NotNull float[] paramArrayOfFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "mtx");
    super.getTransformMatrix(paramArrayOfFloat);
    paramArrayOfFloat = Arrays.copyOf(paramArrayOfFloat, paramArrayOfFloat.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfFloat, "java.util.Arrays.copyOf(this, size)");
    this.b = paramArrayOfFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.c
 * JD-Core Version:    0.7.0.1
 */