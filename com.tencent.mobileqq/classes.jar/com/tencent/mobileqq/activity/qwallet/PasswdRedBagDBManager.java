package com.tencent.mobileqq.activity.qwallet;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

public class PasswdRedBagDBManager
{
  private Context jdField_a_of_type_AndroidContentContext;
  private SQLiteDatabase jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase;
  private PasswdRedBagDBHelper jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagDBHelper;
  private PasswdRedBagManager jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager;
  private String jdField_a_of_type_JavaLangString;
  
  public PasswdRedBagDBManager(PasswdRedBagManager paramPasswdRedBagManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagDBHelper = new PasswdRedBagDBHelper(paramPasswdRedBagManager.jdField_a_of_type_AndroidContentContext, paramPasswdRedBagManager.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidContentContext = paramPasswdRedBagManager.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_JavaLangString = paramPasswdRedBagManager.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager = paramPasswdRedBagManager;
  }
  
  /* Error */
  public java.util.HashMap a()
  {
    // Byte code:
    //   0: new 38	java/util/HashMap
    //   3: dup
    //   4: invokespecial 39	java/util/HashMap:<init>	()V
    //   7: astore 8
    //   9: aload_0
    //   10: aload_0
    //   11: getfield 28	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBManager:jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagDBHelper	Lcom/tencent/mobileqq/activity/qwallet/PasswdRedBagDBHelper;
    //   14: invokevirtual 43	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   17: putfield 45	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   20: aload_0
    //   21: getfield 45	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   24: ldc 47
    //   26: iconst_4
    //   27: anewarray 49	java/lang/String
    //   30: dup
    //   31: iconst_0
    //   32: ldc 51
    //   34: aastore
    //   35: dup
    //   36: iconst_1
    //   37: ldc 53
    //   39: aastore
    //   40: dup
    //   41: iconst_2
    //   42: ldc 55
    //   44: aastore
    //   45: dup
    //   46: iconst_3
    //   47: ldc 57
    //   49: aastore
    //   50: aconst_null
    //   51: aconst_null
    //   52: aconst_null
    //   53: aconst_null
    //   54: aconst_null
    //   55: invokevirtual 63	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   58: astore 6
    //   60: aload 6
    //   62: ifnull +240 -> 302
    //   65: aload 6
    //   67: astore 5
    //   69: aload 6
    //   71: ldc 51
    //   73: invokeinterface 69 2 0
    //   78: istore_1
    //   79: aload 6
    //   81: astore 5
    //   83: aload 6
    //   85: ldc 53
    //   87: invokeinterface 69 2 0
    //   92: istore_2
    //   93: aload 6
    //   95: astore 5
    //   97: aload 6
    //   99: ldc 55
    //   101: invokeinterface 69 2 0
    //   106: istore_3
    //   107: aload 6
    //   109: astore 5
    //   111: aload 6
    //   113: ldc 57
    //   115: invokeinterface 69 2 0
    //   120: istore 4
    //   122: aload 6
    //   124: astore 5
    //   126: aload 6
    //   128: invokeinterface 73 1 0
    //   133: ifeq +169 -> 302
    //   136: aload 6
    //   138: astore 5
    //   140: new 75	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   147: astore 7
    //   149: aload 6
    //   151: astore 5
    //   153: aload 7
    //   155: aload 6
    //   157: iload_3
    //   158: invokeinterface 80 2 0
    //   163: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload 6
    //   169: astore 5
    //   171: aload 7
    //   173: ldc 86
    //   175: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload 6
    //   181: astore 5
    //   183: aload 7
    //   185: aload 6
    //   187: iload_2
    //   188: invokeinterface 80 2 0
    //   193: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload 6
    //   199: astore 5
    //   201: aload 7
    //   203: ldc 86
    //   205: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload 6
    //   211: astore 5
    //   213: aload 7
    //   215: aload 6
    //   217: iload_1
    //   218: invokeinterface 80 2 0
    //   223: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: aload 6
    //   229: astore 5
    //   231: aload 8
    //   233: aload 7
    //   235: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: aload 6
    //   240: iload 4
    //   242: invokeinterface 80 2 0
    //   247: invokevirtual 94	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   250: pop
    //   251: goto -129 -> 122
    //   254: astore 7
    //   256: aload 6
    //   258: astore 5
    //   260: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   263: ifeq +15 -> 278
    //   266: aload 6
    //   268: astore 5
    //   270: ldc 101
    //   272: iconst_2
    //   273: ldc 103
    //   275: invokestatic 107	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   278: aload 6
    //   280: astore 5
    //   282: aload 7
    //   284: invokevirtual 110	java/lang/Exception:printStackTrace	()V
    //   287: aload 6
    //   289: ifnull +10 -> 299
    //   292: aload 6
    //   294: invokeinterface 113 1 0
    //   299: aload 8
    //   301: areturn
    //   302: aload 6
    //   304: ifnull -5 -> 299
    //   307: aload 6
    //   309: invokeinterface 113 1 0
    //   314: aload 8
    //   316: areturn
    //   317: astore 6
    //   319: aconst_null
    //   320: astore 5
    //   322: aload 5
    //   324: ifnull +10 -> 334
    //   327: aload 5
    //   329: invokeinterface 113 1 0
    //   334: aload 6
    //   336: athrow
    //   337: astore 6
    //   339: goto -17 -> 322
    //   342: astore 7
    //   344: aconst_null
    //   345: astore 6
    //   347: goto -91 -> 256
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	350	0	this	PasswdRedBagDBManager
    //   78	140	1	i	int
    //   92	96	2	j	int
    //   106	52	3	k	int
    //   120	121	4	m	int
    //   67	261	5	localCursor1	android.database.Cursor
    //   58	250	6	localCursor2	android.database.Cursor
    //   317	18	6	localObject1	Object
    //   337	1	6	localObject2	Object
    //   345	1	6	localObject3	Object
    //   147	87	7	localStringBuilder	java.lang.StringBuilder
    //   254	29	7	localException1	Exception
    //   342	1	7	localException2	Exception
    //   7	308	8	localHashMap	java.util.HashMap
    // Exception table:
    //   from	to	target	type
    //   69	79	254	java/lang/Exception
    //   83	93	254	java/lang/Exception
    //   97	107	254	java/lang/Exception
    //   111	122	254	java/lang/Exception
    //   126	136	254	java/lang/Exception
    //   140	149	254	java/lang/Exception
    //   153	167	254	java/lang/Exception
    //   171	179	254	java/lang/Exception
    //   183	197	254	java/lang/Exception
    //   201	209	254	java/lang/Exception
    //   213	227	254	java/lang/Exception
    //   231	251	254	java/lang/Exception
    //   9	60	317	finally
    //   69	79	337	finally
    //   83	93	337	finally
    //   97	107	337	finally
    //   111	122	337	finally
    //   126	136	337	finally
    //   140	149	337	finally
    //   153	167	337	finally
    //   171	179	337	finally
    //   183	197	337	finally
    //   201	209	337	finally
    //   213	227	337	finally
    //   231	251	337	finally
    //   260	266	337	finally
    //   270	278	337	finally
    //   282	287	337	finally
    //   9	60	342	java/lang/Exception
  }
  
  /* Error */
  public java.util.List a()
  {
    // Byte code:
    //   0: new 116	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 117	java/util/ArrayList:<init>	()V
    //   7: astore 14
    //   9: aload_0
    //   10: aload_0
    //   11: getfield 28	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBManager:jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagDBHelper	Lcom/tencent/mobileqq/activity/qwallet/PasswdRedBagDBHelper;
    //   14: invokevirtual 43	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   17: putfield 45	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   20: aload_0
    //   21: getfield 45	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   24: ldc 119
    //   26: bipush 9
    //   28: anewarray 49	java/lang/String
    //   31: dup
    //   32: iconst_0
    //   33: ldc 51
    //   35: aastore
    //   36: dup
    //   37: iconst_1
    //   38: ldc 121
    //   40: aastore
    //   41: dup
    //   42: iconst_2
    //   43: ldc 123
    //   45: aastore
    //   46: dup
    //   47: iconst_3
    //   48: ldc 125
    //   50: aastore
    //   51: dup
    //   52: iconst_4
    //   53: ldc 127
    //   55: aastore
    //   56: dup
    //   57: iconst_5
    //   58: ldc 129
    //   60: aastore
    //   61: dup
    //   62: bipush 6
    //   64: ldc 131
    //   66: aastore
    //   67: dup
    //   68: bipush 7
    //   70: ldc 133
    //   72: aastore
    //   73: dup
    //   74: bipush 8
    //   76: ldc 135
    //   78: aastore
    //   79: aconst_null
    //   80: aconst_null
    //   81: aconst_null
    //   82: aconst_null
    //   83: ldc 137
    //   85: invokevirtual 63	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   88: astore 12
    //   90: aload 12
    //   92: ifnull +443 -> 535
    //   95: aload 12
    //   97: astore 11
    //   99: aload 12
    //   101: ldc 51
    //   103: invokeinterface 69 2 0
    //   108: istore_1
    //   109: aload 12
    //   111: astore 11
    //   113: aload 12
    //   115: ldc 121
    //   117: invokeinterface 69 2 0
    //   122: istore_2
    //   123: aload 12
    //   125: astore 11
    //   127: aload 12
    //   129: ldc 123
    //   131: invokeinterface 69 2 0
    //   136: istore_3
    //   137: aload 12
    //   139: astore 11
    //   141: aload 12
    //   143: ldc 125
    //   145: invokeinterface 69 2 0
    //   150: istore 4
    //   152: aload 12
    //   154: astore 11
    //   156: aload 12
    //   158: ldc 127
    //   160: invokeinterface 69 2 0
    //   165: istore 5
    //   167: aload 12
    //   169: astore 11
    //   171: aload 12
    //   173: ldc 129
    //   175: invokeinterface 69 2 0
    //   180: istore 6
    //   182: aload 12
    //   184: astore 11
    //   186: aload 12
    //   188: ldc 131
    //   190: invokeinterface 69 2 0
    //   195: istore 7
    //   197: aload 12
    //   199: astore 11
    //   201: aload 12
    //   203: ldc 133
    //   205: invokeinterface 69 2 0
    //   210: istore 8
    //   212: aload 12
    //   214: astore 11
    //   216: aload 12
    //   218: ldc 135
    //   220: invokeinterface 69 2 0
    //   225: istore 9
    //   227: aload 12
    //   229: astore 11
    //   231: aload 12
    //   233: invokeinterface 73 1 0
    //   238: ifeq +297 -> 535
    //   241: aload 12
    //   243: astore 11
    //   245: new 139	com/tencent/mobileqq/activity/qwallet/PasswdRedBagInfo
    //   248: dup
    //   249: invokespecial 140	com/tencent/mobileqq/activity/qwallet/PasswdRedBagInfo:<init>	()V
    //   252: astore 13
    //   254: aload 12
    //   256: astore 11
    //   258: aload 12
    //   260: iload 7
    //   262: invokeinterface 144 2 0
    //   267: iconst_1
    //   268: if_icmpne +249 -> 517
    //   271: iconst_1
    //   272: istore 10
    //   274: aload 12
    //   276: astore 11
    //   278: aload 13
    //   280: iload 10
    //   282: putfield 148	com/tencent/mobileqq/activity/qwallet/PasswdRedBagInfo:jdField_b_of_type_Boolean	Z
    //   285: aload 12
    //   287: astore 11
    //   289: aload 12
    //   291: iload 6
    //   293: invokeinterface 144 2 0
    //   298: iconst_1
    //   299: if_icmpne +224 -> 523
    //   302: iconst_1
    //   303: istore 10
    //   305: aload 12
    //   307: astore 11
    //   309: aload 13
    //   311: iload 10
    //   313: putfield 150	com/tencent/mobileqq/activity/qwallet/PasswdRedBagInfo:jdField_a_of_type_Boolean	Z
    //   316: aload 12
    //   318: astore 11
    //   320: aload 13
    //   322: aload 12
    //   324: iload 5
    //   326: invokeinterface 80 2 0
    //   331: putfield 152	com/tencent/mobileqq/activity/qwallet/PasswdRedBagInfo:d	Ljava/lang/String;
    //   334: aload 12
    //   336: astore 11
    //   338: aload 13
    //   340: aload 12
    //   342: iload_1
    //   343: invokeinterface 80 2 0
    //   348: putfield 153	com/tencent/mobileqq/activity/qwallet/PasswdRedBagInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   351: aload 12
    //   353: astore 11
    //   355: aload 13
    //   357: aload 12
    //   359: iload_2
    //   360: invokeinterface 80 2 0
    //   365: putfield 155	com/tencent/mobileqq/activity/qwallet/PasswdRedBagInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   368: aload 12
    //   370: astore 11
    //   372: aload 13
    //   374: aload 12
    //   376: iload_3
    //   377: invokeinterface 80 2 0
    //   382: putfield 158	com/tencent/mobileqq/activity/qwallet/PasswdRedBagInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   385: aload 12
    //   387: astore 11
    //   389: aload 13
    //   391: aload 12
    //   393: iload 4
    //   395: invokeinterface 162 2 0
    //   400: putfield 165	com/tencent/mobileqq/activity/qwallet/PasswdRedBagInfo:jdField_a_of_type_Long	J
    //   403: aload 12
    //   405: astore 11
    //   407: aload 12
    //   409: iload 8
    //   411: invokeinterface 144 2 0
    //   416: iconst_1
    //   417: if_icmpne +112 -> 529
    //   420: iconst_1
    //   421: istore 10
    //   423: aload 12
    //   425: astore 11
    //   427: aload 13
    //   429: iload 10
    //   431: putfield 167	com/tencent/mobileqq/activity/qwallet/PasswdRedBagInfo:jdField_c_of_type_Boolean	Z
    //   434: aload 12
    //   436: astore 11
    //   438: aload 13
    //   440: aload 12
    //   442: iload 9
    //   444: invokeinterface 144 2 0
    //   449: putfield 170	com/tencent/mobileqq/activity/qwallet/PasswdRedBagInfo:jdField_a_of_type_Int	I
    //   452: aload 12
    //   454: astore 11
    //   456: aload 14
    //   458: aload 13
    //   460: invokeinterface 176 2 0
    //   465: pop
    //   466: goto -239 -> 227
    //   469: astore 13
    //   471: aload 12
    //   473: astore 11
    //   475: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   478: ifeq +15 -> 493
    //   481: aload 12
    //   483: astore 11
    //   485: ldc 101
    //   487: iconst_2
    //   488: ldc 178
    //   490: invokestatic 107	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   493: aload 12
    //   495: astore 11
    //   497: aload 13
    //   499: invokevirtual 110	java/lang/Exception:printStackTrace	()V
    //   502: aload 12
    //   504: ifnull +10 -> 514
    //   507: aload 12
    //   509: invokeinterface 113 1 0
    //   514: aload 14
    //   516: areturn
    //   517: iconst_0
    //   518: istore 10
    //   520: goto -246 -> 274
    //   523: iconst_0
    //   524: istore 10
    //   526: goto -221 -> 305
    //   529: iconst_0
    //   530: istore 10
    //   532: goto -109 -> 423
    //   535: aload 12
    //   537: ifnull -23 -> 514
    //   540: aload 12
    //   542: invokeinterface 113 1 0
    //   547: aload 14
    //   549: areturn
    //   550: astore 12
    //   552: aconst_null
    //   553: astore 11
    //   555: aload 11
    //   557: ifnull +10 -> 567
    //   560: aload 11
    //   562: invokeinterface 113 1 0
    //   567: aload 12
    //   569: athrow
    //   570: astore 12
    //   572: goto -17 -> 555
    //   575: astore 13
    //   577: aconst_null
    //   578: astore 12
    //   580: goto -109 -> 471
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	583	0	this	PasswdRedBagDBManager
    //   108	235	1	i	int
    //   122	238	2	j	int
    //   136	241	3	k	int
    //   150	244	4	m	int
    //   165	160	5	n	int
    //   180	112	6	i1	int
    //   195	66	7	i2	int
    //   210	200	8	i3	int
    //   225	218	9	i4	int
    //   272	259	10	bool	boolean
    //   97	464	11	localCursor1	android.database.Cursor
    //   88	453	12	localCursor2	android.database.Cursor
    //   550	18	12	localObject1	Object
    //   570	1	12	localObject2	Object
    //   578	1	12	localObject3	Object
    //   252	207	13	localPasswdRedBagInfo	PasswdRedBagInfo
    //   469	29	13	localException1	Exception
    //   575	1	13	localException2	Exception
    //   7	541	14	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   99	109	469	java/lang/Exception
    //   113	123	469	java/lang/Exception
    //   127	137	469	java/lang/Exception
    //   141	152	469	java/lang/Exception
    //   156	167	469	java/lang/Exception
    //   171	182	469	java/lang/Exception
    //   186	197	469	java/lang/Exception
    //   201	212	469	java/lang/Exception
    //   216	227	469	java/lang/Exception
    //   231	241	469	java/lang/Exception
    //   245	254	469	java/lang/Exception
    //   258	271	469	java/lang/Exception
    //   278	285	469	java/lang/Exception
    //   289	302	469	java/lang/Exception
    //   309	316	469	java/lang/Exception
    //   320	334	469	java/lang/Exception
    //   338	351	469	java/lang/Exception
    //   355	368	469	java/lang/Exception
    //   372	385	469	java/lang/Exception
    //   389	403	469	java/lang/Exception
    //   407	420	469	java/lang/Exception
    //   427	434	469	java/lang/Exception
    //   438	452	469	java/lang/Exception
    //   456	466	469	java/lang/Exception
    //   9	90	550	finally
    //   99	109	570	finally
    //   113	123	570	finally
    //   127	137	570	finally
    //   141	152	570	finally
    //   156	167	570	finally
    //   171	182	570	finally
    //   186	197	570	finally
    //   201	212	570	finally
    //   216	227	570	finally
    //   231	241	570	finally
    //   245	254	570	finally
    //   258	271	570	finally
    //   278	285	570	finally
    //   289	302	570	finally
    //   309	316	570	finally
    //   320	334	570	finally
    //   338	351	570	finally
    //   355	368	570	finally
    //   372	385	570	finally
    //   389	403	570	finally
    //   407	420	570	finally
    //   427	434	570	finally
    //   438	452	570	finally
    //   456	466	570	finally
    //   475	481	570	finally
    //   485	493	570	finally
    //   497	502	570	finally
    //   9	90	575	java/lang/Exception
  }
  
  /* Error */
  public java.util.List a(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 116	java/util/ArrayList
    //   6: dup
    //   7: invokespecial 117	java/util/ArrayList:<init>	()V
    //   10: astore 7
    //   12: aload_0
    //   13: aload_0
    //   14: getfield 28	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBManager:jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagDBHelper	Lcom/tencent/mobileqq/activity/qwallet/PasswdRedBagDBHelper;
    //   17: invokevirtual 43	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   20: putfield 45	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   23: aload_0
    //   24: getfield 45	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   27: astore 4
    //   29: new 75	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   36: iload_1
    //   37: invokevirtual 182	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   40: ldc 184
    //   42: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: astore 6
    //   50: aload 4
    //   52: ldc 186
    //   54: iconst_2
    //   55: anewarray 49	java/lang/String
    //   58: dup
    //   59: iconst_0
    //   60: ldc 53
    //   62: aastore
    //   63: dup
    //   64: iconst_1
    //   65: ldc 188
    //   67: aastore
    //   68: ldc 190
    //   70: iconst_1
    //   71: anewarray 49	java/lang/String
    //   74: dup
    //   75: iconst_0
    //   76: aload 6
    //   78: aastore
    //   79: aconst_null
    //   80: aconst_null
    //   81: aconst_null
    //   82: invokevirtual 63	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   85: astore 4
    //   87: aload 4
    //   89: astore 5
    //   91: aload 5
    //   93: ifnull +167 -> 260
    //   96: aload 5
    //   98: astore 4
    //   100: aload 5
    //   102: ldc 53
    //   104: invokeinterface 69 2 0
    //   109: istore_2
    //   110: aload 5
    //   112: astore 4
    //   114: aload 5
    //   116: ldc 188
    //   118: invokeinterface 69 2 0
    //   123: istore_3
    //   124: aload 5
    //   126: astore 4
    //   128: aload 5
    //   130: invokeinterface 73 1 0
    //   135: ifeq +125 -> 260
    //   138: aload 5
    //   140: astore 4
    //   142: new 192	com/tencent/mobileqq/activity/qwallet/PasswdRedBagUpdateInfo
    //   145: dup
    //   146: invokespecial 193	com/tencent/mobileqq/activity/qwallet/PasswdRedBagUpdateInfo:<init>	()V
    //   149: astore 6
    //   151: aload 5
    //   153: astore 4
    //   155: aload 6
    //   157: iload_1
    //   158: putfield 194	com/tencent/mobileqq/activity/qwallet/PasswdRedBagUpdateInfo:jdField_a_of_type_Int	I
    //   161: aload 5
    //   163: astore 4
    //   165: aload 6
    //   167: aload 5
    //   169: iload_2
    //   170: invokeinterface 162 2 0
    //   175: putfield 195	com/tencent/mobileqq/activity/qwallet/PasswdRedBagUpdateInfo:jdField_a_of_type_Long	J
    //   178: aload 5
    //   180: astore 4
    //   182: aload 6
    //   184: aload 5
    //   186: iload_3
    //   187: invokeinterface 162 2 0
    //   192: putfield 197	com/tencent/mobileqq/activity/qwallet/PasswdRedBagUpdateInfo:b	J
    //   195: aload 5
    //   197: astore 4
    //   199: aload 7
    //   201: aload 6
    //   203: invokeinterface 176 2 0
    //   208: pop
    //   209: goto -85 -> 124
    //   212: astore 6
    //   214: aload 5
    //   216: astore 4
    //   218: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   221: ifeq +15 -> 236
    //   224: aload 5
    //   226: astore 4
    //   228: ldc 101
    //   230: iconst_2
    //   231: ldc 199
    //   233: invokestatic 107	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   236: aload 5
    //   238: astore 4
    //   240: aload 6
    //   242: invokevirtual 110	java/lang/Exception:printStackTrace	()V
    //   245: aload 5
    //   247: ifnull +10 -> 257
    //   250: aload 5
    //   252: invokeinterface 113 1 0
    //   257: aload 7
    //   259: areturn
    //   260: aload 5
    //   262: ifnull -5 -> 257
    //   265: aload 5
    //   267: invokeinterface 113 1 0
    //   272: aload 7
    //   274: areturn
    //   275: astore 4
    //   277: aload 5
    //   279: ifnull +10 -> 289
    //   282: aload 5
    //   284: invokeinterface 113 1 0
    //   289: aload 4
    //   291: athrow
    //   292: astore 6
    //   294: aload 4
    //   296: astore 5
    //   298: aload 6
    //   300: astore 4
    //   302: goto -25 -> 277
    //   305: astore 6
    //   307: aconst_null
    //   308: astore 5
    //   310: goto -96 -> 214
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	313	0	this	PasswdRedBagDBManager
    //   0	313	1	paramInt	int
    //   109	61	2	i	int
    //   123	64	3	j	int
    //   27	212	4	localObject1	Object
    //   275	20	4	localObject2	Object
    //   300	1	4	localObject3	Object
    //   1	308	5	localObject4	Object
    //   48	154	6	localObject5	Object
    //   212	29	6	localException1	Exception
    //   292	7	6	localObject6	Object
    //   305	1	6	localException2	Exception
    //   10	263	7	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   100	110	212	java/lang/Exception
    //   114	124	212	java/lang/Exception
    //   128	138	212	java/lang/Exception
    //   142	151	212	java/lang/Exception
    //   155	161	212	java/lang/Exception
    //   165	178	212	java/lang/Exception
    //   182	195	212	java/lang/Exception
    //   199	209	212	java/lang/Exception
    //   12	87	275	finally
    //   100	110	292	finally
    //   114	124	292	finally
    //   128	138	292	finally
    //   142	151	292	finally
    //   155	161	292	finally
    //   165	178	292	finally
    //   182	195	292	finally
    //   199	209	292	finally
    //   218	224	292	finally
    //   228	236	292	finally
    //   240	245	292	finally
    //   12	87	305	java/lang/Exception
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase != null) {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.close();
    }
  }
  
