package com.tencent.map.sdk.a;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

final class ce
  extends LinkedHashMap<String, String>
{
  ce()
  {
    super(8, 1.0F, true);
  }
  
  protected final boolean removeEldestEntry(Map.Entry<String, String> paramEntry)
  {
    return size() > 8;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.sdk.a.ce
 * JD-Core Version:    0.7.0.1
 */