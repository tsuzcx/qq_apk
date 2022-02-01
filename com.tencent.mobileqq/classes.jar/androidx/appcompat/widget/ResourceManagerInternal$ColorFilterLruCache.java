package androidx.appcompat.widget;

import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import androidx.collection.LruCache;

class ResourceManagerInternal$ColorFilterLruCache
  extends LruCache<Integer, PorterDuffColorFilter>
{
  public ResourceManagerInternal$ColorFilterLruCache(int paramInt)
  {
    super(paramInt);
  }
  
  private static int generateCacheKey(int paramInt, PorterDuff.Mode paramMode)
  {
    return (paramInt + 31) * 31 + paramMode.hashCode();
  }
  
  PorterDuffColorFilter get(int paramInt, PorterDuff.Mode paramMode)
  {
    return (PorterDuffColorFilter)get(Integer.valueOf(generateCacheKey(paramInt, paramMode)));
  }
  
  PorterDuffColorFilter put(int paramInt, PorterDuff.Mode paramMode, PorterDuffColorFilter paramPorterDuffColorFilter)
  {
    return (PorterDuffColorFilter)put(Integer.valueOf(generateCacheKey(paramInt, paramMode)), paramPorterDuffColorFilter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.ResourceManagerInternal.ColorFilterLruCache
 * JD-Core Version:    0.7.0.1
 */