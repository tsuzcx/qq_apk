package com.tencent.mobileqq.adapter;

import ainv;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

public class MayKnowAdapter$5
  implements Runnable
{
  public MayKnowAdapter$5(ainv paramainv) {}
  
  public void run()
  {
    View localView = ainv.a(this.this$0);
    if (QLog.isColorLevel()) {
      QLog.d("MayKnowAdapter", 2, "delayUpdateRunnable target：" + localView);
    }
    if (localView != null)
    {
      ainv.a(this.this$0, localView);
      return;
    }
    ainv.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.MayKnowAdapter.5
 * JD-Core Version:    0.7.0.1
 */