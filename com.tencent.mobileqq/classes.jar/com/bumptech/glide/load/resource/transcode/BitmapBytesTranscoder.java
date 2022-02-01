package com.bumptech.glide.load.resource.transcode;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bytes.BytesResource;
import java.io.ByteArrayOutputStream;

public class BitmapBytesTranscoder
  implements ResourceTranscoder<Bitmap, byte[]>
{
  private final Bitmap.CompressFormat a;
  private final int b;
  
  public BitmapBytesTranscoder()
  {
    this(Bitmap.CompressFormat.JPEG, 100);
  }
  
  public BitmapBytesTranscoder(@NonNull Bitmap.CompressFormat paramCompressFormat, int paramInt)
  {
    this.a = paramCompressFormat;
    this.b = paramInt;
  }
  
  @Nullable
  public Resource<byte[]> a(@NonNull Resource<Bitmap> paramResource, @NonNull Options paramOptions)
  {
    paramOptions = new ByteArrayOutputStream();
    ((Bitmap)paramResource.d()).compress(this.a, this.b, paramOptions);
    paramResource.f();
    return new BytesResource(paramOptions.toByteArray());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.transcode.BitmapBytesTranscoder
 * JD-Core Version:    0.7.0.1
 */