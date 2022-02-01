package com.tencent.biz.pubaccount.readinjoy.ugc.databinding;

import java.util.ArrayList;
import java.util.List;

public class CallbackRegistry<C, T, A>
  implements Cloneable
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  private final CallbackRegistry.NotifierCallback<C, T, A> jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingCallbackRegistry$NotifierCallback;
  private List<C> jdField_a_of_type_JavaUtilList = new ArrayList();
  private long[] jdField_a_of_type_ArrayOfLong;
  
  public CallbackRegistry(CallbackRegistry.NotifierCallback<C, T, A> paramNotifierCallback)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingCallbackRegistry$NotifierCallback = paramNotifierCallback;
  }
  
  private void a(int paramInt)
  {
    if (paramInt < 64)
    {
      this.jdField_a_of_type_Long = (1L << paramInt | this.jdField_a_of_type_Long);
      return;
    }
    int i = paramInt / 64 - 1;
    if (this.jdField_a_of_type_ArrayOfLong == null) {
      this.jdField_a_of_type_ArrayOfLong = new long[this.jdField_a_of_type_JavaUtilList.size() / 64];
    }
    for (;;)
    {
      long[] arrayOfLong = this.jdField_a_of_type_ArrayOfLong;
      arrayOfLong[i] = (1L << paramInt % 64 | arrayOfLong[i]);
      return;
      if (this.jdField_a_of_type_ArrayOfLong.length < i)
      {
        arrayOfLong = new long[this.jdField_a_of_type_JavaUtilList.size() / 64];
        System.arraycopy(this.jdField_a_of_type_ArrayOfLong, 0, arrayOfLong, 0, this.jdField_a_of_type_ArrayOfLong.length);
        this.jdField_a_of_type_ArrayOfLong = arrayOfLong;
      }
    }
  }
  
  private void a(int paramInt, long paramLong)
  {
    long l = -9223372036854775808L;
    int i = paramInt + 64 - 1;
    while (i >= paramInt)
    {
      if ((paramLong & l) != 0L) {
        this.jdField_a_of_type_JavaUtilList.remove(i);
      }
      l >>>= 1;
      i -= 1;
    }
  }
  
  private void a(T paramT, int paramInt1, A paramA, int paramInt2)
  {
    if (paramInt2 < 0)
    {
      b(paramT, paramInt1, paramA);
      return;
    }
    long l = this.jdField_a_of_type_ArrayOfLong[paramInt2];
    int i = (paramInt2 + 1) * 64;
    int j = Math.min(this.jdField_a_of_type_JavaUtilList.size(), i + 64);
    a(paramT, paramInt1, paramA, paramInt2 - 1);
    a(paramT, paramInt1, paramA, i, j, l);
  }
  
  private void a(T paramT, int paramInt1, A paramA, int paramInt2, int paramInt3, long paramLong)
  {
    long l = 1L;
    while (paramInt2 < paramInt3)
    {
      if ((paramLong & l) == 0L) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingCallbackRegistry$NotifierCallback.a(this.jdField_a_of_type_JavaUtilList.get(paramInt2), paramT, paramInt1, paramA);
      }
      l <<= 1;
      paramInt2 += 1;
    }
  }
  
  private boolean a(int paramInt)
  {
    if (paramInt < 64) {
      if ((1L << paramInt & this.jdField_a_of_type_Long) == 0L) {}
    }
    int i;
    do
    {
      return true;
      return false;
      if (this.jdField_a_of_type_ArrayOfLong == null) {
        return false;
      }
      i = paramInt / 64 - 1;
      if (i >= this.jdField_a_of_type_ArrayOfLong.length) {
        return false;
      }
    } while ((this.jdField_a_of_type_ArrayOfLong[i] & 1L << paramInt % 64) != 0L);
    return false;
  }
  
  private void b(T paramT, int paramInt, A paramA)
  {
    a(paramT, paramInt, paramA, 0, Math.min(64, this.jdField_a_of_type_JavaUtilList.size()), this.jdField_a_of_type_Long);
  }
  
  private void c(T paramT, int paramInt, A paramA)
  {
    int j = this.jdField_a_of_type_JavaUtilList.size();
    if (this.jdField_a_of_type_ArrayOfLong == null) {}
    for (int i = -1;; i = this.jdField_a_of_type_ArrayOfLong.length - 1)
    {
      a(paramT, paramInt, paramA, i);
      a(paramT, paramInt, paramA, (i + 2) * 64, j, 0L);
      return;
    }
  }
  
  /* Error */
  public CallbackRegistry<C, T, A> a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 90	java/lang/Object:clone	()Ljava/lang/Object;
    //   6: checkcast 2	com/tencent/biz/pubaccount/readinjoy/ugc/databinding/CallbackRegistry
    //   9: astore_3
    //   10: aload_3
    //   11: lconst_0
    //   12: putfield 27	com/tencent/biz/pubaccount/readinjoy/ugc/databinding/CallbackRegistry:jdField_a_of_type_Long	J
    //   15: aload_3
    //   16: aconst_null
    //   17: putfield 35	com/tencent/biz/pubaccount/readinjoy/ugc/databinding/CallbackRegistry:jdField_a_of_type_ArrayOfLong	[J
    //   20: aload_3
    //   21: iconst_0
    //   22: putfield 92	com/tencent/biz/pubaccount/readinjoy/ugc/databinding/CallbackRegistry:jdField_a_of_type_Int	I
    //   25: aload_3
    //   26: new 22	java/util/ArrayList
    //   29: dup
    //   30: invokespecial 23	java/util/ArrayList:<init>	()V
    //   33: putfield 25	com/tencent/biz/pubaccount/readinjoy/ugc/databinding/CallbackRegistry:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   36: aload_0
    //   37: getfield 25	com/tencent/biz/pubaccount/readinjoy/ugc/databinding/CallbackRegistry:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   40: invokeinterface 41 1 0
    //   45: istore_2
    //   46: iconst_0
    //   47: istore_1
    //   48: aload_3
    //   49: astore 4
    //   51: iload_1
    //   52: iload_2
    //   53: if_icmpge +50 -> 103
    //   56: aload_0
    //   57: iload_1
    //   58: invokespecial 94	com/tencent/biz/pubaccount/readinjoy/ugc/databinding/CallbackRegistry:a	(I)Z
    //   61: ifne +23 -> 84
    //   64: aload_3
    //   65: getfield 25	com/tencent/biz/pubaccount/readinjoy/ugc/databinding/CallbackRegistry:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   68: aload_0
    //   69: getfield 25	com/tencent/biz/pubaccount/readinjoy/ugc/databinding/CallbackRegistry:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   72: iload_1
    //   73: invokeinterface 74 2 0
    //   78: invokeinterface 98 2 0
    //   83: pop
    //   84: iload_1
    //   85: iconst_1
    //   86: iadd
    //   87: istore_1
    //   88: goto -40 -> 48
    //   91: astore 4
    //   93: aconst_null
    //   94: astore_3
    //   95: aload 4
    //   97: invokevirtual 101	java/lang/CloneNotSupportedException:printStackTrace	()V
    //   100: aload_3
    //   101: astore 4
    //   103: aload_0
    //   104: monitorexit
    //   105: aload 4
    //   107: areturn
    //   108: astore_3
    //   109: aload_0
    //   110: monitorexit
    //   111: aload_3
    //   112: athrow
    //   113: astore 4
    //   115: goto -20 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	this	CallbackRegistry
    //   47	41	1	i	int
    //   45	9	2	j	int
    //   9	92	3	localCallbackRegistry1	CallbackRegistry
    //   108	4	3	localObject	Object
    //   49	1	4	localCallbackRegistry2	CallbackRegistry
    //   91	5	4	localCloneNotSupportedException1	java.lang.CloneNotSupportedException
    //   101	5	4	localCallbackRegistry3	CallbackRegistry
    //   113	1	4	localCloneNotSupportedException2	java.lang.CloneNotSupportedException
    // Exception table:
    //   from	to	target	type
    //   2	10	91	java/lang/CloneNotSupportedException
    //   2	10	108	finally
    //   10	46	108	finally
    //   56	84	108	finally
    //   95	100	108	finally
    //   10	46	113	java/lang/CloneNotSupportedException
    //   56	84	113	java/lang/CloneNotSupportedException
  }
  
  public void a(C paramC)
  {
    if (paramC == null) {
      try
      {
        throw new IllegalArgumentException("callback cannot be null");
      }
      finally {}
    }
    int i = this.jdField_a_of_type_JavaUtilList.lastIndexOf(paramC);
    if ((i < 0) || (a(i))) {
      this.jdField_a_of_type_JavaUtilList.add(paramC);
    }
  }
  
  public void a(T paramT, int paramInt, A paramA)
  {
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Int += 1;
        c(paramT, paramInt, paramA);
        this.jdField_a_of_type_Int -= 1;
        if (this.jdField_a_of_type_Int == 0)
        {
          if (this.jdField_a_of_type_ArrayOfLong != null)
          {
            paramInt = this.jdField_a_of_type_ArrayOfLong.length - 1;
            if (paramInt >= 0)
            {
              long l = this.jdField_a_of_type_ArrayOfLong[paramInt];
              if (l == 0L) {
                break label123;
              }
              a((paramInt + 1) * 64, l);
              this.jdField_a_of_type_ArrayOfLong[paramInt] = 0L;
              break label123;
            }
          }
          if (this.jdField_a_of_type_Long != 0L)
          {
            a(0, this.jdField_a_of_type_Long);
            this.jdField_a_of_type_Long = 0L;
          }
        }
        return;
      }
      finally {}
      label123:
      paramInt -= 1;
    }
  }
  
  /* Error */
  public void b(C paramC)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 92	com/tencent/biz/pubaccount/readinjoy/ugc/databinding/CallbackRegistry:jdField_a_of_type_Int	I
    //   6: ifne +17 -> 23
    //   9: aload_0
    //   10: getfield 25	com/tencent/biz/pubaccount/readinjoy/ugc/databinding/CallbackRegistry:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   13: aload_1
    //   14: invokeinterface 121 2 0
    //   19: pop
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: getfield 25	com/tencent/biz/pubaccount/readinjoy/ugc/databinding/CallbackRegistry:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   27: aload_1
    //   28: invokeinterface 114 2 0
    //   33: istore_2
    //   34: iload_2
    //   35: iflt -15 -> 20
    //   38: aload_0
    //   39: iload_2
    //   40: invokespecial 123	com/tencent/biz/pubaccount/readinjoy/ugc/databinding/CallbackRegistry:a	(I)V
    //   43: goto -23 -> 20
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	CallbackRegistry
    //   0	51	1	paramC	C
    //   33	7	2	i	int
    // Exception table:
    //   from	to	target	type
    //   2	20	46	finally
    //   23	34	46	finally
    //   38	43	46	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.databinding.CallbackRegistry
 * JD-Core Version:    0.7.0.1
 */