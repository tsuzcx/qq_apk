package com.tencent.map.sdk.a;

import java.util.ArrayList;

public final class ig
  implements gr
{
  private ArrayList<gr> a = new ArrayList();
  
  public final void a()
  {
    int i = this.a.size() - 1;
    while (i >= 0)
    {
      ((gr)this.a.get(i)).a();
      i -= 1;
    }
  }
  
  public final void a(gr paramgr)
  {
    if (paramgr != null) {}
    try
    {
      if (!this.a.contains(paramgr)) {
        this.a.add(paramgr);
      }
      return;
    }
    finally
    {
      paramgr = finally;
      throw paramgr;
    }
  }
  
  /* Error */
  public final boolean a(float paramFloat)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 18	com/tencent/map/sdk/a/ig:a	Ljava/util/ArrayList;
    //   6: invokevirtual 23	java/util/ArrayList:size	()I
    //   9: iconst_1
    //   10: isub
    //   11: istore_2
    //   12: iload_2
    //   13: iflt +38 -> 51
    //   16: aload_0
    //   17: getfield 18	com/tencent/map/sdk/a/ig:a	Ljava/util/ArrayList;
    //   20: iload_2
    //   21: invokevirtual 27	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   24: checkcast 6	com/tencent/map/sdk/a/gr
    //   27: fload_1
    //   28: invokeinterface 40 2 0
    //   33: istore_3
    //   34: iload_3
    //   35: ifeq +9 -> 44
    //   38: iconst_1
    //   39: istore_3
    //   40: aload_0
    //   41: monitorexit
    //   42: iload_3
    //   43: ireturn
    //   44: iload_2
    //   45: iconst_1
    //   46: isub
    //   47: istore_2
    //   48: goto -36 -> 12
    //   51: iconst_0
    //   52: istore_3
    //   53: goto -13 -> 40
    //   56: astore 4
    //   58: aload_0
    //   59: monitorexit
    //   60: aload 4
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	this	ig
    //   0	63	1	paramFloat	float
    //   11	37	2	i	int
    //   33	20	3	bool	boolean
    //   56	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	56	finally
    //   16	34	56	finally
  }
  
  /* Error */
  public final boolean a(float paramFloat1, float paramFloat2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 18	com/tencent/map/sdk/a/ig:a	Ljava/util/ArrayList;
    //   6: invokevirtual 23	java/util/ArrayList:size	()I
    //   9: iconst_1
    //   10: isub
    //   11: istore_3
    //   12: iload_3
    //   13: iflt +43 -> 56
    //   16: aload_0
    //   17: getfield 18	com/tencent/map/sdk/a/ig:a	Ljava/util/ArrayList;
    //   20: iload_3
    //   21: invokevirtual 27	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   24: checkcast 6	com/tencent/map/sdk/a/gr
    //   27: fload_1
    //   28: fload_2
    //   29: invokeinterface 43 3 0
    //   34: istore 4
    //   36: iload 4
    //   38: ifeq +11 -> 49
    //   41: iconst_1
    //   42: istore 4
    //   44: aload_0
    //   45: monitorexit
    //   46: iload 4
    //   48: ireturn
    //   49: iload_3
    //   50: iconst_1
    //   51: isub
    //   52: istore_3
    //   53: goto -41 -> 12
    //   56: iconst_0
    //   57: istore 4
    //   59: goto -15 -> 44
    //   62: astore 5
    //   64: aload_0
    //   65: monitorexit
    //   66: aload 5
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	ig
    //   0	69	1	paramFloat1	float
    //   0	69	2	paramFloat2	float
    //   11	42	3	i	int
    //   34	24	4	bool	boolean
    //   62	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	62	finally
    //   16	36	62	finally
  }
  
  /* Error */
  public final boolean a(android.graphics.PointF paramPointF1, android.graphics.PointF paramPointF2, double paramDouble1, double paramDouble2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 18	com/tencent/map/sdk/a/ig:a	Ljava/util/ArrayList;
    //   6: invokevirtual 23	java/util/ArrayList:size	()I
    //   9: iconst_1
    //   10: isub
    //   11: istore 7
    //   13: iload 7
    //   15: iflt +49 -> 64
    //   18: aload_0
    //   19: getfield 18	com/tencent/map/sdk/a/ig:a	Ljava/util/ArrayList;
    //   22: iload 7
    //   24: invokevirtual 27	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   27: checkcast 6	com/tencent/map/sdk/a/gr
    //   30: aload_1
    //   31: aload_2
    //   32: dload_3
    //   33: dload 5
    //   35: invokeinterface 46 7 0
    //   40: istore 8
    //   42: iload 8
    //   44: ifeq +11 -> 55
    //   47: iconst_1
    //   48: istore 8
    //   50: aload_0
    //   51: monitorexit
    //   52: iload 8
    //   54: ireturn
    //   55: iload 7
    //   57: iconst_1
    //   58: isub
    //   59: istore 7
    //   61: goto -48 -> 13
    //   64: iconst_0
    //   65: istore 8
    //   67: goto -17 -> 50
    //   70: astore_1
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_1
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	ig
    //   0	75	1	paramPointF1	android.graphics.PointF
    //   0	75	2	paramPointF2	android.graphics.PointF
    //   0	75	3	paramDouble1	double
    //   0	75	5	paramDouble2	double
    //   11	49	7	i	int
    //   40	26	8	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	13	70	finally
    //   18	42	70	finally
  }
  
  /* Error */
  public final boolean a(android.graphics.PointF paramPointF1, android.graphics.PointF paramPointF2, float paramFloat)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 18	com/tencent/map/sdk/a/ig:a	Ljava/util/ArrayList;
    //   6: invokevirtual 23	java/util/ArrayList:size	()I
    //   9: iconst_1
    //   10: isub
    //   11: istore 4
    //   13: iload 4
    //   15: iflt +47 -> 62
    //   18: aload_0
    //   19: getfield 18	com/tencent/map/sdk/a/ig:a	Ljava/util/ArrayList;
    //   22: iload 4
    //   24: invokevirtual 27	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   27: checkcast 6	com/tencent/map/sdk/a/gr
    //   30: aload_1
    //   31: aload_2
    //   32: fload_3
    //   33: invokeinterface 49 4 0
    //   38: istore 5
    //   40: iload 5
    //   42: ifeq +11 -> 53
    //   45: iconst_1
    //   46: istore 5
    //   48: aload_0
    //   49: monitorexit
    //   50: iload 5
    //   52: ireturn
    //   53: iload 4
    //   55: iconst_1
    //   56: isub
    //   57: istore 4
    //   59: goto -46 -> 13
    //   62: iconst_0
    //   63: istore 5
    //   65: goto -17 -> 48
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	ig
    //   0	73	1	paramPointF1	android.graphics.PointF
    //   0	73	2	paramPointF2	android.graphics.PointF
    //   0	73	3	paramFloat	float
    //   11	47	4	i	int
    //   38	26	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	13	68	finally
    //   18	40	68	finally
  }
  
  public final void b(gr paramgr)
  {
    try
    {
      this.a.remove(paramgr);
      return;
    }
    finally
    {
      paramgr = finally;
      throw paramgr;
    }
  }
  
  /* Error */
  public final boolean b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 18	com/tencent/map/sdk/a/ig:a	Ljava/util/ArrayList;
    //   6: invokevirtual 23	java/util/ArrayList:size	()I
    //   9: iconst_1
    //   10: isub
    //   11: istore_1
    //   12: iload_1
    //   13: iflt +37 -> 50
    //   16: aload_0
    //   17: getfield 18	com/tencent/map/sdk/a/ig:a	Ljava/util/ArrayList;
    //   20: iload_1
    //   21: invokevirtual 27	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   24: checkcast 6	com/tencent/map/sdk/a/gr
    //   27: invokeinterface 56 1 0
    //   32: istore_2
    //   33: iload_2
    //   34: ifeq +9 -> 43
    //   37: iconst_1
    //   38: istore_2
    //   39: aload_0
    //   40: monitorexit
    //   41: iload_2
    //   42: ireturn
    //   43: iload_1
    //   44: iconst_1
    //   45: isub
    //   46: istore_1
    //   47: goto -35 -> 12
    //   50: iconst_0
    //   51: istore_2
    //   52: goto -13 -> 39
    //   55: astore_3
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_3
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	ig
    //   11	36	1	i	int
    //   32	20	2	bool	boolean
    //   55	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	55	finally
    //   16	33	55	finally
  }
  
  /* Error */
  public final boolean b(float paramFloat1, float paramFloat2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 18	com/tencent/map/sdk/a/ig:a	Ljava/util/ArrayList;
    //   6: invokevirtual 23	java/util/ArrayList:size	()I
    //   9: iconst_1
    //   10: isub
    //   11: istore_3
    //   12: iload_3
    //   13: iflt +43 -> 56
    //   16: aload_0
    //   17: getfield 18	com/tencent/map/sdk/a/ig:a	Ljava/util/ArrayList;
    //   20: iload_3
    //   21: invokevirtual 27	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   24: checkcast 6	com/tencent/map/sdk/a/gr
    //   27: fload_1
    //   28: fload_2
    //   29: invokeinterface 58 3 0
    //   34: istore 4
    //   36: iload 4
    //   38: ifeq +11 -> 49
    //   41: iconst_1
    //   42: istore 4
    //   44: aload_0
    //   45: monitorexit
    //   46: iload 4
    //   48: ireturn
    //   49: iload_3
    //   50: iconst_1
    //   51: isub
    //   52: istore_3
    //   53: goto -41 -> 12
    //   56: ldc 60
    //   58: invokestatic 65	com/tencent/map/sdk/a/or:a	(Ljava/lang/String;)V
    //   61: aload_0
    //   62: getfield 18	com/tencent/map/sdk/a/ig:a	Ljava/util/ArrayList;
    //   65: invokevirtual 23	java/util/ArrayList:size	()I
    //   68: iconst_1
    //   69: isub
    //   70: istore_3
    //   71: iload_3
    //   72: iflt +26 -> 98
    //   75: aload_0
    //   76: getfield 18	com/tencent/map/sdk/a/ig:a	Ljava/util/ArrayList;
    //   79: iload_3
    //   80: invokevirtual 27	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   83: checkcast 6	com/tencent/map/sdk/a/gr
    //   86: invokeinterface 29 1 0
    //   91: iload_3
    //   92: iconst_1
    //   93: isub
    //   94: istore_3
    //   95: goto -24 -> 71
    //   98: iconst_0
    //   99: istore 4
    //   101: goto -57 -> 44
    //   104: astore 5
    //   106: aload_0
    //   107: monitorexit
    //   108: aload 5
    //   110: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	ig
    //   0	111	1	paramFloat1	float
    //   0	111	2	paramFloat2	float
    //   11	84	3	i	int
    //   34	66	4	bool	boolean
    //   104	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	104	finally
    //   16	36	104	finally
    //   56	71	104	finally
    //   75	91	104	finally
  }
  
  /* Error */
  public final boolean c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 18	com/tencent/map/sdk/a/ig:a	Ljava/util/ArrayList;
    //   6: invokevirtual 23	java/util/ArrayList:size	()I
    //   9: iconst_1
    //   10: isub
    //   11: istore_1
    //   12: iload_1
    //   13: iflt +37 -> 50
    //   16: aload_0
    //   17: getfield 18	com/tencent/map/sdk/a/ig:a	Ljava/util/ArrayList;
    //   20: iload_1
    //   21: invokevirtual 27	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   24: checkcast 6	com/tencent/map/sdk/a/gr
    //   27: invokeinterface 68 1 0
    //   32: istore_2
    //   33: iload_2
    //   34: ifeq +9 -> 43
    //   37: iconst_1
    //   38: istore_2
    //   39: aload_0
    //   40: monitorexit
    //   41: iload_2
    //   42: ireturn
    //   43: iload_1
    //   44: iconst_1
    //   45: isub
    //   46: istore_1
    //   47: goto -35 -> 12
    //   50: iconst_0
    //   51: istore_2
    //   52: goto -13 -> 39
    //   55: astore_3
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_3
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	ig
    //   11	36	1	i	int
    //   32	20	2	bool	boolean
    //   55	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	55	finally
    //   16	33	55	finally
  }
  
  /* Error */
  public final boolean c(float paramFloat1, float paramFloat2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 18	com/tencent/map/sdk/a/ig:a	Ljava/util/ArrayList;
    //   6: invokevirtual 23	java/util/ArrayList:size	()I
    //   9: iconst_1
    //   10: isub
    //   11: istore_3
    //   12: iload_3
    //   13: iflt +43 -> 56
    //   16: aload_0
    //   17: getfield 18	com/tencent/map/sdk/a/ig:a	Ljava/util/ArrayList;
    //   20: iload_3
    //   21: invokevirtual 27	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   24: checkcast 6	com/tencent/map/sdk/a/gr
    //   27: fload_1
    //   28: fload_2
    //   29: invokeinterface 70 3 0
    //   34: istore 4
    //   36: iload 4
    //   38: ifeq +11 -> 49
    //   41: iconst_1
    //   42: istore 4
    //   44: aload_0
    //   45: monitorexit
    //   46: iload 4
    //   48: ireturn
    //   49: iload_3
    //   50: iconst_1
    //   51: isub
    //   52: istore_3
    //   53: goto -41 -> 12
    //   56: iconst_0
    //   57: istore 4
    //   59: goto -15 -> 44
    //   62: astore 5
    //   64: aload_0
    //   65: monitorexit
    //   66: aload 5
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	ig
    //   0	69	1	paramFloat1	float
    //   0	69	2	paramFloat2	float
    //   11	42	3	i	int
    //   34	24	4	bool	boolean
    //   62	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	62	finally
    //   16	36	62	finally
  }
  
  /* Error */
  public final boolean d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 18	com/tencent/map/sdk/a/ig:a	Ljava/util/ArrayList;
    //   6: invokevirtual 23	java/util/ArrayList:size	()I
    //   9: iconst_1
    //   10: isub
    //   11: istore_1
    //   12: iload_1
    //   13: iflt +37 -> 50
    //   16: aload_0
    //   17: getfield 18	com/tencent/map/sdk/a/ig:a	Ljava/util/ArrayList;
    //   20: iload_1
    //   21: invokevirtual 27	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   24: checkcast 6	com/tencent/map/sdk/a/gr
    //   27: invokeinterface 73 1 0
    //   32: istore_2
    //   33: iload_2
    //   34: ifeq +9 -> 43
    //   37: iconst_1
    //   38: istore_2
    //   39: aload_0
    //   40: monitorexit
    //   41: iload_2
    //   42: ireturn
    //   43: iload_1
    //   44: iconst_1
    //   45: isub
    //   46: istore_1
    //   47: goto -35 -> 12
    //   50: iconst_0
    //   51: istore_2
    //   52: goto -13 -> 39
    //   55: astore_3
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_3
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	ig
    //   11	36	1	i	int
    //   32	20	2	bool	boolean
    //   55	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	55	finally
    //   16	33	55	finally
  }
  
  /* Error */
  public final boolean d(float paramFloat1, float paramFloat2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 18	com/tencent/map/sdk/a/ig:a	Ljava/util/ArrayList;
    //   6: invokevirtual 23	java/util/ArrayList:size	()I
    //   9: iconst_1
    //   10: isub
    //   11: istore_3
    //   12: iload_3
    //   13: iflt +43 -> 56
    //   16: aload_0
    //   17: getfield 18	com/tencent/map/sdk/a/ig:a	Ljava/util/ArrayList;
    //   20: iload_3
    //   21: invokevirtual 27	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   24: checkcast 6	com/tencent/map/sdk/a/gr
    //   27: fload_1
    //   28: fload_2
    //   29: invokeinterface 75 3 0
    //   34: istore 4
    //   36: iload 4
    //   38: ifeq +11 -> 49
    //   41: iconst_1
    //   42: istore 4
    //   44: aload_0
    //   45: monitorexit
    //   46: iload 4
    //   48: ireturn
    //   49: iload_3
    //   50: iconst_1
    //   51: isub
    //   52: istore_3
    //   53: goto -41 -> 12
    //   56: iconst_0
    //   57: istore 4
    //   59: goto -15 -> 44
    //   62: astore 5
    //   64: aload_0
    //   65: monitorexit
    //   66: aload 5
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	ig
    //   0	69	1	paramFloat1	float
    //   0	69	2	paramFloat2	float
    //   11	42	3	i	int
    //   34	24	4	bool	boolean
    //   62	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	62	finally
    //   16	36	62	finally
  }
  
  /* Error */
  public final boolean e(float paramFloat1, float paramFloat2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 18	com/tencent/map/sdk/a/ig:a	Ljava/util/ArrayList;
    //   6: invokevirtual 23	java/util/ArrayList:size	()I
    //   9: iconst_1
    //   10: isub
    //   11: istore_3
    //   12: iload_3
    //   13: iflt +43 -> 56
    //   16: aload_0
    //   17: getfield 18	com/tencent/map/sdk/a/ig:a	Ljava/util/ArrayList;
    //   20: iload_3
    //   21: invokevirtual 27	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   24: checkcast 6	com/tencent/map/sdk/a/gr
    //   27: fload_1
    //   28: fload_2
    //   29: invokeinterface 78 3 0
    //   34: istore 4
    //   36: iload 4
    //   38: ifeq +11 -> 49
    //   41: iconst_1
    //   42: istore 4
    //   44: aload_0
    //   45: monitorexit
    //   46: iload 4
    //   48: ireturn
    //   49: iload_3
    //   50: iconst_1
    //   51: isub
    //   52: istore_3
    //   53: goto -41 -> 12
    //   56: iconst_0
    //   57: istore 4
    //   59: goto -15 -> 44
    //   62: astore 5
    //   64: aload_0
    //   65: monitorexit
    //   66: aload 5
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	ig
    //   0	69	1	paramFloat1	float
    //   0	69	2	paramFloat2	float
    //   11	42	3	i	int
    //   34	24	4	bool	boolean
    //   62	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	62	finally
    //   16	36	62	finally
  }
  
  /* Error */
  public final boolean f(float paramFloat1, float paramFloat2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 18	com/tencent/map/sdk/a/ig:a	Ljava/util/ArrayList;
    //   6: invokevirtual 23	java/util/ArrayList:size	()I
    //   9: iconst_1
    //   10: isub
    //   11: istore_3
    //   12: iload_3
    //   13: iflt +43 -> 56
    //   16: aload_0
    //   17: getfield 18	com/tencent/map/sdk/a/ig:a	Ljava/util/ArrayList;
    //   20: iload_3
    //   21: invokevirtual 27	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   24: checkcast 6	com/tencent/map/sdk/a/gr
    //   27: fload_1
    //   28: fload_2
    //   29: invokeinterface 81 3 0
    //   34: istore 4
    //   36: iload 4
    //   38: ifeq +11 -> 49
    //   41: iconst_1
    //   42: istore 4
    //   44: aload_0
    //   45: monitorexit
    //   46: iload 4
    //   48: ireturn
    //   49: iload_3
    //   50: iconst_1
    //   51: isub
    //   52: istore_3
    //   53: goto -41 -> 12
    //   56: iconst_0
    //   57: istore 4
    //   59: goto -15 -> 44
    //   62: astore 5
    //   64: aload_0
    //   65: monitorexit
    //   66: aload 5
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	ig
    //   0	69	1	paramFloat1	float
    //   0	69	2	paramFloat2	float
    //   11	42	3	i	int
    //   34	24	4	bool	boolean
    //   62	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	62	finally
    //   16	36	62	finally
  }
  
  /* Error */
  public final boolean g(float paramFloat1, float paramFloat2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 18	com/tencent/map/sdk/a/ig:a	Ljava/util/ArrayList;
    //   6: invokevirtual 23	java/util/ArrayList:size	()I
    //   9: iconst_1
    //   10: isub
    //   11: istore_3
    //   12: iload_3
    //   13: iflt +43 -> 56
    //   16: aload_0
    //   17: getfield 18	com/tencent/map/sdk/a/ig:a	Ljava/util/ArrayList;
    //   20: iload_3
    //   21: invokevirtual 27	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   24: checkcast 6	com/tencent/map/sdk/a/gr
    //   27: fload_1
    //   28: fload_2
    //   29: invokeinterface 84 3 0
    //   34: istore 4
    //   36: iload 4
    //   38: ifeq +11 -> 49
    //   41: iconst_1
    //   42: istore 4
    //   44: aload_0
    //   45: monitorexit
    //   46: iload 4
    //   48: ireturn
    //   49: iload_3
    //   50: iconst_1
    //   51: isub
    //   52: istore_3
    //   53: goto -41 -> 12
    //   56: iconst_0
    //   57: istore 4
    //   59: goto -15 -> 44
    //   62: astore 5
    //   64: aload_0
    //   65: monitorexit
    //   66: aload 5
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	ig
    //   0	69	1	paramFloat1	float
    //   0	69	2	paramFloat2	float
    //   11	42	3	i	int
    //   34	24	4	bool	boolean
    //   62	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	62	finally
    //   16	36	62	finally
  }
  
  /* Error */
  public final boolean h(float paramFloat1, float paramFloat2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 18	com/tencent/map/sdk/a/ig:a	Ljava/util/ArrayList;
    //   6: invokevirtual 23	java/util/ArrayList:size	()I
    //   9: iconst_1
    //   10: isub
    //   11: istore_3
    //   12: iload_3
    //   13: iflt +43 -> 56
    //   16: aload_0
    //   17: getfield 18	com/tencent/map/sdk/a/ig:a	Ljava/util/ArrayList;
    //   20: iload_3
    //   21: invokevirtual 27	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   24: checkcast 6	com/tencent/map/sdk/a/gr
    //   27: fload_1
    //   28: fload_2
    //   29: invokeinterface 87 3 0
    //   34: istore 4
    //   36: iload 4
    //   38: ifeq +11 -> 49
    //   41: iconst_1
    //   42: istore 4
    //   44: aload_0
    //   45: monitorexit
    //   46: iload 4
    //   48: ireturn
    //   49: iload_3
    //   50: iconst_1
    //   51: isub
    //   52: istore_3
    //   53: goto -41 -> 12
    //   56: iconst_0
    //   57: istore 4
    //   59: goto -15 -> 44
    //   62: astore 5
    //   64: aload_0
    //   65: monitorexit
    //   66: aload 5
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	ig
    //   0	69	1	paramFloat1	float
    //   0	69	2	paramFloat2	float
    //   11	42	3	i	int
    //   34	24	4	bool	boolean
    //   62	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	62	finally
    //   16	36	62	finally
  }
  
  /* Error */
  public final boolean i(float paramFloat1, float paramFloat2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 18	com/tencent/map/sdk/a/ig:a	Ljava/util/ArrayList;
    //   6: invokevirtual 23	java/util/ArrayList:size	()I
    //   9: iconst_1
    //   10: isub
    //   11: istore_3
    //   12: iload_3
    //   13: iflt +43 -> 56
    //   16: aload_0
    //   17: getfield 18	com/tencent/map/sdk/a/ig:a	Ljava/util/ArrayList;
    //   20: iload_3
    //   21: invokevirtual 27	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   24: checkcast 6	com/tencent/map/sdk/a/gr
    //   27: fload_1
    //   28: fload_2
    //   29: invokeinterface 90 3 0
    //   34: istore 4
    //   36: iload 4
    //   38: ifeq +11 -> 49
    //   41: iconst_1
    //   42: istore 4
    //   44: aload_0
    //   45: monitorexit
    //   46: iload 4
    //   48: ireturn
    //   49: iload_3
    //   50: iconst_1
    //   51: isub
    //   52: istore_3
    //   53: goto -41 -> 12
    //   56: iconst_0
    //   57: istore 4
    //   59: goto -15 -> 44
    //   62: astore 5
    //   64: aload_0
    //   65: monitorexit
    //   66: aload 5
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	ig
    //   0	69	1	paramFloat1	float
    //   0	69	2	paramFloat2	float
    //   11	42	3	i	int
    //   34	24	4	bool	boolean
    //   62	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	62	finally
    //   16	36	62	finally
  }
  
  /* Error */
  public final boolean j(float paramFloat1, float paramFloat2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 18	com/tencent/map/sdk/a/ig:a	Ljava/util/ArrayList;
    //   6: invokevirtual 23	java/util/ArrayList:size	()I
    //   9: iconst_1
    //   10: isub
    //   11: istore_3
    //   12: iload_3
    //   13: iflt +43 -> 56
    //   16: aload_0
    //   17: getfield 18	com/tencent/map/sdk/a/ig:a	Ljava/util/ArrayList;
    //   20: iload_3
    //   21: invokevirtual 27	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   24: checkcast 6	com/tencent/map/sdk/a/gr
    //   27: fload_1
    //   28: fload_2
    //   29: invokeinterface 93 3 0
    //   34: istore 4
    //   36: iload 4
    //   38: ifeq +11 -> 49
    //   41: iconst_1
    //   42: istore 4
    //   44: aload_0
    //   45: monitorexit
    //   46: iload 4
    //   48: ireturn
    //   49: iload_3
    //   50: iconst_1
    //   51: isub
    //   52: istore_3
    //   53: goto -41 -> 12
    //   56: iconst_0
    //   57: istore 4
    //   59: goto -15 -> 44
    //   62: astore 5
    //   64: aload_0
    //   65: monitorexit
    //   66: aload 5
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	ig
    //   0	69	1	paramFloat1	float
    //   0	69	2	paramFloat2	float
    //   11	42	3	i	int
    //   34	24	4	bool	boolean
    //   62	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	62	finally
    //   16	36	62	finally
  }
  
  public final boolean k(float paramFloat1, float paramFloat2)
  {
    int i = this.a.size() - 1;
    while (i >= 0)
    {
      if (((gr)this.a.get(i)).k(paramFloat1, paramFloat2)) {
        return true;
      }
      i -= 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.ig
 * JD-Core Version:    0.7.0.1
 */