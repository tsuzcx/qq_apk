package com.tencent.hippy.qq.utils;

import java.io.Serializable;
import java.util.HashMap;

public class SerializableMap
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private HashMap mHashMap;
  
  public HashMap getMap()
  {
    return this.mHashMap;
  }
  
  public void wrapMap(HashMap paramHashMap)
  {
    this.mHashMap = paramHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.utils.SerializableMap
 * JD-Core Version:    0.7.0.1
 */