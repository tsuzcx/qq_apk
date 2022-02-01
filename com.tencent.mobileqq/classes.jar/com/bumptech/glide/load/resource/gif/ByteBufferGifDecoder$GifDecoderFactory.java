package com.bumptech.glide.load.resource.gif;

import android.support.annotation.VisibleForTesting;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider;
import com.bumptech.glide.gifdecoder.GifHeader;
import com.bumptech.glide.gifdecoder.StandardGifDecoder;
import java.nio.ByteBuffer;

@VisibleForTesting
class ByteBufferGifDecoder$GifDecoderFactory
{
  GifDecoder a(GifDecoder.BitmapProvider paramBitmapProvider, GifHeader paramGifHeader, ByteBuffer paramByteBuffer, int paramInt)
  {
    return new StandardGifDecoder(paramBitmapProvider, paramGifHeader, paramByteBuffer, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder.GifDecoderFactory
 * JD-Core Version:    0.7.0.1
 */