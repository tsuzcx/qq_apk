package com.tencent.mobileqq.app;

import amtm;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bfza;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;

public class HotChatCenterManager$5
  implements Runnable
{
  public HotChatCenterManager$5(amtm paramamtm) {}
  
  public void run()
  {
    localObject3 = null;
    Object localObject1 = localObject3;
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
      for (;;)
      {
        QLog.e("HotChatCenterManager", 1, localThrowable, new Object[0]);
        Object localObject2 = localObject3;
      }
    }
    if ((localObject1 != null) && (this.this$0.jdField_a_of_type_AndroidContentSharedPreferences != null)) {
      bfza.a(this.this$0.jdField_a_of_type_AndroidContentSharedPreferences.edit(), "hotchat_new_unread_list", (Object[])localObject1).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.HotChatCenterManager.5
 * JD-Core Version:    0.7.0.1
 */