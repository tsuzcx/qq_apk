package com.tencent.mobileqq.activity.aio.rebuild;

import android.os.Handler;
import android.os.Message;
import bftl;
import bgsl;
import bhju;
import bhnv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import mqq.os.MqqHandler;

class TroopChatPie$37
  implements Runnable
{
  TroopChatPie$37(TroopChatPie paramTroopChatPie) {}
  
  public void run()
  {
    this.this$0.bx();
    Object localObject1 = ((bgsl)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48)).a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, true);
    Object localObject2 = this.this$0.b.obtainMessage(2);
    ((Message)localObject2).obj = localObject1;
    this.this$0.b.sendMessage((Message)localObject2);
    localObject1 = ((TroopManager)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    int i = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    localObject2 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    int j = bhnv.a(BaseApplicationImpl.getContext());
    if (((i == 1) || (i == 4) || ((i == -1) && (((bftl)localObject2).c > 0))) && (((bftl)localObject2).jdField_a_of_type_Boolean) && (localObject1 != null) && (((TroopInfo)localObject1).wMemberNum < ((bftl)localObject2).b) && ((j == 4) || (j == 1))) {
      ((bftl)localObject2).c(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, Math.min(this.this$0.u, ((bftl)localObject2).jdField_a_of_type_Int));
    }
    TroopChatPie.k(this.this$0).obtainMessage(85).sendToTarget();
    if ((localObject1 != null) && (((TroopInfo)localObject1).isGameBind())) {
      bhju.a("Grp_game", "Grp_AIO", "aio_exp", 0, 0, new String[] { this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.37
 * JD-Core Version:    0.7.0.1
 */