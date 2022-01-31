package com.tencent.mobileqq.ar.arengine;

import aaau;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;

public class ARDeviceInfo
{
  private static int jdField_a_of_type_Int = -1;
  private static long jdField_a_of_type_Long;
  private static final FileFilter jdField_a_of_type_JavaIoFileFilter = new aaau();
  private static int b = -1;
  private static int c;
  
  static
  {
    jdField_a_of_type_Long = -1L;
    c = -1;
  }
  
  public static int a()
  {
    if (c != -1) {
      return c;
    }
    jdField_a_of_type_Int = b();
    b = c();
    jdField_a_of_type_Long = a(BaseApplicationImpl.getApplication().getApplicationContext());
    if ((jdField_a_of_type_Int >= 8) || ((jdField_a_of_type_Int >= 4) && (b > 2355.1999999999998D) && (jdField_a_of_type_Long > 2048L)))
    {
      c = 0;
      if ((Build.MODEL.equalsIgnoreCase("MI NOTE LTE")) || (Build.MODEL.equalsIgnoreCase("vivo Y37A")) || (Build.MODEL.equalsIgnoreCase("Nexus 6")) || (Build.MODEL.equalsIgnoreCase("ATH-AL00"))) {
        c = 1;
      }
    }
    for (;;)
    {
      QLog.i("AREngine_ARDeviceInfo", 1, "getDeviceCapability. Build.MODEL = " + Build.MODEL + ", deviceCapability = " + c + ", numberOfCPUCores = " + jdField_a_of_type_Int + ", cpuMaxFreqMHz = " + b + ", totalMemoryMB = " + jdField_a_of_type_Long);
      return c;
      if ((jdField_a_of_type_Int <= 2) || (b < 1331.2D) || (jdField_a_of_type_Long <= 1024L)) {
        c = 2;
      } else {
        c = 1;
      }
    }
  }
  
  static int a(String paramString)
  {
    if ((paramString == null) || (!paramString.matches("0-[\\d]+$"))) {
      return -1;
    }
    return Integer.valueOf(paramString.substring(2)).intValue() + 1;
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
  public static long a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: getstatic 20	com/tencent/mobileqq/ar/arengine/ARDeviceInfo:jdField_a_of_type_Long	J
    //   3: ldc2_w 17
    //   6: lcmp
    //   7: ifeq +7 -> 14
    //   10: getstatic 20	com/tencent/mobileqq/ar/arengine/ARDeviceInfo:jdField_a_of_type_Long	J
    //   13: lreturn
    //   14: getstatic 172	android/os/Build$VERSION:SDK_INT	I
    //   17: bipush 16
    //   19: if_icmplt +51 -> 70
    //   22: new 174	android/app/ActivityManager$MemoryInfo
    //   25: dup
    //   26: invokespecial 175	android/app/ActivityManager$MemoryInfo:<init>	()V
    //   29: astore 4
    //   31: aload_0
    //   32: ldc 177
    //   34: invokevirtual 183	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   37: checkcast 185	android/app/ActivityManager
    //   40: aload 4
    //   42: invokevirtual 189	android/app/ActivityManager:getMemoryInfo	(Landroid/app/ActivityManager$MemoryInfo;)V
    //   45: aload 4
    //   47: ifnull +19 -> 66
    //   50: aload 4
    //   52: getfield 192	android/app/ActivityManager$MemoryInfo:totalMem	J
    //   55: ldc2_w 193
    //   58: ldiv
    //   59: putstatic 20	com/tencent/mobileqq/ar/arengine/ARDeviceInfo:jdField_a_of_type_Long	J
    //   62: getstatic 20	com/tencent/mobileqq/ar/arengine/ARDeviceInfo:jdField_a_of_type_Long	J
    //   65: lreturn
    //   66: ldc2_w 17
    //   69: lreturn
    //   70: new 138	java/io/FileInputStream
    //   73: dup
    //   74: ldc 196
    //   76: invokespecial 199	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   79: astore_0
    //   80: ldc 201
    //   82: aload_0
    //   83: invokestatic 203	com/tencent/mobileqq/ar/arengine/ARDeviceInfo:a	(Ljava/lang/String;Ljava/io/FileInputStream;)I
    //   86: istore_1
    //   87: iload_1
    //   88: i2l
    //   89: lstore_2
    //   90: aload_0
    //   91: invokevirtual 206	java/io/FileInputStream:close	()V
    //   94: lload_2
    //   95: ldc2_w 111
    //   98: ldiv
    //   99: putstatic 20	com/tencent/mobileqq/ar/arengine/ARDeviceInfo:jdField_a_of_type_Long	J
    //   102: getstatic 20	com/tencent/mobileqq/ar/arengine/ARDeviceInfo:jdField_a_of_type_Long	J
    //   105: lreturn
    //   106: astore 4
    //   108: aload_0
    //   109: invokevirtual 206	java/io/FileInputStream:close	()V
    //   112: aload 4
    //   114: athrow
    //   115: astore_0
    //   116: ldc2_w 17
    //   119: lstore_2
    //   120: goto -26 -> 94
    //   123: astore_0
    //   124: goto -30 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	paramContext	android.content.Context
    //   86	2	1	i	int
    //   89	31	2	l	long
    //   29	22	4	localMemoryInfo	android.app.ActivityManager.MemoryInfo
    //   106	7	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   80	87	106	finally
    //   70	80	115	java/io/IOException
    //   108	115	115	java/io/IOException
    //   90	94	123	java/io/IOException
  }
  
