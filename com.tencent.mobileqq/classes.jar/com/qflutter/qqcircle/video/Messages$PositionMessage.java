package com.qflutter.qqcircle.video;

import java.util.HashMap;

public class Messages$PositionMessage
{
  private Long position;
  private Long textureId;
  
  static PositionMessage fromMap(HashMap paramHashMap)
  {
    Object localObject2 = null;
    PositionMessage localPositionMessage = new PositionMessage();
    Object localObject1 = paramHashMap.get("textureId");
    if (localObject1 == null)
    {
      localObject1 = null;
      localPositionMessage.textureId = ((Long)localObject1);
      paramHashMap = paramHashMap.get("position");
      if (paramHashMap == null)
      {
        paramHashMap = localObject2;
        localPositionMessage.position = paramHashMap;
        return localPositionMessage;
      }
    }
    else
    {
      if ((localObject1 instanceof Integer)) {}
      for (l = ((Integer)localObject1).intValue();; l = ((Long)localObject1).longValue())
      {
        localObject1 = Long.valueOf(l);
        break;
      }
    }
    if ((paramHashMap instanceof Integer)) {}
    for (long l = ((Integer)paramHashMap).intValue();; l = ((Long)paramHashMap).longValue())
    {
      paramHashMap = Long.valueOf(l);
      break;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.qqcircle.video.Messages.PositionMessage
 * JD-Core Version:    0.7.0.1
 */