package com.tencent.mobileqq.app.asyncdb.cache;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.qphone.base.util.QLog;

class RecentUserCache$1
  implements Runnable
{
  RecentUserCache$1(RecentUserCache paramRecentUserCache, long paramLong) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.db.Cache.RecentUserCache", 2, "filterErrorData | start");
    }
    try
    {
      int i = RecentUserCache.a(this.this$0).a().a("recent", "_id=?", new String[] { String.valueOf(this.a) });
      if (QLog.isColorLevel()) {
        QLog.d("Q.db.Cache.RecentUserCache", 2, "filterErrorData | RecentUser delCount = " + i);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("Q.db.Cache.RecentUserCache", 2, "filterErrorData | delete recommend error~");
      }
      return;
    }
    finally
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.db.Cache.RecentUserCache", 2, "filterErrorData | end");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.asyncdb.cache.RecentUserCache.1
 * JD-Core Version:    0.7.0.1
 */