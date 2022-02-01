package com.huawei.hms.framework.network.grs.b.a;

import com.huawei.hms.framework.network.grs.b.b.c;

public class a
{
  private static final String a = a.class.getSimpleName();
  private static c b;
  
  /* Error */
  public static c a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: ldc 2
    //   7: monitorenter
    //   8: getstatic 27	com/huawei/hms/framework/network/grs/b/a/a:b	Lcom/huawei/hms/framework/network/grs/b/b/c;
    //   11: ifnull +12 -> 23
    //   14: getstatic 27	com/huawei/hms/framework/network/grs/b/a/a:b	Lcom/huawei/hms/framework/network/grs/b/b/c;
    //   17: astore_0
    //   18: ldc 2
    //   20: monitorexit
    //   21: aload_0
    //   22: areturn
    //   23: ldc 29
    //   25: aload_0
    //   26: invokestatic 34	com/huawei/hms/framework/network/grs/c/c:a	(Ljava/lang/String;Landroid/content/Context;)Ljava/lang/String;
    //   29: astore 5
    //   31: aload 5
    //   33: invokestatic 40	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   36: istore_2
    //   37: aload 4
    //   39: astore_0
    //   40: iload_2
    //   41: ifne -23 -> 18
    //   44: new 42	org/json/JSONObject
    //   47: dup
    //   48: aload 5
    //   50: invokespecial 45	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   53: ldc 47
    //   55: invokevirtual 51	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   58: astore 4
    //   60: aload 4
    //   62: ldc 53
    //   64: invokevirtual 57	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   67: astore 5
    //   69: aload_3
    //   70: astore_0
    //   71: aload 5
    //   73: ifnull +57 -> 130
    //   76: aload_3
    //   77: astore_0
    //   78: aload 5
    //   80: invokevirtual 63	org/json/JSONArray:length	()I
    //   83: ifle +47 -> 130
    //   86: new 65	java/util/ArrayList
    //   89: dup
    //   90: invokespecial 66	java/util/ArrayList:<init>	()V
    //   93: astore_3
    //   94: iconst_0
    //   95: istore_1
    //   96: aload_3
    //   97: astore_0
    //   98: iload_1
    //   99: aload 5
    //   101: invokevirtual 63	org/json/JSONArray:length	()I
    //   104: if_icmpge +26 -> 130
    //   107: aload_3
    //   108: aload 5
    //   110: iload_1
    //   111: invokevirtual 70	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   114: invokevirtual 73	java/lang/Object:toString	()Ljava/lang/String;
    //   117: invokeinterface 79 2 0
    //   122: pop
    //   123: iload_1
    //   124: iconst_1
    //   125: iadd
    //   126: istore_1
    //   127: goto -31 -> 96
    //   130: new 81	com/huawei/hms/framework/network/grs/b/b/c
    //   133: dup
    //   134: invokespecial 82	com/huawei/hms/framework/network/grs/b/b/c:<init>	()V
    //   137: putstatic 27	com/huawei/hms/framework/network/grs/b/a/a:b	Lcom/huawei/hms/framework/network/grs/b/b/c;
    //   140: getstatic 27	com/huawei/hms/framework/network/grs/b/a/a:b	Lcom/huawei/hms/framework/network/grs/b/b/c;
    //   143: aload_0
    //   144: invokevirtual 85	com/huawei/hms/framework/network/grs/b/b/c:a	(Ljava/util/List;)V
    //   147: aload 4
    //   149: ldc 87
    //   151: invokevirtual 91	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   154: astore_0
    //   155: getstatic 27	com/huawei/hms/framework/network/grs/b/a/a:b	Lcom/huawei/hms/framework/network/grs/b/b/c;
    //   158: aload_0
    //   159: invokevirtual 93	com/huawei/hms/framework/network/grs/b/b/c:a	(Ljava/lang/String;)V
    //   162: aload 4
    //   164: ldc 95
    //   166: invokevirtual 91	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   169: astore_0
    //   170: getstatic 27	com/huawei/hms/framework/network/grs/b/a/a:b	Lcom/huawei/hms/framework/network/grs/b/b/c;
    //   173: aload_0
    //   174: invokevirtual 97	com/huawei/hms/framework/network/grs/b/b/c:b	(Ljava/lang/String;)V
    //   177: aload 4
    //   179: ldc 99
    //   181: invokevirtual 103	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   184: istore_1
    //   185: getstatic 27	com/huawei/hms/framework/network/grs/b/a/a:b	Lcom/huawei/hms/framework/network/grs/b/b/c;
    //   188: iload_1
    //   189: invokevirtual 106	com/huawei/hms/framework/network/grs/b/b/c:a	(I)V
    //   192: getstatic 27	com/huawei/hms/framework/network/grs/b/a/a:b	Lcom/huawei/hms/framework/network/grs/b/b/c;
    //   195: astore_0
    //   196: goto -178 -> 18
    //   199: astore_0
    //   200: getstatic 18	com/huawei/hms/framework/network/grs/b/a/a:a	Ljava/lang/String;
    //   203: ldc 108
    //   205: aload_0
    //   206: invokestatic 114	com/huawei/hms/framework/common/Logger:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   209: goto -17 -> 192
    //   212: astore_0
    //   213: ldc 2
    //   215: monitorexit
    //   216: aload_0
    //   217: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	paramContext	android.content.Context
    //   95	94	1	i	int
    //   36	5	2	bool	boolean
    //   1	107	3	localArrayList	java.util.ArrayList
    //   3	175	4	localJSONObject	org.json.JSONObject
    //   29	80	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   44	69	199	org/json/JSONException
    //   78	94	199	org/json/JSONException
    //   98	123	199	org/json/JSONException
    //   130	192	199	org/json/JSONException
    //   8	18	212	finally
    //   23	37	212	finally
    //   44	69	212	finally
    //   78	94	212	finally
    //   98	123	212	finally
    //   130	192	212	finally
    //   192	196	212	finally
    //   200	209	212	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.b.a.a
 * JD-Core Version:    0.7.0.1
 */