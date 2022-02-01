package com.samskivert.mustache;

import java.lang.reflect.Method;

class DefaultCollector$1
  implements Mustache.VariableFetcher
{
  DefaultCollector$1(DefaultCollector paramDefaultCollector, Method paramMethod) {}
  
  public Object get(Object paramObject, String paramString)
  {
    return this.val$m.invoke(paramObject, new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.samskivert.mustache.DefaultCollector.1
 * JD-Core Version:    0.7.0.1
 */