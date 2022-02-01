package com.tencent.mobileqq.activity.richmedia.state;

class RMVideoInitState$3
  implements Runnable
{
  RMVideoInitState$3(RMVideoInitState paramRMVideoInitState) {}
  
  public void run()
  {
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (localRMVideoStateMgr.v != null) {
      localRMVideoStateMgr.v.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.state.RMVideoInitState.3
 * JD-Core Version:    0.7.0.1
 */