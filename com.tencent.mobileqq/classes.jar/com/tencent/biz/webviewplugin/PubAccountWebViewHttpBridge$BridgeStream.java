package com.tencent.biz.webviewplugin;

import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

class PubAccountWebViewHttpBridge$BridgeStream
  extends InputStream
{
  BufferedInputStream a;
  BufferedInputStream b;
  ByteArrayOutputStream c;
  HttpURLConnection d;
  
  public PubAccountWebViewHttpBridge$BridgeStream(PubAccountWebViewHttpBridge paramPubAccountWebViewHttpBridge, BufferedInputStream paramBufferedInputStream1, BufferedInputStream paramBufferedInputStream2, ByteArrayOutputStream paramByteArrayOutputStream, HttpURLConnection paramHttpURLConnection)
  {
    this.a = paramBufferedInputStream1;
    this.b = paramBufferedInputStream2;
    if (paramByteArrayOutputStream == null) {
      paramByteArrayOutputStream = new ByteArrayOutputStream();
    }
    this.c = paramByteArrayOutputStream;
    this.d = paramHttpURLConnection;
  }
  
  public void close()
  {
    if (QLog.isColorLevel()) {
      QLog.i("PubAccountWebViewHttpBridge", 2, "now close memory stream and socket stream!");
    }
    try
    {
      if (this.a != null)
      {
        this.a.close();
        this.a = null;
      }
      if (this.b != null)
      {
        this.b.close();
        this.b = null;
      }
      if (this.d != null) {
        this.d.disconnect();
      }
      this.e.l = null;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public int read()
  {
    if ((this.a == null) && (this.b == null)) {
      return -1;
    }
    BufferedInputStream localBufferedInputStream = this.a;
    int i;
    if (localBufferedInputStream != null) {
      i = localBufferedInputStream.read();
    } else {
      i = -1;
    }
    int j = i;
    if (i == -1)
    {
      localBufferedInputStream = this.b;
      j = i;
      if (localBufferedInputStream != null) {
        j = localBufferedInputStream.read();
      }
    }
    return j;
  }
  
  public int read(byte[] paramArrayOfByte)
  {
    if ((this.a == null) && (this.b == null)) {
      return -1;
    }
    Object localObject = this.a;
    int i;
    if (localObject != null)
    {
      j = ((BufferedInputStream)localObject).read(paramArrayOfByte);
      i = j;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("now read data from memory buffer second: ");
        ((StringBuilder)localObject).append(j);
        QLog.i("PubAccountWebViewHttpBridge", 2, ((StringBuilder)localObject).toString());
        i = j;
      }
    }
    else
    {
      i = -1;
    }
    int j = i;
    if (i == -1)
    {
      localObject = this.b;
      j = i;
      if (localObject != null)
      {
        i = ((BufferedInputStream)localObject).read(paramArrayOfByte);
        j = i;
        if (QLog.isColorLevel())
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("now read data from socket stream second: ");
          paramArrayOfByte.append(i);
          QLog.i("PubAccountWebViewHttpBridge", 2, paramArrayOfByte.toString());
          j = i;
        }
      }
    }
    return j;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((this.a == null) && (this.b == null)) {
      return -1;
    }
    int i = paramArrayOfByte.length;
    if (((paramInt1 | paramInt2) >= 0) && (paramInt1 <= i) && (i - paramInt1 >= paramInt2))
    {
      i = 0;
      if (i >= paramInt2) {}
    }
    for (;;)
    {
      try
      {
        if (this.a == null) {
          break label180;
        }
        j = this.a.read();
        int k = j;
        if (j == -1)
        {
          k = j;
          if (this.b != null) {
            k = this.b.read();
          }
        }
        if (k == -1)
        {
          paramInt1 = i;
          if (i == 0) {
            paramInt1 = -1;
          }
          return paramInt1;
        }
        paramArrayOfByte[(paramInt1 + i)] = ((byte)k);
        i += 1;
      }
      catch (IOException paramArrayOfByte)
      {
        if (i != 0) {
          return i;
        }
        throw paramArrayOfByte;
      }
      return paramInt2;
      if (QLog.isColorLevel()) {
        QLog.d("PubAccountWebViewHttpBridge", 2, "buffer three, error");
      }
      paramArrayOfByte = new ArrayIndexOutOfBoundsException();
      for (;;)
      {
        throw paramArrayOfByte;
      }
      label180:
      int j = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.PubAccountWebViewHttpBridge.BridgeStream
 * JD-Core Version:    0.7.0.1
 */