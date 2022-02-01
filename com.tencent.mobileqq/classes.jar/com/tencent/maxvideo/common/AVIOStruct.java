package com.tencent.maxvideo.common;

public class AVIOStruct
  implements Cloneable
{
  public int aBitrate;
  public int aChannel;
  public int aFormat;
  public int aSampleRate;
  public int pBlockIndex;
  public int pCodec;
  public int pControlFlag;
  public int pFrameIndex;
  public int vBitrate;
  public int vFPS;
  public int vFormat;
  public long vFrameTime;
  public int vHeight;
  public int vOrientation;
  public int vWidth;
  
  public Object clone()
  {
    try
    {
      AVIOStruct localAVIOStruct = (AVIOStruct)super.clone();
      return localAVIOStruct;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
  
  public boolean isWriteFrame()
  {
    return (this.pControlFlag == ControlFlagEnum.OPEN_FILE_AND_WRITE_FRAME_DATA.getValue()) || (this.pControlFlag == ControlFlagEnum.WRITE_FRAME_DATA.getValue()) || (this.pControlFlag == ControlFlagEnum.WRITE_FRAME_DATA_AND_CLOSE_FILE.getValue());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("AVIOStruct [pBlockIndex=");
    localStringBuilder.append(this.pBlockIndex);
    localStringBuilder.append(", pFrameIndex=");
    localStringBuilder.append(this.pFrameIndex);
    localStringBuilder.append(", pCodec=");
    localStringBuilder.append(this.pCodec);
    localStringBuilder.append(", pControlFlag=");
    localStringBuilder.append(this.pControlFlag);
    localStringBuilder.append(", vWidth=");
    localStringBuilder.append(this.vWidth);
    localStringBuilder.append(", vHeight=");
    localStringBuilder.append(this.vHeight);
    localStringBuilder.append(", vOrientation=");
    localStringBuilder.append(this.vOrientation);
    localStringBuilder.append(", vFPS=");
    localStringBuilder.append(this.vFPS);
    localStringBuilder.append(", vFormat=");
    localStringBuilder.append(this.vFormat);
    localStringBuilder.append(", vBitrate=");
    localStringBuilder.append(this.vBitrate);
    localStringBuilder.append(", aSampleRate=");
    localStringBuilder.append(this.aSampleRate);
    localStringBuilder.append(", aChannel=");
    localStringBuilder.append(this.aChannel);
    localStringBuilder.append(", aFormat=");
    localStringBuilder.append(this.aFormat);
    localStringBuilder.append(", aBitrate=");
    localStringBuilder.append(this.aBitrate);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.maxvideo.common.AVIOStruct
 * JD-Core Version:    0.7.0.1
 */