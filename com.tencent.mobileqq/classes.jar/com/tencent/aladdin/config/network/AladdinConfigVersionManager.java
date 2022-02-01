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
    Object localObject = paramFile.getParentFile().getParentFile();
    boolean bool;
    if (!((File)localObject).exists())
    {
      String str = ((File)localObject).getAbsolutePath();
      Log.d("AladdinVersionUtils", "ensureParentExists: create " + str);
      bool = ((File)localObject).mkdir();
      Log.i("AladdinVersionUtils", "ensureParentExists: " + str + ", result=" + bool);
    }
    paramFile = paramFile.getParentFile();
    if (!paramFile.exists())
    {
      localObject = paramFile.getAbsolutePath();
      Log.d("AladdinVersionUtils", "ensureParentExists: create " + (String)localObject);
      bool = paramFile.mkdir();
      Log.i("AladdinVersionUtils", "ensureParentExists: " + (String)localObject + ", result=" + bool);
    }
  }
  
  /* Error */
  private void loadFromDisk()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 40	java/io/File
    //   5: dup
    //   6: new 54	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   13: aload_0
    //   14: getfield 35	com/tencent/aladdin/config/network/AladdinConfigVersionManager:basePath	Ljava/lang/String;
    //   17: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: getstatic 91	java/io/File:separator	Ljava/lang/String;
    //   23: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc 11
    //   28: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokespecial 93	java/io/File:<init>	(Ljava/lang/String;)V
    //   37: astore_1
    //   38: aload_1
    //   39: invokestatic 95	com/tencent/aladdin/config/network/AladdinConfigVersionManager:ensureParentExists	(Ljava/io/File;)V
    //   42: new 97	java/io/FileInputStream
    //   45: dup
    //   46: aload_1
    //   47: invokespecial 99	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   50: astore_1
    //   51: new 101	java/io/BufferedReader
    //   54: dup
    //   55: new 103	java/io/InputStreamReader
    //   58: dup
    //   59: aload_1
    //   60: invokespecial 106	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   63: invokespecial 109	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   66: astore_3
    //   67: aload_3
    //   68: astore 5
    //   70: aload_1
    //   71: astore 4
    //   73: new 54	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   80: astore_2
    //   81: aload_3
    //   82: astore 5
    //   84: aload_1
    //   85: astore 4
    //   87: aload_3
    //   88: invokevirtual 112	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   91: astore 6
    //   93: aload 6
    //   95: ifnull +58 -> 153
    //   98: aload_3
    //   99: astore 5
    //   101: aload_1
    //   102: astore 4
    //   104: aload_2
    //   105: aload 6
    //   107: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: ldc 114
    //   112: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: goto -35 -> 81
    //   119: astore 4
    //   121: aload_1
    //   122: astore_2
    //   123: aload_3
    //   124: astore_1
    //   125: aload 4
    //   127: astore_3
    //   128: ldc 8
    //   130: ldc 116
    //   132: aload_3
    //   133: invokestatic 120	com/tencent/aladdin/config/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   136: aload_1
    //   137: ifnull +7 -> 144
    //   140: aload_1
    //   141: invokevirtual 123	java/io/BufferedReader:close	()V
    //   144: aload_2
    //   145: ifnull +7 -> 152
    //   148: aload_2
    //   149: invokevirtual 124	java/io/FileInputStream:close	()V
    //   152: return
    //   153: aload_3
    //   154: astore 5
    //   156: aload_1
    //   157: astore 4
    //   159: aload_3
    //   160: invokevirtual 123	java/io/BufferedReader:close	()V
    //   163: aload_3
    //   164: astore 5
    //   166: aload_1
    //   167: astore 4
    //   169: aload_1
    //   170: invokevirtual 124	java/io/FileInputStream:close	()V
    //   173: aload_3
    //   174: astore 5
    //   176: aload_1
    //   177: astore 4
    //   179: aload_2
    //   180: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: astore_2
    //   184: aload_3
    //   185: astore 5
    //   187: aload_1
    //   188: astore 4
    //   190: invokestatic 127	com/tencent/aladdin/config/utils/Log:isDebugVersion	()Z
    //   193: ifeq +33 -> 226
    //   196: aload_3
    //   197: astore 5
    //   199: aload_1
    //   200: astore 4
    //   202: ldc 8
    //   204: new 54	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   211: ldc 129
    //   213: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: aload_2
    //   217: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 70	com/tencent/aladdin/config/utils/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   226: aload_3
    //   227: astore 5
    //   229: aload_1
    //   230: astore 4
    //   232: new 131	org/json/JSONObject
    //   235: dup
    //   236: aload_2
    //   237: invokespecial 132	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   240: astore_2
    //   241: aload_3
    //   242: astore 5
    //   244: aload_1
    //   245: astore 4
    //   247: aload_0
    //   248: getfield 33	com/tencent/aladdin/config/network/AladdinConfigVersionManager:sConfigVersionMap	Landroid/support/v4/util/SparseArrayCompat;
    //   251: aload_2
    //   252: invokestatic 136	com/tencent/aladdin/config/network/AladdinConfigVersionManager:parseJson	(Landroid/support/v4/util/SparseArrayCompat;Lorg/json/JSONObject;)V
    //   255: aload_3
    //   256: ifnull +7 -> 263
    //   259: aload_3
    //   260: invokevirtual 123	java/io/BufferedReader:close	()V
    //   263: aload_1
    //   264: ifnull -112 -> 152
    //   267: aload_1
    //   268: invokevirtual 124	java/io/FileInputStream:close	()V
    //   271: return
    //   272: astore_1
    //   273: return
    //   274: astore 6
    //   276: aconst_null
    //   277: astore_2
    //   278: aconst_null
    //   279: astore_1
    //   280: aload_2
    //   281: astore 5
    //   283: aload_1
    //   284: astore 4
    //   286: ldc 8
    //   288: ldc 116
    //   290: aload 6
    //   292: invokestatic 120	com/tencent/aladdin/config/utils/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   295: aload_2
    //   296: ifnull +7 -> 303
    //   299: aload_2
    //   300: invokevirtual 123	java/io/BufferedReader:close	()V
    //   303: aload_1
    //   304: ifnull -152 -> 152
    //   307: aload_1
    //   308: invokevirtual 124	java/io/FileInputStream:close	()V
    //   311: return
    //   312: astore_1
    //   313: return
    //   314: astore_2
    //   315: aconst_null
    //   316: astore_3
    //   317: aconst_null
    //   318: astore_1
    //   319: aload_3
    //   320: ifnull +7 -> 327
    //   323: aload_3
    //   324: invokevirtual 123	java/io/BufferedReader:close	()V
    //   327: aload_1
    //   328: ifnull +7 -> 335
    //   331: aload_1
    //   332: invokevirtual 124	java/io/FileInputStream:close	()V
    //   335: aload_2
    //   336: athrow
    //   337: astore_1
    //   338: goto -3 -> 335
    //   341: astore_2
    //   342: aconst_null
    //   343: astore_3
    //   344: goto -25 -> 319
    //   347: astore_2
    //   348: aload 5
    //   350: astore_3
    //   351: aload 4
    //   353: astore_1
    //   354: goto -35 -> 319
    //   357: astore_3
    //   358: aload_2
    //   359: astore 4
    //   361: aload_3
    //   362: astore_2
    //   363: aload_1
    //   364: astore_3
    //   365: aload 4
    //   367: astore_1
    //   368: goto -49 -> 319
    //   371: astore 6
    //   373: aconst_null
    //   374: astore_2
    //   375: goto -95 -> 280
    //   378: astore 6
    //   380: aload_3
    //   381: astore_2
    //   382: goto -102 -> 280
    //   385: astore_1
    //   386: return
    //   387: astore_3
    //   388: aconst_null
    //   389: astore_1
    //   390: goto -262 -> 128
    //   393: astore_3
    //   394: aconst_null
    //   395: astore 4
    //   397: aload_1
    //   398: astore_2
    //   399: aload 4
    //   401: astore_1
    //   402: goto -274 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	405	0	this	AladdinConfigVersionManager
    //   37	231	1	localObject1	Object
    //   272	1	1	localIOException1	IOException
    //   279	29	1	localObject2	Object
    //   312	1	1	localIOException2	IOException
    //   318	14	1	localObject3	Object
    //   337	1	1	localIOException3	IOException
    //   353	15	1	localObject4	Object
    //   385	1	1	localIOException4	IOException
    //   389	13	1	localObject5	Object
    //   1	299	2	localObject6	Object
    //   314	22	2	localObject7	Object
    //   341	1	2	localObject8	Object
    //   347	12	2	localObject9	Object
    //   362	37	2	localObject10	Object
    //   66	285	3	localObject11	Object
    //   357	5	3	localObject12	Object
    //   364	17	3	localObject13	Object
    //   387	1	3	localIOException5	IOException
    //   393	1	3	localIOException6	IOException
    //   71	32	4	localObject14	Object
    //   119	7	4	localIOException7	IOException
    //   157	243	4	localObject15	Object
    //   68	281	5	localObject16	Object
    //   91	15	6	str	String
    //   274	17	6	localJSONException1	JSONException
    //   371	1	6	localJSONException2	JSONException
    //   378	1	6	localJSONException3	JSONException
    // Exception table:
    //   from	to	target	type
    //   73	81	119	java/io/IOException
    //   87	93	119	java/io/IOException
    //   104	116	119	java/io/IOException
    //   159	163	119	java/io/IOException
    //   169	173	119	java/io/IOException
    //   179	184	119	java/io/IOException
    //   190	196	119	java/io/IOException
    //   202	226	119	java/io/IOException
    //   232	241	119	java/io/IOException
    //   247	255	119	java/io/IOException
    //   259	263	272	java/io/IOException
    //   267	271	272	java/io/IOException
    //   38	51	274	org/json/JSONException
    //   299	303	312	java/io/IOException
    //   307	311	312	java/io/IOException
    //   38	51	314	finally
    //   323	327	337	java/io/IOException
    //   331	335	337	java/io/IOException
    //   51	67	341	finally
    //   73	81	347	finally
    //   87	93	347	finally
    //   104	116	347	finally
    //   159	163	347	finally
    //   169	173	347	finally
    //   179	184	347	finally
    //   190	196	347	finally
    //   202	226	347	finally
    //   232	241	347	finally
    //   247	255	347	finally
    //   286	295	347	finally
    //   128	136	357	finally
    //   51	67	371	org/json/JSONException
    //   73	81	378	org/json/JSONException
    //   87	93	378	org/json/JSONException
    //   104	116	378	org/json/JSONException
    //   159	163	378	org/json/JSONException
    //   169	173	378	org/json/JSONException
    //   179	184	378	org/json/JSONException
    //   190	196	378	org/json/JSONException
    //   202	226	378	org/json/JSONException
    //   232	241	378	org/json/JSONException
    //   247	255	378	org/json/JSONException
    //   140	144	385	java/io/IOException
    //   148	152	385	java/io/IOException
    //   38	51	387	java/io/IOException
    //   51	67	393	java/io/IOException
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
      catch (JSONException localJSONException)
      {
        Log.e("AladdinVersionUtils", "parseJson: ", localJSONException);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        Log.e("AladdinVersionUtils", "parseJson: ", localNumberFormatException);
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
        Object localObject2 = new File(this.basePath + File.separator + "versions.json");
        ensureParentExists((File)localObject2);
        localObject2 = new PrintWriter((File)localObject2);
        ((PrintWriter)localObject2).print(toJson(this.sConfigVersionMap));
        ((PrintWriter)localObject2).close();
        return true;
      }
      catch (IOException localIOException)
      {
        Log.e("AladdinVersionUtils", "flush: ", localIOException);
        return false;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          Log.e("AladdinVersionUtils", "flush: ", localJSONException);
        }
      }
    }
  }
  
  int getConfigVersionById(int paramInt)
  {
    synchronized (this.mLock)
    {
      if (!this.mLoaded)
      {
        loadFromDisk();
        this.mLoaded = true;
      }
    }
    synchronized (this.mLock)
    {
      Integer localInteger = (Integer)this.sConfigVersionMap.get(paramInt);
      if (localInteger != null)
      {
        paramInt = localInteger.intValue();
        return paramInt;
        localObject2 = finally;
        throw localObject2;
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