package com.sina.weibo.sdk.net;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public final class g
  implements f
{
  private int q;
  private InputStream r;
  
  public g(int paramInt, InputStream paramInputStream)
  {
    this.q = paramInt;
    this.r = paramInputStream;
  }
  
  public final String j()
  {
    Object localObject;
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      localObject = new byte[1024];
      for (;;)
      {
        int i = this.r.read((byte[])localObject);
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write((byte[])localObject, 0, i);
      }
      localObject = localIOException.toString();
    }
    catch (IOException localIOException)
    {
      throw localIOException;
    }
    localIOException.close();
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.net.g
 * JD-Core Version:    0.7.0.1
 */