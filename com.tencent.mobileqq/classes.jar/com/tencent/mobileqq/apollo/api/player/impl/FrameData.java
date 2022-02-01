package com.tencent.mobileqq.apollo.api.player.impl;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.qphone.base.util.QLog;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/api/player/impl/FrameData;", "", "index", "", "pixels", "", "width", "height", "frameTime", "(I[BIII)V", "bitmap", "Landroid/graphics/Bitmap;", "getFrameTime", "()I", "getHeight", "getIndex", "getPixels", "()[B", "getWidth", "component1", "component2", "component3", "component4", "component5", "copy", "decodeBitmap", "equals", "", "other", "getBitmap", "hashCode", "recycle", "", "toString", "", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class FrameData
{
  public static final FrameData.Companion a;
  private final int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  @NotNull
  private final byte[] jdField_a_of_type_ArrayOfByte;
  private final int b;
  private final int c;
  private final int d;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqApolloApiPlayerImplFrameData$Companion = new FrameData.Companion(null);
  }
  
  public FrameData(int paramInt1, @NotNull byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @Nullable
  public final Bitmap a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {}
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.b, this.c, Bitmap.Config.ARGB_8888);
      Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
      if (localBitmap == null) {
        Intrinsics.throwNpe();
      }
      localBitmap.copyPixelsFromBuffer((Buffer)ByteBuffer.wrap(this.jdField_a_of_type_ArrayOfByte));
    }
    catch (Throwable localThrowable)
    {
      for (;;)
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
  
  @NotNull
  public final byte[] a()
  {
    return this.jdField_a_of_type_ArrayOfByte;
  }
  
  public final int b()
  {
    return this.b;
  }
  
  @Nullable
  public final Bitmap b()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public final int c()
  {
    return this.c;
  }
  
  public final int d()
  {
    return this.d;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof FrameData))
      {
        paramObject = (FrameData)paramObject;
        if ((this.jdField_a_of_type_Int != paramObject.jdField_a_of_type_Int) || (!Intrinsics.areEqual(this.jdField_a_of_type_ArrayOfByte, paramObject.jdField_a_of_type_ArrayOfByte)) || (this.b != paramObject.b) || (this.c != paramObject.c) || (this.d != paramObject.d)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public int hashCode()
  {
    int j = this.jdField_a_of_type_Int;
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    if (arrayOfByte != null) {}
    for (int i = Arrays.hashCode(arrayOfByte);; i = 0) {
      return (((i + j * 31) * 31 + this.b) * 31 + this.c) * 31 + this.d;
    }
  }
  
  @NotNull
  public String toString()
  {
    return "FrameData(index=" + this.jdField_a_of_type_Int + ", pixels=" + Arrays.toString(this.jdField_a_of_type_ArrayOfByte) + ", width=" + this.b + ", height=" + this.c + ", frameTime=" + this.d + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.player.impl.FrameData
 * JD-Core Version:    0.7.0.1
 */