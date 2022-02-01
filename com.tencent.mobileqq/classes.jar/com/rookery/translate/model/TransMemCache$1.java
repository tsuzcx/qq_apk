package com.rookery.translate.model;

import android.support.v4.util.LruCache;

class TransMemCache$1
  extends LruCache<String, String>
{
  TransMemCache$1(TransMemCache paramTransMemCache, int paramInt)
  {
    super(paramInt);
  }
  
  protected int a(String paramString1, String paramString2)
  {
    return paramString2.length() + 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.rookery.translate.model.TransMemCache.1
 * JD-Core Version:    0.7.0.1
 */