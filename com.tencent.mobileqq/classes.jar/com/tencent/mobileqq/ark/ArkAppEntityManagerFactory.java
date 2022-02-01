package com.tencent.mobileqq.ark;

import android.database.Cursor;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.SQLiteOpenHelperFacade;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.persistence.defaultValue;
import com.tencent.mobileqq.persistence.defaultzero;
import com.tencent.mobileqq.utils.SecurityUtile;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ArkAppEntityManagerFactory
  extends EntityManagerFactory
{
  private void a(String paramString, android.database.sqlite.SQLiteDatabase paramSQLiteDatabase)
  {
    System.currentTimeMillis();
    Cursor localCursor1 = paramSQLiteDatabase.rawQuery("select distinct tbl_name from Sqlite_master", null);
    ArrayList localArrayList = new ArrayList();
    int i;
    boolean bool;
    if (localCursor1 != null)
    {
      while (localCursor1.moveToNext())
      {
        String str1 = SecurityUtile.decode(localCursor1.getString(0));
        Cursor localCursor2 = paramSQLiteDatabase.rawQuery("select sql from sqlite_master where type=? and name=?", new String[] { "table", str1 });
        if (localCursor2 != null)
        {
          for (;;)
          {
            try
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(paramString);
              ((StringBuilder)localObject1).append(".");
              ((StringBuilder)localObject1).append(str1);
              Object localObject2 = TableBuilder.getValidField(Class.forName(((StringBuilder)localObject1).toString()));
              if (!localCursor2.moveToFirst()) {
                continue;
              }
              localObject1 = SecurityUtile.decode(localCursor2.getString(0)).split(",");
              localObject2 = ((List)localObject2).iterator();
              if (!((Iterator)localObject2).hasNext()) {
                continue;
              }
              localField = (Field)((Iterator)localObject2).next();
              i = 1;
            }
            catch (ClassNotFoundException localClassNotFoundException)
            {
              Object localObject1;
              Field localField;
              String str2;
              continue;
              i += 1;
              continue;
              i = 0;
              continue;
            }
            if (i >= localObject1.length) {
              continue;
            }
            str2 = localObject1[i].trim().split(" ")[0];
            if (!localField.getName().equals(str2)) {
              continue;
            }
            i = 1;
            if (i == 0)
            {
              if (localField.isAnnotationPresent(defaultzero.class))
              {
                bool = true;
                break label418;
              }
              if (!localField.isAnnotationPresent(defaultValue.class)) {
                break label423;
              }
              i = ((defaultValue)localField.getAnnotation(defaultValue.class)).defaultInteger();
              bool = true;
              localArrayList.add(TableBuilder.addColumn(str1, localField.getName(), (String)TableBuilder.TYPES.get(localField.getType()), bool, i));
            }
          }
          localCursor2.close();
        }
      }
      localCursor1.close();
    }
    com.tencent.mobileqq.app.SQLiteDatabase.beginTransactionLog();
    paramSQLiteDatabase.beginTransaction();
    try
    {
      paramString = localArrayList.iterator();
      while (paramString.hasNext()) {
        paramSQLiteDatabase.execSQL((String)paramString.next());
      }
      paramSQLiteDatabase.setTransactionSuccessful();
      paramSQLiteDatabase.endTransaction();
      com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
      return;
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
      com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
      for (;;)
      {
        throw paramString;
      }
    }
    for (;;)
    {
      label418:
      i = 0;
      break;
      label423:
      bool = false;
    }
  }
  
  public SQLiteOpenHelper build(String paramString)
  {
    if (this.dbHelper == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("arkapp_");
      localStringBuilder.append(paramString);
      localStringBuilder.append(".db");
      this.mInnerDbHelper = SQLiteOpenHelperFacade.getHelper(this, localStringBuilder.toString(), 1);
      this.dbHelper = new SQLiteOpenHelper(this.mInnerDbHelper);
    }
    return this.dbHelper;
  }
  
  protected void createDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new ArkAppTestData()));
  }
  
  protected String getPackageName()
  {
    return getClass().getPackage().getName();
  }
  
  protected void upgradeDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    a(getPackageName(), paramSQLiteDatabase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppEntityManagerFactory
 * JD-Core Version:    0.7.0.1
 */