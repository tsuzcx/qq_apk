package com.google.android.filament;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Size;
import com.google.android.filament.proguard.UsedByReflection;
import java.nio.Buffer;
import java.nio.BufferOverflowException;

public class Texture
{
  public static final int BASE_LEVEL = 0;
  private long mNativeObject;
  
  @UsedByReflection("KtxLoader.java")
  Texture(long paramLong)
  {
    this.mNativeObject = paramLong;
  }
  
  public static boolean isTextureFormatSupported(@NonNull Engine paramEngine, @NonNull Texture.InternalFormat paramInternalFormat)
  {
    return nIsTextureFormatSupported(paramEngine.getNativeObject(), paramInternalFormat.ordinal());
  }
  
  private static native long nBuilderBuild(long paramLong1, long paramLong2);
  
  private static native void nBuilderDepth(long paramLong, int paramInt);
  
  private static native void nBuilderFormat(long paramLong, int paramInt);
  
  private static native void nBuilderHeight(long paramLong, int paramInt);
  
  private static native void nBuilderLevels(long paramLong, int paramInt);
  
  private static native void nBuilderSampler(long paramLong, int paramInt);
  
  private static native void nBuilderUsage(long paramLong, int paramInt);
  
  private static native void nBuilderWidth(long paramLong, int paramInt);
  
  private static native long nCreateBuilder();
  
  private static native void nDestroyBuilder(long paramLong);
  
  private static native void nGenerateMipmaps(long paramLong1, long paramLong2);
  
  private static native int nGeneratePrefilterMipmap(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Buffer paramBuffer, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int[] paramArrayOfInt, Object paramObject, Runnable paramRunnable, int paramInt10, boolean paramBoolean);
  
  private static native int nGetDepth(long paramLong, int paramInt);
  
  private static native int nGetHeight(long paramLong, int paramInt);
  
  private static native int nGetId(long paramLong1, long paramLong2);
  
  private static native int nGetInternalFormat(long paramLong);
  
  private static native int nGetLevels(long paramLong);
  
  private static native int nGetTarget(long paramLong);
  
  private static native int nGetWidth(long paramLong, int paramInt);
  
  private static native boolean nIsStreamValidForTexture(long paramLong1, long paramLong2);
  
  private static native boolean nIsTextureFormatSupported(long paramLong, int paramInt);
  
  private static native void nSetExternalImage(long paramLong1, long paramLong2, long paramLong3);
  
  private static native void nSetExternalStream(long paramLong1, long paramLong2, long paramLong3);
  
  private static native int nSetImage(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, Buffer paramBuffer, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, Object paramObject, Runnable paramRunnable);
  
  private static native int nSetImageCompressed(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, Buffer paramBuffer, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, Object paramObject, Runnable paramRunnable);
  
  private static native int nSetImageCubemap(long paramLong1, long paramLong2, int paramInt1, Buffer paramBuffer, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int[] paramArrayOfInt, Object paramObject, Runnable paramRunnable);
  
  private static native int nSetImageCubemapCompressed(long paramLong1, long paramLong2, int paramInt1, Buffer paramBuffer, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int[] paramArrayOfInt, Object paramObject, Runnable paramRunnable);
  
  void clearNativeObject()
  {
    this.mNativeObject = 0L;
  }
  
  public void generateMipmaps(@NonNull Engine paramEngine)
  {
    nGenerateMipmaps(getNativeObject(), paramEngine.getNativeObject());
  }
  
  public void generatePrefilterMipmap(@NonNull Engine paramEngine, @NonNull Texture.PixelBufferDescriptor paramPixelBufferDescriptor, @NonNull @Size(min=6L) int[] paramArrayOfInt, Texture.PrefilterOptions paramPrefilterOptions)
  {
    int j = getWidth(0);
    int k = getHeight(0);
    int i = 8;
    boolean bool = true;
    if (paramPrefilterOptions != null)
    {
      i = paramPrefilterOptions.sampleCount;
      bool = paramPrefilterOptions.mirror;
    }
    if (nGeneratePrefilterMipmap(getNativeObject(), paramEngine.getNativeObject(), j, k, paramPixelBufferDescriptor.storage, paramPixelBufferDescriptor.storage.remaining(), paramPixelBufferDescriptor.left, paramPixelBufferDescriptor.top, paramPixelBufferDescriptor.type.ordinal(), paramPixelBufferDescriptor.alignment, paramPixelBufferDescriptor.stride, paramPixelBufferDescriptor.format.ordinal(), paramArrayOfInt, paramPixelBufferDescriptor.handler, paramPixelBufferDescriptor.callback, i, bool) < 0) {
      throw new BufferOverflowException();
    }
  }
  
  public int getDepth(@IntRange(from=0L) int paramInt)
  {
    return nGetDepth(getNativeObject(), paramInt);
  }
  
  @NonNull
  public Texture.InternalFormat getFormat()
  {
    return Texture.InternalFormat.values()[nGetInternalFormat(getNativeObject())];
  }
  
  public int getHeight(@IntRange(from=0L) int paramInt)
  {
    return nGetHeight(getNativeObject(), paramInt);
  }
  
