package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatManager.HotChatStateWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.hotchat.api.IHotChatApi;
import com.tencent.mobileqq.hotchat.api.IHotChatHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;

class ConversationHotChatCtrl$2
  implements DialogInterface.OnClickListener
{
  ConversationHotChatCtrl$2(ConversationHotChatCtrl paramConversationHotChatCtrl, HotChatInfo paramHotChatInfo, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isWifiHotChat) {
      paramInt = 1;
    } else {
      paramInt = 2;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004D2C", "0X8004D2C", paramInt, 0, "", "", "", "");
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext(), HardCodeUtil.a(2131702773), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.addObserver(ConversationHotChatCtrl.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl));
    ((IHotChatHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(((IHotChatApi)QRoute.api(IHotChatApi.class)).getHotChatHandlerClassName())).exitHotChat(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_LEFT_NORMAL_ACTION_DELETE_SHELL);
    paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl;
    BaseActivity localBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    paramDialogInterface.a = new QQProgressDialog(localBaseActivity, localBaseActivity.getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl.a.setContentView(2131562765);
    this.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl.a.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131692086));
    this.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl.a.setCancelable(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityConversationHotChatCtrl.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ConversationHotChatCtrl.2
 * JD-Core Version:    0.7.0.1
 */