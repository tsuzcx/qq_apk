package com.tencent.maxvideo.watermark;

import android.text.TextUtils;
import java.io.Serializable;

public class WatermarkInfo
  implements Serializable
{
  public static final String BG_MUSIC = "bg.mp3";
  public static final int TYPE_DYNAMIC_WATERMARK = 2;
  public static final int TYPE_NONE_WATERMARK = 0;
  public static final int TYPE_STATIC_WATERMARK = 1;
  private static final long serialVersionUID = 1L;
  public String mBgMusicPath;
  public String mDesc;
  public String mDir;
  public int mId;
  public String mJsonFilePath;
  public int mType;
  public int mYellowFlag;
  
  public WatermarkInfo() {}
  
  public WatermarkInfo(int paramInt)
  {
    this.mType = paramInt;
  }
  
  public boolean hasBGMusic()
  {
    return !TextUtils.isEmpty(this.mBgMusicPath);
  }
  
  public boolean isYellow()
  {
    return this.mYellowFlag > 0;
  }
  
  public String toJson()
  {
    return "{\"materialPath\":\"" + this.mJsonFilePath + "\",\"materialDirPath\":\"" + this.mDir + "\"}";
  }
  
  public String toString()
  {
    return "WatermarkInfo [mType=" + this.mType + ", mDir=" + this.mDir + ", mJsonFilePath=" + this.mJsonFilePath + ", mDesc=" + this.mDesc + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.maxvideo.watermark.WatermarkInfo
 * JD-Core Version:    0.7.0.1
 */