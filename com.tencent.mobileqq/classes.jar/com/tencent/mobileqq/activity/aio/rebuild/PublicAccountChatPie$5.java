package com.tencent.mobileqq.activity.aio.rebuild;

import ainh;
import android.os.Handler;
import aody;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

public class PublicAccountChatPie$5
  implements Runnable
{
  public PublicAccountChatPie$5(ainh paramainh) {}
  
  public void run()
  {
    Object localObject = (aody)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
    if (localObject != null) {}
    for (localObject = ((aody)localObject).b(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);; localObject = null)
    {
      if (localObject != null) {
        this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.5
 * JD-Core Version:    0.7.0.1
 */