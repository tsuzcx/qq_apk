package com.tencent.featuretoggle.hltxkg.common.c.a.a;

import android.os.Handler;
import com.tencent.featuretoggle.hltxkg.common.a.c.c;
import com.tencent.featuretoggle.hltxkg.common.a.c.d;
import com.tencent.featuretoggle.hltxkg.common.a.e;
import com.tencent.featuretoggle.hltxkg.common.c.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
  extends com.tencent.featuretoggle.hltxkg.common.c.a.a
  implements d
{
  private com.tencent.featuretoggle.hltxkg.common.a.c.b jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonACB;
  private com.tencent.featuretoggle.hltxkg.common.c.b.b.b.a jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonCBBBA = new com.tencent.featuretoggle.hltxkg.common.c.b.b.b.a("HttpSchedulerClient");
  
  /* Error */
  private static void a(com.tencent.featuretoggle.hltxkg.common.a.c.b paramb, org.json.JSONArray paramJSONArray)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: iload_3
    //   3: aload_1
    //   4: invokevirtual 35	org/json/JSONArray:length	()I
    //   7: if_icmpge +448 -> 455
    //   10: aload_1
    //   11: iload_3
    //   12: invokevirtual 39	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   15: astore 11
    //   17: aload 11
    //   19: ldc 41
    //   21: invokevirtual 47	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   24: astore 9
    //   26: aload 11
    //   28: ldc 49
    //   30: invokevirtual 47	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   33: astore 12
    //   35: aload 11
    //   37: ldc 51
    //   39: invokevirtual 47	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   42: astore 8
    //   44: aload 11
    //   46: ldc 53
    //   48: invokevirtual 57	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   51: astore 10
    //   53: aload 11
    //   55: ldc 59
    //   57: sipush 443
    //   60: invokevirtual 63	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   63: istore 5
    //   65: aload 9
    //   67: ifnull +381 -> 448
    //   70: new 65	java/util/ArrayList
    //   73: dup
    //   74: invokespecial 66	java/util/ArrayList:<init>	()V
    //   77: astore 11
    //   79: aload 8
    //   81: ifnull +148 -> 229
    //   84: iconst_0
    //   85: istore 4
    //   87: iconst_1
    //   88: istore_2
    //   89: aload 8
    //   91: invokevirtual 35	org/json/JSONArray:length	()I
    //   94: istore 6
    //   96: iload 4
    //   98: iload 6
    //   100: if_icmpge +126 -> 226
    //   103: aload 8
    //   105: iload 4
    //   107: invokevirtual 39	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   110: astore 14
    //   112: aload 14
    //   114: ldc 68
    //   116: invokevirtual 71	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   119: astore 13
    //   121: aload 14
    //   123: ldc 73
    //   125: invokevirtual 77	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   128: istore 6
    //   130: aload 14
    //   132: ldc 79
    //   134: invokevirtual 77	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   137: istore 7
    //   139: new 81	com/tencent/featuretoggle/hltxkg/common/a/a
    //   142: dup
    //   143: invokespecial 82	com/tencent/featuretoggle/hltxkg/common/a/a:<init>	()V
    //   146: astore 14
    //   148: new 84	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   155: astore 15
    //   157: aload 15
    //   159: aload 13
    //   161: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload 15
    //   167: ldc 91
    //   169: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload 15
    //   175: iload 6
    //   177: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload 14
    //   183: aload 15
    //   185: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokevirtual 101	com/tencent/featuretoggle/hltxkg/common/a/a:a	(Ljava/lang/String;)Z
    //   191: ifeq +26 -> 217
    //   194: aload 14
    //   196: iload 7
    //   198: i2b
    //   199: invokevirtual 104	com/tencent/featuretoggle/hltxkg/common/a/a:a	(B)V
    //   202: aload 11
    //   204: aload 14
    //   206: invokeinterface 110 2 0
    //   211: pop
    //   212: iconst_0
    //   213: istore_2
    //   214: goto +3 -> 217
    //   217: iload 4
    //   219: iconst_1
    //   220: iadd
    //   221: istore 4
    //   223: goto -134 -> 89
    //   226: goto +5 -> 231
    //   229: iconst_1
    //   230: istore_2
    //   231: iload_2
    //   232: ifeq +138 -> 370
    //   235: aload 12
    //   237: ifnull +133 -> 370
    //   240: iconst_0
    //   241: istore_2
    //   242: aload 12
    //   244: invokevirtual 35	org/json/JSONArray:length	()I
    //   247: istore 4
    //   249: iload_2
    //   250: iload 4
    //   252: if_icmpge +118 -> 370
    //   255: aload 12
    //   257: iload_2
    //   258: invokevirtual 39	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   261: astore 13
    //   263: aload 13
    //   265: ldc 68
    //   267: invokevirtual 71	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   270: astore 8
    //   272: aload 13
    //   274: ldc 73
    //   276: invokevirtual 77	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   279: istore 4
    //   281: aload 13
    //   283: ldc 79
    //   285: invokevirtual 77	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   288: istore 6
    //   290: new 81	com/tencent/featuretoggle/hltxkg/common/a/a
    //   293: dup
    //   294: invokespecial 82	com/tencent/featuretoggle/hltxkg/common/a/a:<init>	()V
    //   297: astore 13
    //   299: new 84	java/lang/StringBuilder
    //   302: dup
    //   303: invokespecial 85	java/lang/StringBuilder:<init>	()V
    //   306: astore 14
    //   308: aload 14
    //   310: aload 8
    //   312: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: pop
    //   316: aload 14
    //   318: ldc 91
    //   320: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: pop
    //   324: aload 14
    //   326: iload 4
    //   328: invokevirtual 94	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   331: pop
    //   332: aload 13
    //   334: aload 14
    //   336: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   339: invokevirtual 101	com/tencent/featuretoggle/hltxkg/common/a/a:a	(Ljava/lang/String;)Z
    //   342: ifeq +21 -> 363
    //   345: aload 13
    //   347: iload 6
    //   349: i2b
    //   350: invokevirtual 104	com/tencent/featuretoggle/hltxkg/common/a/a:a	(B)V
    //   353: aload 11
    //   355: aload 13
    //   357: invokeinterface 110 2 0
    //   362: pop
    //   363: iload_2
    //   364: iconst_1
    //   365: iadd
    //   366: istore_2
    //   367: goto -125 -> 242
    //   370: aload 11
    //   372: invokeinterface 114 1 0
    //   377: ifne +71 -> 448
    //   380: iconst_0
    //   381: istore_2
    //   382: aload 9
    //   384: invokevirtual 35	org/json/JSONArray:length	()I
    //   387: istore 4
    //   389: iload_2
    //   390: iload 4
    //   392: if_icmpge +56 -> 448
    //   395: new 116	com/tencent/featuretoggle/hltxkg/common/a/c/c
    //   398: dup
    //   399: aload 9
    //   401: iload_2
    //   402: invokevirtual 119	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   405: aload 10
    //   407: invokespecial 122	com/tencent/featuretoggle/hltxkg/common/a/c/c:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   410: astore 8
    //   412: aload 8
    //   414: iload 5
    //   416: putfield 126	com/tencent/featuretoggle/hltxkg/common/a/c/c:d	I
    //   419: aload 8
    //   421: getfield 130	com/tencent/featuretoggle/hltxkg/common/a/c/c:c	Ljava/util/List;
    //   424: aload 11
    //   426: invokeinterface 134 2 0
    //   431: pop
    //   432: aload_0
    //   433: aload 8
    //   435: invokevirtual 139	com/tencent/featuretoggle/hltxkg/common/a/c/b:a	(Lcom/tencent/featuretoggle/hltxkg/common/a/c/c;)V
    //   438: goto +3 -> 441
    //   441: iload_2
    //   442: iconst_1
    //   443: iadd
    //   444: istore_2
    //   445: goto -63 -> 382
    //   448: iload_3
    //   449: iconst_1
    //   450: iadd
    //   451: istore_3
    //   452: goto -450 -> 2
    //   455: return
    //   456: astore_0
    //   457: aload_0
    //   458: invokevirtual 142	java/lang/Exception:printStackTrace	()V
    //   461: return
    //   462: astore 13
    //   464: goto -247 -> 217
    //   467: astore 13
    //   469: goto -252 -> 217
    //   472: astore 13
    //   474: goto -257 -> 217
    //   477: astore 8
    //   479: goto -116 -> 363
    //   482: astore 8
    //   484: goto -43 -> 441
    //   487: astore 8
    //   489: goto -48 -> 441
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	492	0	paramb	com.tencent.featuretoggle.hltxkg.common.a.c.b
    //   0	492	1	paramJSONArray	org.json.JSONArray
    //   88	357	2	i	int
    //   1	451	3	j	int
    //   85	308	4	k	int
    //   63	352	5	m	int
    //   94	254	6	n	int
    //   137	60	7	i1	int
    //   42	392	8	localObject1	Object
    //   477	1	8	localThrowable1	java.lang.Throwable
    //   482	1	8	localThrowable2	java.lang.Throwable
    //   487	1	8	localThrowable3	java.lang.Throwable
    //   24	376	9	localJSONArray1	org.json.JSONArray
    //   51	355	10	str	String
    //   15	410	11	localObject2	Object
    //   33	223	12	localJSONArray2	org.json.JSONArray
    //   119	237	13	localObject3	Object
    //   462	1	13	localThrowable4	java.lang.Throwable
    //   467	1	13	localThrowable5	java.lang.Throwable
    //   472	1	13	localThrowable6	java.lang.Throwable
    //   110	225	14	localObject4	Object
    //   155	29	15	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	65	456	java/lang/Exception
    //   70	79	456	java/lang/Exception
    //   89	96	456	java/lang/Exception
    //   103	139	456	java/lang/Exception
    //   139	148	456	java/lang/Exception
    //   148	212	456	java/lang/Exception
    //   242	249	456	java/lang/Exception
    //   255	363	456	java/lang/Exception
    //   370	380	456	java/lang/Exception
    //   382	389	456	java/lang/Exception
    //   395	432	456	java/lang/Exception
    //   432	438	456	java/lang/Exception
    //   103	139	462	java/lang/Throwable
    //   139	148	467	java/lang/Throwable
    //   148	212	472	java/lang/Throwable
    //   255	363	477	java/lang/Throwable
    //   395	432	482	java/lang/Throwable
    //   432	438	487	java/lang/Throwable
  }
  
  public final List<c> a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonACB;
    if ((localObject != null) && (((com.tencent.featuretoggle.hltxkg.common.a.c.b)localObject).a().equals(e.b())))
    {
      localObject = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonACB.b().entrySet().iterator();
      while (localIterator.hasNext()) {
        ((List)localObject).add(((Map.Entry)localIterator.next()).getValue());
      }
      return localObject;
    }
    com.tencent.featuretoggle.hltxkg.common.a.i().post(new b(this));
    return null;
  }
  
  public final void a(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    this.jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonCBBBA.a(paramString1, paramArrayOfByte);
    com.tencent.featuretoggle.hltxkg.common.a.i().post(new b(this));
  }
  
  public final String b()
  {
    return "accessscheduler";
  }
  
  public final void c()
  {
    f.d().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.common.c.a.a.a
 * JD-Core Version:    0.7.0.1
 */