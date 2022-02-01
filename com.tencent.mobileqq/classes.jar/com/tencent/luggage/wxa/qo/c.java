package com.tencent.luggage.wxa.qo;

import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.if.e;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSourceFactory;
import com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource;
import java.nio.ByteBuffer;

public class c
  implements IDataSourceFactory
{
  public e a;
  public ByteBuffer b;
  
  public c(e parame)
  {
    this.a = parame;
  }
  
  public c(ByteBuffer paramByteBuffer)
  {
    this.b = paramByteBuffer;
  }
  
  public IDataSource createDataSource()
  {
    ByteBuffer localByteBuffer = this.b;
    if (localByteBuffer != null) {
      return new a(localByteBuffer);
    }
    return new b(this.a);
  }
  
  @Nullable
  public INativeDataSource createNativeDataSource()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qo.c
 * JD-Core Version:    0.7.0.1
 */