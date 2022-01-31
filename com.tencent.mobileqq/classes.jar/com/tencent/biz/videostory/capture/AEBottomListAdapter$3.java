package com.tencent.biz.videostory.capture;

import bgxx;
import bgya;
import com.tencent.biz.videostory.capture.widgets.AEBottomListScrollView;
import com.tencent.qphone.base.util.QLog;
import wql;

public class AEBottomListAdapter$3
  implements Runnable
{
  public AEBottomListAdapter$3(wql paramwql, bgya parambgya) {}
  
  public void run()
  {
    if (wql.a(this.this$0).getVisibility() == 0)
    {
      wql.a(this.this$0).a(this.a, true);
      QLog.d(wql.a(), 4, "### [bottom list] select material " + this.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.capture.AEBottomListAdapter.3
 * JD-Core Version:    0.7.0.1
 */