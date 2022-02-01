package com.tencent.mobileqq.app.asyncdb.cache;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import aohi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class RecentUserCache$4
  implements Runnable
{
  public RecentUserCache$4(aohi paramaohi, SharedPreferences paramSharedPreferences) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.db.Cache.RecentUserCache", 2, "checkPubAccountAssistant | start");
    }
    Object localObject1 = null;
    label384:
    for (;;)
    {
      synchronized (aohi.g(this.this$0))
      {
        Iterator localIterator = aohi.h(this.this$0).values().iterator();
        if (localIterator.hasNext())
        {
          Entity localEntity = (Entity)localIterator.next();
          if ((localEntity == null) || (!AppConstants.PUBLIC_ACCOUNT_WPA_ASSISTANT_UIN.equals(((RecentUser)localEntity).uin))) {
            break label384;
          }
          localObject1 = (RecentUser)localEntity;
          break label384;
        }
      }
      try
      {
        ??? = ((QQAppInterface)this.this$0.app).getWritableDatabase();
        if (localObject1 != null)
        {
          localObject1 = this.this$0.getKey((Entity)localObject1);
          if (aohi.i(this.this$0).containsKey(localObject1)) {
            aohi.j(this.this$0).remove(localObject1);
          }
        }
        int i = ((SQLiteDatabase)???).delete("recent", "uin=?", new String[] { AppConstants.PUBLIC_ACCOUNT_WPA_ASSISTANT_UIN });
        if (QLog.isColorLevel()) {
          QLog.d("Q.db.Cache.RecentUserCache", 2, "checkPubAccountAssistant | RecentUser delCount = " + i);
        }
        i = ((SQLiteDatabase)???).delete(ConversationInfo.getConversationInfoTableName(), "uin=?", new String[] { AppConstants.PUBLIC_ACCOUNT_WPA_ASSISTANT_UIN });
        if (QLog.isColorLevel()) {
          QLog.d("Q.db.Cache.RecentUserCache", 2, "checkPubAccountAssistant | conversationinfo delCount = " + i);
        }
        i = ((SQLiteDatabase)???).delete(MessageRecord.getTableName(AppConstants.PUBLIC_ACCOUNT_WPA_ASSISTANT_UIN, 7200), "frienduin=?", new String[] { AppConstants.PUBLIC_ACCOUNT_WPA_ASSISTANT_UIN });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.asyncdb.cache.RecentUserCache.4
 * JD-Core Version:    0.7.0.1
 */