package com.tencent.mobileqq.activity.recent;

import android.app.Dialog;
import android.view.View;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.apollo.api.script.ISpriteCommFunc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.DeleteRecordDialog.OnDeleteRecordDialogClickListener;
import com.tencent.mobileqq.widget.QQToast;

class RecentAdapter$10$2
  implements DeleteRecordDialog.OnDeleteRecordDialogClickListener
{
  RecentAdapter$10$2(RecentAdapter.10 param10) {}
  
  public void a(Dialog paramDialog, View paramView, boolean paramBoolean)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.getRecentUserUin(), 3000);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().e(this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData.getRecentUserUin(), 3000);
    ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).stopAllTask(this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "chat_history_confirm_del_msg");
    QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.jdField_a_of_type_AndroidContentContext, 2, 2131691562, 0).a();
    RecentAdapter.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter, this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData, this.a.jdField_a_of_type_JavaLangString, this.a.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentAdapter.10.2
 * JD-Core Version:    0.7.0.1
 */