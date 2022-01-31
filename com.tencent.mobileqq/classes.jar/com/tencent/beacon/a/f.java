package com.tencent.beacon.a;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.beacon.a.a.e;
import com.tencent.beacon.event.k;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.Key;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.http.util.EncodingUtils;

public final class f
{
  private static f a;
  
  public static int a(Context paramContext, com.tencent.beacon.a.a.f[] paramArrayOff)
  {
    int j = 0;
    int i;
    if ((paramContext == null) || (paramArrayOff == null) || (paramArrayOff.length <= 0)) {
      i = -1;
    }
    ArrayList localArrayList;
    do
    {
      return i;
      localArrayList = new ArrayList(paramArrayOff.length);
      int k = paramArrayOff.length;
      i = 0;
      while (i < k)
      {
        com.tencent.beacon.a.a.f localf = paramArrayOff[i];
        Object localObject = a(localf);
        if (localObject != null)
        {
          localObject = new com.tencent.beacon.a.a.a(6, 0, 0L, (byte[])localObject);
          ((com.tencent.beacon.a.a.a)localObject).a(localf.a());
          localArrayList.add(localObject);
        }
        i += 1;
      }
      i = j;
    } while (localArrayList.size() <= 0);
    if (com.tencent.beacon.a.a.a.b(paramContext, localArrayList)) {
      return localArrayList.size();
    }
    return -1;
  }
  
  public static int a(Context paramContext, Long[] paramArrayOfLong)
  {
    com.tencent.beacon.d.a.a(" RecordDAO.deleteRecordList() start", new Object[0]);
    if (paramContext == null)
    {
      com.tencent.beacon.d.a.d(" deleteRecordList() have null args!", new Object[0]);
      return -1;
    }
    com.tencent.beacon.d.a.a(" RecordDAO.deleteRecordList() end", new Object[0]);
    return com.tencent.beacon.a.a.a.a(paramContext, paramArrayOfLong);
  }
  
  public static int a(String paramString1, Object paramObject, String paramString2)
  {
    try
    {
      Field localField = Class.forName(paramString1).getDeclaredField(paramString2);
      localField.setAccessible(true);
      int i = localField.getInt(paramObject);
      return i;
    }
    catch (Exception paramObject)
    {
      com.tencent.beacon.d.a.a("ref get %s.%s failed.", new Object[] { paramString1, paramString2 });
    }
    return -1;
  }
  
