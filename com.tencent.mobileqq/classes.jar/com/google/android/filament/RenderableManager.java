package com.google.android.filament;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import java.nio.Buffer;
import java.nio.BufferOverflowException;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

public class RenderableManager
{
  private static final String LOG_TAG = "Filament";
  private long mNativeObject;
  
  RenderableManager(long paramLong)
  {
    this.mNativeObject = paramLong;
  }
  
  private static native void nBuilderBlendOrder(long paramLong, int paramInt1, int paramInt2);
  
  private static native void nBuilderBoundingBox(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6);
  
  private static native boolean nBuilderBuild(long paramLong1, long paramLong2, int paramInt);
  
  private static native void nBuilderCastShadows(long paramLong, boolean paramBoolean);
  
  private static native void nBuilderCulling(long paramLong, boolean paramBoolean);
  
  private static native void nBuilderGeometry(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3);
  
  private static native void nBuilderGeometry(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3, int paramInt3, int paramInt4);
  
  private static native void nBuilderGeometry(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
  private static native void nBuilderLayerMask(long paramLong, int paramInt1, int paramInt2);
  
  private static native void nBuilderMaterial(long paramLong1, int paramInt, long paramLong2);
  
  private static native void nBuilderMorphing(long paramLong, boolean paramBoolean);
  
  private static native void nBuilderPriority(long paramLong, int paramInt);
  
  private static native void nBuilderReceiveShadows(long paramLong, boolean paramBoolean);
  
  private static native void nBuilderSkinning(long paramLong, int paramInt);
  
  private static native int nBuilderSkinningBones(long paramLong, int paramInt1, Buffer paramBuffer, int paramInt2);
  
  private static native long nCreateBuilder(int paramInt);
  
  private static native void nDestroy(long paramLong, int paramInt);
  
  private static native void nDestroyBuilder(long paramLong);
  
  private static native void nGetAxisAlignedBoundingBox(long paramLong, int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2);
  
  private static native int nGetEnabledAttributesAt(long paramLong, int paramInt1, int paramInt2);
  
  private static native int nGetInstance(long paramLong, int paramInt);
  
  private static native long nGetMaterialAt(long paramLong, int paramInt1, int paramInt2);
  
  private static native long nGetMaterialInstanceAt(long paramLong, int paramInt1, int paramInt2);
  
  private static native int nGetPrimitiveCount(long paramLong, int paramInt);
  
  private static native boolean nHasComponent(long paramLong, int paramInt);
  
  private static native boolean nIsShadowCaster(long paramLong, int paramInt);
  
  private static native boolean nIsShadowReceiver(long paramLong, int paramInt);
  
  private static native void nSetAxisAlignedBoundingBox(long paramLong, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6);
  
  private static native void nSetBlendOrderAt(long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  private static native int nSetBonesAsMatrices(long paramLong, int paramInt1, Buffer paramBuffer, int paramInt2, int paramInt3, int paramInt4);
  
  private static native int nSetBonesAsQuaternions(long paramLong, int paramInt1, Buffer paramBuffer, int paramInt2, int paramInt3, int paramInt4);
  
  private static native void nSetCastShadows(long paramLong, int paramInt, boolean paramBoolean);
  
  private static native void nSetGeometryAt(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  private static native void nSetGeometryAt(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, long paramLong3, int paramInt4, int paramInt5);
  
  private static native void nSetLayerMask(long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  private static native void nSetMaterialInstanceAt(long paramLong1, int paramInt1, int paramInt2, long paramLong2);
  
  private static native void nSetMorphWeights(long paramLong, int paramInt, float[] paramArrayOfFloat);
  
  private static native void nSetPriority(long paramLong, int paramInt1, int paramInt2);
  
  private static native void nSetReceiveShadows(long paramLong, int paramInt, boolean paramBoolean);
  
  public void destroy(@Entity int paramInt)
  {
    nDestroy(this.mNativeObject, paramInt);
  }
  
  @NonNull
  public Box getAxisAlignedBoundingBox(@EntityInstance int paramInt, @Nullable Box paramBox)
  {
    Box localBox = paramBox;
    if (paramBox == null) {
      localBox = new Box();
    }
    nGetAxisAlignedBoundingBox(this.mNativeObject, paramInt, localBox.getCenter(), localBox.getHalfExtent());
    return localBox;
  }
  
  public Set<VertexBuffer.VertexAttribute> getEnabledAttributesAt(@EntityInstance int paramInt1, @IntRange(from=0L) int paramInt2)
  {
    paramInt2 = nGetEnabledAttributesAt(this.mNativeObject, paramInt1, paramInt2);
    EnumSet localEnumSet = EnumSet.noneOf(VertexBuffer.VertexAttribute.class);
    VertexBuffer.VertexAttribute[] arrayOfVertexAttribute = VertexBuffer.VertexAttribute.values();
    paramInt1 = 0;
    while (paramInt1 < arrayOfVertexAttribute.length)
    {
      if ((1 << paramInt1 & paramInt2) != 0) {
        localEnumSet.add(arrayOfVertexAttribute[paramInt1]);
      }
      paramInt1 += 1;
    }
    return Collections.unmodifiableSet(localEnumSet);
  }
  
  @EntityInstance
  public int getInstance(@Entity int paramInt)
  {
    return nGetInstance(this.mNativeObject, paramInt);
  }
  
  @NonNull
  public MaterialInstance getMaterialInstanceAt(@EntityInstance int paramInt1, @IntRange(from=0L) int paramInt2)
  {
    long l = nGetMaterialInstanceAt(this.mNativeObject, paramInt1, paramInt2);
    return new MaterialInstance(nGetMaterialAt(this.mNativeObject, paramInt1, paramInt2), l);
  }
  
  public long getNativeObject()
  {
    return this.mNativeObject;
  }
  
  @IntRange(from=0L)
  public int getPrimitiveCount(@EntityInstance int paramInt)
  {
    return nGetPrimitiveCount(this.mNativeObject, paramInt);
  }
  
  public boolean hasComponent(@Entity int paramInt)
  {
    return nHasComponent(this.mNativeObject, paramInt);
  }
  
  public boolean isShadowCaster(@EntityInstance int paramInt)
  {
    return nIsShadowCaster(this.mNativeObject, paramInt);
  }
  
  public boolean isShadowReceiver(@EntityInstance int paramInt)
  {
    return nIsShadowReceiver(this.mNativeObject, paramInt);
  }
  
  public void setAxisAlignedBoundingBox(@EntityInstance int paramInt, @NonNull Box paramBox)
  {
    nSetAxisAlignedBoundingBox(this.mNativeObject, paramInt, paramBox.getCenter()[0], paramBox.getCenter()[1], paramBox.getCenter()[2], paramBox.getHalfExtent()[0], paramBox.getHalfExtent()[1], paramBox.getHalfExtent()[2]);
  }
  
  public void setBlendOrderAt(@EntityInstance int paramInt1, @IntRange(from=0L) int paramInt2, @IntRange(from=0L, to=65535L) int paramInt3)
  {
    nSetBlendOrderAt(this.mNativeObject, paramInt1, paramInt2, paramInt3);
  }
  
  public void setBonesAsMatrices(@EntityInstance int paramInt1, @NonNull Buffer paramBuffer, @IntRange(from=0L, to=255L) int paramInt2, @IntRange(from=0L) int paramInt3)
  {
    if (nSetBonesAsMatrices(this.mNativeObject, paramInt1, paramBuffer, paramBuffer.remaining(), paramInt2, paramInt3) < 0) {
      throw new BufferOverflowException();
    }
  }
  
  public void setBonesAsQuaternions(@EntityInstance int paramInt1, @NonNull Buffer paramBuffer, @IntRange(from=0L, to=255L) int paramInt2, @IntRange(from=0L) int paramInt3)
  {
    if (nSetBonesAsQuaternions(this.mNativeObject, paramInt1, paramBuffer, paramBuffer.remaining(), paramInt2, paramInt3) < 0) {
      throw new BufferOverflowException();
    }
  }
  
  public void setCastShadows(@EntityInstance int paramInt, boolean paramBoolean)
  {
    nSetCastShadows(this.mNativeObject, paramInt, paramBoolean);
  }
  
  public void setGeometryAt(@EntityInstance int paramInt1, @IntRange(from=0L) int paramInt2, @NonNull RenderableManager.PrimitiveType paramPrimitiveType, @IntRange(from=0L) int paramInt3, @IntRange(from=0L) int paramInt4)
  {
    nSetGeometryAt(this.mNativeObject, paramInt1, paramInt2, paramPrimitiveType.getValue(), paramInt3, paramInt4);
  }
  
  public void setGeometryAt(@EntityInstance int paramInt1, @IntRange(from=0L) int paramInt2, @NonNull RenderableManager.PrimitiveType paramPrimitiveType, @NonNull VertexBuffer paramVertexBuffer, @NonNull IndexBuffer paramIndexBuffer)
  {
    nSetGeometryAt(this.mNativeObject, paramInt1, paramInt2, paramPrimitiveType.getValue(), paramVertexBuffer.getNativeObject(), paramIndexBuffer.getNativeObject(), 0, paramIndexBuffer.getIndexCount());
  }
  
  public void setGeometryAt(@EntityInstance int paramInt1, @IntRange(from=0L) int paramInt2, @NonNull RenderableManager.PrimitiveType paramPrimitiveType, @NonNull VertexBuffer paramVertexBuffer, @NonNull IndexBuffer paramIndexBuffer, @IntRange(from=0L) int paramInt3, @IntRange(from=0L) int paramInt4)
  {
    nSetGeometryAt(this.mNativeObject, paramInt1, paramInt2, paramPrimitiveType.getValue(), paramVertexBuffer.getNativeObject(), paramIndexBuffer.getNativeObject(), paramInt3, paramInt4);
  }
  
  public void setLayerMask(@EntityInstance int paramInt1, @IntRange(from=0L, to=255L) int paramInt2, @IntRange(from=0L, to=255L) int paramInt3)
  {
    nSetLayerMask(this.mNativeObject, paramInt1, paramInt2, paramInt3);
  }
  
  public void setMaterialInstanceAt(@EntityInstance int paramInt1, @IntRange(from=0L) int paramInt2, @NonNull MaterialInstance paramMaterialInstance)
  {
    int i = paramMaterialInstance.getMaterial().getRequiredAttributesAsInt();
    if ((nGetEnabledAttributesAt(this.mNativeObject, paramInt1, paramInt2) & i) != i) {
      Platform.get().warn("setMaterialInstanceAt() on primitive " + paramInt2 + " of Renderable at " + paramInt1 + ": declared attributes " + getEnabledAttributesAt(paramInt1, paramInt2) + " do no satisfy required attributes " + paramMaterialInstance.getMaterial().getRequiredAttributes());
    }
    nSetMaterialInstanceAt(this.mNativeObject, paramInt1, paramInt2, paramMaterialInstance.getNativeObject());
  }
  
  public void setMorphWeights(@EntityInstance int paramInt, @NonNull @Size(min=4L) float[] paramArrayOfFloat)
  {
    nSetMorphWeights(this.mNativeObject, paramInt, paramArrayOfFloat);
  }
  
  public void setPriority(@EntityInstance int paramInt1, @IntRange(from=0L, to=7L) int paramInt2)
  {
    nSetPriority(this.mNativeObject, paramInt1, paramInt2);
  }
  
  public void setReceiveShadows(@EntityInstance int paramInt, boolean paramBoolean)
  {
    nSetReceiveShadows(this.mNativeObject, paramInt, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.filament.RenderableManager
 * JD-Core Version:    0.7.0.1
 */