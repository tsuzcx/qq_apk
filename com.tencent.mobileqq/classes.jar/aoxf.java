import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager;

public class aoxf
  implements Runnable
{
  public aoxf(QIMPtvTemplateManager paramQIMPtvTemplateManager, boolean paramBoolean) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: getfield 13	aoxf:jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager	Ldov/com/tencent/mobileqq/shortvideo/QIMPtvTemplateManager;
    //   6: getfield 29	dov/com/tencent/mobileqq/shortvideo/QIMPtvTemplateManager:a	Ljava/util/List;
    //   9: invokeinterface 35 1 0
    //   14: ifne +11 -> 25
    //   17: aload_0
    //   18: getfield 15	aoxf:jdField_a_of_type_Boolean	Z
    //   21: ifne +4 -> 25
    //   24: return
    //   25: ldc 37
    //   27: astore 4
    //   29: invokestatic 43	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   32: invokevirtual 47	com/tencent/qphone/base/util/BaseApplication:getAssets	()Landroid/content/res/AssetManager;
    //   35: ldc 49
    //   37: invokevirtual 55	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   40: astore_1
    //   41: aload_1
    //   42: astore_2
    //   43: aload_1
    //   44: invokestatic 60	com/tencent/biz/common/util/Util:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   47: astore_3
    //   48: aload_3
    //   49: astore_2
    //   50: aload_1
    //   51: ifnull +9 -> 60
    //   54: aload_1
    //   55: invokevirtual 65	java/io/InputStream:close	()V
    //   58: aload_3
    //   59: astore_2
    //   60: aload_0
    //   61: getfield 13	aoxf:jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager	Ldov/com/tencent/mobileqq/shortvideo/QIMPtvTemplateManager;
    //   64: aload_2
    //   65: aconst_null
    //   66: invokestatic 68	dov/com/tencent/mobileqq/shortvideo/QIMPtvTemplateManager:a	(Ldov/com/tencent/mobileqq/shortvideo/QIMPtvTemplateManager;Ljava/lang/String;Ldov/com/qq/im/capture/data/QIMRedDotConfig;)Ljava/util/List;
    //   69: astore_2
    //   70: aload_2
    //   71: ifnull -47 -> 24
    //   74: aload_2
    //   75: invokeinterface 35 1 0
    //   80: ifne -56 -> 24
    //   83: aload_0
    //   84: getfield 13	aoxf:jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager	Ldov/com/tencent/mobileqq/shortvideo/QIMPtvTemplateManager;
    //   87: getfield 72	dov/com/tencent/mobileqq/shortvideo/QIMPtvTemplateManager:b	Ljava/lang/Object;
    //   90: astore_1
    //   91: aload_1
    //   92: monitorenter
    //   93: aload_0
    //   94: getfield 13	aoxf:jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager	Ldov/com/tencent/mobileqq/shortvideo/QIMPtvTemplateManager;
    //   97: getfield 29	dov/com/tencent/mobileqq/shortvideo/QIMPtvTemplateManager:a	Ljava/util/List;
    //   100: invokeinterface 35 1 0
    //   105: ifeq +17 -> 122
    //   108: aload_0
    //   109: getfield 13	aoxf:jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager	Ldov/com/tencent/mobileqq/shortvideo/QIMPtvTemplateManager;
    //   112: getfield 29	dov/com/tencent/mobileqq/shortvideo/QIMPtvTemplateManager:a	Ljava/util/List;
    //   115: aload_2
    //   116: invokeinterface 76 2 0
    //   121: pop
    //   122: aload_2
    //   123: invokeinterface 80 1 0
    //   128: astore_2
    //   129: aload_2
    //   130: invokeinterface 85 1 0
    //   135: ifeq +221 -> 356
    //   138: aload_2
    //   139: invokeinterface 89 1 0
    //   144: checkcast 91	dov/com/qq/im/capture/data/TemplateGroupItem
    //   147: getfield 92	dov/com/qq/im/capture/data/TemplateGroupItem:a	Ljava/util/List;
    //   150: invokeinterface 80 1 0
    //   155: astore_3
    //   156: aload_3
    //   157: invokeinterface 85 1 0
    //   162: ifeq -33 -> 129
    //   165: aload_3
    //   166: invokeinterface 89 1 0
    //   171: checkcast 94	dov/com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo
    //   174: astore 4
    //   176: aload 4
    //   178: ifnull -22 -> 156
    //   181: aload 4
    //   183: aload_0
    //   184: getfield 13	aoxf:jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager	Ldov/com/tencent/mobileqq/shortvideo/QIMPtvTemplateManager;
    //   187: aload 4
    //   189: invokevirtual 97	dov/com/tencent/mobileqq/shortvideo/QIMPtvTemplateManager:a	(Ldov/com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo;)Z
    //   192: putfield 100	dov/com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo:usable	Z
    //   195: aload 4
    //   197: getfield 100	dov/com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo:usable	Z
    //   200: ifne -44 -> 156
    //   203: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   206: ifeq -50 -> 156
    //   209: ldc 107
    //   211: iconst_2
    //   212: new 109	java/lang/StringBuilder
    //   215: dup
    //   216: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   219: ldc 112
    //   221: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: aload 4
    //   226: getfield 120	dov/com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo:id	Ljava/lang/String;
    //   229: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: ldc 122
    //   234: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: aload 4
    //   239: getfield 125	dov/com/tencent/mobileqq/shortvideo/PtvTemplateManager$PtvTemplateInfo:md5	Ljava/lang/String;
    //   242: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokestatic 133	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   251: goto -95 -> 156
    //   254: astore_2
    //   255: aload_1
    //   256: monitorexit
    //   257: aload_2
    //   258: athrow
    //   259: astore_1
    //   260: aload_3
    //   261: astore_2
    //   262: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   265: ifeq -205 -> 60
    //   268: aload_1
    //   269: invokevirtual 136	java/lang/Exception:printStackTrace	()V
    //   272: aload_3
    //   273: astore_2
    //   274: goto -214 -> 60
    //   277: astore_3
    //   278: aconst_null
    //   279: astore_1
    //   280: aload_1
    //   281: astore_2
    //   282: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   285: ifeq +9 -> 294
    //   288: aload_1
    //   289: astore_2
    //   290: aload_3
    //   291: invokevirtual 137	java/io/IOException:printStackTrace	()V
    //   294: aload 4
    //   296: astore_2
    //   297: aload_1
    //   298: ifnull -238 -> 60
    //   301: aload_1
    //   302: invokevirtual 65	java/io/InputStream:close	()V
    //   305: aload 4
    //   307: astore_2
    //   308: goto -248 -> 60
    //   311: astore_1
    //   312: aload 4
    //   314: astore_2
    //   315: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   318: ifeq -258 -> 60
    //   321: aload_1
    //   322: invokevirtual 136	java/lang/Exception:printStackTrace	()V
    //   325: aload 4
    //   327: astore_2
    //   328: goto -268 -> 60
    //   331: astore_1
    //   332: aload_2
    //   333: ifnull +7 -> 340
    //   336: aload_2
    //   337: invokevirtual 65	java/io/InputStream:close	()V
    //   340: aload_1
    //   341: athrow
    //   342: astore_2
    //   343: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   346: ifeq -6 -> 340
    //   349: aload_2
    //   350: invokevirtual 136	java/lang/Exception:printStackTrace	()V
    //   353: goto -13 -> 340
    //   356: aload_0
    //   357: getfield 13	aoxf:jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager	Ldov/com/tencent/mobileqq/shortvideo/QIMPtvTemplateManager;
    //   360: invokevirtual 140	dov/com/tencent/mobileqq/shortvideo/QIMPtvTemplateManager:a	()Lcom/tencent/common/app/AppInterface;
    //   363: ifnull +18 -> 381
    //   366: aload_0
    //   367: getfield 13	aoxf:jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager	Ldov/com/tencent/mobileqq/shortvideo/QIMPtvTemplateManager;
    //   370: invokevirtual 140	dov/com/tencent/mobileqq/shortvideo/QIMPtvTemplateManager:a	()Lcom/tencent/common/app/AppInterface;
    //   373: ldc 142
    //   375: iconst_3
    //   376: iconst_1
    //   377: aconst_null
    //   378: invokevirtual 148	com/tencent/common/app/AppInterface:notifyObservers	(Ljava/lang/Class;IZLandroid/os/Bundle;)V
    //   381: aload_1
    //   382: monitorexit
    //   383: return
    //   384: astore_1
    //   385: goto -53 -> 332
    //   388: astore_3
    //   389: goto -109 -> 280
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	392	0	this	aoxf
    //   259	10	1	localException1	java.lang.Exception
    //   279	23	1	localObject2	Object
    //   311	11	1	localException2	java.lang.Exception
    //   331	51	1	localObject3	Object
    //   384	1	1	localObject4	Object
    //   1	138	2	localObject5	Object
    //   254	4	2	localObject6	Object
    //   261	76	2	localObject7	Object
    //   342	8	2	localException3	java.lang.Exception
    //   47	226	3	localObject8	Object
    //   277	14	3	localIOException1	java.io.IOException
    //   388	1	3	localIOException2	java.io.IOException
    //   27	299	4	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   93	122	254	finally
    //   122	129	254	finally
    //   129	156	254	finally
    //   156	176	254	finally
    //   181	251	254	finally
    //   255	257	254	finally
    //   356	381	254	finally
    //   381	383	254	finally
    //   54	58	259	java/lang/Exception
    //   29	41	277	java/io/IOException
    //   301	305	311	java/lang/Exception
    //   29	41	331	finally
    //   336	340	342	java/lang/Exception
    //   43	48	384	finally
    //   282	288	384	finally
    //   290	294	384	finally
    //   43	48	388	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoxf
 * JD-Core Version:    0.7.0.1
 */