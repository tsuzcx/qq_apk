package com.qflutter.qqcircle.video;

import java.util.HashMap;

public class Messages$CreateMessage
{
  private byte[] feed;
  private String uri;
  
  static CreateMessage fromMap(HashMap paramHashMap)
  {
    CreateMessage localCreateMessage = new CreateMessage();
    localCreateMessage.uri = ((String)paramHashMap.get("uri"));
    localCreateMessage.feed = ((byte[])paramHashMap.get("feed"));
    return localCreateMessage;
  }
  
  public byte[] getFeed()
  {
    return this.feed;
  }
  
  public String getUri()
  {
    return this.uri;
  }
  
  public void setFeed(byte[] paramArrayOfByte)
  {
    this.feed = paramArrayOfByte;
  }
  
  public void setUri(String paramString)
  {
    this.uri = paramString;
  }
  
  HashMap toMap()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uri", this.uri);
    localHashMap.put("feed", this.feed);
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.qflutter.qqcircle.video.Messages.CreateMessage
 * JD-Core Version:    0.7.0.1
 */