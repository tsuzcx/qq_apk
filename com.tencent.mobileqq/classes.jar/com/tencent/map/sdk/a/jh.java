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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramlf.b().getFilesDir().getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("stData");
    this.e = localStringBuilder.toString();
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
    if (d == null) {
      try
      {
        if (d == null) {
          d = new jh(paramlf);
        }
      }
      finally {}
    }
    return d;
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
    //   8: ifne +92 -> 100
    //   11: aconst_null
    //   12: astore 5
    //   14: aconst_null
    //   15: astore_3
    //   16: new 134	java/io/FileOutputStream
    //   19: dup
    //   20: aload_0
    //   21: getfield 79	com/tencent/map/sdk/a/jh:e	Ljava/lang/String;
    //   24: invokespecial 136	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   27: astore 4
    //   29: aload 4
    //   31: aload_1
    //   32: invokevirtual 142	java/lang/String:getBytes	()[B
    //   35: invokevirtual 146	java/io/FileOutputStream:write	([B)V
    //   38: aload 4
    //   40: invokevirtual 149	java/io/FileOutputStream:flush	()V
    //   43: aload 4
    //   45: invokestatic 154	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   48: aload_0
    //   49: monitorexit
    //   50: return
    //   51: astore_1
    //   52: aload 4
    //   54: astore_3
    //   55: goto +39 -> 94
    //   58: astore_3
    //   59: aload 4
    //   61: astore_1
    //   62: aload_3
    //   63: astore 4
    //   65: goto +12 -> 77
    //   68: astore_1
    //   69: goto +25 -> 94
    //   72: astore 4
    //   74: aload 5
    //   76: astore_1
    //   77: aload_1
    //   78: astore_3
    //   79: aload 4
    //   81: invokestatic 160	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   84: invokestatic 163	com/tencent/map/sdk/a/or:a	(Ljava/lang/String;)V
    //   87: aload_1
    //   88: invokestatic 154	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   91: aload_0
    //   92: monitorexit
    //   93: return
    //   94: aload_3
    //   95: invokestatic 154	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   98: aload_1
    //   99: athrow
    //   100: aload_0
    //   101: monitorexit
    //   102: return
    //   103: astore_1
    //   104: aload_0
    //   105: monitorexit
    //   106: aload_1
    //   107: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	jh
    //   0	108	1	paramString	String
    //   6	2	2	bool	boolean
    //   15	40	3	localObject1	Object
    //   58	5	3	localException1	java.lang.Exception
    //   78	17	3	str	String
    //   27	37	4	localObject2	Object
    //   72	8	4	localException2	java.lang.Exception
    //   12	63	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   29	43	51	finally
    //   29	43	58	java/lang/Exception
    //   16	29	68	finally
    //   79	87	68	finally
    //   16	29	72	java/lang/Exception
    //   2	7	103	finally
    //   43	48	103	finally
    //   87	91	103	finally
    //   94	100	103	finally
  }
  
  public final JSONArray a(List<jg> paramList)
  {
    try
    {
      JSONArray localJSONArray = new JSONArray();
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
      return localJSONArray;
    }
    finally {}
    for (;;)
    {
      throw paramList;
    }
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
    //   85: ifnull +111 -> 196
    //   88: aload_3
    //   89: astore_2
    //   90: aload_0
    //   91: getfield 45	com/tencent/map/sdk/a/jh:b	Ljava/util/List;
    //   94: aload 5
    //   96: invokeinterface 222 2 0
    //   101: pop
    //   102: goto +94 -> 196
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
    //   124: goto +13 -> 137
    //   127: astore_2
    //   128: aconst_null
    //   129: astore_3
    //   130: goto +49 -> 179
    //   133: astore 4
    //   135: aconst_null
    //   136: astore_3
    //   137: aload_3
    //   138: astore_2
    //   139: invokestatic 226	com/tencent/map/sdk/a/or:a	()Z
    //   142: ifeq +23 -> 165
    //   145: aload_3
    //   146: astore_2
    //   147: invokestatic 226	com/tencent/map/sdk/a/or:a	()Z
    //   150: ifeq +15 -> 165
    //   153: aload_3
    //   154: astore_2
    //   155: ldc 228
    //   157: ldc 230
    //   159: aload 4
    //   161: invokestatic 234	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   164: pop
    //   165: aload_3
    //   166: invokestatic 154	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   169: aload_0
    //   170: monitorexit
    //   171: return
    //   172: astore 4
    //   174: aload_2
    //   175: astore_3
    //   176: aload 4
    //   178: astore_2
    //   179: aload_3
    //   180: invokestatic 154	com/tencent/map/sdk/a/on:a	(Ljava/io/Closeable;)V
    //   183: aload_2
    //   184: athrow
    //   185: astore_2
    //   186: aload_0
    //   187: monitorexit
    //   188: goto +5 -> 193
    //   191: aload_2
    //   192: athrow
    //   193: goto -2 -> 191
    //   196: iload_1
    //   197: iconst_1
    //   198: iadd
    //   199: istore_1
    //   200: goto -141 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	this	jh
    //   58	142	1	i	int
    //   22	85	2	localObject1	Object
    //   127	1	2	localObject2	Object
    //   138	46	2	localObject3	Object
    //   185	7	2	localObject4	Object
    //   20	160	3	localObject5	Object
    //   27	46	4	localObject6	Object
    //   122	1	4	localException1	java.lang.Exception
    //   133	27	4	localException2	java.lang.Exception
    //   172	5	4	localObject7	Object
    //   81	14	5	localjg	jg
    // Exception table:
    //   from	to	target	type
    //   23	29	122	java/lang/Exception
    //   36	47	122	java/lang/Exception
    //   49	57	122	java/lang/Exception
    //   61	70	122	java/lang/Exception
    //   72	83	122	java/lang/Exception
    //   90	102	122	java/lang/Exception
    //   107	115	122	java/lang/Exception
    //   2	21	127	finally
    //   2	21	133	java/lang/Exception
    //   23	29	172	finally
    //   36	47	172	finally
    //   49	57	172	finally
    //   61	70	172	finally
    //   72	83	172	finally
    //   90	102	172	finally
    //   107	115	172	finally
    //   139	145	172	finally
    //   147	153	172	finally
    //   155	165	172	finally
    //   115	119	185	finally
    //   165	169	185	finally
    //   179	185	185	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.jh
 * JD-Core Version:    0.7.0.1
 */