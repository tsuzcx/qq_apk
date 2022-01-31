package com.google.android.exoplayer2.mediacodec;

import android.annotation.TargetApi;
import android.media.MediaCodec.CodecException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Util;

public class MediaCodecRenderer$DecoderInitializationException
  extends Exception
{
  private static final int CUSTOM_ERROR_CODE_BASE = -50000;
  private static final int DECODER_QUERY_ERROR = -49998;
  private static final int NO_SUITABLE_DECODER_ERROR = -49999;
  public final String decoderName;
  public final String diagnosticInfo;
  public final String mimeType;
  public final boolean secureDecoderRequired;
  
  public MediaCodecRenderer$DecoderInitializationException(Format paramFormat, Throwable paramThrowable, boolean paramBoolean, int paramInt)
  {
    super("Decoder init failed: [" + paramInt + "], " + paramFormat, paramThrowable);
    this.mimeType = paramFormat.sampleMimeType;
    this.secureDecoderRequired = paramBoolean;
    this.decoderName = null;
    this.diagnosticInfo = buildCustomDiagnosticInfo(paramInt);
  }
  
  public MediaCodecRenderer$DecoderInitializationException(Format paramFormat, Throwable paramThrowable, boolean paramBoolean, String paramString)
  {
    super("Decoder init failed: " + paramString + ", " + paramFormat, paramThrowable);
    this.mimeType = paramFormat.sampleMimeType;
    this.secureDecoderRequired = paramBoolean;
    this.decoderName = paramString;
    if (Util.SDK_INT >= 21) {}
    for (paramFormat = getDiagnosticInfoV21(paramThrowable);; paramFormat = null)
    {
      this.diagnosticInfo = paramFormat;
      return;
    }
  }
  
  private static String buildCustomDiagnosticInfo(int paramInt)
  {
    if (paramInt < 0) {}
    for (String str = "neg_";; str = "") {
      return "com.google.android.exoplayer.MediaCodecTrackRenderer_" + str + Math.abs(paramInt);
    }
  }
  
  @TargetApi(21)
  private static String getDiagnosticInfoV21(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof MediaCodec.CodecException)) {
      return ((MediaCodec.CodecException)paramThrowable).getDiagnosticInfo();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.DecoderInitializationException
 * JD-Core Version:    0.7.0.1
 */