package com.tencent.mobileqq.adapter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class NewFriendMoreSysMsgAdapter$3
  implements DialogInterface.OnClickListener
{
  NewFriendMoreSysMsgAdapter$3(NewFriendMoreSysMsgAdapter paramNewFriendMoreSysMsgAdapter) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendMoreSysMsgAdapter", 2, "clear click");
    }
    if (NetworkUtil.d(NewFriendMoreSysMsgAdapter.a(this.a)))
    {
      ReportController.b(this.a.a, "dc00898", "", "", "0X800A328", "0X800A328", 2, 0, "", "", "", "");
      NewFriendMoreSysMsgAdapter.b(this.a);
      this.a.a.getMsgHandler().a().f();
      ((FriendListHandler)this.a.a.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).deleteAllSuspiciousMsg();
      return;
    }
    QQToast.a(NewFriendMoreSysMsgAdapter.a(this.a), 2131694468, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.NewFriendMoreSysMsgAdapter.3
 * JD-Core Version:    0.7.0.1
 */