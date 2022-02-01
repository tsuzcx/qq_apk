import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msgbackup.data.MsgBackupExtraEntity;
import com.tencent.mobileqq.msgbackup.data.MsgBackupMsgEntity;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManagerFactory.SQLiteOpenHelperImpl;
import com.tencent.mobileqq.persistence.NoColumnError;
import com.tencent.mobileqq.persistence.NoColumnErrorHandler;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class awoe
  extends EntityManagerFactory
{
  public awoe(String paramString)
  {
    super(paramString);
  }
  
  /* Error */
  public int a(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore_2
    //   5: aload_0
    //   6: getfield 19	awoe:mInnerDbHelper	Lcom/tencent/mobileqq/persistence/EntityManagerFactory$SQLiteOpenHelperImpl;
    //   9: invokevirtual 25	com/tencent/mobileqq/persistence/EntityManagerFactory$SQLiteOpenHelperImpl:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   12: astore 5
    //   14: aload 5
    //   16: ifnonnull +16 -> 32
    //   19: ldc 27
    //   21: ldc 29
    //   23: iconst_0
    //   24: anewarray 31	java/lang/Object
    //   27: invokestatic 36	awqu:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   30: iconst_0
    //   31: ireturn
    //   32: iload 4
    //   34: istore_3
    //   35: aload 5
    //   37: new 38	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   44: ldc 43
    //   46: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_1
    //   50: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: aconst_null
    //   57: invokevirtual 57	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   60: astore_1
    //   61: aload_1
    //   62: ifnull -32 -> 30
    //   65: aload_1
    //   66: invokeinterface 63 1 0
    //   71: ifeq +11 -> 82
    //   74: aload_1
    //   75: iconst_0
    //   76: invokeinterface 67 2 0
    //   81: istore_2
    //   82: iload_2
    //   83: istore_3
    //   84: aload_1
    //   85: invokeinterface 70 1 0
    //   90: iload_2
    //   91: ireturn
    //   92: astore_1
    //   93: ldc 27
    //   95: iconst_1
    //   96: new 38	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   103: ldc 72
    //   105: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: aload_1
    //   109: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   118: iload_3
    //   119: ireturn
    //   120: astore 5
    //   122: ldc 27
    //   124: iconst_1
    //   125: new 38	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   132: ldc 83
    //   134: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload 5
    //   139: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   148: iload 4
    //   150: istore_3
    //   151: aload_1
    //   152: invokeinterface 70 1 0
    //   157: iconst_0
    //   158: ireturn
    //   159: astore 5
    //   161: iload 4
    //   163: istore_3
    //   164: aload_1
    //   165: invokeinterface 70 1 0
    //   170: iload 4
    //   172: istore_3
    //   173: aload 5
    //   175: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	awoe
    //   0	176	1	paramString	String
    //   4	87	2	i	int
    //   34	139	3	j	int
    //   1	170	4	k	int
    //   12	24	5	localSQLiteDatabase	SQLiteDatabase
    //   120	18	5	localThrowable	Throwable
    //   159	15	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   35	61	92	java/lang/Exception
    //   84	90	92	java/lang/Exception
    //   151	157	92	java/lang/Exception
    //   164	170	92	java/lang/Exception
    //   173	176	92	java/lang/Exception
    //   65	82	120	java/lang/Throwable
    //   65	82	159	finally
    //   122	148	159	finally
  }
  
  public Entity a(Class<? extends Entity> paramClass, String paramString, Cursor paramCursor, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    if (paramCursor.isBeforeFirst()) {
      paramCursor.moveToFirst();
    }
    long l = -1L;
    try
    {
      if (paramCursor.getColumnIndex("_id") >= 0) {
        l = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          paramClass = (Entity)paramClass.newInstance();
          a(paramString, paramCursor, paramNoColumnErrorHandler, l, paramClass);
          return paramClass;
        }
        catch (Exception paramClass)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("MsgBackup_db", 2, MsfSdkUtils.getStackTraceString(paramClass));
          return null;
        }
        catch (OutOfMemoryError paramClass)
        {
          if (!QLog.isColorLevel()) {
            break label115;
          }
          QLog.e("MsgBackup_db", 2, MsfSdkUtils.getStackTraceString(paramClass));
        }
        localException = localException;
        l = -1L;
      }
    }
    label115:
    return null;
  }
  
  public List<MsgBackupExtraEntity> a()
  {
    Object localObject1 = String.format("select * from %s", new Object[] { "ex_info" });
    Object localObject2 = this.mInnerDbHelper.getWritableDatabase();
    if (localObject2 == null)
    {
      awqu.a("MsgBackup_db", "db is null queryExtraInfo ...", new Object[0]);
      return new ArrayList();
    }
    localObject1 = ((SQLiteDatabase)localObject2).rawQuery((String)localObject1, null);
    localObject2 = a(MsgBackupExtraEntity.class, "ex_info", (Cursor)localObject1, null);
    ((Cursor)localObject1).close();
    return localObject2;
  }
  
  public List<MsgBackupMsgEntity> a(long paramLong, int paramInt)
  {
    Object localObject1 = String.format("select * from %s where _id>=%d limit %d", new Object[] { "msg", Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    Object localObject2 = this.mInnerDbHelper.getWritableDatabase();
    if (localObject2 == null)
    {
      awqu.a("MsgBackup_db", "db is null queryMsg ..125.", new Object[0]);
      return new ArrayList();
    }
    localObject1 = ((SQLiteDatabase)localObject2).rawQuery((String)localObject1, null);
    localObject2 = a(MsgBackupMsgEntity.class, "msg", (Cursor)localObject1, null);
    ((Cursor)localObject1).close();
    return localObject2;
  }
  
  public List<MsgBackupResEntity> a(long paramLong1, long paramLong2)
  {
    Object localObject1 = String.format("select * from %s where msgSeq = %d and msgRandom = %d", new Object[] { "res", Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    Object localObject2 = this.mInnerDbHelper.getWritableDatabase();
    if (localObject2 == null)
    {
      awqu.a("MsgBackup_db", "db is null queryRes ...", new Object[0]);
      return new ArrayList();
    }
    localObject1 = ((SQLiteDatabase)localObject2).rawQuery((String)localObject1, null);
    localObject2 = a(MsgBackupResEntity.class, "res", (Cursor)localObject1, null);
    ((Cursor)localObject1).close();
    return localObject2;
  }
  
  protected List<? extends Entity> a(Class<? extends Entity> paramClass, String paramString, Cursor paramCursor, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    localObject4 = null;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramCursor != null)
    {
      localObject1 = localObject2;
      localObject2 = localObject4;
    }
    try
    {
      int i;
      if (paramCursor.moveToFirst())
      {
        localObject2 = localObject4;
        i = paramCursor.getCount();
        localObject1 = null;
      }
      Entity localEntity;
      label112:
      boolean bool;
      Object localObject3;
      for (;;)
      {
        localObject4 = localObject1;
      }
    }
    catch (Exception paramClass)
    {
      do
      {
        try
        {
          localEntity = a(paramClass, paramString, paramCursor, paramNoColumnErrorHandler);
          localObject2 = localObject1;
          if (localEntity != null)
          {
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject4 = localObject1;
            }
          }
          try
          {
            localObject2 = new ArrayList(i);
            localObject4 = localObject2;
            ((List)localObject2).add(localEntity);
            localObject1 = localObject2;
          }
          catch (Throwable localThrowable)
          {
            break label112;
          }
          localObject2 = localObject1;
          bool = paramCursor.moveToNext();
          if (bool) {
            break label169;
          }
          return localObject1;
        }
        catch (Exception paramClass)
        {
          for (;;)
          {
            localObject3 = localObject4;
          }
        }
        paramClass = paramClass;
        localObject1 = localThrowable;
      } while (!QLog.isColorLevel());
      QLog.e("MsgBackup_db", 2, MsfSdkUtils.getStackTraceString(paramClass));
      return localThrowable;
    }
  }
  
  protected void a(String paramString, Cursor paramCursor, NoColumnErrorHandler paramNoColumnErrorHandler, long paramLong, Entity paramEntity)
  {
    if (paramEntity != null)
    {
      paramEntity.setId(paramLong);
      List localList = TableBuilder.getValidField(paramEntity);
      int j = localList.size();
      int i = 0;
      if (i < j)
      {
        Field localField = (Field)localList.get(i);
        Class localClass = localField.getType();
        String str = localField.getName();
        int k = paramCursor.getColumnIndex(str);
        if (k != -1)
        {
          if (!localField.isAccessible()) {
            localField.setAccessible(true);
          }
          if (localClass == Long.TYPE) {
            localField.set(paramEntity, Long.valueOf(paramCursor.getLong(k)));
          }
        }
        for (;;)
        {
          i += 1;
          break;
          if (localClass == Integer.TYPE)
          {
            localField.set(paramEntity, Integer.valueOf(paramCursor.getInt(k)));
          }
          else if (localClass == String.class)
          {
            localField.set(paramEntity, paramCursor.getString(k));
          }
          else if (localClass == Byte.TYPE)
          {
            localField.set(paramEntity, Byte.valueOf((byte)paramCursor.getShort(k)));
          }
          else if (localClass == [B.class)
          {
            localField.set(paramEntity, paramCursor.getBlob(k));
          }
          else if (localClass == Short.TYPE)
          {
            localField.set(paramEntity, Short.valueOf(paramCursor.getShort(k)));
          }
          else
          {
            if (localClass == Boolean.TYPE)
            {
              if (paramCursor.getInt(k) != 0) {}
              for (boolean bool = true;; bool = false)
              {
                localField.set(paramEntity, Boolean.valueOf(bool));
                break;
              }
            }
            if (localClass == Float.TYPE)
            {
              localField.set(paramEntity, Float.valueOf(paramCursor.getFloat(k)));
            }
            else if (localClass == Double.TYPE)
            {
              localField.set(paramEntity, Double.valueOf(paramCursor.getDouble(k)));
              continue;
              if (paramNoColumnErrorHandler != null) {
                paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError(str, localClass));
              }
            }
          }
        }
      }
      if ((paramLong == -1L) || (paramString == null)) {
        break label432;
      }
      paramEntity.setStatus(1001);
      if (!(paramEntity instanceof MsgBackupMsgEntity)) {
        break label443;
      }
      ((MsgBackupMsgEntity)paramEntity).postRead();
    }
    label432:
    label443:
    while (!(paramEntity instanceof MsgBackupResEntity))
    {
      return;
      paramEntity.setStatus(1002);
      break;
    }
    ((MsgBackupResEntity)paramEntity).postRead();
  }
  
  public void a(List<MsgBackupExtraEntity> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    ContentValues localContentValues = new ContentValues();
    SQLiteDatabase localSQLiteDatabase = this.mInnerDbHelper.getWritableDatabase();
    localSQLiteDatabase.beginTransaction();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MsgBackupExtraEntity localMsgBackupExtraEntity = (MsgBackupExtraEntity)paramList.next();
      localContentValues.put("name", localMsgBackupExtraEntity.name);
      localContentValues.put("value", localMsgBackupExtraEntity.value);
      localSQLiteDatabase.insert("ex_info", null, localContentValues);
    }
    localSQLiteDatabase.setTransactionSuccessful();
    localSQLiteDatabase.endTransaction();
  }
  
  /* Error */
  public int b(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore_2
    //   5: aload_0
    //   6: getfield 19	awoe:mInnerDbHelper	Lcom/tencent/mobileqq/persistence/EntityManagerFactory$SQLiteOpenHelperImpl;
    //   9: invokevirtual 25	com/tencent/mobileqq/persistence/EntityManagerFactory$SQLiteOpenHelperImpl:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   12: astore 5
    //   14: aload 5
    //   16: ifnonnull +17 -> 33
    //   19: ldc 27
    //   21: ldc_w 355
    //   24: iconst_0
    //   25: anewarray 31	java/lang/Object
    //   28: invokestatic 36	awqu:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   31: iconst_0
    //   32: ireturn
    //   33: iload 4
    //   35: istore_3
    //   36: aload 5
    //   38: new 38	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   45: ldc 43
    //   47: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload_1
    //   51: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: aconst_null
    //   58: invokevirtual 57	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   61: astore_1
    //   62: aload_1
    //   63: ifnull -32 -> 31
    //   66: aload_1
    //   67: invokeinterface 63 1 0
    //   72: ifeq +11 -> 83
    //   75: aload_1
    //   76: iconst_0
    //   77: invokeinterface 67 2 0
    //   82: istore_2
    //   83: iload_2
    //   84: istore_3
    //   85: aload_1
    //   86: invokeinterface 70 1 0
    //   91: iload_2
    //   92: ireturn
    //   93: astore_1
    //   94: ldc 27
    //   96: iconst_1
    //   97: new 38	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   104: ldc_w 357
    //   107: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload_1
    //   111: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   120: iload_3
    //   121: ireturn
    //   122: astore 5
    //   124: ldc 27
    //   126: iconst_1
    //   127: new 38	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   134: ldc 83
    //   136: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: aload 5
    //   141: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   150: iload 4
    //   152: istore_3
    //   153: aload_1
    //   154: invokeinterface 70 1 0
    //   159: iconst_0
    //   160: ireturn
    //   161: astore 5
    //   163: iload 4
    //   165: istore_3
    //   166: aload_1
    //   167: invokeinterface 70 1 0
    //   172: iload 4
    //   174: istore_3
    //   175: aload 5
    //   177: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	this	awoe
    //   0	178	1	paramString	String
    //   4	88	2	i	int
    //   35	140	3	j	int
    //   1	172	4	k	int
    //   12	25	5	localSQLiteDatabase	SQLiteDatabase
    //   122	18	5	localThrowable	Throwable
    //   161	15	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   36	62	93	java/lang/Exception
    //   85	91	93	java/lang/Exception
    //   153	159	93	java/lang/Exception
    //   166	172	93	java/lang/Exception
    //   175	178	93	java/lang/Exception
    //   66	83	122	java/lang/Throwable
    //   66	83	161	finally
    //   124	150	161	finally
  }
  
  public List<MsgBackupResEntity> b(long paramLong, int paramInt)
  {
    Object localObject1 = String.format("select * from %s where _id>=%d limit %d", new Object[] { "res", Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    Object localObject2 = this.mInnerDbHelper.getWritableDatabase();
    if (localObject2 == null)
    {
      awqu.a("MsgBackup_db", "db is null queryRes ...135", new Object[0]);
      return new ArrayList();
    }
    localObject1 = ((SQLiteDatabase)localObject2).rawQuery((String)localObject1, null);
    localObject2 = a(MsgBackupResEntity.class, "res", (Cursor)localObject1, null);
    ((Cursor)localObject1).close();
    return localObject2;
  }
  
  public void b(List<MsgBackupMsgEntity> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    ContentValues localContentValues = new ContentValues();
    SQLiteDatabase localSQLiteDatabase = this.mInnerDbHelper.getWritableDatabase();
    localSQLiteDatabase.beginTransaction();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MsgBackupMsgEntity localMsgBackupMsgEntity = (MsgBackupMsgEntity)paramList.next();
      localMsgBackupMsgEntity.prewrite();
      localContentValues.put("chatUin", localMsgBackupMsgEntity.chatUin);
      localContentValues.put("chatType", Integer.valueOf(localMsgBackupMsgEntity.chatType));
      localContentValues.put("msgType", Integer.valueOf(localMsgBackupMsgEntity.msgType));
      localContentValues.put("msgTime", Long.valueOf(localMsgBackupMsgEntity.msgTime));
      localContentValues.put("msgSeq", Long.valueOf(localMsgBackupMsgEntity.msgSeq));
      localContentValues.put("msgRandom", Long.valueOf(localMsgBackupMsgEntity.msgRandom));
      localContentValues.put("extensionData", localMsgBackupMsgEntity.extensionData);
      localContentValues.put("extraData", localMsgBackupMsgEntity.extraData);
      localSQLiteDatabase.insert("msg", null, localContentValues);
    }
    localSQLiteDatabase.setTransactionSuccessful();
    localSQLiteDatabase.endTransaction();
  }
  
  public SQLiteOpenHelper build(String paramString)
  {
    if (this.mInnerDbHelper == null)
    {
      this.mInnerDbHelper = new EntityManagerFactory.SQLiteOpenHelperImpl(this, paramString, null, 1);
      this.dbHelper = new SQLiteOpenHelper(this.mInnerDbHelper);
      createDatabase(this.mInnerDbHelper.getWritableDatabase());
    }
    return this.dbHelper;
  }
  
  public void c(List<MsgBackupResEntity> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    ContentValues localContentValues = new ContentValues();
    SQLiteDatabase localSQLiteDatabase = this.mInnerDbHelper.getWritableDatabase();
    localSQLiteDatabase.beginTransaction();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MsgBackupResEntity localMsgBackupResEntity = (MsgBackupResEntity)paramList.next();
      localMsgBackupResEntity.prewrite();
      localContentValues.put("msgSeq", Long.valueOf(localMsgBackupResEntity.msgSeq));
      localContentValues.put("msgRandom", Long.valueOf(localMsgBackupResEntity.msgRandom));
      localContentValues.put("msgType", Integer.valueOf(localMsgBackupResEntity.msgType));
      localContentValues.put("msgSubType", Integer.valueOf(localMsgBackupResEntity.msgSubType));
      localContentValues.put("filePath", localMsgBackupResEntity.filePath);
      localContentValues.put("fileSize", Long.valueOf(localMsgBackupResEntity.fileSize));
      localContentValues.put("extraData", localMsgBackupResEntity.extraData);
      localSQLiteDatabase.insert("res", null, localContentValues);
    }
    localSQLiteDatabase.setTransactionSuccessful();
    localSQLiteDatabase.endTransaction();
  }
  
  public void createDatabase(SQLiteDatabase paramSQLiteDatabase)
  {
    if (paramSQLiteDatabase == null)
    {
      awqu.b("MsgBackup_db", "db create is null", new Object[0]);
      return;
    }
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new MsgBackupMsgEntity()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new MsgBackupResEntity()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new MsgBackupExtraEntity()));
  }
  
  public String getPackageName()
  {
    return getClass().getPackage().getName();
  }
  
  public boolean isNeedEncrypt()
  {
    return false;
  }
  
  public void upgradeDatabase(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awoe
 * JD-Core Version:    0.7.0.1
 */