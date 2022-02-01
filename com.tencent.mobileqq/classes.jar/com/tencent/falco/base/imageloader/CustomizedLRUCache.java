package com.tencent.falco.base.imageloader;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.nostra13.universalimageloader.cache.memory.impl.LRULimitedMemoryCache;

class CustomizedLRUCache
  extends LRULimitedMemoryCache
{
  public CustomizedLRUCache(int paramInt)
  {
    super(paramInt);
  }
  
  private static int getLargeMemoryClass(ActivityManager paramActivityManager)
  {
    return paramActivityManager.getLargeMemoryClass();
  }
  
  private static boolean hasHoneycomb()
  {
    return Build.VERSION.SDK_INT >= 11;
  }
  
  @TargetApi(11)
  private static boolean isLargeHeap(Context paramContext)
  {
    return (paramContext.getApplicationInfo().flags & 0x100000) != 0;
  }
  
  public Bitmap get(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (paramString.lastIndexOf("_") >= 0) {
      return super.get(paramString.substring(0, paramString.lastIndexOf("_")));
    }
    return super.get(paramString);
  }
  
  public boolean put(String paramString, Bitmap paramBitmap)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (paramString.lastIndexOf("_") >= 0) {
      return super.put(paramString.substring(0, paramString.lastIndexOf("_")), paramBitmap);
    }
    return super.put(paramString, paramBitmap);
  }
  
  public Bitmap remove(String paramString)
  {
    return super.remove(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.imageloader.CustomizedLRUCache
 * JD-Core Version:    0.7.0.1
 */