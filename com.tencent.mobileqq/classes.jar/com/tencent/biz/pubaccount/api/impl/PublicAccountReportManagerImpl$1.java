package com.tencent.biz.pubaccount.api.impl;

import com.tencent.biz.pubaccount.util.PAReportInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class PublicAccountReportManagerImpl$1
  implements Runnable
{
  PublicAccountReportManagerImpl$1(PublicAccountReportManagerImpl paramPublicAccountReportManagerImpl, Entity paramEntity) {}
  
  public void run()
  {
    Object localObject1 = this.a;
    if (!(localObject1 instanceof PAReportInfo)) {
      return;
    }
    localObject1 = (PAReportInfo)localObject1;
    if (PublicAccountReportManagerImpl.access$000(this.this$0) == -1)
    {
      ??? = this.this$0;
      PublicAccountReportManagerImpl.access$002((PublicAccountReportManagerImpl)???, PublicAccountReportManagerImpl.access$100((PublicAccountReportManagerImpl)???).getReadableDatabase().getCount(PAReportInfo.class.getSimpleName()));
    }
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("before insert into db mCount = ");
      ((StringBuilder)???).append(PublicAccountReportManagerImpl.access$000(this.this$0));
      QLog.d("PAReport", 2, ((StringBuilder)???).toString());
    }
    if (PublicAccountReportManagerImpl.access$000(this.this$0) >= 80)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PAReport", 2, "databases message records is out of 80 delete the first _id ");
      }
      ??? = String.format("delete from %s where _id = (select min(_id) from %s)", new Object[] { ((PAReportInfo)localObject1).getTableName(), ((PAReportInfo)localObject1).getTableName() });
      SQLiteDatabase localSQLiteDatabase = PublicAccountReportManagerImpl.access$100(this.this$0).getWritableDatabase();
      if (localSQLiteDatabase == null) {
        return;
      }
      if (localSQLiteDatabase.execSQL((String)???)) {
        synchronized (PublicAccountReportManagerImpl.access$200(this.this$0))
        {
          PublicAccountReportManagerImpl.access$200(this.this$0).clear();
          PublicAccountReportManagerImpl.access$010(this.this$0);
        }
      }
    }
    PublicAccountReportManagerImpl.access$008(this.this$0);
    PublicAccountReportManagerImpl.access$300(this.this$0).persist(localEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountReportManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */