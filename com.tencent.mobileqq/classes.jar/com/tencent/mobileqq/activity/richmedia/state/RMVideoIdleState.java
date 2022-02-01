package com.tencent.mobileqq.activity.richmedia.state;

import com.tencent.qphone.base.util.QLog;

class RMVideoIdleState
  extends RMVideoState
{
  public void a()
  {
    RMVideoStateMgr.a().a.c();
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoIdleState", 2, "[@] initState end");
    }
  }
  
  public void b()
  {
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (QLog.isColorLevel()) {
      QLog.d("RMVideoIdleState", 2, "[@] realDeleteVideoSegment ...");
    }
    localRMVideoStateMgr.a.a(100);
    localRMVideoStateMgr.a(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.state.RMVideoIdleState
 * JD-Core Version:    0.7.0.1
 */