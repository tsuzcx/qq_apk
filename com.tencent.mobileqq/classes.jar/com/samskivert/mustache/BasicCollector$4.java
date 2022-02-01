package com.samskivert.mustache;

import java.util.List;

final class BasicCollector$4
  implements Mustache.VariableFetcher
{
  public Object get(Object paramObject, String paramString)
  {
    try
    {
      paramObject = ((List)paramObject).get(Integer.parseInt(paramString));
      return paramObject;
    }
    catch (NumberFormatException paramObject)
    {
      return Template.NO_FETCHER_FOUND;
    }
    catch (IndexOutOfBoundsException paramObject) {}
    return Template.NO_FETCHER_FOUND;
  }
  
  public String toString()
  {
    return "LIST_FETCHER";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.samskivert.mustache.BasicCollector.4
 * JD-Core Version:    0.7.0.1
 */