  public static f a(Context paramContext)
  {
    try
    {
      if ((a == null) && (paramContext != null)) {
        a = new f();
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  /* Error */
  public static com.tencent.beacon.b.a.b a(int paramInt1, d paramd, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: ldc 96
    //   2: iconst_0
    //   3: anewarray 4	java/lang/Object
    //   6: invokestatic 98	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   9: aload_1
    //   10: ifnonnull +14 -> 24
    //   13: ldc 100
    //   15: iconst_0
    //   16: anewarray 4	java/lang/Object
    //   19: invokestatic 58	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   22: aconst_null
    //   23: areturn
    //   24: new 102	com/tencent/beacon/b/a/b
    //   27: dup
    //   28: invokespecial 103	com/tencent/beacon/b/a/b:<init>	()V
    //   31: astore 6
    //   33: aload_1
    //   34: monitorenter
    //   35: aload 6
    //   37: aload_1
    //   38: invokevirtual 108	com/tencent/beacon/a/d:a	()Ljava/lang/String;
    //   41: putfield 112	com/tencent/beacon/b/a/b:j	Ljava/lang/String;
    //   44: aload 6
    //   46: aload_1
    //   47: invokevirtual 114	com/tencent/beacon/a/d:b	()Ljava/lang/String;
    //   50: putfield 117	com/tencent/beacon/b/a/b:k	Ljava/lang/String;
    //   53: aload 6
    //   55: aload_1
    //   56: invokevirtual 121	com/tencent/beacon/a/d:c	()B
    //   59: putfield 124	com/tencent/beacon/b/a/b:a	B
    //   62: aload 6
    //   64: aload_1
    //   65: invokevirtual 126	com/tencent/beacon/a/d:j	()Ljava/lang/String;
    //   68: putfield 128	com/tencent/beacon/b/a/b:b	Ljava/lang/String;
    //   71: aload 6
    //   73: aload_1
    //   74: invokevirtual 130	com/tencent/beacon/a/d:d	()Ljava/lang/String;
    //   77: putfield 132	com/tencent/beacon/b/a/b:c	Ljava/lang/String;
    //   80: aload 6
    //   82: aload_1
    //   83: invokevirtual 135	com/tencent/beacon/a/d:e	()Ljava/lang/String;
    //   86: putfield 137	com/tencent/beacon/b/a/b:d	Ljava/lang/String;
    //   89: aload 6
    //   91: aload_1
    //   92: invokevirtual 140	com/tencent/beacon/a/d:f	()Ljava/lang/String;
    //   95: putfield 142	com/tencent/beacon/b/a/b:e	Ljava/lang/String;
    //   98: aload 6
    //   100: ldc 144
    //   102: putfield 147	com/tencent/beacon/b/a/b:l	Ljava/lang/String;
    //   105: iload_0
    //   106: bipush 100
    //   108: if_icmpne +344 -> 452
    //   111: new 149	java/util/HashMap
    //   114: dup
    //   115: invokespecial 150	java/util/HashMap:<init>	()V
    //   118: astore 7
    //   120: aload 7
    //   122: ldc 152
    //   124: new 154	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   131: invokestatic 160	com/tencent/beacon/event/UserAction:getUserID	()Ljava/lang/String;
    //   134: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokeinterface 173 3 0
    //   145: pop
    //   146: aload 7
    //   148: ldc 175
    //   150: new 154	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   157: aload_1
    //   158: invokevirtual 178	com/tencent/beacon/a/d:i	()Ljava/lang/String;
    //   161: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokeinterface 173 3 0
    //   172: pop
    //   173: aload_1
    //   174: invokevirtual 181	com/tencent/beacon/a/d:l	()Landroid/content/Context;
    //   177: invokestatic 186	com/tencent/beacon/event/d:a	(Landroid/content/Context;)Lcom/tencent/beacon/event/d;
    //   180: astore 5
    //   182: aload 7
    //   184: ldc 188
    //   186: new 154	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   193: aload 5
    //   195: invokevirtual 189	com/tencent/beacon/event/d:d	()Ljava/lang/String;
    //   198: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokeinterface 173 3 0
    //   209: pop
    //   210: aload 7
    //   212: ldc 191
    //   214: new 154	java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   221: aload 5
    //   223: invokevirtual 193	com/tencent/beacon/event/d:c	()Ljava/lang/String;
    //   226: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokeinterface 173 3 0
    //   237: pop
    //   238: aload 7
    //   240: ldc 195
    //   242: new 154	java/lang/StringBuilder
    //   245: dup
    //   246: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   249: aload 5
    //   251: invokevirtual 196	com/tencent/beacon/event/d:e	()Ljava/lang/String;
    //   254: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokeinterface 173 3 0
    //   265: pop
    //   266: aload 7
    //   268: ldc 198
    //   270: new 154	java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   277: aload_1
    //   278: invokevirtual 181	com/tencent/beacon/a/d:l	()Landroid/content/Context;
    //   281: invokestatic 203	com/tencent/beacon/a/j:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/j;
    //   284: invokevirtual 204	com/tencent/beacon/a/j:a	()Ljava/lang/String;
    //   287: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: invokeinterface 173 3 0
    //   298: pop
    //   299: aload 7
    //   301: ldc 206
    //   303: new 154	java/lang/StringBuilder
    //   306: dup
    //   307: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   310: aload_1
    //   311: invokevirtual 208	com/tencent/beacon/a/d:k	()Ljava/lang/String;
    //   314: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: invokeinterface 173 3 0
    //   325: pop
    //   326: aload_1
    //   327: invokevirtual 181	com/tencent/beacon/a/d:l	()Landroid/content/Context;
    //   330: invokestatic 210	com/tencent/beacon/a/f:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/f;
    //   333: pop
    //   334: aload 7
    //   336: ldc 212
    //   338: aload_1
    //   339: invokevirtual 181	com/tencent/beacon/a/d:l	()Landroid/content/Context;
    //   342: invokestatic 215	com/tencent/beacon/a/f:l	(Landroid/content/Context;)Ljava/lang/String;
    //   345: invokeinterface 173 3 0
    //   350: pop
    //   351: aload_1
    //   352: invokevirtual 181	com/tencent/beacon/a/d:l	()Landroid/content/Context;
    //   355: invokestatic 221	com/tencent/beacon/a/b:h	(Landroid/content/Context;)Z
    //   358: ifeq +138 -> 496
    //   361: aload 7
    //   363: ldc 223
    //   365: ldc 225
    //   367: invokeinterface 173 3 0
    //   372: pop
    //   373: aload 7
    //   375: ldc 227
    //   377: aload_1
    //   378: invokevirtual 181	com/tencent/beacon/a/d:l	()Landroid/content/Context;
    //   381: invokestatic 229	com/tencent/beacon/a/b:j	(Landroid/content/Context;)Ljava/lang/String;
    //   384: invokeinterface 173 3 0
    //   389: pop
    //   390: aload 7
    //   392: ldc 231
    //   394: new 154	java/lang/StringBuilder
    //   397: dup
    //   398: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   401: aload_1
    //   402: invokevirtual 181	com/tencent/beacon/a/d:l	()Landroid/content/Context;
    //   405: invokestatic 234	com/tencent/beacon/a/b:i	(Landroid/content/Context;)I
    //   408: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   411: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   414: invokeinterface 173 3 0
    //   419: pop
    //   420: getstatic 240	com/tencent/beacon/a/b:a	Z
    //   423: ifeq +101 -> 524
    //   426: ldc 242
    //   428: astore 5
    //   430: aload 7
    //   432: ldc 244
    //   434: aload 5
    //   436: invokeinterface 173 3 0
    //   441: pop
    //   442: aload 6
    //   444: aload 7
    //   446: invokestatic 247	com/tencent/beacon/a/f:a	(Ljava/util/Map;)Ljava/lang/String;
    //   449: putfield 147	com/tencent/beacon/b/a/b:l	Ljava/lang/String;
    //   452: aload_1
    //   453: monitorexit
    //   454: aload 6
    //   456: iload_0
    //   457: putfield 250	com/tencent/beacon/b/a/b:f	I
    //   460: aload 6
    //   462: iload 4
    //   464: i2b
    //   465: putfield 252	com/tencent/beacon/b/a/b:h	B
    //   468: aload 6
    //   470: iload_3
    //   471: i2b
    //   472: putfield 254	com/tencent/beacon/b/a/b:i	B
    //   475: aload_2
    //   476: astore_1
    //   477: aload_2
    //   478: ifnonnull +9 -> 487
    //   481: ldc 144
    //   483: invokevirtual 260	java/lang/String:getBytes	()[B
    //   486: astore_1
    //   487: aload 6
    //   489: aload_1
    //   490: putfield 264	com/tencent/beacon/b/a/b:g	[B
    //   493: aload 6
    //   495: areturn
    //   496: aload 7
    //   498: ldc 223
    //   500: ldc_w 265
    //   503: invokeinterface 173 3 0
    //   508: pop
    //   509: goto -136 -> 373
    //   512: astore_2
    //   513: aload_1
    //   514: monitorexit
    //   515: aload_2
    //   516: athrow
    //   517: astore_1
    //   518: aload_1
    //   519: invokestatic 268	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   522: aconst_null
    //   523: areturn
    //   524: ldc_w 270
    //   527: astore 5
    //   529: goto -99 -> 430
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	532	0	paramInt1	int
    //   0	532	1	paramd	d
    //   0	532	2	paramArrayOfByte	byte[]
    //   0	532	3	paramInt2	int
    //   0	532	4	paramInt3	int
    //   180	348	5	localObject	Object
    //   31	463	6	localb	com.tencent.beacon.b.a.b
    //   118	379	7	localHashMap	java.util.HashMap
    // Exception table:
    //   from	to	target	type
    //   35	105	512	finally
    //   111	373	512	finally
    //   373	426	512	finally
    //   430	452	512	finally
    //   452	454	512	finally
    //   496	509	512	finally
    //   24	35	517	java/lang/Throwable
    //   454	475	517	java/lang/Throwable
    //   481	487	517	java/lang/Throwable
    //   487	493	517	java/lang/Throwable
    //   513	517	517	java/lang/Throwable
  }
  
  public static Object a(String paramString1, String paramString2, Object paramObject, Class[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    try
    {
      paramObject = Class.forName(paramString1).getMethod(paramString2, paramArrayOfClass).invoke(paramObject, paramArrayOfObject);
      return paramObject;
    }
    catch (Exception paramObject)
    {
      com.tencent.beacon.d.a.a("ref call %s#%s failed.", new Object[] { paramString1, paramString2 });
    }
    return null;
  }
  
  public static Object a(String paramString1, String paramString2, Class[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    try
    {
      paramArrayOfClass = Class.forName(paramString1).getMethod(paramString2, paramArrayOfClass).invoke(null, paramArrayOfObject);
      return paramArrayOfClass;
    }
    catch (Exception paramArrayOfClass)
    {
      com.tencent.beacon.d.a.a("ref call %s#%s failed.", new Object[] { paramString1, paramString2 });
    }
    return null;
  }
  
  public static String a()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("Android ");
    localStringBuffer.append(c());
    localStringBuffer.append(",level ");
    localStringBuffer.append(d());
    return localStringBuffer.toString();
  }
  
  public static String a(Map<String, String> paramMap)
  {
    com.tencent.beacon.d.a.b("map 2 str", new Object[0]);
    if (paramMap == null) {
      return "";
    }
    Object localObject = paramMap.keySet();
    if (localObject == null) {
      return "";
    }
    if (((Set)localObject).size() > 50) {
      com.tencent.beacon.d.a.c("The Map<String, String> params size is more than 50, effective size is <= 50!", new Object[0]);
    }
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = ((Set)localObject).iterator();
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      int i = str2.trim().length();
      String str1;
      if ((i > 0) && (d(str2)))
      {
        str1 = str2.trim();
        localObject = str1;
        if (i > 64) {
          localObject = str1.substring(0, 64);
        }
        localStringBuffer.append("&");
        localStringBuffer.append(((String)localObject).replace("|", "%7C").replace("&", "%26").replace("=", "%3D"));
        localStringBuffer.append("=");
        localObject = (String)paramMap.get(str2);
        if (localObject == null) {
          continue;
        }
        str1 = ((String)localObject).trim();
        if (!str1.contains(";")) {
          break label330;
        }
        localObject = str1;
        if (str1.length() > 10240)
        {
          localObject = str1.substring(0, 10240);
          localObject = ((String)localObject).substring(0, ((String)localObject).lastIndexOf(";"));
        }
      }
      for (;;)
      {
        localStringBuffer.append(((String)localObject).replace('\n', ' ').replace('\r', ' ').replace("|", "%7C").replace("&", "%26").replace("=", "%3D"));
        break;
        com.tencent.beacon.d.a.c("The Map<String, String> params key is invalid!! key should be ASCII code in 32-126! key:" + str2, new Object[0]);
        break;
        label330:
        localObject = str1;
        if (str1.length() > 1024) {
          localObject = str1.substring(0, 1024);
        }
      }
    }
    paramMap = localStringBuffer.substring(1);
    localStringBuffer.setLength(0);
    return paramMap;
  }
  
  /* Error */
  public static ArrayList<String> a(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 14	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 387	java/util/ArrayList:<init>	()V
    //   9: astore 4
    //   11: invokestatic 393	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   14: aload_0
    //   15: invokevirtual 397	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   18: astore_0
    //   19: new 399	java/io/BufferedReader
    //   22: dup
    //   23: new 401	java/io/InputStreamReader
    //   26: dup
    //   27: aload_0
    //   28: invokevirtual 407	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   31: invokespecial 410	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   34: invokespecial 413	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   37: astore_1
    //   38: aload_1
    //   39: invokevirtual 416	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   42: astore_2
    //   43: aload_2
    //   44: ifnull +44 -> 88
    //   47: aload 4
    //   49: aload_2
    //   50: invokevirtual 37	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   53: pop
    //   54: goto -16 -> 38
    //   57: astore 4
    //   59: aconst_null
    //   60: astore_0
    //   61: aload_0
    //   62: astore_3
    //   63: aload_1
    //   64: astore_2
    //   65: aload 4
    //   67: invokestatic 268	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   70: aload_1
    //   71: ifnull +7 -> 78
    //   74: aload_1
    //   75: invokevirtual 419	java/io/BufferedReader:close	()V
    //   78: aload_0
    //   79: ifnull +7 -> 86
    //   82: aload_0
    //   83: invokevirtual 419	java/io/BufferedReader:close	()V
    //   86: aconst_null
    //   87: areturn
    //   88: new 399	java/io/BufferedReader
    //   91: dup
    //   92: new 401	java/io/InputStreamReader
    //   95: dup
    //   96: aload_0
    //   97: invokevirtual 422	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   100: invokespecial 410	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   103: invokespecial 413	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   106: astore_0
    //   107: aload_0
    //   108: astore_3
    //   109: aload_1
    //   110: astore_2
    //   111: aload_0
    //   112: invokevirtual 416	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   115: astore 5
    //   117: aload 5
    //   119: ifnull +23 -> 142
    //   122: aload_0
    //   123: astore_3
    //   124: aload_1
    //   125: astore_2
    //   126: aload 4
    //   128: aload 5
    //   130: invokevirtual 37	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   133: pop
    //   134: goto -27 -> 107
    //   137: astore 4
    //   139: goto -78 -> 61
    //   142: aload_1
    //   143: invokevirtual 419	java/io/BufferedReader:close	()V
    //   146: aload_0
    //   147: invokevirtual 419	java/io/BufferedReader:close	()V
    //   150: aload 4
    //   152: areturn
    //   153: astore_0
    //   154: aload_0
    //   155: invokestatic 268	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   158: aload 4
    //   160: areturn
    //   161: astore_1
    //   162: aload_1
    //   163: invokestatic 268	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   166: goto -20 -> 146
    //   169: astore_1
    //   170: aload_1
    //   171: invokestatic 268	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   174: goto -96 -> 78
    //   177: astore_0
    //   178: aload_0
    //   179: invokestatic 268	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   182: goto -96 -> 86
    //   185: astore_0
    //   186: aconst_null
    //   187: astore_1
    //   188: aload_1
    //   189: ifnull +7 -> 196
    //   192: aload_1
    //   193: invokevirtual 419	java/io/BufferedReader:close	()V
    //   196: aload_3
    //   197: ifnull +7 -> 204
    //   200: aload_3
    //   201: invokevirtual 419	java/io/BufferedReader:close	()V
    //   204: aload_0
    //   205: athrow
    //   206: astore_1
    //   207: aload_1
    //   208: invokestatic 268	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   211: goto -15 -> 196
    //   214: astore_1
    //   215: aload_1
    //   216: invokestatic 268	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   219: goto -15 -> 204
    //   222: astore_0
    //   223: goto -35 -> 188
    //   226: astore_0
    //   227: aload_2
    //   228: astore_1
    //   229: goto -41 -> 188
    //   232: astore 4
    //   234: aconst_null
    //   235: astore_0
    //   236: aconst_null
    //   237: astore_1
    //   238: goto -177 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	paramArrayOfString	String[]
    //   37	106	1	localBufferedReader	BufferedReader
    //   161	2	1	localIOException1	java.io.IOException
    //   169	2	1	localIOException2	java.io.IOException
    //   187	6	1	localObject1	Object
    //   206	2	1	localIOException3	java.io.IOException
    //   214	2	1	localIOException4	java.io.IOException
    //   228	10	1	localObject2	Object
    //   42	186	2	localObject3	Object
    //   1	200	3	arrayOfString	String[]
    //   9	39	4	localArrayList	ArrayList
    //   57	70	4	localThrowable1	Throwable
    //   137	22	4	localThrowable2	Throwable
    //   232	1	4	localThrowable3	Throwable
    //   115	14	5	str	String
    // Exception table:
    //   from	to	target	type
    //   38	43	57	java/lang/Throwable
    //   47	54	57	java/lang/Throwable
    //   88	107	57	java/lang/Throwable
    //   111	117	137	java/lang/Throwable
    //   126	134	137	java/lang/Throwable
    //   146	150	153	java/io/IOException
    //   142	146	161	java/io/IOException
    //   74	78	169	java/io/IOException
    //   82	86	177	java/io/IOException
    //   11	38	185	finally
    //   192	196	206	java/io/IOException
    //   200	204	214	java/io/IOException
    //   38	43	222	finally
    //   47	54	222	finally
    //   88	107	222	finally
    //   65	70	226	finally
    //   111	117	226	finally
    //   126	134	226	finally
    //   11	38	232	java/lang/Throwable
  }
  
  public static HashSet<String> a(ArrayList<String> paramArrayList)
  {
    int i = paramArrayList.size();
    if ((paramArrayList != null) && (i > 0))
    {
      HashSet localHashSet = new HashSet(i);
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        localHashSet.add((String)paramArrayList.next());
      }
      return localHashSet;
    }
    return null;
  }
  
  public static List<k> a(Context paramContext, int paramInt)
  {
    com.tencent.beacon.d.a.a(" RecordDAO.queryRecentRecord() start", new Object[0]);
    if (paramContext == null) {
      com.tencent.beacon.d.a.d(" queryRecentRecord() have null args!", new Object[0]);
    }
    List localList;
    do
    {
      return null;
      localList = com.tencent.beacon.a.a.a.a(paramContext, new int[] { 1, 2, 3, 4 }, paramInt);
    } while ((localList == null) || (localList.size() <= 0));
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = localList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      com.tencent.beacon.a.a.a locala = (com.tencent.beacon.a.a.a)((Iterator)localObject1).next();
      try
      {
        Object localObject2 = b(locala.b());
        if ((localObject2 != null) && (k.class.isInstance(localObject2)))
        {
          localObject2 = (k)k.class.cast(localObject2);
          ((k)localObject2).a(locala.a());
          localArrayList.add(localObject2);
          ((Iterator)localObject1).remove();
        }
      }
      catch (Throwable localThrowable)
      {
        com.tencent.beacon.d.a.a(localThrowable);
        com.tencent.beacon.d.a.d(" query have error!", new Object[0]);
      }
    }
    if (localList.size() > 0)
    {
      com.tencent.beacon.d.a.a(" there are error datas ,should be remove " + localList.size(), new Object[0]);
      localObject1 = new Long[localList.size()];
      paramInt = 0;
      while (paramInt < localList.size())
      {
        localObject1[paramInt] = Long.valueOf(((com.tencent.beacon.a.a.a)localList.get(paramInt)).a());
        paramInt += 1;
      }
      com.tencent.beacon.a.a.a.a(paramContext, (Long[])localObject1);
    }
    com.tencent.beacon.d.a.a(" RecordDAO.queryRecentRecord() end", new Object[0]);
    return localArrayList;
  }
  
  /* Error */
  public static boolean a(Context paramContext, com.tencent.beacon.a.b.g paramg)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: iconst_0
    //   3: istore_3
    //   4: getstatic 484	com/tencent/beacon/a/a/e:a	Ljava/lang/Object;
    //   7: astore 6
    //   9: aload 6
    //   11: monitorenter
    //   12: aload_0
    //   13: ifnull +7 -> 20
    //   16: aload_1
    //   17: ifnonnull +18 -> 35
    //   20: ldc_w 486
    //   23: iconst_0
    //   24: anewarray 4	java/lang/Object
    //   27: invokestatic 310	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   30: aload 6
    //   32: monitorexit
    //   33: iconst_0
    //   34: ireturn
    //   35: aload_0
    //   36: invokestatic 489	com/tencent/beacon/a/a/e:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/a/e;
    //   39: invokevirtual 493	com/tencent/beacon/a/a/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   42: astore 7
    //   44: aload 7
    //   46: ifnonnull +24 -> 70
    //   49: ldc_w 495
    //   52: iconst_0
    //   53: anewarray 4	java/lang/Object
    //   56: invokestatic 58	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   59: aload 6
    //   61: monitorexit
    //   62: iconst_0
    //   63: ireturn
    //   64: astore_0
    //   65: aload 6
    //   67: monitorexit
    //   68: aload_0
    //   69: athrow
    //   70: aload_1
    //   71: ifnonnull +47 -> 118
    //   74: aconst_null
    //   75: astore_0
    //   76: aload_0
    //   77: ifnull +152 -> 229
    //   80: aload 7
    //   82: ldc_w 497
    //   85: ldc_w 499
    //   88: aload_0
    //   89: invokevirtual 504	android/database/sqlite/SQLiteDatabase:replace	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   92: lstore 4
    //   94: lload 4
    //   96: lconst_0
    //   97: lcmp
    //   98: ifge +102 -> 200
    //   101: ldc_w 506
    //   104: iconst_0
    //   105: anewarray 4	java/lang/Object
    //   108: invokestatic 310	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   111: iload_3
    //   112: istore_2
    //   113: aload 6
    //   115: monitorexit
    //   116: iload_2
    //   117: ireturn
    //   118: new 508	android/content/ContentValues
    //   121: dup
    //   122: invokespecial 509	android/content/ContentValues:<init>	()V
    //   125: astore_0
    //   126: aload_1
    //   127: invokevirtual 512	com/tencent/beacon/a/b/g:a	()J
    //   130: lconst_0
    //   131: lcmp
    //   132: iflt +17 -> 149
    //   135: aload_0
    //   136: ldc_w 499
    //   139: aload_1
    //   140: invokevirtual 512	com/tencent/beacon/a/b/g:a	()J
    //   143: invokestatic 475	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   146: invokevirtual 515	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   149: aload_0
    //   150: ldc_w 517
    //   153: aload_1
    //   154: invokevirtual 519	com/tencent/beacon/a/b/g:b	()I
    //   157: invokestatic 524	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   160: invokevirtual 527	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   163: aload_0
    //   164: ldc_w 529
    //   167: aload_1
    //   168: invokevirtual 531	com/tencent/beacon/a/b/g:c	()[B
    //   171: invokevirtual 534	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   174: goto -98 -> 76
    //   177: astore_0
    //   178: ldc_w 536
    //   181: iconst_1
    //   182: anewarray 4	java/lang/Object
    //   185: dup
    //   186: iconst_0
    //   187: aload_0
    //   188: invokevirtual 537	java/lang/Throwable:toString	()Ljava/lang/String;
    //   191: aastore
    //   192: invokestatic 58	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   195: iload_3
    //   196: istore_2
    //   197: goto -84 -> 113
    //   200: aload_1
    //   201: lload 4
    //   203: invokevirtual 538	com/tencent/beacon/a/b/g:a	(J)V
    //   206: ldc_w 540
    //   209: iconst_1
    //   210: anewarray 4	java/lang/Object
    //   213: dup
    //   214: iconst_0
    //   215: aload_1
    //   216: invokevirtual 519	com/tencent/beacon/a/b/g:b	()I
    //   219: invokestatic 524	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   222: aastore
    //   223: invokestatic 542	com/tencent/beacon/d/a:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   226: goto -113 -> 113
    //   229: iconst_0
    //   230: istore_2
    //   231: goto -5 -> 226
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	234	0	paramContext	Context
    //   0	234	1	paramg	com.tencent.beacon.a.b.g
    //   1	230	2	bool1	boolean
    //   3	193	3	bool2	boolean
    //   92	110	4	l	long
    //   7	107	6	localObject	Object
    //   42	39	7	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   20	33	64	finally
    //   35	44	64	finally
    //   49	59	64	finally
    //   59	62	64	finally
    //   80	94	64	finally
    //   101	111	64	finally
    //   113	116	64	finally
    //   118	149	64	finally
    //   149	174	64	finally
    //   178	195	64	finally
    //   200	226	64	finally
    //   35	44	177	java/lang/Throwable
    //   49	59	177	java/lang/Throwable
    //   80	94	177	java/lang/Throwable
    //   101	111	177	java/lang/Throwable
    //   118	149	177	java/lang/Throwable
    //   149	174	177	java/lang/Throwable
    //   200	226	177	java/lang/Throwable
  }
  
