package com.tencent.mobileqq.activity.aio.rebuild;

import android.os.Handler;
import android.os.Message;
import bbtt;
import bcnu;
import bcth;
import bdes;
import bdin;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import mqq.os.MqqHandler;

class TroopChatPie$24
  implements Runnable
{
  TroopChatPie$24(TroopChatPie paramTroopChatPie) {}
  
  public void run()
  {
    this.this$0.bA();
    Object localObject1 = ((bcnu)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48)).a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, true);
    Object localObject2 = this.this$0.b.obtainMessage(2);
    ((Message)localObject2).obj = localObject1;
    this.this$0.b.sendMessage((Message)localObject2);
    localObject1 = ((TroopManager)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    int i = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    localObject2 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    int j = bdin.a(BaseApplicationImpl.getContext());
    if (((i == 1) || (i == 4) || ((i == -1) && (((bbtt)localObject2).c > 0))) && (((bbtt)localObject2).jdField_a_of_type_Boolean) && (localObject1 != null) && (((TroopInfo)localObject1).wMemberNum < ((bbtt)localObject2).b) && ((j == 4) || (j == 1))) {
      ((bbtt)localObject2).d(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, Math.min(this.this$0.u, ((bbtt)localObject2).jdField_a_of_type_Int));
    }
    localObject2 = TroopChatPie.h(this.this$0).obtainMessage(85);
    if (bcth.a(TroopChatPie.a(this.this$0)).a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {}
    for (i = 1;; i = 0)
    {
      ((Message)localObject2).arg1 = i;
      ((Message)localObject2).sendToTarget();
      if ((localObject1 != null) && (((TroopInfo)localObject1).isGameBind())) {
        bdes.a("Grp_game", "Grp_AIO", "aio_exp", 0, 0, new String[] { this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a });
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.24
 * JD-Core Version:    0.7.0.1
 */