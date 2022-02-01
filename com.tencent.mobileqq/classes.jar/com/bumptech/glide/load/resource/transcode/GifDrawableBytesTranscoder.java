package com.bumptech.glide.load.resource.transcode;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bytes.BytesResource;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.util.ByteBufferUtil;

public class GifDrawableBytesTranscoder
  implements ResourceTranscoder<GifDrawable, byte[]>
{
  @Nullable
  public Resource<byte[]> a(@NonNull Resource<GifDrawable> paramResource, @NonNull Options paramOptions)
  {
    return new BytesResource(ByteBufferUtil.a(((GifDrawable)paramResource.d()).c()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.transcode.GifDrawableBytesTranscoder
 * JD-Core Version:    0.7.0.1
 */