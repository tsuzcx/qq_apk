package com.tencent.mobileqq.apollo.debug.log;

import amyb;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class CmGameDebugLogView$1
  implements Runnable
{
  public CmGameDebugLogView$1(amyb paramamyb) {}
  
  public void run()
  {
    Object localObject = amyb.a(this.this$0).getLayoutManager();
    if ((localObject instanceof LinearLayoutManager)) {}
    for (localObject = (LinearLayoutManager)localObject;; localObject = null)
    {
      View localView = amyb.a(this.this$0).getChildAt(amyb.a(this.this$0).getChildCount() - 1);
      if ((localView != null) && (localView.getId() != 2131362751) && (localObject != null)) {
        ((LinearLayoutManager)localObject).setStackFromEnd(true);
      }
      while (localObject == null) {
        return;
      }
      ((LinearLayoutManager)localObject).setStackFromEnd(false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.debug.log.CmGameDebugLogView.1
 * JD-Core Version:    0.7.0.1
 */