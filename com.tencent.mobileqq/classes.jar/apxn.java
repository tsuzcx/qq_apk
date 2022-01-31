import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class apxn
  extends SQLiteOpenHelper
{
  private Context a;
  
  public apxn(Context paramContext)
  {
    super(paramContext, "WADLTASK.db", null, 27);
    this.a = paramContext;
  }
  
  private apxo a(Cursor paramCursor)
  {
    if (paramCursor != null)
    {
      apxo localapxo = new apxo();
      localapxo.jdField_a_of_type_JavaLangString = paramCursor.getString(paramCursor.getColumnIndex("appId"));
      localapxo.jdField_b_of_type_JavaLangString = paramCursor.getString(paramCursor.getColumnIndex("packageName"));
      localapxo.jdField_c_of_type_JavaLangString = paramCursor.getString(paramCursor.getColumnIndex("apkUrl"));
      localapxo.jdField_d_of_type_JavaLangString = paramCursor.getString(paramCursor.getColumnIndex("apkSign"));
      localapxo.jdField_a_of_type_Int = paramCursor.getInt(paramCursor.getColumnIndex("versionCode"));
      localapxo.e = paramCursor.getString(paramCursor.getColumnIndex("appName"));
      localapxo.f = paramCursor.getString(paramCursor.getColumnIndex("iconUrl"));
      localapxo.g = paramCursor.getString(paramCursor.getColumnIndex("apkChannel"));
      localapxo.h = paramCursor.getString(paramCursor.getColumnIndex("via"));
      localapxo.jdField_b_of_type_Int = paramCursor.getInt(paramCursor.getColumnIndex("flags"));
      localapxo.i = paramCursor.getString(paramCursor.getColumnIndex("fromWebUrl"));
      localapxo.jdField_c_of_type_Int = paramCursor.getInt(paramCursor.getColumnIndex("actionFrom"));
      localapxo.j = paramCursor.getString(paramCursor.getColumnIndex("adtag"));
      localapxo.k = paramCursor.getString(paramCursor.getColumnIndex("extraData"));
      localapxo.jdField_a_of_type_Long = paramCursor.getLong(paramCursor.getColumnIndex("totalSize"));
      localapxo.jdField_b_of_type_Long = paramCursor.getLong(paramCursor.getColumnIndex("downloadSize"));
      localapxo.l = paramCursor.getString(paramCursor.getColumnIndex("savePath"));
      localapxo.jdField_d_of_type_Int = paramCursor.getInt(paramCursor.getColumnIndex("status"));
      localapxo.m = paramCursor.getString(paramCursor.getColumnIndex("taskId"));
      localapxo.jdField_c_of_type_Long = paramCursor.getLong(paramCursor.getColumnIndex("createTime"));
      return localapxo;
    }
    return null;
  }
  
  private boolean a()
  {
    return new File(this.a.getDatabasePath("WADLTASK.db").getPath()).exists();
  }
  
  public List<apxo> a()
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
          apxo localapxo = a(localCursor);
          if (localapxo == null) {
            continue;
          }
          Object localObject3 = localObject1;
          if (localObject1 == null)
          {
            localObject4 = localObject1;
            localObject3 = new ArrayList();
          }
          localObject4 = localObject3;
          ((List)localObject3).add(localapxo);
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
 * Qualified Name:     apxn
 * JD-Core Version:    0.7.0.1
 */