package com.gyailib.library;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SDKModelConfig
{
  public Map<String, String> modelPaths;
  public int modelType;
  public int preferPoints;
  
  public String getModelPaths()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.modelPaths.entrySet().iterator();
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
  
  public int getModel_type()
  {
    return this.modelType;
  }
  
  public int getPrefer_points()
  {
    return this.preferPoints;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.gyailib.library.SDKModelConfig
 * JD-Core Version:    0.7.0.1
 */