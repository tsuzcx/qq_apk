package com.google.android.exoplayer2.ext.vp9;

import com.google.android.exoplayer2.decoder.CryptoInfo;
import com.google.android.exoplayer2.decoder.SimpleDecoder;
import com.google.android.exoplayer2.drm.DecryptionException;
import com.google.android.exoplayer2.drm.ExoMediaCrypto;
import java.nio.ByteBuffer;

final class VpxDecoder
  extends SimpleDecoder<VpxInputBuffer, VpxOutputBuffer, VpxDecoderException>
{
  private static final int DECODE_ERROR = 1;
  private static final int DRM_ERROR = 2;
  private static final int NO_ERROR = 0;
  public static final int OUTPUT_MODE_NONE = -1;
  public static final int OUTPUT_MODE_RGB = 1;
  public static final int OUTPUT_MODE_YUV = 0;
  private final ExoMediaCrypto exoMediaCrypto;
  private volatile int outputMode;
  private final long vpxDecContext;
  
  public VpxDecoder(int paramInt1, int paramInt2, int paramInt3, ExoMediaCrypto paramExoMediaCrypto, boolean paramBoolean)
  {
    super(new VpxInputBuffer[paramInt1], new VpxOutputBuffer[paramInt2]);
    if (!VpxLibrary.isAvailable()) {
      throw new VpxDecoderException("Failed to load decoder native libraries.");
    }
    this.exoMediaCrypto = paramExoMediaCrypto;
    if ((paramExoMediaCrypto != null) && (!VpxLibrary.vpxIsSecureDecodeSupported())) {
      throw new VpxDecoderException("Vpx decoder does not support secure decode.");
    }
    this.vpxDecContext = vpxInit(paramBoolean);
    if (this.vpxDecContext == 0L) {
      throw new VpxDecoderException("Failed to initialize decoder");
    }
    setInitialInputBufferSize(paramInt3);
  }
  
  private native long vpxClose(long paramLong);
  
  private native long vpxDecode(long paramLong, ByteBuffer paramByteBuffer, int paramInt);
  
  private native int vpxGetErrorCode(long paramLong);
  
  private native String vpxGetErrorMessage(long paramLong);
  
  private native int vpxGetFrame(long paramLong, VpxOutputBuffer paramVpxOutputBuffer);
  
  private native long vpxInit(boolean paramBoolean);
  
  private native long vpxSecureDecode(long paramLong, ByteBuffer paramByteBuffer, int paramInt1, ExoMediaCrypto paramExoMediaCrypto, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt3, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
  
  protected VpxInputBuffer createInputBuffer()
  {
    return new VpxInputBuffer();
  }
  
  protected VpxOutputBuffer createOutputBuffer()
  {
    return new VpxOutputBuffer(this);
  }
  
  protected VpxDecoderException createUnexpectedDecodeException(Throwable paramThrowable)
  {
    return new VpxDecoderException("Unexpected decode error", paramThrowable);
  }
  
  protected VpxDecoderException decode(VpxInputBuffer paramVpxInputBuffer, VpxOutputBuffer paramVpxOutputBuffer, boolean paramBoolean)
  {
    ByteBuffer localByteBuffer = paramVpxInputBuffer.data;
    int i = localByteBuffer.limit();
    CryptoInfo localCryptoInfo = paramVpxInputBuffer.cryptoInfo;
    long l;
    if (paramVpxInputBuffer.isEncrypted()) {
      l = vpxSecureDecode(this.vpxDecContext, localByteBuffer, i, this.exoMediaCrypto, localCryptoInfo.mode, localCryptoInfo.key, localCryptoInfo.iv, localCryptoInfo.numSubSamples, localCryptoInfo.numBytesOfClearData, localCryptoInfo.numBytesOfEncryptedData);
    }
    while (l != 0L) {
      if (l == 2L)
      {
        paramVpxInputBuffer = "Drm error: " + vpxGetErrorMessage(this.vpxDecContext);
        return new VpxDecoderException(paramVpxInputBuffer, new DecryptionException(vpxGetErrorCode(this.vpxDecContext), paramVpxInputBuffer));
        l = vpxDecode(this.vpxDecContext, localByteBuffer, i);
      }
      else
      {
        return new VpxDecoderException("Decode error: " + vpxGetErrorMessage(this.vpxDecContext));
      }
    }
    if (!paramVpxInputBuffer.isDecodeOnly())
    {
      paramVpxOutputBuffer.init(paramVpxInputBuffer.timeUs, this.outputMode);
      i = vpxGetFrame(this.vpxDecContext, paramVpxOutputBuffer);
      if (i != 1) {
        break label245;
      }
      paramVpxOutputBuffer.addFlag(-2147483648);
    }
    label245:
    while (i != -1)
    {
      paramVpxOutputBuffer.colorInfo = paramVpxInputBuffer.colorInfo;
      return null;
    }
    return new VpxDecoderException("Buffer initialization failed.");
  }
  
  public String getName()
  {
    return "libvpx" + VpxLibrary.getVersion();
  }
  
  public void release()
  {
    super.release();
    vpxClose(this.vpxDecContext);
  }
  
  protected void releaseOutputBuffer(VpxOutputBuffer paramVpxOutputBuffer)
  {
    super.releaseOutputBuffer(paramVpxOutputBuffer);
  }
  
  public void setOutputMode(int paramInt)
  {
    this.outputMode = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.ext.vp9.VpxDecoder
 * JD-Core Version:    0.7.0.1
 */