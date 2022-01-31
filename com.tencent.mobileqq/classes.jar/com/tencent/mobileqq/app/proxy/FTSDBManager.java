package com.tencent.mobileqq.app.proxy;

import android.os.HandlerThread;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.app.proxy.fts.FTSIndexOperator;
import com.tencent.mobileqq.app.proxy.fts.FTSMsgOperator;
import com.tencent.mobileqq.app.proxy.fts.FTSNewTroopOperator;
import com.tencent.mobileqq.app.proxy.fts.FTSSyncHandler;
import com.tencent.mobileqq.app.proxy.fts.FTSTroopOperator;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.fts.FTSTroopSync;
import com.tencent.mobileqq.data.fts.FTSTroopTime;
import com.tencent.mobileqq.fts.FTSDatabase;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.fts.FTSDatatbase;
import com.tencent.mobileqq.utils.fts.SQLiteFTSUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Observable;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import zsc;

public class FTSDBManager
  extends Observable
  implements Manager
{
  public static volatile boolean a;
  private int jdField_a_of_type_Int = -1;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public FTSSyncHandler a;
  private FTSDatabase jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase;
  private FTSDatatbase jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private volatile int b;
  public volatile boolean b;
  private volatile boolean c;
  
  static
  {
    jdField_a_of_type_Boolean = true;
  }
  
  public FTSDBManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("QQ_FTS_Sync", 3);
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_ComTencentMobileqqAppProxyFtsFTSSyncHandler = new FTSSyncHandler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(1), new FTSMsgOperator(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppProxyFtsFTSSyncHandler));
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2), new FTSTroopOperator(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppProxyFtsFTSSyncHandler));
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(4), new FTSNewTroopOperator(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppProxyFtsFTSSyncHandler));
    a();
    if (QLog.isColorLevel()) {
      QLog.i("Q.fts.manager", 2, "FTSDBManager structure...");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    SQLiteFTSUtils.a(paramQQAppInterface, paramString);
    SQLiteDatabase localSQLiteDatabase = new QQEntityManagerFactory(paramString).build(paramString).a();
    localSQLiteDatabase.a("DROP TABLE IF EXISTS msg_upgrade_log;");
    localSQLiteDatabase.a("DROP TABLE IF EXISTS msg_sync_log;");
    localSQLiteDatabase.a("DROP TABLE IF EXISTS " + FTSTroopSync.class.getSimpleName() + ";");
    localSQLiteDatabase.a("DROP TABLE IF EXISTS " + FTSTroopTime.class.getSimpleName() + ";");
    if (!paramBoolean) {
      paramQQAppInterface.a().b();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.fts.manager", 2, "FTS clear...");
      }
      return;
      paramQQAppInterface = new File(paramQQAppInterface.getApplication().getFilesDir().getAbsolutePath().replace("files", "databases") + File.separator + paramString + "-IndexQQMsg.db");
      if ((paramQQAppInterface.exists()) && (paramQQAppInterface.isFile())) {
        paramQQAppInterface.delete();
      }
    }
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: getfield 35	com/tencent/mobileqq/app/proxy/FTSDBManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7: iconst_0
    //   8: invokestatic 218	com/tencent/mobileqq/utils/fts/SQLiteFTSUtils:f	(Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   11: aload_0
    //   12: getfield 210	com/tencent/mobileqq/app/proxy/FTSDBManager:c	Z
    //   15: ifne +215 -> 230
    //   18: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   21: ifeq +115 -> 136
    //   24: ldc 220
    //   26: aconst_null
    //   27: invokestatic 226	android/database/sqlite/SQLiteDatabase:openOrCreateDatabase	(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;)Landroid/database/sqlite/SQLiteDatabase;
    //   30: ldc 228
    //   32: aconst_null
    //   33: invokevirtual 232	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   36: astore_3
    //   37: ldc 234
    //   39: astore 5
    //   41: aload_3
    //   42: astore 4
    //   44: aload_3
    //   45: invokeinterface 239 1 0
    //   50: ifeq +36 -> 86
    //   53: aload_3
    //   54: astore 4
    //   56: new 132	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   63: aload 5
    //   65: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload_3
    //   69: iconst_0
    //   70: invokeinterface 243 2 0
    //   75: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: astore 5
    //   83: goto -42 -> 41
    //   86: aload_3
    //   87: astore 4
    //   89: ldc 89
    //   91: iconst_2
    //   92: new 132	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   99: ldc 245
    //   101: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: invokestatic 249	com/tencent/mobileqq/utils/DeviceInfoUtil:f	()Ljava/lang/String;
    //   107: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: ldc 251
    //   112: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload 5
    //   117: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokestatic 95	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   126: aload_3
    //   127: ifnull +9 -> 136
    //   130: aload_3
    //   131: invokeinterface 254 1 0
    //   136: getstatic 259	android/os/Build$VERSION:SDK_INT	I
    //   139: bipush 18
    //   141: if_icmpge +449 -> 590
    //   144: aload_0
    //   145: getfield 35	com/tencent/mobileqq/app/proxy/FTSDBManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   148: invokestatic 262	com/tencent/mobileqq/utils/fts/SQLiteFTSUtils:f	(Lcom/tencent/mobileqq/app/QQAppInterface;)I
    //   151: istore_2
    //   152: aload_0
    //   153: getfield 35	com/tencent/mobileqq/app/proxy/FTSDBManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   156: iload_2
    //   157: iconst_1
    //   158: iadd
    //   159: invokestatic 265	com/tencent/mobileqq/utils/fts/SQLiteFTSUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;I)V
    //   162: ldc 89
    //   164: iconst_1
    //   165: new 132	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   172: ldc_w 267
    //   175: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: iload_2
    //   179: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   182: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 95	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   188: iload_2
    //   189: iconst_5
    //   190: if_icmplt +79 -> 269
    //   193: iload_2
    //   194: sipush 200
    //   197: if_icmpge +72 -> 269
    //   200: ldc 89
    //   202: iconst_1
    //   203: new 132	java/lang/StringBuilder
    //   206: dup
    //   207: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   210: ldc_w 272
    //   213: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: iload_2
    //   217: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   220: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 275	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   226: iconst_0
    //   227: putstatic 21	com/tencent/mobileqq/app/proxy/FTSDBManager:jdField_a_of_type_Boolean	Z
    //   230: return
    //   231: astore_3
    //   232: aload 4
    //   234: ifnull -98 -> 136
    //   237: aload 4
    //   239: invokeinterface 254 1 0
    //   244: goto -108 -> 136
    //   247: astore_3
    //   248: aconst_null
    //   249: astore 5
    //   251: aload_3
    //   252: astore 4
    //   254: aload 5
    //   256: ifnull +10 -> 266
    //   259: aload 5
    //   261: invokeinterface 254 1 0
    //   266: aload 4
    //   268: athrow
    //   269: iload_2
    //   270: istore_1
    //   271: iload_2
    //   272: sipush 200
    //   275: if_icmplt +13 -> 288
    //   278: aload_0
    //   279: getfield 35	com/tencent/mobileqq/app/proxy/FTSDBManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   282: iconst_0
    //   283: invokestatic 265	com/tencent/mobileqq/utils/fts/SQLiteFTSUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;I)V
    //   286: iload_2
    //   287: istore_1
    //   288: ldc 89
    //   290: iconst_1
    //   291: ldc_w 277
    //   294: invokestatic 95	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   297: aload_0
    //   298: new 279	com/tencent/mobileqq/persistence/fts/FTSDatatbase
    //   301: dup
    //   302: aload_0
    //   303: getfield 35	com/tencent/mobileqq/app/proxy/FTSDBManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   306: invokespecial 281	com/tencent/mobileqq/persistence/fts/FTSDatatbase:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   309: putfield 283	com/tencent/mobileqq/app/proxy/FTSDBManager:jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   312: new 285	com/tencent/mobileqq/fts/logger/QLogger
    //   315: dup
    //   316: invokespecial 286	com/tencent/mobileqq/fts/logger/QLogger:<init>	()V
    //   319: invokestatic 291	com/tencent/mobileqq/fts/FTSDatabase:a	(Lcom/tencent/mobileqq/fts/logger/ILogger;)V
    //   322: aload_0
    //   323: new 293	com/tencent/mobileqq/fts/QFTSDatabase
    //   326: dup
    //   327: invokespecial 294	com/tencent/mobileqq/fts/QFTSDatabase:<init>	()V
    //   330: putfield 296	com/tencent/mobileqq/app/proxy/FTSDBManager:jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase	Lcom/tencent/mobileqq/fts/FTSDatabase;
    //   333: aload_0
    //   334: getfield 283	com/tencent/mobileqq/app/proxy/FTSDBManager:jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   337: invokevirtual 297	com/tencent/mobileqq/persistence/fts/FTSDatatbase:a	()V
    //   340: new 132	java/lang/StringBuilder
    //   343: dup
    //   344: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   347: aload_0
    //   348: getfield 35	com/tencent/mobileqq/app/proxy/FTSDBManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   351: invokevirtual 169	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   354: invokevirtual 175	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   357: invokevirtual 178	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   360: ldc 180
    //   362: ldc 182
    //   364: invokevirtual 188	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   367: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: getstatic 192	java/io/File:separator	Ljava/lang/String;
    //   373: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: aload_0
    //   377: getfield 35	com/tencent/mobileqq/app/proxy/FTSDBManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   380: invokevirtual 300	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   383: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: ldc 194
    //   388: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   394: astore_3
    //   395: aload_0
    //   396: getfield 296	com/tencent/mobileqq/app/proxy/FTSDBManager:jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase	Lcom/tencent/mobileqq/fts/FTSDatabase;
    //   399: aload_3
    //   400: invokevirtual 302	com/tencent/mobileqq/fts/FTSDatabase:a	(Ljava/lang/String;)V
    //   403: aload_0
    //   404: getfield 35	com/tencent/mobileqq/app/proxy/FTSDBManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   407: iconst_1
    //   408: invokestatic 305	com/tencent/mobileqq/utils/fts/SQLiteFTSUtils:e	(Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   411: getstatic 259	android/os/Build$VERSION:SDK_INT	I
    //   414: bipush 18
    //   416: if_icmpge +37 -> 453
    //   419: ldc 89
    //   421: iconst_1
    //   422: new 132	java/lang/StringBuilder
    //   425: dup
    //   426: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   429: ldc_w 307
    //   432: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: iload_1
    //   436: invokevirtual 270	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   439: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: invokestatic 275	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   445: aload_0
    //   446: getfield 35	com/tencent/mobileqq/app/proxy/FTSDBManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   449: iconst_0
    //   450: invokestatic 265	com/tencent/mobileqq/utils/fts/SQLiteFTSUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;I)V
    //   453: aload_0
    //   454: getfield 31	com/tencent/mobileqq/app/proxy/FTSDBManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   457: invokevirtual 311	java/util/HashMap:keySet	()Ljava/util/Set;
    //   460: invokeinterface 317 1 0
    //   465: astore_3
    //   466: aload_3
    //   467: invokeinterface 322 1 0
    //   472: ifeq +104 -> 576
    //   475: aload_3
    //   476: invokeinterface 326 1 0
    //   481: checkcast 60	java/lang/Integer
    //   484: invokevirtual 330	java/lang/Integer:intValue	()I
    //   487: istore_1
    //   488: aload_0
    //   489: getfield 31	com/tencent/mobileqq/app/proxy/FTSDBManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   492: iload_1
    //   493: invokestatic 64	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   496: invokevirtual 334	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   499: checkcast 336	com/tencent/mobileqq/app/proxy/fts/FTSIndexOperator
    //   502: astore 4
    //   504: aload 4
    //   506: aload_0
    //   507: getfield 283	com/tencent/mobileqq/app/proxy/FTSDBManager:jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   510: aload_0
    //   511: getfield 296	com/tencent/mobileqq/app/proxy/FTSDBManager:jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase	Lcom/tencent/mobileqq/fts/FTSDatabase;
    //   514: invokevirtual 339	com/tencent/mobileqq/app/proxy/fts/FTSIndexOperator:a	(Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;Lcom/tencent/mobileqq/fts/FTSDatabase;)Z
    //   517: ifne -51 -> 466
    //   520: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   523: ifeq -293 -> 230
    //   526: ldc 89
    //   528: iconst_2
    //   529: iconst_2
    //   530: anewarray 341	java/lang/Object
    //   533: dup
    //   534: iconst_0
    //   535: ldc_w 343
    //   538: aastore
    //   539: dup
    //   540: iconst_1
    //   541: aload 4
    //   543: invokevirtual 347	java/lang/Object:getClass	()Ljava/lang/Class;
    //   546: invokevirtual 147	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   549: aastore
    //   550: invokestatic 351	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   553: return
    //   554: astore_3
    //   555: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   558: ifeq +13 -> 571
    //   561: ldc 89
    //   563: iconst_2
    //   564: ldc_w 353
    //   567: aload_3
    //   568: invokestatic 356	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   571: iconst_0
    //   572: putstatic 21	com/tencent/mobileqq/app/proxy/FTSDBManager:jdField_a_of_type_Boolean	Z
    //   575: return
    //   576: aload_0
    //   577: iconst_1
    //   578: putfield 210	com/tencent/mobileqq/app/proxy/FTSDBManager:c	Z
    //   581: return
    //   582: astore 4
    //   584: aload_3
    //   585: astore 5
    //   587: goto -333 -> 254
    //   590: iconst_0
    //   591: istore_1
    //   592: goto -304 -> 288
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	595	0	this	FTSDBManager
    //   270	322	1	i	int
    //   151	136	2	j	int
    //   36	95	3	localCursor	android.database.Cursor
    //   231	1	3	localException	java.lang.Exception
    //   247	5	3	localObject1	Object
    //   394	82	3	localObject2	Object
    //   554	31	3	localThrowable	java.lang.Throwable
    //   1	541	4	localObject3	Object
    //   582	1	4	localObject4	Object
    //   39	547	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   24	37	231	java/lang/Exception
    //   44	53	231	java/lang/Exception
    //   56	83	231	java/lang/Exception
    //   89	126	231	java/lang/Exception
    //   24	37	247	finally
    //   333	453	554	java/lang/Throwable
    //   44	53	582	finally
    //   56	83	582	finally
    //   89	126	582	finally
  }
  
  public FTSIndexOperator a(int paramInt)
  {
    return (FTSIndexOperator)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
  }
  
  public FTSMsgOperator a()
  {
    return (FTSMsgOperator)a(1);
  }
  
  public void a()
  {
    if (a()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppProxyFtsFTSSyncHandler.post(new zsc(this));
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = this.c;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.c();
    this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase.a();
  }
  
  public void b(int paramInt)
  {
    if (!this.jdField_b_of_type_Boolean) {
      ((FTSIndexOperator)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt))).d();
    }
  }
  
  public void onDestroy()
  {
    try
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqAppProxyFtsFTSSyncHandler.a();
      this.jdField_a_of_type_AndroidOsHandlerThread.quit();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        ((FTSIndexOperator)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i))).a();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase == null) {
        break label96;
      }
    }
    finally {}
    this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.b();
    label96:
    if (this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase != null) {
      this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase.a();
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.fts.manager", 2, "FTSDBManager destroy...");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.FTSDBManager
 * JD-Core Version:    0.7.0.1
 */