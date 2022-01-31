package com.google.android.filament;

import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class RenderTarget$Builder
{
  private final RenderTarget.Builder.BuilderFinalizer mFinalizer = new RenderTarget.Builder.BuilderFinalizer(this.mNativeBuilder);
  private final long mNativeBuilder = RenderTarget.access$100();
  private final Texture[] mTextures = new Texture[2];
  
  @NonNull
  public RenderTarget build(@NonNull Engine paramEngine)
  {
    long l = RenderTarget.access$600(this.mNativeBuilder, paramEngine.getNativeObject());
    if (l == 0L) {
      throw new IllegalStateException("Couldn't create RenderTarget");
    }
    return new RenderTarget(l, this, null);
  }
  
  @NonNull
  public Builder face(@NonNull RenderTarget.AttachmentPoint paramAttachmentPoint, Texture.CubemapFace paramCubemapFace)
  {
    RenderTarget.access$400(this.mNativeBuilder, paramAttachmentPoint.ordinal(), paramCubemapFace.ordinal());
    return this;
  }
  
  @NonNull
  public Builder layer(@NonNull RenderTarget.AttachmentPoint paramAttachmentPoint, @IntRange(from=0L) int paramInt)
  {
    RenderTarget.access$500(this.mNativeBuilder, paramAttachmentPoint.ordinal(), paramInt);
    return this;
  }
  
  @NonNull
  public Builder mipLevel(@NonNull RenderTarget.AttachmentPoint paramAttachmentPoint, @IntRange(from=0L) int paramInt)
  {
    RenderTarget.access$300(this.mNativeBuilder, paramAttachmentPoint.ordinal(), paramInt);
    return this;
  }
  
  @NonNull
  public Builder texture(@NonNull RenderTarget.AttachmentPoint paramAttachmentPoint, @Nullable Texture paramTexture)
  {
    this.mTextures[paramAttachmentPoint.ordinal()] = paramTexture;
    long l2 = this.mNativeBuilder;
    int i = paramAttachmentPoint.ordinal();
    if (paramTexture != null) {}
    for (long l1 = paramTexture.getNativeObject();; l1 = 0L)
    {
      RenderTarget.access$200(l2, i, l1);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.google.android.filament.RenderTarget.Builder
 * JD-Core Version:    0.7.0.1
 */