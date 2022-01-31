package com.tencent.component.media.image;

import android.graphics.Bitmap;
import com.tencent.component.media.utils.BitmapUtils;
import com.tencent.component.media.utils.LruCache;

class ReuseBitmapPool$1
  extends LruCache<Integer, Bitmap>
{
  ReuseBitmapPool$1(ReuseBitmapPool paramReuseBitmapPool, int paramInt)
  {
    super(paramInt);
  }
  
  /* Error */
  protected void entryRemoved(boolean paramBoolean, Integer paramInteger, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: aload_2
    //   5: aload_3
    //   6: aload 4
    //   8: invokespecial 20	com/tencent/component/media/utils/LruCache:entryRemoved	(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   11: iload_1
    //   12: ifeq +36 -> 48
    //   15: aload_3
    //   16: invokestatic 26	com/tencent/component/media/utils/BitmapUtils:getBitmapAllocSize	(Landroid/graphics/Bitmap;)I
    //   19: istore 5
    //   21: aload_0
    //   22: getfield 11	com/tencent/component/media/image/ReuseBitmapPool$1:this$0	Lcom/tencent/component/media/image/ReuseBitmapPool;
    //   25: invokestatic 32	com/tencent/component/media/image/ReuseBitmapPool:access$000	(Lcom/tencent/component/media/image/ReuseBitmapPool;)Ljava/util/TreeMap;
    //   28: iload 5
    //   30: invokestatic 38	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   33: invokevirtual 44	java/util/TreeMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   36: checkcast 46	java/util/List
    //   39: astore_3
    //   40: aload_3
    //   41: ifnonnull +10 -> 51
    //   44: invokestatic 52	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   47: pop
    //   48: aload_0
    //   49: monitorexit
    //   50: return
    //   51: aload_3
    //   52: aload_2
    //   53: invokeinterface 56 2 0
    //   58: pop
    //   59: aload_3
    //   60: invokeinterface 60 1 0
    //   65: ifeq +19 -> 84
    //   68: aload_0
    //   69: getfield 11	com/tencent/component/media/image/ReuseBitmapPool$1:this$0	Lcom/tencent/component/media/image/ReuseBitmapPool;
    //   72: invokestatic 32	com/tencent/component/media/image/ReuseBitmapPool:access$000	(Lcom/tencent/component/media/image/ReuseBitmapPool;)Ljava/util/TreeMap;
    //   75: iload 5
    //   77: invokestatic 38	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   80: invokevirtual 62	java/util/TreeMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   83: pop
    //   84: invokestatic 52	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   87: pop
    //   88: goto -40 -> 48
    //   91: astore_2
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_2
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	1
    //   0	96	1	paramBoolean	boolean
    //   0	96	2	paramInteger	Integer
    //   0	96	3	paramBitmap1	Bitmap
    //   0	96	4	paramBitmap2	Bitmap
    //   19	57	5	i	int
    // Exception table:
    //   from	to	target	type
    //   2	11	91	finally
    //   15	40	91	finally
    //   44	48	91	finally
    //   51	84	91	finally
    //   84	88	91	finally
  }
  
  protected int sizeOf(Integer paramInteger, Bitmap paramBitmap)
  {
    return BitmapUtils.getBitmapAllocSize(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.media.image.ReuseBitmapPool.1
 * JD-Core Version:    0.7.0.1
 */