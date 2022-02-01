package com.google.android.exoplayer2.util;

public final class LibraryLoader
{
  private boolean isAvailable;
  private boolean loadAttempted;
  private String[] nativeLibraries;
  
  public LibraryLoader(String... paramVarArgs)
  {
    this.nativeLibraries = paramVarArgs;
  }
  
  /* Error */
  public boolean isAvailable()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 22	com/google/android/exoplayer2/util/LibraryLoader:loadAttempted	Z
    //   6: ifeq +12 -> 18
    //   9: aload_0
    //   10: getfield 24	com/google/android/exoplayer2/util/LibraryLoader:isAvailable	Z
    //   13: istore_3
    //   14: aload_0
    //   15: monitorexit
    //   16: iload_3
    //   17: ireturn
    //   18: aload_0
    //   19: iconst_1
    //   20: putfield 22	com/google/android/exoplayer2/util/LibraryLoader:loadAttempted	Z
    //   23: aload_0
    //   24: getfield 16	com/google/android/exoplayer2/util/LibraryLoader:nativeLibraries	[Ljava/lang/String;
    //   27: astore 4
    //   29: aload 4
    //   31: arraylength
    //   32: istore_2
    //   33: iconst_0
    //   34: istore_1
    //   35: iload_1
    //   36: iload_2
    //   37: if_icmpge +17 -> 54
    //   40: aload 4
    //   42: iload_1
    //   43: aaload
    //   44: invokestatic 30	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   47: iload_1
    //   48: iconst_1
    //   49: iadd
    //   50: istore_1
    //   51: goto -16 -> 35
    //   54: aload_0
    //   55: iconst_1
    //   56: putfield 24	com/google/android/exoplayer2/util/LibraryLoader:isAvailable	Z
    //   59: aload_0
    //   60: getfield 24	com/google/android/exoplayer2/util/LibraryLoader:isAvailable	Z
    //   63: istore_3
    //   64: goto -50 -> 14
    //   67: astore 4
    //   69: ldc 2
    //   71: invokevirtual 36	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   74: new 38	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   81: ldc 41
    //   83: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: aload 4
    //   88: invokevirtual 48	java/lang/UnsatisfiedLinkError:toString	()Ljava/lang/String;
    //   91: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokestatic 55	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   100: pop
    //   101: goto -42 -> 59
    //   104: astore 4
    //   106: aload_0
    //   107: monitorexit
    //   108: aload 4
    //   110: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	LibraryLoader
    //   34	17	1	i	int
    //   32	6	2	j	int
    //   13	51	3	bool	boolean
    //   27	14	4	arrayOfString	String[]
    //   67	20	4	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   104	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   23	33	67	java/lang/UnsatisfiedLinkError
    //   40	47	67	java/lang/UnsatisfiedLinkError
    //   54	59	67	java/lang/UnsatisfiedLinkError
    //   2	14	104	finally
    //   18	23	104	finally
    //   23	33	104	finally
    //   40	47	104	finally
    //   54	59	104	finally
    //   59	64	104	finally
    //   69	101	104	finally
  }
  
  /* Error */
  public void setLibraries(String... paramVarArgs)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 22	com/google/android/exoplayer2/util/LibraryLoader:loadAttempted	Z
    //   6: ifne +19 -> 25
    //   9: iconst_1
    //   10: istore_2
    //   11: iload_2
    //   12: ldc 58
    //   14: invokestatic 64	com/google/android/exoplayer2/util/Assertions:checkState	(ZLjava/lang/Object;)V
    //   17: aload_0
    //   18: aload_1
    //   19: putfield 16	com/google/android/exoplayer2/util/LibraryLoader:nativeLibraries	[Ljava/lang/String;
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: iconst_0
    //   26: istore_2
    //   27: goto -16 -> 11
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_1
    //   34: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	this	LibraryLoader
    //   0	35	1	paramVarArgs	String[]
    //   10	17	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	9	30	finally
    //   11	22	30	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.util.LibraryLoader
 * JD-Core Version:    0.7.0.1
 */