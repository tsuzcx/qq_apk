public class bbwa
{
  /* Error */
  public static java.lang.String a(java.lang.String paramString)
  {
    // Byte code:
    //   0: new 12	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 16	java/lang/StringBuilder:<init>	()V
    //   7: astore_3
    //   8: new 18	java/io/BufferedReader
    //   11: dup
    //   12: new 20	java/io/FileReader
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 23	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   20: invokespecial 26	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   23: astore_1
    //   24: aload_1
    //   25: astore_0
    //   26: aload_1
    //   27: invokevirtual 30	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   30: astore_2
    //   31: aload_2
    //   32: ifnull +52 -> 84
    //   35: aload_1
    //   36: astore_0
    //   37: aload_3
    //   38: new 12	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 16	java/lang/StringBuilder:<init>	()V
    //   45: aload_2
    //   46: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: bipush 10
    //   51: invokevirtual 37	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   54: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: goto -37 -> 24
    //   64: astore_2
    //   65: aload_1
    //   66: astore_0
    //   67: aload_2
    //   68: invokevirtual 43	java/lang/Exception:printStackTrace	()V
    //   71: aload_1
    //   72: ifnull +7 -> 79
    //   75: aload_1
    //   76: invokevirtual 46	java/io/BufferedReader:close	()V
    //   79: aload_3
    //   80: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: areturn
    //   84: aload_1
    //   85: astore_0
    //   86: aload_1
    //   87: invokevirtual 46	java/io/BufferedReader:close	()V
    //   90: aload_1
    //   91: ifnull -12 -> 79
    //   94: aload_1
    //   95: invokevirtual 46	java/io/BufferedReader:close	()V
    //   98: goto -19 -> 79
    //   101: astore_0
    //   102: aload_0
    //   103: invokevirtual 47	java/io/IOException:printStackTrace	()V
    //   106: goto -27 -> 79
    //   109: astore_0
    //   110: aload_0
    //   111: invokevirtual 47	java/io/IOException:printStackTrace	()V
    //   114: goto -35 -> 79
    //   117: astore_1
    //   118: aconst_null
    //   119: astore_0
    //   120: aload_0
    //   121: ifnull +7 -> 128
    //   124: aload_0
    //   125: invokevirtual 46	java/io/BufferedReader:close	()V
    //   128: aload_1
    //   129: athrow
    //   130: astore_0
    //   131: aload_0
    //   132: invokevirtual 47	java/io/IOException:printStackTrace	()V
    //   135: goto -7 -> 128
    //   138: astore_1
    //   139: goto -19 -> 120
    //   142: astore_2
    //   143: aconst_null
    //   144: astore_1
    //   145: goto -80 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	paramString	java.lang.String
    //   23	72	1	localBufferedReader	java.io.BufferedReader
    //   117	12	1	localObject1	Object
    //   138	1	1	localObject2	Object
    //   144	1	1	localObject3	Object
    //   30	16	2	str	java.lang.String
    //   64	4	2	localException1	java.lang.Exception
    //   142	1	2	localException2	java.lang.Exception
    //   7	73	3	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   26	31	64	java/lang/Exception
    //   37	61	64	java/lang/Exception
    //   86	90	64	java/lang/Exception
    //   94	98	101	java/io/IOException
    //   75	79	109	java/io/IOException
    //   8	24	117	finally
    //   124	128	130	java/io/IOException
    //   26	31	138	finally
    //   37	61	138	finally
    //   67	71	138	finally
    //   86	90	138	finally
    //   8	24	142	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbwa
 * JD-Core Version:    0.7.0.1
 */