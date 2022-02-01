package com.tencent.aladdin.config.network;

import android.support.v4.util.SparseArrayCompat;
import com.tencent.aladdin.config.utils.Log;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class AladdinConfigVersionManager
{
  private static final String TAG = "AladdinVersionUtils";
  private static final String VERSION_FILE_NAME = "versions.json";
  private final String basePath;
  private boolean mLoaded = false;
  private final Object mLock = new Object();
  private final SparseArrayCompat<Integer> sConfigVersionMap = new SparseArrayCompat();
  
  public AladdinConfigVersionManager(String paramString)
  {
    this.basePath = paramString;
  }
  
  private static void ensureParentExists(File paramFile)
  {
    Object localObject2 = paramFile.getParentFile().getParentFile();
    boolean bool;
    if (!((File)localObject2).exists())
    {
      localObject1 = ((File)localObject2).getAbsolutePath();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ensureParentExists: create ");
      localStringBuilder.append((String)localObject1);
      Log.d("AladdinVersionUtils", localStringBuilder.toString());
      bool = ((File)localObject2).mkdir();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("ensureParentExists: ");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(", result=");
      ((StringBuilder)localObject2).append(bool);
      Log.i("AladdinVersionUtils", ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = paramFile.getParentFile();
    if (!((File)localObject1).exists())
    {
      paramFile = ((File)localObject1).getAbsolutePath();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("ensureParentExists: create ");
      ((StringBuilder)localObject2).append(paramFile);
      Log.d("AladdinVersionUtils", ((StringBuilder)localObject2).toString());
      bool = ((File)localObject1).mkdir();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("ensureParentExists: ");
      ((StringBuilder)localObject1).append(paramFile);
      ((StringBuilder)localObject1).append(", result=");
      ((StringBuilder)localObject1).append(bool);
      Log.i("AladdinVersionUtils", ((StringBuilder)localObject1).toString());
    }
  }
  
  /* Error */
  private void loadFromDisk()
  {
    // Byte code:
    //   0: new 54	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   7: astore_1
    //   8: aload_1
    //   9: aload_0
    //   10: getfield 35	com/tencent/aladdin/config/network/AladdinConfigVersionManager:basePath	Ljava/lang/String;
    //   13: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload_1
    //   18: getstatic 91	java/io/File:separator	Ljava/lang/String;
    //   21: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload_1
    //   26: ldc 11
    //   28: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: new 40	java/io/File
    //   35: dup
    //   36: aload_1
    //   37: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokespecial 93	java/io/File:<init>	(Ljava/lang/String;)V
    //   43: astore_1
    //   44: aload_1
    //   45: invokestatic 95	com/tencent/aladdin/config/network/AladdinConfigVersionManager:ensureParentExists	(Ljava/io/File;)V
    //   48: new 97	java/io/FileInputStream
    //   51: dup
    //   52: aload_1
    //   53: invokespecial 99	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   56: astore_1
    //   57: new 101	java/io/BufferedReader
    //   60: dup
    //   61: new 103	java/io/InputStreamReader
    //   64: dup
    //   65: aload_1
    //   66: invokespecial 106	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   69: invokespecial 109	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   72: astore 4
    //   74: aload 4
    //   76: astore_2
    //   77: aload_1
    //   78: astore_3
    //   79: new 54	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   86: astore 5
    //   88: aload 4
    //   90: astore_2
    //   91: aload_1
    //   92: astore_3
    //   93: aload 4
    //   95: invokevirtual 112	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   98: astore 6
    //   100: aload 6
    //   102: ifnull +32 -> 134
    //   105: aload 4
    //   107: astore_2
    //   108: aload_1
    //   109: astore_3
    //   110: aload 5
    //   112: aload 6
    //   114: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload 4
    //   120: astore_2
    //   121: aload_1
    //   122: astore_3
    //   123: aload 5
    //   125: ldc 114
    //   127: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: goto -43 -> 88
    //   134: aload 4
    //   136: astore_2
    //   137: aload_1
    //   138: astore_3
    //   139: aload 4
    //   141: invokevirtual 117	java/io/BufferedReader:close	()V
    //   144: aload 4
    //   146: astore_2
    //   147: aload_1
    //   148: astore_3
    //   149: aload_1
    //   150: invokevirtual 118	java/io/FileInputStream:close	()V
    //   153: aload 4
    //   155: astore_2
    //   156: aload_1
    //   157: astore_3
    //   158: aload 5
    //   160: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: astore 5
    //   165: aload 4
    //   167: astore_2
    //   168: aload_1
    //   169: astore_3
    //   170: invokestatic 121	com/tencent/aladdin/config/utils/Log:isDebugVersion	()Z
    //   173: ifeq +58 -> 231
    //   176: aload 4
    //   178: astore_2
    //   179: aload_1
    //   180: astore_3
    //   181: new 54	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   188: astore 6
    //   190: aload 4
    //   192: astore_2
    //   193: aload_1
    //   194: astore_3
    //   195: aload 6
    //   197: ldc 123
    //   199: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: aload 4
    //   205: astore_2
    //   206: aload_1
    //   207: astore_3
    //   208: aload 6
    //   210: aload 5
    //   212: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload 4
    //   218: astore_2
    //   219: aload_1
    //   220: astore_3
    //   221: ldc 8
    //   223: aload 6
    //   225: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokestatic 70	com/tencent/aladdin/config/utils/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   231: aload 4
    //   233: astore_2
    //   234: aload_1
    //   235: astore_3
    //   236: new 125	org/json/JSONObject
    //   239: dup
    //   240: aload 5
    //   242: invokespecial 126	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   245: astore 5
    //   247: aload 4
    //   249: astore_2
    //   250: aload_1
    //   251: astore_3
    //   252: aload_0
    //   253: getfield 33	com/tencent/aladdin/config/network/AladdinConfigVersionManager:sConfigVersionMap	Landroid/support/v4/util/SparseArrayCompat;
    //   256: aload 5
    //   258: invokestatic 130	com/tencent/aladdin/config/network/AladdinConfigVersionManager:parseJson	(Landroid/support/v4/util/SparseArrayCompat;Lorg/json/JSONObject;)V
    //   261: aload 4
    //   263: invokevirtual 117	java/io/BufferedReader:close	()V
    //   266: aload_1
    //   267: invokevirtual 118	java/io/FileInputStream:close	()V
    //   270: return
    //   271: astore 5
    //   273: goto +45 -> 318
    //   276: astore 5
    //   278: goto +78 -> 356
    //   281: astore_2
    //   282: aconst_null
    //   283: astore_3
    //   284: goto +113 -> 397
    //   287: astore 5
    //   289: aconst_null
    //   290: astore 4
    //   292: goto +26 -> 318
    //   295: astore 5
    //   297: aconst_null
    //   298: astore 4
    //   300: goto +56 -> 356
    //   303: astore_2
    //   304: aconst_null
    //   305: astore_3
    //   306: aload_3
    //   307: astore_1
    //   308: goto +89 -> 397
    //   311: astore 5
    //   313: aconst_null
    //   314: astore_1
    //   315: aload_1
    //   316: astore 4
    //   318: aload 4
    //   320: astore_2
    //   321: aload_1
    //   322: astore_3
    //   323: ldc 8
    //   325: ldc 132
    //   327: aload 5
    //   329: invokestatic 136	com/tencent/aladdin/config/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   332: aload 4
    //   334: ifnull +8 -> 342
    //   337: aload 4
    //   339: invokevirtual 117	java/io/BufferedReader:close	()V
    //   342: aload_1
    //   343: ifnull +44 -> 387
    //   346: goto -80 -> 266
    //   349: astore 5
    //   351: aconst_null
    //   352: astore_1
    //   353: aload_1
    //   354: astore 4
    //   356: aload 4
    //   358: astore_2
    //   359: aload_1
    //   360: astore_3
    //   361: ldc 8
    //   363: ldc 132
    //   365: aload 5
    //   367: invokestatic 136	com/tencent/aladdin/config/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   370: aload 4
    //   372: ifnull +8 -> 380
    //   375: aload 4
    //   377: invokevirtual 117	java/io/BufferedReader:close	()V
    //   380: aload_1
    //   381: ifnull +6 -> 387
    //   384: goto -118 -> 266
    //   387: return
    //   388: astore 4
    //   390: aload_3
    //   391: astore_1
    //   392: aload_2
    //   393: astore_3
    //   394: aload 4
    //   396: astore_2
    //   397: aload_3
    //   398: ifnull +7 -> 405
    //   401: aload_3
    //   402: invokevirtual 117	java/io/BufferedReader:close	()V
    //   405: aload_1
    //   406: ifnull +7 -> 413
    //   409: aload_1
    //   410: invokevirtual 118	java/io/FileInputStream:close	()V
    //   413: goto +5 -> 418
    //   416: aload_2
    //   417: athrow
    //   418: goto -2 -> 416
    //   421: astore_1
    //   422: return
    //   423: astore_1
    //   424: goto -11 -> 413
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	427	0	this	AladdinConfigVersionManager
    //   7	403	1	localObject1	Object
    //   421	1	1	localIOException1	IOException
    //   423	1	1	localIOException2	IOException
    //   76	174	2	localObject2	Object
    //   281	1	2	localObject3	Object
    //   303	1	2	localObject4	Object
    //   320	97	2	localObject5	Object
    //   78	324	3	localObject6	Object
    //   72	304	4	localObject7	Object
    //   388	7	4	localObject8	Object
    //   86	171	5	localObject9	Object
    //   271	1	5	localJSONException1	JSONException
    //   276	1	5	localIOException3	IOException
    //   287	1	5	localJSONException2	JSONException
    //   295	1	5	localIOException4	IOException
    //   311	17	5	localJSONException3	JSONException
    //   349	17	5	localIOException5	IOException
    //   98	126	6	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   79	88	271	org/json/JSONException
    //   93	100	271	org/json/JSONException
    //   110	118	271	org/json/JSONException
    //   123	131	271	org/json/JSONException
    //   139	144	271	org/json/JSONException
    //   149	153	271	org/json/JSONException
    //   158	165	271	org/json/JSONException
    //   170	176	271	org/json/JSONException
    //   181	190	271	org/json/JSONException
    //   195	203	271	org/json/JSONException
    //   208	216	271	org/json/JSONException
    //   221	231	271	org/json/JSONException
    //   236	247	271	org/json/JSONException
    //   252	261	271	org/json/JSONException
    //   79	88	276	java/io/IOException
    //   93	100	276	java/io/IOException
    //   110	118	276	java/io/IOException
    //   123	131	276	java/io/IOException
    //   139	144	276	java/io/IOException
    //   149	153	276	java/io/IOException
    //   158	165	276	java/io/IOException
    //   170	176	276	java/io/IOException
    //   181	190	276	java/io/IOException
    //   195	203	276	java/io/IOException
    //   208	216	276	java/io/IOException
    //   221	231	276	java/io/IOException
    //   236	247	276	java/io/IOException
    //   252	261	276	java/io/IOException
    //   57	74	281	finally
    //   57	74	287	org/json/JSONException
    //   57	74	295	java/io/IOException
    //   44	57	303	finally
    //   44	57	311	org/json/JSONException
    //   44	57	349	java/io/IOException
    //   79	88	388	finally
    //   93	100	388	finally
    //   110	118	388	finally
    //   123	131	388	finally
    //   139	144	388	finally
    //   149	153	388	finally
    //   158	165	388	finally
    //   170	176	388	finally
    //   181	190	388	finally
    //   195	203	388	finally
    //   208	216	388	finally
    //   221	231	388	finally
    //   236	247	388	finally
    //   252	261	388	finally
    //   323	332	388	finally
    //   361	370	388	finally
    //   261	266	421	java/io/IOException
    //   266	270	421	java/io/IOException
    //   337	342	421	java/io/IOException
    //   375	380	421	java/io/IOException
    //   401	405	423	java/io/IOException
    //   409	413	423	java/io/IOException
  }
  
  private static void parseJson(SparseArrayCompat<Integer> paramSparseArrayCompat, JSONObject paramJSONObject)
  {
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        paramSparseArrayCompat.put(Integer.valueOf(str).intValue(), Integer.valueOf(paramJSONObject.getInt(str)));
      }
      catch (NumberFormatException localNumberFormatException)
      {
        Log.e("AladdinVersionUtils", "parseJson: ", localNumberFormatException);
      }
      catch (JSONException localJSONException)
      {
        Log.e("AladdinVersionUtils", "parseJson: ", localJSONException);
      }
    }
  }
  
  private static String toJson(SparseArrayCompat<Integer> paramSparseArrayCompat)
  {
    JSONObject localJSONObject = new JSONObject();
    int j = paramSparseArrayCompat.size();
    int i = 0;
    while (i < j)
    {
      int k = paramSparseArrayCompat.keyAt(i);
      localJSONObject.put(String.valueOf(k), paramSparseArrayCompat.get(k, Integer.valueOf(0)));
      i += 1;
    }
    return localJSONObject.toString();
  }
  
  boolean flush()
  {
    synchronized (this.mLock)
    {
      try
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.basePath);
        ((StringBuilder)localObject2).append(File.separator);
        ((StringBuilder)localObject2).append("versions.json");
        localObject2 = new File(((StringBuilder)localObject2).toString());
        ensureParentExists((File)localObject2);
        localObject2 = new PrintWriter((File)localObject2);
        ((PrintWriter)localObject2).print(toJson(this.sConfigVersionMap));
        ((PrintWriter)localObject2).close();
        return true;
      }
      catch (JSONException localJSONException)
      {
        Log.e("AladdinVersionUtils", "flush: ", localJSONException);
      }
      catch (IOException localIOException)
      {
        Log.e("AladdinVersionUtils", "flush: ", localIOException);
      }
      return false;
      throw localIOException;
    }
  }
  
  int getConfigVersionById(int paramInt)
  {
    for (;;)
    {
      synchronized (this.mLock)
      {
        if (!this.mLoaded)
        {
          loadFromDisk();
          this.mLoaded = true;
        }
        synchronized (this.mLock)
        {
          Integer localInteger = (Integer)this.sConfigVersionMap.get(paramInt);
          if (localInteger != null)
          {
            paramInt = localInteger.intValue();
            return paramInt;
          }
        }
      }
      paramInt = 0;
    }
  }
  
  void setConfigVersionById(int paramInt1, int paramInt2)
  {
    synchronized (this.mLock)
    {
      this.sConfigVersionMap.put(paramInt1, Integer.valueOf(paramInt2));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aladdin.config.network.AladdinConfigVersionManager
 * JD-Core Version:    0.7.0.1
 */