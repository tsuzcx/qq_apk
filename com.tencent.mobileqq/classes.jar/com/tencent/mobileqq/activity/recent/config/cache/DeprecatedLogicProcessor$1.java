package com.tencent.mobileqq.activity.recent.config.cache;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.qphone.base.util.QLog;

class DeprecatedLogicProcessor$1
  implements Runnable
{
  DeprecatedLogicProcessor$1(DeprecatedLogicProcessor paramDeprecatedLogicProcessor, QQAppInterface paramQQAppInterface, long paramLong) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.a(), 2, "filterErrorData | start");
    }
    try
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getWritableDatabase().delete("recent", "_id=?", new String[] { String.valueOf(this.jdField_a_of_type_Long) });
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.a, 2, "filterErrorData | RecentUser delCount = " + i);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.a, 2, "filterErrorData | delete recommend error~");
      }
      return;
    }
    finally
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.a, 2, "filterErrorData | end");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.cache.DeprecatedLogicProcessor.1
 * JD-Core Version:    0.7.0.1
 */