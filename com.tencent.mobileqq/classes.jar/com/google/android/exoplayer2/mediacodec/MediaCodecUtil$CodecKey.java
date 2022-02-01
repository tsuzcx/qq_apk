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
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (paramObject.getClass() != CodecKey.class) {
        return false;
      }
      paramObject = (CodecKey)paramObject;
      return (TextUtils.equals(this.mimeType, paramObject.mimeType)) && (this.secure == paramObject.secure);
    }
    return false;
  }
  
  public int hashCode()
  {
    String str = this.mimeType;
    int i;
    if (str == null) {
      i = 0;
    } else {
      i = str.hashCode();
    }
    int j;
    if (this.secure) {
      j = 1231;
    } else {
      j = 1237;
    }
    return (i + 31) * 31 + j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.mediacodec.MediaCodecUtil.CodecKey
 * JD-Core Version:    0.7.0.1
 */