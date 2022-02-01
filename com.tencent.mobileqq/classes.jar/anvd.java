import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.proxy.fts.FTSMsgUpgrader.1;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.fts.FTSDatatbase;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class anvd
  implements anvi
{
  private int jdField_a_of_type_Int;
  private anvc jdField_a_of_type_Anvc;
  private anvf jdField_a_of_type_Anvf;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FTSDatatbase jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase;
  public boolean a;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  
  anvd(QQAppInterface paramQQAppInterface, anvc paramanvc)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Anvc = paramanvc;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase = this.jdField_a_of_type_Anvc.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase;
    this.jdField_a_of_type_Anvf = this.jdField_a_of_type_Anvc.jdField_a_of_type_Anvf;
  }
  
  private int a(SQLiteDatabase paramSQLiteDatabase)
  {
    for (;;)
    {
      try
      {
        paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT max(id) AS MAX_ID FROM msg_upgrade_log;", null);
        int j;
        if ((paramSQLiteDatabase != null) && (paramSQLiteDatabase.getCount() == 1))
        {
          paramSQLiteDatabase.moveToNext();
          i = paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndex("MAX_ID"));
          j = i;
          if (paramSQLiteDatabase == null) {}
        }
        int i = -1;
      }
      catch (Exception paramSQLiteDatabase)
      {
        try
        {
          paramSQLiteDatabase.close();
          j = i;
          return j;
        }
        catch (Exception paramSQLiteDatabase)
        {
          continue;
        }
        paramSQLiteDatabase = paramSQLiteDatabase;
        i = -1;
        paramSQLiteDatabase.printStackTrace();
        j = i;
        if (QLog.isColorLevel())
        {
          QLog.e("Q.fts.FTSMsgUpgrader", 2, "startUpgradeTableStep: ", paramSQLiteDatabase);
          return i;
        }
      }
      finally {}
    }
  }
  
  private long a(long paramLong1, String paramString, long paramLong2, SQLiteDatabase paramSQLiteDatabase)
  {
    if (paramLong1 != -1L)
    {
      paramString = new ContentValues();
      paramString.put("MAX_ID", Long.valueOf(paramLong2));
      return paramSQLiteDatabase.update("msg_upgrade_log", paramString, "id=?", new String[] { String.valueOf(paramLong1) });
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("tablename", paramString);
    localContentValues.put("MAX_ID", Long.valueOf(paramLong2));
    return paramSQLiteDatabase.insert("msg_upgrade_log", null, localContentValues);
  }
  
  private List<MessageRecord> a(SQLiteDatabase paramSQLiteDatabase, aybg paramaybg)
  {
    Object localObject2 = null;
    long l = -1L;
    Object localObject1 = paramSQLiteDatabase.rawQuery("SELECT tablename, MAX_ID FROM msg_upgrade_log WHERE id=?;", new String[] { String.valueOf(this.jdField_b_of_type_Int + 1) });
    if ((localObject1 != null) && (((Cursor)localObject1).getCount() == 1))
    {
      ((Cursor)localObject1).moveToNext();
      paramSQLiteDatabase = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("tablename"));
      l = ((Cursor)localObject1).getLong(((Cursor)localObject1).getColumnIndex("MAX_ID"));
      if (localObject1 != null) {
        ((Cursor)localObject1).close();
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.fts.FTSMsgUpgrader", 2, "writeNativeIndex tableName=" + paramSQLiteDatabase + " maxId=" + l);
      }
      localObject1 = localObject2;
      if (paramSQLiteDatabase != null)
      {
        localObject1 = localObject2;
        if (l > 0L)
        {
          localObject1 = "SELECT * FROM " + paramSQLiteDatabase + " WHERE _id<=?;";
          if (QLog.isColorLevel()) {
            QLog.d("Q.fts.FTSMsgUpgrader", 2, "UpgradeThread: SELECT * FROM " + paramSQLiteDatabase + " WHERE _id<=" + l + ";");
          }
          paramSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          localObject1 = paramaybg.a((String)localObject1, new String[] { String.valueOf(l) }, paramSQLiteDatabase);
          if (QLog.isColorLevel())
          {
            paramaybg = new StringBuilder().append("UpgradeThread: list size = ");
            if (localObject1 != null) {
              break label345;
            }
          }
        }
      }
    }
    label345:
    for (paramSQLiteDatabase = "null";; paramSQLiteDatabase = Integer.valueOf(((List)localObject1).size()))
    {
      QLog.d("Q.fts.FTSMsgUpgrader", 2, paramSQLiteDatabase);
      return localObject1;
      if (QLog.isColorLevel()) {
        QLog.d("Q.fts.FTSMsgUpgrader", 2, "UpgradeThread: rowid=" + (this.jdField_b_of_type_Int + 1) + " failure");
      }
      paramSQLiteDatabase = null;
      break;
    }
  }
  
  private boolean a(SQLiteDatabase paramSQLiteDatabase)
  {
    boolean bool1 = true;
    for (;;)
    {
      try
      {
        paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT * FROM sqlite_master WHERE tbl_name='msg_upgrade_log';", null);
        boolean bool2;
        if (paramSQLiteDatabase != null)
        {
          int i = paramSQLiteDatabase.getCount();
          if (i == 1)
          {
            bool2 = bool1;
            if (paramSQLiteDatabase == null) {}
          }
        }
        bool1 = false;
      }
      catch (Exception paramSQLiteDatabase)
      {
        try
        {
          paramSQLiteDatabase.close();
          bool2 = bool1;
          return bool2;
        }
        catch (Exception paramSQLiteDatabase)
        {
          continue;
        }
        paramSQLiteDatabase = paramSQLiteDatabase;
        bool1 = false;
        paramSQLiteDatabase.printStackTrace();
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          QLog.e("Q.fts.FTSMsgUpgrader", 2, "startUpgradeTableStep: ", paramSQLiteDatabase);
          return bool1;
        }
      }
      finally {}
    }
  }
  
  private void b()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_table", String.valueOf(bgbo.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)));
    localHashMap.put("param_msg", String.valueOf(bgbo.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)));
    StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).collectPerformance(null, "actFTSUpgradeCost", true, bgbo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), 0L, localHashMap, null, false);
    bgbo.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts.FTSMsgUpgrader", 2, "========== upgrade table complete, cost =" + bgbo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) + "us, tables = " + bgbo.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) + ", msgs = " + bgbo.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    }
  }
  
  private void c()
  {
    long l1 = bgbo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    long l2 = System.nanoTime();
    if (!this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.b("UpgradeCursor"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.fts.FTSMsgUpgrader", 2, "startUpgradeTableStep: upgradeCursorTable has not exist");
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.a("UpgradeCursor"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.fts.FTSMsgUpgrader", 2, "startUpgradeTableStep: create upgradeCursorTable failure");
        }
        return;
      }
    }
    for (int i = 0;; i = -1)
    {
      int j = i;
      if (i != 1) {
        j = this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.a("UpgradeCursor");
      }
      if (j == -1)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.fts.FTSMsgUpgrader", 2, "startUpgradeTableStep: curCursor == -1");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.fts.FTSMsgUpgrader", 2, "startUpgradeTableStep: curCursor = " + j);
      }
      this.jdField_b_of_type_Int = j;
      l2 = (System.nanoTime() - l2) / 1000L;
      bgbo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l1, l2);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
  }
  
  private boolean c()
  {
    if (bgbo.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != 1) {
      return false;
    }
    if (bgbo.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      QLog.d("Q.fts.FTSMsgUpgrader", 1, "========== upgrade table has complete");
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts.FTSMsgUpgrader", 2, "========== upgrade table start");
    }
    long l1 = bgbo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    long l2 = System.nanoTime();
    if (!a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getReadableDatabase()))
    {
      QLog.d("Q.fts.FTSMsgUpgrader", 1, "startUpgradeTableStep: msg_upgrade_log has not exist");
      b();
      return true;
    }
    int i = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getReadableDatabase());
    if (i == -1)
    {
      QLog.d("Q.fts.FTSMsgUpgrader", 1, "startUpgradeTableStep: query msg_upgrade_log MAX(id) failure");
      b();
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts.FTSMsgUpgrader", 2, "startUpgradeTableStep: maxIndex = " + i);
    }
    this.jdField_a_of_type_Int = i;
    l2 = (System.nanoTime() - l2) / 1000L;
    bgbo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l1, l2);
    this.jdField_a_of_type_Anvf.post(new FTSMsgUpgrader.1(this));
    return false;
  }
  
  /* Error */
  private boolean d()
  {
    // Byte code:
    //   0: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 81
    //   8: iconst_2
    //   9: ldc_w 337
    //   12: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aconst_null
    //   16: astore 8
    //   18: aconst_null
    //   19: astore 10
    //   21: new 339	java/util/ArrayList
    //   24: dup
    //   25: sipush 512
    //   28: invokespecial 342	java/util/ArrayList:<init>	(I)V
    //   31: astore 11
    //   33: aload_0
    //   34: getfield 23	anvd:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   37: invokestatic 227	bgbo:c	(Lcom/tencent/mobileqq/app/QQAppInterface;)I
    //   40: istore_1
    //   41: aload_0
    //   42: getfield 23	anvd:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   45: invokestatic 234	bgbo:d	(Lcom/tencent/mobileqq/app/QQAppInterface;)I
    //   48: istore_2
    //   49: aload_0
    //   50: getfield 23	anvd:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   53: invokestatic 251	bgbo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)J
    //   56: lstore 4
    //   58: invokestatic 274	java/lang/System:nanoTime	()J
    //   61: lstore 6
    //   63: aload_0
    //   64: getfield 23	anvd:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   67: invokevirtual 346	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   70: invokevirtual 352	com/tencent/mobileqq/data/QQEntityManagerFactory:createMessageRecordEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   73: checkcast 176	aybg
    //   76: astore 9
    //   78: aload_0
    //   79: aload_0
    //   80: getfield 23	anvd:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   83: invokevirtual 311	com/tencent/mobileqq/app/QQAppInterface:getReadableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   86: aload 9
    //   88: invokespecial 354	anvd:a	(Lcom/tencent/mobileqq/app/SQLiteDatabase;Laybg;)Ljava/util/List;
    //   91: astore 8
    //   93: aload 8
    //   95: ifnull +205 -> 300
    //   98: aload 8
    //   100: invokeinterface 357 1 0
    //   105: ifne +195 -> 300
    //   108: aload 8
    //   110: invokeinterface 361 1 0
    //   115: astore 8
    //   117: aload 8
    //   119: invokeinterface 366 1 0
    //   124: ifeq +176 -> 300
    //   127: aload 8
    //   129: invokeinterface 370 1 0
    //   134: checkcast 372	com/tencent/mobileqq/data/MessageRecord
    //   137: astore 10
    //   139: aload 10
    //   141: invokevirtual 375	com/tencent/mobileqq/data/MessageRecord:isSupportFTS	()Z
    //   144: ifeq -27 -> 117
    //   147: aload 10
    //   149: getfield 378	com/tencent/mobileqq/data/MessageRecord:isValid	Z
    //   152: ifeq -35 -> 117
    //   155: aload 10
    //   157: getfield 381	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   160: sipush -2006
    //   163: if_icmpeq -46 -> 117
    //   166: aload 10
    //   168: invokestatic 386	com/tencent/mobileqq/utils/fts/FTSMessageCodec:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Lcom/tencent/mobileqq/data/fts/FTSMessage;
    //   171: astore 10
    //   173: aload 10
    //   175: ifnull -58 -> 117
    //   178: aload 10
    //   180: invokevirtual 391	com/tencent/mobileqq/data/fts/FTSMessage:insertOpt	()V
    //   183: aload 10
    //   185: invokevirtual 394	com/tencent/mobileqq/data/fts/FTSMessage:preWrite	()V
    //   188: aload 11
    //   190: aload 10
    //   192: invokevirtual 398	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   195: pop
    //   196: goto -79 -> 117
    //   199: astore 8
    //   201: aload 8
    //   203: invokevirtual 399	java/lang/Throwable:printStackTrace	()V
    //   206: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   209: ifeq +30 -> 239
    //   212: ldc 81
    //   214: iconst_2
    //   215: new 144	java/lang/StringBuilder
    //   218: dup
    //   219: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   222: ldc_w 401
    //   225: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: aload 8
    //   230: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokestatic 403	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   239: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   242: ifeq +46 -> 288
    //   245: ldc 81
    //   247: iconst_2
    //   248: new 144	java/lang/StringBuilder
    //   251: dup
    //   252: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   255: ldc_w 405
    //   258: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: aload 11
    //   263: invokevirtual 406	java/util/ArrayList:size	()I
    //   266: invokevirtual 191	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   269: ldc_w 408
    //   272: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: aload_0
    //   276: getfield 37	anvd:jdField_b_of_type_Int	I
    //   279: invokevirtual 191	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   282: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   288: aload 9
    //   290: ifnull +8 -> 298
    //   293: aload 9
    //   295: invokevirtual 409	aybg:close	()V
    //   298: iconst_0
    //   299: ireturn
    //   300: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   303: ifeq +46 -> 349
    //   306: ldc 81
    //   308: iconst_2
    //   309: new 144	java/lang/StringBuilder
    //   312: dup
    //   313: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   316: ldc_w 405
    //   319: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: aload 11
    //   324: invokevirtual 406	java/util/ArrayList:size	()I
    //   327: invokevirtual 191	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   330: ldc_w 408
    //   333: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: aload_0
    //   337: getfield 37	anvd:jdField_b_of_type_Int	I
    //   340: invokevirtual 191	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   343: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   346: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   349: aload 9
    //   351: ifnull +8 -> 359
    //   354: aload 9
    //   356: invokevirtual 409	aybg:close	()V
    //   359: aload_0
    //   360: getfield 30	anvd:jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   363: aload 11
    //   365: iconst_1
    //   366: invokevirtual 412	com/tencent/mobileqq/persistence/fts/FTSDatatbase:a	(Ljava/util/ArrayList;I)I
    //   369: iconst_m1
    //   370: if_icmpne +137 -> 507
    //   373: ldc2_w 413
    //   376: invokestatic 420	java/lang/Thread:sleep	(J)V
    //   379: aload_0
    //   380: getfield 30	anvd:jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   383: aload 11
    //   385: iconst_1
    //   386: invokevirtual 412	com/tencent/mobileqq/persistence/fts/FTSDatatbase:a	(Ljava/util/ArrayList;I)I
    //   389: istore_3
    //   390: invokestatic 274	java/lang/System:nanoTime	()J
    //   393: lload 6
    //   395: lsub
    //   396: ldc2_w 294
    //   399: ldiv
    //   400: lstore 6
    //   402: aload_0
    //   403: getfield 23	anvd:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   406: lload 4
    //   408: lload 6
    //   410: invokestatic 298	bgbo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JJ)J
    //   413: pop2
    //   414: iload_3
    //   415: iconst_m1
    //   416: if_icmpne +55 -> 471
    //   419: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   422: ifeq +12 -> 434
    //   425: ldc 81
    //   427: iconst_2
    //   428: ldc_w 422
    //   431: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   434: aload_0
    //   435: getfield 23	anvd:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   438: invokevirtual 240	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   441: invokestatic 246	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   444: aconst_null
    //   445: ldc_w 424
    //   448: iconst_0
    //   449: ldc2_w 89
    //   452: lconst_0
    //   453: aconst_null
    //   454: aconst_null
    //   455: iconst_0
    //   456: invokevirtual 255	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   459: iconst_0
    //   460: ireturn
    //   461: astore 8
    //   463: aload 8
    //   465: invokevirtual 425	java/lang/InterruptedException:printStackTrace	()V
    //   468: goto -89 -> 379
    //   471: aload_0
    //   472: aload_0
    //   473: getfield 37	anvd:jdField_b_of_type_Int	I
    //   476: iconst_1
    //   477: iadd
    //   478: putfield 37	anvd:jdField_b_of_type_Int	I
    //   481: aload_0
    //   482: getfield 23	anvd:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   485: iload_1
    //   486: iconst_1
    //   487: invokestatic 428	bgbo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;II)I
    //   490: pop
    //   491: aload_0
    //   492: getfield 23	anvd:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   495: iload_2
    //   496: aload 11
    //   498: invokevirtual 406	java/util/ArrayList:size	()I
    //   501: invokestatic 430	bgbo:b	(Lcom/tencent/mobileqq/app/QQAppInterface;II)I
    //   504: pop
    //   505: iconst_1
    //   506: ireturn
    //   507: invokestatic 274	java/lang/System:nanoTime	()J
    //   510: lload 6
    //   512: lsub
    //   513: ldc2_w 294
    //   516: ldiv
    //   517: lstore 6
    //   519: aload_0
    //   520: getfield 23	anvd:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   523: lload 4
    //   525: lload 6
    //   527: invokestatic 298	bgbo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JJ)J
    //   530: pop2
    //   531: aload_0
    //   532: aload_0
    //   533: getfield 37	anvd:jdField_b_of_type_Int	I
    //   536: iconst_1
    //   537: iadd
    //   538: putfield 37	anvd:jdField_b_of_type_Int	I
    //   541: goto -60 -> 481
    //   544: astore 8
    //   546: aload 10
    //   548: astore 9
    //   550: aload 8
    //   552: astore 10
    //   554: aload 9
    //   556: astore 8
    //   558: aload 10
    //   560: invokevirtual 74	java/lang/Exception:printStackTrace	()V
    //   563: aload 9
    //   565: astore 8
    //   567: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   570: ifeq +18 -> 588
    //   573: aload 9
    //   575: astore 8
    //   577: ldc 81
    //   579: iconst_2
    //   580: ldc_w 432
    //   583: aload 10
    //   585: invokestatic 87	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   588: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   591: ifeq +46 -> 637
    //   594: ldc 81
    //   596: iconst_2
    //   597: new 144	java/lang/StringBuilder
    //   600: dup
    //   601: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   604: ldc_w 405
    //   607: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: aload 11
    //   612: invokevirtual 406	java/util/ArrayList:size	()I
    //   615: invokevirtual 191	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   618: ldc_w 408
    //   621: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: aload_0
    //   625: getfield 37	anvd:jdField_b_of_type_Int	I
    //   628: invokevirtual 191	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   631: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   634: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   637: aload 9
    //   639: ifnull +8 -> 647
    //   642: aload 9
    //   644: invokevirtual 409	aybg:close	()V
    //   647: iconst_0
    //   648: ireturn
    //   649: astore 10
    //   651: aload 8
    //   653: astore 9
    //   655: aload 10
    //   657: astore 8
    //   659: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   662: ifeq +46 -> 708
    //   665: ldc 81
    //   667: iconst_2
    //   668: new 144	java/lang/StringBuilder
    //   671: dup
    //   672: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   675: ldc_w 405
    //   678: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: aload 11
    //   683: invokevirtual 406	java/util/ArrayList:size	()I
    //   686: invokevirtual 191	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   689: ldc_w 408
    //   692: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   695: aload_0
    //   696: getfield 37	anvd:jdField_b_of_type_Int	I
    //   699: invokevirtual 191	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   702: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   705: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   708: aload 9
    //   710: ifnull +8 -> 718
    //   713: aload 9
    //   715: invokevirtual 409	aybg:close	()V
    //   718: aload_0
    //   719: getfield 30	anvd:jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   722: aload 11
    //   724: iconst_1
    //   725: invokevirtual 412	com/tencent/mobileqq/persistence/fts/FTSDatatbase:a	(Ljava/util/ArrayList;I)I
    //   728: iconst_m1
    //   729: if_icmpne +138 -> 867
    //   732: ldc2_w 413
    //   735: invokestatic 420	java/lang/Thread:sleep	(J)V
    //   738: aload_0
    //   739: getfield 30	anvd:jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   742: aload 11
    //   744: iconst_1
    //   745: invokevirtual 412	com/tencent/mobileqq/persistence/fts/FTSDatatbase:a	(Ljava/util/ArrayList;I)I
    //   748: istore_3
    //   749: invokestatic 274	java/lang/System:nanoTime	()J
    //   752: lload 6
    //   754: lsub
    //   755: ldc2_w 294
    //   758: ldiv
    //   759: lstore 6
    //   761: aload_0
    //   762: getfield 23	anvd:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   765: lload 4
    //   767: lload 6
    //   769: invokestatic 298	bgbo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JJ)J
    //   772: pop2
    //   773: iload_3
    //   774: iconst_m1
    //   775: if_icmpne +55 -> 830
    //   778: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   781: ifeq +12 -> 793
    //   784: ldc 81
    //   786: iconst_2
    //   787: ldc_w 422
    //   790: invokestatic 164	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   793: aload_0
    //   794: getfield 23	anvd:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   797: invokevirtual 240	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   800: invokestatic 246	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   803: aconst_null
    //   804: ldc_w 424
    //   807: iconst_0
    //   808: ldc2_w 89
    //   811: lconst_0
    //   812: aconst_null
    //   813: aconst_null
    //   814: iconst_0
    //   815: invokevirtual 255	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   818: iconst_0
    //   819: ireturn
    //   820: astore 9
    //   822: aload 9
    //   824: invokevirtual 425	java/lang/InterruptedException:printStackTrace	()V
    //   827: goto -89 -> 738
    //   830: aload_0
    //   831: aload_0
    //   832: getfield 37	anvd:jdField_b_of_type_Int	I
    //   835: iconst_1
    //   836: iadd
    //   837: putfield 37	anvd:jdField_b_of_type_Int	I
    //   840: aload_0
    //   841: getfield 23	anvd:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   844: iload_1
    //   845: iconst_1
    //   846: invokestatic 428	bgbo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;II)I
    //   849: pop
    //   850: aload_0
    //   851: getfield 23	anvd:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   854: iload_2
    //   855: aload 11
    //   857: invokevirtual 406	java/util/ArrayList:size	()I
    //   860: invokestatic 430	bgbo:b	(Lcom/tencent/mobileqq/app/QQAppInterface;II)I
    //   863: pop
    //   864: aload 8
    //   866: athrow
    //   867: invokestatic 274	java/lang/System:nanoTime	()J
    //   870: lload 6
    //   872: lsub
    //   873: ldc2_w 294
    //   876: ldiv
    //   877: lstore 6
    //   879: aload_0
    //   880: getfield 23	anvd:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   883: lload 4
    //   885: lload 6
    //   887: invokestatic 298	bgbo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JJ)J
    //   890: pop2
    //   891: aload_0
    //   892: aload_0
    //   893: getfield 37	anvd:jdField_b_of_type_Int	I
    //   896: iconst_1
    //   897: iadd
    //   898: putfield 37	anvd:jdField_b_of_type_Int	I
    //   901: goto -61 -> 840
    //   904: astore 8
    //   906: goto -247 -> 659
    //   909: astore 10
    //   911: goto -357 -> 554
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	914	0	this	anvd
    //   40	805	1	i	int
    //   48	807	2	j	int
    //   389	387	3	k	int
    //   56	828	4	l1	long
    //   61	825	6	l2	long
    //   16	112	8	localObject1	Object
    //   199	30	8	localThrowable	java.lang.Throwable
    //   461	3	8	localInterruptedException1	java.lang.InterruptedException
    //   544	7	8	localException1	Exception
    //   556	309	8	localObject2	Object
    //   904	1	8	localObject3	Object
    //   76	638	9	localObject4	Object
    //   820	3	9	localInterruptedException2	java.lang.InterruptedException
    //   19	565	10	localObject5	Object
    //   649	7	10	localObject6	Object
    //   909	1	10	localException2	Exception
    //   31	825	11	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   188	196	199	java/lang/Throwable
    //   373	379	461	java/lang/InterruptedException
    //   63	78	544	java/lang/Exception
    //   63	78	649	finally
    //   558	563	649	finally
    //   567	573	649	finally
    //   577	588	649	finally
    //   732	738	820	java/lang/InterruptedException
    //   78	93	904	finally
    //   98	117	904	finally
    //   117	173	904	finally
    //   178	188	904	finally
    //   188	196	904	finally
    //   201	239	904	finally
    //   78	93	909	java/lang/Exception
    //   98	117	909	java/lang/Exception
    //   117	173	909	java/lang/Exception
    //   178	188	909	java/lang/Exception
    //   188	196	909	java/lang/Exception
    //   201	239	909	java/lang/Exception
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public boolean a()
  {
    return !bgbo.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public boolean b()
  {
    if (bgbo.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      QLog.d("Q.fts.FTSMsgUpgrader", 2, "========== upgrade log has complete");
      return c();
    }
    QLog.d("Q.fts.FTSMsgUpgrader", 2, "========== upgrade log start");
    long l3 = bgbo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    long l4 = System.nanoTime();
    for (;;)
    {
      try
      {
        SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getReadableDatabase();
        Object localObject3 = localSQLiteDatabase.getAllTableNameFromDB();
        boolean bool;
        long l1;
        if ((localObject3 == null) || (localObject3.length == 0))
        {
          bgbo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
          bool = c();
          return bool;
        }
        HashMap localHashMap = new HashMap();
        int j = localObject3.length;
        int i = 0;
        String str;
        Cursor localCursor;
        if (i < j)
        {
          str = localObject3[i];
          if ((str.endsWith("_New")) && ((str.startsWith("mr_friend_")) || (str.startsWith("mr_troop_")) || (str.startsWith("mr_discusssion_")) || (str.startsWith("mr_contact_")) || (str.startsWith("mr_devicemsg_"))))
          {
            localCursor = localSQLiteDatabase.rawQuery("SELECT max(_id) AS MAX_ID FROM " + str + ";", null);
            if ((localCursor != null) && (localCursor.getCount() == 1))
            {
              localCursor.moveToNext();
              localHashMap.put(str, Long.valueOf(localCursor.getLong(localCursor.getColumnIndex("MAX_ID"))));
            }
            if (localCursor != null) {
              localCursor.close();
            }
          }
        }
        else if (QLog.isColorLevel())
        {
          localObject3 = localHashMap.keySet().iterator();
          if (((Iterator)localObject3).hasNext())
          {
            str = (String)((Iterator)localObject3).next();
            QLog.d("Q.fts.FTSMsgUpgrader", 2, "startUpgradeLogStep: msgUpgradeInfo[key=" + str + ", value=" + localHashMap.get(str) + "]");
            continue;
          }
        }
        long l2;
        i += 1;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        QLog.e("Q.fts.FTSMsgUpgrader", 2, "startUpgradeLogStep: ", localException1);
        return false;
        try
        {
          localException1.execSQL("CREATE TABLE IF NOT EXISTS msg_upgrade_log(id INTEGER PRIMARY KEY AUTOINCREMENT, tablename TEXT, MAX_ID INTEGER);");
          localObject3 = localHashMap.keySet().iterator();
          if (((Iterator)localObject3).hasNext())
          {
            str = (String)((Iterator)localObject3).next();
            localCursor = localException1.query("msg_upgrade_log", new String[] { "id" }, "tablename=?", new String[] { str }, null, null);
            l2 = -1L;
            l1 = l2;
            if (localCursor != null)
            {
              l1 = l2;
              if (localCursor.getCount() == 1)
              {
                localCursor.moveToNext();
                l1 = localCursor.getLong(localCursor.getColumnIndex("id"));
              }
            }
            if (localCursor != null) {
              localCursor.close();
            }
            if (a(l1, str, ((Long)localHashMap.get(str)).longValue(), localException1) != -1L) {
              continue;
            }
            Thread.sleep(5L);
            if (a(l1, str, ((Long)localHashMap.get(str)).longValue(), localException1) != -1L) {
              continue;
            }
            StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).collectPerformance(null, "actFTSUpgradeLogFailure", false, -1L, 0L, null, null, false);
            return false;
          }
          bgbo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
          bool = c();
        }
        catch (Exception localException2)
        {
          localException2 = localException2;
          bool = false;
          localException2.printStackTrace();
          QLog.e("Q.fts.FTSMsgUpgrader", 2, "startUpgradeLogStep: ", localException2);
          continue;
        }
        finally {}
        return bool;
      }
      finally
      {
        l1 = (System.nanoTime() - l4) / 1000L;
        bgbo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l3, l1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anvd
 * JD-Core Version:    0.7.0.1
 */