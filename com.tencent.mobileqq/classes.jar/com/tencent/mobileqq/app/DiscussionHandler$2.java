package com.tencent.mobileqq.app;

import java.util.ArrayList;

class DiscussionHandler$2
  implements Runnable
{
  DiscussionHandler$2(DiscussionHandler paramDiscussionHandler, long paramLong, ArrayList paramArrayList) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 37	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 39
    //   8: iconst_2
    //   9: ldc 41
    //   11: invokestatic 45	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: aload_0
    //   15: getfield 18	com/tencent/mobileqq/app/DiscussionHandler$2:a	J
    //   18: lstore_3
    //   19: new 47	org/apache/http/impl/client/DefaultHttpClient
    //   22: dup
    //   23: invokespecial 48	org/apache/http/impl/client/DefaultHttpClient:<init>	()V
    //   26: astore 6
    //   28: new 50	org/apache/http/protocol/BasicHttpContext
    //   31: dup
    //   32: invokespecial 51	org/apache/http/protocol/BasicHttpContext:<init>	()V
    //   35: astore 7
    //   37: new 53	org/apache/http/client/methods/HttpPost
    //   40: dup
    //   41: ldc 55
    //   43: invokespecial 58	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   46: astore 8
    //   48: new 60	java/util/ArrayList
    //   51: dup
    //   52: invokespecial 61	java/util/ArrayList:<init>	()V
    //   55: pop
    //   56: new 63	org/json/JSONArray
    //   59: dup
    //   60: invokespecial 64	org/json/JSONArray:<init>	()V
    //   63: astore 9
    //   65: aload_0
    //   66: getfield 16	com/tencent/mobileqq/app/DiscussionHandler$2:this$0	Lcom/tencent/mobileqq/app/DiscussionHandler;
    //   69: invokestatic 69	com/tencent/mobileqq/app/DiscussionHandler:a	(Lcom/tencent/mobileqq/app/DiscussionHandler;)Lcom/tencent/mobileqq/app/QQAppInterface;
    //   72: getstatic 75	com/tencent/mobileqq/app/QQManagerFactory:DISCUSSION_MANAGER	I
    //   75: invokevirtual 81	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   78: checkcast 83	com/tencent/mobileqq/app/DiscussionManager
    //   81: lload_3
    //   82: invokestatic 89	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   85: aload_0
    //   86: getfield 16	com/tencent/mobileqq/app/DiscussionHandler$2:this$0	Lcom/tencent/mobileqq/app/DiscussionHandler;
    //   89: invokestatic 69	com/tencent/mobileqq/app/DiscussionHandler:a	(Lcom/tencent/mobileqq/app/DiscussionHandler;)Lcom/tencent/mobileqq/app/QQAppInterface;
    //   92: invokevirtual 93	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   95: invokevirtual 96	com/tencent/mobileqq/app/DiscussionManager:b	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mobileqq/data/DiscussionMemberInfo;
    //   98: astore 10
    //   100: invokestatic 102	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   103: invokevirtual 106	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   106: ldc 107
    //   108: invokevirtual 113	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   111: astore 5
    //   113: aload 10
    //   115: ifnull +10 -> 125
    //   118: aload 10
    //   120: getfield 119	com/tencent/mobileqq/data/DiscussionMemberInfo:inteRemark	Ljava/lang/String;
    //   123: astore 5
    //   125: iconst_0
    //   126: istore_1
    //   127: iload_1
    //   128: aload_0
    //   129: getfield 20	com/tencent/mobileqq/app/DiscussionHandler$2:b	Ljava/util/ArrayList;
    //   132: invokevirtual 123	java/util/ArrayList:size	()I
    //   135: if_icmpge +65 -> 200
    //   138: new 125	org/json/JSONObject
    //   141: dup
    //   142: invokespecial 126	org/json/JSONObject:<init>	()V
    //   145: astore 10
    //   147: aload 10
    //   149: ldc 128
    //   151: aload_0
    //   152: getfield 20	com/tencent/mobileqq/app/DiscussionHandler$2:b	Ljava/util/ArrayList;
    //   155: iload_1
    //   156: invokevirtual 132	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   159: checkcast 134	QQService/AddDiscussMemberInfo
    //   162: invokevirtual 138	QQService/AddDiscussMemberInfo:getUin	()J
    //   165: invokestatic 89	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   168: invokevirtual 142	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   171: pop
    //   172: aload 10
    //   174: ldc 144
    //   176: aload 5
    //   178: invokevirtual 147	java/lang/String:toString	()Ljava/lang/String;
    //   181: invokevirtual 142	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   184: pop
    //   185: aload 9
    //   187: aload 10
    //   189: invokevirtual 150	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   192: pop
    //   193: iload_1
    //   194: iconst_1
    //   195: iadd
    //   196: istore_1
    //   197: goto -70 -> 127
    //   200: new 60	java/util/ArrayList
    //   203: dup
    //   204: invokespecial 61	java/util/ArrayList:<init>	()V
    //   207: astore 5
    //   209: new 152	org/apache/http/message/BasicNameValuePair
    //   212: dup
    //   213: ldc 154
    //   215: aload 9
    //   217: invokevirtual 155	org/json/JSONArray:toString	()Ljava/lang/String;
    //   220: invokespecial 158	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   223: astore 10
    //   225: new 152	org/apache/http/message/BasicNameValuePair
    //   228: dup
    //   229: ldc 160
    //   231: lload_3
    //   232: invokestatic 89	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   235: invokespecial 158	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   238: astore 11
    //   240: aload 5
    //   242: aload 10
    //   244: invokeinterface 166 2 0
    //   249: pop
    //   250: aload 5
    //   252: aload 11
    //   254: invokeinterface 166 2 0
    //   259: pop
    //   260: new 125	org/json/JSONObject
    //   263: dup
    //   264: invokespecial 126	org/json/JSONObject:<init>	()V
    //   267: astore 10
    //   269: aload 10
    //   271: ldc 154
    //   273: aload 9
    //   275: invokevirtual 155	org/json/JSONArray:toString	()Ljava/lang/String;
    //   278: invokevirtual 142	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   281: pop
    //   282: aload 10
    //   284: ldc 160
    //   286: lload_3
    //   287: invokestatic 89	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   290: invokevirtual 142	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   293: pop
    //   294: new 168	java/util/HashMap
    //   297: dup
    //   298: invokespecial 169	java/util/HashMap:<init>	()V
    //   301: astore 10
    //   303: aload 10
    //   305: ldc 154
    //   307: aload 9
    //   309: invokevirtual 155	org/json/JSONArray:toString	()Ljava/lang/String;
    //   312: invokevirtual 172	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   315: pop
    //   316: aload 10
    //   318: ldc 160
    //   320: lload_3
    //   321: invokestatic 89	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   324: invokevirtual 172	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   327: pop
    //   328: aload 10
    //   330: invokevirtual 173	java/util/HashMap:toString	()Ljava/lang/String;
    //   333: astore 9
    //   335: new 175	org/apache/http/client/entity/UrlEncodedFormEntity
    //   338: dup
    //   339: aload 5
    //   341: ldc 177
    //   343: invokespecial 180	org/apache/http/client/entity/UrlEncodedFormEntity:<init>	(Ljava/util/List;Ljava/lang/String;)V
    //   346: astore 5
    //   348: new 182	org/apache/http/entity/StringEntity
    //   351: dup
    //   352: aload 9
    //   354: ldc 177
    //   356: invokespecial 183	org/apache/http/entity/StringEntity:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   359: ldc 185
    //   361: invokevirtual 188	org/apache/http/entity/StringEntity:setContentType	(Ljava/lang/String;)V
    //   364: aload 8
    //   366: aload 5
    //   368: invokevirtual 192	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   371: goto +10 -> 381
    //   374: astore 5
    //   376: aload 5
    //   378: invokevirtual 195	org/json/JSONException:printStackTrace	()V
    //   381: aload_0
    //   382: getfield 16	com/tencent/mobileqq/app/DiscussionHandler$2:this$0	Lcom/tencent/mobileqq/app/DiscussionHandler;
    //   385: invokestatic 69	com/tencent/mobileqq/app/DiscussionHandler:a	(Lcom/tencent/mobileqq/app/DiscussionHandler;)Lcom/tencent/mobileqq/app/QQAppInterface;
    //   388: iconst_2
    //   389: invokevirtual 81	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   392: checkcast 197	mqq/manager/TicketManager
    //   395: astore 5
    //   397: aload 5
    //   399: ifnonnull +16 -> 415
    //   402: aload 6
    //   404: invokeinterface 203 1 0
    //   409: invokeinterface 208 1 0
    //   414: return
    //   415: aload 5
    //   417: aload_0
    //   418: getfield 16	com/tencent/mobileqq/app/DiscussionHandler$2:this$0	Lcom/tencent/mobileqq/app/DiscussionHandler;
    //   421: invokestatic 69	com/tencent/mobileqq/app/DiscussionHandler:a	(Lcom/tencent/mobileqq/app/DiscussionHandler;)Lcom/tencent/mobileqq/app/QQAppInterface;
    //   424: invokevirtual 211	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   427: invokeinterface 215 2 0
    //   432: astore 5
    //   434: aload 5
    //   436: ifnull -34 -> 402
    //   439: aload 5
    //   441: invokevirtual 218	java/lang/String:length	()I
    //   444: ifne +6 -> 450
    //   447: goto -45 -> 402
    //   450: aload_0
    //   451: getfield 16	com/tencent/mobileqq/app/DiscussionHandler$2:this$0	Lcom/tencent/mobileqq/app/DiscussionHandler;
    //   454: invokestatic 69	com/tencent/mobileqq/app/DiscussionHandler:a	(Lcom/tencent/mobileqq/app/DiscussionHandler;)Lcom/tencent/mobileqq/app/QQAppInterface;
    //   457: invokevirtual 221	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   460: astore 9
    //   462: new 223	java/lang/StringBuilder
    //   465: dup
    //   466: invokespecial 224	java/lang/StringBuilder:<init>	()V
    //   469: astore 10
    //   471: aload 10
    //   473: ldc 226
    //   475: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: pop
    //   479: aload 10
    //   481: aload 9
    //   483: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: pop
    //   487: aload 10
    //   489: ldc 232
    //   491: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: pop
    //   495: aload 10
    //   497: aload 5
    //   499: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: pop
    //   503: aload 8
    //   505: ldc 234
    //   507: aload 10
    //   509: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   512: invokevirtual 238	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   515: aload 6
    //   517: aload 8
    //   519: aload 7
    //   521: invokeinterface 242 3 0
    //   526: astore 5
    //   528: aload 5
    //   530: invokeinterface 248 1 0
    //   535: invokeinterface 253 1 0
    //   540: istore_1
    //   541: iload_1
    //   542: sipush 200
    //   545: if_icmpne +77 -> 622
    //   548: new 125	org/json/JSONObject
    //   551: dup
    //   552: aload 5
    //   554: invokeinterface 257 1 0
    //   559: invokestatic 262	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
    //   562: invokespecial 263	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   565: astore 5
    //   567: aload 5
    //   569: ldc_w 265
    //   572: invokevirtual 269	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   575: ifne +47 -> 622
    //   578: aload 5
    //   580: ldc_w 271
    //   583: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   586: ifeq +36 -> 622
    //   589: aload 5
    //   591: ldc_w 271
    //   594: invokevirtual 279	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   597: astore 5
    //   599: aload 5
    //   601: ldc_w 281
    //   604: invokevirtual 275	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   607: ifeq +15 -> 622
    //   610: aload 5
    //   612: ldc_w 281
    //   615: invokevirtual 269	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   618: istore_1
    //   619: goto +5 -> 624
    //   622: iconst_m1
    //   623: istore_1
    //   624: iload_1
    //   625: istore_2
    //   626: invokestatic 37	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   629: ifeq +114 -> 743
    //   632: new 223	java/lang/StringBuilder
    //   635: dup
    //   636: invokespecial 224	java/lang/StringBuilder:<init>	()V
    //   639: astore 5
    //   641: aload 5
    //   643: ldc_w 283
    //   646: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: pop
    //   650: aload 5
    //   652: aconst_null
    //   653: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   656: pop
    //   657: aload 5
    //   659: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   662: astore 5
    //   664: ldc 39
    //   666: iconst_2
    //   667: aload 5
    //   669: invokestatic 45	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   672: iload_1
    //   673: istore_2
    //   674: goto +69 -> 743
    //   677: astore 5
    //   679: goto +17 -> 696
    //   682: astore 5
    //   684: goto +12 -> 696
    //   687: astore 5
    //   689: goto +119 -> 808
    //   692: astore 5
    //   694: iconst_m1
    //   695: istore_1
    //   696: iload_1
    //   697: istore_2
    //   698: invokestatic 37	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   701: ifeq +42 -> 743
    //   704: new 223	java/lang/StringBuilder
    //   707: dup
    //   708: invokespecial 224	java/lang/StringBuilder:<init>	()V
    //   711: astore 7
    //   713: aload 7
    //   715: ldc_w 285
    //   718: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   721: pop
    //   722: aload 7
    //   724: aload 5
    //   726: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   729: pop
    //   730: ldc 39
    //   732: iconst_2
    //   733: aload 7
    //   735: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   738: invokestatic 45	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   741: iload_1
    //   742: istore_2
    //   743: aload 6
    //   745: invokeinterface 203 1 0
    //   750: invokeinterface 208 1 0
    //   755: iload_2
    //   756: ifne +19 -> 775
    //   759: aload_0
    //   760: getfield 16	com/tencent/mobileqq/app/DiscussionHandler$2:this$0	Lcom/tencent/mobileqq/app/DiscussionHandler;
    //   763: aload_0
    //   764: getfield 18	com/tencent/mobileqq/app/DiscussionHandler$2:a	J
    //   767: aload_0
    //   768: getfield 20	com/tencent/mobileqq/app/DiscussionHandler$2:b	Ljava/util/ArrayList;
    //   771: invokevirtual 291	com/tencent/mobileqq/app/DiscussionHandler:a	(JLjava/util/ArrayList;)V
    //   774: return
    //   775: aload_0
    //   776: getfield 16	com/tencent/mobileqq/app/DiscussionHandler$2:this$0	Lcom/tencent/mobileqq/app/DiscussionHandler;
    //   779: sipush 1003
    //   782: iconst_0
    //   783: iconst_2
    //   784: anewarray 4	java/lang/Object
    //   787: dup
    //   788: iconst_0
    //   789: aload_0
    //   790: getfield 18	com/tencent/mobileqq/app/DiscussionHandler$2:a	J
    //   793: invokestatic 89	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   796: aastore
    //   797: dup
    //   798: iconst_1
    //   799: iconst_m1
    //   800: invokestatic 296	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   803: aastore
    //   804: invokevirtual 300	com/tencent/mobileqq/app/DiscussionHandler:notifyUI	(IZLjava/lang/Object;)V
    //   807: return
    //   808: aload 6
    //   810: invokeinterface 203 1 0
    //   815: invokeinterface 208 1 0
    //   820: goto +6 -> 826
    //   823: aload 5
    //   825: athrow
    //   826: goto -3 -> 823
    //   829: astore 10
    //   831: goto -638 -> 193
    //   834: astore 5
    //   836: goto -455 -> 381
    //   839: astore 5
    //   841: goto -219 -> 622
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	844	0	this	2
    //   126	616	1	i	int
    //   625	131	2	j	int
    //   18	303	3	l	long
    //   111	256	5	localObject1	Object
    //   374	3	5	localJSONException1	org.json.JSONException
    //   395	273	5	localObject2	Object
    //   677	1	5	localException1	java.lang.Exception
    //   682	1	5	localException2	java.lang.Exception
    //   687	1	5	localObject3	Object
    //   692	132	5	localException3	java.lang.Exception
    //   834	1	5	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
    //   839	1	5	localException4	java.lang.Exception
    //   26	783	6	localDefaultHttpClient	org.apache.http.impl.client.DefaultHttpClient
    //   35	699	7	localObject4	Object
    //   46	472	8	localHttpPost	org.apache.http.client.methods.HttpPost
    //   63	419	9	localObject5	Object
    //   98	410	10	localObject6	Object
    //   829	1	10	localJSONException2	org.json.JSONException
    //   238	15	11	localBasicNameValuePair	org.apache.http.message.BasicNameValuePair
    // Exception table:
    //   from	to	target	type
    //   260	371	374	org/json/JSONException
    //   664	672	677	java/lang/Exception
    //   626	664	682	java/lang/Exception
    //   381	397	687	finally
    //   415	434	687	finally
    //   439	447	687	finally
    //   450	541	687	finally
    //   548	619	687	finally
    //   626	664	687	finally
    //   664	672	687	finally
    //   698	741	687	finally
    //   381	397	692	java/lang/Exception
    //   415	434	692	java/lang/Exception
    //   439	447	692	java/lang/Exception
    //   450	541	692	java/lang/Exception
    //   147	193	829	org/json/JSONException
    //   260	371	834	java/io/UnsupportedEncodingException
    //   548	619	839	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.DiscussionHandler.2
 * JD-Core Version:    0.7.0.1
 */