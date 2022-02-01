package com.samskivert.mustache;

final class BasicCollector$2
  implements Mustache.VariableFetcher
{
  public Object get(Object paramObject, String paramString)
  {
    paramString = ((Mustache.CustomContext)paramObject).get(paramString);
    paramObject = paramString;
    if (paramString == null) {
      paramObject = Template.NO_FETCHER_FOUND;
    }
    return paramObject;
  }
  
  public String toString()
  {
    return "CUSTOM_FETCHER";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.samskivert.mustache.BasicCollector.2
 * JD-Core Version:    0.7.0.1
 */