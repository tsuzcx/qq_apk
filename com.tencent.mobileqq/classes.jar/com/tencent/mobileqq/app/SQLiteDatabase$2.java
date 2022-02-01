package com.tencent.mobileqq.app;

import android.widget.Toast;
import com.tencent.qphone.base.util.BaseApplication;

class SQLiteDatabase$2
  implements Runnable
{
  SQLiteDatabase$2(SQLiteDatabase paramSQLiteDatabase) {}
  
  public void run()
  {
    Toast.makeText(BaseApplication.getContext(), "进程：" + BaseApplication.processName + "DB读写异常，请联系 williscao", 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.SQLiteDatabase.2
 * JD-Core Version:    0.7.0.1
 */