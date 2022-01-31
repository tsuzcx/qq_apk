import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class bfje
  extends SQLiteOpenHelper
{
  protected static bfje a;
  protected String a;
  protected String b = "CREATE TABLE IF NOT EXISTS table_old_data( _id INTEGER PRIMARY KEY,actiontype varchar,appid varchar,qua varchar,uin varchar,via varchar,network varchar,timestamp varchar,expand1 varchar,expand2 varchar,expand3 varchar,expand4 varchar,expand5 varchar);";
  protected String c = "CREATE TABLE IF NOT EXISTS table_appcircle_setting(_id INTEGER PRIMARY KEY AUTOINCREMENT,uin TEXT,key TEXT,value TEXT,data BLOB);";
  protected String d = "CREATE TABLE IF NOT EXISTS table_appcircle_report( _id INTEGER PRIMARY KEY,actiontype varchar,appid varchar,qua varchar,uin varchar,via varchar,network varchar,timestamp varchar,expand1 varchar,expand2 varchar,expand3 varchar,expand4 varchar,expand5 varchar);";
  
  protected bfje(Context paramContext)
  {
    super(paramContext, "open_report.db", null, 3);
    this.jdField_a_of_type_JavaLangString = "CREATE TABLE IF NOT EXISTS table_new_data( _id INTEGER PRIMARY KEY,actiontype varchar,appid varchar,qua varchar,uin varchar,via varchar,network varchar,timestamp varchar,expand1 varchar,expand2 varchar,expand3 varchar,expand4 varchar,expand5 varchar);";
  }
  
  public static bfje a(Context paramContext)
  {
    try
    {
      if (jdField_a_of_type_Bfje == null) {
        jdField_a_of_type_Bfje = new bfje(paramContext);
      }
      paramContext = jdField_a_of_type_Bfje;
      return paramContext;
    }
    finally {}
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    bfhg.b("opensdk", "sql1:" + this.jdField_a_of_type_JavaLangString);
    bfhg.b("opensdk", "sql2:" + this.b);
    paramSQLiteDatabase.execSQL(this.jdField_a_of_type_JavaLangString);
    paramSQLiteDatabase.execSQL(this.b);
    Log.i("ReportSqliteHelper", "circleTest create table:" + this.c);
    paramSQLiteDatabase.execSQL(this.c);
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS table_new_data");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS table_old_data");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS table_appcircle_setting");
    onCreate(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS table_new_data");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS table_old_data");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS table_appcircle_setting");
    onCreate(paramSQLiteDatabase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfje
 * JD-Core Version:    0.7.0.1
 */