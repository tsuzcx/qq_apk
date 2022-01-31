package com.tencent.biz.pubaccount.util;

import aukn;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import ser;

public class PAReportManager$1
  implements Runnable
{
  public PAReportManager$1(ser paramser, PAReportInfo paramPAReportInfo) {}
  
  public void run()
  {
    if (this.a == null) {}
    SQLiteDatabase localSQLiteDatabase;
    do
    {
      return;
      if (ser.a(this.this$0) == -1) {
        ser.a(this.this$0, ser.a(this.this$0).b().a(PAReportInfo.class.getSimpleName()));
      }
      if (QLog.isColorLevel()) {
        QLog.d("PAReport", 2, "before insert into db mCount = " + ser.a(this.this$0));
      }
      if (ser.a(this.this$0) < 80) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PAReport", 2, "databases message records is out of 80 delete the first _id ");
      }
      ??? = String.format("delete from %s where _id = (select min(_id) from %s)", new Object[] { this.a.getTableName(), this.a.getTableName() });
      localSQLiteDatabase = ser.a(this.this$0).a();
    } while (localSQLiteDatabase == null);
    if (localSQLiteDatabase.a((String)???)) {}
    synchronized (ser.a(this.this$0))
    {
      ser.a(this.this$0).clear();
      ser.b(this.this$0);
      ser.c(this.this$0);
      ser.a(this.this$0).a(this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PAReportManager.1
 * JD-Core Version:    0.7.0.1
 */