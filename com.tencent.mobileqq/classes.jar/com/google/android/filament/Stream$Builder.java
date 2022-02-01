package com.google.android.filament;

import androidx.annotation.NonNull;

public class Stream$Builder
{
  private final Stream.Builder.BuilderFinalizer mFinalizer = new Stream.Builder.BuilderFinalizer(this.mNativeBuilder);
  private final long mNativeBuilder = Stream.access$000();
  
  @NonNull
  public Stream build(@NonNull Engine paramEngine)
  {
    long l = Stream.access$500(this.mNativeBuilder, paramEngine.getNativeObject());
    if (l == 0L) {
      throw new IllegalStateException("Couldn't create Stream");
    }
    return new Stream(l, paramEngine);
  }
  
  @NonNull
  public Builder height(int paramInt)
  {
    Stream.access$400(this.mNativeBuilder, paramInt);
    return this;
  }
  
  @NonNull
  public Builder stream(long paramLong)
  {
    Stream.access$200(this.mNativeBuilder, paramLong);
    return this;
  }
  
  @NonNull
  public Builder stream(@NonNull Object paramObject)
  {
    if (Platform.get().validateStreamSource(paramObject))
    {
      Stream.access$100(this.mNativeBuilder, paramObject);
      return this;
    }
    throw new IllegalArgumentException("Invalid stream source: " + paramObject);
  }
  
  @NonNull
  public Builder width(int paramInt)
  {
    Stream.access$300(this.mNativeBuilder, paramInt);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.filament.Stream.Builder
 * JD-Core Version:    0.7.0.1
 */