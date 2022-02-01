package com.tencent.mobileqq.adapter;

import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class RobotAdapter$3
  implements AbsListView.OnScrollListener
{
  RobotAdapter$3(RobotAdapter paramRobotAdapter) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    RobotAdapter.a(this.a, paramInt);
    if (paramInt == 0)
    {
      RobotAdapter.a(this.a, null, null);
      RobotAdapter.a(this.a).resume();
      return;
    }
    RobotAdapter.a(this.a).pause();
    RobotAdapter.a(this.a).cancelPendingRequests();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.RobotAdapter.3
 * JD-Core Version:    0.7.0.1
 */