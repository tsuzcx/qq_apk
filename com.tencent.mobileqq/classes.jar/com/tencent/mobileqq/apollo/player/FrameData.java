package com.tencent.mobileqq.apollo.player;

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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/player/FrameData;", "", "index", "", "pixels", "", "dataWidth", "dataHeight", "frameTime", "(I[BIII)V", "bitmap", "Landroid/graphics/Bitmap;", "getDataHeight", "()I", "getDataWidth", "getFrameTime", "getIndex", "getPixels", "()[B", "targetHeight", "getTargetHeight", "setTargetHeight", "(I)V", "targetWidth", "getTargetWidth", "setTargetWidth", "component1", "component2", "component3", "component4", "component5", "copy", "decodeBitmap", "equals", "", "other", "getBitmap", "hashCode", "recycle", "", "scaleBitmap", "toString", "", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class FrameData
{
  public static final FrameData.Companion a;
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  @NotNull
  private final byte[] jdField_a_of_type_ArrayOfByte;
  private int b;
  private final int c;
  private final int d;
  private final int e;
  private final int f;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqApolloPlayerFrameData$Companion = new FrameData.Companion(null);
  }
  
  public FrameData(int paramInt1, @NotNull byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4)
  {
    this.c = paramInt1;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.d = paramInt2;
    this.e = paramInt3;
    this.f = paramInt4;
  }
  
  private final Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f1 = paramInt1 * 1.0F / i;
    float f2 = paramInt2 * 1.0F / j;
    Object localObject = new Matrix();
    ((Matrix)localObject).postScale(f1, f2);
    localObject = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, (Matrix)localObject, true);
    if (((Intrinsics.areEqual(paramBitmap, localObject) ^ true)) && (!paramBitmap.isRecycled())) {
      paramBitmap.recycle();
    }
    Intrinsics.checkExpressionValueIsNotNull(localObject, "res");
    return localObject;
  }
  
  public final int a()
  {
    return this.c;
  }
  
  @Nullable
  public final Bitmap a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      try
      {
        Bitmap localBitmap2 = Bitmap.createBitmap(this.d, this.e, Bitmap.Config.ARGB_8888);
        if (localBitmap2 == null) {
          Intrinsics.throwNpe();
        }
        localBitmap2.copyPixelsFromBuffer((Buffer)ByteBuffer.wrap(this.jdField_a_of_type_ArrayOfByte));
        Bitmap localBitmap1 = localBitmap2;
        if (this.jdField_a_of_type_Int > 0)
        {
          localBitmap1 = localBitmap2;
          if (this.b > 0) {
            if (this.d == this.jdField_a_of_type_Int)
            {
              localBitmap1 = localBitmap2;
              if (this.e == this.b) {}
            }
            else
            {
              localBitmap1 = a(localBitmap2, this.jdField_a_of_type_Int, this.b);
            }
          }
        }
        this.jdField_a_of_type_AndroidGraphicsBitmap = localBitmap1;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("FrameData", 1, "decodeBitmap error.", localThrowable);
      }
    }
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public final void a()
  {
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localBitmap != null) {
      localBitmap.recycle();
    }
  }
  
  public final void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  @NotNull
  public final byte[] a()
  {
    return this.jdField_a_of_type_ArrayOfByte;
  }
  
  public final int b()
  {
    return this.d;
  }
  
  @Nullable
  public final Bitmap b()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public final void b(int paramInt)
  {
    this.b = paramInt;
  }
  
  public final int c()
  {
    return this.e;
  }
  
  public final int d()
  {
    return this.f;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof FrameData))
      {
        paramObject = (FrameData)paramObject;
        if ((this.c == paramObject.c) && (Intrinsics.areEqual(this.jdField_a_of_type_ArrayOfByte, paramObject.jdField_a_of_type_ArrayOfByte)) && (this.d == paramObject.d) && (this.e == paramObject.e) && (this.f == paramObject.f)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int j = this.c;
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    int i;
    if (arrayOfByte != null) {
      i = Arrays.hashCode(arrayOfByte);
    } else {
      i = 0;
    }
    return (((j * 31 + i) * 31 + this.d) * 31 + this.e) * 31 + this.f;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FrameData(index=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", pixels=");
    localStringBuilder.append(Arrays.toString(this.jdField_a_of_type_ArrayOfByte));
    localStringBuilder.append(", dataWidth=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", dataHeight=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", frameTime=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.FrameData
 * JD-Core Version:    0.7.0.1
 */