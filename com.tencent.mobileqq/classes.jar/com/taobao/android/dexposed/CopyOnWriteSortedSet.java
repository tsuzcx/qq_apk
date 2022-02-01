package com.taobao.android.dexposed;

public class CopyOnWriteSortedSet<E>
{
  private static final Object[] EMPTY_ARRAY = new Object[0];
  private volatile transient Object[] elements = EMPTY_ARRAY;
  
  private int indexOf(Object paramObject)
  {
    int i = 0;
    while (i < this.elements.length)
    {
      if (paramObject.equals(this.elements[i])) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  /* Error */
  public boolean add(E paramE)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: aload_1
    //   6: invokespecial 27	com/taobao/android/dexposed/CopyOnWriteSortedSet:indexOf	(Ljava/lang/Object;)I
    //   9: istore_2
    //   10: iload_2
    //   11: iflt +7 -> 18
    //   14: aload_0
    //   15: monitorexit
    //   16: iload_3
    //   17: ireturn
    //   18: aload_0
    //   19: getfield 18	com/taobao/android/dexposed/CopyOnWriteSortedSet:elements	[Ljava/lang/Object;
    //   22: arraylength
    //   23: iconst_1
    //   24: iadd
    //   25: anewarray 5	java/lang/Object
    //   28: astore 4
    //   30: aload_0
    //   31: getfield 18	com/taobao/android/dexposed/CopyOnWriteSortedSet:elements	[Ljava/lang/Object;
    //   34: iconst_0
    //   35: aload 4
    //   37: iconst_0
    //   38: aload_0
    //   39: getfield 18	com/taobao/android/dexposed/CopyOnWriteSortedSet:elements	[Ljava/lang/Object;
    //   42: arraylength
    //   43: invokestatic 33	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   46: aload 4
    //   48: aload_0
    //   49: getfield 18	com/taobao/android/dexposed/CopyOnWriteSortedSet:elements	[Ljava/lang/Object;
    //   52: arraylength
    //   53: aload_1
    //   54: aastore
    //   55: aload 4
    //   57: invokestatic 39	java/util/Arrays:sort	([Ljava/lang/Object;)V
    //   60: aload_0
    //   61: aload 4
    //   63: putfield 18	com/taobao/android/dexposed/CopyOnWriteSortedSet:elements	[Ljava/lang/Object;
    //   66: iconst_1
    //   67: istore_3
    //   68: goto -54 -> 14
    //   71: astore_1
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	CopyOnWriteSortedSet
    //   0	76	1	paramE	E
    //   9	2	2	i	int
    //   1	67	3	bool	boolean
    //   28	34	4	arrayOfObject	Object[]
    // Exception table:
    //   from	to	target	type
    //   4	10	71	finally
    //   18	66	71	finally
  }
  
  public void clear()
  {
    try
    {
      this.elements = EMPTY_ARRAY;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public Object[] getSnapshot()
  {
    return this.elements;
  }
  
  /* Error */
  public boolean remove(E paramE)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: aload_1
    //   6: invokespecial 27	com/taobao/android/dexposed/CopyOnWriteSortedSet:indexOf	(Ljava/lang/Object;)I
    //   9: istore_2
    //   10: iload_2
    //   11: iconst_m1
    //   12: if_icmpne +7 -> 19
    //   15: aload_0
    //   16: monitorexit
    //   17: iload_3
    //   18: ireturn
    //   19: aload_0
    //   20: getfield 18	com/taobao/android/dexposed/CopyOnWriteSortedSet:elements	[Ljava/lang/Object;
    //   23: arraylength
    //   24: iconst_1
    //   25: isub
    //   26: anewarray 5	java/lang/Object
    //   29: astore_1
    //   30: aload_0
    //   31: getfield 18	com/taobao/android/dexposed/CopyOnWriteSortedSet:elements	[Ljava/lang/Object;
    //   34: iconst_0
    //   35: aload_1
    //   36: iconst_0
    //   37: iload_2
    //   38: invokestatic 33	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   41: aload_0
    //   42: getfield 18	com/taobao/android/dexposed/CopyOnWriteSortedSet:elements	[Ljava/lang/Object;
    //   45: iload_2
    //   46: iconst_1
    //   47: iadd
    //   48: aload_1
    //   49: iload_2
    //   50: aload_0
    //   51: getfield 18	com/taobao/android/dexposed/CopyOnWriteSortedSet:elements	[Ljava/lang/Object;
    //   54: arraylength
    //   55: iload_2
    //   56: isub
    //   57: iconst_1
    //   58: isub
    //   59: invokestatic 33	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   62: aload_0
    //   63: aload_1
    //   64: putfield 18	com/taobao/android/dexposed/CopyOnWriteSortedSet:elements	[Ljava/lang/Object;
    //   67: iconst_1
    //   68: istore_3
    //   69: goto -54 -> 15
    //   72: astore_1
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_1
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	CopyOnWriteSortedSet
    //   0	77	1	paramE	E
    //   9	48	2	i	int
    //   1	68	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	10	72	finally
    //   19	67	72	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.taobao.android.dexposed.CopyOnWriteSortedSet
 * JD-Core Version:    0.7.0.1
 */