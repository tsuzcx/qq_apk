package com.tencent.luggage.wxa.rt;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.tencent.luggage.wxa.ry.b;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;

public final class k
{
  public static int a(String paramString, byte[] paramArrayOfByte)
  {
    return a(paramString, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  /* Error */
  public static int a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +149 -> 150
    //   4: aload_1
    //   5: arraylength
    //   6: ifeq +144 -> 150
    //   9: aload_1
    //   10: arraylength
    //   11: iload_2
    //   12: iload_3
    //   13: iadd
    //   14: if_icmpge +6 -> 20
    //   17: goto +133 -> 150
    //   20: aconst_null
    //   21: astore 5
    //   23: aconst_null
    //   24: astore 4
    //   26: aload_0
    //   27: iconst_1
    //   28: invokestatic 15	com/tencent/luggage/wxa/rt/k:a	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   31: astore 6
    //   33: aload 6
    //   35: astore 4
    //   37: aload 6
    //   39: astore 5
    //   41: aload 6
    //   43: aload_1
    //   44: iload_2
    //   45: iload_3
    //   46: invokevirtual 21	java/io/OutputStream:write	([BII)V
    //   49: aload 6
    //   51: invokestatic 26	com/tencent/luggage/wxa/rt/o:a	(Ljava/io/Closeable;)V
    //   54: iconst_0
    //   55: ireturn
    //   56: astore_0
    //   57: goto +86 -> 143
    //   60: astore 6
    //   62: aload 5
    //   64: astore 4
    //   66: ldc 28
    //   68: aload 6
    //   70: ldc 30
    //   72: invokestatic 36	com/tencent/luggage/wxa/ry/b:b	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   75: aload 5
    //   77: astore 4
    //   79: ldc 28
    //   81: ldc 38
    //   83: bipush 6
    //   85: anewarray 4	java/lang/Object
    //   88: dup
    //   89: iconst_0
    //   90: aload 6
    //   92: invokevirtual 42	java/lang/Object:getClass	()Ljava/lang/Class;
    //   95: invokevirtual 48	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   98: aastore
    //   99: dup
    //   100: iconst_1
    //   101: aload 6
    //   103: invokevirtual 51	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   106: aastore
    //   107: dup
    //   108: iconst_2
    //   109: aload_0
    //   110: aastore
    //   111: dup
    //   112: iconst_3
    //   113: aload_1
    //   114: arraylength
    //   115: invokestatic 57	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   118: aastore
    //   119: dup
    //   120: iconst_4
    //   121: iload_2
    //   122: invokestatic 57	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   125: aastore
    //   126: dup
    //   127: iconst_5
    //   128: iload_3
    //   129: invokestatic 57	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   132: aastore
    //   133: invokestatic 60	com/tencent/luggage/wxa/ry/b:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   136: aload 5
    //   138: invokestatic 26	com/tencent/luggage/wxa/rt/o:a	(Ljava/io/Closeable;)V
    //   141: iconst_m1
    //   142: ireturn
    //   143: aload 4
    //   145: invokestatic 26	com/tencent/luggage/wxa/rt/o:a	(Ljava/io/Closeable;)V
    //   148: aload_0
    //   149: athrow
    //   150: bipush 254
    //   152: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	paramString	String
    //   0	153	1	paramArrayOfByte	byte[]
    //   0	153	2	paramInt1	int
    //   0	153	3	paramInt2	int
    //   24	120	4	localObject1	Object
    //   21	116	5	localObject2	Object
    //   31	19	6	localOutputStream	OutputStream
    //   60	42	6	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   26	33	56	finally
    //   41	49	56	finally
    //   66	75	56	finally
    //   79	136	56	finally
    //   26	33	60	java/lang/Exception
    //   41	49	60	java/lang/Exception
  }
  
  static ParcelFileDescriptor a(Uri paramUri, e.d paramd, String paramString)
  {
    paramd = e.a().a(paramUri, paramd);
    if (paramd.a()) {
      return paramd.a.a(paramd.b, paramString);
    }
    paramd = new StringBuilder();
    paramd.append("Cannot resolve path or URI: ");
    paramd.append(paramUri);
    throw new FileNotFoundException(paramd.toString());
  }
  
  public static ParcelFileDescriptor a(Uri paramUri, String paramString)
  {
    return a(paramUri, null, paramString);
  }
  
  public static ParcelFileDescriptor a(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (!paramString1.isEmpty())) {
      return a(o.a(paramString1), null, paramString2);
    }
    throw new FileNotFoundException("path is empty");
  }
  
