package com.google.android.exoplayer2.ext.hevc;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.OutputBuffer;
import com.google.android.exoplayer2.decoder.SimpleDecoder;
import com.google.android.exoplayer2.drm.ExoMediaCrypto;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

final class HevcDecoder
  extends SimpleDecoder<HevcInputBuffer, HevcOutputBuffer, HevcDecoderException>
{
  private static final int DECODE_ERROR = -1;
  public static final int DECODE_ONLY = 1;
  private static final int DRM_ERROR = -2;
  public static final int GET_FRAME_ERROR = -3;
  private static final int NO_ERROR = 0;
  public static final int OUTPUT_MODE_NONE = -1;
  public static final int OUTPUT_MODE_RGB = 1;
  public static final int OUTPUT_MODE_YUV = 0;
  private final ExoMediaCrypto exoMediaCrypto;
  private final long hvcDecContext;
  private volatile int outputMode;
  
  public HevcDecoder(int paramInt1, int paramInt2, int paramInt3, ExoMediaCrypto paramExoMediaCrypto, Format paramFormat)
  {
    super(new HevcInputBuffer[paramInt1], new HevcOutputBuffer[paramInt2]);
    if (!HevcLibrary.isAvailable()) {
      throw new HevcDecoderException("Failed to load decoder native libraries.");
    }
    this.exoMediaCrypto = paramExoMediaCrypto;
    if ((paramExoMediaCrypto != null) && (!HevcLibrary.hevcIsSecureDecodeSupported())) {
      throw new HevcDecoderException("Hevc decoder does not support secure decode.");
    }
    paramExoMediaCrypto = wrapBytes(paramFormat.initializationData);
    this.hvcDecContext = hevcInit(paramExoMediaCrypto, paramExoMediaCrypto.capacity());
    if (this.hvcDecContext == 0L) {
      throw new HevcDecoderException("Failed to initialize decoder");
    }
    setInitialInputBufferSize(paramInt3);
  }
  
  private native long hevcClose(long paramLong);
  
  private native int hevcDecode(long paramLong1, ByteBuffer paramByteBuffer, int paramInt1, long paramLong2, OutputBuffer paramOutputBuffer, int paramInt2, boolean paramBoolean, String paramString);
  
  private native long hevcInit(ByteBuffer paramByteBuffer, int paramInt);
  
  private ByteBuffer wrapBytes(List<byte[]> paramList)
  {
    Object localObject = paramList.iterator();
    for (int i = 0; ((Iterator)localObject).hasNext(); i = ((byte[])((Iterator)localObject).next()).length + i) {}
    localObject = ByteBuffer.allocateDirect(i);
    byte[] arrayOfByte1 = new byte[i];
    paramList = paramList.iterator();
    byte[] arrayOfByte2;
    for (i = 0; paramList.hasNext(); i = arrayOfByte2.length + i)
    {
      arrayOfByte2 = (byte[])paramList.next();
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, i, arrayOfByte2.length);
    }
    ((ByteBuffer)localObject).put(arrayOfByte1);
    return localObject;
  }
  
  protected HevcInputBuffer createInputBuffer()
  {
    return new HevcInputBuffer();
  }
  
  protected HevcOutputBuffer createOutputBuffer()
  {
    return new HevcOutputBuffer(this);
  }
  
  protected HevcDecoderException createUnexpectedDecodeException(Throwable paramThrowable)
  {
    return new HevcDecoderException("Unexpected decode error", paramThrowable);
  }
  
  protected HevcDecoderException decode(HevcInputBuffer paramHevcInputBuffer, HevcOutputBuffer paramHevcOutputBuffer, boolean paramBoolean)
  {
    if ((paramHevcInputBuffer.isEncrypted()) && (!HevcLibrary.hevcIsSecureDecodeSupported())) {
      return new HevcDecoderException(HevcLibrary.getVersion() + " does not support secure decode.");
    }
    ByteBuffer localByteBuffer = paramHevcInputBuffer.data;
    int i = localByteBuffer.limit();
    long l = hevcDecode(this.hvcDecContext, localByteBuffer, i, paramHevcInputBuffer.timeUs, paramHevcOutputBuffer, this.outputMode, paramBoolean, null);
    if (l == 1L) {
      paramHevcOutputBuffer.addFlag(-2147483648);
    }
    while (l == 0L)
    {
      paramHevcOutputBuffer.colorInfo = paramHevcInputBuffer.colorInfo;
      paramHevcOutputBuffer.mode = this.outputMode;
      return null;
    }
    return new HevcDecoderException("Decode error " + l);
  }
  
  public String getName()
  {
    return "libopenhevc" + HevcLibrary.getVersion();
  }
  
  public void release()
  {
    super.release();
    hevcClose(this.hvcDecContext);
  }
  
  protected void releaseOutputBuffer(HevcOutputBuffer paramHevcOutputBuffer)
  {
    super.releaseOutputBuffer(paramHevcOutputBuffer);
  }
  
  public void setOutputMode(int paramInt)
  {
    this.outputMode = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.ext.hevc.HevcDecoder
 * JD-Core Version:    0.7.0.1
 */