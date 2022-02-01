package com.tencent.mobileqq.activity.aio.rebuild;

import android.os.Handler;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

class PublicAccountChatPie$5
  implements Runnable
{
  PublicAccountChatPie$5(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void run()
  {
    Object localObject = (PublicAccountDataManager)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
    if (localObject != null) {}
    for (localObject = ((PublicAccountDataManager)localObject).b(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);; localObject = null)
    {
      if (localObject != null) {
        this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.5
 * JD-Core Version:    0.7.0.1
 */