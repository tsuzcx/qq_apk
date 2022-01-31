package com.tencent.mobileqq.activity.aio.rebuild;

import aert;
import akdh;
import android.os.Handler;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

public class PublicAccountChatPie$4
  implements Runnable
{
  public PublicAccountChatPie$4(aert paramaert) {}
  
  public void run()
  {
    Object localObject = (akdh)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
    if (localObject != null) {}
    for (localObject = ((akdh)localObject).b(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);; localObject = null)
    {
      if (localObject != null) {
        this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.4
 * JD-Core Version:    0.7.0.1
 */