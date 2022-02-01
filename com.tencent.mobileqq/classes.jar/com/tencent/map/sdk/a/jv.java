package com.tencent.map.sdk.a;

import com.tencent.map.lib.basemap.data.GeoPoint;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONObject;

public class jv
{
  public static ConcurrentHashMap<String, fw[]> a = new ConcurrentHashMap();
  private static volatile jv f;
  public String b = null;
  public String c = null;
  public boolean d = false;
  public AtomicInteger e = new AtomicInteger(0);
  private ReentrantReadWriteLock g = new ReentrantReadWriteLock();
  
  public static jv a()
  {
    if (f == null) {
      try
      {
        if (f == null) {
          f = new jv();
        }
      }
      finally {}
    }
    return f;
  }
  
  public static boolean a(fw paramfw, fw[] paramArrayOffw)
  {
    if (paramArrayOffw != null)
    {
      if (paramArrayOffw.length < 3) {
        return false;
      }
      int j = paramArrayOffw.length - 1;
      int i = 0;
      int m;
      for (int k = 0; i < paramArrayOffw.length; k = m)
      {
        if ((paramArrayOffw[i].a >= paramfw.a) || (paramArrayOffw[j].a < paramfw.a))
        {
          m = k;
          if (paramArrayOffw[j].a < paramfw.a)
          {
            m = k;
            if (paramArrayOffw[i].a < paramfw.a) {}
          }
        }
        else if (paramArrayOffw[i].b > paramfw.b)
        {
          m = k;
          if (paramArrayOffw[j].b > paramfw.b) {}
        }
        else
        {
          if (paramArrayOffw[i].b + (paramfw.a - paramArrayOffw[i].a) / (paramArrayOffw[j].a - paramArrayOffw[i].a) * (paramArrayOffw[j].b - paramArrayOffw[i].b) < paramfw.b) {
            j = 1;
          } else {
            j = 0;
          }
          m = k ^ j;
        }
        j = i;
        i += 1;
      }
      return k;
    }
    return false;
  }
  
  public static boolean a(fw[] paramArrayOffw1, fw[] paramArrayOffw2)
  {
    int m = paramArrayOffw1.length;
    int i = 0;
    int j = 0;
    while (i < m)
    {
      j |= a(paramArrayOffw1[i], paramArrayOffw2);
      if (j != 0)
      {
        i = 1;
        break label42;
      }
      i += 1;
    }
    i = 0;
    label42:
    int n = paramArrayOffw2.length;
    j = 0;
    boolean bool = false;
    m = 0;
    while (j < n)
    {
      bool |= a(paramArrayOffw2[j], paramArrayOffw1);
      if (bool) {
        m = 1;
      }
      int k;
      j += 1;
    }
    if (i == 0) {
      return m != 0;
    }
    return true;
  }
  
