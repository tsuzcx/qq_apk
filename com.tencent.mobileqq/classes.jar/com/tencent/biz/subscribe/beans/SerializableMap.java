package com.tencent.biz.subscribe.beans;

import java.io.Serializable;
import java.util.Map;

public class SerializableMap
  implements Serializable
{
  private Map<String, String> map;
  
  public Map<String, String> getMap()
  {
    return this.map;
  }
  
  public void setMap(Map<String, String> paramMap)
  {
    this.map = paramMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.beans.SerializableMap
 * JD-Core Version:    0.7.0.1
 */