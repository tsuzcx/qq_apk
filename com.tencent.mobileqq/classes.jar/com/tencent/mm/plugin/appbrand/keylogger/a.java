package com.tencent.mm.plugin.appbrand.keylogger;

import com.tencent.luggage.wxa.nk.c;
import com.tencent.luggage.wxa.nk.c.a;
import com.tencent.luggage.wxa.nk.c.b;
import com.tencent.luggage.wxa.nk.c.c;
import com.tencent.luggage.wxa.nk.e;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.regex.Pattern;

public class a
  implements c
{
  private List<String> a(String paramString, long paramLong)
  {
    return d.a().a(paramString, paramLong);
  }
  
  /* Error */
  private List<c.c> a(String paramString, Pattern paramPattern)
  {
    // Byte code:
    //   0: ldc 31
    //   2: ldc 33
    //   4: iconst_1
    //   5: anewarray 4	java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: aload_1
    //   11: aastore
    //   12: invokestatic 39	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   15: new 41	java/util/ArrayList
    //   18: dup
    //   19: invokespecial 42	java/util/ArrayList:<init>	()V
    //   22: astore 6
    //   24: aconst_null
    //   25: astore 4
    //   27: aconst_null
    //   28: astore 5
    //   30: aconst_null
    //   31: astore_3
    //   32: new 44	java/io/BufferedReader
    //   35: dup
    //   36: new 46	java/io/FileReader
    //   39: dup
    //   40: aload_1
    //   41: invokespecial 49	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   44: invokespecial 52	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   47: astore_1
    //   48: aload_1
    //   49: invokevirtual 56	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   52: astore_3
    //   53: aload_3
    //   54: ifnull +45 -> 99
    //   57: aload_3
    //   58: invokestatic 59	com/tencent/mm/plugin/appbrand/keylogger/d:a	(Ljava/lang/String;)Lcom/tencent/luggage/wxa/nk/c$c;
    //   61: astore_3
    //   62: aload_3
    //   63: ifnull -15 -> 48
    //   66: aload_3
    //   67: getfield 65	com/tencent/luggage/wxa/nk/c$c:b	Ljava/lang/String;
    //   70: ifnull -22 -> 48
    //   73: aload_2
    //   74: aload_3
    //   75: getfield 65	com/tencent/luggage/wxa/nk/c$c:b	Ljava/lang/String;
    //   78: invokevirtual 71	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   81: invokevirtual 77	java/util/regex/Matcher:matches	()Z
    //   84: ifeq -36 -> 48
    //   87: aload 6
    //   89: aload_3
    //   90: invokeinterface 83 2 0
    //   95: pop
    //   96: goto -48 -> 48
    //   99: aload_1
    //   100: invokevirtual 86	java/io/BufferedReader:close	()V
    //   103: aload 6
    //   105: areturn
    //   106: astore_2
    //   107: aload_1
    //   108: astore_3
    //   109: aload_2
    //   110: astore_1
    //   111: goto +78 -> 189
    //   114: astore_2
    //   115: goto +15 -> 130
    //   118: astore_2
    //   119: goto +43 -> 162
    //   122: astore_1
    //   123: goto +66 -> 189
    //   126: astore_2
    //   127: aload 4
    //   129: astore_1
    //   130: aload_1
    //   131: astore_3
    //   132: ldc 31
    //   134: ldc 88
    //   136: iconst_1
    //   137: anewarray 4	java/lang/Object
    //   140: dup
    //   141: iconst_0
    //   142: aload_2
    //   143: aastore
    //   144: invokestatic 91	com/tencent/luggage/wxa/qz/o:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   147: aload_1
    //   148: ifnull +38 -> 186
    //   151: aload_1
    //   152: invokevirtual 86	java/io/BufferedReader:close	()V
    //   155: aload 6
    //   157: areturn
    //   158: astore_2
    //   159: aload 5
    //   161: astore_1
    //   162: aload_1
    //   163: astore_3
    //   164: ldc 31
    //   166: ldc 88
    //   168: iconst_1
    //   169: anewarray 4	java/lang/Object
    //   172: dup
    //   173: iconst_0
    //   174: aload_2
    //   175: aastore
    //   176: invokestatic 91	com/tencent/luggage/wxa/qz/o:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   179: aload_1
    //   180: ifnull +6 -> 186
    //   183: goto -32 -> 151
    //   186: aload 6
    //   188: areturn
    //   189: aload_3
    //   190: ifnull +7 -> 197
    //   193: aload_3
    //   194: invokevirtual 86	java/io/BufferedReader:close	()V
    //   197: goto +5 -> 202
    //   200: aload_1
    //   201: athrow
    //   202: goto -2 -> 200
    //   205: astore_1
    //   206: aload 6
    //   208: areturn
    //   209: astore_2
    //   210: goto -13 -> 197
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	this	a
    //   0	213	1	paramString	String
    //   0	213	2	paramPattern	Pattern
    //   31	163	3	localObject1	Object
    //   25	103	4	localObject2	Object
    //   28	132	5	localObject3	Object
    //   22	185	6	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   48	53	106	finally
    //   57	62	106	finally
    //   66	96	106	finally
    //   48	53	114	java/io/IOException
    //   57	62	114	java/io/IOException
    //   66	96	114	java/io/IOException
    //   48	53	118	java/io/FileNotFoundException
    //   57	62	118	java/io/FileNotFoundException
    //   66	96	118	java/io/FileNotFoundException
    //   32	48	122	finally
    //   132	147	122	finally
    //   164	179	122	finally
    //   32	48	126	java/io/IOException
    //   32	48	158	java/io/FileNotFoundException
    //   99	103	205	java/io/IOException
    //   151	155	205	java/io/IOException
    //   193	197	209	java/io/IOException
  }
  
  private List<c.c> a(List<List<c.c>> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    PriorityQueue localPriorityQueue = new PriorityQueue(paramList.size(), new a.2(this));
    int m = 0;
    int j = 0;
    int i = 0;
    int k;
    a.a locala1;
    for (;;)
    {
      k = m;
      if (j >= paramList.size()) {
        break;
      }
      if (!((List)paramList.get(j)).isEmpty())
      {
        locala1 = new a.a(null);
        locala1.a = ((c.c)((List)paramList.get(j)).get(0));
        locala1.b = 0;
        locala1.c = j;
        localPriorityQueue.add(locala1);
        i += ((List)paramList.get(j)).size();
      }
      j += 1;
    }
    while (k < i)
    {
      locala1 = (a.a)localPriorityQueue.poll();
      localArrayList.add(locala1.a);
      List localList = (List)paramList.get(locala1.c);
      j = locala1.b + 1;
      if (j >= localList.size())
      {
        localPriorityQueue.add(a.a.a());
      }
      else
      {
        a.a locala2 = new a.a(null);
        locala2.a = ((c.c)localList.get(j));
        locala2.b = j;
        locala2.c = locala1.c;
        localPriorityQueue.add(locala2);
      }
      k += 1;
    }
    return localArrayList;
  }
  
  private List<c.b> b(List<c.c> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    Object localObject2 = null;
    int k = 0;
    int i = 0;
    while (k < paramList.size())
    {
      c.c localc = (c.c)paramList.get(k);
      o.f("MicroMsg.KeyStepAnalyser", "sortOutResult time:%d step:%s", new Object[] { Long.valueOf(localc.a), localc.c });
      int j = i;
      Object localObject1 = localObject2;
      if (localc.a())
      {
        if (localObject2 != null) {
          localArrayList.add(0, localObject2);
        }
        localHashMap.clear();
        localObject1 = new c.b();
        localHashMap.put("Start", Long.valueOf(localc.a));
        j = 0;
      }
      if (localObject1 != null) {
        if (localc.d())
        {
          localHashMap.put(localc.c, Long.valueOf(localc.a));
        }
        else if (localc.c())
        {
          ((c.b)localObject1).a(localc.f);
        }
        else
        {
          if (localHashMap.containsKey(localc.c)) {
            localc.g = (localc.a - ((Long)localHashMap.get(localc.c)).longValue());
          }
          ((c.b)localObject1).a(localc);
        }
      }
      i = j;
      localObject2 = localObject1;
      if (localc.b())
      {
        i = j;
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          if (localHashMap.containsKey("Start")) {
            localc.g = (localc.a - ((Long)localHashMap.get("Start")).longValue());
          }
          localArrayList.add(0, localObject1);
          localHashMap.clear();
          localObject2 = null;
          i = 1;
        }
      }
      k += 1;
    }
    if ((i == 0) && (localObject2 != null)) {
      localArrayList.add(0, localObject2);
    }
    return localArrayList;
  }
  
  private void b(String paramString, Pattern paramPattern, long paramLong, c.a parama)
  {
    int i = 0;
    o.d("MicroMsg.KeyStepAnalyser", "doAnalyse processName:%s sessionIdPattern:%s", new Object[] { paramString, paramPattern.pattern() });
    if (parama == null) {
      return;
    }
    paramString = a(paramString, paramLong);
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      while (i < paramString.size())
      {
        List localList = a((String)paramString.get(i), paramPattern);
        if (!localList.isEmpty()) {
          localArrayList.add(localList);
        }
        i += 1;
      }
      if (localArrayList.isEmpty())
      {
        o.d("MicroMsg.KeyStepAnalyser", "no keystep logs");
        parama.a(new ArrayList());
        return;
      }
      parama.a(b(a(localArrayList)));
      return;
    }
    o.d("MicroMsg.KeyStepAnalyser", "no keystep logs");
    parama.a(new ArrayList());
  }
  
  public void a(String paramString, Pattern paramPattern, long paramLong, c.a parama)
  {
    new s(String.format(Locale.ENGLISH, "KeyStepAnalyser:%s", new Object[] { paramString })).a(new a.1(this, paramString, paramPattern, paramLong, parama));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.a
 * JD-Core Version:    0.7.0.1
 */