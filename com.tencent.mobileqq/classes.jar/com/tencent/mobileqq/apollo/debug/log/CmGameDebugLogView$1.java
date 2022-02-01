package com.tencent.mobileqq.apollo.debug.log;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

class CmGameDebugLogView$1
  implements Runnable
{
  CmGameDebugLogView$1(CmGameDebugLogView paramCmGameDebugLogView) {}
  
  public void run()
  {
    Object localObject = CmGameDebugLogView.a(this.this$0).getLayoutManager();
    if ((localObject instanceof LinearLayoutManager)) {}
    for (localObject = (LinearLayoutManager)localObject;; localObject = null)
    {
      View localView = CmGameDebugLogView.a(this.this$0).getChildAt(CmGameDebugLogView.a(this.this$0).getChildCount() - 1);
      if ((localView != null) && (localView.getId() != 2131362803) && (localObject != null)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.debug.log.CmGameDebugLogView.1
 * JD-Core Version:    0.7.0.1
 */