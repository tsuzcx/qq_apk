package com.samskivert.mustache;

import java.lang.reflect.Method;

class DefaultCollector$3
  implements Mustache.VariableFetcher
{
  DefaultCollector$3(DefaultCollector paramDefaultCollector, Method paramMethod) {}
  
  public Object get(Object paramObject, String paramString)
  {
    return this.val$im.invoke(paramObject, new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.samskivert.mustache.DefaultCollector.3
 * JD-Core Version:    0.7.0.1
 */