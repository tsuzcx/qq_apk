package com.tencent.mobileqq.activity.richmedia.state;

class RMVideoInitState$4
  implements Runnable
{
  RMVideoInitState$4(RMVideoInitState paramRMVideoInitState) {}
  
  public void run()
  {
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (localRMVideoStateMgr.v != null) {
      localRMVideoStateMgr.v.k();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.state.RMVideoInitState.4
 * JD-Core Version:    0.7.0.1
 */