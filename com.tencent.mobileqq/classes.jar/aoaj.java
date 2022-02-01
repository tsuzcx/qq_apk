import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.commonsdk.pool.ByteArrayPool;
import com.tencent.commonsdk.pool.RecyclablePool;
import com.tencent.commonsdk.util.StringUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class aoaj
{
  public static int a;
  public static long a;
  public static aoal a;
  private static final RecyclablePool jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool = new RecyclablePool(aoal.class, 30);
  private static Map<String, aoal> jdField_a_of_type_JavaUtilMap;
  static int[] jdField_a_of_type_ArrayOfInt;
  public static int b;
  private static long jdField_b_of_type_Long;
  static int[] jdField_b_of_type_ArrayOfInt;
  private static long c;
  
  static
  {
    jdField_a_of_type_Aoal = a();
    jdField_a_of_type_JavaUtilMap = new HashMap(30);
    jdField_a_of_type_ArrayOfInt = new int[17];
    jdField_b_of_type_ArrayOfInt = new int[17];
    jdField_b_of_type_Int = -1;
  }
  
  @SuppressLint({"NewApi"})
  public static final int a()
  {
    if (jdField_b_of_type_Int == -1) {
      if (Build.VERSION.SDK_INT < 17) {
        break label28;
      }
    }
    label28:
    for (jdField_b_of_type_Int = Runtime.getRuntime().availableProcessors();; jdField_b_of_type_Int = b()) {
      return jdField_b_of_type_Int;
    }
  }
  
  public static long a(String paramString)
  {
    paramString = a(paramString);
    if (paramString == null) {
      return -1L;
    }
    long l = ((Long)paramString[1]).longValue();
    return ((Long)paramString[2]).longValue() + l;
  }
  
  public static aoal a()
  {
    return (aoal)jdField_a_of_type_ComTencentCommonsdkPoolRecyclablePool.obtain(aoal.class);
  }
  
  private static final RandomAccessFile a(String paramString)
  {
    try
    {
      if (paramString.equals("-2")) {
        return new RandomAccessFile("/proc/stat", "r");
      }
      if (paramString.equals("-1"))
      {
        paramString = new RandomAccessFile("/proc/" + Process.myPid() + "/stat", "r");
        return paramString;
      }
    }
    catch (FileNotFoundException paramString)
    {
      paramString.printStackTrace();
      return null;
      paramString = new RandomAccessFile("/proc/" + Process.myPid() + "/task/" + paramString + "/stat", "r");
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  /* Error */
  public static final String a(int paramInt)
  {
    // Byte code:
    //   0: new 108	java/lang/StringBuilder
    //   3: dup
    //   4: iload_0
    //   5: bipush 110
    //   7: imul
    //   8: invokespecial 140	java/lang/StringBuilder:<init>	(I)V
    //   11: astore_3
    //   12: ldc 106
    //   14: getstatic 31	aoaj:jdField_a_of_type_Aoal	Laoal;
    //   17: iconst_0
    //   18: invokestatic 143	aoaj:a	(Ljava/lang/String;Laoal;Z)V
    //   21: ldc 145
    //   23: new 108	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   30: ldc 147
    //   32: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: getstatic 31	aoaj:jdField_a_of_type_Aoal	Laoal;
    //   38: getfield 149	aoal:jdField_a_of_type_Long	J
    //   41: invokevirtual 152	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   44: ldc 154
    //   46: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: getstatic 31	aoaj:jdField_a_of_type_Aoal	Laoal;
    //   52: getfield 156	aoal:jdField_b_of_type_Long	J
    //   55: invokevirtual 152	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   58: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 162	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   64: pop
    //   65: new 164	java/io/BufferedReader
    //   68: dup
    //   69: new 166	java/io/InputStreamReader
    //   72: dup
    //   73: invokestatic 60	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   76: new 108	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   83: ldc 168
    //   85: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: iload_0
    //   89: invokevirtual 124	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   92: ldc 170
    //   94: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokevirtual 174	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   103: invokevirtual 180	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   106: invokespecial 183	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   109: invokespecial 186	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   112: astore_2
    //   113: aload_2
    //   114: invokevirtual 189	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   117: astore_1
    //   118: aload_1
    //   119: ifnull +46 -> 165
    //   122: aload_3
    //   123: aload_1
    //   124: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: ldc 191
    //   129: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: goto -20 -> 113
    //   136: astore_1
    //   137: iconst_0
    //   138: ifeq +11 -> 149
    //   141: new 193	java/lang/NullPointerException
    //   144: dup
    //   145: invokespecial 194	java/lang/NullPointerException:<init>	()V
    //   148: athrow
    //   149: iconst_0
    //   150: ifeq +11 -> 161
    //   153: new 193	java/lang/NullPointerException
    //   156: dup
    //   157: invokespecial 194	java/lang/NullPointerException:<init>	()V
    //   160: athrow
    //   161: aconst_null
    //   162: astore_2
    //   163: aload_2
    //   164: areturn
    //   165: ldc 106
    //   167: getstatic 31	aoaj:jdField_a_of_type_Aoal	Laoal;
    //   170: iconst_0
    //   171: invokestatic 143	aoaj:a	(Ljava/lang/String;Laoal;Z)V
    //   174: ldc 145
    //   176: new 108	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   183: ldc 147
    //   185: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: getstatic 31	aoaj:jdField_a_of_type_Aoal	Laoal;
    //   191: getfield 149	aoal:jdField_a_of_type_Long	J
    //   194: invokevirtual 152	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   197: ldc 154
    //   199: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: getstatic 31	aoaj:jdField_a_of_type_Aoal	Laoal;
    //   205: getfield 156	aoal:jdField_b_of_type_Long	J
    //   208: invokevirtual 152	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   211: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokestatic 162	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   217: pop
    //   218: aload_3
    //   219: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: astore_1
    //   223: iconst_0
    //   224: ifeq +11 -> 235
    //   227: new 193	java/lang/NullPointerException
    //   230: dup
    //   231: invokespecial 194	java/lang/NullPointerException:<init>	()V
    //   234: athrow
    //   235: aload_1
    //   236: astore_2
    //   237: iconst_0
    //   238: ifeq -75 -> 163
    //   241: new 193	java/lang/NullPointerException
    //   244: dup
    //   245: invokespecial 194	java/lang/NullPointerException:<init>	()V
    //   248: athrow
    //   249: astore_2
    //   250: aload_1
    //   251: areturn
    //   252: astore_1
    //   253: iconst_0
    //   254: ifeq +11 -> 265
    //   257: new 193	java/lang/NullPointerException
    //   260: dup
    //   261: invokespecial 194	java/lang/NullPointerException:<init>	()V
    //   264: athrow
    //   265: iconst_0
    //   266: ifeq +11 -> 277
    //   269: new 193	java/lang/NullPointerException
    //   272: dup
    //   273: invokespecial 194	java/lang/NullPointerException:<init>	()V
    //   276: athrow
    //   277: aload_1
    //   278: athrow
    //   279: astore_2
    //   280: goto -45 -> 235
    //   283: astore_1
    //   284: goto -135 -> 149
    //   287: astore_1
    //   288: goto -127 -> 161
    //   291: astore_2
    //   292: goto -27 -> 265
    //   295: astore_2
    //   296: goto -19 -> 277
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	299	0	paramInt	int
    //   117	7	1	str1	String
    //   136	1	1	localException1	Exception
    //   222	29	1	str2	String
    //   252	26	1	localObject1	Object
    //   283	1	1	localException2	Exception
    //   287	1	1	localException3	Exception
    //   112	125	2	localObject2	Object
    //   249	1	2	localException4	Exception
    //   279	1	2	localException5	Exception
    //   291	1	2	localException6	Exception
    //   295	1	2	localException7	Exception
    //   11	208	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   0	113	136	java/lang/Exception
    //   113	118	136	java/lang/Exception
    //   122	133	136	java/lang/Exception
    //   165	223	136	java/lang/Exception
    //   241	249	249	java/lang/Exception
    //   0	113	252	finally
    //   113	118	252	finally
    //   122	133	252	finally
    //   165	223	252	finally
    //   227	235	279	java/lang/Exception
    //   141	149	283	java/lang/Exception
    //   153	161	287	java/lang/Exception
    //   257	265	291	java/lang/Exception
    //   269	277	295	java/lang/Exception
  }
  
  public static final List<String> a(int paramInt, boolean paramBoolean)
  {
    Object localObject1 = new HashMap();
    Object localObject2;
    int i;
    Object localObject3;
    if (paramBoolean)
    {
      localObject1 = Thread.currentThread().getThreadGroup();
      localObject2 = new Thread[((ThreadGroup)localObject1).activeCount()];
      ((ThreadGroup)localObject1).enumerate((Thread[])localObject2);
      localObject1 = new HashMap(localObject2.length);
      int j = localObject2.length;
      i = 0;
      while (i < j)
      {
        localObject3 = localObject2[i];
        if (localObject3 != null) {
          ((Map)localObject1).put(((Thread)localObject3).getName(), localObject3);
        }
        i += 1;
      }
    }
    for (;;)
    {
      localObject2 = new ArrayList(jdField_a_of_type_JavaUtilMap.size() / 2);
      localObject3 = jdField_a_of_type_JavaUtilMap.keySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Object localObject4 = (String)((Iterator)localObject3).next();
        aoal localaoal = (aoal)jdField_a_of_type_JavaUtilMap.get(localObject4);
        if (localaoal.jdField_a_of_type_Int >= paramInt)
        {
          if (paramBoolean) {}
          StringBuilder localStringBuilder;
          for (i = 300;; i = 50)
          {
            localStringBuilder = new StringBuilder(i);
            localStringBuilder.append(localaoal.jdField_a_of_type_JavaLangString).append("_").append((String)localObject4).append(":").append(localaoal.jdField_a_of_type_Int).append("\r\n");
            if (!paramBoolean) {
              break;
            }
            localObject4 = (Thread)((Map)localObject1).get(localaoal.jdField_a_of_type_JavaLangString);
            if (localObject4 != null) {
              localStringBuilder.append(Arrays.toString(((Thread)localObject4).getStackTrace()));
            }
            localObject4 = StringUtils.getStringValue(localStringBuilder);
            if (localObject4 == null) {
              break label308;
            }
            ((List)localObject2).add(StringUtils.newStringWithData((char[])localObject4));
            break;
          }
          label308:
          ((List)localObject2).add(localStringBuilder.toString());
        }
      }
      if (paramBoolean) {
        ((List)localObject2).add(Arrays.toString(Looper.getMainLooper().getThread().getStackTrace()));
      }
      return localObject2;
    }
  }
  
  public static void a(aoal paramaoal)
  {
    paramaoal.recycle();
  }
  
  private static void a(String paramString, aoal paramaoal, boolean paramBoolean)
  {
    try
    {
      Object[] arrayOfObject = a(paramString);
      long l1;
      if (arrayOfObject != null)
      {
        paramString = (String)arrayOfObject[0];
        l1 = ((Long)arrayOfObject[1]).longValue();
      }
      for (long l2 = ((Long)arrayOfObject[2]).longValue();; l2 = -100L)
      {
        if (paramBoolean)
        {
          paramaoal.jdField_a_of_type_Long = l1;
          paramaoal.jdField_b_of_type_Long = l2;
          paramaoal.jdField_a_of_type_JavaLangString = paramString;
          return;
        }
        if (paramaoal.jdField_a_of_type_Long == -100L)
        {
          paramaoal.c = -100L;
          paramaoal.d = -100L;
          return;
        }
        paramaoal.c = (l1 - paramaoal.jdField_a_of_type_Long);
        paramaoal.d = (l2 - paramaoal.jdField_b_of_type_Long);
        return;
        l1 = -100L;
        paramString = null;
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  public static void a(boolean paramBoolean)
  {
    byte[] arrayOfByte = ByteArrayPool.getGenericInstance().getBuf(1024);
    try
    {
      localObject1 = a("-2");
      if (localObject1 == null) {
        break label117;
      }
      jdField_b_of_type_Long = ((Long)localObject1[1]).longValue();
      c = ((Long)localObject1[2]).longValue();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1;
        localException.printStackTrace();
        return;
        jdField_b_of_type_Long = -1L;
        c = -1L;
      }
    }
    finally
    {
      ByteArrayPool.getGenericInstance().returnBuf(arrayOfByte);
    }
    a("-1", jdField_a_of_type_Aoal, true);
    if (paramBoolean)
    {
      localObject1 = jdField_a_of_type_JavaUtilMap.values().iterator();
      while (((Iterator)localObject1).hasNext()) {
        a((aoal)((Iterator)localObject1).next());
      }
      label117:
      jdField_a_of_type_JavaUtilMap.clear();
      String[] arrayOfString = a(Process.myPid());
      if (arrayOfString != null)
      {
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          aoal localaoal = a();
          a(str, localaoal, true);
          jdField_a_of_type_JavaUtilMap.put(str, localaoal);
          i += 1;
        }
      }
    }
    ByteArrayPool.getGenericInstance().returnBuf(arrayOfByte);
  }
  
  /* Error */
  public static Object[] a(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: invokestatic 343	aoaj:a	(Ljava/lang/String;)Ljava/io/RandomAccessFile;
    //   6: astore 21
    //   8: invokestatic 315	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   11: sipush 1024
    //   14: invokevirtual 319	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   17: astore 22
    //   19: aload 21
    //   21: lconst_0
    //   22: invokevirtual 347	java/io/RandomAccessFile:seek	(J)V
    //   25: aload 21
    //   27: aload 22
    //   29: invokevirtual 351	java/io/RandomAccessFile:read	([B)I
    //   32: istore 4
    //   34: iconst_0
    //   35: istore_3
    //   36: goto +663 -> 699
    //   39: iload_2
    //   40: istore_1
    //   41: iload_2
    //   42: iload 4
    //   44: if_icmpge +691 -> 735
    //   47: getstatic 40	aoaj:jdField_a_of_type_ArrayOfInt	[I
    //   50: iload_3
    //   51: iload_2
    //   52: iastore
    //   53: iload_2
    //   54: istore_1
    //   55: goto +680 -> 735
    //   58: iload_1
    //   59: iload 4
    //   61: if_icmpge +696 -> 757
    //   64: getstatic 42	aoaj:jdField_b_of_type_ArrayOfInt	[I
    //   67: iload_3
    //   68: iload_1
    //   69: iastore
    //   70: goto +687 -> 757
    //   73: iload_3
    //   74: bipush 17
    //   76: if_icmpne +558 -> 634
    //   79: ldc 89
    //   81: aload_0
    //   82: invokevirtual 95	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   85: ifne +236 -> 321
    //   88: new 91	java/lang/String
    //   91: dup
    //   92: aload 22
    //   94: getstatic 40	aoaj:jdField_a_of_type_ArrayOfInt	[I
    //   97: iconst_1
    //   98: iaload
    //   99: iconst_1
    //   100: iadd
    //   101: getstatic 42	aoaj:jdField_b_of_type_ArrayOfInt	[I
    //   104: iconst_1
    //   105: iaload
    //   106: getstatic 40	aoaj:jdField_a_of_type_ArrayOfInt	[I
    //   109: iconst_1
    //   110: iaload
    //   111: isub
    //   112: iconst_1
    //   113: isub
    //   114: invokespecial 354	java/lang/String:<init>	([BII)V
    //   117: astore 23
    //   119: new 91	java/lang/String
    //   122: dup
    //   123: aload 22
    //   125: getstatic 40	aoaj:jdField_a_of_type_ArrayOfInt	[I
    //   128: bipush 13
    //   130: iaload
    //   131: getstatic 42	aoaj:jdField_b_of_type_ArrayOfInt	[I
    //   134: bipush 13
    //   136: iaload
    //   137: getstatic 40	aoaj:jdField_a_of_type_ArrayOfInt	[I
    //   140: bipush 13
    //   142: iaload
    //   143: isub
    //   144: invokespecial 354	java/lang/String:<init>	([BII)V
    //   147: invokestatic 357	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   150: lstore 5
    //   152: new 91	java/lang/String
    //   155: dup
    //   156: aload 22
    //   158: getstatic 40	aoaj:jdField_a_of_type_ArrayOfInt	[I
    //   161: bipush 15
    //   163: iaload
    //   164: getstatic 42	aoaj:jdField_b_of_type_ArrayOfInt	[I
    //   167: bipush 15
    //   169: iaload
    //   170: getstatic 40	aoaj:jdField_a_of_type_ArrayOfInt	[I
    //   173: bipush 15
    //   175: iaload
    //   176: isub
    //   177: invokespecial 354	java/lang/String:<init>	([BII)V
    //   180: invokestatic 357	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   183: lstore 7
    //   185: new 91	java/lang/String
    //   188: dup
    //   189: aload 22
    //   191: getstatic 40	aoaj:jdField_a_of_type_ArrayOfInt	[I
    //   194: bipush 14
    //   196: iaload
    //   197: getstatic 42	aoaj:jdField_b_of_type_ArrayOfInt	[I
    //   200: bipush 14
    //   202: iaload
    //   203: getstatic 40	aoaj:jdField_a_of_type_ArrayOfInt	[I
    //   206: bipush 14
    //   208: iaload
    //   209: isub
    //   210: invokespecial 354	java/lang/String:<init>	([BII)V
    //   213: invokestatic 357	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   216: lstore 9
    //   218: new 91	java/lang/String
    //   221: dup
    //   222: aload 22
    //   224: getstatic 40	aoaj:jdField_a_of_type_ArrayOfInt	[I
    //   227: bipush 16
    //   229: iaload
    //   230: getstatic 42	aoaj:jdField_b_of_type_ArrayOfInt	[I
    //   233: bipush 16
    //   235: iaload
    //   236: getstatic 40	aoaj:jdField_a_of_type_ArrayOfInt	[I
    //   239: bipush 16
    //   241: iaload
    //   242: isub
    //   243: invokespecial 354	java/lang/String:<init>	([BII)V
    //   246: invokestatic 357	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   249: lstore 11
    //   251: aload 23
    //   253: ifnull +50 -> 303
    //   256: iconst_3
    //   257: anewarray 4	java/lang/Object
    //   260: astore_0
    //   261: aload_0
    //   262: iconst_0
    //   263: aload 23
    //   265: aastore
    //   266: aload_0
    //   267: iconst_1
    //   268: lload 5
    //   270: lload 7
    //   272: ladd
    //   273: invokestatic 361	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   276: aastore
    //   277: aload_0
    //   278: iconst_2
    //   279: lload 9
    //   281: lload 11
    //   283: ladd
    //   284: invokestatic 361	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   287: aastore
    //   288: invokestatic 315	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   291: aload 22
    //   293: invokevirtual 335	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   296: aload 21
    //   298: invokevirtual 364	java/io/RandomAccessFile:close	()V
    //   301: aload_0
    //   302: areturn
    //   303: invokestatic 315	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   306: aload 22
    //   308: invokevirtual 335	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   311: aload 21
    //   313: invokevirtual 364	java/io/RandomAccessFile:close	()V
    //   316: aconst_null
    //   317: areturn
    //   318: astore_0
    //   319: aconst_null
    //   320: areturn
    //   321: new 91	java/lang/String
    //   324: dup
    //   325: aload 22
    //   327: getstatic 40	aoaj:jdField_a_of_type_ArrayOfInt	[I
    //   330: iconst_4
    //   331: iaload
    //   332: getstatic 42	aoaj:jdField_b_of_type_ArrayOfInt	[I
    //   335: iconst_4
    //   336: iaload
    //   337: getstatic 40	aoaj:jdField_a_of_type_ArrayOfInt	[I
    //   340: iconst_4
    //   341: iaload
    //   342: isub
    //   343: invokespecial 354	java/lang/String:<init>	([BII)V
    //   346: invokestatic 357	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   349: lstore 5
    //   351: new 91	java/lang/String
    //   354: dup
    //   355: aload 22
    //   357: getstatic 40	aoaj:jdField_a_of_type_ArrayOfInt	[I
    //   360: iconst_1
    //   361: iaload
    //   362: getstatic 42	aoaj:jdField_b_of_type_ArrayOfInt	[I
    //   365: iconst_1
    //   366: iaload
    //   367: getstatic 40	aoaj:jdField_a_of_type_ArrayOfInt	[I
    //   370: iconst_1
    //   371: iaload
    //   372: isub
    //   373: invokespecial 354	java/lang/String:<init>	([BII)V
    //   376: invokestatic 357	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   379: lstore 7
    //   381: new 91	java/lang/String
    //   384: dup
    //   385: aload 22
    //   387: getstatic 40	aoaj:jdField_a_of_type_ArrayOfInt	[I
    //   390: iconst_2
    //   391: iaload
    //   392: getstatic 42	aoaj:jdField_b_of_type_ArrayOfInt	[I
    //   395: iconst_2
    //   396: iaload
    //   397: getstatic 40	aoaj:jdField_a_of_type_ArrayOfInt	[I
    //   400: iconst_2
    //   401: iaload
    //   402: isub
    //   403: invokespecial 354	java/lang/String:<init>	([BII)V
    //   406: invokestatic 357	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   409: lstore 9
    //   411: new 91	java/lang/String
    //   414: dup
    //   415: aload 22
    //   417: getstatic 40	aoaj:jdField_a_of_type_ArrayOfInt	[I
    //   420: iconst_3
    //   421: iaload
    //   422: getstatic 42	aoaj:jdField_b_of_type_ArrayOfInt	[I
    //   425: iconst_3
    //   426: iaload
    //   427: getstatic 40	aoaj:jdField_a_of_type_ArrayOfInt	[I
    //   430: iconst_3
    //   431: iaload
    //   432: isub
    //   433: invokespecial 354	java/lang/String:<init>	([BII)V
    //   436: invokestatic 357	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   439: lstore 11
    //   441: new 91	java/lang/String
    //   444: dup
    //   445: aload 22
    //   447: getstatic 40	aoaj:jdField_a_of_type_ArrayOfInt	[I
    //   450: iconst_5
    //   451: iaload
    //   452: getstatic 42	aoaj:jdField_b_of_type_ArrayOfInt	[I
    //   455: iconst_5
    //   456: iaload
    //   457: getstatic 40	aoaj:jdField_a_of_type_ArrayOfInt	[I
    //   460: iconst_5
    //   461: iaload
    //   462: isub
    //   463: invokespecial 354	java/lang/String:<init>	([BII)V
    //   466: invokestatic 357	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   469: lstore 13
    //   471: new 91	java/lang/String
    //   474: dup
    //   475: aload 22
    //   477: getstatic 40	aoaj:jdField_a_of_type_ArrayOfInt	[I
    //   480: bipush 6
    //   482: iaload
    //   483: getstatic 42	aoaj:jdField_b_of_type_ArrayOfInt	[I
    //   486: bipush 6
    //   488: iaload
    //   489: getstatic 40	aoaj:jdField_a_of_type_ArrayOfInt	[I
    //   492: bipush 6
    //   494: iaload
    //   495: isub
    //   496: invokespecial 354	java/lang/String:<init>	([BII)V
    //   499: invokestatic 357	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   502: lstore 15
    //   504: new 91	java/lang/String
    //   507: dup
    //   508: aload 22
    //   510: getstatic 40	aoaj:jdField_a_of_type_ArrayOfInt	[I
    //   513: bipush 7
    //   515: iaload
    //   516: getstatic 42	aoaj:jdField_b_of_type_ArrayOfInt	[I
    //   519: bipush 7
    //   521: iaload
    //   522: getstatic 40	aoaj:jdField_a_of_type_ArrayOfInt	[I
    //   525: bipush 7
    //   527: iaload
    //   528: isub
    //   529: invokespecial 354	java/lang/String:<init>	([BII)V
    //   532: invokestatic 357	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   535: lstore 17
    //   537: new 91	java/lang/String
    //   540: dup
    //   541: aload 22
    //   543: getstatic 40	aoaj:jdField_a_of_type_ArrayOfInt	[I
    //   546: bipush 8
    //   548: iaload
    //   549: getstatic 42	aoaj:jdField_b_of_type_ArrayOfInt	[I
    //   552: bipush 8
    //   554: iaload
    //   555: getstatic 40	aoaj:jdField_a_of_type_ArrayOfInt	[I
    //   558: bipush 8
    //   560: iaload
    //   561: isub
    //   562: invokespecial 354	java/lang/String:<init>	([BII)V
    //   565: invokestatic 357	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   568: lstore 19
    //   570: iconst_3
    //   571: anewarray 4	java/lang/Object
    //   574: astore_0
    //   575: aload_0
    //   576: iconst_0
    //   577: ldc_w 366
    //   580: aastore
    //   581: aload_0
    //   582: iconst_1
    //   583: lload 5
    //   585: invokestatic 361	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   588: aastore
    //   589: aload_0
    //   590: iconst_2
    //   591: lload 7
    //   593: lload 9
    //   595: ladd
    //   596: lload 11
    //   598: ladd
    //   599: lload 13
    //   601: ladd
    //   602: lload 15
    //   604: ladd
    //   605: lload 17
    //   607: ladd
    //   608: lload 19
    //   610: ladd
    //   611: invokestatic 361	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   614: aastore
    //   615: invokestatic 315	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   618: aload 22
    //   620: invokevirtual 335	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   623: aload 21
    //   625: invokevirtual 364	java/io/RandomAccessFile:close	()V
    //   628: aload_0
    //   629: areturn
    //   630: astore 21
    //   632: aload_0
    //   633: areturn
    //   634: invokestatic 315	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   637: aload 22
    //   639: invokevirtual 335	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   642: aload 21
    //   644: invokevirtual 364	java/io/RandomAccessFile:close	()V
    //   647: aconst_null
    //   648: areturn
    //   649: astore_0
    //   650: invokestatic 315	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   653: aload 22
    //   655: invokevirtual 335	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   658: aload 21
    //   660: invokevirtual 364	java/io/RandomAccessFile:close	()V
    //   663: goto -16 -> 647
    //   666: astore_0
    //   667: goto -20 -> 647
    //   670: astore_0
    //   671: invokestatic 315	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   674: aload 22
    //   676: invokevirtual 335	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   679: aload 21
    //   681: invokevirtual 364	java/io/RandomAccessFile:close	()V
    //   684: aload_0
    //   685: athrow
    //   686: astore 21
    //   688: aload_0
    //   689: areturn
    //   690: astore_0
    //   691: goto -44 -> 647
    //   694: astore 21
    //   696: goto -12 -> 684
    //   699: iload_1
    //   700: iload 4
    //   702: if_icmpge -629 -> 73
    //   705: iload_3
    //   706: bipush 17
    //   708: if_icmpge -635 -> 73
    //   711: iload_1
    //   712: istore_2
    //   713: iload_2
    //   714: iload 4
    //   716: if_icmpge -677 -> 39
    //   719: aload 22
    //   721: iload_2
    //   722: baload
    //   723: bipush 32
    //   725: if_icmpne -686 -> 39
    //   728: iload_2
    //   729: iconst_1
    //   730: iadd
    //   731: istore_2
    //   732: goto -19 -> 713
    //   735: iload_1
    //   736: iload 4
    //   738: if_icmpge -680 -> 58
    //   741: aload 22
    //   743: iload_1
    //   744: baload
    //   745: bipush 32
    //   747: if_icmpeq -689 -> 58
    //   750: iload_1
    //   751: iconst_1
    //   752: iadd
    //   753: istore_1
    //   754: goto -19 -> 735
    //   757: iload_3
    //   758: iconst_1
    //   759: iadd
    //   760: istore_3
    //   761: goto -62 -> 699
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	764	0	paramString	String
    //   1	753	1	i	int
    //   39	693	2	j	int
    //   35	726	3	k	int
    //   32	707	4	m	int
    //   150	434	5	l1	long
    //   183	409	7	l2	long
    //   216	378	9	l3	long
    //   249	348	11	l4	long
    //   469	131	13	l5	long
    //   502	101	15	l6	long
    //   535	71	17	l7	long
    //   568	41	19	l8	long
    //   6	618	21	localRandomAccessFile	RandomAccessFile
    //   630	50	21	localException1	Exception
    //   686	1	21	localException2	Exception
    //   694	1	21	localException3	Exception
    //   17	725	22	arrayOfByte	byte[]
    //   117	147	23	str	String
    // Exception table:
    //   from	to	target	type
    //   311	316	318	java/lang/Exception
    //   623	628	630	java/lang/Exception
    //   19	34	649	java/lang/Exception
    //   47	53	649	java/lang/Exception
    //   64	70	649	java/lang/Exception
    //   79	251	649	java/lang/Exception
    //   256	261	649	java/lang/Exception
    //   266	288	649	java/lang/Exception
    //   321	575	649	java/lang/Exception
    //   581	615	649	java/lang/Exception
    //   658	663	666	java/lang/Exception
    //   19	34	670	finally
    //   47	53	670	finally
    //   64	70	670	finally
    //   79	251	670	finally
    //   256	261	670	finally
    //   266	288	670	finally
    //   321	575	670	finally
    //   581	615	670	finally
    //   296	301	686	java/lang/Exception
    //   642	647	690	java/lang/Exception
    //   679	684	694	java/lang/Exception
  }
  
  private static final String[] a(long paramLong)
  {
    File localFile = new File("/proc/" + paramLong + "/task");
    if ((localFile.exists()) && (localFile.isDirectory())) {
      return localFile.list();
    }
    return null;
  }
  
  private static final int b()
  {
    try
    {
      int i = new File("/sys/devices/system/cpu/").listFiles(new aoak()).length;
      return i;
    }
    catch (Exception localException) {}
    return 1;
  }
  
  public static void b(boolean paramBoolean)
  {
    byte[] arrayOfByte = ByteArrayPool.getGenericInstance().getBuf(1024);
    for (;;)
    {
      try
      {
        Object localObject1 = a("-2");
        if (localObject1 != null)
        {
          l1 = ((Long)localObject1[1]).longValue();
          l2 = ((Long)localObject1[2]).longValue();
          l1 = l1 + l2 - c - jdField_b_of_type_Long;
          a("-1", jdField_a_of_type_Aoal, false);
          if (paramBoolean)
          {
            localObject1 = jdField_a_of_type_JavaUtilMap.keySet().iterator();
            if (((Iterator)localObject1).hasNext())
            {
              String str = (String)((Iterator)localObject1).next();
              aoal localaoal = (aoal)jdField_a_of_type_JavaUtilMap.get(str);
              a(str, localaoal, false);
              localaoal.jdField_a_of_type_Int = ((int)(100L * (localaoal.d + localaoal.c) / l1));
              continue;
            }
          }
        }
        long l1 = -1L;
      }
      catch (Exception localException)
      {
        return;
        jdField_a_of_type_Int = (int)(100L * (l2 - c) / l1);
        jdField_a_of_type_Aoal.jdField_a_of_type_Int = ((int)(100L * (jdField_a_of_type_Aoal.d + jdField_a_of_type_Aoal.c) / l1));
        jdField_a_of_type_Long = SystemClock.uptimeMillis();
        return;
      }
      finally
      {
        ByteArrayPool.getGenericInstance().returnBuf(arrayOfByte);
      }
      long l2 = -1L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoaj
 * JD-Core Version:    0.7.0.1
 */