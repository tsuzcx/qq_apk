package com.tencent.mobileqq.app;

import anks;
import java.util.ArrayList;

public class DiscussionHandler$2
  implements Runnable
{
  public DiscussionHandler$2(anks paramanks, long paramLong, ArrayList paramArrayList) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 38
    //   8: iconst_2
    //   9: ldc 40
    //   11: invokestatic 44	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: aload_0
    //   15: getfield 17	com/tencent/mobileqq/app/DiscussionHandler$2:jdField_a_of_type_Long	J
    //   18: lstore 4
    //   20: new 46	org/apache/http/impl/client/DefaultHttpClient
    //   23: dup
    //   24: invokespecial 47	org/apache/http/impl/client/DefaultHttpClient:<init>	()V
    //   27: astore 7
    //   29: new 49	org/apache/http/protocol/BasicHttpContext
    //   32: dup
    //   33: invokespecial 50	org/apache/http/protocol/BasicHttpContext:<init>	()V
    //   36: astore 8
    //   38: new 52	org/apache/http/client/methods/HttpPost
    //   41: dup
    //   42: ldc 54
    //   44: invokespecial 57	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   47: astore 9
    //   49: new 59	java/util/ArrayList
    //   52: dup
    //   53: invokespecial 60	java/util/ArrayList:<init>	()V
    //   56: pop
    //   57: new 62	org/json/JSONArray
    //   60: dup
    //   61: invokespecial 63	org/json/JSONArray:<init>	()V
    //   64: astore 10
    //   66: aload_0
    //   67: getfield 15	com/tencent/mobileqq/app/DiscussionHandler$2:this$0	Lanks;
    //   70: getfield 69	anks:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   73: bipush 53
    //   75: invokevirtual 75	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   78: checkcast 77	ankw
    //   81: lload 4
    //   83: invokestatic 83	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   86: aload_0
    //   87: getfield 15	com/tencent/mobileqq/app/DiscussionHandler$2:this$0	Lanks;
    //   90: getfield 69	anks:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   93: invokevirtual 87	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   96: invokevirtual 90	ankw:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mobileqq/data/DiscussionMemberInfo;
    //   99: astore 11
    //   101: invokestatic 96	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   104: invokevirtual 100	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   107: ldc 101
    //   109: invokevirtual 107	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   112: astore 6
    //   114: aload 11
    //   116: ifnull +711 -> 827
    //   119: aload 11
    //   121: getfield 113	com/tencent/mobileqq/data/DiscussionMemberInfo:inteRemark	Ljava/lang/String;
    //   124: astore 6
    //   126: iconst_0
    //   127: istore_1
    //   128: iload_1
    //   129: aload_0
    //   130: getfield 19	com/tencent/mobileqq/app/DiscussionHandler$2:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   133: invokevirtual 117	java/util/ArrayList:size	()I
    //   136: if_icmpge +65 -> 201
    //   139: new 119	org/json/JSONObject
    //   142: dup
    //   143: invokespecial 120	org/json/JSONObject:<init>	()V
    //   146: astore 11
    //   148: aload 11
    //   150: ldc 122
    //   152: aload_0
    //   153: getfield 19	com/tencent/mobileqq/app/DiscussionHandler$2:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   156: iload_1
    //   157: invokevirtual 126	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   160: checkcast 128	QQService/AddDiscussMemberInfo
    //   163: invokevirtual 132	QQService/AddDiscussMemberInfo:getUin	()J
    //   166: invokestatic 83	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   169: invokevirtual 136	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   172: pop
    //   173: aload 11
    //   175: ldc 138
    //   177: aload 6
    //   179: invokevirtual 141	java/lang/String:toString	()Ljava/lang/String;
    //   182: invokevirtual 136	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   185: pop
    //   186: aload 10
    //   188: aload 11
    //   190: invokevirtual 144	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   193: pop
    //   194: iload_1
    //   195: iconst_1
    //   196: iadd
    //   197: istore_1
    //   198: goto -70 -> 128
    //   201: new 59	java/util/ArrayList
    //   204: dup
    //   205: invokespecial 60	java/util/ArrayList:<init>	()V
    //   208: astore 6
    //   210: new 146	org/apache/http/message/BasicNameValuePair
    //   213: dup
    //   214: ldc 148
    //   216: aload 10
    //   218: invokevirtual 149	org/json/JSONArray:toString	()Ljava/lang/String;
    //   221: invokespecial 152	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   224: astore 11
    //   226: new 146	org/apache/http/message/BasicNameValuePair
    //   229: dup
    //   230: ldc 154
    //   232: lload 4
    //   234: invokestatic 83	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   237: invokespecial 152	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   240: astore 12
    //   242: aload 6
    //   244: aload 11
    //   246: invokeinterface 160 2 0
    //   251: pop
    //   252: aload 6
    //   254: aload 12
    //   256: invokeinterface 160 2 0
    //   261: pop
    //   262: new 119	org/json/JSONObject
    //   265: dup
    //   266: invokespecial 120	org/json/JSONObject:<init>	()V
    //   269: astore 11
    //   271: aload 11
    //   273: ldc 148
    //   275: aload 10
    //   277: invokevirtual 149	org/json/JSONArray:toString	()Ljava/lang/String;
    //   280: invokevirtual 136	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   283: pop
    //   284: aload 11
    //   286: ldc 154
    //   288: lload 4
    //   290: invokestatic 83	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   293: invokevirtual 136	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   296: pop
    //   297: new 162	java/util/HashMap
    //   300: dup
    //   301: invokespecial 163	java/util/HashMap:<init>	()V
    //   304: astore 11
    //   306: aload 11
    //   308: ldc 148
    //   310: aload 10
    //   312: invokevirtual 149	org/json/JSONArray:toString	()Ljava/lang/String;
    //   315: invokevirtual 166	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   318: pop
    //   319: aload 11
    //   321: ldc 154
    //   323: lload 4
    //   325: invokestatic 83	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   328: invokevirtual 166	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   331: pop
    //   332: aload 11
    //   334: invokevirtual 167	java/util/HashMap:toString	()Ljava/lang/String;
    //   337: astore 10
    //   339: new 169	org/apache/http/client/entity/UrlEncodedFormEntity
    //   342: dup
    //   343: aload 6
    //   345: ldc 171
    //   347: invokespecial 174	org/apache/http/client/entity/UrlEncodedFormEntity:<init>	(Ljava/util/List;Ljava/lang/String;)V
    //   350: astore 6
    //   352: new 176	org/apache/http/entity/StringEntity
    //   355: dup
    //   356: aload 10
    //   358: ldc 171
    //   360: invokespecial 177	org/apache/http/entity/StringEntity:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   363: ldc 179
    //   365: invokevirtual 182	org/apache/http/entity/StringEntity:setContentType	(Ljava/lang/String;)V
    //   368: aload 9
    //   370: aload 6
    //   372: invokevirtual 186	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   375: iconst_m1
    //   376: istore_3
    //   377: iload_3
    //   378: istore_2
    //   379: aload_0
    //   380: getfield 15	com/tencent/mobileqq/app/DiscussionHandler$2:this$0	Lanks;
    //   383: getfield 69	anks:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   386: iconst_2
    //   387: invokevirtual 75	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   390: checkcast 188	mqq/manager/TicketManager
    //   393: astore 6
    //   395: aload 6
    //   397: ifnonnull +26 -> 423
    //   400: aload 7
    //   402: invokeinterface 194 1 0
    //   407: invokeinterface 199 1 0
    //   412: return
    //   413: astore 6
    //   415: aload 6
    //   417: invokevirtual 202	org/json/JSONException:printStackTrace	()V
    //   420: goto -45 -> 375
    //   423: iload_3
    //   424: istore_2
    //   425: aload 6
    //   427: aload_0
    //   428: getfield 15	com/tencent/mobileqq/app/DiscussionHandler$2:this$0	Lanks;
    //   431: getfield 69	anks:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   434: invokevirtual 205	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   437: invokeinterface 209 2 0
    //   442: astore 6
    //   444: aload 6
    //   446: ifnull +15 -> 461
    //   449: iload_3
    //   450: istore_2
    //   451: aload 6
    //   453: invokevirtual 212	java/lang/String:length	()I
    //   456: istore_1
    //   457: iload_1
    //   458: ifne +16 -> 474
    //   461: aload 7
    //   463: invokeinterface 194 1 0
    //   468: invokeinterface 199 1 0
    //   473: return
    //   474: iload_3
    //   475: istore_2
    //   476: aload_0
    //   477: getfield 15	com/tencent/mobileqq/app/DiscussionHandler$2:this$0	Lanks;
    //   480: getfield 69	anks:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   483: invokevirtual 215	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   486: astore 10
    //   488: iload_3
    //   489: istore_2
    //   490: aload 9
    //   492: ldc 217
    //   494: new 219	java/lang/StringBuilder
    //   497: dup
    //   498: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   501: ldc 222
    //   503: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: aload 10
    //   508: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: ldc 228
    //   513: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: aload 6
    //   518: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   524: invokevirtual 232	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   527: iload_3
    //   528: istore_2
    //   529: aload 7
    //   531: aload 9
    //   533: aload 8
    //   535: invokeinterface 236 3 0
    //   540: astore 6
    //   542: iload_3
    //   543: istore_1
    //   544: iload_3
    //   545: istore_2
    //   546: aload 6
    //   548: invokeinterface 242 1 0
    //   553: invokeinterface 247 1 0
    //   558: sipush 200
    //   561: if_icmpne +74 -> 635
    //   564: new 119	org/json/JSONObject
    //   567: dup
    //   568: aload 6
    //   570: invokeinterface 251 1 0
    //   575: invokestatic 256	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
    //   578: invokespecial 257	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   581: astore 6
    //   583: aload 6
    //   585: ldc_w 259
    //   588: invokevirtual 263	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   591: ifne +231 -> 822
    //   594: aload 6
    //   596: ldc_w 265
    //   599: invokevirtual 269	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   602: ifeq +220 -> 822
    //   605: aload 6
    //   607: ldc_w 265
    //   610: invokevirtual 273	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   613: astore 6
    //   615: aload 6
    //   617: ldc_w 275
    //   620: invokevirtual 269	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   623: ifeq +199 -> 822
    //   626: aload 6
    //   628: ldc_w 275
    //   631: invokevirtual 263	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   634: istore_1
    //   635: iload_1
    //   636: istore_2
    //   637: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   640: ifeq +31 -> 671
    //   643: iload_1
    //   644: istore_2
    //   645: ldc 38
    //   647: iconst_2
    //   648: new 219	java/lang/StringBuilder
    //   651: dup
    //   652: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   655: ldc_w 277
    //   658: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   661: aconst_null
    //   662: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   668: invokestatic 44	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   671: aload 7
    //   673: invokeinterface 194 1 0
    //   678: invokeinterface 199 1 0
    //   683: iload_1
    //   684: ifne +88 -> 772
    //   687: aload_0
    //   688: getfield 15	com/tencent/mobileqq/app/DiscussionHandler$2:this$0	Lanks;
    //   691: aload_0
    //   692: getfield 17	com/tencent/mobileqq/app/DiscussionHandler$2:jdField_a_of_type_Long	J
    //   695: aload_0
    //   696: getfield 19	com/tencent/mobileqq/app/DiscussionHandler$2:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   699: invokevirtual 280	anks:a	(JLjava/util/ArrayList;)V
    //   702: return
    //   703: astore 6
    //   705: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   708: ifeq +30 -> 738
    //   711: ldc 38
    //   713: iconst_2
    //   714: new 219	java/lang/StringBuilder
    //   717: dup
    //   718: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   721: ldc_w 282
    //   724: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: aload 6
    //   729: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   732: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   735: invokestatic 44	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   738: aload 7
    //   740: invokeinterface 194 1 0
    //   745: invokeinterface 199 1 0
    //   750: iload_2
    //   751: istore_1
    //   752: goto -69 -> 683
    //   755: astore 6
    //   757: aload 7
    //   759: invokeinterface 194 1 0
    //   764: invokeinterface 199 1 0
    //   769: aload 6
    //   771: athrow
    //   772: aload_0
    //   773: getfield 15	com/tencent/mobileqq/app/DiscussionHandler$2:this$0	Lanks;
    //   776: sipush 1003
    //   779: iconst_0
    //   780: iconst_2
    //   781: anewarray 4	java/lang/Object
    //   784: dup
    //   785: iconst_0
    //   786: aload_0
    //   787: getfield 17	com/tencent/mobileqq/app/DiscussionHandler$2:jdField_a_of_type_Long	J
    //   790: invokestatic 83	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   793: aastore
    //   794: dup
    //   795: iconst_1
    //   796: iconst_m1
    //   797: invokestatic 290	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   800: aastore
    //   801: invokevirtual 294	anks:notifyUI	(IZLjava/lang/Object;)V
    //   804: return
    //   805: astore 6
    //   807: iload_3
    //   808: istore_1
    //   809: goto -174 -> 635
    //   812: astore 6
    //   814: goto -439 -> 375
    //   817: astore 11
    //   819: goto -625 -> 194
    //   822: iconst_m1
    //   823: istore_1
    //   824: goto -189 -> 635
    //   827: goto -701 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	830	0	this	2
    //   127	697	1	i	int
    //   378	373	2	j	int
    //   376	432	3	k	int
    //   18	306	4	l	long
    //   112	284	6	localObject1	Object
    //   413	13	6	localJSONException1	org.json.JSONException
    //   442	185	6	localObject2	Object
    //   703	25	6	localException1	java.lang.Exception
    //   755	15	6	localObject3	Object
    //   805	1	6	localException2	java.lang.Exception
    //   812	1	6	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
    //   27	731	7	localDefaultHttpClient	org.apache.http.impl.client.DefaultHttpClient
    //   36	498	8	localBasicHttpContext	org.apache.http.protocol.BasicHttpContext
    //   47	485	9	localHttpPost	org.apache.http.client.methods.HttpPost
    //   64	443	10	localObject4	Object
    //   99	234	11	localObject5	Object
    //   817	1	11	localJSONException2	org.json.JSONException
    //   240	15	12	localBasicNameValuePair	org.apache.http.message.BasicNameValuePair
    // Exception table:
    //   from	to	target	type
    //   262	375	413	org/json/JSONException
    //   379	395	703	java/lang/Exception
    //   425	444	703	java/lang/Exception
    //   451	457	703	java/lang/Exception
    //   476	488	703	java/lang/Exception
    //   490	527	703	java/lang/Exception
    //   529	542	703	java/lang/Exception
    //   546	564	703	java/lang/Exception
    //   637	643	703	java/lang/Exception
    //   645	671	703	java/lang/Exception
    //   379	395	755	finally
    //   425	444	755	finally
    //   451	457	755	finally
    //   476	488	755	finally
    //   490	527	755	finally
    //   529	542	755	finally
    //   546	564	755	finally
    //   564	635	755	finally
    //   637	643	755	finally
    //   645	671	755	finally
    //   705	738	755	finally
    //   564	635	805	java/lang/Exception
    //   262	375	812	java/io/UnsupportedEncodingException
    //   148	194	817	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.DiscussionHandler.2
 * JD-Core Version:    0.7.0.1
 */