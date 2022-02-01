package com.tencent.map.sdk.a;

import android.content.Context;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;

public class jh
{
  private static volatile jh d;
  public int a;
  public List<jg> b = new ArrayList();
  public ExecutorService c = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque());
  private String e;
  private String f;
  private String g;
  
  private jh(lf paramlf)
  {
    this.e = (paramlf.b().getFilesDir().getAbsolutePath() + File.separator + "stData");
    om.a(this.e);
    this.f = "";
    this.g = "";
    if (paramlf.d() != null)
    {
      this.f = paramlf.d().getSubKey();
      this.g = paramlf.d().getSubId();
    }
    this.c.execute(new jh.1(this));
  }
  
  public static jh a(lf paramlf)
  {
    if (d == null) {}
    try
    {
      if (d == null) {
        d = new jh(paramlf);
      }
      return d;
    }
    finally {}
  }
  
  /* Error */
  private void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 132	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +41 -> 49
    //   11: new 134	java/io/FileOutputStream
    //   14: dup
    //   15: aload_0
    //   16: getfield 79	com/tencent/map/sdk/a/jh:e	Ljava/lang/String;
    //   19: invokespecial 136	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   22: astore 4
    //   24: aload 4
    //   26: astore_3
    //   27: aload 4
    //   29: aload_1
    //   30: invokevirtual 142	java/lang/String:getBytes	()[B
    //   33: invokevirtual 146	java/io/FileOutputStream:write	([B)V
    //   36: aload 4
    //   38: astore_3
    //   39: aload 4
    //   41: invokevirtual 149	java/io/FileOutputStream:flush	()V
    //   44: aload 4
    //   46: invokestatic 154	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   49: aload_0
    //   50: monitorexit
    //   51: return
    //   52: astore 5
    //   54: aconst_null
    //   55: astore_1
    //   56: aload_1
    //   57: astore_3
    //   58: aload 5
    //   60: invokestatic 160	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   63: invokestatic 163	com/tencent/map/sdk/a/or:a	(Ljava/lang/String;)V
    //   66: aload_1
    //   67: invokestatic 154	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   70: goto -21 -> 49
    //   73: astore_1
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    //   78: astore_1
    //   79: aconst_null
    //   80: astore_3
    //   81: aload_3
    //   82: invokestatic 154	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   85: aload_1
    //   86: athrow
    //   87: astore_1
    //   88: goto -7 -> 81
    //   91: astore 5
    //   93: aload 4
    //   95: astore_1
    //   96: goto -40 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	this	jh
    //   0	99	1	paramString	String
    //   6	2	2	bool	boolean
    //   26	56	3	localObject	Object
    //   22	72	4	localFileOutputStream	java.io.FileOutputStream
    //   52	7	5	localException1	java.lang.Exception
    //   91	1	5	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   11	24	52	java/lang/Exception
    //   2	7	73	finally
    //   44	49	73	finally
    //   66	70	73	finally
    //   81	87	73	finally
    //   11	24	78	finally
    //   27	36	87	finally
    //   39	44	87	finally
    //   58	66	87	finally
    //   27	36	91	java/lang/Exception
    //   39	44	91	java/lang/Exception
  }
  
  public final JSONArray a(List<jg> paramList)
  {
    JSONArray localJSONArray;
    try
    {
      localJSONArray = new JSONArray();
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          Object localObject = (jg)paramList.next();
          if (localObject != null)
          {
            localObject = ((jg)localObject).a();
            if (localObject != null) {
              localJSONArray.put(localObject);
            }
          }
        }
      }
    }
    finally {}
    return localJSONArray;
  }
  
  /* Error */
  public final void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 197	java/io/BufferedReader
    //   5: dup
    //   6: new 199	java/io/FileReader
    //   9: dup
    //   10: aload_0
    //   11: getfield 79	com/tencent/map/sdk/a/jh:e	Ljava/lang/String;
    //   14: invokespecial 200	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   17: invokespecial 203	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   20: astore_3
    //   21: aload_3
    //   22: astore_2
    //   23: aload_3
    //   24: invokevirtual 206	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   27: astore 4
    //   29: aload 4
    //   31: ifnull +74 -> 105
    //   34: aload_3
    //   35: astore_2
    //   36: new 167	org/json/JSONArray
    //   39: dup
    //   40: aload 4
    //   42: invokespecial 207	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   45: astore 4
    //   47: aload_3
    //   48: astore_2
    //   49: aload 4
    //   51: invokevirtual 211	org/json/JSONArray:length	()I
    //   54: ifle -33 -> 21
    //   57: iconst_0
    //   58: istore_1
    //   59: aload_3
    //   60: astore_2
    //   61: iload_1
    //   62: aload 4
    //   64: invokevirtual 211	org/json/JSONArray:length	()I
    //   67: if_icmpge -46 -> 21
    //   70: aload_3
    //   71: astore_2
    //   72: aload 4
    //   74: iload_1
    //   75: invokevirtual 215	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   78: invokestatic 218	com/tencent/map/sdk/a/jg:a	(Lorg/json/JSONObject;)Lcom/tencent/map/sdk/a/jg;
    //   81: astore 5
    //   83: aload 5
    //   85: ifnull +99 -> 184
    //   88: aload_3
    //   89: astore_2
    //   90: aload_0
    //   91: getfield 45	com/tencent/map/sdk/a/jh:b	Ljava/util/List;
    //   94: aload 5
    //   96: invokeinterface 222 2 0
    //   101: pop
    //   102: goto +82 -> 184
    //   105: aload_3
    //   106: astore_2
    //   107: aload_0
    //   108: getfield 79	com/tencent/map/sdk/a/jh:e	Ljava/lang/String;
    //   111: invokestatic 224	com/tencent/map/sdk/a/on:c	(Ljava/lang/String;)Z
    //   114: pop
    //   115: aload_3
    //   116: invokestatic 154	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   119: aload_0
    //   120: monitorexit
    //   121: return
    //   122: astore 4
    //   124: aconst_null
    //   125: astore_3
    //   126: aload_3
    //   127: astore_2
    //   128: invokestatic 226	com/tencent/map/sdk/a/or:a	()Z
    //   131: ifeq +23 -> 154
    //   134: aload_3
    //   135: astore_2
    //   136: invokestatic 226	com/tencent/map/sdk/a/or:a	()Z
    //   139: ifeq +15 -> 154
    //   142: aload_3
    //   143: astore_2
    //   144: ldc 228
    //   146: ldc 230
    //   148: aload 4
    //   150: invokestatic 234	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   153: pop
    //   154: aload_3
    //   155: invokestatic 154	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   158: goto -39 -> 119
    //   161: astore_2
    //   162: aload_0
    //   163: monitorexit
    //   164: aload_2
    //   165: athrow
    //   166: astore_3
    //   167: aconst_null
    //   168: astore_2
    //   169: aload_2
    //   170: invokestatic 154	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   173: aload_3
    //   174: athrow
    //   175: astore_3
    //   176: goto -7 -> 169
    //   179: astore 4
    //   181: goto -55 -> 126
    //   184: iload_1
    //   185: iconst_1
    //   186: iadd
    //   187: istore_1
    //   188: goto -129 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	this	jh
    //   58	130	1	i	int
    //   22	122	2	localBufferedReader1	java.io.BufferedReader
    //   161	4	2	localObject1	Object
    //   168	2	2	localCloseable	java.io.Closeable
    //   20	135	3	localBufferedReader2	java.io.BufferedReader
    //   166	8	3	localObject2	Object
    //   175	1	3	localObject3	Object
    //   27	46	4	localObject4	Object
    //   122	27	4	localException1	java.lang.Exception
    //   179	1	4	localException2	java.lang.Exception
    //   81	14	5	localjg	jg
    // Exception table:
    //   from	to	target	type
    //   2	21	122	java/lang/Exception
    //   115	119	161	finally
    //   154	158	161	finally
    //   169	175	161	finally
    //   2	21	166	finally
    //   23	29	175	finally
    //   36	47	175	finally
    //   49	57	175	finally
    //   61	70	175	finally
    //   72	83	175	finally
    //   90	102	175	finally
    //   107	115	175	finally
    //   128	134	175	finally
    //   136	142	175	finally
    //   144	154	175	finally
    //   23	29	179	java/lang/Exception
    //   36	47	179	java/lang/Exception
    //   49	57	179	java/lang/Exception
    //   61	70	179	java/lang/Exception
    //   72	83	179	java/lang/Exception
    //   90	102	179	java/lang/Exception
    //   107	115	179	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.jh
 * JD-Core Version:    0.7.0.1
 */