package com.tencent.mobileqq.app;

import android.widget.Toast;
import com.tencent.qphone.base.util.BaseApplication;

class SQLiteDatabase$2
  implements Runnable
{
  SQLiteDatabase$2(SQLiteDatabase paramSQLiteDatabase) {}
  
  public void run()
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("进程：");
    localStringBuilder.append(BaseApplication.processName);
    localStringBuilder.append("DB读写异常，请联系 williscao");
    Toast.makeText(localBaseApplication, localStringBuilder.toString(), 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.SQLiteDatabase.2
 * JD-Core Version:    0.7.0.1
 */