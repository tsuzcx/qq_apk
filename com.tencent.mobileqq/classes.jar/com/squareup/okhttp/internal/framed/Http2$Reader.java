package com.squareup.okhttp.internal.framed;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.BufferedSource;
import okio.ByteString;

final class Http2$Reader
  implements FrameReader
{
  private final boolean client;
  private final Http2.ContinuationSource continuation;
  final Hpack.Reader hpackReader;
  private final BufferedSource source;
  
  Http2$Reader(BufferedSource paramBufferedSource, int paramInt, boolean paramBoolean)
  {
    this.source = paramBufferedSource;
    this.client = paramBoolean;
    this.continuation = new Http2.ContinuationSource(this.source);
    this.hpackReader = new Hpack.Reader(paramInt, this.continuation);
  }
  
  private void readData(FrameReader.Handler paramHandler, int paramInt1, byte paramByte, int paramInt2)
  {
    int i = 1;
    short s = 0;
    boolean bool;
    if ((paramByte & 0x1) != 0)
    {
      bool = true;
      if ((paramByte & 0x20) == 0) {
        break label43;
      }
    }
    for (;;)
    {
      if (i == 0) {
        break label49;
      }
      throw Http2.access$200("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
      bool = false;
      break;
      label43:
      i = 0;
    }
    label49:
    if ((paramByte & 0x8) != 0) {
      s = (short)(this.source.readByte() & 0xFF);
    }
    paramInt1 = Http2.access$400(paramInt1, paramByte, s);
    paramHandler.data(bool, paramInt2, this.source, paramInt1);
    this.source.skip(s);
  }
  
  private void readGoAway(FrameReader.Handler paramHandler, int paramInt1, byte paramByte, int paramInt2)
  {
    if (paramInt1 < 8) {
      throw Http2.access$200("TYPE_GOAWAY length < 8: %s", new Object[] { Integer.valueOf(paramInt1) });
    }
    if (paramInt2 != 0) {
      throw Http2.access$200("TYPE_GOAWAY streamId != 0", new Object[0]);
    }
    paramByte = this.source.readInt();
    paramInt2 = this.source.readInt();
    paramInt1 -= 8;
    ErrorCode localErrorCode = ErrorCode.fromHttp2(paramInt2);
    if (localErrorCode == null) {
      throw Http2.access$200("TYPE_GOAWAY unexpected error code: %d", new Object[] { Integer.valueOf(paramInt2) });
    }
    ByteString localByteString = ByteString.EMPTY;
    if (paramInt1 > 0) {
      localByteString = this.source.readByteString(paramInt1);
    }
    paramHandler.goAway(paramByte, localErrorCode, localByteString);
  }
  
  private List<Header> readHeaderBlock(int paramInt1, short paramShort, byte paramByte, int paramInt2)
  {
    Http2.ContinuationSource localContinuationSource = this.continuation;
    this.continuation.left = paramInt1;
    localContinuationSource.length = paramInt1;
    this.continuation.padding = paramShort;
    this.continuation.flags = paramByte;
    this.continuation.streamId = paramInt2;
    this.hpackReader.readHeaders();
    return this.hpackReader.getAndResetHeaderList();
  }
  
  private void readHeaders(FrameReader.Handler paramHandler, int paramInt1, byte paramByte, int paramInt2)
  {
    if (paramInt2 == 0) {
      throw Http2.access$200("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
    }
    boolean bool;
    if ((paramByte & 0x1) != 0)
    {
      bool = true;
      if ((paramByte & 0x8) == 0) {
        break label108;
      }
    }
    label108:
    for (short s = (short)(this.source.readByte() & 0xFF);; s = 0)
    {
      int i = paramInt1;
      if ((paramByte & 0x20) != 0)
      {
        readPriority(paramHandler, paramInt2);
        i = paramInt1 - 5;
      }
      paramHandler.headers(false, bool, paramInt2, -1, readHeaderBlock(Http2.access$400(i, paramByte, s), s, paramByte, paramInt2), HeadersMode.HTTP_20_HEADERS);
      return;
      bool = false;
      break;
    }
  }
  
  private void readPing(FrameReader.Handler paramHandler, int paramInt1, byte paramByte, int paramInt2)
  {
    boolean bool = true;
    if (paramInt1 != 8) {
      throw Http2.access$200("TYPE_PING length != 8: %s", new Object[] { Integer.valueOf(paramInt1) });
    }
    if (paramInt2 != 0) {
      throw Http2.access$200("TYPE_PING streamId != 0", new Object[0]);
    }
    paramInt1 = this.source.readInt();
    paramInt2 = this.source.readInt();
    if ((paramByte & 0x1) != 0) {}
    for (;;)
    {
      paramHandler.ping(bool, paramInt1, paramInt2);
      return;
      bool = false;
    }
  }
  
  private void readPriority(FrameReader.Handler paramHandler, int paramInt)
  {
    int i = this.source.readInt();
    if ((0x80000000 & i) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramHandler.priority(paramInt, i & 0x7FFFFFFF, (this.source.readByte() & 0xFF) + 1, bool);
      return;
    }
  }
  
  private void readPriority(FrameReader.Handler paramHandler, int paramInt1, byte paramByte, int paramInt2)
  {
    if (paramInt1 != 5) {
      throw Http2.access$200("TYPE_PRIORITY length: %d != 5", new Object[] { Integer.valueOf(paramInt1) });
    }
    if (paramInt2 == 0) {
      throw Http2.access$200("TYPE_PRIORITY streamId == 0", new Object[0]);
    }
    readPriority(paramHandler, paramInt2);
  }
  
  private void readPushPromise(FrameReader.Handler paramHandler, int paramInt1, byte paramByte, int paramInt2)
  {
    short s = 0;
    if (paramInt2 == 0) {
      throw Http2.access$200("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
    }
    if ((paramByte & 0x8) != 0) {
      s = (short)(this.source.readByte() & 0xFF);
    }
    paramHandler.pushPromise(paramInt2, this.source.readInt() & 0x7FFFFFFF, readHeaderBlock(Http2.access$400(paramInt1 - 4, paramByte, s), s, paramByte, paramInt2));
  }
  
  private void readRstStream(FrameReader.Handler paramHandler, int paramInt1, byte paramByte, int paramInt2)
  {
    if (paramInt1 != 4) {
      throw Http2.access$200("TYPE_RST_STREAM length: %d != 4", new Object[] { Integer.valueOf(paramInt1) });
    }
    if (paramInt2 == 0) {
      throw Http2.access$200("TYPE_RST_STREAM streamId == 0", new Object[0]);
    }
    paramInt1 = this.source.readInt();
    ErrorCode localErrorCode = ErrorCode.fromHttp2(paramInt1);
    if (localErrorCode == null) {
      throw Http2.access$200("TYPE_RST_STREAM unexpected error code: %d", new Object[] { Integer.valueOf(paramInt1) });
    }
    paramHandler.rstStream(paramInt2, localErrorCode);
  }
  
  private void readSettings(FrameReader.Handler paramHandler, int paramInt1, byte paramByte, int paramInt2)
  {
    if (paramInt2 != 0) {
      throw Http2.access$200("TYPE_SETTINGS streamId != 0", new Object[0]);
    }
    if ((paramByte & 0x1) != 0)
    {
      if (paramInt1 != 0) {
        throw Http2.access$200("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
      }
      paramHandler.ackSettings();
    }
    Settings localSettings;
    label255:
    do
    {
      return;
      if (paramInt1 % 6 != 0) {
        throw Http2.access$200("TYPE_SETTINGS length %% 6 != 0: %s", new Object[] { Integer.valueOf(paramInt1) });
      }
      localSettings = new Settings();
      paramByte = 0;
      if (paramByte < paramInt1)
      {
        int i = this.source.readShort();
        int j = this.source.readInt();
        paramInt2 = i;
        switch (i)
        {
        default: 
          throw Http2.access$200("PROTOCOL_ERROR invalid settings id: %s", new Object[] { Short.valueOf(i) });
        case 2: 
          paramInt2 = i;
          if (j != 0)
          {
            paramInt2 = i;
            if (j != 1) {
              throw Http2.access$200("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
            }
          }
          break;
        case 3: 
          paramInt2 = 4;
        }
        do
        {
          do
          {
            localSettings.set(paramInt2, 0, j);
            paramByte += 6;
            break;
            paramInt2 = 7;
          } while (j >= 0);
          throw Http2.access$200("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
          if (j < 16384) {
            break label255;
          }
          paramInt2 = i;
        } while (j <= 16777215);
        throw Http2.access$200("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", new Object[] { Integer.valueOf(j) });
      }
      paramHandler.settings(false, localSettings);
    } while (localSettings.getHeaderTableSize() < 0);
    this.hpackReader.headerTableSizeSetting(localSettings.getHeaderTableSize());
  }
  
  private void readWindowUpdate(FrameReader.Handler paramHandler, int paramInt1, byte paramByte, int paramInt2)
  {
    if (paramInt1 != 4) {
      throw Http2.access$200("TYPE_WINDOW_UPDATE length !=4: %s", new Object[] { Integer.valueOf(paramInt1) });
    }
    long l = this.source.readInt() & 0x7FFFFFFF;
    if (l == 0L) {
      throw Http2.access$200("windowSizeIncrement was 0", new Object[] { Long.valueOf(l) });
    }
    paramHandler.windowUpdate(paramInt2, l);
  }
  
  public void close()
  {
    this.source.close();
  }
  
  public boolean nextFrame(FrameReader.Handler paramHandler)
  {
    int i;
    try
    {
      this.source.require(9L);
      i = Http2.access$300(this.source);
      if ((i < 0) || (i > 16384)) {
        throw Http2.access$200("FRAME_SIZE_ERROR: %s", new Object[] { Integer.valueOf(i) });
      }
    }
    catch (IOException paramHandler)
    {
      return false;
    }
    byte b1 = (byte)(this.source.readByte() & 0xFF);
    byte b2 = (byte)(this.source.readByte() & 0xFF);
    int j = this.source.readInt() & 0x7FFFFFFF;
    if (Http2.access$100().isLoggable(Level.FINE)) {
      Http2.access$100().fine(Http2.FrameLogger.formatHeader(true, j, i, b1, b2));
    }
    switch (b1)
    {
    default: 
      this.source.skip(i);
      return true;
    case 0: 
      readData(paramHandler, i, b2, j);
      return true;
    case 1: 
      readHeaders(paramHandler, i, b2, j);
      return true;
    case 2: 
      readPriority(paramHandler, i, b2, j);
      return true;
    case 3: 
      readRstStream(paramHandler, i, b2, j);
      return true;
    case 4: 
      readSettings(paramHandler, i, b2, j);
      return true;
    case 5: 
      readPushPromise(paramHandler, i, b2, j);
      return true;
    case 6: 
      readPing(paramHandler, i, b2, j);
      return true;
    case 7: 
      readGoAway(paramHandler, i, b2, j);
      return true;
    }
    readWindowUpdate(paramHandler, i, b2, j);
    return true;
  }
  
  public void readConnectionPreface()
  {
    if (this.client) {}
    ByteString localByteString;
    do
    {
      return;
      localByteString = this.source.readByteString(Http2.access$000().size());
      if (Http2.access$100().isLoggable(Level.FINE)) {
        Http2.access$100().fine(String.format("<< CONNECTION %s", new Object[] { localByteString.hex() }));
      }
    } while (Http2.access$000().equals(localByteString));
    throw Http2.access$200("Expected a connection header but was %s", new Object[] { localByteString.utf8() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.internal.framed.Http2.Reader
 * JD-Core Version:    0.7.0.1
 */