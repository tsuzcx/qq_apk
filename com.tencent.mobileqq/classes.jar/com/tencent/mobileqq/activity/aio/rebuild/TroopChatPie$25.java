package com.tencent.mobileqq.activity.aio.rebuild;

import aejb;
import android.os.Handler;
import android.os.Message;
import ayqj;
import azjh;
import azot;
import azzx;
import badq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.TroopInfo;
import mqq.os.MqqHandler;

public class TroopChatPie$25
  implements Runnable
{
  public TroopChatPie$25(aejb paramaejb) {}
  
  public void run()
  {
    this.this$0.bv();
    Object localObject1 = ((azjh)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48)).a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, true);
    Object localObject2 = this.this$0.b.obtainMessage(2);
    ((Message)localObject2).obj = localObject1;
    this.this$0.b.sendMessage((Message)localObject2);
    localObject1 = ((TroopManager)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    int i = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    localObject2 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    int j = badq.a(BaseApplicationImpl.getContext());
    if (((i == 1) || (i == 4) || ((i == -1) && (((ayqj)localObject2).c > 0))) && (((ayqj)localObject2).jdField_a_of_type_Boolean) && (localObject1 != null) && (((TroopInfo)localObject1).wMemberNum < ((ayqj)localObject2).b) && ((j == 4) || (j == 1))) {
      ((ayqj)localObject2).b(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, Math.min(this.this$0.u, ((ayqj)localObject2).jdField_a_of_type_Int));
    }
    localObject2 = aejb.j(this.this$0).obtainMessage(85);
    if (azot.a(aejb.a(this.this$0)).a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {}
    for (i = 1;; i = 0)
    {
      ((Message)localObject2).arg1 = i;
      ((Message)localObject2).sendToTarget();
      if ((localObject1 != null) && (((TroopInfo)localObject1).isGameBind())) {
        azzx.a("Grp_game", "Grp_AIO", "aio_exp", 0, 0, new String[] { this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a });
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.25
 * JD-Core Version:    0.7.0.1
 */