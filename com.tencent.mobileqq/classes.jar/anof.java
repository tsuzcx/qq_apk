import cooperation.troop_homework.jsp.TroopHWJsPlugin;
import cooperation.troop_homework.jsp.TroopHWJsPlugin.UploadMediaEntry;

public class anof
  implements Runnable
{
  anoe jdField_a_of_type_Anoe;
  TroopHWJsPlugin.UploadMediaEntry jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin$UploadMediaEntry;
  
  public anof(TroopHWJsPlugin paramTroopHWJsPlugin, TroopHWJsPlugin.UploadMediaEntry paramUploadMediaEntry, anoe paramanoe)
  {
    this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin$UploadMediaEntry = paramUploadMediaEntry;
    this.jdField_a_of_type_Anoe = paramanoe;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc 27
    //   2: iconst_2
    //   3: new 29	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   10: ldc 32
    //   12: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_0
    //   16: getfield 19	anof:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin$UploadMediaEntry	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry;
    //   19: getfield 41	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:jdField_a_of_type_Int	I
    //   22: invokevirtual 44	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   25: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 54	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   31: aload_0
    //   32: getfield 19	anof:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin$UploadMediaEntry	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry;
    //   35: getfield 57	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   38: ifnull +230 -> 268
    //   41: aload_0
    //   42: getfield 19	anof:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin$UploadMediaEntry	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry;
    //   45: getfield 57	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   48: invokevirtual 63	android/graphics/Bitmap:isRecycled	()Z
    //   51: ifne +217 -> 268
    //   54: aload_0
    //   55: getfield 19	anof:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin$UploadMediaEntry	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry;
    //   58: getfield 66	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   61: invokevirtual 71	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   64: ifne +204 -> 268
    //   67: ldc 73
    //   69: astore 4
    //   71: aload_0
    //   72: getfield 14	anof:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin	Lcooperation/troop_homework/jsp/TroopHWJsPlugin;
    //   75: getfield 79	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   78: invokevirtual 84	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   81: astore 5
    //   83: aload 4
    //   85: astore_3
    //   86: aload 5
    //   88: ifnull +22 -> 110
    //   91: aload 4
    //   93: astore_3
    //   94: aload 5
    //   96: invokevirtual 89	com/tencent/biz/pubaccount/CustomWebView:getUrl	()Ljava/lang/String;
    //   99: ldc 91
    //   101: invokevirtual 97	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   104: ifeq +6 -> 110
    //   107: ldc 99
    //   109: astore_3
    //   110: aload_0
    //   111: getfield 14	anof:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin	Lcooperation/troop_homework/jsp/TroopHWJsPlugin;
    //   114: getfield 79	cooperation/troop_homework/jsp/TroopHWJsPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   117: invokevirtual 102	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   120: astore 5
    //   122: aload 5
    //   124: iconst_2
    //   125: invokevirtual 108	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   128: checkcast 110	mqq/manager/TicketManager
    //   131: astore 4
    //   133: aload 5
    //   135: invokevirtual 113	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   138: astore 5
    //   140: aload 4
    //   142: aload 5
    //   144: invokeinterface 117 2 0
    //   149: astore 6
    //   151: new 119	java/io/File
    //   154: dup
    //   155: new 29	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   162: getstatic 125	com/tencent/mobileqq/app/AppConstants:bb	Ljava/lang/String;
    //   165: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: ldc 127
    //   170: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokespecial 130	java/io/File:<init>	(Ljava/lang/String;)V
    //   179: astore 4
    //   181: aload_0
    //   182: getfield 19	anof:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin$UploadMediaEntry	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry;
    //   185: getfield 57	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   188: aload 4
    //   190: invokestatic 135	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/graphics/Bitmap;Ljava/io/File;)V
    //   193: aload_0
    //   194: getfield 19	anof:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin$UploadMediaEntry	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry;
    //   197: getfield 66	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   200: invokevirtual 71	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   203: ifeq +66 -> 269
    //   206: ldc 27
    //   208: iconst_2
    //   209: new 29	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   216: ldc 137
    //   218: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: aload_0
    //   222: getfield 19	anof:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin$UploadMediaEntry	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry;
    //   225: getfield 41	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:jdField_a_of_type_Int	I
    //   228: invokevirtual 44	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   231: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: invokestatic 54	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   237: aload_0
    //   238: getfield 19	anof:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin$UploadMediaEntry	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry;
    //   241: getfield 57	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   244: ifnull +13 -> 257
    //   247: aload_0
    //   248: getfield 19	anof:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin$UploadMediaEntry	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry;
    //   251: getfield 57	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   254: invokevirtual 140	android/graphics/Bitmap:recycle	()V
    //   257: aload 4
    //   259: ifnull +9 -> 268
    //   262: aload 4
    //   264: invokevirtual 143	java/io/File:delete	()Z
    //   267: pop
    //   268: return
    //   269: aload 4
    //   271: ifnull +166 -> 437
    //   274: aload 4
    //   276: invokevirtual 146	java/io/File:exists	()Z
    //   279: ifeq +158 -> 437
    //   282: aload_3
    //   283: aload 4
    //   285: invokevirtual 149	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   288: aload 5
    //   290: aload 6
    //   292: ldc2_w 150
    //   295: invokestatic 156	cooperation/troop_homework/TroopHomeworkHelper:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)Ljava/lang/String;
    //   298: astore_3
    //   299: aload_0
    //   300: getfield 19	anof:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin$UploadMediaEntry	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry;
    //   303: getfield 66	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   306: invokevirtual 71	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   309: istore_2
    //   310: iload_2
    //   311: ifeq +35 -> 346
    //   314: aload_0
    //   315: getfield 19	anof:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin$UploadMediaEntry	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry;
    //   318: getfield 57	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   321: ifnull +13 -> 334
    //   324: aload_0
    //   325: getfield 19	anof:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin$UploadMediaEntry	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry;
    //   328: getfield 57	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   331: invokevirtual 140	android/graphics/Bitmap:recycle	()V
    //   334: aload 4
    //   336: ifnull -68 -> 268
    //   339: aload 4
    //   341: invokevirtual 143	java/io/File:delete	()Z
    //   344: pop
    //   345: return
    //   346: aload_3
    //   347: invokestatic 161	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   350: ifne +233 -> 583
    //   353: new 163	org/json/JSONObject
    //   356: dup
    //   357: aload_3
    //   358: invokespecial 164	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   361: astore_3
    //   362: aload_3
    //   363: ifnull +220 -> 583
    //   366: aload_3
    //   367: ldc 166
    //   369: iconst_m1
    //   370: invokevirtual 170	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   373: ifne +210 -> 583
    //   376: aload_3
    //   377: ldc 172
    //   379: invokevirtual 176	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   382: astore_3
    //   383: aload_3
    //   384: ifnull +199 -> 583
    //   387: aload_3
    //   388: ldc 178
    //   390: invokevirtual 181	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   393: astore_3
    //   394: aload_0
    //   395: getfield 21	anof:jdField_a_of_type_Anoe	Lanoe;
    //   398: ifnull +190 -> 588
    //   401: aload_0
    //   402: getfield 21	anof:jdField_a_of_type_Anoe	Lanoe;
    //   405: iconst_1
    //   406: aload_3
    //   407: invokeinterface 186 3 0
    //   412: goto +176 -> 588
    //   415: iload_1
    //   416: ifne +21 -> 437
    //   419: aload_0
    //   420: getfield 21	anof:jdField_a_of_type_Anoe	Lanoe;
    //   423: ifnull +14 -> 437
    //   426: aload_0
    //   427: getfield 21	anof:jdField_a_of_type_Anoe	Lanoe;
    //   430: iconst_0
    //   431: aconst_null
    //   432: invokeinterface 186 3 0
    //   437: aload_0
    //   438: getfield 19	anof:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin$UploadMediaEntry	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry;
    //   441: getfield 57	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   444: ifnull +13 -> 457
    //   447: aload_0
    //   448: getfield 19	anof:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin$UploadMediaEntry	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry;
    //   451: getfield 57	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   454: invokevirtual 140	android/graphics/Bitmap:recycle	()V
    //   457: aload 4
    //   459: ifnull -191 -> 268
    //   462: aload 4
    //   464: invokevirtual 143	java/io/File:delete	()Z
    //   467: pop
    //   468: return
    //   469: astore 4
    //   471: aconst_null
    //   472: astore_3
    //   473: invokestatic 189	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   476: ifeq +13 -> 489
    //   479: ldc 27
    //   481: iconst_2
    //   482: ldc 191
    //   484: aload 4
    //   486: invokestatic 195	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   489: aload_0
    //   490: getfield 19	anof:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin$UploadMediaEntry	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry;
    //   493: getfield 57	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   496: ifnull +13 -> 509
    //   499: aload_0
    //   500: getfield 19	anof:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin$UploadMediaEntry	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry;
    //   503: getfield 57	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   506: invokevirtual 140	android/graphics/Bitmap:recycle	()V
    //   509: aload_3
    //   510: ifnull -242 -> 268
    //   513: aload_3
    //   514: invokevirtual 143	java/io/File:delete	()Z
    //   517: pop
    //   518: return
    //   519: astore_3
    //   520: aconst_null
    //   521: astore 4
    //   523: aload_0
    //   524: getfield 19	anof:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin$UploadMediaEntry	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry;
    //   527: getfield 57	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   530: ifnull +13 -> 543
    //   533: aload_0
    //   534: getfield 19	anof:jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin$UploadMediaEntry	Lcooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry;
    //   537: getfield 57	cooperation/troop_homework/jsp/TroopHWJsPlugin$UploadMediaEntry:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   540: invokevirtual 140	android/graphics/Bitmap:recycle	()V
    //   543: aload 4
    //   545: ifnull +9 -> 554
    //   548: aload 4
    //   550: invokevirtual 143	java/io/File:delete	()Z
    //   553: pop
    //   554: aload_3
    //   555: athrow
    //   556: astore_3
    //   557: goto -34 -> 523
    //   560: astore 5
    //   562: aload_3
    //   563: astore 4
    //   565: aload 5
    //   567: astore_3
    //   568: goto -45 -> 523
    //   571: astore 5
    //   573: aload 4
    //   575: astore_3
    //   576: aload 5
    //   578: astore 4
    //   580: goto -107 -> 473
    //   583: iconst_0
    //   584: istore_1
    //   585: goto -170 -> 415
    //   588: iconst_1
    //   589: istore_1
    //   590: goto -175 -> 415
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	593	0	this	anof
    //   415	175	1	i	int
    //   309	2	2	bool	boolean
    //   85	429	3	localObject1	Object
    //   519	36	3	localObject2	Object
    //   556	7	3	localObject3	Object
    //   567	9	3	localObject4	Object
    //   69	394	4	localObject5	Object
    //   469	16	4	localException1	java.lang.Exception
    //   521	58	4	localObject6	Object
    //   81	208	5	localObject7	Object
    //   560	6	5	localObject8	Object
    //   571	6	5	localException2	java.lang.Exception
    //   149	142	6	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   151	181	469	java/lang/Exception
    //   151	181	519	finally
    //   181	237	556	finally
    //   274	310	556	finally
    //   346	362	556	finally
    //   366	383	556	finally
    //   387	412	556	finally
    //   419	437	556	finally
    //   473	489	560	finally
    //   181	237	571	java/lang/Exception
    //   274	310	571	java/lang/Exception
    //   346	362	571	java/lang/Exception
    //   366	383	571	java/lang/Exception
    //   387	412	571	java/lang/Exception
    //   419	437	571	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anof
 * JD-Core Version:    0.7.0.1
 */