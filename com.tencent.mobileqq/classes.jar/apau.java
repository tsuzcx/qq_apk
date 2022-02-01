import android.os.HandlerThread;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.app.proxy.FTSDBManager.1;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.fts.FTSTroopSync;
import com.tencent.mobileqq.data.fts.FTSTroopTime;
import com.tencent.mobileqq.fts.FTSDatabase;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.fts.FTSDatatbase;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.Observable;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class apau
  extends Observable
  implements Manager
{
  public static volatile boolean a;
  private int jdField_a_of_type_Int = -1;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  public apbc a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FTSDatabase jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase;
  private FTSDatatbase jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase;
  private ConcurrentHashMap<Integer, apay> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private volatile int b;
  public volatile boolean b;
  private volatile boolean c;
  
  static
  {
    jdField_a_of_type_Boolean = true;
  }
  
  public apau(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("QQ_FTS_Sync", 3);
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_Apbc = new apbc(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(1), new apaz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Apbc));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(2), new apbd(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Apbc));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(4), new apbb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Apbc));
    a();
    if (QLog.isColorLevel()) {
      QLog.i("Q.fts.manager", 2, "FTSDBManager structure...");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    bhut.a(paramQQAppInterface, paramString);
    SQLiteDatabase localSQLiteDatabase = new QQEntityManagerFactory(paramString).build(paramString).getWritableDatabase();
    localSQLiteDatabase.execSQL("DROP TABLE IF EXISTS msg_upgrade_log;");
    localSQLiteDatabase.execSQL("DROP TABLE IF EXISTS msg_sync_log;");
    localSQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + FTSTroopSync.class.getSimpleName() + ";");
    localSQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + FTSTroopTime.class.getSimpleName() + ";");
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
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 4
    //   9: aload_0
    //   10: getfield 36	apau:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13: iconst_0
    //   14: invokestatic 221	bhut:f	(Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   17: aload_0
    //   18: getfield 213	apau:c	Z
    //   21: ifne +237 -> 258
    //   24: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   27: ifeq +137 -> 164
    //   30: ldc 223
    //   32: aconst_null
    //   33: invokestatic 229	android/database/sqlite/SQLiteDatabase:openOrCreateDatabase	(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;)Landroid/database/sqlite/SQLiteDatabase;
    //   36: astore_3
    //   37: aload 6
    //   39: astore 4
    //   41: aload_3
    //   42: ldc 231
    //   44: aconst_null
    //   45: invokevirtual 235	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   48: astore 5
    //   50: ldc 237
    //   52: astore 6
    //   54: aload 5
    //   56: astore 4
    //   58: aload 5
    //   60: invokeinterface 242 1 0
    //   65: ifeq +38 -> 103
    //   68: aload 5
    //   70: astore 4
    //   72: new 138	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   79: aload 6
    //   81: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload 5
    //   86: iconst_0
    //   87: invokeinterface 246 2 0
    //   92: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: astore 6
    //   100: goto -46 -> 54
    //   103: aload 5
    //   105: astore 4
    //   107: ldc 90
    //   109: iconst_2
    //   110: new 138	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   117: ldc 248
    //   119: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokestatic 253	bhlo:e	()Ljava/lang/String;
    //   125: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: ldc 255
    //   130: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: aload 6
    //   135: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokestatic 96	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   144: aload 5
    //   146: ifnull +10 -> 156
    //   149: aload 5
    //   151: invokeinterface 258 1 0
    //   156: aload_3
    //   157: ifnull +7 -> 164
    //   160: aload_3
    //   161: invokevirtual 259	android/database/sqlite/SQLiteDatabase:close	()V
    //   164: getstatic 264	android/os/Build$VERSION:SDK_INT	I
    //   167: bipush 18
    //   169: if_icmpge +573 -> 742
    //   172: aload_0
    //   173: getfield 36	apau:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   176: invokestatic 267	bhut:f	(Lcom/tencent/mobileqq/app/QQAppInterface;)I
    //   179: istore_2
    //   180: aload_0
    //   181: getfield 36	apau:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   184: iload_2
    //   185: iconst_1
    //   186: iadd
    //   187: invokestatic 270	bhut:b	(Lcom/tencent/mobileqq/app/QQAppInterface;I)V
    //   190: ldc 90
    //   192: iconst_1
    //   193: new 138	java/lang/StringBuilder
    //   196: dup
    //   197: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   200: ldc_w 272
    //   203: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: iload_2
    //   207: invokevirtual 275	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   210: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokestatic 96	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   216: iload_2
    //   217: iconst_5
    //   218: if_icmplt +95 -> 313
    //   221: iload_2
    //   222: sipush 200
    //   225: if_icmpge +88 -> 313
    //   228: ldc 90
    //   230: iconst_1
    //   231: new 138	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   238: ldc_w 277
    //   241: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: iload_2
    //   245: invokevirtual 275	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   248: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: invokestatic 280	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   254: iconst_0
    //   255: putstatic 22	apau:jdField_a_of_type_Boolean	Z
    //   258: return
    //   259: astore_3
    //   260: aconst_null
    //   261: astore_3
    //   262: aload 4
    //   264: ifnull +10 -> 274
    //   267: aload 4
    //   269: invokeinterface 258 1 0
    //   274: aload_3
    //   275: ifnull -111 -> 164
    //   278: aload_3
    //   279: invokevirtual 259	android/database/sqlite/SQLiteDatabase:close	()V
    //   282: goto -118 -> 164
    //   285: astore_3
    //   286: aconst_null
    //   287: astore 4
    //   289: aload 4
    //   291: ifnull +10 -> 301
    //   294: aload 4
    //   296: invokeinterface 258 1 0
    //   301: aload 5
    //   303: ifnull +8 -> 311
    //   306: aload 5
    //   308: invokevirtual 259	android/database/sqlite/SQLiteDatabase:close	()V
    //   311: aload_3
    //   312: athrow
    //   313: iload_2
    //   314: istore_1
    //   315: iload_2
    //   316: sipush 200
    //   319: if_icmplt +13 -> 332
    //   322: aload_0
    //   323: getfield 36	apau:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   326: iconst_0
    //   327: invokestatic 270	bhut:b	(Lcom/tencent/mobileqq/app/QQAppInterface;I)V
    //   330: iload_2
    //   331: istore_1
    //   332: aload_0
    //   333: getfield 282	apau:jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase	Lcom/tencent/mobileqq/fts/FTSDatabase;
    //   336: ifnull +10 -> 346
    //   339: aload_0
    //   340: getfield 282	apau:jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase	Lcom/tencent/mobileqq/fts/FTSDatabase;
    //   343: invokevirtual 285	com/tencent/mobileqq/fts/FTSDatabase:a	()V
    //   346: aload_0
    //   347: getfield 287	apau:jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   350: ifnull +10 -> 360
    //   353: aload_0
    //   354: getfield 287	apau:jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   357: invokevirtual 290	com/tencent/mobileqq/persistence/fts/FTSDatatbase:b	()V
    //   360: ldc 90
    //   362: iconst_1
    //   363: ldc_w 292
    //   366: invokestatic 96	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   369: aload_0
    //   370: new 289	com/tencent/mobileqq/persistence/fts/FTSDatatbase
    //   373: dup
    //   374: aload_0
    //   375: getfield 36	apau:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   378: invokespecial 294	com/tencent/mobileqq/persistence/fts/FTSDatatbase:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   381: putfield 287	apau:jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   384: new 296	avhv
    //   387: dup
    //   388: invokespecial 297	avhv:<init>	()V
    //   391: invokestatic 300	com/tencent/mobileqq/fts/FTSDatabase:a	(Lavht;)V
    //   394: aload_0
    //   395: new 302	avhp
    //   398: dup
    //   399: invokespecial 303	avhp:<init>	()V
    //   402: putfield 282	apau:jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase	Lcom/tencent/mobileqq/fts/FTSDatabase;
    //   405: aload_0
    //   406: getfield 287	apau:jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   409: invokevirtual 304	com/tencent/mobileqq/persistence/fts/FTSDatatbase:a	()V
    //   412: new 138	java/lang/StringBuilder
    //   415: dup
    //   416: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   419: aload_0
    //   420: getfield 36	apau:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   423: invokevirtual 175	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   426: invokevirtual 181	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   429: invokevirtual 184	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   432: ldc 186
    //   434: ldc 188
    //   436: invokevirtual 194	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   439: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: getstatic 198	java/io/File:separator	Ljava/lang/String;
    //   445: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: aload_0
    //   449: getfield 36	apau:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   452: invokevirtual 307	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   455: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: ldc 200
    //   460: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   466: astore_3
    //   467: aload_0
    //   468: getfield 282	apau:jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase	Lcom/tencent/mobileqq/fts/FTSDatabase;
    //   471: aload_3
    //   472: invokevirtual 309	com/tencent/mobileqq/fts/FTSDatabase:a	(Ljava/lang/String;)V
    //   475: aload_0
    //   476: getfield 36	apau:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   479: iconst_1
    //   480: invokestatic 311	bhut:e	(Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   483: getstatic 264	android/os/Build$VERSION:SDK_INT	I
    //   486: bipush 18
    //   488: if_icmpge +37 -> 525
    //   491: ldc 90
    //   493: iconst_1
    //   494: new 138	java/lang/StringBuilder
    //   497: dup
    //   498: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   501: ldc_w 313
    //   504: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: iload_1
    //   508: invokevirtual 275	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   511: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   514: invokestatic 280	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   517: aload_0
    //   518: getfield 36	apau:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   521: iconst_0
    //   522: invokestatic 270	bhut:b	(Lcom/tencent/mobileqq/app/QQAppInterface;I)V
    //   525: aload_0
    //   526: getfield 32	apau:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   529: invokevirtual 317	java/util/concurrent/ConcurrentHashMap:keySet	()Ljava/util/Set;
    //   532: invokeinterface 323 1 0
    //   537: astore_3
    //   538: aload_3
    //   539: invokeinterface 328 1 0
    //   544: ifeq +158 -> 702
    //   547: aload_3
    //   548: invokeinterface 332 1 0
    //   553: checkcast 61	java/lang/Integer
    //   556: invokevirtual 336	java/lang/Integer:intValue	()I
    //   559: istore_1
    //   560: aload_0
    //   561: getfield 32	apau:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   564: iload_1
    //   565: invokestatic 65	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   568: invokevirtual 340	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   571: checkcast 342	apay
    //   574: astore 4
    //   576: aload 4
    //   578: ifnonnull +74 -> 652
    //   581: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   584: ifeq -326 -> 258
    //   587: ldc 90
    //   589: iconst_2
    //   590: iconst_4
    //   591: anewarray 344	java/lang/Object
    //   594: dup
    //   595: iconst_0
    //   596: ldc_w 346
    //   599: aastore
    //   600: dup
    //   601: iconst_1
    //   602: iload_1
    //   603: invokestatic 65	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   606: aastore
    //   607: dup
    //   608: iconst_2
    //   609: ldc_w 348
    //   612: aastore
    //   613: dup
    //   614: iconst_3
    //   615: aload_0
    //   616: getfield 32	apau:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   619: invokevirtual 351	java/util/concurrent/ConcurrentHashMap:size	()I
    //   622: invokestatic 65	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   625: aastore
    //   626: invokestatic 355	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   629: return
    //   630: astore_3
    //   631: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   634: ifeq +13 -> 647
    //   637: ldc 90
    //   639: iconst_2
    //   640: ldc_w 357
    //   643: aload_3
    //   644: invokestatic 360	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   647: iconst_0
    //   648: putstatic 22	apau:jdField_a_of_type_Boolean	Z
    //   651: return
    //   652: aload 4
    //   654: aload_0
    //   655: getfield 287	apau:jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   658: aload_0
    //   659: getfield 282	apau:jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase	Lcom/tencent/mobileqq/fts/FTSDatabase;
    //   662: invokevirtual 363	apay:a	(Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;Lcom/tencent/mobileqq/fts/FTSDatabase;)Z
    //   665: ifne -127 -> 538
    //   668: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   671: ifeq -413 -> 258
    //   674: ldc 90
    //   676: iconst_2
    //   677: iconst_2
    //   678: anewarray 344	java/lang/Object
    //   681: dup
    //   682: iconst_0
    //   683: ldc_w 365
    //   686: aastore
    //   687: dup
    //   688: iconst_1
    //   689: aload 4
    //   691: invokevirtual 369	java/lang/Object:getClass	()Ljava/lang/Class;
    //   694: invokevirtual 153	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   697: aastore
    //   698: invokestatic 355	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   701: return
    //   702: aload_0
    //   703: iconst_1
    //   704: putfield 213	apau:c	Z
    //   707: return
    //   708: astore 6
    //   710: aconst_null
    //   711: astore 4
    //   713: aload_3
    //   714: astore 5
    //   716: aload 6
    //   718: astore_3
    //   719: goto -430 -> 289
    //   722: astore 6
    //   724: aload 5
    //   726: astore 4
    //   728: aload_3
    //   729: astore 5
    //   731: aload 6
    //   733: astore_3
    //   734: goto -445 -> 289
    //   737: astore 5
    //   739: goto -477 -> 262
    //   742: iconst_0
    //   743: istore_1
    //   744: goto -412 -> 332
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	747	0	this	apau
    //   314	430	1	i	int
    //   179	152	2	j	int
    //   36	125	3	localSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    //   259	1	3	localException1	java.lang.Exception
    //   261	18	3	localObject1	Object
    //   285	27	3	localObject2	Object
    //   466	82	3	localObject3	Object
    //   630	84	3	localThrowable	java.lang.Throwable
    //   718	16	3	localObject4	Object
    //   7	720	4	localObject5	Object
    //   1	729	5	localObject6	Object
    //   737	1	5	localException2	java.lang.Exception
    //   4	130	6	str	String
    //   708	9	6	localObject7	Object
    //   722	10	6	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   30	37	259	java/lang/Exception
    //   30	37	285	finally
    //   405	525	630	java/lang/Throwable
    //   41	50	708	finally
    //   58	68	722	finally
    //   72	100	722	finally
    //   107	144	722	finally
    //   41	50	737	java/lang/Exception
    //   58	68	737	java/lang/Exception
    //   72	100	737	java/lang/Exception
    //   107	144	737	java/lang/Exception
  }
  
  public long a()
  {
    long l = 0L;
    File localFile = new File(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getFilesDir().getAbsolutePath().replace("files", "databases") + File.separator + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "-IndexQQMsg.db");
    if (localFile.exists()) {
      l = localFile.length();
    }
    return l;
  }
  
  public apay a(int paramInt)
  {
    return (apay)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
  }
  
  public apaz a()
  {
    return (apaz)a(1);
  }
  
  public void a()
  {
    if (a()) {
      return;
    }
    this.jdField_a_of_type_Apbc.post(new FTSDBManager.1(this));
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
      ((apay)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt))).d();
    }
  }
  
  public void onDestroy()
  {
    try
    {
      this.jdField_b_of_type_Boolean = true;
      this.c = false;
      this.jdField_a_of_type_Apbc.a();
      this.jdField_a_of_type_AndroidOsHandlerThread.quit();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        ((apay)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i))).a();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase == null) {
        break label101;
      }
    }
    finally {}
    this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.b();
    label101:
    if (this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase != null) {
      this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase.a();
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.fts.manager", 2, "FTSDBManager destroy...");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apau
 * JD-Core Version:    0.7.0.1
 */