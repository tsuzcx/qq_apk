package com.tencent.mobileqq.adapter;

import aicw;
import ajnf;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class SystemMsgListAdapter$1
  implements Runnable
{
  public SystemMsgListAdapter$1(aicw paramaicw, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.e("SystemMsgListAdapter", 2, "MSG_FRESH_DATA refreshDataInner tabId = " + this.a);
    }
    aicw.a(this.this$0).a(true, this.a);
    ArrayList localArrayList = aicw.a(this.this$0).b();
    aicw.a(this.this$0).runOnUiThread(new SystemMsgListAdapter.1.1(this, localArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.SystemMsgListAdapter.1
 * JD-Core Version:    0.7.0.1
 */