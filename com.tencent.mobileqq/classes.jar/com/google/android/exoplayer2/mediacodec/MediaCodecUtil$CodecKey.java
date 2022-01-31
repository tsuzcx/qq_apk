package com.google.android.exoplayer2.mediacodec;

import android.text.TextUtils;

final class MediaCodecUtil$CodecKey
{
  public final String mimeType;
  public final boolean secure;
  
  public MediaCodecUtil$CodecKey(String paramString, boolean paramBoolean)
  {
    this.mimeType = paramString;
    this.secure = paramBoolean;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (paramObject.getClass() != CodecKey.class)) {
        return false;
      }
      paramObject = (CodecKey)paramObject;
    } while ((TextUtils.equals(this.mimeType, paramObject.mimeType)) && (this.secure == paramObject.secure));
    return false;
  }
  
  public int hashCode()
  {
    int i;
    if (this.mimeType == null)
    {
      i = 0;
      if (!this.secure) {
        break label41;
      }
    }
    label41:
    for (int j = 1231;; j = 1237)
    {
      return j + (i + 31) * 31;
      i = this.mimeType.hashCode();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.mediacodec.MediaCodecUtil.CodecKey
 * JD-Core Version:    0.7.0.1
 */