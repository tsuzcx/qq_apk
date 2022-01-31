package com.tencent.component.network.utils;

import java.util.ArrayList;

public class BytesBufferPool
{
  private final int jdField_a_of_type_Int;
  private final ArrayList jdField_a_of_type_JavaUtilArrayList;
  private final int b;
  
  public BytesBufferPool(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramInt1);
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  /* Error */
  public BytesBufferPool.BytesBuffer a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 20	com/tencent/component/network/utils/BytesBufferPool:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   6: invokevirtual 30	java/util/ArrayList:size	()I
    //   9: istore_1
    //   10: iload_1
    //   11: ifle +21 -> 32
    //   14: aload_0
    //   15: getfield 20	com/tencent/component/network/utils/BytesBufferPool:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   18: iload_1
    //   19: iconst_1
    //   20: isub
    //   21: invokevirtual 34	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   24: checkcast 36	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer
    //   27: astore_2
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_2
    //   31: areturn
    //   32: new 36	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer
    //   35: dup
    //   36: aload_0
    //   37: getfield 24	com/tencent/component/network/utils/BytesBufferPool:b	I
    //   40: aconst_null
    //   41: invokespecial 39	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:<init>	(ILpjd;)V
    //   44: astore_2
    //   45: goto -17 -> 28
    //   48: astore_2
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_2
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	this	BytesBufferPool
    //   9	12	1	i	int
    //   27	18	2	localBytesBuffer	BytesBufferPool.BytesBuffer
    //   48	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	48	finally
    //   14	28	48	finally
    //   32	45	48	finally
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public void a(BytesBufferPool.BytesBuffer paramBytesBuffer)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: getfield 46	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:jdField_a_of_type_ArrayOfByte	[B
    //   6: arraylength
    //   7: istore_2
    //   8: aload_0
    //   9: getfield 24	com/tencent/component/network/utils/BytesBufferPool:b	I
    //   12: istore_3
    //   13: iload_2
    //   14: iload_3
    //   15: if_icmpeq +6 -> 21
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: aload_0
    //   22: getfield 20	com/tencent/component/network/utils/BytesBufferPool:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   25: invokevirtual 30	java/util/ArrayList:size	()I
    //   28: aload_0
    //   29: getfield 22	com/tencent/component/network/utils/BytesBufferPool:jdField_a_of_type_Int	I
    //   32: if_icmpge -14 -> 18
    //   35: aload_1
    //   36: iconst_0
    //   37: putfield 47	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:jdField_a_of_type_Int	I
    //   40: aload_1
    //   41: iconst_0
    //   42: putfield 48	com/tencent/component/network/utils/BytesBufferPool$BytesBuffer:b	I
    //   45: aload_0
    //   46: getfield 20	com/tencent/component/network/utils/BytesBufferPool:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   49: aload_1
    //   50: invokevirtual 52	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   53: pop
    //   54: goto -36 -> 18
    //   57: astore_1
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	BytesBufferPool
    //   0	62	1	paramBytesBuffer	BytesBufferPool.BytesBuffer
    //   7	9	2	i	int
    //   12	4	3	j	int
    // Exception table:
    //   from	to	target	type
    //   2	13	57	finally
    //   21	54	57	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.utils.BytesBufferPool
 * JD-Core Version:    0.7.0.1
 */