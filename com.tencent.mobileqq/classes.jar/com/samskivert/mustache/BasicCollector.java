package com.samskivert.mustache;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class BasicCollector
  implements Mustache.Collector
{
  protected static final BasicCollector.ArrayHelper BOOLEAN_ARRAY_HELPER;
  protected static final BasicCollector.ArrayHelper BYTE_ARRAY_HELPER;
  protected static final BasicCollector.ArrayHelper CHAR_ARRAY_HELPER;
  protected static final Mustache.VariableFetcher CUSTOM_FETCHER = new BasicCollector.2();
  protected static final BasicCollector.ArrayHelper DOUBLE_ARRAY_HELPER = new BasicCollector.14();
  protected static final BasicCollector.ArrayHelper FLOAT_ARRAY_HELPER;
  protected static final BasicCollector.ArrayHelper INT_ARRAY_HELPER;
  protected static final Mustache.VariableFetcher ITER_FETCHER;
  protected static final Mustache.VariableFetcher LIST_FETCHER;
  protected static final BasicCollector.ArrayHelper LONG_ARRAY_HELPER;
  protected static final Mustache.VariableFetcher MAP_FETCHER = new BasicCollector.3();
  protected static final BasicCollector.ArrayHelper OBJECT_ARRAY_HELPER;
  protected static final BasicCollector.ArrayHelper SHORT_ARRAY_HELPER;
  
  static
  {
    LIST_FETCHER = new BasicCollector.4();
    ITER_FETCHER = new BasicCollector.5();
    OBJECT_ARRAY_HELPER = new BasicCollector.6();
    BOOLEAN_ARRAY_HELPER = new BasicCollector.7();
    BYTE_ARRAY_HELPER = new BasicCollector.8();
    CHAR_ARRAY_HELPER = new BasicCollector.9();
    SHORT_ARRAY_HELPER = new BasicCollector.10();
    INT_ARRAY_HELPER = new BasicCollector.11();
    LONG_ARRAY_HELPER = new BasicCollector.12();
    FLOAT_ARRAY_HELPER = new BasicCollector.13();
  }
  
  protected static BasicCollector.ArrayHelper arrayHelper(Object paramObject)
  {
    if ((paramObject instanceof Object[])) {
      return OBJECT_ARRAY_HELPER;
    }
    if ((paramObject instanceof boolean[])) {
      return BOOLEAN_ARRAY_HELPER;
    }
    if ((paramObject instanceof byte[])) {
      return BYTE_ARRAY_HELPER;
    }
    if ((paramObject instanceof char[])) {
      return CHAR_ARRAY_HELPER;
    }
    if ((paramObject instanceof short[])) {
      return SHORT_ARRAY_HELPER;
    }
    if ((paramObject instanceof int[])) {
      return INT_ARRAY_HELPER;
    }
    if ((paramObject instanceof long[])) {
      return LONG_ARRAY_HELPER;
    }
    if ((paramObject instanceof float[])) {
      return FLOAT_ARRAY_HELPER;
    }
    if ((paramObject instanceof double[])) {
      return DOUBLE_ARRAY_HELPER;
    }
    return null;
  }
  
  public Mustache.VariableFetcher createFetcher(Object paramObject, String paramString)
  {
    if ((paramObject instanceof Mustache.CustomContext)) {
      return CUSTOM_FETCHER;
    }
    if ((paramObject instanceof Map)) {
      return MAP_FETCHER;
    }
    int i = paramString.charAt(0);
    if ((i >= 48) && (i <= 57))
    {
      if ((paramObject instanceof List)) {
        return LIST_FETCHER;
      }
      if ((paramObject instanceof Iterator)) {
        return ITER_FETCHER;
      }
      if (paramObject.getClass().isArray()) {
        return arrayHelper(paramObject);
      }
    }
    return null;
  }
  
  public abstract <K, V> Map<K, V> createFetcherCache();
  
  public Iterator<?> toIterator(Object paramObject)
  {
    if ((paramObject instanceof Iterable)) {
      return ((Iterable)paramObject).iterator();
    }
    if ((paramObject instanceof Iterator)) {
      return (Iterator)paramObject;
    }
    if (paramObject.getClass().isArray()) {
      return new BasicCollector.1(this, arrayHelper(paramObject), paramObject);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.samskivert.mustache.BasicCollector
 * JD-Core Version:    0.7.0.1
 */