package com.tencent.mobileqq.activity.aio.rebuild;

import aejb;
import ajhh;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;
import arjb;
import azhi;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import java.util.Set;

public class TroopChatPie$26
  implements Runnable
{
  public TroopChatPie$26(aejb paramaejb) {}
  
  public void run()
  {
    if (arjb.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      this.this$0.jdField_a_of_type_AndroidWidgetToast = ChatActivityUtils.a(this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131624376));
      this.this$0.jdField_a_of_type_AndroidWidgetToast.show();
      arjb.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    Object localObject = (ajhh)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53);
    if ((localObject != null) && (((ajhh)localObject).a.contains(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)))
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      ((ajhh)localObject).a.remove(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    }
    localObject = (azhi)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(109);
    TroopManager localTroopManager = (TroopManager)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    if (localObject != null)
    {
      if (this.this$0.q != ((azhi)localObject).a(0))
      {
        this.this$0.q = ((azhi)localObject).a(0);
        this.this$0.b.sendEmptyMessage(4);
      }
      localTroopManager.c(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      ((azhi)localObject).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.26
 * JD-Core Version:    0.7.0.1
 */