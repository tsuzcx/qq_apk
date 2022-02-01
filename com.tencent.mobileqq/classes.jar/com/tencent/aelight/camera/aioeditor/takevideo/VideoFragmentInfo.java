package com.tencent.aelight.camera.aioeditor.takevideo;

import android.graphics.Bitmap;

public class VideoFragmentInfo
{
  public final int a;
  public final Bitmap a;
  
  public VideoFragmentInfo(int paramInt, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoFragmentInfo{blockIndex=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.VideoFragmentInfo
 * JD-Core Version:    0.7.0.1
 */