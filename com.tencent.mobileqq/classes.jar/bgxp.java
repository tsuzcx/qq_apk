public class bgxp<T>
{
  private int jdField_a_of_type_Int = 10;
  private Object[] jdField_a_of_type_ArrayOfJavaLangObject;
  private int b;
  private int c;
  private int d;
  
  public bgxp()
  {
    this.b = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ArrayOfJavaLangObject = new Object[this.b];
  }
  
  public bgxp(int paramInt)
  {
    if (paramInt < 1) {
      throw new IllegalArgumentException("size不能小于1,size=" + paramInt);
    }
    this.b = paramInt;
    this.jdField_a_of_type_ArrayOfJavaLangObject = new Object[this.b];
  }
  
  /* Error */
  public int a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 48	bgxp:b	()Z
    //   6: istore 4
    //   8: iload 4
    //   10: ifeq +9 -> 19
    //   13: iconst_0
    //   14: istore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: iload_1
    //   18: ireturn
    //   19: aload_0
    //   20: getfield 50	bgxp:d	I
    //   23: aload_0
    //   24: getfield 52	bgxp:c	I
    //   27: if_icmple +16 -> 43
    //   30: aload_0
    //   31: getfield 50	bgxp:d	I
    //   34: aload_0
    //   35: getfield 52	bgxp:c	I
    //   38: isub
    //   39: istore_1
    //   40: goto -25 -> 15
    //   43: aload_0
    //   44: getfield 19	bgxp:b	I
    //   47: istore_1
    //   48: aload_0
    //   49: getfield 52	bgxp:c	I
    //   52: istore_2
    //   53: aload_0
    //   54: getfield 50	bgxp:d	I
    //   57: istore_3
    //   58: iload_1
    //   59: iload_2
    //   60: iload_3
    //   61: isub
    //   62: isub
    //   63: istore_1
    //   64: goto -49 -> 15
    //   67: astore 5
    //   69: aload_0
    //   70: monitorexit
    //   71: aload 5
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	bgxp
    //   14	50	1	i	int
    //   52	10	2	j	int
    //   57	5	3	k	int
    //   6	3	4	bool	boolean
    //   67	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	8	67	finally
    //   19	40	67	finally
    //   43	58	67	finally
  }
  
  public T a()
  {
    try
    {
      if (b()) {
        throw new IndexOutOfBoundsException(ajyc.a(2131706384));
      }
    }
    finally {}
    Object localObject2 = this.jdField_a_of_type_ArrayOfJavaLangObject[this.c];
    Object[] arrayOfObject = this.jdField_a_of_type_ArrayOfJavaLangObject;
    int i = this.c;
    this.c = (i + 1);
    arrayOfObject[i] = null;
    if (this.c == this.b) {}
    for (i = 0;; i = this.c)
    {
      this.c = i;
      return localObject2;
    }
  }
  
  public void a(T paramT)
  {
    try
    {
      if ((this.d == this.c) && (this.jdField_a_of_type_ArrayOfJavaLangObject[this.c] != null)) {
        throw new IndexOutOfBoundsException(ajyc.a(2131706383));
      }
    }
    finally {}
    if (paramT == null) {
      throw new IllegalArgumentException("element不能为null,element=null");
    }
    Object[] arrayOfObject = this.jdField_a_of_type_ArrayOfJavaLangObject;
    int i = this.d;
    this.d = (i + 1);
    arrayOfObject[i] = paramT;
    if (this.d == this.b) {}
    for (i = 0;; i = this.d)
    {
      this.d = i;
      return;
    }
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 71	bgxp:a	()I
    //   6: istore_1
    //   7: aload_0
    //   8: getfield 19	bgxp:b	I
    //   11: istore_2
    //   12: iload_1
    //   13: iload_2
    //   14: if_icmpne +9 -> 23
    //   17: iconst_1
    //   18: istore_3
    //   19: aload_0
    //   20: monitorexit
    //   21: iload_3
    //   22: ireturn
    //   23: iconst_0
    //   24: istore_3
    //   25: goto -6 -> 19
    //   28: astore 4
    //   30: aload_0
    //   31: monitorexit
    //   32: aload 4
    //   34: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	this	bgxp
    //   6	9	1	i	int
    //   11	4	2	j	int
    //   18	7	3	bool	boolean
    //   28	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	28	finally
  }
  
  /* Error */
  public boolean b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 50	bgxp:d	I
    //   6: aload_0
    //   7: getfield 52	bgxp:c	I
    //   10: if_icmpne +23 -> 33
    //   13: aload_0
    //   14: getfield 21	bgxp:jdField_a_of_type_ArrayOfJavaLangObject	[Ljava/lang/Object;
    //   17: aload_0
    //   18: getfield 50	bgxp:d	I
    //   21: aaload
    //   22: astore_2
    //   23: aload_2
    //   24: ifnonnull +9 -> 33
    //   27: iconst_1
    //   28: istore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: iload_1
    //   32: ireturn
    //   33: iconst_0
    //   34: istore_1
    //   35: goto -6 -> 29
    //   38: astore_2
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_2
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	bgxp
    //   28	7	1	bool	boolean
    //   22	2	2	localObject1	Object
    //   38	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	23	38	finally
  }
  
  public String toString()
  {
    for (;;)
    {
      try
      {
        Object localObject1;
        if (b())
        {
          localObject1 = "[]";
          return localObject1;
        }
        int i;
        if (this.c < this.d)
        {
          localObject1 = new StringBuilder("[");
          i = this.c;
          if (i < this.d)
          {
            ((StringBuilder)localObject1).append(this.jdField_a_of_type_ArrayOfJavaLangObject[i].toString() + "->");
            i += 1;
          }
          else
          {
            i = ((StringBuilder)localObject1).length();
            localObject1 = "]";
          }
        }
        else
        {
          localObject1 = new StringBuilder("[");
          i = this.c;
          if (i < this.b)
          {
            ((StringBuilder)localObject1).append(this.jdField_a_of_type_ArrayOfJavaLangObject[i].toString() + "->");
            i += 1;
            continue;
            if (i < this.d)
            {
              ((StringBuilder)localObject1).append(this.jdField_a_of_type_ArrayOfJavaLangObject[i].toString() + "->");
              i += 1;
            }
            else
            {
              i = ((StringBuilder)localObject1).length();
              localObject1 = "]";
            }
          }
          else
          {
            i = 0;
          }
        }
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bgxp
 * JD-Core Version:    0.7.0.1
 */