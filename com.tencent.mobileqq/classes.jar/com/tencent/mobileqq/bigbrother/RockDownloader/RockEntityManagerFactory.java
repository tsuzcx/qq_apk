package com.tencent.mobileqq.bigbrother.RockDownloader;

import android.database.sqlite.SQLiteDatabase;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.data.RockDownloadInfo;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManagerFactory.SQLiteOpenHelperImpl;
import com.tencent.mobileqq.persistence.TableBuilder;
import java.util.HashMap;
import java.util.Map;

public class RockEntityManagerFactory
  extends EntityManagerFactory
{
  private static Map<String, Class<?>> a = null;
  
  static
  {
    a = new HashMap();
    a.put(RockDownloadInfo.class.getSimpleName(), RockDownloadInfo.class);
  }
  
  public RockEntityManagerFactory()
  {
    super("RockDownload");
  }
  
  public SQLiteOpenHelper build(String paramString)
  {
    if (this.dbHelper == null)
    {
      this.mInnerDbHelper = new EntityManagerFactory.SQLiteOpenHelperImpl(this, paramString + ".db", null, 1);
      this.dbHelper = new SQLiteOpenHelper(this.mInnerDbHelper);
    }
    return this.dbHelper;
  }
  
  public void createDatabase(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new RockDownloadInfo()));
  }
  
  public String getPackageName()
  {
    return getClass().getPackage().getName();
  }
  
  public void upgradeDatabase(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bigbrother.RockDownloader.RockEntityManagerFactory
 * JD-Core Version:    0.7.0.1
 */