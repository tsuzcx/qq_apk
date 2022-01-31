import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class aslt
  extends SQLiteOpenHelper
{
  private Context a;
  
  public aslt(Context paramContext)
  {
    super(paramContext, "WADLTASK.db", null, 28);
    this.a = paramContext;
  }
  
  private aslu a(Cursor paramCursor)
  {
    if (paramCursor != null)
    {
      aslu localaslu = new aslu();
      localaslu.jdField_a_of_type_JavaLangString = paramCursor.getString(paramCursor.getColumnIndex("appId"));
      localaslu.jdField_b_of_type_JavaLangString = paramCursor.getString(paramCursor.getColumnIndex("packageName"));
      localaslu.jdField_c_of_type_JavaLangString = paramCursor.getString(paramCursor.getColumnIndex("apkUrl"));
      localaslu.jdField_d_of_type_JavaLangString = paramCursor.getString(paramCursor.getColumnIndex("apkSign"));
      localaslu.jdField_a_of_type_Int = paramCursor.getInt(paramCursor.getColumnIndex("versionCode"));
      localaslu.e = paramCursor.getString(paramCursor.getColumnIndex("appName"));
      localaslu.f = paramCursor.getString(paramCursor.getColumnIndex("iconUrl"));
      localaslu.g = paramCursor.getString(paramCursor.getColumnIndex("apkChannel"));
      localaslu.h = paramCursor.getString(paramCursor.getColumnIndex("via"));
      localaslu.jdField_b_of_type_Int = paramCursor.getInt(paramCursor.getColumnIndex("flags"));
      localaslu.i = paramCursor.getString(paramCursor.getColumnIndex("fromWebUrl"));
      localaslu.jdField_c_of_type_Int = paramCursor.getInt(paramCursor.getColumnIndex("actionFrom"));
      localaslu.j = paramCursor.getString(paramCursor.getColumnIndex("adtag"));
      localaslu.k = paramCursor.getString(paramCursor.getColumnIndex("extraData"));
      localaslu.jdField_a_of_type_Long = paramCursor.getLong(paramCursor.getColumnIndex("totalSize"));
      localaslu.jdField_b_of_type_Long = paramCursor.getLong(paramCursor.getColumnIndex("downloadSize"));
      localaslu.l = paramCursor.getString(paramCursor.getColumnIndex("savePath"));
      localaslu.jdField_d_of_type_Int = paramCursor.getInt(paramCursor.getColumnIndex("status"));
      localaslu.m = paramCursor.getString(paramCursor.getColumnIndex("taskId"));
      localaslu.jdField_c_of_type_Long = paramCursor.getLong(paramCursor.getColumnIndex("createTime"));
      return localaslu;
    }
    return null;
  }
  
  private boolean a()
  {
    return new File(this.a.getDatabasePath("WADLTASK.db").getPath()).exists();
  }
  
  public List<aslu> a()
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
          aslu localaslu = a(localCursor);
          if (localaslu == null) {
            continue;
          }
          Object localObject3 = localObject1;
          if (localObject1 == null)
          {
            localObject4 = localObject1;
            localObject3 = new ArrayList();
          }
          localObject4 = localObject3;
          ((List)localObject3).add(localaslu);
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
 * Qualified Name:     aslt
 * JD-Core Version:    0.7.0.1
 */