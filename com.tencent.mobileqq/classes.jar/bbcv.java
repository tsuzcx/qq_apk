import java.lang.reflect.Array;
import mqq.util.WeakReference;

public final class bbcv<T>
{
  private int jdField_a_of_type_Int = -1;
  private WeakReference<T>[] jdField_a_of_type_ArrayOfMqqUtilWeakReference;
  
  public bbcv()
  {
    this(16);
  }
  
  public bbcv(int paramInt)
  {
    this.jdField_a_of_type_ArrayOfMqqUtilWeakReference = ((WeakReference[])Array.newInstance(WeakReference.class, paramInt));
  }
  
  /* Error */
  public T a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: aload 4
    //   7: astore_3
    //   8: aload_0
    //   9: getfield 19	bbcv:jdField_a_of_type_Int	I
    //   12: iconst_m1
    //   13: if_icmpeq +22 -> 35
    //   16: aload_0
    //   17: getfield 19	bbcv:jdField_a_of_type_Int	I
    //   20: istore_1
    //   21: aload_0
    //   22: getfield 30	bbcv:jdField_a_of_type_ArrayOfMqqUtilWeakReference	[Lmqq/util/WeakReference;
    //   25: arraylength
    //   26: istore_2
    //   27: iload_1
    //   28: iload_2
    //   29: if_icmple +10 -> 39
    //   32: aload 4
    //   34: astore_3
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_3
    //   38: areturn
    //   39: aload_0
    //   40: getfield 30	bbcv:jdField_a_of_type_ArrayOfMqqUtilWeakReference	[Lmqq/util/WeakReference;
    //   43: aload_0
    //   44: getfield 19	bbcv:jdField_a_of_type_Int	I
    //   47: aaload
    //   48: invokevirtual 34	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   51: astore_3
    //   52: aload_0
    //   53: getfield 30	bbcv:jdField_a_of_type_ArrayOfMqqUtilWeakReference	[Lmqq/util/WeakReference;
    //   56: aload_0
    //   57: getfield 19	bbcv:jdField_a_of_type_Int	I
    //   60: aconst_null
    //   61: aastore
    //   62: aload_0
    //   63: aload_0
    //   64: getfield 19	bbcv:jdField_a_of_type_Int	I
    //   67: iconst_1
    //   68: isub
    //   69: putfield 19	bbcv:jdField_a_of_type_Int	I
    //   72: goto -37 -> 35
    //   75: astore_3
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_3
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	bbcv
    //   20	10	1	i	int
    //   26	4	2	j	int
    //   7	45	3	localObject1	Object
    //   75	4	3	localObject2	Object
    //   1	32	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   8	27	75	finally
    //   39	72	75	finally
  }
  
  /* Error */
  public boolean a(T paramT)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 19	bbcv:jdField_a_of_type_Int	I
    //   6: iconst_m1
    //   7: if_icmpeq +17 -> 24
    //   10: aload_0
    //   11: getfield 19	bbcv:jdField_a_of_type_Int	I
    //   14: aload_0
    //   15: getfield 30	bbcv:jdField_a_of_type_ArrayOfMqqUtilWeakReference	[Lmqq/util/WeakReference;
    //   18: arraylength
    //   19: iconst_1
    //   20: isub
    //   21: if_icmpge +36 -> 57
    //   24: aload_0
    //   25: aload_0
    //   26: getfield 19	bbcv:jdField_a_of_type_Int	I
    //   29: iconst_1
    //   30: iadd
    //   31: putfield 19	bbcv:jdField_a_of_type_Int	I
    //   34: aload_0
    //   35: getfield 30	bbcv:jdField_a_of_type_ArrayOfMqqUtilWeakReference	[Lmqq/util/WeakReference;
    //   38: aload_0
    //   39: getfield 19	bbcv:jdField_a_of_type_Int	I
    //   42: new 21	mqq/util/WeakReference
    //   45: dup
    //   46: aload_1
    //   47: invokespecial 40	mqq/util/WeakReference:<init>	(Ljava/lang/Object;)V
    //   50: aastore
    //   51: iconst_1
    //   52: istore_2
    //   53: aload_0
    //   54: monitorexit
    //   55: iload_2
    //   56: ireturn
    //   57: iconst_0
    //   58: istore_2
    //   59: goto -6 -> 53
    //   62: astore_1
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_1
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	bbcv
    //   0	67	1	paramT	T
    //   52	7	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	24	62	finally
    //   24	51	62	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbcv
 * JD-Core Version:    0.7.0.1
 */