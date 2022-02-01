package com.qflutter.qqcircle.video;

import java.util.HashMap;

public class Messages$VolumeMessage
{
  private Long textureId;
  private Double volume;
  
  static VolumeMessage fromMap(HashMap paramHashMap)
  {
    VolumeMessage localVolumeMessage = new VolumeMessage();
    Object localObject = paramHashMap.get("textureId");
    if (localObject == null)
    {
      localObject = null;
      localVolumeMessage.textureId = ((Long)localObject);
      localVolumeMessage.volume = ((Double)paramHashMap.get("volume"));
      return localVolumeMessage;
    }
    if ((localObject instanceof Integer)) {}
    for (long l = ((Integer)localObject).intValue();; l = ((Long)localObject).longValue())
    {
      localObject = Long.valueOf(l);
      break;
    }
  }
  
  public Long getTextureId()
  {
    return this.textureId;
  }
  
  public Double getVolume()
  {
    return this.volume;
  }
  
  public void setTextureId(Long paramLong)
  {
    this.textureId = paramLong;
  }
  
  public void setVolume(Double paramDouble)
  {
    this.volume = paramDouble;
  }
  
  HashMap toMap()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("textureId", this.textureId);
    localHashMap.put("volume", this.volume);
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.qqcircle.video.Messages.VolumeMessage
 * JD-Core Version:    0.7.0.1
 */