  public static InputStream a(Uri paramUri)
  {
    return a(paramUri, null);
  }
  
  static InputStream a(Uri paramUri, e.d paramd)
  {
    paramd = e.a().a(paramUri, paramd);
    if (paramd.a()) {
      return paramd.a.b(paramd.b);
    }
    paramd = new StringBuilder();
    paramd.append("Cannot resolve path or URI: ");
    paramd.append(paramUri);
    throw new FileNotFoundException(paramd.toString());
  }
  
  public static InputStream a(i parami)
  {
    return a(parami.c(), parami.a());
  }
  
  public static InputStream a(String paramString)
  {
    if ((paramString != null) && (!paramString.isEmpty())) {
      return a(o.a(paramString));
    }
    throw new FileNotFoundException("path is empty");
  }
  
  static OutputStream a(Uri paramUri, e.d paramd, boolean paramBoolean)
  {
    paramd = e.a().a(paramUri, paramd);
    if (paramd.a()) {
      return paramd.a.a(paramd.b, paramBoolean);
    }
    paramd = new StringBuilder();
    paramd.append("Cannot resolve path or URI: ");
    paramd.append(paramUri);
    throw new FileNotFoundException(paramd.toString());
  }
  
  public static OutputStream a(Uri paramUri, boolean paramBoolean)
  {
    return a(paramUri, null, paramBoolean);
  }
  
  public static OutputStream a(String paramString, boolean paramBoolean)
  {
    if ((paramString != null) && (!paramString.isEmpty())) {
      return a(o.a(paramString), paramBoolean);
    }
    throw new FileNotFoundException("path is empty");
  }
  
