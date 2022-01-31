package com.tencent.mobileqq.adapter;

import akgy;
import altc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class SystemMsgListAdapter$1
  implements Runnable
{
  public SystemMsgListAdapter$1(akgy paramakgy, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.e("SystemMsgListAdapter", 2, "MSG_FRESH_DATA refreshDataInner tabId = " + this.a);
    }
    akgy.a(this.this$0).a(true, this.a);
    ArrayList localArrayList = akgy.a(this.this$0).b();
    akgy.a(this.this$0).runOnUiThread(new SystemMsgListAdapter.1.1(this, localArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.SystemMsgListAdapter.1
 * JD-Core Version:    0.7.0.1
 */