  public static boolean a(Context paramContext, String paramString, Object[] paramArrayOfObject)
  {
    Object localObject = e.a;
    if ((paramContext != null) && (paramString != null) && (paramArrayOfObject != null)) {}
    for (;;)
    {
      ContentValues localContentValues;
      try
      {
        if (paramArrayOfObject.length == 0) {
          return false;
        }
      }
      finally {}
      try
      {
        paramContext = e.a(paramContext).getWritableDatabase();
        paramContext.delete("t_conf", "_key = '" + paramString + "'", null);
        localContentValues = new ContentValues();
        localContentValues.put("_key", paramString);
        localContentValues.put("_value", (String)paramArrayOfObject[0]);
        localContentValues.put("_vdate", (Long)paramArrayOfObject[1]);
        localContentValues.put("_time", Long.valueOf(new Date().getTime()));
        if (paramContext.insert("t_conf", null, localContentValues) >= 0L) {
          break label175;
        }
        com.tencent.beacon.d.a.d(" insertOrUpdateByKey failure! return false!", new Object[0]);
        bool = false;
      }
      catch (Exception paramContext)
      {
        label175:
        bool = false;
        continue;
      }
      return bool;
      bool = true;
    }
  }
  
  /* Error */
  private static byte[] a(Object paramObject)
  {
    // Byte code:
    //   0: ldc_w 575
    //   3: iconst_0
    //   4: anewarray 4	java/lang/Object
    //   7: invokestatic 98	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   10: aload_0
    //   11: ifnull +13 -> 24
    //   14: ldc_w 577
    //   17: aload_0
    //   18: invokevirtual 452	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   21: ifne +15 -> 36
    //   24: ldc_w 579
    //   27: iconst_0
    //   28: anewarray 4	java/lang/Object
    //   31: invokestatic 310	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   34: aconst_null
    //   35: areturn
    //   36: new 581	java/io/ByteArrayOutputStream
    //   39: dup
    //   40: invokespecial 582	java/io/ByteArrayOutputStream:<init>	()V
    //   43: astore 4
    //   45: new 584	java/io/ObjectOutputStream
    //   48: dup
    //   49: aload 4
    //   51: invokespecial 587	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   54: astore_2
    //   55: aload_2
    //   56: astore_1
    //   57: aload_2
    //   58: aload_0
    //   59: invokevirtual 591	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   62: aload_2
    //   63: astore_1
    //   64: aload_2
    //   65: invokevirtual 594	java/io/ObjectOutputStream:flush	()V
    //   68: aload_2
    //   69: astore_1
    //   70: aload 4
    //   72: invokevirtual 597	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   75: astore_0
    //   76: aload_2
    //   77: invokevirtual 598	java/io/ObjectOutputStream:close	()V
    //   80: aload 4
    //   82: invokevirtual 599	java/io/ByteArrayOutputStream:close	()V
    //   85: aload_0
    //   86: areturn
    //   87: astore_1
    //   88: aload_1
    //   89: invokestatic 268	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   92: aload_0
    //   93: areturn
    //   94: astore_1
    //   95: aload_1
    //   96: invokestatic 268	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   99: goto -19 -> 80
    //   102: astore_3
    //   103: aconst_null
    //   104: astore_0
    //   105: aload_0
    //   106: astore_1
    //   107: aload_3
    //   108: invokestatic 268	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   111: aload_0
    //   112: astore_1
    //   113: aload_3
    //   114: invokevirtual 602	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   117: iconst_0
    //   118: anewarray 4	java/lang/Object
    //   121: invokestatic 58	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   124: aload_0
    //   125: ifnull +7 -> 132
    //   128: aload_0
    //   129: invokevirtual 598	java/io/ObjectOutputStream:close	()V
    //   132: aload 4
    //   134: invokevirtual 599	java/io/ByteArrayOutputStream:close	()V
    //   137: aconst_null
    //   138: areturn
    //   139: astore_0
    //   140: aload_0
    //   141: invokestatic 268	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   144: aconst_null
    //   145: areturn
    //   146: astore_0
    //   147: aload_0
    //   148: invokestatic 268	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   151: goto -19 -> 132
    //   154: astore_0
    //   155: aconst_null
    //   156: astore_1
    //   157: aload_1
    //   158: ifnull +7 -> 165
    //   161: aload_1
    //   162: invokevirtual 598	java/io/ObjectOutputStream:close	()V
    //   165: aload 4
    //   167: invokevirtual 599	java/io/ByteArrayOutputStream:close	()V
    //   170: aload_0
    //   171: athrow
    //   172: astore_1
    //   173: aload_1
    //   174: invokestatic 268	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   177: goto -12 -> 165
    //   180: astore_1
    //   181: aload_1
    //   182: invokestatic 268	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   185: goto -15 -> 170
    //   188: astore_0
    //   189: goto -32 -> 157
    //   192: astore_3
    //   193: aload_2
    //   194: astore_0
    //   195: goto -90 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	paramObject	Object
    //   56	14	1	localObjectOutputStream1	java.io.ObjectOutputStream
    //   87	2	1	localIOException1	java.io.IOException
    //   94	2	1	localIOException2	java.io.IOException
    //   106	56	1	localObject	Object
    //   172	2	1	localIOException3	java.io.IOException
    //   180	2	1	localIOException4	java.io.IOException
    //   54	140	2	localObjectOutputStream2	java.io.ObjectOutputStream
    //   102	12	3	localThrowable1	Throwable
    //   192	1	3	localThrowable2	Throwable
    //   43	123	4	localByteArrayOutputStream	ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   80	85	87	java/io/IOException
    //   76	80	94	java/io/IOException
    //   45	55	102	java/lang/Throwable
    //   132	137	139	java/io/IOException
    //   128	132	146	java/io/IOException
    //   45	55	154	finally
    //   161	165	172	java/io/IOException
    //   165	170	180	java/io/IOException
    //   57	62	188	finally
    //   64	68	188	finally
    //   70	76	188	finally
    //   107	111	188	finally
    //   113	124	188	finally
    //   57	62	192	java/lang/Throwable
    //   64	68	192	java/lang/Throwable
    //   70	76	192	java/lang/Throwable
  }
  
