package com.tencent.mobileqq.activity.contact.newfriend;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.widget.QQToast;

class SystemMsgListView$1
  extends Handler
{
  SystemMsgListView$1(SystemMsgListView paramSystemMsgListView) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 1012: 
      do
      {
        return;
      } while (SystemMsgListView.a(this.a) == null);
      this.a.i();
      SystemMsgListView.a(this.a).notifyDataSetChanged();
      return;
    }
    paramMessage = SystemMsgListView.a(this.a).getResources().getString(2131719688);
    QQToast.a(SystemMsgListView.a(this.a), 1, paramMessage, 0).b(this.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView.1
 * JD-Core Version:    0.7.0.1
 */