package com.tencent.beacon.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Base64;
import com.tencent.beacon.a.a.f;
import com.tencent.beacon.a.b.g;
import com.tencent.beacon.a.b.j;
import com.tencent.beacon.a.c.e;
import com.tencent.beacon.a.f.h;
import com.tencent.beacon.a.f.i;
import com.tencent.beacon.c.c;
import com.tencent.beacon.event.UserAction;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
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
import java.util.HashMap;
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

public class a
{
  protected Context a;
  private boolean b = true;
  
  public a(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public static int a(Context paramContext, com.tencent.beacon.e.b[] paramArrayOfb)
  {
    int j = 0;
    int i;
    if ((paramContext == null) || (paramArrayOfb == null) || (paramArrayOfb.length <= 0)) {
      i = -1;
    }
    ArrayList localArrayList;
    do
    {
      return i;
      localArrayList = new ArrayList(paramArrayOfb.length);
      int k = paramArrayOfb.length;
      i = 0;
      while (i < k)
      {
        com.tencent.beacon.e.b localb = paramArrayOfb[i];
        Object localObject = a(localb);
        if (localObject != null)
        {
          localObject = new com.tencent.beacon.a.a.a.a(6, 0, 0L, (byte[])localObject);
          ((com.tencent.beacon.a.a.a.a)localObject).a = localb.a();
          localArrayList.add(localObject);
        }
        i += 1;
      }
      i = j;
    } while (localArrayList.size() <= 0);
    if (com.tencent.beacon.a.a.a.a.b(paramContext, localArrayList)) {
      return localArrayList.size();
    }
    return -1;
  }
  
  public static int a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    int j = paramInt1;
    if (paramString != null) {}
    try
    {
      i = Integer.valueOf(paramString).intValue();
      j = paramInt1;
      if (i >= paramInt2)
      {
        j = paramInt1;
        if (i <= paramInt3) {
          j = i;
        }
      }
      return j;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        int i = paramInt1;
      }
    }
    catch (Throwable paramString)
    {
      com.tencent.beacon.a.g.a.a(paramString);
    }
    return paramInt1;
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
      com.tencent.beacon.a.g.a.d("[core] ref get %s.%s failed.", new Object[] { paramString1, paramString2 });
    }
    return -1;
  }
  
  public static g a(Context paramContext, String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramString == null) {
      return null;
    }
    com.tencent.beacon.a.c.b localb = com.tencent.beacon.a.c.b.a(UserAction.mContext);
    if (localb == null)
    {
      com.tencent.beacon.a.g.a.d("[event] BeaconInfo is null!", new Object[0]);
      return null;
    }
    String str3 = UserAction.getUserID();
    long l1 = localb.j();
    long l2 = new Date().getTime();
    String str2 = localb.i();
    String str1 = i(paramContext);
    if (str1 == null) {
      str1 = "null";
    }
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      if (paramMap != null) {
        localHashMap.putAll(paramMap);
      }
      int j = 0;
      int i = j;
      if (com.tencent.beacon.a.b.d.a().i())
      {
        i = j;
        if (!paramString.startsWith("rqd_")) {
          i = 1;
        }
      }
      paramMap = com.tencent.beacon.a.c.d.a(paramContext);
      if (i == 0)
      {
        localHashMap.put("A1", str3);
        str3 = UserAction.getQQ();
        if ((str3 != null) && (!str3.equals(""))) {
          localHashMap.put("QQ", str3);
        }
        localHashMap.put("A2", paramMap.a());
        localHashMap.put("A4", paramMap.c());
        localHashMap.put("A6", paramMap.b());
        localHashMap.put("A7", paramMap.d());
        localHashMap.put("A3", paramMap.f());
        localHashMap.put("A23", localb.b());
        localHashMap.put("A31", paramMap.e());
        localHashMap.put("A67", com.tencent.beacon.a.c.a.i(paramContext));
        localHashMap.put("A76", com.tencent.beacon.a.c.a.a());
        if (!localHashMap.containsKey("A95")) {
          localHashMap.put("A95", com.tencent.beacon.a.c.a.d(paramContext));
        }
        if (!paramBoolean2) {
          break label573;
        }
      }
      label573:
      for (paramMap = "Y";; paramMap = "N")
      {
        localHashMap.put("A99", paramMap);
        paramContext = h.a(paramContext).c();
        if ((paramContext != null) && (paramContext.size() > 0))
        {
          paramContext = ((i)paramContext.get(0)).a_(paramString);
          if (paramContext != null) {
            localHashMap.put("A100", paramContext);
          }
        }
        localHashMap.put("A19", str1);
        localHashMap.put("A28", str2);
        localHashMap.put("A25", String.valueOf(paramBoolean1));
        localHashMap.put("A26", String.valueOf(paramLong1));
        localHashMap.put("A27", String.valueOf(paramLong2));
        paramContext = new g();
        paramContext.b(paramString);
        paramContext.b(l2 + l1);
        paramContext.a("UA");
        paramContext.a(localHashMap);
        paramContext.a(paramBoolean3);
        return paramContext;
      }
    }
  }
  
  public static com.tencent.beacon.a.d.a.b a(int paramInt1, com.tencent.beacon.a.c.b paramb, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    if (paramb == null)
    {
      com.tencent.beacon.a.g.a.d("error no com info! ", new Object[0]);
      return null;
    }
    for (;;)
    {
      try
      {
        com.tencent.beacon.a.d.a.b localb = new com.tencent.beacon.a.d.a.b();
        localb.j = paramb.f();
        localb.k = paramb.g();
        localb.a = paramb.h();
        localb.b = paramb.a();
        localb.c = paramb.c();
        localb.d = paramb.d();
        localb.e = paramb.e();
        localb.l = "";
        if (paramInt1 != 100) {
          break label569;
        }
        HashMap localHashMap = new HashMap();
        localHashMap.put("A1", UserAction.getUserID());
        com.tencent.beacon.a.c.d locald = com.tencent.beacon.a.c.d.a(paramb.k());
        localHashMap.put("A2", locald.a());
        localHashMap.put("A4", locald.c());
        localHashMap.put("A6", locald.b());
        localHashMap.put("A7", locald.d());
        localHashMap.put("A3", locald.f());
        localHashMap.put("A23", paramb.b());
        localHashMap.put("A31", locald.e());
        e.a(paramb.k());
        localHashMap.put("A33", e.i(paramb.k()));
        if (com.tencent.beacon.a.c.a.g(paramb.k()))
        {
          localHashMap.put("A66", "F");
          localHashMap.put("A67", com.tencent.beacon.a.c.a.i(paramb.k()));
          localHashMap.put("A68", com.tencent.beacon.a.c.a.h(paramb.k()));
          if (com.tencent.beacon.a.c.a.a)
          {
            paramb = "Y";
            localHashMap.put("A85", paramb);
            localb.l = a(localHashMap);
            break label569;
            localb.l = a(UserAction.getAdditionalInfo());
            localb.f = paramInt1;
            localb.h = ((byte)paramInt3);
            localb.i = ((byte)paramInt2);
            paramb = paramArrayOfByte;
            if (paramArrayOfByte == null) {
              paramb = "".getBytes();
            }
            localb.g = paramb;
            return localb;
          }
        }
        else
        {
          localHashMap.put("A66", "B");
          continue;
        }
        paramb = "N";
      }
      catch (Throwable paramb)
      {
        com.tencent.beacon.a.g.a.a(paramb);
        return null;
      }
      continue;
      label569:
      if ((paramInt1 != 4) && (paramInt1 != 2)) {
        if (paramInt1 != 1) {}
      }
    }
  }
  
  public static com.tencent.beacon.a.d.b.a a(g paramg)
  {
    if ((paramg == null) || (!"UA".equals(paramg.b()))) {
      return null;
    }
    Map localMap = paramg.e();
    if (localMap == null) {
      return null;
    }
    try
    {
      com.tencent.beacon.a.d.b.a locala = new com.tencent.beacon.a.d.b.a();
      String str1 = (String)localMap.get("A19");
      String str2 = (String)localMap.get("A28");
      if (str1 != null) {
        locala.a = str1;
      }
      locala.c = paramg.d();
      locala.h = paramg.c();
      if (str2 != null) {
        locala.b = str2;
      }
      paramg = (String)localMap.get("A26");
      if (paramg == null)
      {
        l = 0L;
        locala.f = l;
        locala.d = Boolean.parseBoolean((String)localMap.get("A25"));
        paramg = (String)localMap.get("A27");
        if (paramg != null) {
          break label249;
        }
      }
      label249:
      for (long l = 0L;; l = Long.parseLong(paramg))
      {
        locala.e = l;
        localMap.remove("A19");
        localMap.remove("A28");
        localMap.remove("A26");
        localMap.remove("A25");
        localMap.remove("A27");
        locala.g = a(localMap);
        return locala;
        l = Long.parseLong(paramg);
        break;
      }
      return null;
    }
    catch (Throwable paramg)
    {
      com.tencent.beacon.a.g.a.a(paramg);
      com.tencent.beacon.a.g.a.d(paramg.getMessage(), new Object[0]);
    }
  }
  
  public static Object a(String paramString1, String paramString2, Class[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    try
    {
      paramArrayOfClass = Class.forName(paramString1).getDeclaredMethod(paramString2, paramArrayOfClass);
      paramArrayOfClass.setAccessible(true);
      paramArrayOfClass = paramArrayOfClass.invoke(null, paramArrayOfObject);
      return paramArrayOfClass;
    }
    catch (Exception paramArrayOfClass)
    {
      com.tencent.beacon.a.g.a.d("[core] ref call %s#%s failed.", new Object[] { paramString1, paramString2 });
    }
    return null;
  }
  
  private static String a(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return "";
    }
    Object localObject = paramMap.keySet();
    if (localObject == null) {
      return "";
    }
    if (((Set)localObject).size() > 50) {
      com.tencent.beacon.a.g.a.c("[core] map size should <= 50!", new Object[0]);
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
          break label310;
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
        com.tencent.beacon.a.g.a.c("[core] '%s' should be ASCII code in 32-126!", new Object[] { str2 });
        break;
        label310:
        localObject = str1;
        if (str1.length() > 1024) {
          localObject = str1.substring(0, 1024);
        }
      }
    }
    paramMap = "";
    if (localStringBuffer.length() > 0) {
      paramMap = localStringBuffer.substring(1);
    }
    localStringBuffer.setLength(0);
    return paramMap;
  }
  
  public static String a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    if (paramBoolean1)
    {
      if ((paramString != null) && (!"".equals(paramString))) {
        break label154;
      }
      if (paramBoolean2) {
        paramString = "http://oth.eve.mdt.qq.com:8080/analytics/upload";
      }
    }
    label146:
    label154:
    for (;;)
    {
      if (paramBoolean3) {
        paramString = "http://183.36.108.226:8080/analytics/upload";
      }
      return paramString;
      paramString = "http://oth.str.mdt.qq.com:8080/analytics/upload";
      continue;
      if ((paramString == null) || ("".equals(paramString)))
      {
        paramString = "";
        label58:
        if (paramString != null)
        {
          str = paramString;
          if (!"".equals(paramString)) {}
        }
        else
        {
          if (!paramBoolean2) {
            break label146;
          }
        }
      }
      for (String str = "oth.eve.mdt.qq.com";; str = "oth.str.mdt.qq.com")
      {
        paramString = str;
        if (!paramBoolean3) {
          break;
        }
        return "183.36.108.226";
        int i = paramString.indexOf("http://");
        if (i == -1) {
          break label58;
        }
        int j = paramString.indexOf(":", "http://".length());
        paramString = paramString.substring("http://".length() + i, j);
        break label58;
      }
    }
  }
  
  /* Error */
  public static ArrayList<String> a(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 21	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 552	java/util/ArrayList:<init>	()V
    //   9: astore 4
    //   11: invokestatic 558	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   14: aload_0
    //   15: invokevirtual 562	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   18: astore_0
    //   19: new 564	java/io/BufferedReader
    //   22: dup
    //   23: new 566	java/io/InputStreamReader
    //   26: dup
    //   27: aload_0
    //   28: invokevirtual 572	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   31: invokespecial 575	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   34: invokespecial 578	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   37: astore_1
    //   38: aload_1
    //   39: invokevirtual 581	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   42: astore_2
    //   43: aload_2
    //   44: ifnull +44 -> 88
    //   47: aload 4
    //   49: aload_2
    //   50: invokevirtual 44	java/util/ArrayList:add	(Ljava/lang/Object;)Z
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
    //   67: invokestatic 70	com/tencent/beacon/a/g/a:a	(Ljava/lang/Throwable;)V
    //   70: aload_1
    //   71: ifnull +7 -> 78
    //   74: aload_1
    //   75: invokevirtual 584	java/io/BufferedReader:close	()V
    //   78: aload_0
    //   79: ifnull +7 -> 86
    //   82: aload_0
    //   83: invokevirtual 584	java/io/BufferedReader:close	()V
    //   86: aconst_null
    //   87: areturn
    //   88: new 564	java/io/BufferedReader
    //   91: dup
    //   92: new 566	java/io/InputStreamReader
    //   95: dup
    //   96: aload_0
    //   97: invokevirtual 587	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   100: invokespecial 575	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   103: invokespecial 578	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   106: astore_0
    //   107: aload_0
    //   108: astore_3
    //   109: aload_1
    //   110: astore_2
    //   111: aload_0
    //   112: invokevirtual 581	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   115: astore 5
    //   117: aload 5
    //   119: ifnull +23 -> 142
    //   122: aload_0
    //   123: astore_3
    //   124: aload_1
    //   125: astore_2
    //   126: aload 4
    //   128: aload 5
    //   130: invokevirtual 44	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   133: pop
    //   134: goto -27 -> 107
    //   137: astore 4
    //   139: goto -78 -> 61
    //   142: aload_1
    //   143: invokevirtual 584	java/io/BufferedReader:close	()V
    //   146: aload_0
    //   147: invokevirtual 584	java/io/BufferedReader:close	()V
    //   150: aload 4
    //   152: areturn
    //   153: astore_0
    //   154: aload_0
    //   155: invokestatic 70	com/tencent/beacon/a/g/a:a	(Ljava/lang/Throwable;)V
    //   158: aload 4
    //   160: areturn
    //   161: astore_1
    //   162: aload_1
    //   163: invokestatic 70	com/tencent/beacon/a/g/a:a	(Ljava/lang/Throwable;)V
    //   166: goto -20 -> 146
    //   169: astore_1
    //   170: aload_1
    //   171: invokestatic 70	com/tencent/beacon/a/g/a:a	(Ljava/lang/Throwable;)V
    //   174: goto -96 -> 78
    //   177: astore_0
    //   178: aload_0
    //   179: invokestatic 70	com/tencent/beacon/a/g/a:a	(Ljava/lang/Throwable;)V
    //   182: goto -96 -> 86
    //   185: astore_0
    //   186: aconst_null
    //   187: astore_1
    //   188: aload_1
    //   189: ifnull +7 -> 196
    //   192: aload_1
    //   193: invokevirtual 584	java/io/BufferedReader:close	()V
    //   196: aload_3
    //   197: ifnull +7 -> 204
    //   200: aload_3
    //   201: invokevirtual 584	java/io/BufferedReader:close	()V
    //   204: aload_0
    //   205: athrow
    //   206: astore_1
    //   207: aload_1
    //   208: invokestatic 70	com/tencent/beacon/a/g/a:a	(Ljava/lang/Throwable;)V
    //   211: goto -15 -> 196
    //   214: astore_1
    //   215: aload_1
    //   216: invokestatic 70	com/tencent/beacon/a/g/a:a	(Ljava/lang/Throwable;)V
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
    //   37	106	1	localBufferedReader	java.io.BufferedReader
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
  
  public static List<a> a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(j.j(paramContext));
    localArrayList.add(com.tencent.beacon.b.a.j(paramContext));
    localArrayList.add(c.j(paramContext));
    localArrayList.add(com.tencent.beacon.e.a.j(paramContext));
    localArrayList.add(com.tencent.beacon.d.a.j(paramContext));
    localArrayList.add(com.tencent.beacon.a.e.b.j(paramContext));
    return localArrayList;
  }
  
  public static List<g> a(Context paramContext, int paramInt)
  {
    if (paramContext == null) {
      com.tencent.beacon.a.g.a.d("[db] have null args!", new Object[0]);
    }
    List localList;
    do
    {
      return null;
      localList = com.tencent.beacon.a.a.a.a.a(paramContext, new int[] { 1, 2, 3, 4 }, paramInt);
    } while ((localList == null) || (localList.size() <= 0));
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = localList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      com.tencent.beacon.a.a.a.a locala = (com.tencent.beacon.a.a.a.a)((Iterator)localObject1).next();
      try
      {
        Object localObject2 = b(locala.b);
        if ((localObject2 != null) && (g.class.isInstance(localObject2)))
        {
          localObject2 = (g)g.class.cast(localObject2);
          ((g)localObject2).a(locala.a);
          localArrayList.add(localObject2);
          ((Iterator)localObject1).remove();
        }
      }
      catch (Throwable localThrowable)
      {
        com.tencent.beacon.a.g.a.a(localThrowable);
        com.tencent.beacon.a.g.a.d("[db] query have error!", new Object[0]);
      }
    }
    if (localList.size() > 0)
    {
      com.tencent.beacon.a.g.a.c("[db] there are error data ,should be remove " + localList.size(), new Object[0]);
      localObject1 = new Long[localList.size()];
      paramInt = 0;
      while (paramInt < localList.size())
      {
        localObject1[paramInt] = Long.valueOf(((com.tencent.beacon.a.a.a.a)localList.get(paramInt)).a);
        paramInt += 1;
      }
      com.tencent.beacon.a.a.a.a.a(paramContext, (Long[])localObject1);
    }
    return localArrayList;
  }
  
  /* Error */
  public static boolean a(Context paramContext, String paramString, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: getstatic 669	com/tencent/beacon/a/a/a/c:a	Ljava/lang/Object;
    //   3: astore 4
    //   5: aload 4
    //   7: monitorenter
    //   8: aload_0
    //   9: ifnonnull +8 -> 17
    //   12: aload 4
    //   14: monitorexit
    //   15: iconst_0
    //   16: ireturn
    //   17: aload_0
    //   18: invokestatic 672	com/tencent/beacon/a/a/a/c:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/a/a/c;
    //   21: invokevirtual 676	com/tencent/beacon/a/a/a/c:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   24: astore_0
    //   25: aload_0
    //   26: ldc_w 678
    //   29: new 181	java/lang/StringBuilder
    //   32: dup
    //   33: ldc_w 680
    //   36: invokespecial 656	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   39: aload_1
    //   40: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: ldc_w 682
    //   46: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: aconst_null
    //   53: invokevirtual 688	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   56: pop
    //   57: new 690	android/content/ContentValues
    //   60: dup
    //   61: invokespecial 691	android/content/ContentValues:<init>	()V
    //   64: astore 5
    //   66: aload 5
    //   68: ldc_w 693
    //   71: aload_1
    //   72: invokevirtual 696	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   75: aload 5
    //   77: ldc_w 698
    //   80: aload_2
    //   81: iconst_0
    //   82: aaload
    //   83: checkcast 152	java/lang/String
    //   86: invokevirtual 696	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: aload 5
    //   91: ldc_w 700
    //   94: aload_2
    //   95: iconst_1
    //   96: aaload
    //   97: checkcast 423	java/lang/Long
    //   100: invokevirtual 703	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   103: aload 5
    //   105: ldc_w 705
    //   108: new 119	java/util/Date
    //   111: dup
    //   112: invokespecial 120	java/util/Date:<init>	()V
    //   115: invokevirtual 123	java/util/Date:getTime	()J
    //   118: invokestatic 659	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   121: invokevirtual 703	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   124: aload_0
    //   125: ldc_w 678
    //   128: aconst_null
    //   129: aload 5
    //   131: invokevirtual 709	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   134: lconst_0
    //   135: lcmp
    //   136: ifge +26 -> 162
    //   139: ldc_w 711
    //   142: iconst_0
    //   143: anewarray 4	java/lang/Object
    //   146: invokestatic 97	com/tencent/beacon/a/g/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   149: iconst_0
    //   150: istore_3
    //   151: aload 4
    //   153: monitorexit
    //   154: iload_3
    //   155: ireturn
    //   156: astore_0
    //   157: aload 4
    //   159: monitorexit
    //   160: aload_0
    //   161: athrow
    //   162: iconst_1
    //   163: istore_3
    //   164: goto -13 -> 151
    //   167: astore_0
    //   168: iconst_0
    //   169: istore_3
    //   170: goto -19 -> 151
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	paramContext	Context
    //   0	173	1	paramString	String
    //   0	173	2	paramArrayOfObject	Object[]
    //   150	20	3	bool	boolean
    //   3	155	4	localObject	Object
    //   64	66	5	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   12	15	156	finally
    //   17	149	156	finally
    //   151	154	156	finally
    //   157	160	156	finally
    //   17	149	167	java/lang/Exception
  }
  
  public static boolean a(String paramString, boolean paramBoolean)
  {
    if (paramString != null) {
      try
      {
        if (paramString.toLowerCase().equals("y")) {
          return true;
        }
        boolean bool = paramString.toLowerCase().equals("n");
        if (bool) {
          return false;
        }
      }
      catch (Throwable paramString)
      {
        com.tencent.beacon.a.g.a.a(paramString);
      }
    }
    return paramBoolean;
  }
  
  /* Error */
  private static byte[] a(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +13 -> 14
    //   4: ldc_w 721
    //   7: aload_0
    //   8: invokevirtual 643	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   11: ifne +15 -> 26
    //   14: ldc_w 723
    //   17: iconst_0
    //   18: anewarray 4	java/lang/Object
    //   21: invokestatic 97	com/tencent/beacon/a/g/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   24: aconst_null
    //   25: areturn
    //   26: new 725	java/io/ByteArrayOutputStream
    //   29: dup
    //   30: invokespecial 726	java/io/ByteArrayOutputStream:<init>	()V
    //   33: astore 4
    //   35: new 728	java/io/ObjectOutputStream
    //   38: dup
    //   39: aload 4
    //   41: invokespecial 731	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   44: astore_2
    //   45: aload_2
    //   46: astore_1
    //   47: aload_2
    //   48: aload_0
    //   49: invokevirtual 735	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   52: aload_2
    //   53: astore_1
    //   54: aload_2
    //   55: invokevirtual 738	java/io/ObjectOutputStream:flush	()V
    //   58: aload_2
    //   59: astore_1
    //   60: aload 4
    //   62: invokevirtual 741	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   65: astore_0
    //   66: aload_2
    //   67: invokevirtual 742	java/io/ObjectOutputStream:close	()V
    //   70: aload 4
    //   72: invokevirtual 743	java/io/ByteArrayOutputStream:close	()V
    //   75: aload_0
    //   76: areturn
    //   77: astore_1
    //   78: aload_1
    //   79: invokestatic 70	com/tencent/beacon/a/g/a:a	(Ljava/lang/Throwable;)V
    //   82: aload_0
    //   83: areturn
    //   84: astore_1
    //   85: aload_1
    //   86: invokestatic 70	com/tencent/beacon/a/g/a:a	(Ljava/lang/Throwable;)V
    //   89: goto -19 -> 70
    //   92: astore_3
    //   93: aconst_null
    //   94: astore_0
    //   95: aload_0
    //   96: astore_1
    //   97: aload_3
    //   98: invokestatic 70	com/tencent/beacon/a/g/a:a	(Ljava/lang/Throwable;)V
    //   101: aload_0
    //   102: astore_1
    //   103: aload_3
    //   104: invokevirtual 430	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   107: iconst_0
    //   108: anewarray 4	java/lang/Object
    //   111: invokestatic 97	com/tencent/beacon/a/g/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   114: aload_0
    //   115: ifnull +7 -> 122
    //   118: aload_0
    //   119: invokevirtual 742	java/io/ObjectOutputStream:close	()V
    //   122: aload 4
    //   124: invokevirtual 743	java/io/ByteArrayOutputStream:close	()V
    //   127: aconst_null
    //   128: areturn
    //   129: astore_0
    //   130: aload_0
    //   131: invokestatic 70	com/tencent/beacon/a/g/a:a	(Ljava/lang/Throwable;)V
    //   134: aconst_null
    //   135: areturn
    //   136: astore_0
    //   137: aload_0
    //   138: invokestatic 70	com/tencent/beacon/a/g/a:a	(Ljava/lang/Throwable;)V
    //   141: goto -19 -> 122
    //   144: astore_0
    //   145: aconst_null
    //   146: astore_1
    //   147: aload_1
    //   148: ifnull +7 -> 155
    //   151: aload_1
    //   152: invokevirtual 742	java/io/ObjectOutputStream:close	()V
    //   155: aload 4
    //   157: invokevirtual 743	java/io/ByteArrayOutputStream:close	()V
    //   160: aload_0
    //   161: athrow
    //   162: astore_1
    //   163: aload_1
    //   164: invokestatic 70	com/tencent/beacon/a/g/a:a	(Ljava/lang/Throwable;)V
    //   167: goto -12 -> 155
    //   170: astore_1
    //   171: aload_1
    //   172: invokestatic 70	com/tencent/beacon/a/g/a:a	(Ljava/lang/Throwable;)V
    //   175: goto -15 -> 160
    //   178: astore_0
    //   179: goto -32 -> 147
    //   182: astore_3
    //   183: aload_2
    //   184: astore_0
    //   185: goto -90 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	paramObject	Object
    //   46	14	1	localObjectOutputStream1	java.io.ObjectOutputStream
    //   77	2	1	localIOException1	java.io.IOException
    //   84	2	1	localIOException2	java.io.IOException
    //   96	56	1	localObject	Object
    //   162	2	1	localIOException3	java.io.IOException
    //   170	2	1	localIOException4	java.io.IOException
    //   44	140	2	localObjectOutputStream2	java.io.ObjectOutputStream
    //   92	12	3	localThrowable1	Throwable
    //   182	1	3	localThrowable2	Throwable
    //   33	123	4	localByteArrayOutputStream	ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   70	75	77	java/io/IOException
    //   66	70	84	java/io/IOException
    //   35	45	92	java/lang/Throwable
    //   122	127	129	java/io/IOException
    //   118	122	136	java/io/IOException
    //   35	45	144	finally
    //   151	155	162	java/io/IOException
    //   155	160	170	java/io/IOException
    //   47	52	178	finally
    //   54	58	178	finally
    //   60	66	178	finally
    //   97	101	178	finally
    //   103	114	178	finally
    //   47	52	182	java/lang/Throwable
    //   54	58	182	java/lang/Throwable
    //   60	66	182	java/lang/Throwable
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
    while (i < 16)
    {
      paramString = paramString + "0";
      i += 1;
    }
    paramString = paramString.substring(0, 16);
    SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramString.getBytes(), "AES");
    Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    localCipher.init(2, localSecretKeySpec, new IvParameterSpec(paramString.getBytes()));
    return localCipher.doFinal(paramArrayOfByte);
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
      int i = localGZIPInputStream.read(arrayOfByte, 0, 1024);
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    arrayOfByte = localByteArrayOutputStream.toByteArray();
    localByteArrayOutputStream.flush();
    localByteArrayOutputStream.close();
    localGZIPInputStream.close();
    paramArrayOfByte.close();
    return arrayOfByte;
  }
  
  private static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte == null) || (paramInt == -1)) {
      return paramArrayOfByte;
    }
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
        com.tencent.beacon.a.g.a.a(paramArrayOfByte);
        com.tencent.beacon.a.g.a.d("err zp : %s", new Object[] { paramArrayOfByte.toString() });
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
      com.tencent.beacon.a.g.a.a(paramArrayOfByte);
    }
    return null;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt, String paramString)
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
      localCipher.init(1, SecretKeyFactory.getInstance("DES").generateSecret(localDESKeySpec), new IvParameterSpec(paramString.getBytes("UTF-8")));
      return localCipher.doFinal(paramArrayOfByte);
    }
    catch (Throwable paramArrayOfByte)
    {
      com.tencent.beacon.a.g.a.a(paramArrayOfByte);
      com.tencent.beacon.a.g.a.d("err enD: %s", new Object[] { paramArrayOfByte.toString() });
    }
    if (paramInt == 3)
    {
      paramArrayOfByte = b(paramString, paramArrayOfByte);
      return paramArrayOfByte;
    }
    return null;
    return null;
  }
  
  public static Long[] a(Context paramContext, List<g> paramList)
  {
    if ((paramContext == null) || (paramList == null))
    {
      com.tencent.beacon.a.g.a.d("[db] have null args!", new Object[0]);
      return null;
    }
    int m = paramList.size();
    if (m == 0)
    {
      com.tencent.beacon.a.g.a.d("[db] insert list size(0) return.", new Object[0]);
      return null;
    }
    Long[] arrayOfLong = new Long[m];
    ArrayList localArrayList = new ArrayList();
    int k = 0;
    if (k < m)
    {
      g localg = (g)paramList.get(k);
      if (localg == null) {
        com.tencent.beacon.a.g.a.c("[db] bean is null!", new Object[0]);
      }
      for (;;)
      {
        k += 1;
        break;
        int j;
        if (localg.b().equals("UA"))
        {
          i = 1;
          j = 3;
        }
        for (;;)
        {
          try
          {
            localArrayList.add(new com.tencent.beacon.a.a.a.a(i, j, localg.c(), a(localg)));
          }
          catch (Throwable localThrowable)
          {
            com.tencent.beacon.a.g.a.a(localThrowable);
          }
          break;
          if (localThrowable.b().equals("IP"))
          {
            i = 2;
            j = 0;
          }
          else if (localThrowable.b().equals("DN"))
          {
            j = 0;
            i = 3;
          }
          else
          {
            if (!localThrowable.b().equals("HO")) {
              break label229;
            }
            i = 4;
            j = 0;
          }
        }
        label229:
        com.tencent.beacon.a.g.a.c("[db] bean's type is error!", new Object[0]);
      }
    }
    if (!com.tencent.beacon.a.a.a.a.a(paramContext, localArrayList)) {
      return null;
    }
    paramContext = localArrayList.iterator();
    int i = 0;
    while (paramContext.hasNext())
    {
      paramList = (com.tencent.beacon.a.a.a.a)paramContext.next();
      if (i < m) {
        arrayOfLong[i] = Long.valueOf(paramList.a);
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
    //   3: getstatic 669	com/tencent/beacon/a/a/a/c:a	Ljava/lang/Object;
    //   6: astore 5
    //   8: aload 5
    //   10: monitorenter
    //   11: aload_0
    //   12: ifnonnull +18 -> 30
    //   15: ldc_w 909
    //   18: iconst_0
    //   19: anewarray 4	java/lang/Object
    //   22: invokestatic 97	com/tencent/beacon/a/g/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   25: aload 5
    //   27: monitorexit
    //   28: aconst_null
    //   29: areturn
    //   30: aload_0
    //   31: invokestatic 672	com/tencent/beacon/a/a/a/c:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/a/a/c;
    //   34: invokevirtual 676	com/tencent/beacon/a/a/a/c:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   37: astore_0
    //   38: aload_0
    //   39: ifnonnull +18 -> 57
    //   42: ldc_w 911
    //   45: iconst_0
    //   46: anewarray 4	java/lang/Object
    //   49: invokestatic 97	com/tencent/beacon/a/g/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   52: aload 5
    //   54: monitorexit
    //   55: aconst_null
    //   56: areturn
    //   57: aload_0
    //   58: ldc_w 678
    //   61: aconst_null
    //   62: new 181	java/lang/StringBuilder
    //   65: dup
    //   66: ldc_w 680
    //   69: invokespecial 656	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   72: aload_1
    //   73: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: ldc_w 682
    //   79: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: aconst_null
    //   86: aconst_null
    //   87: aconst_null
    //   88: aconst_null
    //   89: invokevirtual 915	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   92: astore_0
    //   93: aload_0
    //   94: ifnull +94 -> 188
    //   97: aload_0
    //   98: invokeinterface 920 1 0
    //   103: ifeq +85 -> 188
    //   106: aload_0
    //   107: aload_0
    //   108: ldc_w 698
    //   111: invokeinterface 923 2 0
    //   116: invokeinterface 926 2 0
    //   121: astore 4
    //   123: aload_0
    //   124: aload_0
    //   125: ldc_w 700
    //   128: invokeinterface 923 2 0
    //   133: invokeinterface 930 2 0
    //   138: lstore_2
    //   139: aload_0
    //   140: ifnull +18 -> 158
    //   143: aload_0
    //   144: invokeinterface 933 1 0
    //   149: ifne +9 -> 158
    //   152: aload_0
    //   153: invokeinterface 934 1 0
    //   158: aload 5
    //   160: monitorexit
    //   161: iconst_3
    //   162: anewarray 4	java/lang/Object
    //   165: dup
    //   166: iconst_0
    //   167: aload_1
    //   168: aastore
    //   169: dup
    //   170: iconst_1
    //   171: aload 4
    //   173: aastore
    //   174: dup
    //   175: iconst_2
    //   176: lload_2
    //   177: invokestatic 659	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   180: aastore
    //   181: areturn
    //   182: astore_0
    //   183: aload 5
    //   185: monitorexit
    //   186: aload_0
    //   187: athrow
    //   188: aload_0
    //   189: ifnull +18 -> 207
    //   192: aload_0
    //   193: invokeinterface 933 1 0
    //   198: ifne +9 -> 207
    //   201: aload_0
    //   202: invokeinterface 934 1 0
    //   207: aload 5
    //   209: monitorexit
    //   210: aconst_null
    //   211: areturn
    //   212: aload_0
    //   213: ifnull -6 -> 207
    //   216: aload_0
    //   217: invokeinterface 933 1 0
    //   222: ifne -15 -> 207
    //   225: aload_0
    //   226: invokeinterface 934 1 0
    //   231: goto -24 -> 207
    //   234: aload_1
    //   235: ifnull +18 -> 253
    //   238: aload_1
    //   239: invokeinterface 933 1 0
    //   244: ifne +9 -> 253
    //   247: aload_1
    //   248: invokeinterface 934 1 0
    //   253: aload_0
    //   254: athrow
    //   255: astore 4
    //   257: aload_0
    //   258: astore_1
    //   259: aload 4
    //   261: astore_0
    //   262: goto -28 -> 234
    //   265: astore_1
    //   266: goto -54 -> 212
    //   269: astore_0
    //   270: aconst_null
    //   271: astore_0
    //   272: goto -60 -> 212
    //   275: astore_0
    //   276: aload 4
    //   278: astore_1
    //   279: goto -45 -> 234
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	282	0	paramContext	Context
    //   0	282	1	paramString	String
    //   138	39	2	l	long
    //   1	171	4	str	String
    //   255	22	4	localObject1	Object
    //   6	202	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   15	28	182	finally
    //   52	55	182	finally
    //   143	158	182	finally
    //   158	182	182	finally
    //   183	186	182	finally
    //   192	207	182	finally
    //   207	210	182	finally
    //   216	231	182	finally
    //   238	253	182	finally
    //   253	255	182	finally
    //   97	139	255	finally
    //   97	139	265	java/lang/Exception
    //   30	38	269	java/lang/Exception
    //   42	52	269	java/lang/Exception
    //   57	93	269	java/lang/Exception
    //   30	38	275	finally
    //   42	52	275	finally
    //   57	93	275	finally
  }
  
  public static int b(Context paramContext, com.tencent.beacon.e.b[] paramArrayOfb)
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
      localArrayList = new ArrayList();
      i = 0;
      while (i <= 0)
      {
        com.tencent.beacon.e.b localb = paramArrayOfb[0];
        if (localb.a() >= 0L) {
          localArrayList.add(Long.valueOf(localb.a()));
        }
        i += 1;
      }
      i = j;
    } while (localArrayList.size() <= 0);
    return com.tencent.beacon.a.a.a.a.a(paramContext, (Long[])localArrayList.toArray(new Long[0]));
  }
  
  /* Error */
  private static Object b(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +8 -> 9
    //   4: aload_0
    //   5: arraylength
    //   6: ifge +5 -> 11
    //   9: aconst_null
    //   10: areturn
    //   11: new 812	java/io/ByteArrayInputStream
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 813	java/io/ByteArrayInputStream:<init>	([B)V
    //   19: astore_3
    //   20: new 942	java/io/ObjectInputStream
    //   23: dup
    //   24: aload_3
    //   25: invokespecial 943	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   28: astore_1
    //   29: aload_1
    //   30: astore_0
    //   31: aload_1
    //   32: invokevirtual 946	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   35: astore_2
    //   36: aload_1
    //   37: invokevirtual 947	java/io/ObjectInputStream:close	()V
    //   40: aload_3
    //   41: invokevirtual 827	java/io/ByteArrayInputStream:close	()V
    //   44: aload_2
    //   45: areturn
    //   46: astore_0
    //   47: aload_0
    //   48: invokestatic 70	com/tencent/beacon/a/g/a:a	(Ljava/lang/Throwable;)V
    //   51: aload_2
    //   52: areturn
    //   53: astore_0
    //   54: aload_0
    //   55: invokestatic 70	com/tencent/beacon/a/g/a:a	(Ljava/lang/Throwable;)V
    //   58: goto -18 -> 40
    //   61: astore_2
    //   62: aconst_null
    //   63: astore_1
    //   64: aload_1
    //   65: astore_0
    //   66: aload_2
    //   67: invokestatic 70	com/tencent/beacon/a/g/a:a	(Ljava/lang/Throwable;)V
    //   70: aload_1
    //   71: astore_0
    //   72: aload_2
    //   73: invokevirtual 430	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   76: iconst_0
    //   77: anewarray 4	java/lang/Object
    //   80: invokestatic 97	com/tencent/beacon/a/g/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   83: aload_1
    //   84: ifnull +7 -> 91
    //   87: aload_1
    //   88: invokevirtual 947	java/io/ObjectInputStream:close	()V
    //   91: aload_3
    //   92: invokevirtual 827	java/io/ByteArrayInputStream:close	()V
    //   95: aconst_null
    //   96: areturn
    //   97: astore_0
    //   98: aload_0
    //   99: invokestatic 70	com/tencent/beacon/a/g/a:a	(Ljava/lang/Throwable;)V
    //   102: aconst_null
    //   103: areturn
    //   104: astore_0
    //   105: aload_0
    //   106: invokestatic 70	com/tencent/beacon/a/g/a:a	(Ljava/lang/Throwable;)V
    //   109: goto -18 -> 91
    //   112: astore_1
    //   113: aconst_null
    //   114: astore_0
    //   115: aload_0
    //   116: ifnull +7 -> 123
    //   119: aload_0
    //   120: invokevirtual 947	java/io/ObjectInputStream:close	()V
    //   123: aload_3
    //   124: invokevirtual 827	java/io/ByteArrayInputStream:close	()V
    //   127: aload_1
    //   128: athrow
    //   129: astore_0
    //   130: aload_0
    //   131: invokestatic 70	com/tencent/beacon/a/g/a:a	(Ljava/lang/Throwable;)V
    //   134: goto -11 -> 123
    //   137: astore_0
    //   138: aload_0
    //   139: invokestatic 70	com/tencent/beacon/a/g/a:a	(Ljava/lang/Throwable;)V
    //   142: goto -15 -> 127
    //   145: astore_1
    //   146: goto -31 -> 115
    //   149: astore_2
    //   150: goto -86 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	paramArrayOfByte	byte[]
    //   28	60	1	localObjectInputStream	java.io.ObjectInputStream
    //   112	16	1	localObject1	Object
    //   145	1	1	localObject2	Object
    //   35	17	2	localObject3	Object
    //   61	12	2	localThrowable1	Throwable
    //   149	1	2	localThrowable2	Throwable
    //   19	105	3	localByteArrayInputStream	ByteArrayInputStream
    // Exception table:
    //   from	to	target	type
    //   40	44	46	java/io/IOException
    //   36	40	53	java/io/IOException
    //   20	29	61	java/lang/Throwable
    //   91	95	97	java/io/IOException
    //   87	91	104	java/io/IOException
    //   20	29	112	finally
    //   119	123	129	java/io/IOException
    //   123	127	137	java/io/IOException
    //   31	36	145	finally
    //   66	70	145	finally
    //   72	83	145	finally
    //   31	36	149	java/lang/Throwable
  }
  
  public static String b(Context paramContext, int paramInt)
  {
    try
    {
      Object localObject = com.tencent.beacon.a.c.d.a(paramContext);
      paramContext = ((com.tencent.beacon.a.c.d)localObject).a();
      localObject = ((com.tencent.beacon.a.c.d)localObject).b();
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
        com.tencent.beacon.a.g.a.c("[core] userID length should < 5!", new Object[0]);
      }
      paramString = str;
      if (str.length() > 128) {
        paramString = str.substring(0, 128);
      }
      return paramString;
    }
    com.tencent.beacon.a.g.a.c("[core] userID should be ASCII code in 32-126! userID:" + paramString, new Object[0]);
    return "10000";
  }
  
  private static byte[] b(String paramString, byte[] paramArrayOfByte)
    throws Exception, NoSuchAlgorithmException
  {
    if ((paramString == null) || (paramArrayOfByte == null)) {
      return null;
    }
    int i = paramString.length();
    while (i < 16)
    {
      paramString = paramString + "0";
      i += 1;
    }
    paramString = paramString.substring(0, 16);
    SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramString.getBytes(), "AES");
    Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    localCipher.init(1, localSecretKeySpec, new IvParameterSpec(paramString.getBytes()));
    return localCipher.doFinal(paramArrayOfByte);
  }
  
  private static byte[] b(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte == null) || (paramInt == -1)) {
      return paramArrayOfByte;
    }
    if (paramInt == 1)
    {
      ByteArrayInputStream localByteArrayInputStream;
      ZipInputStream localZipInputStream;
      for (;;)
      {
        ByteArrayOutputStream localByteArrayOutputStream;
        try
        {
          localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
          localZipInputStream = new ZipInputStream(localByteArrayInputStream);
          paramArrayOfByte = null;
          if (localZipInputStream.getNextEntry() == null) {
            break;
          }
          paramArrayOfByte = new byte[1024];
          localByteArrayOutputStream = new ByteArrayOutputStream();
          paramInt = localZipInputStream.read(paramArrayOfByte, 0, 1024);
          if (paramInt != -1)
          {
            localByteArrayOutputStream.write(paramArrayOfByte, 0, paramInt);
            continue;
          }
          paramArrayOfByte = localByteArrayOutputStream.toByteArray();
        }
        catch (Throwable paramArrayOfByte)
        {
          com.tencent.beacon.a.g.a.a(paramArrayOfByte);
          com.tencent.beacon.a.g.a.d("err unzp}" + paramArrayOfByte.toString(), new Object[0]);
          return null;
        }
        localByteArrayOutputStream.flush();
        localByteArrayOutputStream.close();
      }
      localZipInputStream.close();
      localByteArrayInputStream.close();
      return paramArrayOfByte;
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
      com.tencent.beacon.a.g.a.a(paramArrayOfByte);
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
      com.tencent.beacon.a.g.a.a(paramArrayOfByte);
      com.tencent.beacon.a.g.a.d("err unD: %s", new Object[] { paramArrayOfByte.toString() });
    }
    if (paramInt == 3)
    {
      paramArrayOfByte = a(paramString, paramArrayOfByte);
      return paramArrayOfByte;
    }
    return null;
    return null;
  }
  
  public static int c(Context paramContext)
  {
    if (paramContext == null)
    {
      com.tencent.beacon.a.g.a.d("[db] context is null.", new Object[0]);
      return -1;
    }
    return com.tencent.beacon.a.a.a.a.b(paramContext, new int[] { 1, 2, 3, 4 });
  }
  
  public static int c(Context paramContext, com.tencent.beacon.e.b[] paramArrayOfb)
  {
    int j = 0;
    int i;
    if ((paramContext == null) || (paramArrayOfb == null) || (paramArrayOfb.length <= 0)) {
      i = -1;
    }
    ArrayList localArrayList;
    do
    {
      return i;
      localArrayList = new ArrayList(paramArrayOfb.length);
      int k = paramArrayOfb.length;
      i = 0;
      while (i < k)
      {
        com.tencent.beacon.e.b localb = paramArrayOfb[i];
        Object localObject = a(localb);
        if (localObject != null)
        {
          localObject = new com.tencent.beacon.a.a.a.a(7, 0, 0L, (byte[])localObject);
          ((com.tencent.beacon.a.a.a.a)localObject).a = localb.a();
          localArrayList.add(localObject);
        }
        i += 1;
      }
      i = j;
    } while (localArrayList.size() <= 0);
    if (com.tencent.beacon.a.a.a.a.b(paramContext, localArrayList)) {
      return localArrayList.size();
    }
    return -1;
  }
  
  public static String c(String paramString)
  {
    String str2 = "unknown";
    String str1 = str2;
    if (paramString != null)
    {
      if (paramString.trim().length() != 0) {
        break label24;
      }
      str1 = str2;
    }
    label24:
    do
    {
      return str1;
      if (!d(paramString.trim())) {
        break;
      }
      paramString = paramString.trim();
      str1 = paramString;
    } while (paramString.length() <= 16);
    return paramString.substring(0, 16);
    com.tencent.beacon.a.g.a.c("[core] channelID should be Numeric! channelID:" + paramString, new Object[0]);
    return "unknown";
  }
  
  public static String d(Context paramContext)
  {
    try
    {
      String str = com.tencent.beacon.a.c.d.a(paramContext).d();
      paramContext = "";
      com.tencent.beacon.a.c.b localb = com.tencent.beacon.a.c.b.a(UserAction.mContext);
      if (localb != null) {
        paramContext = localb.a();
      }
      int i = (int)(Math.random() * 2147483647.0D);
      paramContext = g(paramContext + "_" + str + "_" + new Date().getTime() + "_" + i);
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
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
  
  public static long e()
  {
    try
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
      long l = localSimpleDateFormat.parse(localSimpleDateFormat.format(new Date())).getTime();
      return l;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.a.g.a.a(localThrowable);
    }
    return -1L;
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
      com.tencent.beacon.a.g.a.a(paramString);
    }
    return null;
  }
  
  public static List<com.tencent.beacon.e.b> e(Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      return null;
      localObject = com.tencent.beacon.a.a.a.a.a(paramContext, new int[] { 6 }, -1, -1, 5, 0L);
    } while ((localObject == null) || (((List)localObject).size() <= 0));
    paramContext = new ArrayList(((List)localObject).size());
    Object localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.beacon.a.a.a.a locala = (com.tencent.beacon.a.a.a.a)((Iterator)localObject).next();
      try
      {
        com.tencent.beacon.e.b localb = (com.tencent.beacon.e.b)com.tencent.beacon.e.b.class.cast(b(locala.b));
        if (localb != null)
        {
          localb.a(locala.a);
          paramContext.add(localb);
        }
      }
      catch (Throwable localThrowable)
      {
        com.tencent.beacon.a.g.a.a(localThrowable);
        com.tencent.beacon.a.g.a.d("[db] net consume error %s", new Object[] { localThrowable.toString() });
      }
    }
    return paramContext;
  }
  
  public static String f()
  {
    try
    {
      String str = new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(new Date());
      return str;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.a.g.a.a(localThrowable);
    }
    return "";
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
      com.tencent.beacon.a.g.a.d("Read file %s failed.", new Object[] { paramString });
    }
    return str1;
  }
  
  public static List<com.tencent.beacon.e.b> f(Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      return null;
      localObject = com.tencent.beacon.a.a.a.a.a(paramContext, new int[] { 7 }, -1, -1, 5, 0L);
    } while ((localObject == null) || (((List)localObject).size() <= 0));
    paramContext = new ArrayList(((List)localObject).size());
    Object localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.beacon.a.a.a.a locala = (com.tencent.beacon.a.a.a.a)((Iterator)localObject).next();
      try
      {
        com.tencent.beacon.e.b localb = (com.tencent.beacon.e.b)com.tencent.beacon.e.b.class.cast(b(locala.b));
        localb.a(locala.a);
        paramContext.add(localb);
      }
      catch (Throwable localThrowable)
      {
        com.tencent.beacon.a.g.a.a(localThrowable);
        com.tencent.beacon.a.g.a.d("[db] net consume error:%s", new Object[] { localThrowable.toString() });
      }
    }
    return paramContext;
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
  
  public static boolean g(Context paramContext)
  {
    paramContext = j(paramContext);
    return (paramContext != null) && (paramContext.getType() == 1);
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
      com.tencent.beacon.a.g.a.a(localException);
    }
    return paramString;
  }
  
  public static boolean h(Context paramContext)
  {
    paramContext = j(paramContext);
    return (paramContext != null) && (paramContext.isConnected());
  }
  
  public static String i(Context paramContext)
  {
    paramContext = j(paramContext);
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
  
  private static NetworkInfo j(Context paramContext)
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
      com.tencent.beacon.a.g.a.a(paramContext);
    }
    return null;
  }
  
  public void a(int paramInt, Map<String, String> paramMap) {}
  
  public void a(com.tencent.beacon.a.e.a parama) {}
  
  public void b(Context paramContext) {}
  
  public void b_() {}
  
  public void c() {}
  
  public void c_() {}
  
  public void d()
  {
    if (this.b)
    {
      c_();
      if ((!h.a(this.a).a()) || (!f.a(this.a).a("sig_1")) || (!h.a(this.a).b())) {
        break label63;
      }
      c();
    }
    for (;;)
    {
      this.b = false;
      return;
      label63:
      com.tencent.beacon.a.g.a.c("[strategy] get lock failed, on call module started", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.a
 * JD-Core Version:    0.7.0.1
 */