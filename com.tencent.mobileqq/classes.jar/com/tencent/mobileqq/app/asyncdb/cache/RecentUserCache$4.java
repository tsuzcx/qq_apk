package com.tencent.mobileqq.app.asyncdb.cache;

import alof;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import awge;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

class RecentUserCache$4
  implements Runnable
{
  RecentUserCache$4(RecentUserCache paramRecentUserCache, SharedPreferences paramSharedPreferences) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.db.Cache.RecentUserCache", 2, "checkPubAccountAssistant | start");
    }
    Object localObject1 = null;
    label381:
    for (;;)
    {
      synchronized (RecentUserCache.g(this.this$0))
      {
        Iterator localIterator = RecentUserCache.h(this.this$0).values().iterator();
        if (localIterator.hasNext())
        {
          awge localawge = (awge)localIterator.next();
          if ((localawge == null) || (!alof.U.equals(((RecentUser)localawge).uin))) {
            break label381;
          }
          localObject1 = (RecentUser)localawge;
          break label381;
        }
      }
      try
      {
        ??? = RecentUserCache.d(this.this$0).a();
        if (localObject1 != null)
        {
          localObject1 = this.this$0.a((awge)localObject1);
          if (RecentUserCache.i(this.this$0).containsKey(localObject1)) {
            RecentUserCache.j(this.this$0).remove(localObject1);
          }
        }
        int i = ((SQLiteDatabase)???).a("recent", "uin=?", new String[] { alof.U });
        if (QLog.isColorLevel()) {
          QLog.d("Q.db.Cache.RecentUserCache", 2, "checkPubAccountAssistant | RecentUser delCount = " + i);
        }
        i = ((SQLiteDatabase)???).a(ConversationInfo.getConversationInfoTableName(), "uin=?", new String[] { alof.U });
        if (QLog.isColorLevel()) {
          QLog.d("Q.db.Cache.RecentUserCache", 2, "checkPubAccountAssistant | conversationinfo delCount = " + i);
        }
        i = ((SQLiteDatabase)???).a(MessageRecord.getTableName(alof.U, 7200), "frienduin=?", new String[] { alof.U });
        if (QLog.isColorLevel()) {
          QLog.d("Q.db.Cache.RecentUserCache", 2, "checkPubAccountAssistant | MessageRecord.RecommendMsg delCount = " + i);
        }
        return;
      }
      catch (Exception localException)
      {
        do
        {
          localException.printStackTrace();
        } while (!QLog.isColorLevel());
        QLog.d("Q.db.Cache.RecentUserCache", 2, "checkPubAccountAssistant | delete recommend error~");
        return;
      }
      finally
      {
        this.a.edit().putBoolean("check_pubaccountassistant_when_upgrade", false).commit();
      }
      localObject2 = finally;
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.asyncdb.cache.RecentUserCache.4
 * JD-Core Version:    0.7.0.1
 */