package com.tencent.biz.qqstory.playvideo.player.mediaplayer;

import java.nio.ByteBuffer;

class MediaCodecDecoder$FrameInfo
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  ByteBuffer jdField_a_of_type_JavaNioByteBuffer;
  boolean jdField_a_of_type_Boolean;
  boolean b;
  
  public MediaCodecDecoder$FrameInfo()
  {
    a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaNioByteBuffer = null;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_Boolean = false;
    this.b = false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FrameInfo{buffer=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", data=");
    localStringBuilder.append(this.jdField_a_of_type_JavaNioByteBuffer);
    localStringBuilder.append(", presentationTimeUs=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", endOfStream=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", representationChanged=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaCodecDecoder.FrameInfo
 * JD-Core Version:    0.7.0.1
 */