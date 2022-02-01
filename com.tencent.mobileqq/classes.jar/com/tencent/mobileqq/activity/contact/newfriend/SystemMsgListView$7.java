package com.tencent.mobileqq.activity.contact.newfriend;

import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.widget.QQToast;

class SystemMsgListView$7
  extends CardObserver
{
  SystemMsgListView$7(SystemMsgListView paramSystemMsgListView) {}
  
  public void onSetConnectionsSwitch(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      if (SystemMsgListView.a(this.a) != null) {
        SystemMsgListView.a(this.a).c();
      }
      QQToast.a(this.a.getContext(), 2131698972, 3000).a();
      return;
    }
    QQToast.a(this.a.getContext(), 2131698971, 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView.7
 * JD-Core Version:    0.7.0.1
 */