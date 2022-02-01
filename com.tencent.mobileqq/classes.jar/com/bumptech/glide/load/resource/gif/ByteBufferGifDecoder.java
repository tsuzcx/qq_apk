package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.gifdecoder.GifHeader;
import com.bumptech.glide.gifdecoder.GifHeaderParser;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.UnitTransformation;
import com.bumptech.glide.util.LogTime;
import java.nio.ByteBuffer;
import java.util.List;

public class ByteBufferGifDecoder
  implements ResourceDecoder<ByteBuffer, GifDrawable>
{
  private static final ByteBufferGifDecoder.GifDecoderFactory a = new ByteBufferGifDecoder.GifDecoderFactory();
  private static final ByteBufferGifDecoder.GifHeaderParserPool b = new ByteBufferGifDecoder.GifHeaderParserPool();
  private final Context c;
  private final List<ImageHeaderParser> d;
  private final ByteBufferGifDecoder.GifHeaderParserPool e;
  private final ByteBufferGifDecoder.GifDecoderFactory f;
  private final GifBitmapProvider g;
  
  public ByteBufferGifDecoder(Context paramContext, List<ImageHeaderParser> paramList, BitmapPool paramBitmapPool, ArrayPool paramArrayPool)
  {
    this(paramContext, paramList, paramBitmapPool, paramArrayPool, b, a);
  }
  
  @VisibleForTesting
  ByteBufferGifDecoder(Context paramContext, List<ImageHeaderParser> paramList, BitmapPool paramBitmapPool, ArrayPool paramArrayPool, ByteBufferGifDecoder.GifHeaderParserPool paramGifHeaderParserPool, ByteBufferGifDecoder.GifDecoderFactory paramGifDecoderFactory)
  {
    this.c = paramContext.getApplicationContext();
    this.d = paramList;
    this.f = paramGifDecoderFactory;
    this.g = new GifBitmapProvider(paramBitmapPool, paramArrayPool);
    this.e = paramGifHeaderParserPool;
  }
  
  private static int a(GifHeader paramGifHeader, int paramInt1, int paramInt2)
  {
    int i = Math.min(paramGifHeader.a() / paramInt2, paramGifHeader.b() / paramInt1);
    if (i == 0) {
      i = 0;
    } else {
      i = Integer.highestOneBit(i);
    }
    i = Math.max(1, i);
    if ((Log.isLoggable("BufferGifDecoder", 2)) && (i > 1))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Downsampling GIF, sampleSize: ");
      localStringBuilder.append(i);
      localStringBuilder.append(", target dimens: [");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("x");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("], actual dimens: [");
      localStringBuilder.append(paramGifHeader.b());
      localStringBuilder.append("x");
      localStringBuilder.append(paramGifHeader.a());
      localStringBuilder.append("]");
      Log.v("BufferGifDecoder", localStringBuilder.toString());
    }
    return i;
  }
  
  @Nullable
  private GifDrawableResource a(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, GifHeaderParser paramGifHeaderParser, Options paramOptions)
  {
    long l = LogTime.a();
    try
    {
      GifHeader localGifHeader = paramGifHeaderParser.b();
      if ((localGifHeader.c() > 0) && (localGifHeader.d() == 0))
      {
        if (paramOptions.a(GifOptions.a) == DecodeFormat.PREFER_RGB_565) {
          paramGifHeaderParser = Bitmap.Config.RGB_565;
        } else {
          paramGifHeaderParser = Bitmap.Config.ARGB_8888;
        }
        int i = a(localGifHeader, paramInt1, paramInt2);
        paramByteBuffer = this.f.a(this.g, localGifHeader, paramByteBuffer, i);
        paramByteBuffer.a(paramGifHeaderParser);
        paramByteBuffer.b();
        paramGifHeaderParser = paramByteBuffer.h();
        if (paramGifHeaderParser == null) {
          return null;
        }
        paramOptions = UnitTransformation.a();
        paramByteBuffer = new GifDrawableResource(new GifDrawable(this.c, paramByteBuffer, paramOptions, paramInt1, paramInt2, paramGifHeaderParser));
        return paramByteBuffer;
      }
      return null;
    }
    finally
    {
      if (Log.isLoggable("BufferGifDecoder", 2))
      {
        paramGifHeaderParser = new StringBuilder();
        paramGifHeaderParser.append("Decoded GIF from stream in ");
        paramGifHeaderParser.append(LogTime.a(l));
        Log.v("BufferGifDecoder", paramGifHeaderParser.toString());
      }
    }
  }
  
  public GifDrawableResource a(@NonNull ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, @NonNull Options paramOptions)
  {
    GifHeaderParser localGifHeaderParser = this.e.a(paramByteBuffer);
    try
    {
      paramByteBuffer = a(paramByteBuffer, paramInt1, paramInt2, localGifHeaderParser, paramOptions);
      return paramByteBuffer;
    }
    finally
    {
      this.e.a(localGifHeaderParser);
    }
  }
  
  public boolean a(@NonNull ByteBuffer paramByteBuffer, @NonNull Options paramOptions)
  {
    return (!((Boolean)paramOptions.a(GifOptions.b)).booleanValue()) && (ImageHeaderParserUtils.a(this.d, paramByteBuffer) == ImageHeaderParser.ImageType.GIF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder
 * JD-Core Version:    0.7.0.1
 */