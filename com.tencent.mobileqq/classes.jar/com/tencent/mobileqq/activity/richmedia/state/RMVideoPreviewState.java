package com.tencent.mobileqq.activity.richmedia.state;

public class RMVideoPreviewState
  extends RMVideoState
{
  public void a()
  {
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (localRMVideoStateMgr.v != null) {
      localRMVideoStateMgr.v.d();
    }
  }
  
  public void b()
  {
    RMVideoStateMgr.a().a(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.state.RMVideoPreviewState
 * JD-Core Version:    0.7.0.1
 */