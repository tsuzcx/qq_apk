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
  BufferedInputStream jdField_a_of_type_JavaIoBufferedInputStream;
  ByteArrayOutputStream jdField_a_of_type_JavaIoByteArrayOutputStream;
  HttpURLConnection jdField_a_of_type_JavaNetHttpURLConnection;
  BufferedInputStream b;
  
  public PubAccountWebViewHttpBridge$BridgeStream(PubAccountWebViewHttpBridge paramPubAccountWebViewHttpBridge, BufferedInputStream paramBufferedInputStream1, BufferedInputStream paramBufferedInputStream2, ByteArrayOutputStream paramByteArrayOutputStream, HttpURLConnection paramHttpURLConnection)
  {
    this.jdField_a_of_type_JavaIoBufferedInputStream = paramBufferedInputStream1;
    this.b = paramBufferedInputStream2;
    if (paramByteArrayOutputStream != null) {}
    for (;;)
    {
      this.jdField_a_of_type_JavaIoByteArrayOutputStream = paramByteArrayOutputStream;
      this.jdField_a_of_type_JavaNetHttpURLConnection = paramHttpURLConnection;
      return;
      paramByteArrayOutputStream = new ByteArrayOutputStream();
    }
  }
  
  public void close()
  {
    if (QLog.isColorLevel()) {
      QLog.i("PubAccountWebViewHttpBridge", 2, "now close memory stream and socket stream!");
    }
    try
    {
      if (this.jdField_a_of_type_JavaIoBufferedInputStream != null)
      {
        this.jdField_a_of_type_JavaIoBufferedInputStream.close();
        this.jdField_a_of_type_JavaIoBufferedInputStream = null;
      }
      if (this.b != null)
      {
        this.b.close();
        this.b = null;
      }
      if (this.jdField_a_of_type_JavaNetHttpURLConnection != null) {
        this.jdField_a_of_type_JavaNetHttpURLConnection.disconnect();
      }
      this.jdField_a_of_type_ComTencentBizWebviewpluginPubAccountWebViewHttpBridge.a = null;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public int read()
  {
    int j;
    if ((this.jdField_a_of_type_JavaIoBufferedInputStream == null) && (this.b == null))
    {
      j = -1;
      return j;
    }
    if (this.jdField_a_of_type_JavaIoBufferedInputStream != null) {}
    for (int i = this.jdField_a_of_type_JavaIoBufferedInputStream.read();; i = -1)
    {
      j = i;
      if (i != -1) {
        break;
      }
      j = i;
      if (this.b == null) {
        break;
      }
      return this.b.read();
    }
  }
  
  public int read(byte[] paramArrayOfByte)
  {
    int i;
    if ((this.jdField_a_of_type_JavaIoBufferedInputStream == null) && (this.b == null))
    {
      i = -1;
      return i;
    }
    if (this.jdField_a_of_type_JavaIoBufferedInputStream != null)
    {
      i = this.jdField_a_of_type_JavaIoBufferedInputStream.read(paramArrayOfByte);
      j = i;
      if (QLog.isColorLevel()) {
        QLog.i("PubAccountWebViewHttpBridge", 2, "now read data from memory buffer second: " + i);
      }
    }
    for (int j = i;; j = -1)
    {
      i = j;
      if (j != -1) {
        break;
      }
      i = j;
      if (this.b == null) {
        break;
      }
      j = this.b.read(paramArrayOfByte);
      i = j;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("PubAccountWebViewHttpBridge", 2, "now read data from socket stream second: " + j);
      return j;
    }
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_JavaIoBufferedInputStream == null) && (this.b == null)) {
      return -1;
    }
    int i = paramArrayOfByte.length;
    if (((paramInt1 | paramInt2) < 0) || (paramInt1 > i) || (i - paramInt1 < paramInt2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PubAccountWebViewHttpBridge", 2, "buffer three, error");
      }
      throw new ArrayIndexOutOfBoundsException();
    }
    int j = 0;
    label65:
    if (j < paramInt2) {}
    for (;;)
    {
      int k;
      try
      {
        if (this.jdField_a_of_type_JavaIoBufferedInputStream == null) {
          break label162;
        }
        i = this.jdField_a_of_type_JavaIoBufferedInputStream.read();
        k = i;
        if (i == -1)
        {
          k = i;
          if (this.b != null) {
            k = this.b.read();
          }
        }
        if (k == -1)
        {
          if (j == 0) {
            break;
          }
          return j;
        }
      }
      catch (IOException paramArrayOfByte)
      {
        if (j != 0) {
          return j;
        }
        throw paramArrayOfByte;
      }
      paramArrayOfByte[(paramInt1 + j)] = ((byte)k);
      j += 1;
      break label65;
      return paramInt2;
      label162:
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.PubAccountWebViewHttpBridge.BridgeStream
 * JD-Core Version:    0.7.0.1
 */