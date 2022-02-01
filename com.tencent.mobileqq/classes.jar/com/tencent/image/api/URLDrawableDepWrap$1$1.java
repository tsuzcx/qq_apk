package com.tencent.image.api;

import android.util.LruCache;
import android.util.Pair;

class URLDrawableDepWrap$1$1
  extends LruCache<String, Object>
{
  URLDrawableDepWrap$1$1(URLDrawableDepWrap.1 param1, int paramInt)
  {
    super(paramInt);
  }
  
  protected int sizeOf(String paramString, Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof Pair))) {
      return ((Integer)((Pair)paramObject).second).intValue();
    }
    return 100;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.api.URLDrawableDepWrap.1.1
 * JD-Core Version:    0.7.0.1
 */