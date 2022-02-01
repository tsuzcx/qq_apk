package com.tencent.liteav.basic.structs;

import android.media.MediaCodec.BufferInfo;
import java.nio.ByteBuffer;

public class TXSNALPacket
{
  public long arrivalTimeMs = 0L;
  public ByteBuffer buffer = null;
  public int codecId = 0;
  public long dts = 0L;
  public long frameIndex = 0L;
  public long gopFrameIndex = 0L;
  public long gopIndex = 0L;
  public MediaCodec.BufferInfo info = null;
  public byte[] nalData = null;
  public int nalType = -1;
  public long pts = 0L;
  public long refFremeIndex = 0L;
  public int rotation = 0;
  public long sequenceNum = 0L;
  public int streamType = 2;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.basic.structs.TXSNALPacket
 * JD-Core Version:    0.7.0.1
 */