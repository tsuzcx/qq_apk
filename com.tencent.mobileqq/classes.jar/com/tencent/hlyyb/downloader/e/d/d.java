package com.tencent.hlyyb.downloader.e.d;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class d
{
  List<a> a;
  List<a> b;
  a c;
  a d;
  boolean e = false;
  boolean f = false;
  private String g;
  private List<a> h;
  private List<a> i;
  private List<a> j;
  
  public d(c paramc, String paramString)
  {
    this.g = paramString;
  }
  
  private static void a(StringBuilder paramStringBuilder, List<a> paramList)
  {
    if (paramList != null) {
      if (paramList != null) {
        try
        {
          if (paramList.size() > 0)
          {
            Iterator localIterator = paramList.iterator();
            while (localIterator.hasNext())
            {
              a locala = (a)localIterator.next();
              if (locala != null) {
                paramStringBuilder.append(locala).append(",");
              }
            }
          }
        }
        finally {}
      }
    }
  }
  
  private List<a> b(int paramInt)
  {
    List localList = null;
    if (paramInt == b.c) {
      localList = this.h;
    }
    do
    {
      return localList;
      if (paramInt == b.e) {
        return this.i;
      }
      if (paramInt == b.f) {
        return this.a;
      }
      if (paramInt == b.j) {
        return this.b;
      }
    } while (paramInt != b.h);
    return this.j;
  }
  
  /* Error */
  public final a a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: getstatic 99	com/tencent/hlyyb/downloader/e/d/b:d	I
    //   6: if_icmpne +12 -> 18
    //   9: aload_0
    //   10: getfield 101	com/tencent/hlyyb/downloader/e/d/d:c	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   13: astore_2
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_2
    //   17: areturn
    //   18: iload_1
    //   19: getstatic 103	com/tencent/hlyyb/downloader/e/d/b:i	I
    //   22: if_icmpne +11 -> 33
    //   25: aload_0
    //   26: getfield 105	com/tencent/hlyyb/downloader/e/d/d:d	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   29: astore_2
    //   30: goto -16 -> 14
    //   33: iload_1
    //   34: invokestatic 108	com/tencent/hlyyb/downloader/e/d/a:b	(I)Z
    //   37: ifeq +27 -> 64
    //   40: aload_0
    //   41: iload_1
    //   42: invokespecial 110	com/tencent/hlyyb/downloader/e/d/d:b	(I)Ljava/util/List;
    //   45: astore_2
    //   46: aload_2
    //   47: ifnull +17 -> 64
    //   50: aload_2
    //   51: iconst_0
    //   52: invokeinterface 114 2 0
    //   57: checkcast 58	com/tencent/hlyyb/downloader/e/d/a
    //   60: astore_2
    //   61: goto -47 -> 14
    //   64: aconst_null
    //   65: astore_2
    //   66: goto -52 -> 14
    //   69: astore_2
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_2
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	d
    //   0	74	1	paramInt	int
    //   13	53	2	localObject1	Object
    //   69	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	69	finally
    //   18	30	69	finally
    //   33	46	69	finally
    //   50	61	69	finally
  }
  
  /* Error */
  public final a a(a parama)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_1
    //   6: ifnonnull +10 -> 16
    //   9: aload 4
    //   11: astore_3
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_3
    //   15: areturn
    //   16: aload_0
    //   17: aload_1
    //   18: getfield 117	com/tencent/hlyyb/downloader/e/d/a:b	I
    //   21: invokespecial 110	com/tencent/hlyyb/downloader/e/d/d:b	(I)Ljava/util/List;
    //   24: astore 5
    //   26: aload 4
    //   28: astore_3
    //   29: aload 5
    //   31: ifnull -19 -> 12
    //   34: iconst_0
    //   35: istore_2
    //   36: aload 4
    //   38: astore_3
    //   39: iload_2
    //   40: aload 5
    //   42: invokeinterface 42 1 0
    //   47: if_icmpge -35 -> 12
    //   50: aload_1
    //   51: aload 5
    //   53: iload_2
    //   54: invokeinterface 114 2 0
    //   59: if_acmpne +36 -> 95
    //   62: aload 4
    //   64: astore_3
    //   65: iload_2
    //   66: aload 5
    //   68: invokeinterface 42 1 0
    //   73: iconst_1
    //   74: isub
    //   75: if_icmpeq -63 -> 12
    //   78: aload 5
    //   80: iload_2
    //   81: iconst_1
    //   82: iadd
    //   83: invokeinterface 114 2 0
    //   88: checkcast 58	com/tencent/hlyyb/downloader/e/d/a
    //   91: astore_3
    //   92: goto -80 -> 12
    //   95: iload_2
    //   96: iconst_1
    //   97: iadd
    //   98: istore_2
    //   99: goto -63 -> 36
    //   102: astore_1
    //   103: aload_0
    //   104: monitorexit
    //   105: aload_1
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	d
    //   0	107	1	parama	a
    //   35	64	2	m	int
    //   11	81	3	localObject1	Object
    //   1	62	4	localObject2	Object
    //   24	55	5	localList	List
    // Exception table:
    //   from	to	target	type
    //   16	26	102	finally
    //   39	62	102	finally
    //   65	92	102	finally
  }
  
  public final List<a> a()
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.k.a);
      List localList = this.h;
      if ((localList != null) && (localList.size() > 0)) {
        localArrayList.addAll(localList);
      }
      localList = this.i;
      if ((localList != null) && (localList.size() > 0)) {
        localArrayList.addAll(localList);
      }
      localList = this.a;
      if ((localList != null) && (localList.size() > 0)) {
        localArrayList.addAll(localList);
      }
      localList = this.b;
      if ((localList != null) && (localList.size() > 0)) {
        localArrayList.addAll(localList);
      }
      if (this.c != null) {
        localArrayList.add(this.c);
      }
      localList = this.j;
      if ((localList != null) && (localList.size() > 0)) {
        localArrayList.addAll(localList);
      }
      if (this.d != null) {
        localArrayList.add(this.d);
      }
      if (this.k.b != null) {
        localArrayList.add(this.k.b);
      }
      return localArrayList;
    }
    finally {}
  }
  
  /* Error */
  public final void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 143	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 101	com/tencent/hlyyb/downloader/e/d/d:c	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   18: ifnonnull -7 -> 11
    //   21: aload_0
    //   22: new 58	com/tencent/hlyyb/downloader/e/d/a
    //   25: dup
    //   26: aload_1
    //   27: getstatic 99	com/tencent/hlyyb/downloader/e/d/b:d	I
    //   30: invokespecial 146	com/tencent/hlyyb/downloader/e/d/a:<init>	(Ljava/lang/String;I)V
    //   33: putfield 101	com/tencent/hlyyb/downloader/e/d/d:c	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   36: aload_0
    //   37: getfield 101	com/tencent/hlyyb/downloader/e/d/d:c	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   40: aload_0
    //   41: getfield 25	com/tencent/hlyyb/downloader/e/d/d:k	Lcom/tencent/hlyyb/downloader/e/d/c;
    //   44: invokestatic 149	com/tencent/hlyyb/downloader/e/d/c:e	(Lcom/tencent/hlyyb/downloader/e/d/c;)Ljava/util/concurrent/atomic/AtomicInteger;
    //   47: invokevirtual 154	java/util/concurrent/atomic/AtomicInteger:getAndIncrement	()I
    //   50: putfield 155	com/tencent/hlyyb/downloader/e/d/a:c	I
    //   53: goto -42 -> 11
    //   56: astore_1
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_1
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	d
    //   0	61	1	paramString	String
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	56	finally
    //   14	53	56	finally
  }
  
  /* Error */
  public final void a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 143	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: iload_2
    //   15: getstatic 77	com/tencent/hlyyb/downloader/e/d/b:c	I
    //   18: if_icmpne +69 -> 87
    //   21: aload_0
    //   22: getfield 79	com/tencent/hlyyb/downloader/e/d/d:h	Ljava/util/List;
    //   25: ifnonnull +14 -> 39
    //   28: aload_0
    //   29: new 120	java/util/ArrayList
    //   32: dup
    //   33: invokespecial 121	java/util/ArrayList:<init>	()V
    //   36: putfield 79	com/tencent/hlyyb/downloader/e/d/d:h	Ljava/util/List;
    //   39: aload_0
    //   40: getfield 79	com/tencent/hlyyb/downloader/e/d/d:h	Ljava/util/List;
    //   43: astore 4
    //   45: aload 4
    //   47: invokeinterface 46 1 0
    //   52: astore 5
    //   54: aload 5
    //   56: invokeinterface 52 1 0
    //   61: ifeq +162 -> 223
    //   64: aload_1
    //   65: aload 5
    //   67: invokeinterface 56 1 0
    //   72: checkcast 58	com/tencent/hlyyb/downloader/e/d/a
    //   75: getfield 157	com/tencent/hlyyb/downloader/e/d/a:a	Ljava/lang/String;
    //   78: invokevirtual 163	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   81: ifeq -27 -> 54
    //   84: goto -73 -> 11
    //   87: iload_2
    //   88: getstatic 81	com/tencent/hlyyb/downloader/e/d/b:e	I
    //   91: if_icmpne +30 -> 121
    //   94: aload_0
    //   95: getfield 83	com/tencent/hlyyb/downloader/e/d/d:i	Ljava/util/List;
    //   98: ifnonnull +14 -> 112
    //   101: aload_0
    //   102: new 120	java/util/ArrayList
    //   105: dup
    //   106: invokespecial 121	java/util/ArrayList:<init>	()V
    //   109: putfield 83	com/tencent/hlyyb/downloader/e/d/d:i	Ljava/util/List;
    //   112: aload_0
    //   113: getfield 83	com/tencent/hlyyb/downloader/e/d/d:i	Ljava/util/List;
    //   116: astore 4
    //   118: goto -73 -> 45
    //   121: iload_2
    //   122: getstatic 85	com/tencent/hlyyb/downloader/e/d/b:f	I
    //   125: if_icmpne +30 -> 155
    //   128: aload_0
    //   129: getfield 87	com/tencent/hlyyb/downloader/e/d/d:a	Ljava/util/List;
    //   132: ifnonnull +14 -> 146
    //   135: aload_0
    //   136: new 120	java/util/ArrayList
    //   139: dup
    //   140: invokespecial 121	java/util/ArrayList:<init>	()V
    //   143: putfield 87	com/tencent/hlyyb/downloader/e/d/d:a	Ljava/util/List;
    //   146: aload_0
    //   147: getfield 87	com/tencent/hlyyb/downloader/e/d/d:a	Ljava/util/List;
    //   150: astore 4
    //   152: goto -107 -> 45
    //   155: iload_2
    //   156: getstatic 89	com/tencent/hlyyb/downloader/e/d/b:j	I
    //   159: if_icmpne +30 -> 189
    //   162: aload_0
    //   163: getfield 91	com/tencent/hlyyb/downloader/e/d/d:b	Ljava/util/List;
    //   166: ifnonnull +14 -> 180
    //   169: aload_0
    //   170: new 120	java/util/ArrayList
    //   173: dup
    //   174: invokespecial 121	java/util/ArrayList:<init>	()V
    //   177: putfield 91	com/tencent/hlyyb/downloader/e/d/d:b	Ljava/util/List;
    //   180: aload_0
    //   181: getfield 91	com/tencent/hlyyb/downloader/e/d/d:b	Ljava/util/List;
    //   184: astore 4
    //   186: goto -141 -> 45
    //   189: iload_2
    //   190: getstatic 93	com/tencent/hlyyb/downloader/e/d/b:h	I
    //   193: if_icmpne -182 -> 11
    //   196: aload_0
    //   197: getfield 95	com/tencent/hlyyb/downloader/e/d/d:j	Ljava/util/List;
    //   200: ifnonnull +14 -> 214
    //   203: aload_0
    //   204: new 120	java/util/ArrayList
    //   207: dup
    //   208: invokespecial 121	java/util/ArrayList:<init>	()V
    //   211: putfield 95	com/tencent/hlyyb/downloader/e/d/d:j	Ljava/util/List;
    //   214: aload_0
    //   215: getfield 95	com/tencent/hlyyb/downloader/e/d/d:j	Ljava/util/List;
    //   218: astore 4
    //   220: goto -175 -> 45
    //   223: new 58	com/tencent/hlyyb/downloader/e/d/a
    //   226: dup
    //   227: aload_1
    //   228: iload_2
    //   229: invokespecial 146	com/tencent/hlyyb/downloader/e/d/a:<init>	(Ljava/lang/String;I)V
    //   232: astore_1
    //   233: aload_1
    //   234: aload_0
    //   235: getfield 25	com/tencent/hlyyb/downloader/e/d/d:k	Lcom/tencent/hlyyb/downloader/e/d/c;
    //   238: invokestatic 149	com/tencent/hlyyb/downloader/e/d/c:e	(Lcom/tencent/hlyyb/downloader/e/d/c;)Ljava/util/concurrent/atomic/AtomicInteger;
    //   241: invokevirtual 154	java/util/concurrent/atomic/AtomicInteger:getAndIncrement	()I
    //   244: putfield 155	com/tencent/hlyyb/downloader/e/d/a:c	I
    //   247: aload 4
    //   249: aload_1
    //   250: invokeinterface 129 2 0
    //   255: pop
    //   256: goto -245 -> 11
    //   259: astore_1
    //   260: aload_0
    //   261: monitorexit
    //   262: aload_1
    //   263: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	this	d
    //   0	264	1	paramString	String
    //   0	264	2	paramInt	int
    //   6	2	3	bool	boolean
    //   43	205	4	localList	List
    //   52	14	5	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	7	259	finally
    //   14	39	259	finally
    //   39	45	259	finally
    //   45	54	259	finally
    //   54	84	259	finally
    //   87	112	259	finally
    //   112	118	259	finally
    //   121	146	259	finally
    //   146	152	259	finally
    //   155	180	259	finally
    //   180	186	259	finally
    //   189	214	259	finally
    //   214	220	259	finally
    //   223	256	259	finally
  }
  
  /* Error */
  public final void b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 143	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 105	com/tencent/hlyyb/downloader/e/d/d:d	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   18: ifnonnull -7 -> 11
    //   21: aload_0
    //   22: new 58	com/tencent/hlyyb/downloader/e/d/a
    //   25: dup
    //   26: aload_1
    //   27: getstatic 103	com/tencent/hlyyb/downloader/e/d/b:i	I
    //   30: invokespecial 146	com/tencent/hlyyb/downloader/e/d/a:<init>	(Ljava/lang/String;I)V
    //   33: putfield 105	com/tencent/hlyyb/downloader/e/d/d:d	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   36: aload_0
    //   37: getfield 105	com/tencent/hlyyb/downloader/e/d/d:d	Lcom/tencent/hlyyb/downloader/e/d/a;
    //   40: aload_0
    //   41: getfield 25	com/tencent/hlyyb/downloader/e/d/d:k	Lcom/tencent/hlyyb/downloader/e/d/c;
    //   44: invokestatic 149	com/tencent/hlyyb/downloader/e/d/c:e	(Lcom/tencent/hlyyb/downloader/e/d/c;)Ljava/util/concurrent/atomic/AtomicInteger;
    //   47: invokevirtual 154	java/util/concurrent/atomic/AtomicInteger:getAndIncrement	()I
    //   50: putfield 155	com/tencent/hlyyb/downloader/e/d/a:c	I
    //   53: goto -42 -> 11
    //   56: astore_1
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_1
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	d
    //   0	61	1	paramString	String
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	56	finally
    //   14	53	56	finally
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(com.tencent.hlyyb.common.b.b.b(this.g));
    localStringBuilder.append(",");
    a(localStringBuilder, this.h);
    a(localStringBuilder, this.i);
    a(localStringBuilder, this.a);
    a(localStringBuilder, this.b);
    if (this.c != null) {
      localStringBuilder.append(this.c).append(",");
    }
    a(localStringBuilder, this.j);
    if (this.d != null) {
      localStringBuilder.append(this.d);
    }
    localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.e.d.d
 * JD-Core Version:    0.7.0.1
 */