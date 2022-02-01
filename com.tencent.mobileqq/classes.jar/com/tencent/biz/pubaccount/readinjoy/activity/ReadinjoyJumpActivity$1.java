package com.tencent.biz.pubaccount.readinjoy.activity;

import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.qphone.base.util.QLog;

class ReadinjoyJumpActivity$1
  implements Runnable
{
  ReadinjoyJumpActivity$1(ReadinjoyJumpActivity paramReadinjoyJumpActivity) {}
  
  public void run()
  {
    QLog.d("ReadinjoyJumpActivity", 1, "timeout ! show error page !");
    ReadInJoyLogicEngineEventDispatcher.a().b(ReadinjoyJumpActivity.a(this.this$0));
    ReadinjoyJumpActivity.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadinjoyJumpActivity.1
 * JD-Core Version:    0.7.0.1
 */