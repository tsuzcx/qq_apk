package com.tencent.mobileqq.activity.aio.core;

import android.os.Handler;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.utils.NetworkUtil;

class TroopChatPie$32
  implements Runnable
{
  TroopChatPie$32(TroopChatPie paramTroopChatPie) {}
  
  public void run()
  {
    this.this$0.br();
    Object localObject1 = ((TroopGagMgr)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, true);
    Object localObject2 = this.this$0.b.obtainMessage(2);
    ((Message)localObject2).obj = localObject1;
    this.this$0.b.sendMessage((Message)localObject2);
    localObject1 = ((TroopManager)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    int i = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopMask(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    localObject2 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a();
    int j = NetworkUtil.a(BaseApplicationImpl.getContext());
    if (((i == 1) || (i == 4) || ((i == -1) && (((TroopMessageManager)localObject2).d > 0))) && (((TroopMessageManager)localObject2).jdField_a_of_type_Boolean) && (localObject1 != null) && (((TroopInfo)localObject1).wMemberNum < ((TroopMessageManager)localObject2).c) && ((j == 4) || (j == 1))) {
      ((TroopMessageManager)localObject2).c(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, Math.min(this.this$0.o, ((TroopMessageManager)localObject2).jdField_a_of_type_Int));
    }
    if ((localObject1 != null) && (((TroopInfo)localObject1).isGameBind())) {
      TroopReportor.a("Grp_game", "Grp_AIO", "aio_exp", 0, 0, new String[] { this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.32
 * JD-Core Version:    0.7.0.1
 */