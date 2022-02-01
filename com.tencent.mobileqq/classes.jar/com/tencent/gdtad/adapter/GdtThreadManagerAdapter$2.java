package com.tencent.gdtad.adapter;

import com.tencent.mobileqq.app.ThreadManager;

class GdtThreadManagerAdapter$2
  implements Runnable
{
  GdtThreadManagerAdapter$2(GdtThreadManagerAdapter paramGdtThreadManagerAdapter, Runnable paramRunnable, int paramInt) {}
  
  public void run()
  {
    ThreadManager.excute(this.a, this.b, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.adapter.GdtThreadManagerAdapter.2
 * JD-Core Version:    0.7.0.1
 */