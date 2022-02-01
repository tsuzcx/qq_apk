package com.tencent.component.media.image;

import android.graphics.Bitmap;
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
      ImageManagerLog.w("NewBucketPool", "ReuseBitmapPool maxSize<=0:" + paramInt1);
      paramInt2 = 1;
    }
    this.bitmapItemSetLruCache = new ReuseBitmapPool.1(this, paramInt2);
  }
  
  private boolean addIntoPoolInternal(Bitmap paramBitmap)
  {
    int i = BitmapUtils.getBitmapAllocSize(paramBitmap);
    if ((i > this.limit) || (i <= 0))
    {
      ImageManagerEnv.getLogger();
      return false;
    }
    if (this.bitmapItemSetLruCache.size() + i > this.bitmapItemSetLruCache.maxSize())
    {
      localObject1 = (Integer)this.bitmapKeySet.ceilingKey(Integer.valueOf(i));
      if ((localObject1 != null) && (((Integer)localObject1).intValue() * 0.8D < i))
      {
        ImageManagerEnv.getLogger();
        return false;
      }
    }
    Object localObject2 = (List)this.bitmapKeySet.get(Integer.valueOf(i));
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = Collections.synchronizedList(new LinkedList());
      this.bitmapKeySet.put(Integer.valueOf(i), localObject1);
    }
    if (i * ((List)localObject1).size() > this.maxSizePerKey)
    {
      ImageManagerEnv.getLogger();
      return false;
    }
    localObject2 = Integer.valueOf(paramBitmap.hashCode());
    ((List)localObject1).add(localObject2);
    this.bitmapItemSetLruCache.put(localObject2, paramBitmap);
    return true;
  }
  
  private Bitmap removeFromPoolInternal(Integer paramInteger)
  {
    Object localObject2 = null;
    List localList = (List)this.bitmapKeySet.get(paramInteger);
    Object localObject1 = localObject2;
    if (localList != null)
    {
      localObject1 = localObject2;
      if (!localList.isEmpty())
      {
        localObject1 = (Integer)localList.remove(localList.size() - 1);
        localObject1 = (Bitmap)this.bitmapItemSetLruCache.remove(localObject1);
      }
    }
    if (localList.isEmpty()) {
      this.bitmapKeySet.remove(paramInteger);
    }
    return localObject1;
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
  
  /* Error */
  public Bitmap getBitmapFromPool(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 27	com/tencent/component/media/image/ReuseBitmapPool:bitmapKeySet	Ljava/util/TreeMap;
    //   6: iload_1
    //   7: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   10: invokevirtual 102	java/util/TreeMap:ceilingKey	(Ljava/lang/Object;)Ljava/lang/Object;
    //   13: checkcast 94	java/lang/Integer
    //   16: astore_2
    //   17: aload_2
    //   18: ifnonnull +13 -> 31
    //   21: invokestatic 83	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   24: pop
    //   25: aconst_null
    //   26: astore_2
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_2
    //   30: areturn
    //   31: aload_2
    //   32: invokevirtual 105	java/lang/Integer:intValue	()I
    //   35: iload_1
    //   36: iconst_2
    //   37: imul
    //   38: if_icmple +12 -> 50
    //   41: invokestatic 83	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   44: pop
    //   45: aconst_null
    //   46: astore_2
    //   47: goto -20 -> 27
    //   50: aload_0
    //   51: aload_2
    //   52: invokespecial 158	com/tencent/component/media/image/ReuseBitmapPool:removeFromPoolInternal	(Ljava/lang/Integer;)Landroid/graphics/Bitmap;
    //   55: astore_3
    //   56: aload_3
    //   57: astore_2
    //   58: aload_3
    //   59: ifnull -32 -> 27
    //   62: invokestatic 83	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   65: pop
    //   66: aload_3
    //   67: astore_2
    //   68: goto -41 -> 27
    //   71: astore_2
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_2
    //   75: athrow
    //   76: astore_2
    //   77: ldc 8
    //   79: aload_2
    //   80: invokestatic 164	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   83: invokestatic 167	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: aconst_null
    //   87: astore_3
    //   88: goto -32 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	ReuseBitmapPool
    //   0	91	1	paramInt	int
    //   16	52	2	localObject1	Object
    //   71	4	2	localObject2	Object
    //   76	4	2	localThrowable	java.lang.Throwable
    //   55	33	3	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   2	17	71	finally
    //   21	25	71	finally
    //   31	45	71	finally
    //   50	56	71	finally
    //   62	66	71	finally
    //   77	86	71	finally
    //   50	56	76	java/lang/Throwable
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.media.image.ReuseBitmapPool
 * JD-Core Version:    0.7.0.1
 */