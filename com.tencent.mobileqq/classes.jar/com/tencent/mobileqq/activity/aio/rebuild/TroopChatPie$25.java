package com.tencent.mobileqq.activity.aio.rebuild;

import ajvi;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;
import asff;
import baiz;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import java.util.Set;

class TroopChatPie$25
  implements Runnable
{
  TroopChatPie$25(TroopChatPie paramTroopChatPie) {}
  
  public void run()
  {
    if (asff.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      this.this$0.jdField_a_of_type_AndroidWidgetToast = ChatActivityUtils.a(this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131689923));
      this.this$0.jdField_a_of_type_AndroidWidgetToast.show();
      asff.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    Object localObject = (ajvi)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53);
    if ((localObject != null) && (((ajvi)localObject).a.contains(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)))
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      ((ajvi)localObject).a.remove(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    }
    localObject = (baiz)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(109);
    TroopManager localTroopManager = (TroopManager)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    if (localObject != null)
    {
      if (this.this$0.q != ((baiz)localObject).a(0))
      {
        this.this$0.q = ((baiz)localObject).a(0);
        this.this$0.b.sendEmptyMessage(4);
      }
      localTroopManager.c(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      ((baiz)localObject).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.25
 * JD-Core Version:    0.7.0.1
 */