  public static byte[] a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      Object localObject = new X509EncodedKeySpec(Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCsAxNCSLyNUCOP1QqYStE8ZeiU\nv4afaMqEmoLCKb0mUZYvYOoVN7LPMi2IVY2MRaFJvuND3glVw1RDm2VJJtjQkwUd\n3kpR9TrHAf7UQOVTpNo3Vi7pXTOqZ6bh3ZA/fs56jDCCKV6+wT/pCeu8N6vVnPrD\nz3SdHIeNeWb/woazCwIDAQAB", 0));
      localObject = (RSAPublicKey)KeyFactory.getInstance("RSA", "BC").generatePublic((KeySpec)localObject);
      Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
      localCipher.init(1, (Key)localObject);
      paramString = localCipher.doFinal(paramString.getBytes());
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
    }
  }
  
  private static byte[] a(String paramString, byte[] paramArrayOfByte)
    throws Exception
  {
    if ((paramString == null) || (paramArrayOfByte == null)) {
      return null;
    }
    int i = paramString.length();
    for (;;)
    {
      if (i >= 16)
      {
        paramString = paramString.substring(0, 16);
        SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramString.getBytes(), "AES");
        Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        localCipher.init(2, localSecretKeySpec, new IvParameterSpec(paramString.getBytes()));
        return localCipher.doFinal(paramArrayOfByte);
      }
      paramString = paramString + "0";
      i += 1;
    }
  }
  
  private static byte[] a(byte[] paramArrayOfByte)
    throws Exception
  {
    paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
    GZIPInputStream localGZIPInputStream = new GZIPInputStream(paramArrayOfByte);
    byte[] arrayOfByte = new byte[1024];
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    for (;;)
    {
      int i = localGZIPInputStream.read(arrayOfByte, 0, arrayOfByte.length);
      if (i == -1)
      {
        arrayOfByte = localByteArrayOutputStream.toByteArray();
        localByteArrayOutputStream.flush();
        localByteArrayOutputStream.close();
        localGZIPInputStream.close();
        paramArrayOfByte.close();
        return arrayOfByte;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  private static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte == null) || (paramInt == -1)) {
      return paramArrayOfByte;
    }
    com.tencent.beacon.d.a.b("zp: %s len: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfByte.length) });
    ByteArrayOutputStream localByteArrayOutputStream;
    Object localObject;
    if (paramInt == 1) {
      try
      {
        localByteArrayOutputStream = new ByteArrayOutputStream();
        localObject = new ZipOutputStream(localByteArrayOutputStream);
        ZipEntry localZipEntry = new ZipEntry("zip");
        localZipEntry.setSize(paramArrayOfByte.length);
        ((ZipOutputStream)localObject).putNextEntry(localZipEntry);
        ((ZipOutputStream)localObject).write(paramArrayOfByte);
        ((ZipOutputStream)localObject).closeEntry();
        ((ZipOutputStream)localObject).close();
        paramArrayOfByte = localByteArrayOutputStream.toByteArray();
        localByteArrayOutputStream.close();
        return paramArrayOfByte;
      }
      catch (Throwable paramArrayOfByte)
      {
        com.tencent.beacon.d.a.a(paramArrayOfByte);
        com.tencent.beacon.d.a.d("err zp : %s", new Object[] { paramArrayOfByte.toString() });
        return null;
      }
    }
    if (paramInt == 2)
    {
      localByteArrayOutputStream = new ByteArrayOutputStream();
      localObject = new GZIPOutputStream(localByteArrayOutputStream);
      ((GZIPOutputStream)localObject).write(paramArrayOfByte);
      ((GZIPOutputStream)localObject).finish();
      ((GZIPOutputStream)localObject).close();
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      localByteArrayOutputStream.close();
      return paramArrayOfByte;
    }
    return null;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, String paramString)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    try
    {
      paramArrayOfByte = a(a(paramArrayOfByte, paramInt1), paramInt2, paramString);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      com.tencent.beacon.d.a.a(paramArrayOfByte);
    }
    return null;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt, String paramString)
  {
    if ((paramArrayOfByte == null) || (paramInt == -1)) {
      return paramArrayOfByte;
    }
    com.tencent.beacon.d.a.b("enD: %d %d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt) });
    if (paramInt == 1) {
      if ((paramString == null) || (paramArrayOfByte == null)) {
        return null;
      }
    }
    try
    {
      Cipher localCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
      DESKeySpec localDESKeySpec = new DESKeySpec(paramString.getBytes("UTF-8"));
      localCipher.init(1, SecretKeyFactory.getInstance("DES").generateSecret(localDESKeySpec), new IvParameterSpec(paramString.getBytes("UTF-8")));
      return localCipher.doFinal(paramArrayOfByte);
    }
    catch (Throwable paramArrayOfByte)
    {
      com.tencent.beacon.d.a.a(paramArrayOfByte);
      com.tencent.beacon.d.a.d("err enD: %s", new Object[] { paramArrayOfByte.toString() });
    }
    if (paramInt == 3)
    {
      paramArrayOfByte = b(paramString, paramArrayOfByte);
      return paramArrayOfByte;
    }
    return null;
    return null;
  }
  
  public static Long[] a(Context paramContext, List<k> paramList)
  {
    com.tencent.beacon.d.a.a(" RecordDAO.insertList() start", new Object[0]);
    if ((paramContext == null) || (paramList == null))
    {
      com.tencent.beacon.d.a.d(" insertList() have null args!", new Object[0]);
      return null;
    }
    int m = paramList.size();
    if (m == 0)
    {
      com.tencent.beacon.d.a.b(" list siez == 0 , return true!", new Object[0]);
      return null;
    }
    Long[] arrayOfLong = new Long[m];
    ArrayList localArrayList = new ArrayList();
    int k = 0;
    for (;;)
    {
      if (k < m)
      {
        k localk = (k)paramList.get(k);
        int j;
        if (localk.b().equals("UA"))
        {
          i = 1;
          j = 3;
        }
        try
        {
          label112:
          localArrayList.add(new com.tencent.beacon.a.a.a(i, j, localk.c(), a(localk)));
          for (;;)
          {
            k += 1;
            break;
            if (localk.b().equals("IP"))
            {
              i = 2;
              j = 0;
              break label112;
            }
            if (localk.b().equals("DN"))
            {
              j = 0;
              i = 3;
              break label112;
            }
            if (localk.b().equals("HO"))
            {
              i = 4;
              j = 0;
              break label112;
            }
            com.tencent.beacon.d.a.d(" bean's type is error!", new Object[0]);
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            com.tencent.beacon.d.a.a(localThrowable);
          }
        }
      }
    }
    if (!com.tencent.beacon.a.a.a.a(paramContext, localArrayList)) {
      return null;
    }
    paramContext = localArrayList.iterator();
    int i = 0;
    while (paramContext.hasNext())
    {
      paramList = (com.tencent.beacon.a.a.a)paramContext.next();
      if (i < m) {
        arrayOfLong[i] = Long.valueOf(paramList.a());
      }
      i += 1;
    }
    return arrayOfLong;
  }
  
  /* Error */
  public static Object[] a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: getstatic 484	com/tencent/beacon/a/a/e:a	Ljava/lang/Object;
    //   6: astore 5
    //   8: aload 5
    //   10: monitorenter
    //   11: aload_0
    //   12: ifnonnull +18 -> 30
    //   15: ldc_w 785
    //   18: iconst_0
    //   19: anewarray 4	java/lang/Object
    //   22: invokestatic 310	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   25: aload 5
    //   27: monitorexit
    //   28: aconst_null
    //   29: areturn
    //   30: aload_1
    //   31: ifnonnull +18 -> 49
    //   34: ldc_w 787
    //   37: iconst_0
    //   38: anewarray 4	java/lang/Object
    //   41: invokestatic 310	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   44: aload 5
    //   46: monitorexit
    //   47: aconst_null
    //   48: areturn
    //   49: aload_0
    //   50: invokestatic 489	com/tencent/beacon/a/a/e:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/a/e;
    //   53: invokevirtual 493	com/tencent/beacon/a/a/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   56: astore_0
    //   57: aload_0
    //   58: ifnonnull +18 -> 76
    //   61: ldc_w 789
    //   64: iconst_0
    //   65: anewarray 4	java/lang/Object
    //   68: invokestatic 310	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   71: aload 5
    //   73: monitorexit
    //   74: aconst_null
    //   75: areturn
    //   76: aload_0
    //   77: ldc_w 545
    //   80: aconst_null
    //   81: new 154	java/lang/StringBuilder
    //   84: dup
    //   85: ldc_w 547
    //   88: invokespecial 375	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   91: aload_1
    //   92: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: ldc_w 549
    //   98: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: aconst_null
    //   105: aconst_null
    //   106: aconst_null
    //   107: aconst_null
    //   108: invokevirtual 793	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   111: astore_0
    //   112: aload_0
    //   113: ifnull +94 -> 207
    //   116: aload_0
    //   117: invokeinterface 798 1 0
    //   122: ifeq +85 -> 207
    //   125: aload_0
    //   126: aload_0
    //   127: ldc_w 558
    //   130: invokeinterface 801 2 0
    //   135: invokeinterface 804 2 0
    //   140: astore 4
    //   142: aload_0
    //   143: aload_0
    //   144: ldc_w 560
    //   147: invokeinterface 801 2 0
    //   152: invokeinterface 808 2 0
    //   157: lstore_2
    //   158: aload_0
    //   159: ifnull +18 -> 177
    //   162: aload_0
    //   163: invokeinterface 811 1 0
    //   168: ifne +9 -> 177
    //   171: aload_0
    //   172: invokeinterface 812 1 0
    //   177: aload 5
    //   179: monitorexit
    //   180: iconst_3
    //   181: anewarray 4	java/lang/Object
    //   184: dup
    //   185: iconst_0
    //   186: aload_1
    //   187: aastore
    //   188: dup
    //   189: iconst_1
    //   190: aload 4
    //   192: aastore
    //   193: dup
    //   194: iconst_2
    //   195: lload_2
    //   196: invokestatic 475	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   199: aastore
    //   200: areturn
    //   201: astore_0
    //   202: aload 5
    //   204: monitorexit
    //   205: aload_0
    //   206: athrow
    //   207: aload_0
    //   208: ifnull +18 -> 226
    //   211: aload_0
    //   212: invokeinterface 811 1 0
    //   217: ifne +9 -> 226
    //   220: aload_0
    //   221: invokeinterface 812 1 0
    //   226: aload 5
    //   228: monitorexit
    //   229: aconst_null
    //   230: areturn
    //   231: aload_0
    //   232: ifnull -6 -> 226
    //   235: aload_0
    //   236: invokeinterface 811 1 0
    //   241: ifne -15 -> 226
    //   244: aload_0
    //   245: invokeinterface 812 1 0
    //   250: goto -24 -> 226
    //   253: aload_1
    //   254: ifnull +18 -> 272
    //   257: aload_1
    //   258: invokeinterface 811 1 0
    //   263: ifne +9 -> 272
    //   266: aload_1
    //   267: invokeinterface 812 1 0
    //   272: aload_0
    //   273: athrow
    //   274: astore 4
    //   276: aload_0
    //   277: astore_1
    //   278: aload 4
    //   280: astore_0
    //   281: goto -28 -> 253
    //   284: astore_1
    //   285: goto -54 -> 231
    //   288: astore_0
    //   289: aconst_null
    //   290: astore_0
    //   291: goto -60 -> 231
    //   294: astore_0
    //   295: aload 4
    //   297: astore_1
    //   298: goto -45 -> 253
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	301	0	paramContext	Context
    //   0	301	1	paramString	String
    //   157	39	2	l	long
    //   1	190	4	str	String
    //   274	22	4	localObject1	Object
    //   6	221	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   15	28	201	finally
    //   34	47	201	finally
    //   71	74	201	finally
    //   162	177	201	finally
    //   177	180	201	finally
    //   211	226	201	finally
    //   226	229	201	finally
    //   235	250	201	finally
    //   257	272	201	finally
    //   272	274	201	finally
    //   116	158	274	finally
    //   116	158	284	java/lang/Exception
    //   49	57	288	java/lang/Exception
    //   61	71	288	java/lang/Exception
    //   76	112	288	java/lang/Exception
    //   49	57	294	finally
    //   61	71	294	finally
    //   76	112	294	finally
  }
  
  public static int b(Context paramContext, com.tencent.beacon.a.a.f[] paramArrayOff)
  {
    int j = 0;
    int i;
    if (paramContext == null) {
      i = -1;
    }
    ArrayList localArrayList;
    do
    {
      return i;
      if (paramArrayOff == null) {
        return com.tencent.beacon.a.a.a.a(paramContext, new int[] { 6 });
      }
      localArrayList = new ArrayList();
      int k = paramArrayOff.length;
      i = 0;
      while (i < k)
      {
        com.tencent.beacon.a.a.f localf = paramArrayOff[i];
        if (localf.a() >= 0L) {
          localArrayList.add(Long.valueOf(localf.a()));
        }
        i += 1;
      }
      i = j;
    } while (localArrayList.size() <= 0);
    return com.tencent.beacon.a.a.a.a(paramContext, (Long[])localArrayList.toArray(new Long[0]));
  }
  
  /* Error */
  private static Object b(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc_w 823
    //   3: iconst_0
    //   4: anewarray 4	java/lang/Object
    //   7: invokestatic 98	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   10: aload_0
    //   11: ifnull +8 -> 19
    //   14: aload_0
    //   15: arraylength
    //   16: ifge +5 -> 21
    //   19: aconst_null
    //   20: areturn
    //   21: new 674	java/io/ByteArrayInputStream
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 675	java/io/ByteArrayInputStream:<init>	([B)V
    //   29: astore_3
    //   30: new 825	java/io/ObjectInputStream
    //   33: dup
    //   34: aload_3
    //   35: invokespecial 826	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   38: astore_1
    //   39: aload_1
    //   40: astore_0
    //   41: aload_1
    //   42: invokevirtual 829	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   45: astore_2
    //   46: aload_1
    //   47: invokevirtual 830	java/io/ObjectInputStream:close	()V
    //   50: aload_3
    //   51: invokevirtual 685	java/io/ByteArrayInputStream:close	()V
    //   54: aload_2
    //   55: areturn
    //   56: astore_0
    //   57: aload_0
    //   58: invokestatic 268	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   61: aload_2
    //   62: areturn
    //   63: astore_0
    //   64: aload_0
    //   65: invokestatic 268	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   68: goto -18 -> 50
    //   71: astore_2
    //   72: aconst_null
    //   73: astore_1
    //   74: aload_1
    //   75: astore_0
    //   76: aload_2
    //   77: invokestatic 268	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   80: aload_1
    //   81: astore_0
    //   82: aload_2
    //   83: invokevirtual 602	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   86: iconst_0
    //   87: anewarray 4	java/lang/Object
    //   90: invokestatic 58	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   93: aload_1
    //   94: ifnull +7 -> 101
    //   97: aload_1
    //   98: invokevirtual 830	java/io/ObjectInputStream:close	()V
    //   101: aload_3
    //   102: invokevirtual 685	java/io/ByteArrayInputStream:close	()V
    //   105: aconst_null
    //   106: areturn
    //   107: astore_0
    //   108: aload_0
    //   109: invokestatic 268	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   112: aconst_null
    //   113: areturn
    //   114: astore_0
    //   115: aload_0
    //   116: invokestatic 268	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   119: goto -18 -> 101
    //   122: astore_1
    //   123: aconst_null
    //   124: astore_0
    //   125: aload_0
    //   126: ifnull +7 -> 133
    //   129: aload_0
    //   130: invokevirtual 830	java/io/ObjectInputStream:close	()V
    //   133: aload_3
    //   134: invokevirtual 685	java/io/ByteArrayInputStream:close	()V
    //   137: aload_1
    //   138: athrow
    //   139: astore_0
    //   140: aload_0
    //   141: invokestatic 268	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   144: goto -11 -> 133
    //   147: astore_0
    //   148: aload_0
    //   149: invokestatic 268	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   152: goto -15 -> 137
    //   155: astore_1
    //   156: goto -31 -> 125
    //   159: astore_2
    //   160: goto -86 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	paramArrayOfByte	byte[]
    //   38	60	1	localObjectInputStream	java.io.ObjectInputStream
    //   122	16	1	localObject1	Object
    //   155	1	1	localObject2	Object
    //   45	17	2	localObject3	Object
    //   71	12	2	localThrowable1	Throwable
    //   159	1	2	localThrowable2	Throwable
    //   29	105	3	localByteArrayInputStream	ByteArrayInputStream
    // Exception table:
    //   from	to	target	type
    //   50	54	56	java/io/IOException
    //   46	50	63	java/io/IOException
    //   30	39	71	java/lang/Throwable
    //   101	105	107	java/io/IOException
    //   97	101	114	java/io/IOException
    //   30	39	122	finally
    //   129	133	139	java/io/IOException
    //   133	137	147	java/io/IOException
    //   41	46	155	finally
    //   76	80	155	finally
    //   82	93	155	finally
    //   41	46	159	java/lang/Throwable
  }
  
  public static String b()
  {
    try
    {
      String str = Build.MODEL;
      return str;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.d.a.d("getDeviceName error", new Object[0]);
      com.tencent.beacon.d.a.a(localThrowable);
    }
    return "";
  }
  
  public static String b(Context paramContext)
  {
    if (paramContext == null)
    {
      com.tencent.beacon.d.a.d("getImei but context == null!", new Object[0]);
      return "";
    }
    for (;;)
    {
      try
      {
        if (!b.g(paramContext)) {
          continue;
        }
        paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
        if (paramContext != null) {
          continue;
        }
        paramContext = "";
      }
      catch (Throwable paramContext)
      {
        Object localObject = "";
        continue;
        paramContext = "";
        continue;
      }
      localObject = paramContext;
      try
      {
        com.tencent.beacon.d.a.a("IMEI:" + paramContext, new Object[0]);
        return paramContext;
      }
      catch (Throwable paramContext) {}
      com.tencent.beacon.d.a.d("getImei error!", new Object[0]);
      return localObject;
      localObject = paramContext;
      paramContext = paramContext.toLowerCase();
    }
  }
  
  public static String b(Context paramContext, int paramInt)
  {
    try
    {
      Object localObject = com.tencent.beacon.event.d.a(paramContext);
      paramContext = ((com.tencent.beacon.event.d)localObject).b();
      localObject = ((com.tencent.beacon.event.d)localObject).c();
      paramContext = g(paramContext + "_" + (String)localObject + "_" + new Date().getTime() + "_" + paramInt);
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public static String b(String paramString)
  {
    String str = paramString.replace('|', '_').trim();
    if (d(str))
    {
      if (str.length() < 5) {
        com.tencent.beacon.d.a.c(" userID is invalid!! userID is too short, length < 5!", new Object[0]);
      }
      paramString = str;
      if (str.length() > 128) {
        paramString = str.substring(0, 128);
      }
      return paramString;
    }
    com.tencent.beacon.d.a.c("userID is invalid!! userID should be ASCII code in 32-126! userID:" + paramString, new Object[0]);
    return "10000";
  }
  
  private static byte[] b(String paramString, byte[] paramArrayOfByte)
    throws Exception, NoSuchAlgorithmException
  {
    if ((paramString == null) || (paramArrayOfByte == null)) {
      return null;
    }
    int i = paramString.length();
    for (;;)
    {
      if (i >= 16)
      {
        paramString = paramString.substring(0, 16);
        SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramString.getBytes(), "AES");
        Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        localCipher.init(1, localSecretKeySpec, new IvParameterSpec(paramString.getBytes()));
        return localCipher.doFinal(paramArrayOfByte);
      }
      paramString = paramString + "0";
      i += 1;
    }
  }
  
  private static byte[] b(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte == null) || (paramInt == -1)) {
      return paramArrayOfByte;
    }
    com.tencent.beacon.d.a.b("unzp: %s len: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfByte.length) });
    if (paramInt == 1)
    {
      ZipInputStream localZipInputStream;
      try
      {
        ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
        localZipInputStream = new ZipInputStream(localByteArrayInputStream);
        paramArrayOfByte = null;
        if (localZipInputStream.getNextEntry() == null)
        {
          localZipInputStream.close();
          localByteArrayInputStream.close();
          return paramArrayOfByte;
        }
      }
      catch (Throwable paramArrayOfByte)
      {
        com.tencent.beacon.d.a.a(paramArrayOfByte);
        com.tencent.beacon.d.a.d("err unzp}" + paramArrayOfByte.toString(), new Object[0]);
        return null;
      }
      paramArrayOfByte = new byte[1024];
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      for (;;)
      {
        paramInt = localZipInputStream.read(paramArrayOfByte, 0, paramArrayOfByte.length);
        if (paramInt == -1)
        {
          paramArrayOfByte = localByteArrayOutputStream.toByteArray();
          localByteArrayOutputStream.flush();
          localByteArrayOutputStream.close();
          break;
        }
        localByteArrayOutputStream.write(paramArrayOfByte, 0, paramInt);
      }
    }
    if (paramInt == 2)
    {
      paramArrayOfByte = a(paramArrayOfByte);
      return paramArrayOfByte;
    }
    return null;
  }
  
  public static byte[] b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, String paramString)
  {
    try
    {
      paramArrayOfByte = b(b(paramArrayOfByte, paramInt2, paramString), paramInt1);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      com.tencent.beacon.d.a.a(paramArrayOfByte);
    }
    return null;
  }
  
  public static byte[] b(byte[] paramArrayOfByte, int paramInt, String paramString)
  {
    if ((paramArrayOfByte == null) || (paramInt == -1)) {
      return paramArrayOfByte;
    }
    if (paramInt == 1) {
      if ((paramString == null) || (paramArrayOfByte == null)) {
        return null;
      }
    }
    try
    {
      Cipher localCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
      DESKeySpec localDESKeySpec = new DESKeySpec(paramString.getBytes("UTF-8"));
      localCipher.init(2, SecretKeyFactory.getInstance("DES").generateSecret(localDESKeySpec), new IvParameterSpec(paramString.getBytes("UTF-8")));
      return localCipher.doFinal(paramArrayOfByte);
    }
    catch (Throwable paramArrayOfByte)
    {
      com.tencent.beacon.d.a.a(paramArrayOfByte);
      com.tencent.beacon.d.a.d("err unD: %s", new Object[] { paramArrayOfByte.toString() });
    }
    if (paramInt == 3)
    {
      paramArrayOfByte = a(paramString, paramArrayOfByte);
      return paramArrayOfByte;
    }
    return null;
    return null;
  }
  
  public static int c(Context paramContext, com.tencent.beacon.a.a.f[] paramArrayOff)
  {
    int j = 0;
    int i;
    if ((paramContext == null) || (paramArrayOff == null) || (paramArrayOff.length <= 0)) {
      i = -1;
    }
    ArrayList localArrayList;
    do
    {
      return i;
      localArrayList = new ArrayList(paramArrayOff.length);
      int k = paramArrayOff.length;
      i = 0;
      while (i < k)
      {
        com.tencent.beacon.a.a.f localf = paramArrayOff[i];
        Object localObject = a(localf);
        if (localObject != null)
        {
          localObject = new com.tencent.beacon.a.a.a(7, 0, 0L, (byte[])localObject);
          ((com.tencent.beacon.a.a.a)localObject).a(localf.a());
          localArrayList.add(localObject);
        }
        i += 1;
      }
      i = j;
    } while (localArrayList.size() <= 0);
    if (com.tencent.beacon.a.a.a.b(paramContext, localArrayList)) {
      return localArrayList.size();
    }
    return -1;
  }
  
  public static String c()
  {
    try
    {
      String str = Build.VERSION.RELEASE;
      return str;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.d.a.d("getVersion error", new Object[0]);
      com.tencent.beacon.d.a.a(localThrowable);
    }
    return "";
  }
  
  public static String c(Context paramContext)
  {
    String str = "";
    if (paramContext == null)
    {
      com.tencent.beacon.d.a.d("getImsi but context == null!", new Object[0]);
      return "";
    }
    Object localObject = str;
    try
    {
      if (b.g(paramContext))
      {
        localObject = str;
        paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
        if (paramContext == null)
        {
          paramContext = "";
        }
        else
        {
          localObject = paramContext;
          paramContext = paramContext.toLowerCase();
        }
      }
    }
    catch (Throwable paramContext)
    {
      paramContext = (Context)localObject;
      com.tencent.beacon.d.a.d("getImsi error!", new Object[0]);
    }
    paramContext = "";
    return paramContext;
  }
  
  public static String c(String paramString)
  {
    String str2 = "unknown";
    String str1 = str2;
    if (paramString != null)
    {
      if (paramString.trim().length() == 0) {
        str1 = str2;
      }
    }
    else {
      return str1;
    }
    str1 = paramString.trim();
    int i = str1.length();
    int j;
    do
    {
      i -= 1;
      if (i < 0) {
        break;
      }
      j = str1.charAt(i);
    } while ((j >= 48) && (j <= 57));
    for (i = 0;; i = 1)
    {
      if (i == 0) {
        break label98;
      }
      paramString = paramString.trim();
      str1 = paramString;
      if (paramString.length() <= 16) {
        break;
      }
      return paramString.substring(0, 16);
    }
    label98:
    com.tencent.beacon.d.a.c("channelID is invalid!! channelID should be Numeric! channelID:" + paramString, new Object[0]);
    return "unknown";
  }
  
  public static String d()
  {
    try
    {
      String str = Build.VERSION.SDK;
      return str;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.d.a.d("getApiLevel error", new Object[0]);
      com.tencent.beacon.d.a.a(localThrowable);
    }
    return "";
  }
  
  public static String d(Context paramContext)
  {
    String str2 = "";
    if (paramContext == null)
    {
      com.tencent.beacon.d.a.d("getAndroidId but context == null!", new Object[0]);
      return "";
    }
    try
    {
      paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      if (paramContext == null) {
        return "";
      }
      String str1;
      com.tencent.beacon.d.a.d("getAndroidId error!", new Object[0]);
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        str1 = paramContext.toLowerCase();
        return str1;
      }
      catch (Throwable localThrowable2)
      {
        break label48;
      }
      localThrowable1 = localThrowable1;
      paramContext = str2;
    }
    label48:
    com.tencent.beacon.d.a.a(localThrowable1);
    return paramContext;
  }
  
  public static boolean d(String paramString)
  {
    int i = paramString.length();
    boolean bool = true;
    for (;;)
    {
      int j = i - 1;
      if (j < 0) {
        break;
      }
      int k = paramString.charAt(j);
      if (k >= 32)
      {
        i = j;
        if (k < 127) {}
      }
      else
      {
        bool = false;
        i = j;
      }
    }
    return bool;
  }
  
  public static String e()
  {
    String str = null;
    try
    {
      Object localObject = Build.class.getField("HARDWARE").get(null);
      if (localObject != null) {
        str = localObject.toString();
      }
      return str;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.d.a.c("getCpuProductorName error!", new Object[0]);
    }
    return null;
  }
  
  public static String e(Context paramContext)
  {
    String str = "";
    Object localObject;
    if (paramContext == null)
    {
      com.tencent.beacon.d.a.d("getMacAddress but context == null!", new Object[0]);
      localObject = "";
    }
    do
    {
      return localObject;
      localObject = str;
      try
      {
        if (Integer.valueOf(Build.VERSION.SDK).intValue() < 23)
        {
          localObject = str;
          paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();
          if (paramContext == null) {
            return "";
          }
          localObject = paramContext;
          return paramContext.toLowerCase();
        }
        localObject = str;
        arrayOfString = new String[2];
        arrayOfString[0] = "/sys/class/net/wlan0/address";
        arrayOfString[1] = "/sys/devices/virtual/net/wlan0/address";
        localObject = str;
        j = arrayOfString.length;
        i = 0;
        paramContext = "";
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          String[] arrayOfString;
          int j;
          int i;
          localObject = f(arrayOfString[i]).toString().trim();
          paramContext = (Context)localObject;
          if (paramContext != null)
          {
            localObject = paramContext;
            if (paramContext.length() > 0)
            {
              localObject = paramContext;
              paramContext = paramContext.toLowerCase();
              return paramContext;
            }
          }
          i += 1;
        }
        catch (Throwable localThrowable2)
        {
          break label165;
        }
        localThrowable1 = localThrowable1;
        paramContext = (Context)localObject;
      }
      localObject = paramContext;
    } while (i >= j);
    label165:
    com.tencent.beacon.d.a.a(localThrowable1);
    return paramContext;
  }
  
  public static Date e(String paramString)
  {
    if ((paramString == null) || (paramString.trim().length() <= 0)) {
      return null;
    }
    try
    {
      paramString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).parse(paramString);
      return paramString;
    }
    catch (ParseException paramString)
    {
      com.tencent.beacon.d.a.a(paramString);
    }
    return null;
  }
  
  public static String f()
  {
    try
    {
      Object localObject = new StatFs(Environment.getDataDirectory().getPath());
      long l1 = ((StatFs)localObject).getBlockSize();
      long l2 = ((StatFs)localObject).getBlockCount();
      localObject = l2 * l1 / 1024L / 1024L;
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.d.a.d("getDisplayMetrics error!", new Object[0]);
      com.tencent.beacon.d.a.a(localThrowable);
    }
    return null;
  }
  
  public static String f(Context paramContext)
  {
    if (paramContext == null)
    {
      com.tencent.beacon.d.a.d("getMacAddress but context == null!", new Object[0]);
      return "";
    }
    try
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getBSSID();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        com.tencent.beacon.d.a.a(paramContext);
        com.tencent.beacon.d.a.d("getMacAddress error!", new Object[0]);
        paramContext = "";
      }
    }
  }
  
  public static String f(String paramString)
  {
    String str2 = "";
    String str1 = str2;
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(paramString);
      str1 = str2;
      byte[] arrayOfByte = new byte[localFileInputStream.available()];
      str1 = str2;
      localFileInputStream.read(arrayOfByte);
      str1 = str2;
      str2 = EncodingUtils.getString(arrayOfByte, "UTF-8");
      str1 = str2;
      localFileInputStream.close();
      return str2;
    }
    catch (Exception localException)
    {
      com.tencent.beacon.d.a.d("Read file %s failed.", new Object[] { paramString });
    }
    return str1;
  }
  
  /* Error */
  public static String g()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: new 1048	java/io/FileReader
    //   6: dup
    //   7: ldc_w 1050
    //   10: invokespecial 1051	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   13: astore_3
    //   14: new 399	java/io/BufferedReader
    //   17: dup
    //   18: aload_3
    //   19: sipush 8192
    //   22: invokespecial 1054	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   25: astore_2
    //   26: aload_2
    //   27: astore 5
    //   29: aload_3
    //   30: astore 4
    //   32: aload_2
    //   33: invokevirtual 416	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   36: ldc_w 1056
    //   39: iconst_2
    //   40: invokevirtual 1060	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   43: iconst_1
    //   44: aaload
    //   45: invokevirtual 861	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   48: ldc_w 1062
    //   51: ldc 144
    //   53: invokevirtual 347	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   56: invokevirtual 327	java/lang/String:trim	()Ljava/lang/String;
    //   59: invokestatic 1066	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   62: ldc2_w 1021
    //   65: ldiv
    //   66: lstore_0
    //   67: lload_0
    //   68: invokestatic 1069	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   71: astore 4
    //   73: aload_2
    //   74: invokevirtual 419	java/io/BufferedReader:close	()V
    //   77: aload_3
    //   78: invokevirtual 1070	java/io/FileReader:close	()V
    //   81: aload 4
    //   83: astore_2
    //   84: aload_2
    //   85: areturn
    //   86: astore_2
    //   87: ldc_w 1072
    //   90: iconst_0
    //   91: anewarray 4	java/lang/Object
    //   94: invokestatic 58	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   97: aload_2
    //   98: invokestatic 268	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   101: aload 4
    //   103: areturn
    //   104: astore 6
    //   106: aconst_null
    //   107: astore_2
    //   108: aconst_null
    //   109: astore_3
    //   110: aload_2
    //   111: astore 5
    //   113: aload_3
    //   114: astore 4
    //   116: ldc_w 1072
    //   119: iconst_0
    //   120: anewarray 4	java/lang/Object
    //   123: invokestatic 58	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   126: aload_2
    //   127: astore 5
    //   129: aload_3
    //   130: astore 4
    //   132: aload 6
    //   134: invokestatic 268	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   137: aload_2
    //   138: ifnull +7 -> 145
    //   141: aload_2
    //   142: invokevirtual 419	java/io/BufferedReader:close	()V
    //   145: aload 7
    //   147: astore_2
    //   148: aload_3
    //   149: ifnull -65 -> 84
    //   152: aload_3
    //   153: invokevirtual 1070	java/io/FileReader:close	()V
    //   156: aconst_null
    //   157: areturn
    //   158: astore_2
    //   159: ldc_w 1072
    //   162: iconst_0
    //   163: anewarray 4	java/lang/Object
    //   166: invokestatic 58	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   169: aload_2
    //   170: invokestatic 268	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   173: aconst_null
    //   174: areturn
    //   175: astore_2
    //   176: aconst_null
    //   177: astore 5
    //   179: aconst_null
    //   180: astore_3
    //   181: aload 5
    //   183: ifnull +8 -> 191
    //   186: aload 5
    //   188: invokevirtual 419	java/io/BufferedReader:close	()V
    //   191: aload_3
    //   192: ifnull +7 -> 199
    //   195: aload_3
    //   196: invokevirtual 1070	java/io/FileReader:close	()V
    //   199: aload_2
    //   200: athrow
    //   201: astore_3
    //   202: ldc_w 1072
    //   205: iconst_0
    //   206: anewarray 4	java/lang/Object
    //   209: invokestatic 58	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   212: aload_3
    //   213: invokestatic 268	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   216: goto -17 -> 199
    //   219: astore_2
    //   220: aconst_null
    //   221: astore 5
    //   223: goto -42 -> 181
    //   226: astore_2
    //   227: aload 4
    //   229: astore_3
    //   230: goto -49 -> 181
    //   233: astore 6
    //   235: aconst_null
    //   236: astore_2
    //   237: goto -127 -> 110
    //   240: astore 6
    //   242: goto -132 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   66	2	0	l	long
    //   25	60	2	localObject1	Object
    //   86	12	2	localThrowable1	Throwable
    //   107	41	2	localObject2	Object
    //   158	12	2	localThrowable2	Throwable
    //   175	25	2	localObject3	Object
    //   219	1	2	localObject4	Object
    //   226	1	2	localObject5	Object
    //   236	1	2	localObject6	Object
    //   13	183	3	localFileReader	FileReader
    //   201	12	3	localThrowable3	Throwable
    //   229	1	3	localObject7	Object
    //   30	198	4	localObject8	Object
    //   27	195	5	localObject9	Object
    //   104	29	6	localThrowable4	Throwable
    //   233	1	6	localThrowable5	Throwable
    //   240	1	6	localThrowable6	Throwable
    //   1	145	7	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   73	81	86	java/lang/Throwable
    //   3	14	104	java/lang/Throwable
    //   141	145	158	java/lang/Throwable
    //   152	156	158	java/lang/Throwable
    //   3	14	175	finally
    //   186	191	201	java/lang/Throwable
    //   195	199	201	java/lang/Throwable
    //   14	26	219	finally
    //   32	67	226	finally
    //   116	126	226	finally
    //   132	137	226	finally
    //   14	26	233	java/lang/Throwable
    //   32	67	240	java/lang/Throwable
  }
  
  public static String g(Context paramContext)
  {
    if (paramContext == null)
    {
      com.tencent.beacon.d.a.d("getWifiSSID but context == null!", new Object[0]);
      return "";
    }
    try
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
      if (paramContext.getBSSID() != null)
      {
        paramContext = paramContext.getSSID();
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        com.tencent.beacon.d.a.a(paramContext);
        com.tencent.beacon.d.a.d("getWifiSSID error!", new Object[0]);
        paramContext = "";
      }
    }
  }
  
  public static String g(String paramString)
  {
    String str = h(paramString);
    paramString = str;
    if (str != null) {}
    try
    {
      paramString = str.substring(8, 24);
      return paramString;
    }
    catch (Exception paramString) {}
    return str;
  }
  
  public static long h()
  {
    if (Environment.getExternalStorageState().equals("mounted")) {}
    for (int i = 1; i == 0; i = 0) {
      return 0L;
    }
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      i = localStatFs.getBlockSize();
      long l = localStatFs.getBlockCount();
      l = i * l / 1024L / 1024L;
      return l;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.d.a.a(localThrowable);
    }
    return 0L;
  }
  
  public static DisplayMetrics h(Context paramContext)
  {
    if (paramContext == null)
    {
      com.tencent.beacon.d.a.d("getDisplayMetrics but context == null!", new Object[0]);
      return null;
    }
    try
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
      return localDisplayMetrics;
    }
    catch (Throwable paramContext)
    {
      com.tencent.beacon.d.a.d("getDisplayMetrics error!", new Object[0]);
      com.tencent.beacon.d.a.a(paramContext);
    }
    return null;
  }
  
  private static String h(String paramString)
  {
    int i = 0;
    try
    {
      Object localObject = MessageDigest.getInstance("MD5").digest(paramString.getBytes());
      StringBuffer localStringBuffer = new StringBuffer();
      int j = localObject.length;
      while (i < j)
      {
        int k = localObject[i] & 0xFF;
        if (k < 16) {
          localStringBuffer.append(0);
        }
        localStringBuffer.append(Integer.toHexString(k));
        i += 1;
      }
      localObject = localStringBuffer.toString();
      return localObject;
    }
    catch (Exception localException)
    {
      com.tencent.beacon.d.a.a(localException);
    }
    return paramString;
  }
  
  public static long i(Context paramContext)
  {
    if (paramContext == null)
    {
      com.tencent.beacon.d.a.d("getFreeMem but context == null!", new Object[0]);
      return -1L;
    }
    try
    {
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
      paramContext.getMemoryInfo(localMemoryInfo);
      long l = localMemoryInfo.availMem;
      return l;
    }
    catch (Throwable paramContext)
    {
      com.tencent.beacon.d.a.d("getFreeMem error!", new Object[0]);
      com.tencent.beacon.d.a.a(paramContext);
    }
    return -1L;
  }
  
  public static String i()
  {
    try
    {
      String str = Locale.getDefault().getCountry();
      return str;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.d.a.d("getCountry error!", new Object[0]);
      com.tencent.beacon.d.a.a(localThrowable);
    }
    return null;
  }
  
  public static String j()
  {
    try
    {
      String str = Locale.getDefault().getLanguage();
      return str;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.d.a.d("getLanguage error!", new Object[0]);
      com.tencent.beacon.d.a.a(localThrowable);
    }
    return null;
  }
  
  public static String j(Context paramContext)
  {
    if (paramContext == null)
    {
      com.tencent.beacon.d.a.d("getSensor but context == null!", new Object[0]);
      return null;
    }
    com.tencent.beacon.d.a.a("getSensor start", new Object[0]);
    Object localObject2 = "X";
    StringBuffer localStringBuffer = new StringBuffer();
    if (Integer.parseInt(Build.VERSION.SDK) >= 10) {}
    for (;;)
    {
      int i;
      try
      {
        localClass = Class.forName("android.hardware.Camera");
        j = ((Integer)localClass.getMethod("getNumberOfCameras", new Class[0]).invoke(localClass, new Object[0])).intValue();
        if (j == 0)
        {
          localObject1 = "N";
          localObject2 = "N";
        }
      }
      catch (Throwable localThrowable1)
      {
        Class localClass;
        int j;
        Object localObject3;
        Object localObject6;
        Object localObject7;
        int k;
        Field localField1;
        Field localField2;
        Field localField3;
        int m;
        int n;
        localObject1 = "X";
        paramContext = "X";
        com.tencent.beacon.d.a.d("getSensor error!", new Object[0]);
        com.tencent.beacon.d.a.a(localThrowable1);
        Object localObject5 = localObject1;
        localObject1 = "X";
        Context localContext = paramContext;
        continue;
        continue;
        localObject1 = "X";
        localObject2 = "X";
        continue;
      }
      try
      {
        localObject3 = (SensorManager)paramContext.getSystemService("sensor");
        if (((SensorManager)localObject3).getDefaultSensor(9) != null) {
          paramContext = "Y";
        }
      }
      catch (Throwable localThrowable3)
      {
        localObject5 = "X";
        paramContext = (Context)localObject1;
        localObject1 = localObject5;
        continue;
      }
      try
      {
        if (((SensorManager)localObject3).getDefaultSensor(4) != null)
        {
          localObject6 = "Y";
          localObject3 = localObject1;
          localObject5 = paramContext;
          localObject1 = localObject6;
          localStringBuffer.append((String)localObject3).append((String)localObject2).append((String)localObject5).append((String)localObject1);
          return localStringBuffer.toString();
          localObject3 = Class.forName("android.hardware.Camera$CameraInfo");
          localObject7 = ((Class)localObject3).newInstance();
          localObject6 = localClass.getMethods();
          localObject1 = null;
          k = localObject6.length;
          i = 0;
          localObject5 = localObject1;
          if (i < k)
          {
            localObject5 = localObject6[i];
            if (!((Method)localObject5).getName().equals("getCameraInfo")) {
              break label577;
            }
          }
          localField1 = ((Class)localObject3).getField("facing");
          localField2 = ((Class)localObject3).getField("CAMERA_FACING_BACK");
          localField3 = ((Class)localObject3).getField("CAMERA_FACING_FRONT");
          if (localObject5 == null) {
            continue;
          }
          localObject2 = "X";
          localObject1 = "X";
          i = 0;
          if (i >= j) {
            continue;
          }
        }
      }
      catch (Throwable localThrowable4)
      {
        localObject4 = localObject1;
        localObject1 = paramContext;
        paramContext = (Context)localObject4;
        localObject4 = localThrowable4;
        continue;
      }
      try
      {
        ((Method)localObject5).invoke(localClass, new Object[] { Integer.valueOf(i), localObject7 });
        k = localField1.getInt(localObject7);
        m = localField2.getInt(localObject7);
        n = localField3.getInt(localObject7);
        if (k == m)
        {
          localObject1 = "Y";
          localObject3 = localObject1;
          if (j == 1)
          {
            localObject2 = "N";
            localObject3 = localObject1;
          }
        }
        else
        {
          localObject3 = localObject1;
          if (k == n)
          {
            localObject6 = "Y";
            localObject2 = localObject6;
            localObject3 = localObject1;
            if (j == 1)
            {
              localObject3 = "N";
              localObject2 = localObject6;
            }
          }
        }
      }
      catch (Throwable localThrowable2)
      {
        paramContext = (Context)localObject1;
        localObject1 = "X";
        continue;
      }
      paramContext = "N";
      continue;
      localObject5 = "N";
      localObject3 = localObject1;
      Object localObject1 = localObject5;
      localObject5 = paramContext;
      continue;
      localObject1 = "X";
      localObject2 = "X";
      String str = "X";
      Object localObject4 = "X";
      continue;
      i += 1;
      localObject1 = localObject4;
      continue;
      label577:
      i += 1;
    }
  }
  
  public static String k()
  {
    try
    {
      String str = Build.BRAND;
      return str;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.d.a.d("getBrand error!", new Object[0]);
      com.tencent.beacon.d.a.a(localThrowable);
    }
    return null;
  }
  
  public static String k(Context paramContext)
  {
    if (a != null)
    {
      f localf = a;
      return l(paramContext);
    }
    return "unknown";
  }
  
  public static String l()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      BufferedReader localBufferedReader = new BufferedReader(new FileReader(new File("/sys/block/mmcblk0/device/type")));
      String str = localBufferedReader.readLine();
      localBufferedReader.close();
      localStringBuilder.append(str);
      label48:
      localStringBuilder.append(",");
      try
      {
        localBufferedReader = new BufferedReader(new FileReader(new File("/sys/block/mmcblk0/device/name")));
        str = localBufferedReader.readLine();
        localBufferedReader.close();
        localStringBuilder.append(str);
        label96:
        localStringBuilder.append(",");
        try
        {
          localBufferedReader = new BufferedReader(new FileReader(new File("/sys/block/mmcblk0/device/cid")));
          str = localBufferedReader.readLine();
          localBufferedReader.close();
          localStringBuilder.append(str);
          label144:
          return localStringBuilder.toString();
        }
        catch (Exception localException1)
        {
          break label144;
        }
      }
      catch (Exception localException2)
      {
        break label96;
      }
    }
    catch (Exception localException3)
    {
      break label48;
    }
  }
  
  public static String l(Context paramContext)
  {
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (localNetworkInfo == null) {
        return "unknown";
      }
      if (localNetworkInfo.getType() == 1)
      {
        paramContext = "wifi";
      }
      else if (localNetworkInfo.getType() == 0)
      {
        paramContext = (TelephonyManager)paramContext.getSystemService("phone");
        if (paramContext != null) {
          switch (paramContext.getNetworkType())
          {
          case 15: 
            paramContext = "HSPA+";
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      com.tencent.beacon.d.a.a(paramContext);
      paramContext = "unknown";
    }
    for (;;)
    {
      return paramContext;
      paramContext = "unknown";
      continue;
      paramContext = "GPRS";
      continue;
      paramContext = "EDGE";
      continue;
      paramContext = "UMTS";
      continue;
      paramContext = "HSDPA";
      continue;
      paramContext = "HSUPA";
      continue;
      paramContext = "HSPA";
      continue;
      paramContext = "CDMA";
      continue;
      paramContext = "EVDO_0";
      continue;
      paramContext = "EVDO_A";
      continue;
      paramContext = "1xRTT";
      continue;
      paramContext = "iDen";
      continue;
      paramContext = "EVDO_B";
      continue;
      paramContext = "LTE";
      continue;
      paramContext = "eHRPD";
    }
  }
  
  public static long m()
  {
    try
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
      long l = localSimpleDateFormat.parse(localSimpleDateFormat.format(new Date())).getTime();
      return l;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.d.a.a(localThrowable);
    }
    return -1L;
  }
  
  public static List<com.tencent.beacon.a.a.f> m(Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      return null;
      localObject = com.tencent.beacon.a.a.a.a(paramContext, new int[] { 6 }, -1, -1, 5, 0L);
    } while ((localObject == null) || (((List)localObject).size() <= 0));
    paramContext = new ArrayList(((List)localObject).size());
    Object localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.beacon.a.a.a locala = (com.tencent.beacon.a.a.a)((Iterator)localObject).next();
      try
      {
        com.tencent.beacon.a.a.f localf = (com.tencent.beacon.a.a.f)com.tencent.beacon.a.a.f.class.cast(b(locala.b()));
        if (localf != null)
        {
          localf.a(locala.a());
          paramContext.add(localf);
        }
      }
      catch (Throwable localThrowable)
      {
        com.tencent.beacon.d.a.a(localThrowable);
        com.tencent.beacon.d.a.d("netconsume error %s", new Object[] { localThrowable.toString() });
      }
    }
    return paramContext;
  }
  
  public static String n()
  {
    try
    {
      String str = new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(new Date());
      return str;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.d.a.a(localThrowable);
    }
    return "";
  }
  
  public static List<com.tencent.beacon.a.a.f> n(Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      return null;
      localObject = com.tencent.beacon.a.a.a.a(paramContext, new int[] { 7 }, -1, -1, 5, 0L);
    } while ((localObject == null) || (((List)localObject).size() <= 0));
    paramContext = new ArrayList(((List)localObject).size());
    Object localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.beacon.a.a.a locala = (com.tencent.beacon.a.a.a)((Iterator)localObject).next();
      try
      {
        com.tencent.beacon.a.a.f localf = (com.tencent.beacon.a.a.f)com.tencent.beacon.a.a.f.class.cast(b(locala.b()));
        localf.a(locala.a());
        paramContext.add(localf);
      }
      catch (Throwable localThrowable)
      {
        com.tencent.beacon.d.a.a(localThrowable);
        com.tencent.beacon.d.a.d(" netconsume error:%s", new Object[] { localThrowable.toString() });
      }
    }
    return paramContext;
  }
  
  /* Error */
  public static com.tencent.beacon.a.b.g o(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_2
    //   4: aconst_null
    //   5: astore 5
    //   7: aconst_null
    //   8: astore 6
    //   10: getstatic 484	com/tencent/beacon/a/a/e:a	Ljava/lang/Object;
    //   13: astore 7
    //   15: aload 7
    //   17: monitorenter
    //   18: aload_0
    //   19: ifnonnull +18 -> 37
    //   22: ldc_w 1287
    //   25: iconst_0
    //   26: anewarray 4	java/lang/Object
    //   29: invokestatic 310	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   32: aload 7
    //   34: monitorexit
    //   35: aconst_null
    //   36: areturn
    //   37: aload_0
    //   38: invokestatic 489	com/tencent/beacon/a/a/e:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/a/e;
    //   41: invokevirtual 493	com/tencent/beacon/a/a/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   44: astore_0
    //   45: aload_0
    //   46: ifnonnull +18 -> 64
    //   49: ldc_w 789
    //   52: iconst_0
    //   53: anewarray 4	java/lang/Object
    //   56: invokestatic 310	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   59: aload 7
    //   61: monitorexit
    //   62: aconst_null
    //   63: areturn
    //   64: aload_0
    //   65: ldc_w 497
    //   68: aconst_null
    //   69: getstatic 994	java/util/Locale:US	Ljava/util/Locale;
    //   72: ldc_w 1289
    //   75: iconst_2
    //   76: anewarray 4	java/lang/Object
    //   79: dup
    //   80: iconst_0
    //   81: ldc_w 517
    //   84: aastore
    //   85: dup
    //   86: iconst_1
    //   87: bipush 101
    //   89: invokestatic 524	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   92: aastore
    //   93: invokestatic 1292	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   96: aconst_null
    //   97: aconst_null
    //   98: aconst_null
    //   99: aconst_null
    //   100: invokevirtual 793	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   103: astore_0
    //   104: aload_0
    //   105: astore_2
    //   106: aload_1
    //   107: astore_0
    //   108: aload_2
    //   109: ifnull +96 -> 205
    //   112: aload_1
    //   113: astore_0
    //   114: aload_2
    //   115: astore_3
    //   116: aload 5
    //   118: astore 4
    //   120: aload_2
    //   121: invokeinterface 798 1 0
    //   126: ifeq +79 -> 205
    //   129: aload 6
    //   131: astore_1
    //   132: aload_2
    //   133: ifnull +39 -> 172
    //   136: aload 6
    //   138: astore_1
    //   139: aload_2
    //   140: astore_3
    //   141: aload 5
    //   143: astore 4
    //   145: aload_2
    //   146: invokeinterface 1295 1 0
    //   151: ifne +21 -> 172
    //   154: aload_2
    //   155: astore_3
    //   156: aload 5
    //   158: astore 4
    //   160: aload_2
    //   161: invokeinterface 1298 1 0
    //   166: ifeq +73 -> 239
    //   169: aload 6
    //   171: astore_1
    //   172: aload_1
    //   173: astore_0
    //   174: aload_1
    //   175: ifnull +30 -> 205
    //   178: aload_2
    //   179: astore_3
    //   180: aload_1
    //   181: astore 4
    //   183: ldc_w 1300
    //   186: iconst_1
    //   187: anewarray 4	java/lang/Object
    //   190: dup
    //   191: iconst_0
    //   192: aload_1
    //   193: invokevirtual 519	com/tencent/beacon/a/b/g:b	()I
    //   196: invokestatic 524	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   199: aastore
    //   200: invokestatic 1302	com/tencent/beacon/d/a:g	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   203: aload_1
    //   204: astore_0
    //   205: aload_0
    //   206: astore_1
    //   207: aload_2
    //   208: ifnull +210 -> 418
    //   211: aload_0
    //   212: astore_1
    //   213: aload_2
    //   214: invokeinterface 811 1 0
    //   219: ifne +199 -> 418
    //   222: aload_2
    //   223: invokeinterface 812 1 0
    //   228: aload 7
    //   230: monitorexit
    //   231: aload_0
    //   232: areturn
    //   233: astore_0
    //   234: aload 7
    //   236: monitorexit
    //   237: aload_0
    //   238: athrow
    //   239: aload_2
    //   240: astore_3
    //   241: aload 5
    //   243: astore 4
    //   245: ldc_w 1304
    //   248: iconst_0
    //   249: anewarray 4	java/lang/Object
    //   252: invokestatic 98	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   255: aload_2
    //   256: astore_3
    //   257: aload 5
    //   259: astore 4
    //   261: new 511	com/tencent/beacon/a/b/g
    //   264: dup
    //   265: invokespecial 1305	com/tencent/beacon/a/b/g:<init>	()V
    //   268: astore_1
    //   269: aload_2
    //   270: astore_3
    //   271: aload 5
    //   273: astore 4
    //   275: aload_1
    //   276: aload_2
    //   277: aload_2
    //   278: ldc_w 499
    //   281: invokeinterface 801 2 0
    //   286: invokeinterface 808 2 0
    //   291: invokevirtual 538	com/tencent/beacon/a/b/g:a	(J)V
    //   294: aload_2
    //   295: astore_3
    //   296: aload 5
    //   298: astore 4
    //   300: aload_1
    //   301: aload_2
    //   302: aload_2
    //   303: ldc_w 517
    //   306: invokeinterface 801 2 0
    //   311: invokeinterface 1308 2 0
    //   316: invokevirtual 1310	com/tencent/beacon/a/b/g:a	(I)V
    //   319: aload_2
    //   320: astore_3
    //   321: aload 5
    //   323: astore 4
    //   325: aload_1
    //   326: aload_2
    //   327: aload_2
    //   328: ldc_w 529
    //   331: invokeinterface 801 2 0
    //   336: invokeinterface 1314 2 0
    //   341: invokevirtual 1316	com/tencent/beacon/a/b/g:a	([B)V
    //   344: goto -172 -> 172
    //   347: astore_1
    //   348: aconst_null
    //   349: astore_3
    //   350: aload_2
    //   351: astore_0
    //   352: aload_3
    //   353: astore_2
    //   354: aload_2
    //   355: astore_3
    //   356: aload_1
    //   357: invokestatic 268	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   360: aload_0
    //   361: astore_1
    //   362: aload_2
    //   363: ifnull +55 -> 418
    //   366: aload_0
    //   367: astore_1
    //   368: aload_2
    //   369: invokeinterface 811 1 0
    //   374: ifne +44 -> 418
    //   377: aload_2
    //   378: invokeinterface 812 1 0
    //   383: goto -155 -> 228
    //   386: aload_3
    //   387: ifnull +18 -> 405
    //   390: aload_3
    //   391: invokeinterface 811 1 0
    //   396: ifne +9 -> 405
    //   399: aload_3
    //   400: invokeinterface 812 1 0
    //   405: aload_0
    //   406: athrow
    //   407: astore_0
    //   408: goto -22 -> 386
    //   411: astore_1
    //   412: aload 4
    //   414: astore_0
    //   415: goto -61 -> 354
    //   418: aload_1
    //   419: astore_0
    //   420: goto -192 -> 228
    //   423: astore_0
    //   424: aconst_null
    //   425: astore_3
    //   426: goto -40 -> 386
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	429	0	paramContext	Context
    //   1	325	1	localObject1	Object
    //   347	10	1	localThrowable1	Throwable
    //   361	7	1	localContext	Context
    //   411	8	1	localThrowable2	Throwable
    //   3	375	2	localObject2	Object
    //   115	311	3	localObject3	Object
    //   118	295	4	localObject4	Object
    //   5	317	5	localObject5	Object
    //   8	162	6	localObject6	Object
    //   13	222	7	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   22	35	233	finally
    //   59	62	233	finally
    //   213	228	233	finally
    //   228	231	233	finally
    //   368	383	233	finally
    //   390	405	233	finally
    //   405	407	233	finally
    //   37	45	347	java/lang/Throwable
    //   49	59	347	java/lang/Throwable
    //   64	104	347	java/lang/Throwable
    //   120	129	407	finally
    //   145	154	407	finally
    //   160	169	407	finally
    //   183	203	407	finally
    //   245	255	407	finally
    //   261	269	407	finally
    //   275	294	407	finally
    //   300	319	407	finally
    //   325	344	407	finally
    //   356	360	407	finally
    //   120	129	411	java/lang/Throwable
    //   145	154	411	java/lang/Throwable
    //   160	169	411	java/lang/Throwable
    //   183	203	411	java/lang/Throwable
    //   245	255	411	java/lang/Throwable
    //   261	269	411	java/lang/Throwable
    //   275	294	411	java/lang/Throwable
    //   300	319	411	java/lang/Throwable
    //   325	344	411	java/lang/Throwable
    //   37	45	423	finally
    //   49	59	423	finally
    //   64	104	423	finally
  }
  
  /* Error */
  public static int p(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 484	com/tencent/beacon/a/a/e:a	Ljava/lang/Object;
    //   3: astore_2
    //   4: aload_2
    //   5: monitorenter
    //   6: aload_0
    //   7: ifnonnull +17 -> 24
    //   10: ldc_w 1319
    //   13: iconst_0
    //   14: anewarray 4	java/lang/Object
    //   17: invokestatic 310	com/tencent/beacon/d/a:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   20: aload_2
    //   21: monitorexit
    //   22: iconst_0
    //   23: ireturn
    //   24: aload_0
    //   25: invokestatic 489	com/tencent/beacon/a/a/e:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/a/e;
    //   28: invokevirtual 493	com/tencent/beacon/a/a/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   31: astore_0
    //   32: aload_0
    //   33: ifnonnull +22 -> 55
    //   36: ldc_w 1321
    //   39: iconst_0
    //   40: anewarray 4	java/lang/Object
    //   43: invokestatic 58	com/tencent/beacon/d/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   46: aload_2
    //   47: monitorexit
    //   48: iconst_0
    //   49: ireturn
    //   50: astore_0
    //   51: aload_2
    //   52: monitorexit
    //   53: aload_0
    //   54: athrow
    //   55: aload_0
    //   56: ldc_w 497
    //   59: ldc_w 1323
    //   62: iconst_2
    //   63: anewarray 4	java/lang/Object
    //   66: dup
    //   67: iconst_0
    //   68: ldc_w 517
    //   71: aastore
    //   72: dup
    //   73: iconst_1
    //   74: bipush 101
    //   76: invokestatic 524	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   79: aastore
    //   80: invokestatic 1326	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   83: aconst_null
    //   84: invokevirtual 553	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   87: istore_1
    //   88: ldc_w 1328
    //   91: iconst_2
    //   92: anewarray 4	java/lang/Object
    //   95: dup
    //   96: iconst_0
    //   97: bipush 101
    //   99: invokestatic 524	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   102: aastore
    //   103: dup
    //   104: iconst_1
    //   105: iload_1
    //   106: invokestatic 524	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   109: aastore
    //   110: invokestatic 1302	com/tencent/beacon/d/a:g	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   113: aload_2
    //   114: monitorexit
    //   115: iload_1
    //   116: ireturn
    //   117: aload_0
    //   118: invokestatic 268	com/tencent/beacon/d/a:a	(Ljava/lang/Throwable;)V
    //   121: goto -8 -> 113
    //   124: astore_0
    //   125: goto -8 -> 117
    //   128: astore_0
    //   129: iconst_0
    //   130: istore_1
    //   131: goto -14 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	paramContext	Context
    //   87	44	1	i	int
    //   3	111	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   10	22	50	finally
    //   24	32	50	finally
    //   36	46	50	finally
    //   46	48	50	finally
    //   55	88	50	finally
    //   88	113	50	finally
    //   113	115	50	finally
    //   117	121	50	finally
    //   88	113	124	java/lang/Throwable
    //   24	32	128	java/lang/Throwable
    //   36	46	128	java/lang/Throwable
    //   55	88	128	java/lang/Throwable
  }
  
  public static int q(Context paramContext)
  {
    com.tencent.beacon.d.a.a(" RecordDAO.countRecordNum() start", new Object[0]);
    if (paramContext == null)
    {
      com.tencent.beacon.d.a.d(" countRecordNum() have null args!", new Object[0]);
      return -1;
    }
    return com.tencent.beacon.a.a.a.b(paramContext, new int[] { 1, 2, 3, 4 });
  }
  
  public static String r(Context paramContext)
  {
    try
    {
      String str = com.tencent.beacon.event.d.a(paramContext).e();
      paramContext = "";
      d locald = d.m();
      if (locald != null) {
        paramContext = locald.j();
      }
      int i = (int)(Math.random() * 2147483647.0D);
      paramContext = g(paramContext + "_" + str + "_" + new Date().getTime() + "_" + i);
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public static boolean s(Context paramContext)
  {
    paramContext = v(paramContext);
    return (paramContext != null) && (paramContext.getType() == 1);
  }
  
  public static boolean t(Context paramContext)
  {
    paramContext = v(paramContext);
    return (paramContext != null) && (paramContext.isConnected());
  }
  
  public static String u(Context paramContext)
  {
    paramContext = v(paramContext);
    if (paramContext == null) {
      paramContext = "unknown";
    }
    String str;
    do
    {
      do
      {
        return paramContext;
        if (paramContext.getType() == 1) {
          return "wifi";
        }
        str = paramContext.getExtraInfo();
        paramContext = str;
      } while (str == null);
      paramContext = str;
    } while (str.length() <= 64);
    return str.substring(0, 64);
  }
  
  private static NetworkInfo v(Context paramContext)
  {
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null) {
        return null;
      }
      paramContext = paramContext.getActiveNetworkInfo();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      com.tencent.beacon.d.a.a(paramContext);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.f
 * JD-Core Version:    0.7.0.1
 */