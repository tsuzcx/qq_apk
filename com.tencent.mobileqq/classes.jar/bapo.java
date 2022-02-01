import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.util.SparseIntArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.data.QCallRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qcall.QCallProxy.1;
import com.tencent.mobileqq.qcall.QCallProxy.3;
import com.tencent.mobileqq.qcall.QCallProxy.5;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class bapo
  extends aoxs
{
  private static volatile boolean jdField_a_of_type_Boolean;
  private int jdField_a_of_type_Int = 20;
  EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = null;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private final List<QCallRecent> jdField_a_of_type_JavaUtilList = new ArrayList(20);
  private final Map<String, QCallRecent> jdField_a_of_type_JavaUtilMap = new HashMap();
  private ConcurrentHashMap<String, List<QCallRecord>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Object> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_b_of_type_Boolean;
  
  public bapo(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    super(paramQQAppInterface, paramProxyManager);
  }
  
  private int a(String paramString)
  {
    paramString = paramString.split("[^0-9]");
    int k = -1;
    for (;;)
    {
      try
      {
        int m = paramString.length;
        i = 0;
        j = k;
        if (i < m)
        {
          String str = paramString[i];
          if ((str == null) || (str.length() <= 0)) {
            continue;
          }
          j = Integer.parseInt(str);
        }
      }
      catch (Exception paramString)
      {
        int i;
        int j = k;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("QCallProxy", 2, paramString.getMessage(), paramString);
      }
      return j;
      i += 1;
    }
    return -1;
  }
  
  private Cursor a(String paramString)
  {
    Object localObject = null;
    paramString = acnh.a(paramString);
    paramString = "select name from sqlite_master where (type='table') and (name like 'qc/_%/_" + paramString + "' escape '/') and (name not like 'qc/_" + 3000 + "/_" + paramString + "' escape '/') and (name not like 'qc/_" + 8 + "/_" + paramString + "' escape '/') order by name;";
    try
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getReadableDatabase().rawQuery(paramString, null);
      return paramString;
    }
    catch (Exception localException)
    {
      do
      {
        paramString = localObject;
      } while (!QLog.isColorLevel());
      QLog.w("QCallProxy", 2, localException.getMessage(), localException);
    }
    return null;
  }
  
  private EntityManager a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen())) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen())) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      }
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
    }
  }
  
  private Object a(String arg1, int paramInt)
  {
    String str = a(???, paramInt);
    if (!this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str)) {}
    synchronized (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      if (!this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str)) {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, new Object());
      }
      return this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
    }
  }
  
  private String a(String paramString, int paramInt)
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().concat("_").concat(paramString);
    if (paramInt != 3000)
    {
      paramString = str;
      if (paramInt != 8) {}
    }
    else
    {
      paramString = str.concat(String.valueOf(paramInt));
    }
    return paramString;
  }
  
  private ArrayList<QCallRecord> a(List<QCallRecord> paramList)
  {
    if (paramList == null) {
      return null;
    }
    Collections.sort(paramList, new bapp(this));
    SparseIntArray localSparseIntArray = new SparseIntArray();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      QCallRecord localQCallRecord1 = (QCallRecord)localIterator.next();
      if ((localQCallRecord1 != null) && (localQCallRecord1.type != QCallRecord.TYPE_DATE))
      {
        if (localSparseIntArray.get(localQCallRecord1.getDate(), -1) == -1)
        {
          QCallRecord localQCallRecord2 = new QCallRecord(QCallRecord.TYPE_DATE);
          localQCallRecord2.time = localQCallRecord1.time;
          localArrayList.add(localQCallRecord2);
          localSparseIntArray.put(localQCallRecord1.getDate(), 0);
        }
        localArrayList.add(localQCallRecord1);
      }
    }
    paramList.clear();
    return localArrayList;
  }
  
  private void a(QCallRecent paramQCallRecent, boolean paramBoolean)
  {
    if ((paramQCallRecent == null) || (paramQCallRecent.uin == null) || (paramQCallRecent.uin.length() < 2)) {
      bhbx.a("QCallProxy");
    }
    while ((paramQCallRecent == null) || (paramQCallRecent.uin == null) || (paramQCallRecent.uin.length() < 2)) {
      return;
    }
    List localList = this.jdField_a_of_type_JavaUtilList;
    Object localObject1 = paramQCallRecent;
    for (;;)
    {
      try
      {
        if (paramQCallRecent.type != 1)
        {
          localObject1 = paramQCallRecent;
          if (paramQCallRecent.type != 3000)
          {
            localObject1 = paramQCallRecent;
            if (paramQCallRecent.type != 8)
            {
              localObject2 = new ArrayList();
              localObject1 = acnh.q;
              j = localObject1.length;
              i = 0;
              if (i < j)
              {
                int k = localObject1[i];
                if (k == paramQCallRecent.type) {
                  break label697;
                }
                QCallRecent localQCallRecent = (QCallRecent)this.jdField_a_of_type_JavaUtilMap.remove(b(paramQCallRecent.uin, k));
                if (localQCallRecent == null) {
                  break label697;
                }
                ((ArrayList)localObject2).add(localQCallRecent);
                break label697;
              }
              j = ((ArrayList)localObject2).size();
              localObject1 = paramQCallRecent;
              if (j > 0)
              {
                if (paramQCallRecent.getStatus() != 1000) {
                  break label692;
                }
                localObject1 = (QCallRecent)((ArrayList)localObject2).get(0);
                this.jdField_a_of_type_JavaUtilList.remove(localObject1);
                ((QCallRecent)localObject1).type = paramQCallRecent.type;
                ((QCallRecent)localObject1).troopUin = paramQCallRecent.troopUin;
                ((QCallRecent)localObject1).displayName = paramQCallRecent.displayName;
                ((QCallRecent)localObject1).lastCallTime = paramQCallRecent.lastCallTime;
                ((QCallRecent)localObject1).lastCallMsg = paramQCallRecent.lastCallMsg;
                ((QCallRecent)localObject1).sendFlag = paramQCallRecent.sendFlag;
                ((QCallRecent)localObject1).isVideo = paramQCallRecent.isVideo;
                ((QCallRecent)localObject1).missedCallCount = paramQCallRecent.missedCallCount;
                ((QCallRecent)localObject1).isLastCallRealMissed = paramQCallRecent.isLastCallRealMissed;
                i = 1;
                paramQCallRecent = (QCallRecent)localObject1;
                localObject1 = paramQCallRecent;
                if (i < j)
                {
                  localObject1 = (QCallRecent)((ArrayList)localObject2).get(i);
                  this.jdField_a_of_type_JavaUtilList.remove(localObject1);
                  a((QCallRecent)localObject1);
                  i += 1;
                  continue;
                }
              }
            }
          }
        }
        paramQCallRecent = this.jdField_a_of_type_JavaUtilMap.keySet();
        Object localObject2 = new String[paramQCallRecent.size()];
        paramQCallRecent.toArray((Object[])localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("QCallProxy", 2, "saveRecentCall before put:" + Arrays.toString((Object[])localObject2));
        }
        this.jdField_a_of_type_JavaUtilMap.put(b(((QCallRecent)localObject1).uin, ((QCallRecent)localObject1).type), localObject1);
        paramQCallRecent = this.jdField_a_of_type_JavaUtilMap.keySet();
        localObject2 = new String[paramQCallRecent.size()];
        paramQCallRecent.toArray((Object[])localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("QCallProxy", 2, "saveRecentCall after put:" + Arrays.toString((Object[])localObject2));
        }
        this.jdField_a_of_type_JavaUtilList.remove(localObject1);
        int j = this.jdField_a_of_type_JavaUtilList.size();
        i = 0;
        if (i < j)
        {
          paramQCallRecent = (QCallRecent)this.jdField_a_of_type_JavaUtilList.get(i);
          if (((QCallRecent)localObject1).lastCallTime > paramQCallRecent.lastCallTime)
          {
            this.jdField_a_of_type_JavaUtilList.add(i, localObject1);
            i = 1;
            if (i == 0) {
              this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_JavaUtilList.size(), localObject1);
            }
            if (!paramBoolean) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("QCallProxy", 2, "insertOrUpdateRecentCallToDB uin: " + ((QCallRecent)localObject1).uin + ",callstatus:" + ((QCallRecent)localObject1).state);
            }
            b((QCallRecent)localObject1);
            return;
          }
          i += 1;
          continue;
        }
        i = 0;
      }
      finally {}
      continue;
      label692:
      int i = 0;
      continue;
      label697:
      i += 1;
    }
  }
  
  private boolean a(QCallRecord paramQCallRecord)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.addMsgQueue(paramQCallRecord.friendUin, paramQCallRecord.uinType, paramQCallRecord.getTableName(), paramQCallRecord, 3, null);
    return true;
  }
  
  private boolean a(String paramString, int paramInt)
  {
    if ((paramInt == 3000) || (paramInt == 8)) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.addMsgQueue(paramString, paramInt, QCallRecord.getTableName(paramString, paramInt), null, null, 2, null);
    }
    for (;;)
    {
      return true;
      ThreadManager.post(new QCallProxy.3(this, paramString), 5, null, false);
    }
  }
  
  private String b(String paramString, int paramInt)
  {
    return paramString + "&" + paramInt;
  }
  
  /* Error */
  private List<QCallRecord> b(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: aload_0
    //   7: getfield 124	bapo:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10: invokevirtual 386	com/tencent/mobileqq/app/QQAppInterface:getWritableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   13: astore 8
    //   15: aload 8
    //   17: ifnonnull +5 -> 22
    //   20: aconst_null
    //   21: areturn
    //   22: iload_2
    //   23: sipush 3000
    //   26: if_icmpeq +9 -> 35
    //   29: iload_2
    //   30: bipush 8
    //   32: if_icmpne +164 -> 196
    //   35: aload_1
    //   36: iload_2
    //   37: invokestatic 366	com/tencent/mobileqq/data/QCallRecord:getTableName	(Ljava/lang/String;I)Ljava/lang/String;
    //   40: astore_1
    //   41: aload 8
    //   43: aload_1
    //   44: invokevirtual 389	com/tencent/mobileqq/app/SQLiteDatabase:getCount	(Ljava/lang/String;)I
    //   47: istore_2
    //   48: iload_2
    //   49: aload_0
    //   50: getfield 39	bapo:jdField_a_of_type_Int	I
    //   53: if_icmple +39 -> 92
    //   56: aload 8
    //   58: ldc_w 391
    //   61: iconst_3
    //   62: anewarray 34	java/lang/Object
    //   65: dup
    //   66: iconst_0
    //   67: aload_1
    //   68: aastore
    //   69: dup
    //   70: iconst_1
    //   71: aload_1
    //   72: aastore
    //   73: dup
    //   74: iconst_2
    //   75: iload_2
    //   76: aload_0
    //   77: getfield 39	bapo:jdField_a_of_type_Int	I
    //   80: isub
    //   81: invokestatic 394	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   84: aastore
    //   85: invokestatic 398	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   88: invokevirtual 402	com/tencent/mobileqq/app/SQLiteDatabase:execSQL	(Ljava/lang/String;)Z
    //   91: pop
    //   92: new 102	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   99: ldc_w 404
    //   102: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_1
    //   106: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: ldc_w 406
    //   112: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: astore_1
    //   119: aload_0
    //   120: invokespecial 408	bapo:a	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   123: ldc 217
    //   125: aload_1
    //   126: aconst_null
    //   127: invokevirtual 411	com/tencent/mobileqq/persistence/EntityManager:rawQuery	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/String;)Ljava/util/List;
    //   130: astore_1
    //   131: aload_1
    //   132: ifnull +310 -> 442
    //   135: invokestatic 416	bcrg:a	()J
    //   138: lstore 4
    //   140: aload_1
    //   141: invokeinterface 206 1 0
    //   146: astore 6
    //   148: aload 6
    //   150: invokeinterface 211 1 0
    //   155: ifeq +287 -> 442
    //   158: aload 6
    //   160: invokeinterface 215 1 0
    //   165: checkcast 217	com/tencent/mobileqq/data/QCallRecord
    //   168: astore 7
    //   170: aload 7
    //   172: ifnull -24 -> 148
    //   175: aload 7
    //   177: getfield 234	com/tencent/mobileqq/data/QCallRecord:time	J
    //   180: lload 4
    //   182: lcmp
    //   183: ifle -35 -> 148
    //   186: aload 7
    //   188: lload 4
    //   190: putfield 234	com/tencent/mobileqq/data/QCallRecord:time	J
    //   193: goto -45 -> 148
    //   196: aload_0
    //   197: aload_1
    //   198: invokespecial 95	bapo:a	(Ljava/lang/String;)Landroid/database/Cursor;
    //   201: astore_1
    //   202: aload_1
    //   203: ifnull +201 -> 404
    //   206: new 41	java/util/ArrayList
    //   209: dup
    //   210: invokespecial 200	java/util/ArrayList:<init>	()V
    //   213: astore 6
    //   215: aload_1
    //   216: ldc_w 418
    //   219: invokeinterface 423 2 0
    //   224: istore_2
    //   225: aload_1
    //   226: invokeinterface 426 1 0
    //   231: ifeq +173 -> 404
    //   234: aload_1
    //   235: iload_2
    //   236: invokeinterface 429 2 0
    //   241: invokestatic 434	com/tencent/mobileqq/utils/SecurityUtile:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   244: astore 7
    //   246: aload 8
    //   248: aload 7
    //   250: invokevirtual 389	com/tencent/mobileqq/app/SQLiteDatabase:getCount	(Ljava/lang/String;)I
    //   253: istore_3
    //   254: iload_3
    //   255: ifle -30 -> 225
    //   258: iload_3
    //   259: aload_0
    //   260: getfield 39	bapo:jdField_a_of_type_Int	I
    //   263: if_icmple +41 -> 304
    //   266: aload 8
    //   268: ldc_w 391
    //   271: iconst_3
    //   272: anewarray 34	java/lang/Object
    //   275: dup
    //   276: iconst_0
    //   277: aload 7
    //   279: aastore
    //   280: dup
    //   281: iconst_1
    //   282: aload 7
    //   284: aastore
    //   285: dup
    //   286: iconst_2
    //   287: iload_3
    //   288: aload_0
    //   289: getfield 39	bapo:jdField_a_of_type_Int	I
    //   292: isub
    //   293: invokestatic 394	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   296: aastore
    //   297: invokestatic 398	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   300: invokevirtual 402	com/tencent/mobileqq/app/SQLiteDatabase:execSQL	(Ljava/lang/String;)Z
    //   303: pop
    //   304: new 102	java/lang/StringBuilder
    //   307: dup
    //   308: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   311: ldc_w 404
    //   314: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: aload 7
    //   319: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: ldc_w 406
    //   325: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   331: astore 7
    //   333: aload_0
    //   334: invokespecial 408	bapo:a	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   337: ldc 217
    //   339: aload 7
    //   341: aconst_null
    //   342: invokevirtual 411	com/tencent/mobileqq/persistence/EntityManager:rawQuery	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/String;)Ljava/util/List;
    //   345: astore 7
    //   347: aload 7
    //   349: ifnull +13 -> 362
    //   352: aload 6
    //   354: aload 7
    //   356: invokeinterface 438 2 0
    //   361: pop
    //   362: aload 6
    //   364: new 440	bapq
    //   367: dup
    //   368: aload_0
    //   369: invokespecial 441	bapq:<init>	(Lbapo;)V
    //   372: invokestatic 196	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   375: goto -150 -> 225
    //   378: astore 7
    //   380: aload_1
    //   381: astore 7
    //   383: aload 6
    //   385: astore_1
    //   386: aload 7
    //   388: ifnull -257 -> 131
    //   391: aload 7
    //   393: invokeinterface 444 1 0
    //   398: aload 6
    //   400: astore_1
    //   401: goto -270 -> 131
    //   404: aload_1
    //   405: ifnull +65 -> 470
    //   408: aload_1
    //   409: invokeinterface 444 1 0
    //   414: aload 6
    //   416: astore_1
    //   417: goto -286 -> 131
    //   420: astore_1
    //   421: aconst_null
    //   422: astore 7
    //   424: aload_1
    //   425: astore 6
    //   427: aload 7
    //   429: ifnull +10 -> 439
    //   432: aload 7
    //   434: invokeinterface 444 1 0
    //   439: aload 6
    //   441: athrow
    //   442: aload_1
    //   443: areturn
    //   444: astore 6
    //   446: aload_1
    //   447: astore 7
    //   449: goto -22 -> 427
    //   452: astore_1
    //   453: aconst_null
    //   454: astore 6
    //   456: goto -73 -> 383
    //   459: astore 6
    //   461: aconst_null
    //   462: astore 6
    //   464: aload_1
    //   465: astore 7
    //   467: goto -84 -> 383
    //   470: aload 6
    //   472: astore_1
    //   473: goto -342 -> 131
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	476	0	this	bapo
    //   0	476	1	paramString	String
    //   0	476	2	paramInt	int
    //   253	40	3	i	int
    //   138	51	4	l	long
    //   1	439	6	localObject1	Object
    //   444	1	6	localObject2	Object
    //   454	1	6	localObject3	Object
    //   459	1	6	localException1	Exception
    //   462	9	6	localObject4	Object
    //   4	351	7	localObject5	Object
    //   378	1	7	localException2	Exception
    //   381	85	7	str	String
    //   13	254	8	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   215	225	378	java/lang/Exception
    //   225	254	378	java/lang/Exception
    //   258	304	378	java/lang/Exception
    //   304	347	378	java/lang/Exception
    //   352	362	378	java/lang/Exception
    //   362	375	378	java/lang/Exception
    //   196	202	420	finally
    //   206	215	444	finally
    //   215	225	444	finally
    //   225	254	444	finally
    //   258	304	444	finally
    //   304	347	444	finally
    //   352	362	444	finally
    //   362	375	444	finally
    //   196	202	452	java/lang/Exception
    //   206	215	459	java/lang/Exception
  }
  
  public QCallRecent a(String paramString, int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      QCallRecent localQCallRecent2 = (QCallRecent)this.jdField_a_of_type_JavaUtilMap.get(b(paramString, paramInt));
      QCallRecent localQCallRecent1 = localQCallRecent2;
      if (localQCallRecent2 == null)
      {
        localQCallRecent1 = new QCallRecent();
        localQCallRecent1.uin = paramString;
        localQCallRecent1.type = paramInt;
        localQCallRecent1.displayName = localQCallRecent1.uin;
      }
      return localQCallRecent1;
    }
  }
  
  public List<QCallRecent> a()
  {
    return a(null);
  }
  
  public List<QCallRecent> a(bapr arg1)
  {
    ThreadManager.post(new QCallProxy.5(this, ???), 5, null, false);
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        QCallRecent localQCallRecent = (QCallRecent)localIterator.next();
        if ((localQCallRecent == null) || (localQCallRecent.uin == null) || (localQCallRecent.uin.length() < 2)) {
          bhbx.a("QCallProxy");
        }
        if ((localQCallRecent != null) && (localQCallRecent.uin != null) && (localQCallRecent.uin.length() >= 2)) {
          localArrayList.add(localQCallRecent);
        }
      }
    }
    return localList;
  }
  
  public List<QCallRecord> a(String paramString, int paramInt)
  {
    String str = a(paramString, paramInt);
    Object localObject = a(paramString, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("QCallProxy", 2, "getListRecord ThreadName:" + Thread.currentThread().getName() + " getListRecord friendUin:" + paramString + ",uinType:" + paramInt);
    }
    try
    {
      List localList = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
      if (localList != null) {
        return localList;
      }
      localList = b(paramString, paramInt);
      paramString = localList;
      if (localList == null) {
        paramString = new ArrayList();
      }
      if (QLog.isColorLevel())
      {
        QLog.d("QCallProxy", 2, "getListRecord ThreadName:" + Thread.currentThread().getName() + " getListRecord (DB) records size:" + paramString.size());
        QLog.d("QCallProxy", 2, "getListRecord" + paramString);
      }
      paramString = a(paramString);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramString);
      return paramString;
    }
    finally {}
  }
  
  protected void a()
  {
    if (jdField_a_of_type_Boolean) {
      return;
    }
    jdField_a_of_type_Boolean = true;
    ThreadManager.excute(new QCallProxy.1(this), 32, null, true);
  }
  
  public void a(QCallRecent paramQCallRecent)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramQCallRecent);
      this.jdField_a_of_type_JavaUtilMap.remove(b(paramQCallRecent.uin, paramQCallRecent.type));
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.addMsgQueueDonotNotify(paramQCallRecent.uin, paramQCallRecent.type, paramQCallRecent.getTableName(), paramQCallRecent, 5, null);
      return;
    }
  }
  
  public void a(QCallRecord paramQCallRecord)
  {
    if (paramQCallRecord == null) {
      return;
    }
    for (;;)
    {
      synchronized (a(paramQCallRecord.friendUin, paramQCallRecord.uinType))
      {
        String str = a(paramQCallRecord.friendUin, paramQCallRecord.uinType);
        List localList = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
        if (localList == null)
        {
          localList = a(paramQCallRecord.friendUin, paramQCallRecord.uinType);
          localList.add(paramQCallRecord);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder().append("insertRecord ThreadName:").append(Thread.currentThread().getName()).append(" insertRecord records size:");
            if (localList != null)
            {
              i = localList.size();
              QLog.d("QCallProxy", 2, i);
            }
          }
          else
          {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, a(localList));
            a(paramQCallRecord);
            return;
          }
          int i = 0;
        }
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    Object localObject = a(paramString, paramInt);
    localObject = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
    if (localObject != null) {
      ((List)localObject).clear();
    }
    a(paramString, paramInt);
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    if (!a(paramString1, paramInt1).equals(a(paramString2, paramInt2)))
    {
      Object localObject = a(paramString1, paramInt1);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          QCallRecord localQCallRecord = (QCallRecord)((Iterator)localObject).next();
          localQCallRecord.friendUin = paramString2;
          localQCallRecord.uinType = paramInt2;
          a(localQCallRecord);
        }
        a(paramString1, paramInt1);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).edit();
    localEditor.putBoolean("Conversation_call_prompt_flag", false);
    localEditor.commit();
  }
  
  public boolean a()
  {
    return (this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilList.size() > 0);
  }
  
  public QCallRecent b(String paramString, int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      paramString = (QCallRecent)this.jdField_a_of_type_JavaUtilMap.get(b(paramString, paramInt));
      return paramString;
    }
  }
  
  protected void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen())) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.close();
    }
    e();
    c();
    jdField_a_of_type_Boolean = false;
  }
  
  public void b(QCallRecent paramQCallRecent)
  {
    if (paramQCallRecent.getStatus() == 1000)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.addMsgQueueDonotNotify(paramQCallRecent.uin, paramQCallRecent.type, paramQCallRecent.getTableName(), paramQCallRecent, 3, null);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.addMsgQueueDonotNotify(paramQCallRecent.uin, paramQCallRecent.type, paramQCallRecent.getTableName(), paramQCallRecent, 4, null);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
  }
  
  public void c(QCallRecent paramQCallRecent)
  {
    a(paramQCallRecent, false);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QCallProxy", 2, "recentDoInit ====start====");
    }
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getBoolean("Conversation_call_prompt_flag", true);
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    List localList2;
    Object localObject5;
    Object localObject4;
    try
    {
      List localList1 = localEntityManager.query(QCallRecent.class, false, null, null, null, null, "lastCallTime desc", null);
      localList2 = this.jdField_a_of_type_JavaUtilList;
      if (localList1 == null) {
        break label515;
      }
      long l1;
      boolean bool;
      Object localObject1;
      label284:
      try
      {
        if (localList1.size() <= 0) {
          break label515;
        }
        localObject5 = localList1;
        if (localList1.size() > 100)
        {
          l1 = System.currentTimeMillis();
          localObject4 = localList1;
        }
      }
      finally {}
    }
    finally
    {
      localEntityManager.close();
    }
    try
    {
      bool = localEntityManager.execSQL("delete from" + "recent_call" + " where lastCallTime < " + ((QCallRecent)localList1.get(90)).lastCallTime + ";");
      localObject1 = localList1;
      if (bool)
      {
        localObject4 = localList1;
        localObject1 = new ArrayList(localList1.subList(0, 90));
      }
      localObject5 = localObject1;
      localObject4 = localObject1;
      if (QLog.isColorLevel())
      {
        localObject4 = localObject1;
        long l2 = System.currentTimeMillis();
        localObject4 = localObject1;
        QLog.d("QCallProxy", 2, "doInit cache data > 100 isOk = " + bool + ",time:" + (l2 - l1));
        localObject5 = localObject1;
      }
    }
    catch (Exception localException)
    {
      localObject5 = localObject4;
      if (!QLog.isDevelopLevel()) {
        break label284;
      }
      QLog.e("QCallProxy", 4, localException.getMessage(), localException);
      localObject5 = localObject4;
      break label284;
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    localObject1 = ((List)localObject5).iterator();
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localObject4 = (QCallRecent)((Iterator)localObject1).next();
        if ((((QCallRecent)localObject4).state == 5) || (((QCallRecent)localObject4).state == 6) || (((QCallRecent)localObject4).state == 7) || (((QCallRecent)localObject4).state == 1)) {
          ((QCallRecent)localObject4).state = 0;
        }
        if ((((QCallRecent)localObject4).uin != null) && (((QCallRecent)localObject4).uin.length() >= 2)) {
          this.jdField_a_of_type_JavaUtilList.add(localObject4);
        }
      }
      else
      {
        Iterator localIterator;
        while (localIterator.hasNext())
        {
          localObject4 = (QCallRecent)localIterator.next();
          this.jdField_a_of_type_JavaUtilMap.put(b(((QCallRecent)localObject4).uin, ((QCallRecent)localObject4).type), localObject4);
        }
      }
    }
    label515:
    if (QLog.isDevelopLevel()) {
      QLog.d("QCallProxy", 4, this.jdField_a_of_type_JavaUtilList.toString());
    }
    localEntityManager.close();
    if (QLog.isColorLevel()) {
      QLog.d("QCallProxy", 2, "recentDoInit ====end====");
    }
  }
  
  public void d(QCallRecent paramQCallRecent)
  {
    a(paramQCallRecent, true);
  }
  
  public void e()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilMap.clear();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bapo
 * JD-Core Version:    0.7.0.1
 */