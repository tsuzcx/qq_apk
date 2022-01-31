import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.persistence.fts.FTSDatatbase;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class amjo
  implements amjt
{
  private int jdField_a_of_type_Int;
  private amjn jdField_a_of_type_Amjn;
  private amjq jdField_a_of_type_Amjq;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FTSDatatbase jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase;
  public boolean a;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  
  amjo(QQAppInterface paramQQAppInterface, amjn paramamjn)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Amjn = paramamjn;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase = this.jdField_a_of_type_Amjn.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase;
    this.jdField_a_of_type_Amjq = this.jdField_a_of_type_Amjn.jdField_a_of_type_Amjq;
  }
  
  private long a(long paramLong1, String paramString, long paramLong2, SQLiteDatabase paramSQLiteDatabase)
  {
    if (paramLong1 != -1L)
    {
      paramString = new ContentValues();
      paramString.put("MAX_ID", Long.valueOf(paramLong2));
      return paramSQLiteDatabase.a("msg_upgrade_log", paramString, "id=?", new String[] { String.valueOf(paramLong1) });
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("tablename", paramString);
    localContentValues.put("MAX_ID", Long.valueOf(paramLong2));
    return paramSQLiteDatabase.a("msg_upgrade_log", null, localContentValues);
  }
  
  private void b()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_table", String.valueOf(bdli.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)));
    localHashMap.put("param_msg", String.valueOf(bdli.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)));
    azmz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).a(null, "actFTSUpgradeCost", true, bdli.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), 0L, localHashMap, null, false);
    bdli.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts.FTSMsgUpgrader", 2, "========== upgrade table complete, cost =" + bdli.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) + "us, tables = " + bdli.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) + ", msgs = " + bdli.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    }
  }
  
  private void c()
  {
    long l1 = bdli.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
      bdli.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l1, l2);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
  }
  
  /* Error */
  private boolean c()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 23	amjo:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokestatic 206	bdli:b	(Lcom/tencent/mobileqq/app/QQAppInterface;)I
    //   7: iconst_1
    //   8: if_icmpeq +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: aload_0
    //   14: getfield 23	amjo:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   17: invokestatic 209	bdli:c	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   20: ifeq +19 -> 39
    //   23: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +11 -> 37
    //   29: ldc 141
    //   31: iconst_2
    //   32: ldc 211
    //   34: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: iconst_1
    //   38: ireturn
    //   39: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   42: ifeq +11 -> 53
    //   45: ldc 141
    //   47: iconst_2
    //   48: ldc 213
    //   50: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   53: aload_0
    //   54: getfield 23	amjo:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   57: invokestatic 127	bdli:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)J
    //   60: lstore_3
    //   61: invokestatic 177	java/lang/System:nanoTime	()J
    //   64: lstore 5
    //   66: aload_0
    //   67: getfield 23	amjo:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   70: invokevirtual 216	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   73: ldc 218
    //   75: aconst_null
    //   76: invokevirtual 221	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   79: astore 7
    //   81: aload 7
    //   83: ifnull +322 -> 405
    //   86: aload 7
    //   88: invokeinterface 227 1 0
    //   93: istore_1
    //   94: iload_1
    //   95: iconst_1
    //   96: if_icmpne +309 -> 405
    //   99: iconst_1
    //   100: istore_1
    //   101: iload_1
    //   102: istore_2
    //   103: aload 7
    //   105: ifnull +12 -> 117
    //   108: aload 7
    //   110: invokeinterface 230 1 0
    //   115: iload_1
    //   116: istore_2
    //   117: iload_2
    //   118: ifne +60 -> 178
    //   121: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   124: ifeq +11 -> 135
    //   127: ldc 141
    //   129: iconst_2
    //   130: ldc 232
    //   132: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   135: aload_0
    //   136: invokespecial 169	amjo:b	()V
    //   139: iconst_1
    //   140: ireturn
    //   141: astore 7
    //   143: iconst_0
    //   144: istore_1
    //   145: aload 7
    //   147: invokevirtual 235	java/lang/Exception:printStackTrace	()V
    //   150: iload_1
    //   151: istore_2
    //   152: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   155: ifeq -38 -> 117
    //   158: ldc 141
    //   160: iconst_2
    //   161: ldc 237
    //   163: aload 7
    //   165: invokestatic 241	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   168: iload_1
    //   169: istore_2
    //   170: goto -53 -> 117
    //   173: astore 7
    //   175: aload 7
    //   177: athrow
    //   178: aload_0
    //   179: getfield 23	amjo:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   182: invokevirtual 216	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   185: ldc 243
    //   187: aconst_null
    //   188: invokevirtual 221	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   191: astore 7
    //   193: aload 7
    //   195: ifnull +205 -> 400
    //   198: aload 7
    //   200: invokeinterface 227 1 0
    //   205: iconst_1
    //   206: if_icmpne +194 -> 400
    //   209: aload 7
    //   211: invokeinterface 246 1 0
    //   216: pop
    //   217: aload 7
    //   219: aload 7
    //   221: ldc 45
    //   223: invokeinterface 249 2 0
    //   228: invokeinterface 253 2 0
    //   233: istore_1
    //   234: iload_1
    //   235: istore_2
    //   236: aload 7
    //   238: ifnull +12 -> 250
    //   241: aload 7
    //   243: invokeinterface 230 1 0
    //   248: iload_1
    //   249: istore_2
    //   250: iload_2
    //   251: iconst_m1
    //   252: if_icmpne +60 -> 312
    //   255: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   258: ifeq +11 -> 269
    //   261: ldc 141
    //   263: iconst_2
    //   264: ldc 255
    //   266: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   269: aload_0
    //   270: invokespecial 169	amjo:b	()V
    //   273: iconst_1
    //   274: ireturn
    //   275: astore 7
    //   277: iconst_m1
    //   278: istore_1
    //   279: aload 7
    //   281: invokevirtual 235	java/lang/Exception:printStackTrace	()V
    //   284: iload_1
    //   285: istore_2
    //   286: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   289: ifeq -39 -> 250
    //   292: ldc 141
    //   294: iconst_2
    //   295: ldc 237
    //   297: aload 7
    //   299: invokestatic 241	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   302: iload_1
    //   303: istore_2
    //   304: goto -54 -> 250
    //   307: astore 7
    //   309: aload 7
    //   311: athrow
    //   312: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   315: ifeq +29 -> 344
    //   318: ldc 141
    //   320: iconst_2
    //   321: new 143	java/lang/StringBuilder
    //   324: dup
    //   325: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   328: ldc_w 257
    //   331: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: iload_2
    //   335: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   338: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   344: aload_0
    //   345: iload_2
    //   346: putfield 90	amjo:jdField_a_of_type_Int	I
    //   349: invokestatic 177	java/lang/System:nanoTime	()J
    //   352: lload 5
    //   354: lsub
    //   355: ldc2_w 198
    //   358: ldiv
    //   359: lstore 5
    //   361: aload_0
    //   362: getfield 23	amjo:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   365: lload_3
    //   366: lload 5
    //   368: invokestatic 202	bdli:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JJ)J
    //   371: pop2
    //   372: aload_0
    //   373: getfield 33	amjo:jdField_a_of_type_Amjq	Lamjq;
    //   376: new 259	com/tencent/mobileqq/app/proxy/fts/FTSMsgUpgrader$1
    //   379: dup
    //   380: aload_0
    //   381: invokespecial 261	com/tencent/mobileqq/app/proxy/fts/FTSMsgUpgrader$1:<init>	(Lamjo;)V
    //   384: invokevirtual 267	amjq:post	(Ljava/lang/Runnable;)Z
    //   387: pop
    //   388: iconst_0
    //   389: ireturn
    //   390: astore 7
    //   392: goto -113 -> 279
    //   395: astore 7
    //   397: goto -252 -> 145
    //   400: iconst_m1
    //   401: istore_1
    //   402: goto -168 -> 234
    //   405: iconst_0
    //   406: istore_1
    //   407: goto -306 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	410	0	this	amjo
    //   93	314	1	i	int
    //   102	244	2	j	int
    //   60	306	3	l1	long
    //   64	303	5	l2	long
    //   79	30	7	localCursor1	Cursor
    //   141	23	7	localException1	Exception
    //   173	3	7	localObject1	Object
    //   191	51	7	localCursor2	Cursor
    //   275	23	7	localException2	Exception
    //   307	3	7	localObject2	Object
    //   390	1	7	localException3	Exception
    //   395	1	7	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   66	81	141	java/lang/Exception
    //   86	94	141	java/lang/Exception
    //   66	81	173	finally
    //   86	94	173	finally
    //   108	115	173	finally
    //   145	150	173	finally
    //   152	168	173	finally
    //   178	193	275	java/lang/Exception
    //   198	234	275	java/lang/Exception
    //   178	193	307	finally
    //   198	234	307	finally
    //   241	248	307	finally
    //   279	284	307	finally
    //   286	302	307	finally
    //   241	248	390	java/lang/Exception
    //   108	115	395	java/lang/Exception
  }
  
  /* Error */
  private boolean d()
  {
    // Byte code:
    //   0: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 141
    //   8: iconst_2
    //   9: ldc_w 273
    //   12: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aconst_null
    //   16: astore 10
    //   18: aconst_null
    //   19: astore 12
    //   21: new 275	java/util/ArrayList
    //   24: dup
    //   25: sipush 512
    //   28: invokespecial 278	java/util/ArrayList:<init>	(I)V
    //   31: astore 14
    //   33: aload_0
    //   34: getfield 23	amjo:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   37: invokestatic 100	bdli:c	(Lcom/tencent/mobileqq/app/QQAppInterface;)I
    //   40: istore_1
    //   41: aload_0
    //   42: getfield 23	amjo:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   45: invokestatic 111	bdli:d	(Lcom/tencent/mobileqq/app/QQAppInterface;)I
    //   48: istore_2
    //   49: aload_0
    //   50: getfield 23	amjo:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   53: invokestatic 127	bdli:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)J
    //   56: lstore 6
    //   58: invokestatic 177	java/lang/System:nanoTime	()J
    //   61: lstore 8
    //   63: aload_0
    //   64: getfield 23	amjo:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   67: invokevirtual 282	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lawbx;
    //   70: invokevirtual 288	awbx:createMessageRecordEntityManager	()Lawbw;
    //   73: checkcast 290	awce
    //   76: astore 11
    //   78: aload_0
    //   79: getfield 23	amjo:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   82: invokevirtual 216	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   85: astore 10
    //   87: ldc2_w 39
    //   90: lstore 4
    //   92: aload 10
    //   94: ldc_w 292
    //   97: iconst_1
    //   98: anewarray 61	java/lang/String
    //   101: dup
    //   102: iconst_0
    //   103: aload_0
    //   104: getfield 37	amjo:jdField_b_of_type_Int	I
    //   107: iconst_1
    //   108: iadd
    //   109: invokestatic 103	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   112: aastore
    //   113: invokevirtual 221	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   116: astore 12
    //   118: aload 12
    //   120: ifnull +507 -> 627
    //   123: aload 12
    //   125: invokeinterface 227 1 0
    //   130: iconst_1
    //   131: if_icmpne +496 -> 627
    //   134: aload 12
    //   136: invokeinterface 246 1 0
    //   141: pop
    //   142: aload 12
    //   144: aload 12
    //   146: ldc 71
    //   148: invokeinterface 249 2 0
    //   153: invokeinterface 295 2 0
    //   158: astore 10
    //   160: aload 12
    //   162: aload 12
    //   164: ldc 45
    //   166: invokeinterface 249 2 0
    //   171: invokeinterface 299 2 0
    //   176: lstore 4
    //   178: aload 12
    //   180: ifnull +10 -> 190
    //   183: aload 12
    //   185: invokeinterface 230 1 0
    //   190: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   193: ifeq +41 -> 234
    //   196: ldc 141
    //   198: iconst_2
    //   199: new 143	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   206: ldc_w 301
    //   209: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: aload 10
    //   214: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: ldc_w 303
    //   220: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: lload 4
    //   225: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   228: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   234: aconst_null
    //   235: astore 13
    //   237: aload 13
    //   239: astore 12
    //   241: aload 10
    //   243: ifnull +177 -> 420
    //   246: aload 13
    //   248: astore 12
    //   250: lload 4
    //   252: lconst_0
    //   253: lcmp
    //   254: ifle +166 -> 420
    //   257: new 143	java/lang/StringBuilder
    //   260: dup
    //   261: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   264: ldc_w 305
    //   267: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: aload 10
    //   272: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: ldc_w 307
    //   278: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: astore 12
    //   286: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   289: ifeq +47 -> 336
    //   292: ldc 141
    //   294: iconst_2
    //   295: new 143	java/lang/StringBuilder
    //   298: dup
    //   299: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   302: ldc_w 309
    //   305: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: aload 10
    //   310: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: ldc_w 311
    //   316: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: lload 4
    //   321: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   324: ldc_w 313
    //   327: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   333: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   336: aload_0
    //   337: getfield 23	amjo:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   340: astore 10
    //   342: aload 11
    //   344: aload 12
    //   346: iconst_1
    //   347: anewarray 61	java/lang/String
    //   350: dup
    //   351: iconst_0
    //   352: lload 4
    //   354: invokestatic 64	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   357: aastore
    //   358: aload 10
    //   360: invokevirtual 316	awce:a	(Ljava/lang/String;[Ljava/lang/String;Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/util/List;
    //   363: astore 13
    //   365: aload 13
    //   367: astore 12
    //   369: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   372: ifeq +48 -> 420
    //   375: new 143	java/lang/StringBuilder
    //   378: dup
    //   379: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   382: ldc_w 318
    //   385: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: astore 12
    //   390: aload 13
    //   392: ifnonnull +281 -> 673
    //   395: ldc_w 320
    //   398: astore 10
    //   400: ldc 141
    //   402: iconst_2
    //   403: aload 12
    //   405: aload 10
    //   407: invokevirtual 323	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   410: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   413: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   416: aload 13
    //   418: astore 12
    //   420: aload 12
    //   422: ifnull +268 -> 690
    //   425: aload 12
    //   427: invokeinterface 328 1 0
    //   432: ifne +258 -> 690
    //   435: aload 12
    //   437: invokeinterface 332 1 0
    //   442: astore 10
    //   444: aload 10
    //   446: invokeinterface 337 1 0
    //   451: ifeq +239 -> 690
    //   454: aload 10
    //   456: invokeinterface 341 1 0
    //   461: checkcast 343	com/tencent/mobileqq/data/MessageRecord
    //   464: astore 12
    //   466: aload 12
    //   468: invokevirtual 346	com/tencent/mobileqq/data/MessageRecord:isSupportFTS	()Z
    //   471: ifeq -27 -> 444
    //   474: aload 12
    //   476: getfield 349	com/tencent/mobileqq/data/MessageRecord:isValid	Z
    //   479: ifeq -35 -> 444
    //   482: aload 12
    //   484: getfield 352	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   487: sipush -2006
    //   490: if_icmpeq -46 -> 444
    //   493: aload 12
    //   495: invokestatic 357	com/tencent/mobileqq/utils/fts/FTSMessageCodec:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Lcom/tencent/mobileqq/data/fts/FTSMessage;
    //   498: astore 12
    //   500: aload 12
    //   502: ifnull -58 -> 444
    //   505: aload 12
    //   507: invokevirtual 362	com/tencent/mobileqq/data/fts/FTSMessage:insertOpt	()V
    //   510: aload 12
    //   512: invokevirtual 365	com/tencent/mobileqq/data/fts/FTSMessage:preWrite	()V
    //   515: aload 14
    //   517: aload 12
    //   519: invokevirtual 369	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   522: pop
    //   523: goto -79 -> 444
    //   526: astore 10
    //   528: aload 10
    //   530: invokevirtual 370	java/lang/Throwable:printStackTrace	()V
    //   533: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   536: ifeq +30 -> 566
    //   539: ldc 141
    //   541: iconst_2
    //   542: new 143	java/lang/StringBuilder
    //   545: dup
    //   546: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   549: ldc_w 372
    //   552: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: aload 10
    //   557: invokevirtual 323	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   560: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   563: invokestatic 374	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   566: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   569: ifeq +46 -> 615
    //   572: ldc 141
    //   574: iconst_2
    //   575: new 143	java/lang/StringBuilder
    //   578: dup
    //   579: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   582: ldc_w 376
    //   585: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: aload 14
    //   590: invokevirtual 379	java/util/ArrayList:size	()I
    //   593: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   596: ldc_w 381
    //   599: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: aload_0
    //   603: getfield 37	amjo:jdField_b_of_type_Int	I
    //   606: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   609: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   612: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   615: aload 11
    //   617: ifnull +8 -> 625
    //   620: aload 11
    //   622: invokevirtual 383	awce:a	()V
    //   625: iconst_0
    //   626: ireturn
    //   627: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   630: ifeq +674 -> 1304
    //   633: ldc 141
    //   635: iconst_2
    //   636: new 143	java/lang/StringBuilder
    //   639: dup
    //   640: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   643: ldc_w 385
    //   646: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: aload_0
    //   650: getfield 37	amjo:jdField_b_of_type_Int	I
    //   653: iconst_1
    //   654: iadd
    //   655: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   658: ldc_w 387
    //   661: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   664: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   667: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   670: goto +634 -> 1304
    //   673: aload 13
    //   675: invokeinterface 388 1 0
    //   680: istore_3
    //   681: iload_3
    //   682: invokestatic 393	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   685: astore 10
    //   687: goto -287 -> 400
    //   690: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   693: ifeq +46 -> 739
    //   696: ldc 141
    //   698: iconst_2
    //   699: new 143	java/lang/StringBuilder
    //   702: dup
    //   703: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   706: ldc_w 376
    //   709: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   712: aload 14
    //   714: invokevirtual 379	java/util/ArrayList:size	()I
    //   717: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   720: ldc_w 381
    //   723: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   726: aload_0
    //   727: getfield 37	amjo:jdField_b_of_type_Int	I
    //   730: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   733: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   736: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   739: aload 11
    //   741: ifnull +8 -> 749
    //   744: aload 11
    //   746: invokevirtual 383	awce:a	()V
    //   749: aload_0
    //   750: getfield 30	amjo:jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   753: aload 14
    //   755: iconst_1
    //   756: invokevirtual 396	com/tencent/mobileqq/persistence/fts/FTSDatatbase:a	(Ljava/util/ArrayList;I)I
    //   759: iconst_m1
    //   760: if_icmpne +137 -> 897
    //   763: ldc2_w 397
    //   766: invokestatic 404	java/lang/Thread:sleep	(J)V
    //   769: aload_0
    //   770: getfield 30	amjo:jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   773: aload 14
    //   775: iconst_1
    //   776: invokevirtual 396	com/tencent/mobileqq/persistence/fts/FTSDatatbase:a	(Ljava/util/ArrayList;I)I
    //   779: istore_3
    //   780: invokestatic 177	java/lang/System:nanoTime	()J
    //   783: lload 8
    //   785: lsub
    //   786: ldc2_w 198
    //   789: ldiv
    //   790: lstore 4
    //   792: aload_0
    //   793: getfield 23	amjo:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   796: lload 6
    //   798: lload 4
    //   800: invokestatic 202	bdli:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JJ)J
    //   803: pop2
    //   804: iload_3
    //   805: iconst_m1
    //   806: if_icmpne +55 -> 861
    //   809: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   812: ifeq +12 -> 824
    //   815: ldc 141
    //   817: iconst_2
    //   818: ldc_w 406
    //   821: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   824: aload_0
    //   825: getfield 23	amjo:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   828: invokevirtual 117	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   831: invokestatic 122	azmz:a	(Landroid/content/Context;)Lazmz;
    //   834: aconst_null
    //   835: ldc_w 408
    //   838: iconst_0
    //   839: ldc2_w 39
    //   842: lconst_0
    //   843: aconst_null
    //   844: aconst_null
    //   845: iconst_0
    //   846: invokevirtual 130	azmz:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   849: iconst_0
    //   850: ireturn
    //   851: astore 10
    //   853: aload 10
    //   855: invokevirtual 409	java/lang/InterruptedException:printStackTrace	()V
    //   858: goto -89 -> 769
    //   861: aload_0
    //   862: aload_0
    //   863: getfield 37	amjo:jdField_b_of_type_Int	I
    //   866: iconst_1
    //   867: iadd
    //   868: putfield 37	amjo:jdField_b_of_type_Int	I
    //   871: aload_0
    //   872: getfield 23	amjo:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   875: iload_1
    //   876: iconst_1
    //   877: invokestatic 412	bdli:a	(Lcom/tencent/mobileqq/app/QQAppInterface;II)I
    //   880: pop
    //   881: aload_0
    //   882: getfield 23	amjo:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   885: iload_2
    //   886: aload 14
    //   888: invokevirtual 379	java/util/ArrayList:size	()I
    //   891: invokestatic 414	bdli:b	(Lcom/tencent/mobileqq/app/QQAppInterface;II)I
    //   894: pop
    //   895: iconst_1
    //   896: ireturn
    //   897: invokestatic 177	java/lang/System:nanoTime	()J
    //   900: lload 8
    //   902: lsub
    //   903: ldc2_w 198
    //   906: ldiv
    //   907: lstore 4
    //   909: aload_0
    //   910: getfield 23	amjo:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   913: lload 6
    //   915: lload 4
    //   917: invokestatic 202	bdli:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JJ)J
    //   920: pop2
    //   921: aload_0
    //   922: aload_0
    //   923: getfield 37	amjo:jdField_b_of_type_Int	I
    //   926: iconst_1
    //   927: iadd
    //   928: putfield 37	amjo:jdField_b_of_type_Int	I
    //   931: goto -60 -> 871
    //   934: astore 10
    //   936: aload 12
    //   938: astore 11
    //   940: aload 10
    //   942: astore 12
    //   944: aload 11
    //   946: astore 10
    //   948: aload 12
    //   950: invokevirtual 235	java/lang/Exception:printStackTrace	()V
    //   953: aload 11
    //   955: astore 10
    //   957: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   960: ifeq +18 -> 978
    //   963: aload 11
    //   965: astore 10
    //   967: ldc 141
    //   969: iconst_2
    //   970: ldc_w 416
    //   973: aload 12
    //   975: invokestatic 241	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   978: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   981: ifeq +46 -> 1027
    //   984: ldc 141
    //   986: iconst_2
    //   987: new 143	java/lang/StringBuilder
    //   990: dup
    //   991: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   994: ldc_w 376
    //   997: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1000: aload 14
    //   1002: invokevirtual 379	java/util/ArrayList:size	()I
    //   1005: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1008: ldc_w 381
    //   1011: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1014: aload_0
    //   1015: getfield 37	amjo:jdField_b_of_type_Int	I
    //   1018: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1021: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1024: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1027: aload 11
    //   1029: ifnull +8 -> 1037
    //   1032: aload 11
    //   1034: invokevirtual 383	awce:a	()V
    //   1037: iconst_0
    //   1038: ireturn
    //   1039: astore 12
    //   1041: aload 10
    //   1043: astore 11
    //   1045: aload 12
    //   1047: astore 10
    //   1049: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1052: ifeq +46 -> 1098
    //   1055: ldc 141
    //   1057: iconst_2
    //   1058: new 143	java/lang/StringBuilder
    //   1061: dup
    //   1062: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   1065: ldc_w 376
    //   1068: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1071: aload 14
    //   1073: invokevirtual 379	java/util/ArrayList:size	()I
    //   1076: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1079: ldc_w 381
    //   1082: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1085: aload_0
    //   1086: getfield 37	amjo:jdField_b_of_type_Int	I
    //   1089: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1092: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1095: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1098: aload 11
    //   1100: ifnull +8 -> 1108
    //   1103: aload 11
    //   1105: invokevirtual 383	awce:a	()V
    //   1108: aload_0
    //   1109: getfield 30	amjo:jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   1112: aload 14
    //   1114: iconst_1
    //   1115: invokevirtual 396	com/tencent/mobileqq/persistence/fts/FTSDatatbase:a	(Ljava/util/ArrayList;I)I
    //   1118: iconst_m1
    //   1119: if_icmpne +138 -> 1257
    //   1122: ldc2_w 397
    //   1125: invokestatic 404	java/lang/Thread:sleep	(J)V
    //   1128: aload_0
    //   1129: getfield 30	amjo:jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   1132: aload 14
    //   1134: iconst_1
    //   1135: invokevirtual 396	com/tencent/mobileqq/persistence/fts/FTSDatatbase:a	(Ljava/util/ArrayList;I)I
    //   1138: istore_3
    //   1139: invokestatic 177	java/lang/System:nanoTime	()J
    //   1142: lload 8
    //   1144: lsub
    //   1145: ldc2_w 198
    //   1148: ldiv
    //   1149: lstore 4
    //   1151: aload_0
    //   1152: getfield 23	amjo:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1155: lload 6
    //   1157: lload 4
    //   1159: invokestatic 202	bdli:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JJ)J
    //   1162: pop2
    //   1163: iload_3
    //   1164: iconst_m1
    //   1165: if_icmpne +55 -> 1220
    //   1168: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1171: ifeq +12 -> 1183
    //   1174: ldc 141
    //   1176: iconst_2
    //   1177: ldc_w 406
    //   1180: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1183: aload_0
    //   1184: getfield 23	amjo:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1187: invokevirtual 117	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1190: invokestatic 122	azmz:a	(Landroid/content/Context;)Lazmz;
    //   1193: aconst_null
    //   1194: ldc_w 408
    //   1197: iconst_0
    //   1198: ldc2_w 39
    //   1201: lconst_0
    //   1202: aconst_null
    //   1203: aconst_null
    //   1204: iconst_0
    //   1205: invokevirtual 130	azmz:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   1208: iconst_0
    //   1209: ireturn
    //   1210: astore 11
    //   1212: aload 11
    //   1214: invokevirtual 409	java/lang/InterruptedException:printStackTrace	()V
    //   1217: goto -89 -> 1128
    //   1220: aload_0
    //   1221: aload_0
    //   1222: getfield 37	amjo:jdField_b_of_type_Int	I
    //   1225: iconst_1
    //   1226: iadd
    //   1227: putfield 37	amjo:jdField_b_of_type_Int	I
    //   1230: aload_0
    //   1231: getfield 23	amjo:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1234: iload_1
    //   1235: iconst_1
    //   1236: invokestatic 412	bdli:a	(Lcom/tencent/mobileqq/app/QQAppInterface;II)I
    //   1239: pop
    //   1240: aload_0
    //   1241: getfield 23	amjo:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1244: iload_2
    //   1245: aload 14
    //   1247: invokevirtual 379	java/util/ArrayList:size	()I
    //   1250: invokestatic 414	bdli:b	(Lcom/tencent/mobileqq/app/QQAppInterface;II)I
    //   1253: pop
    //   1254: aload 10
    //   1256: athrow
    //   1257: invokestatic 177	java/lang/System:nanoTime	()J
    //   1260: lload 8
    //   1262: lsub
    //   1263: ldc2_w 198
    //   1266: ldiv
    //   1267: lstore 4
    //   1269: aload_0
    //   1270: getfield 23	amjo:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1273: lload 6
    //   1275: lload 4
    //   1277: invokestatic 202	bdli:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JJ)J
    //   1280: pop2
    //   1281: aload_0
    //   1282: aload_0
    //   1283: getfield 37	amjo:jdField_b_of_type_Int	I
    //   1286: iconst_1
    //   1287: iadd
    //   1288: putfield 37	amjo:jdField_b_of_type_Int	I
    //   1291: goto -61 -> 1230
    //   1294: astore 10
    //   1296: goto -247 -> 1049
    //   1299: astore 12
    //   1301: goto -357 -> 944
    //   1304: aconst_null
    //   1305: astore 10
    //   1307: goto -1129 -> 178
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1310	0	this	amjo
    //   40	1195	1	i	int
    //   48	1197	2	j	int
    //   680	486	3	k	int
    //   90	1186	4	l1	long
    //   56	1218	6	l2	long
    //   61	1200	8	l3	long
    //   16	439	10	localObject1	Object
    //   526	30	10	localThrowable	java.lang.Throwable
    //   685	1	10	localInteger	java.lang.Integer
    //   851	3	10	localInterruptedException1	java.lang.InterruptedException
    //   934	7	10	localException1	Exception
    //   946	309	10	localObject2	Object
    //   1294	1	10	localObject3	Object
    //   1305	1	10	localObject4	Object
    //   76	1028	11	localObject5	Object
    //   1210	3	11	localInterruptedException2	java.lang.InterruptedException
    //   19	955	12	localObject6	Object
    //   1039	7	12	localObject7	Object
    //   1299	1	12	localException2	Exception
    //   235	439	13	localList	java.util.List
    //   31	1215	14	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   515	523	526	java/lang/Throwable
    //   763	769	851	java/lang/InterruptedException
    //   63	78	934	java/lang/Exception
    //   63	78	1039	finally
    //   948	953	1039	finally
    //   957	963	1039	finally
    //   967	978	1039	finally
    //   1122	1128	1210	java/lang/InterruptedException
    //   78	87	1294	finally
    //   92	118	1294	finally
    //   123	178	1294	finally
    //   183	190	1294	finally
    //   190	234	1294	finally
    //   257	336	1294	finally
    //   336	365	1294	finally
    //   369	390	1294	finally
    //   400	416	1294	finally
    //   425	444	1294	finally
    //   444	500	1294	finally
    //   505	515	1294	finally
    //   515	523	1294	finally
    //   528	566	1294	finally
    //   627	670	1294	finally
    //   673	681	1294	finally
    //   78	87	1299	java/lang/Exception
    //   92	118	1299	java/lang/Exception
    //   123	178	1299	java/lang/Exception
    //   183	190	1299	java/lang/Exception
    //   190	234	1299	java/lang/Exception
    //   257	336	1299	java/lang/Exception
    //   336	365	1299	java/lang/Exception
    //   369	390	1299	java/lang/Exception
    //   400	416	1299	java/lang/Exception
    //   425	444	1299	java/lang/Exception
    //   444	500	1299	java/lang/Exception
    //   505	515	1299	java/lang/Exception
    //   515	523	1299	java/lang/Exception
    //   528	566	1299	java/lang/Exception
    //   627	670	1299	java/lang/Exception
    //   673	681	1299	java/lang/Exception
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public boolean a()
  {
    return !bdli.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public boolean b()
  {
    if (bdli.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.fts.FTSMsgUpgrader", 2, "========== upgrade log has complete");
      }
      return c();
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts.FTSMsgUpgrader", 2, "========== upgrade log start");
    }
    long l3 = bdli.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    long l4 = System.nanoTime();
    for (;;)
    {
      try
      {
        SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b();
        Object localObject3 = localSQLiteDatabase.a();
        boolean bool1;
        long l1;
        if ((localObject3 == null) || (localObject3.length == 0))
        {
          bdli.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
          bool1 = c();
          return bool1;
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
            localCursor = localSQLiteDatabase.a("SELECT max(_id) AS MAX_ID FROM " + str + ";", null);
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
        boolean bool2;
        i += 1;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("Q.fts.FTSMsgUpgrader", 2, "startUpgradeLogStep: ", localException1);
        }
        return false;
        try
        {
          localException1.a("CREATE TABLE IF NOT EXISTS msg_upgrade_log(id INTEGER PRIMARY KEY AUTOINCREMENT, tablename TEXT, MAX_ID INTEGER);");
          localObject3 = localHashMap.keySet().iterator();
          if (((Iterator)localObject3).hasNext())
          {
            str = (String)((Iterator)localObject3).next();
            localCursor = localException1.a("msg_upgrade_log", new String[] { "id" }, "tablename=?", new String[] { str }, null, null);
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
            azmz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).a(null, "actFTSUpgradeLogFailure", false, -1L, 0L, null, null, false);
            return false;
          }
          bdli.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
          bool1 = c();
        }
        catch (Exception localException2)
        {
          localException2 = localException2;
          bool2 = false;
          localException2.printStackTrace();
          bool1 = bool2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("Q.fts.FTSMsgUpgrader", 2, "startUpgradeLogStep: ", localException2);
          bool1 = bool2;
          continue;
        }
        finally {}
        return bool1;
      }
      finally
      {
        l1 = (System.nanoTime() - l4) / 1000L;
        bdli.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l3, l1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amjo
 * JD-Core Version:    0.7.0.1
 */