  public static int b(String paramString)
  {
    int k = 0;
    int m = 0;
    int i = 0;
    int j;
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return 0;
      }
      j = m;
    }
    try
    {
      paramString = new JSONObject(paramString);
      j = m;
      Iterator localIterator = paramString.keys();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        j = i;
        String str = (String)localIterator.next();
        j = i;
        if ("version".equals(str))
        {
          j = i;
          i = paramString.optInt(str);
        }
        else
        {
          j = i;
          fw[] arrayOffw = c(paramString.optString(str));
          if (arrayOffw != null)
          {
            j = i;
            a.put(str, arrayOffw);
          }
        }
      }
      j = i;
      if (!a.containsKey("china"))
      {
        j = i;
        paramString = c("124.240000,39.863000:127.060000,41.420000:128.320000,41.340000:128.338164,41.966811:129.070015,42.006633:129.392187,42.394602:129.544000,42.337000:129.757733,42.443019:129.915455,42.958121:130.581000,42.411000:130.664000,42.409000:130.660000,42.750000:131.056800,42.832500:131.362267,43.147780:131.359097,44.050378:131.184574,44.758711:131.911825,45.219501:133.163642,44.937724:135.144366,48.211013:135.128000,48.597000:131.071828,47.811040:130.773650,49.035551:128.751969,49.726565:125.969075,53.154351:123.347269,53.704738:120.827269,53.390754:119.713597,52.637780:120.321762,52.210396:118.926328,50.226355:117.662701,49.700280:116.622716,49.956516:115.284508,48.000368:116.104389,47.451176:118.485448,47.755809:119.550866,46.911548:117.463642,46.804509:113.640000,45.105329:111.969090,45.243847:111.267254,44.465714:111.589045,43.737317:109.905388,42.763982:107.448179,42.614694:105.337313,41.946215:100.992746,42.800196:96.838239,42.914056:95.070866,44.957807:91.816477,45.242319:91.161836,46.742245:90.130007,47.948495:88.699097,48.336174:87.883642,49.202090:86.809933,49.172099:85.459963,48.255788:85.328157,47.119427:82.919985,47.328453:82.134523,45.619623:82.396343,45.291415:81.735685,45.446091:79.797183,45.018009:80.618157,43.259401:80.112694,42.868284:80.120896,42.260590:77.976351,41.282314:76.788172,41.096389:76.197254,40.491205:75.361880,40.846808:73.365418,39.794560:73.634523,38.503352:74.669067,38.423003:74.896815,37.310540:74.429528,37.294106:74.454501,36.972073:75.734530,36.578999:75.962701,35.784605:77.852731,35.299899:78.205470,34.574291:78.973568,32.910437:78.263619,32.582183:78.649985,30.992536:81.199112,29.930890:81.625396,30.231654:85.988179,27.769037:88.674612,27.787987:88.840910,27.047339:89.241858,27.247275:89.644552,28.077447:90.426358,28.002589:91.425425,27.605415:92.127284,26.721880:93.834582,26.907073:95.855604,28.198876:97.000074,27.593593:97.491836,27.849236:97.700896,28.296779:98.301769,27.394792:98.605433,27.417494:98.502702,26.026786:97.440895,25.088802:97.485448,23.745403:98.497224,24.030523:98.809985,23.174956:99.324515,22.945024:99.099993,22.084196:100.205485,21.391178:101.003735,21.463004:101.278198,21.122876:101.931836,21.129823:101.785481,22.197373:102.650063,22.558783:103.074619,22.382137:103.979093,22.474798:104.809933,22.767793:105.399978,23.049961:106.469971,22.704082:106.610899,21.787060:107.897261,21.372454:107.490036,19.305984:109.748489,14.674666:110.039063,11.480025:107.666016,6.271618:111.752930,3.281824:112.939454,3.413421:115.018257,6.054474:118.674316,10.790140:119.164223,12.212996:119.707031,18.020528:121.959229,21.677848:122.699226,23.809795:127.303391,24.447079:127.390663,31.568056:124.335754,32.823666");
        if (paramString != null)
        {
          j = i;
          a.put("china", paramString);
        }
      }
      j = i;
      if (!a.containsKey("inland"))
      {
        j = i;
        paramString = c("124.240000,39.863000:127.060000,41.420000:128.320000,41.340000:128.338164,41.966811:129.070015,42.006633:129.392187,42.394602:129.544000,42.337000:129.757733,42.443019:129.915455,42.958121:130.581000,42.411000:130.664000,42.409000:130.660000,42.750000:131.056800,42.832500:131.362267,43.147780:131.359097,44.050378:131.184574,44.758711:131.911825,45.219501:133.163642,44.937724:135.144366,48.211013:135.128000,48.597000:131.071828,47.811040:130.773650,49.035551:128.751969,49.726565:125.969075,53.154351:123.347269,53.704738:120.827269,53.390754:119.713597,52.637780:120.321762,52.210396:118.926328,50.226355:117.662701,49.700280:116.622716,49.956516:115.284508,48.000368:116.104389,47.451176:118.485448,47.755809:119.550866,46.911548:117.463642,46.804509:113.640000,45.105329:111.969090,45.243847:111.267254,44.465714:111.589045,43.737317:109.905388,42.763982:107.448179,42.614694:105.337313,41.946215:100.992746,42.800196:96.838239,42.914056:95.070866,44.957807:91.816477,45.242319:91.161836,46.742245:90.130007,47.948495:88.699097,48.336174:87.883642,49.202090:86.809933,49.172099:85.459963,48.255788:85.328157,47.119427:82.919985,47.328453:82.134523,45.619623:82.396343,45.291415:81.735685,45.446091:79.797183,45.018009:80.618157,43.259401:80.112694,42.868284:80.120896,42.260590:77.976351,41.282314:76.788172,41.096389:76.197254,40.491205:75.361880,40.846808:73.365418,39.794560:73.634523,38.503352:74.669067,38.423003:74.896815,37.310540:74.429528,37.294106:74.454501,36.972073:75.734530,36.578999:75.962701,35.784605:77.852731,35.299899:78.205470,34.574291:78.973568,32.910437:78.263619,32.582183:78.649985,30.992536:81.199112,29.930890:81.625396,30.231654:85.988179,27.769037:88.674612,27.787987:88.840910,27.047339:89.241858,27.247275:89.644552,28.077447:90.426358,28.002589:91.425425,27.605415:92.127284,26.721880:93.834582,26.907073:95.855604,28.198876:97.000074,27.593593:97.491836,27.849236:97.700896,28.296779:98.301769,27.394792:98.605433,27.417494:98.502702,26.026786:97.440895,25.088802:97.485448,23.745403:98.497224,24.030523:98.809985,23.174956:99.324515,22.945024:99.099993,22.084196:100.205485,21.391178:101.003735,21.463004:101.278198,21.122876:101.931836,21.129823:101.785481,22.197373:102.650063,22.558783:103.074619,22.382137:103.979093,22.474798:104.809933,22.767793:105.399978,23.049961:106.469971,22.704082:106.610899,21.787060:107.897261,21.372454:107.490036,19.305984:109.748489,14.674666:110.039063,11.480025:107.666016,6.271618:111.752930,3.281824:112.939454,3.413421:115.018257,6.054474:118.674316,10.790140:119.164223,12.212996:119.707031,18.020528:121.397269,20.720622:118.487770,21.778166:119.578789,24.089008:120.465831,25.121382:121.207406,25.815692:121.869972,25.849447:122.742859,25.209509:122.699226,23.809795:127.303391,24.447079:127.390663,31.568056:124.335754,32.823666");
        if (paramString != null)
        {
          j = i;
          a.put("inland", paramString);
        }
      }
      k = i;
      j = i;
      if (!a.containsKey("taiwan"))
      {
        j = i;
        paramString = c("121.397269,20.720622:118.487770,21.778166:119.578789,24.089008:120.465831,25.121382:121.207406,25.815692:121.869972,25.849447:122.742859,25.209509:122.699226,23.809795:121.959229,21.677848");
        k = i;
        if (paramString != null)
        {
          j = i;
          a.put("taiwan", paramString);
          k = i;
        }
      }
      return k;
    }
    catch (Throwable paramString) {}
    return j;
  }
  
  public static fw[] c(String paramString)
  {
    Object localObject = null;
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return null;
      }
      String[] arrayOfString = paramString.split(":");
      if (arrayOfString.length == 0) {
        return null;
      }
      paramString = new fw[arrayOfString.length];
      int i = 0;
      for (;;)
      {
        localObject = paramString;
        if (i >= arrayOfString.length) {
          break;
        }
        localObject = arrayOfString[i].split(",");
        paramString[i] = kd.b(new GeoPoint((int)(Double.parseDouble(localObject[1]) * 1000000.0D), (int)(Double.parseDouble(localObject[0]) * 1000000.0D)));
        i += 1;
      }
    }
    return localObject;
  }
  
  public static fw[] d(String paramString)
  {
    return (fw[])a.get(paramString);
  }
  
  /* Error */
  public final boolean a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 34	com/tencent/map/sdk/a/jv:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   4: invokevirtual 162	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   7: invokevirtual 167	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   10: new 169	java/io/File
    //   13: dup
    //   14: aload_0
    //   15: getfield 36	com/tencent/map/sdk/a/jv:b	Ljava/lang/String;
    //   18: invokespecial 170	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: astore 6
    //   23: new 169	java/io/File
    //   26: dup
    //   27: aload_0
    //   28: getfield 38	com/tencent/map/sdk/a/jv:c	Ljava/lang/String;
    //   31: invokespecial 170	java/io/File:<init>	(Ljava/lang/String;)V
    //   34: astore 7
    //   36: aload 7
    //   38: invokevirtual 173	java/io/File:exists	()Z
    //   41: ifeq +18 -> 59
    //   44: aload 7
    //   46: invokevirtual 176	java/io/File:delete	()Z
    //   49: ifne +10 -> 59
    //   52: aload 7
    //   54: invokevirtual 179	java/io/File:deleteOnExit	()V
    //   57: iconst_0
    //   58: ireturn
    //   59: aconst_null
    //   60: astore 4
    //   62: aconst_null
    //   63: astore 5
    //   65: aload 6
    //   67: invokevirtual 173	java/io/File:exists	()Z
    //   70: ifeq +42 -> 112
    //   73: aload 6
    //   75: aload 7
    //   77: invokevirtual 183	java/io/File:renameTo	(Ljava/io/File;)Z
    //   80: istore_2
    //   81: iload_2
    //   82: ifne +30 -> 112
    //   85: aload 5
    //   87: astore_1
    //   88: aload_1
    //   89: invokestatic 188	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   92: aload 7
    //   94: aload 6
    //   96: invokevirtual 183	java/io/File:renameTo	(Ljava/io/File;)Z
    //   99: pop
    //   100: aload_0
    //   101: getfield 34	com/tencent/map/sdk/a/jv:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   104: invokevirtual 162	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   107: invokevirtual 191	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   110: iconst_0
    //   111: ireturn
    //   112: new 193	java/io/FileOutputStream
    //   115: dup
    //   116: aload 6
    //   118: invokespecial 196	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   121: astore_3
    //   122: aload_3
    //   123: aload_1
    //   124: ldc 198
    //   126: invokevirtual 202	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   129: invokevirtual 206	java/io/FileOutputStream:write	([B)V
    //   132: aload_3
    //   133: invokevirtual 209	java/io/FileOutputStream:flush	()V
    //   136: aload_3
    //   137: invokestatic 188	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   140: aload 7
    //   142: invokevirtual 176	java/io/File:delete	()Z
    //   145: pop
    //   146: aload_0
    //   147: getfield 34	com/tencent/map/sdk/a/jv:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   150: invokevirtual 162	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   153: invokevirtual 191	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   156: iconst_1
    //   157: ireturn
    //   158: astore 4
    //   160: aload_3
    //   161: astore_1
    //   162: aload 4
    //   164: astore_3
    //   165: goto +12 -> 177
    //   168: aload_3
    //   169: astore_1
    //   170: goto -82 -> 88
    //   173: astore_3
    //   174: aload 4
    //   176: astore_1
    //   177: aload_1
    //   178: invokestatic 188	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   181: aload 7
    //   183: aload 6
    //   185: invokevirtual 183	java/io/File:renameTo	(Ljava/io/File;)Z
    //   188: pop
    //   189: aload_0
    //   190: getfield 34	com/tencent/map/sdk/a/jv:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   193: invokevirtual 162	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   196: invokevirtual 191	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   199: goto +5 -> 204
    //   202: aload_3
    //   203: athrow
    //   204: goto -2 -> 202
    //   207: astore_1
    //   208: aload 5
    //   210: astore_1
    //   211: goto -123 -> 88
    //   214: astore_1
    //   215: goto -47 -> 168
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	this	jv
    //   0	218	1	paramString	String
    //   80	2	2	bool	boolean
    //   121	48	3	localObject1	Object
    //   173	30	3	localObject2	Object
    //   60	1	4	localObject3	Object
    //   158	17	4	localObject4	Object
    //   63	146	5	localObject5	Object
    //   21	163	6	localFile1	java.io.File
    //   34	148	7	localFile2	java.io.File
    // Exception table:
    //   from	to	target	type
    //   122	136	158	finally
    //   65	81	173	finally
    //   112	122	173	finally
    //   65	81	207	java/lang/Throwable
    //   112	122	207	java/lang/Throwable
    //   122	136	214	java/lang/Throwable
  }
  
  /* Error */
  public final String b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 34	com/tencent/map/sdk/a/jv:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   4: invokevirtual 214	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   7: invokevirtual 217	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   10: aconst_null
    //   11: astore_3
    //   12: new 219	java/io/FileInputStream
    //   15: dup
    //   16: new 169	java/io/File
    //   19: dup
    //   20: aload_0
    //   21: getfield 36	com/tencent/map/sdk/a/jv:b	Ljava/lang/String;
    //   24: invokespecial 170	java/io/File:<init>	(Ljava/lang/String;)V
    //   27: invokespecial 220	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   30: astore_1
    //   31: new 67	java/lang/String
    //   34: dup
    //   35: aload_1
    //   36: invokestatic 223	com/tencent/map/sdk/a/on:a	(Ljava/io/InputStream;)[B
    //   39: ldc 198
    //   41: invokespecial 226	java/lang/String:<init>	([BLjava/lang/String;)V
    //   44: astore_2
    //   45: aload_1
    //   46: invokestatic 188	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   49: aload_0
    //   50: getfield 34	com/tencent/map/sdk/a/jv:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   53: invokevirtual 214	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   56: invokevirtual 227	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   59: aload_2
    //   60: areturn
    //   61: astore_2
    //   62: goto +6 -> 68
    //   65: astore_2
    //   66: aload_3
    //   67: astore_1
    //   68: aload_1
    //   69: invokestatic 188	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   72: aload_0
    //   73: getfield 34	com/tencent/map/sdk/a/jv:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   76: invokevirtual 214	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   79: invokevirtual 227	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   82: aload_2
    //   83: athrow
    //   84: aconst_null
    //   85: astore_1
    //   86: aload_1
    //   87: invokestatic 188	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   90: aload_0
    //   91: getfield 34	com/tencent/map/sdk/a/jv:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   94: invokevirtual 214	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   97: invokevirtual 227	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   100: aconst_null
    //   101: areturn
    //   102: astore_1
    //   103: goto -19 -> 84
    //   106: astore_2
    //   107: goto -21 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	jv
    //   30	57	1	localObject1	Object
    //   102	1	1	localThrowable1	Throwable
    //   44	16	2	str	String
    //   61	1	2	localObject2	Object
    //   65	18	2	localObject3	Object
    //   106	1	2	localThrowable2	Throwable
    //   11	56	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   31	45	61	finally
    //   12	31	65	finally
    //   12	31	102	java/lang/Throwable
    //   31	45	106	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.jv
 * JD-Core Version:    0.7.0.1
 */