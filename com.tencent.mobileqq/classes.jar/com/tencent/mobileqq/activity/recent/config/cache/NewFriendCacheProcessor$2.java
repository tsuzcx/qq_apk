package com.tencent.mobileqq.activity.recent.config.cache;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

class NewFriendCacheProcessor$2
  implements Runnable
{
  NewFriendCacheProcessor$2(NewFriendCacheProcessor paramNewFriendCacheProcessor, QQAppInterface paramQQAppInterface, SharedPreferences paramSharedPreferences) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.a, 2, "checkNewFriendUpgrade | start");
    }
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getWritableDatabase();
      int i = localSQLiteDatabase.delete("recent", "uin=?", new String[] { AppConstants.RECOMMEND_CONTACT_UIN });
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.a, 2, "checkNewFriendUpgrade | RecentUser delCount = " + i);
      }
      i = localSQLiteDatabase.delete(ConversationInfo.getConversationInfoTableName(), "uin=?", new String[] { AppConstants.RECOMMEND_CONTACT_UIN });
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.a, 2, "checkNewFriendUpgrade | conversationinfo delCount = " + i);
      }
      i = localSQLiteDatabase.delete(MessageRecord.getTableName(AppConstants.RECOMMEND_CONTACT_UIN, 4000), "frienduin=?", new String[] { AppConstants.RECOMMEND_CONTACT_UIN });
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.a, 2, "checkNewFriendUpgrade | MessageRecord.RecommendMsg delCount = " + i);
      }
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.d(this.this$0.a, 2, "checkNewFriendUpgrade | delete recommend error~");
      return;
    }
    finally
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("check_newfriend_when_upgrade", false).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.cache.NewFriendCacheProcessor.2
 * JD-Core Version:    0.7.0.1
 */