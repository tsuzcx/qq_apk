package com.qflutter.qqcircle.video;

import java.util.HashMap;

public class Messages$PositionMessage
{
  private Long position;
  private Long textureId;
  
  static PositionMessage fromMap(HashMap paramHashMap)
  {
    PositionMessage localPositionMessage = new PositionMessage();
    Object localObject1 = paramHashMap.get("textureId");
    Object localObject2 = null;
    long l;
    if (localObject1 == null)
    {
      localObject1 = null;
    }
    else
    {
      if ((localObject1 instanceof Integer)) {
        l = ((Integer)localObject1).intValue();
      } else {
        l = ((Long)localObject1).longValue();
      }
      localObject1 = Long.valueOf(l);
    }
    localPositionMessage.textureId = ((Long)localObject1);
    paramHashMap = paramHashMap.get("position");
    if (paramHashMap == null)
    {
      paramHashMap = localObject2;
    }
    else
    {
      if ((paramHashMap instanceof Integer)) {
        l = ((Integer)paramHashMap).intValue();
      } else {
        l = ((Long)paramHashMap).longValue();
      }
      paramHashMap = Long.valueOf(l);
    }
    localPositionMessage.position = paramHashMap;
    return localPositionMessage;
  }
  
  public Long getPosition()
  {
    return this.position;
  }
  
  public Long getTextureId()
  {
    return this.textureId;
  }
  
  public void setPosition(Long paramLong)
  {
    this.position = paramLong;
  }
  
  public void setTextureId(Long paramLong)
  {
    this.textureId = paramLong;
  }
  
  HashMap toMap()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("textureId", this.textureId);
    localHashMap.put("position", this.position);
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.qflutter.qqcircle.video.Messages.PositionMessage
 * JD-Core Version:    0.7.0.1
 */