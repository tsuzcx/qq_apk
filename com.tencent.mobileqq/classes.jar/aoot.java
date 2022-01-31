import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager;

public class aoot
  implements Runnable
{
  public aoot(QIMPtvTemplateManager paramQIMPtvTemplateManager, boolean paramBoolean) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: getfield 13	aoot:jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager	Ldov/com/tencent/mobileqq/shortvideo/QIMPtvTemplateManager;
    //   6: getfield 29	dov/com/tencent/mobileqq/shortvideo/QIMPtvTemplateManager:a	Ljava/util/List;
    //   9: invokeinterface 35 1 0
    //   14: ifne +11 -> 25
    //   17: aload_0
    //   18: getfield 15	aoot:jdField_a_of_type_Boolean	Z
    //   21: ifne +4 -> 25
    //   24: return
    //   25: ldc 37
    //   27: astore 5
    //   29: invokestatic 43	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   32: invokevirtual 47	com/tencent/qphone/base/util/BaseApplication:getAssets	()Landroid/content/res/AssetManager;
    //   35: ldc 49
    //   37: invokevirtual 55	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   40: astore_2
    //   41: aload_2
    //   42: astore_3
    //   43: aload_2
    //   44: invokestatic 60	com/tencent/biz/common/util/Util:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   47: astore 4
    //   49: aload 4
    //   51: astore_3
    //   52: aload_2
    //   53: ifnull +10 -> 63
    //   56: aload_2
    //   57: invokevirtual 65	java/io/InputStream:close	()V
    //   60: aload 4
    //   62: astore_3
    //   63: aload_0
    //   64: getfield 13	aoot:jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager	Ldov/com/tencent/mobileqq/shortvideo/QIMPtvTemplateManager;
    //   67: aload_3
    //   68: aconst_null
    //   69: invokestatic 68	dov/com/tencent/mobileqq/shortvideo/QIMPtvTemplateManager:a	(Ldov/com/tencent/mobileqq/shortvideo/QIMPtvTemplateManager;Ljava/lang/String;Ldov/com/qq/im/capture/data/QIMRedDotConfig;)Ljava/util/List;
    //   72: astore_3
    //   73: aload_3
    //   74: ifnull -50 -> 24
    //   77: aload_3
    //   78: invokeinterface 35 1 0
    //   83: ifne -59 -> 24
    //   86: aload_0
    //   87: getfield 13	aoot:jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager	Ldov/com/tencent/mobileqq/shortvideo/QIMPtvTemplateManager;
    //   90: getfield 72	dov/com/tencent/mobileqq/shortvideo/QIMPtvTemplateManager:b	Ljava/lang/Object;
    //   93: astore_2
    //   94: aload_2
    //   95: monitorenter
    //   96: aload_0
    //   97: getfield 13	aoot:jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager	Ldov/com/tencent/mobileqq/shortvideo/QIMPtvTemplateManager;
    //   100: getfield 29	dov/com/tencent/mobileqq/shortvideo/QIMPtvTemplateManager:a	Ljava/util/List;
    //   103: invokeinterface 35 1 0
    //   108: ifeq +17 -> 125
    //   111: aload_0
    //   112: getfield 13	aoot:jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager	Ldov/com/tencent/mobileqq/shortvideo/QIMPtvTemplateManager;
    //   115: getfield 29	dov/com/tencent/mobileqq/shortvideo/QIMPtvTemplateManager:a	Ljava/util/List;
    //   118: aload_3
    //   119: invokeinterface 76 2 0
    //   124: pop
    //   125: aload_3
    //   126: invokeinterface 80 1 0
    //   131: astore_3
    //   132: aload_3
    //   133: invokeinterface 85 1 0
    //   138: ifeq +318 -> 456
    //   141: aload_3
    //   142: invokeinterface 89 1 0
    //   147: checkcast 91	dov/com/qq/im/capture/data/TemplateGroupItem
    //   150: getfield 92	dov/com/qq/im/capture/data/TemplateGroupItem:a	Ljava/util/List;
    //   153: invokeinterface 80 1 0
    //   158: astore 4
    //   160: aload 4
    //   162: invokeinterface 85 1 0
    //   167: ifeq -35 -> 132
    //   170: aload 4
    //   172: invokeinterface 89 1 0
    //   177: checkcast 94	dov/com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo
    //   180: astore 5
    //   182: aload 5
    //   184: ifnull -24 -> 160
    //   187: aload 5
    //   189: aload_0
    //   190: getfield 13	aoot:jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager	Ldov/com/tencent/mobileqq/shortvideo/QIMPtvTemplateManager;
    //   193: aload 5
    //   195: invokevirtual 97	dov/com/tencent/mobileqq/shortvideo/QIMPtvTemplateManager:a	(Ldov/com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo;)Z
    //   198: putfield 100	dov/com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo:usable	Z
    //   201: aload 5
    //   203: getfield 100	dov/com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo:usable	Z
    //   206: ifne +51 -> 257
    //   209: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   212: ifeq +45 -> 257
    //   215: ldc 107
    //   217: iconst_2
    //   218: new 109	java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   225: ldc 112
    //   227: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: aload 5
    //   232: getfield 120	dov/com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo:id	Ljava/lang/String;
    //   235: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: ldc 122
    //   240: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: aload 5
    //   245: getfield 125	dov/com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo:md5	Ljava/lang/String;
    //   248: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokestatic 133	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   257: aload_0
    //   258: getfield 13	aoot:jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager	Ldov/com/tencent/mobileqq/shortvideo/QIMPtvTemplateManager;
    //   261: aload 5
    //   263: invokevirtual 136	dov/com/tencent/mobileqq/shortvideo/QIMPtvTemplateManager:a	(Ldov/com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo;)Ljava/util/List;
    //   266: astore 6
    //   268: aload 6
    //   270: invokeinterface 140 1 0
    //   275: ifle +171 -> 446
    //   278: aload 6
    //   280: iconst_0
    //   281: invokeinterface 144 2 0
    //   286: checkcast 146	java/lang/Integer
    //   289: checkcast 146	java/lang/Integer
    //   292: invokevirtual 149	java/lang/Integer:intValue	()I
    //   295: istore_1
    //   296: aload 5
    //   298: iload_1
    //   299: putfield 153	dov/com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo:type	I
    //   302: aload 6
    //   304: invokeinterface 140 1 0
    //   309: iconst_1
    //   310: if_icmple +141 -> 451
    //   313: aload 6
    //   315: iconst_1
    //   316: invokeinterface 144 2 0
    //   321: checkcast 146	java/lang/Integer
    //   324: checkcast 146	java/lang/Integer
    //   327: invokevirtual 149	java/lang/Integer:intValue	()I
    //   330: istore_1
    //   331: aload 5
    //   333: iload_1
    //   334: putfield 156	dov/com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo:color	I
    //   337: goto -177 -> 160
    //   340: astore_3
    //   341: aload_2
    //   342: monitorexit
    //   343: aload_3
    //   344: athrow
    //   345: astore_2
    //   346: aload 4
    //   348: astore_3
    //   349: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   352: ifeq -289 -> 63
    //   355: aload_2
    //   356: invokevirtual 159	java/lang/Exception:printStackTrace	()V
    //   359: aload 4
    //   361: astore_3
    //   362: goto -299 -> 63
    //   365: astore 4
    //   367: aconst_null
    //   368: astore_2
    //   369: aload_2
    //   370: astore_3
    //   371: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   374: ifeq +10 -> 384
    //   377: aload_2
    //   378: astore_3
    //   379: aload 4
    //   381: invokevirtual 160	java/io/IOException:printStackTrace	()V
    //   384: aload 5
    //   386: astore_3
    //   387: aload_2
    //   388: ifnull -325 -> 63
    //   391: aload_2
    //   392: invokevirtual 65	java/io/InputStream:close	()V
    //   395: aload 5
    //   397: astore_3
    //   398: goto -335 -> 63
    //   401: astore_2
    //   402: aload 5
    //   404: astore_3
    //   405: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   408: ifeq -345 -> 63
    //   411: aload_2
    //   412: invokevirtual 159	java/lang/Exception:printStackTrace	()V
    //   415: aload 5
    //   417: astore_3
    //   418: goto -355 -> 63
    //   421: astore_2
    //   422: aload_3
    //   423: ifnull +7 -> 430
    //   426: aload_3
    //   427: invokevirtual 65	java/io/InputStream:close	()V
    //   430: aload_2
    //   431: athrow
    //   432: astore_3
    //   433: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   436: ifeq -6 -> 430
    //   439: aload_3
    //   440: invokevirtual 159	java/lang/Exception:printStackTrace	()V
    //   443: goto -13 -> 430
    //   446: iconst_0
    //   447: istore_1
    //   448: goto -152 -> 296
    //   451: iconst_0
    //   452: istore_1
    //   453: goto -122 -> 331
    //   456: aload_0
    //   457: getfield 13	aoot:jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager	Ldov/com/tencent/mobileqq/shortvideo/QIMPtvTemplateManager;
    //   460: invokevirtual 163	dov/com/tencent/mobileqq/shortvideo/QIMPtvTemplateManager:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   463: ifnull +18 -> 481
    //   466: aload_0
    //   467: getfield 13	aoot:jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager	Ldov/com/tencent/mobileqq/shortvideo/QIMPtvTemplateManager;
    //   470: invokevirtual 163	dov/com/tencent/mobileqq/shortvideo/QIMPtvTemplateManager:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   473: ldc 165
    //   475: iconst_3
    //   476: iconst_1
    //   477: aconst_null
    //   478: invokevirtual 171	com/tencent/mobileqq/app/QQAppInterface:notifyObservers	(Ljava/lang/Class;IZLandroid/os/Bundle;)V
    //   481: aload_2
    //   482: monitorexit
    //   483: return
    //   484: astore_2
    //   485: goto -63 -> 422
    //   488: astore 4
    //   490: goto -121 -> 369
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	493	0	this	aoot
    //   295	158	1	i	int
    //   345	11	2	localException1	java.lang.Exception
    //   368	24	2	localObject2	Object
    //   401	11	2	localException2	java.lang.Exception
    //   421	61	2	localObject3	Object
    //   484	1	2	localObject4	Object
    //   1	141	3	localObject5	Object
    //   340	4	3	localObject6	Object
    //   348	79	3	localObject7	Object
    //   432	8	3	localException3	java.lang.Exception
    //   47	313	4	localObject8	Object
    //   365	15	4	localIOException1	java.io.IOException
    //   488	1	4	localIOException2	java.io.IOException
    //   27	389	5	localObject9	Object
    //   266	48	6	localList	java.util.List
    // Exception table:
    //   from	to	target	type
    //   96	125	340	finally
    //   125	132	340	finally
    //   132	160	340	finally
    //   160	182	340	finally
    //   187	257	340	finally
    //   257	296	340	finally
    //   296	331	340	finally
    //   331	337	340	finally
    //   341	343	340	finally
    //   456	481	340	finally
    //   481	483	340	finally
    //   56	60	345	java/lang/Exception
    //   29	41	365	java/io/IOException
    //   391	395	401	java/lang/Exception
    //   29	41	421	finally
    //   426	430	432	java/lang/Exception
    //   43	49	484	finally
    //   371	377	484	finally
    //   379	384	484	finally
    //   43	49	488	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoot
 * JD-Core Version:    0.7.0.1
 */