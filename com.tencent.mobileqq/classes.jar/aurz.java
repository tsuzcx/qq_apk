import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class aurz
  extends SQLiteOpenHelper
{
  private Context a;
  
  public aurz(Context paramContext)
  {
    super(paramContext, "WADLTASK.db", null, 28);
    this.a = paramContext;
  }
  
  private ausa a(Cursor paramCursor)
  {
    if (paramCursor != null)
    {
      ausa localausa = new ausa();
      localausa.jdField_a_of_type_JavaLangString = paramCursor.getString(paramCursor.getColumnIndex("appId"));
      localausa.jdField_b_of_type_JavaLangString = paramCursor.getString(paramCursor.getColumnIndex("packageName"));
      localausa.jdField_c_of_type_JavaLangString = paramCursor.getString(paramCursor.getColumnIndex("apkUrl"));
      localausa.jdField_d_of_type_JavaLangString = paramCursor.getString(paramCursor.getColumnIndex("apkSign"));
      localausa.jdField_a_of_type_Int = paramCursor.getInt(paramCursor.getColumnIndex("versionCode"));
      localausa.e = paramCursor.getString(paramCursor.getColumnIndex("appName"));
      localausa.f = paramCursor.getString(paramCursor.getColumnIndex("iconUrl"));
      localausa.g = paramCursor.getString(paramCursor.getColumnIndex("apkChannel"));
      localausa.h = paramCursor.getString(paramCursor.getColumnIndex("via"));
      localausa.jdField_b_of_type_Int = paramCursor.getInt(paramCursor.getColumnIndex("flags"));
      localausa.i = paramCursor.getString(paramCursor.getColumnIndex("fromWebUrl"));
      localausa.jdField_c_of_type_Int = paramCursor.getInt(paramCursor.getColumnIndex("actionFrom"));
      localausa.j = paramCursor.getString(paramCursor.getColumnIndex("adtag"));
      localausa.k = paramCursor.getString(paramCursor.getColumnIndex("extraData"));
      localausa.jdField_a_of_type_Long = paramCursor.getLong(paramCursor.getColumnIndex("totalSize"));
      localausa.jdField_b_of_type_Long = paramCursor.getLong(paramCursor.getColumnIndex("downloadSize"));
      localausa.l = paramCursor.getString(paramCursor.getColumnIndex("savePath"));
      localausa.jdField_d_of_type_Int = paramCursor.getInt(paramCursor.getColumnIndex("status"));
      localausa.m = paramCursor.getString(paramCursor.getColumnIndex("taskId"));
      localausa.jdField_c_of_type_Long = paramCursor.getLong(paramCursor.getColumnIndex("createTime"));
      return localausa;
    }
    return null;
  }
  
  private boolean a()
  {
    return new File(this.a.getDatabasePath("WADLTASK.db").getPath()).exists();
  }
  
  public List<ausa> a()
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
          ausa localausa = a(localCursor);
          if (localausa == null) {
            continue;
          }
          Object localObject3 = localObject1;
          if (localObject1 == null)
          {
            localObject4 = localObject1;
            localObject3 = new ArrayList();
          }
          localObject4 = localObject3;
          ((List)localObject3).add(localausa);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aurz
 * JD-Core Version:    0.7.0.1
 */