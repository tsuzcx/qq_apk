package com.samskivert.mustache;

import java.util.Map;

final class BasicCollector$3
  implements Mustache.VariableFetcher
{
  public Object get(Object paramObject, String paramString)
  {
    paramObject = (Map)paramObject;
    if (paramObject.containsKey(paramString)) {
      return paramObject.get(paramString);
    }
    if ("entrySet".equals(paramString)) {
      return paramObject.entrySet();
    }
    return Template.NO_FETCHER_FOUND;
  }
  
  public String toString()
  {
    return "MAP_FETCHER";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.samskivert.mustache.BasicCollector.3
 * JD-Core Version:    0.7.0.1
 */