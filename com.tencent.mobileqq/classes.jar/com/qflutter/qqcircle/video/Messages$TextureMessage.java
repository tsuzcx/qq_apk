package com.qflutter.qqcircle.video;

import java.util.HashMap;

public class Messages$TextureMessage
{
  private Long textureId;
  
  static TextureMessage fromMap(HashMap paramHashMap)
  {
    TextureMessage localTextureMessage = new TextureMessage();
    paramHashMap = paramHashMap.get("textureId");
    if (paramHashMap == null)
    {
      paramHashMap = null;
      localTextureMessage.textureId = paramHashMap;
      return localTextureMessage;
    }
    if ((paramHashMap instanceof Integer)) {}
    for (long l = ((Integer)paramHashMap).intValue();; l = ((Long)paramHashMap).longValue())
    {
      paramHashMap = Long.valueOf(l);
      break;
    }
  }
  
  public Long getTextureId()
  {
    return this.textureId;
  }
  
  public void setTextureId(Long paramLong)
  {
    this.textureId = paramLong;
  }
  
  HashMap toMap()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("textureId", this.textureId);
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.qqcircle.video.Messages.TextureMessage
 * JD-Core Version:    0.7.0.1
 */