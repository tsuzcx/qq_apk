package com.tencent.mobileqq.app.asyncdb.cache;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import aohi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class RecentUserCache$3
  implements Runnable
{
  public RecentUserCache$3(aohi paramaohi, SharedPreferences paramSharedPreferences) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.db.Cache.RecentUserCache", 2, "checkNewFriendUpgradeV2 | start");
    }
    try
    {
      SQLiteDatabase localSQLiteDatabase = ((QQAppInterface)this.this$0.app).getWritableDatabase();
      String str = this.this$0.getKey(AppConstants.RECOMMEND_CONTACT_UIN, 4000);
      if (aohi.e(this.this$0).containsKey(str)) {
        aohi.f(this.this$0).remove(str);
      }
      int i = localSQLiteDatabase.delete("recent", "uin=?", new String[] { AppConstants.RECOMMEND_CONTACT_UIN });
      if (QLog.isColorLevel()) {
        QLog.d("Q.db.Cache.RecentUserCache", 2, "checkNewFriendUpgradeV2 | RecentUser delCount = " + i);
      }
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.d("Q.db.Cache.RecentUserCache", 2, "checkNewFriendUpgradeV2 | delete recommend error~");
      return;
    }
    finally
    {
      this.a.edit().putBoolean("check_newfriend_when_upgrade_V2", false).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.asyncdb.cache.RecentUserCache.3
 * JD-Core Version:    0.7.0.1
 */