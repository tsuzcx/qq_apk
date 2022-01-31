package com.tencent.biz.videostory.capture;

import java.util.List;
import mpl;
import wql;
import wqm;

public class AEBottomListAdapter$1$1
  implements Runnable
{
  public AEBottomListAdapter$1$1(wqm paramwqm) {}
  
  public void run()
  {
    int i = mpl.a();
    if (i != 0) {
      this.a.a.notifyDataSetChanged();
    }
    if ((i == 1) && (wql.a(this.a.a).size() > 1)) {
      wql.a(this.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.capture.AEBottomListAdapter.1.1
 * JD-Core Version:    0.7.0.1
 */