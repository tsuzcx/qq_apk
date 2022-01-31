package com.tencent.biz.qqstory.takevideo;

import android.graphics.Bitmap;
import java.util.concurrent.CountDownLatch;
import uvd;

public class EditVideoPlayer$4
  implements Runnable
{
  public EditVideoPlayer$4(uvd paramuvd, int paramInt, Bitmap[] paramArrayOfBitmap, CountDownLatch paramCountDownLatch) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	com/tencent/biz/qqstory/takevideo/EditVideoPlayer$4:this$0	Luvd;
    //   4: getfield 32	uvd:a	Ljava/util/List;
    //   7: astore_1
    //   8: aload_1
    //   9: ifnull +56 -> 65
    //   12: aload_0
    //   13: getfield 18	com/tencent/biz/qqstory/takevideo/EditVideoPlayer$4:jdField_a_of_type_Int	I
    //   16: aload_1
    //   17: invokeinterface 38 1 0
    //   22: if_icmpge +43 -> 65
    //   25: aload_1
    //   26: aload_0
    //   27: getfield 18	com/tencent/biz/qqstory/takevideo/EditVideoPlayer$4:jdField_a_of_type_Int	I
    //   30: invokeinterface 42 2 0
    //   35: checkcast 44	uwo
    //   38: astore_1
    //   39: aload_1
    //   40: ifnull +17 -> 57
    //   43: aload_0
    //   44: getfield 20	com/tencent/biz/qqstory/takevideo/EditVideoPlayer$4:jdField_a_of_type_ArrayOfAndroidGraphicsBitmap	[Landroid/graphics/Bitmap;
    //   47: iconst_0
    //   48: aload_0
    //   49: getfield 16	com/tencent/biz/qqstory/takevideo/EditVideoPlayer$4:this$0	Luvd;
    //   52: aload_1
    //   53: invokevirtual 47	uvd:a	(Luwo;)Landroid/graphics/Bitmap;
    //   56: aastore
    //   57: aload_0
    //   58: getfield 22	com/tencent/biz/qqstory/takevideo/EditVideoPlayer$4:jdField_a_of_type_JavaUtilConcurrentCountDownLatch	Ljava/util/concurrent/CountDownLatch;
    //   61: invokevirtual 52	java/util/concurrent/CountDownLatch:countDown	()V
    //   64: return
    //   65: aconst_null
    //   66: astore_1
    //   67: goto -28 -> 39
    //   70: astore_1
    //   71: aload_0
    //   72: getfield 22	com/tencent/biz/qqstory/takevideo/EditVideoPlayer$4:jdField_a_of_type_JavaUtilConcurrentCountDownLatch	Ljava/util/concurrent/CountDownLatch;
    //   75: invokevirtual 52	java/util/concurrent/CountDownLatch:countDown	()V
    //   78: aload_1
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	4
    //   7	60	1	localObject1	Object
    //   70	9	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	8	70	finally
    //   12	39	70	finally
    //   43	57	70	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoPlayer.4
 * JD-Core Version:    0.7.0.1
 */