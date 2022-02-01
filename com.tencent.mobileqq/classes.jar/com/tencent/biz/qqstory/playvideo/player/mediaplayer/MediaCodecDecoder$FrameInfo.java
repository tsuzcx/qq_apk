package com.tencent.biz.qqstory.playvideo.player.mediaplayer;

import java.nio.ByteBuffer;

class MediaCodecDecoder$FrameInfo
{
  int a;
  ByteBuffer b;
  long c;
  boolean d;
  boolean e;
  
  public MediaCodecDecoder$FrameInfo()
  {
    a();
  }
  
  public void a()
  {
    this.a = -1;
    this.b = null;
    this.c = -1L;
    this.d = false;
    this.e = false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FrameInfo{buffer=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", data=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", presentationTimeUs=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", endOfStream=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", representationChanged=");
    localStringBuilder.append(this.e);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaCodecDecoder.FrameInfo
 * JD-Core Version:    0.7.0.1
 */