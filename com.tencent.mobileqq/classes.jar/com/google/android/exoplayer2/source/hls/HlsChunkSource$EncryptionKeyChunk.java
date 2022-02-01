package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.chunk.DataChunk;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import java.util.Arrays;

final class HlsChunkSource$EncryptionKeyChunk
  extends DataChunk
{
  public final String iv;
  private byte[] result;
  
  public HlsChunkSource$EncryptionKeyChunk(DataSource paramDataSource, DataSpec paramDataSpec, Format paramFormat, int paramInt, Object paramObject, byte[] paramArrayOfByte, String paramString)
  {
    super(paramDataSource, paramDataSpec, 3, paramFormat, paramInt, paramObject, paramArrayOfByte);
    this.iv = paramString;
  }
  
  public void consume(byte[] paramArrayOfByte, int paramInt)
  {
    this.result = Arrays.copyOf(paramArrayOfByte, paramInt);
  }
  
  public byte[] getResult()
  {
    return this.result;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.source.hls.HlsChunkSource.EncryptionKeyChunk
 * JD-Core Version:    0.7.0.1
 */