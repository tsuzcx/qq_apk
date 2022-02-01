package com.tencent.live2;

public class V2TXLiveDef$V2TXLiveMixStream
{
  public int height;
  public V2TXLiveDef.V2TXLiveMixInputType inputType;
  public String streamId;
  public String userId;
  public int width;
  public int x;
  public int y;
  public int zOrder;
  
  public V2TXLiveDef$V2TXLiveMixStream()
  {
    this.userId = "";
    this.x = 0;
    this.y = 0;
    this.width = 0;
    this.height = 0;
    this.zOrder = 0;
    this.inputType = V2TXLiveDef.V2TXLiveMixInputType.V2TXLiveMixInputTypeAudioVideo;
  }
  
  public V2TXLiveDef$V2TXLiveMixStream(V2TXLiveMixStream paramV2TXLiveMixStream)
  {
    this.userId = paramV2TXLiveMixStream.userId;
    this.streamId = paramV2TXLiveMixStream.streamId;
    this.x = paramV2TXLiveMixStream.x;
    this.y = paramV2TXLiveMixStream.y;
    this.width = paramV2TXLiveMixStream.width;
    this.height = paramV2TXLiveMixStream.height;
    this.zOrder = paramV2TXLiveMixStream.zOrder;
    this.inputType = paramV2TXLiveMixStream.inputType;
  }
  
  public V2TXLiveDef$V2TXLiveMixStream(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.userId = paramString;
    this.x = paramInt1;
    this.y = paramInt2;
    this.width = paramInt3;
    this.height = paramInt4;
    this.zOrder = paramInt5;
    this.inputType = V2TXLiveDef.V2TXLiveMixInputType.V2TXLiveMixInputTypeAudioVideo;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[userId='");
    localStringBuilder.append(this.userId);
    localStringBuilder.append('\'');
    localStringBuilder.append("][streamId='");
    localStringBuilder.append(this.streamId);
    localStringBuilder.append('\'');
    localStringBuilder.append("][x=");
    localStringBuilder.append(this.x);
    localStringBuilder.append("][y=");
    localStringBuilder.append(this.y);
    localStringBuilder.append("][width=");
    localStringBuilder.append(this.width);
    localStringBuilder.append("][height=");
    localStringBuilder.append(this.height);
    localStringBuilder.append("][zOrder=");
    localStringBuilder.append(this.zOrder);
    localStringBuilder.append("][inputType=");
    localStringBuilder.append(this.inputType);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.V2TXLiveDef.V2TXLiveMixStream
 * JD-Core Version:    0.7.0.1
 */