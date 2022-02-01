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
    //   67: getfield 15	com/tencent/mobileqq/app/DiscussionHandler$2:this$0	Lcom/tencent/mobileqq/app/DiscussionHandler;
    //   70: invokestatic 68	com/tencent/mobileqq/app/DiscussionHandler:a	(Lcom/tencent/mobileqq/app/DiscussionHandler;)Lcom/tencent/mobileqq/app/QQAppInterface;
    //   73: getstatic 74	com/tencent/mobileqq/app/QQManagerFactory:DISCUSSION_MANAGER	I
    //   76: invokevirtual 80	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   79: checkcast 82	com/tencent/mobileqq/app/DiscussionManager
    //   82: lload 4
    //   84: invokestatic 88	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   87: aload_0
    //   88: getfield 15	com/tencent/mobileqq/app/DiscussionHandler$2:this$0	Lcom/tencent/mobileqq/app/DiscussionHandler;
    //   91: invokestatic 68	com/tencent/mobileqq/app/DiscussionHandler:a	(Lcom/tencent/mobileqq/app/DiscussionHandler;)Lcom/tencent/mobileqq/app/QQAppInterface;
    //   94: invokevirtual 92	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   97: invokevirtual 95	com/tencent/mobileqq/app/DiscussionManager:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mobileqq/data/DiscussionMemberInfo;
    //   100: astore 11
    //   102: invokestatic 101	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   105: invokevirtual 105	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   108: ldc 106
    //   110: invokevirtual 112	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   113: astore 6
    //   115: aload 11
    //   117: ifnull +711 -> 828
    //   120: aload 11
    //   122: getfield 118	com/tencent/mobileqq/data/DiscussionMemberInfo:inteRemark	Ljava/lang/String;
    //   125: astore 6
    //   127: iconst_0
    //   128: istore_1
    //   129: iload_1
    //   130: aload_0
    //   131: getfield 19	com/tencent/mobileqq/app/DiscussionHandler$2:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   134: invokevirtual 122	java/util/ArrayList:size	()I
    //   137: if_icmpge +65 -> 202
    //   140: new 124	org/json/JSONObject
    //   143: dup
    //   144: invokespecial 125	org/json/JSONObject:<init>	()V
    //   147: astore 11
    //   149: aload 11
    //   151: ldc 127
    //   153: aload_0
    //   154: getfield 19	com/tencent/mobileqq/app/DiscussionHandler$2:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   157: iload_1
    //   158: invokevirtual 131	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   161: checkcast 133	QQService/AddDiscussMemberInfo
    //   164: invokevirtual 137	QQService/AddDiscussMemberInfo:getUin	()J
    //   167: invokestatic 88	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   170: invokevirtual 141	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   173: pop
    //   174: aload 11
    //   176: ldc 143
    //   178: aload 6
    //   180: invokevirtual 146	java/lang/String:toString	()Ljava/lang/String;
    //   183: invokevirtual 141	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   186: pop
    //   187: aload 10
    //   189: aload 11
    //   191: invokevirtual 149	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   194: pop
    //   195: iload_1
    //   196: iconst_1
    //   197: iadd
    //   198: istore_1
    //   199: goto -70 -> 129
    //   202: new 59	java/util/ArrayList
    //   205: dup
    //   206: invokespecial 60	java/util/ArrayList:<init>	()V
    //   209: astore 6
    //   211: new 151	org/apache/http/message/BasicNameValuePair
    //   214: dup
    //   215: ldc 153
    //   217: aload 10
    //   219: invokevirtual 154	org/json/JSONArray:toString	()Ljava/lang/String;
    //   222: invokespecial 157	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   225: astore 11
    //   227: new 151	org/apache/http/message/BasicNameValuePair
    //   230: dup
    //   231: ldc 159
    //   233: lload 4
    //   235: invokestatic 88	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   238: invokespecial 157	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   241: astore 12
    //   243: aload 6
    //   245: aload 11
    //   247: invokeinterface 165 2 0
    //   252: pop
    //   253: aload 6
    //   255: aload 12
    //   257: invokeinterface 165 2 0
    //   262: pop
    //   263: new 124	org/json/JSONObject
    //   266: dup
    //   267: invokespecial 125	org/json/JSONObject:<init>	()V
    //   270: astore 11
    //   272: aload 11
    //   274: ldc 153
    //   276: aload 10
    //   278: invokevirtual 154	org/json/JSONArray:toString	()Ljava/lang/String;
    //   281: invokevirtual 141	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   284: pop
    //   285: aload 11
    //   287: ldc 159
    //   289: lload 4
    //   291: invokestatic 88	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   294: invokevirtual 141	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   297: pop
    //   298: new 167	java/util/HashMap
    //   301: dup
    //   302: invokespecial 168	java/util/HashMap:<init>	()V
    //   305: astore 11
    //   307: aload 11
    //   309: ldc 153
    //   311: aload 10
    //   313: invokevirtual 154	org/json/JSONArray:toString	()Ljava/lang/String;
    //   316: invokevirtual 171	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   319: pop
    //   320: aload 11
    //   322: ldc 159
    //   324: lload 4
    //   326: invokestatic 88	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   329: invokevirtual 171	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   332: pop
    //   333: aload 11
    //   335: invokevirtual 172	java/util/HashMap:toString	()Ljava/lang/String;
    //   338: astore 10
    //   340: new 174	org/apache/http/client/entity/UrlEncodedFormEntity
    //   343: dup
    //   344: aload 6
    //   346: ldc 176
    //   348: invokespecial 179	org/apache/http/client/entity/UrlEncodedFormEntity:<init>	(Ljava/util/List;Ljava/lang/String;)V
    //   351: astore 6
    //   353: new 181	org/apache/http/entity/StringEntity
    //   356: dup
    //   357: aload 10
    //   359: ldc 176
    //   361: invokespecial 182	org/apache/http/entity/StringEntity:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   364: ldc 184
    //   366: invokevirtual 187	org/apache/http/entity/StringEntity:setContentType	(Ljava/lang/String;)V
    //   369: aload 9
    //   371: aload 6
    //   373: invokevirtual 191	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   376: iconst_m1
    //   377: istore_3
    //   378: iload_3
    //   379: istore_2
    //   380: aload_0
    //   381: getfield 15	com/tencent/mobileqq/app/DiscussionHandler$2:this$0	Lcom/tencent/mobileqq/app/DiscussionHandler;
    //   384: invokestatic 68	com/tencent/mobileqq/app/DiscussionHandler:a	(Lcom/tencent/mobileqq/app/DiscussionHandler;)Lcom/tencent/mobileqq/app/QQAppInterface;
    //   387: iconst_2
    //   388: invokevirtual 80	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   391: checkcast 193	mqq/manager/TicketManager
    //   394: astore 6
    //   396: aload 6
    //   398: ifnonnull +26 -> 424
    //   401: aload 7
    //   403: invokeinterface 199 1 0
    //   408: invokeinterface 204 1 0
    //   413: return
    //   414: astore 6
    //   416: aload 6
    //   418: invokevirtual 207	org/json/JSONException:printStackTrace	()V
    //   421: goto -45 -> 376
    //   424: iload_3
    //   425: istore_2
    //   426: aload 6
    //   428: aload_0
    //   429: getfield 15	com/tencent/mobileqq/app/DiscussionHandler$2:this$0	Lcom/tencent/mobileqq/app/DiscussionHandler;
    //   432: invokestatic 68	com/tencent/mobileqq/app/DiscussionHandler:a	(Lcom/tencent/mobileqq/app/DiscussionHandler;)Lcom/tencent/mobileqq/app/QQAppInterface;
    //   435: invokevirtual 210	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   438: invokeinterface 214 2 0
    //   443: astore 6
    //   445: aload 6
    //   447: ifnull +15 -> 462
    //   450: iload_3
    //   451: istore_2
    //   452: aload 6
    //   454: invokevirtual 217	java/lang/String:length	()I
    //   457: istore_1
    //   458: iload_1
    //   459: ifne +16 -> 475
    //   462: aload 7
    //   464: invokeinterface 199 1 0
    //   469: invokeinterface 204 1 0
    //   474: return
    //   475: iload_3
    //   476: istore_2
    //   477: aload_0
    //   478: getfield 15	com/tencent/mobileqq/app/DiscussionHandler$2:this$0	Lcom/tencent/mobileqq/app/DiscussionHandler;
    //   481: invokestatic 68	com/tencent/mobileqq/app/DiscussionHandler:a	(Lcom/tencent/mobileqq/app/DiscussionHandler;)Lcom/tencent/mobileqq/app/QQAppInterface;
    //   484: invokevirtual 220	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   487: astore 10
    //   489: iload_3
    //   490: istore_2
    //   491: aload 9
    //   493: ldc 222
    //   495: new 224	java/lang/StringBuilder
    //   498: dup
    //   499: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   502: ldc 227
    //   504: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: aload 10
    //   509: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: ldc 233
    //   514: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: aload 6
    //   519: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   525: invokevirtual 237	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   528: iload_3
    //   529: istore_2
    //   530: aload 7
    //   532: aload 9
    //   534: aload 8
    //   536: invokeinterface 241 3 0
    //   541: astore 6
    //   543: iload_3
    //   544: istore_1
    //   545: iload_3
    //   546: istore_2
    //   547: aload 6
    //   549: invokeinterface 247 1 0
    //   554: invokeinterface 252 1 0
    //   559: sipush 200
    //   562: if_icmpne +74 -> 636
    //   565: new 124	org/json/JSONObject
    //   568: dup
    //   569: aload 6
    //   571: invokeinterface 256 1 0
    //   576: invokestatic 261	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
    //   579: invokespecial 262	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   582: astore 6
    //   584: aload 6
    //   586: ldc_w 264
    //   589: invokevirtual 268	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   592: ifne +231 -> 823
    //   595: aload 6
    //   597: ldc_w 270
    //   600: invokevirtual 274	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   603: ifeq +220 -> 823
    //   606: aload 6
    //   608: ldc_w 270
    //   611: invokevirtual 278	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   614: astore 6
    //   616: aload 6
    //   618: ldc_w 280
    //   621: invokevirtual 274	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   624: ifeq +199 -> 823
    //   627: aload 6
    //   629: ldc_w 280
    //   632: invokevirtual 268	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   635: istore_1
    //   636: iload_1
    //   637: istore_2
    //   638: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   641: ifeq +31 -> 672
    //   644: iload_1
    //   645: istore_2
    //   646: ldc 38
    //   648: iconst_2
    //   649: new 224	java/lang/StringBuilder
    //   652: dup
    //   653: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   656: ldc_w 282
    //   659: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   662: aconst_null
    //   663: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   669: invokestatic 44	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   672: aload 7
    //   674: invokeinterface 199 1 0
    //   679: invokeinterface 204 1 0
    //   684: iload_1
    //   685: ifne +88 -> 773
    //   688: aload_0
    //   689: getfield 15	com/tencent/mobileqq/app/DiscussionHandler$2:this$0	Lcom/tencent/mobileqq/app/DiscussionHandler;
    //   692: aload_0
    //   693: getfield 17	com/tencent/mobileqq/app/DiscussionHandler$2:jdField_a_of_type_Long	J
    //   696: aload_0
    //   697: getfield 19	com/tencent/mobileqq/app/DiscussionHandler$2:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   700: invokevirtual 285	com/tencent/mobileqq/app/DiscussionHandler:a	(JLjava/util/ArrayList;)V
    //   703: return
    //   704: astore 6
    //   706: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   709: ifeq +30 -> 739
    //   712: ldc 38
    //   714: iconst_2
    //   715: new 224	java/lang/StringBuilder
    //   718: dup
    //   719: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   722: ldc_w 287
    //   725: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   728: aload 6
    //   730: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   733: invokevirtual 234	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   736: invokestatic 44	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   739: aload 7
    //   741: invokeinterface 199 1 0
    //   746: invokeinterface 204 1 0
    //   751: iload_2
    //   752: istore_1
    //   753: goto -69 -> 684
    //   756: astore 6
    //   758: aload 7
    //   760: invokeinterface 199 1 0
    //   765: invokeinterface 204 1 0
    //   770: aload 6
    //   772: athrow
    //   773: aload_0
    //   774: getfield 15	com/tencent/mobileqq/app/DiscussionHandler$2:this$0	Lcom/tencent/mobileqq/app/DiscussionHandler;
    //   777: sipush 1003
    //   780: iconst_0
    //   781: iconst_2
    //   782: anewarray 4	java/lang/Object
    //   785: dup
    //   786: iconst_0
    //   787: aload_0
    //   788: getfield 17	com/tencent/mobileqq/app/DiscussionHandler$2:jdField_a_of_type_Long	J
    //   791: invokestatic 88	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   794: aastore
    //   795: dup
    //   796: iconst_1
    //   797: iconst_m1
    //   798: invokestatic 295	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   801: aastore
    //   802: invokevirtual 299	com/tencent/mobileqq/app/DiscussionHandler:notifyUI	(IZLjava/lang/Object;)V
    //   805: return
    //   806: astore 6
    //   808: iload_3
    //   809: istore_1
    //   810: goto -174 -> 636
    //   813: astore 6
    //   815: goto -439 -> 376
    //   818: astore 11
    //   820: goto -625 -> 195
    //   823: iconst_m1
    //   824: istore_1
    //   825: goto -189 -> 636
    //   828: goto -701 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	831	0	this	2
    //   128	697	1	i	int
    //   379	373	2	j	int
    //   377	432	3	k	int
    //   18	307	4	l	long
    //   113	284	6	localObject1	Object
    //   414	13	6	localJSONException1	org.json.JSONException
    //   443	185	6	localObject2	Object
    //   704	25	6	localException1	java.lang.Exception
    //   756	15	6	localObject3	Object
    //   806	1	6	localException2	java.lang.Exception
    //   813	1	6	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
    //   27	732	7	localDefaultHttpClient	org.apache.http.impl.client.DefaultHttpClient
    //   36	499	8	localBasicHttpContext	org.apache.http.protocol.BasicHttpContext
    //   47	486	9	localHttpPost	org.apache.http.client.methods.HttpPost
    //   64	444	10	localObject4	Object
    //   100	234	11	localObject5	Object
    //   818	1	11	localJSONException2	org.json.JSONException
    //   241	15	12	localBasicNameValuePair	org.apache.http.message.BasicNameValuePair
    // Exception table:
    //   from	to	target	type
    //   263	376	414	org/json/JSONException
    //   380	396	704	java/lang/Exception
    //   426	445	704	java/lang/Exception
    //   452	458	704	java/lang/Exception
    //   477	489	704	java/lang/Exception
    //   491	528	704	java/lang/Exception
    //   530	543	704	java/lang/Exception
    //   547	565	704	java/lang/Exception
    //   638	644	704	java/lang/Exception
    //   646	672	704	java/lang/Exception
    //   380	396	756	finally
    //   426	445	756	finally
    //   452	458	756	finally
    //   477	489	756	finally
    //   491	528	756	finally
    //   530	543	756	finally
    //   547	565	756	finally
    //   565	636	756	finally
    //   638	644	756	finally
    //   646	672	756	finally
    //   706	739	756	finally
    //   565	636	806	java/lang/Exception
    //   263	376	813	java/io/UnsupportedEncodingException
    //   149	195	818	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.DiscussionHandler.2
 * JD-Core Version:    0.7.0.1
 */