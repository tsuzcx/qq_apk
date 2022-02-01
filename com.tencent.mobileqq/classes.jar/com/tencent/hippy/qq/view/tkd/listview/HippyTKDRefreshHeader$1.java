package com.tencent.hippy.qq.view.tkd.listview;

import android.util.Log;

class HippyTKDRefreshHeader$1
  implements Runnable
{
  HippyTKDRefreshHeader$1(HippyTKDRefreshHeader paramHippyTKDRefreshHeader) {}
  
  public void run()
  {
    Log.d("QBRefreshHeader", "mStayRunnable run");
    HippyTKDRefreshHeader localHippyTKDRefreshHeader = this.this$0;
    HippyTKDRefreshHeader.1.1 local1 = new HippyTKDRefreshHeader.1.1(this);
    if (this.this$0.mRefreshState == 6) {}
    for (boolean bool = true;; bool = false)
    {
      localHippyTKDRefreshHeader.hideToast(local1, bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshHeader.1
 * JD-Core Version:    0.7.0.1
 */