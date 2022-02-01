package com.tencent.mobileqq.activity.aio.rebuild;

import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.hotchat.api.IHotChatApi;
import com.tencent.mobileqq.hotchat.api.IHotChatHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class HotChatPie$16
  implements ActionSheet.OnButtonClickListener
{
  HotChatPie$16(HotChatPie paramHotChatPie, ActionSheet paramActionSheet, ChatMessage paramChatMessage, String paramString) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      if (QLog.isColorLevel())
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("del hot chat member onClick, uin=");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin);
        QLog.i(paramView, 2, localStringBuilder.toString());
      }
      if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.a().getString(2131694424), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.a().getTitleBarHeight());
        return;
      }
      if ((IHotChatHandler)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.a.getBusinessHandler(((IHotChatApi)QRoute.api(IHotChatApi.class)).getHotChatHandlerClassName()) != null)
      {
        paramView = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.a(), 230).setMessage(2131693178).setNegativeButton(2131690707, new HotChatPie.16.2(this)).setPositiveButton(2131690709, new HotChatPie.16.1(this));
        paramView.setTitle(2131693179);
        paramView.show();
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin, this.jdField_a_of_type_JavaLangString, false, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.16
 * JD-Core Version:    0.7.0.1
 */