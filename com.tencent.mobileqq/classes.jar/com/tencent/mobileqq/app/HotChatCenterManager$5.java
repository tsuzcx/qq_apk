package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.utils.SharedPreferencesHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;

class HotChatCenterManager$5
  implements Runnable
{
  HotChatCenterManager$5(HotChatCenterManager paramHotChatCenterManager) {}
  
  public void run()
  {
    Object localObject3 = null;
    Object localObject1 = localObject3;
    Object localObject2;
    try
    {
      if (this.this$0.jdField_a_of_type_JavaUtilSet != null)
      {
        localObject1 = localObject3;
        if (this.this$0.jdField_a_of_type_JavaUtilSet.size() > 0) {
          localObject1 = this.this$0.jdField_a_of_type_JavaUtilSet.toArray();
        }
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("HotChatCenterManager", 1, localThrowable, new Object[0]);
      localObject2 = localObject3;
    }
    if ((localObject2 != null) && (this.this$0.jdField_a_of_type_AndroidContentSharedPreferences != null)) {
      SharedPreferencesHandler.a(this.this$0.jdField_a_of_type_AndroidContentSharedPreferences.edit(), "hotchat_new_unread_list", localObject2).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.HotChatCenterManager.5
 * JD-Core Version:    0.7.0.1
 */