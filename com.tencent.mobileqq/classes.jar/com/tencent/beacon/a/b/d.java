package com.tencent.beacon.a.b;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public final class d
{
  private static d a;
  private int b = 12;
  private int c = 60;
  private int d = 12;
  private int e = 60;
  private int f = 20;
  private boolean g = false;
  private boolean h = true;
  private Set<String> i = null;
  private Map<String, Float> j = null;
  private boolean k = false;
  private boolean l = false;
  private int m = 10485760;
  private boolean n = false;
  private float o = 1.0F;
  private boolean p = false;
  private int q = 1;
  
  public static d a()
  {
    try
    {
      if (a == null) {
        a = new d();
      }
      d locald = a;
      return locald;
    }
    finally {}
  }
  
  /* Error */
  public final void a(Map<String, String> paramMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +441 -> 444
    //   6: aload_0
    //   7: aload_1
    //   8: ldc 76
    //   10: invokeinterface 82 2 0
    //   15: checkcast 84	java/lang/String
    //   18: aload_0
    //   19: getfield 35	com/tencent/beacon/a/b/d:b	I
    //   22: iconst_1
    //   23: bipush 50
    //   25: invokestatic 89	com/tencent/beacon/a/a:a	(Ljava/lang/String;III)I
    //   28: putfield 35	com/tencent/beacon/a/b/d:b	I
    //   31: aload_0
    //   32: aload_1
    //   33: ldc 91
    //   35: invokeinterface 82 2 0
    //   40: checkcast 84	java/lang/String
    //   43: aload_0
    //   44: getfield 37	com/tencent/beacon/a/b/d:c	I
    //   47: bipush 10
    //   49: sipush 600
    //   52: invokestatic 89	com/tencent/beacon/a/a:a	(Ljava/lang/String;III)I
    //   55: putfield 37	com/tencent/beacon/a/b/d:c	I
    //   58: aload_0
    //   59: aload_1
    //   60: ldc 93
    //   62: invokeinterface 82 2 0
    //   67: checkcast 84	java/lang/String
    //   70: aload_0
    //   71: getfield 39	com/tencent/beacon/a/b/d:d	I
    //   74: iconst_1
    //   75: bipush 50
    //   77: invokestatic 89	com/tencent/beacon/a/a:a	(Ljava/lang/String;III)I
    //   80: putfield 39	com/tencent/beacon/a/b/d:d	I
    //   83: aload_0
    //   84: aload_1
    //   85: ldc 95
    //   87: invokeinterface 82 2 0
    //   92: checkcast 84	java/lang/String
    //   95: aload_0
    //   96: getfield 41	com/tencent/beacon/a/b/d:e	I
    //   99: bipush 30
    //   101: sipush 600
    //   104: invokestatic 89	com/tencent/beacon/a/a:a	(Ljava/lang/String;III)I
    //   107: putfield 41	com/tencent/beacon/a/b/d:e	I
    //   110: aload_0
    //   111: aload_1
    //   112: ldc 97
    //   114: invokeinterface 82 2 0
    //   119: checkcast 84	java/lang/String
    //   122: aload_0
    //   123: getfield 43	com/tencent/beacon/a/b/d:f	I
    //   126: iconst_1
    //   127: bipush 100
    //   129: invokestatic 89	com/tencent/beacon/a/a:a	(Ljava/lang/String;III)I
    //   132: putfield 43	com/tencent/beacon/a/b/d:f	I
    //   135: aload_0
    //   136: aload_1
    //   137: ldc 99
    //   139: invokeinterface 82 2 0
    //   144: checkcast 84	java/lang/String
    //   147: aload_0
    //   148: getfield 47	com/tencent/beacon/a/b/d:h	Z
    //   151: invokestatic 102	com/tencent/beacon/a/a:a	(Ljava/lang/String;Z)Z
    //   154: putfield 47	com/tencent/beacon/a/b/d:h	Z
    //   157: aload_0
    //   158: aload_1
    //   159: ldc 104
    //   161: invokeinterface 82 2 0
    //   166: checkcast 84	java/lang/String
    //   169: aload_0
    //   170: getfield 53	com/tencent/beacon/a/b/d:k	Z
    //   173: invokestatic 102	com/tencent/beacon/a/a:a	(Ljava/lang/String;Z)Z
    //   176: putfield 53	com/tencent/beacon/a/b/d:k	Z
    //   179: aload_0
    //   180: aload_1
    //   181: ldc 106
    //   183: invokeinterface 82 2 0
    //   188: checkcast 84	java/lang/String
    //   191: aload_0
    //   192: getfield 55	com/tencent/beacon/a/b/d:l	Z
    //   195: invokestatic 102	com/tencent/beacon/a/a:a	(Ljava/lang/String;Z)Z
    //   198: putfield 55	com/tencent/beacon/a/b/d:l	Z
    //   201: aload_0
    //   202: aload_1
    //   203: ldc 108
    //   205: invokeinterface 82 2 0
    //   210: checkcast 84	java/lang/String
    //   213: aload_0
    //   214: getfield 45	com/tencent/beacon/a/b/d:g	Z
    //   217: invokestatic 102	com/tencent/beacon/a/a:a	(Ljava/lang/String;Z)Z
    //   220: putfield 45	com/tencent/beacon/a/b/d:g	Z
    //   223: aload_0
    //   224: aload_1
    //   225: ldc 110
    //   227: invokeinterface 82 2 0
    //   232: checkcast 84	java/lang/String
    //   235: aload_0
    //   236: getfield 58	com/tencent/beacon/a/b/d:m	I
    //   239: ldc 111
    //   241: ldc 56
    //   243: invokestatic 89	com/tencent/beacon/a/a:a	(Ljava/lang/String;III)I
    //   246: putfield 58	com/tencent/beacon/a/b/d:m	I
    //   249: aload_1
    //   250: ldc 113
    //   252: invokeinterface 82 2 0
    //   257: checkcast 84	java/lang/String
    //   260: getstatic 117	com/tencent/beacon/a/g/a:b	Z
    //   263: invokestatic 102	com/tencent/beacon/a/a:a	(Ljava/lang/String;Z)Z
    //   266: putstatic 117	com/tencent/beacon/a/g/a:b	Z
    //   269: aload_0
    //   270: aload_1
    //   271: ldc 119
    //   273: invokeinterface 82 2 0
    //   278: checkcast 84	java/lang/String
    //   281: aload_0
    //   282: getfield 60	com/tencent/beacon/a/b/d:n	Z
    //   285: invokestatic 102	com/tencent/beacon/a/a:a	(Ljava/lang/String;Z)Z
    //   288: putfield 60	com/tencent/beacon/a/b/d:n	Z
    //   291: aload_1
    //   292: ldc 121
    //   294: invokeinterface 82 2 0
    //   299: checkcast 84	java/lang/String
    //   302: astore_3
    //   303: aload_3
    //   304: ifnull +53 -> 357
    //   307: aload_3
    //   308: invokevirtual 125	java/lang/String:trim	()Ljava/lang/String;
    //   311: astore_3
    //   312: aload_3
    //   313: invokevirtual 129	java/lang/String:length	()I
    //   316: ifle +41 -> 357
    //   319: aload_3
    //   320: ldc 131
    //   322: invokevirtual 135	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   325: astore_3
    //   326: aload_3
    //   327: arraylength
    //   328: istore_2
    //   329: iload_2
    //   330: iconst_2
    //   331: if_icmpne +26 -> 357
    //   334: aload_0
    //   335: aload_3
    //   336: iconst_0
    //   337: aaload
    //   338: invokestatic 141	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   341: invokevirtual 145	java/lang/Float:floatValue	()F
    //   344: aload_3
    //   345: iconst_1
    //   346: aaload
    //   347: invokestatic 141	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   350: invokevirtual 145	java/lang/Float:floatValue	()F
    //   353: fdiv
    //   354: putfield 62	com/tencent/beacon/a/b/d:o	F
    //   357: aload_0
    //   358: aload_1
    //   359: ldc 147
    //   361: invokeinterface 82 2 0
    //   366: checkcast 84	java/lang/String
    //   369: aload_0
    //   370: getfield 64	com/tencent/beacon/a/b/d:p	Z
    //   373: invokestatic 102	com/tencent/beacon/a/a:a	(Ljava/lang/String;Z)Z
    //   376: putfield 64	com/tencent/beacon/a/b/d:p	Z
    //   379: aload_0
    //   380: aload_1
    //   381: ldc 149
    //   383: invokeinterface 82 2 0
    //   388: checkcast 84	java/lang/String
    //   391: aload_0
    //   392: getfield 66	com/tencent/beacon/a/b/d:q	I
    //   395: iconst_1
    //   396: ldc 150
    //   398: invokestatic 89	com/tencent/beacon/a/a:a	(Ljava/lang/String;III)I
    //   401: putfield 66	com/tencent/beacon/a/b/d:q	I
    //   404: aload_0
    //   405: getfield 37	com/tencent/beacon/a/b/d:c	I
    //   408: bipush 60
    //   410: if_icmpeq +14 -> 424
    //   413: invokestatic 155	com/tencent/beacon/a/b/j:g	()Lcom/tencent/beacon/a/b/j;
    //   416: invokevirtual 158	com/tencent/beacon/a/b/j:j	()Lcom/tencent/beacon/a/b/f;
    //   419: invokeinterface 162 1 0
    //   424: aload_0
    //   425: getfield 41	com/tencent/beacon/a/b/d:e	I
    //   428: bipush 60
    //   430: if_icmpeq +14 -> 444
    //   433: invokestatic 155	com/tencent/beacon/a/b/j:g	()Lcom/tencent/beacon/a/b/j;
    //   436: invokevirtual 164	com/tencent/beacon/a/b/j:i	()Lcom/tencent/beacon/a/b/f;
    //   439: invokeinterface 162 1 0
    //   444: aload_0
    //   445: monitorexit
    //   446: return
    //   447: astore_1
    //   448: aload_1
    //   449: invokestatic 167	com/tencent/beacon/a/g/a:a	(Ljava/lang/Throwable;)V
    //   452: goto -8 -> 444
    //   455: astore_1
    //   456: aload_0
    //   457: monitorexit
    //   458: aload_1
    //   459: athrow
    //   460: astore_3
    //   461: goto -104 -> 357
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	464	0	this	d
    //   0	464	1	paramMap	Map<String, String>
    //   328	4	2	i1	int
    //   302	43	3	localObject	Object
    //   460	1	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   6	303	447	java/lang/Exception
    //   307	329	447	java/lang/Exception
    //   357	424	447	java/lang/Exception
    //   424	444	447	java/lang/Exception
    //   6	303	455	finally
    //   307	329	455	finally
    //   334	357	455	finally
    //   357	424	455	finally
    //   424	444	455	finally
    //   448	452	455	finally
    //   334	357	460	java/lang/Exception
  }
  
  public final void a(Set<String> paramSet)
  {
    try
    {
      this.i = paramSet;
      return;
    }
    finally
    {
      paramSet = finally;
      throw paramSet;
    }
  }
  
  public final boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (this.i != null)
      {
        bool1 = bool2;
        if (this.i.size() > 0) {
          bool1 = this.i.contains(paramString);
        }
      }
      return bool1;
    }
    finally {}
  }
  
  public final int b()
  {
    try
    {
      int i1 = this.b;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void b(Set<String> paramSet)
  {
    try
    {
      if (this.j == null) {
        this.j = new HashMap();
      }
      paramSet = paramSet.iterator();
      while (paramSet.hasNext())
      {
        String[] arrayOfString = ((String)paramSet.next()).split(",");
        int i1 = arrayOfString.length;
        if (i1 == 3) {
          try
          {
            float f1 = Float.valueOf(arrayOfString[1]).floatValue() / Float.valueOf(arrayOfString[2]).floatValue();
            this.j.put(arrayOfString[0].toLowerCase(), Float.valueOf(f1));
          }
          catch (Exception localException) {}
        }
      }
      return;
    }
    finally {}
  }
  
  public final boolean b(String paramString)
  {
    for (;;)
    {
      try
      {
        boolean bool;
        if (this.j != null)
        {
          Object localObject = this.j.get(paramString);
          if (localObject != null) {}
        }
        else
        {
          bool = true;
          return bool;
        }
        int i1 = (int)(((Float)this.j.get(paramString.toLowerCase())).floatValue() * 1000.0F);
        int i2 = new Random().nextInt(1000);
        if (i2 + 1 > i1) {
          bool = false;
        } else {
          bool = true;
        }
      }
      finally {}
    }
  }
  
  public final int c()
  {
    try
    {
      int i1 = this.c;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int d()
  {
    try
    {
      int i1 = this.d;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int e()
  {
    try
    {
      int i1 = this.e;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int f()
  {
    try
    {
      int i1 = this.f;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean g()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    try
    {
      if (this.n)
      {
        Calendar localCalendar = Calendar.getInstance();
        int i1 = localCalendar.get(11);
        int i2 = localCalendar.get(12);
        bool1 = bool2;
        if (i1 == 0)
        {
          bool1 = bool2;
          if (i2 >= 0)
          {
            bool1 = bool2;
            if (30 >= i2)
            {
              i1 = (int)(this.o * 1000.0F);
              i2 = new Random().nextInt(1000);
              bool1 = bool2;
              if (i2 + 1 > i1) {
                bool1 = false;
              }
            }
          }
        }
      }
      return bool1;
    }
    finally {}
  }
  
  public final boolean h()
  {
    return this.g;
  }
  
  public final boolean i()
  {
    return this.k;
  }
  
  public final boolean j()
  {
    return this.l;
  }
  
  public final int k()
  {
    return this.m;
  }
  
  public final int l()
  {
    return this.q;
  }
  
  public final boolean m()
  {
    return this.p;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.b.d
 * JD-Core Version:    0.7.0.1
 */