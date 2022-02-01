package com.samskivert.mustache;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class BasicCollector$5
  implements Mustache.VariableFetcher
{
  public Object get(Object paramObject, String paramString)
  {
    try
    {
      paramObject = (Iterator)paramObject;
      int i = 0;
      int j = Integer.parseInt(paramString);
      while (i < j)
      {
        paramObject.next();
        i += 1;
      }
      paramObject = paramObject.next();
      return paramObject;
    }
    catch (NumberFormatException paramObject)
    {
      break label46;
    }
    catch (NoSuchElementException paramObject)
    {
      label42:
      label46:
      break label42;
    }
    return Template.NO_FETCHER_FOUND;
    return Template.NO_FETCHER_FOUND;
  }
  
  public String toString()
  {
    return "ITER_FETCHER";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.samskivert.mustache.BasicCollector.5
 * JD-Core Version:    0.7.0.1
 */