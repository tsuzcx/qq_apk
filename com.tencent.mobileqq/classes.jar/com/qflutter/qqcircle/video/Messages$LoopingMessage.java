package com.qflutter.qqcircle.video;

import java.util.HashMap;

public class Messages$LoopingMessage
{
  private Boolean isLooping;
  private Long textureId;
  
  static LoopingMessage fromMap(HashMap paramHashMap)
  {
    LoopingMessage localLoopingMessage = new LoopingMessage();
    Object localObject = paramHashMap.get("textureId");
    if (localObject == null)
    {
      localObject = null;
    }
    else
    {
      long l;
      if ((localObject instanceof Integer)) {
        l = ((Integer)localObject).intValue();
      } else {
        l = ((Long)localObject).longValue();
      }
      localObject = Long.valueOf(l);
    }
    localLoopingMessage.textureId = ((Long)localObject);
    localLoopingMessage.isLooping = ((Boolean)paramHashMap.get("isLooping"));
    return localLoopingMessage;
  }
  
  public Boolean getIsLooping()
  {
    return this.isLooping;
  }
  
  public Long getTextureId()
  {
    return this.textureId;
  }
  
  public void setIsLooping(Boolean paramBoolean)
  {
    this.isLooping = paramBoolean;
  }
  
  public void setTextureId(Long paramLong)
  {
    this.textureId = paramLong;
  }
  
  HashMap toMap()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("textureId", this.textureId);
    localHashMap.put("isLooping", this.isLooping);
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.qflutter.qqcircle.video.Messages.LoopingMessage
 * JD-Core Version:    0.7.0.1
 */