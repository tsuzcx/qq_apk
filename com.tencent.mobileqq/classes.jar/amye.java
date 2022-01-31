import cooperation.qqreader.QRBridgeActivity;

public class amye
  implements Runnable
{
  public amye(QRBridgeActivity paramQRBridgeActivity) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 5
    //   5: aload_0
    //   6: getfield 12	amye:a	Lcooperation/qqreader/QRBridgeActivity;
    //   9: getfield 25	cooperation/qqreader/QRBridgeActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   12: invokestatic 31	cooperation/qqreader/QRBridgeUtil:getSKey	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/lang/String;
    //   15: astore 4
    //   17: aload 4
    //   19: invokestatic 37	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   22: ifeq +18 -> 40
    //   25: invokestatic 43	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   28: ifeq +11 -> 39
    //   31: ldc 45
    //   33: iconst_4
    //   34: ldc 47
    //   36: invokestatic 51	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   39: return
    //   40: new 53	java/net/URL
    //   43: dup
    //   44: new 55	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   51: ldc 58
    //   53: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload 4
    //   58: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: ldc 64
    //   63: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokespecial 71	java/net/URL:<init>	(Ljava/lang/String;)V
    //   72: invokevirtual 75	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   75: checkcast 77	java/net/HttpURLConnection
    //   78: astore_3
    //   79: aload_3
    //   80: sipush 10000
    //   83: invokevirtual 81	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   86: aload_3
    //   87: ldc 83
    //   89: new 55	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   96: ldc 85
    //   98: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload_0
    //   102: getfield 12	amye:a	Lcooperation/qqreader/QRBridgeActivity;
    //   105: getfield 25	cooperation/qqreader/QRBridgeActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   108: invokevirtual 90	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   111: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: ldc 92
    //   116: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_0
    //   120: getfield 12	amye:a	Lcooperation/qqreader/QRBridgeActivity;
    //   123: getfield 25	cooperation/qqreader/QRBridgeActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   126: invokevirtual 90	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   129: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: ldc 94
    //   134: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload 4
    //   139: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokevirtual 98	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: aload_3
    //   149: invokevirtual 102	java/net/HttpURLConnection:getResponseCode	()I
    //   152: sipush 200
    //   155: if_icmpne +285 -> 440
    //   158: new 104	java/io/BufferedReader
    //   161: dup
    //   162: new 106	java/io/InputStreamReader
    //   165: dup
    //   166: aload_3
    //   167: invokevirtual 110	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   170: invokespecial 113	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   173: invokespecial 116	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   176: astore_2
    //   177: new 118	java/lang/StringBuffer
    //   180: dup
    //   181: invokespecial 119	java/lang/StringBuffer:<init>	()V
    //   184: astore 4
    //   186: aload_2
    //   187: invokevirtual 122	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   190: astore 5
    //   192: aload 5
    //   194: ifnull +32 -> 226
    //   197: aload 4
    //   199: aload 5
    //   201: invokevirtual 125	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   204: pop
    //   205: goto -19 -> 186
    //   208: astore 4
    //   210: aload_3
    //   211: astore_2
    //   212: aload 4
    //   214: invokevirtual 128	java/lang/Exception:printStackTrace	()V
    //   217: aload_3
    //   218: ifnull -179 -> 39
    //   221: aload_3
    //   222: invokevirtual 131	java/net/HttpURLConnection:disconnect	()V
    //   225: return
    //   226: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   229: ifeq +32 -> 261
    //   232: ldc 45
    //   234: iconst_2
    //   235: new 55	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   242: ldc 136
    //   244: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: aload 4
    //   249: invokevirtual 137	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   252: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokestatic 51	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   261: new 139	org/json/JSONObject
    //   264: dup
    //   265: aload 4
    //   267: invokevirtual 137	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   270: invokespecial 140	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   273: astore_2
    //   274: aload_0
    //   275: getfield 12	amye:a	Lcooperation/qqreader/QRBridgeActivity;
    //   278: aload_2
    //   279: ldc 142
    //   281: invokevirtual 146	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   284: putfield 149	cooperation/qqreader/QRBridgeActivity:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   287: aload_0
    //   288: getfield 12	amye:a	Lcooperation/qqreader/QRBridgeActivity;
    //   291: getfield 149	cooperation/qqreader/QRBridgeActivity:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   294: ldc 151
    //   296: invokevirtual 155	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   299: istore_1
    //   300: iload_1
    //   301: ifne +12 -> 313
    //   304: aload_3
    //   305: ifnull -266 -> 39
    //   308: aload_3
    //   309: invokevirtual 131	java/net/HttpURLConnection:disconnect	()V
    //   312: return
    //   313: aload_0
    //   314: getfield 12	amye:a	Lcooperation/qqreader/QRBridgeActivity;
    //   317: aload_0
    //   318: getfield 12	amye:a	Lcooperation/qqreader/QRBridgeActivity;
    //   321: getfield 149	cooperation/qqreader/QRBridgeActivity:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   324: ldc 151
    //   326: invokevirtual 159	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   329: putfield 163	cooperation/qqreader/QRBridgeActivity:j	Ljava/lang/String;
    //   332: aload_0
    //   333: getfield 12	amye:a	Lcooperation/qqreader/QRBridgeActivity;
    //   336: aload_0
    //   337: getfield 12	amye:a	Lcooperation/qqreader/QRBridgeActivity;
    //   340: getfield 149	cooperation/qqreader/QRBridgeActivity:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   343: ldc 165
    //   345: invokevirtual 159	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   348: putfield 168	cooperation/qqreader/QRBridgeActivity:f	Ljava/lang/String;
    //   351: aload_0
    //   352: getfield 12	amye:a	Lcooperation/qqreader/QRBridgeActivity;
    //   355: aload_0
    //   356: getfield 12	amye:a	Lcooperation/qqreader/QRBridgeActivity;
    //   359: getfield 149	cooperation/qqreader/QRBridgeActivity:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   362: ldc 170
    //   364: invokevirtual 159	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   367: putfield 173	cooperation/qqreader/QRBridgeActivity:g	Ljava/lang/String;
    //   370: aload_0
    //   371: getfield 12	amye:a	Lcooperation/qqreader/QRBridgeActivity;
    //   374: aload_0
    //   375: getfield 12	amye:a	Lcooperation/qqreader/QRBridgeActivity;
    //   378: getfield 149	cooperation/qqreader/QRBridgeActivity:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   381: ldc 175
    //   383: invokevirtual 159	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   386: putfield 178	cooperation/qqreader/QRBridgeActivity:h	Ljava/lang/String;
    //   389: aload_0
    //   390: getfield 12	amye:a	Lcooperation/qqreader/QRBridgeActivity;
    //   393: aload_0
    //   394: getfield 12	amye:a	Lcooperation/qqreader/QRBridgeActivity;
    //   397: getfield 149	cooperation/qqreader/QRBridgeActivity:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   400: ldc 180
    //   402: invokevirtual 159	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   405: putfield 183	cooperation/qqreader/QRBridgeActivity:i	Ljava/lang/String;
    //   408: aload_0
    //   409: getfield 12	amye:a	Lcooperation/qqreader/QRBridgeActivity;
    //   412: aload_0
    //   413: getfield 12	amye:a	Lcooperation/qqreader/QRBridgeActivity;
    //   416: getfield 149	cooperation/qqreader/QRBridgeActivity:jdField_a_of_type_OrgJsonJSONObject	Lorg/json/JSONObject;
    //   419: ldc 185
    //   421: invokevirtual 189	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   424: putfield 192	cooperation/qqreader/QRBridgeActivity:jdField_a_of_type_Int	I
    //   427: aload_0
    //   428: getfield 12	amye:a	Lcooperation/qqreader/QRBridgeActivity;
    //   431: getfield 195	cooperation/qqreader/QRBridgeActivity:jdField_a_of_type_ComTencentUtilWeakReferenceHandler	Lcom/tencent/util/WeakReferenceHandler;
    //   434: bipush 100
    //   436: invokevirtual 201	com/tencent/util/WeakReferenceHandler:sendEmptyMessage	(I)Z
    //   439: pop
    //   440: aload_3
    //   441: ifnull -402 -> 39
    //   444: aload_3
    //   445: invokevirtual 131	java/net/HttpURLConnection:disconnect	()V
    //   448: return
    //   449: astore 4
    //   451: aload_2
    //   452: astore_3
    //   453: aload 4
    //   455: astore_2
    //   456: aload_3
    //   457: ifnull +7 -> 464
    //   460: aload_3
    //   461: invokevirtual 131	java/net/HttpURLConnection:disconnect	()V
    //   464: aload_2
    //   465: athrow
    //   466: astore_2
    //   467: goto -11 -> 456
    //   470: astore 4
    //   472: aload 5
    //   474: astore_3
    //   475: goto -265 -> 210
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	478	0	this	amye
    //   299	2	1	bool	boolean
    //   1	464	2	localObject1	Object
    //   466	1	2	localObject2	Object
    //   78	397	3	localObject3	Object
    //   15	183	4	localObject4	Object
    //   208	58	4	localException1	java.lang.Exception
    //   449	5	4	localObject5	Object
    //   470	1	4	localException2	java.lang.Exception
    //   3	470	5	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   79	186	208	java/lang/Exception
    //   186	192	208	java/lang/Exception
    //   197	205	208	java/lang/Exception
    //   226	261	208	java/lang/Exception
    //   261	300	208	java/lang/Exception
    //   313	440	208	java/lang/Exception
    //   40	79	449	finally
    //   212	217	449	finally
    //   79	186	466	finally
    //   186	192	466	finally
    //   197	205	466	finally
    //   226	261	466	finally
    //   261	300	466	finally
    //   313	440	466	finally
    //   40	79	470	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amye
 * JD-Core Version:    0.7.0.1
 */