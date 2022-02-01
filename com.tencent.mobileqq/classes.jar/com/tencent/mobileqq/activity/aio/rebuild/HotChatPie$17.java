package com.tencent.mobileqq.activity.aio.rebuild;

import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HotChatHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class HotChatPie$17
  implements ActionSheet.OnButtonClickListener
{
  HotChatPie$17(HotChatPie paramHotChatPie, ActionSheet paramActionSheet, ChatMessage paramChatMessage, String paramString) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    switch (paramInt)
    {
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin, this.jdField_a_of_type_JavaLangString, false, 1);
      return;
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.b, 2, "del hot chat member onClick, uin=" + this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin);
      }
      if (!NetworkUtil.d(BaseApplication.getContext()))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.a().getString(2131694459), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.a().getTitleBarHeight());
        return;
      }
    } while ((HotChatHandler)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.a.getBusinessHandler(BusinessHandlerFactory.HOT_CHAT_HANDLER) == null);
    paramView = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.a(), 230).setMessage(2131693224).setNegativeButton(2131690779, new HotChatPie.17.2(this)).setPositiveButton(2131690781, new HotChatPie.17.1(this));
    paramView.setTitle(2131693225);
    paramView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.17
 * JD-Core Version:    0.7.0.1
 */