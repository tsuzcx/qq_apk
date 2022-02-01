package com.tencent.luggage.wxa.lw;

import android.content.Context;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.rt.i;
import com.tencent.mm.plugin.appbrand.appstorage.m.a;

public class u
{
  public static int a(String... paramVarArgs)
  {
    int m = paramVarArgs.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      String str = paramVarArgs[i];
      k = j;
      if (str != null) {
        k = j + str.length();
      }
      i += 1;
    }
    return j;
  }
  
  /* Error */
  public static String a(i parami)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 24	com/tencent/luggage/wxa/rt/i:j	()Z
    //   4: ifne +6 -> 10
    //   7: ldc 26
    //   9: areturn
    //   10: new 28	java/lang/StringBuffer
    //   13: dup
    //   14: invokespecial 32	java/lang/StringBuffer:<init>	()V
    //   17: astore 4
    //   19: aconst_null
    //   20: astore_3
    //   21: aconst_null
    //   22: astore_2
    //   23: new 34	java/io/BufferedReader
    //   26: dup
    //   27: new 36	com/tencent/luggage/wxa/rt/l
    //   30: dup
    //   31: aload_0
    //   32: invokespecial 39	com/tencent/luggage/wxa/rt/l:<init>	(Lcom/tencent/luggage/wxa/rt/i;)V
    //   35: invokespecial 42	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   38: astore_0
    //   39: sipush 1024
    //   42: newarray char
    //   44: astore_2
    //   45: aload_0
    //   46: aload_2
    //   47: invokevirtual 46	java/io/BufferedReader:read	([C)I
    //   50: istore_1
    //   51: iload_1
    //   52: iconst_m1
    //   53: if_icmpeq +18 -> 71
    //   56: aload 4
    //   58: aload_2
    //   59: iconst_0
    //   60: iload_1
    //   61: invokestatic 50	java/lang/String:valueOf	([CII)Ljava/lang/String;
    //   64: invokevirtual 54	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   67: pop
    //   68: goto -23 -> 45
    //   71: aload_0
    //   72: invokevirtual 57	java/io/BufferedReader:close	()V
    //   75: aload 4
    //   77: invokevirtual 61	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   80: areturn
    //   81: astore_0
    //   82: aload_0
    //   83: athrow
    //   84: astore_3
    //   85: aload_0
    //   86: astore_2
    //   87: aload_3
    //   88: astore_0
    //   89: goto +20 -> 109
    //   92: astore_3
    //   93: aload_0
    //   94: astore_2
    //   95: aload_3
    //   96: astore_0
    //   97: goto +10 -> 107
    //   100: astore_0
    //   101: goto +8 -> 109
    //   104: astore_0
    //   105: aload_3
    //   106: astore_2
    //   107: aload_0
    //   108: athrow
    //   109: aload_2
    //   110: ifnull +13 -> 123
    //   113: aload_2
    //   114: invokevirtual 57	java/io/BufferedReader:close	()V
    //   117: goto +6 -> 123
    //   120: astore_0
    //   121: aload_0
    //   122: athrow
    //   123: goto +5 -> 128
    //   126: aload_0
    //   127: athrow
    //   128: goto -2 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	parami	i
    //   50	11	1	i	int
    //   22	92	2	localObject1	Object
    //   20	1	3	localObject2	Object
    //   84	4	3	localObject3	Object
    //   92	14	3	localIOException	java.io.IOException
    //   17	59	4	localStringBuffer	java.lang.StringBuffer
    // Exception table:
    //   from	to	target	type
    //   71	75	81	java/lang/Exception
    //   39	45	84	finally
    //   45	51	84	finally
    //   56	68	84	finally
    //   39	45	92	java/io/IOException
    //   45	51	92	java/io/IOException
    //   56	68	92	java/io/IOException
    //   23	39	100	finally
    //   107	109	100	finally
    //   23	39	104	java/io/IOException
    //   113	117	120	java/lang/Exception
  }
  
  static String a(m.a parama)
  {
    if (parama == m.a.a) {
      return "ok";
    }
    if (parama == m.a.e) {
      return "fail:quota reached";
    }
    return "fail:internal error set DB data fail";
  }
  
  public static String a(String paramString)
  {
    return a(new i(r.a().getCacheDir(), paramString));
  }
  
  /* Error */
  public static void a(String paramString, String... paramVarArgs)
  {
    // Byte code:
    //   0: new 20	com/tencent/luggage/wxa/rt/i
    //   3: dup
    //   4: invokestatic 82	com/tencent/luggage/wxa/qz/r:a	()Landroid/content/Context;
    //   7: invokevirtual 88	android/content/Context:getCacheDir	()Ljava/io/File;
    //   10: aload_0
    //   11: invokespecial 91	com/tencent/luggage/wxa/rt/i:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   14: astore_0
    //   15: new 96	com/tencent/luggage/wxa/rt/m
    //   18: dup
    //   19: aload_0
    //   20: invokespecial 97	com/tencent/luggage/wxa/rt/m:<init>	(Lcom/tencent/luggage/wxa/rt/i;)V
    //   23: astore_0
    //   24: aload_1
    //   25: arraylength
    //   26: istore_3
    //   27: iconst_0
    //   28: istore_2
    //   29: iload_2
    //   30: iload_3
    //   31: if_icmpge +17 -> 48
    //   34: aload_0
    //   35: aload_1
    //   36: iload_2
    //   37: aaload
    //   38: invokevirtual 101	com/tencent/luggage/wxa/rt/m:write	(Ljava/lang/String;)V
    //   41: iload_2
    //   42: iconst_1
    //   43: iadd
    //   44: istore_2
    //   45: goto -16 -> 29
    //   48: aload_0
    //   49: invokevirtual 102	com/tencent/luggage/wxa/rt/m:close	()V
    //   52: return
    //   53: astore 4
    //   55: aload_0
    //   56: astore_1
    //   57: aload 4
    //   59: astore_0
    //   60: goto +6 -> 66
    //   63: astore_0
    //   64: aconst_null
    //   65: astore_1
    //   66: aload_1
    //   67: ifnull +7 -> 74
    //   70: aload_1
    //   71: invokevirtual 102	com/tencent/luggage/wxa/rt/m:close	()V
    //   74: goto +5 -> 79
    //   77: aload_0
    //   78: athrow
    //   79: goto -2 -> 77
    //   82: astore_0
    //   83: return
    //   84: astore_1
    //   85: goto -11 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	paramString	String
    //   0	88	1	paramVarArgs	String[]
    //   28	17	2	i	int
    //   26	6	3	j	int
    //   53	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   24	27	53	finally
    //   34	41	53	finally
    //   15	24	63	finally
    //   48	52	82	java/io/IOException
    //   70	74	84	java/io/IOException
  }
  
  public static void b(String paramString)
  {
    boolean bool = new i(r.a().getCacheDir(), paramString).w();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("deleteTmpFile: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(":");
    localStringBuilder.append(bool);
    o.d("MicroMsg.JsApiStorageHelper", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lw.u
 * JD-Core Version:    0.7.0.1
 */