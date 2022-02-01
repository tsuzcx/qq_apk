package com.google.android.filament;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class Texture$PixelBufferDescriptor
{
  public int alignment = 1;
  @Nullable
  public Runnable callback;
  public Texture.CompressedFormat compressedFormat;
  public int compressedSizeInBytes;
  public Texture.Format format;
  @Nullable
  public Object handler;
  public int left = 0;
  public Buffer storage;
  public int stride = 0;
  public int top = 0;
  public Texture.Type type;
  
  public Texture$PixelBufferDescriptor(@NonNull Buffer paramBuffer, @NonNull Texture.Format paramFormat, @NonNull Texture.Type paramType)
  {
    this(paramBuffer, paramFormat, paramType, 1, 0, 0, 0, null, null);
  }
  
  public Texture$PixelBufferDescriptor(@NonNull Buffer paramBuffer, @NonNull Texture.Format paramFormat, @NonNull Texture.Type paramType, @IntRange(from=1L, to=8L) int paramInt)
  {
    this(paramBuffer, paramFormat, paramType, paramInt, 0, 0, 0, null, null);
  }
  
  public Texture$PixelBufferDescriptor(@NonNull Buffer paramBuffer, @NonNull Texture.Format paramFormat, @NonNull Texture.Type paramType, @IntRange(from=1L, to=8L) int paramInt1, @IntRange(from=0L) int paramInt2, @IntRange(from=0L) int paramInt3)
  {
    this(paramBuffer, paramFormat, paramType, paramInt1, paramInt2, paramInt3, 0, null, null);
  }
  
  public Texture$PixelBufferDescriptor(@NonNull Buffer paramBuffer, @NonNull Texture.Format paramFormat, @NonNull Texture.Type paramType, @IntRange(from=1L, to=8L) int paramInt1, @IntRange(from=0L) int paramInt2, @IntRange(from=0L) int paramInt3, @IntRange(from=0L) int paramInt4, @Nullable Object paramObject, @Nullable Runnable paramRunnable)
  {
    this.storage = paramBuffer;
    this.left = paramInt2;
    this.top = paramInt3;
    this.type = paramType;
    this.alignment = paramInt1;
    this.stride = paramInt4;
    this.format = paramFormat;
    this.handler = paramObject;
    this.callback = paramRunnable;
  }
  
  public Texture$PixelBufferDescriptor(@NonNull ByteBuffer paramByteBuffer, @NonNull Texture.CompressedFormat paramCompressedFormat, @IntRange(from=0L) int paramInt)
  {
    this.storage = paramByteBuffer;
    this.type = Texture.Type.COMPRESSED;
    this.alignment = 1;
    this.compressedFormat = paramCompressedFormat;
    this.compressedSizeInBytes = paramInt;
  }
  
  static int computeDataSize(@NonNull Texture.Format paramFormat, @NonNull Texture.Type paramType, int paramInt1, int paramInt2, @IntRange(from=1L, to=8L) int paramInt3)
  {
    int i = 0;
    if (paramType == Texture.Type.COMPRESSED) {
      return 0;
    }
    int j;
    switch (Texture.1.$SwitchMap$com$google$android$filament$Texture$Format[paramFormat.ordinal()])
    {
    default: 
      j = i;
      switch (Texture.1.$SwitchMap$com$google$android$filament$Texture$Type[paramType.ordinal()])
      {
      default: 
        j = i;
      }
      break;
    }
    for (;;)
    {
      return (j * paramInt1 + (paramInt3 - 1) & -paramInt3) * paramInt2;
      i = 1;
      break;
      i = 2;
      break;
      i = 3;
      break;
      i = 4;
      break;
      j = i * 2;
      continue;
      j = i * 4;
      continue;
      j = 4;
    }
  }
  
  public void setCallback(@Nullable Object paramObject, @Nullable Runnable paramRunnable)
  {
    this.handler = paramObject;
    this.callback = paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.filament.Texture.PixelBufferDescriptor
 * JD-Core Version:    0.7.0.1
 */