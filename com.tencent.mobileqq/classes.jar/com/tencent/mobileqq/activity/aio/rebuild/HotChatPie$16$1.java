package com.tencent.mobileqq.activity.aio.rebuild;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.hotchat.api.IHotChatApi;
import com.tencent.mobileqq.hotchat.api.IHotChatHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

class HotChatPie$16$1
  implements DialogInterface.OnClickListener
{
  HotChatPie$16$1(HotChatPie.16 param16) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.d.bX = new ReportDialog(this.a.d.aX(), 2131953338);
    this.a.d.bX.setContentView(2131623999);
    this.a.d.bX.setCancelable(true);
    ((TextView)this.a.d.bX.findViewById(2131431876)).setText(this.a.d.aX().getString(2131916272));
    this.a.d.bX.show();
    ((IHotChatHandler)this.a.d.d.getBusinessHandler(((IHotChatApi)QRoute.api(IHotChatApi.class)).getHotChatHandlerClassName())).kickHotChatMember(this.a.d.ah.b, this.a.d.ah.c, this.a.b.senderuin, this.a.c, 1);
    ReportController.b(this.a.d.d, "CliOper", "", "", "0X8005D55", "0X8005D55", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.16.1
 * JD-Core Version:    0.7.0.1
 */