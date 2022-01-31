package com.tencent.mobileqq.app.asyncdb.cache;

import ajsf;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import aukm;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

class RecentUserCache$2
  implements Runnable
{
  RecentUserCache$2(RecentUserCache paramRecentUserCache, SharedPreferences paramSharedPreferences) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.db.Cache.RecentUserCache", 2, "checkNewFriendUpgrade | start");
    }
    Object localObject1 = null;
    label381:
    for (;;)
    {
      synchronized (RecentUserCache.a(this.this$0))
      {
        Iterator localIterator = RecentUserCache.b(this.this$0).values().iterator();
        if (localIterator.hasNext())
        {
          aukm localaukm = (aukm)localIterator.next();
          if ((localaukm == null) || (!ajsf.D.equals(((RecentUser)localaukm).uin))) {
            break label381;
          }
          localObject1 = (RecentUser)localaukm;
          break label381;
        }
      }
      try
      {
        ??? = RecentUserCache.b(this.this$0).a();
        if (localObject1 != null)
        {
          localObject1 = this.this$0.a((aukm)localObject1);
          if (RecentUserCache.c(this.this$0).containsKey(localObject1)) {
            RecentUserCache.d(this.this$0).remove(localObject1);
          }
        }
        int i = ((SQLiteDatabase)???).a("recent", "uin=?", new String[] { ajsf.D });
        if (QLog.isColorLevel()) {
          QLog.d("Q.db.Cache.RecentUserCache", 2, "checkNewFriendUpgrade | RecentUser delCount = " + i);
        }
        i = ((SQLiteDatabase)???).a(ConversationInfo.getConversationInfoTableName(), "uin=?", new String[] { ajsf.D });
        if (QLog.isColorLevel()) {
          QLog.d("Q.db.Cache.RecentUserCache", 2, "checkNewFriendUpgrade | conversationinfo delCount = " + i);
        }
        i = ((SQLiteDatabase)???).a(MessageRecord.getTableName(ajsf.D, 4000), "frienduin=?", new String[] { ajsf.D });
        if (QLog.isColorLevel()) {
          QLog.d("Q.db.Cache.RecentUserCache", 2, "checkNewFriendUpgrade | MessageRecord.RecommendMsg delCount = " + i);
        }
        return;
      }
      catch (Exception localException)
      {
        do
        {
          localException.printStackTrace();
        } while (!QLog.isColorLevel());
        QLog.d("Q.db.Cache.RecentUserCache", 2, "checkNewFriendUpgrade | delete recommend error~");
        return;
      }
      finally
      {
        this.a.edit().putBoolean("check_newfriend_when_upgrade", false).commit();
      }
      localObject2 = finally;
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.asyncdb.cache.RecentUserCache.2
 * JD-Core Version:    0.7.0.1
 */