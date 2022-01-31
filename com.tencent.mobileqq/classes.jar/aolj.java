import dov.com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager;

public class aolj
  implements Runnable
{
  public aolj(CapturePtvTemplateManager paramCapturePtvTemplateManager, boolean paramBoolean) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: getfield 13	aolj:jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager	Ldov/com/tencent/mobileqq/richmedia/capture/data/CapturePtvTemplateManager;
    //   6: getfield 29	dov/com/tencent/mobileqq/richmedia/capture/data/CapturePtvTemplateManager:a	Ljava/util/List;
    //   9: invokeinterface 35 1 0
    //   14: ifne +11 -> 25
    //   17: aload_0
    //   18: getfield 15	aolj:jdField_a_of_type_Boolean	Z
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
    //   61: getfield 13	aolj:jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager	Ldov/com/tencent/mobileqq/richmedia/capture/data/CapturePtvTemplateManager;
    //   64: aload_2
    //   65: aconst_null
    //   66: invokestatic 68	dov/com/tencent/mobileqq/richmedia/capture/data/CapturePtvTemplateManager:a	(Ldov/com/tencent/mobileqq/richmedia/capture/data/CapturePtvTemplateManager;Ljava/lang/String;Ldov/com/tencent/mobileqq/richmedia/capture/data/CaptureRedDotConfig;)Ljava/util/List;
    //   69: astore_1
    //   70: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   73: ifeq +11 -> 84
    //   76: ldc 75
    //   78: iconst_2
    //   79: ldc 77
    //   81: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   84: aload_0
    //   85: getfield 13	aolj:jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager	Ldov/com/tencent/mobileqq/richmedia/capture/data/CapturePtvTemplateManager;
    //   88: aload_1
    //   89: invokevirtual 84	dov/com/tencent/mobileqq/richmedia/capture/data/CapturePtvTemplateManager:a	(Ljava/util/List;)V
    //   92: return
    //   93: astore_1
    //   94: aload_3
    //   95: astore_2
    //   96: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   99: ifeq -39 -> 60
    //   102: aload_1
    //   103: invokevirtual 87	java/lang/Exception:printStackTrace	()V
    //   106: aload_3
    //   107: astore_2
    //   108: goto -48 -> 60
    //   111: astore_3
    //   112: aconst_null
    //   113: astore_1
    //   114: aload_1
    //   115: astore_2
    //   116: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   119: ifeq +9 -> 128
    //   122: aload_1
    //   123: astore_2
    //   124: aload_3
    //   125: invokevirtual 88	java/io/IOException:printStackTrace	()V
    //   128: aload 4
    //   130: astore_2
    //   131: aload_1
    //   132: ifnull -72 -> 60
    //   135: aload_1
    //   136: invokevirtual 65	java/io/InputStream:close	()V
    //   139: aload 4
    //   141: astore_2
    //   142: goto -82 -> 60
    //   145: astore_1
    //   146: aload 4
    //   148: astore_2
    //   149: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   152: ifeq -92 -> 60
    //   155: aload_1
    //   156: invokevirtual 87	java/lang/Exception:printStackTrace	()V
    //   159: aload 4
    //   161: astore_2
    //   162: goto -102 -> 60
    //   165: astore_1
    //   166: aload_2
    //   167: ifnull +7 -> 174
    //   170: aload_2
    //   171: invokevirtual 65	java/io/InputStream:close	()V
    //   174: aload_1
    //   175: athrow
    //   176: astore_2
    //   177: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   180: ifeq -6 -> 174
    //   183: aload_2
    //   184: invokevirtual 87	java/lang/Exception:printStackTrace	()V
    //   187: goto -13 -> 174
    //   190: astore_1
    //   191: goto -25 -> 166
    //   194: astore_3
    //   195: goto -81 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	this	aolj
    //   40	49	1	localObject1	Object
    //   93	10	1	localException1	java.lang.Exception
    //   113	23	1	localObject2	Object
    //   145	11	1	localException2	java.lang.Exception
    //   165	10	1	localObject3	Object
    //   190	1	1	localObject4	Object
    //   1	170	2	localObject5	Object
    //   176	8	2	localException3	java.lang.Exception
    //   47	60	3	str1	java.lang.String
    //   111	14	3	localIOException1	java.io.IOException
    //   194	1	3	localIOException2	java.io.IOException
    //   27	133	4	str2	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   54	58	93	java/lang/Exception
    //   29	41	111	java/io/IOException
    //   135	139	145	java/lang/Exception
    //   29	41	165	finally
    //   170	174	176	java/lang/Exception
    //   43	48	190	finally
    //   116	122	190	finally
    //   124	128	190	finally
    //   43	48	194	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aolj
 * JD-Core Version:    0.7.0.1
 */