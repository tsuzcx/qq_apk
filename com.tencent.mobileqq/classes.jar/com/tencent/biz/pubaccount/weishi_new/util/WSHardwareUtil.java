package com.tencent.biz.pubaccount.weishi_new.util;

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
  private static int jdField_a_of_type_Int = -1;
  private static final FileFilter jdField_a_of_type_JavaIoFileFilter = new WSHardwareUtil.1();
  private static final Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public static int a()
  {
    int k = 0;
    int i = -1;
    try
    {
      int j;
      for (;;)
      {
        Object localObject1;
        if (k < b())
        {
          localObject1 = new File("/sys/devices/system/cpu/cpu" + k + "/cpufreq/cpuinfo_max_freq");
          j = i;
          if (((File)localObject1).exists())
          {
            j = i;
            if (((File)localObject1).canRead())
            {
              byte[] arrayOfByte = new byte[''];
              localObject1 = new FileInputStream((File)localObject1);
              try
              {
                ((FileInputStream)localObject1).read(arrayOfByte);
                j = 0;
                while ((Character.isDigit(arrayOfByte[j])) && (j < arrayOfByte.length)) {
                  j += 1;
                }
                int m = Integer.parseInt(new String(arrayOfByte, 0, j));
                j = i;
                if (m > i) {
                  j = m;
                }
              }
              catch (NumberFormatException localNumberFormatException)
              {
                ((FileInputStream)localObject1).close();
                j = i;
              }
              finally
              {
                ((FileInputStream)localObject1).close();
              }
            }
          }
        }
        else
        {
          j = i;
          if (i != -1) {
            break;
          }
          localObject1 = new FileInputStream("/proc/cpuinfo");
          try
          {
            j = a("cpu MHz", (FileInputStream)localObject1);
            k = j * 1000;
            j = i;
            if (k > i) {
              j = k;
            }
            return j;
          }
          finally
          {
            ((FileInputStream)localObject1).close();
          }
        }
        k += 1;
        i = j;
      }
      return j;
    }
    catch (IOException localIOException)
    {
      j = -1;
    }
  }
  
  public static int a(Context paramContext)
  {
    int j = 2;
    if (paramContext == null) {
      return -1;
    }
    if (jdField_a_of_type_Int != -1) {
      return jdField_a_of_type_Int;
    }
    int k = b(paramContext);
    int m = c();
    int i;
    if ((k < 1) && (m == 0)) {
      i = -2;
    }
    for (;;)
    {
      jdField_a_of_type_Int = i;
      return i;
      if ((k < 2) || (m == 0))
      {
        i = 1;
      }
      else if (k == 2)
      {
        i = j;
        if (m >= 1) {}
      }
      else if (k > 2)
      {
        i = j;
        if (m > 1) {
          i = 3;
        }
      }
      else
      {
        i = -1;
      }
    }
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
    //   9: new 110	java/io/BufferedReader
    //   12: dup
    //   13: new 112	java/io/InputStreamReader
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 115	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   21: invokespecial 118	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   24: astore_3
    //   25: aload_3
    //   26: invokevirtual 121	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   29: astore 4
    //   31: aload_3
    //   32: invokevirtual 122	java/io/BufferedReader:close	()V
    //   35: aload 4
    //   37: invokestatic 124	com/tencent/biz/pubaccount/weishi_new/util/WSHardwareUtil:b	(Ljava/lang/String;)I
    //   40: istore_1
    //   41: iload_1
    //   42: istore_2
    //   43: aload_0
    //   44: ifnull +9 -> 53
    //   47: aload_0
    //   48: invokevirtual 127	java/io/InputStream:close	()V
    //   51: iload_1
    //   52: istore_2
    //   53: iload_2
    //   54: ireturn
    //   55: astore_0
    //   56: aconst_null
    //   57: astore_0
    //   58: iconst_m1
    //   59: istore_2
    //   60: aload_0
    //   61: ifnull -8 -> 53
    //   64: aload_0
    //   65: invokevirtual 127	java/io/InputStream:close	()V
    //   68: iconst_m1
    //   69: ireturn
    //   70: astore_0
    //   71: iconst_m1
    //   72: ireturn
    //   73: astore_3
    //   74: aconst_null
    //   75: astore_0
    //   76: aload_0
    //   77: ifnull +7 -> 84
    //   80: aload_0
    //   81: invokevirtual 127	java/io/InputStream:close	()V
    //   84: aload_3
    //   85: athrow
    //   86: astore_0
    //   87: iload_1
    //   88: ireturn
    //   89: astore_0
    //   90: goto -6 -> 84
    //   93: astore_3
    //   94: goto -18 -> 76
    //   97: astore_3
    //   98: goto -40 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	paramString	String
    //   40	48	1	i	int
    //   42	18	2	j	int
    //   24	8	3	localBufferedReader	java.io.BufferedReader
    //   73	12	3	localObject1	Object
    //   93	1	3	localObject2	Object
    //   97	1	3	localIOException	IOException
    //   29	7	4	str	String
    // Exception table:
    //   from	to	target	type
    //   0	9	55	java/io/IOException
    //   64	68	70	java/io/IOException
    //   0	9	73	finally
    //   47	51	86	java/io/IOException
    //   80	84	89	java/io/IOException
    //   9	41	93	finally
    //   9	41	97	java/io/IOException
  }
  
  private static int a(String paramString, FileInputStream paramFileInputStream)
  {
    byte[] arrayOfByte = new byte[1024];
    int m;
    int j;
    int i;
    int k;
    for (;;)
    {
      try
      {
        m = paramFileInputStream.read(arrayOfByte);
        j = 0;
      }
      catch (NumberFormatException paramString)
      {
        return -1;
      }
      catch (IOException paramString)
      {
        continue;
      }
      k = i;
      if (j >= m) {
        break label129;
      }
      k = j - i;
      if (arrayOfByte[j] != paramString.charAt(k))
      {
        k = i;
        break label129;
      }
      if (k == paramString.length() - 1)
      {
        i = a(arrayOfByte, j);
        return i;
      }
      j += 1;
    }
    for (;;)
    {
      if (j < m)
      {
        if (arrayOfByte[j] != 10)
        {
          k = j;
          if (j != 0) {}
        }
        else
        {
          i = j;
          if (arrayOfByte[j] == 10) {
            i = j + 1;
          }
          j = i;
          break;
        }
        label129:
        j = k + 1;
      }
    }
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
  
  /* Error */
  @android.annotation.TargetApi(16)
  public static long a(Context paramContext)
  {
    // Byte code:
    //   0: ldc2_w 145
    //   3: lstore 4
    //   5: aload_0
    //   6: ifnonnull +7 -> 13
    //   9: ldc2_w 145
    //   12: lreturn
    //   13: getstatic 151	android/os/Build$VERSION:SDK_INT	I
    //   16: bipush 16
    //   18: if_icmplt +38 -> 56
    //   21: new 153	android/app/ActivityManager$MemoryInfo
    //   24: dup
    //   25: invokespecial 154	android/app/ActivityManager$MemoryInfo:<init>	()V
    //   28: astore 6
    //   30: aload_0
    //   31: ldc 156
    //   33: invokevirtual 162	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   36: checkcast 164	android/app/ActivityManager
    //   39: astore_0
    //   40: aload_0
    //   41: ifnull +9 -> 50
    //   44: aload_0
    //   45: aload 6
    //   47: invokevirtual 168	android/app/ActivityManager:getMemoryInfo	(Landroid/app/ActivityManager$MemoryInfo;)V
    //   50: aload 6
    //   52: getfield 172	android/app/ActivityManager$MemoryInfo:totalMem	J
    //   55: lreturn
    //   56: lload 4
    //   58: lstore_2
    //   59: new 67	java/io/FileInputStream
    //   62: dup
    //   63: ldc 174
    //   65: invokespecial 97	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   68: astore_0
    //   69: ldc 176
    //   71: aload_0
    //   72: invokestatic 102	com/tencent/biz/pubaccount/weishi_new/util/WSHardwareUtil:a	(Ljava/lang/String;Ljava/io/FileInputStream;)I
    //   75: istore_1
    //   76: iload_1
    //   77: i2l
    //   78: ldc2_w 177
    //   81: lmul
    //   82: lstore 4
    //   84: lload 4
    //   86: lstore_2
    //   87: aload_0
    //   88: invokevirtual 94	java/io/FileInputStream:close	()V
    //   91: lload 4
    //   93: lreturn
    //   94: astore_0
    //   95: aload_0
    //   96: invokevirtual 181	java/io/IOException:printStackTrace	()V
    //   99: lload_2
    //   100: lreturn
    //   101: astore 6
    //   103: lload 4
    //   105: lstore_2
    //   106: aload_0
    //   107: invokevirtual 94	java/io/FileInputStream:close	()V
    //   110: lload 4
    //   112: lstore_2
    //   113: aload 6
    //   115: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	paramContext	Context
    //   75	2	1	i	int
    //   58	55	2	l1	long
    //   3	108	4	l2	long
    //   28	23	6	localMemoryInfo	ActivityManager.MemoryInfo
    //   101	13	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   59	69	94	java/io/IOException
    //   87	91	94	java/io/IOException
    //   106	110	94	java/io/IOException
    //   113	116	94	java/io/IOException
    //   69	76	101	finally
  }
  
  public static String a()
  {
    return Build.BRAND;
  }
  
  public static String a(Context paramContext)
  {
    synchronized (jdField_a_of_type_JavaUtilMap)
    {
      if (jdField_a_of_type_JavaUtilMap.isEmpty())
      {
        jdField_a_of_type_JavaUtilMap.put("model", b());
        jdField_a_of_type_JavaUtilMap.put("brand", a());
        jdField_a_of_type_JavaUtilMap.put("cpuMaxFreqMHz", String.valueOf(a() / 1000));
        jdField_a_of_type_JavaUtilMap.put("cpuCoreNumber", String.valueOf(b()));
        jdField_a_of_type_JavaUtilMap.put("cpuName", c());
        jdField_a_of_type_JavaUtilMap.put("ram", String.valueOf(a(paramContext)));
      }
      jdField_a_of_type_JavaUtilMap.put("availRam", String.valueOf(b(paramContext)));
      paramContext = new JSONObject(jdField_a_of_type_JavaUtilMap).toString();
      return paramContext;
    }
  }
  
  public static int b()
  {
    int j;
    if (Build.VERSION.SDK_INT <= 10) {
      j = 1;
    }
    for (;;)
    {
      return j;
      try
      {
        j = a("/sys/devices/system/cpu/possible");
        int i = j;
        if (j == -1) {
          i = a("/sys/devices/system/cpu/present");
        }
        j = i;
        if (i == -1)
        {
          Object localObject = new File("/sys/devices/system/cpu/");
          j = i;
          if (localObject != null)
          {
            j = i;
            if (((File)localObject).exists())
            {
              localObject = ((File)localObject).listFiles(jdField_a_of_type_JavaIoFileFilter);
              j = i;
              if (localObject != null)
              {
                i = localObject.length;
                return i;
              }
            }
          }
        }
      }
      catch (SecurityException localSecurityException)
      {
        return -1;
      }
      catch (NullPointerException localNullPointerException) {}
    }
    return -1;
  }
  
  private static int b(Context paramContext)
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
  
  private static int b(String paramString)
  {
    if ((paramString == null) || (!paramString.matches("0-[\\d]+$"))) {
      return -1;
    }
    return Integer.parseInt(paramString.substring(2)) + 1;
  }
  
  public static long b(Context paramContext)
  {
    if (paramContext == null) {
      return -1L;
    }
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    if (paramContext != null)
    {
      paramContext.getMemoryInfo(localMemoryInfo);
      return localMemoryInfo.availMem;
    }
    return -1L;
  }
  
  public static String b()
  {
    return Build.MODEL;
  }
  
  private static int c()
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
  
  /* Error */
  public static String c()
  {
    // Byte code:
    //   0: new 282	java/io/FileReader
    //   3: dup
    //   4: ldc 96
    //   6: invokespecial 283	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   9: astore_1
    //   10: aload_1
    //   11: astore_0
    //   12: new 110	java/io/BufferedReader
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 118	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   20: astore 4
    //   22: ldc_w 285
    //   25: astore_2
    //   26: aload_1
    //   27: astore_0
    //   28: aload 4
    //   30: invokevirtual 121	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   33: astore_3
    //   34: aload_3
    //   35: ifnull +8 -> 43
    //   38: aload_3
    //   39: astore_2
    //   40: goto -14 -> 26
    //   43: aload_1
    //   44: astore_0
    //   45: aload_2
    //   46: ldc_w 287
    //   49: invokevirtual 291	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   52: ifeq +33 -> 85
    //   55: aload_1
    //   56: astore_0
    //   57: aload_2
    //   58: ldc_w 293
    //   61: iconst_2
    //   62: invokevirtual 297	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   65: iconst_1
    //   66: aaload
    //   67: astore_2
    //   68: aload_1
    //   69: ifnull +7 -> 76
    //   72: aload_1
    //   73: invokevirtual 298	java/io/FileReader:close	()V
    //   76: aload_2
    //   77: areturn
    //   78: astore_0
    //   79: aload_0
    //   80: invokevirtual 299	java/lang/Exception:printStackTrace	()V
    //   83: aload_2
    //   84: areturn
    //   85: aload_1
    //   86: ifnull +7 -> 93
    //   89: aload_1
    //   90: invokevirtual 298	java/io/FileReader:close	()V
    //   93: getstatic 302	android/os/Build:HARDWARE	Ljava/lang/String;
    //   96: areturn
    //   97: astore_0
    //   98: aload_0
    //   99: invokevirtual 299	java/lang/Exception:printStackTrace	()V
    //   102: goto -9 -> 93
    //   105: astore_2
    //   106: aconst_null
    //   107: astore_1
    //   108: aload_1
    //   109: astore_0
    //   110: aload_2
    //   111: invokevirtual 299	java/lang/Exception:printStackTrace	()V
    //   114: aload_1
    //   115: ifnull -22 -> 93
    //   118: aload_1
    //   119: invokevirtual 298	java/io/FileReader:close	()V
    //   122: goto -29 -> 93
    //   125: astore_0
    //   126: aload_0
    //   127: invokevirtual 299	java/lang/Exception:printStackTrace	()V
    //   130: goto -37 -> 93
    //   133: astore_1
    //   134: aconst_null
    //   135: astore_0
    //   136: aload_0
    //   137: ifnull +7 -> 144
    //   140: aload_0
    //   141: invokevirtual 298	java/io/FileReader:close	()V
    //   144: aload_1
    //   145: athrow
    //   146: astore_0
    //   147: aload_0
    //   148: invokevirtual 299	java/lang/Exception:printStackTrace	()V
    //   151: goto -7 -> 144
    //   154: astore_1
    //   155: goto -19 -> 136
    //   158: astore_2
    //   159: goto -51 -> 108
    // Local variable table:
    //   start	length	slot	name	signature
    //   11	46	0	localFileReader1	java.io.FileReader
    //   78	2	0	localException1	java.lang.Exception
    //   97	2	0	localException2	java.lang.Exception
    //   109	1	0	localFileReader2	java.io.FileReader
    //   125	2	0	localException3	java.lang.Exception
    //   135	6	0	localObject1	Object
    //   146	2	0	localException4	java.lang.Exception
    //   9	110	1	localFileReader3	java.io.FileReader
    //   133	12	1	localObject2	Object
    //   154	1	1	localObject3	Object
    //   25	59	2	localObject4	Object
    //   105	6	2	localException5	java.lang.Exception
    //   158	1	2	localException6	java.lang.Exception
    //   33	6	3	str	String
    //   20	9	4	localBufferedReader	java.io.BufferedReader
    // Exception table:
    //   from	to	target	type
    //   72	76	78	java/lang/Exception
    //   89	93	97	java/lang/Exception
    //   0	10	105	java/lang/Exception
    //   118	122	125	java/lang/Exception
    //   0	10	133	finally
    //   140	144	146	java/lang/Exception
    //   12	22	154	finally
    //   28	34	154	finally
    //   45	55	154	finally
    //   57	68	154	finally
    //   110	114	154	finally
    //   12	22	158	java/lang/Exception
    //   28	34	158	java/lang/Exception
    //   45	55	158	java/lang/Exception
    //   57	68	158	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WSHardwareUtil
 * JD-Core Version:    0.7.0.1
 */