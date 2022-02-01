package com.tencent.mobileqq.ar.arengine;

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
  private static int a = -1;
  private static int b = -1;
  private static long c = -1L;
  private static int d = -1;
  private static final FileFilter e = new ARDeviceInfo.1();
  
  public static int a()
  {
    int i = d;
    if (i != -1) {
      return i;
    }
    a = b();
    b = c();
    c = a(BaseApplicationImpl.getApplication().getApplicationContext());
    i = a;
    if ((i < 8) && ((i < 4) || (b <= 2355.1999999999998D) || (c <= 2048L)))
    {
      if ((a > 2) && (b >= 1331.2D) && (c > 1024L)) {
        d = 1;
      } else {
        d = 2;
      }
    }
    else
    {
      d = 0;
      if ((Build.MODEL.equalsIgnoreCase("MI NOTE LTE")) || (Build.MODEL.equalsIgnoreCase("vivo Y37A")) || (Build.MODEL.equalsIgnoreCase("Nexus 6")) || (Build.MODEL.equalsIgnoreCase("ATH-AL00"))) {
        d = 1;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getDeviceCapability. Build.MODEL = ");
    localStringBuilder.append(Build.MODEL);
    localStringBuilder.append(", deviceCapability = ");
    localStringBuilder.append(d);
    localStringBuilder.append(", numberOfCPUCores = ");
    localStringBuilder.append(a);
    localStringBuilder.append(", cpuMaxFreqMHz = ");
    localStringBuilder.append(b);
    localStringBuilder.append(", totalMemoryMB = ");
    localStringBuilder.append(c);
    QLog.i("AREngine_ARDeviceInfo", 1, localStringBuilder.toString());
    return d;
  }
  
  static int a(String paramString)
  {
    if ((paramString != null) && (paramString.matches("0-[\\d]+$"))) {
      return Integer.valueOf(paramString.substring(2)).intValue() + 1;
    }
    return -1;
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
  
  /* Error */
  @android.annotation.TargetApi(16)
  public static long a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: getstatic 52	com/tencent/mobileqq/ar/arengine/ARDeviceInfo:c	J
    //   3: lstore_2
    //   4: ldc2_w 11
    //   7: lstore 4
    //   9: lload_2
    //   10: ldc2_w 11
    //   13: lcmp
    //   14: ifeq +5 -> 19
    //   17: lload_2
    //   18: lreturn
    //   19: getstatic 175	android/os/Build$VERSION:SDK_INT	I
    //   22: bipush 16
    //   24: if_icmplt +42 -> 66
    //   27: new 177	android/app/ActivityManager$MemoryInfo
    //   30: dup
    //   31: invokespecial 178	android/app/ActivityManager$MemoryInfo:<init>	()V
    //   34: astore 6
    //   36: aload_0
    //   37: ldc 180
    //   39: invokevirtual 186	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   42: checkcast 188	android/app/ActivityManager
    //   45: aload 6
    //   47: invokevirtual 192	android/app/ActivityManager:getMemoryInfo	(Landroid/app/ActivityManager$MemoryInfo;)V
    //   50: aload 6
    //   52: getfield 195	android/app/ActivityManager$MemoryInfo:totalMem	J
    //   55: ldc2_w 196
    //   58: ldiv
    //   59: putstatic 52	com/tencent/mobileqq/ar/arengine/ARDeviceInfo:c	J
    //   62: getstatic 52	com/tencent/mobileqq/ar/arengine/ARDeviceInfo:c	J
    //   65: lreturn
    //   66: lload 4
    //   68: lstore_2
    //   69: new 141	java/io/FileInputStream
    //   72: dup
    //   73: ldc 199
    //   75: invokespecial 202	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   78: astore_0
    //   79: ldc 204
    //   81: aload_0
    //   82: invokestatic 206	com/tencent/mobileqq/ar/arengine/ARDeviceInfo:a	(Ljava/lang/String;Ljava/io/FileInputStream;)I
    //   85: istore_1
    //   86: iload_1
    //   87: i2l
    //   88: lstore 4
    //   90: lload 4
    //   92: lstore_2
    //   93: aload_0
    //   94: invokevirtual 209	java/io/FileInputStream:close	()V
    //   97: lload 4
    //   99: lstore_2
    //   100: goto +18 -> 118
    //   103: astore 6
    //   105: lload 4
    //   107: lstore_2
    //   108: aload_0
    //   109: invokevirtual 209	java/io/FileInputStream:close	()V
    //   112: lload 4
    //   114: lstore_2
    //   115: aload 6
    //   117: athrow
    //   118: lload_2
    //   119: ldc2_w 59
    //   122: ldiv
    //   123: putstatic 52	com/tencent/mobileqq/ar/arengine/ARDeviceInfo:c	J
    //   126: getstatic 52	com/tencent/mobileqq/ar/arengine/ARDeviceInfo:c	J
    //   129: lreturn
    //   130: astore_0
    //   131: goto -13 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	paramContext	android.content.Context
    //   85	2	1	i	int
    //   3	116	2	l1	long
    //   7	106	4	l2	long
    //   34	17	6	localMemoryInfo	android.app.ActivityManager.MemoryInfo
    //   103	13	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   79	86	103	finally
    //   69	79	130	java/io/IOException
    //   93	97	130	java/io/IOException
    //   108	112	130	java/io/IOException
    //   115	118	130	java/io/IOException
  }
  
  public static int b()
  {
    int i = a;
    k = -1;
    if (i != -1) {
      return i;
    }
    if (Build.VERSION.SDK_INT <= 10)
    {
      a = 1;
      return a;
    }
    try
    {
      j = b("/sys/devices/system/cpu/possible");
      i = j;
      if (j == -1) {
        i = b("/sys/devices/system/cpu/present");
      }
      j = i;
      if (i == -1) {
        j = d();
      }
    }
    catch (SecurityException|NullPointerException localSecurityException)
    {
      for (;;)
      {
        int j = k;
      }
    }
    a = j;
    return j;
  }
  
  /* Error */
  private static int b(String paramString)
  {
    // Byte code:
    //   0: new 141	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 202	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: new 224	java/io/BufferedReader
    //   12: dup
    //   13: new 226	java/io/InputStreamReader
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 229	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   21: invokespecial 232	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   24: astore_2
    //   25: aload_2
    //   26: invokevirtual 235	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   29: astore_3
    //   30: aload_2
    //   31: invokevirtual 236	java/io/BufferedReader:close	()V
    //   34: aload_3
    //   35: invokestatic 238	com/tencent/mobileqq/ar/arengine/ARDeviceInfo:a	(Ljava/lang/String;)I
    //   38: istore_1
    //   39: aload_0
    //   40: invokevirtual 241	java/io/InputStream:close	()V
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
    //   64: invokevirtual 241	java/io/InputStream:close	()V
    //   67: aload_0
    //   68: athrow
    //   69: aconst_null
    //   70: astore_0
    //   71: aload_0
    //   72: ifnull +7 -> 79
    //   75: aload_0
    //   76: invokevirtual 241	java/io/InputStream:close	()V
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
  
  /* Error */
  public static int c()
  {
    // Byte code:
    //   0: getstatic 37	com/tencent/mobileqq/ar/arengine/ARDeviceInfo:b	I
    //   3: istore_0
    //   4: iload_0
    //   5: iconst_m1
    //   6: if_icmpeq +5 -> 11
    //   9: iload_0
    //   10: ireturn
    //   11: getstatic 66	android/os/Build:MODEL	Ljava/lang/String;
    //   14: ldc 245
    //   16: invokevirtual 74	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   19: ifeq +13 -> 32
    //   22: sipush 1824
    //   25: putstatic 37	com/tencent/mobileqq/ar/arengine/ARDeviceInfo:b	I
    //   28: getstatic 37	com/tencent/mobileqq/ar/arengine/ARDeviceInfo:b	I
    //   31: ireturn
    //   32: iconst_0
    //   33: istore 4
    //   35: iconst_0
    //   36: istore_2
    //   37: iconst_m1
    //   38: istore_0
    //   39: invokestatic 31	com/tencent/mobileqq/ar/arengine/ARDeviceInfo:b	()I
    //   42: istore_1
    //   43: iconst_1
    //   44: istore 5
    //   46: iload 4
    //   48: iload_1
    //   49: if_icmpge +382 -> 431
    //   52: new 82	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   59: astore 6
    //   61: aload 6
    //   63: ldc 247
    //   65: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload 6
    //   71: iload 4
    //   73: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload 6
    //   79: ldc 249
    //   81: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload 6
    //   87: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: astore 6
    //   92: new 82	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   99: astore 7
    //   101: aload 7
    //   103: ldc 251
    //   105: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: aload 7
    //   111: aload 6
    //   113: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: ldc 105
    //   119: iconst_1
    //   120: aload 7
    //   122: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokestatic 115	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   128: iload_0
    //   129: istore_3
    //   130: new 253	java/io/File
    //   133: dup
    //   134: aload 6
    //   136: invokespecial 254	java/io/File:<init>	(Ljava/lang/String;)V
    //   139: astore 6
    //   141: iload_0
    //   142: istore_3
    //   143: aload 6
    //   145: invokevirtual 258	java/io/File:exists	()Z
    //   148: ifeq +209 -> 357
    //   151: iload_0
    //   152: istore_3
    //   153: sipush 128
    //   156: newarray byte
    //   158: astore 7
    //   160: iload_0
    //   161: istore_3
    //   162: new 141	java/io/FileInputStream
    //   165: dup
    //   166: aload 6
    //   168: invokespecial 261	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   171: astore 6
    //   173: aload 6
    //   175: aload 7
    //   177: invokevirtual 145	java/io/FileInputStream:read	([B)I
    //   180: pop
    //   181: iconst_0
    //   182: istore_1
    //   183: aload 7
    //   185: iload_1
    //   186: baload
    //   187: invokestatic 161	java/lang/Character:isDigit	(I)Z
    //   190: ifeq +17 -> 207
    //   193: iload_1
    //   194: aload 7
    //   196: arraylength
    //   197: if_icmpge +10 -> 207
    //   200: iload_1
    //   201: iconst_1
    //   202: iadd
    //   203: istore_1
    //   204: goto -21 -> 183
    //   207: new 70	java/lang/String
    //   210: dup
    //   211: aload 7
    //   213: iconst_0
    //   214: iload_1
    //   215: invokespecial 264	java/lang/String:<init>	([BII)V
    //   218: invokestatic 167	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   221: sipush 1000
    //   224: idiv
    //   225: istore_3
    //   226: new 82	java/lang/StringBuilder
    //   229: dup
    //   230: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   233: astore 7
    //   235: aload 7
    //   237: ldc_w 266
    //   240: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: aload 7
    //   246: iload_3
    //   247: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: ldc 105
    //   253: iconst_1
    //   254: aload 7
    //   256: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokestatic 115	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   262: iload_0
    //   263: istore_1
    //   264: iload_3
    //   265: iload_0
    //   266: if_icmple +5 -> 271
    //   269: iload_3
    //   270: istore_1
    //   271: iload_1
    //   272: istore_3
    //   273: aload 6
    //   275: invokevirtual 209	java/io/FileInputStream:close	()V
    //   278: iload_1
    //   279: istore_0
    //   280: iload_2
    //   281: istore_1
    //   282: goto +89 -> 371
    //   285: astore 7
    //   287: goto +58 -> 345
    //   290: astore 7
    //   292: new 82	java/lang/StringBuilder
    //   295: dup
    //   296: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   299: astore 8
    //   301: aload 8
    //   303: ldc_w 268
    //   306: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: pop
    //   310: aload 8
    //   312: aload 7
    //   314: invokevirtual 269	java/lang/Exception:toString	()Ljava/lang/String;
    //   317: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: ldc 105
    //   323: iconst_1
    //   324: aload 8
    //   326: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   329: invokestatic 115	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   332: iload_0
    //   333: istore_3
    //   334: aload 6
    //   336: invokevirtual 209	java/io/FileInputStream:close	()V
    //   339: iload 5
    //   341: istore_1
    //   342: goto +29 -> 371
    //   345: iload_0
    //   346: istore_3
    //   347: aload 6
    //   349: invokevirtual 209	java/io/FileInputStream:close	()V
    //   352: iload_0
    //   353: istore_3
    //   354: aload 7
    //   356: athrow
    //   357: iload_0
    //   358: istore_3
    //   359: ldc 105
    //   361: iconst_1
    //   362: ldc_w 271
    //   365: invokestatic 115	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   368: iload 5
    //   370: istore_1
    //   371: iload_1
    //   372: istore_2
    //   373: goto +49 -> 422
    //   376: astore 6
    //   378: new 82	java/lang/StringBuilder
    //   381: dup
    //   382: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   385: astore 7
    //   387: aload 7
    //   389: ldc_w 273
    //   392: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: pop
    //   396: aload 7
    //   398: aload 6
    //   400: invokevirtual 269	java/lang/Exception:toString	()Ljava/lang/String;
    //   403: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: pop
    //   407: ldc 105
    //   409: iconst_1
    //   410: aload 7
    //   412: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   415: invokestatic 115	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   418: iconst_1
    //   419: istore_2
    //   420: iload_3
    //   421: istore_0
    //   422: iload 4
    //   424: iconst_1
    //   425: iadd
    //   426: istore 4
    //   428: goto -389 -> 39
    //   431: iload_0
    //   432: istore_1
    //   433: iload_2
    //   434: ifeq +297 -> 731
    //   437: invokestatic 275	com/tencent/mobileqq/ar/arengine/ARDeviceInfo:e	()I
    //   440: istore_2
    //   441: new 82	java/lang/StringBuilder
    //   444: dup
    //   445: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   448: astore 6
    //   450: aload 6
    //   452: ldc_w 277
    //   455: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: pop
    //   459: aload 6
    //   461: iload_2
    //   462: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   465: pop
    //   466: ldc 105
    //   468: iconst_1
    //   469: aload 6
    //   471: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   474: invokestatic 115	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   477: iload_2
    //   478: istore_1
    //   479: iload_0
    //   480: istore_3
    //   481: iload_2
    //   482: iconst_m1
    //   483: if_icmpne +238 -> 721
    //   486: iload_2
    //   487: istore_1
    //   488: iload_0
    //   489: istore 4
    //   491: new 141	java/io/FileInputStream
    //   494: dup
    //   495: ldc_w 279
    //   498: invokespecial 202	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   501: astore 6
    //   503: iload_2
    //   504: istore_3
    //   505: ldc_w 281
    //   508: aload 6
    //   510: invokestatic 206	com/tencent/mobileqq/ar/arengine/ARDeviceInfo:a	(Ljava/lang/String;Ljava/io/FileInputStream;)I
    //   513: istore_1
    //   514: iload_1
    //   515: istore_3
    //   516: iload_1
    //   517: istore_2
    //   518: new 82	java/lang/StringBuilder
    //   521: dup
    //   522: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   525: astore 7
    //   527: iload_1
    //   528: istore_3
    //   529: iload_1
    //   530: istore_2
    //   531: aload 7
    //   533: ldc_w 283
    //   536: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: pop
    //   540: iload_1
    //   541: istore_3
    //   542: iload_1
    //   543: istore_2
    //   544: aload 7
    //   546: iload_1
    //   547: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   550: pop
    //   551: iload_1
    //   552: istore_3
    //   553: iload_1
    //   554: istore_2
    //   555: ldc 105
    //   557: iconst_1
    //   558: aload 7
    //   560: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   563: invokestatic 115	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   566: iload_1
    //   567: istore_3
    //   568: iload_0
    //   569: istore_2
    //   570: iload_1
    //   571: iload_0
    //   572: if_icmple +7 -> 579
    //   575: iload_1
    //   576: istore_2
    //   577: iload_1
    //   578: istore_3
    //   579: iload_3
    //   580: istore_1
    //   581: iload_2
    //   582: istore 4
    //   584: aload 6
    //   586: invokevirtual 209	java/io/FileInputStream:close	()V
    //   589: iload_3
    //   590: istore_1
    //   591: iload_2
    //   592: istore_3
    //   593: goto +128 -> 721
    //   596: astore 7
    //   598: goto +60 -> 658
    //   601: astore 7
    //   603: iload_2
    //   604: istore_3
    //   605: new 82	java/lang/StringBuilder
    //   608: dup
    //   609: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   612: astore 8
    //   614: iload_2
    //   615: istore_3
    //   616: aload 8
    //   618: ldc_w 285
    //   621: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: pop
    //   625: iload_2
    //   626: istore_3
    //   627: aload 8
    //   629: aload 7
    //   631: invokevirtual 269	java/lang/Exception:toString	()Ljava/lang/String;
    //   634: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   637: pop
    //   638: iload_2
    //   639: istore_3
    //   640: ldc 105
    //   642: iconst_1
    //   643: aload 8
    //   645: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   648: invokestatic 115	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   651: iload_2
    //   652: istore_3
    //   653: iload_0
    //   654: istore_2
    //   655: goto -76 -> 579
    //   658: iload_3
    //   659: istore_1
    //   660: iload_0
    //   661: istore 4
    //   663: aload 6
    //   665: invokevirtual 209	java/io/FileInputStream:close	()V
    //   668: iload_3
    //   669: istore_1
    //   670: iload_0
    //   671: istore 4
    //   673: aload 7
    //   675: athrow
    //   676: astore 6
    //   678: new 82	java/lang/StringBuilder
    //   681: dup
    //   682: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   685: astore 7
    //   687: aload 7
    //   689: ldc_w 287
    //   692: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   695: pop
    //   696: aload 7
    //   698: aload 6
    //   700: invokevirtual 269	java/lang/Exception:toString	()Ljava/lang/String;
    //   703: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   706: pop
    //   707: ldc 105
    //   709: iconst_1
    //   710: aload 7
    //   712: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   715: invokestatic 115	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   718: iload 4
    //   720: istore_3
    //   721: iload_1
    //   722: iload_3
    //   723: if_icmple +6 -> 729
    //   726: goto +5 -> 731
    //   729: iload_3
    //   730: istore_1
    //   731: iload_1
    //   732: putstatic 37	com/tencent/mobileqq/ar/arengine/ARDeviceInfo:b	I
    //   735: iload_1
    //   736: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   3	668	0	i	int
    //   42	694	1	j	int
    //   36	619	2	k	int
    //   129	601	3	m	int
    //   33	686	4	n	int
    //   44	325	5	i1	int
    //   59	289	6	localObject1	Object
    //   376	23	6	localException1	java.lang.Exception
    //   448	216	6	localObject2	Object
    //   676	23	6	localException2	java.lang.Exception
    //   99	156	7	localObject3	Object
    //   285	1	7	localObject4	Object
    //   290	65	7	localException3	java.lang.Exception
    //   385	174	7	localStringBuilder1	StringBuilder
    //   596	1	7	localObject5	Object
    //   601	73	7	localException4	java.lang.Exception
    //   685	26	7	localStringBuilder2	StringBuilder
    //   299	345	8	localStringBuilder3	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   173	181	285	finally
    //   183	200	285	finally
    //   207	262	285	finally
    //   292	332	285	finally
    //   173	181	290	java/lang/Exception
    //   183	200	290	java/lang/Exception
    //   207	262	290	java/lang/Exception
    //   130	141	376	java/lang/Exception
    //   143	151	376	java/lang/Exception
    //   153	160	376	java/lang/Exception
    //   162	173	376	java/lang/Exception
    //   273	278	376	java/lang/Exception
    //   334	339	376	java/lang/Exception
    //   347	352	376	java/lang/Exception
    //   354	357	376	java/lang/Exception
    //   359	368	376	java/lang/Exception
    //   505	514	596	finally
    //   518	527	596	finally
    //   531	540	596	finally
    //   544	551	596	finally
    //   555	566	596	finally
    //   605	614	596	finally
    //   616	625	596	finally
    //   627	638	596	finally
    //   640	651	596	finally
    //   505	514	601	java/lang/Exception
    //   518	527	601	java/lang/Exception
    //   531	540	601	java/lang/Exception
    //   544	551	601	java/lang/Exception
    //   555	566	601	java/lang/Exception
    //   491	503	676	java/lang/Exception
    //   584	589	676	java/lang/Exception
    //   663	668	676	java/lang/Exception
    //   673	676	676	java/lang/Exception
  }
  
  private static int d()
  {
    return new File("/sys/devices/system/cpu/").listFiles(e).length;
  }
  
  /* Error */
  private static int e()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: iconst_m1
    //   4: istore_1
    //   5: new 224	java/io/BufferedReader
    //   8: dup
    //   9: new 295	java/io/FileReader
    //   12: dup
    //   13: ldc_w 297
    //   16: invokespecial 298	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   19: invokespecial 232	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   22: astore 5
    //   24: aload 5
    //   26: astore_3
    //   27: aload 5
    //   29: invokevirtual 235	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   32: astore 6
    //   34: aload 6
    //   36: astore_3
    //   37: aload 4
    //   39: astore 6
    //   41: aload_3
    //   42: astore 4
    //   44: aload 4
    //   46: ifnull +376 -> 422
    //   49: aload 5
    //   51: astore_3
    //   52: new 82	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   59: astore 6
    //   61: aload 5
    //   63: astore_3
    //   64: aload 6
    //   66: ldc_w 300
    //   69: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload 5
    //   75: astore_3
    //   76: aload 6
    //   78: aload 4
    //   80: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload 5
    //   86: astore_3
    //   87: ldc 105
    //   89: iconst_1
    //   90: aload 6
    //   92: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 115	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   98: aload 5
    //   100: astore_3
    //   101: aload 5
    //   103: invokevirtual 235	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   106: astore 6
    //   108: aload 6
    //   110: astore_3
    //   111: goto -74 -> 37
    //   114: aload 5
    //   116: astore_3
    //   117: aload 6
    //   119: bipush 9
    //   121: invokevirtual 304	java/lang/String:indexOf	(I)I
    //   124: istore_0
    //   125: iload_0
    //   126: iconst_m1
    //   127: if_icmpeq +108 -> 235
    //   130: aload 5
    //   132: astore_3
    //   133: aload 6
    //   135: iconst_0
    //   136: iload_0
    //   137: invokevirtual 307	java/lang/String:substring	(II)Ljava/lang/String;
    //   140: astore 4
    //   142: iload_1
    //   143: istore_0
    //   144: aload 4
    //   146: ifnull +139 -> 285
    //   149: iload_1
    //   150: istore_0
    //   151: aload 5
    //   153: astore_3
    //   154: aload 4
    //   156: invokevirtual 152	java/lang/String:length	()I
    //   159: ifle +126 -> 285
    //   162: aload 5
    //   164: astore_3
    //   165: aload 4
    //   167: invokestatic 167	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   170: sipush 1000
    //   173: idiv
    //   174: istore_2
    //   175: aload 5
    //   177: astore_3
    //   178: new 82	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   185: astore 4
    //   187: aload 5
    //   189: astore_3
    //   190: aload 4
    //   192: ldc_w 309
    //   195: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: aload 5
    //   201: astore_3
    //   202: aload 4
    //   204: iload_2
    //   205: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload 5
    //   211: astore_3
    //   212: ldc 105
    //   214: iconst_1
    //   215: aload 4
    //   217: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 115	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   223: iload_1
    //   224: istore_0
    //   225: iload_2
    //   226: iconst_m1
    //   227: if_icmple +58 -> 285
    //   230: iload_2
    //   231: istore_0
    //   232: goto +53 -> 285
    //   235: aload 5
    //   237: astore_3
    //   238: new 82	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   245: astore 4
    //   247: aload 5
    //   249: astore_3
    //   250: aload 4
    //   252: ldc_w 311
    //   255: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: pop
    //   259: aload 5
    //   261: astore_3
    //   262: aload 4
    //   264: iload_0
    //   265: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload 5
    //   271: astore_3
    //   272: ldc 105
    //   274: iconst_1
    //   275: aload 4
    //   277: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: invokestatic 115	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   283: iload_1
    //   284: istore_0
    //   285: iload_0
    //   286: istore_1
    //   287: aload 5
    //   289: invokevirtual 236	java/io/BufferedReader:close	()V
    //   292: iload_0
    //   293: ireturn
    //   294: astore_3
    //   295: aload_3
    //   296: invokevirtual 314	java/io/IOException:printStackTrace	()V
    //   299: iload_1
    //   300: ireturn
    //   301: astore 6
    //   303: aload 5
    //   305: astore 4
    //   307: goto +15 -> 322
    //   310: astore_3
    //   311: aconst_null
    //   312: astore 4
    //   314: goto +80 -> 394
    //   317: astore 6
    //   319: aconst_null
    //   320: astore 4
    //   322: aload 4
    //   324: astore_3
    //   325: new 82	java/lang/StringBuilder
    //   328: dup
    //   329: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   332: astore 5
    //   334: aload 4
    //   336: astore_3
    //   337: aload 5
    //   339: ldc_w 316
    //   342: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: pop
    //   346: aload 4
    //   348: astore_3
    //   349: aload 5
    //   351: aload 6
    //   353: invokevirtual 269	java/lang/Exception:toString	()Ljava/lang/String;
    //   356: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: pop
    //   360: aload 4
    //   362: astore_3
    //   363: ldc 105
    //   365: iconst_1
    //   366: aload 5
    //   368: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   371: invokestatic 115	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   374: aload 4
    //   376: ifnull +8 -> 384
    //   379: aload 4
    //   381: invokevirtual 236	java/io/BufferedReader:close	()V
    //   384: iconst_m1
    //   385: ireturn
    //   386: astore 5
    //   388: aload_3
    //   389: astore 4
    //   391: aload 5
    //   393: astore_3
    //   394: aload 4
    //   396: ifnull +18 -> 414
    //   399: aload 4
    //   401: invokevirtual 236	java/io/BufferedReader:close	()V
    //   404: goto +10 -> 414
    //   407: astore 4
    //   409: aload 4
    //   411: invokevirtual 314	java/io/IOException:printStackTrace	()V
    //   414: goto +5 -> 419
    //   417: aload_3
    //   418: athrow
    //   419: goto -2 -> 417
    //   422: aload 6
    //   424: ifnonnull -310 -> 114
    //   427: iconst_m1
    //   428: istore_0
    //   429: goto -304 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   124	305	0	i	int
    //   4	296	1	j	int
    //   174	57	2	k	int
    //   26	246	3	localObject1	Object
    //   294	2	3	localIOException1	IOException
    //   310	1	3	localObject2	Object
    //   324	94	3	localObject3	Object
    //   1	399	4	localObject4	Object
    //   407	3	4	localIOException2	IOException
    //   22	345	5	localObject5	Object
    //   386	6	5	localObject6	Object
    //   32	102	6	localObject7	Object
    //   301	1	6	localException1	java.lang.Exception
    //   317	106	6	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   287	292	294	java/io/IOException
    //   379	384	294	java/io/IOException
    //   27	34	301	java/lang/Exception
    //   52	61	301	java/lang/Exception
    //   64	73	301	java/lang/Exception
    //   76	84	301	java/lang/Exception
    //   87	98	301	java/lang/Exception
    //   101	108	301	java/lang/Exception
    //   117	125	301	java/lang/Exception
    //   133	142	301	java/lang/Exception
    //   154	162	301	java/lang/Exception
    //   165	175	301	java/lang/Exception
    //   178	187	301	java/lang/Exception
    //   190	199	301	java/lang/Exception
    //   202	209	301	java/lang/Exception
    //   212	223	301	java/lang/Exception
    //   238	247	301	java/lang/Exception
    //   250	259	301	java/lang/Exception
    //   262	269	301	java/lang/Exception
    //   272	283	301	java/lang/Exception
    //   5	24	310	finally
    //   5	24	317	java/lang/Exception
    //   27	34	386	finally
    //   52	61	386	finally
    //   64	73	386	finally
    //   76	84	386	finally
    //   87	98	386	finally
    //   101	108	386	finally
    //   117	125	386	finally
    //   133	142	386	finally
    //   154	162	386	finally
    //   165	175	386	finally
    //   178	187	386	finally
    //   190	199	386	finally
    //   202	209	386	finally
    //   212	223	386	finally
    //   238	247	386	finally
    //   250	259	386	finally
    //   262	269	386	finally
    //   272	283	386	finally
    //   325	334	386	finally
    //   337	346	386	finally
    //   349	360	386	finally
    //   363	374	386	finally
    //   399	404	407	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARDeviceInfo
 * JD-Core Version:    0.7.0.1
 */