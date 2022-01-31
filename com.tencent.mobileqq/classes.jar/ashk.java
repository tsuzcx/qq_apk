import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ashk
  extends SQLiteOpenHelper
{
  private Context a;
  
  public ashk(Context paramContext)
  {
    super(paramContext, "WADLTASK.db", null, 28);
    this.a = paramContext;
  }
  
  private ashl a(Cursor paramCursor)
  {
    if (paramCursor != null)
    {
      ashl localashl = new ashl();
      localashl.jdField_a_of_type_JavaLangString = paramCursor.getString(paramCursor.getColumnIndex("appId"));
      localashl.jdField_b_of_type_JavaLangString = paramCursor.getString(paramCursor.getColumnIndex("packageName"));
      localashl.jdField_c_of_type_JavaLangString = paramCursor.getString(paramCursor.getColumnIndex("apkUrl"));
      localashl.jdField_d_of_type_JavaLangString = paramCursor.getString(paramCursor.getColumnIndex("apkSign"));
      localashl.jdField_a_of_type_Int = paramCursor.getInt(paramCursor.getColumnIndex("versionCode"));
      localashl.e = paramCursor.getString(paramCursor.getColumnIndex("appName"));
      localashl.f = paramCursor.getString(paramCursor.getColumnIndex("iconUrl"));
      localashl.g = paramCursor.getString(paramCursor.getColumnIndex("apkChannel"));
      localashl.h = paramCursor.getString(paramCursor.getColumnIndex("via"));
      localashl.jdField_b_of_type_Int = paramCursor.getInt(paramCursor.getColumnIndex("flags"));
      localashl.i = paramCursor.getString(paramCursor.getColumnIndex("fromWebUrl"));
      localashl.jdField_c_of_type_Int = paramCursor.getInt(paramCursor.getColumnIndex("actionFrom"));
      localashl.j = paramCursor.getString(paramCursor.getColumnIndex("adtag"));
      localashl.k = paramCursor.getString(paramCursor.getColumnIndex("extraData"));
      localashl.jdField_a_of_type_Long = paramCursor.getLong(paramCursor.getColumnIndex("totalSize"));
      localashl.jdField_b_of_type_Long = paramCursor.getLong(paramCursor.getColumnIndex("downloadSize"));
      localashl.l = paramCursor.getString(paramCursor.getColumnIndex("savePath"));
      localashl.jdField_d_of_type_Int = paramCursor.getInt(paramCursor.getColumnIndex("status"));
      localashl.m = paramCursor.getString(paramCursor.getColumnIndex("taskId"));
      localashl.jdField_c_of_type_Long = paramCursor.getLong(paramCursor.getColumnIndex("createTime"));
      return localashl;
    }
    return null;
  }
  
  private boolean a()
  {
    return new File(this.a.getDatabasePath("WADLTASK.db").getPath()).exists();
  }
  
  public List<ashl> a()
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
          ashl localashl = a(localCursor);
          if (localashl == null) {
            continue;
          }
          Object localObject3 = localObject1;
          if (localObject1 == null)
          {
            localObject4 = localObject1;
            localObject3 = new ArrayList();
          }
          localObject4 = localObject3;
          ((List)localObject3).add(localashl);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ashk
 * JD-Core Version:    0.7.0.1
 */