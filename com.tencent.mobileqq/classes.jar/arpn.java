import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.QQEntityManagerFactory.SQLiteOpenHelperImpl;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msgbackup.data.MsgBackupExtraEntity;
import com.tencent.mobileqq.msgbackup.data.MsgBackupMsgEntity;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.mobileqq.persistence.NoColumnError;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class arpn
  extends QQEntityManagerFactory
{
  public arpn(String paramString)
  {
    super(paramString);
  }
  
  public int a(String paramString)
  {
    int i = 0;
    SQLiteDatabase localSQLiteDatabase = this.mInnerDbHelper.getWritableDatabase();
    if (localSQLiteDatabase == null) {
      arsc.a("MsgBackup_db", "db is null queryMsgTotalCount ...", new Object[0]);
    }
    do
    {
      return 0;
      paramString = localSQLiteDatabase.rawQuery("select count() from " + paramString, null);
    } while (paramString == null);
    try
    {
      if (paramString.moveToFirst()) {
        i = paramString.getInt(0);
      }
      return i;
    }
    catch (Throwable localThrowable)
    {
      QLog.d("MsgBackup_db", 1, "queryResTotalCount:" + localThrowable);
      return 0;
    }
    finally
    {
      paramString.close();
    }
  }
  
  public atmo a(Class<? extends atmo> paramClass, String paramString, Cursor paramCursor, atmz paramatmz)
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
      for (;;)
      {
        atmo localatmo;
        int i;
        Field localField;
        Class localClass;
        String str;
        int k;
        try
        {
          localatmo = (atmo)paramClass.newInstance();
          paramClass = localatmo;
          if (localatmo != null)
          {
            localatmo.setId(l);
            paramClass = atnp.a(localatmo);
            int j = paramClass.size();
            i = 0;
            if (i >= j) {
              break label481;
            }
            localField = (Field)paramClass.get(i);
            localClass = localField.getType();
            str = localField.getName();
            k = paramCursor.getColumnIndex(str);
            if (k == -1) {
              break label455;
            }
            if (!localField.isAccessible()) {
              localField.setAccessible(true);
            }
            if (localClass == Long.TYPE) {
              localField.set(localatmo, Long.valueOf(paramCursor.getLong(k)));
            } else if (localClass == Integer.TYPE) {
              localField.set(localatmo, Integer.valueOf(paramCursor.getInt(k)));
            }
          }
        }
        catch (Exception paramClass)
        {
          if (QLog.isColorLevel()) {
            QLog.e("MsgBackup_db", 2, MsfSdkUtils.getStackTraceString(paramClass));
          }
          paramClass = null;
          return paramClass;
          if (localClass == String.class) {
            localField.set(localatmo, paramCursor.getString(k));
          }
        }
        catch (OutOfMemoryError paramClass)
        {
          if (QLog.isColorLevel()) {
            QLog.e("MsgBackup_db", 2, MsfSdkUtils.getStackTraceString(paramClass));
          }
          return null;
        }
        if (localClass == Byte.TYPE)
        {
          localField.set(localatmo, Byte.valueOf((byte)paramCursor.getShort(k)));
        }
        else if (localClass == [B.class)
        {
          localField.set(localatmo, paramCursor.getBlob(k));
        }
        else if (localClass == Short.TYPE)
        {
          localField.set(localatmo, Short.valueOf(paramCursor.getShort(k)));
        }
        else if (localClass == Boolean.TYPE)
        {
          if (paramCursor.getInt(k) == 0) {
            break;
          }
          bool = true;
          localField.set(localatmo, Boolean.valueOf(bool));
        }
        else if (localClass == Float.TYPE)
        {
          localField.set(localatmo, Float.valueOf(paramCursor.getFloat(k)));
        }
        else if (localClass == Double.TYPE)
        {
          localField.set(localatmo, Double.valueOf(paramCursor.getDouble(k)));
          break label554;
          label455:
          if (paramatmz != null)
          {
            paramatmz.a(new NoColumnError(str, localClass));
            break label554;
            label481:
            if ((l != -1L) && (paramString != null)) {
              localatmo.setStatus(1001);
            }
            while ((localatmo instanceof MsgBackupMsgEntity))
            {
              ((MsgBackupMsgEntity)localatmo).postRead();
              return localatmo;
              localatmo.setStatus(1002);
            }
            paramClass = localatmo;
            if (!(localatmo instanceof MsgBackupResEntity)) {
              continue;
            }
            ((MsgBackupResEntity)localatmo).postRead();
            return localatmo;
          }
        }
        label554:
        i += 1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        l = -1L;
        continue;
        boolean bool = false;
      }
    }
  }
  
  public List<MsgBackupExtraEntity> a()
  {
    Object localObject1 = String.format("select * from %s", new Object[] { "ex_info" });
    Object localObject2 = this.mInnerDbHelper.getWritableDatabase();
    if (localObject2 == null)
    {
      arsc.a("MsgBackup_db", "db is null queryExtraInfo ...", new Object[0]);
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
      arsc.a("MsgBackup_db", "db is null queryMsg ..125.", new Object[0]);
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
      arsc.a("MsgBackup_db", "db is null queryRes ...", new Object[0]);
      return new ArrayList();
    }
    localObject1 = ((SQLiteDatabase)localObject2).rawQuery((String)localObject1, null);
    localObject2 = a(MsgBackupResEntity.class, "res", (Cursor)localObject1, null);
    ((Cursor)localObject1).close();
    return localObject2;
  }
  
  protected List<? extends atmo> a(Class<? extends atmo> paramClass, String paramString, Cursor paramCursor, atmz paramatmz)
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
      atmo localatmo;
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
          localatmo = a(paramClass, paramString, paramCursor, paramatmz);
          localObject2 = localObject1;
          if (localatmo != null)
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
            ((List)localObject2).add(localatmo);
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
  
  public int b(String paramString)
  {
    int i = 0;
    SQLiteDatabase localSQLiteDatabase = this.mInnerDbHelper.getWritableDatabase();
    if (localSQLiteDatabase == null) {
      arsc.a("MsgBackup_db", "db is null queryResTotalCount ...", new Object[0]);
    }
    do
    {
      return 0;
      paramString = localSQLiteDatabase.rawQuery("select count() from " + paramString, null);
    } while (paramString == null);
    try
    {
      if (paramString.moveToFirst()) {
        i = paramString.getInt(0);
      }
      return i;
    }
    catch (Throwable localThrowable)
    {
      QLog.d("MsgBackup_db", 1, "queryResTotalCount:" + localThrowable);
      return 0;
    }
    finally
    {
      paramString.close();
    }
  }
  
  public List<MsgBackupResEntity> b(long paramLong, int paramInt)
  {
    Object localObject1 = String.format("select * from %s where _id>=%d limit %d", new Object[] { "res", Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    Object localObject2 = this.mInnerDbHelper.getWritableDatabase();
    if (localObject2 == null)
    {
      arsc.a("MsgBackup_db", "db is null queryRes ...135", new Object[0]);
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
  
  public ajrl build(String paramString)
  {
    if (this.mInnerDbHelper == null)
    {
      this.mInnerDbHelper = new QQEntityManagerFactory.SQLiteOpenHelperImpl(this, paramString, null, 1);
      this.dbHelper = new ajrl(this.mInnerDbHelper);
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
      arsc.b("MsgBackup_db", "db create is null", new Object[0]);
      return;
    }
    paramSQLiteDatabase.execSQL(atnp.a(new MsgBackupMsgEntity()));
    paramSQLiteDatabase.execSQL(atnp.a(new MsgBackupResEntity()));
    paramSQLiteDatabase.execSQL(atnp.a(new MsgBackupExtraEntity()));
  }
  
  public boolean isNeedEncry()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arpn
 * JD-Core Version:    0.7.0.1
 */