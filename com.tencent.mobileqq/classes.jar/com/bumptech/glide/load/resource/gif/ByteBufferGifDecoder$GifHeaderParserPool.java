package com.bumptech.glide.load.resource.gif;

import android.support.annotation.VisibleForTesting;
import com.bumptech.glide.gifdecoder.GifHeaderParser;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.util.Queue;

@VisibleForTesting
class ByteBufferGifDecoder$GifHeaderParserPool
{
  private final Queue<GifHeaderParser> a = Util.a(0);
  
  GifHeaderParser a(ByteBuffer paramByteBuffer)
  {
    try
    {
      GifHeaderParser localGifHeaderParser2 = (GifHeaderParser)this.a.poll();
      GifHeaderParser localGifHeaderParser1 = localGifHeaderParser2;
      if (localGifHeaderParser2 == null) {
        localGifHeaderParser1 = new GifHeaderParser();
      }
      paramByteBuffer = localGifHeaderParser1.a(paramByteBuffer);
      return paramByteBuffer;
    }
    finally {}
  }
  
  void a(GifHeaderParser paramGifHeaderParser)
  {
    try
    {
      paramGifHeaderParser.a();
      this.a.offer(paramGifHeaderParser);
      return;
    }
    finally
    {
      paramGifHeaderParser = finally;
      throw paramGifHeaderParser;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder.GifHeaderParserPool
 * JD-Core Version:    0.7.0.1
 */