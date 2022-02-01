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
    }
    else
    {
      long l;
      if ((paramHashMap instanceof Integer)) {
        l = ((Integer)paramHashMap).intValue();
      } else {
        l = ((Long)paramHashMap).longValue();
      }
      paramHashMap = Long.valueOf(l);
    }
    localTextureMessage.textureId = paramHashMap;
    return localTextureMessage;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.qflutter.qqcircle.video.Messages.TextureMessage
 * JD-Core Version:    0.7.0.1
 */