package com.tencent.crossengine.net;

import java.io.OutputStream;
import okhttp3.RequestBody;

class OkHttpNetworkManager$3$1
  extends OutputStream
{
  OkHttpNetworkManager$3$1(OkHttpNetworkManager.3 param3, OutputStream paramOutputStream) {}
  
  public void close()
  {
    this.a.close();
  }
  
  public void flush()
  {
    this.a.flush();
  }
  
  public void write(int paramInt)
  {
    this.a.write(paramInt);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.a.write(paramArrayOfByte, paramInt1, paramInt2);
    if (this.b.b[0] == 0L) {
      this.b.b[0] = this.b.a.contentLength();
    }
    paramArrayOfByte = this.b.b;
    paramArrayOfByte[1] += paramInt2;
    this.b.c.onProgress(this.b.b[3], this.b.b[2], this.b.b[1], this.b.b[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.crossengine.net.OkHttpNetworkManager.3.1
 * JD-Core Version:    0.7.0.1
 */