package com.google.android.filament;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class RenderTarget
{
  private long mNativeObject;
  private final Texture[] mTextures = new Texture[2];
  
  private RenderTarget(long paramLong, RenderTarget.Builder paramBuilder)
  {
    this.mNativeObject = paramLong;
    this.mTextures[0] = RenderTarget.Builder.access$000(paramBuilder)[0];
    this.mTextures[1] = RenderTarget.Builder.access$000(paramBuilder)[1];
  }
  
  private static native long nBuilderBuild(long paramLong1, long paramLong2);
  
  private static native long nBuilderFace(long paramLong, int paramInt1, int paramInt2);
  
  private static native long nBuilderLayer(long paramLong, int paramInt1, int paramInt2);
  
  private static native long nBuilderMipLevel(long paramLong, int paramInt1, int paramInt2);
  
  private static native long nBuilderTexture(long paramLong1, int paramInt, long paramLong2);
  
  private static native long nCreateBuilder();
  
  private static native long nDestroyBuilder(long paramLong);
  
  private static native int nGetFace(long paramLong, int paramInt);
  
  private static native int nGetLayer(long paramLong, int paramInt);
  
  private static native int nGetMipLevel(long paramLong, int paramInt);
  
  void clearNativeObject()
  {
    this.mNativeObject = 0L;
  }
  
  public Texture.CubemapFace getFace(RenderTarget.AttachmentPoint paramAttachmentPoint)
  {
    return Texture.CubemapFace.values()[nGetFace(getNativeObject(), paramAttachmentPoint.ordinal())];
  }
  
  @IntRange(from=0L)
  public int getLayer(@NonNull RenderTarget.AttachmentPoint paramAttachmentPoint)
  {
    return nGetLayer(getNativeObject(), paramAttachmentPoint.ordinal());
  }
  
  @IntRange(from=0L)
  public int getMipLevel(@NonNull RenderTarget.AttachmentPoint paramAttachmentPoint)
  {
    return nGetMipLevel(getNativeObject(), paramAttachmentPoint.ordinal());
  }
  
  public long getNativeObject()
  {
    if (this.mNativeObject == 0L) {
      throw new IllegalStateException("Calling method on destroyed RenderTarget");
    }
    return this.mNativeObject;
  }
  
  @Nullable
  public Texture getTexture(@NonNull RenderTarget.AttachmentPoint paramAttachmentPoint)
  {
    return this.mTextures[paramAttachmentPoint.ordinal()];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.filament.RenderTarget
 * JD-Core Version:    0.7.0.1
 */