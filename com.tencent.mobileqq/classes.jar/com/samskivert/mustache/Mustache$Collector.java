package com.samskivert.mustache;

import java.util.Iterator;
import java.util.Map;

public abstract interface Mustache$Collector
{
  public abstract Mustache.VariableFetcher createFetcher(Object paramObject, String paramString);
  
  public abstract <K, V> Map<K, V> createFetcherCache();
  
  public abstract Iterator<?> toIterator(Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.samskivert.mustache.Mustache.Collector
 * JD-Core Version:    0.7.0.1
 */