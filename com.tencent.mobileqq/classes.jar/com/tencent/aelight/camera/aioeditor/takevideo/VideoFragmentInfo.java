package com.tencent.aelight.camera.aioeditor.takevideo;

import android.graphics.Bitmap;

public class VideoFragmentInfo
{
  public final int d;
  public final Bitmap e;
  
  public VideoFragmentInfo(int paramInt, Bitmap paramBitmap)
  {
    this.d = paramInt;
    this.e = paramBitmap;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoFragmentInfo{blockIndex=");
    localStringBuilder.append(this.d);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.VideoFragmentInfo
 * JD-Core Version:    0.7.0.1
 */