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

public class anux
  extends Observable
  implements Manager
{
  public static volatile boolean a;
  private int jdField_a_of_type_Int = -1;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  public anvf a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FTSDatabase jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase;
  private FTSDatatbase jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase;
  private ConcurrentHashMap<Integer, anvb> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private volatile int b;
  public volatile boolean b;
  private volatile boolean c;
  
  static
  {
    jdField_a_of_type_Boolean = true;
  }
  
  public anux(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("QQ_FTS_Sync", 3);
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_Anvf = new anvf(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(1), new anvc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Anvf));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(2), new anvg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Anvf));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(4), new anve(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Anvf));
    a();
    if (QLog.isColorLevel()) {
      QLog.i("Q.fts.manager", 2, "FTSDBManager structure...");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    bgbo.a(paramQQAppInterface, paramString);
    SQLiteDatabase localSQLiteDatabase = new QQEntityManagerFactory(paramString).build(paramString).getWritableDatabase();
    localSQLiteDatabase.execSQL("DROP TABLE IF EXISTS msg_upgrade_log;");
    localSQLiteDatabase.execSQL("DROP TABLE IF EXISTS msg_sync_log;");
    localSQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + FTSTroopSync.class.getSimpleName() + ";");
    localSQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + FTSTroopTime.class.getSimpleName() + ";");
    if (!paramBoolean) {
      paramQQAppInterface.getFTSDBManager().b();
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
    //   10: getfield 36	anux:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13: iconst_0
    //   14: invokestatic 222	bgbo:f	(Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   17: aload_0
    //   18: getfield 214	anux:c	Z
    //   21: ifne +238 -> 259
    //   24: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   27: ifeq +138 -> 165
    //   30: ldc 224
    //   32: aconst_null
    //   33: invokestatic 230	android/database/sqlite/SQLiteDatabase:openOrCreateDatabase	(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;)Landroid/database/sqlite/SQLiteDatabase;
    //   36: astore_3
    //   37: aload 6
    //   39: astore 4
    //   41: aload_3
    //   42: ldc 232
    //   44: aconst_null
    //   45: invokevirtual 236	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   48: astore 5
    //   50: ldc 238
    //   52: astore 6
    //   54: aload 5
    //   56: astore 4
    //   58: aload 5
    //   60: invokeinterface 243 1 0
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
    //   87: invokeinterface 247 2 0
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
    //   117: ldc 249
    //   119: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokestatic 254	com/tencent/mobileqq/utils/DeviceInfoUtil:getDeviceOSVersion	()Ljava/lang/String;
    //   125: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: ldc_w 256
    //   131: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: aload 6
    //   136: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 96	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   145: aload 5
    //   147: ifnull +10 -> 157
    //   150: aload 5
    //   152: invokeinterface 259 1 0
    //   157: aload_3
    //   158: ifnull +7 -> 165
    //   161: aload_3
    //   162: invokevirtual 260	android/database/sqlite/SQLiteDatabase:close	()V
    //   165: getstatic 265	android/os/Build$VERSION:SDK_INT	I
    //   168: bipush 18
    //   170: if_icmpge +573 -> 743
    //   173: aload_0
    //   174: getfield 36	anux:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   177: invokestatic 268	bgbo:f	(Lcom/tencent/mobileqq/app/QQAppInterface;)I
    //   180: istore_2
    //   181: aload_0
    //   182: getfield 36	anux:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   185: iload_2
    //   186: iconst_1
    //   187: iadd
    //   188: invokestatic 271	bgbo:b	(Lcom/tencent/mobileqq/app/QQAppInterface;I)V
    //   191: ldc 90
    //   193: iconst_1
    //   194: new 138	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   201: ldc_w 273
    //   204: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: iload_2
    //   208: invokevirtual 276	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   211: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokestatic 96	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   217: iload_2
    //   218: iconst_5
    //   219: if_icmplt +95 -> 314
    //   222: iload_2
    //   223: sipush 200
    //   226: if_icmpge +88 -> 314
    //   229: ldc 90
    //   231: iconst_1
    //   232: new 138	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   239: ldc_w 278
    //   242: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: iload_2
    //   246: invokevirtual 276	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   249: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokestatic 281	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   255: iconst_0
    //   256: putstatic 22	anux:jdField_a_of_type_Boolean	Z
    //   259: return
    //   260: astore_3
    //   261: aconst_null
    //   262: astore_3
    //   263: aload 4
    //   265: ifnull +10 -> 275
    //   268: aload 4
    //   270: invokeinterface 259 1 0
    //   275: aload_3
    //   276: ifnull -111 -> 165
    //   279: aload_3
    //   280: invokevirtual 260	android/database/sqlite/SQLiteDatabase:close	()V
    //   283: goto -118 -> 165
    //   286: astore_3
    //   287: aconst_null
    //   288: astore 4
    //   290: aload 4
    //   292: ifnull +10 -> 302
    //   295: aload 4
    //   297: invokeinterface 259 1 0
    //   302: aload 5
    //   304: ifnull +8 -> 312
    //   307: aload 5
    //   309: invokevirtual 260	android/database/sqlite/SQLiteDatabase:close	()V
    //   312: aload_3
    //   313: athrow
    //   314: iload_2
    //   315: istore_1
    //   316: iload_2
    //   317: sipush 200
    //   320: if_icmplt +13 -> 333
    //   323: aload_0
    //   324: getfield 36	anux:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   327: iconst_0
    //   328: invokestatic 271	bgbo:b	(Lcom/tencent/mobileqq/app/QQAppInterface;I)V
    //   331: iload_2
    //   332: istore_1
    //   333: aload_0
    //   334: getfield 283	anux:jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase	Lcom/tencent/mobileqq/fts/FTSDatabase;
    //   337: ifnull +10 -> 347
    //   340: aload_0
    //   341: getfield 283	anux:jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase	Lcom/tencent/mobileqq/fts/FTSDatabase;
    //   344: invokevirtual 286	com/tencent/mobileqq/fts/FTSDatabase:a	()V
    //   347: aload_0
    //   348: getfield 288	anux:jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   351: ifnull +10 -> 361
    //   354: aload_0
    //   355: getfield 288	anux:jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   358: invokevirtual 291	com/tencent/mobileqq/persistence/fts/FTSDatatbase:b	()V
    //   361: ldc 90
    //   363: iconst_1
    //   364: ldc_w 293
    //   367: invokestatic 96	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   370: aload_0
    //   371: new 290	com/tencent/mobileqq/persistence/fts/FTSDatatbase
    //   374: dup
    //   375: aload_0
    //   376: getfield 36	anux:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   379: invokespecial 295	com/tencent/mobileqq/persistence/fts/FTSDatatbase:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   382: putfield 288	anux:jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   385: new 297	atvb
    //   388: dup
    //   389: invokespecial 298	atvb:<init>	()V
    //   392: invokestatic 301	com/tencent/mobileqq/fts/FTSDatabase:a	(Latuz;)V
    //   395: aload_0
    //   396: new 303	atuv
    //   399: dup
    //   400: invokespecial 304	atuv:<init>	()V
    //   403: putfield 283	anux:jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase	Lcom/tencent/mobileqq/fts/FTSDatabase;
    //   406: aload_0
    //   407: getfield 288	anux:jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   410: invokevirtual 305	com/tencent/mobileqq/persistence/fts/FTSDatatbase:a	()V
    //   413: new 138	java/lang/StringBuilder
    //   416: dup
    //   417: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   420: aload_0
    //   421: getfield 36	anux:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   424: invokevirtual 176	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   427: invokevirtual 182	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   430: invokevirtual 185	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   433: ldc 187
    //   435: ldc 189
    //   437: invokevirtual 195	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   440: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: getstatic 199	java/io/File:separator	Ljava/lang/String;
    //   446: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: aload_0
    //   450: getfield 36	anux:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   453: invokevirtual 308	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   456: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: ldc 201
    //   461: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   467: astore_3
    //   468: aload_0
    //   469: getfield 283	anux:jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase	Lcom/tencent/mobileqq/fts/FTSDatabase;
    //   472: aload_3
    //   473: invokevirtual 310	com/tencent/mobileqq/fts/FTSDatabase:a	(Ljava/lang/String;)V
    //   476: aload_0
    //   477: getfield 36	anux:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   480: iconst_1
    //   481: invokestatic 313	bgbo:e	(Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   484: getstatic 265	android/os/Build$VERSION:SDK_INT	I
    //   487: bipush 18
    //   489: if_icmpge +37 -> 526
    //   492: ldc 90
    //   494: iconst_1
    //   495: new 138	java/lang/StringBuilder
    //   498: dup
    //   499: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   502: ldc_w 315
    //   505: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: iload_1
    //   509: invokevirtual 276	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   512: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   515: invokestatic 281	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   518: aload_0
    //   519: getfield 36	anux:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   522: iconst_0
    //   523: invokestatic 271	bgbo:b	(Lcom/tencent/mobileqq/app/QQAppInterface;I)V
    //   526: aload_0
    //   527: getfield 32	anux:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   530: invokevirtual 319	java/util/concurrent/ConcurrentHashMap:keySet	()Ljava/util/Set;
    //   533: invokeinterface 325 1 0
    //   538: astore_3
    //   539: aload_3
    //   540: invokeinterface 330 1 0
    //   545: ifeq +158 -> 703
    //   548: aload_3
    //   549: invokeinterface 334 1 0
    //   554: checkcast 61	java/lang/Integer
    //   557: invokevirtual 338	java/lang/Integer:intValue	()I
    //   560: istore_1
    //   561: aload_0
    //   562: getfield 32	anux:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   565: iload_1
    //   566: invokestatic 65	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   569: invokevirtual 342	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   572: checkcast 344	anvb
    //   575: astore 4
    //   577: aload 4
    //   579: ifnonnull +74 -> 653
    //   582: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   585: ifeq -326 -> 259
    //   588: ldc 90
    //   590: iconst_2
    //   591: iconst_4
    //   592: anewarray 346	java/lang/Object
    //   595: dup
    //   596: iconst_0
    //   597: ldc_w 348
    //   600: aastore
    //   601: dup
    //   602: iconst_1
    //   603: iload_1
    //   604: invokestatic 65	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   607: aastore
    //   608: dup
    //   609: iconst_2
    //   610: ldc_w 350
    //   613: aastore
    //   614: dup
    //   615: iconst_3
    //   616: aload_0
    //   617: getfield 32	anux:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   620: invokevirtual 353	java/util/concurrent/ConcurrentHashMap:size	()I
    //   623: invokestatic 65	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   626: aastore
    //   627: invokestatic 357	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   630: return
    //   631: astore_3
    //   632: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   635: ifeq +13 -> 648
    //   638: ldc 90
    //   640: iconst_2
    //   641: ldc_w 359
    //   644: aload_3
    //   645: invokestatic 362	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   648: iconst_0
    //   649: putstatic 22	anux:jdField_a_of_type_Boolean	Z
    //   652: return
    //   653: aload 4
    //   655: aload_0
    //   656: getfield 288	anux:jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   659: aload_0
    //   660: getfield 283	anux:jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase	Lcom/tencent/mobileqq/fts/FTSDatabase;
    //   663: invokevirtual 365	anvb:a	(Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;Lcom/tencent/mobileqq/fts/FTSDatabase;)Z
    //   666: ifne -127 -> 539
    //   669: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   672: ifeq -413 -> 259
    //   675: ldc 90
    //   677: iconst_2
    //   678: iconst_2
    //   679: anewarray 346	java/lang/Object
    //   682: dup
    //   683: iconst_0
    //   684: ldc_w 367
    //   687: aastore
    //   688: dup
    //   689: iconst_1
    //   690: aload 4
    //   692: invokevirtual 371	java/lang/Object:getClass	()Ljava/lang/Class;
    //   695: invokevirtual 153	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   698: aastore
    //   699: invokestatic 357	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   702: return
    //   703: aload_0
    //   704: iconst_1
    //   705: putfield 214	anux:c	Z
    //   708: return
    //   709: astore 6
    //   711: aconst_null
    //   712: astore 4
    //   714: aload_3
    //   715: astore 5
    //   717: aload 6
    //   719: astore_3
    //   720: goto -430 -> 290
    //   723: astore 6
    //   725: aload 5
    //   727: astore 4
    //   729: aload_3
    //   730: astore 5
    //   732: aload 6
    //   734: astore_3
    //   735: goto -445 -> 290
    //   738: astore 5
    //   740: goto -477 -> 263
    //   743: iconst_0
    //   744: istore_1
    //   745: goto -412 -> 333
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	748	0	this	anux
    //   315	430	1	i	int
    //   180	152	2	j	int
    //   36	126	3	localSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    //   260	1	3	localException1	java.lang.Exception
    //   262	18	3	localObject1	Object
    //   286	27	3	localObject2	Object
    //   467	82	3	localObject3	Object
    //   631	84	3	localThrowable	java.lang.Throwable
    //   719	16	3	localObject4	Object
    //   7	721	4	localObject5	Object
    //   1	730	5	localObject6	Object
    //   738	1	5	localException2	java.lang.Exception
    //   4	131	6	str	String
    //   709	9	6	localObject7	Object
    //   723	10	6	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   30	37	260	java/lang/Exception
    //   30	37	286	finally
    //   406	526	631	java/lang/Throwable
    //   41	50	709	finally
    //   58	68	723	finally
    //   72	100	723	finally
    //   107	145	723	finally
    //   41	50	738	java/lang/Exception
    //   58	68	738	java/lang/Exception
    //   72	100	738	java/lang/Exception
    //   107	145	738	java/lang/Exception
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
  
  public anvb a(int paramInt)
  {
    return (anvb)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
  }
  
  public anvc a()
  {
    return (anvc)a(1);
  }
  
  public void a()
  {
    if (a()) {
      return;
    }
    this.jdField_a_of_type_Anvf.post(new FTSDBManager.1(this));
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
      ((anvb)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt))).d();
    }
  }
  
  public void onDestroy()
  {
    try
    {
      this.jdField_b_of_type_Boolean = true;
      this.c = false;
      this.jdField_a_of_type_Anvf.a();
      this.jdField_a_of_type_AndroidOsHandlerThread.quit();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        ((anvb)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i))).a();
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
 * Qualified Name:     anux
 * JD-Core Version:    0.7.0.1
 */