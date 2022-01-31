import com.tencent.mobileqq.persistence.EntityManager;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;

public final class anma
  extends anmb
{
  final EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  String jdField_a_of_type_JavaLangString = null;
  public boolean a;
  
  public anma(QIMMusicConfigManager paramQIMMusicConfigManager)
  {
    super(paramQIMMusicConfigManager);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = QIMMusicConfigManager.a(paramQIMMusicConfigManager);
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 30	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 32	java/util/ArrayList:<init>	()V
    //   7: astore 9
    //   9: aconst_null
    //   10: astore 7
    //   12: aconst_null
    //   13: astore 5
    //   15: aload_0
    //   16: getfield 16	anma:jdField_a_of_type_Boolean	Z
    //   19: ifeq +161 -> 180
    //   22: aload_0
    //   23: getfield 23	anma:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   26: ldc 34
    //   28: invokevirtual 39	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;)Ljava/util/List;
    //   31: astore 6
    //   33: aload 6
    //   35: ifnull +140 -> 175
    //   38: aload 6
    //   40: invokeinterface 45 1 0
    //   45: ifne +130 -> 175
    //   48: new 30	java/util/ArrayList
    //   51: dup
    //   52: aload 6
    //   54: invokespecial 48	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   57: astore 5
    //   59: aload 5
    //   61: invokeinterface 52 1 0
    //   66: istore_1
    //   67: aload 5
    //   69: astore 7
    //   71: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   74: ifeq +106 -> 180
    //   77: ldc 59
    //   79: iconst_2
    //   80: new 61	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   87: ldc 64
    //   89: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: iload_1
    //   93: invokevirtual 71	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   96: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   102: aload 5
    //   104: astore 7
    //   106: aload 5
    //   108: ifnull +72 -> 180
    //   111: aload 5
    //   113: invokeinterface 83 1 0
    //   118: astore 6
    //   120: aload 5
    //   122: astore 7
    //   124: aload 6
    //   126: invokeinterface 88 1 0
    //   131: ifeq +49 -> 180
    //   134: aload 6
    //   136: invokeinterface 92 1 0
    //   141: checkcast 34	com/tencent/mobileqq/data/FlowMusic
    //   144: astore 7
    //   146: ldc 59
    //   148: iconst_2
    //   149: new 61	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   156: ldc 94
    //   158: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload 7
    //   163: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: goto -52 -> 120
    //   175: iconst_0
    //   176: istore_1
    //   177: goto -110 -> 67
    //   180: aload_0
    //   181: getfield 14	anma:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   184: invokestatic 102	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   187: ifne +634 -> 821
    //   190: new 104	org/json/JSONObject
    //   193: dup
    //   194: aload_0
    //   195: getfield 14	anma:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   198: invokespecial 107	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   201: astore 5
    //   203: aload 5
    //   205: ldc 109
    //   207: iconst_m1
    //   208: invokevirtual 113	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   211: ifne +596 -> 807
    //   214: aload 5
    //   216: ldc 115
    //   218: invokevirtual 119	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   221: astore 6
    //   223: aload 6
    //   225: ifnull +563 -> 788
    //   228: aload 6
    //   230: invokevirtual 124	org/json/JSONArray:length	()I
    //   233: ifle +555 -> 788
    //   236: aload_0
    //   237: getfield 127	anma:jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager	Ldov/com/qq/im/capture/music/QIMMusicConfigManager;
    //   240: iconst_2
    //   241: iconst_1
    //   242: aload 6
    //   244: invokevirtual 130	dov/com/qq/im/capture/music/QIMMusicConfigManager:a	(IZLjava/lang/Object;)V
    //   247: new 30	java/util/ArrayList
    //   250: dup
    //   251: invokespecial 32	java/util/ArrayList:<init>	()V
    //   254: astore 5
    //   256: new 132	java/util/HashSet
    //   259: dup
    //   260: invokespecial 133	java/util/HashSet:<init>	()V
    //   263: astore 8
    //   265: aload 7
    //   267: ifnull +582 -> 849
    //   270: aload 7
    //   272: invokeinterface 52 1 0
    //   277: istore_1
    //   278: goto +549 -> 827
    //   281: aload 6
    //   283: invokevirtual 124	org/json/JSONArray:length	()I
    //   286: iload_1
    //   287: if_icmpge +575 -> 862
    //   290: aload 6
    //   292: invokevirtual 124	org/json/JSONArray:length	()I
    //   295: istore_1
    //   296: invokestatic 139	java/lang/System:currentTimeMillis	()J
    //   299: lstore_3
    //   300: iconst_0
    //   301: istore_2
    //   302: iload_2
    //   303: iload_1
    //   304: if_icmpge +216 -> 520
    //   307: aload 6
    //   309: iload_2
    //   310: invokevirtual 143	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   313: astore 10
    //   315: aload 10
    //   317: ifnull +525 -> 842
    //   320: new 34	com/tencent/mobileqq/data/FlowMusic
    //   323: dup
    //   324: invokespecial 144	com/tencent/mobileqq/data/FlowMusic:<init>	()V
    //   327: astore 11
    //   329: aload 11
    //   331: aload 10
    //   333: ldc 146
    //   335: invokevirtual 149	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   338: putfield 153	com/tencent/mobileqq/data/FlowMusic:albumId	I
    //   341: aload 11
    //   343: aload 10
    //   345: ldc 155
    //   347: invokevirtual 159	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   350: putfield 162	com/tencent/mobileqq/data/FlowMusic:albumMid	Ljava/lang/String;
    //   353: aload 11
    //   355: aload 10
    //   357: ldc 164
    //   359: invokevirtual 159	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   362: putfield 167	com/tencent/mobileqq/data/FlowMusic:albumName	Ljava/lang/String;
    //   365: aload 11
    //   367: aload 10
    //   369: ldc 169
    //   371: invokevirtual 149	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   374: putfield 172	com/tencent/mobileqq/data/FlowMusic:singerId	I
    //   377: aload 11
    //   379: aload 10
    //   381: ldc 174
    //   383: invokevirtual 159	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   386: putfield 177	com/tencent/mobileqq/data/FlowMusic:singerMid	Ljava/lang/String;
    //   389: aload 11
    //   391: aload 10
    //   393: ldc 179
    //   395: invokevirtual 159	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   398: putfield 182	com/tencent/mobileqq/data/FlowMusic:singerName	Ljava/lang/String;
    //   401: aload 11
    //   403: aload 10
    //   405: ldc 184
    //   407: invokevirtual 149	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   410: putfield 187	com/tencent/mobileqq/data/FlowMusic:songId	I
    //   413: aload 11
    //   415: aload 10
    //   417: ldc 189
    //   419: invokevirtual 159	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   422: putfield 192	com/tencent/mobileqq/data/FlowMusic:songMid	Ljava/lang/String;
    //   425: aload 11
    //   427: aload 10
    //   429: ldc 194
    //   431: invokevirtual 159	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   434: putfield 197	com/tencent/mobileqq/data/FlowMusic:songName	Ljava/lang/String;
    //   437: aload 11
    //   439: aload 10
    //   441: ldc 199
    //   443: invokevirtual 149	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   446: putfield 202	com/tencent/mobileqq/data/FlowMusic:songPlayTime	I
    //   449: aload 11
    //   451: aload 10
    //   453: ldc 204
    //   455: invokevirtual 149	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   458: putfield 207	com/tencent/mobileqq/data/FlowMusic:userOwnRule	I
    //   461: aload 11
    //   463: iconst_1
    //   464: putfield 210	com/tencent/mobileqq/data/FlowMusic:sourceType	I
    //   467: aload 11
    //   469: iload_1
    //   470: i2l
    //   471: lload_3
    //   472: ladd
    //   473: iload_2
    //   474: i2l
    //   475: lsub
    //   476: putfield 214	com/tencent/mobileqq/data/FlowMusic:storeTimeStamp	J
    //   479: aload 11
    //   481: getfield 192	com/tencent/mobileqq/data/FlowMusic:songMid	Ljava/lang/String;
    //   484: invokestatic 102	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   487: ifne +355 -> 842
    //   490: aload 7
    //   492: ifnull +15 -> 507
    //   495: aload 7
    //   497: aload 11
    //   499: invokeinterface 218 2 0
    //   504: ifne +338 -> 842
    //   507: aload 8
    //   509: aload 11
    //   511: invokeinterface 223 2 0
    //   516: pop
    //   517: goto +325 -> 842
    //   520: aload 5
    //   522: aload 8
    //   524: invokeinterface 227 2 0
    //   529: pop
    //   530: aload_0
    //   531: getfield 23	anma:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   534: invokevirtual 230	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   537: astore 6
    //   539: aload 6
    //   541: invokevirtual 234	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   544: aload 5
    //   546: invokeinterface 83 1 0
    //   551: astore 8
    //   553: aload 8
    //   555: invokeinterface 88 1 0
    //   560: ifeq +172 -> 732
    //   563: aload 8
    //   565: invokeinterface 92 1 0
    //   570: checkcast 34	com/tencent/mobileqq/data/FlowMusic
    //   573: astore 10
    //   575: aload_0
    //   576: getfield 23	anma:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   579: aload 10
    //   581: invokevirtual 238	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   584: goto -31 -> 553
    //   587: astore 8
    //   589: aload 6
    //   591: invokevirtual 240	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   594: aload 8
    //   596: athrow
    //   597: astore 8
    //   599: aload_0
    //   600: getfield 127	anma:jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager	Ldov/com/qq/im/capture/music/QIMMusicConfigManager;
    //   603: iconst_2
    //   604: iconst_0
    //   605: new 61	java/lang/StringBuilder
    //   608: dup
    //   609: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   612: ldc 242
    //   614: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: aload_0
    //   618: getfield 14	anma:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   621: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   627: invokevirtual 130	dov/com/qq/im/capture/music/QIMMusicConfigManager:a	(IZLjava/lang/Object;)V
    //   630: aload 5
    //   632: astore 6
    //   634: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   637: ifeq +48 -> 685
    //   640: ldc 59
    //   642: iconst_2
    //   643: new 61	java/lang/StringBuilder
    //   646: dup
    //   647: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   650: ldc 242
    //   652: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: aload_0
    //   656: getfield 14	anma:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   659: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   662: ldc 244
    //   664: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: aload 8
    //   669: invokevirtual 245	org/json/JSONException:toString	()Ljava/lang/String;
    //   672: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   675: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   678: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   681: aload 5
    //   683: astore 6
    //   685: aload 7
    //   687: ifnull +13 -> 700
    //   690: aload 9
    //   692: aload 7
    //   694: invokeinterface 227 2 0
    //   699: pop
    //   700: aload 6
    //   702: ifnull +13 -> 715
    //   705: aload 9
    //   707: aload 6
    //   709: invokeinterface 227 2 0
    //   714: pop
    //   715: aload 9
    //   717: invokestatic 251	java/util/Collections:sort	(Ljava/util/List;)V
    //   720: aload_0
    //   721: getfield 127	anma:jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager	Ldov/com/qq/im/capture/music/QIMMusicConfigManager;
    //   724: iconst_4
    //   725: iconst_1
    //   726: aload 9
    //   728: invokevirtual 130	dov/com/qq/im/capture/music/QIMMusicConfigManager:a	(IZLjava/lang/Object;)V
    //   731: return
    //   732: aload 6
    //   734: invokevirtual 254	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   737: aload_0
    //   738: getfield 256	anma:b	Ljava/lang/String;
    //   741: invokestatic 258	dov/com/qq/im/capture/music/QIMMusicConfigManager:b	(Ljava/lang/String;)V
    //   744: aload 6
    //   746: invokevirtual 240	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   749: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   752: ifeq +29 -> 781
    //   755: ldc 59
    //   757: iconst_2
    //   758: new 61	java/lang/StringBuilder
    //   761: dup
    //   762: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   765: ldc_w 260
    //   768: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   771: iload_1
    //   772: invokevirtual 71	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   775: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   778: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   781: aload 5
    //   783: astore 6
    //   785: goto -100 -> 685
    //   788: aload_0
    //   789: getfield 256	anma:b	Ljava/lang/String;
    //   792: invokestatic 258	dov/com/qq/im/capture/music/QIMMusicConfigManager:b	(Ljava/lang/String;)V
    //   795: aload_0
    //   796: getfield 127	anma:jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager	Ldov/com/qq/im/capture/music/QIMMusicConfigManager;
    //   799: iconst_2
    //   800: iconst_0
    //   801: ldc_w 262
    //   804: invokevirtual 130	dov/com/qq/im/capture/music/QIMMusicConfigManager:a	(IZLjava/lang/Object;)V
    //   807: aconst_null
    //   808: astore 5
    //   810: goto -29 -> 781
    //   813: astore 8
    //   815: aconst_null
    //   816: astore 5
    //   818: goto -219 -> 599
    //   821: aconst_null
    //   822: astore 6
    //   824: goto -139 -> 685
    //   827: bipush 40
    //   829: iload_1
    //   830: isub
    //   831: bipush 20
    //   833: if_icmple +21 -> 854
    //   836: bipush 20
    //   838: istore_1
    //   839: goto -558 -> 281
    //   842: iload_2
    //   843: iconst_1
    //   844: iadd
    //   845: istore_2
    //   846: goto -544 -> 302
    //   849: iconst_0
    //   850: istore_1
    //   851: goto -24 -> 827
    //   854: bipush 40
    //   856: iload_1
    //   857: isub
    //   858: istore_1
    //   859: goto -578 -> 281
    //   862: goto -566 -> 296
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	865	0	this	anma
    //   66	793	1	i	int
    //   301	545	2	j	int
    //   299	173	3	l	long
    //   13	804	5	localObject1	java.lang.Object
    //   31	792	6	localObject2	java.lang.Object
    //   10	683	7	localObject3	java.lang.Object
    //   263	301	8	localObject4	java.lang.Object
    //   587	8	8	localObject5	java.lang.Object
    //   597	71	8	localJSONException1	org.json.JSONException
    //   813	1	8	localJSONException2	org.json.JSONException
    //   7	720	9	localArrayList	java.util.ArrayList
    //   313	267	10	localObject6	java.lang.Object
    //   327	183	11	localFlowMusic	com.tencent.mobileqq.data.FlowMusic
    // Exception table:
    //   from	to	target	type
    //   539	553	587	finally
    //   553	584	587	finally
    //   732	744	587	finally
    //   256	265	597	org/json/JSONException
    //   270	278	597	org/json/JSONException
    //   281	296	597	org/json/JSONException
    //   296	300	597	org/json/JSONException
    //   307	315	597	org/json/JSONException
    //   320	490	597	org/json/JSONException
    //   495	507	597	org/json/JSONException
    //   507	517	597	org/json/JSONException
    //   520	539	597	org/json/JSONException
    //   589	597	597	org/json/JSONException
    //   744	781	597	org/json/JSONException
    //   190	223	813	org/json/JSONException
    //   228	256	813	org/json/JSONException
    //   788	807	813	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anma
 * JD-Core Version:    0.7.0.1
 */