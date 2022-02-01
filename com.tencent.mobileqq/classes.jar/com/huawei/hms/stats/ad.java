package com.huawei.hms.stats;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ad
{
  public static Map<String, List<w>> a(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return null;
    }
    paramContext = ap.b(paramContext, paramString);
    a(paramContext);
    return b(paramContext);
  }
  
  public static Map<String, List<w>> a(Context paramContext, String paramString1, String paramString2)
  {
    if (("alltype".equals(paramString2)) || (TextUtils.isEmpty(paramString1)))
    {
      af.b("EventManager", "read all event records");
      paramString1 = a(paramContext, "stat_v2_1");
    }
    for (paramContext = a(paramContext, "cached_v2_1");; paramContext = b(paramContext, "cached_v2_1", paramString2))
    {
      return a(paramString1, paramContext);
      paramString2 = bb.a(paramString1, paramString2);
      paramString1 = b(paramContext, "stat_v2_1", paramString2);
    }
  }
  
  private static Map<String, List<w>> a(Map<String, List<w>> paramMap1, Map<String, List<w>> paramMap2)
  {
    if ((paramMap1.size() == 0) && (paramMap2.size() == 0)) {
      localObject1 = new HashMap();
    }
    do
    {
      return localObject1;
      localObject1 = paramMap2;
    } while (paramMap1.size() == 0);
    if (paramMap2.size() == 0) {
      return paramMap1;
    }
    Object localObject1 = new HashMap();
    paramMap1 = paramMap1.entrySet().iterator();
    while (paramMap1.hasNext())
    {
      Object localObject2 = (Map.Entry)paramMap1.next();
      String str = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (List)((Map.Entry)localObject2).getValue();
      ((List)localObject2).addAll((List)paramMap2.get(str));
      ((Map)localObject1).put(str, localObject2);
    }
    return localObject1;
  }
  
  /* Error */
  private static void a(String paramString1, String paramString2, Map<String, List<w>> paramMap)
  {
    // Byte code:
    //   0: new 121	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 122	java/util/ArrayList:<init>	()V
    //   7: astore 4
    //   9: aload_1
    //   10: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifeq +4 -> 17
    //   16: return
    //   17: new 124	org/json/JSONArray
    //   20: dup
    //   21: aload_1
    //   22: invokespecial 127	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   25: astore_1
    //   26: aload_1
    //   27: invokevirtual 130	org/json/JSONArray:length	()I
    //   30: ifeq +80 -> 110
    //   33: iconst_0
    //   34: istore_3
    //   35: iload_3
    //   36: aload_1
    //   37: invokevirtual 130	org/json/JSONArray:length	()I
    //   40: if_icmpge +60 -> 100
    //   43: new 132	com/huawei/hms/stats/w
    //   46: dup
    //   47: invokespecial 133	com/huawei/hms/stats/w:<init>	()V
    //   50: astore 5
    //   52: aload 5
    //   54: aload_1
    //   55: iload_3
    //   56: invokevirtual 137	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   59: invokevirtual 140	com/huawei/hms/stats/w:a	(Lorg/json/JSONObject;)V
    //   62: aload 4
    //   64: aload 5
    //   66: invokeinterface 143 2 0
    //   71: pop
    //   72: iload_3
    //   73: iconst_1
    //   74: iadd
    //   75: istore_3
    //   76: goto -41 -> 35
    //   79: astore_0
    //   80: ldc 37
    //   82: ldc 145
    //   84: invokestatic 148	com/huawei/hms/stats/af:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: return
    //   88: astore 5
    //   90: ldc 37
    //   92: ldc 150
    //   94: invokestatic 148	com/huawei/hms/stats/af:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: goto -25 -> 72
    //   100: aload_2
    //   101: aload_0
    //   102: aload 4
    //   104: invokeinterface 115 3 0
    //   109: pop
    //   110: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	paramString1	String
    //   0	111	1	paramString2	String
    //   0	111	2	paramMap	Map<String, List<w>>
    //   34	42	3	i	int
    //   7	96	4	localArrayList	java.util.ArrayList
    //   50	15	5	localw	w
    //   88	1	5	localJSONException	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   9	16	79	org/json/JSONException
    //   17	26	79	org/json/JSONException
    //   52	72	88	org/json/JSONException
  }
  
  private static void a(Map<String, ?> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    Set localSet = bb.a(b.a());
    while (paramMap.hasNext()) {
      if (!localSet.contains(((Map.Entry)paramMap.next()).getKey())) {
        paramMap.remove();
      }
    }
  }
  
  public static Map<String, List<w>> b(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = ap.b(paramContext, paramString1, paramString2, "");
    paramString1 = new HashMap();
    a(paramString2, paramContext, paramString1);
    return paramString1;
  }
  
  private static Map<String, List<w>> b(Map<String, ?> paramMap)
  {
    HashMap localHashMap = new HashMap();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      String str = (String)localEntry.getKey();
      if ((localEntry.getValue() instanceof String)) {
        a(str, (String)localEntry.getValue(), localHashMap);
      }
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.stats.ad
 * JD-Core Version:    0.7.0.1
 */