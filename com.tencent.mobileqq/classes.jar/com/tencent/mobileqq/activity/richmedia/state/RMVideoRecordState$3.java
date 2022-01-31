package com.tencent.mobileqq.activity.richmedia.state;

import ahxq;
import ahxz;
import ved;

public class RMVideoRecordState$3
  implements Runnable
{
  public RMVideoRecordState$3(ahxq paramahxq) {}
  
  public void run()
  {
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (!localRMVideoStateMgr.b())
    {
      ved.c("RMRecordState", "run record finish, but state is not right");
      return;
    }
    this.this$0.b();
    localRMVideoStateMgr.a.A();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.state.RMVideoRecordState.3
 * JD-Core Version:    0.7.0.1
 */