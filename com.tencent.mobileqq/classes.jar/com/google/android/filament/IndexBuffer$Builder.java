package com.google.android.filament;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;

public class IndexBuffer$Builder
{
  private final IndexBuffer.Builder.BuilderFinalizer mFinalizer = new IndexBuffer.Builder.BuilderFinalizer(this.mNativeBuilder);
  private final long mNativeBuilder = IndexBuffer.access$000();
  
  @NonNull
  public Builder bufferType(@NonNull IndexBuffer.Builder.IndexType paramIndexType)
  {
    IndexBuffer.access$200(this.mNativeBuilder, paramIndexType.ordinal());
    return this;
  }
  
  @NonNull
  public IndexBuffer build(@NonNull Engine paramEngine)
  {
    long l = IndexBuffer.access$300(this.mNativeBuilder, paramEngine.getNativeObject());
    if (l == 0L) {
      throw new IllegalStateException("Couldn't create IndexBuffer");
    }
    return new IndexBuffer(l, null);
  }
  
  @NonNull
  public Builder indexCount(@IntRange(from=1L) int paramInt)
  {
    IndexBuffer.access$100(this.mNativeBuilder, paramInt);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.filament.IndexBuffer.Builder
 * JD-Core Version:    0.7.0.1
 */