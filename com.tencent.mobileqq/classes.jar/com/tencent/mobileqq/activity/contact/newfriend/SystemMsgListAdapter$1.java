package com.tencent.mobileqq.activity.contact.newfriend;

import aiej;
import aifw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class SystemMsgListAdapter$1
  implements Runnable
{
  public SystemMsgListAdapter$1(aifw paramaifw, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.e("SystemMsgListAdapter", 2, "MSG_FRESH_DATA refreshDataInner tabId = " + this.a);
    }
    aifw.a(this.this$0).a(true, this.a);
    ArrayList localArrayList = aifw.a(this.this$0).b();
    aifw.a(this.this$0).runOnUiThread(new SystemMsgListAdapter.1.1(this, localArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListAdapter.1
 * JD-Core Version:    0.7.0.1
 */