package com.tencent.beacon.core.info;

public class IccIdJNI
{
  private static volatile String a;
  
  /* Error */
  public static String a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 13	com/tencent/beacon/core/info/IccIdJNI:a	Ljava/lang/String;
    //   6: ifnonnull +34 -> 40
    //   9: ldc 15
    //   11: invokestatic 21	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   14: invokestatic 24	com/tencent/beacon/core/info/IccIdJNI:collectIccid	()Ljava/lang/String;
    //   17: astore_0
    //   18: aload_0
    //   19: invokestatic 30	com/tencent/beacon/core/e/j:b	(Ljava/lang/String;)Ljava/lang/String;
    //   22: putstatic 13	com/tencent/beacon/core/info/IccIdJNI:a	Ljava/lang/String;
    //   25: ldc 32
    //   27: iconst_1
    //   28: anewarray 4	java/lang/Object
    //   31: dup
    //   32: iconst_0
    //   33: getstatic 13	com/tencent/beacon/core/info/IccIdJNI:a	Ljava/lang/String;
    //   36: aastore
    //   37: invokestatic 37	com/tencent/beacon/core/e/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   40: getstatic 13	com/tencent/beacon/core/info/IccIdJNI:a	Ljava/lang/String;
    //   43: astore_0
    //   44: ldc 2
    //   46: monitorexit
    //   47: aload_0
    //   48: areturn
    //   49: astore_0
    //   50: ldc 39
    //   52: astore_0
    //   53: ldc 41
    //   55: iconst_0
    //   56: anewarray 4	java/lang/Object
    //   59: invokestatic 43	com/tencent/beacon/core/e/d:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   62: goto -44 -> 18
    //   65: astore_0
    //   66: ldc 2
    //   68: monitorexit
    //   69: aload_0
    //   70: athrow
    //   71: astore_0
    //   72: ldc 15
    //   74: invokestatic 21	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   77: invokestatic 24	com/tencent/beacon/core/info/IccIdJNI:collectIccid	()Ljava/lang/String;
    //   80: astore_0
    //   81: goto -63 -> 18
    //   84: astore_0
    //   85: ldc 39
    //   87: astore_0
    //   88: ldc 41
    //   90: iconst_0
    //   91: anewarray 4	java/lang/Object
    //   94: invokestatic 43	com/tencent/beacon/core/e/d:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   97: goto -79 -> 18
    // Local variable table:
    //   start	length	slot	name	signature
    //   17	31	0	str1	String
    //   49	1	0	localThrowable1	java.lang.Throwable
    //   52	1	0	str2	String
    //   65	5	0	localObject	Object
    //   71	1	0	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   80	1	0	str3	String
    //   84	1	0	localThrowable2	java.lang.Throwable
    //   87	1	0	str4	String
    // Exception table:
    //   from	to	target	type
    //   9	18	49	java/lang/Throwable
    //   3	9	65	finally
    //   9	18	65	finally
    //   18	40	65	finally
    //   40	44	65	finally
    //   53	62	65	finally
    //   72	81	65	finally
    //   88	97	65	finally
    //   9	18	71	java/lang/UnsatisfiedLinkError
    //   72	81	84	java/lang/Throwable
  }
  
  public static native String collectIccid();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.info.IccIdJNI
 * JD-Core Version:    0.7.0.1
 */