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
    if (this.a.isWifiHotChat) {
      paramInt = 1;
    } else {
      paramInt = 2;
    }
    ReportController.b(this.b, "CliOper", "", "", "0X8004D2C", "0X8004D2C", paramInt, 0, "", "", "", "");
    if (!NetworkUtil.isNetSupport(this.c))
    {
      QQToast.makeText(this.c.getApplicationContext(), HardCodeUtil.a(2131900764), 0).show(this.c.getTitleBarHeight());
      return;
    }
    this.c.addObserver(ConversationHotChatCtrl.a(this.d));
    ((IHotChatHandler)this.b.getBusinessHandler(((IHotChatApi)QRoute.api(IHotChatApi.class)).getHotChatHandlerClassName())).exitHotChat(this.a, HotChatManager.HotChatStateWrapper.STATE_LEFT_NORMAL_ACTION_DELETE_SHELL);
    paramDialogInterface = this.d;
    BaseActivity localBaseActivity = this.c;
    paramDialogInterface.b = new QQProgressDialog(localBaseActivity, localBaseActivity.getTitleBarHeight());
    this.d.b.setContentView(2131629210);
    this.d.b.a(this.c.getString(2131889064));
    this.d.b.setCancelable(true);
    this.d.b.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ConversationHotChatCtrl.2
 * JD-Core Version:    0.7.0.1
 */