package com.tencent.mobileqq.activity;

import ajvi;
import anov;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

class LebaListMgrActivity$1
  implements Runnable
{
  LebaListMgrActivity$1(LebaListMgrActivity paramLebaListMgrActivity) {}
  
  public void run()
  {
    ajvi.a().a(this.this$0, this.this$0.app);
    boolean bool = this.this$0.app.a().a();
    List localList = ajvi.a().a();
    this.this$0.runOnUiThread(new LebaListMgrActivity.1.1(this, bool, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LebaListMgrActivity.1
 * JD-Core Version:    0.7.0.1
 */