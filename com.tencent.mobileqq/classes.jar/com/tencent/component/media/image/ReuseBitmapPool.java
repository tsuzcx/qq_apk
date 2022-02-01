package com.tencent.component.media.image;

import android.graphics.Bitmap;
import android.util.Log;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.utils.BitmapUtils;
import com.tencent.component.media.utils.ImageManagerLog;
import com.tencent.component.media.utils.LruCache;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class ReuseBitmapPool
{
  public static final String TAG = "NewBucketPool";
  private LruCache<Integer, Bitmap> bitmapItemSetLruCache;
  private TreeMap<Integer, List<Integer>> bitmapKeySet = new TreeMap();
  private int limit;
  private int maxSizePerKey;
  
  public ReuseBitmapPool(int paramInt1, int paramInt2, int paramInt3)
  {
    this.limit = paramInt2;
    this.maxSizePerKey = Math.min(paramInt1, paramInt3);
    paramInt2 = paramInt1;
    if (paramInt1 <= 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ReuseBitmapPool maxSize<=0:");
      localStringBuilder.append(paramInt1);
      ImageManagerLog.w("NewBucketPool", localStringBuilder.toString());
      paramInt2 = 1;
    }
    this.bitmapItemSetLruCache = new ReuseBitmapPool.1(this, paramInt2);
  }
  
  private boolean addIntoPoolInternal(Bitmap paramBitmap)
  {
    int i = BitmapUtils.getBitmapAllocSize(paramBitmap);
    if ((i <= this.limit) && (i > 0))
    {
      if (this.bitmapItemSetLruCache.size() + i > this.bitmapItemSetLruCache.maxSize())
      {
        localObject1 = (Integer)this.bitmapKeySet.ceilingKey(Integer.valueOf(i));
        if (localObject1 != null)
        {
          double d = ((Integer)localObject1).intValue();
          Double.isNaN(d);
          if (d * 0.8D < i)
          {
            ImageManagerEnv.getLogger();
            return false;
          }
        }
      }
      Object localObject2 = (List)this.bitmapKeySet.get(Integer.valueOf(i));
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = Collections.synchronizedList(new LinkedList());
        this.bitmapKeySet.put(Integer.valueOf(i), localObject1);
      }
      if (((List)localObject1).size() * i > this.maxSizePerKey)
      {
        ImageManagerEnv.getLogger();
        return false;
      }
      localObject2 = Integer.valueOf(paramBitmap.hashCode());
      ((List)localObject1).add(localObject2);
      this.bitmapItemSetLruCache.put(localObject2, paramBitmap);
      return true;
    }
    ImageManagerEnv.getLogger();
    return false;
  }
  
  private Bitmap removeFromPoolInternal(Integer paramInteger)
  {
    List localList = (List)this.bitmapKeySet.get(paramInteger);
    Object localObject;
    if ((localList != null) && (!localList.isEmpty()))
    {
      localObject = (Integer)localList.remove(localList.size() - 1);
      localObject = (Bitmap)this.bitmapItemSetLruCache.remove(localObject);
    }
    else
    {
      localObject = null;
    }
    if (localList.isEmpty()) {
      this.bitmapKeySet.remove(paramInteger);
    }
    return localObject;
  }
  
  public boolean addBitMapIntoPool(Bitmap paramBitmap)
  {
    try
    {
      boolean bool = addIntoPoolInternal(paramBitmap);
      return bool;
    }
    finally
    {
      paramBitmap = finally;
      throw paramBitmap;
    }
  }
  
  public Bitmap getBitmapFromPool(int paramInt)
  {
    try
    {
      Object localObject3 = (Integer)this.bitmapKeySet.ceilingKey(Integer.valueOf(paramInt));
      Object localObject1 = null;
      if (localObject3 == null)
      {
        ImageManagerEnv.getLogger();
        return null;
      }
      if (((Integer)localObject3).intValue() > paramInt * 2)
      {
        ImageManagerEnv.getLogger();
        return null;
      }
      try
      {
        localObject3 = removeFromPoolInternal((Integer)localObject3);
        localObject1 = localObject3;
      }
      catch (Throwable localThrowable)
      {
        ImageManagerLog.e("NewBucketPool", Log.getStackTraceString(localThrowable));
      }
      if (localObject1 != null) {
        ImageManagerEnv.getLogger();
      }
      return localObject1;
    }
    finally {}
  }
  
  public void resizeCahce(float paramFloat)
  {
    BitmapUtils.resize(this.bitmapItemSetLruCache, paramFloat);
  }
  
  public void trimToSize(float paramFloat)
  {
    BitmapUtils.trimToSize(this.bitmapItemSetLruCache, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.ReuseBitmapPool
 * JD-Core Version:    0.7.0.1
 */