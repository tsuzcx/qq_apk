import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class bfnf
  extends SQLiteOpenHelper
{
  public bfnf(bfne parambfne, Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    super(paramContext, paramString, paramCursorFactory, paramInt);
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      bflp.b("cgi_report_debug", "ReportDataModal onCreate sql1 = create table if not exists newdata_report(id integer primary key,apn text,frequency text,commandid text,resultcode text,tmcost text,reqsize text,rspsize text,touin text,deviceinfo text,detail text,appid text)");
      paramSQLiteDatabase.execSQL("create table if not exists newdata_report(id integer primary key,apn text,frequency text,commandid text,resultcode text,tmcost text,reqsize text,rspsize text,touin text,deviceinfo text,detail text,appid text)");
      bflp.b("cgi_report_debug", "ReportDataModal onCreate sql2 = create table if not exists olddata_report(id integer primary key,apn text,frequency text,commandid text,resultcode text,tmcost text,reqsize text,rspsize text,touin text,deviceinfo text,detail text,appid text)");
      paramSQLiteDatabase.execSQL("create table if not exists olddata_report(id integer primary key,apn text,frequency text,commandid text,resultcode text,tmcost text,reqsize text,rspsize text,touin text,deviceinfo text,detail text,appid text)");
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      bflp.e("cgi_report_debug", "ReportDataModal onCreate failed");
    }
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    try
    {
      paramSQLiteDatabase.execSQL("drop table if exists newdata_report");
      paramSQLiteDatabase.execSQL("drop table if exists olddata_report");
      onCreate(paramSQLiteDatabase);
      bflp.b("cgi_report_debug", "ReportDataModal onUpgrade success");
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      bflp.e("cgi_report_debug", "ReportDataModal onUpgrade failed");
    }
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    bflp.b("cgi_report_debug", "ReportDataModal onUpgrade oldVersion=" + paramInt1 + "  newVersion=" + paramInt2 + "");
    if (paramInt1 != paramInt2) {}
    try
    {
      paramSQLiteDatabase.execSQL("drop table if exists newdata_report");
      paramSQLiteDatabase.execSQL("drop table if exists olddata_report");
      onCreate(paramSQLiteDatabase);
      bflp.b("cgi_report_debug", "ReportDataModal onUpgrade success");
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      bflp.e("cgi_report_debug", "ReportDataModal onUpgrade failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfnf
 * JD-Core Version:    0.7.0.1
 */