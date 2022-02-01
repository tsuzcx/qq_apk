package com.google.android.exoplayer2.ext.mediaplayer;

public class DecoderInfo
{
  public static final int TYPE_AUDIO = 1;
  public static final int TYPE_UNKNOWN = -1;
  public static final int TYPE_VIDEO = 0;
  public String decoderName = "";
  public int decoderType = -1;
  public long initializationDurationMs = 0L;
  
  DecoderInfo(int paramInt, String paramString, long paramLong)
  {
    this.decoderType = paramInt;
    this.decoderName = paramString;
    this.initializationDurationMs = paramLong;
  }
  
  private String type2Str(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "unknown";
    case 1: 
      return "adec";
    }
    return "vdec";
  }
  
  public String toString()
  {
    return type2Str(this.decoderType) + ": " + this.decoderName + "," + this.initializationDurationMs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.ext.mediaplayer.DecoderInfo
 * JD-Core Version:    0.7.0.1
 */