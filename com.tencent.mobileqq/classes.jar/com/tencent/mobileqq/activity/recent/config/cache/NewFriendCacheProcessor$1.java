package com.tencent.mobileqq.activity.recent.config.cache;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.qphone.base.util.QLog;

class NewFriendCacheProcessor$1
  implements Runnable
{
  NewFriendCacheProcessor$1(NewFriendCacheProcessor paramNewFriendCacheProcessor, QQAppInterface paramQQAppInterface, SharedPreferences paramSharedPreferences) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.a, 2, "checkNewFriendUpgradeV2 | start");
    }
    try
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getWritableDatabase().delete("recent", "uin=?", new String[] { AppConstants.RECOMMEND_CONTACT_UIN });
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.a, 2, "checkNewFriendUpgradeV2 | RecentUser delCount = " + i);
      }
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.d(this.this$0.a, 2, "checkNewFriendUpgradeV2 | delete recommend error~");
      return;
    }
    finally
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("check_newfriend_when_upgrade_V2", false).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.cache.NewFriendCacheProcessor.1
 * JD-Core Version:    0.7.0.1
 */