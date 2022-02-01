package com.tencent.mobileqq.activity.contact.newfriend;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class SystemMsgListAdapter$1
  implements Runnable
{
  SystemMsgListAdapter$1(SystemMsgListAdapter paramSystemMsgListAdapter, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.e("SystemMsgListAdapter", 2, "MSG_FRESH_DATA refreshDataInner tabId = " + this.a);
    }
    SystemMsgListAdapter.a(this.this$0).a(true, this.a);
    ArrayList localArrayList = SystemMsgListAdapter.a(this.this$0).b();
    SystemMsgListAdapter.a(this.this$0).runOnUiThread(new SystemMsgListAdapter.1.1(this, localArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListAdapter.1
 * JD-Core Version:    0.7.0.1
 */