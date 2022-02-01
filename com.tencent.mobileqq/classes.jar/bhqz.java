import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.util.LRULinkedHashMap;
import mqq.util.WeakReference;

public class bhqz
{
  private static final LRULinkedHashMap<String, bhra> jdField_a_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(4);
  private static WeakReference<abbj> jdField_a_of_type_MqqUtilWeakReference;
  
  public static bhra a(String paramString)
  {
    if (AppSetting.f) {
      return null;
    }
    paramString = nko.d(paramString);
    if (TextUtils.isEmpty(paramString)) {}
    for (paramString = null;; paramString = (bhra)jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get(paramString))
    {
      String str;
      if (paramString != null)
      {
        str = paramString;
        if (!paramString.a()) {}
      }
      else
      {
        str = null;
      }
      return str;
    }
  }
  
  /* Error */
  public static boolean a(String paramString)
  {
    // Byte code:
    //   0: getstatic 27	com/tencent/common/config/AppSetting:f	Z
    //   3: ifeq +7 -> 10
    //   6: iconst_0
    //   7: istore_3
    //   8: iload_3
    //   9: ireturn
    //   10: aload_0
    //   11: invokestatic 55	bhqz:a	(Ljava/lang/String;)Lbhra;
    //   14: ifnull +19 -> 33
    //   17: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +11 -> 31
    //   23: ldc 62
    //   25: iconst_2
    //   26: ldc 64
    //   28: invokestatic 67	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   31: iconst_1
    //   32: ireturn
    //   33: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   36: ifeq +11 -> 47
    //   39: ldc 62
    //   41: iconst_2
    //   42: ldc 69
    //   44: invokestatic 67	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   47: aload_0
    //   48: invokestatic 75	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   51: ldc 77
    //   53: invokevirtual 80	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   56: astore 14
    //   58: aload 14
    //   60: invokestatic 39	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   63: ifeq +5 -> 68
    //   66: iconst_0
    //   67: ireturn
    //   68: invokestatic 86	java/lang/System:currentTimeMillis	()J
    //   71: lstore 4
    //   73: getstatic 89	nko:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   76: ifnull +42 -> 118
    //   79: getstatic 89	nko:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   82: aload 14
    //   84: invokevirtual 95	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   87: ifeq +31 -> 118
    //   90: getstatic 89	nko:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   93: aload 14
    //   95: invokevirtual 96	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   98: checkcast 98	java/lang/String
    //   101: astore 12
    //   103: invokestatic 86	java/lang/System:currentTimeMillis	()J
    //   106: lstore 6
    //   108: aload 12
    //   110: invokestatic 39	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   113: ifeq +150 -> 263
    //   116: iconst_0
    //   117: ireturn
    //   118: new 100	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   125: aload 14
    //   127: invokestatic 106	nku:a	(Ljava/lang/String;)Ljava/lang/String;
    //   130: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: aload 14
    //   135: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: ldc 112
    //   140: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: astore 12
    //   148: new 118	java/io/File
    //   151: dup
    //   152: aload 12
    //   154: invokespecial 121	java/io/File:<init>	(Ljava/lang/String;)V
    //   157: invokevirtual 124	java/io/File:exists	()Z
    //   160: istore_2
    //   161: iload_2
    //   162: ifne +5 -> 167
    //   165: iconst_0
    //   166: ireturn
    //   167: aconst_null
    //   168: astore 13
    //   170: new 126	java/io/BufferedInputStream
    //   173: dup
    //   174: new 128	java/io/FileInputStream
    //   177: dup
    //   178: aload 12
    //   180: invokespecial 129	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   183: invokespecial 132	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   186: astore 12
    //   188: aload 12
    //   190: invokestatic 137	nme:a	(Ljava/io/BufferedInputStream;)Ljava/lang/String;
    //   193: astore 13
    //   195: getstatic 89	nko:a	Ljava/util/concurrent/ConcurrentHashMap;
    //   198: aload 14
    //   200: aload 13
    //   202: invokevirtual 141	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   205: pop
    //   206: aload 12
    //   208: ifnull +702 -> 910
    //   211: aload 12
    //   213: invokevirtual 144	java/io/BufferedInputStream:close	()V
    //   216: aload 13
    //   218: astore 12
    //   220: goto -117 -> 103
    //   223: aload 12
    //   225: ifnull +679 -> 904
    //   228: aload 12
    //   230: invokevirtual 144	java/io/BufferedInputStream:close	()V
    //   233: aconst_null
    //   234: astore 12
    //   236: goto -133 -> 103
    //   239: aload 12
    //   241: ifnull +8 -> 249
    //   244: aload 12
    //   246: invokevirtual 144	java/io/BufferedInputStream:close	()V
    //   249: aload_0
    //   250: athrow
    //   251: astore_0
    //   252: ldc 62
    //   254: iconst_1
    //   255: ldc 146
    //   257: aload_0
    //   258: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   261: iconst_0
    //   262: ireturn
    //   263: new 152	org/json/JSONObject
    //   266: dup
    //   267: aload 12
    //   269: invokespecial 153	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   272: astore 12
    //   274: aload_0
    //   275: invokestatic 33	nko:d	(Ljava/lang/String;)Ljava/lang/String;
    //   278: astore 15
    //   280: aload 15
    //   282: ifnonnull +5 -> 287
    //   285: iconst_0
    //   286: ireturn
    //   287: aload 12
    //   289: aload 15
    //   291: invokevirtual 156	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   294: astore 13
    //   296: invokestatic 86	java/lang/System:currentTimeMillis	()J
    //   299: lstore 8
    //   301: getstatic 158	bhqz:jdField_a_of_type_MqqUtilWeakReference	Lmqq/util/WeakReference;
    //   304: ifnull +12 -> 316
    //   307: getstatic 158	bhqz:jdField_a_of_type_MqqUtilWeakReference	Lmqq/util/WeakReference;
    //   310: invokevirtual 163	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   313: ifnonnull +90 -> 403
    //   316: invokestatic 169	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   319: invokevirtual 173	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   322: astore 12
    //   324: aload 12
    //   326: instanceof 175
    //   329: ifeq +49 -> 378
    //   332: aload 12
    //   334: ldc 177
    //   336: invokevirtual 183	mqq/app/AppRuntime:getAppRuntime	(Ljava/lang/String;)Lmqq/app/AppRuntime;
    //   339: astore 12
    //   341: aload 12
    //   343: instanceof 185
    //   346: ifeq +552 -> 898
    //   349: new 187	abbj
    //   352: dup
    //   353: aload 12
    //   355: checkcast 185	com/tencent/common/app/AppInterface
    //   358: invokespecial 190	abbj:<init>	(Lcom/tencent/common/app/AppInterface;)V
    //   361: astore 12
    //   363: new 160	mqq/util/WeakReference
    //   366: dup
    //   367: aload 12
    //   369: invokespecial 193	mqq/util/WeakReference:<init>	(Ljava/lang/Object;)V
    //   372: putstatic 158	bhqz:jdField_a_of_type_MqqUtilWeakReference	Lmqq/util/WeakReference;
    //   375: goto +558 -> 933
    //   378: aload 12
    //   380: instanceof 185
    //   383: ifeq +509 -> 892
    //   386: new 187	abbj
    //   389: dup
    //   390: aload 12
    //   392: checkcast 185	com/tencent/common/app/AppInterface
    //   395: invokespecial 190	abbj:<init>	(Lcom/tencent/common/app/AppInterface;)V
    //   398: astore 12
    //   400: goto -37 -> 363
    //   403: getstatic 158	bhqz:jdField_a_of_type_MqqUtilWeakReference	Lmqq/util/WeakReference;
    //   406: invokevirtual 163	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   409: checkcast 187	abbj
    //   412: astore 12
    //   414: goto +519 -> 933
    //   417: aload 12
    //   419: aload 13
    //   421: invokevirtual 196	abbj:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/OfflineWebRes;
    //   424: astore 12
    //   426: invokestatic 86	java/lang/System:currentTimeMillis	()J
    //   429: lstore 10
    //   431: aload 12
    //   433: ifnonnull +5 -> 438
    //   436: iconst_0
    //   437: ireturn
    //   438: new 118	java/io/File
    //   441: dup
    //   442: invokestatic 200	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   445: invokevirtual 206	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   448: ldc 208
    //   450: invokespecial 211	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   453: astore 13
    //   455: aload 13
    //   457: invokevirtual 124	java/io/File:exists	()Z
    //   460: ifne +5 -> 465
    //   463: iconst_0
    //   464: ireturn
    //   465: new 118	java/io/File
    //   468: dup
    //   469: aload 13
    //   471: aload 12
    //   473: getfield 217	com/tencent/mobileqq/data/OfflineWebRes:hashName	Ljava/lang/String;
    //   476: invokespecial 211	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   479: astore 13
    //   481: aload 13
    //   483: invokevirtual 124	java/io/File:exists	()Z
    //   486: ifne +5 -> 491
    //   489: iconst_0
    //   490: ireturn
    //   491: ldc 219
    //   493: astore 12
    //   495: aload 15
    //   497: ldc 221
    //   499: invokevirtual 224	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   502: ifeq +46 -> 548
    //   505: ldc 226
    //   507: astore 12
    //   509: new 128	java/io/FileInputStream
    //   512: dup
    //   513: aload 13
    //   515: invokespecial 229	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   518: astore 14
    //   520: aload 14
    //   522: astore 13
    //   524: aload 14
    //   526: invokevirtual 235	java/io/InputStream:available	()I
    //   529: istore_1
    //   530: iload_1
    //   531: ifne +81 -> 612
    //   534: iconst_0
    //   535: istore_3
    //   536: aload 14
    //   538: ifnull -530 -> 8
    //   541: aload 14
    //   543: invokevirtual 236	java/io/InputStream:close	()V
    //   546: iconst_0
    //   547: ireturn
    //   548: aload 15
    //   550: ldc 238
    //   552: invokevirtual 224	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   555: ifeq +10 -> 565
    //   558: ldc 240
    //   560: astore 12
    //   562: goto -53 -> 509
    //   565: aload 15
    //   567: ldc 242
    //   569: invokevirtual 224	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   572: ifne +33 -> 605
    //   575: aload 15
    //   577: ldc 244
    //   579: invokevirtual 224	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   582: ifne +23 -> 605
    //   585: aload 15
    //   587: ldc 246
    //   589: invokevirtual 224	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   592: ifne +13 -> 605
    //   595: aload 15
    //   597: ldc 248
    //   599: invokevirtual 224	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   602: ifeq -93 -> 509
    //   605: ldc 250
    //   607: astore 12
    //   609: goto -100 -> 509
    //   612: aload 14
    //   614: astore 13
    //   616: iload_1
    //   617: newarray byte
    //   619: astore 16
    //   621: aload 14
    //   623: astore 13
    //   625: iload_1
    //   626: aload 14
    //   628: aload 16
    //   630: invokevirtual 254	java/io/InputStream:read	([B)I
    //   633: if_icmpne +254 -> 887
    //   636: aload 14
    //   638: astore 13
    //   640: new 98	java/lang/String
    //   643: dup
    //   644: aload 16
    //   646: ldc_w 256
    //   649: invokespecial 259	java/lang/String:<init>	([BLjava/lang/String;)V
    //   652: astore 16
    //   654: aload 14
    //   656: astore 13
    //   658: getstatic 19	bhqz:jdField_a_of_type_ComTencentUtilLRULinkedHashMap	Lcom/tencent/util/LRULinkedHashMap;
    //   661: aload 15
    //   663: new 41	bhra
    //   666: dup
    //   667: aload 12
    //   669: aload 16
    //   671: ldc_w 256
    //   674: invokespecial 262	bhra:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   677: invokevirtual 263	com/tencent/util/LRULinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   680: pop
    //   681: iconst_1
    //   682: istore_3
    //   683: iload_3
    //   684: istore_2
    //   685: aload 14
    //   687: ifnull +10 -> 697
    //   690: aload 14
    //   692: invokevirtual 236	java/io/InputStream:close	()V
    //   695: iload_3
    //   696: istore_2
    //   697: iload_2
    //   698: istore_3
    //   699: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   702: ifeq -694 -> 8
    //   705: ldc 62
    //   707: iconst_2
    //   708: new 100	java/lang/StringBuilder
    //   711: dup
    //   712: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   715: ldc_w 265
    //   718: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   721: lload 6
    //   723: lload 4
    //   725: lsub
    //   726: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   729: ldc_w 270
    //   732: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: lload 8
    //   737: lload 6
    //   739: lsub
    //   740: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   743: ldc_w 272
    //   746: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   749: lload 10
    //   751: lload 8
    //   753: lsub
    //   754: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   757: ldc_w 274
    //   760: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   763: invokestatic 86	java/lang/System:currentTimeMillis	()J
    //   766: lload 4
    //   768: lsub
    //   769: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   772: ldc_w 276
    //   775: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   778: aload_0
    //   779: invokestatic 33	nko:d	(Ljava/lang/String;)Ljava/lang/String;
    //   782: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   785: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   788: invokestatic 67	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   791: iload_2
    //   792: ireturn
    //   793: aload 12
    //   795: ifnull +87 -> 882
    //   798: aload 12
    //   800: invokevirtual 236	java/io/InputStream:close	()V
    //   803: iconst_0
    //   804: istore_2
    //   805: goto -108 -> 697
    //   808: astore 12
    //   810: aconst_null
    //   811: astore 14
    //   813: aload 14
    //   815: astore 13
    //   817: ldc 62
    //   819: iconst_1
    //   820: aload 12
    //   822: invokevirtual 279	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   825: invokestatic 281	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   828: aload 14
    //   830: ifnull +52 -> 882
    //   833: aload 14
    //   835: invokevirtual 236	java/io/InputStream:close	()V
    //   838: iconst_0
    //   839: istore_2
    //   840: goto -143 -> 697
    //   843: aload 13
    //   845: ifnull +8 -> 853
    //   848: aload 13
    //   850: invokevirtual 236	java/io/InputStream:close	()V
    //   853: aload_0
    //   854: athrow
    //   855: astore_0
    //   856: goto -13 -> 843
    //   859: astore 12
    //   861: goto -48 -> 813
    //   864: astore 12
    //   866: aload 14
    //   868: astore 12
    //   870: goto -77 -> 793
    //   873: astore_0
    //   874: goto -635 -> 239
    //   877: astore 13
    //   879: goto -656 -> 223
    //   882: iconst_0
    //   883: istore_2
    //   884: goto -187 -> 697
    //   887: iconst_0
    //   888: istore_3
    //   889: goto -206 -> 683
    //   892: aconst_null
    //   893: astore 12
    //   895: goto -532 -> 363
    //   898: aconst_null
    //   899: astore 12
    //   901: goto -538 -> 363
    //   904: aconst_null
    //   905: astore 12
    //   907: goto -804 -> 103
    //   910: aload 13
    //   912: astore 12
    //   914: goto -811 -> 103
    //   917: astore 12
    //   919: aconst_null
    //   920: astore 12
    //   922: goto -699 -> 223
    //   925: astore_0
    //   926: aload 13
    //   928: astore 12
    //   930: goto -691 -> 239
    //   933: aload 12
    //   935: ifnonnull -518 -> 417
    //   938: iconst_0
    //   939: ireturn
    //   940: astore 12
    //   942: aconst_null
    //   943: astore 12
    //   945: goto -152 -> 793
    //   948: astore_0
    //   949: aconst_null
    //   950: astore 13
    //   952: goto -109 -> 843
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	955	0	paramString	String
    //   529	105	1	i	int
    //   160	724	2	bool1	boolean
    //   7	882	3	bool2	boolean
    //   71	696	4	l1	long
    //   106	632	6	l2	long
    //   299	453	8	l3	long
    //   429	321	10	l4	long
    //   101	698	12	localObject1	Object
    //   808	13	12	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   859	1	12	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   864	1	12	localException1	java.lang.Exception
    //   868	45	12	localObject2	Object
    //   917	1	12	localException2	java.lang.Exception
    //   920	14	12	localObject3	Object
    //   940	1	12	localException3	java.lang.Exception
    //   943	1	12	localObject4	Object
    //   168	681	13	localObject5	Object
    //   877	50	13	localException4	java.lang.Exception
    //   950	1	13	localObject6	Object
    //   56	811	14	localObject7	Object
    //   278	384	15	str	String
    //   619	51	16	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   33	47	251	java/lang/Exception
    //   47	66	251	java/lang/Exception
    //   68	103	251	java/lang/Exception
    //   103	116	251	java/lang/Exception
    //   118	161	251	java/lang/Exception
    //   211	216	251	java/lang/Exception
    //   228	233	251	java/lang/Exception
    //   244	249	251	java/lang/Exception
    //   249	251	251	java/lang/Exception
    //   263	280	251	java/lang/Exception
    //   287	316	251	java/lang/Exception
    //   316	363	251	java/lang/Exception
    //   363	375	251	java/lang/Exception
    //   378	400	251	java/lang/Exception
    //   403	414	251	java/lang/Exception
    //   417	431	251	java/lang/Exception
    //   438	463	251	java/lang/Exception
    //   465	489	251	java/lang/Exception
    //   495	505	251	java/lang/Exception
    //   541	546	251	java/lang/Exception
    //   548	558	251	java/lang/Exception
    //   565	595	251	java/lang/Exception
    //   595	605	251	java/lang/Exception
    //   690	695	251	java/lang/Exception
    //   699	791	251	java/lang/Exception
    //   798	803	251	java/lang/Exception
    //   833	838	251	java/lang/Exception
    //   848	853	251	java/lang/Exception
    //   853	855	251	java/lang/Exception
    //   509	520	808	java/lang/OutOfMemoryError
    //   524	530	855	finally
    //   616	621	855	finally
    //   625	636	855	finally
    //   640	654	855	finally
    //   658	681	855	finally
    //   817	828	855	finally
    //   524	530	859	java/lang/OutOfMemoryError
    //   616	621	859	java/lang/OutOfMemoryError
    //   625	636	859	java/lang/OutOfMemoryError
    //   640	654	859	java/lang/OutOfMemoryError
    //   658	681	859	java/lang/OutOfMemoryError
    //   524	530	864	java/lang/Exception
    //   616	621	864	java/lang/Exception
    //   625	636	864	java/lang/Exception
    //   640	654	864	java/lang/Exception
    //   658	681	864	java/lang/Exception
    //   188	206	873	finally
    //   188	206	877	java/lang/Exception
    //   170	188	917	java/lang/Exception
    //   170	188	925	finally
    //   509	520	940	java/lang/Exception
    //   509	520	948	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhqz
 * JD-Core Version:    0.7.0.1
 */