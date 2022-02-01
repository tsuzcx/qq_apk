package com.gyailib.library;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SDKModelConfig
{
  public Map<String, String> model_paths;
  private int model_type;
  private int prefer_points;
  
  public String getModelPaths()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.model_paths.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localStringBuilder.append((String)localEntry.getKey()).append(" ").append((String)localEntry.getValue()).append(" ");
    }
    return localStringBuilder.toString().trim();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.gyailib.library.SDKModelConfig
 * JD-Core Version:    0.7.0.1
 */