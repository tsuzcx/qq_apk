package com.tencent.av.ui;

class ConferenceFlyTicketActivity$2
  implements Runnable
{
  ConferenceFlyTicketActivity$2(ConferenceFlyTicketActivity paramConferenceFlyTicketActivity, String paramString) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 14	com/tencent/av/ui/ConferenceFlyTicketActivity$2:this$0	Lcom/tencent/av/ui/ConferenceFlyTicketActivity;
    //   4: getfield 26	com/tencent/av/ui/ConferenceFlyTicketActivity:a	Ljava/lang/String;
    //   7: astore_1
    //   8: new 28	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   15: astore_2
    //   16: aload_2
    //   17: ldc 31
    //   19: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload_2
    //   24: aload_0
    //   25: getfield 16	com/tencent/av/ui/ConferenceFlyTicketActivity$2:a	Ljava/lang/String;
    //   28: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload_2
    //   33: ldc 37
    //   35: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload_1
    //   40: iconst_1
    //   41: aload_2
    //   42: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 47	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: ldc 49
    //   50: invokestatic 55	com/tencent/av/utils/AudioHelper:b	(Ljava/lang/String;)V
    //   53: new 57	org/apache/http/impl/client/DefaultHttpClient
    //   56: dup
    //   57: invokespecial 58	org/apache/http/impl/client/DefaultHttpClient:<init>	()V
    //   60: astore 5
    //   62: new 60	org/apache/http/protocol/BasicHttpContext
    //   65: dup
    //   66: invokespecial 61	org/apache/http/protocol/BasicHttpContext:<init>	()V
    //   69: astore_1
    //   70: new 63	org/apache/http/client/methods/HttpGet
    //   73: dup
    //   74: aload_0
    //   75: getfield 16	com/tencent/av/ui/ConferenceFlyTicketActivity$2:a	Ljava/lang/String;
    //   78: invokespecial 65	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   81: astore 6
    //   83: aconst_null
    //   84: astore 4
    //   86: aconst_null
    //   87: astore_3
    //   88: aload 4
    //   90: astore_2
    //   91: aload 5
    //   93: aload 6
    //   95: aload_1
    //   96: invokeinterface 71 3 0
    //   101: pop
    //   102: aload 4
    //   104: astore_2
    //   105: aload_1
    //   106: ldc 73
    //   108: invokeinterface 79 2 0
    //   113: astore 6
    //   115: aload_3
    //   116: astore_1
    //   117: aload 6
    //   119: ifnull +49 -> 168
    //   122: aload 4
    //   124: astore_2
    //   125: aload 6
    //   127: checkcast 81	org/apache/http/client/methods/HttpUriRequest
    //   130: astore 6
    //   132: aload_3
    //   133: astore_1
    //   134: aload 6
    //   136: ifnull +32 -> 168
    //   139: aload_3
    //   140: astore_1
    //   141: aload 4
    //   143: astore_2
    //   144: aload 6
    //   146: invokeinterface 85 1 0
    //   151: ifnull +17 -> 168
    //   154: aload 4
    //   156: astore_2
    //   157: aload 6
    //   159: invokeinterface 85 1 0
    //   164: invokevirtual 88	java/net/URI:toString	()Ljava/lang/String;
    //   167: astore_1
    //   168: aload_1
    //   169: astore_2
    //   170: aload_0
    //   171: getfield 14	com/tencent/av/ui/ConferenceFlyTicketActivity$2:this$0	Lcom/tencent/av/ui/ConferenceFlyTicketActivity;
    //   174: getfield 26	com/tencent/av/ui/ConferenceFlyTicketActivity:a	Ljava/lang/String;
    //   177: astore_3
    //   178: aload_1
    //   179: astore_2
    //   180: new 28	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   187: astore 4
    //   189: aload_1
    //   190: astore_2
    //   191: aload 4
    //   193: ldc 90
    //   195: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: aload_1
    //   200: astore_2
    //   201: aload 4
    //   203: aload_1
    //   204: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload_1
    //   209: astore_2
    //   210: aload 4
    //   212: ldc 37
    //   214: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: aload_1
    //   219: astore_2
    //   220: aload_3
    //   221: iconst_1
    //   222: aload 4
    //   224: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: invokestatic 47	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   230: goto +60 -> 290
    //   233: astore_1
    //   234: goto +256 -> 490
    //   237: astore_3
    //   238: aload_2
    //   239: astore_1
    //   240: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   243: ifeq +47 -> 290
    //   246: aload_0
    //   247: getfield 14	com/tencent/av/ui/ConferenceFlyTicketActivity$2:this$0	Lcom/tencent/av/ui/ConferenceFlyTicketActivity;
    //   250: getfield 26	com/tencent/av/ui/ConferenceFlyTicketActivity:a	Ljava/lang/String;
    //   253: astore_1
    //   254: new 28	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   261: astore 4
    //   263: aload 4
    //   265: ldc 96
    //   267: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload 4
    //   273: aload_3
    //   274: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   277: pop
    //   278: aload_1
    //   279: iconst_2
    //   280: aload 4
    //   282: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   288: aload_2
    //   289: astore_1
    //   290: aload 5
    //   292: invokeinterface 106 1 0
    //   297: invokeinterface 111 1 0
    //   302: ldc 113
    //   304: invokestatic 55	com/tencent/av/utils/AudioHelper:b	(Ljava/lang/String;)V
    //   307: ldc 114
    //   309: invokestatic 119	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   312: invokestatic 55	com/tencent/av/utils/AudioHelper:b	(Ljava/lang/String;)V
    //   315: aload_1
    //   316: ifnull +77 -> 393
    //   319: aload_1
    //   320: ldc 121
    //   322: invokevirtual 127	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   325: ifeq +68 -> 393
    //   328: aload_1
    //   329: bipush 17
    //   331: invokevirtual 130	java/lang/String:substring	(I)Ljava/lang/String;
    //   334: astore_1
    //   335: aload_0
    //   336: getfield 14	com/tencent/av/ui/ConferenceFlyTicketActivity$2:this$0	Lcom/tencent/av/ui/ConferenceFlyTicketActivity;
    //   339: getfield 26	com/tencent/av/ui/ConferenceFlyTicketActivity:a	Ljava/lang/String;
    //   342: astore_2
    //   343: new 28	java/lang/StringBuilder
    //   346: dup
    //   347: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   350: astore_3
    //   351: aload_3
    //   352: ldc 132
    //   354: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: pop
    //   358: aload_3
    //   359: aload_1
    //   360: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: pop
    //   364: aload_3
    //   365: ldc 37
    //   367: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: pop
    //   371: aload_2
    //   372: iconst_1
    //   373: aload_3
    //   374: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: invokestatic 47	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   380: aload_0
    //   381: getfield 14	com/tencent/av/ui/ConferenceFlyTicketActivity$2:this$0	Lcom/tencent/av/ui/ConferenceFlyTicketActivity;
    //   384: getfield 136	com/tencent/av/ui/ConferenceFlyTicketActivity:n	Lcom/tencent/mobileqq/app/DiscussionHandler;
    //   387: aload_1
    //   388: iconst_0
    //   389: invokevirtual 141	com/tencent/mobileqq/app/DiscussionHandler:a	(Ljava/lang/String;I)V
    //   392: return
    //   393: aload_1
    //   394: ifnull +77 -> 471
    //   397: aload_1
    //   398: ldc 143
    //   400: invokevirtual 127	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   403: ifeq +68 -> 471
    //   406: aload_1
    //   407: bipush 34
    //   409: invokevirtual 130	java/lang/String:substring	(I)Ljava/lang/String;
    //   412: astore_1
    //   413: aload_0
    //   414: getfield 14	com/tencent/av/ui/ConferenceFlyTicketActivity$2:this$0	Lcom/tencent/av/ui/ConferenceFlyTicketActivity;
    //   417: getfield 26	com/tencent/av/ui/ConferenceFlyTicketActivity:a	Ljava/lang/String;
    //   420: astore_2
    //   421: new 28	java/lang/StringBuilder
    //   424: dup
    //   425: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   428: astore_3
    //   429: aload_3
    //   430: ldc 132
    //   432: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: pop
    //   436: aload_3
    //   437: aload_1
    //   438: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: pop
    //   442: aload_3
    //   443: ldc 37
    //   445: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: pop
    //   449: aload_2
    //   450: iconst_1
    //   451: aload_3
    //   452: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   455: invokestatic 47	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   458: aload_0
    //   459: getfield 14	com/tencent/av/ui/ConferenceFlyTicketActivity$2:this$0	Lcom/tencent/av/ui/ConferenceFlyTicketActivity;
    //   462: getfield 136	com/tencent/av/ui/ConferenceFlyTicketActivity:n	Lcom/tencent/mobileqq/app/DiscussionHandler;
    //   465: aload_1
    //   466: iconst_0
    //   467: invokevirtual 141	com/tencent/mobileqq/app/DiscussionHandler:a	(Ljava/lang/String;I)V
    //   470: return
    //   471: aload_0
    //   472: getfield 14	com/tencent/av/ui/ConferenceFlyTicketActivity$2:this$0	Lcom/tencent/av/ui/ConferenceFlyTicketActivity;
    //   475: iconst_0
    //   476: sipush -161
    //   479: invokevirtual 146	com/tencent/av/ui/ConferenceFlyTicketActivity:a	(II)V
    //   482: aload_0
    //   483: getfield 14	com/tencent/av/ui/ConferenceFlyTicketActivity$2:this$0	Lcom/tencent/av/ui/ConferenceFlyTicketActivity;
    //   486: invokevirtual 149	com/tencent/av/ui/ConferenceFlyTicketActivity:finish	()V
    //   489: return
    //   490: aload 5
    //   492: invokeinterface 106 1 0
    //   497: invokeinterface 111 1 0
    //   502: aload_1
    //   503: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	504	0	this	2
    //   7	212	1	localObject1	Object
    //   233	1	1	localObject2	Object
    //   239	264	1	localObject3	Object
    //   15	435	2	localObject4	Object
    //   87	134	3	str	String
    //   237	37	3	localException	java.lang.Exception
    //   350	102	3	localStringBuilder1	java.lang.StringBuilder
    //   84	197	4	localStringBuilder2	java.lang.StringBuilder
    //   60	431	5	localDefaultHttpClient	org.apache.http.impl.client.DefaultHttpClient
    //   81	77	6	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   91	102	233	finally
    //   105	115	233	finally
    //   125	132	233	finally
    //   144	154	233	finally
    //   157	168	233	finally
    //   170	178	233	finally
    //   180	189	233	finally
    //   191	199	233	finally
    //   201	208	233	finally
    //   210	218	233	finally
    //   220	230	233	finally
    //   240	288	233	finally
    //   91	102	237	java/lang/Exception
    //   105	115	237	java/lang/Exception
    //   125	132	237	java/lang/Exception
    //   144	154	237	java/lang/Exception
    //   157	168	237	java/lang/Exception
    //   170	178	237	java/lang/Exception
    //   180	189	237	java/lang/Exception
    //   191	199	237	java/lang/Exception
    //   201	208	237	java/lang/Exception
    //   210	218	237	java/lang/Exception
    //   220	230	237	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.ConferenceFlyTicketActivity.2
 * JD-Core Version:    0.7.0.1
 */