  public static int b()
  {
    if (jdField_a_of_type_Int != -1) {
      return jdField_a_of_type_Int;
    }
    if (Build.VERSION.SDK_INT <= 10)
    {
      jdField_a_of_type_Int = 1;
      return jdField_a_of_type_Int;
    }
    try
    {
      i = b("/sys/devices/system/cpu/possible");
      int j = i;
      if (i == -1) {
        j = b("/sys/devices/system/cpu/present");
      }
      i = j;
      if (j == -1) {
        i = d();
      }
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        i = -1;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        int i = -1;
      }
    }
    jdField_a_of_type_Int = i;
    return i;
  }
  
  /* Error */
  private static int b(String paramString)
  {
    // Byte code:
    //   0: new 138	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 199	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: new 222	java/io/BufferedReader
    //   12: dup
    //   13: new 224	java/io/InputStreamReader
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 227	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   21: invokespecial 230	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   24: astore_3
    //   25: aload_3
    //   26: invokevirtual 233	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   29: astore 4
    //   31: aload_3
    //   32: invokevirtual 234	java/io/BufferedReader:close	()V
    //   35: aload 4
    //   37: invokestatic 236	com/tencent/mobileqq/ar/arengine/ARDeviceInfo:a	(Ljava/lang/String;)I
    //   40: istore_1
    //   41: iload_1
    //   42: istore_2
    //   43: aload_0
    //   44: ifnull +9 -> 53
    //   47: aload_0
    //   48: invokevirtual 239	java/io/InputStream:close	()V
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
    //   65: invokevirtual 239	java/io/InputStream:close	()V
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
    //   81: invokevirtual 239	java/io/InputStream:close	()V
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
  
  /* Error */
  public static int c()
  {
    // Byte code:
    //   0: getstatic 16	com/tencent/mobileqq/ar/arengine/ARDeviceInfo:b	I
    //   3: iconst_m1
    //   4: if_icmpeq +7 -> 11
    //   7: getstatic 16	com/tencent/mobileqq/ar/arengine/ARDeviceInfo:b	I
    //   10: ireturn
    //   11: getstatic 59	android/os/Build:MODEL	Ljava/lang/String;
    //   14: ldc 243
    //   16: invokevirtual 67	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   19: ifeq +13 -> 32
    //   22: sipush 1824
    //   25: putstatic 16	com/tencent/mobileqq/ar/arengine/ARDeviceInfo:b	I
    //   28: getstatic 16	com/tencent/mobileqq/ar/arengine/ARDeviceInfo:b	I
    //   31: ireturn
    //   32: iconst_0
    //   33: istore_3
    //   34: iconst_0
    //   35: istore 4
    //   37: iconst_m1
    //   38: istore_0
    //   39: iload_3
    //   40: invokestatic 34	com/tencent/mobileqq/ar/arengine/ARDeviceInfo:b	()I
    //   43: if_icmpge +323 -> 366
    //   46: new 77	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   53: ldc 245
    //   55: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: iload_3
    //   59: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   62: ldc 247
    //   64: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: astore 5
    //   72: ldc 75
    //   74: iconst_1
    //   75: new 77	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   82: ldc 249
    //   84: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload 5
    //   89: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 108	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   98: iload_0
    //   99: istore_2
    //   100: new 251	java/io/File
    //   103: dup
    //   104: aload 5
    //   106: invokespecial 252	java/io/File:<init>	(Ljava/lang/String;)V
    //   109: astore 5
    //   111: iload_0
    //   112: istore_2
    //   113: aload 5
    //   115: invokevirtual 256	java/io/File:exists	()Z
    //   118: ifeq +232 -> 350
    //   121: iload_0
    //   122: istore_2
    //   123: sipush 128
    //   126: newarray byte
    //   128: astore 6
    //   130: iload_0
    //   131: istore_2
    //   132: new 138	java/io/FileInputStream
    //   135: dup
    //   136: aload 5
    //   138: invokespecial 259	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   141: astore 5
    //   143: aload 5
    //   145: aload 6
    //   147: invokevirtual 142	java/io/FileInputStream:read	([B)I
    //   150: pop
    //   151: iconst_0
    //   152: istore_1
    //   153: aload 6
    //   155: iload_1
    //   156: baload
    //   157: invokestatic 158	java/lang/Character:isDigit	(I)Z
    //   160: ifeq +17 -> 177
    //   163: iload_1
    //   164: aload 6
    //   166: arraylength
    //   167: if_icmpge +10 -> 177
    //   170: iload_1
    //   171: iconst_1
    //   172: iadd
    //   173: istore_1
    //   174: goto -21 -> 153
    //   177: new 63	java/lang/String
    //   180: dup
    //   181: aload 6
    //   183: iconst_0
    //   184: iload_1
    //   185: invokespecial 262	java/lang/String:<init>	([BII)V
    //   188: invokestatic 164	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   191: sipush 1000
    //   194: idiv
    //   195: istore_2
    //   196: ldc 75
    //   198: iconst_1
    //   199: new 77	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   206: ldc_w 264
    //   209: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: iload_2
    //   213: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   216: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokestatic 108	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   222: iload_0
    //   223: istore_1
    //   224: iload_2
    //   225: iload_0
    //   226: if_icmple +5 -> 231
    //   229: iload_2
    //   230: istore_1
    //   231: iload_1
    //   232: istore_2
    //   233: aload 5
    //   235: invokevirtual 206	java/io/FileInputStream:close	()V
    //   238: iload_1
    //   239: istore_0
    //   240: iload 4
    //   242: istore_1
    //   243: iload_3
    //   244: iconst_1
    //   245: iadd
    //   246: istore_3
    //   247: iload_1
    //   248: istore 4
    //   250: goto -211 -> 39
    //   253: astore 6
    //   255: ldc 75
    //   257: iconst_1
    //   258: new 77	java/lang/StringBuilder
    //   261: dup
    //   262: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   265: ldc_w 266
    //   268: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: aload 6
    //   273: invokevirtual 267	java/lang/Exception:toString	()Ljava/lang/String;
    //   276: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: invokestatic 108	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   285: iload_0
    //   286: istore_2
    //   287: aload 5
    //   289: invokevirtual 206	java/io/FileInputStream:close	()V
    //   292: iconst_1
    //   293: istore_1
    //   294: goto -51 -> 243
    //   297: astore 6
    //   299: iload_0
    //   300: istore_2
    //   301: aload 5
    //   303: invokevirtual 206	java/io/FileInputStream:close	()V
    //   306: iload_0
    //   307: istore_2
    //   308: aload 6
    //   310: athrow
    //   311: astore 5
    //   313: ldc 75
    //   315: iconst_1
    //   316: new 77	java/lang/StringBuilder
    //   319: dup
    //   320: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   323: ldc_w 269
    //   326: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: aload 5
    //   331: invokevirtual 267	java/lang/Exception:toString	()Ljava/lang/String;
    //   334: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: invokestatic 108	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   343: iconst_1
    //   344: istore_1
    //   345: iload_2
    //   346: istore_0
    //   347: goto -104 -> 243
    //   350: iload_0
    //   351: istore_2
    //   352: ldc 75
    //   354: iconst_1
    //   355: ldc_w 271
    //   358: invokestatic 108	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   361: iconst_1
    //   362: istore_1
    //   363: goto -120 -> 243
    //   366: iload_0
    //   367: istore_1
    //   368: iload 4
    //   370: ifeq +121 -> 491
    //   373: invokestatic 274	com/tencent/mobileqq/ar/arengine/ARDeviceInfo:e	()I
    //   376: istore_1
    //   377: ldc 75
    //   379: iconst_1
    //   380: new 77	java/lang/StringBuilder
    //   383: dup
    //   384: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   387: ldc_w 276
    //   390: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: iload_1
    //   394: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   397: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: invokestatic 108	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   403: iload_1
    //   404: istore_2
    //   405: iload_0
    //   406: istore_3
    //   407: iload_1
    //   408: iconst_m1
    //   409: if_icmpne +174 -> 583
    //   412: iload_1
    //   413: istore_2
    //   414: new 138	java/io/FileInputStream
    //   417: dup
    //   418: ldc_w 278
    //   421: invokespecial 199	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   424: astore 6
    //   426: ldc_w 280
    //   429: aload 6
    //   431: invokestatic 203	com/tencent/mobileqq/ar/arengine/ARDeviceInfo:a	(Ljava/lang/String;Ljava/io/FileInputStream;)I
    //   434: istore_2
    //   435: iload_2
    //   436: istore_1
    //   437: iload_1
    //   438: istore_2
    //   439: ldc 75
    //   441: iconst_1
    //   442: new 77	java/lang/StringBuilder
    //   445: dup
    //   446: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   449: ldc_w 282
    //   452: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: iload_1
    //   456: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   459: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   462: invokestatic 108	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   465: iload_0
    //   466: istore_2
    //   467: iload_1
    //   468: iload_0
    //   469: if_icmple +5 -> 474
    //   472: iload_1
    //   473: istore_2
    //   474: iload_1
    //   475: istore 4
    //   477: iload_2
    //   478: istore_3
    //   479: aload 6
    //   481: invokevirtual 206	java/io/FileInputStream:close	()V
    //   484: iload_2
    //   485: istore_0
    //   486: iload_1
    //   487: iload_0
    //   488: if_icmple +133 -> 621
    //   491: iload_1
    //   492: putstatic 16	com/tencent/mobileqq/ar/arengine/ARDeviceInfo:b	I
    //   495: iload_1
    //   496: ireturn
    //   497: astore 5
    //   499: iload_1
    //   500: istore_2
    //   501: ldc 75
    //   503: iconst_1
    //   504: new 77	java/lang/StringBuilder
    //   507: dup
    //   508: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   511: ldc_w 284
    //   514: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: aload 5
    //   519: invokevirtual 267	java/lang/Exception:toString	()Ljava/lang/String;
    //   522: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   525: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   528: invokestatic 108	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   531: iload_1
    //   532: istore 4
    //   534: iload_0
    //   535: istore_3
    //   536: aload 6
    //   538: invokevirtual 206	java/io/FileInputStream:close	()V
    //   541: goto -55 -> 486
    //   544: astore 5
    //   546: iload 4
    //   548: istore_2
    //   549: iload_3
    //   550: istore_0
    //   551: ldc 75
    //   553: iconst_1
    //   554: new 77	java/lang/StringBuilder
    //   557: dup
    //   558: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   561: ldc_w 286
    //   564: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: aload 5
    //   569: invokevirtual 267	java/lang/Exception:toString	()Ljava/lang/String;
    //   572: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   578: invokestatic 108	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   581: iload_0
    //   582: istore_3
    //   583: iload_3
    //   584: istore_0
    //   585: iload_2
    //   586: istore_1
    //   587: goto -101 -> 486
    //   590: astore 5
    //   592: iload_1
    //   593: istore_2
    //   594: aload 6
    //   596: invokevirtual 206	java/io/FileInputStream:close	()V
    //   599: iload_1
    //   600: istore_2
    //   601: aload 5
    //   603: athrow
    //   604: astore 5
    //   606: goto -55 -> 551
    //   609: astore 5
    //   611: iload_2
    //   612: istore_1
    //   613: goto -21 -> 592
    //   616: astore 5
    //   618: goto -119 -> 499
    //   621: iload_0
    //   622: istore_1
    //   623: goto -132 -> 491
    // Local variable table:
    //   start	length	slot	name	signature
    //   38	584	0	i	int
    //   152	471	1	j	int
    //   99	513	2	k	int
    //   33	551	3	m	int
    //   35	512	4	n	int
    //   70	232	5	localObject1	Object
    //   311	19	5	localException1	java.lang.Exception
    //   497	21	5	localException2	java.lang.Exception
    //   544	24	5	localException3	java.lang.Exception
    //   590	12	5	localObject2	Object
    //   604	1	5	localException4	java.lang.Exception
    //   609	1	5	localObject3	Object
    //   616	1	5	localException5	java.lang.Exception
    //   128	54	6	arrayOfByte	byte[]
    //   253	19	6	localException6	java.lang.Exception
    //   297	12	6	localObject4	Object
    //   424	171	6	localFileInputStream	FileInputStream
    // Exception table:
    //   from	to	target	type
    //   143	151	253	java/lang/Exception
    //   153	170	253	java/lang/Exception
    //   177	222	253	java/lang/Exception
    //   143	151	297	finally
    //   153	170	297	finally
    //   177	222	297	finally
    //   255	285	297	finally
    //   100	111	311	java/lang/Exception
    //   113	121	311	java/lang/Exception
    //   123	130	311	java/lang/Exception
    //   132	143	311	java/lang/Exception
    //   233	238	311	java/lang/Exception
    //   287	292	311	java/lang/Exception
    //   301	306	311	java/lang/Exception
    //   308	311	311	java/lang/Exception
    //   352	361	311	java/lang/Exception
    //   426	435	497	java/lang/Exception
    //   479	484	544	java/lang/Exception
    //   536	541	544	java/lang/Exception
    //   426	435	590	finally
    //   414	426	604	java/lang/Exception
    //   594	599	604	java/lang/Exception
    //   601	604	604	java/lang/Exception
    //   439	465	609	finally
    //   501	531	609	finally
    //   439	465	616	java/lang/Exception
  }
  
  private static int d()
  {
    return new File("/sys/devices/system/cpu/").listFiles(jdField_a_of_type_JavaIoFileFilter).length;
  }
  
  /* Error */
  private static int e()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: iconst_m1
    //   4: istore_1
    //   5: new 222	java/io/BufferedReader
    //   8: dup
    //   9: new 294	java/io/FileReader
    //   12: dup
    //   13: ldc_w 296
    //   16: invokespecial 297	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   19: invokespecial 230	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   22: astore 4
    //   24: iload_1
    //   25: istore_0
    //   26: aload 4
    //   28: ifnull +140 -> 168
    //   31: aload 4
    //   33: astore_2
    //   34: aload 4
    //   36: invokevirtual 233	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   39: astore_3
    //   40: aload_3
    //   41: ifnull +291 -> 332
    //   44: aload 4
    //   46: astore_2
    //   47: ldc 75
    //   49: iconst_1
    //   50: new 77	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   57: ldc_w 299
    //   60: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_3
    //   64: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokestatic 108	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   73: aload 4
    //   75: astore_2
    //   76: aload 4
    //   78: invokevirtual 233	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   81: astore 6
    //   83: aload_3
    //   84: astore 5
    //   86: aload 6
    //   88: astore_3
    //   89: goto -49 -> 40
    //   92: iload_0
    //   93: iconst_m1
    //   94: if_icmpeq +104 -> 198
    //   97: aload 4
    //   99: astore_2
    //   100: aload 5
    //   102: iconst_0
    //   103: iload_0
    //   104: invokevirtual 302	java/lang/String:substring	(II)Ljava/lang/String;
    //   107: astore_3
    //   108: aload_3
    //   109: ifnull +218 -> 327
    //   112: aload 4
    //   114: astore_2
    //   115: aload_3
    //   116: invokevirtual 149	java/lang/String:length	()I
    //   119: ifle +208 -> 327
    //   122: aload 4
    //   124: astore_2
    //   125: aload_3
    //   126: invokestatic 164	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   129: sipush 1000
    //   132: idiv
    //   133: istore_0
    //   134: aload 4
    //   136: astore_2
    //   137: ldc 75
    //   139: iconst_1
    //   140: new 77	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   147: ldc_w 304
    //   150: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: iload_0
    //   154: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   157: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokestatic 108	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   163: iload_0
    //   164: iconst_m1
    //   165: if_icmple +162 -> 327
    //   168: iload_0
    //   169: istore_1
    //   170: aload 4
    //   172: ifnull +10 -> 182
    //   175: aload 4
    //   177: invokevirtual 234	java/io/BufferedReader:close	()V
    //   180: iload_0
    //   181: istore_1
    //   182: iload_1
    //   183: ireturn
    //   184: aload 4
    //   186: astore_2
    //   187: aload 5
    //   189: bipush 9
    //   191: invokevirtual 308	java/lang/String:indexOf	(I)I
    //   194: istore_0
    //   195: goto -103 -> 92
    //   198: aload 4
    //   200: astore_2
    //   201: ldc 75
    //   203: iconst_1
    //   204: new 77	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   211: ldc_w 310
    //   214: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: iload_0
    //   218: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   221: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokestatic 108	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   227: iload_1
    //   228: istore_0
    //   229: goto -61 -> 168
    //   232: astore_2
    //   233: aload 4
    //   235: astore_3
    //   236: aload_2
    //   237: astore 4
    //   239: aload_3
    //   240: astore_2
    //   241: ldc 75
    //   243: iconst_1
    //   244: new 77	java/lang/StringBuilder
    //   247: dup
    //   248: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   251: ldc_w 312
    //   254: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: aload 4
    //   259: invokevirtual 267	java/lang/Exception:toString	()Ljava/lang/String;
    //   262: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: invokestatic 108	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   271: aload_3
    //   272: ifnull -90 -> 182
    //   275: aload_3
    //   276: invokevirtual 234	java/io/BufferedReader:close	()V
    //   279: iconst_m1
    //   280: ireturn
    //   281: astore_2
    //   282: aload_2
    //   283: invokevirtual 315	java/io/IOException:printStackTrace	()V
    //   286: iconst_m1
    //   287: ireturn
    //   288: astore_2
    //   289: aload_2
    //   290: invokevirtual 315	java/io/IOException:printStackTrace	()V
    //   293: iload_0
    //   294: ireturn
    //   295: astore_3
    //   296: aconst_null
    //   297: astore_2
    //   298: aload_2
    //   299: ifnull +7 -> 306
    //   302: aload_2
    //   303: invokevirtual 234	java/io/BufferedReader:close	()V
    //   306: aload_3
    //   307: athrow
    //   308: astore_2
    //   309: aload_2
    //   310: invokevirtual 315	java/io/IOException:printStackTrace	()V
    //   313: goto -7 -> 306
    //   316: astore_3
    //   317: goto -19 -> 298
    //   320: astore 4
    //   322: aconst_null
    //   323: astore_3
    //   324: goto -85 -> 239
    //   327: iconst_m1
    //   328: istore_0
    //   329: goto -161 -> 168
    //   332: aload 5
    //   334: ifnonnull -150 -> 184
    //   337: iconst_m1
    //   338: istore_0
    //   339: goto -247 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   25	314	0	i	int
    //   4	224	1	j	int
    //   33	168	2	localObject1	Object
    //   232	5	2	localException1	java.lang.Exception
    //   240	1	2	localObject2	Object
    //   281	2	2	localIOException1	IOException
    //   288	2	2	localIOException2	IOException
    //   297	6	2	localObject3	Object
    //   308	2	2	localIOException3	IOException
    //   39	237	3	localObject4	Object
    //   295	12	3	localObject5	Object
    //   316	1	3	localObject6	Object
    //   323	1	3	localObject7	Object
    //   22	236	4	localObject8	Object
    //   320	1	4	localException2	java.lang.Exception
    //   1	332	5	localObject9	Object
    //   81	6	6	str	String
    // Exception table:
    //   from	to	target	type
    //   34	40	232	java/lang/Exception
    //   47	73	232	java/lang/Exception
    //   76	83	232	java/lang/Exception
    //   100	108	232	java/lang/Exception
    //   115	122	232	java/lang/Exception
    //   125	134	232	java/lang/Exception
    //   137	163	232	java/lang/Exception
    //   187	195	232	java/lang/Exception
    //   201	227	232	java/lang/Exception
    //   275	279	281	java/io/IOException
    //   175	180	288	java/io/IOException
    //   5	24	295	finally
    //   302	306	308	java/io/IOException
    //   34	40	316	finally
    //   47	73	316	finally
    //   76	83	316	finally
    //   100	108	316	finally
    //   115	122	316	finally
    //   125	134	316	finally
    //   137	163	316	finally
    //   187	195	316	finally
    //   201	227	316	finally
    //   241	271	316	finally
    //   5	24	320	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARDeviceInfo
 * JD-Core Version:    0.7.0.1
 */