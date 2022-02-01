package com.tencent.biz.pubaccount.util;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class PAReportManager$1
  implements Runnable
{
  PAReportManager$1(PAReportManager paramPAReportManager, PAReportInfo paramPAReportInfo) {}
  
  public void run()
  {
    if (this.a == null) {}
    SQLiteDatabase localSQLiteDatabase;
    do
    {
      return;
      if (PAReportManager.a(this.this$0) == -1) {
        PAReportManager.a(this.this$0, PAReportManager.a(this.this$0).getReadableDatabase().getCount(PAReportInfo.class.getSimpleName()));
      }
      if (QLog.isColorLevel()) {
        QLog.d("PAReport", 2, "before insert into db mCount = " + PAReportManager.a(this.this$0));
      }
      if (PAReportManager.a(this.this$0) < 80) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PAReport", 2, "databases message records is out of 80 delete the first _id ");
      }
      ??? = String.format("delete from %s where _id = (select min(_id) from %s)", new Object[] { this.a.getTableName(), this.a.getTableName() });
      localSQLiteDatabase = PAReportManager.a(this.this$0).getWritableDatabase();
    } while (localSQLiteDatabase == null);
    if (localSQLiteDatabase.execSQL((String)???)) {}
    synchronized (PAReportManager.a(this.this$0))
    {
      PAReportManager.a(this.this$0).clear();
      PAReportManager.b(this.this$0);
      PAReportManager.c(this.this$0);
      PAReportManager.a(this.this$0).persist(this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PAReportManager.1
 * JD-Core Version:    0.7.0.1
 */