package com.samskivert.mustache;

public abstract class BasicCollector$ArrayHelper
  implements Mustache.VariableFetcher
{
  protected abstract Object get(Object paramObject, int paramInt);
  
  public Object get(Object paramObject, String paramString)
  {
    try
    {
      paramObject = get(paramObject, Integer.parseInt(paramString));
      return paramObject;
    }
    catch (NumberFormatException paramObject)
    {
      return Template.NO_FETCHER_FOUND;
    }
    catch (ArrayIndexOutOfBoundsException paramObject) {}
    return Template.NO_FETCHER_FOUND;
  }
  
  public abstract int length(Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.samskivert.mustache.BasicCollector.ArrayHelper
 * JD-Core Version:    0.7.0.1
 */