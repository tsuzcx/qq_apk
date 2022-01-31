package com.tencent.mobileqq.activity.richmedia.state;

import ajpa;
import ajpj;
import wsv;

public class RMVideoRecordState$3
  implements Runnable
{
  public RMVideoRecordState$3(ajpa paramajpa) {}
  
  public void run()
  {
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (!localRMVideoStateMgr.b())
    {
      wsv.c("RMRecordState", "run record finish, but state is not right");
      return;
    }
    this.this$0.b();
    localRMVideoStateMgr.a.z();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.state.RMVideoRecordState.3
 * JD-Core Version:    0.7.0.1
 */