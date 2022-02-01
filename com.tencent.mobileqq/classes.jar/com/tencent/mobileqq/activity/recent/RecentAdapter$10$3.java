package com.tencent.mobileqq.activity.recent;

import android.app.Dialog;
import android.os.Message;
import android.view.View;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.apollo.api.script.ISpriteCommFunc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.widget.DeleteRecordDialog.OnDeleteRecordDialogClickListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

class RecentAdapter$10$3
  implements DeleteRecordDialog.OnDeleteRecordDialogClickListener
{
  RecentAdapter$10$3(RecentAdapter.10 param10) {}
  
  public void a(Dialog paramDialog, View paramView, boolean paramBoolean)
  {
    for (;;)
    {
      long l1;
      try
      {
        paramDialog = this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.getRecentUserUin();
        paramView = new StringBuilder();
        int i = ChatHistory.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDialog, 1, paramView);
        Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(paramDialog, 1);
        if ((localObject == null) || (((List)localObject).isEmpty())) {
          break label507;
        }
        l1 = ((MessageRecord)((List)localObject).get(((List)localObject).size() - 1)).shmsgseq;
        if (i <= 0) {
          break label490;
        }
        try
        {
          long l2 = Long.parseLong(paramView.toString());
          l1 = Math.max(l2, l1);
          if (l1 > 0L) {
            this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a(paramDialog, 1, l1);
          }
          if (((TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramDialog))
          {
            FriendsStatusUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDialog, 1);
            this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramDialog, 1, true, false);
            this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().e(paramDialog, 1);
            ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).stopAllTask(this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "chat_history_confirm_del_msg");
            paramView = this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
            localObject = paramView.obtainMessage(1017);
            ((Message)localObject).obj = paramDialog;
            ((Message)localObject).arg1 = 1;
            paramView.sendMessage((Message)localObject);
            QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.jdField_a_of_type_AndroidContentContext, 2, 2131691562, 0).a();
            RecentAdapter.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter, this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData, this.a.jdField_a_of_type_JavaLangString, this.a.b);
            return;
          }
        }
        catch (Exception paramDialog)
        {
          QLog.e("Q.recent", 1, "ClearChatRecordTask parse seq fail.", paramDialog);
          QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.jdField_a_of_type_AndroidContentContext, 2, 2131691562, 0).a();
          RecentAdapter.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter, this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData, this.a.jdField_a_of_type_JavaLangString, this.a.b);
          return;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramDialog, 1);
      }
      catch (IllegalStateException paramDialog)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.recent", 2, "msg history clear,  IllegalStateException" + paramDialog.toString());
        }
        QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.jdField_a_of_type_AndroidContentContext, 1, 2131691559, 0).a();
        return;
      }
      continue;
      label490:
      if (QLog.isColorLevel())
      {
        QLog.d("Q.recent", 2, "msg history already clear!");
        continue;
        label507:
        l1 = 0L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentAdapter.10.3
 * JD-Core Version:    0.7.0.1
 */