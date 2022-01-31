package com.tencent.biz.pubaccount.util;

import awgf;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import swi;

public class PAReportManager$1
  implements Runnable
{
  public PAReportManager$1(swi paramswi, PAReportInfo paramPAReportInfo) {}
  
  public void run()
  {
    if (this.a == null) {}
    SQLiteDatabase localSQLiteDatabase;
    do
    {
      return;
      if (swi.a(this.this$0) == -1) {
        swi.a(this.this$0, swi.a(this.this$0).b().a(PAReportInfo.class.getSimpleName()));
      }
      if (QLog.isColorLevel()) {
        QLog.d("PAReport", 2, "before insert into db mCount = " + swi.a(this.this$0));
      }
      if (swi.a(this.this$0) < 80) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PAReport", 2, "databases message records is out of 80 delete the first _id ");
      }
      ??? = String.format("delete from %s where _id = (select min(_id) from %s)", new Object[] { this.a.getTableName(), this.a.getTableName() });
      localSQLiteDatabase = swi.a(this.this$0).a();
    } while (localSQLiteDatabase == null);
    if (localSQLiteDatabase.a((String)???)) {}
    synchronized (swi.a(this.this$0))
    {
      swi.a(this.this$0).clear();
      swi.b(this.this$0);
      swi.c(this.this$0);
      swi.a(this.this$0).a(this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PAReportManager.1
 * JD-Core Version:    0.7.0.1
 */