package com.tencent.biz.pubaccount.weishi_new.util;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class WSHardwareUtil
{
  private static int a = -1;
  private static final Map<String, String> b = new HashMap();
  private static final FileFilter c = new WSHardwareUtil.1();
  
  /* Error */
  public static int a()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_m1
    //   3: istore_0
    //   4: iload_2
    //   5: invokestatic 35	com/tencent/biz/pubaccount/weishi_new/util/WSHardwareUtil:b	()I
    //   8: if_icmpge +163 -> 171
    //   11: new 37	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   18: astore 4
    //   20: aload 4
    //   22: ldc 40
    //   24: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload 4
    //   30: iload_2
    //   31: invokevirtual 47	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload 4
    //   37: ldc 49
    //   39: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: new 51	java/io/File
    //   46: dup
    //   47: aload 4
    //   49: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokespecial 58	java/io/File:<init>	(Ljava/lang/String;)V
    //   55: astore 4
    //   57: iload_0
    //   58: istore_1
    //   59: aload 4
    //   61: invokevirtual 62	java/io/File:exists	()Z
    //   64: ifeq +177 -> 241
    //   67: iload_0
    //   68: istore_1
    //   69: aload 4
    //   71: invokevirtual 65	java/io/File:canRead	()Z
    //   74: ifeq +167 -> 241
    //   77: sipush 128
    //   80: newarray byte
    //   82: astore 5
    //   84: new 67	java/io/FileInputStream
    //   87: dup
    //   88: aload 4
    //   90: invokespecial 70	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   93: astore 4
    //   95: aload 4
    //   97: aload 5
    //   99: invokevirtual 74	java/io/FileInputStream:read	([B)I
    //   102: pop
    //   103: iconst_0
    //   104: istore_1
    //   105: aload 5
    //   107: iload_1
    //   108: baload
    //   109: invokestatic 80	java/lang/Character:isDigit	(I)Z
    //   112: ifeq +17 -> 129
    //   115: iload_1
    //   116: aload 5
    //   118: arraylength
    //   119: if_icmpge +10 -> 129
    //   122: iload_1
    //   123: iconst_1
    //   124: iadd
    //   125: istore_1
    //   126: goto -21 -> 105
    //   129: new 82	java/lang/String
    //   132: dup
    //   133: aload 5
    //   135: iconst_0
    //   136: iload_1
    //   137: invokespecial 85	java/lang/String:<init>	([BII)V
    //   140: invokestatic 91	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   143: istore_3
    //   144: iload_0
    //   145: istore_1
    //   146: iload_3
    //   147: iload_0
    //   148: if_icmple +5 -> 153
    //   151: iload_3
    //   152: istore_1
    //   153: aload 4
    //   155: invokevirtual 94	java/io/FileInputStream:close	()V
    //   158: goto +83 -> 241
    //   161: astore 5
    //   163: aload 4
    //   165: invokevirtual 94	java/io/FileInputStream:close	()V
    //   168: aload 5
    //   170: athrow
    //   171: iload_0
    //   172: iconst_m1
    //   173: if_icmpne +55 -> 228
    //   176: new 67	java/io/FileInputStream
    //   179: dup
    //   180: ldc 96
    //   182: invokespecial 97	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   185: astore 4
    //   187: ldc 99
    //   189: aload 4
    //   191: invokestatic 102	com/tencent/biz/pubaccount/weishi_new/util/WSHardwareUtil:a	(Ljava/lang/String;Ljava/io/FileInputStream;)I
    //   194: istore_1
    //   195: iload_1
    //   196: sipush 1000
    //   199: imul
    //   200: istore_1
    //   201: iload_1
    //   202: iload_0
    //   203: if_icmple +8 -> 211
    //   206: iload_1
    //   207: istore_0
    //   208: goto +3 -> 211
    //   211: aload 4
    //   213: invokevirtual 94	java/io/FileInputStream:close	()V
    //   216: iload_0
    //   217: ireturn
    //   218: astore 5
    //   220: aload 4
    //   222: invokevirtual 94	java/io/FileInputStream:close	()V
    //   225: aload 5
    //   227: athrow
    //   228: iload_0
    //   229: ireturn
    //   230: astore 4
    //   232: iconst_m1
    //   233: ireturn
    //   234: astore 5
    //   236: iload_0
    //   237: istore_1
    //   238: goto -85 -> 153
    //   241: iload_2
    //   242: iconst_1
    //   243: iadd
    //   244: istore_2
    //   245: iload_1
    //   246: istore_0
    //   247: goto -243 -> 4
    // Local variable table:
    //   start	length	slot	name	signature
    //   3	244	0	i	int
    //   58	188	1	j	int
    //   1	244	2	k	int
    //   143	9	3	m	int
    //   18	203	4	localObject1	Object
    //   230	1	4	localIOException	IOException
    //   82	52	5	arrayOfByte	byte[]
    //   161	8	5	localObject2	Object
    //   218	8	5	localObject3	Object
    //   234	1	5	localNumberFormatException	NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   95	103	161	finally
    //   105	122	161	finally
    //   129	144	161	finally
    //   187	195	218	finally
    //   4	57	230	java/io/IOException
    //   59	67	230	java/io/IOException
    //   69	95	230	java/io/IOException
    //   153	158	230	java/io/IOException
    //   163	171	230	java/io/IOException
    //   176	187	230	java/io/IOException
    //   211	216	230	java/io/IOException
    //   220	228	230	java/io/IOException
    //   95	103	234	java/lang/NumberFormatException
    //   105	122	234	java/lang/NumberFormatException
    //   129	144	234	java/lang/NumberFormatException
  }
  
  /* Error */
  private static int a(String paramString)
  {
    // Byte code:
    //   0: new 67	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 97	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: new 104	java/io/BufferedReader
    //   12: dup
    //   13: new 106	java/io/InputStreamReader
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 109	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   21: invokespecial 112	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   24: astore_2
    //   25: aload_2
    //   26: invokevirtual 115	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   29: astore_3
    //   30: aload_2
    //   31: invokevirtual 116	java/io/BufferedReader:close	()V
    //   34: aload_3
    //   35: invokestatic 118	com/tencent/biz/pubaccount/weishi_new/util/WSHardwareUtil:b	(Ljava/lang/String;)I
    //   38: istore_1
    //   39: aload_0
    //   40: invokevirtual 121	java/io/InputStream:close	()V
    //   43: iload_1
    //   44: ireturn
    //   45: astore_3
    //   46: aload_0
    //   47: astore_2
    //   48: aload_3
    //   49: astore_0
    //   50: goto +9 -> 59
    //   53: goto +18 -> 71
    //   56: astore_0
    //   57: aconst_null
    //   58: astore_2
    //   59: aload_2
    //   60: ifnull +7 -> 67
    //   63: aload_2
    //   64: invokevirtual 121	java/io/InputStream:close	()V
    //   67: aload_0
    //   68: athrow
    //   69: aconst_null
    //   70: astore_0
    //   71: aload_0
    //   72: ifnull +7 -> 79
    //   75: aload_0
    //   76: invokevirtual 121	java/io/InputStream:close	()V
    //   79: iconst_m1
    //   80: ireturn
    //   81: astore_0
    //   82: goto -13 -> 69
    //   85: astore_2
    //   86: goto -33 -> 53
    //   89: astore_0
    //   90: iload_1
    //   91: ireturn
    //   92: astore_2
    //   93: goto -26 -> 67
    //   96: astore_0
    //   97: iconst_m1
    //   98: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	paramString	String
    //   38	53	1	i	int
    //   24	40	2	localObject1	Object
    //   85	1	2	localIOException1	IOException
    //   92	1	2	localIOException2	IOException
    //   29	6	3	str	String
    //   45	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   9	39	45	finally
    //   0	9	56	finally
    //   0	9	81	java/io/IOException
    //   9	39	85	java/io/IOException
    //   39	43	89	java/io/IOException
    //   63	67	92	java/io/IOException
    //   75	79	96	java/io/IOException
  }
  
  private static int a(String paramString, FileInputStream paramFileInputStream)
  {
    arrayOfByte = new byte[1024];
    for (;;)
    {
      try
      {
        m = paramFileInputStream.read(arrayOfByte);
        j = 0;
      }
      catch (IOException|NumberFormatException paramString)
      {
        int m;
        continue;
        if (j >= m) {
          continue;
        }
        if (arrayOfByte[j] == 10) {
          continue;
        }
        int k = j;
        if (j != 0) {
          continue;
        }
        int i = j;
        if (arrayOfByte[j] != 10) {
          continue;
        }
        i = j + 1;
        int j = i;
        continue;
      }
      k = i;
      if (j >= m) {
        continue;
      }
      k = j - i;
      if (arrayOfByte[j] != paramString.charAt(k))
      {
        k = i;
        continue;
      }
      if (k == paramString.length() - 1)
      {
        i = a(arrayOfByte, j);
        return i;
      }
      j += 1;
    }
    j = k + 1;
    break label94;
    return -1;
  }
  
  private static int a(byte[] paramArrayOfByte, int paramInt)
  {
    while ((paramInt < paramArrayOfByte.length) && (paramArrayOfByte[paramInt] != 10))
    {
      if (Character.isDigit(paramArrayOfByte[paramInt]))
      {
        int i = paramInt + 1;
        while ((i < paramArrayOfByte.length) && (Character.isDigit(paramArrayOfByte[i]))) {
          i += 1;
        }
        return Integer.parseInt(new String(paramArrayOfByte, 0, paramInt, i - paramInt));
      }
      paramInt += 1;
    }
    return -1;
  }
  
  @TargetApi(16)
  public static long a(Context paramContext)
  {
    long l2 = -1L;
    if (paramContext == null) {
      return -1L;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      if (paramContext != null) {
        paramContext.getMemoryInfo(localMemoryInfo);
      }
      return localMemoryInfo.totalMem;
    }
    l1 = l2;
    try
    {
      paramContext = new FileInputStream("/proc/meminfo");
      try
      {
        int i = a("MemTotal", paramContext);
        l2 = i * 1024L;
        l1 = l2;
        paramContext.close();
        return l2;
      }
      finally
      {
        l1 = l2;
        paramContext.close();
        l1 = l2;
      }
      return l1;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static int b()
  {
    if (Build.VERSION.SDK_INT <= 10) {
      return 1;
    }
    try
    {
      int j = a("/sys/devices/system/cpu/possible");
      int i = j;
      if (j == -1) {
        i = a("/sys/devices/system/cpu/present");
      }
      if (i == -1)
      {
        Object localObject = new File("/sys/devices/system/cpu/");
        if (((File)localObject).exists())
        {
          localObject = ((File)localObject).listFiles(c);
          if (localObject != null)
          {
            i = localObject.length;
            return i;
          }
        }
      }
      return i;
    }
    catch (SecurityException|NullPointerException localSecurityException) {}
    return -1;
  }
  
  private static int b(String paramString)
  {
    if ((paramString != null) && (paramString.matches("0-[\\d]+$"))) {
      return Integer.parseInt(paramString.substring(2)) + 1;
    }
    return -1;
  }
  
  public static long b(Context paramContext)
  {
    long l = -1L;
    if (paramContext == null) {
      return -1L;
    }
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    if (paramContext != null)
    {
      paramContext.getMemoryInfo(localMemoryInfo);
      l = localMemoryInfo.availMem;
    }
    return l;
  }
  
  public static int c(Context paramContext)
  {
    int i = -1;
    if (paramContext == null) {
      return -1;
    }
    int j = a;
    if (j != -1) {
      return j;
    }
    j = e(paramContext);
    int k = f();
    if ((j < 1) && (k == 0))
    {
      i = -2;
    }
    else if ((j >= 2) && (k != 0))
    {
      if ((j == 2) && (k >= 1)) {}
      do
      {
        i = 2;
        break;
        if (j <= 2) {
          break;
        }
      } while (k <= 1);
      i = 3;
    }
    else
    {
      i = 1;
    }
    a = i;
    return i;
  }
  
  public static String c()
  {
    return Build.BRAND;
  }
  
  public static String d()
  {
    return Build.MODEL;
  }
  
  public static String d(Context paramContext)
  {
    synchronized (b)
    {
      if (b.isEmpty())
      {
        b.put("model", d());
        b.put("brand", c());
        b.put("cpuMaxFreqMHz", String.valueOf(a() / 1000));
        b.put("cpuCoreNumber", String.valueOf(b()));
        b.put("cpuName", e());
        b.put("ram", String.valueOf(a(paramContext)));
      }
      b.put("availRam", String.valueOf(b(paramContext)));
      paramContext = new JSONObject(b).toString();
      return paramContext;
    }
  }
  
  private static int e(Context paramContext)
  {
    long l = a(paramContext) / 1048576L;
    if (l <= 2000L) {
      return 0;
    }
    if (l <= 3000L) {
      return 1;
    }
    if (l <= 4000L) {
      return 2;
    }
    if (l <= 6000L) {
      return 3;
    }
    return 4;
  }
  
  /* Error */
  public static String e()
  {
    // Byte code:
    //   0: new 286	java/io/FileReader
    //   3: dup
    //   4: ldc 96
    //   6: invokespecial 287	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   9: astore_1
    //   10: aload_1
    //   11: astore_0
    //   12: new 104	java/io/BufferedReader
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 112	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   20: astore 4
    //   22: ldc_w 289
    //   25: astore_2
    //   26: aload_1
    //   27: astore_0
    //   28: aload 4
    //   30: invokevirtual 115	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   33: astore_3
    //   34: aload_3
    //   35: ifnull +8 -> 43
    //   38: aload_3
    //   39: astore_2
    //   40: goto -14 -> 26
    //   43: aload_1
    //   44: astore_0
    //   45: aload_2
    //   46: ldc_w 291
    //   49: invokevirtual 295	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   52: ifeq +29 -> 81
    //   55: aload_1
    //   56: astore_0
    //   57: aload_2
    //   58: ldc_w 297
    //   61: iconst_2
    //   62: invokevirtual 301	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   65: iconst_1
    //   66: aaload
    //   67: astore_2
    //   68: aload_1
    //   69: invokevirtual 302	java/io/FileReader:close	()V
    //   72: aload_2
    //   73: areturn
    //   74: astore_0
    //   75: aload_0
    //   76: invokevirtual 303	java/lang/Exception:printStackTrace	()V
    //   79: aload_2
    //   80: areturn
    //   81: aload_1
    //   82: invokevirtual 302	java/io/FileReader:close	()V
    //   85: goto +38 -> 123
    //   88: astore_2
    //   89: goto +12 -> 101
    //   92: astore_0
    //   93: aconst_null
    //   94: astore_1
    //   95: goto +37 -> 132
    //   98: astore_2
    //   99: aconst_null
    //   100: astore_1
    //   101: aload_1
    //   102: astore_0
    //   103: aload_2
    //   104: invokevirtual 303	java/lang/Exception:printStackTrace	()V
    //   107: aload_1
    //   108: ifnull +15 -> 123
    //   111: aload_1
    //   112: invokevirtual 302	java/io/FileReader:close	()V
    //   115: goto +8 -> 123
    //   118: astore_0
    //   119: aload_0
    //   120: invokevirtual 303	java/lang/Exception:printStackTrace	()V
    //   123: getstatic 306	android/os/Build:HARDWARE	Ljava/lang/String;
    //   126: areturn
    //   127: astore_2
    //   128: aload_0
    //   129: astore_1
    //   130: aload_2
    //   131: astore_0
    //   132: aload_1
    //   133: ifnull +15 -> 148
    //   136: aload_1
    //   137: invokevirtual 302	java/io/FileReader:close	()V
    //   140: goto +8 -> 148
    //   143: astore_1
    //   144: aload_1
    //   145: invokevirtual 303	java/lang/Exception:printStackTrace	()V
    //   148: goto +5 -> 153
    //   151: aload_0
    //   152: athrow
    //   153: goto -2 -> 151
    // Local variable table:
    //   start	length	slot	name	signature
    //   11	46	0	localObject1	Object
    //   74	2	0	localException1	java.lang.Exception
    //   92	1	0	localObject2	Object
    //   102	1	0	localObject3	Object
    //   118	11	0	localException2	java.lang.Exception
    //   131	21	0	localObject4	Object
    //   9	128	1	localObject5	Object
    //   143	2	1	localException3	java.lang.Exception
    //   25	55	2	localObject6	Object
    //   88	1	2	localException4	java.lang.Exception
    //   98	6	2	localException5	java.lang.Exception
    //   127	4	2	localObject7	Object
    //   33	6	3	str	String
    //   20	9	4	localBufferedReader	java.io.BufferedReader
    // Exception table:
    //   from	to	target	type
    //   68	72	74	java/lang/Exception
    //   12	22	88	java/lang/Exception
    //   28	34	88	java/lang/Exception
    //   45	55	88	java/lang/Exception
    //   57	68	88	java/lang/Exception
    //   0	10	92	finally
    //   0	10	98	java/lang/Exception
    //   81	85	118	java/lang/Exception
    //   111	115	118	java/lang/Exception
    //   12	22	127	finally
    //   28	34	127	finally
    //   45	55	127	finally
    //   57	68	127	finally
    //   103	107	127	finally
    //   136	140	143	java/lang/Exception
  }
  
  private static int f()
  {
    int i = a() / 1000;
    if (i <= 1600) {
      return 0;
    }
    if (i <= 2000) {
      return 1;
    }
    if (i <= 2500) {
      return 2;
    }
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WSHardwareUtil
 * JD-Core Version:    0.7.0.1
 */