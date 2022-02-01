package com.qflutter.qqcircle.video;

import java.util.HashMap;

public class Messages$PlaybackSpeedMessage
{
  private Double speed;
  private Long textureId;
  
  static PlaybackSpeedMessage fromMap(HashMap paramHashMap)
  {
    PlaybackSpeedMessage localPlaybackSpeedMessage = new PlaybackSpeedMessage();
    Object localObject = paramHashMap.get("textureId");
    if (localObject == null)
    {
      localObject = null;
      localPlaybackSpeedMessage.textureId = ((Long)localObject);
      localPlaybackSpeedMessage.speed = ((Double)paramHashMap.get("speed"));
      return localPlaybackSpeedMessage;
    }
    if ((localObject instanceof Integer)) {}
    for (long l = ((Integer)localObject).intValue();; l = ((Long)localObject).longValue())
    {
      localObject = Long.valueOf(l);
      break;
    }
  }
  
  public Double getSpeed()
  {
    return this.speed;
  }
  
  public Long getTextureId()
  {
    return this.textureId;
  }
  
  public void setSpeed(Double paramDouble)
  {
    this.speed = paramDouble;
  }
  
  public void setTextureId(Long paramLong)
  {
    this.textureId = paramLong;
  }
  
  HashMap toMap()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("textureId", this.textureId);
    localHashMap.put("speed", this.speed);
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.qqcircle.video.Messages.PlaybackSpeedMessage
 * JD-Core Version:    0.7.0.1
 */