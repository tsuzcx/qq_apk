package com.tencent.aelight.camera.aioeditor;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.os.Build.VERSION;

public class SystemUtil
{
  private static long a;
  
  /* Error */
  private static long a()
  {
    // Byte code:
    //   0: new 18	java/io/File
    //   3: dup
    //   4: ldc 20
    //   6: invokespecial 23	java/io/File:<init>	(Ljava/lang/String;)V
    //   9: astore_3
    //   10: aconst_null
    //   11: astore 4
    //   13: aconst_null
    //   14: astore_2
    //   15: new 25	java/io/BufferedReader
    //   18: dup
    //   19: new 27	java/io/InputStreamReader
    //   22: dup
    //   23: new 29	java/io/FileInputStream
    //   26: dup
    //   27: aload_3
    //   28: invokespecial 32	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   31: invokespecial 35	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   34: invokespecial 38	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   37: astore_3
    //   38: aload_3
    //   39: invokevirtual 42	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   42: astore_2
    //   43: aload_2
    //   44: aload_2
    //   45: bipush 58
    //   47: invokevirtual 48	java/lang/String:indexOf	(I)I
    //   50: iconst_1
    //   51: iadd
    //   52: aload_2
    //   53: bipush 107
    //   55: invokevirtual 48	java/lang/String:indexOf	(I)I
    //   58: invokevirtual 52	java/lang/String:substring	(II)Ljava/lang/String;
    //   61: invokevirtual 55	java/lang/String:trim	()Ljava/lang/String;
    //   64: invokestatic 61	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   67: lstore_0
    //   68: lload_0
    //   69: ldc2_w 62
    //   72: lmul
    //   73: lstore_0
    //   74: aload_3
    //   75: invokevirtual 66	java/io/BufferedReader:close	()V
    //   78: lload_0
    //   79: lreturn
    //   80: astore_2
    //   81: new 68	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   88: astore_3
    //   89: aload_3
    //   90: ldc 71
    //   92: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload_3
    //   97: aload_2
    //   98: invokevirtual 78	java/io/IOException:getMessage	()Ljava/lang/String;
    //   101: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: ldc 80
    //   107: iconst_1
    //   108: aload_3
    //   109: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 89	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   115: aload_2
    //   116: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   119: lload_0
    //   120: lreturn
    //   121: astore 4
    //   123: aload_3
    //   124: astore_2
    //   125: aload 4
    //   127: astore_3
    //   128: goto +125 -> 253
    //   131: astore 4
    //   133: goto +14 -> 147
    //   136: astore_3
    //   137: goto +116 -> 253
    //   140: astore_2
    //   141: aload 4
    //   143: astore_3
    //   144: aload_2
    //   145: astore 4
    //   147: aload_3
    //   148: astore_2
    //   149: aload 4
    //   151: invokevirtual 93	java/lang/Exception:printStackTrace	()V
    //   154: aload_3
    //   155: astore_2
    //   156: new 68	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   163: astore 5
    //   165: aload_3
    //   166: astore_2
    //   167: aload 5
    //   169: ldc 95
    //   171: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload_3
    //   176: astore_2
    //   177: aload 5
    //   179: aload 4
    //   181: invokevirtual 96	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   184: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload_3
    //   189: astore_2
    //   190: ldc 80
    //   192: iconst_1
    //   193: aload 5
    //   195: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: invokestatic 89	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   201: aload_3
    //   202: ifnull +49 -> 251
    //   205: aload_3
    //   206: invokevirtual 66	java/io/BufferedReader:close	()V
    //   209: goto +42 -> 251
    //   212: astore_2
    //   213: new 68	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   220: astore_3
    //   221: aload_3
    //   222: ldc 71
    //   224: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: aload_3
    //   229: aload_2
    //   230: invokevirtual 78	java/io/IOException:getMessage	()Ljava/lang/String;
    //   233: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: pop
    //   237: ldc 80
    //   239: iconst_1
    //   240: aload_3
    //   241: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: invokestatic 89	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   247: aload_2
    //   248: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   251: lconst_0
    //   252: lreturn
    //   253: aload_2
    //   254: ifnull +53 -> 307
    //   257: aload_2
    //   258: invokevirtual 66	java/io/BufferedReader:close	()V
    //   261: goto +46 -> 307
    //   264: astore_2
    //   265: new 68	java/lang/StringBuilder
    //   268: dup
    //   269: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   272: astore 4
    //   274: aload 4
    //   276: ldc 71
    //   278: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: aload 4
    //   284: aload_2
    //   285: invokevirtual 78	java/io/IOException:getMessage	()Ljava/lang/String;
    //   288: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: ldc 80
    //   294: iconst_1
    //   295: aload 4
    //   297: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: invokestatic 89	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   303: aload_2
    //   304: invokevirtual 92	java/io/IOException:printStackTrace	()V
    //   307: aload_3
    //   308: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   67	53	0	l	long
    //   14	39	2	str	java.lang.String
    //   80	36	2	localIOException1	java.io.IOException
    //   124	1	2	localObject1	Object
    //   140	5	2	localException1	java.lang.Exception
    //   148	42	2	localObject2	Object
    //   212	46	2	localIOException2	java.io.IOException
    //   264	40	2	localIOException3	java.io.IOException
    //   9	119	3	localObject3	Object
    //   136	1	3	localObject4	Object
    //   143	165	3	localObject5	Object
    //   11	1	4	localObject6	Object
    //   121	5	4	localObject7	Object
    //   131	11	4	localException2	java.lang.Exception
    //   145	151	4	localObject8	Object
    //   163	31	5	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   74	78	80	java/io/IOException
    //   38	68	121	finally
    //   38	68	131	java/lang/Exception
    //   15	38	136	finally
    //   149	154	136	finally
    //   156	165	136	finally
    //   167	175	136	finally
    //   177	188	136	finally
    //   190	201	136	finally
    //   15	38	140	java/lang/Exception
    //   205	209	212	java/io/IOException
    //   257	261	264	java/io/IOException
  }
  
  public static long a(Context paramContext)
  {
    long l = a;
    if (l != 0L) {
      return l;
    }
    if (Build.VERSION.SDK_INT > 16)
    {
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
      paramContext.getMemoryInfo(localMemoryInfo);
      a = localMemoryInfo.totalMem;
    }
    else
    {
      a = a();
    }
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.SystemUtil
 * JD-Core Version:    0.7.0.1
 */