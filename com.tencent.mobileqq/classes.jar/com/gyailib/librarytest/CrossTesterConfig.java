package com.gyailib.librarytest;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CrossTesterConfig
{
  public Map<String, String> configMap;
  
  public String getConfig()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.configMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localStringBuilder.append((String)localEntry.getKey());
      localStringBuilder.append(" ");
      localStringBuilder.append((String)localEntry.getValue());
      localStringBuilder.append(" ");
    }
    return localStringBuilder.toString().trim();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.gyailib.librarytest.CrossTesterConfig
 * JD-Core Version:    0.7.0.1
 */