  public int getId(@NonNull Engine paramEngine)
  {
    return nGetId(paramEngine.getNativeObject(), getNativeObject());
  }
  
  public int getLevels()
  {
    return nGetLevels(getNativeObject());
  }
  
  @UsedByReflection("TextureHelper.java")
  public long getNativeObject()
  {
    if (this.mNativeObject == 0L) {
      throw new IllegalStateException("Calling method on destroyed Texture");
    }
    return this.mNativeObject;
  }
  
  @NonNull
  public Texture.Sampler getTarget()
  {
    return Texture.Sampler.values()[nGetTarget(getNativeObject())];
  }
  
  public int getWidth(@IntRange(from=0L) int paramInt)
  {
    return nGetWidth(getNativeObject(), paramInt);
  }
  
  public void setExternalImage(@NonNull Engine paramEngine, long paramLong)
  {
    nSetExternalImage(getNativeObject(), paramEngine.getNativeObject(), paramLong);
  }
  
  public void setExternalStream(@NonNull Engine paramEngine, @NonNull Stream paramStream)
  {
    long l1 = getNativeObject();
    long l2 = paramStream.getNativeObject();
    if (!nIsStreamValidForTexture(l1, l2)) {
      throw new IllegalStateException("Invalid texture sampler: When used with a stream, a texture must use a SAMPLER_EXTERNAL");
    }
    nSetExternalStream(l1, paramEngine.getNativeObject(), l2);
  }
  
  public void setImage(@NonNull Engine paramEngine, @IntRange(from=0L) int paramInt1, @IntRange(from=0L) int paramInt2, @IntRange(from=0L) int paramInt3, @IntRange(from=0L) int paramInt4, @IntRange(from=0L) int paramInt5, @NonNull Texture.PixelBufferDescriptor paramPixelBufferDescriptor)
  {
    if (paramPixelBufferDescriptor.type == Texture.Type.COMPRESSED) {}
    for (paramInt1 = nSetImageCompressed(getNativeObject(), paramEngine.getNativeObject(), paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramPixelBufferDescriptor.storage, paramPixelBufferDescriptor.storage.remaining(), paramPixelBufferDescriptor.left, paramPixelBufferDescriptor.top, paramPixelBufferDescriptor.type.ordinal(), paramPixelBufferDescriptor.alignment, paramPixelBufferDescriptor.compressedSizeInBytes, paramPixelBufferDescriptor.compressedFormat.ordinal(), paramPixelBufferDescriptor.handler, paramPixelBufferDescriptor.callback); paramInt1 < 0; paramInt1 = nSetImage(getNativeObject(), paramEngine.getNativeObject(), paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramPixelBufferDescriptor.storage, paramPixelBufferDescriptor.storage.remaining(), paramPixelBufferDescriptor.left, paramPixelBufferDescriptor.top, paramPixelBufferDescriptor.type.ordinal(), paramPixelBufferDescriptor.alignment, paramPixelBufferDescriptor.stride, paramPixelBufferDescriptor.format.ordinal(), paramPixelBufferDescriptor.handler, paramPixelBufferDescriptor.callback)) {
      throw new BufferOverflowException();
    }
  }
  
  public void setImage(@NonNull Engine paramEngine, @IntRange(from=0L) int paramInt, @NonNull Texture.PixelBufferDescriptor paramPixelBufferDescriptor)
  {
    setImage(paramEngine, paramInt, 0, 0, getWidth(paramInt), getHeight(paramInt), paramPixelBufferDescriptor);
  }
  
  public void setImage(@NonNull Engine paramEngine, @IntRange(from=0L) int paramInt, @NonNull Texture.PixelBufferDescriptor paramPixelBufferDescriptor, @NonNull @Size(min=6L) int[] paramArrayOfInt)
  {
    if (paramPixelBufferDescriptor.type == Texture.Type.COMPRESSED) {}
    for (paramInt = nSetImageCubemapCompressed(getNativeObject(), paramEngine.getNativeObject(), paramInt, paramPixelBufferDescriptor.storage, paramPixelBufferDescriptor.storage.remaining(), paramPixelBufferDescriptor.left, paramPixelBufferDescriptor.top, paramPixelBufferDescriptor.type.ordinal(), paramPixelBufferDescriptor.alignment, paramPixelBufferDescriptor.compressedSizeInBytes, paramPixelBufferDescriptor.compressedFormat.ordinal(), paramArrayOfInt, paramPixelBufferDescriptor.handler, paramPixelBufferDescriptor.callback); paramInt < 0; paramInt = nSetImageCubemap(getNativeObject(), paramEngine.getNativeObject(), paramInt, paramPixelBufferDescriptor.storage, paramPixelBufferDescriptor.storage.remaining(), paramPixelBufferDescriptor.left, paramPixelBufferDescriptor.top, paramPixelBufferDescriptor.type.ordinal(), paramPixelBufferDescriptor.alignment, paramPixelBufferDescriptor.stride, paramPixelBufferDescriptor.format.ordinal(), paramArrayOfInt, paramPixelBufferDescriptor.handler, paramPixelBufferDescriptor.callback)) {
      throw new BufferOverflowException();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.filament.Texture
 * JD-Core Version:    0.7.0.1
 */