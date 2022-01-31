package com.squareup.okhttp.internal.framed;

import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.util.List;
import java.util.zip.Deflater;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.DeflaterSink;
import okio.Okio;

final class Spdy3$Writer
  implements FrameWriter
{
  private final boolean client;
  private boolean closed;
  private final Buffer headerBlockBuffer;
  private final BufferedSink headerBlockOut;
  private final BufferedSink sink;
  
  Spdy3$Writer(BufferedSink paramBufferedSink, boolean paramBoolean)
  {
    this.sink = paramBufferedSink;
    this.client = paramBoolean;
    paramBufferedSink = new Deflater();
    paramBufferedSink.setDictionary(Spdy3.DICTIONARY);
    this.headerBlockBuffer = new Buffer();
    this.headerBlockOut = Okio.buffer(new DeflaterSink(this.headerBlockBuffer, paramBufferedSink));
  }
  
  private void writeNameValueBlockToBuffer(List<Header> paramList)
  {
    this.headerBlockOut.writeInt(paramList.size());
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      ByteString localByteString = ((Header)paramList.get(i)).name;
      this.headerBlockOut.writeInt(localByteString.size());
      this.headerBlockOut.write(localByteString);
      localByteString = ((Header)paramList.get(i)).value;
      this.headerBlockOut.writeInt(localByteString.size());
      this.headerBlockOut.write(localByteString);
      i += 1;
    }
    this.headerBlockOut.flush();
  }
  
  public void ackSettings(Settings paramSettings) {}
  
  public void close()
  {
    try
    {
      this.closed = true;
      Util.closeAll(this.sink, this.headerBlockOut);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void connectionPreface() {}
  
  public void data(boolean paramBoolean, int paramInt1, Buffer paramBuffer, int paramInt2)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      try
      {
        sendDataFrame(paramInt1, i, paramBuffer, paramInt2);
        return;
      }
      finally {}
    }
  }
  
  public void flush()
  {
    try
    {
      if (this.closed) {
        throw new IOException("closed");
      }
    }
    finally {}
    this.sink.flush();
  }
  
  public void goAway(int paramInt, ErrorCode paramErrorCode, byte[] paramArrayOfByte)
  {
    try
    {
      if (this.closed) {
        throw new IOException("closed");
      }
    }
    finally {}
    if (paramErrorCode.spdyGoAwayCode == -1) {
      throw new IllegalArgumentException("errorCode.spdyGoAwayCode == -1");
    }
    this.sink.writeInt(-2147287033);
    this.sink.writeInt(8);
    this.sink.writeInt(paramInt);
    this.sink.writeInt(paramErrorCode.spdyGoAwayCode);
    this.sink.flush();
  }
  
  public void headers(int paramInt, List<Header> paramList)
  {
    try
    {
      if (this.closed) {
        throw new IOException("closed");
      }
    }
    finally {}
    writeNameValueBlockToBuffer(paramList);
    int i = (int)(this.headerBlockBuffer.size() + 4L);
    this.sink.writeInt(-2147287032);
    this.sink.writeInt(i & 0xFFFFFF | 0x0);
    this.sink.writeInt(0x7FFFFFFF & paramInt);
    this.sink.writeAll(this.headerBlockBuffer);
  }
  
  public int maxDataLength()
  {
    return 16383;
  }
  
  public void ping(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    try
    {
      if (this.closed) {
        throw new IOException("closed");
      }
    }
    finally {}
    boolean bool3 = this.client;
    boolean bool1;
    if ((paramInt1 & 0x1) == 1) {
      bool1 = true;
    }
    for (;;)
    {
      if (paramBoolean != bool1) {
        throw new IllegalArgumentException("payload != reply");
      }
      this.sink.writeInt(-2147287034);
      this.sink.writeInt(4);
      this.sink.writeInt(paramInt1);
      this.sink.flush();
      return;
      for (;;)
      {
        if (bool3 == bool1) {
          break label130;
        }
        bool1 = bool2;
        break;
        bool1 = false;
      }
      label130:
      bool1 = false;
    }
  }
  
  public void pushPromise(int paramInt1, int paramInt2, List<Header> paramList) {}
  
  public void rstStream(int paramInt, ErrorCode paramErrorCode)
  {
    try
    {
      if (this.closed) {
        throw new IOException("closed");
      }
    }
    finally {}
    if (paramErrorCode.spdyRstCode == -1) {
      throw new IllegalArgumentException();
    }
    this.sink.writeInt(-2147287037);
    this.sink.writeInt(8);
    this.sink.writeInt(0x7FFFFFFF & paramInt);
    this.sink.writeInt(paramErrorCode.spdyRstCode);
    this.sink.flush();
  }
  
  void sendDataFrame(int paramInt1, int paramInt2, Buffer paramBuffer, int paramInt3)
  {
    if (this.closed) {
      throw new IOException("closed");
    }
    if (paramInt3 > 16777215L) {
      throw new IllegalArgumentException("FRAME_TOO_LARGE max size is 16Mib: " + paramInt3);
    }
    this.sink.writeInt(0x7FFFFFFF & paramInt1);
    this.sink.writeInt((paramInt2 & 0xFF) << 24 | 0xFFFFFF & paramInt3);
    if (paramInt3 > 0) {
      this.sink.write(paramBuffer, paramInt3);
    }
  }
  
  public void settings(Settings paramSettings)
  {
    try
    {
      if (this.closed) {
        throw new IOException("closed");
      }
    }
    finally {}
    int i = paramSettings.size();
    this.sink.writeInt(-2147287036);
    this.sink.writeInt(i * 8 + 4 & 0xFFFFFF | 0x0);
    this.sink.writeInt(i);
    i = 0;
    for (;;)
    {
      if (i <= 10)
      {
        if (paramSettings.isSet(i))
        {
          int j = paramSettings.flags(i);
          this.sink.writeInt((j & 0xFF) << 24 | i & 0xFFFFFF);
          this.sink.writeInt(paramSettings.get(i));
        }
      }
      else
      {
        this.sink.flush();
        return;
      }
      i += 1;
    }
  }
  
  public void synReply(boolean paramBoolean, int paramInt, List<Header> paramList)
  {
    try
    {
      if (this.closed) {
        throw new IOException("closed");
      }
    }
    finally {}
    writeNameValueBlockToBuffer(paramList);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      int j = (int)(this.headerBlockBuffer.size() + 4L);
      this.sink.writeInt(-2147287038);
      this.sink.writeInt((i & 0xFF) << 24 | j & 0xFFFFFF);
      this.sink.writeInt(0x7FFFFFFF & paramInt);
      this.sink.writeAll(this.headerBlockBuffer);
      this.sink.flush();
      return;
    }
  }
  
  public void synStream(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, List<Header> paramList)
  {
    int j = 0;
    try
    {
      if (this.closed) {
        throw new IOException("closed");
      }
    }
    finally {}
    writeNameValueBlockToBuffer(paramList);
    int k = (int)(10L + this.headerBlockBuffer.size());
    int i;
    if (paramBoolean1) {
      i = 1;
    }
    for (;;)
    {
      this.sink.writeInt(-2147287039);
      this.sink.writeInt(((j | i) & 0xFF) << 24 | k & 0xFFFFFF);
      this.sink.writeInt(paramInt1 & 0x7FFFFFFF);
      this.sink.writeInt(paramInt2 & 0x7FFFFFFF);
      this.sink.writeShort(0);
      this.sink.writeAll(this.headerBlockBuffer);
      this.sink.flush();
      return;
      i = 0;
      if (paramBoolean2) {
        j = 2;
      }
    }
  }
  
  public void windowUpdate(int paramInt, long paramLong)
  {
    try
    {
      if (this.closed) {
        throw new IOException("closed");
      }
    }
    finally {}
    if ((paramLong == 0L) || (paramLong > 2147483647L)) {
      throw new IllegalArgumentException("windowSizeIncrement must be between 1 and 0x7fffffff: " + paramLong);
    }
    this.sink.writeInt(-2147287031);
    this.sink.writeInt(8);
    this.sink.writeInt(paramInt);
    this.sink.writeInt((int)paramLong);
    this.sink.flush();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.internal.framed.Spdy3.Writer
 * JD-Core Version:    0.7.0.1
 */