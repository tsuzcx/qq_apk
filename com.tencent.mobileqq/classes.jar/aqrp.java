import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class aqrp
  extends SQLiteOpenHelper
{
  private Context a;
  
  public aqrp(Context paramContext)
  {
    super(paramContext, "WADLTASK.db", null, 27);
    this.a = paramContext;
  }
  
  private aqrq a(Cursor paramCursor)
  {
    if (paramCursor != null)
    {
      aqrq localaqrq = new aqrq();
      localaqrq.jdField_a_of_type_JavaLangString = paramCursor.getString(paramCursor.getColumnIndex("appId"));
      localaqrq.jdField_b_of_type_JavaLangString = paramCursor.getString(paramCursor.getColumnIndex("packageName"));
      localaqrq.jdField_c_of_type_JavaLangString = paramCursor.getString(paramCursor.getColumnIndex("apkUrl"));
      localaqrq.jdField_d_of_type_JavaLangString = paramCursor.getString(paramCursor.getColumnIndex("apkSign"));
      localaqrq.jdField_a_of_type_Int = paramCursor.getInt(paramCursor.getColumnIndex("versionCode"));
      localaqrq.e = paramCursor.getString(paramCursor.getColumnIndex("appName"));
      localaqrq.f = paramCursor.getString(paramCursor.getColumnIndex("iconUrl"));
      localaqrq.g = paramCursor.getString(paramCursor.getColumnIndex("apkChannel"));
      localaqrq.h = paramCursor.getString(paramCursor.getColumnIndex("via"));
      localaqrq.jdField_b_of_type_Int = paramCursor.getInt(paramCursor.getColumnIndex("flags"));
      localaqrq.i = paramCursor.getString(paramCursor.getColumnIndex("fromWebUrl"));
      localaqrq.jdField_c_of_type_Int = paramCursor.getInt(paramCursor.getColumnIndex("actionFrom"));
      localaqrq.j = paramCursor.getString(paramCursor.getColumnIndex("adtag"));
      localaqrq.k = paramCursor.getString(paramCursor.getColumnIndex("extraData"));
      localaqrq.jdField_a_of_type_Long = paramCursor.getLong(paramCursor.getColumnIndex("totalSize"));
      localaqrq.jdField_b_of_type_Long = paramCursor.getLong(paramCursor.getColumnIndex("downloadSize"));
      localaqrq.l = paramCursor.getString(paramCursor.getColumnIndex("savePath"));
      localaqrq.jdField_d_of_type_Int = paramCursor.getInt(paramCursor.getColumnIndex("status"));
      localaqrq.m = paramCursor.getString(paramCursor.getColumnIndex("taskId"));
      localaqrq.jdField_c_of_type_Long = paramCursor.getLong(paramCursor.getColumnIndex("createTime"));
      return localaqrq;
    }
    return null;
  }
  
  private boolean a()
  {
    return new File(this.a.getDatabasePath("WADLTASK.db").getPath()).exists();
  }
  
  public List<aqrq> a()
  {
    Object localObject1 = null;
    SQLiteDatabase localSQLiteDatabase = getReadableDatabase();
    if (localSQLiteDatabase == null) {
      return null;
    }
    Cursor localCursor = localSQLiteDatabase.rawQuery("select * from TASKS", null);
    for (;;)
    {
      Object localObject4;
      if (localCursor != null) {
        localObject4 = localObject1;
      }
      try
      {
        if (localCursor.moveToNext())
        {
          localObject4 = localObject1;
          aqrq localaqrq = a(localCursor);
          if (localaqrq == null) {
            continue;
          }
          Object localObject3 = localObject1;
          if (localObject1 == null)
          {
            localObject4 = localObject1;
            localObject3 = new ArrayList();
          }
          localObject4 = localObject3;
          ((List)localObject3).add(localaqrq);
          localObject1 = localObject3;
          continue;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return localObject4;
        return localException;
      }
      finally
      {
        if (localCursor != null) {
          localCursor.close();
        }
        localSQLiteDatabase.close();
      }
    }
  }
  
  public SQLiteDatabase getReadableDatabase()
  {
    if (!a()) {
      return null;
    }
    return super.getReadableDatabase();
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase) {}
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    throw new SQLiteException("WadlTaskReader don't upgrade database from version " + paramInt1 + " to " + paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqrp
 * JD-Core Version:    0.7.0.1
 */