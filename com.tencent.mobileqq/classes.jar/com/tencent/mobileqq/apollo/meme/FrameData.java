package com.tencent.mobileqq.apollo.meme;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import com.tencent.qphone.base.util.QLog;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/meme/FrameData;", "", "index", "", "pixels", "", "dataWidth", "dataHeight", "frameTime", "(I[BIII)V", "bitmap", "Landroid/graphics/Bitmap;", "getDataHeight", "()I", "getDataWidth", "getFrameTime", "getIndex", "getPixels", "()[B", "targetHeight", "getTargetHeight", "setTargetHeight", "(I)V", "targetWidth", "getTargetWidth", "setTargetWidth", "component1", "component2", "component3", "component4", "component5", "copy", "decodeBitmap", "equals", "", "other", "getBitmap", "hashCode", "recycle", "", "scaleBitmap", "toString", "", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class FrameData
{
  public static final FrameData.Companion a = new FrameData.Companion(null);
  private Bitmap b;
  private int c;
  private int d;
  private final int e;
  @NotNull
  private final byte[] f;
  private final int g;
  private final int h;
  private final int i;
  
  public FrameData(int paramInt1, @NotNull byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4)
  {
    this.e = paramInt1;
    this.f = paramArrayOfByte;
    this.g = paramInt2;
    this.h = paramInt3;
    this.i = paramInt4;
  }
  
  private final Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int j = paramBitmap.getWidth();
    int k = paramBitmap.getHeight();
    float f1 = paramInt1 * 1.0F / j;
    float f2 = paramInt2 * 1.0F / k;
    Object localObject = new Matrix();
    ((Matrix)localObject).postScale(f1, f2);
    localObject = Bitmap.createBitmap(paramBitmap, 0, 0, j, k, (Matrix)localObject, true);
    if (((Intrinsics.areEqual(paramBitmap, localObject) ^ true)) && (!paramBitmap.isRecycled())) {
      paramBitmap.recycle();
    }
    Intrinsics.checkExpressionValueIsNotNull(localObject, "res");
    return localObject;
  }
  
  @Nullable
  public final Bitmap a()
  {
    if (this.b == null) {
      try
      {
        Bitmap localBitmap2 = Bitmap.createBitmap(this.g, this.h, Bitmap.Config.ARGB_8888);
        if (localBitmap2 == null) {
          Intrinsics.throwNpe();
        }
        localBitmap2.copyPixelsFromBuffer((Buffer)ByteBuffer.wrap(this.f));
        Bitmap localBitmap1 = localBitmap2;
        if (this.c > 0)
        {
          localBitmap1 = localBitmap2;
          if (this.d > 0) {
            if (this.g == this.c)
            {
              localBitmap1 = localBitmap2;
              if (this.h == this.d) {}
            }
            else
            {
              localBitmap1 = a(localBitmap2, this.c, this.d);
            }
          }
        }
        this.b = localBitmap1;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("FrameData", 1, "decodeBitmap error.", localThrowable);
      }
    }
    return this.b;
  }
  
  public final void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  @Nullable
  public final Bitmap b()
  {
    return this.b;
  }
  
  public final void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public final void c()
  {
    Bitmap localBitmap = this.b;
    if (localBitmap != null) {
      localBitmap.recycle();
    }
  }
  
  public final int d()
  {
    return this.e;
  }
  
  @NotNull
  public final byte[] e()
  {
    return this.f;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof FrameData))
      {
        paramObject = (FrameData)paramObject;
        if ((this.e == paramObject.e) && (Intrinsics.areEqual(this.f, paramObject.f)) && (this.g == paramObject.g) && (this.h == paramObject.h) && (this.i == paramObject.i)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final int f()
  {
    return this.g;
  }
  
  public final int g()
  {
    return this.h;
  }
  
  public final int h()
  {
    return this.i;
  }
  
  public int hashCode()
  {
    int k = this.e;
    byte[] arrayOfByte = this.f;
    int j;
    if (arrayOfByte != null) {
      j = Arrays.hashCode(arrayOfByte);
    } else {
      j = 0;
    }
    return (((k * 31 + j) * 31 + this.g) * 31 + this.h) * 31 + this.i;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FrameData(index=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", pixels=");
    localStringBuilder.append(Arrays.toString(this.f));
    localStringBuilder.append(", dataWidth=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", dataHeight=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", frameTime=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.meme.FrameData
 * JD-Core Version:    0.7.0.1
 */