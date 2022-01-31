package com.tencent.biz.pubaccount.readinjoy.view.imageloader;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import mqm;

public class BytePool
{
  protected static final Comparator a;
  private int jdField_a_of_type_Int;
  private List jdField_a_of_type_JavaUtilList = new ArrayList(64);
  private final int b;
  
  static
  {
    jdField_a_of_type_JavaUtilComparator = new mqm();
  }
  
  public BytePool(int paramInt)
  {
    this.b = paramInt;
  }
  
  private void b()
  {
    try
    {
      if (this.jdField_a_of_type_Int > this.b)
      {
        byte[] arrayOfByte = (byte[])this.jdField_a_of_type_JavaUtilList.get(0);
        this.jdField_a_of_type_JavaUtilList.remove(arrayOfByte);
        this.jdField_a_of_type_Int -= arrayOfByte.length;
      }
      return;
    }
    finally {}
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public void a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +16 -> 19
    //   6: aload_1
    //   7: arraylength
    //   8: istore_2
    //   9: aload_0
    //   10: getfield 29	com/tencent/biz/pubaccount/readinjoy/view/imageloader/BytePool:b	I
    //   13: istore_3
    //   14: iload_2
    //   15: iload_3
    //   16: if_icmple +6 -> 22
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield 27	com/tencent/biz/pubaccount/readinjoy/view/imageloader/BytePool:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   26: aload_1
    //   27: getstatic 18	com/tencent/biz/pubaccount/readinjoy/view/imageloader/BytePool:jdField_a_of_type_JavaUtilComparator	Ljava/util/Comparator;
    //   30: invokestatic 53	java/util/Collections:binarySearch	(Ljava/util/List;Ljava/lang/Object;Ljava/util/Comparator;)I
    //   33: istore_3
    //   34: iload_3
    //   35: istore_2
    //   36: iload_3
    //   37: ifge +8 -> 45
    //   40: iload_3
    //   41: ineg
    //   42: iconst_1
    //   43: isub
    //   44: istore_2
    //   45: aload_0
    //   46: getfield 27	com/tencent/biz/pubaccount/readinjoy/view/imageloader/BytePool:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   49: iload_2
    //   50: aload_1
    //   51: invokeinterface 57 3 0
    //   56: aload_0
    //   57: aload_0
    //   58: getfield 31	com/tencent/biz/pubaccount/readinjoy/view/imageloader/BytePool:jdField_a_of_type_Int	I
    //   61: aload_1
    //   62: arraylength
    //   63: iadd
    //   64: putfield 31	com/tencent/biz/pubaccount/readinjoy/view/imageloader/BytePool:jdField_a_of_type_Int	I
    //   67: aload_0
    //   68: invokespecial 59	com/tencent/biz/pubaccount/readinjoy/view/imageloader/BytePool:b	()V
    //   71: goto -52 -> 19
    //   74: astore_1
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_1
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	BytePool
    //   0	79	1	paramArrayOfByte	byte[]
    //   8	42	2	i	int
    //   13	28	3	j	int
    // Exception table:
    //   from	to	target	type
    //   6	14	74	finally
    //   22	34	74	finally
    //   45	71	74	finally
  }
  
  /* Error */
  public byte[] a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore_2
    //   4: iload_2
    //   5: aload_0
    //   6: getfield 27	com/tencent/biz/pubaccount/readinjoy/view/imageloader/BytePool:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   9: invokeinterface 64 1 0
    //   14: if_icmpge +56 -> 70
    //   17: aload_0
    //   18: getfield 27	com/tencent/biz/pubaccount/readinjoy/view/imageloader/BytePool:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   21: iload_2
    //   22: invokeinterface 37 2 0
    //   27: checkcast 39	[B
    //   30: astore_3
    //   31: aload_3
    //   32: arraylength
    //   33: iload_1
    //   34: if_icmplt +29 -> 63
    //   37: aload_0
    //   38: aload_0
    //   39: getfield 31	com/tencent/biz/pubaccount/readinjoy/view/imageloader/BytePool:jdField_a_of_type_Int	I
    //   42: aload_3
    //   43: arraylength
    //   44: isub
    //   45: putfield 31	com/tencent/biz/pubaccount/readinjoy/view/imageloader/BytePool:jdField_a_of_type_Int	I
    //   48: aload_0
    //   49: getfield 27	com/tencent/biz/pubaccount/readinjoy/view/imageloader/BytePool:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   52: iload_2
    //   53: invokeinterface 66 2 0
    //   58: pop
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_3
    //   62: areturn
    //   63: iload_2
    //   64: iconst_1
    //   65: iadd
    //   66: istore_2
    //   67: goto -63 -> 4
    //   70: iload_1
    //   71: newarray byte
    //   73: astore_3
    //   74: goto -15 -> 59
    //   77: astore_3
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_3
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	BytePool
    //   0	82	1	paramInt	int
    //   3	64	2	i	int
    //   30	44	3	arrayOfByte	byte[]
    //   77	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	59	77	finally
    //   70	74	77	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.imageloader.BytePool
 * JD-Core Version:    0.7.0.1
 */