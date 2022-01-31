package com.google.android.filament;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;

public class VertexBuffer$Builder
{
  private final VertexBuffer.Builder.BuilderFinalizer mFinalizer = new VertexBuffer.Builder.BuilderFinalizer(this.mNativeBuilder);
  private final long mNativeBuilder = VertexBuffer.access$000();
  
  @NonNull
  public Builder attribute(@NonNull VertexBuffer.VertexAttribute paramVertexAttribute, @IntRange(from=0L) int paramInt, @NonNull VertexBuffer.AttributeType paramAttributeType)
  {
    return attribute(paramVertexAttribute, paramInt, paramAttributeType, 0, 0);
  }
  
  @NonNull
  public Builder attribute(@NonNull VertexBuffer.VertexAttribute paramVertexAttribute, @IntRange(from=0L) int paramInt1, @NonNull VertexBuffer.AttributeType paramAttributeType, @IntRange(from=0L) int paramInt2, @IntRange(from=0L) int paramInt3)
  {
    VertexBuffer.access$300(this.mNativeBuilder, paramVertexAttribute.ordinal(), paramInt1, paramAttributeType.ordinal(), paramInt2, paramInt3);
    return this;
  }
  
  @NonNull
  public Builder bufferCount(@IntRange(from=1L) int paramInt)
  {
    VertexBuffer.access$200(this.mNativeBuilder, paramInt);
    return this;
  }
  
  @NonNull
  public VertexBuffer build(@NonNull Engine paramEngine)
  {
    long l = VertexBuffer.access$500(this.mNativeBuilder, paramEngine.getNativeObject());
    if (l == 0L) {
      throw new IllegalStateException("Couldn't create VertexBuffer");
    }
    return new VertexBuffer(l, null);
  }
  
  @NonNull
  public Builder normalized(@NonNull VertexBuffer.VertexAttribute paramVertexAttribute)
  {
    VertexBuffer.access$400(this.mNativeBuilder, paramVertexAttribute.ordinal(), true);
    return this;
  }
  
  @NonNull
  public Builder normalized(@NonNull VertexBuffer.VertexAttribute paramVertexAttribute, boolean paramBoolean)
  {
    VertexBuffer.access$400(this.mNativeBuilder, paramVertexAttribute.ordinal(), paramBoolean);
    return this;
  }
  
  @NonNull
  public Builder vertexCount(@IntRange(from=1L) int paramInt)
  {
    VertexBuffer.access$100(this.mNativeBuilder, paramInt);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.filament.VertexBuffer.Builder
 * JD-Core Version:    0.7.0.1
 */