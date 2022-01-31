package com.tencent.biz.pubaccount.readinjoy.activity;

import com.tencent.qphone.base.util.QLog;
import osm;

class ReadinjoyJumpActivity$1
  implements Runnable
{
  ReadinjoyJumpActivity$1(ReadinjoyJumpActivity paramReadinjoyJumpActivity) {}
  
  public void run()
  {
    QLog.d("ReadinjoyJumpActivity", 1, "timeout ! show error page !");
    osm.a().b(ReadinjoyJumpActivity.a(this.this$0));
    ReadinjoyJumpActivity.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadinjoyJumpActivity.1
 * JD-Core Version:    0.7.0.1
 */