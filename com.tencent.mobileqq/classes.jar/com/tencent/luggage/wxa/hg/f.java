package com.tencent.luggage.wxa.hg;

import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import junit.framework.a;

public class f
{
  private static f.a a = new f.1();
  private static final HashMap<String, WeakReference<ClassLoader>> b = new HashMap();
  private static volatile boolean c = false;
  private static volatile boolean d;
  
  static
  {
    try
    {
      d = true;
      d = false;
      return;
    }
    finally {}
  }
  
  public static void a(f.a parama)
  {
    if (parama == null) {
      return;
    }
    a = parama;
  }
  
  public static void a(String paramString, ClassLoader paramClassLoader)
  {
    for (;;)
    {
      try
      {
        if (af.c(paramString)) {
          break label88;
        }
        if (paramClassLoader != null) {
          break label83;
        }
      }
      finally {}
      a.b("libName or callerClassLoader is null", bool);
      if ((!c) && (!d))
      {
        c = true;
        try
        {
          b(paramString, paramClassLoader);
          c = false;
          return;
        }
        finally
        {
          paramString = finally;
          c = false;
          throw paramString;
        }
      }
      o.h("Luggage.Stub.LoadLibrary", "[!] Recursive calling, return directly.", new Object[0]);
      return;
      label83:
      boolean bool = false;
      continue;
      label88:
      bool = true;
    }
  }
  
  public static boolean a(String paramString)
  {
    try
    {
      boolean bool = b.containsKey(paramString);
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public static String b(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 2
    //   5: invokevirtual 71	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   8: astore_1
    //   9: ldc 73
    //   11: ldc 75
    //   13: iconst_1
    //   14: anewarray 67	java/lang/Class
    //   17: dup
    //   18: iconst_0
    //   19: ldc 77
    //   21: aastore
    //   22: invokevirtual 81	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   25: astore_2
    //   26: aload_2
    //   27: iconst_1
    //   28: invokevirtual 87	java/lang/reflect/Method:setAccessible	(Z)V
    //   31: aload_2
    //   32: aload_1
    //   33: iconst_1
    //   34: anewarray 4	java/lang/Object
    //   37: dup
    //   38: iconst_0
    //   39: aload_0
    //   40: aastore
    //   41: invokevirtual 91	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   44: checkcast 77	java/lang/String
    //   47: astore_0
    //   48: goto +11 -> 59
    //   51: astore_0
    //   52: ldc 2
    //   54: monitorexit
    //   55: aload_0
    //   56: athrow
    //   57: aconst_null
    //   58: astore_0
    //   59: ldc 2
    //   61: monitorexit
    //   62: aload_0
    //   63: areturn
    //   64: astore_0
    //   65: goto -8 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	paramString	String
    //   8	25	1	localClassLoader	ClassLoader
    //   25	7	2	localMethod	java.lang.reflect.Method
    // Exception table:
    //   from	to	target	type
    //   3	48	51	finally
    //   3	48	64	java/lang/Throwable
  }
  
  /* Error */
  private static void b(String paramString, ClassLoader paramClassLoader)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 95	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   10: astore 4
    //   12: aload 4
    //   14: ldc 98
    //   16: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: pop
    //   20: aload 4
    //   22: aload_0
    //   23: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload 4
    //   29: ldc 104
    //   31: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload 4
    //   37: aload_1
    //   38: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: ldc 50
    //   44: aload 4
    //   46: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 114	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: getstatic 26	com/tencent/luggage/wxa/hg/f:b	Ljava/util/HashMap;
    //   55: aload_0
    //   56: invokevirtual 118	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   59: checkcast 120	java/lang/ref/WeakReference
    //   62: astore 4
    //   64: aload 4
    //   66: ifnull +75 -> 141
    //   69: aload 4
    //   71: invokevirtual 123	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   74: checkcast 73	java/lang/ClassLoader
    //   77: astore 4
    //   79: aload 4
    //   81: ifnull +60 -> 141
    //   84: aload 4
    //   86: aload_1
    //   87: if_acmpne +14 -> 101
    //   90: ldc 50
    //   92: ldc 125
    //   94: invokestatic 114	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: ldc 2
    //   99: monitorexit
    //   100: return
    //   101: new 95	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   108: astore_1
    //   109: aload_1
    //   110: ldc 127
    //   112: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload_1
    //   117: aload_0
    //   118: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload_1
    //   123: ldc 129
    //   125: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: new 93	java/lang/UnsatisfiedLinkError
    //   132: dup
    //   133: aload_1
    //   134: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokespecial 132	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   140: athrow
    //   141: ldc 50
    //   143: ldc 134
    //   145: iconst_1
    //   146: anewarray 4	java/lang/Object
    //   149: dup
    //   150: iconst_0
    //   151: aload_0
    //   152: aastore
    //   153: invokestatic 136	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   156: invokestatic 139	com/tencent/luggage/wxa/qz/af:b	()J
    //   159: lstore_2
    //   160: getstatic 21	com/tencent/luggage/wxa/hg/f:a	Lcom/tencent/luggage/wxa/hg/f$a;
    //   163: aload_0
    //   164: invokeinterface 143 2 0
    //   169: ldc 50
    //   171: ldc 145
    //   173: iconst_2
    //   174: anewarray 4	java/lang/Object
    //   177: dup
    //   178: iconst_0
    //   179: aload_0
    //   180: aastore
    //   181: dup
    //   182: iconst_1
    //   183: invokestatic 139	com/tencent/luggage/wxa/qz/af:b	()J
    //   186: lload_2
    //   187: lsub
    //   188: invokestatic 151	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   191: aastore
    //   192: invokestatic 136	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   195: ldc 2
    //   197: monitorexit
    //   198: return
    //   199: astore_1
    //   200: goto +6 -> 206
    //   203: astore_1
    //   204: aload_1
    //   205: athrow
    //   206: ldc 50
    //   208: ldc 145
    //   210: iconst_2
    //   211: anewarray 4	java/lang/Object
    //   214: dup
    //   215: iconst_0
    //   216: aload_0
    //   217: aastore
    //   218: dup
    //   219: iconst_1
    //   220: invokestatic 139	com/tencent/luggage/wxa/qz/af:b	()J
    //   223: lload_2
    //   224: lsub
    //   225: invokestatic 151	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   228: aastore
    //   229: invokestatic 136	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   232: aload_1
    //   233: athrow
    //   234: astore_0
    //   235: ldc 2
    //   237: monitorexit
    //   238: aload_0
    //   239: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	paramString	String
    //   0	240	1	paramClassLoader	ClassLoader
    //   159	65	2	l	long
    //   10	75	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   160	169	199	finally
    //   204	206	199	finally
    //   160	169	203	java/lang/UnsatisfiedLinkError
    //   3	64	234	finally
    //   69	79	234	finally
    //   90	97	234	finally
    //   101	141	234	finally
    //   141	160	234	finally
    //   169	195	234	finally
    //   206	234	234	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hg.f
 * JD-Core Version:    0.7.0.1
 */