package com.google.android.filament;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import java.nio.Buffer;
import java.nio.BufferOverflowException;

public class RenderableManager$Builder
{
  private final RenderableManager.Builder.BuilderFinalizer mFinalizer;
  private final long mNativeBuilder;
  
  public RenderableManager$Builder(@IntRange(from=1L) int paramInt)
  {
    this.mNativeBuilder = RenderableManager.access$000(paramInt);
    this.mFinalizer = new RenderableManager.Builder.BuilderFinalizer(this.mNativeBuilder);
  }
  
  @NonNull
  public Builder blendOrder(@IntRange(from=0L) int paramInt1, @IntRange(from=0L, to=32767L) int paramInt2)
  {
    RenderableManager.access$500(this.mNativeBuilder, paramInt1, paramInt2);
    return this;
  }
  
  @NonNull
  public Builder boundingBox(@NonNull Box paramBox)
  {
    RenderableManager.access$600(this.mNativeBuilder, paramBox.getCenter()[0], paramBox.getCenter()[1], paramBox.getCenter()[2], paramBox.getHalfExtent()[0], paramBox.getHalfExtent()[1], paramBox.getHalfExtent()[2]);
    return this;
  }
  
  public void build(@NonNull Engine paramEngine, @Entity int paramInt)
  {
    if (!RenderableManager.access$1500(this.mNativeBuilder, paramEngine.getNativeObject(), paramInt)) {
      throw new IllegalStateException("Couldn't create Renderable component for entity " + paramInt + ", see log.");
    }
  }
  
  @NonNull
  public Builder castShadows(boolean paramBoolean)
  {
    RenderableManager.access$1000(this.mNativeBuilder, paramBoolean);
    return this;
  }
  
  @NonNull
  public Builder culling(boolean paramBoolean)
  {
    RenderableManager.access$900(this.mNativeBuilder, paramBoolean);
    return this;
  }
  
  @NonNull
  public Builder geometry(@IntRange(from=0L) int paramInt, @NonNull RenderableManager.PrimitiveType paramPrimitiveType, @NonNull VertexBuffer paramVertexBuffer, @NonNull IndexBuffer paramIndexBuffer)
  {
    RenderableManager.access$300(this.mNativeBuilder, paramInt, paramPrimitiveType.getValue(), paramVertexBuffer.getNativeObject(), paramIndexBuffer.getNativeObject());
    return this;
  }
  
  @NonNull
  public Builder geometry(@IntRange(from=0L) int paramInt1, @NonNull RenderableManager.PrimitiveType paramPrimitiveType, @NonNull VertexBuffer paramVertexBuffer, @NonNull IndexBuffer paramIndexBuffer, @IntRange(from=0L) int paramInt2, @IntRange(from=0L) int paramInt3)
  {
    RenderableManager.access$200(this.mNativeBuilder, paramInt1, paramPrimitiveType.getValue(), paramVertexBuffer.getNativeObject(), paramIndexBuffer.getNativeObject(), paramInt2, paramInt3);
    return this;
  }
  
  @NonNull
  public Builder geometry(@IntRange(from=0L) int paramInt1, @NonNull RenderableManager.PrimitiveType paramPrimitiveType, @NonNull VertexBuffer paramVertexBuffer, @NonNull IndexBuffer paramIndexBuffer, @IntRange(from=0L) int paramInt2, @IntRange(from=0L) int paramInt3, @IntRange(from=0L) int paramInt4, @IntRange(from=0L) int paramInt5)
  {
    RenderableManager.access$100(this.mNativeBuilder, paramInt1, paramPrimitiveType.getValue(), paramVertexBuffer.getNativeObject(), paramIndexBuffer.getNativeObject(), paramInt2, paramInt3, paramInt4, paramInt5);
    return this;
  }
  
  @NonNull
  public Builder layerMask(@IntRange(from=0L, to=255L) int paramInt1, @IntRange(from=0L, to=255L) int paramInt2)
  {
    RenderableManager.access$700(this.mNativeBuilder, paramInt1 & 0xFF, paramInt2 & 0xFF);
    return this;
  }
  
  @NonNull
  public Builder material(@IntRange(from=0L) int paramInt, @NonNull MaterialInstance paramMaterialInstance)
  {
    RenderableManager.access$400(this.mNativeBuilder, paramInt, paramMaterialInstance.getNativeObject());
    return this;
  }
  
  @NonNull
  public Builder morphing(boolean paramBoolean)
  {
    RenderableManager.access$1400(this.mNativeBuilder, paramBoolean);
    return this;
  }
  
  @NonNull
  public Builder priority(@IntRange(from=0L, to=7L) int paramInt)
  {
    RenderableManager.access$800(this.mNativeBuilder, paramInt);
    return this;
  }
  
  @NonNull
  public Builder receiveShadows(boolean paramBoolean)
  {
    RenderableManager.access$1100(this.mNativeBuilder, paramBoolean);
    return this;
  }
  
  @NonNull
  public Builder skinning(@IntRange(from=0L, to=255L) int paramInt)
  {
    RenderableManager.access$1200(this.mNativeBuilder, paramInt);
    return this;
  }
  
  @NonNull
  public Builder skinning(@IntRange(from=0L, to=255L) int paramInt, @NonNull Buffer paramBuffer)
  {
    if (RenderableManager.access$1300(this.mNativeBuilder, paramInt, paramBuffer, paramBuffer.remaining()) < 0) {
      throw new BufferOverflowException();
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.filament.RenderableManager.Builder
 * JD-Core Version:    0.7.0.1
 */