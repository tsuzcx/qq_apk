package com.tencent.biz.flatbuffers;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

final class Table$1
  extends ThreadLocal<CharsetDecoder>
{
  protected CharsetDecoder a()
  {
    return Charset.forName("UTF-8").newDecoder();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.flatbuffers.Table.1
 * JD-Core Version:    0.7.0.1
 */