package com.squareup.okhttp.internal.framed;

import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.Util;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import okio.BufferedSink;
import okio.BufferedSource;

public final class Spdy3
  implements Variant
{
  static final byte[] DICTIONARY;
  static final int FLAG_FIN = 1;
  static final int FLAG_UNIDIRECTIONAL = 2;
  static final int TYPE_DATA = 0;
  static final int TYPE_GOAWAY = 7;
  static final int TYPE_HEADERS = 8;
  static final int TYPE_PING = 6;
  static final int TYPE_RST_STREAM = 3;
  static final int TYPE_SETTINGS = 4;
  static final int TYPE_SYN_REPLY = 2;
  static final int TYPE_SYN_STREAM = 1;
  static final int TYPE_WINDOW_UPDATE = 9;
  static final int VERSION = 3;
  
  static
  {
    try
    {
      DICTIONARY = "".getBytes(Util.UTF_8.name());
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new AssertionError();
    }
  }
  
  public Protocol getProtocol()
  {
    return Protocol.SPDY_3;
  }
  
  public FrameReader newReader(BufferedSource paramBufferedSource, boolean paramBoolean)
  {
    return new Spdy3.Reader(paramBufferedSource, paramBoolean);
  }
  
  public FrameWriter newWriter(BufferedSink paramBufferedSink, boolean paramBoolean)
  {
    return new Spdy3.Writer(paramBufferedSink, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.internal.framed.Spdy3
 * JD-Core Version:    0.7.0.1
 */