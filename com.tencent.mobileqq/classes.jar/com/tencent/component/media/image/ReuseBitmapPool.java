package com.tencent.component.media.image;

import android.graphics.Bitmap;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.utils.BitmapUtils;
import com.tencent.component.media.utils.ImageManagerLog;
import com.tencent.component.media.utils.LruCache;
import java.util.LinkedList;
import java.util.TreeMap;
import pfs;

public class ReuseBitmapPool
{
  public static final String TAG = "NewBucketPool";
  private int jdField_a_of_type_Int;
  private LruCache jdField_a_of_type_ComTencentComponentMediaUtilsLruCache;
  private TreeMap jdField_a_of_type_JavaUtilTreeMap = new TreeMap();
  private int b;
  
  public ReuseBitmapPool(int paramInt1, int paramInt2, int paramInt3)
  {
    this.b = paramInt2;
    this.jdField_a_of_type_Int = Math.min(paramInt1, paramInt3);
    paramInt2 = paramInt1;
    if (paramInt1 <= 0)
    {
      ImageManagerLog.w("NewBucketPool", "ReuseBitmapPool maxSize<=0:" + paramInt1);
      paramInt2 = 1;
    }
    this.jdField_a_of_type_ComTencentComponentMediaUtilsLruCache = new pfs(this, paramInt2);
  }
  
  private Bitmap a(Integer paramInteger)
  {
    Object localObject2 = null;
    LinkedList localLinkedList = (LinkedList)this.jdField_a_of_type_JavaUtilTreeMap.get(paramInteger);
    Object localObject1 = localObject2;
    if (localLinkedList != null)
    {
      localObject1 = localObject2;
      if (!localLinkedList.isEmpty()) {
        localObject1 = (Bitmap)this.jdField_a_of_type_ComTencentComponentMediaUtilsLruCache.remove(localLinkedList.poll());
      }
    }
    if (localLinkedList.isEmpty()) {
      this.jdField_a_of_type_JavaUtilTreeMap.remove(paramInteger);
    }
    return localObject1;
  }
  
  private boolean a(Bitmap paramBitmap)
  {
    int i = BitmapUtils.getBitmapAllocSize(paramBitmap);
    if ((i > this.b) || (i <= 0))
    {
      ImageManagerEnv.getLogger();
      return false;
    }
    if (this.jdField_a_of_type_ComTencentComponentMediaUtilsLruCache.size() + i > this.jdField_a_of_type_ComTencentComponentMediaUtilsLruCache.maxSize())
    {
      localObject1 = (Integer)this.jdField_a_of_type_JavaUtilTreeMap.ceilingKey(Integer.valueOf(i));
      if ((localObject1 != null) && (((Integer)localObject1).intValue() * 0.8D < i))
      {
        ImageManagerEnv.getLogger();
        return false;
      }
    }
    Object localObject2 = (LinkedList)this.jdField_a_of_type_JavaUtilTreeMap.get(Integer.valueOf(i));
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new LinkedList();
      this.jdField_a_of_type_JavaUtilTreeMap.put(Integer.valueOf(i), localObject1);
    }
    if (i * ((LinkedList)localObject1).size() > this.jdField_a_of_type_Int)
    {
      ImageManagerEnv.getLogger();
      return false;
    }
    localObject2 = Integer.valueOf(paramBitmap.hashCode());
    ((LinkedList)localObject1).add(localObject2);
    this.jdField_a_of_type_ComTencentComponentMediaUtilsLruCache.put(localObject2, paramBitmap);
    return true;
  }
  
  public boolean addBitMapIntoPool(Bitmap paramBitmap)
  {
    try
    {
      boolean bool = a(paramBitmap);
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
    //   3: getfield 23	com/tencent/component/media/image/ReuseBitmapPool:jdField_a_of_type_JavaUtilTreeMap	Ljava/util/TreeMap;
    //   6: iload_1
    //   7: invokestatic 113	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   10: invokevirtual 116	java/util/TreeMap:ceilingKey	(Ljava/lang/Object;)Ljava/lang/Object;
    //   13: checkcast 109	java/lang/Integer
    //   16: astore_2
    //   17: aload_2
    //   18: ifnonnull +13 -> 31
    //   21: invokestatic 100	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   24: pop
    //   25: aconst_null
    //   26: astore_2
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_2
    //   30: areturn
    //   31: aload_2
    //   32: invokevirtual 119	java/lang/Integer:intValue	()I
    //   35: iload_1
    //   36: iconst_2
    //   37: imul
    //   38: if_icmple +12 -> 50
    //   41: invokestatic 100	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   44: pop
    //   45: aconst_null
    //   46: astore_2
    //   47: goto -20 -> 27
    //   50: aload_0
    //   51: aload_2
    //   52: invokespecial 142	com/tencent/component/media/image/ReuseBitmapPool:a	(Ljava/lang/Integer;)Landroid/graphics/Bitmap;
    //   55: astore_3
    //   56: aload_3
    //   57: astore_2
    //   58: aload_3
    //   59: ifnull -32 -> 27
    //   62: invokestatic 100	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   65: pop
    //   66: aload_3
    //   67: astore_2
    //   68: goto -41 -> 27
    //   71: astore_2
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_2
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	ReuseBitmapPool
    //   0	76	1	paramInt	int
    //   16	52	2	localObject1	Object
    //   71	4	2	localObject2	Object
    //   55	12	3	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   2	17	71	finally
    //   21	25	71	finally
    //   31	45	71	finally
    //   50	56	71	finally
    //   62	66	71	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.ReuseBitmapPool
 * JD-Core Version:    0.7.0.1
 */