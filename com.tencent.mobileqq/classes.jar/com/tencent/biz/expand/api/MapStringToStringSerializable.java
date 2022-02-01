package com.tencent.biz.expand.api;

import java.io.Serializable;
import java.util.Map;

public class MapStringToStringSerializable
  implements Serializable
{
  private Map<String, String> serializable;
  
  public Map<String, String> get()
  {
    return this.serializable;
  }
  
  public void set(Map<String, String> paramMap)
  {
    this.serializable = paramMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.api.MapStringToStringSerializable
 * JD-Core Version:    0.7.0.1
 */