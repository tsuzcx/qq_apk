package com.tencent.mobileqq.app;

import com.tencent.mobileqq.richstatus.RichStatus;

final class SignatureManager$2
  implements Runnable
{
  SignatureManager$2(RichStatus paramRichStatus, String paramString) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 28	java/lang/System:currentTimeMillis	()J
    //   3: lstore_1
    //   4: invokestatic 34	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   7: invokevirtual 38	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   10: checkcast 40	com/tencent/mobileqq/app/QQAppInterface
    //   13: astore 7
    //   15: aload_0
    //   16: getfield 13	com/tencent/mobileqq/app/SignatureManager$2:jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus	Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   19: astore 6
    //   21: aconst_null
    //   22: astore 5
    //   24: aload 7
    //   26: getstatic 46	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   29: invokevirtual 50	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   32: checkcast 52	com/tencent/mobileqq/app/FriendsManager
    //   35: astore 8
    //   37: aload 8
    //   39: aload_0
    //   40: getfield 15	com/tencent/mobileqq/app/SignatureManager$2:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   43: invokevirtual 56	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Z
    //   46: istore_3
    //   47: iload_3
    //   48: ifne +61 -> 109
    //   51: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   54: ifeq +50 -> 104
    //   57: new 64	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   64: astore 4
    //   66: aload 4
    //   68: ldc 67
    //   70: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload 4
    //   76: invokestatic 28	java/lang/System:currentTimeMillis	()J
    //   79: lload_1
    //   80: lsub
    //   81: invokevirtual 74	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload 4
    //   87: ldc 76
    //   89: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: ldc 78
    //   95: iconst_2
    //   96: aload 4
    //   98: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   104: iconst_1
    //   105: invokestatic 91	com/tencent/mobileqq/app/SignatureManager:a	(Z)V
    //   108: return
    //   109: aload 6
    //   111: astore 4
    //   113: aload 6
    //   115: ifnonnull +152 -> 267
    //   118: aload 8
    //   120: aload_0
    //   121: getfield 15	com/tencent/mobileqq/app/SignatureManager$2:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   124: invokevirtual 94	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/ExtensionInfo;
    //   127: astore 5
    //   129: aload 5
    //   131: ifnonnull +61 -> 192
    //   134: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   137: ifeq +50 -> 187
    //   140: new 64	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   147: astore 4
    //   149: aload 4
    //   151: ldc 67
    //   153: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload 4
    //   159: invokestatic 28	java/lang/System:currentTimeMillis	()J
    //   162: lload_1
    //   163: lsub
    //   164: invokevirtual 74	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload 4
    //   170: ldc 76
    //   172: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: ldc 78
    //   178: iconst_2
    //   179: aload 4
    //   181: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   187: iconst_1
    //   188: invokestatic 91	com/tencent/mobileqq/app/SignatureManager:a	(Z)V
    //   191: return
    //   192: aload 5
    //   194: getfield 100	com/tencent/mobileqq/data/ExtensionInfo:isAdded2C2C	Z
    //   197: istore_3
    //   198: iload_3
    //   199: ifeq +61 -> 260
    //   202: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   205: ifeq +50 -> 255
    //   208: new 64	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   215: astore 4
    //   217: aload 4
    //   219: ldc 67
    //   221: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: aload 4
    //   227: invokestatic 28	java/lang/System:currentTimeMillis	()J
    //   230: lload_1
    //   231: lsub
    //   232: invokevirtual 74	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: aload 4
    //   238: ldc 76
    //   240: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: ldc 78
    //   246: iconst_2
    //   247: aload 4
    //   249: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   255: iconst_1
    //   256: invokestatic 91	com/tencent/mobileqq/app/SignatureManager:a	(Z)V
    //   259: return
    //   260: aload 5
    //   262: invokestatic 105	com/tencent/mobileqq/richstatus/ExtensionRichStatus:a	(Lcom/tencent/mobileqq/data/ExtensionInfo;)Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   265: astore 4
    //   267: aload 4
    //   269: invokestatic 108	com/tencent/mobileqq/app/SignatureManager:a	(Lcom/tencent/mobileqq/richstatus/RichStatus;)Z
    //   272: istore_3
    //   273: iload_3
    //   274: ifeq +61 -> 335
    //   277: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   280: ifeq +50 -> 330
    //   283: new 64	java/lang/StringBuilder
    //   286: dup
    //   287: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   290: astore 4
    //   292: aload 4
    //   294: ldc 67
    //   296: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: pop
    //   300: aload 4
    //   302: invokestatic 28	java/lang/System:currentTimeMillis	()J
    //   305: lload_1
    //   306: lsub
    //   307: invokevirtual 74	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: aload 4
    //   313: ldc 76
    //   315: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: ldc 78
    //   321: iconst_2
    //   322: aload 4
    //   324: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   327: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   330: iconst_1
    //   331: invokestatic 91	com/tencent/mobileqq/app/SignatureManager:a	(Z)V
    //   334: return
    //   335: aload 7
    //   337: aload 4
    //   339: aload_0
    //   340: getfield 15	com/tencent/mobileqq/app/SignatureManager$2:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   343: invokestatic 111	com/tencent/mobileqq/app/SignatureManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/richstatus/RichStatus;Ljava/lang/String;)Z
    //   346: istore_3
    //   347: iload_3
    //   348: ifeq +61 -> 409
    //   351: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   354: ifeq +50 -> 404
    //   357: new 64	java/lang/StringBuilder
    //   360: dup
    //   361: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   364: astore 4
    //   366: aload 4
    //   368: ldc 67
    //   370: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: pop
    //   374: aload 4
    //   376: invokestatic 28	java/lang/System:currentTimeMillis	()J
    //   379: lload_1
    //   380: lsub
    //   381: invokevirtual 74	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   384: pop
    //   385: aload 4
    //   387: ldc 76
    //   389: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: pop
    //   393: ldc 78
    //   395: iconst_2
    //   396: aload 4
    //   398: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   401: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   404: iconst_1
    //   405: invokestatic 91	com/tencent/mobileqq/app/SignatureManager:a	(Z)V
    //   408: return
    //   409: aload 7
    //   411: aload 4
    //   413: invokestatic 114	com/tencent/mobileqq/app/SignatureManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/richstatus/RichStatus;)V
    //   416: aload 7
    //   418: aload_0
    //   419: getfield 15	com/tencent/mobileqq/app/SignatureManager$2:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   422: invokestatic 117	com/tencent/mobileqq/app/SignatureManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Z
    //   425: istore_3
    //   426: iload_3
    //   427: ifeq +61 -> 488
    //   430: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   433: ifeq +50 -> 483
    //   436: new 64	java/lang/StringBuilder
    //   439: dup
    //   440: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   443: astore 4
    //   445: aload 4
    //   447: ldc 67
    //   449: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: pop
    //   453: aload 4
    //   455: invokestatic 28	java/lang/System:currentTimeMillis	()J
    //   458: lload_1
    //   459: lsub
    //   460: invokevirtual 74	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   463: pop
    //   464: aload 4
    //   466: ldc 76
    //   468: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: pop
    //   472: ldc 78
    //   474: iconst_2
    //   475: aload 4
    //   477: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   480: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   483: iconst_1
    //   484: invokestatic 91	com/tencent/mobileqq/app/SignatureManager:a	(Z)V
    //   487: return
    //   488: aload 4
    //   490: invokestatic 120	com/tencent/mobileqq/app/SignatureManager:a	(Lcom/tencent/mobileqq/richstatus/RichStatus;)Ljava/lang/String;
    //   493: astore 6
    //   495: aload 6
    //   497: ifnonnull +61 -> 558
    //   500: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   503: ifeq +50 -> 553
    //   506: new 64	java/lang/StringBuilder
    //   509: dup
    //   510: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   513: astore 4
    //   515: aload 4
    //   517: ldc 67
    //   519: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: pop
    //   523: aload 4
    //   525: invokestatic 28	java/lang/System:currentTimeMillis	()J
    //   528: lload_1
    //   529: lsub
    //   530: invokevirtual 74	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   533: pop
    //   534: aload 4
    //   536: ldc 76
    //   538: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: pop
    //   542: ldc 78
    //   544: iconst_2
    //   545: aload 4
    //   547: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   550: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   553: iconst_1
    //   554: invokestatic 91	com/tencent/mobileqq/app/SignatureManager:a	(Z)V
    //   557: return
    //   558: aload 7
    //   560: aload 4
    //   562: aload 5
    //   564: aload 6
    //   566: aload_0
    //   567: getfield 15	com/tencent/mobileqq/app/SignatureManager$2:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   570: invokestatic 123	com/tencent/mobileqq/app/SignatureManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/richstatus/RichStatus;Lcom/tencent/mobileqq/data/ExtensionInfo;Ljava/lang/String;Ljava/lang/String;)V
    //   573: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   576: ifeq +111 -> 687
    //   579: new 64	java/lang/StringBuilder
    //   582: dup
    //   583: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   586: astore 4
    //   588: goto +61 -> 649
    //   591: astore 4
    //   593: goto +99 -> 692
    //   596: astore 4
    //   598: new 64	java/lang/StringBuilder
    //   601: dup
    //   602: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   605: astore 5
    //   607: aload 5
    //   609: ldc 125
    //   611: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: pop
    //   615: aload 5
    //   617: aload 4
    //   619: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   622: pop
    //   623: ldc 78
    //   625: iconst_2
    //   626: aload 5
    //   628: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   631: invokestatic 131	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   634: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   637: ifeq +50 -> 687
    //   640: new 64	java/lang/StringBuilder
    //   643: dup
    //   644: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   647: astore 4
    //   649: aload 4
    //   651: ldc 67
    //   653: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   656: pop
    //   657: aload 4
    //   659: invokestatic 28	java/lang/System:currentTimeMillis	()J
    //   662: lload_1
    //   663: lsub
    //   664: invokevirtual 74	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   667: pop
    //   668: aload 4
    //   670: ldc 76
    //   672: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   675: pop
    //   676: ldc 78
    //   678: iconst_2
    //   679: aload 4
    //   681: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   684: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   687: iconst_1
    //   688: invokestatic 91	com/tencent/mobileqq/app/SignatureManager:a	(Z)V
    //   691: return
    //   692: invokestatic 62	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   695: ifeq +50 -> 745
    //   698: new 64	java/lang/StringBuilder
    //   701: dup
    //   702: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   705: astore 5
    //   707: aload 5
    //   709: ldc 67
    //   711: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   714: pop
    //   715: aload 5
    //   717: invokestatic 28	java/lang/System:currentTimeMillis	()J
    //   720: lload_1
    //   721: lsub
    //   722: invokevirtual 74	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   725: pop
    //   726: aload 5
    //   728: ldc 76
    //   730: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   733: pop
    //   734: ldc 78
    //   736: iconst_2
    //   737: aload 5
    //   739: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   742: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   745: iconst_1
    //   746: invokestatic 91	com/tencent/mobileqq/app/SignatureManager:a	(Z)V
    //   749: aload 4
    //   751: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	752	0	this	2
    //   3	718	1	l	long
    //   46	381	3	bool	boolean
    //   64	523	4	localObject1	Object
    //   591	1	4	localObject2	Object
    //   596	22	4	localException	java.lang.Exception
    //   647	103	4	localStringBuilder	java.lang.StringBuilder
    //   22	716	5	localObject3	Object
    //   19	546	6	localObject4	Object
    //   13	546	7	localQQAppInterface	QQAppInterface
    //   35	84	8	localFriendsManager	FriendsManager
    // Exception table:
    //   from	to	target	type
    //   4	21	591	finally
    //   24	47	591	finally
    //   118	129	591	finally
    //   192	198	591	finally
    //   260	267	591	finally
    //   267	273	591	finally
    //   335	347	591	finally
    //   409	426	591	finally
    //   488	495	591	finally
    //   558	573	591	finally
    //   598	634	591	finally
    //   4	21	596	java/lang/Exception
    //   24	47	596	java/lang/Exception
    //   118	129	596	java/lang/Exception
    //   192	198	596	java/lang/Exception
    //   260	267	596	java/lang/Exception
    //   267	273	596	java/lang/Exception
    //   335	347	596	java/lang/Exception
    //   409	426	596	java/lang/Exception
    //   488	495	596	java/lang/Exception
    //   558	573	596	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.SignatureManager.2
 * JD-Core Version:    0.7.0.1
 */