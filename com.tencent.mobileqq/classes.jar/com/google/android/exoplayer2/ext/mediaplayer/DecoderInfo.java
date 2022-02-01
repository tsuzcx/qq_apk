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
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return "unknown";
      }
      return "adec";
    }
    return "vdec";
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(type2Str(this.decoderType));
    localStringBuilder.append(": ");
    localStringBuilder.append(this.decoderName);
    localStringBuilder.append(",");
    localStringBuilder.append(this.initializationDurationMs);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.ext.mediaplayer.DecoderInfo
 * JD-Core Version:    0.7.0.1
 */