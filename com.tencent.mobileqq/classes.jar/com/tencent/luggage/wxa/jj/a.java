package com.tencent.luggage.wxa.jj;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.jx.j;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  implements j
{
  public boolean a = false;
  public String b;
  public String c;
  private a.b d;
  private a.b e;
  private Map<String, a.d> f;
  private Map<String, a.d> g;
  private Map<String, a.e> h;
  private a.g i;
  private a.g j;
  private a.c k;
  private a.a l;
  private Boolean m = null;
  private Boolean n = Boolean.valueOf(false);
  private Set<String> o;
  private JSONArray p;
  private ArrayList<String> q;
  private boolean r = false;
  private JSONObject s;
  private JSONObject t;
  private JSONObject u;
  private JSONObject v;
  private JSONObject w;
  private JSONObject x;
  
  private static a.b a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    return new a.b(paramJSONObject, paramBoolean);
  }
  
  private static a.d a(@Nullable JSONObject paramJSONObject, a.i parami)
  {
    return new a.d(paramJSONObject, parami);
  }
  
  private static a.g a(JSONObject paramJSONObject, a.g paramg)
  {
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    return new a.g(localJSONObject, paramg);
  }
  
  public static a a(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, "{}", false, false);
  }
  
  /* Error */
  public static a a(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: invokestatic 102	com/tencent/luggage/wxa/qz/af:b	()J
    //   3: lstore 9
    //   5: new 2	com/tencent/luggage/wxa/jj/a
    //   8: dup
    //   9: invokespecial 103	com/tencent/luggage/wxa/jj/a:<init>	()V
    //   12: astore 13
    //   14: invokestatic 102	com/tencent/luggage/wxa/qz/af:b	()J
    //   17: lstore 11
    //   19: iconst_m1
    //   20: istore 6
    //   22: aload_1
    //   23: ldc 105
    //   25: invokestatic 110	com/tencent/luggage/wxa/jj/f:a	(Ljava/lang/String;Ljava/lang/String;)Lorg/json/JSONObject;
    //   28: astore 14
    //   30: aload_1
    //   31: invokestatic 113	com/tencent/luggage/wxa/qz/af:b	(Ljava/lang/String;)Ljava/lang/String;
    //   34: invokevirtual 119	java/lang/String:length	()I
    //   37: istore 7
    //   39: aload 14
    //   41: ifnonnull +9 -> 50
    //   44: iconst_m1
    //   45: istore 5
    //   47: goto +10 -> 57
    //   50: aload 14
    //   52: invokevirtual 120	org/json/JSONObject:length	()I
    //   55: istore 5
    //   57: ldc 122
    //   59: ldc 124
    //   61: iconst_4
    //   62: anewarray 4	java/lang/Object
    //   65: dup
    //   66: iconst_0
    //   67: aload_0
    //   68: aastore
    //   69: dup
    //   70: iconst_1
    //   71: iload 7
    //   73: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   76: aastore
    //   77: dup
    //   78: iconst_2
    //   79: iload 5
    //   81: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   84: aastore
    //   85: dup
    //   86: iconst_3
    //   87: invokestatic 102	com/tencent/luggage/wxa/qz/af:b	()J
    //   90: lload 11
    //   92: lsub
    //   93: invokestatic 134	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   96: aastore
    //   97: invokestatic 139	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   100: aload 14
    //   102: invokevirtual 120	org/json/JSONObject:length	()I
    //   105: istore 5
    //   107: iload 5
    //   109: ifeq +12 -> 121
    //   112: aload 13
    //   114: iconst_1
    //   115: invokestatic 58	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   118: invokevirtual 142	com/tencent/luggage/wxa/jj/a:a	(Ljava/lang/Boolean;)V
    //   121: aload 14
    //   123: aload 13
    //   125: invokestatic 145	com/tencent/luggage/wxa/jj/a:a	(Lorg/json/JSONObject;Lcom/tencent/luggage/wxa/jj/a;)V
    //   128: aload 13
    //   130: aload 14
    //   132: ldc 147
    //   134: invokevirtual 151	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   137: iload 4
    //   139: invokestatic 153	com/tencent/luggage/wxa/jj/a:a	(Lorg/json/JSONObject;Z)Lcom/tencent/luggage/wxa/jj/a$b;
    //   142: putfield 155	com/tencent/luggage/wxa/jj/a:d	Lcom/tencent/luggage/wxa/jj/a$b;
    //   145: aload 13
    //   147: aload 14
    //   149: ldc 157
    //   151: invokevirtual 151	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   154: aload 13
    //   156: getfield 155	com/tencent/luggage/wxa/jj/a:d	Lcom/tencent/luggage/wxa/jj/a$b;
    //   159: invokestatic 160	com/tencent/luggage/wxa/jj/a:a	(Lorg/json/JSONObject;Lcom/tencent/luggage/wxa/jj/a$b;)Ljava/util/Map;
    //   162: putfield 162	com/tencent/luggage/wxa/jj/a:f	Ljava/util/Map;
    //   165: aload 13
    //   167: aload 14
    //   169: ldc 164
    //   171: invokevirtual 151	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   174: invokestatic 167	com/tencent/luggage/wxa/jj/a:b	(Lorg/json/JSONObject;)Ljava/util/Map;
    //   177: putfield 169	com/tencent/luggage/wxa/jj/a:h	Ljava/util/Map;
    //   180: aload 13
    //   182: aload 14
    //   184: ldc 171
    //   186: invokevirtual 151	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   189: aconst_null
    //   190: invokestatic 173	com/tencent/luggage/wxa/jj/a:a	(Lorg/json/JSONObject;Lcom/tencent/luggage/wxa/jj/a$g;)Lcom/tencent/luggage/wxa/jj/a$g;
    //   193: putfield 175	com/tencent/luggage/wxa/jj/a:i	Lcom/tencent/luggage/wxa/jj/a$g;
    //   196: aload 13
    //   198: aload 14
    //   200: ldc 177
    //   202: invokevirtual 151	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   205: invokestatic 180	com/tencent/luggage/wxa/jj/a:d	(Lorg/json/JSONObject;)Lcom/tencent/luggage/wxa/jj/a$c;
    //   208: putfield 182	com/tencent/luggage/wxa/jj/a:k	Lcom/tencent/luggage/wxa/jj/a$c;
    //   211: aload 13
    //   213: aload 14
    //   215: invokestatic 185	com/tencent/luggage/wxa/jj/a:e	(Lorg/json/JSONObject;)Lcom/tencent/luggage/wxa/jj/a$a;
    //   218: putfield 187	com/tencent/luggage/wxa/jj/a:l	Lcom/tencent/luggage/wxa/jj/a$a;
    //   221: aload 14
    //   223: ldc 189
    //   225: invokevirtual 193	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   228: istore 8
    //   230: iload 8
    //   232: ifeq +19 -> 251
    //   235: aload 13
    //   237: aload 14
    //   239: ldc 189
    //   241: iconst_0
    //   242: invokevirtual 197	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   245: invokestatic 58	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   248: putfield 52	com/tencent/luggage/wxa/jj/a:m	Ljava/lang/Boolean;
    //   251: aload 13
    //   253: aload 14
    //   255: ldc 199
    //   257: invokevirtual 203	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   260: invokestatic 206	com/tencent/luggage/wxa/jj/a:a	(Lorg/json/JSONArray;)Ljava/util/Set;
    //   263: putfield 208	com/tencent/luggage/wxa/jj/a:o	Ljava/util/Set;
    //   266: aload 13
    //   268: aload 14
    //   270: ldc 210
    //   272: invokevirtual 203	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   275: putfield 212	com/tencent/luggage/wxa/jj/a:p	Lorg/json/JSONArray;
    //   278: aload 13
    //   280: aload 14
    //   282: ldc 214
    //   284: invokevirtual 203	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   287: invokestatic 217	com/tencent/luggage/wxa/jj/a:b	(Lorg/json/JSONArray;)Ljava/util/ArrayList;
    //   290: putfield 219	com/tencent/luggage/wxa/jj/a:q	Ljava/util/ArrayList;
    //   293: aload 13
    //   295: aload 14
    //   297: ldc 221
    //   299: iconst_0
    //   300: invokevirtual 197	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   303: putfield 62	com/tencent/luggage/wxa/jj/a:r	Z
    //   306: aload 13
    //   308: aload 14
    //   310: ldc 223
    //   312: iconst_0
    //   313: invokevirtual 197	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   316: putfield 64	com/tencent/luggage/wxa/jj/a:a	Z
    //   319: invokestatic 102	com/tencent/luggage/wxa/qz/af:b	()J
    //   322: lstore 11
    //   324: aload_2
    //   325: ldc 225
    //   327: invokestatic 110	com/tencent/luggage/wxa/jj/f:a	(Ljava/lang/String;Ljava/lang/String;)Lorg/json/JSONObject;
    //   330: astore 15
    //   332: aload_2
    //   333: invokestatic 113	com/tencent/luggage/wxa/qz/af:b	(Ljava/lang/String;)Ljava/lang/String;
    //   336: invokevirtual 119	java/lang/String:length	()I
    //   339: istore 7
    //   341: aload 15
    //   343: ifnonnull +10 -> 353
    //   346: iload 6
    //   348: istore 5
    //   350: goto +10 -> 360
    //   353: aload 15
    //   355: invokevirtual 120	org/json/JSONObject:length	()I
    //   358: istore 5
    //   360: ldc 122
    //   362: ldc 227
    //   364: iconst_4
    //   365: anewarray 4	java/lang/Object
    //   368: dup
    //   369: iconst_0
    //   370: aload_0
    //   371: aastore
    //   372: dup
    //   373: iconst_1
    //   374: iload 7
    //   376: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   379: aastore
    //   380: dup
    //   381: iconst_2
    //   382: iload 5
    //   384: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   387: aastore
    //   388: dup
    //   389: iconst_3
    //   390: invokestatic 102	com/tencent/luggage/wxa/qz/af:b	()J
    //   393: lload 11
    //   395: lsub
    //   396: invokestatic 134	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   399: aastore
    //   400: invokestatic 139	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   403: aload 15
    //   405: invokevirtual 120	org/json/JSONObject:length	()I
    //   408: ifeq +56 -> 464
    //   411: aload 13
    //   413: aload 15
    //   415: ldc 147
    //   417: invokevirtual 151	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   420: iload 4
    //   422: invokestatic 153	com/tencent/luggage/wxa/jj/a:a	(Lorg/json/JSONObject;Z)Lcom/tencent/luggage/wxa/jj/a$b;
    //   425: putfield 229	com/tencent/luggage/wxa/jj/a:e	Lcom/tencent/luggage/wxa/jj/a$b;
    //   428: aload 13
    //   430: aload 15
    //   432: ldc 171
    //   434: invokevirtual 151	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   437: aconst_null
    //   438: invokestatic 173	com/tencent/luggage/wxa/jj/a:a	(Lorg/json/JSONObject;Lcom/tencent/luggage/wxa/jj/a$g;)Lcom/tencent/luggage/wxa/jj/a$g;
    //   441: putfield 231	com/tencent/luggage/wxa/jj/a:j	Lcom/tencent/luggage/wxa/jj/a$g;
    //   444: aload 13
    //   446: aload 15
    //   448: ldc 157
    //   450: invokevirtual 151	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   453: aload 13
    //   455: getfield 229	com/tencent/luggage/wxa/jj/a:e	Lcom/tencent/luggage/wxa/jj/a$b;
    //   458: invokestatic 160	com/tencent/luggage/wxa/jj/a:a	(Lorg/json/JSONObject;Lcom/tencent/luggage/wxa/jj/a$b;)Ljava/util/Map;
    //   461: putfield 233	com/tencent/luggage/wxa/jj/a:g	Ljava/util/Map;
    //   464: aload_0
    //   465: aload 14
    //   467: aload 15
    //   469: aload 13
    //   471: iload_3
    //   472: invokestatic 236	com/tencent/luggage/wxa/jj/a:a	(Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;Lcom/tencent/luggage/wxa/jj/a;Z)V
    //   475: ldc 122
    //   477: ldc 238
    //   479: iconst_4
    //   480: anewarray 4	java/lang/Object
    //   483: dup
    //   484: iconst_0
    //   485: aload_0
    //   486: aastore
    //   487: dup
    //   488: iconst_1
    //   489: aload_1
    //   490: invokestatic 113	com/tencent/luggage/wxa/qz/af:b	(Ljava/lang/String;)Ljava/lang/String;
    //   493: invokevirtual 119	java/lang/String:length	()I
    //   496: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   499: aastore
    //   500: dup
    //   501: iconst_2
    //   502: aload_2
    //   503: invokestatic 113	com/tencent/luggage/wxa/qz/af:b	(Ljava/lang/String;)Ljava/lang/String;
    //   506: invokevirtual 119	java/lang/String:length	()I
    //   509: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   512: aastore
    //   513: dup
    //   514: iconst_3
    //   515: invokestatic 102	com/tencent/luggage/wxa/qz/af:b	()J
    //   518: lload 9
    //   520: lsub
    //   521: invokestatic 134	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   524: aastore
    //   525: invokestatic 139	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   528: aload 13
    //   530: areturn
    //   531: astore 13
    //   533: goto +3 -> 536
    //   536: ldc 122
    //   538: ldc 227
    //   540: iconst_4
    //   541: anewarray 4	java/lang/Object
    //   544: dup
    //   545: iconst_0
    //   546: aload_0
    //   547: aastore
    //   548: dup
    //   549: iconst_1
    //   550: aload_2
    //   551: invokestatic 113	com/tencent/luggage/wxa/qz/af:b	(Ljava/lang/String;)Ljava/lang/String;
    //   554: invokevirtual 119	java/lang/String:length	()I
    //   557: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   560: aastore
    //   561: dup
    //   562: iconst_2
    //   563: iconst_m1
    //   564: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   567: aastore
    //   568: dup
    //   569: iconst_3
    //   570: invokestatic 102	com/tencent/luggage/wxa/qz/af:b	()J
    //   573: lload 11
    //   575: lsub
    //   576: invokestatic 134	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   579: aastore
    //   580: invokestatic 139	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   583: aload 13
    //   585: athrow
    //   586: astore 13
    //   588: ldc 122
    //   590: ldc 124
    //   592: iconst_4
    //   593: anewarray 4	java/lang/Object
    //   596: dup
    //   597: iconst_0
    //   598: aload_0
    //   599: aastore
    //   600: dup
    //   601: iconst_1
    //   602: aload_1
    //   603: invokestatic 113	com/tencent/luggage/wxa/qz/af:b	(Ljava/lang/String;)Ljava/lang/String;
    //   606: invokevirtual 119	java/lang/String:length	()I
    //   609: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   612: aastore
    //   613: dup
    //   614: iconst_2
    //   615: iconst_m1
    //   616: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   619: aastore
    //   620: dup
    //   621: iconst_3
    //   622: invokestatic 102	com/tencent/luggage/wxa/qz/af:b	()J
    //   625: lload 11
    //   627: lsub
    //   628: invokestatic 134	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   631: aastore
    //   632: invokestatic 139	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   635: aload 13
    //   637: athrow
    //   638: astore 13
    //   640: ldc 122
    //   642: ldc 238
    //   644: iconst_4
    //   645: anewarray 4	java/lang/Object
    //   648: dup
    //   649: iconst_0
    //   650: aload_0
    //   651: aastore
    //   652: dup
    //   653: iconst_1
    //   654: aload_1
    //   655: invokestatic 113	com/tencent/luggage/wxa/qz/af:b	(Ljava/lang/String;)Ljava/lang/String;
    //   658: invokevirtual 119	java/lang/String:length	()I
    //   661: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   664: aastore
    //   665: dup
    //   666: iconst_2
    //   667: aload_2
    //   668: invokestatic 113	com/tencent/luggage/wxa/qz/af:b	(Ljava/lang/String;)Ljava/lang/String;
    //   671: invokevirtual 119	java/lang/String:length	()I
    //   674: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   677: aastore
    //   678: dup
    //   679: iconst_3
    //   680: invokestatic 102	com/tencent/luggage/wxa/qz/af:b	()J
    //   683: lload 9
    //   685: lsub
    //   686: invokestatic 134	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   689: aastore
    //   690: invokestatic 139	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   693: aload 13
    //   695: athrow
    //   696: astore 13
    //   698: goto -58 -> 640
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	701	0	paramString1	String
    //   0	701	1	paramString2	String
    //   0	701	2	paramString3	String
    //   0	701	3	paramBoolean1	boolean
    //   0	701	4	paramBoolean2	boolean
    //   45	338	5	i1	int
    //   20	327	6	i2	int
    //   37	338	7	i3	int
    //   228	3	8	bool	boolean
    //   3	681	9	l1	long
    //   17	609	11	l2	long
    //   12	517	13	locala	a
    //   531	53	13	localObject1	Object
    //   586	50	13	localObject2	Object
    //   638	56	13	localObject3	Object
    //   696	1	13	localObject4	Object
    //   28	438	14	localJSONObject1	JSONObject
    //   330	138	15	localJSONObject2	JSONObject
    // Exception table:
    //   from	to	target	type
    //   324	332	531	finally
    //   22	30	586	finally
    //   5	19	638	finally
    //   112	121	638	finally
    //   235	251	638	finally
    //   332	341	638	finally
    //   353	360	638	finally
    //   360	464	638	finally
    //   464	475	638	finally
    //   536	586	638	finally
    //   588	638	638	finally
    //   30	39	696	finally
    //   50	57	696	finally
    //   57	107	696	finally
    //   121	230	696	finally
    //   251	324	696	finally
  }
  
  private static Map<String, a.d> a(JSONObject paramJSONObject, a.b paramb)
  {
    HashMap localHashMap = new HashMap();
    if (paramJSONObject == null) {
      return localHashMap;
    }
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, a(paramJSONObject.optJSONObject(str), paramb));
    }
    return localHashMap;
  }
  
  private static Set<String> a(JSONArray paramJSONArray)
  {
    HashSet localHashSet = new HashSet();
    if (paramJSONArray == null) {
      return localHashSet;
    }
    int i1 = 0;
    while (i1 < paramJSONArray.length())
    {
      String str = paramJSONArray.optString(i1);
      if (!af.c(str)) {
        localHashSet.add(str);
      }
      i1 += 1;
    }
    return localHashSet;
  }
  
  private static void a(String paramString, JSONObject paramJSONObject1, JSONObject paramJSONObject2, a parama, boolean paramBoolean)
  {
    if (paramJSONObject1 == null) {
      o.c("MicroMsg.AppBrandAppConfig", "extractInjectConfig NULL obj, appId[%s] pruneWxConfigByPage[%b]", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    }
    parama.s = paramJSONObject1;
    if (paramJSONObject1 != null)
    {
      parama.u = paramJSONObject1.optJSONObject("page");
      parama.w = paramJSONObject1.optJSONObject("preloadRule");
    }
    paramJSONObject1 = parama.s;
    if (paramJSONObject1 != null) {
      b.a(paramString, paramJSONObject1, paramBoolean);
    }
    parama.t = paramJSONObject2;
    if (paramJSONObject2 != null)
    {
      parama.v = paramJSONObject2.optJSONObject("page");
      parama.x = paramJSONObject2.optJSONObject("preloadRule");
      parama.x = paramJSONObject2.optJSONObject("preloadRule");
      if (paramJSONObject2.length() <= 0) {}
    }
    for (;;)
    {
      try
      {
        if (!n()) {
          break label193;
        }
        paramJSONObject1 = "dark";
        parama.t.put("theme", paramJSONObject1);
        parama.s.put("theme", paramJSONObject1);
      }
      catch (JSONException paramJSONObject1)
      {
        o.a("MicroMsg.AppBrandAppConfig", paramJSONObject1, "", new Object[0]);
      }
      paramJSONObject1 = parama.t;
      if (paramJSONObject1 != null) {
        b.a(paramString, paramJSONObject1, paramBoolean);
      }
      return;
      label193:
      paramJSONObject1 = "light";
    }
  }
  
  private static void a(JSONObject paramJSONObject, a parama)
  {
    parama.b = paramJSONObject.optString("entryPagePath");
    parama.c = paramJSONObject.optString("referrerPolicy");
  }
  
  private static ArrayList<String> b(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJSONArray == null) {
      return localArrayList;
    }
    int i1 = 0;
    while (i1 < paramJSONArray.length())
    {
      Object localObject1 = paramJSONArray.optJSONObject(i1);
      if (localObject1 != null)
      {
        Object localObject2 = ((JSONObject)localObject1).optString("root");
        if (!af.c((String)localObject2))
        {
          localObject1 = localObject2;
          if (!((String)localObject2).startsWith("/"))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("/");
            ((StringBuilder)localObject1).append((String)localObject2);
            localObject1 = ((StringBuilder)localObject1).toString();
          }
          localObject2 = localObject1;
          if (!((String)localObject1).endsWith(".js"))
          {
            localObject2 = localObject1;
            if (!((String)localObject1).endsWith("/"))
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append((String)localObject1);
              ((StringBuilder)localObject2).append("/");
              localObject2 = ((StringBuilder)localObject2).toString();
            }
          }
          localArrayList.add(localObject2);
        }
      }
      i1 += 1;
    }
    return localArrayList;
  }
  
  private static Map<String, a.e> b(JSONObject paramJSONObject)
  {
    HashMap localHashMap = new HashMap();
    if (paramJSONObject == null) {
      return localHashMap;
    }
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      JSONObject localJSONObject = paramJSONObject.optJSONObject(str);
      if (localJSONObject != null) {
        try
        {
          localHashMap.put(str, new a.e(str, localJSONObject));
        }
        catch (JSONException localJSONException)
        {
          o.b("MicroMsg.AppBrandAppConfig", localJSONException.getMessage());
        }
      }
    }
    return localHashMap;
  }
  
  private static a.h c(JSONObject paramJSONObject)
  {
    return new a.h(paramJSONObject);
  }
  
  private static a.c d(JSONObject paramJSONObject)
  {
    a.c localc = new a.c();
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    localc.a = localJSONObject.optInt("request");
    localc.b = localJSONObject.optInt("connectSocket");
    localc.d = localJSONObject.optInt("downloadFile");
    localc.c = localJSONObject.optInt("uploadFile");
    return localc;
  }
  
  private static a.a e(JSONObject paramJSONObject)
  {
    a.a locala = new a.a();
    if (paramJSONObject == null) {
      return locala;
    }
    locala.a = paramJSONObject.optString("deviceOrientation", "portrait");
    locala.b = paramJSONObject.optBoolean("showStatusBar", false);
    return locala;
  }
  
  private static boolean n()
  {
    return com.tencent.luggage.util.k.a.a();
  }
  
  public a.d a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      String str = paramString;
      if (!this.f.containsKey(paramString)) {
        str = com.tencent.mm.plugin.appbrand.appstorage.k.c(paramString);
      }
      if (this.f.containsKey(str))
      {
        if (n())
        {
          paramString = this.g;
          if ((paramString != null) && (paramString.containsKey(str))) {
            return (a.d)this.g.get(str);
          }
        }
        return (a.d)this.f.get(str);
      }
    }
    return a(null, this.d);
  }
  
  public void a(Boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public final boolean a()
  {
    return (b()) && (n());
  }
  
  @Nullable
  public a.e b(String paramString)
  {
    return (a.e)this.h.get(paramString);
  }
  
  public final boolean b()
  {
    JSONObject localJSONObject = this.t;
    return (localJSONObject != null) && (localJSONObject.length() > 0);
  }
  
  public a.b c()
  {
    if (n())
    {
      a.b localb = this.e;
      if (localb != null) {
        return localb;
      }
    }
    return this.d;
  }
  
  public a.c d()
  {
    return this.k;
  }
  
  public a.g e()
  {
    if (n())
    {
      a.g localg = this.j;
      if (localg != null) {
        return localg;
      }
    }
    return this.i;
  }
  
  public a.a f()
  {
    return this.l;
  }
  
  public Set<String> g()
  {
    return this.o;
  }
  
  public String h()
  {
    if (!af.c(this.b)) {
      return this.b;
    }
    return "index.html";
  }
  
  public Boolean i()
  {
    return this.n;
  }
  
  @Nullable
  public Boolean j()
  {
    return this.m;
  }
  
  public JSONObject k()
  {
    if (n())
    {
      JSONObject localJSONObject = this.t;
      if ((localJSONObject != null) && (localJSONObject.length() != 0)) {
        return this.t;
      }
    }
    return this.s;
  }
  
  public JSONObject l()
  {
    if (n())
    {
      JSONObject localJSONObject = this.v;
      if ((localJSONObject != null) && (localJSONObject.length() != 0)) {
        return this.v;
      }
    }
    return this.u;
  }
  
  public JSONObject m()
  {
    if (n())
    {
      JSONObject localJSONObject = this.x;
      if ((localJSONObject != null) && (localJSONObject.length() != 0)) {
        return this.x;
      }
    }
    return this.w;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jj.a
 * JD-Core Version:    0.7.0.1
 */