package com.tencent.ilive.opensdk.params;

import com.tencent.ilive.opensdk.coreinterface.ICoreFrame;

public class VFrame
  implements ICoreFrame
{
  public static final int BITMAP_VIDEO_SOURCE = 1;
  public static final int CAMER_VIDEO_SOURCE = 0;
  public boolean bPtu = false;
  public int cameraId = 0;
  public byte[] data = null;
  public int dstHeight = 0;
  public int dstWidth = 0;
  public boolean flip = false;
  public int format = 0;
  public int height = 0;
  public String identifier = "";
  public int mVideoSourceType = 0;
  public int rotate = 0;
  public int width = 0;
  
  public void reset()
  {
    this.cameraId = 0;
    this.data = null;
    this.width = 0;
    this.height = 0;
    this.format = 0;
    this.rotate = 0;
    this.flip = false;
    this.identifier = "";
    this.dstWidth = 0;
    this.dstHeight = 0;
    this.bPtu = false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("VFrame{cameraId=");
    localStringBuilder.append(this.cameraId);
    localStringBuilder.append(", width=");
    localStringBuilder.append(this.width);
    localStringBuilder.append(", height=");
    localStringBuilder.append(this.height);
    localStringBuilder.append(", format=");
    localStringBuilder.append(this.format);
    localStringBuilder.append(", rotate=");
    localStringBuilder.append(this.rotate);
    localStringBuilder.append(", flip=");
    localStringBuilder.append(this.flip);
    localStringBuilder.append(", identifier='");
    localStringBuilder.append(this.identifier);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.opensdk.params.VFrame
 * JD-Core Version:    0.7.0.1
 */