  public static int b(String paramString, byte[] paramArrayOfByte)
  {
    return b(paramString, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  /* Error */
  public static int b(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +6 -> 7
    //   4: bipush 254
    //   6: ireturn
    //   7: aload_1
    //   8: arraylength
    //   9: iload_2
    //   10: iload_3
    //   11: iadd
    //   12: if_icmpge +6 -> 18
    //   15: bipush 253
    //   17: ireturn
    //   18: aconst_null
    //   19: astore 5
    //   21: aconst_null
    //   22: astore 4
    //   24: aload_0
    //   25: invokestatic 154	com/tencent/luggage/wxa/rt/k:b	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   28: astore 6
    //   30: aload 6
    //   32: astore 4
    //   34: aload 6
    //   36: astore 5
    //   38: aload 6
    //   40: aload_1
    //   41: iload_2
    //   42: iload_3
    //   43: invokevirtual 21	java/io/OutputStream:write	([BII)V
    //   46: aload 6
    //   48: invokestatic 26	com/tencent/luggage/wxa/rt/o:a	(Ljava/io/Closeable;)V
    //   51: iconst_0
    //   52: ireturn
    //   53: astore_0
    //   54: goto +37 -> 91
    //   57: astore_1
    //   58: aload 5
    //   60: astore 4
    //   62: ldc 28
    //   64: ldc 156
    //   66: iconst_2
    //   67: anewarray 4	java/lang/Object
    //   70: dup
    //   71: iconst_0
    //   72: aload_0
    //   73: aastore
    //   74: dup
    //   75: iconst_1
    //   76: aload_1
    //   77: invokevirtual 157	java/io/IOException:getMessage	()Ljava/lang/String;
    //   80: aastore
    //   81: invokestatic 159	com/tencent/luggage/wxa/ry/b:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   84: aload 5
    //   86: invokestatic 26	com/tencent/luggage/wxa/rt/o:a	(Ljava/io/Closeable;)V
    //   89: iconst_m1
    //   90: ireturn
    //   91: aload 4
    //   93: invokestatic 26	com/tencent/luggage/wxa/rt/o:a	(Ljava/io/Closeable;)V
    //   96: aload_0
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	paramString	String
    //   0	98	1	paramArrayOfByte	byte[]
    //   0	98	2	paramInt1	int
    //   0	98	3	paramInt2	int
    //   22	70	4	localObject1	Object
    //   19	66	5	localObject2	Object
    //   28	19	6	localOutputStream	OutputStream
    // Exception table:
    //   from	to	target	type
    //   24	30	53	finally
    //   38	46	53	finally
    //   62	84	53	finally
    //   24	30	57	java/io/IOException
    //   38	46	57	java/io/IOException
  }
  
  public static long b(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString1.length() != 0) && (paramString2 != null))
    {
      if (paramString2.length() == 0) {
        return -1L;
      }
      if (paramString1.equals(paramString2)) {
        return -1L;
      }
      e.d locald = e.a().a(o.a(paramString1));
      Object localObject = e.a().a(o.a(paramString2));
      if (locald.a())
      {
        if (!((e.d)localObject).a()) {
          return -1L;
        }
        try
        {
          long l = ((e.d)localObject).a.c(((e.d)localObject).b, locald.a, locald.b);
          return l;
        }
        catch (IOException localIOException)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Failed to copy file ");
          ((StringBuilder)localObject).append(paramString1);
          ((StringBuilder)localObject).append(" -> ");
          ((StringBuilder)localObject).append(paramString2);
          ((StringBuilder)localObject).append(": ");
          ((StringBuilder)localObject).append(localIOException.getMessage());
          b.b("MicroMsg.VFSFileOp", ((StringBuilder)localObject).toString());
        }
      }
    }
    return -1L;
  }
  
  public static OutputStream b(i parami)
  {
    return a(parami.c(), parami.a(), false);
  }
  
  public static OutputStream b(String paramString)
  {
    return a(paramString, false);
  }
  
  public static RandomAccessFile b(Uri paramUri, boolean paramBoolean)
  {
    Object localObject = o.a(paramUri, paramBoolean);
    if (localObject != null)
    {
      if (paramBoolean) {
        paramUri = "rw";
      } else {
        paramUri = "r";
      }
      return new RandomAccessFile((String)localObject, paramUri);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Cannot resolve path or URI: ");
    ((StringBuilder)localObject).append(paramUri);
    throw new FileNotFoundException(((StringBuilder)localObject).toString());
  }
  
  public static RandomAccessFile b(String paramString, boolean paramBoolean)
  {
    if ((paramString != null) && (!paramString.isEmpty())) {
      return b(o.a(paramString), paramBoolean);
    }
    throw new FileNotFoundException("path is empty");
  }
  
  public static long c(String paramString)
  {
    long l = 0L;
    if (paramString != null)
    {
      if (paramString.isEmpty()) {
        return 0L;
      }
      paramString = o.a(paramString);
      paramString = e.a().a(paramString);
      if (!paramString.a()) {
        return 0L;
      }
      paramString = paramString.a.d(paramString.b);
      if (paramString == null) {
        return 0L;
      }
      l = paramString.c;
    }
    return l;
  }
  
  public static String c(String paramString, boolean paramBoolean)
  {
    if ((paramString != null) && (!paramString.isEmpty())) {
      return o.a(o.a(paramString), paramBoolean);
    }
    return null;
  }
  
  public static boolean c(String paramString1, String paramString2)
  {
    e.d locald;
    Object localObject;
    if ((paramString1 != null) && (paramString2 != null) && (paramString1.length() != 0))
    {
      if (paramString2.length() == 0) {
        return false;
      }
      locald = e.a().a(o.a(paramString1));
      localObject = e.a().a(o.a(paramString2));
      if (locald.a()) {
        if (!((e.d)localObject).a()) {
          return false;
        }
      }
    }
    for (;;)
    {
      try
      {
        bool1 = ((e.d)localObject).a.a(((e.d)localObject).b, locald.a, locald.b);
        boolean bool2 = bool1;
        if (!bool1)
        {
          if (((e.d)localObject).a.c(((e.d)localObject).b, locald.a, locald.b) < 0L) {
            break label231;
          }
          bool1 = true;
          bool2 = bool1;
          if (bool1)
          {
            locald.a.e(locald.b);
            bool2 = bool1;
          }
        }
        return bool2;
      }
      catch (IOException localIOException)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Failed to move file ");
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(" -> ");
        ((StringBuilder)localObject).append(paramString2);
        ((StringBuilder)localObject).append(": ");
        ((StringBuilder)localObject).append(localIOException.getMessage());
        b.b("MicroMsg.VFSFileOp", ((StringBuilder)localObject).toString());
      }
      return false;
      label231:
      boolean bool1 = false;
    }
  }
  
  public static long d(String paramString)
  {
    long l = 0L;
    if (paramString != null)
    {
      if (paramString.isEmpty()) {
        return 0L;
      }
      paramString = o.a(paramString);
      paramString = e.a().a(paramString);
      if (!paramString.a()) {
        return 0L;
      }
      paramString = paramString.a.d(paramString.b);
      if (paramString == null) {
        return 0L;
      }
      l = paramString.e;
    }
    return l;
  }
  
  public static boolean d(String paramString, boolean paramBoolean)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return false;
      }
      paramString = o.a(paramString);
      paramString = e.a().a(paramString);
      if (!paramString.a()) {
        return false;
      }
      return paramString.a.c(paramString.b, paramBoolean);
    }
    return false;
  }
  
  /* Error */
  public static String e(String paramString)
  {
    // Byte code:
    //   0: new 87	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   7: astore 5
    //   9: aconst_null
    //   10: astore 4
    //   12: aconst_null
    //   13: astore_2
    //   14: new 230	java/io/InputStreamReader
    //   17: dup
    //   18: aload_0
    //   19: invokestatic 232	com/tencent/luggage/wxa/rt/k:a	(Ljava/lang/String;)Ljava/io/InputStream;
    //   22: invokespecial 235	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   25: astore_3
    //   26: sipush 512
    //   29: newarray char
    //   31: astore_2
    //   32: aload_3
    //   33: aload_2
    //   34: invokevirtual 239	java/io/InputStreamReader:read	([C)I
    //   37: istore_1
    //   38: iload_1
    //   39: iconst_m1
    //   40: if_icmpeq +15 -> 55
    //   43: aload 5
    //   45: aload_2
    //   46: iconst_0
    //   47: iload_1
    //   48: invokevirtual 242	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: goto -20 -> 32
    //   55: aload_3
    //   56: invokestatic 26	com/tencent/luggage/wxa/rt/o:a	(Ljava/io/Closeable;)V
    //   59: aload 5
    //   61: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: areturn
    //   65: astore_0
    //   66: aload_3
    //   67: astore_2
    //   68: goto +49 -> 117
    //   71: astore 4
    //   73: goto +14 -> 87
    //   76: astore_0
    //   77: goto +40 -> 117
    //   80: astore_2
    //   81: aload 4
    //   83: astore_3
    //   84: aload_2
    //   85: astore 4
    //   87: aload_3
    //   88: astore_2
    //   89: ldc 28
    //   91: ldc 244
    //   93: iconst_2
    //   94: anewarray 4	java/lang/Object
    //   97: dup
    //   98: iconst_0
    //   99: aload_0
    //   100: aastore
    //   101: dup
    //   102: iconst_1
    //   103: aload 4
    //   105: invokevirtual 157	java/io/IOException:getMessage	()Ljava/lang/String;
    //   108: aastore
    //   109: invokestatic 159	com/tencent/luggage/wxa/ry/b:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   112: aload_3
    //   113: astore_2
    //   114: aload 4
    //   116: athrow
    //   117: aload_2
    //   118: invokestatic 26	com/tencent/luggage/wxa/rt/o:a	(Ljava/io/Closeable;)V
    //   121: goto +5 -> 126
    //   124: aload_0
    //   125: athrow
    //   126: goto -2 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	paramString	String
    //   37	11	1	i	int
    //   13	55	2	localObject1	Object
    //   80	5	2	localIOException1	IOException
    //   88	30	2	localObject2	Object
    //   25	88	3	localObject3	Object
    //   10	1	4	localObject4	Object
    //   71	11	4	localIOException2	IOException
    //   85	30	4	localObject5	Object
    //   7	53	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   26	32	65	finally
    //   32	38	65	finally
    //   43	52	65	finally
    //   26	32	71	java/io/IOException
    //   32	38	71	java/io/IOException
    //   43	52	71	java/io/IOException
    //   14	26	76	finally
    //   89	112	76	finally
    //   114	117	76	finally
    //   14	26	80	java/io/IOException
  }
  
  public static String f(String paramString)
  {
    return new i(paramString).m().f();
  }
  
  public static boolean g(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return false;
      }
      paramString = new i(paramString);
      if (!paramString.u())
      {
        bool1 = bool2;
        if (!paramString.n()) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean h(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.isEmpty()) {
        return false;
      }
      paramString = o.a(paramString);
      paramString = e.a().a(paramString);
      if (!paramString.a()) {
        return false;
      }
      return paramString.a.c(paramString.b);
    }
    return false;
  }
  
  public static boolean i(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0)) {
      return new i(paramString).w();
    }
    return false;
  }
  
  public static boolean j(String paramString)
  {
    return d(paramString, true);
  }
  
  public static boolean k(String paramString)
  {
    boolean bool1 = false;
    try
    {
      paramString = new i(paramString);
      if (!paramString.j())
      {
        boolean bool2 = paramString.v();
        if (!bool2) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
    catch (IOException paramString) {}
    return false;
  }
  
  public static final String l(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() <= 0) {
        return "";
      }
      String str = new i(paramString).d();
      int i = str.lastIndexOf('.');
      if (i < 0) {
        return paramString;
      }
      if (i == 0) {
        return "";
      }
      return str.substring(0, i);
    }
    return "";
  }
  
  public static void m(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.isEmpty()) {
        return;
      }
      paramString = o.a(paramString);
      paramString = e.a().a(paramString);
      if (!paramString.a()) {
        return;
      }
      if ((paramString.a.b() & 0x2) == 0) {
        return;
      }
      if (paramString.a.d(paramString.b, true) == null) {
        return;
      }
    }
    try
    {
      d locald = paramString.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString.b);
      localStringBuilder.append("/.nomedia");
      locald.a(localStringBuilder.toString(), false).close();
      return;
    }
    catch (IOException paramString) {}
  }
  
  /* Error */
  public static byte[] n(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: aload_0
    //   7: invokestatic 232	com/tencent/luggage/wxa/rt/k:a	(Ljava/lang/String;)Ljava/io/InputStream;
    //   10: astore_0
    //   11: ldc_w 298
    //   14: invokestatic 304	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   17: astore_2
    //   18: sipush 2048
    //   21: newarray byte
    //   23: astore_3
    //   24: aload_0
    //   25: aload_3
    //   26: invokevirtual 309	java/io/InputStream:read	([B)I
    //   29: istore_1
    //   30: iload_1
    //   31: iflt +13 -> 44
    //   34: aload_2
    //   35: aload_3
    //   36: iconst_0
    //   37: iload_1
    //   38: invokevirtual 312	java/security/MessageDigest:update	([BII)V
    //   41: goto -17 -> 24
    //   44: aload_2
    //   45: invokevirtual 316	java/security/MessageDigest:digest	()[B
    //   48: astore_2
    //   49: aload_0
    //   50: invokestatic 26	com/tencent/luggage/wxa/rt/o:a	(Ljava/io/Closeable;)V
    //   53: aload_2
    //   54: areturn
    //   55: astore_2
    //   56: aload_0
    //   57: astore_3
    //   58: goto +8 -> 66
    //   61: astore_0
    //   62: aconst_null
    //   63: astore_3
    //   64: aload_0
    //   65: astore_2
    //   66: aload_3
    //   67: invokestatic 26	com/tencent/luggage/wxa/rt/o:a	(Ljava/io/Closeable;)V
    //   70: aload_2
    //   71: athrow
    //   72: aconst_null
    //   73: astore_0
    //   74: aload_0
    //   75: invokestatic 26	com/tencent/luggage/wxa/rt/o:a	(Ljava/io/Closeable;)V
    //   78: aconst_null
    //   79: areturn
    //   80: astore_0
    //   81: goto -9 -> 72
    //   84: astore_2
    //   85: goto -11 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	paramString	String
    //   29	9	1	i	int
    //   17	37	2	localObject1	Object
    //   55	1	2	localObject2	Object
    //   65	6	2	str	String
    //   84	1	2	localException	java.lang.Exception
    //   23	44	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   11	24	55	finally
    //   24	30	55	finally
    //   34	41	55	finally
    //   44	49	55	finally
    //   6	11	61	finally
    //   6	11	80	java/lang/Exception
    //   11	24	84	java/lang/Exception
    //   24	30	84	java/lang/Exception
    //   34	41	84	java/lang/Exception
    //   44	49	84	java/lang/Exception
  }
  
  public static String o(String paramString)
  {
    paramString = n(paramString);
    if (paramString == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(32);
    int i = 0;
    while (i < paramString.length)
    {
      localStringBuilder.append(Integer.toString((paramString[i] & 0xFF) + 256, 16).substring(1));
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rt.k
 * JD-Core Version:    0.7.0.1
 */