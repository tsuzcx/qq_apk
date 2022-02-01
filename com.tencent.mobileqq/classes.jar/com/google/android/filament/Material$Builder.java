package com.google.android.filament;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import java.nio.Buffer;

public class Material$Builder
{
  private Buffer mBuffer;
  private int mSize;
  
  @NonNull
  public Material build(@NonNull Engine paramEngine)
  {
    long l = Material.access$000(paramEngine.getNativeObject(), this.mBuffer, this.mSize);
    if (l == 0L) {
      throw new IllegalStateException("Couldn't create Material");
    }
    return new Material(l);
  }
  
  @NonNull
  public Builder payload(@NonNull Buffer paramBuffer, @IntRange(from=0L) int paramInt)
  {
    this.mBuffer = paramBuffer;
    this.mSize = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.filament.Material.Builder
 * JD-Core Version:    0.7.0.1
 */