  public void a(PasswdRedBagInfo paramPasswdRedBagInfo)
  {
    int j = 1;
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagDBHelper.getWritableDatabase();
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("redbag_id", paramPasswdRedBagInfo.jdField_a_of_type_JavaLangString);
      localContentValues.put("redbag_index", paramPasswdRedBagInfo.jdField_b_of_type_JavaLangString);
      localContentValues.put("uint64_creator_uin", paramPasswdRedBagInfo.jdField_c_of_type_JavaLangString);
      localContentValues.put("expire_time", Long.valueOf(paramPasswdRedBagInfo.jdField_a_of_type_Long));
      localContentValues.put("password", paramPasswdRedBagInfo.d);
      if (paramPasswdRedBagInfo.jdField_a_of_type_Boolean)
      {
        i = 1;
        localContentValues.put("is_open", Integer.valueOf(i));
        if (!paramPasswdRedBagInfo.jdField_b_of_type_Boolean) {
          break label173;
        }
        i = 1;
        label109:
        localContentValues.put("is_finish", Integer.valueOf(i));
        if (!paramPasswdRedBagInfo.jdField_c_of_type_Boolean) {
          break label178;
        }
      }
      label173:
      label178:
      for (int i = j;; i = 0)
      {
        localContentValues.put("is_overdue", Integer.valueOf(i));
        localContentValues.put("redbag_type", Integer.valueOf(paramPasswdRedBagInfo.jdField_a_of_type_Int));
        this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.replace("red_bags", null, localContentValues);
        return;
        i = 0;
        break;
        i = 0;
        break label109;
      }
      return;
    }
    catch (Exception paramPasswdRedBagInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PasswdRedBagManager", 2, "insertPasswdRedBag failed ");
      }
      paramPasswdRedBagInfo.printStackTrace();
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagDBHelper.getWritableDatabase();
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("redbag_id", paramString3);
      localContentValues.put("source", paramString1);
      localContentValues.put("code", paramString2);
      localContentValues.put("authkey", paramString4);
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.replace("red_bag_relations", null, localContentValues);
      return;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PasswdRedBagManager", 2, "insertPasswdRedBagRelation failed ");
      }
      paramString1.printStackTrace();
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    int i = 1;
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagDBHelper.getWritableDatabase();
      ContentValues localContentValues = new ContentValues();
      if (paramBoolean) {}
      for (;;)
      {
        localContentValues.put("is_open", Integer.valueOf(i));
        this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.update("red_bags", localContentValues, "redbag_id=?", new String[] { paramString });
        return;
        i = 0;
      }
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PasswdRedBagManager", 2, "setOpen failed ");
      }
      paramString.printStackTrace();
    }
  }
  
  /* Error */
  public void a(java.util.List paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield 28	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBManager:jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagDBHelper	Lcom/tencent/mobileqq/activity/qwallet/PasswdRedBagDBHelper;
    //   7: invokevirtual 43	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   10: putfield 45	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   13: aload_0
    //   14: getfield 45	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   17: invokevirtual 246	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   20: new 203	android/content/ContentValues
    //   23: dup
    //   24: invokespecial 204	android/content/ContentValues:<init>	()V
    //   27: astore_3
    //   28: aload_1
    //   29: invokeinterface 250 1 0
    //   34: astore_1
    //   35: aload_1
    //   36: invokeinterface 255 1 0
    //   41: ifeq +109 -> 150
    //   44: aload_1
    //   45: invokeinterface 259 1 0
    //   50: checkcast 192	com/tencent/mobileqq/activity/qwallet/PasswdRedBagUpdateInfo
    //   53: astore 4
    //   55: aload_3
    //   56: invokevirtual 262	android/content/ContentValues:clear	()V
    //   59: aload_3
    //   60: ldc 53
    //   62: aload 4
    //   64: getfield 195	com/tencent/mobileqq/activity/qwallet/PasswdRedBagUpdateInfo:jdField_a_of_type_Long	J
    //   67: invokestatic 213	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   70: invokevirtual 216	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   73: aload_3
    //   74: ldc 55
    //   76: aload 4
    //   78: getfield 194	com/tencent/mobileqq/activity/qwallet/PasswdRedBagUpdateInfo:jdField_a_of_type_Int	I
    //   81: invokestatic 221	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   84: invokevirtual 224	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   87: aload_3
    //   88: ldc 188
    //   90: aload 4
    //   92: getfield 197	com/tencent/mobileqq/activity/qwallet/PasswdRedBagUpdateInfo:b	J
    //   95: invokestatic 213	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   98: invokevirtual 216	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   101: aload_0
    //   102: getfield 45	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   105: ldc 186
    //   107: aconst_null
    //   108: aload_3
    //   109: invokevirtual 228	android/database/sqlite/SQLiteDatabase:replace	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   112: pop2
    //   113: goto -78 -> 35
    //   116: astore_1
    //   117: aload_1
    //   118: invokevirtual 110	java/lang/Exception:printStackTrace	()V
    //   121: aload_0
    //   122: getfield 45	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   125: ifnull +22 -> 147
    //   128: aload_0
    //   129: getfield 45	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   132: invokevirtual 265	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   135: istore_2
    //   136: iload_2
    //   137: ifeq +10 -> 147
    //   140: aload_0
    //   141: getfield 45	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   144: invokevirtual 268	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   147: aload_0
    //   148: monitorexit
    //   149: return
    //   150: aload_0
    //   151: getfield 45	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   154: invokevirtual 271	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   157: aload_0
    //   158: getfield 45	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   161: ifnull -14 -> 147
    //   164: aload_0
    //   165: getfield 45	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   168: invokevirtual 265	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   171: istore_2
    //   172: iload_2
    //   173: ifeq -26 -> 147
    //   176: aload_0
    //   177: getfield 45	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   180: invokevirtual 268	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   183: goto -36 -> 147
    //   186: astore_1
    //   187: aload_1
    //   188: invokevirtual 110	java/lang/Exception:printStackTrace	()V
    //   191: goto -44 -> 147
    //   194: astore_1
    //   195: aload_0
    //   196: monitorexit
    //   197: aload_1
    //   198: athrow
    //   199: astore_1
    //   200: aload_1
    //   201: invokevirtual 110	java/lang/Exception:printStackTrace	()V
    //   204: goto -57 -> 147
    //   207: astore_1
    //   208: aload_0
    //   209: getfield 45	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   212: ifnull +22 -> 234
    //   215: aload_0
    //   216: getfield 45	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   219: invokevirtual 265	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   222: istore_2
    //   223: iload_2
    //   224: ifeq +10 -> 234
    //   227: aload_0
    //   228: getfield 45	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBManager:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   231: invokevirtual 268	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   234: aload_1
    //   235: athrow
    //   236: astore_3
    //   237: aload_3
    //   238: invokevirtual 110	java/lang/Exception:printStackTrace	()V
    //   241: goto -7 -> 234
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	this	PasswdRedBagDBManager
    //   0	244	1	paramList	java.util.List
    //   135	89	2	bool	boolean
    //   27	82	3	localContentValues	ContentValues
    //   236	2	3	localException	Exception
    //   53	38	4	localPasswdRedBagUpdateInfo	PasswdRedBagUpdateInfo
    // Exception table:
    //   from	to	target	type
    //   2	35	116	java/lang/Exception
    //   35	113	116	java/lang/Exception
    //   150	157	116	java/lang/Exception
    //   176	183	186	java/lang/Exception
    //   121	136	194	finally
    //   140	147	194	finally
    //   157	172	194	finally
    //   176	183	194	finally
    //   187	191	194	finally
    //   200	204	194	finally
    //   208	223	194	finally
    //   227	234	194	finally
    //   234	236	194	finally
    //   237	241	194	finally
    //   140	147	199	java/lang/Exception
    //   2	35	207	finally
    //   35	113	207	finally
    //   117	121	207	finally
    //   150	157	207	finally
    //   227	234	236	java/lang/Exception
  }
  
  public void b()
  {
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagDBHelper.getWritableDatabase();
      long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.delete("red_bags", "expire_time < ?", new String[] { String.valueOf(l - 604800L) });
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PasswdRedBagManager", 2, "clearExpirePasswdRedBag failed ");
      }
      localException.printStackTrace();
    }
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    int i = 1;
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagDBHelper.getWritableDatabase();
      ContentValues localContentValues = new ContentValues();
      if (paramBoolean) {}
      for (;;)
      {
        localContentValues.put("is_finish", Integer.valueOf(i));
        this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.update("red_bags", localContentValues, "redbag_id=?", new String[] { paramString });
        return;
        i = 0;
      }
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PasswdRedBagManager", 2, "setFinish failed ");
      }
      paramString.printStackTrace();
    }
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 20
    //   3: aconst_null
    //   4: astore 21
    //   6: aload_0
    //   7: getfield 29	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBManager:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   10: ldc_w 296
    //   13: invokevirtual 302	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   16: astore 22
    //   18: aload 22
    //   20: invokevirtual 307	java/io/File:exists	()Z
    //   23: istore 14
    //   25: iload 14
    //   27: ifne +28 -> 55
    //   30: iconst_0
    //   31: ifeq +11 -> 42
    //   34: new 309	java/lang/NullPointerException
    //   37: dup
    //   38: invokespecial 310	java/lang/NullPointerException:<init>	()V
    //   41: athrow
    //   42: iconst_0
    //   43: ifeq +11 -> 54
    //   46: new 309	java/lang/NullPointerException
    //   49: dup
    //   50: invokespecial 310	java/lang/NullPointerException:<init>	()V
    //   53: athrow
    //   54: return
    //   55: aload 22
    //   57: invokevirtual 313	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   60: aconst_null
    //   61: iconst_0
    //   62: invokestatic 317	android/database/sqlite/SQLiteDatabase:openDatabase	(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)Landroid/database/sqlite/SQLiteDatabase;
    //   65: astore 22
    //   67: aload 22
    //   69: astore 20
    //   71: aload 20
    //   73: ifnonnull +26 -> 99
    //   76: iconst_0
    //   77: ifeq +11 -> 88
    //   80: new 309	java/lang/NullPointerException
    //   83: dup
    //   84: invokespecial 310	java/lang/NullPointerException:<init>	()V
    //   87: athrow
    //   88: aload 20
    //   90: ifnull -36 -> 54
    //   93: aload 20
    //   95: invokevirtual 200	android/database/sqlite/SQLiteDatabase:close	()V
    //   98: return
    //   99: aload 20
    //   101: ldc_w 319
    //   104: iconst_1
    //   105: anewarray 49	java/lang/String
    //   108: dup
    //   109: iconst_0
    //   110: aload_0
    //   111: getfield 30	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   114: aastore
    //   115: invokevirtual 323	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   118: astore 22
    //   120: aload 22
    //   122: ifnull +365 -> 487
    //   125: aload 22
    //   127: ldc 51
    //   129: invokeinterface 69 2 0
    //   134: istore 8
    //   136: aload 22
    //   138: ldc 121
    //   140: invokeinterface 69 2 0
    //   145: istore_2
    //   146: aload 22
    //   148: ldc 123
    //   150: invokeinterface 69 2 0
    //   155: istore_1
    //   156: aload 22
    //   158: ldc 125
    //   160: invokeinterface 69 2 0
    //   165: istore 4
    //   167: aload 22
    //   169: ldc 127
    //   171: invokeinterface 69 2 0
    //   176: istore 7
    //   178: aload 22
    //   180: ldc 57
    //   182: invokeinterface 69 2 0
    //   187: istore 6
    //   189: aload 22
    //   191: ldc 53
    //   193: invokeinterface 69 2 0
    //   198: istore 11
    //   200: aload 22
    //   202: ldc 55
    //   204: invokeinterface 69 2 0
    //   209: istore 9
    //   211: aload 22
    //   213: ldc 129
    //   215: invokeinterface 69 2 0
    //   220: istore 5
    //   222: aload 22
    //   224: ldc 131
    //   226: invokeinterface 69 2 0
    //   231: istore 12
    //   233: aload 22
    //   235: ldc 135
    //   237: invokeinterface 69 2 0
    //   242: istore_3
    //   243: aload 22
    //   245: invokeinterface 73 1 0
    //   250: ifeq +237 -> 487
    //   253: aload_0
    //   254: getfield 32	com/tencent/mobileqq/activity/qwallet/PasswdRedBagDBManager:jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager	Lcom/tencent/mobileqq/activity/qwallet/PasswdRedBagManager;
    //   257: astore 25
    //   259: aload 22
    //   261: iload 8
    //   263: invokeinterface 80 2 0
    //   268: astore 23
    //   270: aload 22
    //   272: iload_2
    //   273: invokeinterface 80 2 0
    //   278: astore 24
    //   280: aload 22
    //   282: iload 7
    //   284: invokeinterface 80 2 0
    //   289: astore 26
    //   291: aload 22
    //   293: iload_1
    //   294: invokeinterface 162 2 0
    //   299: lstore 18
    //   301: aload 22
    //   303: iload 4
    //   305: invokeinterface 162 2 0
    //   310: lstore 16
    //   312: aload 22
    //   314: iload 9
    //   316: invokeinterface 144 2 0
    //   321: istore 10
    //   323: aload 22
    //   325: iload 11
    //   327: invokeinterface 144 2 0
    //   332: istore 13
    //   334: aload 22
    //   336: iload 6
    //   338: invokeinterface 80 2 0
    //   343: astore 21
    //   345: aload 22
    //   347: iload 5
    //   349: invokeinterface 144 2 0
    //   354: iconst_1
    //   355: if_icmpne +120 -> 475
    //   358: iconst_1
    //   359: istore 14
    //   361: aload 22
    //   363: iload 12
    //   365: invokeinterface 144 2 0
    //   370: iconst_1
    //   371: if_icmpne +110 -> 481
    //   374: iconst_1
    //   375: istore 15
    //   377: aload 25
    //   379: aload 23
    //   381: aload 24
    //   383: aload 26
    //   385: lload 18
    //   387: invokestatic 286	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   390: lload 16
    //   392: iload 10
    //   394: invokestatic 325	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   397: iload 13
    //   399: invokestatic 325	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   402: aload 21
    //   404: iload 14
    //   406: iload 15
    //   408: aload 22
    //   410: iload_3
    //   411: invokeinterface 144 2 0
    //   416: invokevirtual 328	com/tencent/mobileqq/activity/qwallet/PasswdRedBagManager:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZI)V
    //   419: goto -176 -> 243
    //   422: astore 23
    //   424: aload 22
    //   426: astore 21
    //   428: aload 23
    //   430: astore 22
    //   432: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   435: ifeq +12 -> 447
    //   438: ldc 101
    //   440: iconst_2
    //   441: ldc_w 330
    //   444: invokestatic 107	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   447: aload 22
    //   449: invokevirtual 110	java/lang/Exception:printStackTrace	()V
    //   452: aload 21
    //   454: ifnull +10 -> 464
    //   457: aload 21
    //   459: invokeinterface 113 1 0
    //   464: aload 20
    //   466: ifnull -412 -> 54
    //   469: aload 20
    //   471: invokevirtual 200	android/database/sqlite/SQLiteDatabase:close	()V
    //   474: return
    //   475: iconst_0
    //   476: istore 14
    //   478: goto -117 -> 361
    //   481: iconst_0
    //   482: istore 15
    //   484: goto -107 -> 377
    //   487: aload 22
    //   489: ifnull +10 -> 499
    //   492: aload 22
    //   494: invokeinterface 113 1 0
    //   499: aload 20
    //   501: ifnull -447 -> 54
    //   504: aload 20
    //   506: invokevirtual 200	android/database/sqlite/SQLiteDatabase:close	()V
    //   509: return
    //   510: astore 21
    //   512: aconst_null
    //   513: astore 22
    //   515: aconst_null
    //   516: astore 20
    //   518: aload 22
    //   520: ifnull +10 -> 530
    //   523: aload 22
    //   525: invokeinterface 113 1 0
    //   530: aload 20
    //   532: ifnull +8 -> 540
    //   535: aload 20
    //   537: invokevirtual 200	android/database/sqlite/SQLiteDatabase:close	()V
    //   540: aload 21
    //   542: athrow
    //   543: astore 21
    //   545: aconst_null
    //   546: astore 22
    //   548: goto -30 -> 518
    //   551: astore 21
    //   553: goto -35 -> 518
    //   556: astore 23
    //   558: aload 21
    //   560: astore 22
    //   562: aload 23
    //   564: astore 21
    //   566: goto -48 -> 518
    //   569: astore 22
    //   571: goto -139 -> 432
    //   574: astore 22
    //   576: goto -144 -> 432
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	579	0	this	PasswdRedBagDBManager
    //   155	139	1	i	int
    //   145	128	2	j	int
    //   242	169	3	k	int
    //   165	139	4	m	int
    //   220	128	5	n	int
    //   187	150	6	i1	int
    //   176	107	7	i2	int
    //   134	128	8	i3	int
    //   209	106	9	i4	int
    //   321	72	10	i5	int
    //   198	128	11	i6	int
    //   231	133	12	i7	int
    //   332	66	13	i8	int
    //   23	454	14	bool1	boolean
    //   375	108	15	bool2	boolean
    //   310	81	16	l1	long
    //   299	87	18	l2	long
    //   1	535	20	localObject1	Object
    //   4	454	21	localObject2	Object
    //   510	31	21	localObject3	Object
    //   543	1	21	localObject4	Object
    //   551	8	21	localObject5	Object
    //   564	1	21	localObject6	Object
    //   16	545	22	localObject7	Object
    //   569	1	22	localException1	Exception
    //   574	1	22	localException2	Exception
    //   268	112	23	str1	String
    //   422	7	23	localException3	Exception
    //   556	7	23	localObject8	Object
    //   278	104	24	str2	String
    //   257	121	25	localPasswdRedBagManager	PasswdRedBagManager
    //   289	95	26	str3	String
    // Exception table:
    //   from	to	target	type
    //   125	243	422	java/lang/Exception
    //   243	358	422	java/lang/Exception
    //   361	374	422	java/lang/Exception
    //   377	419	422	java/lang/Exception
    //   6	25	510	finally
    //   55	67	510	finally
    //   99	120	543	finally
    //   125	243	551	finally
    //   243	358	551	finally
    //   361	374	551	finally
    //   377	419	551	finally
    //   432	447	556	finally
    //   447	452	556	finally
    //   6	25	569	java/lang/Exception
    //   55	67	569	java/lang/Exception
    //   99	120	574	java/lang/Exception
  }
  
  public void c(String paramString, boolean paramBoolean)
  {
    int i = 1;
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagDBHelper.getWritableDatabase();
      ContentValues localContentValues = new ContentValues();
      if (paramBoolean) {}
      for (;;)
      {
        localContentValues.put("is_overdue", Integer.valueOf(i));
        this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.update("red_bags", localContentValues, "redbag_id=?", new String[] { paramString });
        return;
        i = 0;
      }
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PasswdRedBagManager", 2, "setOverDue failed ");
      }
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.PasswdRedBagDBManager
 * JD-Core Version:    0.7.0.1
 */