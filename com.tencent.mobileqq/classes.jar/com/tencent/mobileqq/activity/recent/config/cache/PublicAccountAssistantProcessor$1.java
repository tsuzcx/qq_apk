package com.tencent.mobileqq.activity.recent.config.cache;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

class PublicAccountAssistantProcessor$1
  implements Runnable
{
  PublicAccountAssistantProcessor$1(PublicAccountAssistantProcessor paramPublicAccountAssistantProcessor, QQAppInterface paramQQAppInterface, SharedPreferences paramSharedPreferences) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.a, 2, "checkPubAccountAssistant | start");
    }
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getWritableDatabase();
      int i = localSQLiteDatabase.delete("recent", "uin=?", new String[] { AppConstants.PUBLIC_ACCOUNT_WPA_ASSISTANT_UIN });
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.a, 2, "checkPubAccountAssistant | RecentUser delCount = " + i);
      }
      i = localSQLiteDatabase.delete(ConversationInfo.getConversationInfoTableName(), "uin=?", new String[] { AppConstants.PUBLIC_ACCOUNT_WPA_ASSISTANT_UIN });
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.a, 2, "checkPubAccountAssistant | conversationinfo delCount = " + i);
      }
      i = localSQLiteDatabase.delete(MessageRecord.getTableName(AppConstants.PUBLIC_ACCOUNT_WPA_ASSISTANT_UIN, 7200), "frienduin=?", new String[] { AppConstants.PUBLIC_ACCOUNT_WPA_ASSISTANT_UIN });
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.a, 2, "checkPubAccountAssistant | MessageRecord.RecommendMsg delCount = " + i);
      }
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.d(this.this$0.a, 2, "checkPubAccountAssistant | delete recommend error~");
      return;
    }
    finally
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("check_pubaccountassistant_when_upgrade", false).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.cache.PublicAccountAssistantProcessor.1
 * JD-Core Version:    0.7.0.1
 */