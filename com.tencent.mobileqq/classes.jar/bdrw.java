import android.os.Handler;
import com.tencent.qqmini.sdk.monitor.service.CPUMonitor.1;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class bdrw
{
  private static int jdField_a_of_type_Int;
  private static long jdField_a_of_type_Long;
  private static Handler jdField_a_of_type_AndroidOsHandler;
  private static Runnable jdField_a_of_type_JavaLangRunnable = new CPUMonitor.1();
  private static final String jdField_a_of_type_JavaLangString = bdrw.class.getSimpleName();
  private static final SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat;
  private static LinkedHashMap<Long, String> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private static boolean jdField_a_of_type_Boolean;
  private static long b;
  private static long c;
  private static long d;
  private static long e;
  private static long f;
  
  static
  {
    jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("MM-dd HH:mm:ss.SSS");
  }
  
  private static void a(String arg0, String paramString2)
  {
    ??? = ???.split(" ");
    if ((??? == null) || (???.length < 9)) {}
    long l1;
    long l5;
    long l2;
    long l3;
    long l4;
    do
    {
      return;
      l1 = Long.parseLong(???[2]);
      l5 = Long.parseLong(???[3]);
      l2 = Long.parseLong(???[4]);
      l3 = Long.parseLong(???[5]);
      l4 = Long.parseLong(???[6]);
      l5 = l5 + l1 + l2 + l3 + l4 + Long.parseLong(???[7]) + Long.parseLong(???[8]);
      ??? = paramString2.split(" ");
    } while ((??? == null) || (???.length < 17));
    long l6 = Long.parseLong(???[13]) + Long.parseLong(???[14]) + Long.parseLong(???[15]) + Long.parseLong(???[16]);
    if (e != 0L)
    {
      paramString2 = new StringBuilder();
      long l7 = c;
      long l8 = l5 - e;
      paramString2.append("cpu:").append((l8 - (l3 - l7)) * 100L / l8).append("% ");
      paramString2.append("app:").append((l6 - f) * 100L / l8).append("% ");
      paramString2.append("[").append("user:").append((l1 - jdField_a_of_type_Long) * 100L / l8).append("% ");
      paramString2.append("system:").append((l2 - b) * 100L / l8).append("% ");
      paramString2.append("iowait:").append((l4 - d) * 100L / l8).append("% ]");
    }
    synchronized (jdField_a_of_type_JavaUtilLinkedHashMap)
    {
      jdField_a_of_type_JavaUtilLinkedHashMap.put(Long.valueOf(System.currentTimeMillis()), paramString2.toString());
      if (jdField_a_of_type_JavaUtilLinkedHashMap.size() > 10)
      {
        paramString2 = jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
        if (paramString2.hasNext())
        {
          paramString2 = (Long)((Map.Entry)paramString2.next()).getKey();
          jdField_a_of_type_JavaUtilLinkedHashMap.remove(paramString2);
        }
      }
      jdField_a_of_type_Long = l1;
      b = l2;
      c = l3;
      d = l4;
      e = l5;
      f = l6;
      return;
    }
  }
  
  /* Error */
  private static void b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: new 171	java/io/BufferedReader
    //   8: dup
    //   9: new 173	java/io/InputStreamReader
    //   12: dup
    //   13: new 175	java/io/FileInputStream
    //   16: dup
    //   17: ldc 177
    //   19: invokespecial 178	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   22: invokespecial 181	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   25: sipush 1000
    //   28: invokespecial 184	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   31: astore_1
    //   32: aload_1
    //   33: invokevirtual 187	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   36: astore_2
    //   37: aload_2
    //   38: ifnonnull +231 -> 269
    //   41: ldc 189
    //   43: astore_2
    //   44: getstatic 191	bdrw:jdField_a_of_type_Int	I
    //   47: ifne +9 -> 56
    //   50: invokestatic 196	android/os/Process:myPid	()I
    //   53: putstatic 191	bdrw:jdField_a_of_type_Int	I
    //   56: new 171	java/io/BufferedReader
    //   59: dup
    //   60: new 173	java/io/InputStreamReader
    //   63: dup
    //   64: new 175	java/io/FileInputStream
    //   67: dup
    //   68: new 77	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   75: ldc 198
    //   77: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: getstatic 191	bdrw:jdField_a_of_type_Int	I
    //   83: invokevirtual 201	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   86: ldc 203
    //   88: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokespecial 178	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   97: invokespecial 181	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   100: sipush 1000
    //   103: invokespecial 184	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   106: astore_0
    //   107: aload_0
    //   108: invokevirtual 187	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   111: astore 4
    //   113: aload 4
    //   115: astore_3
    //   116: aload 4
    //   118: ifnonnull +6 -> 124
    //   121: ldc 189
    //   123: astore_3
    //   124: aload_2
    //   125: aload_3
    //   126: invokestatic 205	bdrw:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   129: iconst_0
    //   130: putstatic 165	bdrw:jdField_a_of_type_Boolean	Z
    //   133: aload_1
    //   134: ifnull +7 -> 141
    //   137: aload_1
    //   138: invokevirtual 208	java/io/BufferedReader:close	()V
    //   141: aload_0
    //   142: ifnull +7 -> 149
    //   145: aload_0
    //   146: invokevirtual 208	java/io/BufferedReader:close	()V
    //   149: return
    //   150: astore_0
    //   151: aload_0
    //   152: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   155: return
    //   156: astore_2
    //   157: aconst_null
    //   158: astore_0
    //   159: aload_3
    //   160: astore_1
    //   161: iconst_1
    //   162: putstatic 165	bdrw:jdField_a_of_type_Boolean	Z
    //   165: aload_2
    //   166: invokevirtual 212	java/lang/Throwable:printStackTrace	()V
    //   169: aload_0
    //   170: ifnull +7 -> 177
    //   173: aload_0
    //   174: invokevirtual 208	java/io/BufferedReader:close	()V
    //   177: aload_1
    //   178: ifnull -29 -> 149
    //   181: aload_1
    //   182: invokevirtual 208	java/io/BufferedReader:close	()V
    //   185: return
    //   186: astore_0
    //   187: aload_0
    //   188: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   191: return
    //   192: astore_0
    //   193: aconst_null
    //   194: astore_1
    //   195: aload 4
    //   197: astore_2
    //   198: aload_1
    //   199: ifnull +7 -> 206
    //   202: aload_1
    //   203: invokevirtual 208	java/io/BufferedReader:close	()V
    //   206: aload_2
    //   207: ifnull +7 -> 214
    //   210: aload_2
    //   211: invokevirtual 208	java/io/BufferedReader:close	()V
    //   214: aload_0
    //   215: athrow
    //   216: astore_1
    //   217: aload_1
    //   218: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   221: goto -7 -> 214
    //   224: astore_0
    //   225: aload 4
    //   227: astore_2
    //   228: goto -30 -> 198
    //   231: astore_3
    //   232: aload_0
    //   233: astore_2
    //   234: aload_3
    //   235: astore_0
    //   236: goto -38 -> 198
    //   239: astore_2
    //   240: aload_0
    //   241: astore_3
    //   242: aload_2
    //   243: astore_0
    //   244: aload_1
    //   245: astore_2
    //   246: aload_3
    //   247: astore_1
    //   248: goto -50 -> 198
    //   251: astore_2
    //   252: aload_1
    //   253: astore_0
    //   254: aload_3
    //   255: astore_1
    //   256: goto -95 -> 161
    //   259: astore_2
    //   260: aload_1
    //   261: astore_3
    //   262: aload_0
    //   263: astore_1
    //   264: aload_3
    //   265: astore_0
    //   266: goto -105 -> 161
    //   269: goto -225 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   106	40	0	localBufferedReader	java.io.BufferedReader
    //   150	2	0	localIOException1	java.io.IOException
    //   158	16	0	localObject1	Object
    //   186	2	0	localIOException2	java.io.IOException
    //   192	23	0	localObject2	Object
    //   224	9	0	localObject3	Object
    //   235	31	0	localObject4	Object
    //   31	172	1	localObject5	Object
    //   216	29	1	localIOException3	java.io.IOException
    //   247	17	1	localObject6	Object
    //   36	89	2	str1	String
    //   156	10	2	localThrowable1	java.lang.Throwable
    //   197	37	2	localObject7	Object
    //   239	4	2	localObject8	Object
    //   245	1	2	localIOException4	java.io.IOException
    //   251	1	2	localThrowable2	java.lang.Throwable
    //   259	1	2	localThrowable3	java.lang.Throwable
    //   4	156	3	str2	String
    //   231	4	3	localObject9	Object
    //   241	24	3	localObject10	Object
    //   1	225	4	str3	String
    // Exception table:
    //   from	to	target	type
    //   137	141	150	java/io/IOException
    //   145	149	150	java/io/IOException
    //   5	32	156	java/lang/Throwable
    //   173	177	186	java/io/IOException
    //   181	185	186	java/io/IOException
    //   5	32	192	finally
    //   202	206	216	java/io/IOException
    //   210	214	216	java/io/IOException
    //   32	37	224	finally
    //   44	56	224	finally
    //   56	107	224	finally
    //   107	113	231	finally
    //   124	133	231	finally
    //   161	169	239	finally
    //   32	37	251	java/lang/Throwable
    //   44	56	251	java/lang/Throwable
    //   56	107	251	java/lang/Throwable
    //   107	113	259	java/lang/Throwable
    //   124	133	259	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdrw
 * JD-Core Version:    0.7.0.1
 */